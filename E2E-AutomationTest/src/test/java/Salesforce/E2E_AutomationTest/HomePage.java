package Salesforce.E2E_AutomationTest;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	
	LoginPage LP;
	
		public WebDriver driver;
		
		public static Logger Log = LogManager.getLogger(base.class.getName());
		
	   @BeforeTest
		
		public void initialize() throws IOException
		
		{
			driver = initializeDriver();
			
			Log.info("Driver is Initialized");
		}
		
	
	@Test(dataProvider="getData")
	public void homePage(String Username,String Password, String text) throws IOException
	{
			
		driver.get(prop.getProperty("url"));
	
		LandingPage L = new LandingPage(driver);
if(L.getpopUpsize()> 0)
			
		{
			L.getpOPup().click();
		}

		L.getLogin().click();
		
		 LP = new LoginPage(driver);
		LP.getUserName().sendKeys(Username);
		LP.getPassword().sendKeys(Password);
		LP.getLogin();
		
		Log.info(text);
	}
		@Test
		public void validateLoginError() throws IOException
		{
		Assert.assertEquals(LP.getLoginError().getText(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		Log.info("Unable to login successfully");
		}
		
	   @AfterTest
        public void TearDown() 
        {
		    driver.close();
	    }
	
	   @DataProvider()
		public Object[][] getData()
		    
		    {
		    	// coloumn stands for how many values per each test
		  	  // Row stands for how many different data types should run
		  		
		  		Object[][] data = new Object[2][3];
		  		
	  		//0th Row
			data[0][0] = "nonrestricteduser@salesforce.com";
				data [0][1] = "12341256";  
				data[0][2] = "Non-Restricted user";
				
				
				//1st Row
				data[1][0]= "restricteduser@salesforce.com";
				data[1][1]= "45673388";
				data[1][2] = "Restricted user";
				
				
//				
//				data[2][0]= "permitteduser@salesforce.com";
//				data[2][1]= "4501988";
//				data[2][2] = "Permitted user";
//						
				return data;
		    }	
	

}
