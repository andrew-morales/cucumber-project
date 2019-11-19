package test.resources.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
//import io.cucumber.core.api.Scenario;
//import test.resources.config.DriverType;
//import test.resources.config.EnvironmentType;

public class WebDriverManager {
	 private WebDriver driver;
	 private WebDriverWait wait;
	 private ChromeOptions options = new ChromeOptions();
	 //private static DriverType driverType;
	 //private static EnvironmentType environmentType;
	 private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	 private static final String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";
	 private static final String SAFARI_DRIVER_PROPERTY = "webdriver.safari.driver";
	 
	 private static String driverType;
	 private static String environmentType;
	 
	// private DesiredCapabilities chromeCaps = DesiredCapabilities.chrome();
	 
	 //read configurations
	 public WebDriverManager() {
		 //driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		 //environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
		 
		 driverType = System.getProperty("browser").toUpperCase();
		 environmentType = System.getProperty("env").toUpperCase();
	 }
	 
	 //if webdriver is null create one, other wise return existing
	 public WebDriver getDriver() {
		 if(driver == null) driver = createDriver();
		 return driver;
	 }
	 
	 public WebDriverWait getWait(){
		 return (wait == null) ? wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait()) : wait;
	 }
	 
	 private WebDriver createDriver() {
	    switch (environmentType) {     
	         case "LOCAL" : driver = createLocalDriver();
	         break;
	         case "REMOTE" : driver = createRemoteDriver();
	         break;
	         default : System.out.println("environment option is invalid");
	    }
	    return driver;
	 }
	 
	 private WebDriver createRemoteDriver() {
		 //throw new RuntimeException("RemoteWebDriver is not yet implemented");
		 
		String completeUrl = null;
		
		//set default hose and browser
		String host = "localhost";
		DesiredCapabilities dc;
		
		//check for user inputed browser and host
		if(driverType != null && driverType.equals("FIREFOX")){
			dc = DesiredCapabilities.firefox();
		}
		else{
			dc = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.logfile", FileReaderManager.getInstance().getConfigReader().getTestLogPath() + "chromeLog.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			options.addArguments("--no-sandbox");
			dc.setCapability(ChromeOptions.CAPABILITY, options);
		}
		
		//figure out how this fits new setup
		//**********************************
		if(System.getProperty("HUB_HOST") != null){
			host = System.getProperty("HUB_HOST");
		}
		
		//set full grid url
		completeUrl = "http://" + host + ":4444/wd/hub";
		
		try {
			//where grid is running is your url
			//options.addArguments("--no-sandbox");
			driver = new RemoteWebDriver(new URL(completeUrl), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver;
	 }
	 
	 private WebDriver createLocalDriver() {
	       switch (driverType) {     
	        case "FIREFOX" : 
	        	System.setProperty(GECKO_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getFFDriverPath());
	        	driver = new FirefoxDriver();
	        break;
	        case "CHROME" : 
	        	 System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
	     		 options.addArguments("disable-infobars");
	    		 options.addArguments("start-maximized");
	    		 //options.setHeadless(true);
	    		 //driver.manage().window().maximize();
	    		 //chromeCaps.setCapability(ChromeOptions.CAPABILITY, options);
	    		 driver = new ChromeDriver(options);
	        break;
	        case "SAFARI" : 
	        	System.setProperty(SAFARI_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getSafariDriverPath());
	        	driver = new InternetExplorerDriver();
	        break;
	       }
	       return driver;
	 } 
	 
	 //capture a screen shot and save to the report on a failed test case
	 public void exitOnFail(Scenario scenario) {
		 if(driver.toString() != null){
			 getScreenShotOnFail(scenario);
			 //embedVideo(scenario);
			 //driver.close();
			 driver.quit();
		 }
		 else{
			 System.out.println("*************\nThere is no driver session to close\n******************");
		 }
	 }
	 
	 //////////////////////////////////////////////
	 //TO DO
	 //Delete the test recording if the test passed
	 //////////////////////////////////////////////
	 public void exitOnPass(Scenario scenario){
		 System.out.println("Scenario status is: " + scenario.getStatus().toString());
		 if(driver != null){
			 if(scenario.getStatus().toString().equalsIgnoreCase("PASSED")){
				 //driver.close();
				 driver.quit();
			 } 
		 }
		 else{
			 System.out.println("*************\nThere is no driver session to close\n******************");
		 }
	 }
	 
	 public void getScreenShotOnFail(Scenario scenario){
	     final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	     scenario.write("Error screen shot from faild scenario :" + scenario.getName());
	     scenario.embed(screenshot, "image/png"); //stick it in the report
	 } 
	 
	 public void embedVideo(Scenario scenario){
		 DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		 Date date = new Date();	
		 String fileName = scenario.getName().replaceAll(" ", "_");
		 File sourceVid = new File(FileReaderManager.getInstance().getConfigReader().getScrnCastDir() + fileName + "_" + dateFormat.format(date) + ".mov"); 
		 byte[] bArray = readFileToByteArray(sourceVid);
		 
		 scenario.write("Error video from failed scenario: " + scenario.getName());
//		 scenario.embed(bArray, "video/quicktime");
		 scenario.embed(bArray, "video/mp4");
	 }
	 
	 public static byte[] readFileToByteArray(File sourceVid){
		 FileInputStream fis = null;
		 byte[] bArray = new byte[(int) sourceVid.length()];
		 try{
			 fis = new FileInputStream(sourceVid);
			 fis.read(bArray);
			 fis.close();
		 }catch (IOException e){
			 e.printStackTrace();
		 }
		 return bArray;		 
	 }
//	 public void getScreenShotOnFail2(Scenario scenario){
//         //below line is just to append the date format with the screenshot name to avoid duplicate names 
//         String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//         TakesScreenshot ts = (TakesScreenshot) driver;
//         File source = ts.getScreenshotAs(OutputType.FILE);
//         //after execution, you could see a folder "FailedTestsScreenshots" under src folder
//         //String destination = "target/test-output/screenshots/"+ scenario.getName().toString() + dateName+".png";
//         String destination = FileReaderManager.getInstance().getConfigReader().getImgDir().toString() + dateName + ".png";
//         File finalDestination = new File(destination);
//         try {
//			FileUtils.copyFile(source, finalDestination);
//			System.out.println("***************\nScreenshot name: " + finalDestination.getName() + "\nScreenshot path: " + finalDestination.getAbsolutePath() + "\ncannocial path: " + finalDestination.getCanonicalPath());
//			Reporter.addScreenCaptureFromPath(finalDestination.getPath());
//		 } catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		 }
//	 }
}