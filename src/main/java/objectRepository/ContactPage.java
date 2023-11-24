package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	//Declaration
	@FindBy(name="forename")
	private WebElement nameTextField;
	
	@FindBy(id="email")
	private WebElement emailTextField;
	
	@FindBy(id="message")
	private WebElement messagefield;
	
	@FindBy(xpath="//a[text()='Submit']")
	private WebElement Submitbutton;
	
	@FindBy(xpath="//div[@class='alert alert-error ng-scope']")
	private WebElement Errormessage;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successmessage;
	
	//Intilialization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utiliazation

	public WebElement getNameTextField() {
		return nameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getMessagefield() {
		return messagefield;
	}

	public WebElement getSubmitbutton() {
		return Submitbutton;
	}

	public WebElement getErrormessage() {
		return Errormessage;
	}
	
	public WebElement getSuccessmessage() {
		return successmessage;
	}

	//Bussniess library
	public void verifyErrorAddData() throws InterruptedException {
		Submitbutton.click();
		Thread.sleep(2000);
		String error=Errormessage.getText();
		if(error.contains(" but we won't get it unless you complete the form correctly."))
		{
			System.out.println("new Contact cant be created without mandatory dertails ");
		}
		Thread.sleep(2000);
		nameTextField.sendKeys("ramcharan");
		emailTextField.sendKeys("charan1164@mail.com");
		messagefield.sendKeys("new product");
		Submitbutton.click();
		Thread.sleep(2000);
		
		String message=successmessage.getText();
		if(message.contains(" we appreciate your feedback.")) 
		{
			System.out.println("Data is added successfully without any errors");
		}
		
	}
	public void AddDataAndVerify() throws InterruptedException {
		nameTextField.sendKeys("ramcharan");
		emailTextField.sendKeys("charan1164@mail.com");
		messagefield.sendKeys("new product");
		Submitbutton.click();
		Thread.sleep(2000);
		String succes=successmessage.getText();
		if(succes.contains(" we appreciate your feedback.")) 
		{
			System.out.println("Data is added successfully");
		}
	}
		
}
