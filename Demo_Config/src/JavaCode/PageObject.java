package JavaCode;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class PageObject {
	 
    private static WebDriver driver = null;
    //private static WebElement element = null;
    
@Test
  public void PageObjectDemo() {

    System.setProperty("webdriver.chrome.driver", "C://Automation//chromedriver_win32//chromedriver.exe");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--start-maximized");
    driver = new ChromeDriver(chromeOptions);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.shop.com/");
    //JavascriptExecutor js =(JavascriptExecutor)driver;
    //js.executeScript("window.scroll(0,1000)");
    
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email-acquire-overlay\"]/div/div/a"))).click();
    System.out.println("Successfully closed the start Popup");
   // WebElement web=driver.findElement(By.xpath("//*[@id=\"header\"]/section[2]/ul/li/a"));
    //Actions action=new Actions(driver);
    //action.moveToElement(web);
    //action.click().perform();
   //web.click();
    WebElement ele=null;
    List<WebElement> elements=driver.findElements(By.xpath("//*[@id='header']/section[2]/ul/li"));
    int count=elements.size();
    for(int i=1;i<=count;i++)
    {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ele=driver.findElement(By.xpath("//*[@id='header']/section[2]/ul/li["+i+"]/a"));
		System.out.println(ele.getText());
		//Actions action1=new Actions(driver);
	   // action1.moveToElement(ele);
	    //action1.click().perform();
		ele.click();
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if(actualTitle.equals("Shop Fashion | Clothes & Clothing Accessories | SHOP.COM"))
		{
			System.out.println("Clothes tab open successfully");
			
		}
		

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		// Continue with original browser (first window)
		
		
    }
   
    /*String str=driver.findElement(By.xpath("//span[@id='errormsg_0_Passwd']")).getText();
    if(str==null)
    {
    	System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
    }
    else {
    	
    	System.out.println(" Login failed, now it is the time to Log in again.");
    	
    	System.out.println(str);
         }
    
       // driver.quit();
    */
    driver.quit();
}



 }
