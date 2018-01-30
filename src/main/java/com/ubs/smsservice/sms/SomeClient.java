package com.ubs.smsservice.sms;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * I don't know what the name of the client is
 *
 * @author Marcin Grzejszczak
 */
class SomeClient {

	private final RestTemplate restTemplate;

	SomeClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	ResponseEntity<String> postToCallbackUrl (final String url, Object obj) {
		//set your headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//set your entity to send
		HttpEntity entity = new HttpEntity(obj,headers);
		//send it!
		return restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	}
}
