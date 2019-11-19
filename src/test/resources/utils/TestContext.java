package test.resources.utils;

import org.openqa.selenium.support.ui.WebDriverWait;

import main.PageObjects.CartPage;
import main.PageObjects.CheckoutPage;
import main.PageObjects.HomePage;
import main.PageObjects.LoginPage;
import main.PageObjects.ProductListingPage;
import test.resources.utils.PageObjectManager;
import test.resources.utils.WebDriverManager;

public class TestContext {
	 private WebDriverManager driverManager;
	 private PageObjectManager pageObjectManager;
	 private WebDriverWait wait;
	 private ScreenRecordingManager recorderManager;
	 private LoginPage loginPage;
	 private HomePage homePage;
	 private ProductListingPage productListingPage;
	 private CartPage cartPage;
	 private CheckoutPage checkoutPage;
	 
	 public TestContext(){
		 driverManager = new WebDriverManager();
		 pageObjectManager = new PageObjectManager(driverManager.getDriver());
		 wait = driverManager.getWait();
		 recorderManager = new ScreenRecordingManager();
		 
		 //page objects
		 homePage = pageObjectManager.getHomePage();
		 loginPage = pageObjectManager.getLoginPage();
		 productListingPage = pageObjectManager.getProductListingPage();
		 cartPage = pageObjectManager.getCartPage();
		 checkoutPage = pageObjectManager.getCheckoutPage();
	 }
	 
	 //get methods
	 public WebDriverManager getWebDriverManager() {
		 return driverManager;
	 }
	 
	 public ScreenRecordingManager getRecorderManager(){
		 return recorderManager;
	 }
	 
	 public PageObjectManager getPageObjectManager() {
		 return pageObjectManager;
	 }
	 
	 public WebDriverWait getWait() {
		 return wait;
	 }
	 
	 public HomePage getHomepage() {
		 return homePage;
	 }
	 
	 public LoginPage getLoginPage() {
		 return loginPage;
	 }
	 
	 public ProductListingPage getProdListingPage() {
		 return productListingPage;
	 }
	 
	 public CartPage getCartPage() {
		 return cartPage;
	 }
	 
	 public CheckoutPage getCheckoutPage() {
		 return checkoutPage;
	 }
}
