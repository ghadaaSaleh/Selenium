package HelloWorld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
	
	@Test
	public void InValidUserNameAndPassword()
	{
		Login loginPage=new  Login(driver);
		loginPage.Login("ahmed", "");
		String wrongMsg=driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
		boolean isValid=wrongMsg.contains("Your username is invalid");
		Assert.assertTrue(isValid);
	}
	@Test
	public void ValidUserNameAndPassword()
	{
		Login loginPage=new  Login(driver);
		loginPage.Login("tomsmith", "SuperSecretPassword!");
		String wrongMsg=driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
		boolean isValid=wrongMsg.contains("You logged into a secure area!");
		Assert.assertTrue(isValid);
	}
}
