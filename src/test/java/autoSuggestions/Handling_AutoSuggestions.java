package autoSuggestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUlities.PracticeBaseClass;

public class Handling_AutoSuggestions extends PracticeBaseClass {
	@Test 
	public void FetchallAutoSuggestions() throws InterruptedException {
		WebElement elem=driver.findElement(By.id("search"));
		elem.sendKeys("Tees");
		elem.sendKeys(Keys.SPACE);
		
		WebDriverWait wb=new WebDriverWait(driver, 30);
		wb.until(ExpectedConditions.elementToBeClickable(elem));
		
		Reporter.log("input is given",true);
		
		List<WebElement> list = driver.findElements(By.xpath("//li[@role='option']"));
		for (WebElement ele : list) 
		{
			System.out.println(ele.getText());	
		}	
		Reporter.log("All autosuggestions are fetched", true);
		
		String Actual=driver.getTitle();
		System.out.println(Actual);
		Assert.assertEquals(Actual.contains("Home"), true);
		Reporter.log("Auto suggestions are handled",true);
	}
}
