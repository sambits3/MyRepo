package com.test.automation.UI_utomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	public static final Logger log=Logger.getLogger(Homepage.class.getName());
	WebDriver driver;
	
	@FindBy(xpath=".//*[@class='login']")
	WebElement signIn;
	
	@FindBy(xpath=".//*[@id='email']")
	WebElement loginEmailID;
	
	@FindBy(xpath=".//*[@id='passwd']")
	WebElement loginpasswd;
	 
	@FindBy(xpath=".//*[@id='SubmitLogin']")
	WebElement submitlogin;
	
	@FindBy(xpath=".//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailed;
	
	@FindBy(xpath=".//*[@id='email_create']")
	WebElement create_email;
	
	@FindBy(xpath=".//*[@id='SubmitCreate']")
	WebElement submit;
	
	@FindBy(xpath=".//*[@value='1']")
	WebElement gender;
	
	@FindBy(xpath=".//*[@id='customer_firstname']")
	WebElement firstname;
	
	@FindBy(xpath=".//*[@id='customer_lastname']")
	WebElement lastname;
	
	@FindBy(xpath=".//*[@id='passwd']")
	WebElement password;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="years")
	WebElement years;
	
	public Homepage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void loginApplication(String emailaddress, String password){
		signIn.click();
		log.info("click to "+signIn.toString());
		loginEmailID.sendKeys(emailaddress);
		log.info("enter emailaddress "+emailaddress);
		loginpasswd.sendKeys(password);  
		log.info("enter password "+password);
		submitlogin.click();
		log.info("click to "+submitlogin);
	}
	
	public String getinvalidlogintext(){
		log.info("error message is"+authenticationFailed.getText());
		return authenticationFailed.getText();
		
	}
	
	public void registration(String email, String firstname, String lastname, String password) throws InterruptedException {
		signIn.click();
		create_email.sendKeys(email);
		submit.click();
		gender.click();
		this.firstname.sendKeys(firstname);
		this.lastname.sendKeys(lastname);
		this.password.sendKeys(password);
	
		
			
		
		
		
	}
}












