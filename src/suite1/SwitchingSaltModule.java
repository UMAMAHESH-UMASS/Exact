package suite1;

import java.io.IOException;
import java.lang.reflect.Method;

import org.junit.Assume;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.Config;
import config.OR;
import util.Testutil;
import base.BaseTest;

public class SwitchingSaltModule {
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
	  public void testSalt(String username,String password)throws Exception
	  {
		 page.openURL(Config.url);
	     page.fillLogin(username,password);
	     page.clickSalt();
	     page.verifyElementPresent(OR.icon_home);
	     Thread.sleep(4000);
	  }
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
	 @DataProvider(name="testParameterData", parallel=false)
	 
	 public static Object[][] testParameterData(Method method) throws Exception
	 {
	 
	     BaseTest.initialize(); 
	     Object data[][]=Testutil.getData(BaseTest.datatable_suite1, "Login");
	      return data;
	 }
}

