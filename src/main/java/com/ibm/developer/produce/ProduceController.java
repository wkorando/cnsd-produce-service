package com.ibm.developer.produce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/produce")
public class ProduceController {

	private ProduceRepo repo;
	private ProduceService service;
	private RestTemplate restTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProduceController.class);

	public ProduceController(ProduceRepo repo, ProduceService service) {
		super();
		this.repo = repo;
		this.service = service;
		this.restTemplate = restTemplate;
	}

	@GetMapping
	public ResponseEntity<Iterable<Produce>> findAllProduce() {
		LOGGER.info("Getting all produce");
		return ResponseEntity.ok(repo.findAll());
	}

	@GetMapping("/{name}")
	public ResponseEntity<Iterable<Produce>> findProduceByName(@PathVariable String name) {
		LOGGER.info("Getting all produce that matches: " + name);
		try {
			String message = restTemplate.getForObject("/api/v1/downstream", String.class);
			LOGGER.info("Message from downstream service: " + message);
		} catch (Exception e) {
			//EATING exception for now, fix later
		}

		return ResponseEntity.ok(service.findProduceByName(name));
	}

	@PostMapping
	public ResponseEntity<Produce> addNewProduce(@RequestBody Produce produce) {
		LOGGER.info("Adding new produce: " + produce.toString());
		return ResponseEntity.ok(service.addNewProduce(produce));
	}

	@ExceptionHandler(ClientException.class)
	public ResponseEntity<Object> returnClientErrorMessage(ClientException e) {
		return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
	}

	class ErrorMessage {
		private String errorMessage;

		public ErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

	}
}
