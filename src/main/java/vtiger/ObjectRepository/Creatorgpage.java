package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creatorgpage {
	@FindBy(name="accountname")
   private WebElement orgnametf;
	
	@FindBy(name="button")
	private WebElement savebtn;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	
	public Creatorgpage(WebDriver driver)
	{
			PageFactory.initElements(driver,this);
	}
	
	public WebElement getIndustryDD() {
		return industryDD;
	}

	public void creatorgname(String orgname)
	{
		orgnametf.sendKeys(orgname);
	}
	
	public void Savebtnclick()
	{
		savebtn.click();
	}
	/**Business Logic
	 * This methode will create orgnaisation and will save the page
	 * @param orgname
	 */
	public void CreateorgAndSave(String orgname)
	{
		orgnametf.sendKeys(orgname);
		savebtn.click();
		
	}
}


