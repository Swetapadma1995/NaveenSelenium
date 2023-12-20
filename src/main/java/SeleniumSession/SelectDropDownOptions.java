package SeleniumSession;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownOptions {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		
		By country = By.id("Form_getForm_Country");
		//WebElement country_ele = driver.findElement(country);
		
		selectDropDownOption(country, "India");
		selectDropDownOption(country, "Brazil");
		getDropDownOptionsCount(country);
		if(getDropDownOptions(country).contains("India")) {
			System.out.println("India -- pass");
		}
		
		List<String> containOptionsTextList = new ArrayList<String>();
		containOptionsTextList.add("Austria");
		containOptionsTextList.add("Barbados");
		containOptionsTextList.add("Botswana");
		containOptionsTextList.add("China");
		containOptionsTextList.add("Egypt");
		containOptionsTextList.add("Egypt");
		
		if(getDropDownOptions(country).containsAll(containOptionsTextList)) {
			System.out.println("pass");
		}
	
		//int countryCount = getDropDownOptionsCount(country) - 1;
		//if(countryCount == 232) {
		//	System.out.println(countryCount);
		//}
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static int getDropDownOptionsCount(By locators) {
		Select select = new Select(getElement(locators));
		return select.getOptions().size();
	}
	
		public static List<String> getDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
				
		for(WebElement e : optionsList) {
			String text = e.getText();
			optionsTextList.add(text);	
		}
			return optionsTextList;
	}
	
	public static void selectDropDownOption(By locator , String dropDownValue) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
				if(text.equals(dropDownValue)) {
					e.click();
					break;
				}
		}
		
	}

}
