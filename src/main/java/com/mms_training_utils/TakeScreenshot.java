package com.mms_training_utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mms_training_basepage.TestBase;

public class TakeScreenshot extends TestBase {
	String screenshotPath = "target"+File.separator+"Screenshots";
	
public void takeScreenShotForCucumber(String screenshotFileName){
    	
    	File file = new  File(System.getProperty("user.dir")+File.separator+screenshotPath);
    	if(!file.isDirectory())
    		file.mkdir();
    	 File scrFile = ((TakesScreenshot) driver)
                 .getScreenshotAs(OutputType.FILE);
    	 String saveImgFile = System.getProperty("user.dir") +File.separator+ screenshotPath +File.separator+ "Failure_Screenshot_"+screenshotFileName+".jpg";
    	 System.out.println("Save Image File Path : " + saveImgFile);
         try {
			FileUtils.copyFile(scrFile, new File(saveImgFile));
		} catch (IOException e) {
			System.out.println("Error in saving file");
			e.printStackTrace();
		}
    	
    }

}
