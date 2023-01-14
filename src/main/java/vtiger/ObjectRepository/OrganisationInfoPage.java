package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.Baseclass2;

public class OrganisationInfoPage  {

   private static final By ChromeDriver = null;
//private static By driver=ChromeDriver;
//static WebElement orgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	public OrganisationInfoPage(WebDriver driver)
	{
			PageFactory.initElements(driver,this);
	}
	
//	public String GetOrgHeader() {
		//return orgHeader.getText();
	}
	
	


