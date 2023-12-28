package utils;

import io.appium.java_client.android.AndroidDriver; 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static void takeScreenshot(AndroidDriver driver, String scenarioName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE); 
            // Define the directory where screenshots will be saved
            Path destination = Paths.get("screenshots", scenarioName + ".png");
            // Create the directories if they don't exist
            Files.createDirectories(destination.getParent());
            // Copy the screenshot to the destination
            Files.copy(source.toPath(), destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
