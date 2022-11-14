package com.APItests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.utilities.CommonUtilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import com.APItests.UserServiceHelper;
//import com.salesforce.autimationscript.utility.GenerateReports;
import com.utilities.*;
@Listeners(com.utilities.Listener.class)
	public class APItestScript extends UserServiceHelper{
	 public static com.utilities.GenerateReports report= null;
	
		@Test(enabled = true)
		public static void TC01_loginToApi() throws IOException {
			String token = UserServiceHelper.logintokenpojo();
			
		System.out.println("end of TC01");	
		}
			
			
		
		@Test(enabled = true)
		public static void T02_getUsersDetail() throws IOException {
			UserServiceHelper.getMethod();
			System.out.println("end of TC02");
			
		}
		
		@Test(enabled = true)
		public static void TC03_createUser() throws IOException {
			Response res = UserServiceHelper.addUserData();
			UserServiceHelper.verifyStatusCodeis(res, 201);
			UserServiceHelper.verifyStatusisSuccess(res);
			System.out.println("end of TC03");
			//UserServiceHelper.getMethod();
			}
		
		@Test(enabled = true)
		public static void TC04_updateUser() throws IOException {
		
			Response res = UserServiceHelper.updateUserData();
			UserServiceHelper.verifyStatusCodeis(res, 200);
			UserServiceHelper.verifyStatusisSuccess(res);
			UserServiceHelper.responseSize(res);
			System.out.println("end of TC04");
			}
		
		@Test(enabled = true)
		public static void TC05_deleteUser() throws IOException {
			
			
			Response res = UserServiceHelper.deleteUserData();
			UserServiceHelper.verifyStatusCodeis(res, 200);
			UserServiceHelper.verifyStatusisSuccess(res);
			System.out.println("end of TC05");
			//UserServiceHelper.getMethod();
			}}
		
		
		
			
			
		
		
		
			
			
			
		

	



