package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	 private By login = By.cssSelector("a.dropdown-toggle");
	 
	 private By title  = By.xpath("//span[contains(text(),'Get back to growth')]");
	 
	 private By Navbar = By.xpath("//nav[@class='main-menu-container nofocus']");
	 
	 private By popUp = By.xpath("//div[@id='onetrust-button-group']//div/button[2]");
	 
	 
	 
	 
	 
	 public LandingPage(WebDriver driver) 
	 {
		 this.driver = driver;
	 }
	 
	public WebElement getLogin()
	{			
		return driver.findElement(login);		 	
    }
		
	public WebElement getTitle()
	{			
		return driver.findElement(title);	
    }
	
	public WebElement getNavbar()
	{			
		return driver.findElement(Navbar);	
    }
	
	public int getpopUpsize()
	 {
		return driver.findElements(popUp).size();
	 }
	
	public WebElement getpOPup()
	 {
		return driver.findElement(popUp);
	 }

	



}
