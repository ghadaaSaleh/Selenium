package HelloWorld;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase{
	WebDriver driver;
	@BeforeTest
	public void SetUpDriver()
	{
	
	    driver=new EdgeDriver();
	    driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		
	}
	@AfterTest
	public void CloseDriver()
	{
	
		//WebDriverManager.edgedriver().setup();
	    driver.quit();
		
	}
	
}
