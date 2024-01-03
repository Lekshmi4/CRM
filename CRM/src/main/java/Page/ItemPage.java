package Page;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ElementUtility;
import Utility.WaitUtility;

public class ItemPage 
{
	 WebDriver driver;
	 ElementUtility  elementutil;
     WaitUtility wait;
     @FindBy(xpath="//ul[@id=\"sidebar-menu\"]/li[9]/a")
     WebElement items;
     @FindBy(xpath="//a[@class='btn btn-default']")
	 WebElement additem;
     @FindBy(xpath="//input[@name='title']")
	 WebElement title;
     @FindBy(xpath="//textarea[@name='description']")
	 WebElement description;
     @FindBy(xpath="//input[@placeholder='Unit type (Ex: hours, pc, etc.)']")
     WebElement unit;
     @FindBy(xpath="//input[@name='item_rate']")
	 WebElement rate;
     @FindBy(xpath="//button[@class='btn btn-primary']")
	 WebElement save;
     @FindBy(xpath="//input[@aria-controls='item-table']")
     WebElement search;
     @FindBy(xpath="//table[@id='item-table']//tbody//tr[1]//td[1]")
     WebElement itemname;
     @FindBy(xpath="//table[@id='item-table']//tbody//tr[1]//td//a//i[1]")
     WebElement edit;
     @FindBy(xpath="//table[@id='item-table']//tbody//tr[1]//td[1]")
     WebElement editvalue;
     @FindBy(xpath="//button[text()='Close']")
     WebElement close;
     @FindBy(xpath="//span[@class='fa fa-close']")
     WebElement closepopup;
     @FindBy(xpath="//table[@id='item-table']//tbody//td[5]//a[2]")
     WebElement delete;
     @FindBy(xpath=" //button[@data-dismiss='alert']//span")
     WebElement dltclose;
     @FindBy(xpath="//table[@class='display dataTable no-footer']//tbody//tr[1]//td")
     WebElement norecord;

public ItemPage(WebDriver driver)
{
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	 elementutil=new ElementUtility(driver);
	 wait=new WaitUtility(driver);
}

public String addItem(String title1,String description1,String unitvalue,String rate1)
{
	 itemClick();
	 wait.waitClick(additem);
	 additem.click();
	 title.sendKeys(title1);
	 description.sendKeys(description1);
	 unit.sendKeys(unitvalue);
	 rate.sendKeys(rate1);
	 save.click();
	 closepopup.click();
	 wait.waitClick(items);
	 search.sendKeys(title1);
	 String actual=itemname.getText();
	 return actual;
}

public String editItem(String editedvalue,String name1)
{
	  itemClick();
	  wait.waitClick(search);
	  search.sendKeys(name1);
	  wait.waitClick(edit);
	  edit.click();
	  wait.waitClick(title);
	  elementutil.clearAndSend(title,editedvalue);
	  wait.waitClick(save);
	  save.click();
	  closepopup.click();
	  wait.waitClick(items);
	  itemClick();
	  wait.waitClick(search);
	  search.sendKeys(editedvalue);
	  String actual1=editvalue.getText();
	  return actual1;
}

public String deleteItem(String editedvalue )
{
	  itemClick();
	  wait.waitClick(search);
	  search.sendKeys(editedvalue);
	  wait.waitClick(delete);
	  delete.click();
      wait.waitClick(dltclose);
	  dltclose.click();
	  itemClick();
	  search.sendKeys(editedvalue);
      String actual2=norecord.getText();
      return actual2;
}
public String searchItem(String value )
{
	itemClick();
	search.sendKeys(value);
    String actual3=itemname.getText();
    return actual3;
}



public void itemClick()

{
	items.click();
}



}
