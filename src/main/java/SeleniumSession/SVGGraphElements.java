package SeleniumSession;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SVGGraphElements {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map");
		Thread.sleep(5000);
		
		//Browser -- page -- iframe -- svg
		
		String stateXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='g' and @class='region']";
		//51
		
		String subXpath = "//div[@id='map-component']/*[local-name()='svg']//*[name()='g']//*[name()='g']//*[name()='g' and @id='maryland']//*/child::*//*[@class='child']";
		//String subRegionXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='g' and @class='region']//*[name()='g' and @class='subregion']//*[name()='path']";
		//24
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		
		List<WebElement> statesList = driver.findElements(By.xpath(stateXpath));
		System.out.println(statesList.size());
		
		Actions act = new Actions(driver);
		for(WebElement e : statesList) {
			act.moveToElement(e).perform();
			Thread.sleep(500);
			String idValue = e.getAttribute("id");
			System.out.println(idValue);
				if(idValue.contains("maryland")) {
					e.click();
					break;
				}
		}
		Thread.sleep(5000);
		//new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(subXpath))));
		List<WebElement> subRegion = driver.findElements(By.xpath(subXpath));
		System.out.println(subRegion.size());
		for(WebElement eSub : subRegion) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eSub);
			act.moveToElement(eSub).perform();
			Thread.sleep(500);
			String nameValue = eSub.getAttribute("name");
			System.out.println(nameValue);
		}
		
		
		
	}

}
