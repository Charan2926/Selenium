package popups_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FileUploadPopups { 
	@Test
	public void HandlingCalendarpopups() throws InterruptedException 
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
	driver.findElement(By.name("file_0")).sendKeys("C:\\Users\\Nani\\Desktop\\Myname.png");
	
	driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click(); 
	
	Thread.sleep(2000);
	
	Reporter.log("File is uploaded successfully",true);
	
	String exp="Updated today (22 Nov 2023) By Administrator";
	String actual=driver.findElement(By.xpath("//span[@class='small']")).getText();
	System.out.println(actual);
	
    Assert.assertEquals(actual, exp);
	Reporter.log("Test case is Passed",true);

	driver.close();
	}
	@Test
	public void HandlingCalendarpopupsWithExceptions() throws InterruptedException 
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
	try 
	{
		driver.findElement(By.name("file_0")).sendKeys("C:\\Users\\Nani\\Myname.png");
	}
	catch(Exception e)
	{
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click(); 
		Thread.sleep(2000);
		e.printStackTrace();
	}
	Reporter.log("File is uploaded successfully",true);

	String exp="Updated today (22 Nov 2023) By Administrator";
	String actual=driver.findElement(By.xpath("//span[@class='small']")).getText();
	System.out.println(actual);
	
	Assert.assertEquals(actual, exp);
	Reporter.log("Test case is Passed",true);
	
	driver.close();
	
	}
}
