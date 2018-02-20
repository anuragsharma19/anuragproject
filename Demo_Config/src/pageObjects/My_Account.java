package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class My_Account {
 
        private static WebElement element = null;
 
        public static WebElement lnk_LogOut(WebDriver driver){
    	 
         element = driver.findElement(By.id("account_logout"));
 
         return element;
 
         }
 
}
