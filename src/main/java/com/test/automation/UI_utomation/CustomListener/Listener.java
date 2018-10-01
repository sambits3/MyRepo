package com.test.automation.UI_utomation.CustomListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.automation.UI_utomation.testbase.Testbase;

public class Listener extends Testbase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailure(ITestResult result) {
		   Calendar calendar=Calendar.getInstance();
		   SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		   
		   String methodname=result.getName();
		   
		   if(!result.isSuccess()){
		   
		   File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   
		   try {
			   String directory=new File(System.getProperty("user.dir"))+"/src/main/java/com/test/automation/UI_utomation/screenshot/";
			   File destfile=new File(directory +methodname+"_"+formater.format(calendar.getTime())+".png");
			   FileUtils.copyFile(srcfile, destfile);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}	   
	}

		   
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
