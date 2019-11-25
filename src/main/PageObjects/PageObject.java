package main.PageObjects;
//package PageObjects;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import io.cucumber.core.api.Scenario;
//import src.test.resources.utils.WebDriverManager;
//
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class PageObject {
////	public static WebDriver driver;
////	public static WebDriverWait wait;
//	public WebDriverManager webDriverManager = new WebDriverManager();
//	public WebDriver driver = webDriverManager.getDriver();
//	public WebDriverWait wait = webDriverManager.getWait();
//	
//	public WebDriver getWebDriver(){
//		return driver;
//	}
//	
//	public PageObject(){
//	}	
//	
//	public void BtnClick(String btnLocator, String targetAttribute){
//		if(targetAttribute.equals("name")){
//			driver.findElement(By.name(btnLocator)).click();
//		}
//		else if(targetAttribute.equals("id")){
//			driver.findElement(By.id(btnLocator)).click();
//		}
//		else if(targetAttribute.equals("text")){
//			driver.findElement(By.linkText(btnLocator));
//		}
//		
//	}
//	
//	public void enterTxt(String fieldLocator, String txtValue, String attribute){
//		if(attribute.equals("name")){
//			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(fieldLocator))));
//			driver.findElement(By.name(fieldLocator)).clear();
//			driver.findElement(By.name(fieldLocator)).sendKeys(txtValue);
//		}
//		else if(attribute.equals("id")){
//			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(fieldLocator))));
//			driver.findElement(By.id(fieldLocator)).clear();
//			driver.findElement(By.id(fieldLocator)).sendKeys(txtValue);
//		}
//	}
//	
//	public void getScreenShotOnFail(Scenario scenario){
//    	final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    	scenario.embed(screenshot, "image/png"); //stick it in the report
//	}
//	//@After
//	public void quitWebDriver(){
//		driver.quit();
//	}
//}
