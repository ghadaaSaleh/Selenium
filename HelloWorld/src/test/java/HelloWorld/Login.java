package HelloWorld;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login  extends PageBase{
	  @FindBy(name  = "username")
      private WebElement _username;
	  @FindBy(name = "password")
      private WebElement _password;
	  @FindBy(xpath  = "//*[@id=\"login\"]/button")
      private WebElement loginButton;
	  
	
	  
	 public Login(WebDriver driver) {
	        super(driver);
	        
	      
	        
	    }
	 
	 public void Login(String username,String password) {
		 _username.sendKeys(username);
		 _password.sendKeys(password);    
		 loginButton.click();
	        
	    }
}
