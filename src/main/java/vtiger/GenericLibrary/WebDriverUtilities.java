package vtiger.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Sachin R
 *
 */
public class WebDriverUtilities {
	/**
	 * This method is used to maximize the browser screen
	 * @param driver
	 */
	public void Maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method will minimize the browser screen
	 * @param driver
	 */
	public void Minimise(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait till the entire page is loaded 
	 * @param driver
	 */
	public void Waitforpageload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	/**
	 * This method will wait till the element to be visible
	 */
	public void ElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait till the element to be clickable
	 */
	public void ElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This is the custom wait method used to wait untill element get clikable;
	 * @param element
	 * @throws InterruptedException
	 */
	
	public void CustomwaitForSecond(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<5)
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(10000);
			count++;
			
			}
		}
	}
	
	/**
	 * This methode will select the value in dropdown using Index
	 * @param dropdown
	 * @param index
	 */
	
public void HandleDropDownByIndex(WebElement dropdown,int index) {

	Select s=new Select(dropdown);
	s.selectByIndex(index);
	
}
/**
 * This methode will select the value in dropdown using Visible Text
 * @param dropdown
 * @param text
 */
public void HandleDropDownByVisibleText(WebElement dropdown,String text) {

	Select s=new Select(dropdown);
	s.selectByVisibleText(text);
	
}
/**
 * This methode will select the value in dropdown using Value
 * @param dropdown
 * @param value
 */
public void HandleDropDownByValue(WebElement dropdown,String value) {

	Select s=new Select(dropdown);
	s.selectByValue(value);
	
}
/**
 * This method will do the mousehover action on thr particular element;
 * @param driver
 * @param ele
 */
public void Mousehover(WebDriver driver,WebElement ele)
{
	Actions a =new Actions(driver);
	a.moveToElement(ele).perform();
}
/**
 * This will do the double click action on the element
 * @param driver
 * @param ele
 */
public void Dobleclick(WebDriver driver,WebElement ele)
{
	Actions a =new Actions(driver);
	a.doubleClick(ele).perform();
}
/**
 * This method will do right click action on the element
 * @param driver
 * @param ele
 */
public void Rightclick(WebDriver driver,WebElement ele)
{
	Actions a =new Actions(driver);
	a.contextClick(ele).perform();
}
/**
 * This method will press enter and release the button
 * @throws AWTException
 */
public void PressEnterKey() throws AWTException 
{
	Robot r =new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
}
/**
 * This method will scroll till the particular element
 * @param driver
 * @param x
 * @param y
 */
public void ScrollBar(WebDriver driver,int x,int y)
{
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy("+x+","+y+")");
}
/**
 * This method will do switching action of the tabs
 * @param driver
 */
public void Switchingtabs(WebDriver driver,String partialTittele)
{
	Set<String> allwindows = driver.getWindowHandles();
	for(String currentTab:allwindows)
	{
		String currenttbname = driver.switchTo().window(currentTab).getTitle();
		if(currenttbname.contains(partialTittele))
		{
			break;
		}
	}

}
/**
 * This method helps in switching the frame
 * @param driver
 */
public void SwitchFrame(WebDriver driver)
{
	driver.switchTo().frame(0);
}
/**
 * This method helps in switching back to the defult frame
 * @param driver
 */
public void SwitchBackFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * This methode accepts alert popup
 * @param driver
 */
public void AlertPopupAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();;
}
/**
 * This methode dismiss the alert popup
 */
public void AlertPopupDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

public String takeScreenshot(WebDriver driver,String screenshotname) throws IOException 
{
	TakesScreenshot ts =(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest= new File(".\\Screenshots"+screenshotname+".png");
    FileUtils.copyFileToDirectory(src, dest);
    return dest.getAbsolutePath();  //This methode is used in extent reports
}



	
	
	

}
