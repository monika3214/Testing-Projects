package com.APItests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.utilities.CommonUtilities;
import com.utilities.Constants;
import com.utilities.Endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import com.pojo.*;
import com.utilities.GenerateReports;

public class UserServiceHelper {
	
	 public static GenerateReports report= null;
	 @BeforeTest
	 public static void setUpBeforeTest() {
		 report= report.getInstance();
		// report.startExtentReport();
		 report.startExtentReport();
	 }
	 @BeforeMethod
		public static void SetUp(Method m) throws IOException {
			
			RestAssured.baseURI =getBaseUri();
			report.startSigleTestReport(m.getName());
			report.logTestInfo("before method start execution");
			
		}
	
	
	public static String getBaseUri() throws IOException {
		String baseURI = CommonUtilities.readPropertyData("baseURI");
		return baseURI;

	}
	
	
	
	public static String logintoken(){
		Response res = RestAssured
				.given()
				.body("{\"username\":\"monika.kumari_21@yahoo.com\",\"password\":\"monika123\"}")
				.contentType(ContentType.JSON)
				.when()
				.post(Endpoints.LOGIN);
		String token =res.jsonPath().get("[0].token");
		return token;}
	

	public static String logintokenpojo() throws IOException{
		String username=CommonUtilities.readPropertyData("username");
		
		String password=CommonUtilities.readPropertyData("password");
		
		LoginPOJO loginData = new LoginPOJO();
		loginData.setUsername(username);
		
		loginData.setPassword(password);
		
		Response res = RestAssured
				.given()
				.body(loginData)
				.contentType(ContentType.JSON)
				.when()
				//.post("login");
				.post(Endpoints.LOGIN);
	LoginResponsePOJO[]	list = res.as(LoginResponsePOJO[].class);
	String token1 = list[0].getToken();
	System.out.println("token1 is " + token1);
		//String token =res.jsonPath().get("[0].token");
	//res.prettyPrint();
	res.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("LoginSchema.json"));
	System.out.println("JasonSchemaValidation done");
	
		return token1;}
	

	public static void getMethod() throws IOException {
		Header header = new Header("token",logintokenpojo());
		Response res =RestAssured
		.given()
		.header(header)
		.when()
		//.get("getdata");
		.get(Endpoints.GET_DATA);
		res.then().statusCode(200);
		System.out.println("size of response is "+ res.jsonPath().get("size()"));
		String userid =res.jsonPath().get("[0].userid");
		String id =res.jsonPath().get("[0].id");
		String accountnum =res.jsonPath().get("[0].accountno");
		System.out.println("account num is  " + accountnum );
		System.out.println("userid is " + userid + "        "+ "id is "+id );
		String departmentnum =res.jsonPath().get("[0].departmentno");
		System.out.println("department num is  " + departmentnum );
	}
	
	public static Response addUserData() throws IOException {
		Header header = new Header("token",UserServiceHelper.logintokenpojo());
		CreateUserPOJO createuserData = new CreateUserPOJO();
		createuserData.setAccountno("TA-900000");
		createuserData.setDepartmentno("2");
		createuserData.setPincode("321321");
		createuserData.setSalary("15000");
		
		Response res = RestAssured
		.given()
		.header(header)
		.contentType(ContentType.JSON)
	.body(createuserData)
	.when()
	//.post("addData");
	.post(Endpoints.ADD_DATA);
		return res;
	}
	
	public static Response updateUserData() throws IOException {
		Header header = new Header("token",UserServiceHelper.logintokenpojo());
		UpdateUserPOJO updateuserData = new UpdateUserPOJO();
		updateuserData.setAccountno("TA-900000");
		updateuserData.setDepartmentno("6");
		updateuserData.setPincode("321321");
		updateuserData.setSalary("15000");
		updateuserData.setId("1LluIrXuUXWeDqwmDrbW");
		updateuserData.setUserid("vTqHKffvK4WIXGi0xuLU");
		Response res = RestAssured
		.given()
		.header(header)
		.contentType(ContentType.JSON)
	.body(updateuserData)
	.when()
	//.put("updateData");
		.put(Endpoints.UPDATE_DATA);
		return res;
	}
	
	public static Response deleteUserData() throws IOException{
		
		Header header = new Header("token",UserServiceHelper.logintokenpojo());
		DeleteUserPOJO deleteuserData = new DeleteUserPOJO();
		deleteuserData.setId("1LluIrXuUXWeDqwmDrbW");
		deleteuserData.setUserid("vTqHKffvK4WIXGi0xuLU");
		Response res = RestAssured
		.given()
		.header(header)
		.contentType(ContentType.JSON)
	.body(deleteuserData)
	.when()
	//.delete("deleteData");
		.delete(Endpoints.DELETE_DATA);
		
		return res;
	}
	
	public int getStatusCode(Response response) {
		return response.getStatusCode();
	}
	
	public String getContentType(Response response) {
		return response.getContentType();
	}
	
	public long getResponseTimeIn(Response response, TimeUnit unit) {
		return response.getTimeIn(unit);
	}
	
	public static void verifyStatusCodeis(Response response, int statuscode) {
		response.then().statusCode(statuscode);
	}
	
	public static void verifyStatusisSuccess(Response response) {
		
		response.then().body("status",Matchers.equalTo("success"));
	}
	
	public static void responseSize(Response response) {
		System.out.println("size of response is "+ response.jsonPath().get("size()"));
		
		
	}
	public static void Userid(Response response) {
		String userid =response.jsonPath().get("[0].userid");
		System.out.println("Userid :" + userid);
		
		
	}
	
	public static void Accountnum(Response response) {
		String accountnum =response.jsonPath().get("[0].accountno");
		System.out.println("account num is  " + accountnum );
		
		
	}
	public static void Deptnum(Response response) {
		
		String departmentnum =response.jsonPath().get("[0].departmentno");
		System.out.println("department num is  " + departmentnum );
	}
	
	public static void ID (Response response) {
		String id =response.jsonPath().get("[0].id");
		System.out.println("Userid :" + id);
	}
	
/*	public static List<UserPOJO> getUserData() {
		Header header = new Header("token",logintoken());
		Response res =RestAssured
		.given()
		.header(header)
		.when()
		.get("getdata");
		List<Class<UserPOJO[]>> userArray=Arrays.asList(UserPOJO[].class);
		List<List<Class<UserPOJO[]>>> list=Arrays.asList(userArray);
		
		res.then().statusCode(200);
		System.out.println("size of response is "+ res.jsonPath().get("size()"));
		String userid =res.jsonPath().get("[0].userid");
		String id =res.jsonPath().get("[0].id");
		String accountnum =res.jsonPath().get("[0].accountno");
		System.out.println("account num is  " + accountnum );
		System.out.println("userid is " + userid + "        "+ "id is "+id );
		String departmentnum =res.jsonPath().get("[0].departmentno");
		System.out.println("department num is  " + departmentnum );
		return list;
	}*/
	
	
	

}
