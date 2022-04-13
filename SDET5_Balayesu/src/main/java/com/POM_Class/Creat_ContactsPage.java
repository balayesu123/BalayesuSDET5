package com.POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creat_ContactsPage { // Rule1 class name should be page name
   
	WebDriver driver;
	// Rule2 @FindBy and @FindBya and @FindByAll annotations used for web elements
	
	@FindBy(name="salutationtype")
	private WebElement ContSelByValDD;
	
	@FindBy(name="firstname")
	private WebElement contactFirstNmTxtb;
	
	@FindBy(name="lastname")
	private WebElement contactLoststNmTxtb;
	
	@FindBy(css="img[title='Select']")
	private WebElement selectOrgNmInCnts;
	
	@FindBy(name="button")
	private WebElement savebtn;


			// Rule3 create constructor for initialization
			public  Creat_ContactsPage(WebDriver driver)
			{
				  this.driver=driver;
			   PageFactory.initElements(driver,this);
			}
			
			// Rule4 create getter methods for read data
			

			public WebElement getSelectDD() {
				return ContSelByValDD;
			}

			public WebElement getContactFirstNmTxtb() {
				return contactFirstNmTxtb;
			}

			public WebElement getContactLoststNmTxtb() {
				return contactLoststNmTxtb;
			}

			public WebElement getSelectOrgNmInCnts() {
				return selectOrgNmInCnts;
			}
			
			public WebElement getSavebtn() {
				return savebtn;
			}
			
			
}
