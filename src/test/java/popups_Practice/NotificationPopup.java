package popups_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class NotificationPopup {

	@Test 
	public void Handlingpopup() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-geolocation");
		options.addArguments("--disable-notification");
		
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
	    WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.ajio.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	    Thread.sleep(2000);
	    Reporter.log("Popup is Handled", true);
		driver.close();
	}
	
	@Test
	public void NotificationPopupWithExceptions() throws InterruptedException {
		 WebDriver driver;
		
		ChromeOptions options = new ChromeOptions();
		 //options.addArguments("--disable-geolocation");
		//options.addArguments("--disable-notification");
		
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		try 
		{
	    driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.ajio.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		}
		catch(Exception e)
		{
			Thread.sleep(2000);
			e.printStackTrace();	
		}
		Reporter.log("popup is handled", true);
		
	}
}
