package Test;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Page.LoginPage;
import Utility.ExcelRead;
import constants.Constants;



public class LoginTest extends BaseTest{
  @Test(priority=1,dataProvider="dp")
 
  public void VerifyLogin(String email,String password) 
  {
	  LoginPage lp=new LoginPage(driver);
	  String actualmsg=lp.doLogin(email, password);
	  String expectedmsg="Dashboard";
	  Assert.assertEquals(actualmsg, expectedmsg);
  }
  
  @DataProvider
 public Object[][] dp() throws InvalidFormatException, IOException
 {
	  
       Object[][] data=ExcelRead.getDataFromExcel(Constants.test_data,"Sheet1");
       return data;
 
 }
  
}
