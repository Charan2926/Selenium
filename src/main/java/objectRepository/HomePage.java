package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Declaration
	
	@FindBy(xpath="//li[@id='nav-home']")
	private WebElement homelink;
	
	@FindBy(xpath="//li[@id='nav-shop']")
	private WebElement shoplink;
	
	@FindBy(xpath="//li[@id='nav-contact']")
	private WebElement contactlink;
	
	@FindBy(xpath="//i[@class='icon icon-shopping-cart icon-white']")
	private WebElement cartlink;
	
	//Intilialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utiliazation
	public WebElement getHomelink() {
		return homelink;
	}

	public WebElement getShoplink() {
		return shoplink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	
	
	public WebElement getCartlink() {
		return cartlink;
	}

	//Busniess Library
	public void contact() {
		
	contactlink.click();
	}	
	public void shop() {
		shoplink.click();
	}
	public void cart() {
		cartlink.click();
	}

}
