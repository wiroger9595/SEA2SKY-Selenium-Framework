package ca.library.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddCourseLibrary {

WebDriver driver; 
	
	@FindBy(id="id_fullname")
	WebElement courseFullName;
	
	@FindBy(id="id_shortname")
	WebElement courseShourName;
	
	
	
	//Constructor
	public AddCourseLibrary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Methods 
	public void inputCourseFullName(String fullName) {
		courseFullName.click();
		courseFullName.sendKeys(fullName);
	}
	
	public void inputCourseShortName(String shortName) {
		courseShourName.click();
		courseShourName.sendKeys(shortName);
	}
	
	public void createUser(String fullName, String shortName) {
		inputCourseFullName(fullName);
		inputCourseShortName(shortName);
		
	}
	
	
}
