package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import Page.LoginPage;
import Page.MessagePage;
public class MessageTest extends BaseTest {
	
  @Test
  public void verifyMessage() {
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  MessagePage mp=new MessagePage(driver);
	  String actual=mp.message("AALEK","AALEK");
      String expected="Subject: AALEK";
      Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void verifySearch() {
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  MessagePage mp=new MessagePage(driver);
	  String actual=mp.search("AALEK");
      String expected="Subject: AALEK";
      Assert.assertEquals(actual, expected);
  }
}
