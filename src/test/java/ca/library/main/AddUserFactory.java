package ca.library.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserFactory {

	WebDriver driver; 
	
	@FindBy(id="id_username")
	WebElement usernameField;
	
	@FindBy(linkText="Click to enter text")
	WebElement passwordBlockerLink;
	
	@FindBy(id="id_newpassword")
	WebElement passwordField;
	
	@FindBy(xpath="//*[@id=\"id_firstname\"]")
	WebElement firstNameField;
	
	@FindBy(id="id_lastname")
	WebElement lastNameField;
	
	@FindBy(id="id_email")
	WebElement emailField;
	
	@FindBy(id="id_submitbutton")
	WebElement submitButton;
	
	//Constructor
	public AddUserFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Methods 
	public String inputUserName(String username) {
		usernameField.click();
		usernameField.sendKeys(username);
		return username;
	}
	
	public void inputPassword(String password) {
		passwordBlockerLink.click();
		passwordField.click();
		passwordField.sendKeys(password);
	}
	
	public void inputFirstName(String firstName) {
		firstNameField.click();
		firstNameField.sendKeys(firstName);
	}
	
	public void inputlastName(String lastName) {
		lastNameField.click();
		lastNameField.sendKeys(lastName);
	}
	
	public void inputEmail(String email) {
		emailField.click();
		emailField.sendKeys(email);
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public void createUser(String username, String password, String firstName, String lastName, String email) {
		inputUserName(username);
		inputPassword(password);
		inputFirstName(firstName);
		inputlastName(lastName);
		inputEmail(email);
	}

	
}
