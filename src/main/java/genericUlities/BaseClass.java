package genericUlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public DataBaseUtility dlib = new DataBaseUtility();
	public FileUtility flib = new 	FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	
	public static WebDriver driver;
	
	
	@BeforeSuite
	public void config_Bs() throws Throwable 
	{
		//dlib.connectToDatabase();
		System.out.println("-----connect to DataBase-------");	
	}
	
	        @Parameters( "BROWSER")
			@BeforeClass
			public void config_BC() throws Throwable {
				
				String BROWSER = flib.fetchdatafromFile("browser");
				
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
					System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
					WebDriver driver= new ChromeDriver(options);
				}
				
				else 
				{
					WebDriverManager.firefoxdriver().setup();
					WebDriver driver = new FirefoxDriver();
				}
				
				
				
				System.out.println("-----Launch the Browser----------");
				
				wlib.maximize(driver);
			}
		
		@BeforeMethod
		public void config_BM() throws Throwable {
			
			wlib.implicitlyWait(driver);
			System.out.println("------Login into the aplication-------");
		}
		
		@AfterMethod
		public void config_AM() {
			System.out.println("----logout of the application----");
		}
		
		@AfterClass
		public void config_AC() {
			driver.quit();
			System.out.println("---------Close the browser-------");
		}
		
		@AfterSuite
		public void config_AS() throws Throwable {
			//dlib.DisconectFromDatabase();
			System.out.println("-----Close DataBase connection------");
		}
    
	
}
