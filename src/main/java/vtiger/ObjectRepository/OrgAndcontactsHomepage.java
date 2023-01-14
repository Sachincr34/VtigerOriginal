package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericLibrary.Baseclass2;

public class OrgAndcontactsHomepage extends Baseclass2 {
	@FindBy(linkText="Organizations")
private WebElement orglink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactslink;
	
	@FindBy(xpath="//td[@class='small' and @style='padding-bottom: 1em;']")
	private WebElement Administrator;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement Signoutbtn;
	
	public WebElement getAdministrator() {
		return Administrator;
	}

	public WebElement getSignoutbtn() {
		return Signoutbtn;
	}

	public OrgAndcontactsHomepage(WebDriver driver)
	{
			PageFactory.initElements(driver,this);
	}

	public void GetOrglink() {
		orglink.click();
	}

	public void  GetContactslink() {
		 contactslink.click();;
	}
  /**
   * This methode help us to signout from the application
   */
	public void signout(WebDriver driver)
	{
		util.Mousehover(driver, Administrator);
		Signoutbtn.click();
	}
	
	
	
}
