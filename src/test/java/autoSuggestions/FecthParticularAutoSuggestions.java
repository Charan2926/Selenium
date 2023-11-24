package autoSuggestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUlities.PracticeBaseClass;

public class FecthParticularAutoSuggestions extends PracticeBaseClass {
	@Test 
	public void HandlingAutoSuggestions() throws InterruptedException {
	WebElement elem=driver.findElement(By.id("search"));
	elem.sendKeys("Tees");
	elem.sendKeys(Keys.SPACE);

	WebDriverWait wb=new WebDriverWait(driver, 30);
	wb.until(ExpectedConditions.elementToBeClickable(elem));
	
	List<WebElement> list = driver.findElements(By.xpath("(//li[@role='option'])[3]"));
	for (WebElement Partele : list) 
	{
		String text=Partele.getText();
		System.out.println(text);
		elem.sendKeys(text);	
	}	
	
	WebElement el=driver.findElement(By.xpath("//a[@class='product photo product-item-photo']//following-sibling::div//strong//a[contains(text(),'Ingrid Running Jacket')]"));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", el);
	el.click();
	
	WebElement pp=driver.findElement(By.xpath("//span[text()='$84.00']"));
	String pprice=pp.getText();
	int ppp=Integer.parseInt(pprice);  
	System.out.println(ppp);
	
	driver.findElement(By.xpath("//div[@id='option-label-size-143-item-166']")).click();
	driver.findElement(By.xpath("//div[@id='option-label-color-93-item-56']")).click();
	WebElement qnt=driver.findElement(By.xpath("//input[@name='qty']"));
	qnt.clear();
	qnt.sendKeys("100");
	
	WebElement cart=driver.findElement(By.xpath("//span[text()='Add to Cart']"));
	cart.click();
	wb.until(ExpectedConditions.elementToBeClickable(cart));
	
	
	
	
	
	
//	
//	String Actual=driver.getTitle();
//	System.out.println(Actual);
//	Assert.assertEquals(Actual.contains("Tees"), true);
//	Reporter.log("Auto suggestions are handled",true);

  }
}
