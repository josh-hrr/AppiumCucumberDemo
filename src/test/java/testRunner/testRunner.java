package testRunner;

import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
	@RunWith(Cucumber.class)
	@CucumberOptions(
        features= {"src/test/java/Features/TCLoginMobile.feature"},
        glue="stepDefinitions",
        plugin= {
        		"pretty", "html:reports/myreport.html", 
        		"json:reports/myreport.json"
        		},    //Mandatory to capture failures
        dryRun=true,
        monochrome=true 
      )
	public class testRunner { 
	}  
