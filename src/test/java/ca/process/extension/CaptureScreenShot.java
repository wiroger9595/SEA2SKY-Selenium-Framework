package ca.process.extension;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ca.process.data.createAndRunData;


public class CaptureScreenShot extends createAndRunData{
	
	
//	public void CaptureScreenshot() {
//		String projectPath = System.getProperty("user.dir");					
//		System.setProperty("webdriver", projectPath + "/Driver/chromedriver");
//		driver.get("");
//		String title = driver.getTitle();
//		Assert.assertEquals("home -Automation", title);
//		driver.close();
//	}
	
	
	public static void take(WebDriver driver, String screenshotSaveLocationFilePath) throws IOException {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenshotSaveLocationFilePath));
		
	}

	
		
}
