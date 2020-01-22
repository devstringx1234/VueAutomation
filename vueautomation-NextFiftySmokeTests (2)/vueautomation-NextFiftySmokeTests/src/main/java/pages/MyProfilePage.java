package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyProfilePage extends BasePage {


	By userAvatarLink = By.cssSelector("a.userAvatar.router-link-exact-active.router-link-active");
	By myProfileLink = By.xpath("//div[text()='My Profile']");
	By editProfileIcon = By.cssSelector("i.v-icon.notranslate.mdi.mdi-pencil.theme--dark");
	By displayName_Tf = By.cssSelector("div.v-input.ml-2.theme--light.v-text-field.v-text-field--is-booted.v-text-field--enclosed input");
	By saveProfileBtn = By.xpath("//span[contains(text(),'Save Profile')]");
	By closeIcon = By.cssSelector("div.v-input.ml-2.v-input--is-label-active.v-input--is-dirty.theme--light.v-text-field.v-text-field--is-booted.v-text-field--enclosed.v-text-field--outlined.v-text-field--placeholder i");
	
	
	//ACTIONS METHODS======================================================================================================================

	/**
	 * @param driver
	 */
	public void clickOnUserAvatarLink(RemoteWebDriver driver)  {
		waitForElementVisibility(driver, userAvatarLink);
		click(driver, userAvatarLink);
	}
	
	/**
	 * @param driver
	 */
	public void clickCloseIcon(RemoteWebDriver driver)  {
		waitForElementVisibility(driver, closeIcon);
		click(driver, closeIcon);
	}
	
	/**
	 * @param driver
	 */
	public void clickOnSaveProfileBtn(RemoteWebDriver driver)  {
		waitForElementVisibility(driver, saveProfileBtn);
		click(driver, saveProfileBtn);
	}
	
	/**
	 * @param driver
	 */
	public void clickOnEditIconOnProfile(RemoteWebDriver driver)  {
		waitForElementVisibility(driver, editProfileIcon);
		click(driver, editProfileIcon);
	}

	/**
	 * @param driver
	 */
	public void clickMyProfileLink(RemoteWebDriver driver)
	{
		waitForElementVisibility(driver, myProfileLink);
		click(driver, myProfileLink);
	}
	
	/**
	 * @param driver
	 * @param displayName
	 */
	public void enterDisplayName(RemoteWebDriver driver ,String displayName) {
		waitForElementVisibility(driver, displayName_Tf);
		enterData(driver, displayName_Tf, displayName);
	}
}
