package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {
	
	//Declaration
	@FindBy(xpath="//table//tbody//tr[@class='cart-item ng-scope']//td[normalize-space()='Stuffed Frog']/..//td[text()='$10.99']")
	private WebElement  frogprice;
	
	@FindBy(xpath="//table//tbody//tr[@class='cart-item ng-scope']//td[normalize-space()='Fluffy Bunny']/..//td[text()='$9.99']")
	private WebElement  bunnyPrice;
	
	@FindBy(xpath="//table//tbody//tr[@class='cart-item ng-scope']/td[text()=' Valentine Bear']/../td[text()='$14.99']")
	private WebElement bearprice;
	
	@FindBy(xpath="//table//tbody//tr[@class='cart-item ng-scope']//td[normalize-space()='Stuffed Frog']/..//td[text()='$21.98']")
	private WebElement stfrog;
	
	@FindBy(xpath="//table//tbody//tr[@class='cart-item ng-scope']//td[normalize-space()='Fluffy Bunny']/..//td[text()='$49.95']")
	private WebElement stbunny;

	@FindBy(xpath="//table//tbody//tr[@class='cart-item ng-scope']//td[normalize-space()='Valentine Bear']/..//td[text()='$44.97']")
	private WebElement stbear;
	
	@FindBy(xpath="//strong[.='Total: 116.9']")
	private WebElement  totalsum;
	
	//Intialization
	public Cartpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utiliazation
	public WebElement getFrogprice() {
		return frogprice;
	}

	public WebElement getBunnyPrice() {
		return bunnyPrice;
	}

	public WebElement getBearprice() {
		return bearprice;
	}

	public WebElement getStfrog() {
		return stfrog;
	}

	public WebElement getStbunny() {
		return stbunny;
	}

	public WebElement getStbear() {
		return stbear;
	}

	public WebElement getTotal() {
		return totalsum;
	}
	
	//Buniess libraries
	public void verifyPrices() throws InterruptedException {
		
		if(frogprice.getText().contains("$10.99")) 
		{
			System.out.println("Price of stuffed frog is matched");
		}
		if(bunnyPrice.getText().contains("$9.99")) 
		{
			System.out.println("Price of Bunny is matched");
		}
		if(bearprice.getText().contains("$14.99")) 
		{
			System.out.println("Price of stuffed frog is matched");
		}
		Thread.sleep(2000);
	}
	
	public void VerifySubTotals() throws InterruptedException {
		
		if(stfrog.getText().contains("$21.98")) 
		{
			System.out.println("Subtotal of stuffed frog is matched");
		}
		if(stbunny.getText().contains("$49.95")) 
		{
			System.out.println("Subtotal of Bunny is matched");
		}
		if(stbear.getText().contains("$44.97")) 
		{
			System.out.println("Subtotal of stuffed frog is matched");
		}
		Thread.sleep(2000);
		
	}
			
	public void veriftTotal() throws InterruptedException {
		
		Thread.sleep(2000);
		String exp_total="116.9";
		String actual=totalsum.getText();
		if(actual.contains(exp_total)) 
		{
			System.out.println("Total is equal to sum of all three items");
		}
		else 
		{
			System.out.println("Total is not equal");
		}
	}
	
	
		
}
