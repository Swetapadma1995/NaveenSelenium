package testngsessions;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	//invocation means calling
	//bydefault invocationCount is 1
	@Test(invocationCount = 10)
	public void searchProductTest() {
		System.out.println("search product test");
		
	}
	
	
	

}
