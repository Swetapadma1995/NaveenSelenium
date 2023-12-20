package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//driver.get("https://classic.crmpro.com/");
		//driver.get("https://www.amazon.com");
		//driver.get("https://app.hubspot.com/login");
		//driver.get("https://login.yahoo.com/");
		
		//JavaScriptExecutor js = (JavaScriptExecutor)driver;
		
		//JavaScriptExecutor --> interface
		//RemoteWebDriver imp JavaScriptExecutor
		//JavaScriptExecutor --> executeScript(script)
		//script --> executeScript(script) -->it will be executed on the browser -- page
		
		//document --> internal object of the browser
		//title --> property
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//String title = js.executeScript("return document.title").toString();
		// return --> javascript return
		//System.out.println(title);
		
		//String URL = js.executeScript("return document.URL").toString();
		//System.out.println(URL);
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		//String text = jsUtil.getTitleByJs();
		//System.out.println(text);
		
		//String url = jsUtil.getURLByJs();
		//System.out.println(url);
		
		//jsUtil.generateJSAlert("Hello Java");
		
		//String pageText = js.executeScript("return document.documentElement.innerText").toString();
		//System.out.println(pageText);
		//if(pageText.contains("Group Calendar")) {
		//	System.out.println("Group Calendar -- pass");
		//}
		
		//Thread.sleep(1000);
		//jsUtil.scrollPageDown();
		//Thread.sleep(1000);
		//jsUtil.scrollPageUp();
		
		//WebElement callEle = driver.findElement(By.xpath("//h3[normalize-space()='Calls & Voice']"));
//		jsUtil.scrollIntoView(callEle);
		//jsUtil.drawBorder(callEle);
		
		//WebElement loginForm = driver.findElement(By.id("hs-login"));
		//jsUtil.drawBorder(loginForm);
		
		//WebElement userName = driver.findElement(By.id("username"));
		//WebElement password = driver.findElement(By.id("password"));
		//jsUtil.flash(userName);
		//userName.sendKeys("test@gmail.com");
		//jsUtil.flash(password);
		//password.sendKeys("test@123");
		
		//WebElement rem = driver.findElement(By.id("remember"));
		//jsUtil.clickElementByJS(rem);
		
		//WebElement stay = driver.findElement(By.id("persistent"));
		//jsUtil.clickElementByJS(stay);
		
		jsUtil.sendKeysUsingWithId("input-email" , "tom@gmail.com");
		
		
	}

}
