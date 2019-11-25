package main.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListingPage{
	 public ProductListingPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
		 
	 @FindBy(how = How.CSS, using = "button.single_add_to_cart_button") 
	 private WebElement btn_AddToCart;
		 
	 @FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
	 private List<WebElement> prd_List; 
	 
	 @FindBy(id="pa_color")
	 private WebElement colorDD;
	 
	 @FindBy(id="pa_size")
	 private WebElement sizeDD;
		 
	 public void clickOn_AddToCart() {
		btn_AddToCart.click();
	 }
		 
	 public void select_Product(int productNumber, WebDriverWait wait) {
		//wait.until(ExpectedConditions.visibilityOfAllElements(prd_List));
		//prd_List.get(productNumber).click();
		 wait.withMessage("Waiting for product to be clickable");
		 wait.until(ExpectedConditions.elementToBeClickable(prd_List.get(productNumber))).click();
	 }	
	 
	 public void selectProdDetails(String colorTxt, String sizeTxt, WebDriverWait wait){
		 wait.withMessage("Waiting for color select to be clickable");
		 wait.until(ExpectedConditions.elementToBeClickable(colorDD));
		 Select colorSelect = new Select(colorDD);
		 Select sizeSelect = new Select(sizeDD);
		 colorSelect.selectByVisibleText(colorTxt);
		 sizeSelect.selectByVisibleText(sizeTxt);
	 }
}
