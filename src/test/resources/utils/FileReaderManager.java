package test.resources.utils;

//import dataProviders.ConfigFileReader;
import test.resources.config.ConfigFileReader;

public class FileReaderManager {

	 private static FileReaderManager fileReaderManager = new FileReaderManager();
	 private static ConfigFileReader configFileReader;
	 private static JsonDataReader jsonDataReader;
	 
	 private FileReaderManager() {
	 }
	 
	 public static FileReaderManager getInstance( ) {
	       return fileReaderManager;
	 }
	 
	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }
	 
	 public JsonDataReader getJsonReader(){
		 return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
	 }
}
