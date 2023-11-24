package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
	//Declaration
	
		@FindBy(xpath="//h4[text()='Teddy Bear']")
		private WebElement teddybuylink;
		
		@FindBy(xpath="//h4[text()='Stuffed Frog']/..//a[@ng-click='add(item)']")
		private WebElement frogbuylink;
		
		@FindBy(xpath="//h4[text()='Fluffy Bunny']/..//a[@ng-click='add(item)']")
		private WebElement bunnyBuylink;
		
		@FindBy(xpath="//h4[text()='Valentine Bear']/..//a[@ng-click='add(item)']")
		private WebElement bearbuylink;
		
		//Intilialization
		public ShopPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getTeddybuylink() {
			return teddybuylink;
		}

		public WebElement getFrogbuylink() {
			return frogbuylink;
		}

		public WebElement getBunnyBuylink() {
			return bunnyBuylink;
		}

		public WebElement getBearbuylink() {
			return bearbuylink;
		}
		
		//Business library
		public void AddItemsToCart() {
			
			for(int i=0;i<2;i++) {
				
				frogbuylink.click();
			}
			
			for(int i=0;i<5;i++) 
			{
				bunnyBuylink.click();
			}
			for(int i=0;i<3;i++) 
			{
				bearbuylink.click();
			}	
			
		}
}
