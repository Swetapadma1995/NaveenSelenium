package SeleniumSession;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//Implicitly wait:
		//Dynamic wait
		//Global wait : it is applied for all the web elements (only for webelement)
		//applied after the driver initialization
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //selenium 3.x(deprecated this method)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //selenium 4.x
		
		//login page : 10 secs
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
		//driver.findElement(By.id("input-email11")).sendKeys("test@gmail.com"); //NoSuchElementException 
		//element1 --> 10 secs --> if element is visible in 2 secs --> 8 secs is ignored
		//element1 --> 10 secs --> if elemeny is not found in 10 secs the it will throw NoSuchElementException 
		
		//element2
		//element3
		//element4
		//element50 --> for all these elements we have to wait 10 secs
		
		//home page : 20 secs
		//override this method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//element51 : 20 secs
		//element52 : 20 secs
		
		//login page :
		//element1 : 20 secs
		//element2 : 20 secs
		
		//registration page : 5 secs
		//override this method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//RegEle : 50 secs
		
		//Once this is declared after this line all the elements in the script will follow the same rule/ follow the same number of wait. 
		//That's why it is called Global wait.
		
		//page : 0 secs : nullification of implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		//element53 to element58 : 0 secs
		
		//emailId: 10 secs : 2 secs : 8 secs will be ignored
		//password : 10 secs : 0 secs : 10 secs will be ignored
		//login button : 10 secs : 0 secs : 10 secs will be ignored
		
		//implicit wait can not be used with non web elements (alerts, title, url)
		
		//to optimize the wait : explicit wait : for the specific element
		//emailId: 10 secs : 2 secs : 8 secs will be ignored
		//password : no wait applied
		//login button : no wait applied
		
		//explicit wait can be used for web elements

		//alert : 5 secs
		//driver.switchto.alert();
		
	}

}
