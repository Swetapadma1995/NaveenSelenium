package SeleniumSession;

public class OpenCartTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		br.launchBrowser("chrome");
		br.launchURL("https://naveenautomationlabs.com/opencart/");
		String actualTitle = br.getPageTitle();
		if(actualTitle.equals("Your Store")) {
			System.out.println("title is correct -- PASS");
		}
		else {
			System.out.println("title is incorrect -- FAIL");
		}
		
		String actualUrl = br.getPageURL();	
		if(actualUrl.contains("opencart")) {
			System.out.println("url is correct -- PASS");
		}
		
		br.closeBrowser();
		
	}

}
