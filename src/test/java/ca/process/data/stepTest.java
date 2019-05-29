package ca.process.data;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ca.library.data.excelProcessMethod;
import ca.library.data.excelProvider;




public class stepTest {

//	public static void main(String[] args) {
//		String excelPath = "/Users/robert/eclipse-workspace/MoodelJavaAutomation/excel/MOCK_DATA.xlsx";
//		testData(excelPath, "data");
//	}
//	
	private static String testName = "Moodle User CRUD Test";
	WebDriver driver = null;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest test; 
	
	
	@BeforeTest
	public void setUpTest() throws Exception{
		String projectPath = System.getProperty("user.dir");					
		System.setProperty("webdriver.chrome.driver",  "/Volumes/OS/Java/selenium_for_java/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("http://18.224.103.219/");
		driver.findElement(By.linkText("Log in")).click();

		WebElement loginuserName = driver.findElement(By.id("username")); // Username Field
		loginuserName.click();
		loginuserName.clear();
		loginuserName.sendKeys("Admin");
		WebElement loginPassword = driver.findElement(By.id("password")); // Password Field
		loginPassword.click();
		loginPassword.clear();
		loginPassword.sendKeys("Admin123$$");
		Thread.sleep(2000);
		WebElement loginAccount = driver.findElement(By.id("loginbtn"));
		loginAccount.click();
		

		WebElement siteicon = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skip to main content'])[1]/following::button[1]"));
		siteicon.click();
		Thread.sleep(1000);
		
		WebElement siteAdmin = driver.findElement(By.linkText("Site administration"));
		siteAdmin.click();
		WebElement courses = driver.findElement(By.linkText("Courses"));
		courses.click();
		WebElement addCourse = driver.findElement(By.linkText("Add a new course"));
		addCourse.click();
	}
	
	//create the data
	@Test(dataProvider="test1data", groups = {"checkintest", "broken"}, priority =1)
	public void test1(String courseFullName, String courseShortName) throws Exception {
		//System.out.println(username+ " | "+ password);
	
		     
		
		WebElement cFullName = driver.findElement(By.id("id_fullname")); // Username Field
		cFullName.click();
		cFullName.clear();
		cFullName.sendKeys(courseFullName);
		WebElement cShortName = driver.findElement(By.id("id_shortname")); // Password Field
		cShortName.click();
		cShortName.clear();
		cShortName.sendKeys(courseShortName);
		Thread.sleep(2000);
		WebElement saveAndDisplay = driver.findElement(By.id("id_saveanddisplay")); 
		saveAndDisplay.click();
		WebElement returnCourse = driver.findElement(By.linkText("Courses")); 
		returnCourse.click();
		WebElement addANewCourse = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='BvtCategoryII'])[1]/following::button[1]")); 
		addANewCourse.click();
		
	}


	
	
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelPath="/Users/robert/eclipse-workspace/MoodelJavaAutomation/excel/MOCK_DATA.xlsx";
		Object data[][] = testData(excelPath, "data");
		
		return data;
	}
	
	
	public Object[][] testData(String excelPath, String sheetName) {
		
		excelProcessMethod excel = new excelProcessMethod(excelPath, sheetName);
	
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][]= new Object[rowCount-1][colCount];
	
		for(int i=1; i<rowCount;i++) {
			for(int j=0; j<colCount;j++) {
				
				String cellData = excel.getCellDataString(i, j);
				//System.out.println(cellData+ "");
				data[i-1][j]=cellData;
			}
		//System.out.println();
		}
		return data;
	}
	
	
	//clean data
	@AfterTest
	public void teardown(String courseFullName, String courseShortName) throws Exception{
		
		courseFullName = null;
		courseShortName = null;
	
		
		driver.quit();
	}
}