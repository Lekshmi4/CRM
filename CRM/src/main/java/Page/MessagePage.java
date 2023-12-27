package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ElementUtility;
import Utility.WaitUtility;

public class MessagePage {
	     WebDriver driver;
         @FindBy(xpath="//span[text()='Messages']")
         WebElement message;
         @FindBy(xpath=" //a[text()='Compose']")
         WebElement compose;
         @FindBy(xpath="//div[@id='s2id_to_user_id']")
         WebElement to;
         @FindBy(xpath="//input[@id='s2id_autogen3_search']")
         WebElement toselect;
         @FindBy(xpath="//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")
         WebElement contactselect;
         @FindBy(xpath="//input[@data-msg-required='This field is required.']")
         WebElement subject;
         @FindBy(xpath="//textarea[@id='message']")
         WebElement msgwrite;
         @FindBy(xpath="//button[@class='btn btn-primary']")
         WebElement send;
         @FindBy(xpath="//button[@data-dismiss='alert']//span")
         WebElement close;
         @FindBy(xpath="//input[@id='search-messages']")
         WebElement searchmsg;
         @FindBy(xpath="//div[text='The message has been sent.']")
         WebElement sucessMessage;
         @FindBy(xpath="//a[text()='Sent items']")
         WebElement sentitems;
         @FindBy(xpath="//table[@aria-describedby='message-table_info']//tbody//tr//td//div//div")
         WebElement searchResult;
         @FindBy(xpath="//p[@class='pt5 pb10 b-b']")
         WebElement msgSub;
         ElementUtility  elementutil;
         WaitUtility wait;
    
    public MessagePage(WebDriver driver)
	{
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 elementutil=new ElementUtility(driver);
		 wait=new WaitUtility(driver);
	}
    public String message(String title,String msg)
    {
    	 message.click();
    	 wait.waitClick(compose);
    	 compose.click();
    	 to.click();
    	 toselect.sendKeys("keerthana sasi");
    	 contactselect.click();
    	 subject.sendKeys(title);
    	 msgwrite.sendKeys(msg);
    	 send.click();
    	 wait.waitClick(close);
    	 close.click();
    	 sentitems.click();
    	 searchmsg.sendKeys(title);
    	 searchResult.click();
    	 String actual=msgSub.getText();
    	 return actual;
    }
    public String search(String title)
    {
    	 message.click();
    	 sentitems.click();
    	 searchmsg.sendKeys(title);
    	 searchResult.click();
    	 String actual1=msgSub.getText();
    	 return actual1;
    }
   
}
