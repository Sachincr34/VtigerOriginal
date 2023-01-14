package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vtigerLoginPage {
	
	@FindBy(name="user_name")
	private WebElement usernametf;
	
	@FindBy(name="user_password")
	private WebElement passwordtf;
	
	@FindBy(id="submitButton")
	private WebElement submitbutton;
	
	public vtigerLoginPage(WebDriver driver)
	{
			PageFactory.initElements(driver,this);
	}

	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	/**Business Logic
	 * This methode will help to login to application
	 * @param username
	 * @param password
	 */
	public void LoginToAppctn(String username, String password)
	{
		usernametf.sendKeys(username);
		passwordtf.sendKeys(password);
		submitbutton.click();
	}
   
}
