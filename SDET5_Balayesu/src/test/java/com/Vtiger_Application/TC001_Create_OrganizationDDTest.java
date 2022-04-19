package com.Vtiger_Application;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.POM_Class.CreateNewOrganisationPage;
import com.POM_Class.HomePage;
import com.POM_Class.OrgInformationPage;
import com.generic.BaseClass;

public class TC001_Create_OrganizationDDTest extends BaseClass {

	@Test(groups = "regression")
	public void create_OrganizationDDTest() throws Exception
	{
		HomePage homePage= new HomePage(driver);
		homePage.getOrgModule().click();

		OrgInformationPage orgINfoPAge = new OrgInformationPage(driver);

		driverUtils.waitandclick(orgINfoPAge.getCreateOrg());

		CreateNewOrganisationPage newOrgPage = new CreateNewOrganisationPage(driver);
		String orgname=data.getOrgname();
		newOrgPage.getOrganisationName().sendKeys(orgname);

		driverUtils.selectValuefromDD(newOrgPage.getOrgIndustrySelByValDD(), "Chemicals");
		driverUtils.selectValuefromDD(newOrgPage.getOrgRatingSelByValDD(), "Active");
		driverUtils.selectValuefromDD(newOrgPage.getOrgTypeSelByValDD(), "Customer");

		//Thread.sleep(3000);
		//newOrgPage.getSavebutton().click();
		driverUtils.waitandclick(newOrgPage.getSavebutton());
		Thread.sleep(3000);

		homePage.getOrgModule().click();

		orgINfoPAge.searchForOrganisation(orgname, "accountname");

		Thread.sleep(3000);

		//String actual_orgname=	driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

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

	@Test(groups = "smoke")
	public void  deleteOrgTest() throws Exception
	{
		HomePage homePage= new HomePage(driver);
		homePage.getOrgModule().click();

		OrgInformationPage orgINfoPAge = new  OrgInformationPage(driver);
		orgINfoPAge.getCreateOrg().click();

		CreateNewOrganisationPage newOrgPage = new CreateNewOrganisationPage(driver);
		String orgname=data.getOrgname();
		newOrgPage.getOrganisationName().sendKeys(orgname);

		newOrgPage.getSavebutton().click();
		Thread.sleep(3000);

		homePage.getOrgModule().click();

		orgINfoPAge.searchForOrganisation(orgname, "accountname");

		Thread.sleep(3000);

		orgINfoPAge.getFirstcheckbox().click();

		orgINfoPAge.getDeletebtn().click();

		driverUtils.acceptAlert();

		driverUtils.waitforelement(orgINfoPAge.getnoOrgfound());

		String msg= orgINfoPAge.getnoOrgfound().getText();


//		if(msg.equals("No Organization Found !")) 
//		{
//			System.out.println("TC Passed");	
//		}
//		else {
//			System.out.println("TC Fail");
//		}
		
		Assert.assertEquals(msg, "No Organization Found !");
	}

}
