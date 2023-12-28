package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageMobile;
import utils.ScreenshotUtils;

public class steps {
	 
	public static final String APP = "/Users/Josue/Downloads/Android-MyDemoAppRN.1.3.0.build-244.apk";
	public static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";
	LoginPageMobile loginPage;
	AndroidDriver driver;
	DesiredCapabilities capabilities;
	//ExtentReports 
	ExtentReports extentReports;
	File file;
	ExtentSparkReporter extentSparkReporter; 
    ExtentTest extentTest; 
	 
	
	@Before
	public void setup(Scenario scenario) throws Exception {
		/*   Uncomment this code if you want to use Extent Reports
		 * 
		 * 
		if (extentReports == null) {
            extentReports = new ExtentReports();
            file = new File("./ExtentReport.html");
            extentSparkReporter = new ExtentSparkReporter(file);
            extentReports.attachReporter(extentSparkReporter); 
        }
        */
		
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
	public void teardown(Scenario scenario) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
	    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);  

	    if (scenario.isFailed()) {
	        scenario.attach(screenshot, "image/png", "Taking screenshot on failure...");
	    } else {
	        scenario.attach(screenshot, "image/png", "Screenshot attached");
	    }
		driver.quit();
	} 
	
	// Helper method to log information in Extent Reports
	
	/*
    private void logStep(Status status, String stepName, String details) {
        extentReports.createTest(Thread.currentThread().getStackTrace()[2].getMethodName())
                .log(status, MarkupHelper.createLabel(stepName, ExtentColor.BLUE))
                .log(status, details); 
    }
    */
	
	@Given("I am on the Sauce Demo Mobile App")
	public void onTheSauceDemoMobileApp() {
	//	logStep(Status.INFO, "I am on the Sauce Demo Mobile App", "I am on the Sauce Demo Mobile App"); 
	}
	
	@When("I go to the login page")
	public void goToTheLoginPage() {
	//	logStep(Status.INFO, "Navigate to the login page", "Clicking on hamburger and selecting login option");
		loginPage.clickHamburger();
		loginPage.clickLoginOptionFromHamburger();
	}
	
	@When("I enter username as {string} and the passsword as {string}")
	public void enterUsernameAndPassword(String username, String password) {
	/*	logStep(Status.INFO, 
				"Enter username and password",
                "Entering username: " + username + ", password: " + password); 
    */
		loginPage.enterEmail(username);
		loginPage.enterPassword(password);
	}
	
	@When("I click on the login button")
	public void clickOnTheLoginButton() throws InterruptedException {
	//	logStep(Status.INFO, "Click on the login button", "Clicking on the login button");
		loginPage.clickLogin();
		Thread.sleep(2000);
	}
	
	@Then("I should see the inventory page display")
	public void shouldSeeTheInventoryPageDisplay() {
	/*	logStep(Status.PASS, 
				"Verify inventory page display", 
				"Inventory page is displayed");
	*/
		String currentProductsText = loginPage.getProductsText();
		String expectedProductsText = "sadfsdfsfsdf";
		Assert.assertEquals(expectedProductsText, currentProductsText);
	}
	
	@Then("I should see the login page with incorrect credentials error is display")
	public void shouldSeeTheLoginPageWithIncorrectCredentialsErrorIsDisplay() { 
	/*	logStep(Status.PASS, 
				"Verify incorrect credentials error",
                "Error message is displayed for incorrect credentials");
    */
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
	
	 
