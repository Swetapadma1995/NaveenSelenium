package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PsuedoElementHandle {

	static WebDriver driver;

	public static void main(String[] args)  {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// ::before
		// ::after
		
		
		  String script =
		  "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content');";
		  String css = "\"label[for='input-firstname']\"";
		  /* JavascriptExecutor js = (JavascriptExecutor)driver; 
		   */
		  //js.executeScript(script).toString();
		 
 		 
		WebElement fName = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		String fname_text = checkPsuedoEle(driver , css);
 		if (fname_text.contains("*")) {
			System.out.println("first name is mandatory");
		}


	}
	
	public static String checkPsuedoEle(WebDriver driver , String element)  {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return window.getComputedStyle(document.querySelector("+element+"), '::before').getPropertyValue('content');").toString();
		
	}
}
