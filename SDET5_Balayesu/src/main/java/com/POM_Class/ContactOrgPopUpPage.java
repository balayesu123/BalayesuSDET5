package com.POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactOrgPopUpPage { // Rule1 class name should be page name
	 
	WebDriver driver;

	// Rule2 @FindBy and @FindBya and @FindByAll annotations used for web elements
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchorgtxtfld;

	@FindBy(xpath="//input[@name='search']")
	private WebElement searchbtn;

	@FindBy(id="1")
	private WebElement selectorg;
	
	// Rule3 create constructor for initialization
	
	public ContactOrgPopUpPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Rule4 create getter methods for read data

	public WebElement getSearchorgtxtfld() {
		return searchorgtxtfld;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSelectorg() {
		return selectorg;
	}
	
	public void searchandselectforOrg(String orgname) throws Exception
	{
		getSearchorgtxtfld().sendKeys(orgname);
		getSearchbtn().click();
		Thread.sleep(3000);
		getSelectorg().click();
		
	}
}
