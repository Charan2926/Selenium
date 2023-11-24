package jupiterScripts;

import java.io.IOException;
import org.testng.annotations.Test;
import jupiterGeneric.BaseClass;
import objectRepository.ContactPage;
import objectRepository.HomePage;

public class Scenario2 extends BaseClass {
	
	@Test(invocationCount = 5)
	public void scenario1() throws IOException, InterruptedException {
						
		HomePage hp = new HomePage(driver);
		hp.contact();
		
		ContactPage cp = new ContactPage(driver);
		cp.AddDataAndVerify();
		
	}

}
