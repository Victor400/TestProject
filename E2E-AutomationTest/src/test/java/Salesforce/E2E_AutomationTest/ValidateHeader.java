package Salesforce.E2E_AutomationTest;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class ValidateHeader extends base {
	
public WebDriver driver;
	
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
   @BeforeTest
	
	public void initialize() throws IOException
	
	{
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
		Log.info("Driver is Initialized");
	}
   
   @Test()
	public void validateHeader() throws IOException
	{
		
		LandingPage L = new LandingPage(driver);
		
if(L.getpopUpsize() > 0)
			
		{
			L.getpOPup().click();
		}

		
		
		Assert.assertTrue(L.getNavbar().isDisplayed());
		
		Log.info("Navigation bar is displayed");
		
		
	}
   
   @AfterTest()
   public void TearDown()
   {
	   driver.close();
   }
  
  
	
		
	
	

}
