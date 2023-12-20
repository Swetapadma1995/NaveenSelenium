package mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {
	
	
	
	@Test(priority = 1)
	public void amazonTitleTest() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertTrue(actualTitle.contains("amazon"));
	}

	@Test(priority = 2)
	public void amazonURLTest() {
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL);
		Assert.assertTrue(actualURL.contains("amazon"));
	}
	
	
	

}
