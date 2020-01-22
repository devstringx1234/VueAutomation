package pages.cockpit;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import pages.BasePage;

public class CreateAndManagePage extends BasePage {

//	All Create Locators
	By cockpitTab=By.xpath("//div[@class='v-slide-group__wrapper']//a");
	By menuLink=By.cssSelector("div.v-avatar>i.mdi-lead-pencil");
	By createAndManageTitle=By.xpath("div[contains(@class,'column-header-label')][text()='Create and Manage']");
	By filterTextBox=By.xpath("//input[contains(@placeholder,'Items')]");
	By formLabel=By.xpath("//div[contains(text(),'Automation Main Form')]");
	By workflowLabel=By.xpath("//div[contains(text(),'Automation Main Workflow')]");
	By taskTypeLabel=By.xpath("//div[contains(text(),'Automation Main TaskType')]");
	By formModalWindowTitle=By.xpath("//div[@class='v-toolbar__title pb-2']");
	By form3DotLink=By.xpath("//div[contains(text(),'Automation Main Form')]/following-sibling::div//i");
	By editForm=By.xpath("//a[contains(text(),'Edit Form')]");
	By formManageEntries=By.xpath("//a[contains(text(),'Manage Entries')]");
	By formManageButton=By.xpath("//div[contains(text(),'Forms')]/a/span");
	By workflowManageButton=By.xpath("//div[contains(text(),'Workflows')]/a/span");
	By taskTypeManageButton=By.xpath("//div[contains(text(),'Task Types')]/a/span");
	By formManageFilterTextBox=By.xpath("//input[@placeholder='Filter Forms...']");
	By workflowManageFilterTextBox=By.xpath("//input[@placeholder='Filter Workflows...']");
	By taskTypeManageFilterTextBox=By.xpath("//input[@placeholder='Filter Task Types...']");
	By formManageRowLink=By.xpath("//div[@row-index='1']/div[@col-id='name']");
	By workflowManageRowLink=By.xpath("//div[@row-index='1']/div[@col-id='name']");
	By taskTypeManageRowLink=By.xpath("//div[@col-id='name']/a");
	By formExpendCollapse=By.xpath("//div[contains(text(),'Forms')]");
	By workflowExpendCollapse=By.xpath("//div[contains(text(),'Workflows')]");
	By taskTypeExpendCollapse=By.xpath("//div[contains(text(),'Task Types')]");
	By formPopupHeader=By.xpath("//div[@class='v-toolbar__title pb-2'][contains(text(),'Automation')]");
	By formCloseButton=By.xpath("//div[contains(text(),'Automation Main Form')]/../button[@title='Close']");
	
	By formActiveList=By.cssSelector(".v-menu__content.theme--light.v-menu__content--fixed.menuable__content__active.v-autocomplete__content");
	By formMainTextBox=By.xpath("//span[contains(text(),'Main - Text')]/../../../../div[2]//input");
	By formMainTextBoxLabel=By.xpath("//span[contains(text(),'Main - Text')]");
	
	By formMainCustomEmbeddedTextBox=By.xpath("//span[contains(text(),'Main - Custom/Embedded Content')]/../../../../div[2]/div/div/div/div/div[2]/div");
	
	By formMainNumberTextBox=By.xpath("//span[contains(text(),'Main - Number')]/../../../../div[2]//input");
	
	By formMainSignatureCanvas=By.cssSelector("canvas.canvas");
	By formMainSignatureDoneButton=By.xpath("//span[contains(text(),'Main - Signature')]/../../../../div[2]//div[2]/button");
	
	By formMainDateWatchIcon=By.xpath("//span[contains(text(),'Main - Date')]/../../../../div[2]//i[contains(@class,'mdi-clock')]");
	By formMainDateTextBox=By.xpath("//span[contains(text(),'Main - Date')]/../../../../div[2]//input");
	By formMainTimeWatchIcon=By.xpath("//span[contains(text(),'Main - Time')]/../../../../div[2]//i[contains(@class,'mdi-clock')]");
	By formMainTimeTextBox=By.xpath("//span[contains(text(),'Main - Time')]/../../../../div[2]//input");
	
	By formMainDateAndTimeWatchIcon=By.xpath("//span[contains(text(),'Main - Date and Time')]/../../../../div[2]//i[contains(@class,'mdi-clock')]");
	By formMainDateAndTimeDateTextBox=By.xpath("//span[contains(text(),'Main - Date and Time')]/../../../../div[2]//input");
	By formMainDateAndTimeTimeTextBox=By.xpath("//span[contains(text(),'Main - Date and Time')]/../../../../div[2]//input[@placeholder='Set time...']");
	
	By formMainDatePairStartTextBox=By.xpath("//span[contains(text(),'Main - Date Pair Start')]/../../../../div[2]//input");
	By formMainDatePairEndTextBox=By.xpath("//span[contains(text(),'Main - Date Pair End')]/../../../../div[2]//input");
	By formMainDateTimePairStartTextBox=By.xpath("//span[contains(text(),'Main - Date/Time Pair Start')]/../../../../div[2]//input");
	By formMainDateTimePairEndTextBox=By.xpath("//span[contains(text(),'Main - Date/Time Pair End')]/../../../../div[2]//input");
	By formMainLocationTextBox=By.xpath("//span[contains(text(),'Main - Location')]/../../../../div[2]//input");
	By formMainLocationMapButton=By.xpath("//span[contains(text(),'Main - Location')]/../../../../div[2]//button");
	By formMainMapLineStartTextBox=By.xpath("(//span[contains(text(),'Main - Map Line')]/../../../../div[2]//input)[1]");
	By formMainMapLineEndTextBox=By.xpath("(//span[contains(text(),'Main - Map Line')]/../../../../div[2]//input)[2]");
	By formMainMapLineLabelTextBox=By.xpath("(//span[contains(text(),'Main - Map Line')]/../../../../div[2]//input)[3]");
	By formMainMultipleLocationFirstTextBox=By.xpath("(//span[contains(text(),'Main - Multiple Locations')]/../../../../div[2]//input)[1]");
	By formMainMapMultiLocationsMapButton=By.xpath("//span[contains(text(),'Main - Multiple Locations')]/../../../../div[2]//button[@title='Select from map']");
	By formMainAddLocationButton=By.xpath("//span[contains(text(),'Main - Multiple Locations')]/../../../../div[2]//button/span[contains(text(),'Add Location')]");
	By formMainMapLineDrawOnMapLocationButton=By.xpath("//span[contains(text(),'Main - Map Line')]/../../../../div[2]//button/span[contains(text(),'Draw on Map')]");
	By formMainMapAreaDrawOnMapLocationButton=By.xpath("//span[contains(text(),'Main - Map Area')]/../../../../div[2]//button/span[contains(text(),'Draw on Map')]");
	By formMainMapPopupDoneButton=By.xpath("//div[contains(text(),'Select Location')]/../../../div[2]//span[contains(text(),'Done')]");
	
	By formMainMultipleLocationSecondTextBox=By.xpath("(//span[contains(text(),'Main - Multiple Locations')]/../../../../div[2]//input)[2]");
	By formMainMapAreaFirstPointTextBox=By.xpath("(//span[contains(text(),'Main - Map Area')]/../../../../div[2]//input)[1]");
	By formMainMapAreaSecondPointTextBox=By.xpath("(//span[contains(text(),'Main - Map Area')]/../../../../div[2]//input)[2]");
	By formMainMapAreaThirdPointTextBox=By.xpath("(//span[contains(text(),'Main - Map Area')]/../../../../div[2]//input)[3]");
	By formMainMapAreaLabelTextBox=By.xpath("//label[contains(text(),'Area Label')]/following-sibling::input");
	By formMainSingleSelectTextBox=By.xpath("//span[contains(text(),'Main - Single Select (Drop Down)')]/../../../../div[2]//input");
	By formMainRadioButtonOption=By.xpath("//div[@role='radiogroup']//div[@class='v-input--selection-controls__input']/div");
	By formMainMultiSelectOption=By.xpath("//input[@role='checkbox']/..");
	By formMainPersonPickerComboBox=By.xpath("//span[contains(text(),'Main - Person Picker')]/../../../../div[2]//input");
	By formMainContactPickerComboBox=By.xpath("//span[contains(text(),'Main - Contact Picker')]/../../../../div[2]//input");
	By formMainContactPickerMeButton=By.xpath("//span[contains(text(),'Main - Contact Picker')]/../../../../div[2]//button");
	
	By formMainFileAttachmentSingleTextBox=By.xpath("//span[contains(text(),'Main - File Attachment (Single)')]/../../../../div[2]//input[@class='filepond--browser']");
	By formMainSingleFileUploadCancelLink=By.xpath("//div[@class='filepond--file-status']/span[text()='tap to cancel']");
	By formMainFileAttachmentMultipleTextBox=By.xpath("//span[contains(text(),'Main - File Attachment (Multiple)')]/../../../../div[2]//input[@class='filepond--browser']");
		
	By formMainDrawingCanvas=By.cssSelector("canvas.drawing-board-canvas");
	By formMainDrawingDoneButton=By.xpath("//span[contains(text(),'Main - Drawing')]/../../../../div[2]//div/button/span[contains(text(),'Done')]");
	
	By formReferenceListLink=By.xpath("//span[contains(text(),'Main - Reference')]/../../../../../div[2]//span[contains(text(),'List')]");
	By formReferenceEntryCheckBox=By.xpath("//span[@class='ag-selection-checkbox']/span[2]");
	By formReferenceListSelectEntryButton=By.xpath("//button/span[contains(text(),'Select Entry')]");
	By formSubSection=By.cssSelector("div.field-wrapper--subform");
	By formSubTextBox=By.xpath("//span[contains(text(),'Sub - Text')]/../../../../div[2]//input");
	By formSubCustomEmbeddedTextBox=By.xpath("//span[contains(text(),'Sub - Custom/Embedded Content')]/../../../../div[2]/div/div/div/div/div[2]/div");
	By formSubNumberTextBox=By.xpath("//span[contains(text(),'Sub - Number')]/../../../../div[2]//input");
	By formSubDateWatchIcon=By.xpath("//span[contains(text(),'Sub - Date')]/../../../../div[2]//i[contains(@class,'mdi-clock')]");
	By formSubTimeWatchIcon=By.xpath("//span[contains(text(),'Sub - Time')]/../../../../div[2]//i[contains(@class,'mdi-clock')]");
	By formSubDateAndTimeWatchIcon=By.xpath("//span[contains(text(),'Sub - Date and Time')]/../../../../div[2]//i[contains(@class,'mdi-clock')]");
	
	By formSubDatePairStartWatchIcon=By.xpath("//span[contains(text(),'Sub - Date Pair Start')]/../../../../div[2]//i[contains(@class,'mdi-clock')]");
	By formSubDatePairEndWatchIcon=By.xpath("//span[contains(text(),'Sub - Date Pair End')]/../../../../div[2]//i[contains(@class,'mdi-clock')]");
	By formSubDateTimePairStartWatchIcon=By.xpath("//span[contains(text(),'Sub - Date/Time Pair Start')]/../../../../div[2]//i[contains(@class,'mdi-clock')]");
	By formSubDateTimePairEndWatchIcon=By.xpath("//span[contains(text(),'Sub - Date/Time Pair End')]/../../../../div[2]//i[contains(@class,'mdi-clock')]");
	By formSubLocationTextBox=By.xpath("//span[contains(text(),'Sub - Location')]/../../../../div[2]//input");
	By formSubSingleSelectomboBox=By.xpath("//span[contains(text(),'Sub - Single Select')]/../../../../div[2]//div/input");
	By formSubPersonPickerComboBox=By.xpath("//span[contains(text(),'Sub - Person Picker')]/../../../../div[2]//input");
	
	By formLookupListLink=By.xpath("//span[contains(text(),'Main - Form Lookup')]/../../../../../div[2]//span[contains(text(),'List')]");
	By formLookupEntryRow=By.xpath("//div[@class='ag-body-container ag-layout-normal']/div/div[@col-id='id']");
	By formLookupListSelectEntryButton=By.xpath("//button/span[contains(text(),'Select Entry')]");
	By formMainTaskEntryLinkButton=By.xpath("//span[contains(text(),'Select Task')]");
	By formMainTaskEntryLinkRow=By.xpath("//div[@class='ag-body-container ag-layout-normal']/../../../div[2]/div/div/div/div[@col-id='orgSequenceId']");
	By formMainTaskEntryLinkSelectEntryButton=By.xpath("//div[contains(@class,'v-card__actions')]/button/span[contains(text(),'Select Task')]");
	By formMainFormEntryLinkButton=By.xpath("//span[contains(text(),'Main - Form Entry Link')]/../../../../div[2]/button");
	By formMainFormEntryLinkRow=By.xpath("//div[@class='ag-body-container ag-layout-normal']/../../../div[2]/div/div/div/div[@col-id='lastModified']");
	By formMainFormEntryLinkSelectEntryButton=By.xpath("//button/span[contains(text(),'Select Entry')]");
	By formMainWorkflowEntryLinkButton=By.xpath("//span[contains(text(),'Main - Workflow Entry Link')]/../../../../div[2]/button");
	By formMainWorkflowEntryLinkRow=By.xpath("//div[@class='ag-body-container ag-layout-normal']/../../../div[2]/div/div/div/div[2]");
	By formMainWorkflowEntryLinkSelectEntryButton=By.xpath("//button/span[contains(text(),'Select Workflow Entry')]");
	By formMainRoomLinkButton=By.xpath("//span[contains(text(),'Main - Room Link')]/../../../../div[2]/button");
	By formMainRoomLinkSelectButton=By.xpath("//button/span[contains(text(),'Select')]");
	By formMainSubmitButton=By.xpath("//div[@class='editModal']/div/div[2]//button/span[contains(text(),'Submit')]");
	By formMainStayHereButton=By.xpath("//button/span[contains(text(),'Stay Here')]");
	By formMainPopupCloseButton=By.xpath("(//button[contains(@class,'v-btn--text theme--light v-size--default white--text')])");
	By formMainClosePopupOKButton=By.xpath("//button/span[contains(text(),'Ok')]");
	
	By formMainEditTextBox=By.xpath("//div[@class='fieldDiv'][@type='TEXT']");
	By formMainEditTextBoxPencilLink=By.xpath("//a[@class='edit-field-icon fa fa-pencil']");
	By formMainEditTextFieldName=By.xpath("//input[@name='field_name']");
	By formMainEditTextDoneButton=By.xpath("//span[text()='Done']");
	By formMainEditSaveButton=By.xpath("//span[text()='Save']");
	By formMainEditOKButton=By.xpath("//span[text()='OK']");
	
	By formEntryListTitle=By.xpath("//span[contains(text(),'Automation Main Form')]");
	
//	All Verify Locators================================================================================================================== 
	By formMainViewText=By.xpath("//span[contains(text(),'Main - Text')]/../../../../div[2]//div");
	By formMainViewCustomEmbeddedText=By.xpath("//span[contains(text(),'Main - Custom/Embedded Content')]/../../../../div[2]/div/div");
	By formMainViewNumber=By.xpath("//span[contains(text(),'Main - Number')]/../../../../div[2]/div");
	By formMainViewAutoNumber=By.xpath("//span[contains(text(),'Main - Auto Number')]/../../../../div[2]");
	By formMainViewDate=By.xpath("//span[contains(text(),'Main - Date')]/../../../../div[2]/div");
	By formMainViewTime=By.xpath("//span[contains(text(),'Main - Time')]/../../../../div[2]/div");
	By formMainViewDateAndTime=By.xpath("//span[contains(text(),'Main - Date and Time')]/../../../../div[2]/div");
	By formMainViewDatePairStart=By.xpath("//span[contains(text(),'Main - Date Pair Start')]/../../../../div[2]/div");
	By formMainViewDatePairEnd=By.xpath("//span[contains(text(),'Main - Date Pair End')]/../../../../div[2]/div");
	By formMainViewDateTimePairStart=By.xpath("//span[contains(text(),'Main - Date/Time Pair Start')]/../../../../div[2]/div");
	By formMainViewDateTimePairEnd=By.xpath("//span[contains(text(),'Main - Date/Time Pair End')]/../../../../div[2]/div");
	
	By formMainViewLocation=By.xpath("//span[contains(text(),'Main - Location')]/../../../../div[2]/div/div/div");
	By formMainViewMapLine=By.xpath("//span[contains(text(),'Main - Map Line')]/../../../../div[2]//div[@class='flex pb-6']");
	By formMainViewMapLineLabel=By.xpath("//span[contains(text(),'Main - Map Line')]/../../../../div[2]/div/div/div");
	By formMainViewMapAreaLabel=By.xpath("//span[contains(text(),'Main - Map Area')]/../../../../div[2]/div/div/div");
	By formMainViewSingleSelectOption=By.xpath("//span[contains(text(),'Main - Single Select (Drop Down)')]/../../../../div[2]/div");
	By formMainViewRadioButtonOption=By.xpath("//span[contains(text(),'Main - Single Select (Radio Button)')]/../../../../div[2]/div");
	By formMainViewMultiSelectOption=By.xpath("//span[contains(text(),'Main - Multi Select')]/../../../../div[2]/div");
	By formMainViewPersonPicker=By.xpath("//span[contains(text(),'Main - Person Picker')]/../../../../div[2]/div//td[2]");
	By formMainViewContactPicker=By.xpath("//span[contains(text(),'Main - Contact Picker')]/../../../../div[2]/div//td[2]");

	By formRefViewText=By.xpath("//span[contains(text(),'Ref - Text')]/../../../../div[2]/div");
	By formEntryLinkViewText=By.xpath("//span[contains(text(),'Main - Form Entry Link')]/../../../../div[3]//a/div");
	By formTaskLinkViewText=By.xpath("//span[contains(text(),'Main - Task Link')]/../../../../div[3]//td");
	By workflowEntryLinkViewText=By.xpath("//span[contains(text(),'Main - Workflow Entry Link')]/../../../../div[3]//a");
	By roomLinkViewText=By.xpath("//span[contains(text(),'Main - Room Link')]/../../../../div[3]//td/a");
	By formViewSubSection=By.xpath("//span[contains(text(),'Main - Sub Form')]/../../../../../div[2]");
	By formSubViewText=By.xpath("//span[contains(text(),'Sub - Text')]/../../../../div[2]/div");
	By formSubViewCustomEmbeddedText=By.xpath("//span[contains(text(),'Sub - Custom/Embedded Content')]/../../../../div[2]/div/div");
	By formSubViewNumber=By.xpath("//span[contains(text(),'Sub - Number')]/../../../../div[2]/div");
	
	By formViewLookupSection=By.xpath("//span[contains(text(),'Main - Form Lookup')]/../../../../../div[2]");
	By formlookupViewText=By.xpath("//span[contains(text(),'Lookup - Text')]/../../../../div[2]/div");
	
	By formViewSingleAttachedFile=By.xpath("//span[contains(text(),'Main - File Attachment (Single)')]/../../../..//div[@class='file-name']");
	By formViewMultipleAttachedFileFirst=By.xpath("(//span[contains(text(),'Main - File Attachment (Multiple)')]/../../../..//div[@class='file-name'])[1]");
	By formViewMultipleAttachedFileSecond=By.xpath("(//span[contains(text(),'Main - File Attachment (Multiple)')]/../../../..//div[@class='file-name'])[2]");
	
	
	
//	All Action Methods===================================================================================================================
	public void clickOnCockpitTab(RemoteWebDriver driver) throws InterruptedException {
		click(driver,cockpitTab);
	}
	
	public void clickCreateAndManageMenuLink(RemoteWebDriver driver) throws InterruptedException {
		click(driver,menuLink);
	}
	
	public void clickSearchedForm(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formLabel);
	}
	
	public void clickSearchedWorkflow(RemoteWebDriver driver) throws InterruptedException {
		click(driver,workflowLabel);
	}
	
	public void clickSearchedTaskType(RemoteWebDriver driver) throws InterruptedException {
		click(driver,taskTypeLabel);
	}
	
	public void clickOnForm3DotLink(RemoteWebDriver driver) throws InterruptedException {
		hardWait(2000);
		click(driver,form3DotLink);
	}
	
	public void clickOnEditFormLink(RemoteWebDriver driver) throws InterruptedException {
		hardWait(2000);
		click(driver,editForm);
		hardWait(5000);
	}
	
	public void clickOnFormManageEntriesLink(RemoteWebDriver driver) throws InterruptedException {
		hardWait(2000);
		click(driver,formManageEntries);
	}
	
	public void clickOnFormManageButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formManageButton);
	}
	
	public void clickOnWorkflowManageButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,workflowManageButton);
	}
	
	public void clickOnTaskTypeManageButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,taskTypeManageButton);
	}
	
	public void clickOnModalCloseButton(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibilityByLocator(driver,formCloseButton);
		click(driver,formCloseButton);
		waitForElementInVisibilityByLocator(driver,formCloseButton);
	}
	
	public void clickToExpandCollapseFormSection(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formExpendCollapse);
	}
	
	public void clickToExpandCollapseWorkflowSection(RemoteWebDriver driver) throws InterruptedException {
		click(driver,workflowExpendCollapse);
	}
	
	public void clickToExpandCollapseTaskTypeSection(RemoteWebDriver driver) throws InterruptedException {
		click(driver,taskTypeExpendCollapse);
	}
	
	public void ClickOnFormCustomEmbeddedTextBox(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainCustomEmbeddedTextBox);
	}
	
	public void ClickOnFormMainSignatureCanvas(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainSignatureCanvas);
	}
	
	public void ClickOnFormMainSignatureDoneButton(RemoteWebDriver driver) throws InterruptedException {
		hardWait(1000);
		click(driver,formMainSignatureDoneButton);
		//waitForElementInVisibilityByLocator(driver, formMainSignatureDoneButton);
		hardWait(1000);
	}
	
	public void clickOnFormMainDateWatchIcon(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainDateWatchIcon);
	}
	
	public void clickOnFormMainTimeWatchIcon(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainTimeWatchIcon);
	}
	
	public void clickOnFormMainTimeTextBox(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainTimeTextBox);
	}
	
	public void clickOnFormMainDateAndTimeWatchIcon(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainDateAndTimeWatchIcon);
	}
	
	public void clickOnFormPopupHeader(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formPopupHeader);
	}
	
	public void clickOnFormMainDatePairStartTextBox(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainDatePairStartTextBox);
	}
	
	public void clickOnFormMainDatePairEndTextBox(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainDatePairEndTextBox);
	}
	
	public void clickOnFormMainDateTimePairStartTextBox(RemoteWebDriver driver) throws InterruptedException {
		waitForElementClickability(driver,formMainDateTimePairStartTextBox);
		click(driver,formMainDateTimePairStartTextBox);
	}
	
	public void clickOnFormMainDateTimePairEndTextBox(RemoteWebDriver driver) throws InterruptedException {
		waitForElementClickability(driver,formMainDateTimePairEndTextBox);
		click(driver,formMainDateTimePairEndTextBox);
	}
	
	public void clickOnFormMainAddLocationButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainAddLocationButton);
	}
	
	public void clickOnMapLocationMapButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainLocationMapButton);
	}
	
	public void clickOnMapMultiLocationsMapButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainMapMultiLocationsMapButton);
	}
	
	public void clickOnMapLineDrawOnMapButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainMapLineDrawOnMapLocationButton);
	}
	
	public void clickOnMapAreaDrawOnMapButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainMapAreaDrawOnMapLocationButton);
	}
	
	public void clickOnMapPopupDoneButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainMapPopupDoneButton);
	}
	
	public void clickOnFormMainRadioButtonOption(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibilityByLocator(driver, formMainRadioButtonOption);
		hardWait(1000);
		click(driver,formMainRadioButtonOption);
	}
	
	public void clickOnFormMainMultiSelectOption(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibilityByLocator(driver, formMainMultiSelectOption);
		hardWait(1000);
		click(driver,formMainMultiSelectOption);
	}
	
	public void clickOnFormMainContactPickerMeButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainContactPickerMeButton);
	}
	
	public void ClickOnFormMainDrawingCanvas(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainDrawingCanvas);
	}
	
	public void ClickOnFormMainDrawingDoneButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainDrawingDoneButton);
		waitForElementInVisibilityByLocator(driver, formMainDrawingDoneButton);
	}
	
	public void clickOnFormReferenceListLink(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formReferenceListLink);
	}
	
	public void clickOnFormReferenceEntryCheckBox(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formReferenceEntryCheckBox);
	}
	
	public void clickOnFormReferenceSelectEntryButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formReferenceListSelectEntryButton);
	}
	
	public void ClickOnFormSubCustomEmbeddedTextBox(RemoteWebDriver driver) throws InterruptedException {
     	click(driver,formSubCustomEmbeddedTextBox);
	}
	
	public void clickOnFormSubDateWatchIcon(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formSubDateWatchIcon);
	}
	
	public void clickOnFormSubTimeWatchIcon(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formSubTimeWatchIcon);
	}
	
	public void clickOnFormSubDateAndTimeWatchIcon(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formSubDateAndTimeWatchIcon);
	}
	
	public void clickOnFormSubDatePairStartWatchIcon(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formSubDatePairStartWatchIcon);
	}
	
	public void clickOnFormSubDatePairEndWatchIcon(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formSubDatePairEndWatchIcon);
	}
	
	public void clickOnFormSubDateTimePairStartWatchIcon(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formSubDateTimePairStartWatchIcon);
	}
	
	public void clickOnFormSubDateTimePairEndWatchIcon(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formSubDateTimePairEndWatchIcon);
	}
	
	public void clickOnFormLookupListLink(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibilityByLocator(driver,formLookupListLink);
		click(driver,formLookupListLink);
	}
	
	public void clickOnFormLookupEntryRow(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formLookupEntryRow);
	}
	
	public void clickOnFormLookupSelectEntryButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formLookupListSelectEntryButton);
	}
	
	public void clickOnMainFormTaskEntryLink(RemoteWebDriver driver) throws InterruptedException {
		movetoTaskLink(driver);
		click(driver,formMainTaskEntryLinkButton);
	}
	
	public void clickOnMainFormTaskEntryLinkRow(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainTaskEntryLinkRow);
	}
	
	public void clickOnMainFormTaskEntryLinkSelectEntryButton(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibilityByLocator(driver,formMainTaskEntryLinkSelectEntryButton);
		click(driver,formMainTaskEntryLinkSelectEntryButton);
	}
	
	public void clickOnMainFormEntryLink(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainFormEntryLinkButton);
	}
	
	public void clickOnMainFormEntryLinkRow(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibilityByLocator(driver,formMainFormEntryLinkRow);
		click(driver,formMainFormEntryLinkRow);
	}
	
	public void clickOnMainFormEntryLinkSelectEntryButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainFormEntryLinkSelectEntryButton);
	}
	
	public void clickOnMainFormWorkflowEntryLink(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainWorkflowEntryLinkButton);
	}
	
	public void clickOnMainFormWorkflowEntryLinkRow(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainWorkflowEntryLinkRow);
	}
	
	public void clickOnMainFormWorkflowEntryLinkSelectEntryButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainWorkflowEntryLinkSelectEntryButton);
	}
	
	public void clickOnMainFormRoomLink(RemoteWebDriver driver) throws InterruptedException {
		click(driver,formMainRoomLinkButton);
	}
	
	public void clickOnMainFormRoomLinkSelectButton(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibilityByLocator(driver,formMainRoomLinkSelectButton);
		click(driver,formMainRoomLinkSelectButton);
	}
	
	public void clickOnMainFormSubmitButton(RemoteWebDriver driver) throws InterruptedException {
		//waitForElementVisibilityByLocator(driver,formMainSubmitButton);
		hardWait(5000);
		click(driver,formMainSubmitButton);
	}
	
	public void clickOnMainFormStayHereButton(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibilityByLocator(driver,formMainStayHereButton);
		click(driver,formMainStayHereButton);
	}
	
	public void clickOnMainPopupCloseButton(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibilityByLocator(driver,formMainPopupCloseButton);
		click(driver,formMainPopupCloseButton);
	}
	
	public void clickOnMainClosePopupOKButton(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibilityByLocator(driver,formMainClosePopupOKButton);
		click(driver,formMainClosePopupOKButton);
	}
	
	public void clickOnMainFormTextBoxPencilLink(RemoteWebDriver driver) throws InterruptedException {
		waitForElementVisibilityByLocator(driver,formMainEditTextBoxPencilLink);
		click(driver, formMainEditTextBoxPencilLink);
	}
	
	public void clickOnMainFormTextDoneButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver, formMainEditTextDoneButton);
	}
	
	public void clickOnMainFormEditSaveButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver, formMainEditSaveButton);
	}
	
	public void clickOnMainFormEditOKButton(RemoteWebDriver driver) throws InterruptedException {
		click(driver, formMainEditOKButton);
	}
	
	public void clickAttachedSingleFile(RemoteWebDriver driver) throws InterruptedException {
		click(driver, formViewSingleAttachedFile);
		hardWait(3000);
	}
	
	public void clickAttachedMultipleFileFirst(RemoteWebDriver driver) throws InterruptedException {
		click(driver, formViewMultipleAttachedFileFirst);
	}
	
	public void clickAttachedMultipleFileSecond(RemoteWebDriver driver) throws InterruptedException {
		hardWait(3000);
		click(driver, formViewMultipleAttachedFileSecond);
		hardWait(3000);
	}
	
//	Mouse Hover Methods==================================================================================================================
	public void moveMouseCursorAnyWhere(RemoteWebDriver driver) {
		mouseHover(driver,cockpitTab);
	}
	
	public void moveMouseCursorOnSearchedForm(RemoteWebDriver driver) {
		mouseHover(driver,formLabel);
	}
	
	public void moveMouseCursorOnMainTextBox(RemoteWebDriver driver) {
		waitForElementVisibilityByLocator(driver,formMainEditTextBox);
		mouseHover(driver,formMainEditTextBox);
	}
	
	public void movetoFormSubSection(RemoteWebDriver driver) throws InterruptedException {
     	mouseHover(driver,formSubSection);
	}
	
	public void movetoFormViewSubSection(RemoteWebDriver driver) throws InterruptedException {
     	mouseHover(driver,formViewSubSection);
	}
	
	public void movetoFormViewLookupSection(RemoteWebDriver driver) throws InterruptedException {
     	mouseHover(driver,formViewLookupSection);
	}
	
	public void movetoTaskLink(RemoteWebDriver driver) throws InterruptedException {
     	mouseHover(driver,formMainTaskEntryLinkButton);
	}
	
//	All Enter Methods=====================================================================================================================	
	public void enterTextInFilterBox(RemoteWebDriver driver,String value) {
		enterData(driver,filterTextBox,value);
	}
	
	public void enterTextInformManageFilterTextBox(RemoteWebDriver driver,String value) {
		enterData(driver,formManageFilterTextBox,value);
	}
	
	public void enterTextInWorkflowManageFilterTextBox(RemoteWebDriver driver,String value) {
		enterData(driver,workflowManageFilterTextBox,value);
	}
	
	public void enterTextInTaskTypeManageFilterTextBox(RemoteWebDriver driver,String value) {
		enterData(driver,taskTypeManageFilterTextBox,value);
	}
	
	public void enterTextInFormMainTextBox(RemoteWebDriver driver, String value) {
		enterData(driver,formMainTextBox, value);
	}
		
	public void enterTextInFormCustomEmbeddedTextBox(RemoteWebDriver driver, String value) {
		enterData(driver,formMainCustomEmbeddedTextBox,value);
	}
	
	public void enterNumberInFormMainNumberTextBox(RemoteWebDriver driver, String value) {
		enterData(driver,formMainNumberTextBox, value);
	}
	
	public void enterTextInMainMapLineLabelTextBox(RemoteWebDriver driver, String value) throws InterruptedException {
		waitForElementVisibilityByLocator(driver,formMainMapLineLabelTextBox);
		enterData(driver,formMainMapLineLabelTextBox, value);
	}
	
	public void enterTextInMainMapAreaLabelTextBox(RemoteWebDriver driver, String value) throws InterruptedException {
		waitForElementVisibilityByLocator(driver,formMainMapAreaLabelTextBox);
		enterData(driver,formMainMapAreaLabelTextBox, value);
	}
	
	public void enterImageURLInFileAttachementSingleTextBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterFileNameForAttachment(driver,formMainFileAttachmentSingleTextBox, value);
		waitForElementInVisibilityByLocator(driver,formMainSingleFileUploadCancelLink);
	}
	
	public void enterImageURLInFileAttachementFirstMultipleTextBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterFileNameForAttachment(driver,formMainFileAttachmentMultipleTextBox, value);
		waitForElementInVisibilityByLocator(driver,formMainSingleFileUploadCancelLink);
		
	}
	
	public void enterImageURLInFileAttachementSecondMultipleTextBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterFileNameForAttachment(driver,formMainFileAttachmentMultipleTextBox, value);
		waitForElementInVisibilityByLocator(driver,formMainSingleFileUploadCancelLink);
	}
	
	public void enterTextInFormSubTextBox(RemoteWebDriver driver, String value) {
		enterData(driver,formSubTextBox, value);
	}
		
	public void enterTextInFormSubCustomEmbeddedTextBox(RemoteWebDriver driver, String value) {
		waitForElementVisibilityByLocator(driver,formSubCustomEmbeddedTextBox);
		mouseHover(driver,formSubTextBox);
		enterData(driver,formSubCustomEmbeddedTextBox,value);
	}
	
	public void enterNumberInFormSubNumberTextBox(RemoteWebDriver driver, String value) {
		mouseHover(driver,formSubTextBox);
		enterData(driver,formSubNumberTextBox, value);
	}
	
	public void enterNameInMainFormTextFieldName(RemoteWebDriver driver, String value) {
		enterData(driver, formMainEditTextFieldName, value);
	}
	
	public void enterImageNameForAttachment(RemoteWebDriver driver, By locator, String imageName) throws InterruptedException {
		driver.findElement(locator).sendKeys(System.getProperty("user.dir")+"\\testdata\\images\\"+imageName+"");
	}
	
	public void enterFileNameForAttachment(RemoteWebDriver driver, By locator, String fileName) throws InterruptedException {
		driver.findElement(locator).sendKeys(System.getProperty("user.dir")+"\\testdata\\files\\"+fileName+"");
	}
	
//	All Select Methods====================================================================================================================
	public void selectLocationInMainLocationComboBox(RemoteWebDriver driver, String value, String locationToSelect) throws InterruptedException {
		enterData(driver,formMainLocationTextBox, value);
		selectLocation(driver, locationToSelect);
	}
	
	public void selectLocationInMainMapLineStartComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formMainMapLineStartTextBox, value);
	}
	
	public void selectLocationInMainMapLineEndComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formMainMapLineEndTextBox, value);
	}
	
	public void selectLocationInMainMultipleLocationFirstComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formMainMultipleLocationFirstTextBox, value);
	}
	
	public void selectLocationInMainMultipleLocationSecondComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formMainMultipleLocationSecondTextBox, value);
	}
	
	public void selectLocationInMainMapAreaFirstPointComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formMainMapAreaFirstPointTextBox, value);
	}
	
	public void selectLocationInMainMapAreaSecondPointComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formMainMapAreaSecondPointTextBox, value);
	}
	
	public void selectLocationInMainMapAreaThirdPointComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formMainMapAreaThirdPointTextBox, value);
	}
	
	public void selectValueFromMainSingleSelectComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formMainSingleSelectTextBox, value);
		selectValueFromComboBox(driver, formActiveList, value);
	}
	
	public void selectValueFromMainPersonPickerComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formMainPersonPickerComboBox, value);
		//waitForElementVisibilityByLocator(driver, formActiveList);
		hardWait(2000);
		selectValueFromPersonComboBox(driver, formActiveList, value);
	}
	
	public void selectValueFromMainContactPickerComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formMainContactPickerComboBox, value);
		//waitForElementVisibilityByLocator(driver, formActiveList);
		hardWait(2000);
		selectValueFromPersonComboBox(driver, formActiveList, value);
	}
	
	public void selectLocationInSubLocationComboBox(RemoteWebDriver driver, String value,String subMapLoctionToSelect) throws InterruptedException {
		enterData(driver,formSubLocationTextBox, value);
		selectLocation(driver, subMapLoctionToSelect);
	}
	
	public void selectValueFromSubSingleSelectComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formSubSingleSelectomboBox, value);
		selectValueFromComboBox(driver, formActiveList, value);
	}
	
	public void selectValueFromSubPersonPickerComboBox(RemoteWebDriver driver, String value) throws InterruptedException {
		enterData(driver,formSubPersonPickerComboBox, value);
		waitForElementVisibilityByLocator(driver, formActiveList);
		hardWait(2000);
		selectValueFromPersonComboBox(driver, formActiveList, value);
	}
	
	public void selectDateInDatePicker(RemoteWebDriver driver, String value) throws InterruptedException {
		selectDate(driver, value);
	}
	
	public void selectTimeInTimePicker(RemoteWebDriver driver, String value) throws InterruptedException {
		selectTime(driver, value);
	}
	
//	All Get Methods=======================================================================================================================	
	public String getCreateAndManageTitle(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, createAndManageTitle);
	}
	
	public String getformNameFromMenu(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formLabel);
	}
	
	public String getMainFormTextBoxLabel(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainTextBoxLabel);
	}
	
	public String getCreateAndManageFormTitle(RemoteWebDriver driver) throws InterruptedException {
		//waitForElementVisibilityByLocator(driver, formBreadcrumbTitle);
		hardWait(3000);
		return getText(driver, formEntryListTitle);
	}
	
	public String getFormManageRowLinkTitle(RemoteWebDriver driver) throws InterruptedException {
		hardWait(2000);
		waitForElementVisibilityByLocator(driver, formManageRowLink);
		return getText(driver, formManageRowLink);
	}
	
	public String getWorkflowManageRowLinkTitle(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, taskTypeManageRowLink);
	}
	
	public String getTaskTypeManageRowLinkTitle(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, workflowManageRowLink);
	}
	
	public String getModalWindowTitle(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formModalWindowTitle);
	}
	
	public String getFilledMainViewText(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewText);
	}
	
	public String getFilledMainCustomEmbeddedText(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewCustomEmbeddedText);
	}
	
	public String getFilledMainNumber(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewNumber);
	}
	
	public String getFilledDate(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewDate);
	}
	
	public String getFilledTimeBeforeSubmitEntry(RemoteWebDriver driver) throws InterruptedException {
		hardWait(3000);
		return getText(driver, formMainTimeTextBox);		
	}
	
	public String getFilledTime(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewTime);
	}
	
	public String getFilledDateAndTime(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewDateAndTime);
	}
	
	public String getFilledDatePairStart(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewDatePairStart);
	}
	
	public String getFilledDatePairEnd(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewDatePairEnd);
	}
	
	public String getFilledDateTimePairStart(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewDateTimePairStart);
	}
	
	public String getFilledDateTimePairEnd(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewDateTimePairEnd);
	}
	
	public String getFilledMainMapLocation(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewLocation);
	}
	
	public String getFilledMainMapLineCordinates(RemoteWebDriver driver) throws InterruptedException {
		//return getText(driver, formMainViewMapLine);
		return getValueFromAttribute(driver,formMainViewMapLine,"innerText");
	}
	
	public String getFilledMainMapLineLabel(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewMapLineLabel);
	}
	
	public String getFilledMainMapAreaLabel(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewMapAreaLabel);
	}
	
	public String getFilledMainSingleSelectOption(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewSingleSelectOption);
	}
	
	public String getFilledMainRadioButtonOption(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewRadioButtonOption);
	}
	
	public String getFilledMainMultiSelectOption(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewMultiSelectOption);
	}
	
	public String getFilledMainPersonPicker(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewPersonPicker);
	}
	
	public String getFilledMainContactPicker(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formMainViewContactPicker);
	}
	
	public String getAttachedSingleFileName(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formViewSingleAttachedFile);
	}
	
	public String getAttachedMultipleFileFirstName(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formViewMultipleAttachedFileFirst);
	}
	
	public String getAttachedMultipleFileSecondName(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formViewMultipleAttachedFileSecond);
	}
	
	public String getFilledRefText(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formRefViewText);
	}
	
	public String getFilledFormEntryLinkText(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formEntryLinkViewText);
	}
	
	public String getFilledTaskEntryLinkText(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, formTaskLinkViewText);
	}
	
	public String getFilledWorkflowEntryLinkText(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, workflowEntryLinkViewText);
	}
	
	public String getFilledRoomLinkText(RemoteWebDriver driver) throws InterruptedException {
		return getText(driver, roomLinkViewText);
	}
	
	public String getFilledSubText(RemoteWebDriver driver) throws InterruptedException {
		movetoFormViewSubSection(driver);
		return getText(driver, formSubViewText);
	}
	
	public String getFilledSubCustomEmbeddedText(RemoteWebDriver driver) throws InterruptedException {
		movetoFormViewSubSection(driver);
		return getText(driver, formSubViewCustomEmbeddedText);
	}
	
	public String getFilledSubNumber(RemoteWebDriver driver) throws InterruptedException {
		movetoFormViewSubSection(driver);
		return getText(driver, formSubViewNumber);
	}
	
	public String getFilledLookupText(RemoteWebDriver driver) throws InterruptedException {
		movetoFormViewLookupSection(driver);
		return getText(driver, formlookupViewText);
	}
	
	public ArrayList<String> getMapCordinates(RemoteWebDriver driver){
		ArrayList<String> dataPoints = new ArrayList<String>();
		List<WebElement> pointElems =  driver.findElements(By.xpath("//div[@role='list']/div[@role='listitem']/div/div/div[2]"));
		
		for (WebElement elem: pointElems) {
			dataPoints.add(elem.getText().trim());
			}
		return dataPoints;
	}
	
	public int getAutoNumber(RemoteWebDriver driver) throws InterruptedException {
		String autoNumberText = getText(driver, formMainViewAutoNumber);
		int autoNumber = Integer.parseInt(autoNumberText);
		return autoNumber;
	}
	
//	Boolean Methods=======================================================================================================================
	public boolean isLabelMatch(RemoteWebDriver driver, String label) throws InterruptedException {
		return isElementPresent(driver, formMainTextBoxLabel);
	}
	
	public void switchToFormFrame(RemoteWebDriver driver) throws InterruptedException {
		switchToFrameByIndex(driver,0);
	}
	
	public void formScrolldown(RemoteWebDriver driver) throws InterruptedException {
		hardWait(2000);
		scrollDownByLocator(driver, formMainMapPopupDoneButton);
	}
}
