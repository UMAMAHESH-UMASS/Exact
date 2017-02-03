package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class OR  {
	
	protected static WebDriver driver;
	public OR(WebDriver driver)
	{
		OR.driver = driver;
	}
	@FindBy(name="q")
	protected WebElement searchField;

	@FindBy(name="btnG")
	protected WebElement searchButton;
	@FindBy(id="loginusername") protected WebElement username;
	@FindBy(id="loginpassword") protected WebElement password;
	@FindBy(id="loginformsubmit") protected WebElement login;
	@FindBy(xpath="//span[@id='logout']/a/img") protected WebElement logout;
	@FindBy(className="salt") protected WebElement icon_salt;
	@FindBy(className="icon company") protected WebElement icon_company;
	@FindBy(className="setting") protected WebElement icon_modules;
	@FindBy(className="onward-image quick-navigation-circle") protected WebElement icon_onward;
	@FindBy(className="pagegrid-home")
	public static WebElement icon_home;
	
	
	
}