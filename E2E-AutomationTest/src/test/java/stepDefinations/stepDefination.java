package stepDefinations;

import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class stepDefination extends base{
	
	   @Given("^Initialize the browser with chrome$")
	    public void initialize_the_browser_with_chrome() throws Throwable {
		   driver = initializeDriver();
	    }
	   
	   @And("^Navigate to \"([^\"]*)\" Site$")
	    public void navigate_to_something_site(String strArg1) throws Throwable {
		   driver.get(strArg1);  
	    }
	   

	    @And("^Click on Login link home page to land on secure sign in Page$")
	    public void click_on_login_link_home_page_to_land_on_secure_sign_in_page() throws Throwable {
	    	LandingPage L = new LandingPage(driver);
	    	if(L.getpopUpsize() > 0)			
	    	{
	    	   L.getpOPup().click();
	    	}
              L.getLogin().click();
	        }

	    @When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
	    	LoginPage LP = new LoginPage(driver);
			LP.getUserName().sendKeys(username);
			LP.getPassword().sendKeys(password);
			LP.getLogin().click();
			
	    }
	    @Then("^Verify that user is not successfully logged in$")
	    public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    	LoginPage LP = new LoginPage(driver);
	    	Assert.assertEquals(LP.getLoginError().getText(), "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
	    }

	    @And("^User close browsers$")
	        public void close_browsers() throws Throwable {
	           driver.quit();
	        }

	    }

	    


