package popups_Practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AuthenticationPopup {
	@Test
	public void Popups() {
		
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
	    WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Reporter.log("PopupisHandled sucessfully",true);
		
		String exp=driver.getTitle();
		System.out.println(exp);
		Assert.assertEquals("The Internet", exp);
		Reporter.log("Test case is passed",true);
	}
	
	@Test
	public void PopupWithExceptions() {

		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
	    WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		try
		{
			driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		Reporter.log("PopupisHandled sucessfully",true);
		
		String exp=driver.getTitle();
		System.out.println(exp);
		Assert.assertEquals("The Internet", exp);
		Reporter.log("Test case is passed",true);
	}
}
