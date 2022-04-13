package com.POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.WebDriverUtils;

public class ContactInfoPage {  // Rule1 class name should be page name
	WebDriver driver;
	
	// Rule2 @FindBy and @FindBya and @FindByAll annotations used for web elements

	@FindBy(xpath="//img[@title='Create Contact...']")   
	private WebElement createContacts;
	
	@FindBy(name="search_text")
	private WebElement searchcontacttxtfld;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchforcontactDD;

	@FindBy(name="submit")
	private WebElement searchcontactbtn;
	
	@FindBy(xpath="//span[@vtfieldname='firstname']/..")
	private WebElement getTextOrgFirstName;
	
	@FindBy(xpath="//span[@vtfieldname='lastname']/..")
    private WebElement getTextOrgLastName;		
	

		// Rule3 create constructor for initialization
		public ContactInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		// Rule4 create getter methods for read data

	public WebElement getcreateContacts() {
		return createContacts;
	}

	public WebElement getSearchcontacttxtfld() {
		return searchcontacttxtfld;
	}
	
	public WebElement getSearchforcontactDD() {
		return searchforcontactDD;
	}

	public WebElement getSearchcontactbtn() {
		return searchcontactbtn;
	}
	
	public WebElement getgetTextOrgName() {
		return getTextOrgFirstName;
	}
	
	public WebElement getGetTextOrgLastName() {
		return getTextOrgLastName;
	}
	
      public void checkcontactcreated(String contactname,String text)
      {
    	  getSearchcontacttxtfld().sendKeys(contactname);
    	  WebDriverUtils driverUtils=new  WebDriverUtils(driver);
    	  driverUtils.selectbyvisibleText(text, getSearchforcontactDD());
    	  getSearchcontactbtn().click();
    	  
      }
	
}
