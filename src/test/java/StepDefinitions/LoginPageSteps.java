package test.java.StepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import main.PageObjects.LoginPage;
import test.resources.utils.TestContext;

public class LoginPageSteps{
	 TestContext testContext;
	 LoginPage loginPage;
	 
	 public LoginPageSteps(TestContext context) {
		 testContext = context;
		 loginPage = testContext.getPageObjectManager().getLoginPage();
	 }
	 
	 @When("^User Navigate to LogIn Page$")
	 public void user_Navigate_to_LogIn_Page() throws Throwable {
		 loginPage.navigateToLoginPage(testContext.getWait());
	 }
	 
//	 @When("^User enters UserName and Password$")
//	 public void user_enters_UserName_and_Password() throws Throwable {
//		 //testContext.getLoginPage().log_in("testuser_1", "Test@123");
//		 loginPage.log_in("testuser_1", "Test");
//	 }
	 
	 @When("^User enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_UserName_and_Password(String username, String password) throws Throwable {
		 loginPage.log_in(username, password);
	 }
	 
	 @Then("^Message displayed Login Successfully$")
	 public void message_displayed_Login_Successfully() throws Throwable {
		 System.out.println("Login Successfully");
	 }
	 
	 @When("^User LogOut from the Application$")
	 public void user_LogOut_from_the_Application() throws Throwable {
		 loginPage.log_out();
		 //lPage.log_out();
	 }
	 
	 @Then("^Message displayed LogOut Successfully$")
	 public void message_displayed_LogOut_Successfully() throws Throwable {
		 System.out.println("LogOut Successfully");
	 }
}
