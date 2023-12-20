package SeleniumSession;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");
		Thread.sleep(3000);
		String book = "return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement bookName = (WebElement)js.executeScript(book);
		bookName.sendKeys("Ramayan");
	
	}

}
