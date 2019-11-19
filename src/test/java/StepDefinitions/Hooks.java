package test.java.StepDefinitions;

//import io.cucumber.core.api.Scenario;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.AfterStep;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import test.resources.utils.TestContext;
import cucumber.api.java.AfterStep;

public class Hooks {
	TestContext testContext;
	 
	 public Hooks(TestContext context) {
		 testContext = context;
	 }
	 
	 @Before
	 public void BeforeSteps(Scenario scenario) {
		 //testContext.getRecorderManager().startRecording(scenario);
	 }
	 
	 @After
	 public void AfterScenario(Scenario scenario) {
		 //testContext.getRecorderManager().stopRecording();
		 if(scenario.getStatus().toString().equals("PASSED")){
			 testContext.getWebDriverManager().exitOnPass(scenario); 
		 }
//		 else if(scenario.isFailed()){
//			 testContext.getWebDriverManager().exitOnFail(scenario);
//		 }
		 //testContext.getWebDriverManager().getDriver().quit();
	 }
	 
	 @AfterStep
	 public void AfterStep(Scenario scenario){
		 if(scenario.isFailed()) {
			 //testContext.getRecorderManager().stopRecording();
			 testContext.getWebDriverManager().exitOnFail(scenario);
		 }
	 }
}
