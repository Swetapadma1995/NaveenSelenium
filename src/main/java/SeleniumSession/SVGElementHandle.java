package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElementHandle {

	public static void main(String[] args) throws InterruptedException {
		
		//SVG --> Scalable Vector Graphics
		//cannot use css for SVG
		//only xpath is applicable: special xpath syntax
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		Thread.sleep(5000);
		
		//Always SVG xpath written by "local-name()" attribute
		
		driver.findElement(By.name("q")).sendKeys("Macbook");
		driver.findElement(By.xpath("//button//*[local-name()='svg']")).click();
		
		
		
	}

}
