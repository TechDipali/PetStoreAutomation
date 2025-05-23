package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext context) 
	{
		
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName ="Test-Report-"+timeStamp+".html";
		
		//sparkReporter=new ExtentSparkReporter("C:\\Users\\dipal\\RestAssuared_WP\\PetStoreAutomation\\reports"+repName);
		sparkReporter = new ExtentSparkReporter("C:\\Users\\dipal\\RestAssuared_WP\\PetStoreAutomation\\reports\\" + repName);

		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
		sparkReporter.config().setReportName("Pet Store Users API");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Pet Store Users API");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Dipali");
		System.out.println("Onstart method");
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
		System.out.println("Onsuccess method");
	}
	
	public void onTestFailure(ITestResult result) 
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Falied");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		System.out.println("Ontestfailure method");
	}
	
	public void onSkipped(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		System.out.println("Onskipped method");
		
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
		System.out.println("Onfinish method");
	}
	
	
	
	
	
	
}
