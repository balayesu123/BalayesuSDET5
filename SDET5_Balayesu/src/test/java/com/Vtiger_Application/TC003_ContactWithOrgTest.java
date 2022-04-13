package com.Vtiger_Application;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.POM_Class.ContactInfoPage;
import com.POM_Class.ContactOrgPopUpPage;
import com.POM_Class.Creat_ContactsPage;
import com.POM_Class.HomePage;
import com.generic.BaseClass;
import com.generic.Fake_Data;

public class TC003_ContactWithOrgTest extends BaseClass {

	@Test(groups = "integration")
	public void contactWithOrgTest() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.getContactsModule().click();

		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
		contactInfoPage.getcreateContacts().click();

		Creat_ContactsPage  contactPage = new Creat_ContactsPage(driver);

		Fake_Data fake_Data = new Fake_Data();
		String contactname=fake_Data.lastname();
		contactPage.getContactLoststNmTxtb().sendKeys(contactname);

		contactPage.getSelectOrgNmInCnts().click();
		// window switching

		driverUtils.switchTowindow("Accounts");
		ContactOrgPopUpPage org_popup = new ContactOrgPopUpPage(driver);
		org_popup.searchandselectforOrg("samsung");

		driverUtils.switchTowindow("Contact");

		contactPage.getSavebtn().click();

		Thread.sleep(3000);
		homePage.getContactsModule().click();

		//validation
		contactInfoPage.checkcontactcreated(contactname, "Last Name");

		Thread.sleep(3000);

		//String fname=driver.findElement(By.xpath("//span[@vtfieldname='lastname']/..")).getText();
		String fname=contactInfoPage.getGetTextOrgLastName().getText();

//		if(fname.equals(contactname)) {
//			System.out.println("TC Pass");
//		}
//		else {
//			System.out.println("TC Fail");
//		}
		
		Assert.assertEquals(fname, contactname);
	}
	@Test(groups="smoke")
	public void createContactTest() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.getContactsModule().click();

		ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
		contactInfoPage.getcreateContacts().click();

		Creat_ContactsPage  contactPage = new Creat_ContactsPage(driver);

		Fake_Data fake_Data = new Fake_Data();
		String contactname=fake_Data.lastname();
		contactPage.getContactLoststNmTxtb().sendKeys(contactname);

		contactPage.getSavebtn().click();

		Thread.sleep(3000);
		homePage.getContactsModule().click();

		//validation
		contactInfoPage.checkcontactcreated(contactname, "Last Name");

		Thread.sleep(3000);

		String fname=contactInfoPage.getGetTextOrgLastName().getText();
//		if(fname.equals(contactname)) {
//			System.out.println("TC Pass");
//		}
//		else {
//			System.out.println("TC Fail");
//		}
		
		Assert.assertEquals(fname, contactname);
	}
}
