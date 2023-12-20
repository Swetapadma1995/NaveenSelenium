package testngsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/");
	}
	
	
	//-ve
	//no prio -- alphabetic
	//+ve
	
	//no prio -- alphabetic
	//+ve 
	
	//no prio -- alphabetic
	
	//also we can write
	//@Test(priority = Integer.MAX_VALUE)
	//@Test(priority = Integer.MIN_VALUE)
	@Test(priority = 1)
	public void isOpenCartLogoVisibleTest() {
		Boolean flag = driver.findElement(By.xpath("//*[@id=\"logo\"]/a/img")).isDisplayed();
		Assert.assertEquals(true, flag);
	}
	
	@Test(priority = 3)
	public void OpenCartTitleTest() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Your Store");
	}

	@Test(priority = 2)
	public void OpenCartURLTest() {
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL);
		Assert.assertTrue(actualURL.contains("opencart"));
	}
	
	@Test
	public void aTest() {
		System.out.println("atest");
	}
	
	@Test
	public void bTest() {
		System.out.println("bTest");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	

}
