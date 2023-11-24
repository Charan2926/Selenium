package interview_scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon_output_print_into_excel {
	@Test
	public void Test() {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		ChromeDriver  driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[@role='button']")).click();
		driver.findElement(By.name("q")).sendKeys("Iphones");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

}
