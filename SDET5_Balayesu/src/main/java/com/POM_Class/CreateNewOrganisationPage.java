package com.POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganisationPage {  // Rule1 class name should be page name
    
	WebDriver driver;
	// Rule2 @FindBy and @FindBya and @FindByAll annotations used for web elements
	
	@FindBy(name="accountname")
	private WebElement OrganisationName;
	
	@FindBy(name="industry")
	private WebElement OrgIndustrySelByValDD;
	
	@FindBy(name="rating")
	private WebElement OrgRatingSelByValDD;
	
	@FindBy(name="accounttype")
	private WebElement OrgTypeSelByValDD;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement Savebutton;
	 
		// Rule3 create constructor for initialization
		public CreateNewOrganisationPage(WebDriver driver)
		{
			this.driver=driver;
		   PageFactory.initElements(driver,this);
		}
		
		// Rule4 create getter methods for read data
		

		public WebElement getOrganisationName() {
			return OrganisationName;
		}

		public WebElement getOrgIndustrySelByValDD() {
			return OrgIndustrySelByValDD;
		}

		public WebElement getOrgRatingSelByValDD() {
			return OrgRatingSelByValDD;
		}

		public WebElement getOrgTypeSelByValDD() {
			return OrgTypeSelByValDD;
		}

		public WebElement getSavebutton() {
			return Savebutton;
		}
		
		@FindBy(xpath="//input[@id='phone']")
		private WebElement phonenotxtbox;


		public WebElement getPhonenotxtbox() {
			return phonenotxtbox;
		}
		
		
		

}
