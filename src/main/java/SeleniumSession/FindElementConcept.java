package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//driver.findElement(By.id("input-email1111")).sendKeys("test@gmail.com"); 
		//NoSuchElementException: no such element: Unable to locate element
		
		//driver.findElement(By.id("input-email")).sendKeys(123);//we can't pass numeric value
		//int totalBill = 123;
		//String totalBillAmount = String.valueOf(totalBill);
		//driver.findElement(By.id("input-email")).sendKeys(totalBillAmount);
		
		//driver.findElement(By.id("input-email")).sendKeys(null);
		//IllegalArgumentException: Keys to send should be a not null CharSequence
		
		//seendKeys: String, StringBuilder, StringBuffer
		StringBuilder sb = new StringBuilder("test@gmail.com");
		//driver.findElement(By.id("input-email")).sendKeys(sb);
		
		driver.findElement(By.id("input-email")).sendKeys(sb+"automation");
		//CharacterSequence <-- String, StringBuilder, StringBuffer		
	}

}
