package vtigerOrganizationandContacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericLibrary.Baseclass2;
import vtiger.ObjectRepository.ContactsHomepage;
import vtiger.ObjectRepository.Createcontactpage;
import vtiger.ObjectRepository.Creatorgpage;
import vtiger.ObjectRepository.OrgAndcontactsHomepage;
import vtiger.ObjectRepository.ogrganization;

public class CreateOrgAndContactsTest {
	@Listeners(vtiger.GenericLibrary.ListenersImplementationClass.class)
	public class CreateOrgWithContacts extends Baseclass2{
		
		@Test (dataProvider = "Lastname")
		public void Testcase1(String lastname) throws IOException, InterruptedException
		{
	    String Orgname=pdata.GetPropertyData("orgname")+jutil.GetRandomNum();
		String username = pdata.GetPropertyData("username");
		String password = pdata.GetPropertyData("password");
		

	   OrgAndcontactsHomepage o=new OrgAndcontactsHomepage(driver);
	   o.GetOrglink();
	   ogrganization or=new ogrganization(driver);
	   or.OrgAddBtn();
	   
	   Creatorgpage cor =new Creatorgpage(driver);
	   cor.CreateorgAndSave(Orgname);
	   util.Waitforpageload(driver);
	   String organizaionName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	  Assert.assertTrue(organizaionName.contains(Orgname));   //ASSERT.assertEquals
	   Reporter.log("Organization is created "+Orgname,true);
	   
	   o.GetContactslink();
	   ContactsHomepage ch=new ContactsHomepage(driver);
	   ch.Createcontact();
	   
	   Createcontactpage ccp=new Createcontactpage(driver);
	   Thread.sleep(3000);
	   ccp.createcontactwithorgname(lastname, Orgname,driver);
	   String ContactName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   Thread.sleep(3000);
	 
		Assert.assertEquals(ContactName.contains(lastname), true);    //ASSERT.assertEquals
		   Reporter.log("Contact  is created "+ContactName,true);
	 
		}
		
		@DataProvider(name="Lastname")
		public Object[][] LoadDataToDataProvider() throws EncryptedDocumentException, IOException
		{
			return ex.readMultipleDataIntoDataProvider("Sheet1");
			
		}
	  
	   
			

	}


}
