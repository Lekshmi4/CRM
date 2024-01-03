package Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ElementUtility;
import Utility.WaitUtility;

public class ClientPage

{
	WebDriver driver;
	@FindBy(xpath="//input[@name='email']")
	WebElement userName;
	@FindBy(xpath="//span[text()='Clients']")
	WebElement clients;	
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement addnote;
	@FindBy(xpath="//h4[@id='ajaxModalTitle']")
	WebElement note;
	@FindBy(xpath="//input[@autofocus='1']")
	WebElement name;
	@FindBy(xpath="//textarea[@name='address']")
	WebElement address;
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	@FindBy(xpath="//input[@name='vat_number']")
	WebElement vatnumber;
	@FindBy(xpath="//input[@name='country']")
	WebElement country;
	@FindBy(xpath="//input[@name='zip']")
	WebElement zip;
	@FindBy(xpath="//input[@name='phone']")
	WebElement phone;
	@FindBy(xpath="//input[@name='website']")
	WebElement website; 												 
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save;
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[9]//a[1]")
	WebElement edit;
	@FindBy(xpath="//input[@value='AALEKSHMI']")
	WebElement editedclient;
	@FindBy(xpath="//table[@role='grid']//tbody//td//a[2]")
	WebElement delete;
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement confirmdelete;	
	@FindBy(xpath="//a[text()='AALEKSHMI']")
	WebElement value;
	@FindBy(xpath="//button[text()=' Close']")
	WebElement close;	
	@FindBy(xpath="//table[@role='grid']//tbody//tr[1]//td//a[1]")
	WebElement record;
	@FindBy(xpath=" //button[@data-dismiss='alert']//span")
	WebElement dltclose;
	@FindBy(xpath="//table[@class='display dataTable no-footer']//tbody//tr[1]//td")
	WebElement norecord;
	@FindBy(xpath="//span[text()='Keep it blank to use the default (USD)']")
	WebElement currency;
	@FindBy(xpath="//input[@id='s2id_autogen541_search']")
	WebElement currencysearch;
	@FindBy(xpath=" //div[@role='option']")
	WebElement amd;
	ElementUtility  elementutil;
	WaitUtility wait;

	public ClientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutil=new ElementUtility(driver);
		wait=new WaitUtility(driver);
	}

	public String client(String name1,String address1,String city1,String state1,String zip1,String country1,String phonenumber,String website1,String vatnumber1,String var)
	{

		clients.click();
		addnote.click();
		name.sendKeys(name1);
		phone.sendKeys(phonenumber);
		website.sendKeys(website1);
		elementutil.scroll(website);
		vatnumber.sendKeys(vatnumber1);
		wait.waitClick(save);
		save.click();
		closePopUp();
		clickclient();
		search.sendKeys(name1);
		String actual=record.getText();
		return actual;
	}

	public String editClient(String editedvalue,String name1)
	{

		clickclient();
		search.sendKeys(name1);
		edit.click();
		elementutil.clearAndSend(editedclient,editedvalue);
		wait.waitClick(save);
		save.click();
		closePopUp();
		clickclient();
		search.sendKeys(editedvalue);
		String actual1=record.getText();
		return actual1;
	}

	public String deleteClient(String editedvalue )
	{
		clickclient();
		search.sendKeys(editedvalue);
		delete.click();
		confirmdelete.click();
		wait.waitClick(dltclose);
		dltclose.click();
		clickclient();
		search.sendKeys(editedvalue);
		String actual2=norecord.getText();
		return actual2;
	}
	public String searchTest(String searchvalue)
	{
		clickclient();
		search.sendKeys(searchvalue);
		String actual=record.getText();
		return actual;
	}
	public void clickclient()
	{
		clients.click();
	}

	public void closePopUp()
	{
		close.click();
	}
}
