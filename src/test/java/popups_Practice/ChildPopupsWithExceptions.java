package popups_Practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ChildPopupsWithExceptions {
	@Test 
	public void HandlePopus() throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
    WebDriver driver= new ChromeDriver();
	driver.get("http://rmgtestingserver:8888/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	//click on opportunity link
	driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
	
	//click on create opportunity lookup image
	driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
	
	//enter details into all the text fields
	driver.findElement(By.name("potentialname")).sendKeys("wipro_929");
	try
	{
	driver.findElement(By.xpath("//img[@src='themes/softed/images/']")).click();
	Thread.sleep(2000);
	
	//switching between windows
	String parent = driver.getWindowHandle();
	Set<String> handles = driver.getWindowHandles();
	
	for (String handle : handles) 
	{
		if(!handle.equals(parent)) 
		{
			driver.switchTo().window(handle);
			driver.findElement(By.name("search_text")).sendKeys("wipro_929");
			driver.findElement(By.xpath("//input[@type='button']")).click();
			Thread.sleep(2000);
			driver.close();
		}
	}
	
	driver.switchTo().window(parent);
	driver.findElement(By.id("jscal_trigger_closingdate")).click();
	driver.findElement(By.xpath("//div[@class='calendar']//following-sibling::div[@class='calendar']//descendant::td[text()='November, 2023']/ancestor::div[@class='calendar']//tbody/descendant::td[contains(@class,'day') and text()='24' and not(contains(@class,'wn'))]")).click();
    Thread.sleep(3000);
	}
	catch(Exception e) 
	{
		e.printStackTrace();
	}
	Reporter.log("childwindow popups is handled");
    
    String actual=driver.getTitle();
	System.out.println(actual);
	
	Assert.assertEquals("Administrator - Products - vtiger CRM 5 - Commercial Open Source CRM", actual);
	
	Reporter.log("Test case is Passed",true);
	
	driver.close();
  }
}
