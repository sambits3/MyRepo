package com.test.automation.UI_utomation.Homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.UI_utomation.pages.Homepage;
import com.test.automation.UI_utomation.testbase.Testbase;



public class TC001_Verify_LogIn extends Testbase{

	static final Logger log=Logger.getLogger(TC001_Verify_LogIn.class.getName());
    
     Homepage homepage;
     String email="test@gmail.com";
     String password="password123";

	@BeforeTest
	public void setup(){
	   init();
	    
	}
		
	
	
	

	//login with invalid credential
	@Test
	public void verifyLogin(String email, String password){ 
		//log.info("=====Starting Test========");
		homepage =new Homepage(driver);
		homepage.loginApplication(email, password) ;
		
		Assert.assertEquals(homepage.getinvalidlogintext(),"Authentication is failed.");
		//log.info("====Ending Test=======");
		
		
		
	}
	
	
	
}
