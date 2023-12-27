package pageObjects;

import java.time.Duration; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	
	public BasePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	public void waitUntilElementVisible(WebElement element) { 
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
