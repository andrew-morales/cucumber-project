package main.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage{
	 public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	 }
		 
	 @FindBy(how = How.CSS, using = ".cart-button") 
	 private WebElement btn_Cart;
		 
	 @FindBy(how = How.CSS, using = ".checkout-button.alt") 
	 private WebElement btn_ContinueToCheckout;
		 	 
	 public void clickOn_Cart(WebDriverWait wait) {
		 wait.withMessage("Waiting for cart button to be clickable");
		 //wait.until(ExpectedConditions.elementToBeClickable(btn_Cart)).click();
		 //btn_Cart.click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cart-button")));
		 wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(btn_Cart)));
		 btn_Cart.click();
	 }
		 
	 public void clickOn_ContinueToCheckout(WebDriverWait wait){
		 wait.withMessage("Waiting for continue to checkout button to be clickable");
		 wait.until(ExpectedConditions.elementToBeClickable(btn_ContinueToCheckout)).click();
//		 btn_ContinueToCheckout.click();
//		 try { Thread.sleep(5000);}
//		 catch (InterruptedException e) {}
	 }
}
