package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features  = "src/test/java/features",
glue = "stepDefinations", tags="@Selenium-Test",monochrome = true ,
plugin = {"pretty","html:target/cucumber", "json:target/cucumber.json", "junit:target/cukes.xml"})


public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
