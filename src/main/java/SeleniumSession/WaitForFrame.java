package SeleniumSession;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForFrame {

	static WebDriver driver;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		
		//page
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		
		By image = By.cssSelector("#imageTemplateContainer");
		By frame = By.xpath("//iframe[contains(@id, 'frame-one')]");
		By textBox = By.id("RESULT_TextField-1");
		By header = By.cssSelector("h3.details__form-preview-title");
		
		waitForVisibilityOfElement(image, 10).click();
		
		waitForFrameByLocator(frame, 10);
		
		waitForVisibilityOfElement(textBox, 5).sendKeys("Test Automation");

		driver.switchTo().defaultContent();
		
		String headerValue = waitForVisibilityOfElement(header, 5).getText();
		System.out.println(headerValue);
		
		
		
	}
	
	public static void waitForFrameByLocator(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public static void waitForFrameByIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public static void waitForFrameByIDOrName(String IDOrName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IDOrName));
	}
	
	public static void waitForFrameByElement(WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public static WebElement waitForVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	
	
}
