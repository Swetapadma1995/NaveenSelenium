package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCSSSelector {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
		//CSS selector -- locator approach
		//id --> #id
		//class --> .class
		
		// #input-firstname
		By.cssSelector("#input-firstname");
		
		// .form-control
		
		// #id.class : #input-firstname.form-control
		// .class#id : .form-control#input-firstname
		
		// if there are multiple classes then
		// .c1.c2c3....cn
		// .form-control.input-lg
		// form-control private-form__control login-email
		// .form-control.private-form__control.login-email#username
		// #username.form-control.private-form__control.login-email
		
		// other attribute : type , name , any other attribute
		// htmltag[attr='value'] -- css
		// //htmltag[@attr='value'] -- xpath
		
		// input[name='email']
		By.cssSelector("input[name='email']");
		// input[id='input-email']
		
		// htmltag[attr1='value'][attr2='value'][attr3='value']
		// input[name='email'][placeholder='E-Mail Address']
		// input[name][placeholder][type]
		
		// input[name='email']#input-email
		// input#input-email[name='email']
		
		
		// driver.findElement(By.className("form-control private-form__control login-email")).sendKeys("sweta@gmail.com"); // invalid
		// InvalidSelectorException: Compound(multiple) class names not permitted
		
		//driver.findElement(By.className("login-email")).sendKeys("sweta@gmail.com"); // valid
		
		//driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")).sendKeys("sweta@gmail.com"); // valid
		// in xpath compound(multiple) class names are allowed
		
		//driver.findElement(By.cssSelector("input.form-control.private-form__control.login-email")).sendKeys("sweta@gmail.com");//valid
		// input.form-control.private-form__control.login-email
		
		// input#username
		
		//driver.findElement(By.xpath("//input[@@@@@id,''username]")).sendKeys("sweta@gmail.com"); //InvalidSelectorException: invalid selector
		
		//text in css : Not available
		//htmltag[att*='value'] --> contains
		// input[placeholder*='E-Mail'] -- contains
		// input[placeholder^='E-Mail'] -- startswith
		// input[placeholder$='Address'] -- endswith
		
		//parent to child:
		// select[@id='Form_getForm_Country']/option --xpath
		// select[id='Form_getForm_Country']>option --css -- direct child element : parent > child
		
		//div#content>input -- 0 direct
		// div#content input -- 11 -- direct + indirect child elements
		
		//child to parent: not allowed -- backward traversing is not allowed in CSS
		//child to ancestor : not allowed
		//preceding sibling : not allowed
		
		//sibling in css:
		//label[for='input-email']+input -- immediate single sibling
		//label[for='input-email']~input -- all follwing sibling
		
		//comma in CSS:
		//input#username,input#password,button#loginBtn,input#remember
		int loginEle = driver.findElements(By.cssSelector("input#username,input#password,button#loginBtn,input#remember")).size();
		System.out.println(loginEle);
		
		if(loginEle == 4) {
			System.out.println("all important elements present in login page");
		}
		else
		{
			System.out.println("Fail");
		}
		
		//not on CSS:
		//div.form-group>input:not(#input-password)
		//div[class='form-group']>input:not(input[type='password'])
		//div[class='form-group']>input:not(input[type='password'],#input-email)
		
		//indexing in CSS:
		//select[id='Form_getForm_Country']> option:nth-of-type(6)
		//select[id='Form_getForm_Country']> option:nth-of-type(n) -- all
		//select[id='Form_getForm_Country']> option:first-child
		//select[id='Form_getForm_Country']> option:last-child
		//select[id='Form_getForm_Country']> option:nth-child(5)
		//select[id='Form_getForm_Country']> option:nth-last-child(2)
		//select[id='Form_getForm_Country']> option:nth-child(even)
		//select[id='Form_getForm_Country']> option:nth-child(n+4)
		//select[id='Form_getForm_Country']> option:nth-child(4n)
		
		//odd / even in xpath:
		// num % 2 == 0
		//table//tobdy//tr[position() mod 2 = 1] -- for odd
		// (//select[@id='Form_getForm_Country']/option)[position() mod 2 = 1] --odd
		//table//tobdy//tr[position() mod 2 = !1] -- for even
		// (//select[@id='Form_getForm_Country']/option)[position() mod 2 = 0] -- even
		
		//                      xpath          vs                css:
		//1.syntax:            complex                           simple
		//2.performance:       good                              good
		//3.backward:          yes                               no
		//4.sibling:           yes                               yes-- only follwing
		//5.text:              yes                               no
		//6.ancestor:          yes                               no
		//7.index:             yes                               yes+1
		//8.comma:             no                                yes 
		//9:not:               no                                yes
		//10:SVG:              yes                               no
		//11.shadowDOM         no                                yes
		//12.endswith:         no                                yes
		
		
		
	}

}
