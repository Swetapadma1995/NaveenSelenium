package SeleniumSession;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMInsideIFrame {

	public static void main(String[] args)   {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		
		//Browser -- page -- iFrame -- shadow DOM(open) -- e1
		
		driver.switchTo().frame("pact");
		
		String tea_script = "return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//html element --> Selenium WebElement
		WebElement tea = (WebElement)js.executeScript(tea_script);
		tea.sendKeys("Masala tea");
		
	}

}
