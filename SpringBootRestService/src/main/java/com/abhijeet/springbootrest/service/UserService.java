package com.abhijeet.springbootrest.service;

import com.abhijeet.springbootrest.model.UserDetailsDto;

public interface UserService {
	public String addUser(UserDetailsDto userDetailsDto);

	public UserDetailsDto getUser(String userID);

	public String deleteUser(String userID);

	public String updateUser(UserDetailsDto userDetailsDto);
}