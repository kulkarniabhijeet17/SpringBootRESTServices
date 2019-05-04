package com.abhijeet.springbootrest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.abhijeet.springbootrest.model.UserDetailsDto;

public class UserDetailsRowMapper implements RowMapper<UserDetailsDto> {
	public UserDetailsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetailsDto userDetailsDto = new UserDetailsDto();
		userDetailsDto.setFirstName("Abhijeet");
		userDetailsDto.setLastName("Kulkarni");
		userDetailsDto.setLastSuccessfulLogonDate("04/18/2019");
		userDetailsDto.setNumberOfAttempts(0);
		userDetailsDto.setPasswordChangeDate("03/18/2019");
		userDetailsDto.setUserID("kulkarniabhijeet17");
		userDetailsDto.setReturnCode(0);
		userDetailsDto.setReturnMsg("Success");
		
		/*userDetailsDto.setFirstName(rs.getString("first_name"));
		userDetailsDto.setLastName(rs.getString("last_name"));
		userDetailsDto.setMiddleInitial(rs.getString("middle_initial").charAt(0));
		userDetailsDto.setEmailID(rs.getString("emailid"));
		String lastSuccessfulLogonDate = new SimpleDateFormat("yyyyMMdd")
				.format(rs.getTimestamp("last_successful_logon_date"));
		// Timestamp timestamp = new Timestamp(new SimpleDateFormat("yyyyMMdd").parse(lastSuccessfulLogonDate).getTime());
		userDetailsDto.setLastSuccessfulLogonDate(lastSuccessfulLogonDate);
		userDetailsDto.setNumberOfAttempts(rs.getInt("number_of_attempts"));
		userDetailsDto.setFailedLogonCount(rs.getInt("failed_logon_count"));
		userDetailsDto.setPasswordChangeDate(
				new SimpleDateFormat("yyyyMMdd").format(rs.getTimestamp("password_change_date")));
		userDetailsDto.setUserID(rs.getString("userid"));
		userDetailsDto.setReturnCode(0);
		userDetailsDto.setReturnMsg("Success");*/

		return userDetailsDto;
	}
}