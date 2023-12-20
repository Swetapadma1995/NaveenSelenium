package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
	String name;
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void loginTest() {
		System.out.println("login step");
		int i = 4/0;
		System.out.println("bye");
	}
	
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void loginTest1() {
		System.out.println("login step");
		int i = 4/0;
		
		ExpectedExceptionConcept obj = null;
		System.out.println(obj.name);
		System.out.println("bye");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
