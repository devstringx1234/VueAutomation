package pages.cockpit;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import pages.BasePage;
import pages.bars.TopBar;

public class RTEPage extends BasePage 
{						
	By sendButton=By.xpath("//span[contains(text(),'Send')]");
	By chatBox=By.xpath("//div[@class='fr-element fr-view']"); 
	By lastSentMessage=By.xpath("//span[@class='body fr-view'][last()]");
	By boldButton=By.xpath("//button[@id='bold-2']//*[@class='fr-svg']");
	By italicButton=By.xpath("//button[@id='italic-2']//*[@class='fr-svg']");
	By underlineButton=By.xpath("//button[@id='underline-2']//*[@class='fr-svg']");
	By strikethroughImageButton=By.xpath("//button[@id='strikeThrough-2']");
	By colorImageButton=By.xpath("//i[@class='fa fa-tint']");
	By backgroundColorTextImageButton=By.xpath("//span[@data-param1='background']");
	By backColorIcon=By.xpath("//span[@data-param1='#B8312F'][@data-cmd='backgroundColor']");
	By colorTextImageButton=By.xpath("//span[@data-param1='text']");
	By textColorIcon=By.xpath("//span[@data-param1='#2C82C9']");
	By hexColorCodeTextBox=By.xpath("//*[@id='fr-color-hex-layer-text-2']");
	By okColorButton=By.xpath("//*[@id='fr-color-hex-layer-2']/div[2]/button");
	By insertImageButton=By.xpath("//span[text()='Insert Image']");
	By insertImageFileButton=By.xpath("//input[@type='file']");
	By boldTextLabel=By.xpath("(//div[@class='message-content pr-5']/div/p)[last()]");
	By yellowMessage=By.xpath("//div[contains(text(),'New Message')]");
	By moreTextColor = By.xpath("//button[contains(@id,'moreText')]");
	By textColor = By.xpath("//button[contains(@id,'textColor')]");
	By colorCode_Tf = By.cssSelector(".fr-input-line input");
	By OkBtnOnColorField = By.xpath("//button[contains(text(),'OK')]");
	By lastThreeDotFromMsgList = By.xpath("//div[@class='v-list-item__content cockpit__message-body'])[last()]//button[2]");
	By pinMessage = By.xpath("//div[contains(text(),'Pin Message')]");
	By unPinMessage = By.xpath("//div[contains(text(),'Unpin Message')]");
	By confirmPopUpOkBtn = By.xpath("//span[contains(text(),'Ok')]");
	By confirmBoxForPinMessage = By.cssSelector("div.v-card__text.veoci-dialog-content");
	By pinMessageThreeDotBtn = By.cssSelector("div.pinnedMessage");
	By unPinIconOnPinMessage = By.xpath("//div[contains(@class,'pinnedMessage')]//button[3]");
	By threeDotsSentMsg = By.xpath("(//div[@class='v-list-item__content cockpit__message-body'])[last()]//button[5]");
	By threeDotsSentMsgInThreadChat = By.xpath("(((//div[contains(@class,'v-list message-list-inner v-sheet v-sheet--tile theme--light')])[1])/div)[last()]//button[4]");
	By pinIconInChatBoxMsgList = By.xpath("(//div[@class='v-list-item__content cockpit__message-body'])[last()]//button[3]");
	By lastSendedMsgInChatRoom = By.xpath("(//div[@class='v-list-item__content cockpit__message-body'])[last()]//div[contains(@class,'message-content')]");
	By lastSendedUploadFileLink = By.xpath("(//div[@class='v-list-item__content cockpit__message-body'])[last()]//div[contains(@class,'message-content')]//a");
	By addFollowersToThread= By.xpath("//div[contains(text(),'Add Followers to Thread')]");
	By addFollowersMail = By.xpath("//div[contains(@class,'layout person-picker-wrapper')]//input");
	By addFollowerTitle = By.xpath("//div[contains(text(),'Add Followers')]");
	By addFollowerBtn = By.xpath("//span[contains(text(),'Add')]");
	By addFollowerAssertionMsg = By.xpath("//div[contains(text(),'Successfully added new thread followers.')]");
	By startNewSideRoom = By.xpath("//div[contains(text(),'Start New Side Room')]");
	By createNewSideRoomName_TF = By.xpath("//input[@id='input-2728']");
	By createNewSideRoomDescription_TF = By.xpath("//input[@id='input-2731']");
	By notifyMembers_TF = By.xpath("//input[@id='input-2752']");
	By listOfNotifyMembers = By.xpath("//div[@role='listbox'][contains(@id,'list')]/div");
	By InviteAccessByAdministrator = By.xpath("//div[contains(@id,'administrator-list-item')]");
	By createSideRoomAssertion = By.xpath("//div[@class='v-snack__content']");
	By createSideRoomBtn = By.xpath("//span[contains(text(),'Create')]");
	By privateChat = By.xpath("//div[contains(text(),'Private Chats')]");
	By editBtnOnPrivateChat = By.xpath("//button[contains(@title,'Initiate Private Chat')]");
	By searchUserOnPrivateChatWindow = By.xpath("//label[text()='Type name or email...']/../input");
	//	By searchedUsersList = By.xpath("");
	By privateChat_Tf = By.cssSelector("div.private-chat-input.grey div");
	By lastChatFromPrivateChatList = By.xpath("(//div[@class='private-message-text-inner'])[last()]");
	By closePrivateChatBox = By.cssSelector("i.v-icon.notranslate.mdi.mdi-close.theme--dark");
	By plusIconOnChatBox = By.xpath("//button[contains(@id,'moreRich')]");
	By insertVideo =By.xpath("(//button[contains(@id,'insertVideo')])[last()]");
	By videoUrl_Tf = By.xpath("//div[@class='fr-input-line']/input[contains(@id,'fr-video')]");
	By insertViedoBtn  = By.xpath("//button[@data-cmd='videoInsertByURL']");
	By lastRecordInChatList = By.xpath("(//div[@class='v-list-item__content cockpit__message-body'])[last()]");
	By lastRecordInThreadChat = By.xpath("((//div[contains(@class,'v-list message-list-inner v-sheet v-sheet--tile theme--light')])[1]/div)[last()]");
	By addThreadLink = By.xpath("(//div[contains(text(),'Add to Thread')])");
	By createNewThread = By.xpath("(//div[contains(text(),'create new thread')])");
	By activeListInChatBox = By.cssSelector("div.v-menu__content.theme--light.menuable__content__active div.v-list-item__title");
	By threadTitle = By.cssSelector("div.v-input.theme--light.v-text-field.v-text-field--is-booted.v-text-field--enclosed.v-text-field--outlined input");
	By createSiedRoomBtn = By.cssSelector("i.v-icon.notranslate.mr-1.mdi.mdi-play.theme--light");
	By createSideRoomLoader = By.cssSelector("span.v-btn__loader");
	By createThreadBtn = By.xpath("//span[contains(text(),'Create')]");
	By createBtnLoader = By.xpath("//span[contains(text(),'Create')]/../span[@class='v-btn__loader']");
	By createdThreadList =By.cssSelector("div.v-sheet--tile.theme--light.v-list--dense.thread-list-inner div.drop-wrapper span.thread-name-wrapper");
	By addMember = By.xpath("//div[contains(text(),'Add Members')]");
	By addMemberByEmail_Tf = By.xpath("//div[@role='combobox']//input");
	By memberInviteAccess = By.xpath("//div[@class='v-data-table__wrapper']//td[2]");
	By adminLinkForMember = By.xpath("//div[contains(@id,'administrator-list-item')]");
	By currentTime = By.cssSelector("i.v-icon.notranslate.mdi.mdi-clock.theme--light");
	By addMemberBtn = By.xpath("//span[contains(text(),'Add Members')]");
	By invitationMsgToastr = By.xpath("//div[contains(text(),'Invitations have been sent to new users.')]");
	By showChatWindowPlusIcon = By.cssSelector("button.v-btn.v-btn--absolute.v-btn--contained.v-btn--fab.v-btn--round.theme--dark.v-size--default.accent");	By selectedCheckBoxOnAddToThreadPage = By.cssSelector("div.v-input--selection-controls__ripple.accent--text");
	By checkBoxOnAddToThreadPage = By.xpath("//div[@class='layout align-center']//input[not(@aria-checked='true')]");
	By threeDotsOnChatBox = By.cssSelector("i.v-icon.notranslate.mdi.mdi-dots-vertical.theme--light");
	By roomToggleOnChatBox = By.xpath("//button[contains(@title,'Toggle this to send your')]");
	By clearBtn = By.xpath("//span[contains(text(),'Clear')][@class='v-btn__content']");
	By contactIconOnChatBox= By.xpath("(//div[contains(@class,'inputWrapper')])[1]//i[@class='v-icon notranslate mdi mdi-account-multiple theme--light']");
	By activeUserListOnChatBox = By.cssSelector("div.v-menu__content.theme--light.v-menu__content--fixed.menuable__content__active div.v-list-item.theme--light");
	By closeThreadPopUp = By.xpath("//div[contains(text(),'Main Thread')]/..//i");
	By advanceLink = By.xpath("//div[contains(text(),'Advanced')]");
	By moveToAnotherRoomLink = By.xpath("//div[contains(text(),'Move to Another Room')]");
	By selectSideRoom = By.cssSelector(".v-card__text.veoci-dialog-content div.sideroom-selector div.v-input__append-inner div.v-input__icon.v-input__icon--append");
	By sideRoomList = By.cssSelector("div.menuable__content__active.v-autocomplete__content div.v-list-item");
	By sideRoomName_Tf = By.xpath("//input[contains(@placeholder,'Select Side Room')]");
	By organization_Input = By.cssSelector("div.flex.org-selector div[role='combobox']");
	By group_Input = By.cssSelector("div.flex.group-selector div[role='combobox']");
	By room_Input = By.cssSelector("div.flex.room-selector div[role='combobox']");
	By searchedSideRoom = By.cssSelector("div.v-list-item__title span.v-list-item__mask");
	By threeDotsOnSideRoom = By.cssSelector("div.sideroom-list.rightList.sideroomList i.v-icon.notranslate.mdi-dots-vertical");
	By createRoomNameAndDescription = By.cssSelector("div.v-dialog.veoci-dialog.v-dialog--active.v-dialog--persistent div.v-text-field__slot input");
	By sideRoomEmail = By.xpath("//div[@role='combobox']//input");
	By inviteAccessOnSideRoom = By.xpath("//div[@class='v-data-table__wrapper']//table/tbody/tr");
	By inviteAccessMember = By.xpath("//div[contains(@id,'member-list-item')]");
	By inviteAccessAdministrator = By.xpath("//div[contains(@id,'administrator-list-item')]");

	By sideRoomToastrMsg = By.cssSelector("div.v-snack__content div.flex");
	By createdSideRoomListOnSideRoomCard  = By.cssSelector("div.sideroom-list a.sideroom-list-item");
	By selectBtn = By.xpath("//span[contains(text(),'Select')]");
	By starIcon = By.cssSelector("div.inputWrapper i.v-icon.notranslate.mdi.mdi-star-outline.theme--light");
	By fileUploadLink = By.xpath("//button[contains(@id,'insertFile')]");
	By imageUploadLink = By.xpath("//button[contains(@id,'insertImage')]");
	By file_Tf = By.cssSelector("input[type='file']");
	By favouriteMsgStarIcon = By.cssSelector("i.v-icon.notranslate.v-icon--link.mdi.mdi-star.theme--light.accent--text"); 
	//Action Methods    
	public void enterMessageInChatBox(RemoteWebDriver driver, String value)
	{
//		if(checkIfElementIsClickable(driver, showChatWindowPlusIcon,3))
//			click(driver, showChatWindowPlusIcon);
		waitForElementVisibility(driver, chatBox);
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(driver.findElement(chatBox))
				.click()	
				.sendKeys(driver.findElement(chatBox), value)
				.build();
		seriesOfActions.perform() ;
		
	}

	public void enterThreadTitle(RemoteWebDriver driver, String titleName) {
		waitForElementVisibility(driver, threadTitle);
		enterDataWithoutClearTextField(driver, threadTitle, titleName);
	}
	public void enterAddMemberEmail(RemoteWebDriver driver, String email) {
		waitForElementVisibility(driver, addMemberByEmail_Tf);
		hardWait(2000);
		enterDataWithoutClearTextField(driver, addMemberByEmail_Tf, email);
		hardWait(2000);
	}

	public void enterColorCodeInColorFields(RemoteWebDriver driver, String colorCode) {
		waitForElementVisibility(driver, colorCode_Tf);
		enterData(driver, colorCode_Tf, colorCode);
	}

	public void enterAddFollowerMail(RemoteWebDriver driver,String followMail) {
		waitForElementVisibility(driver, addFollowersMail);
		enterData(driver, addFollowersMail, followMail);
		hardWait(1000);
		WebElement searchMailList = getDynamicWebElementByText(driver, "//div[contains(text(),'"+followMail+"')]");
		waitForElementVisibility(driver, searchMailList);
		searchMailList.click();
	}

	public void enterAndSelectMailOnSideRoomPage(RemoteWebDriver driver, List<String> sideRoomMail) {
		enterData(driver, sideRoomEmail, sideRoomMail.get(0));
		By searchMail = By.xpath("//div[contains(text(),'"+sideRoomMail.get(0)+"')]");
		click(driver, searchMail);
		enterData(driver, sideRoomEmail, sideRoomMail.get(1));
		By searchMail1 = By.xpath("//div[contains(text(),'"+sideRoomMail.get(1)+"')]");
		click(driver, searchMail1);
	}

	public void enterInviteAcessOnSideRoom(RemoteWebDriver driver,  List<String> usersOnSideRoom,List<String> accessMailOnSideRoom) {
		int count =0;
		waitForAllElementPresenceByElement(driver, inviteAccessOnSideRoom);
		List<WebElement> userRecordElements = getWebElements(driver, inviteAccessOnSideRoom);
		waitForvisibilityOfAllElements(driver, userRecordElements);
		for(WebElement userRecordElement :userRecordElements) {
			scrollDownByLocator(driver, userRecordElement);
			List<WebElement> tdUserRecordElements = userRecordElement.findElements(By.xpath("td"));
			waitForvisibilityOfAllElements(driver, tdUserRecordElements);
			for(int i=0;i<tdUserRecordElements.size();i++) {
				if(tdUserRecordElements.get(i).getText().trim().equals(usersOnSideRoom.get(count))) {
					String inviteText = userRecordElement.findElement(By.xpath("td[2]//div[@class='v-select__selection v-select__selection--comma']")).getText().trim();
					if(!inviteText.equals(accessMailOnSideRoom.get(count))) {
						waitForElementVisibility(driver, userRecordElement.findElement(By.xpath("td[2]//div[@class='v-input__append-inner']")));
						waitForElementClickability(driver, userRecordElement.findElement(By.xpath("td[2]//div[@class='v-input__append-inner']")));
						userRecordElement.findElement(By.xpath("td[2]//div[@class='v-input__append-inner']")).click();
						if(accessMailOnSideRoom.get(count).equals("Member")) {
							waitForElementVisibility(driver, inviteAccessMember);
							waitForElementClickability(driver, inviteAccessMember);
							click(driver, inviteAccessMember);
						}
						else {
							waitForElementVisibility(driver, inviteAccessAdministrator);
							waitForElementClickability(driver, inviteAccessMember);
							click(driver, inviteAccessAdministrator);
						}
					}
					count++;
					break;
				}
			}
		}
	}

	public void enterSearchUserOnPrivateChatWindow(RemoteWebDriver driver, String chatEmail) {
		waitForElementVisibility(driver, searchUserOnPrivateChatWindow);
		waitForElementClickability(driver, searchUserOnPrivateChatWindow);
		enterData(driver, searchUserOnPrivateChatWindow, chatEmail);
		hardWait(2000);
		List<WebElement> searchUsersElementList = driver.findElements(By.xpath("//div[contains(@class,'v-select-list')]//div[@class='v-list-item__subtitle']"));
		for(WebElement searchUserElement: searchUsersElementList) {
			if(searchUserElement.getText().trim().equals(chatEmail)) {
				waitForElementVisibility(driver, searchUserElement);
				searchUserElement.click();
				break;
			}
		}

	}

	public void enterRoomName(RemoteWebDriver driver, String sideRoomName) {
		waitForAllElementPresenceByElement(driver, createRoomNameAndDescription);
		List<WebElement> listElement = getWebElements(driver, createRoomNameAndDescription);
		listElement.get(0).clear();
		listElement.get(0).sendKeys(sideRoomName);
		hardWait(1000);
	}

	public void enterDescription(RemoteWebDriver driver,String description) {
		waitForAllElementPresenceByElement(driver, createRoomNameAndDescription);
		List<WebElement> listElement = getWebElements(driver, createRoomNameAndDescription);
		listElement.get(1).sendKeys(description);
	}

	public void enterMessageOnPrivateChatWindow(RemoteWebDriver driver, String privateMessage) {
		waitForElementVisibility(driver, privateChat_Tf);
		enterDataAndPressEnter(driver, privateChat_Tf, privateMessage);
	}

	public void enterFileUploadLink(RemoteWebDriver driver ,String filePath ,String fileName)
	{
		hardWait(3000);
		getWebElement(driver, file_Tf).sendKeys(filePath+fileName);
		hardWait(6000);
	}

	public void clickAddFollowersToThread(RemoteWebDriver driver) {
		waitForElementVisibility(driver, addFollowersToThread);
		click(driver, addFollowersToThread);
	}
	
	public void clickCloseIconOnThreadPopUp(RemoteWebDriver driver) {
		waitForElementVisibility(driver, closeThreadPopUp);
		click(driver, closeThreadPopUp);
	}
	
	public void clickStarIcon(RemoteWebDriver driver) {
		click(driver, starIcon);
	}

	public void clickRoomToggleOnChatBox(RemoteWebDriver driver, String firstSideRoomNameForMoveMessage ,String secondSideRoomNameForMoveMessage) {
		waitForElementVisibility(driver, roomToggleOnChatBox);
		waitForElementClickability(driver, roomToggleOnChatBox);
		hardWait(4000);
		click(driver, roomToggleOnChatBox);
		mouseHover(driver, roomToggleOnChatBox);
		if(isElementPresent(driver, clearBtn))
			mouseHoverAndClick(driver, clearBtn);
		WebElement firstSideRoomElement  = driver.findElement(By.xpath("//label[contains(text(),'"+firstSideRoomNameForMoveMessage+"')]"));
		scrollDownByLocator(driver, firstSideRoomElement);
		waitForElementVisibility(driver, firstSideRoomElement);
		firstSideRoomElement.click();
		hardWait(3000);
		WebElement secondSideRoomElement  = driver.findElement(By.xpath("//label[contains(text(),'"+secondSideRoomNameForMoveMessage+"')]"));
		scrollDownByLocator(driver, secondSideRoomElement);
		waitForElementVisibility(driver, secondSideRoomElement);
		secondSideRoomElement.click();
	}

	public void clickCreatedSideFromListOnSideRoomCard(RemoteWebDriver driver,String createdSideRoom) {
		waitForAllElementPresenceByElement(driver, createdSideRoomListOnSideRoomCard);
		List<WebElement> createdSideRoomListElement = getWebElements(driver, createdSideRoomListOnSideRoomCard);
		for(WebElement createdSideRoomElement: createdSideRoomListElement) {
			if(createdSideRoomElement.getText().trim().equals(createdSideRoom) ) {
				waitForElementVisibility(driver, createdSideRoomElement);
				hardWait(1000);
				createdSideRoomElement.click();
				break;
			}
		}
	}

	public void clickCreatedSideFromListOnSideRoomCard(RemoteWebDriver driver,String createdSideRoom, String secondSideRoomName) {
		int flag = 0;
		waitForAllElementPresenceByElement(driver, createdSideRoomListOnSideRoomCard);
		List<WebElement> createdSideRoomListElement = getWebElements(driver, createdSideRoomListOnSideRoomCard);
		for(WebElement createdSideRoomElement: createdSideRoomListElement) {
			if(createdSideRoomElement.getText().trim().equals(createdSideRoom) || createdSideRoomElement.getText().trim().equals(secondSideRoomName) ) {
				waitForElementVisibility(driver, createdSideRoomElement);
				createdSideRoomElement.click();
				flag++;
				if(flag == 2)
					break;
			}
		}
	}

	public void clickSelectBtnOnSelectContainerCard(RemoteWebDriver driver) {
		waitForElementVisibility(driver, selectBtn);
		waitForElementClickability(driver, selectBtn);
		click(driver, selectBtn);
		waitForElementInVisibilityByLocator(driver, selectBtn);
	}

	public void clickFileUploadLink(RemoteWebDriver driver)
	{
		waitForElementVisibility(driver, fileUploadLink);
		click(driver, fileUploadLink);
	}

	public void clickImageUploadLink(RemoteWebDriver driver)
	{
		waitForElementVisibility(driver, chatBox);
		click(driver, chatBox);
		waitForElementVisibility(driver, imageUploadLink);
		click(driver, imageUploadLink);
	}

	public void addFollowerBtn(RemoteWebDriver driver) {
		waitForElementVisibility(driver, addFollowerBtn);
		click(driver, addFollowerBtn);
	}
	public void clickUnPinMessage(RemoteWebDriver driver) {
		click(driver, unPinMessage);
	}

	public void clickStartSideRoomLink(RemoteWebDriver driver) {
		waitForElementVisibility(driver, threeDotsOnSideRoom);
		waitForElementClickability(driver, threeDotsOnSideRoom);
		hardWait(2000);
		click(driver, threeDotsOnSideRoom);
		waitForElementVisibility(driver, startNewSideRoom);
		click(driver, startNewSideRoom);
	}

	public void clickPinMessageDotsBtn(RemoteWebDriver driver) {
		hardWait(1000);
		waitForElementVisibility(driver, unPinIconOnPinMessage);
		mouseHoverAndClick(driver, unPinIconOnPinMessage);
	}

	public void clickAdvanceLinkUnderChatBox(RemoteWebDriver driver) {
		waitForElementVisibility(driver, advanceLink);
		click(driver, advanceLink);
	}

	public void clickStartNewSideRoomLink(RemoteWebDriver driver) {
		click(driver, startNewSideRoom);
	}

	public void selectSideRoomSelectContainerCard(RemoteWebDriver driver, String createdSideRoom) {
		waitForElementVisibility(driver, organization_Input);
		waitForElementVisibility(driver, group_Input);
		waitForElementVisibility(driver, room_Input);
		waitForElementVisibility(driver, sideRoomName_Tf);
		hardWait(1000);
		enterData(driver, sideRoomName_Tf, createdSideRoom);
		waitForElementVisibility(driver, sideRoomName_Tf);
		click(driver, searchedSideRoom);
		//		hardWait(3000);
		scrollDown(driver);
		//		List<WebElement> sideRoomListElements = getWebElements(driver, sideRoomList);
		//		for(WebElement sideRoomElement: sideRoomListElements) {
		//			scrollDownByLocatorByElement(driver, sideRoomElement);
		//			scrollDown(driver);
		//			if(sideRoomElement.getText().trim().equals(createdSideRoom)) {
		//				hardWait(1000);
		//				sideRoomElement.click();
		//			break;
		//			}
		//		}
	}

	public void clickMoveToAnotherRoom(RemoteWebDriver driver) {
		waitForElementVisibility(driver, moveToAnotherRoomLink);
		waitForElementClickability(driver, moveToAnotherRoomLink);
		hardWait(1000);
		click(driver, moveToAnotherRoomLink);
	}

	public void clickCreateThreadBtn(RemoteWebDriver driver) {
		scrollDownByLocator(driver, createThreadBtn);
		click(driver, createThreadBtn);
		waitForElementInVisibilityByLocator(driver, createThreadBtn);
		if(getWebElements(driver, createBtnLoader).size()>0)
			waitForElementInVisibilityByLocator(driver, createBtnLoader);
		hardWait(2000);
	}

	public void clickSideRoomCreateBtn(RemoteWebDriver driver) {
		scrollDownByLocator(driver, createSiedRoomBtn);
		//		hardWait(4000);
		////		waitForElementVisibility(driver, createThreadBtn);
		//		if(getWebElements(driver, createSiedRoomBtn).size()>1)
		//			getWebElements(driver, createSiedRoomBtn).get(1).click();
		//		else
		scrollDownByLocator(driver, createSiedRoomBtn);
		waitForElementVisibility(driver, createSiedRoomBtn);
		click(driver, createSiedRoomBtn);
		waitForElementInVisibilityByLocator(driver, createSiedRoomBtn);
		waitForElementInVisibilityByLocator(driver, createSideRoomLoader);
		hardWait(2000);
	}

	public void clickAddThreadLink(RemoteWebDriver driver) {
		waitForElementVisibility(driver, addThreadLink);
		mouseHover(driver, addThreadLink);
//		waitForElementVisibility(driver, createNewThread);
//		click(driver, createNewThread);
		List<WebElement> activeListElements = getWebElements(driver, activeListInChatBox);
		for(WebElement activeElement : activeListElements) {
			waitForElementVisibility(driver, activeElement);
			scrollDownByLocator(driver, activeElement);
			if(activeElement.getText().trim().toLowerCase().equals("create new thread")) {
				activeElement.click();
				break;
			}
		}
	}

	public void clickCurrrentDateAndTime(RemoteWebDriver driver) {
		click(driver, currentTime);
	}
	public void clickAddMemberLink(RemoteWebDriver driver) {
		waitForElementVisibility(driver, addMember);
		click(driver, addMember);
	}

	public void clickAddMemberBtn(RemoteWebDriver driver) {
		click(driver, addMemberBtn);
	}
	public void enterUrlOnUrlTxtField(RemoteWebDriver driver, String viedoUrl) {
		waitForElementVisibility(driver, videoUrl_Tf);
		enterDataWithoutClearTextField(driver, videoUrl_Tf, viedoUrl);
	}
	public void clickInsertVideoBtn(RemoteWebDriver driver) {
		click(driver, insertViedoBtn);
	}

	public void clickOnSendButton(RemoteWebDriver driver) 
	{
//		if(isBtnEnabled(driver, sendButton))
//			click(driver, sendButton);
		waitForElementVisibility(driver, chatBox);
		getWebElement(driver, chatBox).sendKeys(Keys.ENTER);
	}
	public void clickPlusIconOnChatBox(RemoteWebDriver driver) {
		hardWait(3000);
		click(driver, chatBox);
		waitForElementVisibility(driver, plusIconOnChatBox);
		click(driver, plusIconOnChatBox);
	}

	public void clickInsertVideoLink(RemoteWebDriver driver) {
		click(driver, insertVideo);
	}

	public void clickPrivateChatLink(RemoteWebDriver driver) {
		click(driver, privateChat);
	}

	public void clickEditPrivateChatWindow(RemoteWebDriver driver) {
		waitForElementClickability(driver, editBtnOnPrivateChat);
		waitForElementVisibility(driver, editBtnOnPrivateChat);
		click(driver, editBtnOnPrivateChat);
	}
	public void clickBlueColorFromColorField(RemoteWebDriver driver, String colorCode) {
		click(driver, chatBox);
		waitForElementVisibility(driver, moreTextColor);
		click(driver, moreTextColor);
		waitForElementVisibility(driver, textColor);
		click(driver, textColor);
		enterColorCodeInColorFields(driver, colorCode);
		waitForElementVisibility(driver, OkBtnOnColorField);
		click(driver, OkBtnOnColorField);
	}

	public void assignInvitedMembersRole(RemoteWebDriver driver,List<String>  InvitedMenbers) {
		scrollDown(driver);
		hardWait(2000);
		int count =0;
		WebElement addedMemberForCreating =  driver.findElement(By.xpath("//div[@class='v-data-table__wrapper']//tbody"));
		List<WebElement> invitedMembersList = addedMemberForCreating.findElements(By.xpath("tr"));
		for(WebElement trElement: invitedMembersList) {
			if(InvitedMenbers.get(0).equals(trElement.getText().trim())) {
				count++;
				addedMemberForCreating.findElement(By.xpath("tr['"+count+"']/td[2]")).click();
				click(driver, InviteAccessByAdministrator);
			}
		}

	}



	public void clickOnBoldButton(RemoteWebDriver driver) throws InterruptedException
	{
		click(driver, boldButton);
	}

	public void clickOnItalicButton(RemoteWebDriver driver) throws InterruptedException
	{
		click(driver, italicButton);
	}

	public void clickOnUnderlineButton(RemoteWebDriver driver) throws InterruptedException
	{
		click(driver, underlineButton);
	}

	public void clickOnStrikethroughButton(RemoteWebDriver driver) throws InterruptedException
	{
		click(driver, strikethroughImageButton);
	}

	public void clickOnColorButton(RemoteWebDriver driver) throws InterruptedException
	{
		click(driver, colorImageButton);
	}

	public void clickOnColorTextButton(RemoteWebDriver driver) throws InterruptedException
	{
		click(driver, colorTextImageButton);
	}

	public void clickOnBackgroundColorTextButton(RemoteWebDriver driver) throws InterruptedException
	{
		click(driver, backgroundColorTextImageButton);
	}	

	public void clickOnHexOkButton(RemoteWebDriver driver) throws InterruptedException
	{
		click(driver, okColorButton);
	}

	public void clickOnBackColor(RemoteWebDriver driver) throws InterruptedException
	{
		click(driver, backColorIcon);
	}

	public void clickClosePrivateChatBox(RemoteWebDriver driver) 
	{
		waitForElementVisibility(driver, closePrivateChatBox);
		click(driver, closePrivateChatBox);
	}

	public void clickOnHexColor(RemoteWebDriver driver) throws InterruptedException
	{
		click(driver, textColorIcon);
	}

	public void clickOnInsertImageButton(RemoteWebDriver driver) throws InterruptedException
	{
		click(driver, insertImageButton);
	}

	public void clickOnYellowMessageIfAppear(RemoteWebDriver driver) throws InterruptedException
	{
		if(driver.findElements(yellowMessage).size() > 0) {
			click(driver, yellowMessage);
		}
	}

	public void clickLastSendMsg(RemoteWebDriver driver)
	{
		hardWait(3000);
		scrollDownByLocator(driver, lastSendedUploadFileLink);
		mouseHoverAndClick(driver, lastSendedUploadFileLink);
	}

	public void clickLastSendMessageDots(RemoteWebDriver driver) {
		hardWait(3000);
		scrollDownByLocator(driver, lastRecordInChatList);
		mouseHover(driver, lastRecordInChatList);
		hardWait(4000);
		mouseHoverAndClick(driver, pinIconInChatBoxMsgList);

	}
	public void clickPinMessageFromMsgList(RemoteWebDriver driver) {
		click(driver, pinMessage);
	}

	public void enterHexColorCode(RemoteWebDriver driver,String value) 
	{
		mouseHover(driver,hexColorCodeTextBox);
		enterData(driver, hexColorCodeTextBox, value);
	}	

	public void enterImageLocation(RemoteWebDriver driver, String path) throws InterruptedException
	{
		enterData(driver, insertImageFileButton, path);
	}


	//Boolean Methods
	public boolean isMessageSent(RemoteWebDriver driver, String message) throws InterruptedException
	{
		return isElementPresent(driver, By.xpath("//div/p[text()='"+message+"']"));
	}

	public boolean isMessageSentunderline(RemoteWebDriver driver, String message) throws InterruptedException
	{
		return isElementPresent(driver, By.xpath("(//div[@class='message-content pr-5']/div/p/u[text()='"+message+"'])[last()]"));
	}

	public boolean isImageFileInsert(RemoteWebDriver driver)
	{
		hardWait(4000);
		scrollDownByLocator(driver, lastSendedUploadFileLink);
		WebElement imgElement = getWebElement(driver, lastSendedUploadFileLink).findElement(By.xpath("img"));
		return imgElement.isDisplayed();

	}

	//Get Methods
	public String getMessageBoldTagName(RemoteWebDriver driver, String message) throws InterruptedException
	{
		return getElementTagName(driver, By.xpath("//div//strong[text()='"+message+"']"));
	}

	public String getMessageItalicTagName(RemoteWebDriver driver, String message) throws InterruptedException
	{
		return getElementTagName(driver, By.xpath("//div//em[text()='"+message+"']"));
	}

	public int getFavouriteMsg(RemoteWebDriver driver) {
		waitForElementVisibility(driver, lastSendedMsgInChatRoom);
		scrollDownByLocator(driver, lastSendedMsgInChatRoom);
		hardWait(2000);
		return getWebElements(driver, favouriteMsgStarIcon).size();
	}

	public String getLastSendMsgOnChatBox(RemoteWebDriver driver) {
		hardWait(1000);
		waitForAllElementPresenceByElement(driver, lastSendedMsgInChatRoom);
		scrollDownByLocator(driver, lastSendedMsgInChatRoom);
		String splitEntryId = getText(driver, lastSendedMsgInChatRoom).split(":")[0].split("#")[1];
		return splitEntryId;
	}

	public String getMessageUnderlineTagName(RemoteWebDriver driver, String message) throws InterruptedException
	{
		return getElementTagName(driver, By.xpath("//div//u[text()='"+message+"']"));
	}


	public String getMessageStrikethroughTagName(RemoteWebDriver driver, String message) throws InterruptedException
	{
		return getElementTagName(driver, By.xpath("//div//s[text()='"+message+"']"));
	}

	public String getAddFollowerAssertionMsg(RemoteWebDriver driver) {
		waitForElementVisibility(driver, addFollowerAssertionMsg);
		return getText(driver, addFollowerAssertionMsg);
	}

	public String getLastMessageFromCockpit(RemoteWebDriver driver, String message) throws InterruptedException
	{
		WebElement c1=driver.findElement(By.xpath(("(//div[@class='message-content pr-5']/div/p/span)[last()]")));
		waitForElementVisibility(driver, c1);
		return c1.getCssValue("color"); 
	}
	public String getLastMessageColor(RemoteWebDriver driver , String colorText) {
		WebElement element= driver.findElement(By.xpath("//span[contains(text(),'"+colorText+"')][@style]"));
		waitForElementVisibility(driver, element);
		return element.getCssValue("color");
	}


	public String getPinColorName(RemoteWebDriver driver) {
		waitForElementVisibility(driver, pinMessageThreeDotBtn);
		hardWait(2000);
		WebElement pinMsgColor = getWebElement(driver, pinMessageThreeDotBtn);
		waitForElementVisibility(driver, pinMessageThreeDotBtn);
		return pinMsgColor.getCssValue("value");
	}

	public String getPinAndUnPinConfirmMessage(RemoteWebDriver driver) {
		String text = null;
		hardWait(1000);
		if(getWebElements(driver, confirmBoxForPinMessage).size()>1)
			text = getWebElements(driver, confirmBoxForPinMessage).get(0).getText().trim();
		else
			text = getText(driver, confirmBoxForPinMessage);
		return text;
	}


	public String getCreateSideRoomMessage(RemoteWebDriver driver) {
		waitForElementVisibility(driver, createSideRoomAssertion);
		return getText(driver, createSideRoomAssertion);
	}

	public String getLastSentMsgOnPrivateChat(RemoteWebDriver driver) {
		hardWait(3000);
		return getText(driver, lastChatFromPrivateChatList);
	}

	public String getBoardcastMsgInRoom(RemoteWebDriver driver) {
		waitForAllElementPresenceByElement(driver, lastRecordInChatList);
		waitForElementVisibility(driver, lastRecordInChatList);
		WebElement msgElement = getWebElement(driver, lastRecordInChatList).findElement(By.xpath("//p"));
		waitForElementVisibility(driver, msgElement);
		return msgElement.getText().trim();
	}

	public boolean isSideRoomCreated(RemoteWebDriver driver ,String createdSideRoom ,SoftAssert softAssert) {
		boolean status = false;
		waitForAllElementPresenceByElement(driver, createdSideRoomListOnSideRoomCard);
		List<WebElement> createdSideRoomListElement = getWebElements(driver, createdSideRoomListOnSideRoomCard);
		for(WebElement createdSideRoomElement: createdSideRoomListElement) {
			hardWait(1000);
			waitForElementClickability(driver, createdSideRoomElement);
			if(createdSideRoomElement.getText().trim().equals(createdSideRoom)) {
				status = true;
				break;
			}
		}
		return status;
	}
	public boolean isNewThreadVisibleUnderThreadCard(RemoteWebDriver driver,String threadTitle,SoftAssert softAssert) {
		boolean isNewThreadExist = false;
		hardWait(4000);
		waitForAllElementPresenceByElement(driver, createdThreadList);
		List<WebElement> threadListElement = getWebElements(driver, createdThreadList);
		waitForvisibilityOfAllElements(driver, threadListElement);
		for(WebElement threadElement:threadListElement) {
			scrollDownByLocator(driver, threadElement);
			if(threadElement.getText().trim().equals(threadTitle)) {
				waitForElementVisibility(driver, threadElement);
				threadElement.click();
				isNewThreadExist =true;
				break;
			}
		}
		return isNewThreadExist;
	}

	public void createThreadWithMultipleMsg(RemoteWebDriver driver, String threadNames, String titleName, String createdSideRoom) {
		int randomNumber  = generateRandomNumber();
		int randomNumberForThread2  = generateRandomNumber();
		int randomNumberForThread3  = generateRandomNumber();
		int checkBoxCount =0;

		enterMessageInChatBox(driver, threadNames+randomNumber);
		clickOnSendButton(driver);
		hardWait(1000);
		enterMessageInChatBox(driver, threadNames+randomNumberForThread2);
		clickOnSendButton(driver);
		hardWait(1000);
		enterMessageInChatBox(driver, threadNames+randomNumberForThread3);
		clickOnSendButton(driver);
		clickCreatedSideFromListOnSideRoomCard(driver, createdSideRoom);
		scrollDownByLocator(driver, lastRecordInChatList);
		waitForElementVisibility(driver, lastRecordInChatList);
		hardWait(2000);
		mouseHover(driver, lastRecordInChatList);
		waitForElementVisibility(driver, threeDotsSentMsg);
		hardWait(3000);
		mouseHoverAndClick(driver, threeDotsSentMsg);
		clickAddThreadLink(driver);
		enterThreadTitle(driver, titleName);
		scrollDown(driver);
		scrollDownByLocator(driver, getWebElements(driver, selectedCheckBoxOnAddToThreadPage).get(0));
		waitForAllElementPresenceByElement(driver, checkBoxOnAddToThreadPage);
		List<WebElement> unCheckboxList = getWebElements(driver, checkBoxOnAddToThreadPage);
		hardWait(2000);
		for(int i = unCheckboxList.size();i>0;i--) {
			JSClick(driver, unCheckboxList.get(i-1));
			checkBoxCount++;
			if(checkBoxCount==2) {
				break;
			}
		}
		clickCreateThreadBtn(driver);
	}

	public void createAndVerifyColorMessagePosting(RemoteWebDriver driver, String colorCode, String colorMessage, String actColorCode,SoftAssert softAssert) {
		int randomNumber = generateRandomNumber();
		clickBlueColorFromColorField(driver, colorCode);
		enterMessageInChatBox(driver, colorMessage+randomNumber);
		clickOnSendButton(driver);
		String expColorCodeFromCreatedMessageList = getLastMessageColor(driver, colorMessage+randomNumber);
		softAssert.assertEquals(actColorCode.trim(), expColorCodeFromCreatedMessageList.trim(),"Message color is not same as expected");
	}

	public void verifyMessagePinAndUnPin(RemoteWebDriver driver, String pinMessage,String expPinMessage,String expUnPinMessage,String createdSideRoom,SoftAssert softAssert) {
		int randomNumber = generateRandomNumber();

		enterMessageInChatBox(driver, pinMessage+randomNumber);
		clickOnSendButton(driver);
		clickCreatedSideFromListOnSideRoomCard(driver, createdSideRoom);
		clickLastSendMessageDots(driver);
//		clickPinMessageFromMsgList(driver);
		softAssert.assertEquals(getPinAndUnPinConfirmMessage(driver), expPinMessage);
		click(driver, confirmPopUpOkBtn);
//		getPinColorName(driver);
		mouseHover(driver, pinMessageThreeDotBtn);
		clickPinMessageDotsBtn(driver);
//		clickUnPinMessage(driver);
		softAssert.assertEquals(getPinAndUnPinConfirmMessage(driver), expUnPinMessage);
		click(driver, confirmPopUpOkBtn);
	}

	public void verifyPrivateChat(RemoteWebDriver driver, TopBar topBar, String privateMessage,String chatEmail ,SoftAssert softAssert) {
		int randomNumber = generateRandomNumber();
		topBar.clickOnHamburgerMenuButton(driver);
		clickPrivateChatLink(driver);
		clickEditPrivateChatWindow(driver);
		enterSearchUserOnPrivateChatWindow(driver, chatEmail);
		enterMessageOnPrivateChatWindow(driver, privateMessage+randomNumber);
		String expSentLastMsg = getLastSentMsgOnPrivateChat(driver);
		softAssert.assertEquals( expSentLastMsg,privateMessage+randomNumber,"last sent message is not same on private window chat");
		clickClosePrivateChatBox(driver);
	}

	public void verifyPresentUserCount(RemoteWebDriver driver, SoftAssert softAssert) {
		int count =0;
		List<WebElement> presentUserElements = driver.findElements(By.xpath("//header[contains(@class,'v-sheet v-sheet--tile theme--light')]//div[contains(text(),'Present')]"));
		waitForvisibilityOfAllElements(driver, presentUserElements);
		for(WebElement element:presentUserElements) {
			if(element.getText().trim().contains("Present") && count == 0) {
				int size= driver.findElements(By.cssSelector("div.leftContent__list.member-left-list div.v-list.membersList--present.membersList div.member-wrapper")).size();
				count++;
				softAssert.assertTrue(element.getText().trim().split("Present")[1].trim().contains(Integer.toString(size)));
			}
//			else if(element.getText().trim().contains("Not Present")) {
//				int size= driver.findElements(By.cssSelector("div.leftContent__list.member-left-list div.v-list.membersList--not.membersList div.member-wrapper.hoverParent.v-list-item")).size();
//				String labeltext = element.getText().trim().split("Not Present")[1].trim();
//				System.out.println("Count of not present user from label :"+labeltext);
//
//				System.out.println("Count of not present users in the user list :"+size);
//				softAssert.assertTrue(element.getText().trim().split("Not Present")[1].trim().contains(Integer.toString(size)));
//			}
		}
	}

	public void verifyVideoInserted(RemoteWebDriver driver, String viedoUrl, SoftAssert softAssert) {
		hardWait(2000);
		int beforeInsertVideoSize = driver.findElements(By.xpath("//div[contains(@class,'message-content')]//p//span//iframe")).size();
		click(driver, chatBox);
//		clickPlusIconOnChatBox(driver);
		clickInsertVideoLink(driver);
		enterUrlOnUrlTxtField(driver, viedoUrl);
		clickInsertVideoBtn(driver);
		hardWait(3000);
		clickOnSendButton(driver);
//		clickPlusIconOnChatBox(driver);
		hardWait(4000);
		int afterInsertVideoSize = driver.findElements(By.xpath("//div[contains(@class,'message-content')]//p//span//iframe")).size();
		softAssert.assertEquals(beforeInsertVideoSize+1, afterInsertVideoSize);

	}

	public void verifyMoveThreadToAnotherRoom(RemoteWebDriver driver,String threadNames, String titleName,String sideRoomName,String expSideRoomMsg,String createdSideRoom ,SoftAssert softAssert) {
		int randomNumber  = generateRandomNumber();
		createThreadWithMultipleMsg(driver, threadNames, titleName+randomNumber, createdSideRoom);
		clickStartSideRoomLink(driver);
		enterRoomName(driver, sideRoomName+randomNumber);
		clickSideRoomCreateBtn(driver);
		softAssert.assertEquals(getText(driver, sideRoomToastrMsg),expSideRoomMsg);
		softAssert.assertTrue(isNewThreadVisibleUnderThreadCard(driver, titleName+randomNumber, softAssert));
		waitForElementVisibility(driver, getWebElements(driver, threeDotsOnChatBox).get(0));
		hardWait(2000);
		getWebElements(driver, threeDotsOnChatBox).get(0).click();
		clickAdvanceLinkUnderChatBox(driver);
		clickMoveToAnotherRoom(driver);
		selectSideRoomSelectContainerCard(driver, sideRoomName+randomNumber);
		clickSelectBtnOnSelectContainerCard(driver);
		clickCreatedSideFromListOnSideRoomCard(driver, sideRoomName+randomNumber);
//		softAssert.assertTrue(isNewThreadVisibleUnderThreadCard(driver, titleName+randomNumber, softAssert));
	}


	public void verifyThreadFollowers(RemoteWebDriver driver, String threadNames, String titleName,String followMailToAazad ,String followMailToNaveen,String expFollowerAssertionMsg, String createdSideRoom,SoftAssert softAssert) {
		int randomNumber  = generateRandomNumber();
		List<String> actualFollower = new ArrayList<>();
		actualFollower.add(followMailToAazad);
		actualFollower.add(followMailToNaveen);
		createThreadWithMultipleMsg(driver, threadNames, titleName+randomNumber, createdSideRoom);
		softAssert.assertTrue(isNewThreadVisibleUnderThreadCard(driver, titleName+randomNumber, softAssert),"Thread are not exist on thread card");
		waitForElementVisibility(driver, lastRecordInThreadChat);
		mouseHover(driver, lastRecordInThreadChat);
		mouseHoverAndClick(driver, threeDotsSentMsgInThreadChat);
		clickAddFollowersToThread(driver);
		enterAddFollowerMail(driver, followMailToAazad);
		waitForElementVisibility(driver, addFollowerTitle);
		click(driver, addFollowerTitle);
		enterAddFollowerMail(driver, followMailToNaveen);
		addFollowerBtn(driver);
		softAssert.assertEquals(getAddFollowerAssertionMsg(driver), expFollowerAssertionMsg,"Add followers Message are not same as expected");
		waitForElementInVisibilityByLocator(driver, addFollowerAssertionMsg);
		waitForElementVisibility(driver, contactIconOnChatBox);
		click(driver, contactIconOnChatBox);
		waitForElementVisibility(driver, activeUserListOnChatBox);
		softAssert.assertEquals(getWebElements(driver, activeUserListOnChatBox).size()-1,actualFollower.size(),"Add followers user are not display on contact icon under chat box");
		clickCloseIconOnThreadPopUp(driver);
	}



	public void verifyAddMember(RemoteWebDriver driver, String addEmail,String expInvitionMsg, SoftAssert softAssert) {
		String emailWithRndNumber = addEmail+"+"+generateRandomNumber()+"@veoci.com";
		hardWait(3000);
		
//		driver.findElements(By.cssSelector("div.layout.justify-space-between div button")).get(0).click();
		clickAddMemberLink(driver);
		enterAddMemberEmail(driver, emailWithRndNumber);
		By addSearchMemberInList = By.xpath("//div[contains(text(),'"+emailWithRndNumber+"')]");
		click(driver, addSearchMemberInList);
		scrollDown(driver);
		clickCurrrentDateAndTime(driver);
		clickAddMemberBtn(driver);
		String text = getText(driver, invitationMsgToastr);
		softAssert.assertEquals(text, expInvitionMsg);

	}
	public void createAndVerifySideRoom(RemoteWebDriver driver,String sideRoomName,String expSideRoomMsg ,String description ,List<String> sideRoomMail ,List<String> accessMailOnSideRoom ,List<String> usersOnSideRoom,SoftAssert softAssert) {
		int randomNumber  = generateRandomNumber();
		clickStartSideRoomLink(driver);
		enterRoomName(driver, sideRoomName+randomNumber);
		enterDescription(driver, description);
		enterAndSelectMailOnSideRoomPage(driver, sideRoomMail);
		enterInviteAcessOnSideRoom(driver, usersOnSideRoom, accessMailOnSideRoom);
		clickSideRoomCreateBtn(driver);
		softAssert.assertEquals(getText(driver, sideRoomToastrMsg),expSideRoomMsg);
		hardWait(3000);
		softAssert.assertTrue(isSideRoomCreated(driver, sideRoomName+randomNumber, softAssert));
	}

	public void verifyBoardcastMsg(RemoteWebDriver driver ,String sideRoomName ,String boardCastMessage ,String expSideRoomMsg ,SoftAssert  softAssert) {
		int randomNumber  = generateRandomNumber();
		clickStartSideRoomLink(driver);
		enterRoomName(driver, sideRoomName+randomNumber);
		
		clickSideRoomCreateBtn(driver);
		softAssert.assertEquals(getText(driver, sideRoomToastrMsg),expSideRoomMsg);
		clickStartSideRoomLink(driver);
		enterRoomName(driver, sideRoomName+randomNumber+12);
		clickSideRoomCreateBtn(driver);
		clickRoomToggleOnChatBox(driver, sideRoomName+randomNumber,sideRoomName+randomNumber+12);
		enterMessageInChatBox(driver, boardCastMessage);
		clickOnSendButton(driver);
		clickCreatedSideFromListOnSideRoomCard(driver, sideRoomName+randomNumber);
		pageRefresh(driver);
		hardWait(4000);
		softAssert.assertEquals(getBoardcastMsgInRoom(driver), boardCastMessage);
		clickCreatedSideFromListOnSideRoomCard(driver, sideRoomName+randomNumber+12);
		softAssert.assertEquals(getBoardcastMsgInRoom(driver), boardCastMessage);
	}
}
