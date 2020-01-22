package pages.bars;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import pages.BasePage;

public class SideBar extends BasePage {
	
	By roomsLink = By.xpath("//div[text()='Rooms']");
	
	
	public boolean isRoomLinkDisplayed(RemoteWebDriver driver) {
		waitForElementVisibility(driver, roomsLink);
		return isElementPresent(driver, roomsLink);
	}

}
