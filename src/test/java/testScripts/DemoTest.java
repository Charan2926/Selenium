package testScripts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DemoTest {
	@Test
	public void TestScript() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		ChromeDriver  driver= new ChromeDriver(options);
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		
	}

}
