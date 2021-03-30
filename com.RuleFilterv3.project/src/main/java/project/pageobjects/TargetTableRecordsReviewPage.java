package project.pageobjects;


import net.serenitybdd.core.pages.PageObject;
import project.utilities.DBQueries;
import project.utilities.SeleniumUtils;

public class TargetTableRecordsReviewPage extends PageObject 
{
	
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RAReviewWorkQueuePage.class);

	HomePage oCPTICDLINKHomePage;
	SeleniumUtils oSeleniumUtils;
	DBQueries oDBQueries;
	AdminPage oAdminPage;

	public String sCheckBox = "(//div[@class='ui-grid-canvas'])[1]/div[iRowCount]//div[contains(@class,'ui-grid-selection')]";	
	
	public String AcceptButton = "//button[@id='setAppropriate']";

	public String RejectButton = "//button[@id='setInAppropriate']";
	
	public String UpdateDecisionButton = "//button[@id='updateDecision']";
	
	public String ReqCodeCombReviewButton = "//button[@id='requestCodeCombination']";
	
	public String HCPCSCode_CellValue = "((//div[contains(@id,'target')]/div[@class='ui-grid-contents-wrapper']//div[@class='ui-grid-viewport ng-isolate-scope'])[2]/div/div/div[1]/div[1]/div)[1]";

	public String ICDCode_CellValue = "((//div[contains(@id,'target')]/div[@class='ui-grid-contents-wrapper']//div[@class='ui-grid-viewport ng-isolate-scope'])[2]/div/div/div[1]/div[4]/div)[1]";
	
	public String ReviewDecision_CellValue =  "((//div[contains(@id,'target')]/div[@class='ui-grid-contents-wrapper']//div[@class='ui-grid-viewport ng-isolate-scope'])[2]/div/div/div[1]/div[7]/div)[1]";

	public String SelectReason_DrpDwn = "//div[@id='dropdownlistWrapperselectedReason']";
	
	public String SelectReasonArrowIcon =   "//div[@id='dropdownlistArrowselectedReason']"; 	
	
	public String Apply = "//a[@ng-click='onReasonApplyClick()']";
		
	public String UpdateDecisionReason  = "//textarea[@id = 'reasonForUpdateTextArea']";
	
	//public String DecisionConfirmation_Message= "/html/body/div[8]/div/div/div/div[2]";
			
	public String DecisionConfirmation_Message= "/html/body/div[8]/div/div/div";
	
	public String DecisionConfirmation_OkBtn= "/html/body/div[8]/div/div/div/div[3]/button[1]";
	
	public String SpanText = "//span[text()='sValue']";
	
	public String  DoesNotSupportTab   = "//a[contains(text(),'Does Not')]";
	
	public String  InputColumn =  "(//input[@type='text'][@aria-label='Filter for column'])[1]";
	
	public String  AdhocReviewTab   = "//a[contains(text(),'Adhoc')]";
	
	public String     InputBox  =  "//input[@type='text'][@aria-label='Filter for column']";
		
	public String     HCPCSCode_Textbox  = " (//input[@type='text'][@aria-label='Filter for column'])[1]";
	
	public String     ICDCode_Textbox  = " (//input[@type='text'][@aria-label='Filter for column'])[4]";
	
	public String     Category_Textbox  = " (//input[@type='text'][@aria-label='Filter for column'])[4]";
			
	public String    ReviewDecision_Textbox   = 		"(//input[@type='text'][@aria-label='Filter for column'])[8]";
	
	public String     TargetScreen_ICDCode = "//div[@role='gridcell'][4]";
	
	public String     TargetScreen_ReviewDecision = "//div[@role='gridcell'][7]";

}
