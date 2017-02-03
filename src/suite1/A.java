package suite1;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;

public class A {
	private BaseTest page;
	@Test
	public void testA()
	{
		page = PageFactory.initElements(new FirefoxDriver(), BaseTest.class);
		System.out.println("Random name is:"+page.randNameGen(5));
	}


}
