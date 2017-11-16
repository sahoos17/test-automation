package test.testauto.testcases;

//import java.util.concurrent.TimeUnit;
//import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.testauto.utils.CaptureScreenShots;

/*
 * @author Saroj Sahoo
 * 
 * This is for PoC. Hence only page open is verified.
 * This is without actual dev tenant details.
 * 
 * Also user credential is not provided as it's in public GitHub.
 * 
 * Test is configured to execute with PhantmJS headless browser.
 * 
 * 
 */


public class TC_MC_LoginLogout
{
	ExtentReports report;
	ExtentTest logger; 
	WebDriver driver;
	protected static DesiredCapabilities dCaps;

	@Test
	public void MC_Login_PoC_WebPart() throws Exception
	{

		report=new ExtentReports("report\\MC_Sanity_PhantomJS_TestResult.html");

		logger=report.startTest("VerifyLogin");

		dCaps = new DesiredCapabilities();
		dCaps.setJavascriptEnabled(true);
		String exePath = "driver\\phantomjs.exe";
		dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, exePath);
		dCaps.setCapability("takesScreenshot", false);
		
		driver = new PhantomJSDriver(dCaps);
		logger.log(LogStatus.INFO, " Browser started ");
		CaptureScreenShots.captureScreenShot(driver, "01_PhantomJS_Driver_Started");

		//Maximize browser
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Browser maximized ");

		driver.get("https://dev.sharepoint.com");
		logger.log(LogStatus.PASS, "Application is up and running");
		CaptureScreenShots.captureScreenShot(driver, "02_PhantomJS_AppIsUp");

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//User Name
		//driver.findElement(By.id("cred_userid_inputtext")).sendKeys("test1@dev.com");

		//Password
		//driver.findElement(By.id("cred_password_inputtext")).sendKeys("password123");

		//Sign In
		//Thread.sleep(3000);
		//driver.findElement(By.id("cred_sign_in_button")).click();

		//Click on Pages
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[@title='Picture']")).click();
		//logger.log(LogStatus.PASS, "Clicked on Image link");

		//Verify File exist

		//logger.log(LogStatus.PASS, "Image verified");

		//Sign Out 
		//Thread.sleep(5000);
		//logger.log(LogStatus.INFO, "Click on Sign Out");
		//driver.findElement(By.id("O365_MeFlexPane_ButtonID")).click();
		//driver.findElement(By.id("O365_SubLink_ShellSignout")).click();
		//logger.log(LogStatus.INFO, "Signed Out");

		report.endTest(logger);
		report.flush();
		driver.get("report\\MC_Sanity_PhantomJS_TestResult.html");
		Thread.sleep(10000);
	}

	@Test
	public void verifyFailTC01()
	{
		SoftAssert assertion=new SoftAssert();
		assertion.assertEquals(12, 13);
		System.out.println("Test 1 is Failed");
		
	}
	
	@Test
	public void verifyFailTC02()
	{
		SoftAssert assertion=new SoftAssert();
		assertion.assertEquals(15, 15);
		System.out.println("Test 2 is Successed");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Driver session end");
		driver.quit();
	}

}
