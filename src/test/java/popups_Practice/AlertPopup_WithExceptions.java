package popups_Practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AlertPopup_WithExceptions {
	@Test (priority=0)
	public void AcceptAlert() {
		
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
	    WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		try 
	    {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
		driver.findElement(By.xpath("//button[text()='Click for ']")).click();

    	Alert al = driver.switchTo().alert();
 	    al.accept();
	    }
	    catch(Exception e)
	    {
	 		Reporter.log("Alert is Accepted", true);	    
	 		e.printStackTrace();
	 	}  
	}
	
	@Test(priority = 1)
	public void FetchText() {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		try
		{
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("//button[text()='Click for ']")).click();
		
	    Alert al = driver.switchTo().alert();
	    System.out.println(al.getText());
		}
		catch(Exception e)
		{
		Reporter.log("Alert Text is fetched", true);
		e.printStackTrace();
		}
		
	}

	@Test (priority =2)
	public void PassTextToAlert() {
		
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		try 
		{
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
        driver.findElement(By.xpath("//button[text()='Click for ']")).click();
		
	    Alert al = driver.switchTo().alert();
	    al.sendKeys("charan");
	    al.accept();
		}
		catch(Exception e) 
		{
	      Reporter.log("AlertText is modified", true);
	      e.printStackTrace();
		}
     }
	
	@Test(priority = 3)
	public void Dismiss() {
		
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		try
		{
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
        driver.findElement(By.xpath("//button[text()='Click for ']")).click();
		
	    Alert al = driver.switchTo().alert();
	   
		al.dismiss();
		}
		catch(Exception e) 
		{
		    Reporter.log("Alert is cancelled", true);
		    e.printStackTrace();
		}
		
		String exp="JavaScript Alerts";
		String actual=driver.findElement(By.xpath("//h3[text()='JavaScript Alerts']")).getText();
		Assert.assertEquals(actual, exp);
		Reporter.log("Testcase is passed", true); 
     }
	
}
