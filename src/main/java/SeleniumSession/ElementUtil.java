package SeleniumSession;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public By getBy(String locatorType , String locatorValue) {
		By by = null;
		switch (locatorType.toLowerCase().trim()) {
		case "id":
			by = By.id(locatorValue);
			break;
		case "name":
			by = By.name(locatorValue);
			break;
		case "className":
			by = By.className(locatorValue);
			break;
		case "xpath":
			by = By.xpath(locatorValue);
			break;
		case "css":
			by = By.cssSelector(locatorValue);
			break;
		case "linktext":
			by = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			by = By.partialLinkText(locatorValue);
			break;
		case "tag":
			by = By.tagName(locatorValue);
			break;

		default:
			System.out.println("wrong locator type passed.."+locatorType);
			throw new AutomationExecption("wrong locator type");
		}
		 
		return by;
		
	}
	
	//locatorType = "id" , locatorValue = "input_email" , value == "sweta@gmail.com"
	public void doSendKeys(String locatorType , String locatorValue , String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}
	
	public void doSendKeys(By locator , String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public boolean checkSingleElementPresent(By locator) {
		return driver.findElements(locator).size() ==1 ? true : false;	
	}

	
	public boolean checkElementPresent(By locator) {
		return driver.findElements(locator).size() >=1 ? true : false;	
	}

	public boolean checkElementPresent(By locator , int totalElements) {
		return driver.findElements(locator).size() == totalElements ? true : false;	
	}
	
	
	//********************Select Drop Down Utils******************//
	
	private Select createSelect(By locator) {
		Select select = new Select(getElement(locator));
		return select;
	}
	
	public void doSelectDropDownByIndex(By locator , int index) {
		//Select select = new Select(getElement(locator));
		createSelect(locator).selectByIndex(index);
	}
	
	public void doSelectDropDownByVisibleText(By locator , String visibleText) {
		//Select select = new Select(getElement(locator));
		createSelect(locator).selectByVisibleText(visibleText);
	}
	
	public void doSelectDropDownByValue(By locator , String value) {
		//Select select = new Select(getElement(locator));
		createSelect(locator).selectByValue(value);
	}

	public int getDropDownOptionsCount(By locators) {
		//Select select = new Select(getElement(locators));
		return createSelect(locators).getOptions().size();
	}
	
		public List<String> getDropDownOptions(By locator) {
		//Select select = new Select(getElement(locator));
		List<WebElement> optionsList = createSelect(locator).getOptions();
		List<String> optionsTextList = new ArrayList<String>();
				
		for(WebElement e : optionsList) {
			String text = e.getText();
			optionsTextList.add(text);	
		}
			return optionsTextList;
	}
	
	public void selectDropDownOption(By locator , String dropDownValue) {
		//Select select = new Select(getElement(locator));
		List<WebElement> optionsList = createSelect(locator).getOptions();
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
	
	public void selectDropDownValue(By locator , String value) {
		List<WebElement> optionList = driver.findElements(locator);
		for(WebElement e : optionList ) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public boolean isDropDownMultiple(By locator) {
		return createSelect(locator).isMultiple() ? true : false;
	}
	
	/**
	 * This method is used to select the values from the drop down. It can select;
	 * 1. Single selection
	 * 2. Multiple selection
	 * 3. All Selection: please pass "all" as a value to select all the values
	 * @param locator
	 * @param values
	 */
	public void selectDropDownMultipleValues(By locator , By optionLocator , String... values) {
		Select select = new Select(getElement(locator));
		
		if(isDropDownMultiple(locator)) {
			
			if(values[0].equalsIgnoreCase("all")) {
				List<WebElement> optionList = driver.findElements(optionLocator);
				for(WebElement e : optionList) {
					e.click();
				}
			} else {
				for(String value : values) {
					select.selectByVisibleText(value);
				}
			}
			
		}
		
	}
	
	//******************Actions Utils***********************//
	
	public void parentChildMenu(By parentMenuLocator , By childMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).build().perform();
		Thread.sleep(1000);
		doClick(childMenuLocator);
	}
	
	//******************Wait Utils******************************//
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible on the page.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForPresenceOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 *  An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible on the page.
	 * @param locator
	 * @param timeOut
	 * @param intervalTime
	 * @return
	 */
	public WebElement waitForPresenceOfElement(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @param intervalTime
	 * @return
	 */
	public WebElement waitForVisibilityOfElement(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void doClickWithWait(By locator, int timeOut) {
		waitForVisibilityOfElement(locator, timeOut).click();
	}
	
	public void doSendKeysWithWait(By locator, String value, int timeOut) {
		waitForVisibilityOfElement(locator, timeOut).sendKeys(value);
	}
	
	/**
	 * An expectation for checking that all elements present on the web page that match the locator are visible. 
	 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForVisibilityOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	/**
	 * An expectation for checking that there is at least one element present on a web page.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForPresenceOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public String WaitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
			}
		} catch(TimeoutException e) {
			System.out.println(titleFraction + "title value is not present...");
			e.printStackTrace();
		}
		return null;
	}
	
	public String WaitForTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
			}
		} catch(TimeoutException e) {
			System.out.println(title + "title value is not present...");
			e.printStackTrace();
		}
		return null;
	}
	
	public String WaitForURLContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getTitle();
			}
		} catch(TimeoutException e) {
			System.out.println(urlFraction + "url value is not present...");
			e.printStackTrace();
		}
		return null;
	}
	
	//get full url
	public String WaitForURLRToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.urlToBe(url))) {
			return driver.getTitle();
			}
		} catch(TimeoutException e) {
			System.out.println(url + "url value is not present...");
			e.printStackTrace();
		}
		return null;
	}
	
	public Alert waitForJSAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptJSAlert(int timeOut) {
		waitForJSAlert(timeOut).accept();
	}
	
	public void dismissJSAlert(int timeOut) {
		waitForJSAlert(timeOut).dismiss();;
	}
	
	public String getJSAlertText(int timeOut) {
		return waitForJSAlert(timeOut).getText();
	}
	
	public void enterValueOnJSAlert(int timeOut, String value) {
		waitForJSAlert(timeOut).sendKeys(value);;
	}
	
	public void waitForFrameByLocator(By frameLocator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void waitForFrameByIndex(int frameIndex, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public void waitForFrameByIDOrName(String IDOrName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IDOrName));
	}
	
	public void waitForFrameByElement(WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public boolean checkWindowExist(int timeOut , int expectedNumberOfWindows) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		
		try {
			if(wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows))) {
				return true;
			}
		}
		catch (TimeoutException e) {
			System.out.println("number of windows are not same...");
		}
		return false;
	}	
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param locator
	 * @param timeOut
	 */
	public void clickElementWhenReady(By locator , int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		}
		catch (TimeoutException e) {
			System.out.println("number of windows are not same...");
		}
	}
	
	public WebElement waitForElementWithFluentWait(By locator , int timOut , int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timOut))
				.pollingEvery(Duration.ofSeconds(intervalTime))
				.withMessage("--time out is done...element is not found...")
				.ignoring(NoSuchElementException.class)
				.ignoring(ElementNotInteractableException.class);
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForFrameWithFluentWait(String frameIdOrName , int timOut , int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timOut))
				.pollingEvery(Duration.ofSeconds(intervalTime))
				.withMessage("--time out is done...frame is not found...")
				.ignoring(NoSuchFrameException.class);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIdOrName));
	}
	
	public Alert waitForJSAlertWithFluentWait(int timOut , int intervalTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timOut))
				.pollingEvery(Duration.ofSeconds(intervalTime))
				.withMessage("--time out is done...alert is not appeared...")
				.ignoring(NoAlertPresentException.class);
		
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	//********************Custom Wait*********************//
	
	public WebElement retryingElement(By locator , int timeOut) {
		
		WebElement element = null;
		int attempts = 0;
		
		while(attempts < timeOut) {
			try {
				element = getElement(locator);
				System.out.println("element is found..." + locator + "in attempt " + attempts);
				break;
			}
			catch (NoSuchElementException e) {
				System.out.println("element is not found..." + locator + "in attempt " + attempts);
				try {
					Thread.sleep(500);//default polling time = 500ms
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element == null) {
			System.out.println("element is not found... tried for " + locator + "times with the interval of " + 500 + "miliseconds") ;
			throw new AutomationExecption("No Such Element");
		}
		return element;
		
	}

	public WebElement retryingElement(By locator , int timeOut, int intervalTime) {
		
		WebElement element = null;
		int attempts = 0;
		
		while(attempts < timeOut) {
			try {
				element = getElement(locator);
				System.out.println("element is found..." + locator + "in attempt " + attempts);
				break;
			}
			catch (NoSuchElementException e) {
				System.out.println("element is not found..." + locator + "in attempt " + attempts);
				try {
					Thread.sleep(intervalTime);//custom polling time 
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element == null) {
			System.out.println("element is not found... tried for " + locator + "times with the interval of " + 500 + "miliseconds") ;
			throw new AutomationExecption("No Such Element");
		}
		return element;	
	}
	
	public boolean isPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'")).toString();
		return Boolean.parseBoolean(flag);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
