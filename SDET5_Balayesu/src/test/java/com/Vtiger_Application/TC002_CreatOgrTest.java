package com.Vtiger_Application;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.POM_Class.CreateNewOrganisationPage;
import com.POM_Class.HomePage;
import com.POM_Class.OrgInformationPage;
import com.generic.BaseClass;

public class TC002_CreatOgrTest extends BaseClass {
	@Test(groups = "smoke")
	public void creatOgrTest() throws Exception
	{
		HomePage homePage= new HomePage(driver);
		homePage.getOrgModule().click();

		OrgInformationPage orgINfoPAge = new OrgInformationPage(driver);

		driverUtils.waitandclick(orgINfoPAge.getCreateOrg());

		CreateNewOrganisationPage newOrgPage = new CreateNewOrganisationPage(driver);
		String orgname=data.getOrgname();
		newOrgPage.getOrganisationName().sendKeys(orgname);

		driverUtils.waitandclick(newOrgPage.getSavebutton());
		Thread.sleep(3000);

		homePage.getOrgModule().click();

		orgINfoPAge.searchForOrganisation(orgname, "accountname");

		Thread.sleep(3000);

		String actual_orgname = orgINfoPAge.getGettextOfOrg().getText();

//		if(actual_orgname.equals(orgname)) 
//		{
//			System.out.println("TC Passed");	
//		}
//		else {
//			System.out.println("TC Fail");
//		}
		
		Assert.assertEquals(actual_orgname, orgname);
	}

	@Test(groups = "integration")
	public void createOrgWithMobileNumTest() throws Exception
	{
		HomePage homePage= new HomePage(driver);
		homePage.getOrgModule().click();

		OrgInformationPage orgINfoPAge = new OrgInformationPage(driver);

		driverUtils.waitandclick(orgINfoPAge.getCreateOrg());

		CreateNewOrganisationPage newOrgPage = new CreateNewOrganisationPage(driver);
		String orgname=data.getOrgname();
		newOrgPage.getOrganisationName().sendKeys(orgname);

		newOrgPage.getPhonenotxtbox().sendKeys(data.phonenumber());

		driverUtils.waitandclick(newOrgPage.getSavebutton());
		Thread.sleep(3000);

		homePage.getOrgModule().click();

		orgINfoPAge.searchForOrganisation(orgname, "accountname");

		Thread.sleep(3000);

		String actual_orgname = orgINfoPAge.getGettextOfOrg().getText();

//		if(actual_orgname.equals(orgname)) 
//		{
//			System.out.println("TC Passed");	
//		}
//		else {
//			System.out.println("TC Fail");
//		}
		
		Assert.assertEquals(actual_orgname, orgname);
	}
}
