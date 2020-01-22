package pages.bars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import pages.BasePage;

public class TopBar extends BasePage {

	By userIcon = By.xpath("//div[contains(@class,'v-menu u')]//img");
	By signoutButton = By.xpath("//div[text()='Sign Out']");
	By pageTitle = By.xpath("//div[text()='Active Rooms']");
	By roomLink = By.cssSelector(".v-icon.mdi.mdi-door.theme--dark");
	By roomNameList = By.xpath("(//span[@title='Selenium Room 203'])[last()]");
	By hamburgerMenuButton = By.cssSelector("i.v-icon.notranslate.mdi.mdi-menu.theme--dark.white--text");
	By homeIconLink = By.cssSelector("i.v-icon.notranslate.mdi.mdi-home.theme--dark.white--text");
	By megaMenuRoomLink=By.xpath("//div[contains(@class,'mega-menu-root-view')]//div[text()='Rooms']");
	By searchQuery = By.xpath("//label[text()='Search All Rooms...']/following-sibling::input");
	By searchExecute = By.cssSelector(".fa.fa-search");
	By okBtn = By.xpath("//span[text()='Ok']");
	By selectSeleniumRoom = By.xpath("//span[contains(@title,'Selenium Room 203')]");
	By searchIcon = By.cssSelector("div.search-wrapper");
	By roomList = By.cssSelector("div.layout.column.homePage__tabs.tab-wrapper.white div.layout.wrap a");
	By startRoom = By.xpath("//div[contains(text(),'Start a Room')]");
	By roomName_Tf = By.xpath("//label[contains(text(),'Name')]/../input");
	By launchBtn = By.cssSelector("i.v-icon.notranslate.mr-1.mdi.mdi-play.theme--light");
	By bookMarkLink = By.xpath("//a[contains(text(),'Bookmarks')]");
	By roomInBookMark = By.cssSelector("a.roomCard.v-card.v-card--link.v-card--outlined.v-sheet.theme--light");
	By bookMarkIcon = By.cssSelector("i.v-icon.notranslate.grey--text.bookmark-toggle.v-icon--link.mdi.mdi-bookmark-outline.theme--dark");
	By joinCreatedRoomBtn = By.xpath("//span[contains(text(),'Join')]");
	By menuList = By.cssSelector("div.v-menu__content div.v-list.viewSelector__list.v-sheet.v-sheet--tile.theme--light a");
	By viewSelectorBtn = By.cssSelector("button.viewSelector__button");
	By topMenuList = By.cssSelector("div.contextBar__wrapper button[title] span.v-btn__content");
	By actionMenuLink = By.xpath("//span[contains(text(),'Actions')]");
	By actionMenuList = By.cssSelector("div.v-list.contextActions.v-sheet.v-sheet--tile.theme--light div[role='menuitem']");
	By createFormBtn = By.xpath("//a[contains(text(),'Create Form')]");
	By userProfile = By.cssSelector("header.navBar.v-sheet.v-sheet--tile.theme--dark.v-toolbar span.userAvatar__wrapper");
	By signOutLink = By.xpath("//div[contains(text(),'Sign Out')]");

	/**
	* @param driver
	* @throws InterruptedException 
	*/
	public void clickOnStartRoom(RemoteWebDriver driver)  {
	click(driver, startRoom);
	}
	
	public void clickSignOutLink(RemoteWebDriver driver) {
		waitForElementVisibility(driver, signOutLink);
		click(driver, signOutLink);
		hardWait(2000);
	}
	
	public void clickUserProfileIcon(RemoteWebDriver driver) {
		waitForElementVisibility(driver, userProfile);
		click(driver, userProfile);
	}
	
	public void clickCreateFormBtn(RemoteWebDriver driver) {
		waitForElementVisibility(driver, createFormBtn);
		click(driver, createFormBtn);
	}
	
	public void clickActionMenuLink(RemoteWebDriver driver) {
		waitForElementVisibility(driver, actionMenuLink);
		hardWait(2000);
		click(driver, actionMenuLink);
	}
	
	public void clickCerateFlowPlusIcon(RemoteWebDriver driver, String actionListName) {
		waitForAllElementPresenceByElement(driver, actionMenuList);
		hardWait(2000);
		List<WebElement> actionSubMenuElements = getWebElements(driver, actionMenuList);
		for(WebElement element : actionSubMenuElements) {
			if(element.findElement(By.cssSelector("div.v-list-item__title")).getText().trim().equals(actionListName)) {
				element.click();
				break;
			}
		}
	}
	
	public void clickMenuFormList(RemoteWebDriver driver, String menuName) {
		waitForElementVisibility(driver, viewSelectorBtn);
		waitForElementClickability(driver, viewSelectorBtn);
		hardWait(2000);
		click(driver, viewSelectorBtn);
		waitForAllElementPresenceByElement(driver, menuList);
		List<WebElement> menuListElements = getWebElements(driver, menuList);
		waitForvisibilityOfAllElements(driver, menuListElements);
		for(WebElement menuElement : menuListElements) {
			if(menuElement.findElement(By.cssSelector("div.v-list-item__title")).getText().trim().equals(menuName)) {
				menuElement.click();
				break;
			}
		}
	}
	
	public void clickTopMenus(RemoteWebDriver driver, String menuName) {
		waitForAllElementPresenceByElement(driver, topMenuList);
		List<WebElement> menuListElements = getWebElements(driver, topMenuList);
		waitForvisibilityOfAllElements(driver, menuListElements);
		int ss = menuListElements.size();
		for(WebElement menuElement : menuListElements) {
			if(menuElement.getText().trim().equals(menuName)) {
				menuElement.click();
				break;
			}
		}
	}
	
	/**
	* @param driver
	* @throws InterruptedException 
	*/
	public void clickOnJoinBtnOnToastr(RemoteWebDriver driver)  {
	    waitForElementVisibility(driver, joinCreatedRoomBtn);
		click(driver, joinCreatedRoomBtn);
	}
	
	
	/**
	* @param driver
	* @throws InterruptedException 
	*/
	public void clickOnBookMarkIcon(RemoteWebDriver driver)  {
		int i= getWebElements(driver, bookMarkIcon).size();
	click(driver, bookMarkIcon);
	}
	
	/**
	* @param driver
	* @throws InterruptedException 
	*/
	public void clickOnBookmarkTab(RemoteWebDriver driver)  {
		mouseHover(driver, searchIcon);
		waitForElementVisibility(driver, bookMarkLink);
	click(driver, bookMarkLink);
	}
	
	
	/**
	* @param driver
	* @throws InterruptedException 
	*/
	public void clickOnLaunchBtn(RemoteWebDriver driver)  {
	click(driver, launchBtn);
	waitForElementInVisibilityByLocator(driver, launchBtn);
	}
	
	/**
	* @param driver
	* @throws InterruptedException 
	*/
	public void clickOnHamburgerMenuButton(RemoteWebDriver driver)  {
		hardWait(2000);
		waitForElementVisibility(driver, hamburgerMenuButton);
	    click(driver, hamburgerMenuButton);
	}
	
	/**
	 * @param driver
	 */
	public void clickOnSeleniumRoom(RemoteWebDriver driver)  {
		waitForElementVisibility(driver, selectSeleniumRoom);
		click(driver, selectSeleniumRoom);
		
		}
	
	/**
	 * @param driver
	 */
	public void clickOnHomeIcon(RemoteWebDriver driver)  {
		click(driver, homeIconLink);
		
		}
	
	/**
	 * @param driver
	 */
	public void clickFirstRoom(RemoteWebDriver driver)  {
		hardWait(3000);
		waitForAllElementPresenceByElement(driver, roomList);
		if(getWebElements(driver, roomList).size()>0){
			getWebElements(driver, roomList).get(0).click();
		}
		}

	/**
	* @param driver
	* @throws InterruptedException 
	*/
	public void clickOnMegaMenuRoomLink(RemoteWebDriver driver)  {
		waitForElementVisibility(driver, megaMenuRoomLink);
	click(driver, megaMenuRoomLink);
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void enterRoomToSearch(RemoteWebDriver driver, String roomNo) {
		enterData(driver, searchQuery, roomNo);
	}
	
	public void enterNewRoomName(RemoteWebDriver driver ,String newRoomName)
	{
		waitForElementVisibility(driver, roomName_Tf);
		enterData(driver, roomName_Tf, newRoomName);
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void clickSearch(RemoteWebDriver driver)  {
		waitForElementVisibility(driver, searchExecute);
		click(driver, searchExecute);
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void clickRoomLink(RemoteWebDriver driver)  {
		click(driver, roomLink);
	}
	
	/**
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void selectRoom(RemoteWebDriver driver, String roomName) throws InterruptedException {
		hardWait(2000);
//		waitForAllElementPresenceByElement(driver, roomNameList);
//		for(WebElement roomElement: getWebElements(driver, roomNameList)) {
//			waitForElementVisibilityByElement(driver, roomElement);
//			if(roomElement.findElement(By.cssSelector("span[title]")).getText().trim().equals(roomName)) {
//				hardWait(3000);
//				roomElement.click();
//				break;
//			}
//		}
		waitForElementVisibility(driver, roomNameList);
		click(driver, roomNameList);
	}

	/**
	 * @param driver
	 * @throws InterruptedException 
	 */
	public String getPageHeaderText(RemoteWebDriver driver)  {
		return getText(driver, pageTitle);
	}
	
	public int getBookmarkSize(RemoteWebDriver driver) {
		waitForAllElementPresenceByElement(driver, roomInBookMark);
		hardWait(2000);
		return getWebElements(driver, roomInBookMark).size();
	}
	
	/**
	 * @param driver
	 * @param softAssert
	 * @throws InterruptedException 
	 */
	public void logout(RemoteWebDriver driver)  {
		click(driver, userIcon);
		click(driver, signoutButton);
	}

	/**
	 * @throws InterruptedException 
	 * @param driver
	 * @return
	 * @throws 
	 */
	public void provideConsentForTimeZone(RemoteWebDriver driver)  {
		if(driver.findElements(okBtn).size()>0){
			click(driver, okBtn);
			click(driver, okBtn);
		}
	}
}
