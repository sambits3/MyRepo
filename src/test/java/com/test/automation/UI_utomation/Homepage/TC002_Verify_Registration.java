package com.test.automation.UI_utomation.Homepage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.UI_utomation.TestUtils.Listbox;
import com.test.automation.UI_utomation.pages.Homepage;
import com.test.automation.UI_utomation.testbase.Testbase;

public class TC002_Verify_Registration extends Testbase {
	
	Homepage homepage;
	Listbox list;
	String email=System.currentTimeMillis()+"@gmail.com";
	String firstname="Sambit";
	String lastname="Kumar";
	String password="password";
	
	@BeforeTest
	public void setup(){
		init();
	}
	
	@Test
	public void verify_Regd() throws InterruptedException{
		homepage=new Homepage(driver);
		list=new Listbox(driver);
		homepage.registration(email, firstname, lastname, password);
		
		
	}
	
	
	

}
