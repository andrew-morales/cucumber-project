package test.resources.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
 
import test.resources.config.DriverType;
import test.resources.config.EnvironmentType;

public class ConfigFileReader {
	 private Properties properties;
	 private final String propertyFilePath= "src/test/resources/config/Configuration.properties";
	 //private final String propertyFilePath = System.getProperty("props");
	 
	 public ConfigFileReader(){
		 BufferedReader reader;
		 try {
			 reader = new BufferedReader(new FileReader(propertyFilePath));
			 properties = new Properties();
		 try {
			 properties.load(reader);
			 reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	 
	 public String getDriverPath(){
		 String driverPath = properties.getProperty("driverPath");
		 if(driverPath!= null) return driverPath;
		 else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath"); 
	 }
	 
	 public String getFFDriverPath(){
		 String ffDriverPath = properties.getProperty("firefoxDriverPath");
		 if(ffDriverPath!= null) return ffDriverPath;
		 else throw new RuntimeException("Firefox driver Path not specified in the Configuration.properties file for the firefoxDriverPath"); 
	 }
	 
	 public String getSafariDriverPath(){
		 String SafariDriverPath = properties.getProperty("safariDriverPath");
		 if(SafariDriverPath!= null) return SafariDriverPath;
		 else throw new RuntimeException("Safari driver Path not specified in the Configuration.properties file for the safariDriverPath"); 
	 }
	 
	 public long getImplicitlyWait() { 
		 String implicitlyWait = properties.getProperty("implicitlyWait");
		 if(implicitlyWait != null) {
			 try{
				 return Long.parseLong(implicitlyWait);
			 }catch(NumberFormatException e) {
				 throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			 }
		 }
		 return 30; 
	 }
	 
	 public String getApplicationUrl() {
		 String url;
		 url = properties.getProperty("url");
		 if(url != null) return url;
		 else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	 }
	 
	 public DriverType getBrowser() {
		 String browserName = properties.getProperty("browser");
		 if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		 else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		 else if(browserName.equals("iexplorer")) return DriverType.SAFARI;
		 else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	 }
	 
	 public EnvironmentType getEnvironment() {
		 String environmentName = properties.getProperty("environment");
		 if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		 else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		 else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	 }
	 
	 public Boolean getBrowserWindowSize() {
		 String windowSize = properties.getProperty("windowMaximize");
		 if(windowSize != null) return Boolean.valueOf(windowSize);
		 return true;
	 }
	 
	 public String getReportConfigPath(){
		 String reportConfigPath = properties.getProperty("reportConfigPath");
		 if(reportConfigPath!= null) return reportConfigPath;
		 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
	}
	 
	 public String getImgDir(){
		 String imgDir = properties.getProperty("imgDir");
		 if(imgDir!= null) return imgDir;
		 else throw new RuntimeException("Image Directory not specified in the Configuration.properties file for the Key:imgDir"); 
	}
	 
	public String getScrnCastDir(){
		 String scrnCastDir = properties.getProperty("scrnCastDir");
		 if(scrnCastDir!= null) return scrnCastDir;
		 else throw new RuntimeException("Recording Directory not specified in the Configuration.properties file for the Key:scrnCastDir"); 
	}
	 
	public String getRptDir(){
		 String rptDir = properties.getProperty("rptDir");
		 if(rptDir!= null) return rptDir;
		 else throw new RuntimeException("Report Directory not specified in the Configuration.properties file for the Key:rptDir"); 
	}
	
	public String getTestDataResourcePath(){
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if(testDataResourcePath!= null) return testDataResourcePath;
		else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");		
	}
	
	public String getTestLogPath(){
		String testLogPath = properties.getProperty("testLogPath");
		if(testLogPath!= null) return testLogPath;
		else throw new RuntimeException("Test Log Resource Path not specified in the Configuration.properties file for the Key:testLogPath");
	}
}
