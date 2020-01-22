package listner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.model.MediaType;
import com.aventstack.extentreports.model.ScreenCapture;

import constants.Constants;
import utils.EncryptionDecryption;
import utils.FileOperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import java.util.HashMap;
import java.util.Map;

public class ReportListener implements ITestListener, IClassListener, ISuiteListener {

	Path currentRelativePath = Paths.get("");
	String s = currentRelativePath.toAbsolutePath().toString();
	String basePath = s + File.separator;

	private ExtentReports extent;
	private ExtentTest test;
	private ExtentHtmlReporter htmlReporter;
	private String screen, extentScreen = null;
	private static ThreadLocal<Integer> testMethodCount = new ThreadLocal<Integer>();
	private ThreadLocal<String> testRunStatus = new ThreadLocal<String>();
	
	private static String filePathex = System.getProperty("user.dir") + "/Extent Reports/extentreport.html";
	private static Map<String, RemoteWebDriver> driverMap = new HashMap<String, RemoteWebDriver>();
	private static Map<String, ExtentTest> extentTestMap = new HashMap<String, ExtentTest>();
	
	Constants constants = new Constants();
	FileOperations fileOperations = new FileOperations();
	EncryptionDecryption encryptionDecryptionObj = new EncryptionDecryption();

	public synchronized ExtentTest startTest(String testName) {
		ExtentTest classNode = getExtent().createTest(testName);
		extentTestMap.put(testName, classNode);
		return classNode;
	}

	public static synchronized ExtentTest getTest(String testName) {
		return extentTestMap.get(testName);
	}

	public void onStart(ISuite suite) {
		this.extent = getExtent();
		suite.setAttribute("extent", this.extent);
		testRunStatus.set("pass");
	}

	public void onStart(ITestContext context) {

	}

	public void onBeforeClass(ITestClass testclass) {
		this.test = startTest(testclass.getRealClass().getSimpleName());
		testMethodCount.set(-1);
	}

	public void onTestStart(ITestResult result) {
		String testClassName = result.getTestClass().getRealClass().getSimpleName();
		driverMap.put(testClassName, (RemoteWebDriver) result.getTestContext().getSuite().getAttribute("driver"));
		
		getTest(result.getInstanceName().split("\\.")[2].trim())
		.createNode(result.getMethod().getMethodName(), result.getMethod().getDescription())
		.log(Status.INFO, "Test method " + result.getMethod().getMethodName() + " started");

		Integer testMethodCountValue = testMethodCount.get();
		testMethodCountValue = testMethodCountValue + 1;
		testMethodCount.set(testMethodCountValue);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getName().trim();
		String filePath = System.getProperty("user.dir") + "/Passed Screenshots/";
		takeScreenShot(filePath, methodName, driverMap.get(result.getTestClass().getRealClass().getSimpleName()));

		Log logObj = new Log(getTest(Reporter.getCurrentTestResult().getInstanceName().split("\\.")[2].trim()));
		logObj.setDetails("Test method " + result.getMethod().getMethodName() + " completed successfully");
		logObj.setStatus(Status.PASS);

		getTest(Reporter.getCurrentTestResult().getInstanceName().split("\\.")[2].trim()).getModel().getNodeContext().get(testMethodCount.get()).getLogContext().add(logObj);

		ScreenCapture med	= new ScreenCapture();
		med.setMediaType(MediaType.IMG);
		med.setPath(extentScreen);
		getTest(Reporter.getCurrentTestResult().getInstanceName().split("\\.")[2].trim())
		.getModel().getNodeContext().get(testMethodCount.get()).setScreenCapture(med);
	}
	
	public void onTestFailure(ITestResult result) {
		testRunStatus.set("fail");
		String methodName = result.getName().trim();
		String filePath = System.getProperty("user.dir") + "/Failure Screenshots/";
		takeScreenShot(filePath, methodName, driverMap.get(result.getTestClass().getRealClass().getSimpleName()));

		Log logObj = new Log(getTest(Reporter.getCurrentTestResult().getInstanceName().split("\\.")[2].trim()));
		logObj.setDetails("Test method " + result.getMethod().getMethodName() + " failed due to Exception -----> " + Reporter.getCurrentTestResult().getThrowable().toString());
		logObj.setStatus(Status.FAIL);

		getTest(Reporter.getCurrentTestResult().getInstanceName().split("\\.")[2].trim()).getModel().getNodeContext().get(testMethodCount.get()).getLogContext().add(logObj);

		ScreenCapture med	= new ScreenCapture();
		med.setMediaType(MediaType.IMG);
		med.setPath(extentScreen);
		getTest(Reporter.getCurrentTestResult().getInstanceName().split("\\.")[2].trim())
		.getModel().getNodeContext().get(testMethodCount.get()).setScreenCapture(med);
	}

	public void onTestSkipped(ITestResult result) {
		// 		BaseTest.getContext().getSelenium().getWebDriver());
		//		med = new ScreenCapture();
		//		med.setMediaType(MediaType.IMG);
		//		med.setPath(screen1);
		//		mp = new MediaEntityModelProvider(med);
		//		getTest(result.getInstanceName().split("\\.")[2].trim())
		//				.createNode(result.getMethod().getMethodName(), result.getMethod().getDescription())
		//				.fail(MarkupHelper.createLabel("FAIL", ExtentColor.RED))
		//				.fail("Screenshot " + result.getMethod().getMethodName(), mp).log(Status.FAIL, result.getThrowable())
		//				.log(Status.FAIL, "Test Case is fail");
		//		count++;
		
		//		med = new ScreenCapture();
		//		med.setMediaType(MediaType.IMG);
		//		med.setPath(screen1);
		//		mp = new MediaEntityModelProvider(med);
		//		getTest(result.getInstanceName().split("\\.")[2].trim())
		//				.createNode(result.getMethod().getMethodName(), result.getMethod().getDescription())
		//				.pass(MarkupHelper.createLabel("PASS", ExtentColor.GREEN)).log(Status.PASS, result.getTestName())
		//				.pass("Screenshot " + result.getMethod().getMethodName(), mp);
		
		//		method1[count1 - 1] = result.getName().toString().trim();
		//		this.result = result;
		//		String filePath = System.getProperty("user.dir") + "/Skipped Screenshots/";
		//		takeScreenShot(filePath, method1[count1 - 1], driverMap.get(result.getTestClass().getRealClass().getSimpleName()));
		//		// BaseTest.getContext().getSelenium().getWebDriver());
		//
		//		med = new ScreenCapture();
		//		med.setMediaType(MediaType.IMG);
		//		med.setPath(screen1);
		//		mp = new MediaEntityModelProvider(med);
		//		getTest(result.getInstanceName().split("\\.")[2].trim())
		//				.createNode(result.getMethod().getMethodName(), result.getMethod().getDescription())
		//				.skip(MarkupHelper.createLabel("SKIP", ExtentColor.BLUE))
		//				.skip("Screenshot " + result.getMethod().getMethodName(), mp).log(Status.SKIP, result.getThrowable());
		//		count++;
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onAfterClass(ITestClass testclass) {
	}

	public void onFinish(ITestContext context) {
	}

	public void onFinish(ISuite suite) {
		if(testRunStatus.get().equalsIgnoreCase("fail")) {
			try {
				fileOperations.updateValueToPropertyFile(constants.CONFIG_WEB_FILE_PATH, "testRunStatus", "fail");
			} catch (ConfigurationException | IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				fileOperations.updateValueToPropertyFile(constants.CONFIG_WEB_FILE_PATH, "testRunStatus", "pass");
			} catch (ConfigurationException | IOException e) {
				e.printStackTrace();
			}
		}
		this.extent.flush();
	}

	public void takeScreenShot(String filePath, String methodName, RemoteWebDriver driver) {
		try {
			TakesScreenshot d = ((TakesScreenshot) driver);
			File scrFile = d.getScreenshotAs(OutputType.FILE);
			File scrFile2 = new File(filePath + methodName + ".png");
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			FileUtils.copyFile(scrFile, scrFile2);
			System.out.println("***Placed screen shot in " + filePath + " ***");
			extentScreen = scrFile2.toString();
			screen = "<img src='" + scrFile2.toString() + "' width='200' height='200'  > ";
			Reporter.setEscapeHtml(false);
			Reporter.log(screen);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ExtentReports getExtent() {
		if (extent == null) {
			extent = new ExtentReports();
			extent.setSystemInfo("Name", "Manan sharma");
			extent.setSystemInfo("Browser", fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "browserName"));
			extent.attachReporter(getHtmlReporter());
		}
		return extent;
	}

	private ExtentHtmlReporter getHtmlReporter() {
		htmlReporter = new ExtentHtmlReporter(filePathex);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Veoci Automation Report");
		htmlReporter.config().setReportName("Test Automation Report");
		return htmlReporter;
	}

	public static void logToReport(String msg) {
		Log logObj = new Log(getTest(Reporter.getCurrentTestResult().getInstanceName().split("\\.")[2].trim()));
		logObj.setDetails(msg);
		logObj.setStatus(Status.INFO);
		getTest(Reporter.getCurrentTestResult().getInstanceName().split("\\.")[2].trim()).getModel().getNodeContext().get(testMethodCount.get()).getLogContext().add(logObj);

		//			logObj.setSequence(2);
		//			System.out.println(getTest(Reporter.getCurrentTestResult().getInstanceName().split("\\.")[2].trim()).getModel().getNodeContext().get(0).getLogContext().get(0).getDetails());			
		//			System.out.println(getTest(Reporter.getCurrentTestResult().getInstanceName().split("\\.")[2].trim()).getModel().getNodeContext().get(0).getLogContext().get(0).getDetails());
	}
}