package com.abhijeet.springbootrest.client;
import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userID;
	private String firstName;
	private String lastName;
	private char middleInitial;
	private String emailID;
	private String lastSuccessfulLogonDate;
	private String passwordChangeDate;
	private int numberOfAttempts;
	private int failedLogonCount;
	private int returnCode;
	private String returnMsg;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getLastSuccessfulLogonDate() {
		return lastSuccessfulLogonDate;
	}

	public void setLastSuccessfulLogonDate(String lastSuccessfulLogonDate) {
		this.lastSuccessfulLogonDate = lastSuccessfulLogonDate;
	}

	public String getPasswordChangeDate() {
		return passwordChangeDate;
	}

	public void setPasswordChangeDate(String passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public void setNumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}

	public int getFailedLogonCount() {
		return failedLogonCount;
	}

	public void setFailedLogonCount(int failedLogonCount) {
		this.failedLogonCount = failedLogonCount;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
}