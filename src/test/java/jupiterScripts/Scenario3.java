package jupiterScripts;

import org.testng.annotations.Test;
import jupiterGeneric.BaseClass;
import objectRepository.Cartpage;
import objectRepository.HomePage;
import objectRepository.ShopPage;

public class Scenario3 extends BaseClass{
	@Test
	public void CartScenario() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.shop();
		
		ShopPage sp = new ShopPage(driver);
		sp.AddItemsToCart();
		
		hp.cart();
		
		Cartpage cp = new Cartpage(driver);
		cp.verifyPrices();
		cp.VerifySubTotals();
		cp.veriftTotal();
		
		driver.close();
		
		

	}

}
