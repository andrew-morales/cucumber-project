package test.java.StepDefinitions;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
import main.PageObjects.HomePage;
import test.resources.utils.TestContext;
//import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageSteps{
	 TestContext testContext;
	 HomePage homePage;
	 
	 public HomePageSteps(TestContext context) {
		 testContext = context;
		 homePage = testContext.getPageObjectManager().getHomePage();
	 }
		 
	 @Given("^user is on Home Page$")
	 public void user_is_on_Home_Page(){
		 homePage.navigateToHomePage(testContext); 
	 }
	 
	 @When("^he search for \"([^\"]*)\"$")
	 public void he_search_for(String product)  {
		 homePage.perform_Search(product);
	 }
}
