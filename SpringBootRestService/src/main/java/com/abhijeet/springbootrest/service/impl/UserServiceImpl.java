package com.abhijeet.springbootrest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhijeet.springbootrest.dao.UserServiceDao;
import com.abhijeet.springbootrest.model.UserDetailsDto;
import com.abhijeet.springbootrest.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserServiceDao userServiceDao;

	public String addUser(UserDetailsDto userDetailsDto) {
		return userServiceDao.addUser(userDetailsDto);
	}

	public UserDetailsDto getUser(String userID) {
		return userServiceDao.getUser(userID);
	}

	public String deleteUser(String userID) {
		return userServiceDao.deleteUser(userID);
	}

	public String updateUser(UserDetailsDto userDetailsDto) {
		return userServiceDao.updateUser(userDetailsDto);
	}
}