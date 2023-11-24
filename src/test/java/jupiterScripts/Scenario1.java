 package jupiterScripts;

import org.testng.annotations.Test;

import jupiterGeneric.BaseClass;
import objectRepository.ContactPage;
import objectRepository.HomePage;

public class Scenario1 extends BaseClass {
	@Test
	public void VerifyErrorData() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.contact();
		
		ContactPage cp = new ContactPage(driver);
		cp.verifyErrorAddData();
		
	}

}
