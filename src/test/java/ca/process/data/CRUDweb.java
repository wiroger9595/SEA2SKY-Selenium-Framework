package ca.process.data;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import ca.library.main.AddUserFactory;
import ca.library.main.AddCourseLibrary;
import ca.library.main.clickFuntion;
import ca.library.main.sendKeyFunction;
import ca.library.main.clickFuntion;
import ca.library.data.excelProcessMethod;
import ca.library.data.excelProvider;
import ca.process.extension.CaptureScreenShot;;




public class CRUDweb {
	
	
	
	 //private static String testName = "Moodle User CRUD Test";
	private static String testName = "Moodle User CRUD Tests";
	public static WebDriver driver = null;
	private static String projectPath = System.getProperty("user.dir");					
	private static String screenShotFile = projectPath +  "/ScreenShot_Folder/File.png"  ;

	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest test; 
	//JavascriptExecutor js = ((JavascriptExecutor)driver);
	
	@BeforeSuite
	public static void initialization() {	
		System.setProperty("webdriver.chrome.driver",  projectPath + "/Driver/chromedriver");
		driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void setUpBeforeAutomationTest() throws Exception{
		
		
		driver.get("http://localhost:8888/moodle36/");
		driver.findElement(By.linkText("Log in")).click();
		clickFuntion.Id(driver, "username");
		sendKeyFunction.Id(driver, "username", "admin");
		
		clickFuntion.Id(driver, "password");
		sendKeyFunction.Id(driver, "password", "12345");
		
		Thread.sleep(2000);
		
		clickFuntion.Id(driver, "loginbtn");
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skip to main content'])[1]/following::i[1]")).click();
//		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Update'])[1]/following::span[2]")).click();
		
		
		
//		clickFuntion.Xpath(driver, "(.//*[normalize-space(text()) and normalize-space(.)='Skip to main content'])[1]/following::i[1]");
		WebElement siteicon = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skip to main content'])[1]/following::i[1]"));
//		siteicon.click();	
//
//		Thread.sleep(1000);
//
		WebElement siteAdmin = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Update'])[1]/following::span[2]"));
		
		if(siteAdmin != null) {
			siteAdmin.click();
		}else {
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skip to main content'])[1]/following::i[1]")).click();
			
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Update'])[1]/following::span[2]")).click();
			
		}
		
		clickFuntion.LinkText(driver, "Courses");
		clickFuntion.LinkText(driver, "Add a new course");
//		
	}
	
	
	//create the data
	@Test(dataProvider="test1data", dataProviderClass=excelProvider.class, priority=1, retryAnalyzer = ca.library.data.RetestAnalyzer.class)
	public void testCreateCourse(String courseFullName, String courseShortName, String courseStartDate, String courseEndDate) throws Exception {
	
		
		try {
		clickFuntion.Id(driver, "id_fullname");
		sendKeyFunction.Id(driver, "id_fullname", courseFullName);

		clickFuntion.Id(driver, "id_shortname");
		sendKeyFunction.Id(driver, "id_shortname", courseShortName);
		
		driver.findElement(By.id("id_startdate_day")).click();
		Thread.sleep(2000);
		clickFuntion.Id(driver, "id_saveanddisplay");
		
		
		

		}catch(Exception e) {
			CaptureScreenShot.take(driver,screenShotFile);

			
			String failureDisplay = e.getMessage();
			test.fail(testName +" failed: " + failureDisplay);
			
			System.out.println(e.getCause());
			e.printStackTrace();
//			WebElement manageCourseAndCategories = driver.findElement(By.linkText("Manage courses and categories")); 
//			manageCourseAndCategories.click();	
//			WebElement deleteIcon = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quality Assurance: Concepts and Methodologies'])[1]/preceding::i[6]")); 
//			deleteIcon.click();	
//			WebElement deleteConfirm = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contacts'])[1]/preceding::button[1]"));
//			deleteConfirm.click();
//			WebElement deleteConfirmContinue = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='×'])[13]/following::button[1]"));
//			deleteConfirmContinue.click();
//			WebElement createOtherNewCourses = driver.findElement(By.linkText("Courses"));
//			createOtherNewCourses.click();
//			WebElement addOtherNewCourses = driver.findElement(By.linkText("(.//*[normalize-space(text()) and normalize-space(.)='bbraverya'])[1]/following::button[1]"));
//			addOtherNewCourses.click();
		}
	}
	
	
	//modify the data
	@Test(dataProvider="test1data", dataProviderClass=excelProvider.class, priority=2)
	public void testModifyCourse(String courseFullName, String courseShortName, String courseStartDate, String courseEndDate) throws Exception {
	
	try {
		clickFuntion.Xpath(driver, "(.//*[normalize-space(text()) and normalize-space(.)='Sort by Course time created descending'])[2]/following::i[2]");

		
		clickFuntion.Id(driver, "id_fullname");
		sendKeyFunction.Id(driver, "id_fullname", courseFullName);

		clickFuntion.Id(driver, "id_shortname");
		sendKeyFunction.Id(driver, "id_shortname", courseShortName);
		
		driver.findElement(By.id("id_startdate_day")).click();
		Thread.sleep(2000);
		
		clickFuntion.Id(driver, "id_saveandreturn");

		}catch(Exception e) {
			CaptureScreenShot.take(driver,screenShotFile);

			
			String failureDisplay = e.getMessage();
			test.fail(testName +" failed: " + failureDisplay);
			
			System.out.println(e.getCause());
			e.printStackTrace();
			
		}
	}

	//delete the data
	@Test(dataProvider="test1data", dataProviderClass=excelProvider.class, priority=3)
	public void DeleteModifyCourse(String courseFullName, String courseShortName, String courseStartDate, String courseEndDate) throws Exception {
	try {
		
		clickFuntion.Xpath(driver, "(.//*[normalize-space(text()) and normalize-space(.)='Sort by Course time created descending'])[2]/following::i[3]");
		clickFuntion.Xpath(driver, "(.//*[normalize-space(text()) and normalize-space(.)='Confirm'])[1]/following::button[1]");
		clickFuntion.Xpath(driver, "(.//*[normalize-space(text()) and normalize-space(.)='×'])[12]/following::button[1]");


		}catch(Exception e) {
			CaptureScreenShot.take(driver,screenShotFile);

			
			String failureDisplay = e.getMessage();
			test.fail(testName +" failed: " + failureDisplay);
			
			System.out.println(e.getCause());
			e.printStackTrace();
			
		}
	}	
	
	
	//clean data
//	@AfterTest(alwaysRun =true)
//	public void teardown(String courseFullName, String courseShortName) throws Exception{
//		driver.quit();
//		String verificationErrorString = verificationErrors.toString();
//		    if (!"".equals(verificationErrorString)) {
//		      fail(verificationErrorString);
//		    }
//	}
	
	
	public void failed(String testMethodName) {
		String projectPath = System.getProperty("user.dir");					
		File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
		FileUtils.copyFile(scrFile, new File( projectPath + "/ScreenShot_Folder/" + testMethodName + "_" + ".jpg"));
	
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}