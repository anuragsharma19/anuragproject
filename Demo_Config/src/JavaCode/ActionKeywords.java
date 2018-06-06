package JavaCode;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.ExcelUtils;
import utility.Log;
 
public class ActionKeywords {
 
		public static WebDriver driver;
		private static WebElement element = null;
		
 @Test
	public static void openBrowser(){		
	 System.setProperty("webdriver.chrome.driver", "C://Automation_Demo//chromedriver_win32//chromedriver.exe");
				driver = new ChromeDriver();
		}
 
 	public static void navigate(){	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.store.demoqa.com");
		}
 
	public static void click_MyAccount(){
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		Log.info("My Account link element found");
		}
 
	public static void input_Username() throws Exception{
		
		String sUserName = ExcelUtils.getCellData(4, 4);
		 System.out.println("Username :" + sUserName);
		driver.findElement(By.id("log")).sendKeys(sUserName); 
		}
 
	public static void input_Password() throws Exception{
		
		String sUserName = ExcelUtils.getCellData(5, 4);
		driver.findElement(By.id("pwd")).sendKeys(sUserName);
		}
 
	public static void click_Login(){
		driver.findElement(By.id("login")).click();
		}
 
	public static void waitFor() throws Exception{
		Thread.sleep(5000);
		}
 
	public static void click_Logout(){
		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
		}
 
	public static void closeBrowser(){
		System.out.println("Success");
			driver.quit();
		}
 
	}