import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class task {
    public static void main(String[] args) throws Exception {
	        WebDriver driver = new ChromeDriver();
	      try {
		        // Navigate to website and verify that it displayed correctly 
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        driver.get("https://www.zengo.com");
		        //maximize the website window
		        driver.manage().window().maximize();
		       
		        // Move the mouse to hover over the "assets" menu
		        WebElement assetsMenu = driver.findElement(By.linkText("Assets"));
		        Actions actionProvider = new Actions(driver);
		        // Wait for the sub menu to be visible and click on the "Etherium" link
		        actionProvider.moveToElement(assetsMenu).build().perform();
		        WebElement ethSubMenuItem = driver.findElement(By.linkText("Ethereum (ETH)"));
		        ethSubMenuItem.click();
		        
		
		        // Go back to main page and verify that it displayed correctly
		        driver.navigate().back();
		        boolean isLogoVisible = driver.findElement(By.xpath("//img[@alt='zengo logo']")).isDisplayed();
		        if (!isLogoVisible) {
		            throw new Error("Logo is not displayed");
		        }
		        // We wait for 2 seconds just because we are human and want to see stuff :)
		        Thread.sleep(2000);
	       }
	       catch(Exception error)
	       {
	    	   throw(error);
	       }
	      finally 
	      {
	    	  driver.quit();
	      }  
    }
}
