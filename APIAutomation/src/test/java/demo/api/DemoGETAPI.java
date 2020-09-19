package demo.api;

import java.awt.List;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.groovy.json.internal.Dates;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DemoGETAPI {
	
	
	@Test
	void GetDemoapi_Status_code_check() throws UnsupportedEncodingException, ParseException, java.text.ParseException {
		// Specify BaseURI
		RestAssured.baseURI = "http://demo4032024.mockable.io/apitest";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response response = httpRequest.request(Method.GET, "");

		// Print response in console window
		int statuscode = response.getStatusCode();

		System.out.println("Status code is :" + statuscode);
		Assert.assertEquals(statuscode, 200);

		// status line
		
	}
	
	@Test
	void GetDemoapi_Status_line_check() {
		RestAssured.baseURI = "http://demo4032024.mockable.io/apitest";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "");
		//String ResponseBody=response.getBody().asString();
		System.out.println(response.body().asString());
		String statusline = response.getStatusLine();
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		System.out.println("Status line: " +statusline);

		
	}
	
	@Test
	void GetDemoapi_header_check() {
		RestAssured.baseURI = "http://demo4032024.mockable.io/apitest";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "");
		String contentType = response.header("Content-Type"); //validate respose header json
		System.out.println("Content-Type value: " + contentType);
		String serverType =  response.header("Server");
		System.out.println("Server value: " + serverType);
		String acceptLanguage = response.header("Content-Encoding");
		System.out.println("Content-Encoding: " + acceptLanguage);
		String Company_name = response.jsonPath().getString("employeeData.company");
		String DOB = response.jsonPath().getString("employeeData.dob");
		String DOB = response.jsonPath().getString("employeeData.role");
		String success_msg=response.jsonPath().getString("message");
		System.out.println("Success message "+success_msg);
		System.out.println("This is company name "+Company_name);
		//String ResponseBody=response.getBody().asString();
		System.out.println(response.body().asString());
		String statusline = response.getStatusLine();
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		System.out.println("Status line: " +statusline);

		
	}
}

