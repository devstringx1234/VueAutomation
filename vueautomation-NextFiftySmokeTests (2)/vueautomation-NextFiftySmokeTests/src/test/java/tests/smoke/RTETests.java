package tests.smoke;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import appWorkflows.LoginWorkflows;
import constants.Constants;
import init.DriverFactory;
import listner.ReportListener;
import pages.bars.TopBar;
import pages.cockpit.RTEPage;
import utils.EncryptionDecryption;
import utils.FileOperations;

public class RTETests {

	SoftAssert softAssert;
	Logger log=null;
	public DriverFactory driverFactory;

	Path currentRelativePath = Paths.get("");
	String s = currentRelativePath.toAbsolutePath().toString();
	String testDataFile = s + File.separator + "testdata" + File.separator;
	String filePath=System.getProperty("user.dir")+File.separator +"testDownloadedItems"+File.separator;
	String imageFilePath=System.getProperty("user.dir")+File.separator +"testdata"+File.separator;
	Constants constants = new Constants();
	FileOperations fileOperations = new FileOperations();
	LoginWorkflows loginWorkflows = new LoginWorkflows();
	TopBar header=new TopBar();
	EncryptionDecryption encryptionDecryptionObj = new EncryptionDecryption();
	RemoteWebDriver driver;
	RTEPage rtePage=new RTEPage();
	String automationSideRoom = "Selenium Room 203";

	@BeforeClass(alwaysRun = true)
	public void startUp() throws Exception 
	{
		fileOperations.makeDirectoryEmpty(filePath);

		log = Logger.getLogger(RTETests.class);
		PropertyConfigurator.configure(constants.CONFIG_LOG4J_FILE_PATH);
		this.driverFactory = new DriverFactory();
		this.driver = this.driverFactory.getDriver();
		Reporter.getCurrentTestResult().getTestContext().getSuite().setAttribute("driver", this.driver);
		this.driver.get(fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "appUrl"));
		log.info("URL is entered in broswer");
		String roomID=fileOperations.readSingleValueFromExcel(testDataFile,"SmokeTestData.xlsx","RTE_ValidTestData", "RoomID");
//		loginWorkflows.LoginAndNavigateToRoom(this.driver, fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "username"), encryptionDecryptionObj.decryptPassword(fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "password")), roomID);	
	}

	@Test(groups = { "smoke" },singleThreaded=true)
	public void verifyPresentUser() throws Exception 
	{
		log.info("Present online user verifyPresentUser() Test Started"); 
		softAssert = new SoftAssert();
		String roomID=fileOperations.readSingleValueFromExcel(testDataFile,"SmokeTestData.xlsx","RTE_ValidTestData", "RoomID");

		loginWorkflows.LoginAndNavigateToRoom(this.driver, fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "username"), encryptionDecryptionObj.decryptPassword(fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "password")), roomID);	
		softAssert.assertAll();
		ReportListener.logToReport("Verified present online users in user list.");
		log.info("Present online user verifyPresentUser() Test Completed"); 
	}

//	@Test(groups = { "smoke" }, singleThreaded=true)
	public void verifyPinAndUnPinMessageInChatRoom() throws InterruptedException
	{
		log.info("Pin and Unpin Message  verifyPinAndUnPinMessageInChatRoom() Test Started"); 
		softAssert = new SoftAssert(); 
		String pinMessage = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "PinMessage");
		String expPinMessage = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_VerificationData", "ExpPinMessage");
		String expUnPinMessage = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_VerificationData", "ExpUnPinMessage");
		String seleniumRoom = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AutomationSeleniumRoom");

		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);		//verify Thread followers Users
		rtePage.verifyMessagePinAndUnPin(driver, pinMessage, expPinMessage, expUnPinMessage, seleniumRoom,softAssert);   	//verify Pin Message
		softAssert.assertAll();
		ReportListener.logToReport("Verified Pin And Unpin Message In Chat Room");
		log.info("Pin and Unpin Message  verifyPinAndUnPinMessageInChatRoom() Test Completed"); 
	}

//	@Test(groups = { "smoke" }, singleThreaded=true)
	public void verifyColorMessagePostingInChatRoom() throws InterruptedException 
	{
		log.info("Color Message posting  verifyColorMessagePostingInChatRoom() Test Started"); 
		softAssert = new SoftAssert(); 
		String colorCode = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "ColorCode");
		String colorMessage = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "PostingColorMessage");
		String expColorCodeInRgb = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_VerificationData", "expColorCode"); 	
		String seleniumRoom = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AutomationSeleniumRoom");

		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);		//verify Thread followers Users
		rtePage.createAndVerifyColorMessagePosting(driver, colorCode, colorMessage, expColorCodeInRgb, softAssert);		//Create Message text with blue color  and  also verify
		softAssert.assertAll();
		ReportListener.logToReport("Verified Color Message In Chat Room");
		log.info("Color Message posting  verifyColorMessagePostingInChatRoom() Test Completed"); 
	}

//	@Test(groups = { "smoke" }, singleThreaded=true)
	public void verifyInsertVideoInChatRoom() 
	{
		log.info("Insert Video  verifyInsertVideoInChatRoom() Test Started"); 
		softAssert = new SoftAssert(); 
		String viedoUrl = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "VideoUrl");
		String seleniumRoom = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AutomationSeleniumRoom");

		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);		//verify Thread followers Users
		rtePage.verifyVideoInserted(driver, viedoUrl, softAssert);	//verify video insert in chat message
		softAssert.assertAll();
		ReportListener.logToReport("Verified Insert Video In Chat Room");
		log.info("Insert Video  verifyInsertVideoInChatRoom() Test Completed"); 
	}

//	@Test(groups = { "smoke" }, singleThreaded=true)
	public void verifyPrivateChatMessage() 
	{
		log.info("Private Chat Message verifyPrivateChatMessage() Test Started"); 
		softAssert = new SoftAssert(); 
		String privateMessage = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "PrivateMessage");
		String chatEmail = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "UserEmailForChat");
		String seleniumRoom = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AutomationSeleniumRoom");

		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);		//verify Thread followers Users
		rtePage.verifyPrivateChat(driver, header, privateMessage, chatEmail, softAssert);		//Verify private Chat Message
		softAssert.assertAll();
		ReportListener.logToReport("Verified Private Chat Message");
		log.info("Private Chat Message verifyPrivateChatMessage() Test Completed"); 
	}

//	@Test(groups = { "smoke" }, singleThreaded=true)
	public void createSideRoomOnSideRoomBox() 
	{
		log.info("Verified create Side room createSideRoomOnSideRoomBox() Test Started"); 
		softAssert = new SoftAssert(); 
		String sideRoomName = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "SideRoomName");
		String expSideRoomMsg = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_VerificationData", "SideRoomAssertionMsg");
		String description = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "SideRoomDescription");
		List<String> sideRoomMail = fileOperations.readColumnDataFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "SideRoomMail");
		List<String> accessMailOnSideRoom = fileOperations.readColumnDataFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "SideRoomMailAccess");
		List<String> usersOnSideRoom = fileOperations.readColumnDataFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "SideRoomMailUserName");
		String seleniumRoom = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AutomationSeleniumRoom");

		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);       //Verify side room is created...
		rtePage.createAndVerifySideRoom(driver, sideRoomName, expSideRoomMsg, description, sideRoomMail, accessMailOnSideRoom,usersOnSideRoom, softAssert);
		softAssert.assertAll();
		ReportListener.logToReport("Verified created side Room");
		log.info("Verified create Side room createSideRoomOnSideRoomBox() Test Completed"); 
	}

//	@Test(groups = { "smoke" }, singleThreaded=true)
	public void createAndverifyThreadMoveToAnotherRoom() throws InterruptedException 
	{
		log.info("Thread Move To Antother Room verifyThreadMoveToAnotherRoom() Test Started"); 
		softAssert = new SoftAssert(); 
		String titleName = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "ThreadTitle");
		String threadNames = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "ThreadName");
		String sideRoomName = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "SideRoomName");
		String expSideRoomMsg = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_VerificationData", "SideRoomAssertionMsg");
		String seleniumRoom = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AutomationSeleniumRoom");

		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);			//Verify thread Move on another side room
		rtePage.verifyMoveThreadToAnotherRoom(driver, threadNames, titleName, sideRoomName, expSideRoomMsg, seleniumRoom,softAssert);
		softAssert.assertAll();
		ReportListener.logToReport("Verified Thread Move To Another Side Room");
		log.info("Thread Move To Antother Room verifyThreadMoveToAnotherRoom() Test Completed"); 
	}

//	@Test(groups = { "smoke" }, singleThreaded=true)
	public void verifyThreadFollowers() 
	{
		log.info("Verified Thread Side Followers verifyThreadFollowers() Test Started"); 
		softAssert = new SoftAssert(); 
		String titleName = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "ThreadTitle");
		String threadNames = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "ThreadName");
		String followMailToUserOne = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AddFollowerMailToUserOne");
		String followMailToUserTwo = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AddFollowerMailToUserTwo");
		String expFollowerAssertionMsg = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_VerificationData", "AddFollowersAssertionMsg");
		String seleniumRoom = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AutomationSeleniumRoom");

		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);		//verify Thread followers Users
		rtePage.verifyThreadFollowers(driver, threadNames, titleName, followMailToUserOne, followMailToUserTwo, expFollowerAssertionMsg,seleniumRoom,softAssert);
		softAssert.assertAll();
		ReportListener.logToReport("Verified Thread Followers");
		log.info("Verified Thread Side Followers verifyThreadFollowers() Test Completed"); 
	}

//	@Test(groups = { "smoke" }, singleThreaded=true)
	public void verifyBoardCastMessage() throws InterruptedException 
	{
		log.info("Create BoardCast Message verifyBoardCastMessage() Test Started" ); 
		softAssert = new SoftAssert(); 
		String boardCastMessage = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "BoardCastMessage");
		String sideRoomName = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "SideRoomName");
		String expSideRoomMsg = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_VerificationData", "SideRoomAssertionMsg");
		String seleniumRoom = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AutomationSeleniumRoom");

		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);			//Verify BoardCase Message 
		rtePage.verifyBoardcastMsg(driver, sideRoomName, boardCastMessage, expSideRoomMsg, softAssert);
		softAssert.assertAll();
		ReportListener.logToReport("Verified Boardcast Message in multiple siderooms");
		log.info("Create BoardCast Message verifyBoardCastMessage() Test Completed" ); 
	}

//	@Test(groups = { "smoke" }, singleThreaded=true)
	public void verifyFavouriteMsgPosting() throws InterruptedException 
	{
		log.info("verify favourite message posting test started" ); 
		softAssert = new SoftAssert(); 
		String favouriteMsg = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "FavouriteMessagePosting");
		String seleniumRoom = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AutomationSeleniumRoom");
		int rndNumber = rtePage.generateRandomNumber();
		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);	//Verify BoardCase Message
		int beforeFovouriteSize = rtePage.getFavouriteMsg(driver);
		rtePage.clickStarIcon(driver);
		rtePage.enterMessageInChatBox(driver, favouriteMsg+rndNumber);
		rtePage.clickOnSendButton(driver);
		int afterFovouriteSize = rtePage.getFavouriteMsg(driver);
		softAssert.assertEquals(beforeFovouriteSize+1, afterFovouriteSize);
		softAssert.assertAll();
		ReportListener.logToReport("Verified ");
		log.info("verify favourite message posting test completed" ); 
	}

//	@Test(groups = { "smoke" }, singleThreaded=true)
	public void verifyFileUploadOnChatBox() throws InterruptedException 
	{
		log.info("verify file upload on chat Box test started" ); 
		softAssert = new SoftAssert(); 
		String seleniumRoom = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AutomationSeleniumRoom");

		String fileName = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "FileName");
		String path = imageFilePath +"images"+File.separator ;

		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);	//Verify BoardCase Message
		rtePage.clickPlusIconOnChatBox(driver);
		rtePage.clickFileUploadLink(driver);
		rtePage.enterFileUploadLink(driver, path, fileName);
		rtePage.clickOnSendButton(driver);
		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);
		rtePage.clickLastSendMsg(driver);
		rtePage.switchWindows(driver, 1);
		softAssert.assertTrue(driver.getCurrentUrl().contains(fileName));
		driver.close();
		rtePage.switchWindows(driver, 0);
		rtePage.clickPlusIconOnChatBox(driver);
		softAssert.assertAll();
		ReportListener.logToReport("verify file upload on chat Box");
		log.info("verify file upload on chat Box test completed" ); 
	}

//	@Test(groups = { "smoke" }, singleThreaded=true)
	public void imageInsertOnChatBox() throws InterruptedException 
	{
		log.info("verify Image upload on chat Box test started" ); 
		softAssert = new SoftAssert(); 
		String seleniumRoom = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "AutomationSeleniumRoom");

		String fileName = fileOperations.readSingleValueFromExcel(testDataFile, "SmokeTestData.xlsx","RTE_ValidTestData", "FileName");
		String path = imageFilePath +"images"+File.separator ;

		rtePage.clickCreatedSideFromListOnSideRoomCard(driver, seleniumRoom);	//Verify BoardCase Message

		rtePage.clickImageUploadLink(driver);
		rtePage.enterFileUploadLink(driver, path, fileName);
		rtePage.clickOnSendButton(driver);
		//		rtePage.clickPlusIconOnChatBox(driver);
		softAssert.assertTrue(rtePage.isImageFileInsert(driver));
		softAssert.assertAll();
		ReportListener.logToReport("verify Image upload on chat Box");
		log.info("verify Image upload on chat Box test completed" ); 
	}


	@AfterClass (alwaysRun = true)
	public void tearDown() 
	{
		this.driver.quit();
		this.driver = null;
	}
}
