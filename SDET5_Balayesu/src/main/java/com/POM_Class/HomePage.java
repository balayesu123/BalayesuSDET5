package com.POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.WebDriverUtils;

public class HomePage { // Rule1 class name should be page name
	  
	WebDriver driver;
	// Rule2 @FindBy and @FindBys and @FindByAll annotations used for web elements
	
	@FindBy(xpath="//input[@value='Search...']")
	private WebElement searchbox;
	
	@FindBy(className="searchBtn")
	private WebElement searchbutton;
	
	@FindBy(xpath="//td[@class='tabUnSelected']/../td[6]/a")
	private WebElement orgModule;
	
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement ContactsModule;
	

	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement logoutIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOut;
	
	// Rule3 create constructor for initialization
		public HomePage(WebDriver driver)
		{
			this.driver=driver;
		   PageFactory.initElements(driver,this);
		}
		
		// Rule4 create getter methods for read data

		public WebElement getSearchbox() {
			return searchbox;
		}

		public WebElement getSearchbutton() {
			return searchbutton;
		}

		public WebElement getOrgModule() {
			return orgModule;
		}

		

		public WebElement getContactsModule() {
			return ContactsModule;
		}

		

		public WebElement getLogoutIcon() {
			return logoutIcon;
		}

		public WebElement getSignOut() {
			return signOut;
		}

		
		//Rule 5: Business Library
		public void logoutfromApp() 
		{
			getLogoutIcon().click();
			getSignOut().click();
		}
		
		
}
