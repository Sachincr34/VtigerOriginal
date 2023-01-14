package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.Baseclass2;

public class Createcontactpage extends Baseclass2{
	@FindBy(name="lastname")
	private WebElement lastnametf;
	
	@FindBy(xpath="//img[@title='Select' and @alt='Select']")
			private WebElement addorgbtn;
	@FindBy(name="button")
	private WebElement savebtn;
	
	
	@FindBy(name="search_text")
	private WebElement searchtf;

	@FindBy(name="search")
	private WebElement searchbtn;

	
	public WebElement getSearchtf() {
		return searchtf;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public Createcontactpage(WebDriver driver)
	{
			PageFactory.initElements(driver,this);
	}
	public WebElement getLastnametf() {
		return lastnametf;
	}
	public WebElement getAddorgbtn() {
		return addorgbtn;
	}
	
	/**
	 * This methide will create contact with org name
	 * @param Lastname
	 */
	public void createcontactwithorgname(String Lastname,String Orgname,WebDriver driver )
	{
		lastnametf.sendKeys(Lastname);
		addorgbtn.click();
	    util.Switchingtabs(driver, "Accounts&action");
		searchtf.sendKeys(Orgname);
		searchbtn.click();
		driver.findElement(By.xpath("//a[.='"+Orgname+"']")).click();
		util.Switchingtabs(driver, "Contacts&action");
		savebtn.click();
	}

}
