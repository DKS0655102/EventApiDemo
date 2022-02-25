package com.event.api.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController

public class EventapiController {
	@Autowired
	RestTemplate restTemplate;

	@Value("${endpoint_event_url}")
	private String endpointeventurl;

	@Value("${client_id}")
	private String clientid;

	@Value("${client_secret_code}")
	private String clientseccode;

	@RequestMapping(value = "/template/events")
	public String getEventsList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(endpointeventurl)
				// Add query parameter
				.queryParam("client_id", clientid).queryParam("client_secret", clientseccode);
		System.out.println(builder.toUriString());

		return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/template/events/{id}")
	public String getEventsByID(@PathVariable("id") String eventID) {
		String concatID = "/"+eventID;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(endpointeventurl+concatID)
				// Add query parameter
				.queryParam("client_id", clientid).queryParam("client_secret", clientseccode);
		System.out.println(builder.toUriString());

		return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class).getBody();
	}

	
	

}
