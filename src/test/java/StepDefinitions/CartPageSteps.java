package test.java.StepDefinitions;

import cucumber.api.java.en.When;
//import io.cucumber.java.en.When;
import main.PageObjects.CartPage;
import test.resources.utils.TestContext;

public class CartPageSteps{
	 TestContext testContext;
	 CartPage cartPage;
	 
	 public CartPageSteps(TestContext context) {
		 testContext = context;
		 cartPage = testContext.getPageObjectManager().getCartPage();
	 }
	 
	 @When("^moves to checkout from mini cart$")
	 public void moves_to_checkout_from_mini_cart(){
		 cartPage.clickOn_Cart(testContext.getWait());
		 cartPage.clickOn_ContinueToCheckout(testContext.getWait()); 
	 }
}
