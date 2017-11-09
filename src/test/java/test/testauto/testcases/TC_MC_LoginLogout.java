package mastercard.dwp.testauto.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*
 * @author Saroj Sahoo
 * 
 * This is for PoC.
 * Test script execution within one file. Segregation is not done.
 * 
 * Verify the related file is present in Image library.
 * 
 */

@Test
public class TC_MC_LoginLogout //extends BaseTest
{
	ExtentReports report;
	ExtentTest logger; 

	public void MC_Login_PoC_WebPart() throws Exception
	{

		report=new ExtentReports("report\\TR_VerifyImageLibrary.html");
		 
		logger=report.startTest("VerifyImageLibrary");

		String exePath = "driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		logger.log(LogStatus.INFO, "Browser started ");

		/*
		String exePath = "driver\\IEDriverServer64.exe";
		System.setProperty("webdriver.ie.driver", exePath);
		WebDriver driver=new InternetExplorerDriver();
		 */

		/*
		String exePath = "driver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", exePath);
		WebDriver driver = new FirefoxDriver();
		 */
		
		//Maximize browser
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Browser maximized ");

		driver.get("https://dev.sharepoint.com");
		logger.log(LogStatus.INFO, "Application is up and running");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//User Name
		driver.findElement(By.id("cred_userid_inputtext")).sendKeys("test1@dev.com");

		//Password
		driver.findElement(By.id("cred_password_inputtext")).sendKeys("password123");

		//Sign In
		Thread.sleep(3000);
		driver.findElement(By.id("cred_sign_in_button")).click();

		//Click on Pages
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Picture']")).click();
		logger.log(LogStatus.PASS, "Clicked on Image link");

		//Verify File exist
		Thread.sleep(5000);
		SoftAssert assertion=new SoftAssert();
		assertion.assertEquals("desktop-1414436259.jpg", "desktop-1414436259.jpg", "File name is not matching with actual");
		boolean expected = driver.findElement(By.xpath("//*[@title='desktop-1414436259.jpg']")).isDisplayed();
		assertion.assertEquals(true, expected);
		logger.log(LogStatus.PASS, "Image verified");


		//Sign Out 
		Thread.sleep(5000);
		logger.log(LogStatus.INFO, "Click on Sign Out");
		driver.findElement(By.id("O365_MeFlexPane_ButtonID")).click();
		driver.findElement(By.id("O365_SubLink_ShellSignout")).click();
		logger.log(LogStatus.INFO, "Signed Out");
		
		report.endTest(logger);
		report.flush();
		driver.get("report\\MC_Regression_TestResult.html");
		
		driver.quit();

	}

}
