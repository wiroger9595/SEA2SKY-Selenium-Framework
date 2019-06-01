package ca.process.data;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ca.library.data.excelProcessMethod;
import ca.library.data.excelProvider;




public class stepTest extends createAndRunData{

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		setUpBeforeAutomationTest();
		
	}
	
	@AfterMethod void tearDown(){
		driver.quit();
	}
	
	@Test
	public void takeScreenshotTest() {
		Assert.assertEquals(false, true);
	}
}