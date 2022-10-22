package com.apitest;

import java.util.List;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.helper.Helper;
import com.pojo.ResponsePOJO;
import com.utilities.Endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Apitest extends Helper{
	@Test
	public static void Testcase1() {
		
        Response res = RestAssured	

		//.get("https://dummy.restapiexample.com/api/v1/employees");
        .get(Endpoints.EMPLOYEES);
       // ResponsePOJO[]	list = res.as(ResponsePOJO[].class);
        
        Helper.verifyStatusCodeis(res, 200);
        Helper.verifyStatusisSuccess(res);
        Helper.responseSize(res);
        
		/*res.prettyPrint();
		
		System.out.println("status is" + res.path("status"));
		
		System.out.println("number of emeployee entries is:  "+ res.jsonPath().get("data.size()"));*/

}
	@Test
	public static void Testcase2() {
		
		//Response res = RestAssured;
		//		.post(Endpoints.CREATE);
		
		Response res =	Helper.createUser();
		 Helper.verifyStatusCodeis(res, 200);
	     Helper.verifyStatusisSuccess(res);
	     res.prettyPrint();
	     System.out.println(res.path("id"));
	    ResponsePOJO[]	list = res.as(ResponsePOJO[].class);
	 	int id = list[0].getId();
	 	System.out.println("id is " + id);
	    // res.then().body(("data.find{it.id==4000}.employee_name"),Matchers.equalTo("test"));
	    // res.then().body(("data.find{it.id==4000}.employee_name"),Matchers.equalTo("23"));
	     
	     
	    List<String> allEmpdata = res.path("data.findAll {it.employee_age == 23}");
		//	System.out.println("all employee details whose salary is 123 is:");
			System.out.println(allEmpdata);}
		
		
		
	@Test
	public static void Testcase3() {}
	
	
	@Test
	public static void Testcase4() {
		
		 Response res = RestAssured	
				 .delete("https://dummy.restapiexample.com/api/v1/employees/2");
				// .delete(Endpoints.DELETE);
		 Helper.verifyStatusCodeis(res, 405);
		 Helper.verifyStatusisError(res);
		 
		 res.prettyPrint();
				 
	}
	
	
	
	@Test
	public static void Testcase5() {
		Response res = RestAssured
				.get(Endpoints.EMPLOYEES);
		res.prettyPrint();
		 Helper.verifyStatusCodeis(res, 200);
		res.then().body(("data.find{it.id==2}.employee_name"),Matchers.equalTo("Garrett Winters"));
		res.then().body(("data.find{it.id==2}.employee_salary"),Matchers.equalTo(170750));
		res.then().body(("data.find{it.id==2}.employee_age"),Matchers.equalTo(63));
		
		
		
		
		
		
	}
}