package popups_Practice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calendarpopup {

	@Test
	public void HandlingCalendarpopups() {
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
	driver.findElement(By.xpath("//img[@id='jscal_trigger_sales_start_date']")).click();
	
	String day=driver.findElement(By.xpath("//td[@class='today day selected' and contains(text(),'22')]")).getText();
	System.out.println(day);
	}
}
