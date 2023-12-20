package testngsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest {
	
	//feature / API method 
	//WhiteBox testing : static analysis
	//two types of coverage
	//1. test coverage: 100%
	//2. code coverage: 100%
	//SonarQube, Jacoco, Cobertura Tools are used to automatic calculate for test coverage, code coverage and unit test coverage
	private int sum(int a, int b) {
		return a+b;
	}
	
	//user: Web application : Functional Testing
	public void calSum(int a , int b) {
		sum(a, b);
	}
	
	//test - Unit Test + assertion : UT : DEVS
	@Test
	public void test1() {
		Assert.assertEquals(sum(10, 20), 30);
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(sum(0, 20), 20);
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(sum(-10, 20), 10);
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(sum(-10, -20), -30);
	}
	
	
	
	
	
	
	
	
	

}
