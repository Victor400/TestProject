package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	private By userName = By.xpath("//input[@id='username']");
	
	private By password = By.cssSelector("#password");
	
	private By Login = By.xpath("//input[@id='Login']");
	
	private By LoginError = By.cssSelector("#error");
	
	
	public LoginPage(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	
	public WebElement getUserName()
	
	{
		return driver.findElement(userName);
	}
	
	
    public WebElement getPassword()
	
	{
		return driver.findElement(password);
	}
    
    
    public WebElement getLogin()
    
    {
    	return driver.findElement(Login);
    }
    
  public WebElement getLoginError()
    
    {
    	return driver.findElement(LoginError);
    }



}
