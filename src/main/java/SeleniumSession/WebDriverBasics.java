package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverBasics {
		static WebDriver driver;
	public static void main(String[] args) {
		
		//1. open the browser: chrome
				//2. enter url:
				//3. get the title
				//4. verify the title: act vs exp
				//5. close the browser
				
				//Automation Steps
				//ChromeDriver driver = new ChromeDriver();
				//FirefoxDriver driver = new FirefoxDriver();
				//EdgeDriver driver = new EdgeDriver();
				
				String browser = "chrome";
				
				//cross browser logic: with top casting: parallel testing
				switch (browser.toLowerCase().trim()) {
				case "chrome":
					driver = new ChromeDriver();
					break;
				case "edge":
					driver = new EdgeDriver();
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				case "safari":
					driver = new SafariDriver();
					break;
				default:
					System.out.println("please pass the right browser.");
					break;
				}
				
				
				//if browser = "opera" then next the shows NullPoinerExecption 
				driver.get("https://www.google.com");
				//driver.get("www.google.com"); //InvalidArgumentException
				
				String actTitle = driver.getTitle();
				System.out.println("Title is: "+actTitle);
				
				//verification point/checkpoint/act vs exp result: testing
				if(actTitle.equals("Google")) {
					System.out.println("title is correct--PASS");
				}
				else {
					System.out.println("title is not correct--FAIL");
				}
				
				String appURL = driver.getCurrentUrl();				
				System.out.println(appURL);
				if(appURL.contains("google")) {
					System.out.println("url is correct -- PASS");
				}
				
				String pageSource = driver.getPageSource();
				System.out.println(pageSource);
				if(pageSource.contains("Google apps")) {
					System.out.println("PASS");
				}
				
				//close the browser
				driver.quit();
		
	}

}
