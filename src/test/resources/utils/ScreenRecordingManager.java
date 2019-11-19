package test.resources.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import cucumber.api.Scenario;
//import io.cucumber.core.api.Scenario;

public class ScreenRecordingManager {
	ATUTestRecorder recorder;
	
	public void startRecording(Scenario scenario){
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		Date date = new Date();
		String vidDir = FileReaderManager.getInstance().getConfigReader().getScrnCastDir();
		//String directoryName = vidDir.concat(this.getClass().getName());
		File dir = new File(vidDir);
		//Created object of ATUTestRecorder
		//Provide path to store videos and file name format.
//		recorder = new ATUTestRecorder("target/test-output/videos","TestVideo-"+dateFormat.format(date),false);
		  
		//Check if video directory exist if not create it
		if(!dir.exists()){
			dir.mkdir();
		}
		try {
		  String fileName = scenario.getName().replaceAll(" ", "_");
		  recorder = new ATUTestRecorder(FileReaderManager.getInstance().getConfigReader().getScrnCastDir(), fileName + "_" +dateFormat.format(date),false);
		  recorder.start();
		} catch (ATUTestRecorderException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		}  
	}
	
	public void stopRecording(){
		try {
			recorder.stop();
		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}