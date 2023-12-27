package TCSuite;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities; 
import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;  

public class TCOne { 
	public static final String APP = "/Users/Josue/Downloads/Android-MyDemoAppRN.1.3.0.build-244.apk";
	public static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";
	
	
	public static void main(String[] args) throws Exception {
		 
        DesiredCapabilities capabilities = new DesiredCapabilities();  
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14"); // Set your Android version  
        capabilities.setCapability(MobileCapabilityType.APP, APP); // Set the path to your APK package 
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6 Pro API 34"); // Set the device name
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // Set the automation name);
        
        // Create an AndroidDriver instance
        AndroidDriver driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), capabilities);  
        Thread.sleep(1000);   
        WebElement hamgurger = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]")); 
        Thread.sleep(1000);   
        hamgurger.click(); 
        Thread.sleep(1000);  
        WebElement loginOptionFromHamburger = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]"));
        Thread.sleep(1000);  
        loginOptionFromHamburger.click();
        Thread.sleep(1000); 
        WebElement email = driver.findElement(ByAccessibilityId.accessibilityId("Username input field"));
        Thread.sleep(1000); 
        email.sendKeys("bob@example.com"); 
        WebElement password = driver.findElement(ByAccessibilityId.accessibilityId("Password input field"));
        password.sendKeys("10203040");
        Thread.sleep(1000); 
        WebElement login = driver.findElement(ByAccessibilityId.accessibilityId("Login button"));
        login.click();
        Thread.sleep(1000); 
        driver.quit();  
	}

}
