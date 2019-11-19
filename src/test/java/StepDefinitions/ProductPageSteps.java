package test.java.StepDefinitions;

import cucumber.api.java.en.When;
//import io.cucumber.java.en.When;
import main.PageObjects.ProductListingPage;
import test.resources.utils.TestContext;

public class ProductPageSteps{
	 TestContext testContext;
	 ProductListingPage productListingPage;
	 
	 public ProductPageSteps(TestContext context) {
		 testContext = context;
		 productListingPage = testContext.getPageObjectManager().getProductListingPage();
	 }
	 
	 @When("^choose to buy the first item$")
	 public void choose_to_buy_the_first_item() {
		 productListingPage.select_Product(0, testContext.getWait());
		 testContext.getProdListingPage().selectProdDetails("Beige", "Medium", testContext.getWait());
		 productListingPage.clickOn_AddToCart(); 
	 }
}
