package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;

public class ElementUtility
{
	
	    WebDriver driver;
	
	public ElementUtility(WebDriver driver) 
	{
		this.driver=driver;
	}
	
    public void scroll(WebElement var)
    {
	
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("arguments[0].scrollIntoView()",var);
    }
    
    public void dropdownIndex(WebElement selector,int a)
    {
    	
	     Select object=new Select(selector);
         object.selectByIndex(a);
    
    }
    
    public void dropdownVisible(WebElement selector,String value)
    {
    	
	     Select object=new Select(selector);
         object.selectByVisibleText(value);
    
    }
    
    public void dropdownValue(WebElement selector,String value)
    {
    	
	     Select object=new Select(selector);
         object.selectByValue(value);
    
    }
    
    public void radioButton(List<WebElement> option,int a)
    {
    	 option.get(a).click();
    }
    
    public void checkBox( List<WebElement> checkbox,int a)
    {
    	 checkbox.get(a).click();//isselected
    }
    
    public void clearAndSend(WebElement element,String value )
    {
    	 element.clear();
		 element.sendKeys(value);
    }
    
    public static String getPropertyValue(String key) 
	{

		  File src=new File(Constants.propertyConfig_File);
		  Properties pro=new Properties();
		  try
		  {
			FileInputStream fis = new FileInputStream (src);
			
			pro.load(fis);
		  } 
		  catch (Exception e) 
		  {

			e.printStackTrace();
		  }
		
		  String value=pro.get(key).toString();
		  return value;
	 }
    public int getTableDataRowCount(List<WebElement> tableRowData ,String expectedValue)
	{
		int counter=0;
		for(int i=0;i<tableRowData.size();i++)
		{
			String value=tableRowData.get(i).getText();
			if(expectedValue.equalsIgnoreCase(value))
			{
				counter=i+1;
				break;
			}
		}
		return counter;
	}
}



