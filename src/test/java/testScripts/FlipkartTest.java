package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import genericUlities.BaseClass;

public class FlipkartTest extends BaseClass{
	
	@Test
	public void TestScript2() throws IOException, InterruptedException {
		
		 driver.get("https://www.tutorialspoint.com/");
		Thread.sleep(2000);
	}

}
