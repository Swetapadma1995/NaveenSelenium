package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

		//webelement:
		//create the webelement + perform an action(click, sendkeys, getText, isDisplayed)
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//DOM: Document Obeject Model: HTML code
		//1st:
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");
		
		//2nd: 
//		WebElement emailId = driver.findElement(By.id("input-email"));
//  	WebElement password = driver.findElement(By.id("input-password"));
		
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");
		
		//3rd: by locator
//		By eid = By.id("input-email");		
//		By pwd = By.id("input-password");
		
//		WebElement emailId = driver.findElement(eid);
//		WebElement password = driver.findElement(pwd);
		
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");
		
		//4th: By locator + generic methods
//		By eid = By.id("input-email");		
//		By pwd = By.id("input-password");

//		getElement(eid).sendKeys("test@gmail.com");
//		getElement(pwd).sendKeys("test@123");
		
		//5th: By locator + generic method for element and action
//		By eid = By.id("input-email");		
//		By pwd = By.id("input-password");
		
//		doSendKeys(eid, "test@gmail.com");
//		doSendKeys(pwd, "test@123");
	
		//6th: By locator + generic method for element and action
//		By eid = By.id("input-email");		
//		By pwd = By.id("input-password");
		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(eid, "test@gmail.com");
//		eleUtil.doSendKeys(pwd, "test@123");
		
		//7th: BrowserUtil + ElementUtil
		
		//8th: By locators -->String locators
		String email_id = "input-email";
		String pwd_id = "input-password";
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", email_id, "sweta@gmail.com");
		eleUtil.doSendKeys("id", pwd_id, "sweta@123");
		
		
		//9th: POM + framework
		
		}
		
		public static void doSendKeys(By locator , String value) {
			getElement(locator).sendKeys(value);
		}
	
		public static WebElement getElement(By locator) {
			return driver.findElement(locator);
			
		}

}
