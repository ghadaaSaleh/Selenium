package HelloWorld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSuite {
	WebDriver driver;
	
	@DataProvider(name = "UserData")
	public static Object[][] UserData()
	{
		return new Object[][] {{"test","pass"},{"","pass"},{"test",""}};
	}
	@BeforeTest
	public void OpenBrowser()
	{
	
		WebDriverManager.edgedriver().setup();
	    driver=new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		
	}
	@Test(priority = 1,dataProvider = "UserData")
	public void InValidUserNameAndPassword(String userNameInput,String passwordInput)
	{
		WebElement userName=driver.findElement(By.name("username"));
		userName.sendKeys(userNameInput);
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys(passwordInput);
		WebElement login=driver.findElement(By.className("radius"));
		login.click();
		String wrongMsg=driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
		boolean isValid=wrongMsg.contains("Your username is invalid");
		Assert.assertTrue(isValid);
	}
	@Test(priority = 2)
	public void Login()
	{
		WebElement userName=driver.findElement(By.name("username"));
		userName.sendKeys("tomsmith");
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		WebElement login=driver.findElement(By.className("radius"));
		login.click();
		String wrongMsg=driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
		boolean isValid=wrongMsg.contains("You logged into a secure area!");
		Assert.assertTrue(isValid);
	}
	
	@Test(priority = 3,dependsOnMethods = "Login")
	public void LogOut()
	{
		WebElement userName=driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		userName.click();
		String login=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2")).getText();
		boolean isValid=login.contains("Login Page");
		Assert.assertTrue(isValid);
	}
	@AfterTest
	public void CloseBrowser()
	{//driver.quit();
		
	}

}
