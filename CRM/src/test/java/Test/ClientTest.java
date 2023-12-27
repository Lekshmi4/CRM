package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import Page.ClientPage;
import Page.LoginPage;

public class ClientTest extends BaseTest
{
  
  @Test(priority=1,groups= {"regression"})//retryAnalyzer = generaltests.Retry.class)
  public void verifyclient() 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  ClientPage cp=new ClientPage(driver);
	  String actual=cp.client("AALEKSHMI","Bangalore PrestigeShanthinikethen","Bangalore","Karnataka","695006","India","04714040000","https://www.ust.com","1234567","AFN");
      String expected="AALEKSHMI";
      Assert.assertEquals(actual, expected);
      
  }
  @Test(priority=2,groups= {"regression"})
  public void verifysearch() 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  ClientPage cp=new ClientPage(driver);
	  String actual3=cp.searchTest("AALEKSHMI");
      String expected3="AALEKSHMI";
      Assert.assertEquals(actual3, expected3);
      
  }
  
  @Test(priority=3,groups= {"smoke"})
  public void verifyEditClient()
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  ClientPage cp=new ClientPage(driver); 
	  String actual1=cp.editClient("AAEDITEDLEKSHMI","AALEKSHMI");
	  String expected1="AAEDITEDLEKSHMI";
      Assert.assertEquals(actual1, expected1);
  }
  
  @Test(priority=4,groups= {"regression","smoke"})
  public void deleteClient() 
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com", "12345678");
	  ClientPage cp=new ClientPage(driver);
	  String actual2=cp.deleteClient("AAEDITEDLEKSHMI");
	  String expected2="No record found.";
      Assert.assertEquals(actual2, expected2);
	  
  }
}
