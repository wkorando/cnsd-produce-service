package com.ibm.developer.produce;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("!test")
public class DownstreamHealth implements HealthIndicator {

	private RestTemplate restTemplate;

	public DownstreamHealth(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Health health() {
		return restTemplate.getForObject("/actuator/health", Health.class);
	}
}