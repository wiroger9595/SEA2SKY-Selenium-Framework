package ca.library.main;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sendKeyFunction {
public static void Id(WebDriver driver, String id, String typeID) {
	
		driver.findElement(By.id(id)).click();
		driver.findElement(By.id(id)).clear();
		driver.findElement(By.id(id)).sendKeys(typeID);
	}
}
