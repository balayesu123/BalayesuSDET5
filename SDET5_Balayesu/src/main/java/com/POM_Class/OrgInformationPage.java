package com.POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.Fake_Data;
import com.generic.WebDriverUtils;

public class OrgInformationPage {

	WebDriver driver;
	// Rule2 @FindBy and @FindBya and @FindByAll annotations used for web elements
	
	@FindBy(css="img[alt='Create Organization...']")
	private WebElement createOrg;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchtext;

	@FindBy(id="bas_searchfield")
	private WebElement OrgSelByValDD;

	@FindBy(name="submit")
	private WebElement searchNow;
	
	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement gettextOfOrg;

	// Rule3 create constructor for initialization
	public OrgInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);

	}

	// Rule4 create getter methods for read data
	
	public WebElement getCreateOrg() {
		return createOrg;
	}

	public WebElement getSearchtext() {
		return searchtext;
	}

	public WebElement getOrgSelByValDD() {
		return OrgSelByValDD;
	}

	public WebElement getSearchNow() {
		return searchNow;
	}
	
	public WebElement getGettextOfOrg() {
		return gettextOfOrg;
	}
	
	// Rule5 Business logic
	public void searchForOrganisation(String orgname,String value)
	{
		getSearchtext().sendKeys(orgname);
		WebDriverUtils driverUtils = new WebDriverUtils(driver);
		driverUtils.selectValuefromDD( getOrgSelByValDD(), value);
		getSearchNow().click();

	}
	@FindBy(xpath="//table[@class=\"lvt small\"]//tr[3]//input[@name=\"selected_id\" and @type=\"checkbox\"]")
	private WebElement firstcheckbox;
	
	@FindBy(xpath="//input[@class=\"crmbutton small delete\"]")
	private WebElement deletebtn;
	
	@FindBy(xpath="//span[normalize-space()='No Organization Found !']")
	private WebElement noOrgfound;
	
	public WebElement getFirstcheckbox() {
		return firstcheckbox;
	}
	
	public WebElement getDeletebtn() {
		return deletebtn;
	}
	
	public WebElement getnoOrgfound() 
	{
		return noOrgfound;
	}
}
