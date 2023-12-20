package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	@Test
	public void loginTest() {
		System.out.println("login to app");
		int i = 9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void searchHomePageTest() {
		System.out.println("search test");
	}
	
	@Test(dependsOnMethods = "searchHomePageTest")
	public void addToCartTest() {
		System.out.println("add to cart");
	}
	
	//AAA pattern : Arrange, Act and Assert
	//should not have no dependency
	//should not have no priority
	//test cases / methods should be independent
	
	//One test for only one Assertion
	
	
	

}
