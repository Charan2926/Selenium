package popups_Practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ChildBroswerPopups {
	@Test
	public void Handlingpopups() throws InterruptedException 
	{
	System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
    WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("http://rmgtestingserver:8888/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	
	driver.findElement(By.xpath("//a[text()='Products']")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
	driver.findElement(By.name("productname")).sendKeys("My product");
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	//switching between windows
	String parent = driver.getWindowHandle();
	Set<String> handles = driver.getWindowHandles();
		
		for (String handle : handles) 
		{
			if(!handle.equals(parent)) 
			{
				driver.switchTo().window(handle);
				driver.findElement(By.id("search_txt")).sendKeys("Test134");
				driver.findElement(By.name("search")).click();
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click(); 
		Thread.sleep(2000);
		Reporter.log("windowPopup  handled successfully",true);
		
		String actual=driver.getTitle();
		System.out.println(actual);
		
		Assert.assertEquals("Administrator - Products - vtiger CRM 5 - Commercial Open Source CRM", actual);
		Reporter.log("Test case is Passed",true);
		
		driver.close();
	}
}
