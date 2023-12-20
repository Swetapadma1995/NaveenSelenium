package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TopCastingOptions {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//local machine but only for the specific browser
				//1. ChromeDriver driver = new ChromeDriver();
				
				//valid + recommended : local machine + cross browser
				//2. WebDriver driver = new ChromeDriver();
				
				//valid + not recommended beacuse we can only access the SearchContext methods 
				//3. SerchContext driver = new ChromeDriver(); 
				
				//valid + recommended (if in future any browser is coming which is not extending RemoteWebDriver then cannot access methods of WenDriver and SerchContext)
				//4. RemoteWebDriver driver = new ChromeDriver();
				
				//valid + recommened: to run tests on grid/remote machine/cloud
				//5. WebDriver driver = new RemoteWebDriver(remoteAddress, capabilities);
				
				//valid + not recommended (only for chrome and edge)
				//6. ChromiumDriver driver = new ChromeDriver();  
				
		
		
		
	}

}
