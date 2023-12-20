package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	//before -- test -- after
	
	/*
	 * BS -- Connect with DB 
	 * BT -- Create user 
	 * BC -- launch Browser 
	 * 
	 * BM -- login To App
	 * add To Cart test 
	 * AM -- logout 
	 * 
	 * BM -- login To App 
	 * checkout test 
	 * AM -- logout 
	 * 
	 * BM -- login To App 
	 * search test 
	 * AM -- logout 
	 * 
	 * AC -- close Browser 
	 * AT -- delete User
	 * AS -- disconnect With DB
	 */
	
	//@Before means preconditions
	
	//1st execution
	@BeforeSuite
	public void connectWithDB() {
		System.out.println("BS -- Connect with DB");
	}
	
	//2nd
	@BeforeTest
	public void createUser() {
		System.out.println("BT -- Create user");
	}
	
	//3rd
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC -- launch Browser");
	}
	
	//Each time @Test execute before @BeforeMethod will execute
	//4th/7th/10th
	@BeforeMethod
	public void loginToApp() {
		System.out.println("BM -- login To App");
	}
	
	//@Test means Test cases
	//@Test will execute in alphabetic order
	
	//11th
	@Test
	public void searchTest() {
		System.out.println("search test");
	}
	
	//5th
	@Test
	public void addToCartTest() {
		System.out.println("add To Cart test");
	}
	
	//8th
	@Test
	public void checkoutTest() {
		System.out.println("checkout test");
	}
	
	//Each time @Test execute after @AfterMethod will execute
	//6th/9th/12th
	@AfterMethod
	public void logout() {
		System.out.println("AM -- logout");
	}
	
	//13th
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC -- close Browser");
	}
	
	//14th
	@AfterTest
	public void deleteUser() {
		System.out.println("AT -- delete User");
	}
	
	//15th
	@AfterSuite
	public void disconnetWithDB() {
		System.out.println("AS -- disconnect With DB");
	}
	
	
	
	
	
	
	
	
	
	

}
