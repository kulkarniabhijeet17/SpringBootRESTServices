package com.abhijeet.springbootrest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

public class JavaClient {
	public static String addUserUrl = "http://localhost:8085/SpringBootRestService-1.0/rest/api/addUser";
	public static String getUserUrl = "http://localhost:8085/SpringBootRestService-1.0/rest/api/getUser?userID=anvi12";
	public static String updateUserUrl = "http://localhost:8085/SpringBootRestService-1.0/rest/api/updateUser";
	public static String deleteUserUrl = "http://localhost:8085/SpringBootRestService-1.0/rest/api/deleteUser/abhijeet";

	public static void main(String[] args) {
		// addUser();
		getUser();
		// updateUser();
		// deleteUser();
	}

	private static void addUser() {
		try {
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

			URL url = new URL(addUserUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			// conn.setRequestProperty("Accept", "application/json");
			// conn.setRequestProperty("Accept", "application/xml");
			// conn.setRequestProperty("Accept", "text/html");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			OutputStream os = conn.getOutputStream();
			os.write(jasonRequest.toString().getBytes("UTF-8"));
			os.close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void getUser() {
		try {
			URL url = new URL(getUserUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void updateUser() {
		try {
			String xmlRequest = "<UserDetailsDto>" + "<userID>" + "anvi12" + "</userID>" + "<firstName>" + "Anvi"
					+ "</firstName>" + "<lastName>" + "Kulkarni" + "</lastName>" + "</UserDetailsDto>";

			URL url = new URL(updateUserUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			OutputStream os = conn.getOutputStream();
			os.write(xmlRequest.getBytes("UTF-8"));
			os.close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void deleteUser() {
		try {
			URL url = new URL(deleteUserUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setRequestProperty("Accept", "application/xml");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}