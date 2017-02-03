package suite1;

import java.io.IOException;
import java.lang.reflect.Method;

import org.junit.Assume;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import config.Config;
import util.*;
import base.BaseTest;

public class SwitchingModules {
    private BaseTest page;
 
 public void beforeExecution() throws IOException
  {
	//runmode of the test Y or N
	  if(Testutil.isSkip(BaseTest.datatable_suite1, "Scenario_003"))
	  {
	   //skip the test
	   Assume.assumeTrue(false);
	  }
   
 } 

 @Test(dataProvider ="testParameterData")
  public void testModules(String username,String password)throws Exception
  {
	 page.openURL(Config.url);
     page.fillLogin(username,password);
     page.clickSalt();
     //page.verifyCompanyIcon();
     page.clickModules();
     Thread.sleep(2000);
     //page.clickOnward();
    
     Thread.sleep(4000);
  }
 //@Parameters({"browser"})       
 @BeforeTest
	public void openBrowser()
	{
		if(Config.browser.equals("FF"))
		{
			page = PageFactory.initElements(new FirefoxDriver(), BaseTest.class);
			
		}
		else if(Config.browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","D:\\Selenium_Scripts\\Lib\\IEDriverServer.exe");
			page = PageFactory.initElements(new InternetExplorerDriver(), BaseTest.class);
			
		}
		else if(Config.browser.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium_Scripts\\Lib\\chromedriver.exe");
			page = PageFactory.initElements(new ChromeDriver(), BaseTest.class);
			
		}
	}   
 
 @AfterTest
 public void stop()
 {
     page.stopDriver();
 }
 /*@AfterSuite
 public void sendMail() throws Exception
  {
    //Zip.zipFolder("F:\\Selenium_Scripts_Sep14\\DataDrivenFrameWork\\test-output","F:\\Selenium_Scripts_Sep14\\DataDrivenFrameWork\\Results\\"+"Reports.zip");    
    Zip.zipFolder(System.getProperty("user.dir")+"\\test-output",System.getProperty("user.dir")+"\\Results\\"+"Reports.zip");
             
              String[] to={"qtt.selenium.sep@gmail.com"};
              String[] cc={"qtt.selenium@gmail.com"};
               String[] bcc={};

              //This is for google

              SendMail.sendMailTo("qtt.selenium.sep@gmail.com",
                                  "selenium4567",
                                  "smtp.gmail.com",
                                  "465",
                                  "true",
                                  "true",
                                   true,
                                  "javax.net.ssl.SSLSocketFactory",
                                  "false",
                                  to,
                                   cc,
                                  bcc,
                                  "Automation Reports",
                                  "Please find the reports attached in the mail.\n\n Regards\nWebMaster",
                                    System.getProperty("user.dir")+ "\\Results"+"\\Reports.zip",
                                  "Reports.zip"); 
 }*/
  
 @DataProvider(name="testParameterData", parallel=false)
 
 public static Object[][] testParameterData(Method method) throws Exception
 {
 
     BaseTest.initialize(); 
     Object data[][]=Testutil.getData(BaseTest.datatable_suite1, "Login");
      return data;
 }

}