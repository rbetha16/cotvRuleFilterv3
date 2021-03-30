package project.feature.steps.definitions;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.common.base.CharMatcher;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.pageobjects.AdminPage;
import project.pageobjects.HomePage;
import project.pageobjects.LoginPage;
import project.pageobjects.RAReviewWorkQueuePage;
import project.utilities.DBQueries;
import project.utilities.DBUtils;
import project.utilities.GenericUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;

public class ManuallyCreatingNewCombinationsBaseOnAssociatedICDCodesStepDef extends ScenarioSteps {

	private static final long serialVersionUID = 5898280540796957114L;
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ManuallyCreatingNewCombinationsBaseOnAssociatedICDCodesStepDef.class);
	
	LoginPage ologinPage;
	HomePage oHomePage;
	SeleniumUtils oSeleniumUtils;
	RAReviewWorkQueuePage  oRAPage;
	AdminPage oAdminPage;
	GenericUtils oGenericUtils;
	//EstablishProposalReviewWorkflowStepDef oEstablishProposalReviewWorkflowStepDef;
	EstablishOperationalAuditFunctionalityStepDef oEstablishOperationalAuditFunctionalityStepDef;
		
	@Step
	public void raClicksTheID(String sLCD_OR_Article) {
		
		//Select LCD/Article
		oSeleniumUtils.Click_given_WebElement(oHomePage.LCDArticleDropdown);
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText,"sValue",sLCD_OR_Article));
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		oSeleniumUtils.Click_given_WebElement(oHomePage.LCDArticleDropdown);
		logger.info("RA filtered the data with -"+sLCD_OR_Article);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		
		//Select Status
		oSeleniumUtils.Click_given_WebElement(oHomePage.StatusDropDown);
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText,"sValue","Started"));
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		oSeleniumUtils.Click_given_WebElement(oHomePage.StatusDropDown);
		logger.info("RA filtered the data with - Started");
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		logger.info("RA clicked on ID:- "+oSeleniumUtils.get_Text_From_WebElement(oAdminPage.FirstReviewTaskID));
		oSeleniumUtils.Click_given_WebElement(oAdminPage.FirstReviewTaskID);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);		
	}

	@Step
	public void raClicksOnTheButton(String arg1) {
		
		if(arg1.equalsIgnoreCase("Delete Combination"))
		{
			oSeleniumUtils.Click_given_Locator(oRAPage.sRAPage_DelCodeCombinationButton);
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);			
			logger.info("RA Successfully clicked on the Button:"+arg1);
			
		}
		else{		
			oSeleniumUtils.Click_given_WebElement(oRAPage.RAReviewManually_Created_Combination_Btn);
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);			
			logger.info("RA Successfully clicked on the Button:"+arg1);
		}
	}

	@Step
	public void raShouldBeNavigatedToScreenWithTwoTabs(String arg1, String arg2) {
			
		boolean bStatus = false;
			
		bStatus = oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oHomePage.AnchorTags,"sValue",arg1));
		if(bStatus){
			logger.info("Add Combination button is displayed successfully.");
			Assert.assertTrue("Add Combination button is displayed",bStatus);
		}else{
			logger.error("Add Combination button is not displayed.");
			Assert.assertTrue("Add Combination button is displayed",bStatus);
		}
			
		bStatus = oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oHomePage.AnchorTags,"sValue",arg2));
		if(bStatus){
			logger.info("Delete Combination button is displayed successfully.");
			Assert.assertTrue("Delete Combination button is displayed",bStatus);
		}else{
			logger.error("Delete Combination button is not displayed.");
			Assert.assertTrue("Delete Combination button is displayed",bStatus);
		}
	}

	@Step
	public void addCombinationTabShouldBeDisplayedWith(String arg1) {
		boolean bStatus = false;
		
		//Check if the BaseICDCode Text Box WebElement displayed
		bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAPage.sBaseICDCodeTxt);
		if(bStatus){
			logger.info("Base ICD Code Text field is displayed");
			oSeleniumUtils.highlightElement(oRAPage.sBaseICDCodeTxt);
			Assert.assertTrue("Base ICD Code Text field is displayed ",bStatus);
		}else{
			logger.error("Base ICD Code Text field is not displayed");
			Assert.assertTrue("Base ICD Code Text field is not displayed",bStatus);
		}
		
		//Check if the ICD Group Text Box WebElement displayed
		bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAPage.sICDGroupTxt);
		if(bStatus){
			logger.info("ICD Group text field is displayed.");
			oSeleniumUtils.highlightElement(oRAPage.sICDGroupTxt);
			Assert.assertTrue("ICD Group text field is displayed.",bStatus);
		}else{
			logger.error("ICD Group field is not displayed as text field.");
			Assert.assertTrue("ICD Group Code is not displayed as text field.",bStatus);
		}
		
		//Check if the Category drop down WebElement displayed
		bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAPage.sCategoryDropDown);
		if(bStatus){
			logger.info("Category Drop down (combo box) field is displayed");
			oSeleniumUtils.highlightElement(oRAPage.sCategoryDropDown);
			Assert.assertTrue("Category Drop down (combo box) field is displayed",bStatus);
		}else{
			logger.error("Category field is not displayed as Drop down field.");
			Assert.assertTrue("Category field is not displayed as Drop down field.",bStatus);
		}
		
		
		//Check if the ICDCode Text Box WebElement displayed
		bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAPage.sICDCodeTxt);
		if(bStatus){
			logger.info("'ICD Code' text field is displayed.");
			oSeleniumUtils.highlightElement(oRAPage.sICDCodeTxt);
			Assert.assertTrue("ICD Code' text field is displayed.",bStatus);
		}else{
			logger.error("ICD Code field is not displayed as text field.");
			Assert.assertTrue("ICD Code field is not displayed as text field.",bStatus);
		}
		
		//Check if the Add new ICD Code Button WebElement displayed
		bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAPage.sAddNewICDButton);
		if(bStatus){
			logger.info("'Add New ICD' button field is displayed.");
			oSeleniumUtils.highlightElement(oRAPage.sAddNewICDButton);
			Assert.assertTrue("'Add New ICD' button field is displayed.",bStatus);
		}else{
			logger.error("'Add New ICD' field not displayed as button field.");
			Assert.assertTrue("'Add New ICD' field not displayed as button field.",bStatus);
		}

	}

	@Step
	public void ValidateCategoryDropDownValues(String sCategoryDropDownValues) {
		
		List<String> exp_options = Arrays.asList(sCategoryDropDownValues.split(","));
		oSeleniumUtils.Click_given_Locator(oRAPage.sCategoryDropDown);
		boolean bStatus = false;
		ArrayList<String> actual_values = oSeleniumUtils.getDropDownValues(oRAPage.sCategoryDropDown);
				
		for(int i = 0; i < exp_options.size(); i++){
			
			for(int j = i; j < actual_values.size();){
				System.out.println(actual_values.get(j));
				if (actual_values.get(j).equals(exp_options.get(i))){
					bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAPage.sCategoryDropDown+"/option[text()='"+exp_options.get(i)+"']");
					if(bStatus){
						oSeleniumUtils.highlightElement(oRAPage.sCategoryDropDown+"/option[text()='"+exp_options.get(i)+"']");
					}
		             System.out.println("The Expected Drop Down Value is:- '"+exp_options.get(i)+"' matched with the Actual Drop Down Value :-'"+actual_values.get(j)+"'.");
		             logger.info("The Expected Drop Down Value :- '"+exp_options.get(i)+"' is matched with the Actual Drop Down Value :-'"+actual_values.get(j)+"'.");
		             break;
				}else{
					logger.error("The Expected Drop Down Value :- '"+exp_options.get(i)+"' is not matched with the Actual Drop Down Value :-'"+actual_values.get(j)+"'.");
				}
			}
		}
	}

	@Step
	public void RAClicksOnAddNewICDCodeButton(String arg1) 
	{
		if(!arg1.isEmpty())
		{
			for(int i = 1; i <= Integer.parseInt(arg1); i++)
			{
				oSeleniumUtils.Click_given_Locator(oRAPage.sAddNewICDButton);
				logger.info(i+ "Time RA Successfully clicked on Add New ICD Button");
			}	
		}else{
			logger.info(arg1+"Time RA Successfully clicked on Add New ICD Button");
		}
			
	}

	@Step
	public void RAShouldBeAbleToSeeTheICDCodeTextFieldsWithProperUI(String arg1) {
		
		int iExpICDCodeTextFieldsCount = Integer.parseInt(arg1);
		int iActualICDCodeTxtFieldsCount = oSeleniumUtils.getMatchingXpathCount(oRAPage.sAddedICDCodeTxtFields);
		
		logger.info("Expected ICD Code Text Fields Count is '"+iExpICDCodeTextFieldsCount+"'");
		logger.info("Actual ICD Code Text Fields Count is '"+iActualICDCodeTxtFieldsCount+"'");
		
		if(iExpICDCodeTextFieldsCount == iActualICDCodeTxtFieldsCount){
			logger.info("Expected ICD Code Text fields should match with the Actual ICD Code Text fields count with Proper UI");
			Assert.assertTrue("Expected ICD Code Text fields should match with the Actual ICD Code Text fields count with Proper UI",true);
		}else{
			logger.error("Expected ICD Code Text fields is not match with the Actual ICD Code Text fields count with Proper UI");
			Assert.assertTrue("Expected ICD Code Text fields is not match with the Actual ICD Code Text fields count with Proper UI- ExpectedICDCode:- "+iExpICDCodeTextFieldsCount+"' and Actural ICD Code:-'"+iActualICDCodeTxtFieldsCount+"'",false);
		}
	}    

	@Step
	public void raclaimsCodeFromGroupTasks(String LCD_Article)
	{
		
			String sID="";
			String IDName="";

			//Code for LCD 
			if(LCD_Article.equalsIgnoreCase("LCD"))
			{			
				sID= DBUtils.executeSQLQuery(DBQueries.LCD_ID_Query);			     
				Serenity.setSessionVariable("LCD_ID").to(sID);	
				Serenity.setSessionVariable("ID").to(sID);	
				System.out.println("LCD id value is ...."+Serenity.sessionVariableCalled("ID").toString());
				IDName="LCD";
			}
			else{  //Code for Article 		
				sID = DBUtils.executeSQLQuery(DBQueries.ArticleQuery);	
				Serenity.setSessionVariable("Article_ID").to(sID);
				Serenity.setSessionVariable("ID").to(sID);	
				IDName="Article";
			}
			
			//If LCD/Article retrieved from DB is not empty 
			if(!sID.equals("")){			

			logger.info(IDName+" ID is retrieved from DB:"+sID);

			oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,sID);
			logger.info(IDName+" ID entered in the TextBox :"+sID);

			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);

			oSeleniumUtils.is_WebElement_Displayed(oHomePage.ID_Checkbox);			
			oSeleniumUtils.Click_given_WebElement(oHomePage.ID_Checkbox);
			logger.info("Clicked on the ID CheckBox");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);

			oSeleniumUtils.Click_given_WebElement(oHomePage.ClaimTask_Btn);
			logger.info("Clicked on the ClaimTask Button for the ID");
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	

		}else{
			logger.error("There is no "+ IDName +" ids whose status as not started in DB");
			Assert.assertTrue("There is no "+ IDName +" ids whose status as not started in DB.",false);
		}		
         }
	
	@Step
	public void raClicksOnClaimedLCDArticleID(String LCD_Article) {
		
		String sID="";
		String sIDName="";
		
		if (LCD_Article.equalsIgnoreCase("LCD")) {
			///trinath///
			//Serenity.setSessionVariable("LCD_ID").to("37578");
			
			sID = Serenity.sessionVariableCalled("LCD_ID");
			sIDName="LCD";
		}
		else {
			//Serenity.setSessionVariable("Article_ID").to("54862");
			  sID = Serenity.sessionVariableCalled("Article_ID");
			  sIDName="Article";
		     }		
		
	   //Enter value in the ID field	
	   oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oHomePage.CPTICDLinkTaskTblColumnTxt,"sColumnName","ID"),sID);
	   logger.info(sIDName + " ID entered in the TextBox:"+sID);
	   
	   oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	   
	   oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oHomePage.AnchorTags,"sValue",sID));	   
	   SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);  

	   //Click on the Filtered ID Value	  
	  oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags,"sValue",sID));
	   //getDriver().findElement(By.xpath(StringUtils.replace(oHomePage.AnchorTags, "sValue",sID))).click();
	  //Wait for sometime
       oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
	   logger.info("Clicked on the given "+ sIDName+": "+sID); 
	   	  	  		
	}

	@Step
	public void validateAddEditCodeCombinationButton(String strButtonName) {
		
		boolean boolBtnStatus=false;		
				
		boolBtnStatus= oSeleniumUtils.is_WebElement_Displayed(oRAPage.RAReviewManually_Created_Combination_Btn);
		oSeleniumUtils.highlightElement(oRAPage.RAReviewManually_Created_Combination_Btn);
			
		if(boolBtnStatus==true)
		{
		  logger.info("The button :"+strButtonName+" is displayed");	
		  Assert.assertTrue("The button :"+strButtonName+" is displayed",boolBtnStatus);
		  
		}
		else if(boolBtnStatus==false)
		{
		   logger.error("The button :"+strButtonName+" is Not displayed");	
		   Assert.assertTrue("The button :"+strButtonName+" is Not  displayed",boolBtnStatus);		   
		}
		
	}
	
	@Step
	public void validateAddEditCodeCombinationButtonStatus(String strButtonName, String strButtonStatus, String strReviewStatus) {

		strReviewStatus=strReviewStatus.toUpperCase();
		boolean boolBtnStatus=false;
				
		switch (strReviewStatus) 
		{

		case "STARTED":			  

			//Click on Start Review button 			  
			oSeleniumUtils.Click_given_WebElement(oRAPage.StartReview_Btn);
			logger.info("Clicked on StartReview Button");

			//Wait for sometime
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	


			if(strButtonStatus.equalsIgnoreCase("Enabled"))
			{
				boolBtnStatus = oRAPage.RAReviewManually_Created_Combination_Btn.isEnabled();						
				if(boolBtnStatus==true)
				{
					logger.info("The button :"+strButtonName+" is Enabled status when the Task status is Started");	
					Assert.assertTrue("The button :"+strButtonName+" is Enabled status when the Task status is Started",boolBtnStatus);

				}
				else if(boolBtnStatus==false)
				{
					logger.error("The button :"+strButtonName+" is not in Enabled status when the Task status is Started");
					Assert.assertTrue("The button :"+strButtonName+" is Not Enabled status when the Task status is Started",boolBtnStatus);						   
				}				        	
			}			  
			break;

		case "NOTSTARTED":

			if(strButtonStatus.equalsIgnoreCase("Disabled"))
			{
				boolBtnStatus = oRAPage.RAReviewManually_Created_Combination_Btn.isEnabled();						
				if(boolBtnStatus==false)
				{
					logger.info("The button :"+strButtonName+" is in Disabled status when the Task status is NotStarted");
					Assert.assertTrue("The button :"+strButtonName+" is in Disabled status when the Task status is NotStarted",!boolBtnStatus);

				}
				else if(boolBtnStatus==true)
				{
					logger.error("The button :"+strButtonName+" is Not in Disabled status when the Task status is NotStarted");
					Assert.assertTrue("The button :"+strButtonName+" is Not Disabled status when the Task status is NotStarted",!boolBtnStatus);					 
				}		        	
			}		    	  

			break;

		default:  logger.info("No input is provided for the Switch Case");						  				
		Assert.assertTrue("Provided invalid Switch Case value",false);

		}

	}
	
	@Step
	public void raValidatesTheCodeCombinationTabs(String arg1, String arg2, String arg3) {
		
		String strReviewStatus=arg3;
		
		if (strReviewStatus.equalsIgnoreCase("Started")){			
			raShouldBeNavigatedToScreenWithTwoTabs(arg1,arg2);			
		   }		
	}    

	@Step
	public void raClicksOnTheButtonWithStatus(String strButtonName, String strReviewStatus) {
					
		
		if (strReviewStatus.equalsIgnoreCase("Started")){
		    oSeleniumUtils.Click_given_WebElement(oRAPage.RAReviewManually_Created_Combination_Btn);
		    logger.info("Clicked on the "+strButtonName +" Button");		    		
		   }
	}
	
	@Step
	public void raClicksOnTheFirstID(String sLCD_OR_Article) {
				
		//Select LCD or Article
		oSeleniumUtils.Click_given_WebElement(oHomePage.LCDArticleDropdown);
		logger.info("Clicked on LCDArticleDropdown");
		
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText,"sValue",sLCD_OR_Article));
		logger.info("Clicked on"+sLCD_OR_Article+" in the LCDArticleDropdown");
		
		oSeleniumUtils.Click_given_WebElement(oHomePage.LCDArticleDropdown);
		logger.info("Successfully filtered the data with -"+sLCD_OR_Article);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				
		oSeleniumUtils.Click_given_WebElement(oAdminPage.FirstReviewTaskID);
		logger.info("Clicked on FirstReview Task ID in the Table");
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);		
	}

	@Step
	public void ValidateManuallyAndAssociateCodeRadioButtons(String arg1, String arg2) {
		boolean bStatus = false;
		
		bStatus = oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oRAPage.sManually_AssociateCode, "sValue", arg1));
		
		if(bStatus){
			logger.info(arg1+" radio button is displayed successfully");
			Assert.assertTrue(arg1+" radio button is displayed successfully",bStatus);
		}else{
			logger.info(arg1+" radio button is not displayed");
			Assert.assertTrue(arg1+" radio button is not displayed",bStatus);
		}
		
		bStatus = oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oRAPage.sManually_AssociateCode, "sValue", arg2));
		
		if(bStatus){
			logger.info(arg2+" radio button is displayed successfully");
			Assert.assertTrue(arg2+" radio button is displayed successfully",bStatus);
		}else{
			logger.info(arg2+" radio button is not displayed");
			Assert.assertTrue(arg2+" radio button is not displayed",bStatus);
		}
	}
	
	@Step
	public void RAClicksButton(String arg1) {
		oSeleniumUtils.Click_given_Locator(oRAPage.SaveButton);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		logger.info(arg1+" button is clicked successfully.");
	}

	@Step
	public void RAEntersGivenData(String baseICDCode, String iCDGroup, String category, String iCDCode,String iCDCode1) {
		
		if(!(baseICDCode.equalsIgnoreCase(""))){
			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sBaseICDCodeTxt, baseICDCode);
			logger.info("RA entered Base ICD Code as '"+baseICDCode);
			Serenity.setSessionVariable("ICD Code").to(baseICDCode);
			Serenity.setSessionVariable("ICD Code Doesn't").to(baseICDCode);		
		}else{
			logger.info("Base ICD Code value is empty");
		}
		
		if(!(iCDGroup.equalsIgnoreCase(""))){
			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sICDGroupTxt, iCDGroup);
			logger.info("RA entered ICD Group as '"+iCDGroup);
			Serenity.setSessionVariable("NewICDGroup").to(iCDGroup);
			Serenity.setSessionVariable("ICD Group").to(iCDGroup);
		}else{
			logger.info("ICD Group value is empty");
		}
		
		if(!(category.equalsIgnoreCase(""))){
			oSeleniumUtils.select_Given_Value_From_DropDown(oRAPage.sCategoryDropDown,category);
			logger.info("RA selected category drop down value as '"+category);
		}else{
			logger.info("Category value is empty");
		}		
		
		if(!(iCDCode.equalsIgnoreCase(""))){
			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sICDCodeTxt, iCDCode);
			logger.info("RA entered ICD Code as '"+iCDCode);
			Serenity.setSessionVariable("Manually Added Code").to(iCDCode);
			Serenity.setSessionVariable("NewICDCode1").to(iCDCode);
			Serenity.setSessionVariable("NewICDCode").to(iCDCode);
		}else{
			oSeleniumUtils.clear_Text(oRAPage.sICDCodeTxt);
			logger.info("ICD Code value is empty");
		}
		
		int intListSize=0;
		List<String> sNewCodeList=null;
		
		if(!(iCDCode1.equalsIgnoreCase("")))	
		{
			 sNewCodeList = Arrays.asList(iCDCode1.toString().split(","));
			
			intListSize =sNewCodeList.size();
			
			 if(intListSize==0)
			  {									
				oSeleniumUtils.enter_given_text_StringLocator("("+oRAPage.sICDCodeTxt+")[2]", iCDCode1);
				oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sICDCodeTxt, iCDCode1);
				logger.info("RA entered ICD Code as '"+iCDCode1);
				
				}
		}	 
		else{
			  logger.info("ICD Code1 value is empty");
			}	 
		 
		 
		 int i=0;
		
		 if(intListSize!=0)
		  {			 
			 for (i = 0; i <= intListSize-1; i++)
			 {				   
				oSeleniumUtils.enter_given_text_StringLocator("("+oRAPage.sICDCodeTxt+")["+(i+2)+"]", sNewCodeList.get(i));
				logger.info("RA entered ICD Code as '"+sNewCodeList.get(i));
			 }
		  }
	}
	
	@Step
	public void ValidateAlertMessage(String sExpectedAlertMsg) {
		
		    oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			boolean bStatus = false;
			bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAPage.RAPage_sAlertPopup);
			if(bStatus){
				logger.info("Alert Popup is displayed.");
				String sActualAlertMsg = oSeleniumUtils.get_TextFrom_Locator(oHomePage.sAlertPopupMsg);
				System.out.println("Actual AlertMsg:: "+sActualAlertMsg);
				
				if(sExpectedAlertMsg.equalsIgnoreCase(sActualAlertMsg)){
					logger.info("Actual Alert Msg:: '"+sActualAlertMsg+"' is equal with Expected Alert Msg::  '"+sExpectedAlertMsg+"'");
					Assert.assertTrue("Actual and expected alert messages are equal.",true);				
				}else{
					logger.info("Actual Alert Msg '"+sActualAlertMsg+"' is not equal with Expected Alert Msg::  '"+sExpectedAlertMsg+"'");
					Assert.assertTrue("Actual "+sActualAlertMsg+" and expected "+sExpectedAlertMsg+" alert messages are not equal.",false);
				}
				if(!sExpectedAlertMsg.equalsIgnoreCase(ProjectVariables.SwitchindRadioErrorMessage)){
					bStatus = oSeleniumUtils.is_WebElement_Displayed(oHomePage.sAlertPopupOKBtn);
					if(bStatus){
						logger.info("OK Button is displayed in the Alert Popup.");
						oSeleniumUtils.Click_given_Locator(oHomePage.sAlertPopupOKBtn);			
					}else{
						logger.info("OK Button is not displayed in the Alert Popup.");
						Assert.assertTrue("OK button is not displayed in the Alert Popup.",false);
					}	
				}else{
					bStatus = oSeleniumUtils.is_WebElement_Displayed(oHomePage.sAlertPopupOKYes);
					if(bStatus){
						logger.info("OK Button is displayed in the Alert Popup.");
						oSeleniumUtils.Click_given_Locator(oHomePage.sAlertPopupOKYes);			
					}else{
						logger.info("OK Button is not displayed in the Alert Popup.");
						Assert.assertTrue("OK button is not displayed in the Alert Popup.",false);
					}	
				}
				
			}else{
				logger.error("Alert Popup is not displayed.");
				Assert.assertTrue("Alert Popup is not displayed.",false);
			}		
			
		}
	
	@Step
	public void RAEntersBaseICDCodes(String sNewICDCodesCount,String sCategory,String sLCD_Article) {
			
		// Data from Support Table
		//This method Executes SQL query to retrieve specific code(ICD Code,Group,New Icd code,ICDCodeCount)
		//for support does not support and both which is only available in Support Delta Table for the LCD  based on the LCDID
					
		  String sID="";
		  String sSupportICD10Code="";
		  String sSuppportICDGroup="";
		  String sNewICD10Code ="";
		  String sDontSupportICD10Code="";
		  String sDontSuppportICDGroup="";
		  String sNewICD10Code2="";
		  String sSupportICD10CodeBoth="";
		  int iNewICDCodeCount=0;
		  String sSuppportICDGroupBoth="";
		  
		  
		if (sLCD_Article.equalsIgnoreCase("LCD")) {
			
			sID = Serenity.sessionVariableCalled("LCD_ID");
			logger.info("LCDID retrieved from Session variable and stored for further process");

					
		}
		  
		else if (sLCD_Article.equalsIgnoreCase("Article")) {
						
			sID = Serenity.sessionVariableCalled("Article_ID");
			logger.info("ArticleID retrieved from Session variable and stored for further process");
						
				}
		
       //  *****  Code to Retrieve new  ICD codes 		

		//Convert ICDCodeCount from String to integer if it is Not empty
		if (!sNewICDCodesCount.isEmpty()) {
			//Convert the no of ICDCodes to add from String to Integer
			iNewICDCodeCount = Integer.parseInt(sNewICDCodesCount);
		} 
		
		//Retrieve New ICD10_Code from ICD10_manual table		
		sNewICD10Code = getNewICDCodes("NewICDCodeOne","");
		
		if (!sNewICD10Code.isEmpty()) {
			logger.info("New ICD10 Code to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table::" + sNewICD10Code);
			Assert.assertTrue("New ICD10 Code to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table", true);
		} else {
			logger.error("New ICD10 Code to enter for creating Manual CodeCombination is Not retrieved from MDM.ICD10_MANUAL Table");
			Assert.assertTrue("New ICD10 Code to enter for creating Manual CodeCombination is Not available MDM.ICD10_MANUAL Table",false);
		}

		
		//Retrieve New ICD10_Code 2 from ICD10_manual table		
		sNewICD10Code2 = getNewICDCodes("NewICDCodeTwo","");
		
		if (!sNewICD10Code2.isEmpty()) {
			logger.info("New ICD10 Code-2 to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table::" + sNewICD10Code);
			Assert.assertTrue("New ICD10-2 Code to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table", true);
		} else {
			logger.error("New ICD10 Code-2 to enter for creating Manual CodeCombination is Not retrieved from MDM.ICD10_MANUAL Table");
			Assert.assertTrue("New ICD10-2 Code to enter for creating Manual CodeCombination is Not available MDM.ICD10_MANUAL Table",false);
		}
		 
		 switch(sLCD_Article)
		 {
		 
		  case "LCD":
			 
			if (sCategory.equalsIgnoreCase("Does Not Support")||sCategory.equalsIgnoreCase("Both")) {
				
				//BaseICDCode
				sSupportICD10Code= getSupportICD10Code(sID,"LCD","");			
				if(!sSupportICD10Code.isEmpty())
				{
				  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table");
				  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table",true);
				}
				else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario"); 
				      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario",false);
				    }
				
				//ICDGroup based on the ICDCode
				sSuppportICDGroup= getSupportICDGroup(sID,"LCD",sSupportICD10Code,"");				
				if(!sSuppportICDGroup.isEmpty())
				{
				  logger.info("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup);
				  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup,true);
				}
				else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table "); 
				      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table",false);
				    }	
				
				  raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory,sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				
			}

			if (sCategory.equalsIgnoreCase("Support")) {		
				
				//ICDCode for does not support			
				sDontSupportICD10Code=getDontSupportICD10Code(sID,"LCD","");
				
				if(!sDontSupportICD10Code.isEmpty())
				{
				  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table");
				  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table",true);
				}
				else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario"); 
				      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario",false);
				    }
				
				//ICDGroup for does not support
				sDontSuppportICDGroup= getDontSupportICDGroup(sID,"LCD",sDontSupportICD10Code,"");
				
				if(!sDontSuppportICDGroup.isEmpty())
				{
				  logger.info("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup);
				  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup,true);
				}
				else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table"); 
				      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table",false);
				    }
								
				raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory,sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				
			}

			if (sCategory.equalsIgnoreCase("Support-ValidCodes")) {				
				 sCategory = "Support";			
				 Serenity.setSessionVariable("Category Type").to(sCategory);
				 
			    	//BaseICDCode
					sSupportICD10Code= getSupportICD10Code(sID,"LCD","");			
					if(!sSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario",false);
					    }
					
					//ICDGroup based on the ICDCode
					sSuppportICDGroup= getSupportICDGroup(sID,"LCD",sSupportICD10Code,"");				
					if(!sSuppportICDGroup.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup);
					  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup,true);
					}
					else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table "); 
					      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table",false);
					    }						 
				 
				 raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				 
			}			 
			
			if (sCategory.equalsIgnoreCase("DoesNotSupport-ValidCodes")) {				
				 sCategory = "Does Not Support";
				 
					//BaseICDCode
					sSupportICD10Code= getSupportICD10Code(sID,"LCD","");			
					if(!sSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario",false);
					    }
					
					//ICDGroup based on the ICDCode
					sSuppportICDGroup= getSupportICDGroup(sID,"LCD",sSupportICD10Code,"");				
					if(!sSuppportICDGroup.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup);
					  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup,true);
					}
					else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table "); 
					      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table",false);
					    }				 
				 
				    raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				 
				 
					//ICDCode for does not support			
					sDontSupportICD10Code=getDontSupportICD10Code(sID,"LCD","");
					
					if(!sDontSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario",false);
					    }
				 

					//ICDGroup for does not support
					sDontSuppportICDGroup= getDontSupportICDGroup(sID,"LCD",sDontSupportICD10Code,"");
					
					if(!sDontSuppportICDGroup.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup);
					  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup,true);
					}
					else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table"); 
					      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table",false);
					    }				 
				 
				 raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);

			}	
			
			if (sCategory.equalsIgnoreCase("Support-ValidCodes-InvalidICDGroup")) {					
				 sCategory = "Support";		
				
					//BaseICDCode
					sSupportICD10Code= getSupportICD10Code(sID,"LCD","");			
					if(!sSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario",false);
					    }				
					
					//ICDGroup based on the ICDCode
					sSuppportICDGroup= getSupportICDGroup(sID,"LCD",sSupportICD10Code,"");				
					if(!sSuppportICDGroup.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup);
					  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup,true);
					}
					else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table "); 
					      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table",false);
					    }			
					
					 int iSupportICDGroup= Integer.parseInt(sSuppportICDGroup)+15;
					 sSuppportICDGroup =String.valueOf(iSupportICDGroup);				 
				 
				     raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				 
			}

			if (sCategory.equalsIgnoreCase("DoesNotSupport-ValidCodes-InvalidICDGroup")) {
				 sCategory = "Does Not Support";
							 
				 //ICDCode for does not support			
					sDontSupportICD10Code=getDontSupportICD10Code(sID,"LCD","");
					
					if(!sDontSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario",false);
					    }						 

					//ICDGroup for does not support
					sDontSuppportICDGroup= getDontSupportICDGroup(sID,"LCD",sDontSupportICD10Code,"");
					
					if(!sDontSuppportICDGroup.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup);
					  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup,true);
					}
					else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table"); 
					      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table",false);
					    }	
					
					 int iDontSupportICDGroup= Integer.parseInt(sDontSuppportICDGroup)+15;
					 sDontSuppportICDGroup =String.valueOf(iDontSupportICDGroup);
				 
				  raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				 
			}	
			
			if (sCategory.equalsIgnoreCase("BothCategories-InvalidICDGroup")) {					
				 sCategory = "Both";
				 
				 String sLCDArticleID= Serenity.sessionVariableCalled("LCD_ID");
				 
				 //Retrieve ICDCode which is in both the Support and DoesNotSupport tabs				 	
				 String sSupportICD10Query = "Select * from (select icd10_code from LCD.LCD_CPT_ICD_SPRT_DELTA where lcd_id ="+sLCDArticleID
				 								 +" intersect"+ 
				 								 " select icd10_code from LCD.LCD_CPT_ICD_DONTSPRT_DELTA where lcd_id ="+sLCDArticleID+") where rownum=1";
				sSupportICD10Code = DBUtils.executeSQLQuery(sSupportICD10Query);				
				logger.info("Base ICD Code which is available in both Support and DoesNotSupport tabs is retrieved:" + sSupportICD10Code);
   
				 //Retrieve ICDCode for ICDGroup					
				 String sSupportICD10GroupQuery = "Select * from (Select ICD10_Group from LCD.LCD_CPT_ICD_SPRT_DELTA where  lcd_id ="+ sLCDArticleID +" and ICD10_code="+"'"+sSupportICD10Code+"'"+") where rownum=1";
				 String sSupportICD10Group = DBUtils.executeSQLQuery(sSupportICD10GroupQuery);					
				 
				 int iSupportICDGroup= Integer.parseInt(sSupportICD10Group)+15;
				 sSuppportICDGroup =String.valueOf(iSupportICDGroup);
				 raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
			}


			if (sCategory.equalsIgnoreCase("DoesNotSupportOnly-ValidCodes")) {				
				sCategory = "Does Not Support";
				
				//ICDCode for does not support			
				sDontSupportICD10Code=getDontSupportICD10Code(sID,"LCD","");
				
				if(!sDontSupportICD10Code.isEmpty())
				{
				  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table");
				  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table",true);
				}
				else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario"); 
				      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario",false);
				    }				

				//ICDGroup for does not support
				sDontSuppportICDGroup= getDontSupportICDGroup(sID,"LCD",sDontSupportICD10Code,"");
				
				if(!sDontSuppportICDGroup.isEmpty())
				{
				  logger.info("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup);
				  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup,true);
				}
				else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table"); 
				      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table",false);
				    }			
				
					raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
						
			}			

			if (sCategory.equalsIgnoreCase("Support-MultipleValidCodes")) {				
				 sCategory = "Support";			
				 
			    	//BaseICDCode
					sSupportICD10Code= getSupportICD10Code(sID,"LCD","");			
					if(!sSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario",false);
					    }
					

					//ICDGroup based on the ICDCode
					sSuppportICDGroup= getSupportICDGroup(sID,"LCD",sSupportICD10Code,"");				
					if(!sSuppportICDGroup.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup);
					  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup,true);
					}
					else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table "); 
					      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table",false);
					    }		
				 
				 raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
			}
			
			if (sCategory.equalsIgnoreCase("Subsequent_SupportSigle")) {				
				 sCategory = "Support";				
				 raEntersAddCodeCombinationDetails(Serenity.sessionVariableCalled("SupportICD10Code"), Serenity.sessionVariableCalled("SupportICD10Group"), sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
			}
			
			if (sCategory.equalsIgnoreCase("Subsequent_SupportMultiple")) {
				 sCategory = "Support";				
				 raEntersAddCodeCombinationDetails(Serenity.sessionVariableCalled("SupportICD10Code"),Serenity.sessionVariableCalled("SupportICD10Group"),sCategory,sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
			}
			
			
			if (sCategory.equalsIgnoreCase("Validate_RadioButton_Assosiate")) {				
				 sCategory = "Support";		
				 
				   	//BaseICDCode
					sSupportICD10Code= getSupportICD10Code(sID,"LCD","");			
					if(!sSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario",false);
					    }					

					//ICDGroup based on the ICDCode
					sSuppportICDGroup= getSupportICDGroup(sID,"LCD",sSupportICD10Code,"");				
					if(!sSuppportICDGroup.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup);
					  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup,true);
					}
					else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table "); 
					      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table",false);
					    }				 
				 
				     raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory,sNewICD10Code,iNewICDCodeCount,"");
				 
			}	
			
			if (sCategory.equalsIgnoreCase("Validate_RadioButton_Manually")) {				
				 sCategory = "Support";	
				 
					//BaseICDCode
					sSupportICD10Code= getSupportICD10Code(sID,"LCD","");			
					if(!sSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario",false);
					    }					

					//ICDGroup based on the ICDCode
					sSuppportICDGroup= getSupportICDGroup(sID,"LCD",sSupportICD10Code,"");				
					if(!sSuppportICDGroup.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup);
					  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup,true);
					}
					else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table "); 
					      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table",false);
					    }				 
					
				      raEntersAddCodeCombinationDetails("", sSuppportICDGroup, sCategory,sNewICD10Code,iNewICDCodeCount,"");
				      
			}	
			if (sCategory.equalsIgnoreCase("DoesNotSupport")) {				
				sCategory = "Does Not Support";
				
				//ICDCode for does not support			
				sDontSupportICD10Code=getDontSupportICD10Code(sID,"LCD","");
				
				if(!sDontSupportICD10Code.isEmpty())
				{
				  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table");
				  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table",true);
				}
				else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario"); 
				      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario",false);
				    }
				
				//ICDGroup for does not support
				sDontSuppportICDGroup= getDontSupportICDGroup(sID,"LCD",sDontSupportICD10Code,"");
				
				if(!sDontSuppportICDGroup.isEmpty())
				{
				  logger.info("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup);
				  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup,true);
				}
				else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table"); 
				      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table",false);
				    }
   			
				
				raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				
			}
			if (sCategory.equalsIgnoreCase("Support_Both_Categories")) {
							
				sCategory = "Both";		

				//BaseICDCode for both categories
				sSupportICD10CodeBoth= getSupportICD10CodeBoth(sID,"LCD","");			
				if(!sSupportICD10CodeBoth.isEmpty())
				{
				  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10CodeBoth+" which is the code available in Support Delta table and in DontSupport Delta Table");
				  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10CodeBoth+" which is the code available in Support Delta table and  in DontSupport Delta Table",true);
				}
				else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario"); 
				      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario",false);
				    }
				

				//ICDGroup based on the ICDCode for both categories 
				sSuppportICDGroupBoth= getSupportICDGroupBoth(sID,"LCD",sSupportICD10CodeBoth,"");				
				if(!sSuppportICDGroupBoth.isEmpty())
				{
				  logger.info("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroupBoth);
				  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroupBoth,true);
				}
				else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table "); 
				      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table",false);
			    }
				
				raEntersAddCodeCombinationDetails(sSupportICD10CodeBoth, sSuppportICDGroupBoth, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				
			}
		 break;				
			 
			 
		 case "Article":
			 
			 if (sCategory.equalsIgnoreCase("Does Not Support")||sCategory.equalsIgnoreCase("Both")) {
					
					sSupportICD10Code= getSupportICD10Code(sID,"Article","");					
					if(!sSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article",false);
					    }			

					//Retrieve the ICDGroup based on the ICDCode
					sSuppportICDGroup= getSupportICDGroup(sID,"Article",sSupportICD10Code,"");
					if(!sSuppportICDGroup.isEmpty())
					{
						logger.info("DBQuery executed and the ICDGroup retrieved::" + sSuppportICDGroup);
						Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::" + sSuppportICDGroup, true);
					} else {
						logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article ");
						Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article",false);
					}
				 
					raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory,sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				}

				if (sCategory.equalsIgnoreCase("Support")) {
					
					// Call SQL query to retrieve ICD code only available in  DoesNotSupport Tab for the Article
					sDontSupportICD10Code=getDontSupportICD10Code(sID,"Article","");					
					if(!sDontSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table for Article");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table for Article",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario for Article"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario for Article",false);
					    }		
					

					//Retrieve the ICDGroup based on the ICDCode
					sDontSuppportICDGroup= getDontSupportICDGroup(sID,"Article",sDontSupportICD10Code,"");
					if (!sDontSuppportICDGroup.isEmpty()) {
						logger.info("DBQuery executed and the ICDGroup retrieved::" + sDontSuppportICDGroup);
						Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::" + sDontSuppportICDGroup, true);
					} else {
						logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table for Article");
						Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table for Article",false);
					}			
					
					raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory,sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				}

				if (sCategory.equalsIgnoreCase("Support-ValidCodes")) {					
					 sCategory = "Support";		
					 Serenity.setSessionVariable("Category Type").to(sCategory);
					 
						sSupportICD10Code= getSupportICD10Code(sID,"Article","");						
						if(!sSupportICD10Code.isEmpty())
						{
						  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article");
						  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article",true);
						}
						else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article"); 
						      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article",false);
						    }			

						//Retrieve the ICDGroup based on the ICDCode
						sSuppportICDGroup= getSupportICDGroup(sID,"Article",sSupportICD10Code,"");						
						if(!sSuppportICDGroup.isEmpty())
						{
							logger.info("DBQuery executed and the ICDGroup retrieved::" + sSuppportICDGroup);
							Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::" + sSuppportICDGroup, true);
						} else {
							logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article ");
							Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article",false);
						}					 
					      raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				}
				
				if (sCategory.equalsIgnoreCase("Support-ValidCodes-InvalidICDGroup")) {					
					 sCategory = "Support";		
					 int iSupportICDGroup= Integer.parseInt(sSuppportICDGroup)+15;
					 sSuppportICDGroup =String.valueOf(iSupportICDGroup);
				 
				    sSupportICD10Code= getSupportICD10Code(sID,"Article","");						
					if(!sSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article",false);
					    }			
					 
					 raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				}
				
				if (sCategory.equalsIgnoreCase("DoesNotSupport-ValidCodes-InvalidICDGroup")) {
					
					 sCategory = "Does Not Support";
					 int iDontSupportICDGroup= Integer.parseInt(sDontSuppportICDGroup)+15;
					 sDontSuppportICDGroup =String.valueOf(iDontSupportICDGroup);
					 
					    sDontSupportICD10Code=getDontSupportICD10Code(sID,"Article","");						
						if(!sDontSupportICD10Code.isEmpty())
						{
						  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table for Article");
						  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table for Article",true);
						}
						else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario for Article"); 
						      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario for Article",false);
						    }		
					 
					 raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				}
				
				
				if (sCategory.equalsIgnoreCase("BothCategories-InvalidICDGroup")) {					
					 sCategory = "Both";
					 
					 String sLCDArticleID= Serenity.sessionVariableCalled("Article_ID");
					 
					 //Retrieve ICDCode which is in both the Support and DoesNotSupport tabs				 	
					 String sSupportICD10Query = "Select * from (select icd10_code from LCD.ART_CPT_ICD_SPRT_DELTA where art_id ="+sLCDArticleID
					 								 +" intersect"+ 
					 								 " Select icd10_code from LCD.ART_CPT_ICD_DONTSPRT_DELTA where art_id ="+sLCDArticleID+") where rownum=1";
					sSupportICD10Code = DBUtils.executeSQLQuery(sSupportICD10Query);				
					logger.info("Base ICD Code which is available in both Support and DoesNotSupport tabs is retrieved:" + sSupportICD10Code);
	   
					 //Retrieve ICDCode for ICDGroup					
					 String sSupportICD10GroupQuery = "Select * from (Select ICD10_Group from LCD.ART_CPT_ICD_SPRT_DELTA where  art_id ="+ sLCDArticleID +" and ICD10_code="+"'"+sSupportICD10Code+"'"+") where rownum=1";
					 String sSupportICD10Group = DBUtils.executeSQLQuery(sSupportICD10GroupQuery);					
					 
					 int iSupportICDGroup= Integer.parseInt(sSupportICD10Group)+15;
					 sSuppportICDGroup =String.valueOf(iSupportICDGroup);
					 raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				}
				
				
				if (sCategory.equalsIgnoreCase("DoesNotSupport-ValidCodes")) {					
					 sCategory = "Does Not Support";		
					 
					    sDontSupportICD10Code= getDontSupportICD10Code(sID,"Article","");						
						if(!sDontSupportICD10Code.isEmpty())
						{
						  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article");
						  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article",true);
						}
						else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article"); 
						      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article",false);
						    }			

						//Retrieve the ICDGroup based on the ICDCode
						sDontSuppportICDGroup= getDontSupportICDGroup(sID,"Article",sDontSupportICD10Code,"");
						if(!sDontSuppportICDGroup.isEmpty())
						{
							logger.info("DBQuery executed and the ICDGroup retrieved::" + sDontSuppportICDGroup);
							Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::" + sDontSuppportICDGroup, true);
						} else {
							logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article ");
							Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article",false);
						}
					 
					 raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				}
				
				if (sCategory.equalsIgnoreCase("DoesNotSupportOnly-ValidCodes")) {				
					 sCategory = "Does Not Support";
					 
					    sDontSupportICD10Code=getDontSupportICD10Code(sID,"Article","");						
						if(!sDontSupportICD10Code.isEmpty())
						{
						  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table for Article");
						  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table for Article",true);
						}
						else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario for Article"); 
						      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario for Article",false);
						    }								

						//Retrieve the ICDGroup based on the ICDCode
						sDontSuppportICDGroup= getDontSupportICDGroup(sID,"Article",sDontSupportICD10Code,"");
						if (!sDontSuppportICDGroup.isEmpty()) {
							logger.info("DBQuery executed and the ICDGroup retrieved::" + sDontSuppportICDGroup);
							Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::" + sDontSuppportICDGroup, true);
						} else {
							logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table for Article");
							Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table for Article",false);
						}				 
					 
					 raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				}	
				 
				if (sCategory.equalsIgnoreCase("Support-MultipleValidCodes")) {					
					 sCategory = "Support";	
					 
					 sSupportICD10Code= getSupportICD10Code(sID,"Article","");						
						if(!sSupportICD10Code.isEmpty())
						{
						  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article");
						  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article",true);
						}
						else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article"); 
						      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article",false);
						    }			

						//Retrieve the ICDGroup based on the ICDCode
						sSuppportICDGroup= getSupportICDGroup(sID,"Article",sSupportICD10Code,"");
						if(!sSuppportICDGroup.isEmpty())
						{
							logger.info("DBQuery executed and the ICDGroup retrieved::" + sSuppportICDGroup);
							Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::" + sSuppportICDGroup, true);
						} else {
							logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article ");
							Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article",false);
						}		 
					 
					       raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				}				 
			 
				if (sCategory.equalsIgnoreCase("Validate_RadioButton_Assosiate")) {					
					 sCategory = "Support";			
					 
					 sSupportICD10Code= getSupportICD10Code(sID,"Article","");						
						if(!sSupportICD10Code.isEmpty())
						{
						  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article");
						  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article",true);
						}
						else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article"); 
						      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article",false);
						    }			

						//Retrieve the ICDGroup based on the ICDCode
						sSuppportICDGroup= getSupportICDGroup(sID,"Article",sSupportICD10Code,"");
						if(!sSuppportICDGroup.isEmpty())
						{
							logger.info("DBQuery executed and the ICDGroup retrieved::" + sSuppportICDGroup);
							Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::" + sSuppportICDGroup, true);
						} else {
							logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article ");
							Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article",false);
						}					 
					     raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory,sNewICD10Code,iNewICDCodeCount,"");
				}	
				
				if (sCategory.equalsIgnoreCase("Validate_RadioButton_Manually")) {					
					 sCategory = "Support";				
					 raEntersAddCodeCombinationDetails("", sSuppportICDGroup, sCategory,sNewICD10Code,iNewICDCodeCount,"");
				}	
				if (sCategory.equalsIgnoreCase("DoesNotSupport")) {					
					sCategory = "Does Not Support";
					
					sDontSupportICD10Code=getDontSupportICD10Code(sID,"Article","");					
					if(!sDontSupportICD10Code.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table for Article");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table for Article",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario for Article"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario for Article",false);
					    }		
					

					//Retrieve the ICDGroup based on the ICDCode
					sDontSuppportICDGroup= getDontSupportICDGroup(sID,"Article",sDontSupportICD10Code,"");
					if (!sDontSuppportICDGroup.isEmpty()) {
						logger.info("DBQuery executed and the ICDGroup retrieved::" + sDontSuppportICDGroup);
						Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::" + sDontSuppportICDGroup, true);
					} else {
						logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table for Article");
						Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table for Article",false);
					}					
					raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				}
				
				if (sCategory.equalsIgnoreCase("Support_Both_Categories")) {					
					sCategory = "Both";
					
					//BaseICDCode for both categories
					sSupportICD10CodeBoth= getSupportICD10CodeBoth(sID,"Article","");			
					if(!sSupportICD10CodeBoth.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10CodeBoth+" which is the code available in Support Delta table and in DontSupport Delta Table");
					  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10CodeBoth+" which is the code available in Support Delta table and  in DontSupport Delta Table",true);
					}
					else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario"); 
					      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario",false);
					    }							

					//ICDGroup based on the ICDCode for both categories 
					sSuppportICDGroupBoth= getSupportICDGroupBoth(sID,"Article",sSupportICD10CodeBoth,"");				
					if(!sSuppportICDGroupBoth.isEmpty())
					{
					  logger.info("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroupBoth);
					  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroupBoth,true);
					}
					else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table "); 
					      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table",false);
				    }		
					
					raEntersAddCodeCombinationDetails(sSupportICD10CodeBoth, sSuppportICDGroupBoth, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
				}
			 break;	
			 
		 default:  logger.info("No input is provided for the Switch Case");		  							
		  		   Assert.assertTrue("Provided invalid Switch Case value",false);	 
			 
			 
		 }
	
	}
					
		@Step
	public void raEntersAddCodeCombinationDetails(String sBaseICDCode,String sICDGroup,String sCategory,String sNewICdCode,int sNewICDCodeCount,String sNewICD10Code2)
		 {		
					 
			  //Enter the values in the Form				  
			  if(!(sBaseICDCode.equalsIgnoreCase(""))){
					oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sBaseICDCodeTxt,sBaseICDCode);
					logger.info("RA entered Base ICD Code as '"+sBaseICDCode);
					
				}else{
					logger.info("Base ICD Code value is empty");
				}
				
				if(!(sICDGroup.equalsIgnoreCase(""))){
					oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sICDGroupTxt, sICDGroup);
					logger.info("RA entered ICD Group as '"+sICDGroup);
					
				}else{
					logger.info("ICD Group value is empty");
				}						
				
				 //Select the Category
				  if(!(sCategory.equalsIgnoreCase(""))){	
						oSeleniumUtils.select_Given_Value_From_DropDown(oRAPage.sCategoryDropDown,sCategory);
						logger.info("RA selected category drop down value as '"+sCategory);					
						
					}else{
						logger.info("Category value is empty");
					}	
				  
				  if(sNewICDCodeCount==1)
				  {						
						if(!(sNewICdCode.equalsIgnoreCase(""))){
							Serenity.setSessionVariable("NewICDCode").to(sNewICdCode);
							oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sICDCodeTxt, sNewICdCode);
							logger.info("RA entered new ICD code as '"+sNewICdCode);
						}else{
							oSeleniumUtils.clear_Text(oRAPage.sICDCodeTxt);
							logger.info("ICD Code value is empty");
						 }				
						
						
				  }//End of If
				  
				  if(sNewICDCodeCount==2)
				  {								  
					    //Click on "Add New ICD Code" button					  
					    oSeleniumUtils.Click_given_Locator(oRAPage.sAddNewICDButton);
						logger.info("Time RA Successfully clicked on Add New ICD Button");
					  
					  if(!(sNewICD10Code2.equalsIgnoreCase(""))){						   
							oSeleniumUtils.enter_given_text_StringLocator("("+oRAPage.sICDCodeTxt+")["+sNewICDCodeCount+"]", sNewICD10Code2);
							logger.info("RA entered new ICD code2 as '"+sNewICD10Code2);
						}else{
							oSeleniumUtils.clear_Text(oRAPage.sICDCodeTxt);
							logger.info("ICD Code value is empty");
						 }					  
				 
				  }				  
				
	     }

	@Step
	public void RAEntersCodeCombinations(String sNewICDCodesCount, String sCategory, String sLCD_Article) {
			
			  String sID="";
			  String sSupportICD10Code="";
			  String sSuppportICDGroup="";
			  String sNewICD10Code ="";
			  String sDontSupportICD10Code="";
			  String sDontSuppportICDGroup="";
			  String sNewICD10Code2="";
			  int iNewICDCodeCount=0;
			 
			  
		if (sLCD_Article.equalsIgnoreCase("LCD")) {
			
			sID = Serenity.sessionVariableCalled("LCD_ID");
			 
			//Retrieve the ICDCode based on the LCDID
		    sSupportICD10Code= getSupportICD10Code(sID,"LCD","");
		    
			if(!sSupportICD10Code.isEmpty())
			{
			  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table");
			  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table",true);
			}
			else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario"); 
			      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario",false);
			    }			
			
			//Retrieve the ICDGroup based on the ICDCode
			sSuppportICDGroup= getSupportICDGroup(sID,"LCD",sSupportICD10Code,"");	
			
			if(!sSuppportICDGroup.isEmpty())
			{
			  logger.info("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup);
			  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sSuppportICDGroup,true);
			}
			else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table "); 
			      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table",false);
			    }						
			

			//Data from DoesNotSupport Table
			sDontSupportICD10Code=getDontSupportICD10Code(sID,"LCD","");
			
			if(!sDontSupportICD10Code.isEmpty())
			{
			  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table");
			  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table",true);
			}
			else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario"); 
			      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario",false);
			    }				

			    //Retrieve the ICDGroup based on the ICDCode		
			    sDontSuppportICDGroup= getDontSupportICDGroup(sID,"LCD",sDontSupportICD10Code,"");
			    
				if(!sDontSuppportICDGroup.isEmpty())
				{
				  logger.info("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup);
				  Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::"+sDontSuppportICDGroup,true);
				}
				else{ logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table"); 
				      Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table",false);
				    }
				 
			 }
		
		else if (sLCD_Article.equalsIgnoreCase("Article")) {
			
			sID = Serenity.sessionVariableCalled("Article_ID");

			//Article Queries

			//Support Tab - Retrieve the ICDCode based on the LCDID
			sSupportICD10Code= getSupportICD10Code(sID,"Article",""); 
			
			if(!sSupportICD10Code.isEmpty())
			{
			  logger.info("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article");
			  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sSupportICD10Code+" which is the code available in Support Delta table and not available in DontSupport Delta Table for Article",true);
			}
			else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article"); 
			      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in Support Delta table and not available in DontSupport Delta Table which is required for the scenario for Article",false);
			    }		
			

			//Retrieve the ICDGroup based on the ICDCode
			sSuppportICDGroup= getSupportICDGroup(sID,"Article",sSupportICD10Code,"");	 
			
			if(!sSuppportICDGroup.isEmpty())
			{
				logger.info("DBQuery executed and the ICDGroup retrieved::" + sSuppportICDGroup);
				Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::" + sSuppportICDGroup, true);
			} else {
				logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article ");
				Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in Support Delta Table for Article",false);
			}			
			

			//Does Not Support Tab

			//Call SQL query to retrieve ICD code only available in DoesNotSupport Tab for the Article
			sDontSupportICD10Code=getDontSupportICD10Code(sID,"Article",""); 

			if(!sDontSupportICD10Code.isEmpty())
			{
			  logger.info("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table for Article");
			  Assert.assertTrue("DBQuery executed and the ICDCode retrieved::"+sDontSupportICD10Code+" which is the code available in DoesNotSupport Delta table and not available in Support Delta Table for Article",true);
			}
			else{ logger.error("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario for Article"); 
			      Assert.assertTrue("DBQuery executed and there is No ICD10Code which is only available in DoesNotSupport Delta table and not available in Support Delta Table which is required for the scenario for Article",false);
			    }	
			
			
			//Retrieve the ICDGroup based on the ICDCode
			sDontSuppportICDGroup= getDontSupportICDGroup(sID,"Article",sDontSupportICD10Code,"");
			
			if (!sDontSuppportICDGroup.isEmpty()) {
						logger.info("DBQuery executed and the ICDGroup retrieved::" + sDontSuppportICDGroup);
						Assert.assertTrue("DBQuery executed and the ICDGroup retrieved::" + sDontSuppportICDGroup, true);
					} else {
						logger.error("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table for Article");
						Assert.assertTrue("DBQuery executed and there is No ICDGroup for the ICDCode in DoesNotSupport Delta Table for Article",false);
					}			

		}
		
		//Convert ICDCodeCount from String to integer if it is Not empty
		if (!sNewICDCodesCount.isEmpty()) {
			//Convert the no of ICDCodes to add from String to Integer
			iNewICDCodeCount = Integer.parseInt(sNewICDCodesCount);
		 }

		// Retrieve New ICD10_Code from ICD10_manual table
		sNewICD10Code = getNewICDCodes("NewICDCodeOne","");
		
		if (!sNewICD10Code.isEmpty()) {
			logger.info("New ICD10 Code to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table::" + sNewICD10Code);
			Assert.assertTrue("New ICD10 Code to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table", true);
		} else {
			logger.error("New ICD10 Code to enter for creating Manual CodeCombination is Not retrieved from MDM.ICD10_MANUAL Table");
			Assert.assertTrue("New ICD10 Code to enter for creating Manual CodeCombination is Not available MDM.ICD10_MANUAL Table",false);
		}

		//Retrieve New ICD10_Code 2 from ICD10_manual table
		sNewICD10Code2 = getNewICDCodes("NewICDCodeTwo","");
		
		if (!sNewICD10Code2.isEmpty()) {
			logger.info("New ICD10 Code-2 to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table::" + sNewICD10Code);
			Assert.assertTrue("New ICD10-2 Code to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table", true);
		} else {
			logger.error("New ICD10 Code-2 to enter for creating Manual CodeCombination is Not retrieved from MDM.ICD10_MANUAL Table");
			Assert.assertTrue("New ICD10-2 Code to enter for creating Manual CodeCombination is Not available MDM.ICD10_MANUAL Table",false);
		}		
		
		//Convert Category to Upper case for use in Switch Statement below
		sCategory =  sCategory.toUpperCase();				

		 switch(sCategory)
		 {
		 
		  case "SUPPORT-SINGLECODES":					
					
					 sCategory = "Support";				
					 raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
					 
					//Click on Save button to save the Code Combinations
					 oSeleniumUtils.Click_given_Locator(oRAPage.SaveButton);
					 logger.info("Save button is clicked successfully.");
					 					 					 
					 //Validate the Alert Message
					 ValidateAlertMessage("Code combination(s) are created successfully.");					 
					 
					 //Click on close button					 
					 oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_sAddCombination_CloseBtn);					 
					 SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
					 logger.info("Add Code Combination button is clicked successfully.");
	 					 			 			 
					 //Click on "Add code combination button again
					 oSeleniumUtils.Click_given_WebElement(oRAPage.RAReviewManually_Created_Combination_Btn);		
					 logger.info("RA Successfully clicked on the Add Manually Create Combination Button");	
					 SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
					 
					 //Enter the codes again
					 raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);			 
					 
					break;
				
			
		  case "SUPPORT-MULTIPLEVALIDCODES":				
					
					 sCategory = "Support";				
					 raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,1,sNewICD10Code2);
					 
					 //Click on Save button to save the Code Combinations
					 oSeleniumUtils.Click_given_Locator(oRAPage.SaveButton);
					 logger.info("Save button is clicked successfully.");
					 
					 //Validate the Alert Message
					 ValidateAlertMessage("Code combination(s) are created successfully.");					 
					 
					  //Click on close button					 
					  oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_sAddCombination_CloseBtn);
					  logger.info("Add Code Combination button is clicked successfully.");
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			 			 
					  //click on "Add code combination button again
					  oSeleniumUtils.Click_given_WebElement(oRAPage.RAReviewManually_Created_Combination_Btn);		
					  logger.info("RA Successfully clicked on the Add Manually Create Combination Button");
					  SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
					 
					 //Enter the codes again
					 raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,1,"");
					 raEntersAddCodeCombinationDetails("","","","",iNewICDCodeCount,sNewICD10Code2);					 
			
				break;
				
				
		  case "DOESNOTSUPPORT-SINGLECODES":		
				
					
					 sCategory = "Does Not Support";				
					 raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);
					 
					//Click on Save button to save the Code Combinations
					 oSeleniumUtils.Click_given_Locator(oRAPage.SaveButton);
					 logger.info("Save button is clicked successfully.");
					 					 					 
					 //Validate the Alert Message
					 ValidateAlertMessage("Code combination(s) are created successfully.");						 
					 
					 //Click on close button					 
					 oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_sAddCombination_CloseBtn);
					 logger.info("AddCodeCombination Close button is clicked successfully.");
					 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			 			 
					 //Click on "Add code combination button again
					 oSeleniumUtils.Click_given_WebElement(oRAPage.RAReviewManually_Created_Combination_Btn);		
					 logger.info("RA Successfully clicked on the Add Manually Create Combination Button");	
					 
					 //Enter the codes again
					 raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,iNewICDCodeCount,sNewICD10Code2);			 
					 
				  break;
				  
		  case "DOESNOTSUPPORT-MULTIPLEVALIDCODES":	  				
					
					 sCategory = "Does Not Support";				
					 raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,1,sNewICD10Code2);
					 
					 //Click on Save button to save the Code Combinations
					 oSeleniumUtils.Click_given_Locator(oRAPage.SaveButton);
					 logger.info("Save button is clicked successfully.");
					 
					 //Validate the Alert Message
					 ValidateAlertMessage("Code combination(s) are created successfully.");						 
					 
					  //Click on close button					 
					  oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_sAddCombination_CloseBtn);
					  logger.info("AddCodeCombination Close button is clicked successfully.");
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			 			 
					  //click on "Add code combination button again
					  oSeleniumUtils.Click_given_WebElement(oRAPage.RAReviewManually_Created_Combination_Btn);		
					  logger.info("RA Successfully clicked on the Add Manually Create Combination Button");	
					 
					 //Enter the codes again
					 raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,1,"");
					 raEntersAddCodeCombinationDetails("","","","",iNewICDCodeCount,sNewICD10Code2);					 
				break;
					 
		  case "ADDMULTIPLEVALIDCODES_SUPPORT_DONTSUPPORT":
				
					
					 sCategory = "Support";				
					 raEntersAddCodeCombinationDetails(sSupportICD10Code, sSuppportICDGroup, sCategory, sNewICD10Code,1,"");
					 
					 raEntersAddCodeCombinationDetails("", "", "", "",iNewICDCodeCount,sNewICD10Code2);
					 
					 //Click on Save button to save the Code Combinations
					 oSeleniumUtils.Click_given_Locator(oRAPage.SaveButton);
					 logger.info("Save button is clicked successfully.");
					 
					 //Validate the Alert Message
					 ValidateAlertMessage("Code combination(s) are created successfully.");					 
					 
					 //Click on close button					 
					  oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_sAddCombination_CloseBtn);
					  logger.info("AddCodeCombination Close button is clicked successfully.");
					  
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			 			 
					 //click on "Add code combination button again
					  oSeleniumUtils.Click_given_WebElement(oRAPage.RAReviewManually_Created_Combination_Btn);		
					  logger.info("RA Successfully clicked on the Add Manually Create Combination Button");					 
					 
					 sCategory = "Does Not Support";	
					 raEntersAddCodeCombinationDetails(sDontSupportICD10Code, sDontSuppportICDGroup, sCategory, sNewICD10Code,1,"");
					 
					 raEntersAddCodeCombinationDetails("", "", "", "",iNewICDCodeCount,sNewICD10Code2);	
				
			break;		
			
			default: logger.info("No scenario value specified in the Gherkin TestData"); 
					 Assert.assertTrue("Provided invalid case value",false);	
			
		 }			
			
			
		}

	@Step
	public void raClaimsCodeWithMultipleWeeksTasks(String sLCDArticle) {
			
		      String sID="";
		      String IDName="";	
		
		if(sLCDArticle.equalsIgnoreCase("LCD"))
		 {			
			 sID= DBUtils.executeSQLQuery(DBQueries.MultipleWeek_LCDID_Query);			     
		     Serenity.setSessionVariable("LCD_ID").to(sID);	
		     Serenity.setSessionVariable("ID").to(sID);	
		     IDName="LCD";
		  }
		else{			
			  sID = DBUtils.executeSQLQuery(DBQueries.MultipleWeek_Article_Query);	
			  Serenity.setSessionVariable("Article_ID").to(sID);
			  Serenity.setSessionVariable("ID").to(sID);	
			  IDName="Article";
		    }
		
		
		if(!sID.equals("")){			
			
			logger.info(IDName+" ID is retrieved from DB:"+sID);
			
			oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,sID);
			logger.info(IDName+" ID entered in the TextBox :"+sID);
			
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
			oSeleniumUtils.is_WebElement_Displayed(oHomePage.ID_Checkbox);		
			
			//Selecting week task as per ascending order if 2 different weeks
			oRAPage.selectingWeekTask();
			logger.info("Clicked on the ID CheckBox");
			
			oSeleniumUtils.Click_given_WebElement(oHomePage.ClaimTask_Btn);
			logger.info("Clicked on the ClaimTask Button for the ID");
			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			
						
				
		}else{
			  logger.error("There is no "+ IDName +" ids who has multiple weeks tasks");
			  Assert.assertTrue("There is no "+ IDName +" ids who has multiple weeks tasks.",false);
		     }
	}
         			
	@Step
    public void raCompletesRAReview() {       
                      
          oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading); 
          
          //Click on Support Tab
          oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Support"));
          
          //Select Pagination value 2000
          oSeleniumUtils.select_Given_Value_From_DropDown(oRAPage.RAPage_PaginatorSelect, "2000");
          oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading); 
          
          
          oSeleniumUtils.Click_given_Locator(oRAPage.sGridCheckBox);
          //Take Accept decisions
          oSeleniumUtils.Click_given_WebElement(oRAPage.Accept_Btn);
          oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);    
          
//          //Handling alert pop up on if we are changing existing decisions from Accept to Reject and ViceVersa       
//          String sMsgTxt =  oSeleniumUtils.get_TextFrom_Locator(oHomePage.sAlertPopupMsg);
//          if (sMsgTxt.contains("Selected records already have decisions on them"))
//          {        	  
//        	  oSeleniumUtils.Click_given_Locator(oHomePage.sAlertPopupOKYes);
//        	  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);          
//          } 
                      
          
          //Keep checking "All rows" check box till "Next Page" button is Disabled            
          while (!oSeleniumUtils.is_WebElement_Displayed(oRAPage.RAPage_NextPageButtonDisabled))
          {
                oSeleniumUtils.Click_given_Locator(oRAPage.sGridCheckBox);
                //Take Accept decisions
                oSeleniumUtils.Click_given_WebElement(oRAPage.Accept_Btn);
                oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_NextPageButton);
                oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);                 
          }           
          
          //Click on DoesNotSupportTab
          oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Does"));
          oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading); 
                      
          //Select Pagination value 2000
          oSeleniumUtils.select_Given_Value_From_DropDown(oRAPage.RAPage_PaginatorSelect, "2000");
          oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading); 
          
          oSeleniumUtils.Click_given_Locator(oRAPage.sGridCheckBox);
           
          //Take Reject decisions
          if(oRAPage.Reject_Btn.isEnabled())
          {
	          oSeleniumUtils.Click_given_WebElement(oRAPage.Reject_Btn);
	          oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	          
	          //check whether "Select Reason" drop down  is displayed        
	           oSeleniumUtils.is_WebElement_Displayed(oRAPage.SelectReasonCmb);
	
			  //Click on Drop down arrow icon
			  oSeleniumUtils.Click_given_WebElement(oRAPage.SelectReasonArrowIcon);
			 SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
	          
			  //Select reason from Drop down
			 if(!oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oHomePage.SpanText, "sValue", "Non-configurable-Frequency"))){
				 oSeleniumUtils.Click_given_WebElement(oRAPage.SelectReasonArrowIcon);
				 SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			 }
	          oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue", "Non-configurable-Frequency"));
	
			  //Click on Apply button
			  oSeleniumUtils.Click_given_Locator(oRAPage.Apply);
			  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);          
                
			          
			          //Keep checking "All rows" check box till "Next Page" button is enabled
			          while (!oSeleniumUtils.is_WebElement_Displayed(oRAPage.RAPage_NextPageButtonDisabled))
			          {
			        	    //Click on Grid Check box to select all records on the page
			                oSeleniumUtils.Click_given_Locator(oRAPage.sGridCheckBox);
			                
			                //Take Reject decisions
			                oSeleniumUtils.Click_given_WebElement(oRAPage.Reject_Btn);
			                
			                //Click on Next button to navigate to next page
			                oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_NextPageButton);   
			                oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading); 
			                
			                //Take Reject decisions
			                oSeleniumUtils.Click_given_WebElement(oRAPage.Reject_Btn);
			                oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			                
			                //check whether "Select Reason" drop down  is displayed        
			                 oSeleniumUtils.is_WebElement_Displayed(oRAPage.SelectReasonCmb);
			
			      		   //Click on Drop down arrow icon
			      		   oSeleniumUtils.Click_given_WebElement(oRAPage.SelectReasonArrowIcon);
			      			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			                
			      		   //Select reason from Drop down
			               oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue", "Non-configurable-Frequency"));
			
			      		   //Click on Apply button
			      		   oSeleniumUtils.Click_given_Locator(oRAPage.Apply);
			      		   oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);  
			                
			          }     
          }           
	          //Click on Complete RA Review
	          oSeleniumUtils.Click_given_WebElement(oRAPage.CompleteRAReview_Btn);
	          oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
	          
	          //Validating the Message after CompleteRAReview
		        boolean bStatus = false;
		        String sExpectedAlertMsg = "Review process is completed";
				bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAPage.RAPage_sAlertPopup);
				if(bStatus){
					logger.info("Alert Popup is displayed.");
					String sActualAlertMsg = oSeleniumUtils.get_TextFrom_Locator(oHomePage.sAlertPopupMsg);
					System.out.println("Actual AlertMsg:: "+sActualAlertMsg);
					
					if(sExpectedAlertMsg.equalsIgnoreCase(sActualAlertMsg)){
						logger.info("Actual Alert Msg:: '"+sActualAlertMsg+"' is equal with Expected Alert Msg::  '"+sExpectedAlertMsg+"'");
						Assert.assertTrue("Actual and expected alert messages are equal.",true);				
					}else{
						logger.info("Actual Alert Msg '"+sActualAlertMsg+"' is not equal with Expected Alert Msg::  '"+sExpectedAlertMsg+"'");
						Assert.assertTrue("Actual:: "+sActualAlertMsg+" and expected "+sExpectedAlertMsg+" alert messages are not equal.",false);
						logger.info("Review Proces is not completed");
					}         
				}	          
				  oSeleniumUtils.Click_given_Locator(oHomePage.sAlertPopupOKBtn);
				  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);			  
	       }
    
	@Step
	public void raClaimsSecondWeekTask(String sLCDArticle) {

		 String sID="";
	     String IDName="";
	
		if (sLCDArticle.equalsIgnoreCase("LCD")) {
			sID = Serenity.sessionVariableCalled("LCD_ID");
			IDName = "LCD";
		} else {
			sID = Serenity.sessionVariableCalled("Article_ID");
			IDName = "Article";
		}
	     
	if(!sID.equals("")){	

	logger.info(IDName+" ID is retrieved from DB:"+sID);
		
	oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,sID);
	logger.info(IDName+" ID entered in the TextBox :"+sID);
	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		
		oRAPage.selectingWeekTask();  //Sort the Next week Task by clicking on the "TaskAssigned week" column
		SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
	
	//oSeleniumUtils.is_WebElement_Displayed(oHomePage.ID_Checkbox);
		
	//oSeleniumUtils.Click_given_WebElement(oHomePage.ID_Checkbox);
	logger.info("Clicked on the ID CheckBox");
		
		oSeleniumUtils.Click_given_WebElement(oHomePage.ClaimTask_Btn);
		logger.info("Clicked on the ClaimTask Button for the ID");
		SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			
	}else{
		  logger.error("There is no "+ IDName +" ids who has multiple weeks tasks");
		  Assert.assertTrue("There is no "+ IDName +" ids who has multiple weeks tasks.",false);
	     }		
   }
			
	@Step
	public void raClicksSecondweekTaskID(String sLCDArticle)
	{

		String sID="";
		String sIDName="";
		
		if (sLCDArticle.equalsIgnoreCase("LCD")) {
			sID = Serenity.sessionVariableCalled("LCD_ID");
			sIDName="LCD";
		}
		else {
			  sID = Serenity.sessionVariableCalled("Article_ID");
			  sIDName="Article";
		     }		
		
	   //Enter value in the ID field	
	   oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oHomePage.CPTICDLinkTaskTblColumnTxt,"sColumnName","ID"),sID);
	   logger.info(sIDName + " ID entered in the TextBox:"+sID);
	   SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);	  	  
	   	  
	   oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oHomePage.AnchorTags,"sValue",sID));
	   SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
	  	  
	   //Click on the Filtered ID Value	  
	   oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags,"sValue",sID));
	 //Wait for sometime
      oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
	   logger.info("Clicked on the given "+ sIDName+": "+sID); 
		
	}
   
	@Step
	public void raClosesPopup() {
		
		oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_sAddCombination_CloseBtn);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
		logger.info("Alert Popup is closed");		
	}
	
	@Step
	public void RAEntersSubsequentTaskCodeCombinations(String sNewICDCodesCount,String sCategory,String sLCD_Article) {

		  String sID="";		 
		  String sNewICD10Code2="";
		  int sNewICDCodeCount=0;
		  String sNewICD10Code="";
		  
		  
		if (sLCD_Article.equalsIgnoreCase("LCD")) {

			sID = Serenity.sessionVariableCalled("LCD_ID");
			logger.info("LCDID retrieved from Session variable and stored for further process::" + sID);
		}

		else if (sLCD_Article.equalsIgnoreCase("Article")) {

			sID = Serenity.sessionVariableCalled("Article_ID");
			logger.info("ArticleID retrieved from Session variable and stored for further process::" + sID);

		}

		// Convert String to Integer if it is not empty
		if (!sNewICDCodesCount.isEmpty()) {
			// Convert the no of ICDCodes to add from String to Integer
			sNewICDCodeCount = Integer.parseInt(sNewICDCodesCount);
		}
	
		//Retrieve New ICD10_Code from ICD10_manual table
		sNewICD10Code= getNewICDCodes("NewICDCodeOne","");
		
		if (!sNewICD10Code.isEmpty()) {
			logger.info("New ICD10 Code to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table::" + sNewICD10Code);
			Assert.assertTrue("New ICD10 Code to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table", true);
		} else {
			logger.error("New ICD10 Code to enter for creating Manual CodeCombination is Not retrieved from MDM.ICD10_MANUAL Table");
			Assert.assertTrue("New ICD10 Code to enter for creating Manual CodeCombination is Not available MDM.ICD10_MANUAL Table",false);
		}
		
		//Retrieve New ICD10_Code 2 from ICD10_manual table				
		sNewICD10Code2= getNewICDCodes("NewICDCodeTwo","");
		
		if (!sNewICD10Code2.isEmpty()) {
			logger.info("New ICD10 Code-2 to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table::" + sNewICD10Code2);
			Assert.assertTrue("New ICD10-2 Code to enter for creating Manual CodeCombination is retrieved from MDM.ICD10_MANUAL Table", true);
		} else {
			logger.error("New ICD10 Code-2 to enter for creating Manual CodeCombination is Not retrieved from MDM.ICD10_MANUAL Table");
			Assert.assertTrue("New ICD10-2 Code to enter for creating Manual CodeCombination is Not available MDM.ICD10_MANUAL Table",false);
		}		
		 
		switch (sLCD_Article) {

		case "LCD":

			if (sCategory.equalsIgnoreCase("Subsequent_SupportSingle")) {
				sCategory = "Support";
				raEntersAddCodeCombinationDetails(Serenity.sessionVariableCalled("SupportICD10Code"),Serenity.sessionVariableCalled("SupportICD10Group"), sCategory, sNewICD10Code, sNewICDCodeCount,sNewICD10Code2);
			}

			if (sCategory.equalsIgnoreCase("Subsequent_SupportMultiple")) {
				sCategory = "Support";
				raEntersAddCodeCombinationDetails(Serenity.sessionVariableCalled("SupportICD10Code"),Serenity.sessionVariableCalled("SupportICD10Group"), sCategory, sNewICD10Code, 1,"");
				raEntersAddCodeCombinationDetails("","", "", sNewICD10Code, sNewICDCodeCount,sNewICD10Code2);
			}
			
			if (sCategory.equalsIgnoreCase("DoesNotSupportOnly-SubsequentValidCodes")) {
				
				 sCategory = "Does Not Support";
				 raEntersAddCodeCombinationDetails(Serenity.sessionVariableCalled("ICD Code Doesn't"),Serenity.sessionVariableCalled("ICD Group Doesn't"), sCategory, sNewICD10Code,sNewICDCodeCount,sNewICD10Code2);

			}
			
			if (sCategory.equalsIgnoreCase("SubsequentValidCodes-Both")) {
				
				 sCategory = "Both";
				 raEntersAddCodeCombinationDetails(Serenity.sessionVariableCalled("ICD Code Doesn't"),Serenity.sessionVariableCalled("ICD Group Doesn't"), sCategory, sNewICD10Code,sNewICDCodeCount,sNewICD10Code2);

			}

			break;

		case "Article":

			if (sCategory.equalsIgnoreCase("Subsequent_SupportSingle")) {
				sCategory = "Support";
				raEntersAddCodeCombinationDetails(Serenity.sessionVariableCalled("SupportICD10Code"),Serenity.sessionVariableCalled("SupportICD10Group"), sCategory, sNewICD10Code, sNewICDCodeCount,sNewICD10Code2);
			}

			if (sCategory.equalsIgnoreCase("Subsequent_SupportMultiple")) {
				sCategory = "Support";
				raEntersAddCodeCombinationDetails(Serenity.sessionVariableCalled("SupportICD10Code"),Serenity.sessionVariableCalled("SupportICD10Group"), sCategory, sNewICD10Code, 1,"");
				raEntersAddCodeCombinationDetails("","", "", sNewICD10Code, sNewICDCodeCount,sNewICD10Code2);
			}
			
			if (sCategory.equalsIgnoreCase("DoesNotSupportOnly-SubsequentValidCodes")) {
				
				 sCategory = "Does Not Support";
				 raEntersAddCodeCombinationDetails(Serenity.sessionVariableCalled("ICD Code Doesn't"),Serenity.sessionVariableCalled("ICD Group Doesn't"), sCategory, sNewICD10Code,sNewICDCodeCount,sNewICD10Code2);

			}

			break;
			
		default:  logger.info("No input is provided for the Switch Case");        		
        		  Assert.assertTrue("Provided invalid case value",false);	
			 
		 }		
		
	}	
	
	@Step
	public void ColumnNamesInDeleteCombinationTab(String ColHeaders) {
		boolean bstatus=false;
		String[] Expected=ColHeaders.split(",");
		for(int i=0;i<Expected.length;i++){
			String Actual =oSeleniumUtils.get_TextFrom_Locator(StringUtils.replace(oRAPage.DeleteCombCoulmnHeader, "arg",String.valueOf(i+1)));
			bstatus=Expected[i].equalsIgnoreCase(Actual);
			if(bstatus){
				Assert.assertTrue("Column Headers for deleting combination tab displayed as Expected",bstatus);
				logger.info("Column Headers in deleting combination tab displayed as"+Expected[i]);
			}else{
				Assert.assertTrue("Failed to display Column Headers for deleting combination tab",bstatus);
				logger.info("Failed to display Column Headers for deleting combination tab");
			}
			
		}
		
			
	}

	@Step
	public void ValidateSortingForColumn(String Sorting, String Coulmns) {
		
		String[] ColumnHeader=Coulmns.split(",");
		String[] SortingType=Sorting.split(",");
		for(int i=0;i<ColumnHeader.length;i++){
			String Sorting_Arrow=StringUtils.replace(oRAPage.SortingType, "number", String.valueOf(i+1));
			Assert.assertTrue("No sorting Tpe is displayed",oSeleniumUtils.is_WebElement_Present(StringUtils.replace(Sorting_Arrow, "arg", "Sort None")));
			logger.info("No sorting is applied");
			for(int j=0;j<SortingType.length;j++){				
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue", ColumnHeader[i]));					
				Assert.assertTrue("Sorting Type is in ascending order",oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(Sorting_Arrow, "arg",SortingType[j] )));
				logger.info(SortingType[j]+" is applied for "+ColumnHeader[i]);
			}
			logger.info(ColumnHeader[i]);
			if(ColumnHeader[i].equalsIgnoreCase("DOS To")){
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue", ColumnHeader[i]));	
			}
		}
		
	}

	@Step
	public void RASelects(String Type, String Value) {
		if(Value.equalsIgnoreCase("Support")||Value.equalsIgnoreCase("Does Not Support")){
			Serenity.setSessionVariable("Category Type").to(Value);	
		}
		String[] sType=Type.split(",");
		String[] sValue=Value.split(",");
		for(int i=0;i<sType.length;i++){
			oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.DeleteCombInputArea, "arg", sType[i]), sValue[i]);
			logger.info(sType[i]+"Entered as "+sValue[i]);
		}
	}

	@Step
	public void RaValidatesFilterForColumn(String ColHeader) {
		
		String[] sColHeader=ColHeader.split(",");
		for(int i=0;i<sColHeader.length;i++){
			int j=i+1;		
			String sActualText="";
			
			switch(sColHeader[i]){	
			
			case "Manually Added Code":	
				
				if(Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase("Support")){
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.DeleteCombInputArea, "arg",sColHeader[i]),Serenity.sessionVariableCalled("Manually Added Code"));
					sActualText=oSeleniumUtils.get_TextFrom_Locator("((//div[@id='deletecombination']//div[@role='rowgroup'])[4]/div/div[1]/div/div/div)"+"["+j+"]");
					Assert.assertTrue("Displayed data as expected after filtering with "+sColHeader[i],Serenity.sessionVariableCalled("Manually Added Code").toString().equalsIgnoreCase(sActualText)
							);	
					logger.info("Displayed data as expected after filtering with "+sColHeader[i]+" for support category");
				}else{
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.DeleteCombInputArea, "arg",sColHeader[i]),Serenity.sessionVariableCalled("Manually Added Code Doesn't"));
					sActualText=oSeleniumUtils.get_TextFrom_Locator("((//div[@id='deletecombination']//div[@role='rowgroup'])[4]/div/div[1]/div/div/div)"+"["+j+"]");
					Assert.assertTrue("Displayed data as expected after filtering with "+sColHeader[i],Serenity.sessionVariableCalled("Manually Added Code Doesn't").toString().equalsIgnoreCase(sActualText)
							);
					logger.info("Displayed data as expected after filtering with "+sColHeader[i]+" for does not support category");
				}						
				break;
				
			case "Base ICD Code":	
				
				if(Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase("Support")){
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.DeleteCombInputArea, "arg",sColHeader[i]),Serenity.sessionVariableCalled("ICD Code"));
					sActualText=oSeleniumUtils.get_TextFrom_Locator("((//div[@id='deletecombination']//div[@role='rowgroup'])[4]/div/div[1]/div/div/div)"+"["+j+"]");
					Assert.assertTrue(sColHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("ICD Code").toString().equalsIgnoreCase(sActualText)
							);
					logger.info("Displayed data as expected after filtering with "+sColHeader[i]+" for support category");
				}else{
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.DeleteCombInputArea, "arg",sColHeader[i]),Serenity.sessionVariableCalled("ICD Code Doesn't"));
					sActualText=oSeleniumUtils.get_TextFrom_Locator("((//div[@id='deletecombination']//div[@role='rowgroup'])[4]/div/div[1]/div/div/div)"+"["+j+"]");
					Assert.assertTrue(sColHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("ICD Code Doesn't").toString().equalsIgnoreCase(sActualText)
							);
					logger.info("Displayed data as expected after filtering with "+sColHeader[i]+" for does not support category");
				}
				break;
				
			case "ICD group":					
				if(Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase("Support")){
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.DeleteCombInputArea, "arg",sColHeader[i]),Serenity.sessionVariableCalled("ICD Group"));
					sActualText=oSeleniumUtils.get_TextFrom_Locator("((//div[@id='deletecombination']//div[@role='rowgroup'])[4]/div/div[1]/div/div/div)"+"["+j+"]");
					Assert.assertTrue(sColHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("ICD Group").toString().equalsIgnoreCase(sActualText)
						);
					logger.info("Displayed data as expected after filtering with "+sColHeader[i]+" for support category");
				}else{
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.DeleteCombInputArea, "arg",sColHeader[i]),Serenity.sessionVariableCalled("ICD Group Doesn't"));
					sActualText=oSeleniumUtils.get_TextFrom_Locator("((//div[@id='deletecombination']//div[@role='rowgroup'])[4]/div/div[1]/div/div/div)"+"["+j+"]");
					Assert.assertTrue(sColHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("ICD Group Doesn't").toString().equalsIgnoreCase(sActualText)
							);
					logger.info("Displayed data as expected after filtering with "+sColHeader[i]+" for does not support category");
				}
				break;
				
			case "Category":					
				if(Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase("Support")){
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.DeleteCombInputArea, "arg",sColHeader[i]),Serenity.sessionVariableCalled("Category Type"));
					sActualText=oSeleniumUtils.get_TextFrom_Locator("((//div[@id='deletecombination']//div[@role='rowgroup'])[4]/div/div[1]/div/div/div)"+"["+j+"]");
					Assert.assertTrue(sColHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase(sActualText)
						);
					logger.info("Displayed data as expected after filtering with "+sColHeader[i]+" for support category");
				}else{
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.DeleteCombInputArea, "arg",sColHeader[i]),Serenity.sessionVariableCalled("Category Type"));
					sActualText=oSeleniumUtils.get_TextFrom_Locator("((//div[@id='deletecombination']//div[@role='rowgroup'])[4]/div/div[1]/div/div/div)"+"["+j+"]");
					Assert.assertTrue(sColHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase(sActualText)
							);	
					logger.info("Displayed data as expected after filtering with "+sColHeader[i]+" for does not support category");
				}
				break;
				
				default:
		
					Assert.assertTrue("Invalid Header selection",false);
					logger.info("Invalid Header Selection");
			}
			
		}
		
		}

	@Step
	public void ValidateManuallyAddedCodesInDeleteTab(String ColumnHeader) {
		
		//Validating Manually added code in add combination tab to delete tab
		String[] sCoulmnHeader=ColumnHeader.split(",");
		for(int i=0;i<sCoulmnHeader.length;i++){
			
			int j=i+1;
			String sActualText=oSeleniumUtils.get_TextFrom_Locator("((//div[@id='deletecombination']//div[@role='rowgroup'])[4]/div/div[1]/div/div/div)"+"["+j+"]");
			logger.info("ActualText:: " +sActualText);
			
			switch(sCoulmnHeader[i]){
			
			case "Manually Added Code":					
				if(Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase("Support")){
					Assert.assertTrue(sCoulmnHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("Manually Added Code").toString().equalsIgnoreCase(sActualText)
							);	
					logger.info("Data added in Add Combination tab for support category is validated in Delete combination tab for "+sCoulmnHeader[i]);
				}else{						
					Assert.assertTrue(sCoulmnHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("Manually Added Code Doesn't").toString().equalsIgnoreCase(sActualText)
							);
					logger.info("Data added in Add Combination tab for does not support category is validated in Delete combination tab for "+sCoulmnHeader[i]);
				}
				break;
				
			case "Base ICD Code":
				if(Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase("Support")){
					Assert.assertTrue(sCoulmnHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("ICD Code").toString().equalsIgnoreCase(sActualText)
							);
					logger.info("Data added in Add Combination tab for support category is validated in Delete combination tab for "+sCoulmnHeader[i]);logger.info("Data added in Add Combination tab for support category is validated in Delete combination tab for "+sCoulmnHeader[i]);
				}else{
					Assert.assertTrue(sCoulmnHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("ICD Code Doesn't").toString().equalsIgnoreCase(sActualText)
							);
					logger.info("Data added in Add Combination tab for does not support category is validated in Delete combination tab for "+sCoulmnHeader[i]);
				}
				break;
				
			case "ICD group":
				if(Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase("Support")){
					Assert.assertTrue(sCoulmnHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("ICD Group").toString().equalsIgnoreCase(sActualText)
							);
					logger.info("Data added in Add Combination tab for support category is validated in Delete combination tab for "+sCoulmnHeader[i]);
				}else{
					Assert.assertTrue(sCoulmnHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("ICD Group Doesn't").toString().equalsIgnoreCase(sActualText)
							);
					logger.info("Data added in Add Combination tab for does not support category is validated in Delete combination tab for "+sCoulmnHeader[i]);
				}
				break;
				
			case "Category":
				if(Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase("Support")){
					Assert.assertTrue(sCoulmnHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase(sActualText)
						);
					logger.info("Data added in Add Combination tab for support category is validated in Delete combination tab for "+sCoulmnHeader[i]);
				}else{
					Assert.assertTrue(sCoulmnHeader[i]+"Displayed as added in add combination tab",Serenity.sessionVariableCalled("Category Type").toString().equalsIgnoreCase(sActualText)
							);
					logger.info("Data added in Add Combination tab for does not support category is validated in Delete combination tab for "+sCoulmnHeader[i]);
				}
				break;

				default:Assert.assertTrue("Invalid Header selection",false);
				logger.info("Invalid Header Selection");
			}
		}
		
	}

	@Step
	public void RAEntersDateInDeleteCombinationAs(String Dates) {
		String[] sDate=Dates.split(",");
		int icount = getDriver().findElements(By.xpath(oRAPage.DOS_DelComb)).size();
		for(int i=0;i<icount;i++){
			int j=i+1;
			
			Actions action = new Actions(getDriver());
			action.moveToElement(getDriver().findElement(By.xpath(oRAPage.DOS_DelComb+"["+j+"]"))).click().build().perform();
			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			String sXpath = "//DIV[2]/FORM[1]/INPUT[1]";
			oSeleniumUtils.moveToElement(sXpath);
			//SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			getDriver().findElement(By.xpath(sXpath)).sendKeys(sDate[i]);
			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			//clicking outside to change focus
			getDriver().findElement(By.xpath("//span[text()='DOS To']/../following-sibling::div//input[@ng-model='colFilter.term']")).click();
			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			
		}

	}
	
	@Step
	public void RaValidatesRadioButtonsInAddCombTab(String DefaultSel, String SelectingVal) {
		//validating default selection in add/edit combination pop up
		if(DefaultSel.equalsIgnoreCase("Associate Code")){
			boolean bStatus=false;
			bStatus=oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oRAPage.DefaultRadioSel, "arg", "associate"));
			if(bStatus){
				logger.info(DefaultSel+"is displayed as default selection");
				Assert.assertTrue(DefaultSel+"is displayed as default selection",bStatus);
				
			}else{
				logger.info("Failed to display "+DefaultSel+"as default selection");
				Assert.assertTrue("Failed to display "+DefaultSel+" as default selection",bStatus);				
			}
			//selecting the value as per switching between buttons
			String sSelection=StringUtils.replace(oRAPage.DefaultRadioSel, "arg", "manually");
			System.out.println(StringUtils.substringBefore(sSelection, "and")+"]");
			oSeleniumUtils.Click_given_Locator(StringUtils.substringBefore(sSelection,"and")+"]");			
		}else{
			//validating the selection in add/edit combination pop up
			boolean bStatus=false;
			bStatus=oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oRAPage.DefaultRadioSel, "arg", "manually"));
			if(bStatus){
				logger.info(DefaultSel+"is displayed as default selection");
				Assert.assertTrue(DefaultSel+"is displayed as default selection",bStatus);				
			}else{
				logger.info("Failed to display "+DefaultSel+"as default selection");
				Assert.assertTrue("Failed to display "+DefaultSel+" as default selection",bStatus);				
			}
			//selecting the value as per switching between buttons
			String sSelection=StringUtils.replace(oRAPage.DefaultRadioSel, "arg", "associate");
			System.out.println(StringUtils.substringBefore(sSelection, "and")+"]");
			oSeleniumUtils.Click_given_Locator(StringUtils.substringBefore(sSelection,"and")+"]");	
		}
		
	}
	
	@Step
	public void raClosesApplication() {
		oHomePage.closeApplication();
		logger.info("Closing the application");
	}

	@Step
	public void AlertPoupShouldNotbeDisplayed() {
		try{
			logger.info("Alert pop is not displayed as expected");
			Assert.assertFalse("Alert pop up is not displayed",oSeleniumUtils.is_WebElement_Displayed(oRAPage.RAPage_sAlertPopup));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Step
	public void raSelectsGridCheckBox() {
		oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_DeleteComb_GridChkbox);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
		
	}

	@Step
	public String getSupportICD10Code(String LCD_ArticleID,String sLCD_Article,String sOptionalParam)
	{
		 String sSupportICD10Code="";		 
		  String sICD10Code="";
		
		switch (sLCD_Article)
		{

		case "LCD":
			
				//Call SQL query to retrieve ICD code only available in Support Tab for the LCD
				String sSupportICD10Query = "Select * from (Select ICD10_Code from LCD.LCD_CPT_ICD_SPRT_DELTA where  lcd_id="
						+ LCD_ArticleID + " MINUS " + "Select ICD10_Code from LCD.LCD_CPT_ICD_DONTSPRT_DELTA where  lcd_id=" + LCD_ArticleID
						+ ") where rownum=1";
				sSupportICD10Code = DBUtils.executeSQLQuery(sSupportICD10Query);

				//Store it in Session Variable
				Serenity.setSessionVariable("ICD Code").to(sSupportICD10Code);
				Serenity.setSessionVariable("SupportICD10Code").to(sSupportICD10Code);
				
				sICD10Code = sSupportICD10Code;			

			break;

		case "Article":
			
				//Call SQL query to retrieve ICD code only available in Support Tab for the Article
				String sSupportICD10Query_Article = "Select * from (Select ICD10_Code from LCD.ART_CPT_ICD_SPRT_DELTA where  Art_id="
						+ LCD_ArticleID + " MINUS " + "Select ICD10_Code from LCD.ART_CPT_ICD_DONTSPRT_DELTA where  Art_id=" + LCD_ArticleID
						+ ") where rownum=1";
				sSupportICD10Code = DBUtils.executeSQLQuery(sSupportICD10Query_Article);	
				
				//sSupportICD10Code="C18.1";
				
				//Store it in Session Variable
				Serenity.setSessionVariable("ICD Code").to(sSupportICD10Code);
				Serenity.setSessionVariable("SupportICD10Code").to(sSupportICD10Code);
				sICD10Code = sSupportICD10Code;
				
			break;
		}

		return sICD10Code;	
		
	}	
	
	@Step
	private String getSupportICD10CodeBoth(String LCD_ArticleID, String sLCD_Article, String sOptionalParam) {
		
		String sSupportICD10CodeBoth="";		 
		  String sICD10Code="";
		
		switch (sLCD_Article)
		{

		case "LCD":
			
				//Call SQL query to retrieve ICD code only available in Support Tab for the LCD
				String sSupportICD10BothQuery = "select * from (select icd10_code from LCD.LCD_CPT_ICD_SPRT_DELTA where lcd_id ="
				+ LCD_ArticleID + " intersect " + "select icd10_code from LCD.LCD_CPT_ICD_DONTSPRT_DELTA where lcd_id =" + LCD_ArticleID + ") where rownum=1";					 
				logger.info("sSupportICD10BothQuery ::"+sSupportICD10BothQuery);		
				sSupportICD10CodeBoth = DBUtils.executeSQLQuery(sSupportICD10BothQuery);

				//Store it in Session Variable				
				Serenity.setSessionVariable("SupportICD10CodeBoth").to(sSupportICD10CodeBoth);
				
				sICD10Code = sSupportICD10CodeBoth;			

			break;

		case "Article":
			
				//Call SQL query to retrieve ICD code only available in Support Tab for the Article
				String sSupportICD10BothQuery_Article = "select * from (select icd10_code from LCD.ART_CPT_ICD_SPRT_DELTA where art_id ="
						+ LCD_ArticleID + " intersect" + " select icd10_code from LCD.ART_CPT_ICD_DONTSPRT_DELTA where art_id =" + LCD_ArticleID + ") where rownum=1";
				
				sSupportICD10CodeBoth = DBUtils.executeSQLQuery(sSupportICD10BothQuery_Article);		
				
				//Store it in Session Variable				
				Serenity.setSessionVariable("SupportICD10CodeBoth").to(sSupportICD10CodeBoth);
				sICD10Code = sSupportICD10CodeBoth;
				
			break;
			
			default:  logger.info("No input is provided for the Switch Case");
					  Assert.assertTrue("Provided invalid case value",false);		
		}

		return sICD10Code;
}

	@Step
	public String getDontSupportICD10Code(String LCD_ArticleID,String sLCD_Article,String sOptionalParam)
	{
		 
		  String sDontSupportICD10Code="";		  
		  String sICD10Code="";
		
		switch (sLCD_Article)
		{

		case "LCD":
			
  			//Call SQL query to retrieve ICD code only available in DoesNotSupport Tab for the LCD
				String sDontSupportICD10Query = "Select * from (Select ICD10_Code from LCD.LCD_CPT_ICD_DONTSPRT_DELTA where lcd_id="
						+ LCD_ArticleID + " MINUS " + "Select ICD10_Code from LCD.LCD_CPT_ICD_SPRT_DELTA where  lcd_id=" + LCD_ArticleID
						+ ") where rownum=1";
				sDontSupportICD10Code = DBUtils.executeSQLQuery(sDontSupportICD10Query);

				//Store it in Session Variable
				Serenity.setSessionVariable("ICD Code Doesn't").to(sDontSupportICD10Code);
				sICD10Code = sDontSupportICD10Code;			

			break;
			

		case "Article":
			
				// Call SQL query to retrieve ICD code only available in  DoesNotSupport Tab for the Article
				String sDontSupportICD10Query_Article = "Select * from (Select ICD10_Code from LCD.ART_CPT_ICD_DONTSPRT_DELTA where Art_id="
						+ LCD_ArticleID + " MINUS " + "Select ICD10_Code from LCD.ART_CPT_ICD_SPRT_DELTA where  Art_id=" + LCD_ArticleID
						+ ") where rownum=1";
				sDontSupportICD10Code = DBUtils.executeSQLQuery(sDontSupportICD10Query_Article);

				// Store it in Session Variable
				Serenity.setSessionVariable("ICD Code Doesn't").to(sDontSupportICD10Code);		
				sICD10Code = sDontSupportICD10Code;
				
			break;
			
		default:  logger.info("No input is provided for the Switch Case");
				  Assert.assertTrue("Provided invalid case value",false);		
		}

		return sICD10Code;	
		
	}
	
	@Step
	public String getSupportICDGroup(String LCD_ArticleID,String sLCD_Article,String sICD10Code,String sOptionalParam)
	{
		 	  	 
		  String sICDGroup="";		 
		
		switch (sLCD_Article)
		{

		case "LCD":
			
				String sSupportICDGroupQuery = "Select ICD10_Group from LCD.LCD_CPT_ICD_SPRT_DELTA where LCD_ID=" + LCD_ArticleID
						+ " and ICD10_CODE=" + "'" + sICD10Code + "'" + " and rownum=1";
				String sSuppportICDGroup = DBUtils.executeSQLQuery(sSupportICDGroupQuery);
				
				Serenity.setSessionVariable("ICD Group").to(sSuppportICDGroup); 
				Serenity.setSessionVariable("SupportICD10Group").to(sSuppportICDGroup);
				Serenity.setSessionVariable("NewICDGroup").to(sSuppportICDGroup); 
				
				 sICDGroup = sSuppportICDGroup;
			
			break;

		case "Article":
								
				String sSupportICDGroupQuery_Article = "Select ICD10_Group from LCD.ART_CPT_ICD_SPRT_DELTA where Art_id="
						+ LCD_ArticleID + " and ICD10_CODE=" + "'" + sICD10Code + "'" + " and rownum=1";
				sSuppportICDGroup = DBUtils.executeSQLQuery(sSupportICDGroupQuery_Article);
				
				Serenity.setSessionVariable("ICD Group").to(sSuppportICDGroup); 
				Serenity.setSessionVariable("SupportICD10Group").to(sSuppportICDGroup);
				Serenity.setSessionVariable("NewICDGroup").to(sSuppportICDGroup); 
				
				sICDGroup = sSuppportICDGroup;				
			
			break;
			
		    default:  logger.info("No input is provided for the Switch Case");
		    		  Assert.assertTrue("Provided invalid case value",false);	
		}

		return sICDGroup;	
		  
	}
	
	@Step
	public String getSupportICDGroupBoth(String LCD_ArticleID, String sLCD_Article, String sICD10Code, String sOptionalParam) {
		
		String sSuppportICDGroupBoth="";		 
		String sICDGroup="";		 
		
		switch (sLCD_Article)
		{

		case "LCD":
			
				String sSupportICDGroupQuery = "Select ICD10_Group from LCD.LCD_CPT_ICD_SPRT_DELTA where LCD_ID=" + LCD_ArticleID
						+ " and ICD10_CODE=" + "'" + sICD10Code + "'" + " and rownum=1";
				sSuppportICDGroupBoth = DBUtils.executeSQLQuery(sSupportICDGroupQuery);
				
				//Serenity.setSessionVariable("ICD Group").to(sSuppportICDGroupBoth); 
				Serenity.setSessionVariable("SupportICD10Group").to(sSuppportICDGroupBoth);
				
				sICDGroup = sSuppportICDGroupBoth;
			
			break;

		case "Article":
								
				String sSupportICDGroupQuery_Article = "Select ICD10_Group from LCD.ART_CPT_ICD_SPRT_DELTA where Art_id="
						+ LCD_ArticleID + " and ICD10_CODE=" + "'" + sICD10Code + "'" + " and rownum=1";
				sSuppportICDGroupBoth = DBUtils.executeSQLQuery(sSupportICDGroupQuery_Article);			
			 
				Serenity.setSessionVariable("SupportICD10Group").to(sSuppportICDGroupBoth);
				
				sICDGroup = sSuppportICDGroupBoth;				
			
			break;
			
		default: logger.info("No input is provided for the Switch Case");
                 Assert.assertTrue("Provided invalid case value",false);	
		}

		return sICDGroup;	
	}
	
	@Step	
	public String getDontSupportICDGroup(String LCD_ArticleID,String sLCD_Article,String sICD10Code,String sOptionalParam)
	{		 
		  		 
		  String sICDGroup="";
		  String sDontSuppportICDGroup="";
		
		switch (sLCD_Article)
		{

		case "LCD":
			
				String sDontSupportICDGroupQuery = "Select ICD10_Group from LCD.LCD_CPT_ICD_DONTSPRT_DELTA where LCD_ID="
						+ LCD_ArticleID + " and ICD10_CODE=" + "'" + sICD10Code + "'" + " and rownum=1";
				sDontSuppportICDGroup = DBUtils.executeSQLQuery(sDontSupportICDGroupQuery);
				
				Serenity.setSessionVariable("ICD Group Doesn't").to(sDontSuppportICDGroup); 
				
				sICDGroup = sDontSuppportICDGroup;
			break;

		case "Article":
				
				String sDontSupportICDGroupQuery_Article = "Select ICD10_Group from LCD.ART_CPT_ICD_DONTSPRT_DELTA where Art_id="
						+ LCD_ArticleID + " and ICD10_CODE=" + "'" + sICD10Code + "'" + " and rownum=1";
				sDontSuppportICDGroup = DBUtils.executeSQLQuery(sDontSupportICDGroupQuery_Article);
				
				Serenity.setSessionVariable("ICD Group Doesn't").to(sDontSuppportICDGroup);
				
				sICDGroup = sDontSuppportICDGroup;
				
			break;
		default: logger.info("No input is provided for the Switch Case");
				 Assert.assertTrue("Provided invalid case value",false);	
		}

		return sICDGroup;			  
	}	
	
	@Step
	public String getNewICDCodes(String sNewICDCodeName,String optionalParam)
	{		  
		    String sNewICDCode="";
		    String sNewICD10Code="";
		    String sNewICD10Code2="";
		
		    switch (sNewICDCodeName)		    
		    {
		    
		    case "NewICDCodeOne":
		  		    	
		    	String sNewICD10COdeQuery = "Select section from mdm.icd10_manual where section like 'Y37.001A%' and section_type_key = 4 and icd_version = 2019 and rownum=1";
				sNewICD10Code = DBUtils.executeSQLQuery(sNewICD10COdeQuery);
				Serenity.setSessionVariable("Manually Added Code").to(sNewICD10Code);
				Serenity.setSessionVariable("NewICDCode1").to(sNewICD10Code);
				Serenity.setSessionVariable("NewICDCode").to(sNewICD10Code);
				sNewICDCode= sNewICD10Code;		  	    	
		    	break;
		    	
		    case "NewICDCodeTwo":
		    	
		    	String sNewICD10Code2Query = "Select section from mdm.icd10_manual where section like 'Y37.001D%' and section_type_key = 4 and icd_version = 2019 and rownum=1";
		    	sNewICD10Code2 = DBUtils.executeSQLQuery(sNewICD10Code2Query);
				Serenity.setSessionVariable("Manually Added Code Doesn't").to(sNewICD10Code2);
				Serenity.setSessionVariable("NewICDCode2").to(sNewICD10Code2);
				sNewICDCode= sNewICD10Code2;		    	
		    	break;	
		    	
		    	
		    default:  logger.info("No input is provided for the Switch Case");
	                  Assert.assertTrue("Provided invalid case value",false);		
		    }		    
		    
		    return  sNewICDCode;		
  	}

	@Step
	public void validateGriDRecordSelection(String sRecordsType,String optionalParam) {
		
		boolean boolSelected=false;
		 
		if(sRecordsType.equalsIgnoreCase("AllRecords"))
		{
			
			//Check whether all records CheckBox is got selected			
			boolSelected= oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oRAPage.RAPage_DeleteCombGridChkbox_SelectionValidate,"sValue","ui-grid-all-selected"));
			
			if(boolSelected)
			{
				logger.info("All GridRows Checkbox is selected");
				Assert.assertTrue("All GridRows Checkbox is selected",true);
				
				//UnCheck the CheckBox
				oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_DeleteComb_GridChkbox_Generic+"[1]");
			}
			else{
				 logger.info("All GridRows Checkbox is Not selected");	
				 Assert.assertTrue("All GridRows Checkbox is selected",false);				 			
			   }			
		}
		else if (sRecordsType.equalsIgnoreCase("SingleRecord")) {
			
			//Check whether Single record CheckBox is got selected 			
			boolSelected= oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oRAPage.RAPage_DeleteCombGridChkbox_SelectionValidate,"sValue","ui-grid-row-selected"));			
			if(boolSelected)
			{
				logger.info("Single Grid row Checkbox is selected"); 
				Assert.assertTrue("Single Grid row Checkbox is selected",true);
				
			}
			else{	
				  logger.info("Single Grid row Checkbox is Not selected");
				  Assert.assertTrue("Single Grid row Checkbox is Not selected",false);				  
			    }
		 }		
		
	}

	@Step
	public void raSelectsDeleteCombinationGridRecords(String sRecordsType,String optionalParam) {
		
		if(!sRecordsType.isEmpty())	
		{		
			
			  if (oSeleniumUtils.is_WebElement_Displayed(oRAPage.RAPage_DeleteCombGridChkbox_Rows))			
			    {		
						if(sRecordsType.equalsIgnoreCase("All"))						{
							//Click on all Grid Records Check box			
							oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_DeleteComb_GridChkbox_Generic+"[1]");
							logger.info("Clicked on the AllRowsSelection Checkbox");
						}		
						
						else if (sRecordsType.equalsIgnoreCase("Single")) {								
							//Click on Single record CheckBox 			
							oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_DeleteComb_GridChkbox_Generic+"[2]");
							logger.info("Clicked on the single Grid Row Checkbox");
						}
			    }//End of if for rows displayed in DeleteCombination grid 	
			  else{
				     logger.info("No Records displayed in the Delete Combination Popup");
				     Assert.assertTrue("No Records displayed in the Delete Combination Popup",false);				  
			      }
		 }//End of if for sRecordType empty 
		else{
			
			  logger.info("No RecordType is passed from Gherkin Step");
			  Assert.assertTrue("No RecordType is passed from Gherkin Step",false);			
		    }
				
	}

	@Step
	public void ValidatingCreatedCodesUnderLCD(String LCD_Article) throws Exception {
		String sQuery="";
		
		//Getting HCPCS and ICD Code from DB for both lcd and article
		if(LCD_Article.equalsIgnoreCase("LCD")){
			sQuery="select HCPC_CODE from LCD.LCD_CPT_ICD_SPRT_DELTA where LCD_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_Code='"+Serenity.sessionVariableCalled("ICD Code")+"'";
		  logger.info(sQuery);
		}else{
			sQuery="select HCPC_CODE from LCD.ART_CPT_ICD_SPRT_DELTA where ART_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_Code='"+Serenity.sessionVariableCalled("ICD Code")+"'";
		}
		
		ArrayList<String> HCPCSCodes = DBUtils.executeSQLQueryMultipleRows(sQuery);
		if(!HCPCSCodes.isEmpty()){
		for(int i=0;i<HCPCSCodes.size();i++){
		//enter HCPCS Code
		oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.RAPage_Input_TextArea, "arg", "CPT/HCPCS Code"),HCPCSCodes.get(i) );
		//Enter ICD COde
		oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.RAPage_Input_TextArea, "arg", "ICD Code"), Serenity.sessionVariableCalled("NewICDCode"));
		//Click on Apply Filter
		oSeleniumUtils.Click_given_WebElement(oRAPage.ApplyFilter_Btn);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		//validating filter data
		oSeleniumUtils.is_WebElement_Displayed(oRAPage.Matching_FIltered_Count);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
		Assert.assertTrue("Matched 1 row with filtered data",oSeleniumUtils.get_TextFrom_Locator(oRAPage.Matching_FIltered_Count).equalsIgnoreCase(ProjectVariables.Matching_Count));
		logger.info("Matched 1 row after applying filters by entering HCPCS and ICD Code as "+HCPCSCodes.get(i)+" and"+Serenity.sessionVariableCalled("NewICDCode"));
		}
		}else{
			logger.info("No elements were retrieved from query");
			Assert.assertTrue("No elements were retrieved from query",false);			
		}
	}

	@Step
	public void ValidatingManual10CodeInDB(String Table,String LCD_Article) {
		
		String Manual10Query="";
		
		if(LCD_Article.equalsIgnoreCase("LCD")){			
			Manual10Query="select * from (select MANUAL_10 from LCD."+Table+" where LCD_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_Code='"+Serenity.sessionVariableCalled("NewICDCode")+"') where rownum=1";			
		   System.out.println(Manual10Query);		   
		}else{
			Manual10Query="select * from (select MANUAL_10 from LCD."+Table+" where ART_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_Code='"+Serenity.sessionVariableCalled("NewICDCode")+"') where rownum=1";			
		}				
		
		 String sResult=DBUtils.executeSQLQuery(Manual10Query);	
		 Assert.assertTrue("Manaual10 code in "+Table+"Found as " +sResult ,sResult.equalsIgnoreCase("-1"));
		 logger.info("Manaual10 code in "+Table+"Found as " +sResult);
	 
		
	}

	@Step
	public void MappingBaseCodeWithManualCodeInDB(String Table,String Category,String LCD_Article) {		
		
		String sBaseICDCodeQuery="";
		String sNewICDCode="";
		String sICDGroup="";
		String sBaseICDCodeQueryDoesnt="";
		String sNewICDCodeDoesnt="";
		String sICDGroupDoesnt="";
		String sICDGroupDsntSupport="";
		String sNewICDCodeDsntSupport="";
		String sBaseICDCodeQueryDsntSupport="";
				
		
			switch(Category){
			
			case "Support":
				
				if(LCD_Article.equalsIgnoreCase("LCD")){					
										
					sBaseICDCodeQuery="Select * from( select BASE_ICD10_CODE from LCD."+Table+" where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and ICD10_CODE = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'"+" and SUPPORTS_10=-1) where rownum=1";
					sNewICDCode="Select * from( select ICD10_CODE from LCD."+Table+" where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and BASE_ICD10_CODE = '" + Serenity.sessionVariableCalled("ICD Code") + "'"+" and SUPPORTS_10=-1) where rownum=1";
					sICDGroup="Select * from( select ICD10_GROUP from LCD."+Table+" where LCD_ID="+Serenity.sessionVariableCalled("ID")+" and BASE_ICD10_CODE = '" + Serenity.sessionVariableCalled("ICD Code") + "'"+" and ICD10_CODE = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'" +" and SUPPORTS_10=-1) where rownum=1";
					
				}else{
					sBaseICDCodeQuery="select * from( select BASE_ICD10_CODE from LCD."+Table+" where ART_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_CODE = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'"+" and SUPPORTS_10=-1) where rownum=1";
					sNewICDCode="select * from( select ICD10_CODE from LCD."+Table+" where ART_ID="+Serenity.sessionVariableCalled("ID")+" and BASE_ICD10_CODE = '" + Serenity.sessionVariableCalled("ICD Code") + "'"+" and SUPPORTS_10=-1) where rownum=1";
					sICDGroup="select * from( select ICD10_GROUP from LCD."+Table+" where ART_ID="+Serenity.sessionVariableCalled("ID")+" and BASE_ICD10_CODE = '" + Serenity.sessionVariableCalled("ICD Code") + "'"+" and ICD10_CODE = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'" +" and SUPPORTS_10=-1) where rownum=1";
				}
				
				if(!(sBaseICDCodeQuery.isEmpty()&&sNewICDCode.isEmpty()&&sICDGroup.isEmpty())){
					
					//validating Base ICD Code
					Assert.assertTrue("Base ICD Code matched with Value in DB  "+Table,DBUtils.executeSQLQuery(sBaseICDCodeQuery).equalsIgnoreCase(Serenity.sessionVariableCalled("ICD Code").toString()));				
					logger.info("Base ICD Code matched with Value in DB  '"+Table+"' for support LCD");
					//validating New ICD Code
					Assert.assertTrue("New ICD Code matched with Value in DB  "+Table,DBUtils.executeSQLQuery(sNewICDCode).equalsIgnoreCase(Serenity.sessionVariableCalled("Manually Added Code").toString()));
					logger.info("New ICD Code matched with Value in DB  '"+Table+"' for support LCD");
					//validating ICD Group
					Assert.assertTrue("ICD Group matched with Value in DB  "+Table,DBUtils.executeSQLQuery(sICDGroup).equalsIgnoreCase(Serenity.sessionVariableCalled("ICD Group").toString()));		
					logger.info("ICD Group matched with Value in DB  '"+Table+"' for support LCD");
				}else{
					logger.info("DB Result found Empty");
					Assert.assertTrue("DB Result found Empty",false);
				}
				break;	
				
			case "Does":
				
				if(LCD_Article.equalsIgnoreCase("LCD")){					
					
					sBaseICDCodeQueryDoesnt="Select * from( select BASE_ICD10_CODE from LCD."+Table+" where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and ICD10_CODE = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'"+" and SUPPORTS_10=0) where rownum=1";
					sNewICDCodeDoesnt="Select * from( select ICD10_CODE from LCD."+Table+" where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and BASE_ICD10_CODE = '" + Serenity.sessionVariableCalled("ICD Code Doesn't") + "'"+" and SUPPORTS_10=0) where rownum=1";
					sICDGroupDoesnt="Select * from( select ICD10_GROUP from LCD."+Table+" where LCD_ID="+Serenity.sessionVariableCalled("ID")+" and BASE_ICD10_CODE = '" + Serenity.sessionVariableCalled("ICD Code Doesn't" +"") + "'"+" and ICD10_CODE = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'" +" and SUPPORTS_10=0) where rownum=1";
					
					
				}else{
					
					
					sBaseICDCodeQueryDoesnt="select * from( select BASE_ICD10_CODE from LCD."+Table+" where ART_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_CODE = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'"+" and SUPPORTS_10=0) where rownum=1";
					sNewICDCodeDoesnt="select * from( select ICD10_CODE from LCD."+Table+" where ART_ID="+Serenity.sessionVariableCalled("ID")+" and BASE_ICD10_CODE = '" + Serenity.sessionVariableCalled("ICD Code Doesn't") + "'"+" and SUPPORTS_10=0) where rownum=1";
					sICDGroupDoesnt="select * from( select ICD10_GROUP from LCD."+Table+" where ART_ID="+Serenity.sessionVariableCalled("ID")+" and BASE_ICD10_CODE = '" + Serenity.sessionVariableCalled("ICD Code Doesn't") + "'"+" and ICD10_CODE = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'" +" and SUPPORTS_10=0) where rownum=1";
				}
				
				if(!(sBaseICDCodeQueryDoesnt.isEmpty()&&sNewICDCodeDoesnt.isEmpty()&&sICDGroupDoesnt.isEmpty())){
					//validating Base ICD Code
					Assert.assertTrue("Doesn't Support Base ICD Code matched with Value in DB  "+Table,DBUtils.executeSQLQuery(sBaseICDCodeQueryDoesnt).equalsIgnoreCase(Serenity.sessionVariableCalled("ICD Code Doesn't").toString()));
					logger.info("Base ICD Code matched with Value in DB  '"+Table+"' for does not support LCD");
					//validating New ICD Code
					Assert.assertTrue("Doesn't Support New ICD Code matched with Value in DB  "+Table,DBUtils.executeSQLQuery(sNewICDCodeDoesnt).equalsIgnoreCase(Serenity.sessionVariableCalled("Manually Added Code").toString()));
					logger.info("New ICD Code matched with Value in DB  '"+Table+"' for does not support LCD");
					//validating ICD Group
					Assert.assertTrue("Doesn't Support ICD Group matched with Value in DB  "+Table,DBUtils.executeSQLQuery(sICDGroupDoesnt).equalsIgnoreCase(Serenity.sessionVariableCalled("ICD Group Doesn't").toString()));			
					logger.info("ICD Group matched with Value in DB  '"+Table+"' for does not support LCD");
					
				}else{
					logger.info("DB Result found Empty");
					Assert.assertTrue("DB Result found Empty",false);
				}
				break;
				
				
			 case "Both":
				 
					if(LCD_Article.equalsIgnoreCase("LCD")){
						
						sBaseICDCodeQuery="select * from(Select BASE_ICD10_CODE from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and ICD10_CODE="+"'"+Serenity.sessionVariableCalled("NewICDCode")+"'"+" and SUPPORTS_10=-1) where rownum=1";
						sNewICDCode="select * from( select ICD10_CODE from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="+Serenity.sessionVariableCalled("ID")+" and BASE_ICD10_CODE="+"'"+Serenity.sessionVariableCalled("SupportICD10CodeBoth")+"'"+"  and SUPPORTS_10=-1) where rownum=1";
						sICDGroup="select * from( select ICD10_GROUP from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_CODE="+"'"+Serenity.sessionVariableCalled("NewICDCode")+"'"+"  and SUPPORTS_10=-1) where rownum=1";
						
						sBaseICDCodeQueryDsntSupport="select * from( select BASE_ICD10_CODE from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_CODE="+"'"+Serenity.sessionVariableCalled("NewICDCode")+"'"+" and SUPPORTS_10=0) where rownum=1";
						sNewICDCodeDsntSupport="select * from( select ICD10_CODE from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="+Serenity.sessionVariableCalled("ID")+" and BASE_ICD10_CODE="+"'"+Serenity.sessionVariableCalled("SupportICD10CodeBoth")+"'"+" and SUPPORTS_10=0) where rownum=1";
						sICDGroupDsntSupport="select * from( select ICD10_GROUP from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_CODE="+"'"+Serenity.sessionVariableCalled("NewICDCode")+"'"+" and SUPPORTS_10=0) where rownum=1";					
					  
					}else if(LCD_Article.equalsIgnoreCase("Article")){
						
						 sBaseICDCodeQuery="select * from(Select BASE_ICD10_CODE from LCD.ART_MANUAL_CODE_COMB where ART_ID="+Serenity.sessionVariableCalled("ID")+ " and ICD10_CODE="+"'"+Serenity.sessionVariableCalled("NewICDCode")+"'"+" and SUPPORTS_10=-1) where rownum=1";
						 sNewICDCode="select * from( select ICD10_CODE from LCD.ART_MANUAL_CODE_COMB where ART_ID="+Serenity.sessionVariableCalled("ID")+" and BASE_ICD10_CODE="+"'"+Serenity.sessionVariableCalled("SupportICD10CodeBoth")+"'"+"  and SUPPORTS_10=-1) where rownum=1";
						 sICDGroup="select * from( select ICD10_GROUP from LCD.ART_MANUAL_CODE_COMB where ART_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_CODE="+"'"+Serenity.sessionVariableCalled("NewICDCode")+"'"+"  and SUPPORTS_10=-1) where rownum=1";
							
						 sBaseICDCodeQueryDsntSupport="select * from( select BASE_ICD10_CODE from LCD.ART_MANUAL_CODE_COMB where ART_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_CODE="+"'"+Serenity.sessionVariableCalled("NewICDCode")+"'"+" and SUPPORTS_10=0) where rownum=1";
						 sNewICDCodeDsntSupport="select * from( select ICD10_CODE from LCD.ART_MANUAL_CODE_COMB where ART_ID="+Serenity.sessionVariableCalled("ID")+" and BASE_ICD10_CODE="+"'"+Serenity.sessionVariableCalled("SupportICD10CodeBoth")+"'"+" and SUPPORTS_10=0) where rownum=1";
						 sICDGroupDsntSupport="select * from( select ICD10_GROUP from LCD.ART_MANUAL_CODE_COMB where ART_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_CODE="+"'"+Serenity.sessionVariableCalled("NewICDCode")+"'"+" and SUPPORTS_10=0) where rownum=1";						
				      }
					
					if(!( sBaseICDCodeQuery.isEmpty()&&sNewICDCode.isEmpty()&&sICDGroup.isEmpty()&&sBaseICDCodeQueryDoesnt.isEmpty()&&sNewICDCodeDoesnt.isEmpty()&&sICDGroupDoesnt.isEmpty())){
						
						  //Support Table Validations					
							//validating Base ICD Code
						
						String sQryResult = DBUtils.executeSQLQuery(sBaseICDCodeQuery);
						String Code = Serenity.sessionVariableCalled("ICD Code");
						
						  if(sQryResult.equalsIgnoreCase(Code))
						  {
							Assert.assertTrue("Base ICD Code matched with Value in DB  ",true);
							logger.info("Base ICD Code matched with Value in DB  '"+Table+"' for support LCD");							
						  }
						  else
						  {
							  Assert.assertTrue("Base ICD Code not matched with Value in DB  ",false);
								logger.info("Base ICD Code Not matched with Value in DB  '"+Table+"' for support LCD");
							  
						  }
						  
													
							//validating New ICD Code		
						   sQryResult = DBUtils.executeSQLQuery(sNewICDCode);
						   Code = Serenity.sessionVariableCalled("Manually Added Code");
							
						  if(sQryResult.equalsIgnoreCase(Code))
						  {
							Assert.assertTrue("New ICD Code matched with Value in DB  ",true);
							logger.info("New ICD Code matched with Value in DB  '"+Table+"' for support LCD");
						  }
						  else
						  {
								Assert.assertTrue("New ICD Code not matched with Value in DB  ",false);
								logger.info("New ICD Code not matched with Value in DB  '"+Table+"' for support LCD"); 							  
						  }
						  
						  
							//validating ICD Group				
						   sQryResult = DBUtils.executeSQLQuery(sICDGroup);
						   Code = Serenity.sessionVariableCalled("SupportICD10Group");
						  
						   if(sQryResult.equalsIgnoreCase(Code))
							  {
								Assert.assertTrue("ICD Group matched with Value in DB  ",true);
								logger.info("ICD Group matched with Value in DB  '"+Table+"' for support LCD");
							  }
						   else{
							   Assert.assertTrue("ICD Group not matched with Value in DB  ",false);
								logger.info("ICD Group not matched with Value in DB  '"+Table+"' for support LCD");
						   }
									
														
												
						  //DoesNot Support Table Validations	
							
							//validating Base ICD Code
							Assert.assertTrue("Doesn't Support Base ICD Code matched with Value in DB  "+Table,DBUtils.executeSQLQuery(sBaseICDCodeQueryDsntSupport).equalsIgnoreCase(Serenity.sessionVariableCalled("SupportICD10CodeBoth").toString()));
							logger.info("Base ICD Code matched with Value in DB  '"+Table+"' for does not support LCD");
							
							//validating New ICD Code
							Assert.assertTrue("Doesn't Support New ICD Code matched with Value in DB  "+Table,DBUtils.executeSQLQuery(sNewICDCodeDsntSupport).equalsIgnoreCase(Serenity.sessionVariableCalled("Manually Added Code").toString()));
							logger.info("New ICD Code matched with Value in DB  '"+Table+"' for does not support LCD");
							
							//validating ICD Group
							Assert.assertTrue("Doesn't Support ICD Group matched with Value in DB  "+Table,DBUtils.executeSQLQuery(sICDGroupDsntSupport).equalsIgnoreCase(Serenity.sessionVariableCalled("SupportICD10Group").toString()));			
							logger.info("ICD Group matched with Value in DB  '"+Table+"' for does not support LCD");
							
						}else{
							logger.info("DB Result found Empty");
							Assert.assertTrue("DB Result found Empty",false);
						}
				 
			     break;
			 default:  logger.info("No input is provided for the Switch Case");
			 		   Assert.assertTrue("Provided invalid case value",false);	
				
			}			
		
	}

	@Step
	public void ValidatingManual10CodeInTargetDB(String Table, String LCD_Article) throws Exception {
			String sQuery = "";
			String sTargetQuery="";
			if (LCD_Article.equalsIgnoreCase("LCD")) {
			
				sQuery="select HCPC_CODE from LCD."+Table+"  where LCD_ID="+Serenity.sessionVariableCalled("LCD_ID")+" and ICD_Code='"+Serenity.sessionVariableCalled("ICD Code")+"'";
				ArrayList<String> HCPCSCodes = DBUtils.executeSQLQueryMultipleRows(sQuery);
				if(!HCPCSCodes.isEmpty()){
				for(int i=0;i<HCPCSCodes.size();i++){					
					sTargetQuery="select manual_10 from LCD."+Table+"  where lcd_id= "+Serenity.sessionVariableCalled("LCD_ID")+" and hcpc_code='"+HCPCSCodes.get(i)+"' and ICD_Code='"+Serenity.sessionVariableCalled("Manually Added Code")+"'";
					Assert.assertTrue("Manual10 code matched as expected with value in target table '"+Table+"'",DBUtils.executeSQLQuery(sTargetQuery).equalsIgnoreCase("-1"));
					logger.info("Manual10 code matched as expected with value in target table as "+DBUtils.executeSQLQuery(sTargetQuery)+" for LCD");
				}
				}else{
					logger.info("No elements were retrieved from database");
					Assert.assertTrue("No elements were retrieved from database",false);					
				}
			} else {
				sQuery="select HCPC_CODE from LCD."+Table+"  where ARTICLE_ID="+Serenity.sessionVariableCalled("Article_ID")+" and ICD_Code='"+Serenity.sessionVariableCalled("ICD Code")+"'";
				ArrayList<String> HCPCSCodes = DBUtils.executeSQLQueryMultipleRows(sQuery);
				if(!HCPCSCodes.isEmpty()){
				for(int i=0;i<HCPCSCodes.size();i++){					
					sTargetQuery="select manual_10 from LCD."+Table+"  where article_id= "+Serenity.sessionVariableCalled("Article_ID")+" and hcpc_code='"+HCPCSCodes.get(i)+"' and ICD_Code='"+Serenity.sessionVariableCalled("Manually Added Code")+"'";
					Assert.assertTrue("Manual10 code matched as expected with value in target table '"+Table+"'",DBUtils.executeSQLQuery(sTargetQuery).equalsIgnoreCase("-1"));
					logger.info("Manual10 code matched as expected with value in target table as "+DBUtils.executeSQLQuery(sTargetQuery)+" for Article");
				}
				}else{
					logger.info("No elements were retrieved from database");
					Assert.assertTrue("No elements were retrieved from database",false);					
				}
			}
	}
	
	@Step
	public void validateNewCodesinUI(String sNewCodeType, String sOperation) {
		
		         String sNewICDCode="";
		         int iPageItemsCount=0;
		        
		      //Retrieve new ICDCode1 from session variable   
		      if(sNewCodeType.equalsIgnoreCase("NewICDCode1"))
		      {
		    	  sNewICDCode = Serenity.sessionVariableCalled("NewICDCode1") ;
		      }
		    	
		      //Retrieve new ICDCode2 from session variable 
		      if(sNewCodeType.equalsIgnoreCase("NewICDCode2"))
		      {
		    	  sNewICDCode = Serenity.sessionVariableCalled("NewICDCode2");		    	  
		      }
		      
		      
		    //Filter the Value in UI
		      
		    //Enter ICD COde
		 	 oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.RAPage_Input_TextArea, "arg", "ICD Code"),sNewICDCode);
			
			 //Click on Apply Filter
			 oSeleniumUtils.Click_given_WebElement(oRAPage.ApplyFilter_Btn);
			 
			 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			 
		    //Retrieve Page Items count			 
			 try {
				iPageItemsCount=oRAPage.retrievePageItemsCount("ICDCode","SupportTab");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			 
			 //Check whether pageItems count is 0
			 if(iPageItemsCount==0) 
			 {
			    Assert.assertTrue("New ICDCode: "+sNewICDCode+"is successfully deleted from UI",true);	 
			 }else{
				 Assert.assertTrue("New ICDCode: "+sNewICDCode+"is not deleted from UI",false);
			 }
				
	}

	@Step
	public void raClicksOnDataTab(String sTabName) {
		
		if(sTabName.equalsIgnoreCase("Support")||(sTabName.equalsIgnoreCase("DoesNotSupport"))){
    		Serenity.setSessionVariable("TabName").to(sTabName);
    	}
		
	     //if Tab name is Does Not Support 
		if(sTabName.equalsIgnoreCase("DoesNotSupport"))
		{
			sTabName="Does";					
		}
		  
		  //Click on the Tab Name based on the argument 
    	  oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue",sTabName));
    	  
    	  //Synchronization
    	  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);    	   
    	  logger.info("Clicked on the Tab:"+sTabName);
	    }
	
	@Step
	public void raValidatesRecordsDeletion(String sTabName,String sOptionalParam) {
		
		   boolean boolRowCheck=false;
		   	   
		   //Check whether any rows are present after deletion
		   boolRowCheck = oSeleniumUtils.is_WebElement_Present(oRAPage.RAPage_DeleteCombGridChkbox_Rows);
		  		   
		   //Check if the element is not displayed on the tab,if the element not displayed then records are deleted and below condition is passed 		   
		   if(!boolRowCheck)
		   {
			   Assert.assertTrue("Records are deleted from the DeleteCobination tab after clicking on DeleteCombiantion button",true); 
			   logger.info("Records are deleted from the DeleteCobination tab after clicking on DeleteCombiantion button");
		   }
		   else{	
			   
			    Assert.assertTrue("Records are not  deleted from the DeleteCobination tab after clicking on DeleteCombiantion button",false); 
			    logger.info("Records are not  deleted from the DeleteCobination tab after clicking on DeleteCombiantion button");
			   
		       }			
	    }

	@Step
	public void raValidateRecordsDeletionFromDB(String sTableName, String sCategoryType,String sLCD_Article) throws Exception 
	{
		
		    String sDeltatablQuery="";		    
		    int iRowCount=-1;		    
		    int iRowCountCheck=-1;
		    String sQuery="";		
		    ArrayList<String> HCPCSCodes=null;
		    String[] sTableNames=null;
		    String sICDCode="";
		
		if (sCategoryType.equalsIgnoreCase("Support") || sCategoryType.equalsIgnoreCase("Does")) 
		{
				if (sCategoryType.equalsIgnoreCase("Support"))
				{
					sICDCode = Serenity.sessionVariableCalled("ICD Code");
				} else {
					sICDCode = Serenity.sessionVariableCalled("ICD Code Doesn't");
				}

				// Query to retrieve all HCPC codes associated with the new Manually added ICD Code
				if (sLCD_Article.equalsIgnoreCase("LCD")) 
				{
					sQuery = "Select HCPC_CODE from LCD." + sTableName + " where LCD_ID="
							+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'";
					logger.info(sQuery);
	
				} else if (sLCD_Article.equalsIgnoreCase("Article")) {
					sQuery = "Select HCPC_CODE from LCD." + sTableName + " where ART_ID="
							+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'";
					System.out.println(sQuery);
				}

				  //Storing the HCPC Codes in the ArrayList
				   HCPCSCodes = DBUtils.executeSQLQueryMultipleRows(sQuery);

					//Traversing through the ArrayList if it is not empty
					if (!HCPCSCodes.isEmpty()) {
						for (int i = 0; i < HCPCSCodes.size(); i++) 
						{
								if (sLCD_Article.equalsIgnoreCase("LCD"))
								{
									sDeltatablQuery = "Select count(*) from (select * from LCD." + sTableName + " where LCD_ID="
											+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE=" + "'" + HCPCSCodes.get(i)
											+ "'" + " and ICD10_CODE=" + "'" + Serenity.sessionVariableCalled("NewICDCode1") + "'"
											+ ")";
			
								}
								else if (sLCD_Article.equalsIgnoreCase("Article")) 
								{
									sDeltatablQuery = "Select count(*) from (select * from LCD." + sTableName + " where ART_ID="
											+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE=" + "'" + HCPCSCodes.get(i)
											+ "'" + " and ICD10_CODE=" + "'" + Serenity.sessionVariableCalled("NewICDCode1") + "'"
											+ ")";
								}
			
								iRowCount = Integer.parseInt(DBUtils.executeSQLQuery(sDeltatablQuery));
								if (iRowCount == 0) {
									iRowCountCheck = 0;
								} else {
									iRowCountCheck = 1;
									break;
								}
				      }//end of for
			       }//end of if
	
				    else {
					      logger.error("HCPC code is not retrieved from the DB Query for the new Manual added ICDCode so cannot proceed further with execution");
					      Assert.assertTrue("HCPC code is not retrieved from the DB Query for the new Manual added ICDCode so cannot proceed further with execution",						false);
				        }
		
					// Validation of the row count Check
					if (iRowCountCheck == 0) 
					{
						logger.info("New ICDCode deleted from DB Support Delta Table::" + sTableName
								+ "  as no rows returned from DB Query as expected");
						Assert.assertTrue("New ICDCode deleted from DB Support Delta Table::" + sTableName
								+ "  as no rows returned from DB Que", true);	
					} else if (iRowCountCheck == 1) 
					{
						logger.error("New ICDCode not deleted from DB Support Delta Table::" + sTableName
								+ "  as rows returned from DB Query");
						Assert.assertTrue("New ICDCode not deleted from DB Support Delta Table::" + sTableName
								+ "  as rows returned from DB Query", false);
					}
		 }//end of if for category Support and DoesNotSupport	
		
		
		//Code to handle if the new code is added for both Support and DoesNotSupport categories
		if (sCategoryType.equalsIgnoreCase("both")) 
		 {
				sTableNames = sTableName.split(",");
	
				for (int j = 0; j < sTableNames.length; j++)
				{					
					//Query to retrieve all HCPC codes associated with the new Manually added ICD Code for Support Table
					if (sLCD_Article.equalsIgnoreCase("LCD")) {
						
						sQuery = "Select HCPC_CODE from LCD." + sTableNames[j] + " where LCD_ID="
								+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='"
								+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'";
						System.out.println(sQuery);
	
					} else if (sLCD_Article.equalsIgnoreCase("Article")) {
						
						sQuery = "Select HCPC_CODE from LCD." + sTableNames[j] + " where ART_ID="
								+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='"
								+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'";
						System.out.println(sQuery);
					}
	
					//Storing the HCPC Codes in the ArrayList
					HCPCSCodes = DBUtils.executeSQLQueryMultipleRows(sQuery);
	
					//Traversing through the ArrayList if it is not empty
					if (!HCPCSCodes.isEmpty()) {
						for (int i = 0; i < HCPCSCodes.size(); i++) {

							if (sLCD_Article.equalsIgnoreCase("LCD")) {

								sDeltatablQuery = "Select count(*) from (select * from LCD." + sTableNames[j]
										+ " where LCD_ID=" + Serenity.sessionVariableCalled("ID") + " and HCPC_CODE=" + "'"
										+ HCPCSCodes.get(i) + "'" + " and ICD10_CODE=" + "'"
										+ Serenity.sessionVariableCalled("NewICDCode1") + "'" + ")";

							} else if (sLCD_Article.equalsIgnoreCase("Article")) {

								sDeltatablQuery = "Select count(*) from (select * from LCD." + sTableNames[j]
										+ " where ART_ID=" + Serenity.sessionVariableCalled("ID") + " and HCPC_CODE=" + "'"
										+ HCPCSCodes.get(i) + "'" + " and ICD10_CODE=" + "'"
										+ Serenity.sessionVariableCalled("NewICDCode1") + "'" + ")";
							}

							iRowCount = Integer.parseInt(DBUtils.executeSQLQuery(sDeltatablQuery));

							if (iRowCount == 0) {
								iRowCountCheck = 0;
							} else {
								iRowCountCheck = 1;
								break;
							}
						} //end of for
	
						
						//Validation of the row count Check
						if (iRowCountCheck == 0) {
							
							logger.info("New ICDCode deleted from DB Support Delta Table::" + sTableNames[j]
									+ "  as no rows returned from DB Query as expected");
							Assert.assertTrue("New ICDCode deleted from DB Support Delta Table::" + sTableNames[j]
									+ "  as no rows returned from DB Que", true);
	
						} else if (iRowCountCheck == 1) {
							
							logger.error("New ICDCode not deleted from DB Support Delta Table::" + sTableNames[j]
									+ "  as rows returned from DB Query");
							Assert.assertTrue("New ICDCode not deleted from DB Support Delta Table::" + sTableNames[j]
									+ "  as rows returned from DB Query", false);
						}
	
					} //End of If for HCPC code empty check
	
				} //End of String Array traversal for

		} //End of If for Both CategoryType

 }

	@Step
	public void raValidateRecordsDeletionFromManualTableDB(String sTableName, String sCategoryType,String sLCD_Article) throws Exception {
		
		  String sManualTableQuery="";		    
		  int iRowCountCheck=-1;		    
		  int iSupportVal=2;
		  String sICDCode="";
		    
		//Setting the Support Value for the DB query based on the Category Type
		if (sCategoryType.equalsIgnoreCase("Support")) {
			iSupportVal = -1;
		} else {
			iSupportVal = 0;
		}

		if (sCategoryType.equalsIgnoreCase("Support") || sCategoryType.equalsIgnoreCase("Does")) {

			if (sCategoryType.equalsIgnoreCase("Support")) {
				sICDCode = Serenity.sessionVariableCalled("ICD Code");
			} else {
				sICDCode = Serenity.sessionVariableCalled("ICD Code Doesn't");
			}

			if (sLCD_Article.equalsIgnoreCase("LCD")) {
				sManualTableQuery = "Select count(*) from (select * from LCD." + sTableName + " where LCD_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
						+ Serenity.sessionVariableCalled("NewICDCode1") + "'" + " and BASE_ICD10_CODE=" + "'" + sICDCode
						+ "'" + "and SUPPORTS_10=" + iSupportVal + ")";
				
			} else if (sLCD_Article.equalsIgnoreCase("Article")) {
				sManualTableQuery = "Select count(*) from (select * from LCD." + sTableName + " where ART_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
						+ Serenity.sessionVariableCalled("NewICDCode1") + "'" + " and BASE_ICD10_CODE=" + "'" + sICDCode
						+ "'" + "and SUPPORTS_10=" + iSupportVal + ")";
			}
			iRowCountCheck = Integer.parseInt(DBUtils.executeSQLQuery(sManualTableQuery));

			// Validation of the row count Check
			if (iRowCountCheck == 0) {
				logger.info("New ICDCode deleted from DB Manual Code Combination  Table::" + sTableName
						+ "  as no rows returned from DB Query");
				Assert.assertTrue("New ICDCode deleted from DB Manual Code Combination Table::" + sTableName
						+ "  as no rows returned from DB Que", true);

			} else if (iRowCountCheck == 1) {
				logger.error("New ICDCode not deleted from DB Manual Code Combination Table::" + sTableName
						+ "  as no rows returned from DB Query");
				Assert.assertTrue("New ICDCode not deleted from DB Manual Code Combination Table::" + sTableName
						+ "  as no rows returned from DB Query", false);
			}
		}

		if (sCategoryType.equalsIgnoreCase("Both")) {

			// Support Delta Table
			if (sLCD_Article.equalsIgnoreCase("LCD")) {
				sManualTableQuery = "Select count(*) from (select * from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
						+ Serenity.sessionVariableCalled("NewICDCode1") + "'" + " and BASE_ICD10_CODE=" + "'"
						+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'" + "and SUPPORTS_10=-1)";
				
			} else if (sLCD_Article.equalsIgnoreCase("Article")) {
				sManualTableQuery = "Select count(*) from (select * from LCD.ART_MANUAL_CODE_COMB where ART_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
						+ Serenity.sessionVariableCalled("NewICDCode1") + "'" + " and BASE_ICD10_CODE=" + "'"
						+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'" + "and SUPPORTS_10=-1)";
			}

			iRowCountCheck = Integer.parseInt(DBUtils.executeSQLQuery(sManualTableQuery));

			// Validation of the row count Check
			if (iRowCountCheck == 0) {
				logger.info("New ICDCode deleted from DB Manual Code Combination  Table::LCD_MANUAL_CODE_COMB  Support Data as no rows returned from DB Query");
				Assert.assertTrue("New ICDCode deleted from DB Manual Code Combination Table:: LCD_MANUAL_CODE_COMB Support Data  as no rows returned from DB Query",true);

			} else if (iRowCountCheck == 1) {
				logger.error("New ICDCode not deleted from DB Manual Code Combination Table::LCD_CPT_ICD_SPRT_DELTA Support Data  as no rows returned from DB Query");
				Assert.assertTrue("New ICDCode not deleted from DB Manual Code Combination Table::LCD_CPT_ICD_SPRT_DELTA Support Data as no rows returned from DB Query",false);
			}

			// DoesNot Support Delta Table
			if (sLCD_Article.equalsIgnoreCase("LCD")) {
				sManualTableQuery = "Select count(*) from (select * from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
						+ Serenity.sessionVariableCalled("NewICDCode1") + "'" + " and BASE_ICD10_CODE=" + "'"
						+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'" + "and SUPPORTS_10=0)";
			} else if (sLCD_Article.equalsIgnoreCase("Article")) {
				sManualTableQuery = "Select count(*) from (select * from LCD.ART_MANUAL_CODE_COMB where ART_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
						+ Serenity.sessionVariableCalled("NewICDCode1") + "'" + " and BASE_ICD10_CODE=" + "'"
						+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'" + "and SUPPORTS_10=0)";
			}

			iRowCountCheck = Integer.parseInt(DBUtils.executeSQLQuery(sManualTableQuery));

			// Validation of the row count Check
			if (iRowCountCheck == 0) {
				logger.info("New ICDCode deleted from DB Manual Code Combination  Table::LCD_MANUAL_CODE_COMB DoesNot Support Data as no rows returned from DB Query");
				Assert.assertTrue("New ICDCode deleted from DB Manual Code Combination Table:: LCD_MANUAL_CODE_COMB DoesNot Support Data  as no rows returned from DB Query",true);

			} else if (iRowCountCheck == 1) {
				logger.error("New ICDCode not deleted from DB Manual Code Combination Table::LCD_MANUAL_CODE_COMBA DoesNot Support Data as no rows returned from DB Query");
				Assert.assertTrue("New ICDCode not deleted from DB Manual Code Combination Table::LCD_MANUAL_CODE_COMB DoesNot Support Data as no rows returned from DB Query",false);
			}

		}

	     }

	@Step
	public void raValidateRecordsDeletionFromUI(String sCategoryType, String sLCD_Article) throws Exception {
					
			String sQuery="";
			String sTableName="";
			int iPageItemsCount=-1;
			String sNewICDCode="";
			ArrayList<String> HCPCSCodes =null;
			String sICDCode="";
			
		// Click on the Support/Does Not Support Tab in RAReviewWorkQueue Screen
		// based on Gherkin TestData and set the Table name

		if (sCategoryType.equalsIgnoreCase("Support") || sCategoryType.equalsIgnoreCase("Does")) {
			
			if (sCategoryType.equalsIgnoreCase("Support")) {
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue", "Support"));
				sTableName = "CPT_ICD_SPRT_DELTA";

			} else {
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue", "Does"));
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				sTableName = "CPT_ICD_DONTSPRT_DELTA";
			}

			if (sCategoryType.equalsIgnoreCase("Support")) {
				sICDCode = Serenity.sessionVariableCalled("ICD Code");
			} else {
				sICDCode = Serenity.sessionVariableCalled("ICD Code Doesn't");
			}

			// Getting HCPCS Codes from DB for both LCD and Article
			if (sLCD_Article.equalsIgnoreCase("LCD")) {

				sQuery = "Select HCPC_CODE from LCD.LCD_" + sTableName + " where LCD_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'";
				logger.info(sQuery);

			} else {
				sQuery = "Select HCPC_CODE from LCD.ART_" + sTableName + " where ART_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'";
			}

			HCPCSCodes = DBUtils.executeSQLQueryMultipleRows(sQuery);

			if (!HCPCSCodes.isEmpty()) {

				for (int i = 0; i < HCPCSCodes.size(); i++) {

					// Enter HCPCS Code
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.RAPage_Input_TextArea, "arg", "CPT/HCPCS Code"),
							HCPCSCodes.get(i));

					// Enter ICD COde
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.RAPage_Input_TextArea, "arg", "ICD Code"),Serenity.sessionVariableCalled("NewICDCode"));

					sNewICDCode = Serenity.sessionVariableCalled("NewICDCode");

					// Click on Apply Filter
					oSeleniumUtils.Click_given_WebElement(oRAPage.ApplyFilter_Btn);

					// Synchronization
					oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

					// Validating the page Items count after the Filters applied
					try {
						iPageItemsCount = oRAPage.retrievePageItemsCount("ICDCode", "SupportTab");
					} catch (Exception e) {
						e.printStackTrace();
					}

					// Check whether pageItems count is 0
					if (iPageItemsCount == 0) {

						logger.info("New ICDCode: " + sNewICDCode + "is successfully deleted from UI for HCPC Code:"
								+ HCPCSCodes.get(i));
						Assert.assertTrue("New ICDCode: " + sNewICDCode
								+ "is successfully deleted from UI for HCPC Code:" + HCPCSCodes.get(i), true);
					} else {
						logger.error("New ICDCode: " + sNewICDCode + "is not deleted from UI for HCPC Code:"
								+ HCPCSCodes.get(i));
						Assert.assertTrue("New ICDCode: " + sNewICDCode + "is not deleted from UI for HCPC Code:"
								+ HCPCSCodes.get(i), false);
					}

					//Click on ClearAll Filters
					oSeleniumUtils.Click_given_WebElement(oRAPage.ClearAllFilters_Btn);

					//Synchronization
					oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

				} // End of For loop
			} else {
				logger.info("No elements were retrieved from query");
				Assert.assertTrue("No elements were retrieved from query", false);
			} // End of if

		} // End of If for checking the Category Support or DoesNotSupport

		else {
			raValidateRecordsDeletionFromUIforBothCategories(sCategoryType, sLCD_Article);

		}
				
	     }//End of Method		

    @Step
	public void raValidateRecordsDeletionFromUIforBothCategories(String sCategoryType, String sLCD_Article) throws Exception {
			
			ArrayList<String> HCPCSCodesSupport=null; 
			ArrayList<String> HCPCSCodesDoesNotSupport=null; 			
			
			   
		      switch (sLCD_Article)				      
		      {			      
			      case "LCD":
			    	  
			    	  String sQuery1="Select HCPC_CODE from LCD.LCD_CPT_ICD_SPRT_DELTA where LCD_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_Code='"+Serenity.sessionVariableCalled("SupportICD10CodeBoth")+"'";
			    	  HCPCSCodesSupport = DBUtils.executeSQLQueryMultipleRows(sQuery1);
			    	  
			    	  String sQuery2="Select HCPC_CODE from LCD.LCD_CPT_ICD_DONTSPRT_DELTA  where LCD_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_Code='"+Serenity.sessionVariableCalled("SupportICD10CodeBoth")+"'";
			    	  HCPCSCodesDoesNotSupport = DBUtils.executeSQLQueryMultipleRows(sQuery2);		    	  
			    	  
			       break;
			      
			      case "Article":			    	  
			    	  
			    	  sQuery1="Select HCPC_CODE from LCD.ART_CPT_ICD_SPRT_DELTA where ART_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_Code='"+Serenity.sessionVariableCalled("SupportICD10CodeBoth")+"'";
			    	  HCPCSCodesSupport = DBUtils.executeSQLQueryMultipleRows(sQuery1);
			    	  
			    	  sQuery2="Select HCPC_CODE from LCD.ART_CPT_ICD_SPRT_DELTA  where ART_ID="+Serenity.sessionVariableCalled("ID")+" and ICD10_Code='"+Serenity.sessionVariableCalled("SupportICD10CodeBoth")+"'";
			    	  HCPCSCodesDoesNotSupport = DBUtils.executeSQLQueryMultipleRows(sQuery2);	
			    	  
			       break;   
			       
			      default:  logger.info("No input is provided for the Switch Case");
			      		    Assert.assertTrue("Provided invalid case value",false);	
		      }		      
		      
		            //Support Tab validations	
		             validateRAScreenForNewCodesDeletion(HCPCSCodesSupport); 	
		          
			        //Click on DoesNot Support Tab
				    oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Does"));
				    oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
				    
				    //DoeNotSupport Tab validations
				    validateRAScreenForNewCodesDeletion(HCPCSCodesDoesNotSupport); 
			   	      
		}//End of Method
    
    @Step
    public void validateRAScreenForNewCodesDeletion(ArrayList<String> HCPCCodes)      
    {
    	
    	String sNewICDCode="";
    	int iPageItemsCount=-1;
    	
    	if(!HCPCCodes.isEmpty())
		{					
			for(int i=0;i<HCPCCodes.size();i++)
			{			
				//Enter HCPCS Code
				oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.RAPage_Input_TextArea, "arg", "CPT/HCPCS Code"),HCPCCodes.get(i) );
				
				//Enter ICD COde
				oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.RAPage_Input_TextArea, "arg", "ICD Code"), Serenity.sessionVariableCalled("NewICDCode"));
				
				sNewICDCode = Serenity.sessionVariableCalled("NewICDCode");
				
				//Click on Apply Filter
				oSeleniumUtils.Click_given_WebElement(oRAPage.ApplyFilter_Btn);
				
				//Synchronization
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
							

			     //Validating the page Items count after the Filters applied
			    try {
					   iPageItemsCount=oRAPage.retrievePageItemsCount("PageItemsCount","SupportTab");
					}  catch (Exception e) {							
						e.printStackTrace();
					                         }
					 
					 //Check whether pageItems count is 0
					 if(iPageItemsCount==0) 
					 {								
						logger.info("New ICDCode: "+sNewICDCode+"is successfully deleted from UI for HCPC Code:"+HCPCCodes.get(i)); 
					    Assert.assertTrue("New ICDCode: "+sNewICDCode+"is successfully deleted from UI for HCPC Code:"+HCPCCodes.get(i),true);	 
					 }else{
						 logger.error("New ICDCode: "+sNewICDCode+"is not deleted from UI for HCPC Code:"+HCPCCodes.get(i)); 
						 Assert.assertTrue("New ICDCode: "+sNewICDCode+"is not deleted from UI for HCPC Code:"+HCPCCodes.get(i),false);	
						 }	
					 
					//Click on ClearAll Filters
					oSeleniumUtils.Click_given_WebElement(oRAPage.ClearAllFilters_Btn);
						
					//Synchronization
					oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading); 				
			
		    }//End of For loop
		}else{
			   logger.info("No elements were retrieved from query");
			   Assert.assertTrue("No elements were retrieved from query",false);			
			   }
    	
    }
	
    @Step
    public void raValidateDosToinTargetTable(String sDates, String sTargetTable, String sLCD_Article,String sCategoryType) throws Exception 
    {
    	
    	  int iSupportVal=-2;
    	  String sQuery1="";     	   	  	   	  
    	  List<String> HCPCSCodes=null;
    	  String sDOSToValue="";    	  
    	  String[] sDatesNew;    	   	  
    	  sDatesNew= sDates.split(","); 
    	  System.out.println("After spliting: "+sDatesNew[0]);
    	  
    	    
    	//Setting the Support Value for the DB query based on the Category Type
		if (sCategoryType.equalsIgnoreCase("Support")) {
			iSupportVal = -1;				
		} else {
			iSupportVal = 0;			
		}		

		//Retrieve HCPCCodes stored in Session variables	
		HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");
		
		
		  switch (sLCD_Article)				      
	      {			      
		      case "LCD":		    	  
		    	  
		    	  for (int j=0;j<=HCPCSCodes.size()-1;j++)
		    	  {		    	  
			    	  sQuery1="Select  TO_CHAR(DOS_To,'mm/dd/yyyy') from LCD.LCD_CPT_ICD_LINKS where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and HCPC_CODE='"+HCPCSCodes.get(j)+"'"+ " and ICD_Code='"+Serenity.sessionVariableCalled("NewICDCode1")+"'"+ " and SUPPORTS_10="+iSupportVal+" and  Manual_10=-1 and LCD_VERSION=1";
			    	  sDOSToValue = DBUtils.executeSQLQuery(sQuery1);			    	  
			    	  if (sDOSToValue.compareTo(sDatesNew[0])==0)
			    	
			    	  {			    		  
			    		  Assert.assertTrue("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+sDOSToValue +" for HCPC Code:"+HCPCSCodes.get(j)+ "are Not equal.Codes are Not DateBanded in TargetTable for LCD:"+Serenity.sessionVariableCalled("ID"),true);
			    		  logger.info("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+" DBDosToDate"+ " for HCPC Code:"+HCPCSCodes.get(j)+"are equal.Codes are DateBanded in TargetTable for LCD:"+Serenity.sessionVariableCalled("ID"));
			    	  }	
			    	  
			    	  else{			    		  
			    		    logger.error("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue+" for HCPC Code:"+HCPCSCodes.get(j) + "are Not equal.Codes are Not DateBanded in TargetTable for LCD:"+Serenity.sessionVariableCalled("ID"));
			    		    Assert.assertTrue("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue+" for HCPC Code:"+HCPCSCodes.get(j)+ "are Not equal.Codes are Not DateBanded in TargetTable for LCD:"+Serenity.sessionVariableCalled("ID"),false);			    		  
			    	       }			    	  
		    	    }	  
		    	  
		       break;
		      
		      case "Article":	
		    	  
		    	  for (int j=0;j<=HCPCSCodes.size()-1;j++)
		    	  {		    	  
			    	  sQuery1="Select  TO_CHAR(DOS_To,'mm/dd/yyyy') from LCD.ARTICLE_CPT_ICD_LINKS where ARTICLE_ID="+Serenity.sessionVariableCalled("ID")+ "  and HCPC_CODE='"+HCPCSCodes.get(j)+"'"+ " and ICD_Code='"+Serenity.sessionVariableCalled("NewICDCode1")+"'"+ " and SUPPORT_10="+iSupportVal+" and  Manual_10=-1 and ARTICLE_VERSION=1";
			    	  sDOSToValue = DBUtils.executeSQLQuery(sQuery1);			    	
			    	  if (sDOSToValue.compareTo(sDatesNew[0])==0)
			    	  {			    		  
			    		  Assert.assertTrue("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue + " for HCPC Code:"+HCPCSCodes.get(j)+ "are Not equal.Codes are Not DateBanded in TargetTable for Article:"+Serenity.sessionVariableCalled("ID"),true);
			    		  logger.info("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue+ " for HCPC Code:"+HCPCSCodes.get(j)+"are equal.Codes are DateBanded in TargetTable for Article:"+Serenity.sessionVariableCalled("ID"));
			    	  }	
			    	  
			    	  else{			    		  
			    		    logger.error("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue+" for HCPC Code:"+HCPCSCodes.get(j) + "are Not equal.Codes are Not DateBanded in TargetTable for Article:"+Serenity.sessionVariableCalled("ID"));
			    		    Assert.assertTrue("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue +" for HCPC Code:"+HCPCSCodes.get(j)+ "are Not equal.Codes are Not DateBanded in TargetTable for Article:"+Serenity.sessionVariableCalled("ID"),false);  		  
			    		  
			    	       }				    	  
		    	  }	  			    	
		    	  
		       break;   
		       
		      default:  logger.info("No input is provided for the Switch Case");
	          		    Assert.assertTrue("Provided invalid case value",false);				
	      }		
	    	
		
	}

    @Step  
	public void raCapturesHCPCCodes(String sCategory, String sLCD_Article) throws Exception {

		  String sTableName="";
		  String sICDCode="";
		  String sQuery="";
		  List<String> HCPCSCodes=null;		  
		
		if (sCategory.equalsIgnoreCase("Support") || sCategory.equalsIgnoreCase("Does"))
		   {
				if (sCategory.equalsIgnoreCase("Support")) {
					sICDCode = Serenity.sessionVariableCalled("ICD Code");
					sTableName = "CPT_ICD_SPRT_DELTA";
				} else {
					sICDCode = Serenity.sessionVariableCalled("ICD Code Doesn't");
					sTableName = "CPT_ICD_DONTSPRT_DELTA";
				}
		   }
			// Query to retrieve all HCPC codes associated with the new Manually added ICD Code
			if (sLCD_Article.equalsIgnoreCase("LCD")) {
				sQuery = "Select distinct HCPC_CODE from LCD.LCD_" + sTableName + " where LCD_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'";
				logger.info(sQuery);
				sTableName = "CPT_ICD_SPRT_DELTA";

			} else if (sLCD_Article.equalsIgnoreCase("Article")) {
				sQuery = "Select distinct HCPC_CODE from LCD.ART_" + sTableName + " where ART_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'";
				System.out.println(sQuery);
			}

			// Storing the HCPC Codes in the ArrayList
			HCPCSCodes = DBUtils.executeSQLQueryMultipleRows(sQuery);			
            Serenity.setSessionVariable("HCPCCodes").to(HCPCSCodes);           
                   
            
		}//End of method    

    @Step
    public void raValidateRecordsDeletionFromDBNewCodes(String sTableName, String sCategoryType, String sLCD_Article,String sNewCodes) throws Exception {
		
		
		    String sDeltatablQuery="";		    
		    int iRowCount=-1;		    
		    int iRowCountCheck=-1;
		    String sQuery="";		
		    ArrayList<String> HCPCSCodes=null;
		    String[] sTableNames=null;		   
		    String[] sManualCodes=null;			   
		    int iCodeNo=0;		
		    int iStartIndex=0;
		    int iLoopCounter=0;
		    		     
		    //Split the codes based on comma  
		    sManualCodes=sNewCodes.split(",");		    
		    
		      if(sManualCodes.length==1)  //If there is only one new manual code to process
		      {
		    	  iCodeNo = Integer.parseInt(CharMatcher.DIGIT.retainFrom(sNewCodes));	//Capture the digit in the text to retrieve the session variable based on the code 	    	 
		    	  iLoopCounter= iCodeNo;  //Storing it as Loop counter for use in the For loop  
		    	  
		      }else if (sManualCodes.length>1) //If there is more than one Manual Code
		      {
		    	  iCodeNo =1;
		    	  iLoopCounter= sManualCodes.length;		    	  
		      }   
		      
		    
		
		if (sCategoryType.equalsIgnoreCase("Support") || sCategoryType.equalsIgnoreCase("Does")) {
			if (sCategoryType.equalsIgnoreCase("Support")) {
				 
			} else {
				
			}

					
			//Retrieve HCPCCodes stored in Session variables	
			HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");

		//Executing For loop to retrieve the New manual code stored in  the session variables 	
		for(iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
		{	
			// Traversing through the ArrayList if it is not empty
			if (!HCPCSCodes.isEmpty()) {
				for (int i = 0; i < HCPCSCodes.size(); i++) {
					if (sLCD_Article.equalsIgnoreCase("LCD")) {
						sDeltatablQuery = "Select count(*) from (select * from LCD." + sTableName + " where LCD_ID="
								+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE=" + "'" + HCPCSCodes.get(i)
								+ "'" + " and ICD10_CODE=" + "'" + Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'"
								+ ")";

					} else if (sLCD_Article.equalsIgnoreCase("Article")) {
						sDeltatablQuery = "Select count(*) from (select * from LCD." + sTableName + " where ART_ID="
								+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE=" + "'" + HCPCSCodes.get(i)
								+ "'" + " and ICD10_CODE=" + "'" + Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'"
								+ ")";
					}

					iRowCount = Integer.parseInt(DBUtils.executeSQLQuery(sDeltatablQuery));
					if (iRowCount == 0) {
						iRowCountCheck = 0;
					} else {
						iRowCountCheck = 1;
						break;
					}
				} // end of for
			} // end of if

			else {
				logger.error(
						"HCPC code is not retrieved from the DB Query for the new Manual added ICDCode so cannot proceed further with execution");
				Assert.assertTrue(
						"HCPC code is not retrieved from the DB Query for the new Manual added ICDCode so cannot proceed further with execution",
						false);
			}

			// Validation of the row count Check
			if (iRowCountCheck == 0) {
				logger.info("New ICDCode deleted from DB Support Delta Table::" + sTableName
						+ "  as no rows returned from DB Query as expected");
				Assert.assertTrue("New ICDCode deleted from DB Support Delta Table::" + sTableName
						+ "  as no rows returned from DB Que", true);

			} else if (iRowCountCheck == 1) {
				logger.error("New ICDCode not deleted from DB Support Delta Table::" + sTableName
						+ "  as rows returned from DB Query");
				Assert.assertTrue("New ICDCode not deleted from DB Support Delta Table::" + sTableName
						+ "  as rows returned from DB Query", false);
			}
		} // end of of for category Support and DoesNotSupport
		
}//End for for new ICD Codes	
		

		
		// Code to handle if the new code is added for both Support and DoesNotSupport categories
		if (sCategoryType.equalsIgnoreCase("both")) {
			
			for(iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
			{			
			
						sTableNames = sTableName.split(",");
			
						for (int j = 0; j < sTableNames.length; j++) {
							
							// Query to retrieve all HCPC codes associated with the new Manually added ICD Code for Support Table
							if (sLCD_Article.equalsIgnoreCase("LCD")) {
								
								sQuery = "Select HCPC_CODE from LCD." + sTableNames[j] + " where LCD_ID="
										+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='"
										+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'";
								System.out.println(sQuery);
			
							} else if (sLCD_Article.equalsIgnoreCase("Article")) {
								
								sQuery = "Select HCPC_CODE from LCD." + sTableNames[j] + " where ART_ID="
										+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='"
										+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'";
								System.out.println(sQuery);
							}
			
							// Storing the HCPC Codes in the ArrayList
							HCPCSCodes = DBUtils.executeSQLQueryMultipleRows(sQuery);
			
							// Traversing through the ArrayList if it is not empty
							if (!HCPCSCodes.isEmpty()) {
								for (int i = 0; i < HCPCSCodes.size(); i++) {
									
									if (sLCD_Article.equalsIgnoreCase("LCD")) {
										
										sDeltatablQuery = "Select count(*) from (select * from LCD." + sTableNames[j]
												+ " where LCD_ID=" + Serenity.sessionVariableCalled("ID") + " and HCPC_CODE=" + "'"
												+ HCPCSCodes.get(i) + "'" + " and ICD10_CODE=" + "'"
												+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'" + ")";
									
									} else if (sLCD_Article.equalsIgnoreCase("Article")) {
										
										sDeltatablQuery = "Select count(*) from (select * from LCD." + sTableNames[j]
												+ " where ART_ID=" + Serenity.sessionVariableCalled("ID") + " and HCPC_CODE=" + "'"
												+ HCPCSCodes.get(i) + "'" + " and ICD10_CODE=" + "'"
												+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'" + ")";
									}
			
									iRowCount = Integer.parseInt(DBUtils.executeSQLQuery(sDeltatablQuery));
			
									if (iRowCount == 0) {
										iRowCountCheck = 0;
									} else {
										iRowCountCheck = 1;
										break;
									}
								} // end of for
			
								
								// Validation of the row count Check
								if (iRowCountCheck == 0) {
									
									logger.info("New ICDCode deleted from DB Support Delta Table::" + sTableNames[j]
											+ "  as no rows returned from DB Query as expected");
									Assert.assertTrue("New ICDCode deleted from DB Support Delta Table::" + sTableNames[j]
											+ "  as no rows returned from DB Que", true);
			
								} else if (iRowCountCheck == 1) {
									
									logger.error("New ICDCode not deleted from DB Support Delta Table::" + sTableNames[j]
											+ "  as rows returned from DB Query");
									Assert.assertTrue("New ICDCode not deleted from DB Support Delta Table::" + sTableNames[j]
											+ "  as rows returned from DB Query", false);
								}
			
							} // End of If for HCPC code empty check
			
						} // End of String Array traversal for
			  
			   }//End of For loop		

		} // End of If for Both CategoryType
				
	}

    @Step
    public void raValidateRecordsDeletionFromManualTableDBNewCodes(String sTableName, String sCategoryType,String sLCD_Article, String sNewCodes) 
	{
			
		  String sManualTableQuery="";		    
		  int iRowCountCheck=-1;		    
		  int iSupportVal=2;
		  String sICDCode="";
		  String[] sManualCodes=null;
		  int iCodeNo=0;
		  int iLoopCounter=0;		  
		  
		//If there is only one new manual code to process
		  sManualCodes=sNewCodes.split(",");
		    
	      if(sManualCodes.length==1)
	      {	    	 
	    	  iCodeNo = Integer.parseInt(CharMatcher.DIGIT.retainFrom(sNewCodes));//Capture the digit in the text to retrieve the session variable based on the code	    	  
	    	  iLoopCounter= iCodeNo; //Storing it as Loop counter for use in the For loop  
	    	  
	      }else if (sManualCodes.length>1)//If there is more than one Manual Code
	      {
	    	  iCodeNo =1;
	    	  iLoopCounter= sManualCodes.length;		    	  
	      }   
	      
		  		    
		//Setting the Support Value for the DB query based on the Category Type
		if (sCategoryType.equalsIgnoreCase("Support")) {
			iSupportVal = -1;
		} else {
			iSupportVal = 0;
		}
			
			if (sCategoryType.equalsIgnoreCase("Support") || sCategoryType.equalsIgnoreCase("Does")) {
				
				//Executing For loop to retrieve the New manual code stored in  the session variables
					for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
					{		
					
					    if (sCategoryType.equalsIgnoreCase("Support")) {
								sICDCode = Serenity.sessionVariableCalled("ICD Code");
							} else {
								sICDCode = Serenity.sessionVariableCalled("ICD Code Doesn't");
							}
				
							if (sLCD_Article.equalsIgnoreCase("LCD")) {
								sManualTableQuery = "Select count(*) from (select * from LCD." + sTableName + " where LCD_ID="
										+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
										+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'" + " and BASE_ICD10_CODE=" + "'" + sICDCode
										+ "'" + "and SUPPORTS_10=" + iSupportVal + ")";
								
							} else if (sLCD_Article.equalsIgnoreCase("Article")) {
								sManualTableQuery = "Select count(*) from (select * from LCD." + sTableName + " where ART_ID="
										+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
										+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'" + " and BASE_ICD10_CODE=" + "'" + sICDCode
										+ "'" + "and SUPPORTS_10=" + iSupportVal + ")";
							}
							
							iRowCountCheck = Integer.parseInt(DBUtils.executeSQLQuery(sManualTableQuery));
				
							// Validation of the row count Check
							if (iRowCountCheck == 0) {
								logger.info("New ICDCode deleted from DB Manual Code Combination  Table::" + sTableName
										+ "  as no rows returned from DB Query");
								Assert.assertTrue("New ICDCode deleted from DB Manual Code Combination Table::" + sTableName
										+ "  as no rows returned from DB Que", true);
				
							} else if (iRowCountCheck == 1) {
								logger.error("New ICDCode not deleted from DB Manual Code Combination Table::" + sTableName
										+ "  as no rows returned from DB Query");
								Assert.assertTrue("New ICDCode not deleted from DB Manual Code Combination Table::" + sTableName
										+ "  as no rows returned from DB Query", false);
							}	
					}//end of for loop
			  }//End of If
				

		if (sCategoryType.equalsIgnoreCase("Both")) 
		{

			//Executing For loop to retrieve the New manual code stored in  the session variables
		  	for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
			 { 
					// Support Delta Table
					if (sLCD_Article.equalsIgnoreCase("LCD")) {
						sManualTableQuery = "Select count(*) from (select * from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="
								+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
								+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'" + " and BASE_ICD10_CODE=" + "'"
								+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'" + "and SUPPORTS_10=-1)";
						
					} else if (sLCD_Article.equalsIgnoreCase("Article")) {
						sManualTableQuery = "Select count(*) from (select * from LCD.ART_MANUAL_CODE_COMB where ART_ID="
								+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
								+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'" + " and BASE_ICD10_CODE=" + "'"
								+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'" + "and SUPPORTS_10=-1)";
					}
		
					iRowCountCheck = Integer.parseInt(DBUtils.executeSQLQuery(sManualTableQuery));
		
					// Validation of the row count Check
					if (iRowCountCheck == 0) {
						logger.info("New ICDCode deleted from DB Manual Code Combination  Table::LCD_MANUAL_CODE_COMB  Support Data as no rows returned from DB Query");
						Assert.assertTrue("New ICDCode deleted from DB Manual Code Combination Table:: LCD_MANUAL_CODE_COMB Support Data  as no rows returned from DB Query",true);
		
					} else if (iRowCountCheck == 1) {
						logger.error("New ICDCode not deleted from DB Manual Code Combination Table::LCD_CPT_ICD_SPRT_DELTA Support Data  as no rows returned from DB Query");
						Assert.assertTrue("New ICDCode not deleted from DB Manual Code Combination Table::LCD_CPT_ICD_SPRT_DELTA Support Data as no rows returned from DB Query",false);
					}
		
					// DoesNot Support Delta Table
					if (sLCD_Article.equalsIgnoreCase("LCD")) {
						sManualTableQuery = "Select count(*) from (select * from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="
								+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
								+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'" + " and BASE_ICD10_CODE=" + "'"
								+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'" + "and SUPPORTS_10=0)";
					} else if (sLCD_Article.equalsIgnoreCase("Article")) {
						sManualTableQuery = "Select count(*) from (select * from LCD.ART_MANUAL_CODE_COMB where ART_ID="
								+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
								+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'" + " and BASE_ICD10_CODE=" + "'"
								+ Serenity.sessionVariableCalled("SupportICD10CodeBoth") + "'" + "and SUPPORTS_10=0)";
					}
		
					iRowCountCheck = Integer.parseInt(DBUtils.executeSQLQuery(sManualTableQuery));
		
					// Validation of the row count Check
					if (iRowCountCheck == 0) {
						logger.info("New ICDCode deleted from DB Manual Code Combination  Table::LCD_MANUAL_CODE_COMB DoesNot Support Data as no rows returned from DB Query");
						Assert.assertTrue("New ICDCode deleted from DB Manual Code Combination Table:: LCD_MANUAL_CODE_COMB DoesNot Support Data  as no rows returned from DB Query",true);
		
					} else if (iRowCountCheck == 1) {
						logger.error("New ICDCode not deleted from DB Manual Code Combination Table::LCD_MANUAL_CODE_COMBA DoesNot Support Data as no rows returned from DB Query");
						Assert.assertTrue("New ICDCode not deleted from DB Manual Code Combination Table::LCD_MANUAL_CODE_COMB DoesNot Support Data as no rows returned from DB Query",false);
					}

			 }//end of if loop
		}//End of If	
		
	
	}//end of method

    @Step
    public void raValidateDosToinTargetTableforNewCodes(String sDates, String sTargetTable, String sLCD_Article,String sCategoryType, String sNewCodes) 
	{
				
	  int iSupportVal=-2;
   	  String sQuery1="";    	   	  	   	  
   	  List<String> HCPCSCodes=null;
   	  String sDOSToValue="";    	  
   	  String[] sDatesNew;    	   	  
   	  sDatesNew= sDates.split(","); 
      int iCodeNo=0;
	  int iLoopCounter=0;	  
	  String[] sManualCodes=null;
	  
	  sManualCodes=sNewCodes.split(",");
	   
	//If there is only one new manual code to process 
    if(sManualCodes.length==1)
    {  	  
  	  iCodeNo = Integer.parseInt(CharMatcher.DIGIT.retainFrom(sNewCodes));//Capture the digit in the text to retrieve the session variable based on the code  	 
  	  iLoopCounter= iCodeNo;//Storing it as Loop counter for use in the For loop  
  	  
    }else if (sManualCodes.length>1)//If there is more than one Manual Code
    {
  	  iCodeNo =1;
  	  iLoopCounter= sManualCodes.length;		    	  
    }      	  
   	    
   	//Setting the Support Value for the DB query based on the Category Type
		if (sCategoryType.equalsIgnoreCase("Support")) {
			iSupportVal = -1;				
		} else {
			iSupportVal = 0;			
		}		

		//Retrieve HCPCCodes stored in Session variables	
		HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");		
		
		  switch (sLCD_Article)				      
	      {			      
		      case "LCD":
			
		    	  	for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
		    	  		{ 
					    //Executing For loop to retrieve the New manual code stored in  the session variables 
				    	  for (int j=0;j<=HCPCSCodes.size()-1;j++)
				    	  {		    	  
					    	  sQuery1="Select  TO_CHAR(DOS_To,'mm/dd/yyyy') from LCD.LCD_CPT_ICD_LINKS where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and HCPC_CODE='"+HCPCSCodes.get(j)+"'"+ " and ICD_Code='"+Serenity.sessionVariableCalled("NewICDCode"+iStartIndex)+"'"+ " and SUPPORTS_10="+iSupportVal+" and  Manual_10=-1 and LCD_VERSION=1";
					    	  sDOSToValue = DBUtils.executeSQLQuery(sQuery1);			    	  
					    	  if (sDOSToValue.compareTo(sDatesNew[0])==0)					    	
					    	  {			    		  
					    		  Assert.assertTrue("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+sDOSToValue +" for HCPC Code:"+HCPCSCodes.get(j)+ "are  equal.Codes are  DateBanded in TargetTable for LCD:"+Serenity.sessionVariableCalled("ID"),true);
					    		  logger.info("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+" DBDosToDate"+ " for HCPC Code:"+HCPCSCodes.get(j)+"are equal.Codes are DateBanded in TargetTable for LCD:"+Serenity.sessionVariableCalled("ID"));
					    	  }	
					    	  
					    	  else{			    		  
					    		    logger.error("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue+" for HCPC Code:"+HCPCSCodes.get(j) + "are Not equal.Codes are Not DateBanded in TargetTable for LCD:"+Serenity.sessionVariableCalled("ID"));
					    		    Assert.assertTrue("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue+" for HCPC Code:"+HCPCSCodes.get(j)+ "are Not equal.Codes are Not DateBanded in TargetTable for LCD:"+Serenity.sessionVariableCalled("ID"),false);			    		  
					    	       }			    	  
				    	     }	
					} 
			    	  
		       break;
		      
		      case "Article":			

		    	//Executing For loop to retrieve the New manual code stored in  the session variables 
		    	 for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
					{	
				    	  for (int j=0;j<=HCPCSCodes.size()-1;j++)
				    	  {		    	  
					    	  sQuery1="Select  TO_CHAR(DOS_To,'mm/dd/yyyy') from LCD.ARTICLE_CPT_ICD_LINKS where ARTICLE_ID="+Serenity.sessionVariableCalled("ID")+ "  and HCPC_CODE='"+HCPCSCodes.get(j)+"'"+ " and ICD_Code='"+Serenity.sessionVariableCalled("NewICDCode"+iStartIndex)+"'"+ " and SUPPORT_10="+iSupportVal+" and  Manual_10=-1 and ARTICLE_VERSION=1";
					    	  sDOSToValue = DBUtils.executeSQLQuery(sQuery1);			    	
					    	  if (sDOSToValue.compareTo(sDatesNew[0])==0)
					    	  {			    		  
					    		  Assert.assertTrue("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue + " for HCPC Code:"+HCPCSCodes.get(j)+ "are  equal.Codes are DateBanded in TargetTable for Article:"+Serenity.sessionVariableCalled("ID"),true);
					    		  logger.info("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue+ " for HCPC Code:"+HCPCSCodes.get(j)+"are equal.Codes are DateBanded in TargetTable for Article:"+Serenity.sessionVariableCalled("ID"));
					    	  }	
					    	  
					    	  else{			    		  
					    		    logger.error("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue+" for HCPC Code:"+HCPCSCodes.get(j) + "are Not equal.Codes are Not DateBanded in TargetTable for Article:"+Serenity.sessionVariableCalled("ID"));
					    		    Assert.assertTrue("Entered Dates while deleting the CodeCombination ::"+sDatesNew[0]+" and DB DOS_TO dates: "+ sDOSToValue +" for HCPC Code:"+HCPCSCodes.get(j)+ "are Not equal.Codes are Not DateBanded in TargetTable for Article:"+Serenity.sessionVariableCalled("ID"),false);  		  
					    		  
					    	       }				    	  
				    	  }	 
					}	  
		    	  
		       break;   
		       
		      default:  logger.info("No input is provided for the Switch Case");
	          		    Assert.assertTrue("Provided invalid case value",false);				
	      }			
		
	}

    @Step
	public void raEntersNewManualICDCode(String sLCD_Article) {
		 
		String sNewICD10Code2="";
		
		sNewICD10Code2= Serenity.sessionVariableCalled("NewICDCode2");
		
		if(!(sNewICD10Code2.equalsIgnoreCase(""))){
			Serenity.setSessionVariable("NewICDCode").to(sNewICD10Code2);
			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sICDCodeTxt, sNewICD10Code2);
			logger.info("RA entered ICD Group as '"+sNewICD10Code2);
		}else{
			oSeleniumUtils.clear_Text(oRAPage.sICDCodeTxt);
			logger.info("ICD Code value is empty");
		 }
		
	}
	
    @Step
    public void raValidatesManualIndicatorinTarget(String sIndicatorVal,String sLCD_Article,String sLCDArticleVersion) throws Exception
    {
		    
		  String sICDCode="";
		  String sQuery="";
		  int sICDGroup= 0;		  
		  int iManualIndicator=-2; 
		  List<String> HCPCCodes = null; 
		  int iLCDArticleVersion = -2;	   	
		 List<String> Jurisdictions = null;	
		 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
		 String sTargetTableName = "";	   	   
		 int j=0;	
		 Set<String> keys=null;
		 List<String>  Jurs =null;	   	
		   	
		 	int iIndicatorVal = Integer.parseInt(sIndicatorVal);
		  sICDCode  = Serenity.sessionVariableCalled("NewICDCode");
		  sICDGroup = Integer.parseInt(Serenity.sessionVariableCalled("NewICDGroup"));
		  
		  //Retrieve the HCPC codes from the session variable    	
	       HCPCCodes = Serenity.sessionVariableCalled("HCPCCodes");
	       iLCDArticleVersion = Integer.parseInt(sLCDArticleVersion);
	       	
	       //Assign table names based on whether it is LCD or Article 
	    	  if(sLCD_Article.equals("LCD"))
	    	  {   		  
	    		   sTargetTableName = "LCD_CPT_ICD_LINKS";	    		   
	    	   }
	    	  else if (sLCD_Article.equals("Article"))
	    	  { 
	    		  sTargetTableName = "ARTICLE_CPT_ICD_LINKS";  
	    	  }
	       	       	       
				    	
    	if (sLCD_Article.equalsIgnoreCase("LCD"))
    	{    		
    		
		    		if(HCPCCodes.size()!=0) 
		    	   	{	    		   	          	 
		    		   	 for(j=0;j<HCPCCodes.size();j++) //Retrieve the Jurisdiction names for each hcpc code & store it in List
		    		   	 {	 
		    		   		sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCCodes.get(j)+"'"+" and mcare_juris is not null and LCD_ID="+ Serenity.sessionVariableCalled("ID");
		    		   		Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	   
		    		   	    JuryMap.put(HCPCCodes.get(j), Jurisdictions);
		    		   	 }    	    	 
		    	   	}
		    	   	else
		    	   	{
		    	   		logger.info("HCPC codes list size is 0");
		    			Assert.assertTrue("HCPC codes list size is 0",false);    	   		
		    	   	}
	    		
	    		  //Retrieve all keys from the Map
	   	           keys=JuryMap.keySet();
	   	              		
	   	          //Navigate through all keys and retrieve the values 
	      		  	for( String key : keys)
	      		  	{	   	      		  	      
	        		    Jurs= JuryMap.get(key);	//Retrieve the String Array stored in the List		
	        		    
	        		      if(Jurs.size()!=0)    
	          		  	   {	        		    	  
	        		    		 for (j=0;j<Jurs.size();j++)
	        	    		  	 {	    		    	   		
									      	sQuery = "Select MANUAL_10 from LCD.LCD_CPT_ICD_LINKS" + " where LCD_ID="
												+ Serenity.sessionVariableCalled("ID") + " and ICD_Code='" + sICDCode + "'"+" and ICD_GROUP="+sICDGroup+" and HCPC_CODE='"+key+"'"+" and supports_10=-1 and lcd_version="+iLCDArticleVersion+ " and mcare_juris='"+ Jurs.get(j)+"'" ;
				
													logger.info(sQuery);				
												
												 //Retrieve the Manual indicator value from the Query
										    	 iManualIndicator = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));  
										    	 logger.info("Manual indicator value retrieved from query is: "+iManualIndicator);
										    	 
									    	     //Checking if Manual indicator value is set to -1 or not in the Target Table
										    	 if (iManualIndicator== iIndicatorVal)
										    	 {        
										    	   logger.info("Manual Indicator column value is set to"+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+ key);
										    	   Assert.assertTrue("Manual Indicator column value is set to "+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+ key,true);	    	  
										    	 }		  
										    	 else
										    	 {
										    		logger.info("Manual Indicator column value is Not set to "+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+key);
											    	Assert.assertTrue("Manual Indicator column value is Not set to "+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+ key,false);	 
										    	 }			
	        	    		  	     }//end of For
		                  }//end of If jury size
	     		  	}//end of For Keys
    	}//end of if for LCD
    	
    	else if (sLCD_Article.equalsIgnoreCase("Article"))
		{       			
			    		if(HCPCCodes.size()!=0) 
			    	   	{
			    		   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
			    		   	 for(j=0;j<HCPCCodes.size();j++)
			    		   	 {	 
			    		   		sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCCodes.get(j)+"'"+" and mcare_juris is not null and ARTICLE_ID="+ Serenity.sessionVariableCalled("ID");
			    		   		Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
			    		   	    JuryMap.put(HCPCCodes.get(j), Jurisdictions);
			    		   	 }    	    	 
			    	   	}
			    	   	else
			    	   	{
			    	   		logger.info("HCPC codes list size is 0");
			    			Assert.assertTrue("HCPC codes list size is 0",false);    	   		
			    	   	}
	    		
	    		  //Retrieve all keys from the Map
	   	           keys=JuryMap.keySet();   	              		
	   	          
	   	        //Navigate through all keys and retrieve the values 
	      		  	for( String key1 : keys)
	      		  	{	         		  		
	      		  	      //Retrieve the String Array stored in the List	
	        		  	  Jurs= JuryMap.get(key1);	
	        		  	   
	        		      if(Jurs.size()!=0)    
	          		  	   {	        		    	  
	        		    		 for (j=0;j<Jurs.size();j++)
	        	    		  	 {	
													sQuery = "Select MANUAL_10 from LCD.ARTICLE_CPT_ICD_LINKS" + " where ARTICLE_ID="
															+ Serenity.sessionVariableCalled("ID") + " and ICD_Code='" + sICDCode + "'"+" and ICD_GROUP="+sICDGroup+" and HCPC_CODE='" +key1+"'"+" and support_10=-1 and Article_version="+iLCDArticleVersion+" and mcare_juris='"+ Jurs.get(j)+"'" ;
													System.out.println(sQuery);												
								
													//Retrieve the Manual indicator value  from the Query
											    	 iManualIndicator = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));  
											    	 logger.info("Manual indicator value retrieved from query is: "+iManualIndicator);
											    	 
										    	     //Checking if Manual indicator value is set to -1 or not in the Target Table
											    	 if (iManualIndicator==iIndicatorVal)
											    	 {        
											    	   logger.info("Manual Indicator column value is set to  "+iIndicatorVal+" in the TargetTable for HCPC_Code: "+key1);
											    	   Assert.assertTrue("Manual Indicator column value is set to "+iIndicatorVal+"in the TargetTable for HCPC_Code: "+ key1,true);	    	  
											    	 }		  
											    	 else
											    	 {
											    		logger.info("Manual Indicator column value is Not set to  "+iIndicatorVal+"in the TargetTable for HCPC_Code: "+ key1);
												    	Assert.assertTrue("Manual Indicator column value is Not set to "+iIndicatorVal+" in the TargetTable for HCPC_Code: "+ key1,false);	 
											    	 }		
											
	        	    		    	 }	//end of Jury For loop 												
								} ///end of If jury size
	      		  	 
	      		    	  else{	      		    		  
	      		    		       logger.info("Jurs codes list size is 0");
	    	   				       Assert.assertTrue("Jurs codes list size is 0",false);	      		  		
	      		  	           }
	      		  		
	      		  	}//end of Jury keys For loop       		  	
	           	} //end of Article	        	
	}

    @Step
    public void raCapturesHCPCCodesManuallyMaintain(String sCategoryType, String sLCD_Article) throws Exception 
    {
    	
    	  String sTableName="";
		  String sICDCode="";
		  String sQuery="";
		  List<String> HCPCSCodes=null;	
		  int iICDGroup=0;
		  
		  sCategoryType="Support";   //## For Manually Maintained codes the category is always Support 
		  
		  sICDCode  = Serenity.sessionVariableCalled("NewICDCode");
		  iICDGroup = Integer.parseInt(Serenity.sessionVariableCalled("NewICDGroup"));
		
		if (sCategoryType.equalsIgnoreCase("Support") || sCategoryType.equalsIgnoreCase("Does"))
		   {
				if (sCategoryType.equalsIgnoreCase("Support")) 
				{					
					sTableName = "CPT_ICD_SPRT_DELTA";
				} 
				else 
				{					
				   sTableName = "CPT_ICD_DONTSPRT_DELTA";
				}
		   }
		
			//Query to retrieve all HCPC codes associated with the new Manually added ICD Code
			if (sLCD_Article.equalsIgnoreCase("LCD")) {
				sQuery = "Select distinct HCPC_CODE from LCD.LCD_" + sTableName + " where LCD_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'"+ " and ICD10_Group= "+iICDGroup;
				logger.info(sQuery);
				sTableName = "CPT_ICD_SPRT_DELTA";

			} else if (sLCD_Article.equalsIgnoreCase("Article")) {
				sQuery = "Select distinct HCPC_CODE from LCD.ART_" + sTableName + " where ART_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'"+" and ICD10_Group= "+iICDGroup;
				System.out.println(sQuery);
			}

			//Storing the HCPC Codes in the ArrayList
			HCPCSCodes = DBUtils.executeSQLQueryMultipleRows(sQuery);			
            Serenity.setSessionVariable("HCPCCodes").to(HCPCSCodes); 		
		
	}

    @Step
    public void validateDOSToDatesinTarget(String sDate, String sNewICDCode, String sLCD_Article) throws Exception {
			
		ArrayList<String> HCPCCodes = null;
		
	  //Retrieve the HCPC codes from the session variable    	
   	  HCPCCodes = Serenity.sessionVariableCalled("HCPCCodes"); 		

		switch (sLCD_Article)
		
		{
		case "LCD":
		
			// To retrieve the DOS_FROM and DOS_TO values stored in the DB
			for (int j = 0; j <= HCPCCodes.size() - 1; j++) {
				

				String sQuery2 = "Select TO_Char(DOS_TO,'MM/DD/YYYY') from LCD.LCD_CPT_ICD_LINKS where LCD_ID="
						+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + HCPCCodes.get(j) + "'"
						+ " and ICD_CODE='" + sNewICDCode + "'";
				
				String sDOSTOValue = DBUtils.executeSQLQuery(sQuery2);

				if (sDOSTOValue.compareTo(sDate) == 0) {
					logger.info("DOSTo defaulted to open date:" + sDate
							+ " when the combinations moved in target for the HCPC code:" + HCPCCodes.get(j));
					Assert.assertTrue(
							"DOSTo defaulted to open date:" + sDate
									+ " when the combinations moved in target for the HCPC code:" + HCPCCodes.get(j),
							true);
				}

				else {
					Assert.assertTrue(
							"DOSTo not defaulted to open date:" + sDate
									+ " when the combinations moved in target for the HCPC code:" + HCPCCodes.get(j),
							false);
					logger.info("DOSTo not defaulted to open date:" + sDate
							+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j));
				}

			}

			break;

		case "Article":			

			// To retrieve the DOS_FROM and DOS_TO values stored in the DB
			for (int j = 0; j <= HCPCCodes.size() - 1; j++) {
				

				String sQuery2 = "Select TO_Char(DOS_TO,'MM/DD/YYYY') from LCD.ARTICLE_CPT_ICD_LINKS where ARTICLE_ID="
						+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + HCPCCodes.get(j) + "'"
						+ " and ICD_CODE='" + sNewICDCode + "'";
				
				String sDOSTOValue = DBUtils.executeSQLQuery(sQuery2);

				if (sDOSTOValue.compareTo(sDate) == 0) {
					logger.info("DOSTo defaulted to open date:" + sDate
							+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j));
					Assert.assertTrue(
							"DOSTo defaulted to open date:" + sDate
									+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j),
							true);
				}

				else {
					logger.info("DOSTo not defaulted to open date:" + sDate
							+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j));
					Assert.assertTrue(
							"DOSTo not defaulted to open date:" + sDate
									+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j),
							false);
				}

			} // end of for

			break;

		default:
			logger.info("No input is provided for the Switch Case");
			Assert.assertTrue("Provided invalid case value", false);
		}		
		
	}

	@Step
	public void validateDOSFromDatesinTarget(String sNewICDCode, String sLCD_Article) throws Exception {
		
	 List<String> DOSFromDates = new ArrayList<>();
   	 List<String> HCPCCodes = null;  
   	 List<String> Jurisdictions = null;   	
   	 String sDOSFromDate = "";
   	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
     String sTargetTableName = "";
   	 String sMasterTableName = "";
   	 String sLCDArticleIDColName = "";
   	 String sQuery="";
   	 int j=0;
   	 String sSupportCol="";
   	String sEffectiveDateColName="";
   	String sVersionColName="";
   	
   	//Retrieve the HCPC codes from the session variable    	
   	 HCPCCodes = Serenity.sessionVariableCalled("HCPCCodes"); 	 
     	
   	 
   	  //Assign table names based on whether it is LCD or Article 
   	  if(sLCD_Article.equals("LCD"))
   	  {   		  
   		   sTargetTableName = "LCD_CPT_ICD_LINKS"; 
   		   sMasterTableName =   "LCD_MASTER";
   		   sLCDArticleIDColName  =  "LCD_ID";
   		   sSupportCol = "Supports_10";
   		   sEffectiveDateColName = "REV_EFF_DATE";
   		   sVersionColName =  "LCD_VERSION";
   	   }
   	  else if (sLCD_Article.equals("Article"))
   	  { 
   		  sTargetTableName = "ARTICLE_CPT_ICD_LINKS";   
   		  sMasterTableName =   "ARTICLE_MASTER";
   		  sLCDArticleIDColName  =  "ARTICLE_ID";
   		  sSupportCol = "Support_10";
   		  sEffectiveDateColName  = "ARTICLE_EFF_DATE";
   		  sVersionColName =  "ARTICLE_VERSION";
   	  }
   	
   	  
   	if(HCPCCodes.size()!=0) 
   	{
	   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
	   	 for(j=0;j<HCPCCodes.size();j++)
	   	 {	 
	   		sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCCodes.get(j)+"'"+" and mcare_juris is not null";
	   	    Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
	   	    JuryMap.put(HCPCCodes.get(j), Jurisdictions);
	   	 }    	    	 
   	}
   	else
   	{
   		logger.info("HCPC codes list size is 0");
		Assert.assertTrue("HCPC codes list size is 0",false);
   		
   	}
   	   	
   	
   	       //Retrieve all keys from the Map
   	        Set<String> keys=JuryMap.keySet();
   	        
   	        
   	       //Navigate through all keys and retrieve the values 
   		  	for(String key : keys)
   		  	{	   
   		  		
   		  	   //Retrieve the vString Array stored in the List	
   		  	   List<String>  Jurs= JuryMap.get(key);	
   		  	 
   		  	  if(Jurs.size()!=0)    
   		  	  {
   			  
   		  		     //Retrieve all the Jurisdictions for each HCPC Code and store them in DOSFromDate String Array
	    		  	 for (j=0;j<Jurs.size();j++)
	    		  	 {	    		  		 
	    		  		sQuery = "Select To_Char(min(dos_from),'dd/mm/yyyy') from LCD."+sTargetTableName+" where hcpc_code ='" +key+"'"+" and mcare_juris='"+ Jurs.get(j)+"'"+" and  Appropriate_10=-1 and "+ sSupportCol +"=-1 and To_Char(dos_to,'mm/dd/yyyy')='12/31/9999'" ;
	    			   sDOSFromDate = String.format(DBUtils.executeSQLQuery(sQuery));	    	    	    
	    			   DOSFromDates.add(sDOSFromDate);
	    		  	 }
   		   	   }
	   		  	else
	   		   	{
	   		   		logger.info("Jurs codes list size is 0");
	   				Assert.assertTrue("Jurs codes list size is 0",false);
	   		   		
	   		   	}
   		  	} 
   		  	
   		  	int flag=0;
   		  	
   		  	//Compare the DOS_From dates with each other which are in the List String to check if all are equal 
   		  	for(int h=0;h<DOSFromDates.size();h++)
   		  	 {
	    		  		for(int g=0;g<DOSFromDates.size();g++)
	    		  		{	
		    		  		if(DOSFromDates.get(h).compareTo(DOSFromDates.get(g))==0)
		    		  		{
		    		  			System.out.println("all dates are equal");	    
		    		  			logger.info("Al compared dates are equal");
		    		  		}
		    		  		else 
		    		  		{
		    		  			flag=1;	    
		    		  			logger.info("All compared dates are Not equal");
		    		  			System.out.println("All compared dates are Not equal");	
		    		  		}		    		  			
	    		  		}    
	    		  		if(flag==1) { break;}	//if any of the dates are not equal then break out from the loop 
   		  	 }
   		  	
   		  //If all dates are same for all HCPC codes and jurisdictions then the Date should be reflected as DOS_FROM date in Target Table.
   	    	
   		  	 if(flag==0)
   		  	 {    		  		 
	    		  		 
	    		  		for (j = 0; j < HCPCCodes.size() - 1; j++)
	    		  		{
		    					 sQuery = "Select TO_Char(DOS_FROM,'dd/mm/yyyy') from LCD."+sTargetTableName+"  where "+ sLCDArticleIDColName+"="
		    							+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + HCPCCodes.get(j) + "'"
		    							+ " and ICD_CODE='" + sNewICDCode + "'";
		    					
		    					String sDOSFromValue = DBUtils.executeSQLQuery(sQuery);
		    					
		    					if (sDOSFromValue.compareTo(sDOSFromDate) == 0) 
		    					{
		    						logger.info("DOSFrom defaulted to open date:" + sDOSFromDate + " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j));
		    						Assert.assertTrue("DOSFrom defaulted to open date:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j),true);
		    					}
		
		    					else {    						
		    						  logger.info("DOSFrom not defaulted to open date:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j));
		    						  Assert.assertTrue("DOSFrom not defaulted to open date:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j),false);
		    					    }
		
		    				}//End of For loop    		  	    		  		 
   		  		 
   		  	  }//End of If condition 
   		  	
   		  	 else if(flag==1) //if any DOS from date is different
   		  	 {
   		  		 
   		  	  	//If any of the above min(dos_from) date is different from each other then REV_EFFECTIVE_DATE from the Master table should be reflected as DOS_FROM date in Target Table	  		 
   		  		  sQuery = "Select (Trim(SUBSTR(To_CHAR("+sEffectiveDateColName+",'yyyy-mm-dd'),0,10))) from LCD."+sMasterTableName+" where "+ sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID") ;
   		  		  		  		
   		  		   		  		  
   		  		 String sRevEffDate= DBUtils.executeSQLQuery(sQuery);
   		  		   
   		  		 if(!sRevEffDate.isEmpty()) //if Rev effective date is null
   		  		    {	
	    		  		    	for (j = 0; j <= HCPCCodes.size() - 1; j++)
	    	    		  		{
	    		    					 sQuery = "Select TO_Char(DOS_FROM,'yyyy-mm-dd') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName+"="
	    		    							+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + HCPCCodes.get(j) + "'"
	    		    							+ " and ICD_CODE='" + sNewICDCode + "'";
	    		    					
	    		    					String sDOSFromValue = DBUtils.executeSQLQuery(sQuery);
	    		    					
	    		    					if (sRevEffDate.compareTo(sDOSFromValue) == 0) 
	    		    					{
	    		    						logger.info("DOSFrom defaulted to open date:" + sDOSFromValue + " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j));
	    		    						Assert.assertTrue("DOSFrom defaulted to open date:" + sDOSFromValue+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j),true);
	    		    					}
	    		
	    		    					else {    						
	    		    						  logger.info("DOSFrom not defaulted to open date:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j));
	    		    						  Assert.assertTrue("DOSFrom not defaulted to open date:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j),    								false);
	    		    					    }
	    		
	    	    		  		 }//End of For loop 
   		  		    }  
   		  		    else //If the REV_EFFECTIVE_DATE is Null then LAST_UPDATED from LCD/Article MASTER table should be reflected as DOS_FROM date in Target Table.
   		  		    {
   		  		    	 sQuery = "Select (Trim(SUBSTR(To_CHAR(Last_Updated,'yyyy-mm-dd'),0,10))) from LCD."+sMasterTableName+" where " + sLCDArticleIDColName+"="+Serenity.sessionVariableCalled("ID") + "  and "+sVersionColName+"=1";
   		  		  	     String sLastUpdateDate = DBUtils.executeSQLQuery(sQuery);
   		  		    	
   		  		    	
		   		  		  	       if(!sLastUpdateDate.isEmpty())
		   		  		  	          {
					   		  		    	for (j = 0; j <= HCPCCodes.size() - 1; j++)
					   	    		  		{
					   		  		    	  sQuery = "Select TO_Char(DOS_FROM,'yyyy-mm-dd') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName+"="
							    							+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + HCPCCodes.get(j) + "'"
							    							+ " and ICD_CODE='" + sNewICDCode + "'";  
					   		  		    		
					   		  		    		 String sDOSFromDate2 = DBUtils.executeSQLQuery(sQuery);
					   		    					
					   		    					if (sLastUpdateDate.compareTo(sDOSFromDate2) == 0) 
					   		    					{
					   		    						logger.info("DOSFrom defaulted to open date:" + sDOSFromDate + " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j));
					   		    						Assert.assertTrue("DOSFrom defaulted to open date:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j),true);
					   		    					}
					   		
					   		    					else {    						
					   		    						  logger.info("DOSFrom not defaulted to open date:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j));
					   		    						  Assert.assertTrue("DOSFrom not defaulted to open date:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j),false);
					   		    					    }
					   		
					   	    		  		  }//End of For loop
		   		  		  	          }
		   		  		  	       
		   		  		  	        else{		   		  		  	    	       
		   		  		  	    	   	  logger.info("Last Updated Date is null in the Master Table");
		   		  		  	    	   	  Assert.assertTrue("Last Updated Date is null in the Master Table",false);		   		  		  	    	   		   		  		  	    	   
		   		  		  	           }
   		  		    	
   		  		      }//end of Else condition  
   		  		 
   		  	   } //End of Else  for if(flag==1)  	
		
	}//End of method
	
	@Step
	public void validateBaseCodeandDOSToforManuallyMaintained(String sExpectedValue) {
				
		String sActualText = "";

		// Validating BaseI CD Code value as "NA"
		oSeleniumUtils.enter_given_text_StringLocator(
				StringUtils.replace(oRAPage.DeleteCombInputArea, "arg", "Manually Added Code"),Serenity.sessionVariableCalled("NewICDCodeUI"));
		
		sActualText = oSeleniumUtils.get_TextFrom_Locator(oRAPage.RAPage_DeleteCodeComb_BaseICDCodeVal);

		if (sExpectedValue.equalsIgnoreCase(sActualText)) {

			logger.info("The Data : NA : displayed for Manually Added Code in DeleteCodeCombination tab for BaseICDCode col");
			Assert.assertTrue("The Data : NA : displayed for Manually Added Code in DeleteCodeCombination tab for BaseICDCode col",true);
			
		} else {

			logger.error("The Data : NA :  is not displayed for Manually Added Code in DeleteCodeCombination tab for BaseICDCode col");
			Assert.assertTrue("The Data : NA :  is not displayed for Manually Added Code in DeleteCodeCombination tab for BaseICDCode col",false);

		}

		// Validating DOSTo value as "NA"
		sActualText = oSeleniumUtils.get_TextFrom_Locator(oRAPage.RAPage_DeleteCodeComb_DOSToVal);

		if (sExpectedValue.equalsIgnoreCase(sActualText)) {
			
			logger.info("The Data : NA : displayed for Manually Added Code in DeleteCodeCombination tab for DOSTo Col");
			Assert.assertTrue("The Data : NA : displayed for Manually Added Code in DeleteCodeCombination tab for DOSTo col",true);
			
		} else {
			logger.error("The Data : NA : is not displayed for Manually Added Code in DeleteCodeCombination tab for DOSTo Col");
			Assert.assertTrue("The Data : NA : is not displayed for Manually Added Code in DeleteCodeCombination tab for DOSTo col",false);
		}
	}

	@Step
	public void raValidatesPopupWindow() {
		
		if (oSeleniumUtils.is_WebElement_Displayed(oRAPage.RAPage_AddCodeCombination_Popup))
		{
		    logger.info("Pop up window not closed automatically as expected");
		    Assert.assertTrue("Pop up window not closed automatically as expected",true);
		}
		else
		{
			logger.error("Pop up window  closed automatically");
		    Assert.assertTrue("Pop up window  closed automatically ",false);
		}
		
		
	}

	@Step
	public void validateNewCodesinDB(String sTableName, String sLCD_Article) {
		
		int iDBRowCount1= -2;
		int iDBRowCount2= -2;
		String sQuery1="";
		String sQuery2="";
		
		switch (sLCD_Article)
		{
		
			case "LCD":
									
				sQuery1 = "Select count(*) from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and ICD10_Code = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'"+" and ICD10_GROUP="+Serenity.sessionVariableCalled("ICD Group") + " and BASE_ICD10_CODE='"+Serenity.sessionVariableCalled("ICD Code")+"'"+" and SUPPORTS_10=-1";
				sQuery2 = "Select count(*) from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and BASE_ICD10_CODE is NULL"+"  and ICD10_GROUP="+Serenity.sessionVariableCalled("NewICDGroup")+" and SUPPORTS_10=-1 and ICD10_Code = '" + Serenity.sessionVariableCalled("NewICDCodeUI")+"'";
				
				break;	
				
			case "Article":
				
				sQuery1 = "Select count(*) from LCD.ART_MANUAL_CODE_COMB where ART_ID="+Serenity.sessionVariableCalled("ID")+ " and ICD10_Code = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'"+" and ICD10_GROUP="+Serenity.sessionVariableCalled("ICD Group") + " and BASE_ICD10_CODE='"+Serenity.sessionVariableCalled("ICD Code")+"'"+" and SUPPORTS_10=-1";		  
				sQuery2 = "Select count(*) from LCD.ART_MANUAL_CODE_COMB where ART_ID="+Serenity.sessionVariableCalled("ID")+ " and BASE_ICD10_CODE is NULL"+"  and ICD10_GROUP="+Serenity.sessionVariableCalled("NewICDGroup")+" and SUPPORTS_10=-1 and ICD10_Code = '" + Serenity.sessionVariableCalled("NewICDCodeUI")+"'";
								
				break;
		
		       default:     logger.error("No input provided for the switch case");
		}
		
		//Execute the Queries 
		iDBRowCount1=Integer.parseInt(DBUtils.executeSQLQuery(sQuery1));		
		iDBRowCount2=Integer.parseInt(DBUtils.executeSQLQuery(sQuery2));
		
		if(iDBRowCount1==1  && iDBRowCount2==1)
		{
		     logger.info("DB Manual  CodeCombination Table updated with Associated & Manual Code Combinations");		
		     Assert.assertTrue("DB Manual  CodeCombination Table updated with Associated & Manual Code Combinations",true);
		}
		else
		{
			  logger.error("DB Manual  CodeCombination Table not updated with Associated & Manual Code Combinations");		
		      Assert.assertTrue("DB Manual  CodeCombination Table not updated with Associated & Manual Code Combinations",false);	
		}

	}

	@Step
	public void selectNextWeekTask()
	{
		//Selecting week task as per ascending order if 2 different weeks
		oRAPage.selectingWeekTask();
		logger.info("Clicked on the ID CheckBox");
		
		oSeleniumUtils.Click_given_WebElement(oHomePage.ClaimTask_Btn);
		logger.info("Clicked on the ClaimTask Button for the ID");
		
		SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
		
		
	}

	@Step
	public void raClaimsCodeWithThreeWeeksTask(String sLCDArticle)
	{
		
		 String sID="";
	      String IDName="";	
	
	if(sLCDArticle.equalsIgnoreCase("LCD"))
	 {			
		 sID= DBUtils.executeSQLQuery(DBQueries.ThreeWeek_LCDID_Query);			     
	     Serenity.setSessionVariable("LCD_ID").to(sID);	
	     Serenity.setSessionVariable("ID").to(sID);	
	     IDName="LCD";
	  }
	else{			
		  sID = DBUtils.executeSQLQuery(DBQueries.ThreeWeek_Article_Query);	
		  Serenity.setSessionVariable("Article_ID").to(sID);
		  Serenity.setSessionVariable("ID").to(sID);	
		  IDName="Article";
	    }
	
	
	if(!sID.equals("")){			
		
		logger.info(IDName+" ID is retrieved from DB:"+sID);
		
		oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,sID);
		logger.info(IDName+" ID entered in the TextBox :"+sID);
		
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		
		oSeleniumUtils.is_WebElement_Displayed(oHomePage.ID_Checkbox);		
		
		//Selecting week task as per ascending order if 3 different weeks
		oRAPage.selectingWeekTask();
		logger.info("Clicked on the ID CheckBox");
		
		oSeleniumUtils.Click_given_WebElement(oHomePage.ClaimTask_Btn);
		logger.info("Clicked on the ClaimTask Button for the ID");
		
		SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
		
					
			
	}else{
		  logger.error("There is no "+ IDName +" ids who has Three weeks task");
		  Assert.assertTrue("There is no "+ IDName +" ids who has Three weeks task.",false);
	     }
		
	}
	
	@Step
	public void validateNewCodeCombInManualTable(String sValidation, String sCode,String sLCD_Article, String sVersion) throws Exception 
	{
				
		  String sICDCode="";
		  String sQuery="";
		  int sICDGroup= 0;		  
		  int iDBCount=-2; 		
		  int iLCDArticleVersion = -2;
	   	 List<String> Jurisdictions = null;   	
	   	 String sDeltaTableName="";	   
	   	 String sLCDArticleIDColName = "";	   	
	   	 int j=0;	   	
	   	String sVersionColName="";
	   	String sTargetTableName="";
	
		 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
		  
		  sICDCode  = Serenity.sessionVariableCalled("NewICDCode");
		  sICDGroup = Integer.parseInt(Serenity.sessionVariableCalled("NewICDGroup"));
		  
		  //Convert LCD/Article version to Integer
	       iLCDArticleVersion = Integer.parseInt(sVersion);
	 	    	  
	    	  //Assign table names based on whether it is LCD or Article 
	       	  if(sLCD_Article.equals("LCD"))
	       	  {   	
	       		   sLCDArticleIDColName  =  "LCD_ID";	       		     		   
	       		   sVersionColName =  "LCD_VERSION";
	       		   sDeltaTableName = "LCD_CPT_ICD_SPRT_DELTA";	
	       		  sTargetTableName = "LCD_CPT_ICD_LINKS"; 	
	       		   
	       		//Retrieve Jurisdictions and put in Map   
	       		if(!sCode.isEmpty()) 
	    	   	{
	    		    //Retrieve the Jurisdiction names for each hcpc code & store it in List    	    		   
	    		   	sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +sCode+"'"+" and mcare_juris is not null and LCD_ID="+ Serenity.sessionVariableCalled("ID");
	    		   	Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	
	    		   	 JuryMap.put(sCode, Jurisdictions);	    		   	    	 
	    	   	}
	    	   	else
	    	   	{
	    	   		logger.info("New code is empty");
	    			Assert.assertTrue("New code is empty",false);    	   		
	    	   	}  		       		   
	       		   
	       	   }
	       	  else if (sLCD_Article.equals("Article"))
	       	  { 	       		 
	       		  sLCDArticleIDColName  =  "ART_ID";	       		  		  
	       		  sVersionColName =  "ART_VERSION";
	       		  sDeltaTableName = "ART_CPT_ICD_SPRT_DELTA";	
	       		  sTargetTableName = "ARTICLE_CPT_ICD_LINKS"; 	
	       		  
	       		//Retrieve Jurisdictions and put in Map
	       		if(!sCode.isEmpty()) 
	    	   	{
	    		    //Retrieve the Jurisdiction names for each hcpc code & store it in List    	    		   
	    		   	sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +sCode+"'"+" and mcare_juris is not null and ARTICLE_ID="+ Serenity.sessionVariableCalled("ID");
	    		   	Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	
	    		   	 JuryMap.put(sCode, Jurisdictions);	    		   	    	 
	    	   	}
	    	   	else
	    	   	{
	    	   		logger.info("New code is empty");
	    			Assert.assertTrue("New code is empty",false);    	   		
	    	   	}  	
	       		  
	       	  }  	 
	        	  	   List<String>  Jurs= JuryMap.get(sCode);   //Retrieve the String Array stored in the List		
	        		  	   
	        		      if(Jurs.size()!=0)    
	          		  	   {	        		    	  
	        		    		 for (j=0;j<Jurs.size();j++)
	        	    		  	 {	    			
										sQuery = "Select count(*)  from LCD."+sDeltaTableName + " where "+ sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID") + 
												" and ICD10_Code='" + sICDCode + "'"+" and ICD10_Group="+sICDGroup+" and HCPC_CODE='"+sCode+"'"+
												"  and "+ sVersionColName+"="+iLCDArticleVersion + " and mcare_juris='"+Jurs.get(j)+"'";
										
										   logger.info(sQuery);				
										
										 //Retrieve the Manual indicator value from the Query
								    	 iDBCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));  
								    	 logger.info("DB Count retrieved from query is: "+iDBCount);   	    	
	        		      
						        	
						        switch (sValidation)
						        {	        		
						       
						         case "Add":
						        	 
					    					        //Checking if DB Row count  1 in Delta Table
											    	 if (iDBCount== 1)
											    	 {        
											    	   logger.info("Newly added Manual Code and new HCPC Code combination is updated in Delta Table for new code: "+ sCode+" and for jurisidiction :"+Jurs.get(j)+"for " +sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") );
											    	   Assert.assertTrue("Newly added Manual Code and new HCPC Code combination is updated in Delta Table for new code: "+sCode+" and for jurisidiction :"+Jurs.get(j) +sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") ,true);	    	  
											    	 }		  
											    	 else 
											    	 {
											    		 logger.info("Newly added Manual Code and new HCPC Code combination is  not updated in Delta Table for new code: "+ sCode+" and for jurisidiction :"+Jurs.get(j)+sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") );
												    	 Assert.assertTrue("Newly added Manual Code and new HCPC Code combination is not updated in Delta Table for new code: "+sCode+" and for jurisidiction :"+Jurs.get(j)+sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") ,false); 
												     }
									break;
									
						         case "Delete":
						        	 
									        	 //Checking if DB Row count  0 in Delta Table
										    	 if (iDBCount== 0)
										    	 {        
										    	   logger.info("Newly added Manual Code and new HCPC Code combination is deleted in Delta Table for new code: "+ sCode+" and for jurisidiction :"+Jurs.get(j)+"for " +sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") );
										    	   Assert.assertTrue("Newly added Manual Code and new HCPC Code combination is deleted in Delta Table for new code: "+sCode+" and for jurisidiction :"+Jurs.get(j) +sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") ,true);	    	  
										    	 }		  
										    	 else 
										    	 {
										    		 logger.info("Newly added Manual Code and new HCPC Code combination is  not deleted in Delta Table for new code: "+ sCode+" and for jurisidiction :"+Jurs.get(j)+sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") );
											    	 Assert.assertTrue("Newly added Manual Code and new HCPC Code combination is not deleted in Delta Table for new code: "+sCode+" and for jurisidiction :"+Jurs.get(j)+sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") ,false); 
											     }
							    	 
							    	break;
							    	
							        default:  	 Assert.assertTrue("No input provided for Switch case" ,false);
						        }	
	        
	        	    }	//End of Jurs Loop 
	       }    	        
	
	}

	@Step
	public void validateManualIndicatorInDeltaTable(String sIndicator, String sTableName, String sLCD_Article,String sVersion, String sCode) throws Exception 
	{
		
		  String sICDCode="";
		  String sQuery="";
		  int sICDGroup= 0;			   		
		  int iLCDArticleVersion = -2;
	   	 List<String> Jurisdictions = null;   	
	   	 String 	   sDeltaTableName = "";	   
	   	 String sLCDArticleIDColName = "";	   	
	   	 int j=0;	   	
	   	 String sVersionColName="";
	   	 int iExpectedManualIndicator =  -30;
	   	int  iDBManualIndicator =  -40;   	 
	
		 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
		  
		  sICDCode  = Serenity.sessionVariableCalled("NewICDCode");
		  sICDGroup = Integer.parseInt(Serenity.sessionVariableCalled("NewICDGroup"));
		  
		  //Convert LCD/Article version to Integer
		  iExpectedManualIndicator = Integer.parseInt(sIndicator);
	      iLCDArticleVersion = Integer.parseInt(sVersion);
	       
	 	    	  
	    	  //Assign table names based on whether it is LCD or Article 
	       	  if(sLCD_Article.equals("LCD"))
	       	  {   	
	       		   sLCDArticleIDColName  =  "LCD_ID";	       		     		   
	       		   sVersionColName =  "LCD_VERSION";
	       		   sDeltaTableName = "LCD_CPT_ICD_SPRT_DELTA";	  
	       		   
	       		  //Retrieve Jurisdictions and put in Map   
		       		if(!sCode.isEmpty()) 
		    	   	{
		    		    //Retrieve the Jurisdiction names for each hcpc code & store it in List    	    		   
		    		   	sQuery = "Select distinct mcare_juris from LCD."+sDeltaTableName+" where hcpc_code ='" +sCode+"'"+" and mcare_juris is not null and LCD_ID="+ Serenity.sessionVariableCalled("ID");
		    		   	Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	
		    		   	 JuryMap.put(sCode, Jurisdictions);	    		   	    	 
		    	   	}
		    	   	else
		    	   	{
		    	   		logger.info("New code is empty");
		    			Assert.assertTrue("New code is empty",false);    	   		
		    	   	}  		       		   
		       		   
	       		   
	       	   }
	       	  else if (sLCD_Article.equals("Article"))
	       	  { 	       		 
	       		  sLCDArticleIDColName  =  "ART_ID";	       		  		  
	       		  sVersionColName =  "ART_VERSION";
	       	     sDeltaTableName = "ART_CPT_ICD_SPRT_DELTA";	  
	       	     
	       	     
	       		//Retrieve Jurisdictions and put in Map   
		       		if(!sCode.isEmpty()) 
		    	   	{
		    		    //Retrieve the Jurisdiction names for each hcpc code & store it in List    	    		   
		    		   	sQuery = "Select distinct mcare_juris from LCD."+sDeltaTableName+" where hcpc_code ='" +sCode+"'"+" and mcare_juris is not null and ART_ID="+ Serenity.sessionVariableCalled("ID");
		    		   	Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	
		    		   	 JuryMap.put(sCode, Jurisdictions);	    		   	    	 
		    	   	}
		    	   	else
		    	   	{
		    	   		logger.info("New code is empty");
		    			Assert.assertTrue("New code is empty",false);    	   		
		    	   	}  		       		   
		       		   
	       	  }      	 	       	  

   	  	   List<String>  Jurs= JuryMap.get(sCode);   //Retrieve the String Array stored in the List		
   		  	   
   		      if(Jurs.size()!=0)    
     		  	   {	        		    	  
   		    		 for (j=0;j<Jurs.size();j++)
   	    		  	 {	    			
								sQuery = "Select Manual_10  from LCD."+sDeltaTableName + " where "+ sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID") + 
										" and ICD10_Code='" + sICDCode + "'"+" and ICD10_Group="+sICDGroup+" and HCPC_CODE='"+sCode+"'"+
										"  and "+ sVersionColName+"="+iLCDArticleVersion + " and mcare_juris='"+Jurs.get(j)+"'";
								
								   logger.info(sQuery);				
								
								 //Retrieve the Manual indicator value from the Query
						    	 iDBManualIndicator = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));  
						    	 logger.info("DB Count retrieved from query is: "+iDBManualIndicator);	        	            
	        	 
   					            //Checking if Manual Indicator value updated as expected 
						    	 if (iDBManualIndicator== iExpectedManualIndicator)
						    	 {        
						    	   logger.info("Newly added Manual Code Manual Indicator value  updated as :"+iExpectedManualIndicator+"for "+ sCode+" and for jurisidiction :"+Jurs.get(j)+" for " +sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") );
						    	   Assert.assertTrue("Newly added Manual Code Manual Indicator value  updated as :"+iExpectedManualIndicator+"for "+ sCode+" and for jurisidiction :"+Jurs.get(j)+" for " +sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") ,true);	    	  
						    	 }		  
						    	 else 
						    	 {
						    		 logger.info("Newly added Manual Code Manual Indicator value  not updated as :"+iExpectedManualIndicator+"for "+ sCode+" and for jurisidiction :"+Jurs.get(j)+" for " +sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") );
							    	   Assert.assertTrue("Newly added Manual Code Manual Indicator value not  updated as :"+iExpectedManualIndicator+"for "+ sCode+" and for jurisidiction :"+Jurs.get(j)+" for " +sLCDArticleIDColName+":"+Serenity.sessionVariableCalled("ID") ,false); 
							     }
		    	 
   	    		   }	//End of Jurs Loop 
     		   }    	   		
	}

	@Step
	public void validateNewCodesintheDB(String sTableName, String sLCD_Article, String sCodeComboType) 
	{		
		
		int iDBRowCount1= -2;
		int iDBRowCount2= -2;
		String sQuery1="";
		String sQuery2="";
		
		switch (sLCD_Article)
		{
		
			case "LCD":
				
				      if (sCodeComboType.equalsIgnoreCase("Both"))
				       {									
							sQuery1 = "Select count(*) from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and ICD10_Code = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'"+" and ICD10_GROUP="+Serenity.sessionVariableCalled("ICD Group") + " and BASE_ICD10_CODE='"+Serenity.sessionVariableCalled("ICD Code")+"'"+" and SUPPORTS_10=-1";
							sQuery2 = "Select count(*) from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and BASE_ICD10_CODE is NULL"+"  and ICD10_GROUP="+Serenity.sessionVariableCalled("NewICDGroup")+" and SUPPORTS_10=-1 and ICD10_Code = '" + Serenity.sessionVariableCalled("NewICDCodeUI")+"'";
				       }
				      else if (sCodeComboType.equalsIgnoreCase("ManuallyMaintain"))
				    		  {
				    	          sQuery2 = "Select count(*) from LCD.LCD_MANUAL_CODE_COMB where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and BASE_ICD10_CODE is NULL"+"  and ICD10_GROUP="+Serenity.sessionVariableCalled("NewICDGroup")+" and SUPPORTS_10=-1 and ICD10_Code = '" + Serenity.sessionVariableCalled("NewICDCodeUI")+"'";
				    		  }
					
				break;	
				
			case "Article":
				
				 if (sCodeComboType.equalsIgnoreCase("Both"))
			       {					
						sQuery1 = "Select count(*) from LCD.ART_MANUAL_CODE_COMB where ART_ID="+Serenity.sessionVariableCalled("ID")+ " and ICD10_Code = '" + Serenity.sessionVariableCalled("NewICDCode1") + "'"+" and ICD10_GROUP="+Serenity.sessionVariableCalled("ICD Group") + " and BASE_ICD10_CODE='"+Serenity.sessionVariableCalled("ICD Code")+"'"+" and SUPPORTS_10=-1";		  
						sQuery2 = "Select count(*) from LCD.ART_MANUAL_CODE_COMB where ART_ID="+Serenity.sessionVariableCalled("ID")+ " and BASE_ICD10_CODE is NULL"+"  and ICD10_GROUP="+Serenity.sessionVariableCalled("NewICDGroup")+" and SUPPORTS_10=-1 and ICD10_Code = '" + Serenity.sessionVariableCalled("NewICDCodeUI")+"'";
			       }	
				 else if (sCodeComboType.equalsIgnoreCase("ManuallyMaintain"))
	    		  {
	    	          sQuery2 = "Select count(*) from LCD.ART_MANUAL_CODE_COMB where ART_ID="+Serenity.sessionVariableCalled("ID")+ " and BASE_ICD10_CODE is NULL"+"  and ICD10_GROUP="+Serenity.sessionVariableCalled("NewICDGroup")+" and SUPPORTS_10=-1 and ICD10_Code = '" + Serenity.sessionVariableCalled("NewICDCodeUI")+"'";
	    		  }
										
				break;
		
		       default:     logger.error("No input provided for the switch case");
		}
		

	      if (sCodeComboType.equalsIgnoreCase("Both"))
	       {			
					//Execute the Queries 
					iDBRowCount1=Integer.parseInt(DBUtils.executeSQLQuery(sQuery1));		
					iDBRowCount2=Integer.parseInt(DBUtils.executeSQLQuery(sQuery2));
					
					if(iDBRowCount1==1  && iDBRowCount2==1)
					{
					     logger.info("DB Manual  CodeCombination Table updated with Associated & Manual Code Combinations");		
					     Assert.assertTrue("DB Manual  CodeCombination Table updated with Associated & Manual Code Combinations",true);
					}
					else
					{
						  logger.error("DB Manual  CodeCombination Table not updated with Associated & Manual Code Combinations");		
					      Assert.assertTrue("DB Manual  CodeCombination Table not updated with Associated & Manual Code Combinations",false);	
					}
	       }
	      else if (sCodeComboType.equalsIgnoreCase("ManuallyMaintain"))
		  {
	    	  
	    	  iDBRowCount2=Integer.parseInt(DBUtils.executeSQLQuery(sQuery2));

				if( iDBRowCount2==1)
				{
				     logger.info("DB Manual  CodeCombination Table updated with  Manual Code Combinations");		
				     Assert.assertTrue("DB Manual  CodeCombination Table updated with  Manual Code Combinations",true);
				}
				else
				{
					  logger.error("DB Manual  CodeCombination Table not updated with  Manual Code Combinations");		
				      Assert.assertTrue("DB Manual  CodeCombination Table not updated with  Manual Code Combinations",false);	
				   }
	    	  
		       }
				
	}

	@Step
	public void validateDOSToDateBanding(String sNewICDCode, String sLCD_Article, String sHCPCCode,String sLCDArticleVersion) throws Exception 
	{
			
	   	 List<String> Jurisdictions = null;   	
	   	
	   	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
	     String sTargetTableName = "";
	     String sMasterTableName="";
	     String sEffectiveDateColName="";	   
	   	 String sLCDArticleIDColName = "";
	   	 String sQuery="";
	   	 int j=0;	   
	   	String sVersionColName="";	   
	    String sExpectedDOSToDate="";	   
	    String sExpectedDate="";
	   	
	   	int iVersionNo=  Integer.parseInt(sLCDArticleVersion);	
		
	    //Assign table names based on whether it is LCD or Article 
	   	  if(sLCD_Article.equals("LCD"))
	   	  {   		  
	   		   sTargetTableName = "LCD_CPT_ICD_LINKS"; 	   		 
	   		   sLCDArticleIDColName  =  "LCD_ID"; 	 	   		   
	   		   sVersionColName =  "LCD_VERSION";	   		    
	   		   sMasterTableName =   "LCD_MASTER";
	   		   sLCDArticleIDColName  =  "LCD_ID";	   		 
	   		   sEffectiveDateColName = "REV_EFF_DATE";
	   		   sVersionColName =  "LCD_VERSION";
	   	   }
	   	  else if (sLCD_Article.equals("Article"))
	   	  { 
	   		  sTargetTableName = "ARTICLE_CPT_ICD_LINKS";   	   		
	   		  sLCDArticleIDColName  =  "ARTICLE_ID";   	   		 
	   		  sVersionColName =  "ARTICLE_VERSION";	   		
	   		  sMasterTableName =   "ARTICLE_MASTER";	   		   		
	   		  sEffectiveDateColName  = "ARTICLE_EFF_DATE";
	   		  sVersionColName =  "ARTICLE_VERSION";
	   	  }
	   	  	   	  
	   	    //Retrieve Review EffectiveDate-1 from LCD Master Table  based on Version
	   	     sQuery = "Select (Trim(SUBSTR(To_CHAR("+sEffectiveDateColName+"-1"+",'MM/DD/YYYY'),0,10))) from LCD."+sMasterTableName+" where "+ sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID")+ "  and "+sVersionColName+"="+iVersionNo;
	   	     sExpectedDate = DBUtils.executeSQLQuery(sQuery);	   	   
	   	 		   	  
	   	  if(sExpectedDate.isEmpty())  // If  Review Effective Date is blanks in Master Table
	   	  {
	   		  	logger.info("ReviewEffectivedate in Master Table is empty so retrieving the LastUpdated date");
			    System.out.println("ReviewEffectivedate in Master Table is empty so retrieving the LastUpdated date");			   
			    
			    sQuery = "Select (Trim(SUBSTR(To_CHAR(Last_Updated-1,'MM/DD/YYYY'),0,10))) from LCD."+sMasterTableName+" where " + sLCDArticleIDColName+"="+Serenity.sessionVariableCalled("ID") + "  and "+sVersionColName+"="+iVersionNo;
			    sExpectedDate = DBUtils.executeSQLQuery(sQuery);
	   	  }	   
		    	
		    if(sExpectedDate.isEmpty()) // If LastUpdated Date is blank in Master Table then throw error
		    {
		    	 logger.info("ReviewEffectivedate & LastUpdated in Master Table is empty");
		    	 System.out.println("ReviewEffectivedate & LastUpdated are blank in Master Table,So cannot proceed further");	
		    	 Assert.assertTrue("ReviewEffectivedate & LastUpdated are blank in Master Table,So cannot proceed further",false);		 		   
		    }
	   	    
		  	 SimpleDateFormat sdf = new SimpleDateFormat( "MM/dd/yyyy" );
			 java.util.Date dDBExpectedDate = sdf.parse(sExpectedDate);				
	
		   	   //Single HCPC code 
		   	   sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +sHCPCCode+"'"+" and mcare_juris is not null and " +sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID");
		   	    Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
		   	    JuryMap.put(sHCPCCode, Jurisdictions);
		  
  	      
    	//Retrieve all keys from the Map
        Set<String> keys=JuryMap.keySet();     	      

			
			// To retrieve the DOS_FROM and DOS_TO values stored in the DB			
		 	 for(String key : keys)  //Navigate through all keys and retrieve the values 
	   		  	  {	  		   		   		  	  
	   		  	     List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
		   		  	  if(Jurs.size()!=0)    
		   		  	   {					   		   		  		     
				    		  	 for (j=0;j<Jurs.size();j++)  //Retrieve all the Jurisdictions for each HCPC Code and store them in DOSFromDate String Array
				    		  	 {	  				

					 				 String sQuery1 = "Select TO_Char(DOS_FROM,'MM/DD/YYYY') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName +"="
					 						 	+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
					 						 	+ " and ICD_CODE='" + sNewICDCode + "'"+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"="+iVersionNo;
						
					 				 		String sDOSFromDBValue = DBUtils.executeSQLQuery(sQuery1);					 				 		
					 				 		java.util.Date dDOSFromDt = sdf.parse(sDOSFromDBValue );
					 				 		
					 				 		
					 				 		if(!sDOSFromDBValue.isEmpty())  //Check if Query returned value is not empty
					 				 		{					 						  
								 				        if(dDBExpectedDate.compareTo(dDOSFromDt)>0)             // if RevEffictiveDate-1 or LastUpdated Date-1 is greater than to  DOSFrom date then we should consider the RevEffictiveDate-1 as DOSTo date as  DOSFromDate<DOSToDate  which is  allowed
								 				        {
								 				        	   sExpectedDOSToDate  =   sExpectedDate;     		         //Set expected DOSTo value as  RevEffictiveDate-1 or LastUpdated Date-1
								 				        }
								 				        else  if(dDBExpectedDate.compareTo(dDOSFromDt)==0)    // if RevEffictiveDate-1 or LastUpdated Date-1 is equal to  DOSFrom date then we should consider the RevEffictiveDate-1 as DOSTo date as  DOSFromDate=DOSToDate  which is  allowed
								 				        {
								 				        	   sExpectedDOSToDate  =   sExpectedDate;                    //Set expected DOSTo value as  RevEffictiveDate-1 or LastUpdated Date-1
								 				        }
								 				        else if(dDBExpectedDate.compareTo(dDOSFromDt)<0)       // if RevEffictiveDate-1 or LastUpdated Date-1 is less than DOSFrom date then we should  consider DOS From date as DOSTo date as DOSFromDate DOSToDate  cannot be less than DOSFromDate  which is  not allowed
								 				        {			        	
								 				        	 sExpectedDOSToDate  =   sDOSFromDBValue;			      //Set expected DOSTo value as DOSFrom value      	
								 				        }	
					 				 		}   
					 				 		else
					 				 		{
					 				 			 logger.info("DOS From value is empty in DB so cannot proceed further");
					 					    	 Assert.assertTrue("DOS From value is empty in DB so cannot proceed further,So cannot proceed further",false);	
					 				 		}
				    		  		 
									 			 String sQuery2 = "Select TO_Char(DOS_TO,'MM/DD/YYYY') from LCD."+sTargetTableName+"  where "+sLCDArticleIDColName+"="
												+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
												+ " and ICD_CODE='" + sNewICDCode + "'"+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"="+iVersionNo;
										
												String sDOSTOValue = DBUtils.executeSQLQuery(sQuery2);   //Retrieve  DOSTo value from DB 
												
														if(!sDOSTOValue.isEmpty())  //Check if Query returned value is not empty
								 				 		{	
																if (sExpectedDOSToDate.compareTo(sDOSTOValue) == 0)    //Compare expected  DOSTo value with DB DOSTo Value
																{
																	logger.info("DOSTo Datebanded " + sDOSTOValue+ " when the combinations moved in target for the HCPC code:" + key);
																	Assert.assertTrue("DOSTo Datebanded:" + sDOSTOValue+ " when the combinations moved in target for the HCPC code:" + key,true);
																}								
																else {
																	Assert.assertTrue("DOSTo Datebanded:" + sDOSTOValue+ " when the combinations moved in target for the HCPC code:" + key,false);
																	logger.info("DOSTo Datebanded:" + sDOSTOValue+ " when the combinations moved in target or the HCPC code:" + key);
																}														
								 				 		  }
														else
								 				 		{
								 				 			 logger.info("DOS To value is empty in DB so cannot proceed further");
								 					    	 Assert.assertTrue("DOS To value is empty in DB so cannot proceed further,So cannot proceed further",false);	
								 				 		}												
												
											}//end of For for Jurs loop				    		  	
		   		  	         }//end of if for jurs size
				    		  	 else{		   		   		  		  			   		   		  
				   		   	          logger.info("Jurs codes list size is 0");
				   				      Assert.assertTrue("Jurs codes list size is 0",false);			   		   		  		  
		   		   		  	         }
			
		   		  	   }//end of For loop for Map keys				
		
	}

	public void validateDOSToOpenDate(String sOpenDate,String sNewICDCode, String sHCPCCode, String sLCD_Article,String sLCDArticleVersion) throws Exception 
	{
			
	   	 List<String> Jurisdictions = null;   	
	   	
	   	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
	     String sTargetTableName = "";
	   
	   	 String sLCDArticleIDColName = "";
	   	 String sQuery="";
	   	 int j=0;
	   
	   	String sVersionColName="";
	   	int iVersionNo=  Integer.parseInt(sLCDArticleVersion);	
	  
	    //Assign table names based on whether it is LCD or Article 
	   	  if(sLCD_Article.equals("LCD"))
	   	  {   		  
	   		   sTargetTableName = "LCD_CPT_ICD_LINKS"; 	   		 
	   		   sLCDArticleIDColName  =  "LCD_ID"; 	 	   		   
	   		   sVersionColName =  "LCD_VERSION";
	   	   }
	   	  else if (sLCD_Article.equals("Article"))
	   	  { 
	   		  sTargetTableName = "ARTICLE_CPT_ICD_LINKS"; 	   		
	   		  sLCDArticleIDColName  =  "ARTICLE_ID";   	   		 
	   		  sVersionColName =  "ARTICLE_VERSION";
	   	  }
	   		
  	  
  	    //Retrieve all Jurisdictions from the DB for each HCPC Code
  	   if(!sHCPCCode.isEmpty()) 
	   	{		   		 
		   	sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +sHCPCCode+"'"+" and mcare_juris is not null and " +sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID");
		   	Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
		   	JuryMap.put(sHCPCCode, Jurisdictions);		   	    	    	 
	   	}
	   	else
	   	{
	   		logger.info("HCPC codes is blank");
			Assert.assertTrue("HCPC codes is blank  ,cannot proceed further",false);	   		
	   	}  	   	
  	      
  	//Retrieve all keys from the Map
    Set<String> keys=JuryMap.keySet();	    	      

		switch (sLCD_Article)		
		{
		case "LCD":
		
			// To retrieve the DOS_FROM and DOS_TO values stored in the DB			
		 	 for(String key : keys)  //Navigate through all keys and retrieve the values 
	   		  	  {	  		   		   		  	  
	   		  	     List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
		   		  	  if(Jurs.size()!=0)    
		   		  	   {					   		   		  		     
				    		  	 for (j=0;j<Jurs.size();j++)  //Retrieve all the Jurisdictions for each HCPC Code and store them in DOSFromDate String Array
				    		  	 {	  											
											 				String sQuery2 = "Select TO_Char(DOS_TO,'MM/DD/YYYY') from LCD.LCD_CPT_ICD_LINKS where LCD_ID="
														+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
														+ " and ICD_CODE='" + sNewICDCode + "'"+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"="+iVersionNo;
												
												String sDOSTOValueDB = DBUtils.executeSQLQuery(sQuery2);
								
												if (sDOSTOValueDB.compareTo(sOpenDate) == 0) 
												{
													logger.info("DOSTo defaulted to open date:" + sDOSTOValueDB+ " when the combinations moved in target for the HCPC code:" + key);
													Assert.assertTrue("DOSTo defaulted to open date:" + sDOSTOValueDB+ " when the combinations moved in target for the HCPC code:" + key,true);
												}
								
												else {
													Assert.assertTrue("DOSTo not defaulted to open date:" + sDOSTOValueDB+ " when the combinations moved in target for the HCPC code:" + key,false);
													logger.info("DOSTo not defaulted to open date:" + sDOSTOValueDB+ " when the combinations moved in target or the HCPC code:" + key);
												}
											}//end of For for Jurs loop				    		  	
		   		  	        }//end of if for jurs size
				    		  	 else{		   		   		  		  			   		   		  
				   		   	          logger.info("Jurs codes list size is 0");
				   				      Assert.assertTrue("Jurs codes list size is 0",false);			   		   		  		  
		   		   		  	         }
			
		   		  	   }//end of For loop for Map keys		  	 
				    		  	 
				
			break;

		case "Article":			

			// To retrieve the DOS_FROM and DOS_TO values stored in the DB						
			 for(String key : keys)  //Navigate through all keys and retrieve the values 
 		  	  {	  		   		   		  	  
 		  	     List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
	   		  	  if(Jurs.size()!=0)    
	   		  	   {					   		   		  		     
			    		  	 for (j=0;j<Jurs.size();j++)  //Retrieve all the Jurisdictions for each HCPC Code and store them in DOSFromDate String Array
			    		  	 {	  											
															
													String sQuery2 = "Select TO_Char(DOS_TO,'MM/DD/YYYY') from LCD.ARTICLE_CPT_ICD_LINKS where ARTICLE_ID="
															+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" +key + "'"
															+ " and ICD_CODE='" + sNewICDCode + "'"+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"="+iVersionNo;
													
													String sDOSTOValueDB = DBUtils.executeSQLQuery(sQuery2);
									
													if (sDOSTOValueDB.compareTo(sOpenDate) == 0)
													{													
														logger.info("DOSTo defaulted to open date:" + sDOSTOValueDB + " when the combinations moved in target or the HCPC code:" + key);
														Assert.assertTrue("DOSTo defaulted to open date:" + sDOSTOValueDB+ " when the combinations moved in target or the HCPC code:" + key,true);
													}
									
													else {
														       logger.info("DOSTo not defaulted to open date:" + sDOSTOValueDB + " when the combinations moved in target or the HCPC code:" + key);
													    	   Assert.assertTrue("DOSTo not defaulted to open date:" + sDOSTOValueDB+ " when the combinations moved in target or the HCPC code:" + key,false);
												         	}									
							
	    		  	  }
	  	        }//end of if for jurs size
	    		  	 else{		   		   		  		  			   		   		  
	   		   	          logger.info("Jurs codes list size is 0");
	   				      Assert.assertTrue("Jurs codes list size is 0",false);			   		   		  		  
	   		  	         }

	  	   }//end of For loop for Map keys		  

			break;

		default:
			logger.info("No input is provided for the Switch Case");
			Assert.assertTrue("Provided invalid case value", false);
		}				
		
	}

	public void raValidatesManualIndicatorinTargetwithCode(String sIndicatorVal, String sLCD_Article,String sLCDArticleVersion, String sHCPCCode) throws Exception
	{
		String sICDCode="";
		  String sQuery="";
		  int sICDGroup= 0;		  
		  int iManualIndicator=-2; 
		  List<String> HCPCCodes = null; 
		  int iLCDArticleVersion = -2;	   	
		 List<String> Jurisdictions = null;	
		 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
		 String sTargetTableName = "";	   	   
		 int j=0;	
		 Set<String> keys=null;
		 List<String>  Jurs =null;	   	
		   	
		 	int iIndicatorVal = Integer.parseInt(sIndicatorVal);
		  sICDCode  = Serenity.sessionVariableCalled("NewICDCode");
		  sICDGroup = Integer.parseInt(Serenity.sessionVariableCalled("NewICDGroup"));
		  
		  //Retrieve the HCPC codes from the session variable    	
	       HCPCCodes = Serenity.sessionVariableCalled("HCPCCodes");
	       iLCDArticleVersion = Integer.parseInt(sLCDArticleVersion);
	       	
	       //Assign table names based on whether it is LCD or Article 
	    	  if(sLCD_Article.equals("LCD"))
	    	  {   		  
	    		   sTargetTableName = "LCD_CPT_ICD_LINKS";	    		   
	    	   }
	    	  else if (sLCD_Article.equals("Article"))
	    	  { 
	    		  sTargetTableName = "ARTICLE_CPT_ICD_LINKS";  
	    	  }
	       	  
	   switch(sLCD_Article)
	   {   
	   
	      case "LCD":    	 

	    		if(!sHCPCCode.isEmpty()) 
	    	   	{	    		   	          	 
	    		     //Retrieve the Jurisdiction names for each hcpc code & store it in List	    		   	 
	    		   	sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +sHCPCCode+"'"+" and mcare_juris is not null and LCD_ID="+ Serenity.sessionVariableCalled("ID");
	    		   	 JuryMap.put(sHCPCCode, Jurisdictions);	    		     	    	 
	    	   	}
	    	   	else
	    	   	{
	    	   		logger.info("HCPC codes list size is 0");
	    			Assert.assertTrue("HCPC codes list size is 0",false);    	   		
	    	   	}
	    			    		 
	   	           keys=JuryMap.keySet();  //Retrieve all keys from the Map	   	              		
	   	         
	      		  	for( String key : keys)  //Navigate through all keys and retrieve the values 
	      		  	{	   	      		  	      
	        		    Jurs= JuryMap.get(key);	//Retrieve the String Array stored in the List		
	        		    
	        		      if(Jurs.size()!=0)    
	          		  	   {	        		    	  
	        		    		 for (j=0;j<Jurs.size();j++)
	        	    		  	 {	    		    	   		
									      	sQuery = "Select MANUAL_10 from LCD.LCD_CPT_ICD_LINKS" + " where LCD_ID="
												+ Serenity.sessionVariableCalled("ID") + " and ICD_Code='" + sICDCode + "'"+" and HCPC_CODE_GROUP="+sICDGroup+" and HCPC_CODE='"+key+"'"+" and supports_10=-1 and lcd_version="+iLCDArticleVersion ;
				
													logger.info(sQuery);				
												
												 //Retrieve the Manual indicator value from the Query
										    	 iManualIndicator = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));  
										    	 logger.info("Manual indicator value retrieved from query is: "+iManualIndicator);
										    	 
									    	     //Checking if Manual indicator value is set to -1 or not in the Target Table
										    	 if (iManualIndicator== iIndicatorVal)
										    	 {        
										    	   logger.info("Manual Indicator column value is set to"+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+ key);
										    	   Assert.assertTrue("Manual Indicator column value is set to "+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+ key,true);	    	  
										    	 }		  
										    	 else
										    	 {
										    		logger.info("Manual Indicator column value is Not set to "+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+key);
											    	Assert.assertTrue("Manual Indicator column value is Not set to "+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+ key,false);	 
										    	 }			
	        	    		  	     }//end of For
	          		  	   }
	        		      else{	      		    		  
     		    		          logger.info("Jurs codes list size is 0");
   	   				             Assert.assertTrue("Jurs codes list size is 0",false);	      		  		
     		  	           }     		  		
	      		  	} 
	      		  	break;
  	
	   case "Article":     		
	
			  	   	if(!sHCPCCode.isEmpty()) 
				   	     {	     		 
				    		  sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +sHCPCCode+"'"+" and mcare_juris is not null and ARTICLE_ID="+ Serenity.sessionVariableCalled("ID");
				    		  Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
				    		  JuryMap.put(sHCPCCode, Jurisdictions);	    		    	    	 
				    	  }
				    	   	else
				    	   	{
				    	   		logger.info("HCPC codes list size is 0");
				    			Assert.assertTrue("HCPC codes list size is 0",false);    	   		
				    	   	}
				    		
				    		 //Retrieve all keys from the Map
				   	           keys=JuryMap.keySet();   	              		
				   	          
				   	         //Navigate through all keys and retrieve the values 
				      		   	for( String key1 : keys)
				      		  	{	         		  		
				      		  	      //Retrieve the String Array stored in the List	
				        		  	  Jurs= JuryMap.get(key1);	
				        		  	   
				        		      if(Jurs.size()!=0)    
				          		  	   {	        		    	  
				        		    		 for (j=0;j<Jurs.size();j++)
				        	    		  	 {	
																sQuery = "Select MANUAL_10 from LCD.ARTICLE_CPT_ICD_LINKS" + " where ARTICLE_ID="
																		+ Serenity.sessionVariableCalled("ID") + " and ICD_Code='" + sICDCode + "'"+" and HCPC_CODE_GROUP="+sICDGroup+" and HCPC_CODE='" +key1+"'"+" and support_10=-1 and Article_version="+iLCDArticleVersion+" and mcare_juris='"+ Jurs.get(j)+"'" ;
																System.out.println(sQuery);												
											
																//Retrieve the Manual indicator value  from the Query
														    	 iManualIndicator = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));  
														    	 logger.info("Manual indicator value retrieved from query is: "+iManualIndicator);
														    	 
													    	     //Checking if Manual indicator value is set to -1 or not in the Target Table
														    	 if (iManualIndicator==iIndicatorVal)
														    	 {        
														    	   logger.info("Manual Indicator column value is set to  "+iIndicatorVal+" in the TargetTable for HCPC_Code: "+key1);
														    	   Assert.assertTrue("Manual Indicator column value is set to "+iIndicatorVal+"in the TargetTable for HCPC_Code: "+ key1,true);	    	  
														    	 }		  
														    	 else
														    	 {
														    		logger.info("Manual Indicator column value is Not set to  "+iIndicatorVal+"in the TargetTable for HCPC_Code: "+ key1);
															    	Assert.assertTrue("Manual Indicator column value is Not set to "+iIndicatorVal+" in the TargetTable for HCPC_Code: "+ key1,false);	 
														    	 }		
														
				        	    		    	 }	//end of Jury For loop 	
														
											} ///end of If
				      		  	 
				      		    	  else{	      		    		  
				      		    		       logger.info("Jurs codes list size is 0");
				    	   				       Assert.assertTrue("Jurs codes list size is 0",false);	      		  		
				      		  	           }
				      		  		
				      		  	}//end of Jury keys For loop 	
				      			break;  	
				     	} 	//End of switch	
	        }	//End of Method

	public void raValidatesManualIndicatorinTargetForAssociatedCodes(String sIndicatorVal, String sLCD_Article,String sLCDArticleVersion) throws Exception 
	{	
		
		 String sICDCode="";
		  String sQuery="";
		  int sICDGroup= 0;		  
		  int iManualIndicator=-2; 
		  List<String> HCPCCodes = null; 
		  int iLCDArticleVersion = -2;	   	
		 List<String> Jurisdictions = null;	
		 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
		 String sTargetTableName = "";	   	   
		 int j=0;	
		 Set<String> keys=null;
		 List<String>  Jurs =null;	   	
		   	
		  int iIndicatorVal = Integer.parseInt(sIndicatorVal);
		  sICDCode  = Serenity.sessionVariableCalled("NewICDCode");
		  //sICDGroup = Integer.parseInt(Serenity.sessionVariableCalled("NewICDGroup"));
		  
		  //Retrieve the HCPC codes from the session variable    	
	       HCPCCodes = Serenity.sessionVariableCalled("HCPCCodes");
	       iLCDArticleVersion = Integer.parseInt(sLCDArticleVersion);
	       	
	       //Assign table names based on whether it is LCD or Article 
	    	  if(sLCD_Article.equals("LCD"))
	    	  {   		  
	    		   sTargetTableName = "LCD_CPT_ICD_LINKS";	    		   
	    	   }
	    	  else if (sLCD_Article.equals("Article"))
	    	  { 
	    		  sTargetTableName = "ARTICLE_CPT_ICD_LINKS";  
	    	  }
	       	       	       
				    	
  	if (sLCD_Article.equalsIgnoreCase("LCD"))
  	{    	  		
	    		if(HCPCCodes.size()!=0) 
	    	   	{	    		   	          	 
	    		   	 for(j=0;j<HCPCCodes.size();j++) //Retrieve the Jurisdiction names for each hcpc code & store it in List
	    		   	 {	 
	    		   		sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCCodes.get(j)+"'"+" and mcare_juris is not null and LCD_ID="+ Serenity.sessionVariableCalled("ID");
	    		   		Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);
	    		   	    JuryMap.put(HCPCCodes.get(j), Jurisdictions);
	    		   	 }    	    	 
	    	   	}
	    	   	else
	    	   	{
	    	   		logger.info("HCPC codes list size is 0");
	    			Assert.assertTrue("HCPC codes list size is 0",false);    	   		
	    	   	}
	    		
	    		  //Retrieve all keys from the Map
	   	           keys=JuryMap.keySet();
	   	              		
	   	          //Navigate through all keys and retrieve the values 
	      		  	for( String key : keys)
	      		  	{	   	      		  	      
	        		    Jurs= JuryMap.get(key);	//Retrieve the String Array stored in the List		
	        		    
	        		      if(Jurs.size()!=0)    
	          		  	   {	        		    	  
	        		    		 for (j=0;j<Jurs.size();j++)
	        	    		  	 {	    		    	   		
									      	sQuery = "Select MANUAL_10 from LCD.LCD_CPT_ICD_LINKS" + " where LCD_ID="
												+ Serenity.sessionVariableCalled("ID") + " and ICD_Code='" + sICDCode + "'"+" and HCPC_CODE='"+key+"'"+" and supports_10=-1 and lcd_version="+iLCDArticleVersion +" and mcare_juris='"+ Jurs.get(j)+"'" ;
				
													logger.info(sQuery);				
												
												 //Retrieve the Manual indicator value from the Query
										    	 iManualIndicator = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));  
										    	 logger.info("Manual indicator value retrieved from query is: "+iManualIndicator);
										    	 
									    	     //Checking if Manual indicator value is set to -1 or not in the Target Table
										    	 if (iManualIndicator== iIndicatorVal)
										    	 {        
										    	   logger.info("Manual Indicator column value is set to"+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+ key);
										    	   Assert.assertTrue("Manual Indicator column value is set to "+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+ key,true);	    	  
										    	 }		  
										    	 else
										    	 {
										    		logger.info("Manual Indicator column value is Not set to "+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+key);
											    	Assert.assertTrue("Manual Indicator column value is Not set to "+iIndicatorVal+"  in the TargetTable for HCPC_Code: "+ key,false);	 
										    	 }			
	        	    		  	     }//end of For
		                  }
  	
  	else if (sLCD_Article.equalsIgnoreCase("Article"))
		{       		
	
	    		if(HCPCCodes.size()!=0) 
	    	   	{
	    		   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
	    		   	 for(j=0;j<HCPCCodes.size();j++)
	    		   	 {	 
	    		   		sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCCodes.get(j)+"'"+" and mcare_juris is not null and ARTICLE_ID="+ Serenity.sessionVariableCalled("ID");
	    		   		Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
	    		   	    JuryMap.put(HCPCCodes.get(j), Jurisdictions);
	    		   	 }    	    	 
	    	   	}
	    	   	else
	    	   	{
	    	   		logger.info("HCPC codes list size is 0");
	    			Assert.assertTrue("HCPC codes list size is 0",false);    	   		
	    	   	}
	    		
	    		//Retrieve all keys from the Map
	   	           keys=JuryMap.keySet();   	              		
	   	          
	   	        //Navigate through all keys and retrieve the values 
	      		  	for( String key1 : keys)
	      		  	{	         		  		
	      		  	      //Retrieve the String Array stored in the List	
	        		  	  Jurs= JuryMap.get(key);	
	        		  	   
	        		      if(Jurs.size()!=0)    
	          		  	   {	        		    	  
	        		    		 for (j=0;j<Jurs.size();j++)
	        	    		  	 {	
													sQuery = "Select MANUAL_10 from LCD.ARTICLE_CPT_ICD_LINKS" + " where ARTICLE_ID="
															+ Serenity.sessionVariableCalled("ID") + " and ICD_Code='" + sICDCode + "'"+" and HCPC_CODE='" +key1+"'"+" and support_10=-1 and Article_version="+iLCDArticleVersion+" and mcare_juris='"+ Jurs.get(j)+"'" ;
													System.out.println(sQuery);												
								
													//Retrieve the Manual indicator value  from the Query
											    	 iManualIndicator = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));  
											    	 logger.info("Manual indicator value retrieved from query is: "+iManualIndicator);
											    	 
										    	     //Checking if Manual indicator value is set to -1 or not in the Target Table
											    	 if (iManualIndicator==iIndicatorVal)
											    	 {        
											    	   logger.info("Manual Indicator column value is set to  "+iIndicatorVal+" in the TargetTable for HCPC_Code: "+key1);
											    	   Assert.assertTrue("Manual Indicator column value is set to "+iIndicatorVal+"in the TargetTable for HCPC_Code: "+ key,true);	    	  
											    	 }		  
											    	 else
											    	 {
											    		logger.info("Manual Indicator column value is Not set to  "+iIndicatorVal+"in the TargetTable for HCPC_Code: "+ key1);
												    	Assert.assertTrue("Manual Indicator column value is Not set to "+iIndicatorVal+" in the TargetTable for HCPC_Code: "+ key1,false);	 
											    	 }		
											
	        	    		    	 }	//end of Jury For loop 	
											
								} ///end of If
	      		  	 
	      		    	  else{	      		    		  
	      		    		       logger.info("Jurs codes list size is 0");
	    	   				       Assert.assertTrue("Jurs codes list size is 0",false);	      		  		
	      		  	           }
	      		  		
	      		  	}//end of Jury keys For loop 	
	      		  	
	           	} 
	      		  	}
  	}
	   	
		
	}

	@Step
	public void raClaimsGrpTasksDataByScenario(String sLCD_Article, String sWeekNo, String sScenarioName,String sTestDataRange) 
	{		
		String IDName="";
		String sID="";		
		String sArticleQuery="";
		String sLCDQuery="";
		String[]  TestDataArr = null;
		String sFromID = "";
		String sToID = "";
		
		if  (sLCD_Article.equalsIgnoreCase("LCD"))
		{			
			switch(sWeekNo.toUpperCase())
			{		
					
			 case "WEEK1":					 				 
				      sLCDQuery = "Select * from (Select LCD_ID from (Select lcd_id from LCD.LCD_REVIEW_TASK where  LCD_ID like '"+sTestDataRange+"%'"+"  and task_status_key=1 and user_id is null and \r\n" +
						 				"LCD_ID NOT in(Select LCD_ID from LCD.LCD_REVIEW_TASK GROUP BY LCD_ID HAVING COUNT(lcd_id) > 1 ))) where rownum=1";
				 break;
				 
			 case "WEEK2":		
				  //Splitting the TestData Range by  hyphen (-) to pass the values  in the below SQL query
				   TestDataArr  =  sTestDataRange.split("-");				     
				    sFromID   =  TestDataArr[0];
				    sToID     =    TestDataArr[1];
				
					 sLCDQuery = " Select * from (SELECT LCD_ID \r\n" + 
								" FROM LCD.LCD_REVIEW_TASK\r\n" + 
								" WHERE user_id IS NULL AND TASK_STATUS_KEY = 1 and LCD_ID between "+ sFromID+" and "+sToID+"\r\n" + 
								" GROUP BY LCD_ID, TASK_STATUS_KEY\r\n" + 
								" HAVING COUNT (*) =2) where rownum=1";
					 break; 
					 
			 case "WEEK3":		
				 
				 //Splitting the TestData Range by  hyphen (-) to pass the values  in the below SQL query
				   TestDataArr  =  sTestDataRange.split("-");				     
				    sFromID   =  TestDataArr[0];
				    sToID     =    TestDataArr[1];
				 
				      sLCDQuery = " Select * from (SELECT LCD_ID \r\n" + 
							" FROM LCD.LCD_REVIEW_TASK\r\n" + 
							" WHERE user_id IS NULL AND TASK_STATUS_KEY = 1 and LCD_ID between "+ sFromID+" and "+sToID+"\r\n" +
							" GROUP BY LCD_ID, TASK_STATUS_KEY\r\n" + 
							" HAVING COUNT (*) =3) where rownum=1";
				     break; 	 
		          				
			}		
			 sID = DBUtils.executeSQLQuery(sLCDQuery);	
			 Serenity.setSessionVariable("LCD_ID").to(sID);	
		     Serenity.setSessionVariable("ID").to(sID);	
		     IDName="LCD";			
		}
		
		else if   (sLCD_Article.equalsIgnoreCase("Article"))
		{
			
			switch(sWeekNo.toUpperCase())
			{
			
			 case "WEEK1":					 				 
			    	 sArticleQuery = "Select * from (Select Art_ID from (Select Art_ID from LCD.ART_REVIEW_TASK where  Art_ID like '"+sTestDataRange+"%'"+"  and task_status_key=1 and user_id is null\r\n" + 
					" and art_ID NOT in(Select ART_ID from LCD.ART_REVIEW_TASK GROUP BY ART_ID HAVING COUNT(ART_id) > 1 ))) where rownum=1";	
			 break;			     
			
			case "WEEK2": 	
				
				 //Splitting the TestData Range by  hyphen (-) to pass the values  in the below SQL query
				   TestDataArr  =  sTestDataRange.split("-");				     
				    sFromID   =  TestDataArr[0];
				    sToID     =    TestDataArr[1];
				
				      sArticleQuery=  " SELECT * FROM (  SELECT Art_ID, TASK_STATUS_KEY, COUNT (*)\r\n" +
						  " FROM LCD.ART_REVIEW_TASK \r\n" +
						  " WHERE user_id IS NULL AND TASK_STATUS_KEY = 1 AND ART_ID between "+ sFromID+" and "+sToID+"\r\n" +
						   " GROUP BY Art_ID, TASK_STATUS_KEY \r\n" +
							" HAVING COUNT (*)= 2)  WHERE ROWNUM = 1";
				   break;
				   
			case "WEEK3": 		
				
				//Splitting the TestData Range by  hyphen (-) to pass the values  in the below SQL query
				   TestDataArr  =  sTestDataRange.split("-");				     
				    sFromID   =  TestDataArr[0];
				    sToID     =    TestDataArr[1];
				
			        sArticleQuery=  " SELECT * FROM (  SELECT Art_ID, TASK_STATUS_KEY, COUNT (*)\r\n" +
					  " FROM LCD.ART_REVIEW_TASK \r\n" +
					  " WHERE user_id IS NULL AND TASK_STATUS_KEY = 1 AND ART_ID between "+ sFromID+" and "+sToID+"\r\n" +
					   " GROUP BY Art_ID, TASK_STATUS_KEY \r\n" +
						" HAVING COUNT (*)= 3)  WHERE ROWNUM = 1";
			   break;				   			
		          	}						
			 sID = DBUtils.executeSQLQuery(sArticleQuery);	
			  Serenity.setSessionVariable("Article_ID").to(sID);
			  Serenity.setSessionVariable("ID").to(sID);	
			  IDName="Article";		
			  
			}	//End of if else
		
		 		  
			  if(!sID.equals(""))
			  {					
				logger.info(IDName+" ID is retrieved from DB:"+sID);				
				oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,sID);
				logger.info(IDName+" ID entered in the TextBox :"+sID);		
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);		
				oSeleniumUtils.is_WebElement_Displayed(oHomePage.ID_Checkbox);		
				
				//Selecting week task as per ascending order if 2 different weeks
				  oRAPage.selectingWeekTask();
				  logger.info("Clicked on the ID CheckBox");
				
				oSeleniumUtils.Click_given_WebElement(oHomePage.ClaimTask_Btn);
				logger.info("Clicked on the ClaimTask Button for the ID");		
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
				
		}else
		{
			  logger.error("There is no "+ IDName +" ids who has multiple weeks tasks");
			  Assert.assertTrue("There is no "+ IDName +" ids who has multiple weeks tasks.",false);
		     }
		
	}

	@Step
	public void RAEntersDateInDeleteCombinationforRow(String sDate, String sRowNo)
	{		   
		    int iRowno =  Integer.parseInt(sRowNo);
		    
			Actions action = new Actions(getDriver());
			action.moveToElement(getDriver().findElement(By.xpath(oRAPage.DOS_DelComb+"["+iRowno+"]"))).click().build().perform();
			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			String sXpath = "//DIV[2]/FORM[1]/INPUT[1]";
			oSeleniumUtils.moveToElement(sXpath);
			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			getDriver().findElement(By.xpath(sXpath)).sendKeys(sDate);
			//clicking outside to change focus
			getDriver().findElement(By.xpath("//span[text()='DOS To']/../following-sibling::div//input[@ng-model='colFilter.term']")).click();
	}

	@Step
	public void click_on_and_enter_claimedRule(String arg1, String sCodeType) {
		
		boolean bStatus;
		
		String sCode;
		
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

		
		oSeleniumUtils.Click_given_Locator(oHomePage.LCDRequestButton);		
		bStatus=oSeleniumUtils.is_WebElement_Displayed(oHomePage.LCDReviewArticlePopUp);		
		Assert.assertTrue("Request LCD/Article for Review pop up display", bStatus);
		
		oSeleniumUtils.Click_given_Locator(oHomePage.LCDDropDownListArrow);		
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.CodeType, "sValue", sCodeType));
		
		if (sCodeType.equalsIgnoreCase("LCD")) {
			
			sCode=Serenity.sessionVariableCalled("LCD_ID").toString();
			
		}else {			
		    sCode=Serenity.sessionVariableCalled("Article_ID").toString();
		}
				
	    oSeleniumUtils.enter_given_text_StringLocator(oHomePage.LCDArticleTextbox, sCode);	    
	    SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
	    
	    oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.ButtonTag, "sValue", "Submit"));	    	
	    oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);  
		
	}

	public void pick_some_random_rule_from_and_update_the_Decision_for_the_CPT_Code(String sTabType) {
		
		
		if (sTabType.equalsIgnoreCase("Support Tab")) {

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			oSeleniumUtils.Click_given_Locator(oRAPage.SelectRule);

		} else {

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			oSeleniumUtils.gfn_Click_String_object_Xpath(oRAPage.DoesNotSupportTab);		
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
			oSeleniumUtils.Click_given_Locator(oRAPage.SelectRule);
		}
		
		String sCPTCode = oSeleniumUtils.get_TextFrom_Locator(oRAPage.CPTCode);

		Serenity.setSessionVariable("AdCptCode").to(sCPTCode);

		String sICDCode = oSeleniumUtils.get_TextFrom_Locator(oRAPage.ICDCode);

		Serenity.setSessionVariable("AdIcdCode").to(sICDCode);

		if (sTabType.equalsIgnoreCase("Support Tab")) {

			oSeleniumUtils.Click_given_Locator(oRAPage.RejectButton);

			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			oSeleniumUtils.Click_given_Locator(oRAPage.DecisionArrow);

			oSeleniumUtils.Click_given_Locator(oRAPage.DecisionValue);

			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.Reason, ProjectVariables.ReasonCommentText);
			
			oSeleniumUtils.Click_given_Locator(oRAPage.ApplyBtn);

			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			
			oSeleniumUtils.Click_given_WebElement(oRAPage.Update_Decision_Btn);
			
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.ButtonTag, "sValue", "OK"));
	
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

		} else {

			oSeleniumUtils.Click_given_Locator(oRAPage.AcceptButton);

			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.Reason, "AutoTest");
			
			oSeleniumUtils.Click_given_Locator(oRAPage.ApplyBtn);

			oSeleniumUtils.Click_given_WebElement(oRAPage.Update_Decision_Btn);
			
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.ButtonTag, "sValue", "OK"));

		}
		
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		
		
	
	}
		
	@Step
	public void validate_the_updated_decision_of_CPT_Code_in_Adhoc_Review_for(String sTabType, String sCodeType) {
		
		boolean bln;
		
		String sID;
	
		if (sCodeType.equalsIgnoreCase("LCD")) {

			sID = Serenity.sessionVariableCalled("LCD_ID").toString();

		} else {

			sID = Serenity.sessionVariableCalled("Article_ID").toString();
		}
		

		if (sTabType.equalsIgnoreCase("Support Tab")) {

			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.CptCodeTextBox,sID);

			oSeleniumUtils.Click_given_Locator(oAdminPage.SelectRuleInAdmin);

			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue",sID));

			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

			oSeleniumUtils.Click_given_Locator(oRAPage.AdhocReviewTab);

			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
			oSeleniumUtils.scrollToColumn("span", "Review Decision");
			
			oSeleniumUtils.enter_given_text_StringLocator(oAdminPage.AdhocCategoryTextBox, "Support");
				
			oSeleniumUtils.enter_given_text_StringLocator(oAdminPage.ReviewDecisionTextbox, "Reject");
			
		} else {

			oSeleniumUtils.scrollToColumn("span", "Review Decision");
		
			oSeleniumUtils.enter_given_text_StringLocator(oAdminPage.AdhocCategoryTextBox, "Does Not Support");
						
			oSeleniumUtils.enter_given_text_StringLocator(oAdminPage.ReviewDecisionTextbox, "Accept");
			
		}
	
		oSeleniumUtils.scrollToColumn("span", "CPT/HCPCS Code");
		
		oSeleniumUtils.enter_given_text_StringLocator(oRAPage.CptCodeTextBox,Serenity.sessionVariableCalled("AdCptCode").toString());

		oSeleniumUtils.enter_given_text_StringLocator(oRAPage.ICDCodeTextBox,Serenity.sessionVariableCalled("AdIcdCode").toString());
		
		oSeleniumUtils.scrollToColumn("span", "CPT/HCPCS Code");
		
		bln = oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oHomePage.DivTages, "sValue",Serenity.sessionVariableCalled("AdCptCode").toString()));

		verify("CPT Code with updated decision is captured in Adhoc Review Tab", bln);

		bln = oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oHomePage.DivTages, "sValue",Serenity.sessionVariableCalled("AdIcdCode").toString()));

		verify("ICD Code with updated decision is captured in Adhoc Review Tab", bln);
		
		logger.info(""+sCodeType+" - "+ sTabType +" Adhoc Review validation is completed");
	

	}
	
	@Step
	public void verify(String sDescription, boolean blnStatus) {

		GenericUtils.Verify(sDescription, blnStatus);
	}
	
	@Step
	public void raUpdateAcceptDecisionAsReject(String LCDArt, String sTabname)
	{
		String sCode = "";		
		click_on_and_enter_claimedRule(sCode,LCDArt);
		oRAPage.Update_Decision_in_Task_Tab(sTabname);
		
	}
	
	@Step
	public void raValidatesUpdatedDecisioninTargetTable(String sLCD_Article, String sLCDArticleVersion, String sScenario) throws Exception
	{
		 String sTargetTableName="";
		 String[] sScenarioName = null;
		 String sLCDArtIDColName="";
		 String sQuery=""; 
		 String sLCDArtVersionName = "";
		 int iLCDArticleVersion = -2;
		 iLCDArticleVersion = Integer.parseInt(sLCDArticleVersion);
		
		 if(sLCD_Article.equals("LCD"))
	  	  {   			  		  	 
	  		   sLCDArtIDColName  =  "LCD_ID"; 	 
	  		   sTargetTableName = "LCD_CPT_ICD_LINKS";  
	  		 sLCDArtVersionName = "LCD_VERSION";
	  		  
	  	   }
	  	  else if (sLCD_Article.equals("Article"))
	  	  { 			
	  		 sLCDArtIDColName  =  "ARTICLE_ID";  
	  		 sTargetTableName = "ARTICLE_CPT_ICD_LINKS";  		 
	  		 sLCDArtVersionName = "ARTICLE_VERSION";
	  	  }
		 
			sScenarioName  = sScenario.split("-");
		   	sScenario   =    sScenarioName[0];	  
		switch (sScenario)				      
	      {	
	      		case  "UpdateDecision":
				    String  sJuries =  sScenarioName[1] ;
				    String juryList[] = sJuries.split(",");
				    if (!(juryList.length==0)) {
					    for (int k = 0; k < juryList.length; k++)
					    {
				    	 	// Retrieve the updated decision from DB with combination of  HCPC code, ICD code and jury name
								sQuery = "Select decision_update_reason from LCD."+sTargetTableName+" where HCPC_CODE='"+ Serenity.sessionVariableCalled("HCPCCode_Support") +"'" 
								+ "  and ICD_CODE='"+ Serenity.sessionVariableCalled("ICDCode_Support") +"'" + "  and mcare_juris='" + juryList[k]+ "'" 
										+ " and "+sLCDArtIDColName+"="+ Serenity.sessionVariableCalled("ID")+"  and "
										+ sLCDArtVersionName + "=" + iLCDArticleVersion;
								String updatedDecision = DBUtils.executeSQLQuery(sQuery);							
			
								// Checking if updated decision is updated as expected
								if (updatedDecision.equalsIgnoreCase("QA Testing")) {
									logger.info("Updated decision "+updatedDecision+" is verified successfully for "+Serenity.sessionVariableCalled("HCPCCode_Support").toString()+" and "+Serenity.sessionVariableCalled("ICDCode_Support").toString()+" and jury name "+juryList[k]+" in DB");
									Assert.assertTrue("Updated decision "+updatedDecision+" is verified successfully for "+Serenity.sessionVariableCalled("HCPCCode_Support").toString()+" and "+Serenity.sessionVariableCalled("ICDCode_Support").toString()+" and jury name "+juryList[k]+" in DB", true);
								} else {
									logger.info("Updated  decision "+updatedDecision+" is not updated for "+Serenity.sessionVariableCalled("HCPCCode_Support").toString()+" and "+Serenity.sessionVariableCalled("ICDCode_Support").toString()+" and jury name "+juryList[k]+" in DB");
									Assert.assertTrue("Updated  decision "+updatedDecision+" is not updated for "+Serenity.sessionVariableCalled("HCPCCode_Support").toString()+" and "+Serenity.sessionVariableCalled("ICDCode_Support").toString()+" and jury name "+juryList[k]+" in DB", false);
								}				 
						}
				    } else {
						logger.info("Jury list is empty");
						Assert.assertTrue("Jury list is empty", false);	  
			    	}
			     break;
	      		    	  
	      }
				
	}
	
	
	
	@Step
	public void raValidatesAddCombinationPopupHeader(String sPopupHdr)
	{
			boolean bStatus = false;			
		bStatus = oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oRAPage.RAPage_popupHeader, "sValue", sPopupHdr));
		
		if(bStatus){
			logger.info(sPopupHdr+" header text is validated successfully in Add combination popup");
			Assert.assertTrue(sPopupHdr+" header text is validated successfully in Add combination popup",bStatus);
		}else{
			logger.info(sPopupHdr+" header text is not validated in Add combination popup");
			Assert.assertTrue(sPopupHdr+" header text is not validated in Add combination popup",bStatus);
		}
		oSeleniumUtils.Click_given_Locator(oRAPage.RAPage_sAddCombination_CloseBtn);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);			
		logger.info("RA Successfully clicked on the close icon of Add combination popup:");
		
	}
	
	@Step
	public void ValidateSortingForColumnsInDataIntegrityGrid(String Sorting, String Coulmns) {
		
		String[] ColumnHeader=Coulmns.split(",");
		String[] SortingType=Sorting.split(",");
		
		for(int i=0;i<ColumnHeader.length;i++){
			String Sorting_Arrow=StringUtils.replace(oAdminPage.sDataIntegritySortingType, "number", String.valueOf(i+1));
			String Sorting_Arrow1=StringUtils.replace(oAdminPage.sDataIntegrityGridColumnHdr, "number", String.valueOf(i+1));
			logger.info(ColumnHeader[i]);
			Assert.assertTrue("No sorting Type is displayed",oSeleniumUtils.is_WebElement_Present(StringUtils.replace(Sorting_Arrow, "arg", "Sort None")));
			logger.info("No sorting is applied for column header "+ColumnHeader[i]);
			for(int j=0;j<SortingType.length;j++){	
				if((ColumnHeader[i].equalsIgnoreCase("Integrity DOS From")) || (ColumnHeader[i].equalsIgnoreCase("DOS To"))){
					WebElement horizontal_scroll = getDriver().findElement(By.xpath(StringUtils.replace(oAdminPage.sDataIntegrityGridColTextBox, "sValue", ColumnHeader[i])));
					((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);
				}
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(Sorting_Arrow1, "columnname", ColumnHeader[i]));	
				Assert.assertTrue("Sorting Type is in "+SortingType[j]+" order",oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(Sorting_Arrow, "arg", SortingType[j])));
				logger.info(SortingType[j]+" is applied for "+ColumnHeader[i]);
			}
			
			if(ColumnHeader[i].equalsIgnoreCase("DOS To")){
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(Sorting_Arrow1, "columnname", ColumnHeader[i]));	
			}
		}
		
	}
	
	@Step
	public void raSelectsManualOptionAndAddICDCode(String ManuallyAssOption, String sICDGroup, String sNewICdCode){
		
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAPage.sManually_AssociateCode, "sValue", ManuallyAssOption));
		logger.info("Manually add option is chosen in Add Manaul combination pop up");
		
		if(!(sICDGroup.equalsIgnoreCase(""))){
			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sICDGroupTxt, sICDGroup);
			Serenity.setSessionVariable("NewICDGroup").to(sICDGroup);
			logger.info("RA entered ICD Group as "+sICDGroup);
			
		}else{
			logger.info("ICD Group value is empty");
		}
		
		if(!(sNewICdCode.equalsIgnoreCase(""))){
					Serenity.setSessionVariable("NewICDCode").to(sNewICdCode);
					oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sICDCodeTxt, sNewICdCode);
					Serenity.setSessionVariable("NewICDCode1").to(sNewICdCode);
					logger.info("RA entered new ICD code as '"+sNewICdCode);
				}else{
					oSeleniumUtils.clear_Text(oRAPage.sICDCodeTxt);
					logger.info("ICD Code value is empty");
				 }	
		
	}
	

}//End Of Class
	




  

 	
  

	
	
	
	



