package SeleniumSession;

public class Amazon {

	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		br.launchBrowser("chrome");
		br.launchURL("https://www.amazon.com");
		String actualTitle = br.getPageTitle();
		if(actualTitle.contains("Amazon.com")) {
			System.out.println("title is correct -- PASS");
		}
		else {
			System.out.println("title is incorrect -- FAIL");
		}
		
		String actualUrl = br.getPageURL();	
		if(actualUrl.contains("https")) {
			System.out.println("url is correct -- PASS");
		}
		
		boolean pageSource = br.getPageSource("window");
	
		br.closeBrowser();
		
		
		
		
	}

}
