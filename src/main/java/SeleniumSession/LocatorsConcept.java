package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		//1. id: is an attribute/property: unique -- 1st preference
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
		
		//2. name: is an attribute: can be duplicate -- 2nd preference
//		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		
		//3. className: is an attribute: duplicate -- 3rd preference
//		driver.findElement(By.className("form-control")).sendKeys("test@gmail.com");
		
		//4. xpath: is not an attribute. This is the address of the element in the HTML DOM. 
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("test@123");
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
//
//		By eid = By.id("input-email");		
//		By pwd = By.id("input-password");
//		By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		doSendKeys(eid, "test@gmail.com");
//		doSendKeys(pwd, "test@123");
//		doClick(loginBtn);
		
		//5. cssSelector: is not an attribute.
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.cssSelector("#input-password")).sendKeys("test@123");
//		driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
//	
//		By emailId = By.cssSelector("#input-email");
//		By password = By.cssSelector("#input-password");
//		By loginBtn = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
//		
//		doSendKeys(emailId, "test@gmail.com");
//		doSendKeys(password, "test@123");
//		doClick(loginBtn);
		
		//6. linkText: only for links. Link is not an attribute, this is the text of the link
		//html tag: <a> anchor tag
		//link text
		
//		driver.findElement(By.linkText("Register")).click();
//		
//		By registerLink = By.linkText("Register");
//		doClick(registerLink);
		
		//7. partialLinkText: only for links
		//html tag: <a> anchor tag
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//8. tagName: html tag
		//String header = driver.findElement(By.tagName("h2")).getText();
		//System.out.println(header);
		
		//By header = By.tagName("h2");
		//String headerValue = doElementGetText(header);
		//System.out.println(headerValue);
		//if(headerValue.equals("New Customer")) {
		//	System.out.println("Header is correct -- pass");
		//}
		//else {
		//	System.out.println("Fail");
		//}
		
		By logoImage = By.className("img-responsive");
		doClick(logoImage);
		
		//id -- 1
		//name --2
		//className -- 3
		
		//xpath 
		//css
		
		//linkText 
		//partialLinkText
		
		//tagName
		//in By class all the locators are available
		
		//id -- #
		//class -- .
		
	}
	
	public static String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static void doSendKeys(By locator , String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);	
	}
		
}
