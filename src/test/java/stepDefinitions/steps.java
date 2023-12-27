package stepDefinitions;

import java.net.URL; 
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities; 
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageMobile;

public class steps {
	 
	public static final String APP = "/Users/Josue/Downloads/Android-MyDemoAppRN.1.3.0.build-244.apk";
	public static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";
	LoginPageMobile loginPage;
	AndroidDriver driver;
	DesiredCapabilities capabilities;
	
	@Before
	public void setup() throws Exception {
		capabilities = new DesiredCapabilities();  
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14"); // Set your Android version  
        capabilities.setCapability(MobileCapabilityType.APP, APP); // Set the path to your APK package 
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6 Pro API 34"); // Set the device name
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // Set the automation name);
        
        // Create an AndroidDriver instance
        driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), capabilities); 
        loginPage = new LoginPageMobile(driver);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Given("I am on the Sauce Demo Mobile App")
	public void onTheSauceDemoMobileApp() {
		// No action needed, already being executed in the Before hook
	}
	
	@When("I go to the login page")
	public void goToTheLoginPage() {
		loginPage.clickHamburger();
		loginPage.clickLoginOptionFromHamburger();
	}
	
	@When("I enter username as {string} and the passsword as {string}")
	public void enterUsernameAndPassword(String username, String password) {
		loginPage.enterEmail(username);
		loginPage.enterPassword(password);
	}
	
	@When("I click on the login button")
	public void clickOnTheLoginButton() throws InterruptedException {
		loginPage.clickLogin();
		Thread.sleep(2000);
	}
	
	@Then("I should see the inventory page display")
	public void shouldSeeTheInventoryPageDisplay() {
		String currentProductsText = loginPage.getProductsText();
		String expectedProductsText = "Products";
		Assert.assertEquals(currentProductsText, expectedProductsText);
	}
	
	@Then("I should see the login page with incorrect credentials error is display")
	public void shouldSeeTheLoginPageWithIncorrectCredentialsErrorIsDisplay() { 
		Assert.assertTrue(loginPage.isErrorMessageLoginDisplayed());
	}
	
	@Then("I should see {string}")
	public void shouldSeeExpectedResult(String expectedResult) { 
		switch(expectedResult) {
			case "the inventory page display":  
				shouldSeeTheInventoryPageDisplay();
				break;
			case "the login page with incorrect credentials error is display":
				shouldSeeTheLoginPageWithIncorrectCredentialsErrorIsDisplay();
				break;
			}
		}
	}
	
	 
