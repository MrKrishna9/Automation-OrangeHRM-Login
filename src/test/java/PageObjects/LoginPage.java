package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement LoginButton;
	
	public void setUsername(String username){
		Username.sendKeys(username);
	}
	public void setPassword(String password){
		Password.sendKeys(password);
	}
	public void ClickLoginButton() {
		LoginButton.click();
	}
	
	
}
