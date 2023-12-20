package SeleniumSession;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		//wait(I) intil(); <--- FluentWait(Class)  until(){} + other methods  <--- WebDriverWait(Class)
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginButton = By.xpath("//input[@value='Login']");
		By abutUsLink = By.linkText("About Us");
		
		//WebDriverWait without fluent wait features:
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		
		/*
		 * //WebDriverWait with fluent wait features: WebDriverWait wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.pollingEvery(Duration.ofSeconds(10))
		 * .ignoring(NoSuchElementException.class)
		 * .withMessage("--time out is done...element is not found...");
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
		 */
		
		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(10)) .pollingEvery(Duration.ofSeconds(2))
		 * .withMessage("--time out is done...element is not found...")
		 * .ignoring(NoSuchElementException.class);
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(emailId)).sendKeys(
		 * "test@gmail.com");
		 */
		
		waitForElementWithFluentWait(emailId, 10, 2).sendKeys("test@gmail.com");
	}

	public static WebElement waitForElementWithFluentWait(By locator , int timOut , int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timOut))
				.pollingEvery(Duration.ofSeconds(intervalTime))
				.withMessage("--time out is done...element is not found...")
				.ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
}
