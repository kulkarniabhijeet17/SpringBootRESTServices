package com.abhijeet.springbootrest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abhijeet.springbootrest.model.UserDetailsDto;

@Repository
public class UserServiceDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String addUser(UserDetailsDto userDetailsDto) {
		String sql = "insert into user_details values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return "User added successfully";
	}

	public UserDetailsDto getUser(String userID) {
		String sql = "select user_seq, userid, first_name, last_name, middle_initial, emailid, last_successful_logon_date, password_change_date, number_of_attempts, failed_logon_count from user_details where userid = ?";
		UserDetailsDto userDetailsDto = jdbcTemplate.queryForObject(sql, new Object[] { userID },
				new UserDetailsRowMapper());

		return userDetailsDto;
	}

	public String deleteUser(String userID) {
		return "User deleted successfully";
	}

	public String updateUser(UserDetailsDto userDetailsDto) {
		return "User updated successfully";
	}
}