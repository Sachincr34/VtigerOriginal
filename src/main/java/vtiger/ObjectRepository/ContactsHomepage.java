package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsHomepage {
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createcontactbtn;
	  
	
	
	public ContactsHomepage(WebDriver driver)
	{
			PageFactory.initElements(driver,this);
	}
	
	public void Createcontact()
	{
		createcontactbtn.click();
	}

}
