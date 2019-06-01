package ca.process.extension;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ca.process.data.createAndRunData;

public class GetScreenshot extends createAndRunData{
public static String capture(String screenshotName) throws IOException{
		
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"/ScreenShot_Folder/" + screenshotName + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		
		return dest;
	}
}
