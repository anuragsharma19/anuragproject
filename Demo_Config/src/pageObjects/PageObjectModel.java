package pageObjects;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class PageObjectModel {

	private static WebDriver driver = null;

	@Test
	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches", "--disable-extensions");
		// System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir")
		// + "//src//test//resources//chromedriver_new.exe"));
		System.setProperty("webdriver.chrome.driver",
				"C://Automation//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver(options);

		//driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		System.out.println("Open Browser Successfull");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.get("http://www.store.demoqa.com");
		driver.navigate().to("http://www.store.demoqa.com");
		
		// Use page Object library now

		Home_Page.lnk_MyAccount(driver).click();

		LogIn_Page.txtbx_UserName(driver).sendKeys("testuseran");

		LogIn_Page.txtbx_Password(driver).sendKeys("Anu@1234");

		LogIn_Page.btn_LogIn(driver).click();
		
		if(driver.findElement(By.id("account_logout")) != null)
		{
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
			
		}
		else{
		System.out.println(" Login UnSuccessfull.");
		}
		
		My_Account.lnk_LogOut(driver).click();

		driver.quit();

	}

}
