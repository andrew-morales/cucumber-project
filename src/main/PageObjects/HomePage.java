package main.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import test.resources.utils.FileReaderManager;
import test.resources.utils.TestContext;

public class HomePage{
	public String url = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void perform_Search(String search) {
		driver.navigate().to(url + "?" + search + "&post_type=product");
	}
		 
	public void navigateToHomePage(TestContext context){
		//driver.get(url);
		context.getWebDriverManager().getDriver().get(url);
	}
}
