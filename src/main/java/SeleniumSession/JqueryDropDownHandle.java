package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDownHandle {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectmenu/");
		
		driver.switchTo().frame(0);
		
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("span#speed-button")).click();
		Thread.sleep(2000);
		List<WebElement> optionsList = driver.findElements(By.cssSelector("ul#speed-menu div"));
		System.out.println(optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
				if(text.equals("Fast")) {
					e.click();
					break;
				}
		}
		
		//
		System.out.println("--------------------");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span#files-button")).click();
		Thread.sleep(2000);
		List<WebElement> jOption = driver.findElements(By.cssSelector("ul#files-menu div"));
		System.out.println(jOption.size());
		
		for(WebElement e : jOption) {
			String text1 = e.getText();
			System.out.println(text1);
				if(text1.equals("ui.jQuery.js")) {
					e.click();
					break;
				}
		}
		
		//
		System.out.println("---------------------");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span#number-button")).click();
		Thread.sleep(2000);
		List<WebElement> numberOption = driver.findElements(By.cssSelector("ul#number-menu div"));
		System.out.println(numberOption.size());
		
		for(WebElement e : numberOption) {
			String text2 = e.getText();
			System.out.println(text2);
				if(text2.equals("15")) {
					e.click();
					break;
					}
		}
		
		//
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("span#salutation-button")).click();
		Thread.sleep(2000);
		List<WebElement> salutstionList = driver.findElements(By.cssSelector("ul#salutation-menu div"));
		System.out.println(salutstionList.size());
		
		for(WebElement e : salutstionList) {
			String text3 = e.getText();
			System.out.println(text3);
				if(text3.equals("Dr.")) {
					e.click();
					break;
				}
		}
		
	}

}
