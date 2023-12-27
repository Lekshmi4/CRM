package Utility;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility
{
WebDriver driver;
	
	public WaitUtility(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void waitClick(WebElement waitvar)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.elementToBeClickable(waitvar));
	}
	
	public void waitVisibility(WebElement waitvar)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(waitvar));
	}			 
	public void waitforvisible(List<WebElement> itemtable )
	{
		WebDriverWait waitv= new WebDriverWait(driver,Duration.ofSeconds(240));
		waitv.until(ExpectedConditions.visibilityOfAllElements((itemtable)));
	}
					 
	public void waitforvisible(By waitvar) 
	{
		WebDriverWait waitv= new WebDriverWait(driver,Duration.ofSeconds(240));
		waitv.until(ExpectedConditions.visibilityOfElementLocated(waitvar));
	}
	public void waitSelected(WebElement waitvar)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeSelected(waitvar));
	}	

}

