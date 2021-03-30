

package project.pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import project.utilities.DBQueries;
import project.utilities.DBUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;

public class RAReviewWorkQueuePage extends PageObject {

	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RAReviewWorkQueuePage.class);

	HomePage oCPTICDLINKHomePage;
	SeleniumUtils oSeleniumUtils;
	DBQueries oDBQueries;
	AdminPage oAdminPage;
	
	public String RA_RequestLCDArticleReview_Btn = "//a[@ng-click='onRequestLcdorArtilceForReview()']";

	public String SelectLCDArticle = "//div[@id='dropdownlistWrapperrequestReview']";
	
	public String LCDArticleID_Txt = "//input[@ng-model='rowEntity.lcdId']";
	
	@FindBy(xpath = "//a[@ng-click='gotoWorkQueue();']")
	public WebElementFacade RA_Review_WorkQueue;

	@FindBy(xpath = "//li[text()='Review Status :']/following-sibling::li[1]/b")
	public WebElementFacade ReviewStatus_Txt;

	@FindBy(id = "startReview")
	public WebElementFacade StartReview_Btn;

	@FindBy(id = "dropdownlistWrapperselectedReason")
	public WebElementFacade SelectReasonCmb;

	@FindBy(id = "dropdownlistArrowcategory-drop-down")
	public WebElementFacade SelectCategoryCmb;

	@FindBy(id = "dropdownlistArrowselectedReason")
	public WebElementFacade SelectReasonArrowIcon;

	@FindBy(id = "rejectReasonTextArea")
	public WebElementFacade RejectReasonTextArea;

	@FindBy(id = "reasonForUpdateTextArea")
	public WebElementFacade ReasonUpdateTextArea;

	@FindBy(xpath = "//button[@id='applyFilter']")
	public WebElementFacade ApplyFilter_Btn;

	@FindBy(xpath = "//button[@id='clearFilter']")
	public WebElementFacade ClearAllFilters_Btn;

	@FindBy(xpath = "//button[@id='setAppropriate']")
	public WebElementFacade Accept_Btn;

	@FindBy(xpath = "//button[@id='setInAppropriate']")
	public WebElementFacade Reject_Btn;

	@FindBy(xpath = "//button[@id='updateDecision']")
	public WebElementFacade Update_Decision_Btn;

	@FindBy(xpath = "//button[@id='completeRAReview']")
	public WebElementFacade CompleteRAReview_Btn;

	@FindBy(xpath = "//button[@id='requestCodeCombination']")
	public WebElementFacade RequestCodeCombinationReview_Btn;

	@FindBy(xpath = "//input[@ng-model='grid.appScope.remarksFilter']")
	public WebElementFacade RemarksFilter_TextBox;

	@FindBy(xpath = "//div[@class='ui-grid-pager-count-container']//span")
	public WebElementFacade Page_Items_Count;

	@FindBy(xpath = "//input[@ng-model='grid.appScope.needBlank']")
	public WebElementFacade Dispay_Blanks_CheckBox;

	public String Matching_FIltered_Count = "//div[@class='ui-grid-pager-count']";

	public String sCheckBox = "(//div[@class='ui-grid-canvas'])[1]/div[iRowCount]//div[contains(@class,'ui-grid-selection')]";

	public String DOS_Focus = "//DIV[@id='deletecombination']/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role='grid'][1]/DIV[@role='rowgroup'][2]/DIV[1]/DIV[arg]/DIV[@role='row'][1]/DIV[@role='gridcell'][5]/DIV[1]";

	//public String DOS_Input = "//DIV[arg]/DIV[@role='row'][1]/DIV[@role='gridcell'][5]/DIV[2]/FORM[1]/INPUT[1]";
	
	 public String DOS_Input = "//DIV[@id='deletecombination']//DIV[arg]/DIV[@role='row'][1]/DIV[@role='gridcell'][5]/DIV[2]/FORM[1]/INPUT[1]";
	
	//public String DOS_Input ="	//DIV[@id='deletecombination']/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/DIV[@role='grid'][1]/DIV[@role='rowgroup'][2]/DIV[1]/DIV[arg]/DIV[@role='row'][1]/DIV[@role='gridcell'][5]/DIV[1]/FORM[1]/INPUT[1]";

	public String Apply = "//a[@ng-click='onReasonApplyClick()']";

	public String sRemarksSortIcon = "//span[text()='Remarks']/following-sibling::span";

	public String sRemarksColumnDiv = "//span[text()='Remarks']/..";

	public String AcceptButton = "//button[@id='setAppropriate']";

	public String RejectButton = "//button[@id='setInAppropriate']";

	public String DOS_DelComb = "((//div[@class='ui-grid-canvas'])[4]/div/div[@role='row']/div[5]/div)";

	@FindBy(xpath = "//div[@class='ui-grid-pager-count']")
	public WebElementFacade pageItemsCount;

	public String AcceptDecision = "//div[@class='ui-grid-row ng-scope']//div[@class='ng-isolate-scope']/div[5]/div";

	@FindBy(xpath = "//div[@class='ui-grid-row ng-scope']//div[@class='ng-isolate-scope']/div[5]/div")
	public WebElementFacade ReviewDecision;

	@FindBy(xpath = "//div[@id='dropdownlistArrowhcpccode-group-drop-down']")
	public WebElementFacade CPTHCPCSCodeGroupDropDown;

	@FindBy(xpath = "//div[@id='dropdownlistArrowappropriate_10-drop-down']")
	public WebElementFacade ReviewDecisionDropDown;

	@FindBy(xpath = "//button[@ng-click='onAddManuallyCreatedCombinationClicked()']")
	public WebElementFacade RAReviewManually_Created_Combination_Btn;

	public String ReviewDecisionDrpdownValues = "//span[contains(text(),'ReviewDecisionVal')]";

	public String CPTHCPCSCodeGroupDropDownVals = "//div[@id='listBoxContentinnerListBoxhcpccode-group-drop-down']//div[1]//div";

	public String Checkbox = "//div[@class='ui-grid-viewport ng-isolate-scope']/div/div[1]//div[@class='ui-grid-cell-contents']/div";

	public String sGridCheckBox = "//div[@class='ui-grid-header-cell-wrapper']/div/div[1]//div[@class='ui-grid-cell-contents']/div";

	public String RAReviewCPT_HCPCS_Cell_Value = "((//div[contains(@id,'target')]/div[@class='ui-grid-contents-wrapper']//div[@class='ui-grid-viewport ng-isolate-scope'])[2]/div/div/div[1]/div[1]/div)[1]";

	public String RAReviewICD_Code_Cell_Value = "((//div[contains(@id,'target')]/div[@class='ui-grid-contents-wrapper']//div[@class='ui-grid-viewport ng-isolate-scope'])[2]/div/div/div[1]/div[4]/div)[1]";

	public String Week_Task_Sorting = "(//div[@class='ui-grid-canvas'])[2]/div";

	public String sBaseICDCodeTxt = "//label[contains(text(),'Base ICD Code')]/following-sibling::div/input";

	public String sICDGroupTxt = "//label[contains(text(),'ICD Group')]/following-sibling::div/input";

	public String sCategoryDropDown = "//label[contains(text(),'Category')]/following-sibling::div/select";

	public String sCategoryDropDownmanuallyMntn = "//label[contains(text(),'Category')]/following-sibling::div/input";

	public String sICDCodeTxt = "//label[normalize-space(text()) = 'ICD Code']/following-sibling::div/input";

	public String sAddedICDCodeTxtFields = "//label[normalize-space(text()) = 'ICD Code']/span[@class='important-field ng-hide']/parent::label/following-sibling::div/input";

	public String sAddNewICDButton = "//button[@id='Add New ICD Code']";

	public String sRAPage_DelCodeCombinationButton = "//button[@id='Delete Button']";

	public String RAPage_sAddCombination_CloseBtn = "//i[contains(@title,'close')]";

	public String RAPage_sAlertPopup = "//div[contains(@class,'modal-body')]/parent::div";

	public String RAPage_PaginatorSelect = "//select[@ng-model='grid.options.paginationPageSize']";

	public String RAPage_NextPageButton = "//button[@class='ui-grid-pager-next']";

	public String RAPage_NextPageButtonDisabled = "//button[@class='ui-grid-pager-next' and @disabled='disabled']";

	public String DATEBANDING_MESSAGE_OKBTN = "/html/body/div[9]/div/div/div/div[3]/button";

	public String RAPage_SelectReason_DrpDwn = "//div[@id='dropdownlistWrapperselectedReason']";

    public String RAPageCombinationType_Text= "//div[@role='gridcell'][7]";
    
    public String RAPage_CPTHCPCCode =  "//div[@role='gridcell'][1]";
    
    public String RAPage_CPTHCPCCodeGrp =  "//div[@role='gridcell'][2]";
    
    public String RAPage_ICDCode =  "//div[@role='gridcell'][3]";
    
  public String RAPage_Remarks =  "//div[@role='gridcell'][6]";
    
    public String  RAPage_AddCodeCombination_Popup  =  "//div[@class='modal-content']";
    
    public String  RAPage_DeleteCodeComb_BaseICDCodeVal  =  "((//div[@id='deletecombination']//div[@role='rowgroup'])[4]/div/div[1]/div/div/div)[2]";
    
    public String  RAPage_DeleteCodeComb_DOSToVal  =  "((//div[@id='deletecombination']//div[@role='rowgroup'])[4]/div/div[1]/div/div/div)[5]";
    
    public String ROWHEADER_CHECKBOX = "//div[@class ='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope']";
    
    public String RAPage_popupHeader = "//h4[contains(text(),'sValue')]";
    
	 
	// ==================== Delete Combination Tab objects =============================================

	public String strDeleteCominbTabColHeaders = "(//div[@id='deletecombination']//div[@class='ui-grid-header-cell-row'])[2]//span[text()='Manually Added Code']/parent::div/following-sibling::div//input";

	public String sManually_AssociateCode = "//input[@value='sValue']/parent::label";

	public String SaveButton = "//button[@id='Save Button']";

	public String RAPage_DeleteComb_GridChkbox_Generic = "(//div[@id='deletecombination']//div[@role='rowgroup']//..//div[@class='ui-grid-cell-contents']/div)";

	public String DeleteCombCoulmnHeader = "(//div[@id='deletecombination']//div[@role='rowgroup'])[3]//div[arg]/div[@role='columnheader']/div/span[1]";

	public String SortingType = "(//div[@id='deletecombination']//div[@role='rowgroup'])[3]//div[number]/div[@role='columnheader']/div/span[contains(@aria-label,'arg')]";

	public String DeleteCombInputArea = "//span[text()='arg']/..//following-sibling::div/div/div/input";

	public String DefaultRadioSel = "//label[@class='radio-inline']/input[@value='arg' and @checked='checked']";

	public String RAPage_DeleteComb_GridChkbox = "(//div[@id='deletecombination']//div[@role='rowgroup']//..//div[@class='ui-grid-cell-contents']/div)[1]";

	public String RAPage_DeleteCombGridChkbox_SelectionValidate = "//div[contains(@class,'sValue')]";

	public String RAPage_Input_TextArea = "//span[text()='arg']/..//following-sibling::div/div/div/input";

	public String RAPage_DeleteCombGridChkbox_Rows = "//div[@id='deletecombination']//div[@class='ui-grid-row ng-scope']";

	public String sStartReviewBtnDisabled = "//button[@id='startReview' and @disabled='disabled']";

	public String sRejectBtnDisabled = "//button[@id='setInAppropriate' and @disabled='disabled']";

	public String sAcceptBtnDisabled = "//button[@id='setAppropriate' and @disabled='disabled']";

	public String sCompleteRAReviewBtnDisabled = "//button[@id='completeRAReview' and @disabled='disabled']";

	public String sViewParagraphInfoBtn = "//button[@id='viewParagraphInfo']";

	public String sViewParagraphInfoSection = "//div[@id='paragraphinfo']";

	public String sViewParagraphInfoCloseIcon = "//div[@id='paragraphinfo']/preceding-sibling::div//i[@ng-click='hideParagraph() ']";

	public String sViewParagraphInfoSectionHidden = "//div[@class='ng-isolate-scope stretch ui-layout-container animate-column ui-layout-hidden']";
	
	
	
	///////////////////////////////////////Adhoc Review TestCase/////////////////////////////
	
	
	public String DoesNotSupportTab="//a[normalize-space(.) = 'Does Not Support']";
	
	public String CPTCode="(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]";
	
	public String ICDCode="(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[3]";

	public String DecisionStatus="(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[5]";
	
	
	public String SelectRule="(//div[@class='ui-grid-cell-contents'])[2]/child::div";
	
	public String DecisionArrow="//div[@id='dropdownlistArrowselectedReason']";
	
	public String DecisionValue="//div[@id='listitem0innerListBoxselectedReason']//span";
	
	public String Reason="//textarea[@id='reasonForUpdateTextArea']";
	
	public String ApplyBtn="//a[@ng-click='onReasonApplyClick()']";
	
	public String AdhocReviewTab="//a[text()='Adhoc Review']";

	// ==================== Methods
	// =============================================

	HomePage oHomePage;

	public String CptCodeTextBox="(//input[@ng-model='colFilter.term'])[1]";

	public String ICDCodeTextBox="(//input[@ng-model='colFilter.term'])[4]";
	
	public String ICDCodeTextBoxNew = "(//input[@ng-model='colFilter.term'])[2]";

	public String SelectRuleDoesNotSupportTab="(//div[@class='ui-grid-cell-contents'])[3]/child::div";

	public String CPTCodeDoesNotSupportTab="(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[9]";

	public String ICDCodeDoesNotSupportTab="(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[11]";

	

	public void Enters_Remarks_For_Rejected_Codes(String sRemarks) throws Exception {

		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		try {
			List<String> sRemarksList = Arrays.asList(sRemarks.split(","));

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			for (int i = 0; i < sRemarksList.size(); i++) {

				// Select the check box
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(sCheckBox, "iRowCount", String.valueOf(i + 1)));

				// Click on Reject button
				oSeleniumUtils.Click_given_WebElement(Reject_Btn);
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				// Select Reason combo box
				oSeleniumUtils.is_WebElement_Displayed(SelectReasonCmb);

				// Select the Non-Configurable-Other Value
				oSeleniumUtils.Click_given_WebElement(SelectReasonArrowIcon);				 
				//Wait till the Data loads in the page
				 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	

				oSeleniumUtils.Click_given_Locator(
						StringUtils.replace(oHomePage.SpanText, "sValue", ProjectVariables.SelectReasonValue));

				// Enter Reject reasons
				Serenity.setSessionVariable("Remarks").to(sRemarksList.get(i));
				oSeleniumUtils.enter_given_text_webelement(RejectReasonTextArea, sRemarksList.get(i));
				SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

				// Click on Apply
				oSeleniumUtils.Click_given_Locator(Apply);				 
				//Wait till the Data loads in the page
				 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	

			}
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean Filter_Codes_Based_On(String sFilterType) throws InterruptedException {

		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);

		char sActualValue;
		String sDBQuery = null;
		int DBItemsCount=0;

		switch (sFilterType) {

		case "Remarks":

				oSeleniumUtils.enter_given_text_webelement(RemarksFilter_TextBox,Serenity.sessionVariableCalled("Remarks"));
				oSeleniumUtils.Click_given_WebElement(ApplyFilter_Btn);
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			  sActualValue = (oSeleniumUtils.get_Text_From_WebElement(Page_Items_Count)).charAt(9);
			
						switch (Serenity.sessionVariableCalled("TabName").toString()) 
						{
											
						 case "Support":				
							
							 sDBQuery = "Select count(*) from (Select Remarks from LCD.LCD_CPT_ICD_SPRT_DELTA" + " where LCD_ID="
										+ Serenity.sessionVariableCalled("LCD_ID").toString() + " and Remarks='"+ Serenity.sessionVariableCalled("Remarks") + "')";	
							 
							 DBItemsCount = Integer.parseInt(DBUtils.executeSQLQuery(sDBQuery));
							 
							 //Capture Jurisdictions count for the LCDID
							 String sQuery = "Select count(*) from (select distinct  mcare_juris from LCD.LCD_CPT_ICD_SPRT_DELTA where lcd_id="+Serenity.sessionVariableCalled("LCD_ID")+" and mcare_juris is not null)";
							 int iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));
											 
							 //Divide the DB count by  Jurisdiction count  as in DB  for each Jurisdiction the HCPC code values are replicated,but in UI only single set of data is shown 
							  DBItemsCount =  Math.abs((DBItemsCount/iJusrisidictionCount));			
							  System.out.println("After division by Jurisdictions,DB Count: "+DBItemsCount); 
							  
							 break;
			
						case "Does":
			
							sDBQuery = "select count(*) from (Select Remarks from LCD.LCD_CPT_ICD_DONTSPRT_DELTA" + " where LCD_ID="
									+ Serenity.sessionVariableCalled("LCD_ID").toString() + " and Remarks='"
									+ Serenity.sessionVariableCalled("Remarks") + "')";
							
							 DBItemsCount = Integer.parseInt(DBUtils.executeSQLQuery(sDBQuery));
			
							break;
			
						default:
							logger.info("No input is provided for the Switch Case");
							Assert.assertTrue("Provided invalid case value", false);
						}
						
						return String.valueOf(sActualValue).equalsIgnoreCase(String.valueOf(DBItemsCount));

		case "Display Blanks":

				oSeleniumUtils.Click_given_WebElement(Dispay_Blanks_CheckBox);
				oSeleniumUtils.Click_given_WebElement(ApplyFilter_Btn);
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			   sActualValue = (oSeleniumUtils.get_Text_From_WebElement(Page_Items_Count)).charAt(9);
			
					switch (Serenity.sessionVariableCalled("TabName").toString()) 
					{
					case "Support":
						
						sDBQuery = "select count(*) from (Select Remarks from LCD.LCD_CPT_ICD_SPRT_DELTA" + " where LCD_ID="
								+ Serenity.sessionVariableCalled("LCD_ID").toString() + " and Remarks is null) ";
												 
						 DBItemsCount = Integer.parseInt(DBUtils.executeSQLQuery(sDBQuery));
						 
						 //Capture Jurisdictions count for the LCDID
						 String sQuery = "Select count(*) from (select distinct  mcare_juris from LCD.LCD_CPT_ICD_SPRT_DELTA where lcd_id="+Serenity.sessionVariableCalled("LCD_ID")+" and mcare_juris is not null)";
						 int iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));
										 
						 //Divide the DB count by  Jurisdiction count  as in DB  for each Jurisdiction the HCPC code values are replicated,but in UI only single set of data is shown 
						  DBItemsCount =  Math.abs((DBItemsCount/iJusrisidictionCount));			
						  System.out.println("After division by Jurisdictions,DB Count: "+DBItemsCount); 						
		
						break;
		
					case "Does":
						
						sDBQuery = "select count(*) from (Select Remarks from LCD.LCD_CPT_ICD_DONTSPRT_DELTA" + " where LCD_ID="
								+ Serenity.sessionVariableCalled("LCD_ID").toString() + " and Remarks is null) ";
						
						DBItemsCount = Integer.parseInt(DBUtils.executeSQLQuery(sDBQuery));
						break;		
					}
						return String.valueOf(sActualValue).equalsIgnoreCase(String.valueOf(DBItemsCount));
					  
		}
		return false;
	}
		
	public boolean Sort_Remarks_Column() {
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);

		String sActualSortOrder = null;

		oSeleniumUtils.Click_given_WebElement(ClearAllFilters_Btn);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

		// click on Sort icon
		oSeleniumUtils.Click_given_Locator(sRemarksColumnDiv);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

		sActualSortOrder = getDriver().findElement(By.xpath(sRemarksSortIcon)).getAttribute("aria-label");
		if (!sActualSortOrder.equalsIgnoreCase("Sort Ascending")) {
			return false;
		}

		oSeleniumUtils.Click_given_Locator(sRemarksColumnDiv);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

		sActualSortOrder = getDriver().findElement(By.xpath(sRemarksSortIcon)).getAttribute("aria-label");
		if (!sActualSortOrder.equalsIgnoreCase("Sort Descending")) {
			return false;
		}

		return true;
	}

	public void selectCodeCombinations(String arg1) {

		String sTabName;
		sTabName = arg1;

		if (sTabName.equalsIgnoreCase("SupportTab")) {
			sTabName = "Support";
			Serenity.setSessionVariable("TabName").to(sTabName);
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", sTabName));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			// Select some code combinations
			for (int i = 0; i < 2; i++) {
				// Select the check box
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(sCheckBox, "iRowCount", String.valueOf(i + 1)));
			}
		} else if (sTabName.equalsIgnoreCase("DoesNotSupportTab")) {
			sTabName = "Does";
			Serenity.setSessionVariable("TabName").to(sTabName);
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", sTabName));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			// Select some code combinations
			for (int i = 0; i < 2; i++) {
				// Select the check box
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(sCheckBox, "iRowCount", String.valueOf(i + 1)));
			}
		} else if (sTabName.contains("Support and DoesNotSupport")) {

			oSeleniumUtils
					.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", "Support"));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			// Select some code combinations
			for (int i = 0; i < 2; i++) {
				// Select the check box
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(sCheckBox, "iRowCount", String.valueOf(i + 1)));
			}

			// Click on "DoesNotSupport" tab and select some code combinations
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", "Does"));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			// Select some code combinations
			for (int i = 0; i < 2; i++) {
				// Select the check box
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(sCheckBox, "iRowCount", String.valueOf(i + 1)));
			}
		} else if (sTabName.contains("OR")) {
			// Click on "DoesNotSupport" tab and select some code combinations
			oSeleniumUtils
					.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", "Support"));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			// Select some code combinations
			for (int i = 0; i < 1; i++) {
				// Select the check box
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(sCheckBox, "iRowCount", String.valueOf(i + 1)));
			}
		}
	}

	public boolean validateAcceptRejectButtons(String arg1, String arg2) {

		String sButton;
		sButton = arg1;
		String sEnabled_Disabled = arg2;
		boolean bEnabled_Disabled = false;

		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);

		switch (sButton) {

		case "Accept":

			oSeleniumUtils.highlightElement(AcceptButton);

			if (sEnabled_Disabled.equalsIgnoreCase("Enabled")) {

				bEnabled_Disabled = Accept_Btn.isEnabled();
			} else if (sEnabled_Disabled.equalsIgnoreCase("Disabled")) {
				bEnabled_Disabled = !Accept_Btn.isEnabled();
			}

			break;

		case "Reject":

			oSeleniumUtils.highlightElement(RejectButton);

			if (sEnabled_Disabled.equalsIgnoreCase("Enabled")) {
				bEnabled_Disabled = Reject_Btn.isEnabled();
			} else if (sEnabled_Disabled.equalsIgnoreCase("Disabled")) {
				bEnabled_Disabled = !Reject_Btn.isEnabled();
			}

			break;

		default:
			logger.info("No input is provided for the Switch Case");
			Assert.assertTrue("Provided invalid case value", false);

		}

		return bEnabled_Disabled;
	}

	public void deSelectCodeCombinations(String arg1) {

		String sTabName;
		sTabName = arg1;

		if (sTabName.equalsIgnoreCase("SupportTab")) {
			sTabName = "Support";

			Serenity.setSessionVariable("TabName").to(sTabName);
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", sTabName));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			// Select some code combinations
			for (int i = 0; i < 2; i++) {
				// Select the check box
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(sCheckBox, "iRowCount", String.valueOf(i + 1)));
			}
		} else if (sTabName.equalsIgnoreCase("DoesNotSupportTab")) {
			sTabName = "Does";
			Serenity.setSessionVariable("TabName").to(sTabName);
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", sTabName));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			// Select some code combinations
			for (int i = 0; i < 2; i++) {
				// Select the check box
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(sCheckBox, "iRowCount", String.valueOf(i + 1)));
			}
		}

		else if (sTabName.contains("Support and DoesNotSupport")) {

			oSeleniumUtils
					.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", "Support"));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			// Click on "DoesNotSupport" tab and select some code combinations
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", "Does"));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

		}
	}

	public int retrievePageItemsCount(String ColName, String TabName) throws Exception {

		int ItemsCount = 0;
		String ItemsCountText = "";
		String[] ItemCountArr1;
		String[] ItemCountArr2;

		switch (TabName) {

		case "SupportTab":

			try {
				ItemsCountText = pageItemsCount.getText();

			} catch (Exception e) {
				getDriver().quit();
				throw new Exception("Page items count Not retrieved from RAReviewWorkQueuePage SupportTab");
			}

			break;

		case "DoesNotSupportTab":

			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", "Does"));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			try {
				ItemsCountText = pageItemsCount.getText();

			} catch (Exception e) {
				getDriver().quit();
				throw new Exception("Page items count Not retrieved from RAReviewWorkQueuePage DoesNotSupportTab");
			}

			break;
			
		case "GroupTasks":
			try {
				ItemsCountText = pageItemsCount.getText();

			} catch (Exception e) {
				getDriver().quit();
				throw new Exception("Page items count Not retrieved from GroupTasks Screen");
			}

			break;			
			
			case "IndividualTasks":
				try {
					ItemsCountText = pageItemsCount.getText();

				} catch (Exception e) {
					getDriver().quit();
					throw new Exception("Page items count Not retrieved from IndividualTasks Screen");
				}

				break;		

		default:
			logger.info("No input is provided for the Switch Case");
			Assert.assertTrue("Provided invalid case value", false);

		}// End of switch case

		// Retrieving the ItemsCount from the String
		if (ItemsCountText.isEmpty()) {
			return 0;

		} else {
			ItemCountArr1 = ItemsCountText.split("of");
			ItemCountArr2 = ItemCountArr1[1].split("items");
			ItemsCount = Integer.parseInt(ItemCountArr2[0].trim());
		}

		Serenity.setSessionVariable(TabName + "ItemsCount").to(ItemsCount);

		// Returning items count to the calling Method
		return ItemsCount;

	}

	public boolean compareUIandDBitemsCount(String arg1) {

		String sTabName;
		sTabName = arg1;
		int UICount = 0;
		int DBCount = 0;
		String sSupportTabCodeCombDBCount = "";
		String sDoesNotSupportTabCodeCombDBCount = "";
		boolean bcompareCount = false;

		if (sTabName.equalsIgnoreCase("SupportTab")) {

			sSupportTabCodeCombDBCount = "Select count(*) from (Select * from LCD.LCD_CPT_ICD_SPRT_DELTA where LCD_ID="
					+ Serenity.sessionVariableCalled("LCD_ID") + ")";

			// Access the Support count stored in Session variable
			UICount = Serenity.sessionVariableCalled("SupportTabItemsCount");

			// Retrieve the count from query for Support Tab
			DBCount = Integer.parseInt(DBUtils.executeSQLQuery(sSupportTabCodeCombDBCount));

			// Compare the count of UI and DB

			if (UICount == DBCount) {
				System.out.println("Support Tab DB and UI count matched");
				bcompareCount = true;
			} else {
				bcompareCount = false;
			}

		} else if (sTabName.equalsIgnoreCase("DoesNotSupportTab")) {

			sDoesNotSupportTabCodeCombDBCount = "Select count(*) from (Select * from LCD.LCD_CPT_ICD_DONTSPRT_DELTA where LCD_ID="
					+ Serenity.sessionVariableCalled("LCD_ID") + ")";

			// Access the DoesNotSupport count stored in Session variable
			UICount = Serenity.sessionVariableCalled("DoesNotSupportTabItemsCount");

			// Retrieve the count from query for Support Tab
			DBCount = Integer.parseInt(DBUtils.executeSQLQuery(sDoesNotSupportTabCodeCombDBCount));

			// Compare the count of UI and DB
			if (UICount == DBCount) {
				System.out.println("DoesNotSupport Tab DB and UI count matched");
				bcompareCount = true;
			} else {
				bcompareCount = false;
			}

		}

		return bcompareCount;

	}

	public void validateReviewDecision(String arg1) {

		String sReviewDecisionExpected;
		String sReviewDecisionActual;
		sReviewDecisionExpected = arg1;

		sReviewDecisionActual = ReviewDecision.getText();

		if (sReviewDecisionExpected.equalsIgnoreCase(sReviewDecisionActual)) {
			System.out.println("Review decision updated in the column");
		} else {
			System.out.println("Review decision not updated in the column");
		}
	}

	public void applyFilterOnCPTGroup(String arg1) {

		String sTabName;
		sTabName = arg1;

		if (sTabName.contains("Does")) {
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", "Does"));
		}

		else if (sTabName.equalsIgnoreCase("SupportTab")) {
			oSeleniumUtils
					.Click_given_Locator(StringUtils.replace(oCPTICDLINKHomePage.AnchorTags, "sValue", "Support"));
		}

		// CPTHCPC Code Group drop down value selection
		CPTHCPCSCodeGroupDropDown.click();
		SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
		oSeleniumUtils.Click_given_Locator(CPTHCPCSCodeGroupDropDownVals);

		// Click on ApplyFilter Button
		ApplyFilter_Btn.click();
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

	}

	public boolean selectingWeekTask() {
		boolean bStatus = false;
		List<String> itemsToAdd = new ArrayList<String>();
		int iCount = getDriver().findElements(By.xpath(Week_Task_Sorting)).size();
		for (int i = 0; i < iCount; i++) {
			int j = i + 1;
			String sXpath = Week_Task_Sorting + "[" + j + "]/div[@role='row']/div[6]";
			System.out.println(sXpath);
			itemsToAdd.add(oSeleniumUtils.get_TextFrom_Locator(sXpath));
			bStatus = true;
		}
		if (bStatus) {
			Set<String> UniqueList = new HashSet<String>(itemsToAdd);
			System.out.println("Unique gas count: " + itemsToAdd.size());
			if (UniqueList.size() <= 1) {
				oSeleniumUtils.Click_given_WebElement(oHomePage.ID_Checkbox);
			} else {
				oSeleniumUtils
						.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue", "Task Assigned Week"));
				oSeleniumUtils.Click_given_WebElement(oHomePage.ID_Checkbox);
			}

		}
		return bStatus;
	}
	
public void Update_Decision_in_Task_Tab(String sTaskTab) {
		
		boolean bStatus = false;
		
		switch(sTaskTab){
			case "Support":
				Serenity.setSessionVariable("Category").to(sTaskTab);
				getDriver().findElement(By.xpath(StringUtils.replace(oHomePage.AnchorTags, "sValue",sTaskTab))).click();
				//oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue",sTaskTab));
				break;
			case "Does":
				Serenity.setSessionVariable("Category").to("Does Not Support");
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue",sTaskTab));
				break;
			default:
				Assert.assertFalse("Provide wrong task tab name :"+sTaskTab ,false);
			}
		
		//Check the value
		SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
		oSeleniumUtils.Click_given_Locator(Checkbox);
		
		//Get the CPT/HCPCS Code
		String sCPT_HCPCSCode = oSeleniumUtils.get_TextFrom_Locator(RAReviewCPT_HCPCS_Cell_Value);
		 Serenity.setSessionVariable("HCPCCode_Support").to(sCPT_HCPCSCode);	
						
		String sICDCode = oSeleniumUtils.get_TextFrom_Locator(RAReviewICD_Code_Cell_Value);
		Serenity.setSessionVariable("ICDCode_Support").to(sICDCode);
		
		bStatus = Accept_Btn.isEnabled();
		 Serenity.setSessionVariable("ReviewDecision_Support").to("Accept");
		if(bStatus){
			//click on Accept
			oSeleniumUtils.Click_given_WebElement(Accept_Btn);
			
			oSeleniumUtils.enter_given_text_webelement(ReasonUpdateTextArea,"QA Testing");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			
			
			//click on Apply
			oSeleniumUtils.Click_given_Locator(Apply);
			
		}else{
			 Serenity.setSessionVariable("ReviewDecision_Support").to("Reject");
			//click on Reject
			oSeleniumUtils.Click_given_WebElement(Reject_Btn);			
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			
			//Select Reason cmb 
			oSeleniumUtils.is_WebElement_Displayed(SelectReasonCmb);
			
			//Select the Non-Configurable-Other Value
			oSeleniumUtils.Click_given_WebElement(SelectReasonArrowIcon);			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);			
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue",ProjectVariables.SelectReasonValue));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			
			//Enter Reject reasons
			Serenity.setSessionVariable("Remarks").to("Functional Testing");
			oSeleniumUtils.enter_given_text_webelement(RejectReasonTextArea,Serenity.sessionVariableCalled("Remarks"));
			
			oSeleniumUtils.enter_given_text_webelement(ReasonUpdateTextArea,"QA Testing");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			
			//click on Apply
			oSeleniumUtils.Click_given_Locator(Apply);		
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		}
		oSeleniumUtils.Click_given_WebElement(Update_Decision_Btn);		
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
		oSeleniumUtils.Click_given_Locator(oHomePage.Submit_Btn);								
		getDriver().close();
		oSeleniumUtils.switchWindowUsingWindowCount(100,1);	
	}





}
