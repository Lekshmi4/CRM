package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	     WebDriver driver;
	     @FindBy(xpath="//input[@name='email']")
	     WebElement userName;
	     @FindBy(xpath="//input[@name='password']")
	     WebElement password1 ;
	     @FindBy(xpath="//button[text()='Sign in']")
	     WebElement submit;
	     @FindBy(xpath="//span[text()='Dashboard']")
	     WebElement dash;

	public LoginPage(WebDriver driver)
	{
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}

	public String doLogin(String username,String password)
	{
		 
		 userName.sendKeys(username);
		 password1.sendKeys(password);
		 submit.click();
         String actualmsg=dash.getText();
         return actualmsg;
		
	}
}
