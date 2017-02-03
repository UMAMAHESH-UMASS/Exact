 package base;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import config.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import datatable.Xls_Reader;
import static org.testng.Assert.*;
public class BaseTest extends OR 
{
		
	protected static BaseTest page;
	public BaseTest(WebDriver driver)
	{
		super(driver);
	}
	public static Xls_Reader datatable_suite1=null;
	//public static WebDriver d=null;
	public static void initialize() throws Exception
	{
		datatable_suite1=new Xls_Reader(System.getProperty("user.dir")+"//src//config//TestData.xlsx");
		//datatable_suite1=new Xls_Reader("D:\\Selenium_Scripts\\Test_F\\src\\config\\TestData.xlsx");
	}
	
	public void fillLogin(String uname, String upwd)
	{
		username.sendKeys(uname);
		password.sendKeys(upwd);
		login.click();
	}
	public void clickLogout()
	{
		logout.click();
	}
	public void openURL(String url)
	{
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);  
		driver.get(url);
	}
			

		public String getTitle() {
		return driver.getTitle();
		}

		public void searchFor(String searchTerm) {
		searchField.sendKeys(searchTerm);
		searchButton.click();
		}

		public void typeSearchTerm(String searchTerm) {
		searchField.sendKeys(searchTerm);
		}

		public void clickOnSearch() {
		searchButton.click();
		}
	
	public void stopDriver()
	{
		
		driver.quit();
	}
	
		
	public static void takeScreenShots(String fileName) throws IOException{
		
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName+".png"));
	}
	public String randNumGen(int i) 
	{
		return RandomStringUtils.randomNumeric(i);
	}

	public String randNameGen(int i) 
	{
		return RandomStringUtils.randomAlphabetic(i).toLowerCase();
	}

	public String randUserGen() 
	{
		Date d = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmm");
		String strUser = ft.format(d);
		return strUser;
	}
		
	public void clickSalt()
	{
		icon_salt.click();
	}
	public void verifyCompanyIcon()
	{
		assertTrue(icon_company.isDisplayed());
	}
	public void clickModules()
	{
		icon_modules.click();
	}
	public void clickOnward()
	{
		icon_onward.click();
	}
	public void verifyElementPresent(WebElement e)
	{
		assertTrue(e.isDisplayed());
	}
	
}
