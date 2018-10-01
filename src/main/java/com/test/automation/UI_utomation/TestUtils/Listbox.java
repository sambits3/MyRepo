package com.test.automation.UI_utomation.TestUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Listbox {

	Select sel;
	WebDriver driver;
	
	public Listbox(WebDriver driver){
		
		this.driver=driver;
	}
	
	public void select(int i,WebElement ele){
		sel=new Select(ele);
		sel.selectByIndex(i);
	}
	
	public void select(String value, WebElement ele){
		sel=new Select(ele);
		sel.selectByValue(value);
	}
	
	public void deSelect(int i,WebElement ele){
		sel=new Select(ele);
		sel.deselectByIndex(i);
	}
	
	public void deSelect(String value,WebElement ele){
		sel=new Select(ele);
		sel.deselectByValue(value);
	}
}

