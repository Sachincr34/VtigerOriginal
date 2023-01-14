package vtiger.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.OrgAndcontactsHomepage;
import vtiger.ObjectRepository.vtigerLoginPage;

public class Baseclass2 {
			public  PropertyFileUtility pdata=new PropertyFileUtility();
			protected ExcelUtility ex=new ExcelUtility();
		 protected WebDriverUtilities util =new WebDriverUtilities();
		public  JavaUtility jutil=new JavaUtility();
		  public static  WebDriver sdriver= null;
		  public WebDriver driver;
		  @BeforeSuite
		  public void DataBaseConnectionOpen()
		  {
			System.out.println("Database connection is successfull");  
		  }
		@BeforeClass
		public void Openappln() throws IOException
		{
			String BROWSER=pdata.GetPropertyData("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{	
		WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			
		WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else 
		{
		System.out.println("Inavalid BROWSER NAME");
		}
         
		driver.manage().window().maximize();
		util.Waitforpageload(driver);
		
		driver.get("http://localhost:8888/");
		System.out.println("Browser launched succefully");
		sdriver=driver;
		
		
		}
		
		@BeforeMethod
		public void LoinIntoAppln() throws IOException 
		{
			String username= pdata.GetPropertyData("username");
			String password=pdata.GetPropertyData("password");
			vtigerLoginPage vl=new vtigerLoginPage(driver);
			vl.LoginToAppctn(username, password);
			System.out.println("Login succefully");
		}
		@AfterMethod
		public void LogoutFromAppln()
		{
			OrgAndcontactsHomepage och=new OrgAndcontactsHomepage(driver);
			och.signout(driver);
			System.out.println("Logout succefully");
		}
		
		@AfterClass
		public void CloseBrowser()
		{
			driver.quit();
			System.out.println("Browser closed succefully");
		}
		
		@AfterSuite
		public void closeDataBaseConnection()
		{
			System.out.println("Database connection closed successfully");  
		  }
			
		
		
	
		
	}


