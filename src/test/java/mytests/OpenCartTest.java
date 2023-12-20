package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {
	
	
	
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
	
	

}
