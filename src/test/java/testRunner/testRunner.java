package testRunner;

import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
	@RunWith(Cucumber.class)
	@CucumberOptions(   
        features= {"src/test/java/Features/TCLoginMobile.feature"},
        glue="stepDefinitions",
        plugin= { 
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        		},     
        dryRun=false,
        monochrome=true 
      )
	public class testRunner { 
	}  
