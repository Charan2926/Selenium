package interview_scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Flipkart_pageTest {
	@Test
	public void FetchPage() throws InterruptedException {
		
		int pageno=2;
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		ChromeDriver  driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//span[@role='button']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Mobiles & Tablets']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("samsung mobiles");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try {
		WebElement ele = driver.findElement(By.xpath("//a[@class='_1LKTO3']//span[.='Next']"));
		Thread.sleep(4000);
			
		JavascriptExecutor js =( JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,6800)",ele);
		Thread.sleep(3000);
//		js.executeScript("arguments[0].scrollIntoView(true);", ele);
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//nav[@class='yFHi8N']//a[.='"+pageno+"']")).click();
		}
		catch(Exception e)
		{
			
		}
	  }
  }	
		
		  