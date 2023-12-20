package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDownConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("justAnInputBox")).click();
		
		List<WebElement> choiceList = driver.findElements(By.cssSelector("span.comboTreeItemTitle"));
		for(WebElement e : choiceList) {
/*			String text = e.getText();
			System.out.println(text);
				if(text.contains("choice 2")) {
					e.click();
					break;
				}
*/				
			try {
				e.click(); //ElementNotInteractableException: element not interactable
			}
			catch (ElementNotInteractableException ex) {
				System.out.println("drop down choices are over...");
				break;
			}
			
		}
		
		Thread.sleep(5000);
		driver.findElement(By.id("justAnInputBox1")).click();
		List<WebElement> choiceList1 = driver.findElements(By.cssSelector("span.comboTreeItemTitle"));
		for(WebElement e : choiceList1) {
/*			String text1 = e.getText();
			System.out.println(text1);
				if(text1.contains("choice 4")) {
					e.click();
					break;
				}
*/				
			try {
			e.click();
			}
			catch (ElementNotInteractableException ex) {
				//System.out.println("drop down choices are over...");
				//break;
			}
		}
		
		Thread.sleep(2000);
		driver.findElement(By.id("justAnotherInputBox")).click();
		List<WebElement> choiceList2 = driver.findElements(By.cssSelector("span.comboTreeItemTitle"));
		for(WebElement e : choiceList2) {
			String text2 = e.getText();
			System.out.println(text2);
				if(text2.contains("choice 6 1")) {
					e.click();
					break;
				}
		}
		
		
	}

}
