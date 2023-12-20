package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException  {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		
		WebElement parentMenu = driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R2lmb6:']"));
		parentMenu.click();
		Actions act = new Actions(driver);
		By childMenu = By.xpath("(//a[text()='Beverages'])[2]");
		WebElement bevMenu = driver.findElement(childMenu);
		act.moveToElement(bevMenu).build().perform();
		
		Thread.sleep(2000);
		
		By grandChildMenu = By.xpath("//a[text()='Tea']");
		WebElement teaMenu = driver.findElement(grandChildMenu);
		act.moveToElement(teaMenu).build().perform();
		
		Thread.sleep(2000);
		By gChild = By.xpath("//a[text()='Green Tea']");
		WebElement greenTeaMenu = driver.findElement(gChild);
		act.moveToElement(greenTeaMenu).click().build().perform();
		
				
		
	}

}
