package test.testauto.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {

	protected WebDriver driver;

	// It will execute before test class execution
	@BeforeTest
	public void Initialization()
	{
		String exePath = "driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);       
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(30));
	}

	
	// It will execute after every test execution 
	@AfterMethod
	public void tearDown(ITestResult result)
	{

		// Here will compare if test is failing then only it will enter into if condition
		if(ITestResult.FAILURE==result.getStatus())
		{
			try 
			{
				// Create reference of TakesScreenshot
				TakesScreenshot ts=(TakesScreenshot)driver;

				// Call method to capture screenshot
				File source=ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all screenshot in our project home directory and
				// result.getName() will return name of test case so that screenshot name will be same
				FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));

				System.out.println("Screenshot taken");
			} 
			catch (Exception e)
			{

				System.out.println("Exception while taking screenshot "+e.getMessage());
			}
		}



		}

		@AfterClass        
		public void Cleanup()
		{
			driver.quit();
		}



	}
