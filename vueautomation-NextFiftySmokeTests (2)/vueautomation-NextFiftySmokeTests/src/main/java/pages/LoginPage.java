package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends BasePage {

	By userNameTextField = By.id("login-email");
	By passwordTextField = By.id("login-password");
	By NextBtn = By.cssSelector(".submit-username");
	By SignInBtn = By.cssSelector("button.login__submit");
	By mfaCodeTextField = By.id("mfa-code");
	By SubmitBtn = By.xpath("//span[@class='v-btn__content'][contains(text(),'Submit')]");
	//By RadioBtn = By.xpath("(//div[@class='v-input--selection-controls__input']/input[contains(@value,'email')])[2]");
	By RadioBtn = By.xpath("(//input[contains(@value,'email')]/..)[2]");
	
	By SendBtn = By.xpath("//span[@class=\"v-btn__content\"][contains(text(),'Send')]");	
	By mfaRadionBtn = By.cssSelector("div.v-radio.theme--light");
	By sendBtn = By.xpath("//span[contains(text(),'Send')]");
	By mfaCode_Tf = By.cssSelector("input[name='mfa-code']");
	By submitBtn = By.xpath("//span[contains(text(),'Submit')]");
	By confirmPopUp = By.xpath("//span[contains(text(),'Ok')]");
	/**
	 * @param driver
	 * @param username
	 */
	public void enterUserName(RemoteWebDriver driver, String username) {
		waitForElementVisibility(driver, userNameTextField);
		waitForElementVisibility(driver, NextBtn);
		hardWait(3000);
		enterData(driver, userNameTextField, username);
	}
	
	/**
	 * @param driver
	 * @param username
	 */
	public void enterMFAVerificationCode(RemoteWebDriver driver, String username) {
		enterData(driver, mfaCode_Tf, username);
	}

	/**
	 * @param driver
	 * @param password
	 */
	public void enterPassword(RemoteWebDriver driver, String password) {
		enterData(driver, passwordTextField, password);
	}
	
	/**
	 * @param driver
	 * @param password
	 */
	public void enterMFACode(RemoteWebDriver driver, String mfaCode) {
		enterData(driver, mfaCodeTextField, mfaCode);
	}

	/**
	 * @param driver
	 * @throws InterruptedException
	 */
	public void clickOnSubmitutton(RemoteWebDriver driver) throws InterruptedException {
		click(driver, SubmitBtn);
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 */
	public void clickOnNextButton(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibility(driver, NextBtn);
		click(driver, NextBtn);
	}
	
	public void clickOnRadioButton(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibility(driver, RadioBtn);
		click(driver, RadioBtn);
	}
	
	public void clickOnSendButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver, SendBtn);
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 */
	public void clickMFARadioBtn(RemoteWebDriver driver) throws InterruptedException {
		click(driver, mfaRadionBtn);
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 */
	public void clickSendBtn(RemoteWebDriver driver) throws InterruptedException {
		click(driver, sendBtn);
	}
	
	public void clickSubmitBtn(RemoteWebDriver driver) throws InterruptedException {
		click(driver, submitBtn);
	}
	
	/**
	 * @param driver
	 */
	public void clickConfirmOkPupUp(RemoteWebDriver driver) {
		waitForElementInVisibilityByLocator(driver, mfaCode_Tf);
		hardWait(6000);
		if(getWebElements(driver, confirmPopUp).size()>0 ) {
			if(isElementPresent(driver, confirmPopUp)) {
			waitForElementVisibility(driver, confirmPopUp);
			click(driver, confirmPopUp);
			}
			
		}
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException
	 */
	public void clickOnSignInButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver, SignInBtn);
	}
	
	/**
	 * @param driver
	 * @return
	 */
	public int getMFARadioBtnSize(RemoteWebDriver driver) {
		hardWait(3000);
		return getWebElements(driver, mfaRadionBtn).size();
	}
	
	public int getnextBtnSize(RemoteWebDriver driver) {
		hardWait(5000);
		return getWebElements(driver, NextBtn).size();
	}
}
