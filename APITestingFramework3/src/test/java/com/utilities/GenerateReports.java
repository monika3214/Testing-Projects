package com.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateReports {
	ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	private static GenerateReports ob;
	private GenerateReports() {}
	public static GenerateReports getInstance() {
		if (ob == null) {
			ob = new GenerateReports();
		}
		return ob;
	}
	public void startExtentReport() {
		htmlReporter = new ExtentHtmlReporter(Constants.GENERATE_REPORT_PATH);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "Tekarch");
		extent.setSystemInfo("User Name", "Monika");
		htmlReporter.config().setDocumentTitle("Test Execution Reports");
		htmlReporter.config().setReportName("API Tests");
		//  htmlReporter.config().setTestViewChartLocation(chartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);}
	
		public void startSigleTestReport(String testname ) {
			logger = extent.createTest(testname);}
		public void logTestInfo(String message ) {
			logger.log(Status.INFO, message) ;}
		
		public void logTestPassed(String testcasename ) {
			logger.log(Status.PASS, MarkupHelper.createLabel(testcasename, ExtentColor.GREEN));}
		public void logTestFail(String testcasename ) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(testcasename, ExtentColor.RED));}
		

			public void close() {
				extent.flush();
				
			}
		//System.out.println("completed");
			
}


