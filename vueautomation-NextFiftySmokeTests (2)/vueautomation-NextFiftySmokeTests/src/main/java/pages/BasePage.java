package pages;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

	final int WAIT_FOR_SECONDS = 60;

	Logger log=null;

	public BasePage(){
		log = Logger.getLogger(BasePage.class);
	}

	/**
	 * @param driver
	 * @param elem
	 */
	public void waitForElementVisibility(RemoteWebDriver driver, WebElement elem) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		webDriverWait.until(ExpectedConditions.visibilityOf(elem));
	}


	/**
	 * @param driver
	 * @param locator
	 */
	public void waitForElementVisibility(RemoteWebDriver driver, By locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
		webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}



	/**
	 * @param driver
	 * @param elem
	 */
	public void waitForElementInVisibilityByElement(RemoteWebDriver driver, WebElement elem) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		webDriverWait.until(ExpectedConditions.invisibilityOf(elem));
	}

	/**
	 * @param driver
	 * @param locator
	 */
	public void waitForElementInVisibilityByLocator(RemoteWebDriver driver, By locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	/**
	 * @param driver
	 * @param locator
	 */
	public void waitForElementClickability(RemoteWebDriver driver, By locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * @param driver
	 * @param locator
	 */
	public void waitForElementClickability(RemoteWebDriver driver, WebElement locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	}


	/**
	 * @param driver
	 * @param locator
	 */
	public void waitForAllElementPresenceByElement(RemoteWebDriver driver, By locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * @param driver
	 * @param locator
	 */
	public void waitForvisibilityOfAllElements(RemoteWebDriver driver, List<WebElement> element) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		webDriverWait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	/**
	 * @param driver
	 * @param locator
	 * @throws InterruptedException 
	 */
	public void waitForElementAttributeValue(RemoteWebDriver driver, By locator, String attribute, String value) throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		webDriverWait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
		hardWait(1000);
	}

	/**
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public void waitForFieldToBePopulated(RemoteWebDriver driver, By locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		wait.until(ExpectedConditions.textToBePresentInElementValue(driver.findElement(locator), value));
	}



	/**
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public void enterData(RemoteWebDriver driver, By locator, String value)	{
		waitForElementClickability(driver, locator);
		hardWait(1000);
		driver.findElement(locator).click();
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
		//		waitForFieldToBePopulated(driver, locator, value);
	}

	public void enterDataAndPressEnter(RemoteWebDriver driver, By locator, String value)	{
		waitForElementClickability(driver, locator);
		hardWait(2000);
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
		driver.findElement(locator).sendKeys(Keys.ENTER);
		//	waitForFieldToBePopulated(driver, locator, value);
	}

	public  void JSSendKeys(RemoteWebDriver driver,By locator,CharSequence keys) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','"+keys+"');", locator);
	}

	public  void JSSendKeys(RemoteWebDriver driver,WebElement element,CharSequence keys) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','"+keys+"');", element);
	}

	/**
	 * @param driver
	 * @param locator
	 * @param value
	 * @throws InterruptedException 
	 */
	public void enterDataWithoutClearTextField(RemoteWebDriver driver, By locator, String value)  {
		waitForElementVisibility(driver, locator);
		driver.findElement(locator).sendKeys(value);

	}

	/**
	 * @param driver
	 * @param locator
	 * @throws InterruptedException 
	 */
	public void click(RemoteWebDriver driver, By locator)  {
		try {
			waitForElementClickability(driver, locator);
			driver.findElement(locator).click();
			log.info("Click action performed successfully on element " + driver);
		} catch (TimeoutException e) {
			hardWait(2000);
			driver.findElement(locator).click();
		} catch (NoSuchElementException e){
			hardWait(2000);
			driver.findElement(locator).click();
		}
	}

	public void JSClick(RemoteWebDriver driver, WebElement element) {
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", element); 
	}

	public void JSClick(RemoteWebDriver driver, By element) {
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click();", element); 
	} 

	public int generateRandomNumber() {
		Random rand = new Random(); 
		// Generate random integers in range 0 to 999 
		return rand.nextInt(100000); 
	}

	/**
	 * @param driver
	 * @param locator
	 * @param text
	 */
	public void dropdownSelectByText(RemoteWebDriver driver, By locator, String text) {
		try {
			waitForElementVisibility(driver, locator);
			Select dropdown = new Select(driver.findElement(locator));
			dropdown.selectByVisibleText(text);
			log.info("SelectByVisibleText action performed successfully on element " + driver);
		} catch (TimeoutException e) {
			log.error("Timeout occurs while selecting dropdrown option for element " + locator);
			e.printStackTrace();
		} catch (NoSuchElementException e){
			log.error("NoSuchElementException occurs while selecting dropdrown option " + locator);
		}
	}

	/**
	 * @param driver
	 * @param locator
	 * @param text
	 */
	public void dropdownSelectByText(RemoteWebDriver driver, WebElement element, String text) {
		hardWait(3000);
		try {
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(text);
			log.info("SelectByVisibleText action performed successfully on element " + driver);
		} catch (TimeoutException e) {
			log.error("Timeout occurs while selecting dropdrown option for element " + element);
			e.printStackTrace();
		} catch (NoSuchElementException e){
			log.error("NoSuchElementException occurs while selecting dropdrown option " + element);
		}
	}

	/**
	 * @param driver
	 * @param locator
	 * @param index
	 */
	public void dropdownSelectByIndex(RemoteWebDriver driver, By locator, int index) {
		try {
			waitForElementVisibility(driver, locator);
			Select dropdown = new Select(driver.findElement(locator));
			dropdown.selectByIndex(index);
			log.info("SelectByIndex action performed successfully on element " + driver);
		} catch (TimeoutException e) {
			log.error("Timeout occurs while selecting dropdrown option for element " + locator);
			e.printStackTrace();
		} catch (NoSuchElementException e){
			log.error("NoSuchElementException occurs while selecting dropdrown option " + locator);
		}
	}

	public void pageRefresh(RemoteWebDriver driver) {
		driver.navigate().refresh();
	}

	/**
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public void dropdownSelectByValue(RemoteWebDriver driver, By locator, String value) {
		try {
			waitForElementVisibility(driver, locator);
			Select dropdown = new Select(driver.findElement(locator));
			dropdown.selectByValue(value);
			log.info("SelectByValue action performed successfully on element " + driver);
		} catch (TimeoutException e) {
			log.error("Timeout occurs while selecting dropdrown option for element " + locator);
			e.printStackTrace();
		} catch (NoSuchElementException e){
			log.error("NoSuchElementException occurs while selecting dropdrown option " + locator);
		}
	}

	/**
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public void selectValueFromComboBox (RemoteWebDriver driver, By locator, String value) {
		try {
			waitForElementVisibility(driver, locator);
			List<WebElement> items = driver.findElement(locator).findElements(By.xpath("//div//div[@role='option']//div"));

			for (WebElement item : items) {
				String itemText = item.getText().trim();
				if (itemText.contains(value)) {
					item.click();
				}
			}
			log.info("selectValueFromComboBox action performed successfully on element " + driver);
		} catch (TimeoutException e) {
			log.error("Timeout occurs while selecting dropdrown option for element " + locator);
			e.printStackTrace();
		} catch (NoSuchElementException e){
			log.error("NoSuchElementException occurs while selecting dropdrown option " + locator);
		}
	}

	/**
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public void selectValueFromPersonComboBox (RemoteWebDriver driver, By locator, String value) {
		try {
			waitForElementVisibility(driver, locator);
			List<WebElement> items = driver.findElement(locator).findElements(By.xpath("//div//div[@role='option']//div[2]/div[1]"));
			
			for (WebElement item : items) {
				String itemText = item.getText().trim();
				if (itemText.contains(value)) {
					hardWait(2000);
					item.click();
				}
			}
			log.info("selectValueFromComboBox action performed successfully on element " + driver);
		} catch (TimeoutException e) {
			log.error("Timeout occurs while selecting dropdrown option for element " + locator);
			e.printStackTrace();
		} catch (NoSuchElementException e){
			log.error("NoSuchElementException occurs while selecting dropdrown option " + locator);
		}
	}

	/**
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public void selectValueFromList (RemoteWebDriver driver, By locator, String value) {
		try {
			waitForElementVisibility(driver, locator);
			Select dropdown = new Select(driver.findElement(locator));
			dropdown.selectByValue(value);
			log.info("SelectByValue action performed successfully on element " + driver);
		} catch (TimeoutException e) {
			log.error("Timeout occurs while selecting dropdrown option for element " + locator);
			e.printStackTrace();
		} catch (NoSuchElementException e){
			log.error("NoSuchElementException occurs while selecting dropdrown option " + locator);
		}
	}

	/**
	 * @param select
	 * @return
	 */
	public String getDropdownSelectedValue(Select select) {
		return select.getFirstSelectedOption().getText();
	}

	public String getCurrentDate() {
		DateFormat dateformat=new SimpleDateFormat("yyyy-MMM-d");
		Date date=new Date();
		String currentDate = dateformat.format(date).toUpperCase();
		return currentDate;
	}
	
	public  String getThreeDaysDifferenceFromCurrentDate(String curDate ,int daysDifference) {
		String nextDate = "";
		try {
			Calendar today = Calendar.getInstance();
			DateFormat format = new SimpleDateFormat("yyyy-MMM-d");
			Date date = format.parse(curDate);
			today.setTime(date);
			today.add(Calendar.DAY_OF_YEAR, daysDifference);
			nextDate = format.format(today.getTime()).toUpperCase();
		} catch (Exception e) {
			return nextDate;
		}
		return nextDate;
	}
	
	public  String getOnlyCurrentDate() {
		DateFormat dateformat=new SimpleDateFormat("dd");
		Date date=new Date();
		String currentDate = dateformat.format(date).toUpperCase();
		return currentDate;
	}
	
	
	public  String getThreeDaysDifferenceFromCurrentDateWithFormate(String curDate ,int daysDifference) {
		String nextDate = "";
		try {
			Calendar today = Calendar.getInstance();
			DateFormat format = new SimpleDateFormat("MMM d,yyyy");
			Date date = format.parse(curDate);
			today.setTime(date);
			today.add(Calendar.DAY_OF_YEAR, daysDifference);
			nextDate = format.format(today.getTime()).toUpperCase();
		} catch (Exception e) {
			return nextDate;
		}
		return nextDate;
	}
	
	public  String getCurrentDateWithMonth() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d,yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 3); // Adding 3 days
		String output = sdf.format(c.getTime());
		return output.toUpperCase();
	}

	/**
	 * @param drive
	 * @param locators
	 * @return
	 * @throws InterruptedException
	 */
	public boolean isElementPresent(RemoteWebDriver driver, By locators) {
		boolean status = false;
		try {
			driver.findElement(locators).isDisplayed();
			status = true;
		} catch (NoSuchElementException e) {
			status = false;
		}
		return status;
	}
	public boolean isBtnEnabled(RemoteWebDriver driver, By locators) {
		boolean status = false;
		try {
			waitForElementClickability(driver, locators);
			driver.findElement(locators).isEnabled();
			status = true;
		} catch (NoSuchElementException e) {
			status = false;
		}
		return status;
	}

	public  boolean checkIfElementIsClickable(RemoteWebDriver driver, By locator) {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);

			webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		} catch (Exception e) {
			return false;

		}
	}
	public  boolean checkIfElementIsClickable(RemoteWebDriver driver, By locator, int waitTimeForSeconds) {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, waitTimeForSeconds);

			webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		} catch (Exception e) {
			return false;

		}
	}
	
	public  boolean checkIfElementIsClickable(RemoteWebDriver driver, WebElement element) {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);

			webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;

		}
	}
	public  boolean checkIfElementIsDisplayed(RemoteWebDriver driver, WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	public List<WebElement> getWebElements(RemoteWebDriver driver, By locator){
		return driver.findElements(locator);
	}

	public WebElement getWebElement(RemoteWebDriver driver, By locator){
		return driver.findElement(locator);
	}

	public WebElement getDynamicWebElementByText(RemoteWebDriver driver, String xpath){
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * @param driver
	 * @param locator
	 * @return
	 * 
	 */
	public String getText(RemoteWebDriver driver, By locator)  {
		waitForElementVisibility(driver, locator);
		try {
			return driver.findElement(locator).getText().trim();
		} catch (StaleElementReferenceException e) {
			return driver.findElement(locator).getText().trim();
		}
	}



	/**
	 * @param driver
	 * @param locator
	 * @return
	 * @throws InterruptedException
	 */
	public boolean getCheckBoxStaus(RemoteWebDriver driver, By locator) throws InterruptedException {
		boolean status = false;
		try {
			status = driver.findElement(locator).isSelected();
		} catch (NoSuchElementException e) {
			status = false;
		}
		return status;
	}

	/**
	 * @param driver
	 * @param index
	 */
	public void switchWindows(RemoteWebDriver driver, Integer index) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			String[] windows = allWindows.toArray(new String[allWindows.size()]);
			driver.switchTo().window(windows[index]);
		} catch (Exception e) {
			System.out.println("Unexpected issue occurred in switching windows: " + e);
		}

	}

	public void closeSwitchWindow(RemoteWebDriver driver ,Integer index) {
		switchWindows(driver, index);
		driver.close();
	}

	/**
	 * @param driver
	 * @param locator
	 * @param attributeName
	 * @return
	 */
	public String getValueFromAttribute(RemoteWebDriver driver, By locator, String attributeName) {
		waitForElementVisibility(driver, locator);
		return driver.findElement(locator).getAttribute(attributeName);
	}

	/**
	 * @param driver
	 * @param locator
	 * @return
	 */
	public String getElementTagName(RemoteWebDriver driver, By locator) {
		return driver.findElement(locator).getTagName();
	}

	/**
	 * @param driver
	 * @param locator
	 * @return
	 */
	public String getElementCSS(RemoteWebDriver driver, By locator) {
		waitForElementVisibility(driver, locator);
		return driver.findElement(locator).getCssValue("color");
	}	

	public void scrolToRightUseingActio(RemoteWebDriver driver) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, WAIT_FOR_SECONDS);
		WebElement ele = driver.findElement(By.cssSelector("div.ag-body-horizontal-scroll-viewport"));
	  ele.click();
     Actions move = new Actions(driver);
     move.moveToElement(ele).clickAndHold();
     move.moveByOffset(300,0);
     move.release();
     move.perform();
     hardWait(3000);
	}
	
	/**
	 * @param driver
	 * @param locator
	 */
	public void mouseHoverAndClick(RemoteWebDriver driver, By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(locator)).click().perform();
	}

	public void mouseHoverAndClickByElement(RemoteWebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	/**
	 * @param driver
	 * @param locator
	 */
	public void mouseHover(RemoteWebDriver driver, By locator) {
		Actions action = new Actions(driver);
		WebElement target = driver.findElement(locator);
		action.moveToElement(target).build().perform();
	}


	public void mouseHover(RemoteWebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}


	/**
	 * @param driver
	 * @param locator
	 */
	public void scrollBrowserWindow(RemoteWebDriver driver) {
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");
	}

	public void scrolToTop(RemoteWebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}
	/**
	 * @param milliSeconds
	 * @throws InterruptedException
	 */
	public void hardWait(int milliSeconds)  {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param driver
	 * @param index
	 * @throws InterruptedException
	 */
	public void switchToFrameByIndex(RemoteWebDriver driver, int index)  {
		driver.switchTo().frame(index);
	}

	/**
	 * @param driver
	 * @throws InterruptedException
	 */
	public void switchToParentFrame(RemoteWebDriver driver) {
		driver.switchTo().parentFrame();
	}
	public void switchOutFromIframe(RemoteWebDriver driver) {
		
		driver.switchTo().defaultContent();
		hardWait(1000);
	}
	
	/**
	 * @param driver
	 * @param dateValue
	 * @throws InterruptedException
	 */
	public void selectDate(RemoteWebDriver driver, String dateValue)  {
		String [] dateVal = dateValue.split("-");
		String yyyy = dateVal[0].trim();
		String mm = dateVal[1].trim();
		String dd = dateVal[2].trim();

		boolean flag = false;
		WebElement datePicker = driver.findElement(By.cssSelector(".v-menu__content.theme--light.v-menu__content--fixed.menuable__content__active"));
		hardWait(1000);
		datePicker.findElement(By.xpath("div//div[@class='v-picker__title__btn v-date-picker-title__year']")).click();
		hardWait(1000);
		datePicker.findElement(By.xpath("div//li[text()="+ yyyy +"]")).click();
		hardWait(1000);
		//waitForElementVisibilityByElement(driver, datePicker.findElement(By.xpath("div//table//tr")));
		List<WebElement> calendarMonths = datePicker.findElements(By.xpath("div//table//tr"));
		for (WebElement calendarMonth: calendarMonths) {
			List<WebElement> monthsList = calendarMonth.findElements(By.xpath("td//div"));
			for (WebElement month : monthsList) {
				if(month.getText().trim().equals(mm)) {
					hardWait(2000);
					month.click();
					flag=true;
					break;
				}
			}
			if (flag)
				break;
		}
		flag=false;
		hardWait(2000);
		waitForElementVisibility(driver, datePicker.findElement(By.xpath("div//table/tbody//tr")));
		List<WebElement> calendarDates = datePicker.findElements(By.xpath("div//table/tbody//tr"));
		for (WebElement calendarDate: calendarDates) {
			List<WebElement> datesList = calendarDate.findElements(By.xpath("td//div"));
			for (WebElement date : datesList) {
				if(date.getText().trim().equals(dd)) {
					date.click();
					flag=true;
					break;
				}
			}
			if (flag)
				break;
		}
	}

	/**
	 * @param driver
	 * @param locationToSelect
	 */
	public void selectLocation(RemoteWebDriver driver, String locationToSelect){
		waitForElementVisibility(driver, driver.findElement(By.xpath("//div[contains(@class,'pac-container pac-logo')]//span[3]")));
		List<WebElement> element = driver.findElements(By.xpath("//div[contains(@class,'pac-container pac-logo')]//span[3]"));
		for (WebElement elem : element){
			if(checkIfElementIsClickable(driver, elem)){
				elem.click();
				break;
			}
		}
//		waitForElementVisibility(driver, driver.findElement(By.xpath("//span[contains(text(),'Film City')]")));
//		WebElement locationElement = driver.findElement(By.xpath("//span[contains(text(),'Film City')]"));
////		System.out.println(locationElement.getText().trim());
////		if(locationElement.getText().trim().contains(locationToSelect)) 
//			locationElement.click();
	}
	
	public void clickSideBardLink(RemoteWebDriver driver, String sideBarLinkName) {
		List<WebElement> sideBarElements = driver.findElements(By.cssSelector("a.v-list-item.v-list-item--link.theme--dark"));
		waitForvisibilityOfAllElements(driver, sideBarElements);
		for(WebElement sideBarElement : sideBarElements) {
			waitForElementVisibility(driver, sideBarElement);
			mouseHover(driver, sideBarElement);
			WebElement sideBarTextElement = sideBarElement.findElement(By.cssSelector("div.v-list-item__content"));
			if(sideBarTextElement.getText().trim().equals(sideBarLinkName)) {
				sideBarElement.findElement(By.cssSelector("i")).click();
				break;
			}
		}

	}

	/**
	 * @param driver
	 * @param time
	 * @throws InterruptedException
	 */
	public void selectTime(RemoteWebDriver driver, String time) throws InterruptedException {
		String [] timeVal1 = time.split(":");
		String [] timeVal2 = timeVal1[1].split(" ");
		String hh = timeVal1[0].trim();
		String mm = timeVal1[1].trim();
		String tt = timeVal2[0].trim(); 

		//boolean flag = false;
		WebElement timePicker = driver.findElement(By.cssSelector(".v-picker.v-card.v-picker--time.theme--light"));
		hardWait(2000);
		timePicker.findElement(By.xpath("//div[@class='v-time-picker-title__time']/div[1]")).click();
		timePicker.findElement(By.xpath("//span[contains(@class,'v-time-picker-clock__item')]/span[text()="+ hh +"]")).click();
		hardWait(2000);

		timePicker.findElement(By.xpath("//div[@class='v-time-picker-title__time']/div[2]")).click();
		timePicker.findElement(By.xpath("//span[contains(@class,'v-time-picker-clock__item')]/span[text()="+ mm +"]")).click();
		hardWait(2000);
		timePicker.findElement(By.xpath("//div[@class='v-time-picker-clock__ampm primary--text']/div[text()="+ tt +"]")).click();
	}

	public void scrollDown(RemoteWebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
	}

	public void scrollDownByLocator(RemoteWebDriver driver, By locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
	}
	public void scrollDownByLocator(RemoteWebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	

	public void isAllExistingFileDeleted(String filePath) {
		 File file = new File(filePath); 
         
	        if(file.delete()) 
	        { 
	            System.out.println("File deleted successfully"); 
	        } 
	        else
	        { 
	            System.out.println("Failed to delete the file"); 
	        } 
	}
	
	 public String readPDFInURL(RemoteWebDriver driver, String pdfURL, String pdfFileName) throws IOException  {
	        // page with example pdf document
		 driver.get(pdfURL+pdfFileName);
		    String output =null;
	        URL url = new URL(driver.getCurrentUrl());
	        InputStream is = url.openStream();
	        BufferedInputStream fileToParse = new BufferedInputStream(is);
	        org.apache.pdfbox.pdmodel.PDDocument document = null;
	        try {
	            document = PDDocument.load(fileToParse);
	             output = new PDFTextStripper().getText(document);
	        } finally {
	            if (document != null) {
	                document.close();
	            }
	            fileToParse.close();
	            is.close();
	        }
	        hardWait(2000);
	        driver.navigate().back();
	        hardWait(3000);
	        return output;
	    }
	 
	 public String getCurrentDateWithUserFormate(String formate) {
			DateFormat dateformat=new SimpleDateFormat(formate);
			Date date=new Date();
			String currentDate = dateformat.format(date);
			return currentDate;
		}
	 public int getMonthNameFromMonthNumber(String monthName) {
		 Date date =null;
			try {
				date = new SimpleDateFormat("MMMM").parse(monthName);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int i =(cal.get(Calendar.MONTH));
			System.out.println(i+1);
			return i+1;
	 }

}
