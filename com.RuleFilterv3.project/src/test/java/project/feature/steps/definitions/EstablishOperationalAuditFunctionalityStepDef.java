package project.feature.steps.definitions;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.pageobjects.AdminPage;
import project.pageobjects.HomePage;
import project.pageobjects.RAReviewWorkQueuePage;
import project.pageobjects.TargetTableRecordsReviewPage;
import project.utilities.DBQueries;
import project.utilities.DBUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;

public class EstablishOperationalAuditFunctionalityStepDef extends ScenarioSteps{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateProposalStepDef.class);
	
	HomePage oHomePage;
	AdminPage oAdminPage;
	SeleniumUtils oSeleniumUtils;
	DBQueries oDBQueries;
	RAReviewWorkQueuePage oRAReviewWorkQueuePage;
	
	
	@Step
	public void ClicksOnCPTICDAdminLink() {	
	  Assert.assertTrue("CPTICDLink Home page should be dispalyed.",oHomePage.NavigateToCPTICDAdminLink());
	}

	@Step
	public void ClicksOnTargetDataTab() {
		Assert.assertTrue("CPTICDLink Home page should be dispalyed.",oAdminPage.clicksOnTargetDataTab());	
	}
	
	@Step
	public void validateAdminPage() {			  
		Assert.assertTrue("Admin Page should be displayed.",oSeleniumUtils.is_WebElement_Displayed(oAdminPage.AdminPageTitle));				
	}
	
	@Step
	public void filter_TargetDataColumns(String arg1) throws Exception	
	{		
		 
		  String codeGroupstoSelect="";
		  codeGroupstoSelect = arg1;
		  String[] sCodeGroupValues;
		  sCodeGroupValues = codeGroupstoSelect.split(",");	
		  boolean filterResult;		  
		  		  		  
		  for(int i=0;i<sCodeGroupValues.length;i++)
		  {		    				  			  
			    if (sCodeGroupValues[i].equalsIgnoreCase("None"))
			    {				    	
			    	//Retrieve all records DB count.
			    	filterResult=oAdminPage.validateAssigneeFilterDropDown("None");
			    	Assert.assertTrue("Admin All items count matched between DB and UI, condition",filterResult);	
			    }
			    				    	
			    else if (sCodeGroupValues[i].contains("-"))
			    {			    	
			    	//Retrieve multiple records DB count by selecting the passed Assignee values			    	
			    	filterResult=oAdminPage.validateAssigneeFilterDropDown(sCodeGroupValues[i]);	
			    	Assert.assertTrue("Admin Multiple Assignee users count matched between DB and UI, condition",filterResult);
			    }
			    			    
			    else if (sCodeGroupValues[i].equalsIgnoreCase("All"))
			    {			    	
			    	 //Retrieve multiple records DB count by selecting All Assignee values			    	
			    	filterResult=oAdminPage.validateAssigneeFilterDropDown("All");	
			    	 Assert.assertTrue("Admin All Assignee users count matched between DB and UI, condition",filterResult);
			      }	
			    
			    else if (sCodeGroupValues[i].contains("OneUser"))
			    {			    	
			    	//Retrieve multiple records DB count by selecting the passed Assignee values			    	
			    	filterResult =oAdminPage.validateAssigneeFilterDropDown(sCodeGroupValues[i]);	
			    	Assert.assertTrue("Admin One Assignee user count matched between DB and UI, condition",filterResult);
			    }
			 			  
		  }	
		
	}
	
	@Step
	public void filter_MutipleTargetColumns() throws Exception {		
		oAdminPage.fn_Validate_Multiple_Filters_TargeData();		
	}
	
	@Step
	public void Request_Review_For_Completed(String sLCD_OR_ARTICLE_ID) {
			
		switch(sLCD_OR_ARTICLE_ID){
		case "LCD":	
			System.out.println(StringUtils.replace(ProjectVariables.sRA_Completed_LCD_ID, "sval",Serenity.sessionVariableCalled("LCD_ID").toString()));
			Serenity.setSessionVariable("RA_Completed_ID").to(DBUtils.executeSQLQuery(StringUtils.replace(ProjectVariables.sRA_Completed_LCD_ID, "sval",Serenity.sessionVariableCalled("LCD_ID").toString())));
				//Serenity.setSessionVariable("RA_Completed_ID").to(DBUtils.executeSQLQuery(ProjectVariables.sRA_Completed_LCD_ID));
				break;
		case "Article":
			System.out.println(StringUtils.replace(ProjectVariables.sRA_Completed_ARTICLE_ID, "sval",Serenity.sessionVariableCalled("Article_ID").toString()));
			Serenity.setSessionVariable("RA_Completed_ID").to(DBUtils.executeSQLQuery(StringUtils.replace(ProjectVariables.sRA_Completed_ARTICLE_ID, "sval",Serenity.sessionVariableCalled("Article_ID").toString())));
				//Serenity.setSessionVariable("RA_Completed_ID").to(DBUtils.executeSQLQuery(ProjectVariables.sRA_Completed_ARTICLE_ID));
				break;
		 default:  logger.info("No input is provided for the Switch Case"); 		
			}
		oSeleniumUtils.Click_given_WebElement(oHomePage.Request_LCD_Article_For_Review_Btn);
		oSeleniumUtils.Click_given_WebElement(oHomePage.RequestReview_Cmb);
		
		if(sLCD_OR_ARTICLE_ID.equalsIgnoreCase("LCD")){
			//unable to click given locator as focus is shifting due to highlight
			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			getDriver().findElement(By.xpath(oHomePage.LCD_VALUE)).click();
		}else{
			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			getDriver().findElement(By.xpath(oHomePage.ARTICLE_VALUE)).click();
		}
		
		oSeleniumUtils.enter_given_text_webelement(oHomePage.RequestReview_LCD_ID,Serenity.sessionVariableCalled("RA_Completed_ID"));
		
		oSeleniumUtils.Click_given_Locator(oHomePage.Submit_Btn);
		
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	}

	@Step
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
		oSeleniumUtils.Click_given_Locator(oRAReviewWorkQueuePage.Checkbox);
		
		//Get the CPT/HCPCS Code
		String sCPT_HCPCSCode = oSeleniumUtils.get_TextFrom_Locator(oRAReviewWorkQueuePage.RAReviewCPT_HCPCS_Cell_Value);
		Serenity.setSessionVariable("CPT_HCPCSCode").to(sCPT_HCPCSCode);
		Serenity.setSessionVariable("HCPCCode_Support").to(sCPT_HCPCSCode);
		System.out.println(Serenity.sessionVariableCalled("HCPCCode_Support").toString());
						
		String sICDCode = oSeleniumUtils.get_TextFrom_Locator(oRAReviewWorkQueuePage.RAReviewICD_Code_Cell_Value);
		Serenity.setSessionVariable("ICDCode").to(sICDCode);
		Serenity.setSessionVariable("ICDCode_Support").to(sICDCode);
		System.out.println(Serenity.sessionVariableCalled("ICDCode_Support").toString());
		
		bStatus = oRAReviewWorkQueuePage.Accept_Btn.isEnabled();
		if(bStatus){
			//click on Accept
			oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.Accept_Btn);
			
			oSeleniumUtils.enter_given_text_webelement(oRAReviewWorkQueuePage.ReasonUpdateTextArea,"QA Testing");
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			
			//click on Apply
			oSeleniumUtils.Click_given_Locator(oRAReviewWorkQueuePage.Apply);
			
		}else{
			//click on Reject
			oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.Reject_Btn);			
			SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
			
			//Select Reason cmb 
			oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.SelectReasonCmb);
			
			//Select the Non-Configurable-Other Value
			oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.SelectReasonArrowIcon);			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			
			 //Select reason from Drop down
			 if(!oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oHomePage.SpanText, "sValue", ProjectVariables.SelectReasonValue))){
				 oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.SelectReasonArrowIcon);
				 SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			 }
	          oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue", ProjectVariables.SelectReasonValue));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			
			//Enter Reject reasons
			Serenity.setSessionVariable("Remarks").to("Functional Testing");
			oSeleniumUtils.enter_given_text_webelement(oRAReviewWorkQueuePage.RejectReasonTextArea,Serenity.sessionVariableCalled("Remarks"));
			System.out.println(Serenity.sessionVariableCalled("Remarks").toString());
			
			Serenity.setSessionVariable("ReasonForUpdating").to("QA Testing");
			System.out.println(Serenity.sessionVariableCalled("ReasonForUpdating").toString());
			oSeleniumUtils.enter_given_text_webelement(oRAReviewWorkQueuePage.ReasonUpdateTextArea,Serenity.sessionVariableCalled("ReasonForUpdating"));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			
			//click on Apply
			oSeleniumUtils.Click_given_Locator(oRAReviewWorkQueuePage.Apply);		
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		}
		oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.Update_Decision_Btn);		
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
		oSeleniumUtils.Click_given_Locator(oHomePage.Submit_Btn);								
		getDriver().close();
		oSeleniumUtils.switchWindowUsingWindowCount(100,1);	
	}

	@Step
	public void click_On_History_Link() {
		
		System.out.println(Serenity.sessionVariableCalled("RA_Completed_ID").toString());
		//Enter LCD ID
		oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "LCD/Article ID"),Serenity.sessionVariableCalled("RA_Completed_ID").toString());
		
		System.out.println(Serenity.sessionVariableCalled("CPT_HCPCSCode").toString());
		//Enter cpt code
		oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "CPT Code"),Serenity.sessionVariableCalled("CPT_HCPCSCode").toString());
		
		System.out.println(Serenity.sessionVariableCalled("ICDCode").toString());
		//Enter ICD CODE
		oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "ICD Code"),Serenity.sessionVariableCalled("ICDCode").toString());
		
		//Select Category comb 
		oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.SelectCategoryCmb);
		
		oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.SelectCategoryCmb);
		
		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		
		System.out.println(Serenity.sessionVariableCalled("Category").toString());
		
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue",Serenity.sessionVariableCalled("Category")));
		
		//click on apply filter
		oSeleniumUtils.Click_given_WebElement(oAdminPage.ApplyFilter_Btn);
		
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);		
		
		WebElement horizontal_scroll = getDriver().findElement(By.xpath("//div[@class='ui-grid-render-container ng-isolate-scope ui-grid-render-container-body']/div//div[@class='ui-grid-header-cell-row']/div[14]")); 
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);
		
		WebElement element = getDriver().findElement(By.xpath(oAdminPage.sHistoryLink));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		oSeleniumUtils.Click_given_Locator(oAdminPage.sHistoryLink);
		
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
	}
	
	@Step
	public void Validate_Code_Combination_History() {
		String sDecisionColumnTargetDataQuery = "";
		String sRemarksColumnTargetDataQuery = "";
		String sDecisionReasonColumnTargetDataQuery = "";

		//LCD OR Article ID
		String sActual_LCD_OR_ArticleID = oSeleniumUtils.get_TextFrom_Locator(oAdminPage.sTargetDataLCD_ID_HeaderValue);
		Assert.assertTrue("LCD_OR_ArticleID Header value in Code Combination History screen",sActual_LCD_OR_ArticleID.equalsIgnoreCase(Serenity.sessionVariableCalled("RA_Completed_ID").toString()));

		//CPT_HCPCSCode
		String sActual_CPT_HCPCSCode = oSeleniumUtils.get_TextFrom_Locator(StringUtils.replace(oAdminPage.sTargetDataHeaderValue, "sHeaderName","HCPCS code :"));
		Assert.assertTrue("LCD_OR_ArticleID Header value in Code Combination History screen",sActual_CPT_HCPCSCode.equalsIgnoreCase(Serenity.sessionVariableCalled("CPT_HCPCSCode").toString()));

		//CPT_HCPCSCode
		String sActual_ICD_Code_Group = oSeleniumUtils.get_TextFrom_Locator(StringUtils.replace(oAdminPage.sTargetDataHeaderValue, "sHeaderName","ICD Code :"));
		Assert.assertTrue("LCD_OR_ArticleID Header value in Code Combination History screen",sActual_ICD_Code_Group.equalsIgnoreCase(Serenity.sessionVariableCalled("ICDCode").toString()));

		//Category
		String sActual_Category = oSeleniumUtils.get_TextFrom_Locator(StringUtils.replace(oAdminPage.sTargetDataHeaderValue, "sHeaderName","Category :"));
		Assert.assertTrue("LCD_OR_ArticleID Header value in Code Combination History screen",sActual_Category.equalsIgnoreCase(Serenity.sessionVariableCalled("Category").toString()));

		sDecisionColumnTargetDataQuery = "SELECT DECODE(TL.APPROPRIATE_10, -1, 'Accept', 0, 'Reject') as Decision FROM LCD.LCD_CPT_ICD_LINKS_LOG TL"
				+" where TL.LCD_ID= "+Serenity.sessionVariableCalled("RA_Completed_ID").toString()+" AND TL.HCPC_CODE = '"+Serenity.sessionVariableCalled("CPT_HCPCSCode").toString()+"' AND TL.ICD_CODE = '"+Serenity.sessionVariableCalled("ICDCode").toString()+"'"
				+" AND TL.ICD_GROUP = 1 ORDER BY TL.DECISION_DATE";

		sRemarksColumnTargetDataQuery = "SELECT TL.REMARKS FROM LCD.LCD_CPT_ICD_LINKS_LOG TL"
				+" where TL.LCD_ID= "+Serenity.sessionVariableCalled("RA_Completed_ID").toString()+" AND TL.HCPC_CODE = '"+Serenity.sessionVariableCalled("CPT_HCPCSCode").toString()+"' AND TL.ICD_CODE = '"+Serenity.sessionVariableCalled("ICDCode").toString()+"'"
				+" AND TL.ICD_GROUP = 1 ORDER BY TL.DECISION_DATE";

		sDecisionReasonColumnTargetDataQuery = "SELECT TL.DECISION_UPDATE_REASON as DecisionUpdateReason FROM LCD.LCD_CPT_ICD_LINKS_LOG TL"
				+" where TL.LCD_ID= "+Serenity.sessionVariableCalled("RA_Completed_ID").toString()+" AND TL.HCPC_CODE = '"+Serenity.sessionVariableCalled("CPT_HCPCSCode").toString()+"' AND TL.ICD_CODE = '"+Serenity.sessionVariableCalled("ICDCode").toString()+"'"
				+" AND TL.ICD_GROUP = 1 ORDER BY TL.DECISION_DATE";

		try {
			Assert.assertTrue("Decision column values compared with the DB Values ",oAdminPage.CompareDB_UIColumnValues(sDecisionColumnTargetDataQuery, "DECISION",oAdminPage.sDecisionCol));
			Assert.assertTrue("Remarks column values compared with the DB Values ",oAdminPage.CompareDB_UIColumnValues(sRemarksColumnTargetDataQuery, "REMARKS",oAdminPage.sRemarksCol));
			Assert.assertTrue("Decision update Reason  column values compared with the DB Values ",oAdminPage.CompareDB_UIColumnValues(sDecisionReasonColumnTargetDataQuery, "DECISIONUPDATEREASON",oAdminPage.sDecisionReasonCol));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Step
	public void validateTargetDataColumnsHeaders() {
		
		Assert.assertTrue("Target",oAdminPage.validateColumnHeaders());			
	 }

	@Step
	public void validateTargetDataRecordsCount() {
	
	  int UICount=0;
	  int DBCount=0;
	  String sTargetQuery;	
	  
	  
	    //Retrieve Target screen Records count from UI		
	  
		try {
			  UICount= oAdminPage.retrievePageItemsCount("","AdminTargetData");
		    } catch (Exception e) {			
		      e.printStackTrace();
		  }
		
		sTargetQuery="Select count(*) from (SELECT * FROM LCD.LCD_CPT_ICD_LINKS  UNION  SELECT * FROM LCD.ARTICLE_CPT_ICD_LINKS)";
		
		//Retrieve DB Count		  
		DBCount= Integer.parseInt(DBUtils.executeSQLQuery(sTargetQuery));
		
		if (UICount==DBCount)
		{
		  Assert.assertTrue("Admin TargetData Screen items count matched between DB and UI",true);		  
		}else{
			 Assert.assertTrue("Admin TargetData Screen items count Not matched between DB and UI",false);
			 logger.info("Admin screen DB count: "+DBCount+"Admin screen UI count: "+UICount);
		}
		
	}
	
	@Step
	public void ValidateTargetDataTabFilters() {
		
		
		  //Retrieve LCD ID	  
		  String LCD_ID = DBUtils.executeSQLQuery(DBQueries.sAdminTarget_LCDQuery);			   
		  //Enter the ID in the input field				  
	  oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "LCD/Article ID"),LCD_ID);
				
		  
	       String sAdminTarget_HCPCCPTCodeQuery = "Select HCPC_CODE from LCD.LCD_CPT_ICD_LINKS where lcd_id="+LCD_ID+"and rownum=1";
		  //Retrieve CPTHCPCSCode	  		  
		  String HCPCCPTCode = DBUtils.executeSQLQuery(sAdminTarget_HCPCCPTCodeQuery);		   
		  //Enter the ID in the input field				 
		  oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "CPT Code"),HCPCCPTCode);
		 
		
		  //Retrieve HCPCCPTGroup		  		  		  
		  String sAdminTarget_HCPCCPTCodeGrpQuery = "Select HCPC_CODE_GROUP from LCD.LCD_CPT_ICD_LINKS where lcd_id="+LCD_ID+"and rownum=1";
		  String HCPCCPTCodeGroup = DBUtils.executeSQLQuery(sAdminTarget_HCPCCPTCodeGrpQuery);
		  
		  oAdminPage.CPTGroupDropDown.click();		  
		  oAdminPage.CPTGroupDrpDownSearchBox.sendKeys(HCPCCPTCodeGroup);
		  
		    //Click on the Selected value
		    try{
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oAdminPage.FilterTag,"sValue",HCPCCPTCodeGroup));
			   }
			    catch(Exception e){
				getDriver().quit();				
			}
		    
		    //Close the drop down
		    oAdminPage.CPTGroupDropDown.click();	
		  		
		  
		  //Retrieve ICD Code	
		  String sAdminTarget_ICDCodeQuery = "Select ICD_code from LCD.LCD_CPT_ICD_LINKS where lcd_id="+LCD_ID+"and rownum=1";
		  String ICDCOde = DBUtils.executeSQLQuery(sAdminTarget_ICDCodeQuery);		   
		  //Enter the ID in the input field				 
		  oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "ICD Code"),ICDCOde);
		  
		  
		  //Retrieve ICDGroup	
		  String sAdminTarget_ICDGrpQuery = "Select ICD_GROUP from LCD.LCD_CPT_ICD_LINKS where lcd_id="+LCD_ID+"and rownum=1";
		  String ICDGroup = DBUtils.executeSQLQuery(sAdminTarget_ICDGrpQuery);	
		  
		  oAdminPage.ICDGroupDropDown.click();		  
		  oAdminPage.ICDGroupSearchBox.sendKeys(ICDGroup);	
		  
		  
		    //Click on the Selected value
		    try{
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oAdminPage.ICDGroupVal,"sValue",ICDGroup));
			   }
			    catch(Exception e){
				getDriver().quit();				
			   }
		  
		  
		  //Retrieve Category
		  String sAdminTarget_CategoryQuery = "Select DECODE(SUPPORTS_10, -1, 'Support', 0, 'Does Not Support') AS CATEGORY from LCD.LCD_CPT_ICD_LINKS where lcd_id="+LCD_ID+"and rownum=1";
		  String Category = DBUtils.executeSQLQuery(sAdminTarget_CategoryQuery);		  
		  
		  oAdminPage.CategoryDropDown.click();		  
		  oAdminPage.CategorySearchBox.sendKeys(Category);		  
		  
		    //Click on the Selected value
		    try{
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oAdminPage.FilterTag,"sValue",Category));
			   }
			    catch(Exception e){
				getDriver().quit();				
			   }
		    
		    
		    //Assigning the Support value to variable to use in the SQL query below for retrieving DB Count
		          String SupportVal="";
		     
		        if (Category.equalsIgnoreCase("Support"))
		        {	
		        	SupportVal= "-1";
		           }
		        else{  SupportVal= "0";  }
		  
		  
		  
		  //Retrieve DOSFrom Code	 
		  String sAdminTarget_DOSFromQuery = "Select To_Char(DOS_From,'MM/DD/YYYY') from LCD.LCD_CPT_ICD_LINKS where lcd_id="+LCD_ID+"and rownum=1";
		  String DOSFrom = DBUtils.executeSQLQuery(sAdminTarget_DOSFromQuery);		   
		  //Enter the ID in the input field				 
		  oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "DOS From"),DOSFrom);
		  
		  		  
		  //Retrieve DOSTo Code	
		  String sAdminTarget_DOSToQuery = "Select To_Char(DOS_To,'MM/DD/YYYY') from LCD.LCD_CPT_ICD_LINKS where lcd_id="+LCD_ID+"and rownum=1";
		  String DOSTo = DBUtils.executeSQLQuery(sAdminTarget_DOSToQuery);			   
		  //Enter the ID in the input field				 
		  oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "DOS To"),DOSTo);
		  
		  
		 //Retrieve Decision
		  String sAdminTarget_DecisionQuery = "Select DECODE(APPROPRIATE_10, -1, 'Accept', 0, 'Reject') AS REVIEW_DECISION from LCD.LCD_CPT_ICD_LINKS where lcd_id="+LCD_ID+"and rownum=1";
		  String Decision = DBUtils.executeSQLQuery(sAdminTarget_DecisionQuery);
		  		  
		  oSeleniumUtils.Click_given_WebElement(oAdminPage.DecisionDropDown); 		 	  
		  oAdminPage.DecisionSearchBox.sendKeys(Decision);		
		 
		  
		    //Click on the Selected value
		    try{
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oAdminPage.FilterTag,"sValue",Decision));
			   }
			    catch(Exception e){
				getDriver().quit();				
			   }	
		    
		    //Assigning the Decision value to variable to use in the SQL query below for retrieving DB Count
	          String DecisionVal="";
	     
	        if (Decision.equalsIgnoreCase("Accept"))
	        {	
	        	   DecisionVal= "-1";
	           }
	        else{  DecisionVal= "0";  }		
			 
		    
		  		  
          //Assignee Web element scrolling into view		
			SeleniumUtils.scrollingToGivenElement(getDriver(), oAdminPage.AssigneeColumnDropDownIcon);						
			oSeleniumUtils.Click_given_WebElement(oAdminPage.AssigneeDropDown);				 					 
							
					  		  
		    //Retrieve Assignee	  		  
		     String sAdminTarget_AssigneeQuery = "Select DECISION_USER AS ASSIGNEE from LCD.LCD_CPT_ICD_LINKS  where lcd_id="+LCD_ID+"and rownum=1";
		     String Assignee = DBUtils.executeSQLQuery(sAdminTarget_AssigneeQuery);	  		     	    
		    	  
			 oAdminPage.AssigneeDrpDownSearchBox.sendKeys(Assignee);		  
			  
		    //Click on the Selected value
		    try{
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oAdminPage.AssigneeNameTag,"sValue",Assignee));
			   }
			    catch(Exception e){
				getDriver().quit();				
			   }		    
		   
				
			WebElement element = getDriver().findElement(By.xpath(StringUtils.replace(oAdminPage.TargetDataColNames, "sValue", "Remarks")));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			

		  //Retrieve Remarks Code	
		 String sAdminTarget_RemarksQuery = "Select REMARKS from LCD.LCD_CPT_ICD_LINKS  where lcd_id="+LCD_ID+"and rownum=1";		  
		 String Remarks = DBUtils.executeSQLQuery(sAdminTarget_RemarksQuery);
		 
		     String RemarksVal="";
		  
		     if(Remarks.isEmpty()){
		    	   System.out.println("Query returned no result");
		    	   logger.info("Query returned no result");
		    	   //Assigning value to a variable to be used in below SQL Query
		    	   RemarksVal  =  "is NULL"; 		    	 
		     }else{	
		    	 
				  System.out.println("Query result"+Remarks);	
				  System.out.println("Query result"+Remarks);
				  RemarksVal  = "="+"'"+Remarks+"'";
				  
				  //Enter the ID in the input field				 
				  oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "Remarks"),Remarks);
		        }  		  
			
		   element = getDriver().findElement(By.xpath(StringUtils.replace(oAdminPage.TargetDataColNames, "sValue", "Reason For Updating Decision")));
		 ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		  
		  
		  //Retrieve ReasonForUpdating decision Code
		  String sAdminTarget_DcsnUpdtRsn = "Select Decision_update_reason from LCD.LCD_CPT_ICD_LINKS  where lcd_id="+LCD_ID+"and rownum=1";
		  String RsnFrUpdtngDecision = DBUtils.executeSQLQuery(sAdminTarget_DcsnUpdtRsn);	
		  String sDecisionReason="";
		  
		  if(RsnFrUpdtngDecision.isEmpty()){
		    	 System.out.println("Query returned no result");
		    	 logger.info("Query returned no result");
		    	  //Assigning value to a variable to be used in below SQL Query
		    	  sDecisionReason  =  "is NULL"; 		    	 
		     }else{	
		    	  
		    	 System.out.println("Query result"+RsnFrUpdtngDecision);	
				  sDecisionReason  = "="+sDecisionReason;
				  //Enter the ID in the input field				 
				  oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "Reason For Updating Decision"),RsnFrUpdtngDecision);
		        } 

		  
		  element = getDriver().findElement(By.xpath(StringUtils.replace(oAdminPage.TargetDataColNames, "sValue", "Commit Date")));
			 ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		  
		 //CommitDate
		  String sAdminTarget_Cmtdate = "Select To_Char(decision_date,'MM/DD/YYYY') from LCD.LCD_CPT_ICD_LINKS  where lcd_id="+LCD_ID+"and rownum=1";
		  String CommitDate = DBUtils.executeSQLQuery(sAdminTarget_Cmtdate);		   
		  //Enter the ID in the input field				 
		  oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "Commit Date"),CommitDate);
		  
		  		  
		  //Click on Apply Filter
		  oAdminPage.ApplyFilter_Btn.click();
		  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		  
		  
		  //Retrieve UI Count
		  int allItemsUICount=0;
		  
		  try {
			 allItemsUICount = oAdminPage.retrievePageItemsCount("","AdminTargetData");
		   } catch (Exception e) {			
			e.printStackTrace();
		}
		  		  
		  String sb = "SELECT COUNT (*)" +
				  "  FROM (SELECT lcd_id," +
				  " HCPC_CODE," +
				  " HCPC_CODE_GROUP," +
				  " ICD_code," +
				  " ICD_group," +
				  " DECISION_USER AS ASSIGNEE," +
				  " remarks," +
				  " Decision_update_reason," +
				  " TO_CHAR (DOS_From, 'MM/DD/YYYY')," +
				  " TO_CHAR (DOS_TO, 'MM/DD/YYYY')," +
				  " TO_CHAR (decision_date, 'MM/DD/YYYY')," +
				  " DECODE (SUPPORTS_10,  -1, 'Support',  0, 'Does Not Support')" +
				  " AS CATEGORY," +
				  " DECODE (APPROPRIATE_10,  -1, 'Accept',  0, 'Reject')" +
				  " AS REVIEW_DECISION" +
				  " FROM LCD.LCD_CPT_ICD_LINKS" +
				  " WHERE lcd_id ="+LCD_ID+
				  " AND HCPC_CODE ="+"'"+HCPCCPTCode+"'" +
				  " AND HCPC_CODE_GROUP ="+HCPCCPTCodeGroup+
				  " AND ICD_code ="+"'"+ICDCOde+"'" +
				  " AND ICD_group ="+ICDGroup+
				  " AND SUPPORTS_10 ="+SupportVal+
				  " AND TO_CHAR(DOS_From, 'MM/DD/YYYY') ="+"'"+DOSFrom+"'" +
				  " AND TO_CHAR(DOS_To, 'MM/DD/YYYY') = "+"'"+DOSTo+"'" +
				  " AND APPROPRIATE_10 ="+DecisionVal +
				  " AND DECISION_USER = "+"'"+Assignee+"'"+
				  " and  REMARKS "+RemarksVal+
				  " and Decision_update_reason " +sDecisionReason +
				  " AND TO_CHAR (decision_date,'MM/DD/YYYY') ="+"'"+CommitDate+"')";
		  
		  
		  int DBCount = Integer.parseInt(DBUtils.executeSQLQuery(sb));			  
		  System.out.println("Total records count"+DBCount);
		  		  		  
		  //Compare UI count and DB Count		  
		  if(allItemsUICount==DBCount){
			  System.out.println("UI and DB count matched after applying Filter");
			  logger.info("UI and DB count matched after applying Filter");
			  
		  }
		  else{	Assert.assertTrue("UI and DB count matched after applying Filter:: UICount:"+allItemsUICount+",DB Count:"+DBCount,false); }
		  
		  
		  //Apply clear filters  and compare the count of total UI elements with DB
		   oSeleniumUtils.Click_given_WebElement(oAdminPage.ClearAllFilters_Btn);
		   oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		   
		   
		     //Retrieve UI Count
			  int itemsUICount=0;
			  
			  try {
				  itemsUICount = oAdminPage.retrievePageItemsCount("","AdminTargetData");
			   } catch (Exception e) {			
				e.printStackTrace();
			}
		   		   	         
	int itemsCountAfterRemovingFilterDB=Integer.parseInt(DBUtils.executeSQLQuery(DBQueries.sAllItemsCount_Admin_TargetTab_Query_LCD_Article));
	
	 //Compare UI count and DB Count		  
	  if(itemsUICount==itemsCountAfterRemovingFilterDB){
		  System.out.println("UI and DB count matched after clearing applied Filter");
		  logger.info("UI and DB count matched after clearing applied Filter");
	  }
	  else{	Assert.assertTrue("UI and DB count matched after applying Filter:: UICount:"+itemsUICount+",DB Count:"+DBCount,false); }
		  		
	
	
	 //Filter on Remarks column 	 
    String sAdminTarget_RemarksCodeQuery = "Select Remarks from LCD.LCD_CPT_ICD_LINKS where lcd_id="+LCD_ID+"and rownum=1 and remarks is not null";
    
	  //Retrieve Remarks	  		  
	  String RemarksValue = DBUtils.executeSQLQuery(sAdminTarget_RemarksCodeQuery);		  
	  
	  //Enter the ID in the input field				 
	  oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "Remarks"),RemarksValue);
	  
	  //Click on Apply Filter
	  oAdminPage.ApplyFilter_Btn.click();
	  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	  	  
	  //Retrieve UI Count
	  
	  itemsUICount=0;	  
	  try {
		  itemsUICount = oAdminPage.retrievePageItemsCount("","AdminTargetData");
	   } catch (Exception e) {			
		e.printStackTrace();
	}
 		  
	  String RemarksUpperValue= RemarksValue.toUpperCase();	  	  
	  
	  String RemarksCountQuery=  "SELECT COUNT (*)"+
            " FROM (SELECT * "+
            " FROM LCD.LCD_CPT_ICD_LINKS"+
            " WHERE UPPER (remarks) LIKE '%"+RemarksUpperValue+"%'"+
            " UNION"+
            " SELECT *"+
            " FROM LCD.ARTICLE_CPT_ICD_LINKS"+
            " WHERE UPPER (remarks) LIKE '%"+RemarksUpperValue+"%')";
		  
	  int RemarksDBCount = Integer.parseInt(DBUtils.executeSQLQuery(RemarksCountQuery));
	  
	  if( itemsUICount==RemarksDBCount )
	  {
		 System.out.println("UI and DB count matched after Applying Filter on Remarks column");
		logger.info("UI and DB count matched after Applying Filter on Remarks column");
	  }
	  else{	Assert.assertTrue("UI and DB count matched after applying Filter:: UICount:"+itemsUICount+",DB Count:"+RemarksDBCount,false); }
			
	}

	@Step
	public void user_Sort_TargetData_Tab(String sColumnName) {
		
		List<String> items = Arrays.asList(sColumnName.split(","));
		for(int iLoop = 0; iLoop < items.size();iLoop++){
			System.out.println(StringUtils.replace(oAdminPage.sColHeader, "sHeaderName", items.get(iLoop)));
			WebElement element = getDriver().findElement(By.xpath(StringUtils.replace(oAdminPage.sColHeader, "sHeaderName", items.get(iLoop))));
			 ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			
			 //Ascending Order
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oAdminPage.sColHeader,"sHeaderName",items.get(iLoop)));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
			//Descending Order
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oAdminPage.sColHeader,"sHeaderName",items.get(iLoop)));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		}
		logger.info("Column Name"+items.get(items.size()-1));
		Serenity.setSessionVariable("ColumnName").to(items.get(items.size()-1));

		/*//Ascending Order

		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oAdminPage.sColHeader,"sHeaderName",sColumnName));
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		
		//Descending Order
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oAdminPage.sColHeader,"sHeaderName",sColumnName));
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);*/
	}
	
	@Step
	public void user_should_be_able_to_sort_in_the_TargetData(String sColumnName) {		
		
		boolean bStatus = false;
		//scrolling to element
		WebElement element = getDriver().findElement(By.xpath(StringUtils.replace(oAdminPage.sTargetDataColSortIcon,"sHeaderName",Serenity.sessionVariableCalled("ColumnName").toString())));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		//retrieving attribute
		String sColuumnSortValue = oSeleniumUtils.get_AttributeValueFrom_Locator(StringUtils.replace(oAdminPage.sTargetDataColSortIcon,"sHeaderName",Serenity.sessionVariableCalled("ColumnName").toString()),oHomePage.sAttributeName);
		System.out.println("column status "+sColuumnSortValue);
		logger.info("column status "+sColuumnSortValue);
		
		if(sColuumnSortValue.equalsIgnoreCase("Sort None")){
			bStatus = false;
		}else{
			bStatus = true;
		}
		Assert.assertTrue("The Column '"+sColumnName+"' is sorted ",bStatus);
	}

	public void filter_MutipleTargetColumns_Assignee(String sAssigneeName) {
		
		try {
			oAdminPage.fn_Validate_Multiple_Filters_TargeData_Assignee(sAssigneeName);
		    } catch (Exception e) {			
			  e.printStackTrace();
		   }
		
		
	}

	
	@Step
	public void filterTargetTabRecordWithCodeCombinationandJury(String juryName)
	{
		System.out.println(Serenity.sessionVariableCalled("RA_Completed_ID").toString());
		System.out.println(Serenity.sessionVariableCalled("CPT_HCPCSCode").toString());
		System.out.println(Serenity.sessionVariableCalled("ICDCode").toString());
		System.out.println(Serenity.sessionVariableCalled("Category").toString());
		
		String juryList[] = juryName.split(",");
		for(int i=0; i<juryList.length;i++){
			//Enter LCD ID
			oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "LCD/Article ID"),Serenity.sessionVariableCalled("RA_Completed_ID").toString());
			//Enter cpt code
			oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "CPT Code"),Serenity.sessionVariableCalled("CPT_HCPCSCode").toString());
			//Enter ICD CODE
			oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "ICD Code"),Serenity.sessionVariableCalled("ICDCode").toString());
			//Select Category comb 
			oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.SelectCategoryCmb);
			oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.SelectCategoryCmb);	
			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue",Serenity.sessionVariableCalled("Category")));
			//Enter jury name
			WebElement horizontal_scroll = getDriver().findElement(By.xpath("//div[@class='ui-grid-render-container ng-isolate-scope ui-grid-render-container-body']/div//div[@class='ui-grid-header-cell-row']/div[12]")); 
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);
			
			WebElement element = getDriver().findElement(By.xpath(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "Jurisdiction")));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "Jurisdiction"),juryList[i]);
			//Enter Remarks 
			WebElement horizontal_scroll1 = getDriver().findElement(By.xpath("//div[@class='ui-grid-render-container ng-isolate-scope ui-grid-render-container-body']/div//div[@class='ui-grid-header-cell-row']/div[13]")); 
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll1);
			
			WebElement element1 = getDriver().findElement(By.xpath(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "Remarks")));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element1);
			oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "Remarks"),Serenity.sessionVariableCalled("Remarks"));		
			//Enter Reason For Updating Decision 
			WebElement horizontal_scroll2 = getDriver().findElement(By.xpath("//div[@class='ui-grid-render-container ng-isolate-scope ui-grid-render-container-body']/div//div[@class='ui-grid-header-cell-row']/div[14]")); 
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll2);
			
			WebElement element2 = getDriver().findElement(By.xpath(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "Reason For Updating Decision")));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element2);
			oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "Reason For Updating Decision"),Serenity.sessionVariableCalled("ReasonForUpdating"));
					
			//click on apply filter
			oSeleniumUtils.Click_given_WebElement(oAdminPage.ApplyFilter_Btn);	
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
			/*String sDecision = oSeleniumUtils.get_TextFrom_Locator(oAdminPage.sDecision);
			System.out.println(sDecision);
			Assert.assertTrue("Reject decision is validated in TargetData tab for HCPC and ICD code combination and jury name in UI",sDecision.equalsIgnoreCase("Reject"));
			String sRemarks = oSeleniumUtils.get_TextFrom_Locator(oAdminPage.sRemarks);
			System.out.println(sRemarks);
			Assert.assertTrue("Remarks "+sRemarks+" is validated in TargetData tab for HCPC and ICD code combination and jury name in UI",sRemarks.equalsIgnoreCase(Serenity.sessionVariableCalled("Remarks")));*/
			
			WebElement horizontal_scroll4 = getDriver().findElement(By.xpath("//div[@class='ui-grid-render-container ng-isolate-scope ui-grid-render-container-body']/div//div[@class='ui-grid-header-cell-row']/div[14]")); 
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll4);
			
			WebElement element4 = getDriver().findElement(By.xpath(oAdminPage.sHistoryLink));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element4);
			Assert.assertTrue("Updated record is validated TargetData tab for HCPC and ICD code combination and jury name in UI",oSeleniumUtils.is_WebElement_Displayed(oAdminPage.sHistoryLink));
			
					
			oSeleniumUtils.Click_given_WebElement(oAdminPage.ClearAllFilters_Btn);	
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			WebElement horizontal_scroll3 = getDriver().findElement(By.xpath("//div[@class='ui-grid-render-container ng-isolate-scope ui-grid-render-container-body']/div//div[@class='ui-grid-header-cell-row']/div[1]")); 
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll3);
			
			WebElement element3 = getDriver().findElement(By.xpath(StringUtils.replace(oAdminPage.sTargetDataColHeaderTxt, "sHeaderName", "LCD/Article ID")));
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element3);
			
		}
		
				
	}
}
