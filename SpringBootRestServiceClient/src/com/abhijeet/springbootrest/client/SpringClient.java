package com.abhijeet.springbootrest.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class SpringClient {
	public static String addUserUrl = "http://localhost:8085/SpringBootRestService-1.0/rest/api/addUser";
	public static String getUserUrl = "http://localhost:8085/SpringBootRestService-1.0/rest/api/getUser?userID=anvi12";
	public static String updateUserUrl = "http://localhost:8085/SpringBootRestService-1.0/rest/api/updateUser";
	public static String deleteUserUrl = "http://localhost:8085/SpringBootRestService-1.0/rest/api/deleteUser/abhijeet";

	public static void main(String[] args) {
		// addUser();
		// getUser();
		updateUser();
		// deleteUser();
	}

	private static void addUser() {
		JSONObject jasonRequest = new JSONObject();
		jasonRequest.put("userID", "anvi12");
		jasonRequest.put("firstName", "Anvi");
		jasonRequest.put("lastName", "Kulkarni");
		jasonRequest.put("middleInitial", "A");
		jasonRequest.put("emailID", "anvi12@gmail.com");
		jasonRequest.put("lastSuccessfulLogonDate", "14/04/2019");
		jasonRequest.put("passwordChangeDate", "23/04/2019");
		jasonRequest.put("numberOfAttempts", "0");
		jasonRequest.put("failedLogonCount", "0");

		RestTemplate restTemplate = new RestTemplate();

		// Approach 1: Using exchange method
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		// headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<String>(jasonRequest.toString(), headers);

		ResponseEntity<String> exchangeResponse = (ResponseEntity) restTemplate.exchange(addUserUrl, HttpMethod.POST,
				entity, String.class);

		System.out.println("Approach 1 Response is:: " + exchangeResponse);
		System.out.println("Approach 1 Status code is:: " + exchangeResponse.getStatusCode());
		System.out.println("Approach 1 Body is:: " + exchangeResponse.getBody());

		// Approach 2: Using postForObject method
		String postForObjectResponse = restTemplate.postForObject(addUserUrl, entity, String.class);

		System.out.println("Approach 2 Response is:: " + postForObjectResponse);
	}

	private static void getUser() {
		RestTemplate restTemplate = new RestTemplate();

		// Approach 1: Using exchange method
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> exchangeResponse = (ResponseEntity) restTemplate.exchange(getUserUrl, HttpMethod.GET,
				entity, String.class);

		System.out.println("Approach 1 Response is:: " + exchangeResponse);
		System.out.println("Approach 1 Status code is:: " + exchangeResponse.getStatusCode());
		System.out.println("Approach 1 Body is:: " + exchangeResponse.getBody());

		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		try {
			user = mapper.readValue(exchangeResponse.getBody(), User.class);
			System.out.println("User ID:: " + user.getUserID());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Approach 2: Using UriComponentsBuilder and exchange method
		String url = "http://localhost:8085/SpringBootRestService-1.0/rest/api/getUser";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("userID", "anvi12");

		HttpEntity<?> request = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, request,
				String.class);

		System.out.println("Approach 2 Response is:: " + response);
		System.out.println("Approach 2 Status code is:: " + response.getStatusCode());
		System.out.println("Approach 2 Body is:: " + response.getBody());

		// Approach 3: Using getForObject method
		ClientHttpRequestInterceptor acceptHeaderJson = (ClientHttpRequestInterceptor) new HttpHeaderRequestInterceptor(
				MediaType.APPLICATION_JSON_VALUE);
		List<ClientHttpRequestInterceptor> list = new ArrayList<ClientHttpRequestInterceptor>();
		list.add(acceptHeaderJson);
		restTemplate.setInterceptors(list);

		String getForObjectResponse = restTemplate.getForObject(getUserUrl, String.class);

		System.out.println("Approach 3 Response is:: " + getForObjectResponse);
	}

	private static void updateUser() {
		String xmlRequest = "<UserDetailsDto>" + "<userID>" + "anvi12" + "</userID>" + "<firstName>" + "Anvi"
				+ "</firstName>" + "<lastName>" + "Kulkarni" + "</lastName>" + "</UserDetailsDto>";

		RestTemplate restTemplate = new RestTemplate();

		// Approach 1: Using exchange method
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> entity = new HttpEntity<String>(xmlRequest, headers);

		ResponseEntity<String> exchangeResponse = (ResponseEntity) restTemplate.exchange(updateUserUrl, HttpMethod.PUT,
				entity, String.class);

		System.out.println("Approach 1 Response is:: " + exchangeResponse);
		System.out.println("Approach 1 Status code is:: " + exchangeResponse.getStatusCode());
		System.out.println("Approach 1 Body is:: " + exchangeResponse.getBody());

		// Approach 2: Using put method
		restTemplate.put(updateUserUrl, entity, String.class);
	}

	private static void deleteUser() {
		RestTemplate restTemplate = new RestTemplate();

		// Approach 1: Using exchange method
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> exchangeResponse = (ResponseEntity) restTemplate.exchange(deleteUserUrl,
				HttpMethod.DELETE, entity, String.class);

		System.out.println("Approach 1 Response is:: " + exchangeResponse);
		System.out.println("Approach 1 Status code is:: " + exchangeResponse.getStatusCode());
		System.out.println("Approach 1 Body is:: " + exchangeResponse.getBody());

		// Approach 2: Using delete method
		ClientHttpRequestInterceptor acceptHeaderJson = (ClientHttpRequestInterceptor) new HttpHeaderRequestInterceptor(
				MediaType.APPLICATION_XML_VALUE);
		List<ClientHttpRequestInterceptor> list = new ArrayList<ClientHttpRequestInterceptor>();
		list.add(acceptHeaderJson);
		restTemplate.setInterceptors(list);

		restTemplate.delete(deleteUserUrl, String.class);
	}
}