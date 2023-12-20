package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsCloseSessinId {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); //session Id = 123
		driver.get("https://www.google.com");  //session Id = 123
		
		String actTitle = driver.getTitle();  //session Id = 123
		System.out.println("Title is: "+actTitle);  //session Id = 123
		
		//driver.quit(); //quit the browser  //session Id = 123
		//session Id = null
		
		driver.close(); //close the browser --> NoSuchSessionException: invalid session id
		
		//System.out.println(driver.getTitle()); //NoSuchSessionException : Session ID is null. Using WebDriver after calling quit()?
		
		driver = new ChromeDriver(); //session Id = 456
		driver.get("https://www.google.com");  //session Id = 456
		String t = driver.getTitle();
		System.out.println(t);  //session Id = 456...Google
		
		
		
		
	}

}
