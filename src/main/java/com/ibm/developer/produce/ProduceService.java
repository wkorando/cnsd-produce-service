package com.ibm.developer.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduceService {

	private ProduceRepo repo;
//	private KafkaTemplate<String, Produce> template;
	
//	@Autowired(required = false)
	public ProduceService(ProduceRepo repo) {
		this.repo = repo;
	}
	
//	@Autowired(required = false)
//	public ProduceService(ProduceRepo repo, KafkaTemplate<String, String> template) {
//		this.repo = repo;
//	}

	public Produce addNewProduce(Produce produce) {
		if (produce.getName().isEmpty() || !(produce.getQuantity() > 0)) {
			throw new ClientException("Missing required value!");
		}
		
//		template.sendDefault(produce);
		
		return produce;
	}

	public Iterable<Produce> findProduceByName(String name) {
		if (name.matches("[\\W]+")) {
			throw new ClientException("Produce name must be alpha numeric!");
		}
		return repo.findByName(name);
	}
}
