package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	
	{
		prop = new Properties();
        //System.getProperty("user.dir");  
		/*
		 *Removing hard-coded path in framework
		 *generating paths dynamically
		 * */
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	
		prop.load(fis);
		
		//mvn test -Dbrowser=chrome  - run in cmd
		//Jenkins CI Integration
		//String browserName = System.getProperty("browser"); 
		
		
		//Normal test run
		String browserName = prop.getProperty("browser"); 
		
		if(browserName.equals("chrome"))
			
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			//execute in chrome browser
		}
		
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			//execute in firefox browser
		}
		
		else if(browserName.equals("IE"))
		{
			//execute in IE browser
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
	}

}
