package com.abhijeet.springbootrest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhijeet.springbootrest.model.UserDetailsDto;
import com.abhijeet.springbootrest.service.UserService;

@RestController
@RequestMapping(value = "/rest/api")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_HTML_VALUE, MediaType.TEXT_PLAIN_VALUE,
					"application/csv" })
	public String addUser(@RequestBody Map<String, Object> requestBody) {
		UserDetailsDto userDetailsDto = new UserDetailsDto();
		return userService.addUser(userDetailsDto);
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserDetailsDto getUser(@RequestParam String userID) {
		return userService.getUser(userID);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public String updateUser(@RequestBody Map<String, Object> requestBody) {
		System.out.println("requestBody:: " + requestBody);
		UserDetailsDto userDetailsDto = new UserDetailsDto();
		return userService.updateUser(userDetailsDto);
	}

	@RequestMapping(value = "/deleteUser/{userID}", method = RequestMethod.DELETE, consumes = {
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE })
	public String deleteUser(@PathVariable("userID") String userID) {
		return userService.deleteUser(userID);
	}
}