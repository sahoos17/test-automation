package test.testauto.testcases;

//import java.util.concurrent.TimeUnit;
//import org.junit.Test;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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


public class TC_MC_LoginLogout_bkp //extends BaseTest
{
	ExtentReports report;
	ExtentTest logger; 
	WebDriver driver;

	@Test
	@Parameters("browser")
	public void MC_Login_PoC_WebPart(String browserName) throws Exception
	{

		report=new ExtentReports("report\\MC_Sanity_TestResult.html");

		logger=report.startTest("VerifyLogin");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			String exePath = "driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
			logger.log(LogStatus.INFO, "Chrome Browser started ");
		}

		else if(browserName.equalsIgnoreCase("ie"))
		{
			String exePath = "driver\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", exePath);
			driver=new InternetExplorerDriver();
			logger.log(LogStatus.PASS, "IE Browser started ");
		}

		else if(browserName.equalsIgnoreCase("firefox"))
		{
			ProfilesIni profile = new ProfilesIni();

			FirefoxProfile firefoxProfile = profile.getProfile("QAProfile");
			
			String exePath = "driver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exePath);
			driver = new FirefoxDriver(firefoxProfile);
			logger.log(LogStatus.PASS, "Firefox Browser started ");
		}

		//Maximize browser
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Browser maximized ");

		driver.get("https://dev.sharepoint.com");
		logger.log(LogStatus.PASS, "Application is up and running");

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
		driver.get("report\\MC_Sanity_TestResult.html");
		Thread.sleep(10000);
		
		driver.quit();
		//driver.close();
	}

	@Test(enabled = false)
	public void MC_Login_PoC_WebPart1()
	{
		Assert.assertEquals(12, 13);
	}

	@Test(enabled = false)
	public void MC_Login_PoC_WebPart2()
	{
		Assert.assertEquals(14, 166);
	}

}
