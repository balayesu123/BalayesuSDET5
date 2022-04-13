package com.POM_Class;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.PropFile_Util;

public class LoginPage { // Rule1 class name should be page name
  
	WebDriver driver;
	// Rule2 @FindBy and @FindBya and @FindByAll annotations used for web elements 
	  
	@FindBy(name="user_name")
	private WebElement usernametextbox;
	
	@FindBy(name="user_password")
	private WebElement passwordtextbox;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	
	// Rule3 create constructor for initialization
	public LoginPage(WebDriver driver)
	{
		//this.driver=driver;
	   PageFactory.initElements(driver,this);
	}
	
	// Rule4 create getter methods for read data

	public WebElement getUsernametextbox() {
		return usernametextbox;
	}

	public WebElement getPasswordtextbox() {
		return passwordtextbox;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	// Rule5 Business logic 
	
	public void logincredentials() throws Exception
	{
	  PropFile_Util propFile_Util = new PropFile_Util();
	  getUsernametextbox().sendKeys(propFile_Util.readdatafrompropfile("UN"));
	  getPasswordtextbox().sendKeys(propFile_Util.readdatafrompropfile("PWD"));
	  getLoginbutton().click();
	}
	
}
