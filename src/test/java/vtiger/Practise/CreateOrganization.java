package vtiger.Practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericLibrary.Baseclass2;
/**
 * 
 * @author Sachin R
 *
 */
public class CreateOrganization extends Baseclass2{
	
	@Test(retryAnalyzer =vtiger.GenericLibrary.RetryAnalyserImplementation.class )
	public void CreateOrganization()
	{
		
     System.out.println("organization created");
    
	}
	@Test
	public void CreateDEMO()
	{
		
     System.out.println("DEMO created");
}
}