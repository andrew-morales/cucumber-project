package main.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage{
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Locate and save page elements for later use
	 @FindBy(linkText="Dismiss")
	 private WebElement dismissLnk;
	 
	 @FindBy(linkText="My Account")
	 private WebElement accountLnk;
	 
	 @FindBy(id="username")
	 private WebElement nameField;
	 
	 @FindBy(id="password")
	 private WebElement passWField;
	 
	 @FindBy(name="login")
	 private WebElement logInBtn;
	 
	 @FindBy(xpath=".//*[@id='account_logout']/a")
	 private WebElement logoutBtn;
	 
	 //Define methods to interact with page elements
	 public void navigateToLoginPage(WebDriverWait wait){
		 wait.until(ExpectedConditions.visibilityOf(dismissLnk)).click();
		 wait.until(ExpectedConditions.visibilityOf(accountLnk)).click();
	 }
	 
	 public void log_in(String uName, String password){
		 nameField.clear();
		 nameField.sendKeys(uName);
		 passWField.clear();
		 passWField.sendKeys(password);
		 logInBtn.click();
	 }
	 
	 public void log_out(){
		 logoutBtn.click();
	 }
}
