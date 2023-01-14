package vtiger.GenericLibrary;

import java.io.IOException;
import java.util.Set;

import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementationClass implements ITestListener{
	
	ExtentSparkReporter htmlreport;
	ExtentReports report;
	ExtentTest test;
	
	public void onStart(ITestContext context) {
		System.out.println("Execution Started");
		 htmlreport=new ExtentSparkReporter(".\\ExtentReport\\Report-"+".html");
		htmlreport.config().setDocumentTitle("Execution started");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("vtiger execution report");
		//Attach the html report to extent report
		 report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Baseplatform","windows 10");
		report.setSystemInfo("Browser","Chrome");
		report.setSystemInfo("Base Environment","Test ENVIRONMENT");
		report.setSystemInfo("Author","Sachin R");
	}

	public void onTestStart(ITestResult result) {

		String MethodeName = result.getMethod().getMethodName();
		 test =  report.createTest(MethodeName);
		 test.log(Status.PASS, MethodeName+"------>Success");
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodeName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodeName+"------>Success");
		
	}

	public void onTestFailure(ITestResult result) {
	   WebDriverUtilities util=new WebDriverUtilities();
	   JavaUtility jutil=new JavaUtility();
	   
	   String methodeName = result.getMethod().getMethodName();
		
	   test.log(Status.FAIL, methodeName+"------>Failed");
	test.log(Status.FAIL,result.getThrowable());
	   String ScreenshotName = (methodeName+"Testcase failed");
	   try {
		String path=util.takeScreenshot(Baseclass2.sdriver,ScreenshotName );
		test.addScreenCaptureFromPath(path);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodeName = result.getMethod().getMethodName();
		
		   test.log(Status.SKIP, methodeName+"------>Skipped");
		   test.log(Status.SKIP,result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}
		
	

	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished");
		//We should flush thr report, consolidate the status of every test script and generate the reports
		
		report.flush();
		
	}
	
	
	
	

	}

	