package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketMenuHandle {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		
		By parentShopByMenu = By.xpath("(//span[text()='Shop by'])[2]");
		By beverageSecondMenu = By.linkText("Beverages");
		By teaThirdMenu = By.linkText("Tea");
		By greenTeaFourthMenu = By.linkText("Green Tea");
		
		Actions act = new Actions(driver);
		
		driver.findElement(parentShopByMenu).click();
		
		Thread.sleep(1000);
		
		act.moveToElement(driver.findElement(beverageSecondMenu)).build().perform();
		
		Thread.sleep(1000);
		
		//Nov 2
		
		
		
		driver.findElement(greenTeaFourthMenu).click();
		
		
		
		
		
		
	}

}
