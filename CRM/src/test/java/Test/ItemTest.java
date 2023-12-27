package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Page.ClientPage;
import Page.ItemPage;
import Page.LoginPage;

public class ItemTest extends BaseTest 
{
  @Test(priority=1,groups= {"regression"})
  public void verifyAddItem() 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  ItemPage ip=new ItemPage(driver);
	  String actual=ip.addItem("AALEKSHMI","furniture","5pc","50000");
      String expected="AALEKSHMI";
      SoftAssert softassert=new SoftAssert();
	  softassert.assertEquals(actual,expected);
	  softassert.assertAll();
      
  }
  
  @Test(priority=2,groups= {"smoke"})
  public void searchItem() 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  ItemPage ip=new ItemPage(driver);
	  String actual3=ip.searchItem("AALEKSHMI");
	  String expected3="AALEKSHMI";
      Assert.assertEquals(actual3, expected3);
  }
  
  @Test(priority=3,groups= {"smoke"})
  public void verifyEditItem()
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  ItemPage ip=new ItemPage(driver);
	  String actual1=ip.editItem("AAEDITEDLEKSHMI","AALEKSHMI");
	  String expected1="AAEDITEDLEKSHMI";
	  SoftAssert softassert=new SoftAssert();
	  softassert.assertEquals(actual1,expected1);
	  softassert.assertAll();
  }
  
  @Test(priority=4,groups= {"regression","smoke"})
  public void deleteItem() 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  ItemPage ip=new ItemPage(driver);
	  String actual2=ip.deleteItem("AAEDITEDLEKSHMI");
	  String expected2="No record found.";
      Assert.assertEquals(actual2, expected2);
	  
  }
  
}
