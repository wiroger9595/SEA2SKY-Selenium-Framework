package ca.moodle.test.resource;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
	* Methods designed to be used in tests of Moodle's User, Course, Course Category, and Enrollment components.
	*/

public class MoodleBVTQuickNavMethods {
	
	public static void navigatetoBrowseListOfUsers(WebDriver driver) {
		
		driver.findElement(By.linkText("Site administration")).click();		
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.linkText("Browse list of users")).click();
		
	}
	public static void navigatetoManageCoursesAndCategories(WebDriver driver) {
		
		driver.findElement(By.linkText("Site administration")).click();		
		driver.findElement(By.linkText("Courses")).click();
		driver.findElement(By.linkText("Manage courses and categories")).click();
	
		
	}
	
	public static void navigatetoManageEnrolledUsers(WebDriver driver, String categoryName, String courseName) {
		
		driver.findElement(By.linkText("Site administration")).click();		
		driver.findElement(By.linkText("Courses")).click();
		driver.findElement(By.linkText("Manage courses and categories")).click();
		driver.findElement(By.linkText(categoryName)).click();
		driver.findElement(By.linkText(courseName)).click();
		driver.findElement(By.linkText("Enrolled users")).click();
		
		
	}
}
