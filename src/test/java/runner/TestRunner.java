package test.java.runner;

import org.junit.runner.RunWith;

//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.Cucumber;	
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features"},
				 glue={"test.java.StepDefinitions"},
				 plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				 monochrome = true)
public class TestRunner {

}