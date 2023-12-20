package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsEmpty {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//driver.findElement(By.xpath("//input[@class='naveen']")).sendKeys("test");  //NoSuchElementException: no such element

		//List<WebElement> eles = driver.findElements(By.xpath("//input[@class='naveen']"));
		//System.out.println(eles); //empty
		//System.out.println(eles.size()); //0	
		
		By logo = By.cssSelector(".img-responsive");
		if(checkElementPresent(logo)) {
			System.out.println("logo is pass");
		}
		else {
			System.out.println("fail");
		}	
	}
	
	public static boolean checkElementPresent(By locator) {
		return driver.findElements(locator).size() ==1 ? true : false;	
	}

}
