package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//browser 118 --> 118.exe //download --> download chromedriver --> WebDriver for chrome --> chrome for Testing(CFT) availablity dashboard --> download your version .exe file
		//4.5.0
		
		driver.get("https:\\www.google.com");
		
		//4.6.0+ --> 4.13.0
		//browser 118 --> download 118.exe from CFT dashboard in your .cache folder and will start the server automatically
		
		
		
	}

}
