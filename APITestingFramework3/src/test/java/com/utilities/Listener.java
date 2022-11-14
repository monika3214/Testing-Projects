package com.utilities;

 
	
	import java.lang.reflect.Method;

import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

import com.APItests.APItestScript;
import com.aventstack.extentreports.ExtentTest;
//import com.salesforce.autimationscript.utility.GenerateReports;
	import com.utilities.GenerateReports;
	
	public class Listener extends APItestScript implements ITestListener{
		
		public void onStart(ITestResult result) {
			 System.out.println("on Started" +result.getName());
			 report.logTestInfo("on start");
			
		 }
		
		 
		 

		 public void onTestStart(ITestResult result, Method m) {
		 
		 System.out.println("New Test Started" +result.getName());
		 //report.logTestInfo("testcase pass for" + result.getName());
		 report.logTestInfo("testcase pass for" +m.getName());
		// report1.startExtentReport();
		// report1.startSigleTestReport(m.getName());
		 
		 }
		 

		 public void onTestSuccess(ITestResult result, Method m) {
		 
		 System.out.println("Test Successfully Finished" +result.getName());
		 //report.logTestInfo("testcase pass for" + result.getName());
		 report.logTestInfo("testcase pass for" +m.getName());
		 
		 }
		 
		
	/*	 public void onTestFailure(ITestResult result) {
		 
		 System.out.println("Test Failed" +result.getName());
		 report.logTesFail("testcase fail for"+ result.getName());
		 
		 }*/
		 
		 public void onTestSkipped(ITestResult result) {
		 
		 System.out.println("Test Skipped" +result.getName());
		 
		 }
		 
		
		 
		 public void onFinish(ITestContext context) {
		 
		 System.out.println("This is onFinish method" +context.getPassedTests());
		 
		 }
		}




