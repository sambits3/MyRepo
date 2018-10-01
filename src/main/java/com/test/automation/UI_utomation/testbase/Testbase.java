package com.test.automation.UI_utomation.testbase;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Testbase {
   
	public static final Logger log=Logger.getLogger(Testbase.class.getName());
	
	public static WebDriver driver;
	String browser="chrome";
	String url="http://automationpractice.com/index.php";
	public static ExtentReports report;
	public static ExtentTest test;
	public ITestResult result;
	
	public void init(){
		
		report=new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/test/automation/UI_utomation/Extentreport/test.html",false);
		selectBrowser(browser);
		getUrl(url);
		String log4jconfigpath="log4j.properties";
		PropertyConfigurator.configure(log4jconfigpath);
	}
	
	
	public void selectBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
			log.info("creating object of"+browser);
			driver= new ChromeDriver();
		}
	}	
		
		
	
   public void getUrl(String url) {
	   log.info("lunchingurl of"+url);
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	}
   
   
   public void getScreenshot(){
	   Calendar calendar=Calendar.getInstance();
	   SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	   
	   File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   try {
		String directory=new File(System.getProperty("user.dir")).getAbsolutePath() +"/src/main/java/com/test/automation/UI_utomation/screenshot/";
		   File destfile=new File((String)directory + "_"+formater.format(calendar.getTime())+".png");
		   FileUtils.copyFile(srcfile, destfile);
	} catch (Exception e) {
			e.printStackTrace();
	}
   }
   
   public void getResult(ITestResult result){
	  if(result.getStatus()==ITestResult.SUCCESS){
		  test.log(LogStatus.PASS,result.getName()+" result is pass");
	  }
	  else if(result.getStatus()==ITestResult.SKIP){
		  test.log(LogStatus.SKIP,result.getName()+" result is skip & reason is "+result.getThrowable());
	  }
	  else if(result.getStatus()==ITestResult.FAILURE){
		  test.log(LogStatus.ERROR,result.getName()+" result got failed & reason is "+result.getThrowable());
		 // test.log(LogStatus.FAIL, test.addScreenCapture(getScreenshot("")));
	  }
	  else if(result.getStatus()==ITestResult.STARTED){
		  test.log(LogStatus.INFO,result.getName()+" test started ");
	  }
   }
   
   
   @BeforeMethod
   public void beforeMethod(Method result){
	   test=report.startTest(result.getName());
	   test.log(LogStatus.INFO,result.getName()+" test started");
   }
   
   @AfterMethod
   public void afterMethod(ITestResult result){
	   getResult(result);
	   
   }
   

	@AfterClass
	public void endtest(){
		driver.quit();
		log.info("browser closed.");
		report.endTest(test);
		report.flush();
	}
   
}
