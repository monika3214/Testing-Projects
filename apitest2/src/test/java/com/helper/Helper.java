package com.helper;

import java.io.IOException;
import java.lang.reflect.Method;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;

import com.utilities.Endpoints;
//import com.pojo.LoginResponsePOJO;
import com.utilities.ReadPropertyFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.pojo.*;
import com.pojo.CreateUserPojo;

public class Helper {
	 @BeforeMethod
		public static void SetUp(Method m) throws IOException {
			
			RestAssured.baseURI =getBaseUri();
			
		}
	public static Response createUser() {
		
		CreatePOJO createuser = new CreatePOJO();
		createuser.setEmployee_name("test");
		createuser.setEmployee_salary(123);
		createuser.setAge(23);
		createuser.setId(25);

		
		Response res = RestAssured
		.given()
		.contentType(ContentType.JSON)
	.body(createuser)
	.when()
	//.post("addData");
	.post(Endpoints.CREATE);
		return res;
	}
	 
	/* public static Response CreateUser1() {
		 CreateUserPojo createuser1 = new CreateUserPojo();
		 createuser1.
		 
	 }*/
	
	public static String getBaseUri() throws IOException {
		String baseURI = ReadPropertyFile.readPropertyData("baseURI");
		return baseURI;

	}
	
	public int getStatusCode(Response response) {
		return response.getStatusCode();
	}
	
	public static void verifyStatusCodeis(Response response, int statuscode) {
		response.then().statusCode(statuscode);
	}
	
public static void verifyStatusisSuccess(Response response) {
		
		response.then().body("status",Matchers.equalTo("success"));
	}

public static void verifyStatusisError(Response response) {
	
	response.then().body("status",Matchers.equalTo("error"));
}

public static void responseSize(Response response) {
	System.out.println("size of response is "+ response.jsonPath().get("data.size()"));
	
	
}
public String getContentType(Response response) {
	return response.getContentType();
}
//	public static Response ResponsePOJO(Response response) {
		
	//	ResponsePOJO[]	list = response.as(ResponsePOJO[].class);
		
	//}
	
	

}
