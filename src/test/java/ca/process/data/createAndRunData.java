package ca.process.data;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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




public class createAndRunData {
	
	
	
	//private static String testName = "Moodle User CRUD Test";
	WebDriver driver = null;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest test; 
	//JavascriptExecutor js = ((JavascriptExecutor)driver);
	
	@BeforeTest
	public void setUpTest() throws Exception{
		String projectPath = System.getProperty("user.dir");					
		System.setProperty("webdriver.chrome.driver",  projectPath + "/Driver/chromedriver");
		//System.setProperty("webdriver.chrome.driver",  "/Volumes/OS/Java/selenium_for_java/chromedriver");

		driver = new ChromeDriver();
		
		driver.get("http://3.17.121.163");
		driver.findElement(By.linkText("Log in")).click();
		clickFuntion.Id(driver, "username");
		sendKeyFunction.Id(driver, "username", "admin");
		
		clickFuntion.Id(driver, "password");
		sendKeyFunction.Id(driver, "password", "Robert123$$##");
		
		Thread.sleep(2000);
		
		clickFuntion.Id(driver, "loginbtn");
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		clickFuntion.Xpath(driver, "(.//*[normalize-space(text()) and normalize-space(.)='LMS'])[1]/preceding::button[1]");
		WebElement siteicon = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LMS'])[1]/preceding::button[1]"));
		siteicon.click();	

		Thread.sleep(1000);
//		clickFuntion.Xpath(driver, "(.//*[normalize-space(text()) and normalize-space(.)='Side panel'])[1]/preceding::i[1]");
		//driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Side panel'])[1]/preceding::i[1]")).click();

		WebElement siteAdmin = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Private files'])[2]/following::span[2]"));
		
		if(siteAdmin != null) {
			siteAdmin.click();
		}else {
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Side panel'])[1]/preceding::i[1]")).click();
			
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Private files'])[2]/following::span[2]")).click();
			
		}
		
		clickFuntion.LinkText(driver, "Courses");
		clickFuntion.LinkText(driver, "Add a new course");
//		WebElement courses = driver.findElement(By.linkText("Courses"));
//		courses.click();
//		WebElement addCourse = driver.findElement(By.linkText("Add a new course"));
//		addCourse.click();
	}
	
	
	//create the data
	@Test(dataProvider="test1data", dataProviderClass=excelProvider.class, priority=1)
	public void test1(String courseFullName, String courseShortName, String courseStartDate, String courseEndDate) throws Exception {
	
		
		try {
//		WebElement cFullName = driver.findElement(By.id("id_fullname")); // Username Field
//		cFullName.click();
//		cFullName.clear();
//		cFullName.sendKeys(courseFullName);
		clickFuntion.Id(driver, "id_fullname");
		sendKeyFunction.Id(driver, "id_fullname", courseFullName);

		
//		WebElement cShortName = driver.findElement(By.id("id_shortname")); // Password Field
//		cShortName.click();
//		cShortName.clear();
//		cShortName.sendKeys(courseShortName);
		clickFuntion.Id(driver, "id_shortnamename");
		sendKeyFunction.Id(driver, "id_shortnamename", courseShortName);
		
		
		
		driver.findElement(By.id("id_startdate_day")).click();
		//js("document.getElementById('id_startdate_day').value('23')");
		
		
		Thread.sleep(2000);
//		WebElement saveAndDisplay = driver.findElement(By.id("id_saveanddisplay")); 
//		saveAndDisplay.click();
//		WebElement newCourseTitle = driver.findElement(By.id("page-course-view-topics")); 
//		newCourseTitle.click();
//		WebElement addANewCourse = driver.findElement(By.id("single_button5ccb992f32c242")); 
//		addANewCourse.click();
		clickFuntion.Id(driver, "id_shortnamename");

		

		}catch(Exception e) {
			WebElement manageCourseAndCategories = driver.findElement(By.linkText("Manage courses and categories")); 
			manageCourseAndCategories.click();	
			WebElement deleteIcon = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quality Assurance: Concepts and Methodologies'])[1]/preceding::i[6]")); 
			deleteIcon.click();	
			WebElement deleteConfirm = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contacts'])[1]/preceding::button[1]"));
			deleteConfirm.click();
			WebElement deleteConfirmContinue = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='×'])[13]/following::button[1]"));
			deleteConfirmContinue.click();
			WebElement createOtherNewCourses = driver.findElement(By.linkText("Courses"));
			createOtherNewCourses.click();
			WebElement addOtherNewCourses = driver.findElement(By.linkText("(.//*[normalize-space(text()) and normalize-space(.)='bbraverya'])[1]/following::button[1]"));
			addOtherNewCourses.click();
		}
	}
	
	
	//clean data
	@AfterTest
	public void teardown(String courseFullName, String courseShortName) throws Exception{
		
		
		driver.quit();
	}
	
}