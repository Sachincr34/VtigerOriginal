package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ogrganization {
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement orgaddbtn;
	
	public ogrganization(WebDriver driver)
	{
			PageFactory.initElements(driver,this);
	}
	
	public void OrgAddBtn()
	{
		orgaddbtn.click();
		
	}

}
