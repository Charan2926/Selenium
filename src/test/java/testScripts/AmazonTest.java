package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;
import genericUlities.BaseClass;

public class AmazonTest extends BaseClass {
	@Test
	public void Test1() throws IOException {
		 
		driver.get("https://www.amazon.in/");
		

	}
	

}
