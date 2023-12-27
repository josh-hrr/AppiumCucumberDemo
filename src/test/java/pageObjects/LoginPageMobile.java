package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPageMobile extends BasePage{
	public LoginPageMobile(AndroidDriver driver) {
		super(driver);
	}	  
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"open menu\"]")
	WebElement hamgurger;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"menu item log in\"]")
	WebElement loginOptionFromHamburger;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"Username input field\"]")
	WebElement email;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"Password input field\"]")
	WebElement password;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Login button\"]")
	WebElement login;   
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Products\"]")
	WebElement productsText;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Provided credentials do not match any user in this service.\"]")
	WebElement errorMessageLogin;
	
	public void clickHamburger() {
		super.waitUntilElementVisible(hamgurger);
		hamgurger.click();
	} 
	public void clickLoginOptionFromHamburger() {
		super.waitUntilElementVisible(loginOptionFromHamburger);
		loginOptionFromHamburger.click();
	} 
	public void enterEmail(String email) {
		super.waitUntilElementVisible(this.email);
		this.email.sendKeys(email);
	} 
	public void enterPassword(String password) {
		super.waitUntilElementVisible(this.password);
		this.password.sendKeys(password);
	} 
	public void clickLogin() {
		super.waitUntilElementVisible(login);
		login.click();
	}  
	
	public boolean isProductsTextDisplayed() {
		super.waitUntilElementVisible(productsText);
		return productsText.isDisplayed();
	}
	
	public String getProductsText() {
		super.waitUntilElementVisible(productsText);
		return productsText.getText();
	}
	
	public boolean isErrorMessageLoginDisplayed() {
		super.waitUntilElementVisible(errorMessageLogin);
		return errorMessageLogin.isDisplayed();
	}
	
	public void login(String email, String password) {
		clickHamburger();
		clickLoginOptionFromHamburger();
		enterEmail(email);
		enterPassword(password);
		clickLogin();
	} 
}
