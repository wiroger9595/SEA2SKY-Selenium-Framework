package ca.library.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFrontPgae {

	WebDriver driver;

	@FindBy(linkText = "Log in")
	WebElement linkToLogInPage;
	
	@FindBy(id = "Username")
	WebElement Username;
	

	public LoginFrontPgae(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLink() {
		linkToLogInPage.click();
	}
}
