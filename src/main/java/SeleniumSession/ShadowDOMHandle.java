package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
		//ShadowDOM always supports CSS
		//Browser -- page -- shadow DOM -- shadow DOM -- e1
		
		Thread.sleep(3000);
		//driver.findElement(By.id("pizza"));
		
		String pizza_script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
		//String pizza_script = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
		//html element
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//html element --> Selenium WebElement
		WebElement pizza = (WebElement)js.executeScript(pizza_script);
		pizza.sendKeys("veg pizza");
		
		
	}

}

	//SVG: local-time() --> name()
	//shadow down: css