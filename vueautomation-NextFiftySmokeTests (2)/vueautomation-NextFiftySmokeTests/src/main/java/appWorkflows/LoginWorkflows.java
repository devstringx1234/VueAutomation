package appWorkflows;

import org.openqa.selenium.remote.RemoteWebDriver;

import constants.Constants;
import pages.LoginPage;
import pages.bars.TopBar;
import utils.EncryptionDecryption;
import utils.FileOperations;
import utils.ReadingEmails;

public class LoginWorkflows 
{
	ReadingEmails readingEmailsObj = new ReadingEmails();
	FileOperations fileOperations = new FileOperations();
	Constants constants = new Constants();
	EncryptionDecryption encryptionDecryptionObj = new EncryptionDecryption();
	String subject = "Your Veoci Stage Login Code";
	LoginPage loginPage=new LoginPage();
	TopBar header=new TopBar();

	public void LoginAndNavigateToRoom(RemoteWebDriver driver, String userName, String password, String roomID) throws Exception 
	{
		loginPage.enterUserName(driver, userName);
		loginPage.clickOnNextButton(driver);
		loginPage.enterPassword(driver, password);
		loginPage.clickOnSignInButton(driver);
		//			header.clickFirstRoom(driver);
		if(loginPage.getMFARadioBtnSize(driver)>0) {
			loginPage.clickMFARadioBtn(driver);
			loginPage.clickSendBtn(driver);
			loginPage.hardWait(4000);
			String mfaCode = readingEmailsObj.getMailBodyContent(fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "gmailID"), encryptionDecryptionObj.decryptPassword(fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "gmailPass")), subject);
			String splitCode = mfaCode.split("<strong>")[1].split("</strong>")[0];
			loginPage.hardWait(3000);
			loginPage.enterMFAVerificationCode(driver, splitCode);
			loginPage.clickSubmitBtn(driver);
		}
//		loginPage.clickConfirmOkPupUp(driver);
//		header.clickOnHamburgerMenuButton(driver);
//		header.clickOnMegaMenuRoomLink(driver);
//		header.enterRoomToSearch(driver, roomID);
//		header.clickSearch(driver);
//		header.selectRoom(driver, roomID);
	}
	public void enterPasswordToNavigateRoom(RemoteWebDriver driver, String userName, String password, String roomID) throws Exception  
	{
//		loginPage.enterUserName(driver, userName);
		if(loginPage.getnextBtnSize(driver)>0)
	    loginPage.clickOnNextButton(driver);
		loginPage.enterPassword(driver, password);
		loginPage.clickOnSignInButton(driver);
		//			header.clickFirstRoom(driver);
		if(loginPage.getMFARadioBtnSize(driver)>0) {
			loginPage.clickMFARadioBtn(driver);
			loginPage.clickSendBtn(driver);
			loginPage.hardWait(4000);
			String mfaCode = readingEmailsObj.getMailBodyContent(fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "senderEmail"), encryptionDecryptionObj.decryptPassword(fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "senderPasswordForMail")), subject);
			String splitCode = mfaCode.split("<strong>")[1].split("</strong>")[0];
			loginPage.hardWait(3000);
			loginPage.enterMFAVerificationCode(driver, splitCode);
			loginPage.clickSubmitBtn(driver);
		}
		loginPage.clickConfirmOkPupUp(driver);
		header.clickOnHamburgerMenuButton(driver);
		header.clickOnMegaMenuRoomLink(driver);
		header.enterRoomToSearch(driver, roomID);
		header.clickSearch(driver);
		header.selectRoom(driver, roomID);
	}


	public void goToSeleniumRoom(RemoteWebDriver driver,String roomID)  {
		header.clickOnHomeIcon(driver);
		header.clickOnHamburgerMenuButton(driver);
		header.hardWait(1000);
		header.clickOnMegaMenuRoomLink(driver);
		header.hardWait(1000);
		header.enterRoomToSearch(driver, roomID);
		header.hardWait(1000);
		header.clickSearch(driver);
		header.hardWait(4000);
		header.clickOnSeleniumRoom(driver);
	}
	
	public void createNewRoom(RemoteWebDriver driver ,String newRoomName)
	{
		header.clickOnHamburgerMenuButton(driver);
		header.clickOnStartRoom(driver);
		header.enterNewRoomName(driver, newRoomName);
		header.clickOnLaunchBtn(driver);
		header.clickOnJoinBtnOnToastr(driver);
		
	}
}
