package genericUlities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
