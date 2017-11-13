package test.testauto.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShots {

	WebDriver driver;

	public CaptureScreenShots(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	public static void captureScreenShot(WebDriver ldriver, String screenshotName){

		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the  screenshot to desired location using copyFile method

			//FileUtils.copyFile(src, new File("screenshots\\"+System.currentTimeMillis()+".png"));
			FileUtils.copyFile(src, new File("screenshots\\"+screenshotName+".png"));
		}

		catch (IOException e)

		{

			System.out.println(e.getMessage());

		}

	}

}
