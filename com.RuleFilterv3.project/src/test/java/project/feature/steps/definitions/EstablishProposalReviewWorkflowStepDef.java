package project.feature.steps.definitions;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

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

public class EstablishProposalReviewWorkflowStepDef extends ScenarioSteps {

	private static final long serialVersionUID = 5898280540796957114L;
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EstablishProposalReviewWorkflowStepDef.class);

	HomePage oHomePage;
	SeleniumUtils oSeleniumUtils;
	RAReviewWorkQueuePage oRAReviewWorkQueuePage;
	DBQueries oDBQueries;
	AdminPage oAdminPage;
	RAReviewWorkQueuePage  oRAPage;
	TargetTableRecordsReviewPage  oTargetScreenPage;
	CreateProposalStepDef oCreateProposal;
	
	
	@Step
	public void ra_Claims_LCD_Code_From_Group_Tasks() throws InterruptedException  {
					
		Serenity.setSessionVariable("LCD_ID").to(DBUtils.executeSQLQuery(DBQueries.LCD_ID_Query));		
			
		System.out.println(Serenity.sessionVariableCalled("LCD_ID").toString());
		
		if(!Serenity.sessionVariableCalled("LCD_ID").equals("")){
			
			oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,Serenity.sessionVariableCalled("LCD_ID"));
			
			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
			
			oSeleniumUtils.Click_given_WebElement(oHomePage.ID_Checkbox);
			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			
			oSeleniumUtils.Click_given_WebElement(oHomePage.ClaimTask_Btn);
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		}else{
			Assert.assertTrue("There is no LCD/Article ids whose status as not started.",false);
		}				
	}

	@Step
	public void claimed_Code_Should_Be_Dispalyed_As(String sReviewStatus) {
		
		//Enter the Claimed code
		oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,Serenity.sessionVariableCalled("LCD_ID"));
		
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		
		Assert.assertTrue("Review Status should be dispalyed as "+sReviewStatus,oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oHomePage.DivTages,"sValue", sReviewStatus)));
//		oSeleniumUtils.Click_given_WebElement(oHomePage.Remove_Filter);
		
	}
	
	@Step
	public void ra_Clicks_on(String arg1) {		
		switch(arg1){
		
			case "Claimed LCD_Article_ID":
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags,"sValue",Serenity.sessionVariableCalled("LCD_ID")));
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				break;
				
			case "Start Review":				
				if (oRAReviewWorkQueuePage.StartReview_Btn.isCurrentlyEnabled())
				{		
					oRAReviewWorkQueuePage.StartReview_Btn.click();					
					oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				}		
				else
				{
					 logger.error("Start Review button  is in disabled state,so cannot perform click");
					Assert.assertTrue("Start Review button is in disabled state,so cannot perform click",false);
				}
		          //If Date banding is done on records then we close the pop up by clicking on OK button
				  if (oSeleniumUtils.is_WebElement_Present(oRAReviewWorkQueuePage.DATEBANDING_MESSAGE_OKBTN)) {
					  oSeleniumUtils.Click_given_Locator(oRAReviewWorkQueuePage.DATEBANDING_MESSAGE_OKBTN);								
					  logger.info("Date banding message popup displayed");
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				     }				  
				break;
				
			case "Accept":
				
				if (oRAReviewWorkQueuePage.Accept_Btn.isCurrentlyEnabled())
				{	
					     oRAReviewWorkQueuePage.Accept_Btn.click();						
					     oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				}
				else
				{
					 logger.error("Accept button  is in disabled state,so cannot perform click");
					Assert.assertTrue("Accept Review button is in disabled state,so cannot perform click",false);
				}
				
				break;				
			case "Reject":	
				
				if (oRAReviewWorkQueuePage.Reject_Btn.isCurrentlyEnabled())
				{					
					oRAReviewWorkQueuePage.Reject_Btn.click();				
					oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				}
				else
				{
					 logger.error("Reject button is in disabled state,so cannot perform click");
					Assert.assertTrue("Reject button is in disabled state,so cannot perform click",false);
				}
				break;	
			case "ClearAllFilters":				    
							if (oRAReviewWorkQueuePage.ClearAllFilters_Btn.isCurrentlyEnabled())
							{						
								oRAReviewWorkQueuePage.ClearAllFilters_Btn.click();								
								oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
							}
							else
							{
								 logger.error("ClearAllFilters button is in disabled state,so cannot perform click");
								Assert.assertTrue("ClearAllFilters button is in disabled state,so cannot perform click",false);								
							}								
						
				break;
			case "ApplyFilters":
					if (oRAReviewWorkQueuePage.ApplyFilter_Btn.isCurrentlyEnabled())
					{													
						 oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.ApplyFilter_Btn);
						 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
					}	 
					else
					{
						 logger.error("ApplyFilters button is in disabled state,so cannot perform click");
						Assert.assertTrue("ApplyFilters button is in disabled state,so cannot perform click",false);								
					}								
				
				 
				break;			
			case "ReviewDecisionDropdown":				
				//Click on ReviewDecision Drop down 
				 oRAReviewWorkQueuePage.ReviewDecisionDropDown.click();	 			
				 SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);				
				break;						
			case "BlankReviewDecision":				
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAReviewWorkQueuePage.ReviewDecisionDrpdownValues,"ReviewDecisionVal","Blank"));
				 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);			
				break;						
			case "AcceptReviewDecision":				
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAReviewWorkQueuePage.ReviewDecisionDrpdownValues,"ReviewDecisionVal","Accept"));
				 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);				
				break;	
			case "RejectReviewDecision":				
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAReviewWorkQueuePage.ReviewDecisionDrpdownValues,"ReviewDecisionVal","Reject"));
				 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);				
				break;		
							
			case "CompleteRAReview":				
				if (oRAPage.CompleteRAReview_Btn.isCurrentlyEnabled())
				{	
					 oRAPage.CompleteRAReview_Btn.click();						 
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	         
					  oSeleniumUtils.Click_given_Locator(oHomePage.sAlertPopupOKBtn);
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
				}
				else
				{
					 logger.error("CompleteRAReview button  is in disabled state,so cannot perform click");
					Assert.assertTrue("CompleteRAReview  button is in disabled state,so cannot perform click",false);
				}							
			break;	
			
			case "RequestCodeCombinationReview":				
				if (getDriver().findElement(By.xpath(oTargetScreenPage.ReqCodeCombReviewButton)).isEnabled())
				{	
					  getDriver().findElement(By.xpath(oTargetScreenPage.ReqCodeCombReviewButton)).click();		 
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);					 
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
				}
				else
				{
					 logger.error("RequestCodeCombinationReview button  is in disabled state,so cannot perform click");
					Assert.assertTrue("RequestCodeCombinationReview  button is in disabled state,so cannot perform click",false);
				}							
			break;	
			

			case "AdhocReviewTab":				
				if (getDriver().findElement(By.xpath(oTargetScreenPage.AdhocReviewTab)).isEnabled())
				{	
					  getDriver().findElement(By.xpath(oTargetScreenPage.AdhocReviewTab)).click();		 
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);						
				}
				else
				{
					 logger.error("AdhocReview Tab   is in disabled state,so cannot perform click");
					Assert.assertTrue("AdhocReview Tab  button is in disabled state,so cannot perform click",false);
				}							
			break;	
			
			
			case "ShowDataIntegrityRecord":
				
				if (getDriver().findElement(By.xpath(oAdminPage.sDataIntrgtButton)).isEnabled())
				{	
					  getDriver().findElement(By.xpath(oAdminPage.sDataIntrgtButton)).click();		 
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);			 
					
				}
				else
				{
					 logger.error("ShowDataIntegrityRecord Button   is in disabled state,so cannot perform click");
					Assert.assertTrue("ShowDataIntegrityRecord Button  is in disabled state,so cannot perform click",false);
				}							
			break;	
				
				
			
			default:  System.out.println("No option specified to select and click on the Webelement");				 	
		}
	}
	
	@Step
	public void ra_Review_Work_Queue_Screen() {
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
		Assert.assertTrue("RA Review WorkQueue page should be displayed.",oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.RA_Review_WorkQueue));
		logger.info("RA Review WorkQueue page is displayed");
	}

	@Step
	public void review_Status_As(String sReviewStatus) {
		logger.info("Review status is displayed as:"+sReviewStatus);
		Assert.assertTrue("Review status should be displayed as "+sReviewStatus,sReviewStatus.equalsIgnoreCase(oSeleniumUtils.get_Text_From_WebElement(oRAReviewWorkQueuePage.ReviewStatus_Txt)));		
	}

	@Step
	public void ra_Enters_Remarks_For_Rejected_Code(String sRemarks) throws Exception {
		oRAReviewWorkQueuePage.Enters_Remarks_For_Rejected_Codes(sRemarks);	
	}
	
	@Step
	public void ra_Able_To_Filter_Codes_Based_on(String sFilterType) {
		try {
			Assert.assertTrue("RA Should be able to Filter Codes Based on "+sFilterType,oRAReviewWorkQueuePage.Filter_Codes_Based_On(sFilterType));
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}	
	}

	@Step
	public void ra_Able_Sorted_Remarks_Column() {
		Assert.assertTrue("RA Should be able to Sort the Remarks Column ",oRAReviewWorkQueuePage.Sort_Remarks_Column());	
	}
		
	@Step
	public void clickOnTaskID() {		
	 Assert.assertTrue("Admin clicks on the First ID ",oAdminPage.clicksFirstReviewTaskID());		
	}
	
	@Step
	public void selectRadioButton(String arg1) {		
		Assert.assertTrue("Select the LongView radio button ",oAdminPage.selectRadioButton(arg1));
	}
	
	@Step
	public void validateTooltipDescription() {	
	   Assert.assertTrue("Validate Tooltip Description ",oAdminPage.validateToolTipDescriptionForSupportDontSupport());	
	}
	
	@Step	
	public void validateTooltipDescriptionMaxLength(String arg1, String arg2) {
		Assert.assertTrue("Validate Tooltip Description of different lengths",oAdminPage.validateToolTipMaxLength(arg1,arg2));		
	}
	
	@Step	
	public void ra_able_To_View_Review_Tasks_GroupTask_Screen() {
		
		int iActualItemsCount,iArticleItemsCount,iLCDItemsCount,iExpectedItemsCount;		
		try {			
			iActualItemsCount = oAdminPage.retrievePageItemsCount("","GroupTask");			
						
			String sGroupTasksLCDItemsCount= "Select count(*) from ( select distinct LCD_ID  from  LCD.LCD_CPT_ICD_DONTSPRT_DELTA union select distinct LCD_ID  from  LCD.LCD_CPT_ICD_SPRT_DELTA ) minus  (  select  LCD_ID  from  LCD.LCD_REVIEW_TASK)";
						
			String sGroupTasksArticleItemsCount = "Select count(*) from ( select distinct Art_id  from  LCD.ART_CPT_ICD_DONTSPRT_DELTA union select distinct Art_id  from  LCD.ART_CPT_ICD_SPRT_DELTA ) minus (   select  Art_id  from  LCD.ART_REVIEW_TASK)";
			
			iLCDItemsCount = Integer.parseInt(DBUtils.executeSQLQuery(sGroupTasksLCDItemsCount));
			iArticleItemsCount = Integer.parseInt(DBUtils.executeSQLQuery(sGroupTasksArticleItemsCount));
			
			iExpectedItemsCount = iArticleItemsCount + iLCDItemsCount;
			
			if ((iActualItemsCount >=1) &&  ((iActualItemsCount >= iExpectedItemsCount   || iActualItemsCount <= iExpectedItemsCount  )))
			{
				Assert.assertTrue("Records displayed in GroupTasks Tab",true);
			}
			else
			{
				Assert.assertTrue("Records Not displayed in GroupTasks Tab",false);
			}
			getDriver().close();
		    } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step
	public void ra_Should_Not_Able_to_View_Review_Tasks() {
		boolean bStatus = false;
		bStatus = oSeleniumUtils.is_WebElement_Displayed(oHomePage.sWindowProptOKButton);
		oSeleniumUtils.Click_given_Locator(oHomePage.sWindowProptOKButton);
		Assert.assertTrue("User "+Serenity.sessionVariableCalled("UserName").toString()+" don't have access to CPT-ICD Link Page ",bStatus);
	}

	@Step
	public void ra_Should_Not_be_Able_to_view_Other_RA_Claimed_Tasks() {
		int iActualItemsCount = 0;
		
		//Enter the Claimed code
		oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,Serenity.sessionVariableCalled("LCD_ID"));
				
		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		try {
			iActualItemsCount = oAdminPage.retrievePageItemsCount("","GroupTask");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Items count is :- "+iActualItemsCount);
		Assert.assertTrue("RA Should not be able to view other RA Claimed Tasks ",String.valueOf(iActualItemsCount).equalsIgnoreCase("0"));
		
		//DB Validation
		String sIndividualReviewTaskQuerry = "select count(*) from LCD.LCD_REVIEW_TASK where user_id='"+Serenity.sessionVariableCalled("UserName")+"' and lcd_id="+Serenity.sessionVariableCalled("LCD_ID");
		Assert.assertTrue("Other RA User should not be able to view Individual Task Queue for Tasks Claimed by Different RA User ",DBUtils.executeSQLQuery(sIndividualReviewTaskQuerry).equalsIgnoreCase("0"));
		
	}

	@Step
	public void selectCodeCombinationinTab(String arg1) {
		oRAReviewWorkQueuePage.selectCodeCombinations(arg1);		
	}

	public void selectReviewDecision(String arg1) {
		
		 String sDecision="";
		 sDecision=  arg1;
			
		 //Click on ReviewDecision Drop down 
		 oRAReviewWorkQueuePage.ReviewDecisionDropDown.click();	 
			
		switch (sDecision) 	{		
			case "Accept":
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAReviewWorkQueuePage.ReviewDecisionDrpdownValues,"ReviewDecisionVal","Accept"));
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				break;
			case "Reject":
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAReviewWorkQueuePage.ReviewDecisionDrpdownValues,"ReviewDecisionVal","Reject"));
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				break;
			case "Blank":
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAReviewWorkQueuePage.ReviewDecisionDrpdownValues,"ReviewDecisionVal","Blank"));			
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				break;	
				
			default:  logger.info("No input is provided for the Switch Case");
			          System.out.println("No input is provided for the Switch Case");
				
					
		}	
			
	}

	@Step
	public void claimed_LCD_Code_Should_be_in_Queue_For_RA() {
		int iActualItemsCount = 0;
		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		
		//Verifying the Individual Task counts for RA
	//	String sIndividualTasksItemsQuery = "select count(*) from(select * from LCD.LCD_REVIEW_TASK where user_id='"+Serenity.sessionVariableCalled("UserName")+"'"+
	//										 "union select* from LCD.ART_REVIEW_TASK where user_id='"+Serenity.sessionVariableCalled("UserName")+"')";
		
		
		try {
			iActualItemsCount = oAdminPage.retrievePageItemsCount("","IndividualTask");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Items count is :- "+iActualItemsCount);
		//Assert.assertTrue("RA Claimed tasks in Individual Tasks screen",String.valueOf(iActualItemsCount).equalsIgnoreCase(DBUtils.executeSQLQuery(sIndividualTasksItemsQuery)));
		
		
		String sIndividualReviewTaskQuerry = "select count(*) from LCD.LCD_REVIEW_TASK where user_id='"+Serenity.sessionVariableCalled("UserName")+"' and lcd_id="+Serenity.sessionVariableCalled("LCD_ID");
		System.out.println(sIndividualReviewTaskQuerry);
		Assert.assertTrue("Individual Task Queue for Claimed Tasks ",DBUtils.executeSQLQuery(sIndividualReviewTaskQuerry).equalsIgnoreCase("1"));
		
		getDriver().close();
	}

	@Step
	public void multiple_Weeks_Task_exist_for_Not_Started_In_GroupTasks(String sLCD_Article) {
		 
		String sID="";
		if(sLCD_Article.equalsIgnoreCase("LCD"))
		 {			
			 sID= DBUtils.executeSQLQuery(DBQueries.MultipleWeek_LCDID_Query);			     
		     Serenity.setSessionVariable("MultipleWeeksTaskID").to(sID);
		  }
		else{			
			  sID = DBUtils.executeSQLQuery(DBQueries.MultipleWeek_Article_Query);	
			  Serenity.setSessionVariable("MultipleWeeksTaskID").to(sID);
		    }
			
	}

	@Step
	public void user_Claim_Subsequent_Week_Task_From_Group_Tasks(String arg1) {
		
		System.out.println(Serenity.sessionVariableCalled("MultipleWeeksTaskID").toString());
		
		if(!Serenity.sessionVariableCalled("MultipleWeeksTaskID").equals("")){
			
			oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,Serenity.sessionVariableCalled("MultipleWeeksTaskID").toString());
			
			SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
			
			oSeleniumUtils.Click_given_WebElement(oHomePage.ID_Checkbox);
			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			
			oSeleniumUtils.Click_given_WebElement(oHomePage.ClaimTask_Btn);
			
		}else{
			Assert.assertTrue("There is no LCD/Article ids whose status as not started.",false);
		}
	}

	@Step
	public void alert_Popup_Should_be_Displayed_with_Message(String arg1) {
		
		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		Assert.assertTrue("Alert popup is not displayed ",oSeleniumUtils.is_WebElement_Displayed(oHomePage.Alert_PopUp));
		
		String sActualValue = oSeleniumUtils.get_TextFrom_Locator(oHomePage.sAlertPopupMsg);
		
		String sExpectedValue = "";
		switch(arg1){
			case "Claimed":
				sExpectedValue = ProjectVariables.sClaimedError_Msg;
				break;
			case "Reassigned":
				sExpectedValue = ProjectVariables.sReassignedError_Msg;
				break;
			default:
				Assert.assertTrue("Provided invalid case value",false);				
		}
		
		Assert.assertTrue("Alert popup message is not displayed as expected",sActualValue.equalsIgnoreCase(sExpectedValue));
		oSeleniumUtils.Click_given_Locator(oHomePage.sAlertPopupOKBtn);
		getDriver().close();
		oSeleniumUtils.switchWindowUsingWindowCount(100,1);
	}

	@Step
	public void user_Reassign_Subsequent_Week_Task() {
		oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,Serenity.sessionVariableCalled("MultipleWeeksTaskID"));
		
		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		
		oSeleniumUtils.Click_given_WebElement(oHomePage.ID_Checkbox);
		
		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		
		//click on Reassign button
		oSeleniumUtils.Click_given_WebElement(oAdminPage.ReassignBtn);
		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		
		//select RA
		oSeleniumUtils.Click_given_Locator(oAdminPage.SelectRA_Cmb);
		SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
		oSeleniumUtils.Click_given_Locator(oAdminPage.sRAUser);
		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		oSeleniumUtils.Click_given_Locator(oHomePage.sAlertPopupOKYes);
		
	}
	
	@Step
	public void first_Week_Task_Status_is(String arg1) {
		switch(arg1){
		case "Started":
			
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue","My Tasks"));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			Assert.assertTrue("CPTICDLink Home page should be dispalyed.",oHomePage.NavigateToCPTICDLink());
			
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Group"));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	    	
	    	oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,Serenity.sessionVariableCalled("MultipleWeeksTaskID"));			
	    	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
			oSeleniumUtils.Click_given_Locator(oAdminPage.sCheckbox_Two);
			
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			
			oSeleniumUtils.Click_given_WebElement(oHomePage.ClaimTask_Btn);
			
			break;
		case "Completed":
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue","My Tasks"));
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
			Assert.assertTrue("CPTICDLink Home page should be dispalyed.",oHomePage.NavigateToCPTICDLink());			
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	    	
	    	oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,Serenity.sessionVariableCalled("MultipleWeeksTaskID"));			
	    	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
			oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue",Serenity.sessionVariableCalled("MultipleWeeksTaskID").toString()));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);		
	    	Assert.assertTrue("Ra Review WorkQueue page should be displayed.",oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.RA_Review_WorkQueue));
			
	    	//support
	    	oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Support"));
	    	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	    	
	    	//click on Start Review
	    	oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.StartReview_Btn);	    	
	    	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	    	
	    	oSeleniumUtils.Click_given_Locator(oRAReviewWorkQueuePage.sGridCheckBox);	    	
	    	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	    	
	    	oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.Accept_Btn);
	    	
	    	//Does not support
	    	oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Does"));	    	
	    	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);;
	    	
	    	oSeleniumUtils.Click_given_Locator(oRAReviewWorkQueuePage.sGridCheckBox);
	    	
	    	oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.Reject_Btn);	    	
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
	    	
	    	//complete
	    	oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.CompleteRAReview_Btn);
	    	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	    	oSeleniumUtils.Click_given_Locator(oHomePage.sAlertPopupOKBtn);
	    	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	    	
	    	//Group task
	    	oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Group"));
	    	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			break;
		default:
			Assert.assertTrue("Provided invalid Switch value",false);				
	}
		
	}

	@Step
	public void task_should_be_successfully(String sTaskStatus)
	{		
		
		if (sTaskStatus.equalsIgnoreCase("Reassigned"))
		{
		   int iValue = oSeleniumUtils.getMatchingXpathCount(oHomePage.sAlertPopupMsg);
		    if(iValue == 0){
					Assert.assertTrue("Task should be successfully completed.",true);
				}else{
					Assert.assertTrue("Task should not be completed.",true);
				}
		 }		
		else
		{
			getDriver().close();
			oSeleniumUtils.switchWindowUsingWindowCount(100,1);
		}
		
	}

	@Step
	public void validateGivenButtonStatus(String sButtonName, String sStatus) {
		boolean bStatus = false;
			switch(sButtonName){
				case "Start Review":
					if(sStatus.equalsIgnoreCase("Disabled")){
						bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.sStartReviewBtnDisabled);
					}else if(sStatus.equalsIgnoreCase("Enabled")){
						bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.StartReview_Btn);
					}					
					if(bStatus){
						logger.info("Start Review Button is displayed as "+sStatus);
						Assert.assertTrue("Start Review Button is displayed as "+ sStatus,bStatus);
					}else{
						logger.info("Start Review Button is not displayed as "+sStatus);
						Assert.assertTrue("Start Review Button is not displayed as "+sStatus,bStatus);
					}
					break;
				case "Accept":
					if(sStatus.equalsIgnoreCase("Disabled")){
						bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.sAcceptBtnDisabled);
					}else if(sStatus.equalsIgnoreCase("Enabled")){
						bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.Accept_Btn);
					}					
					if(bStatus){
						logger.info("Accept Button is displayed as "+sStatus);
						Assert.assertTrue("Accept Button is displayed as "+ sStatus,bStatus);
					}else{
						logger.info("Start Review Button is not displayed as "+sStatus);
						Assert.assertTrue("Start Review Button is not displayed as "+sStatus,bStatus);
					}
					break;
				case "Reject":
					if(sStatus.equalsIgnoreCase("Disabled")){
						bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.sRejectBtnDisabled);
					}else if(sStatus.equalsIgnoreCase("Enabled")){
						bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.Reject_Btn);
					}					
					if(bStatus){
						logger.info("Reject Button is displayed as "+sStatus);
						Assert.assertTrue("Reject Button is displayed as "+ sStatus,bStatus);
					}else{
						logger.info("Reject Button is not displayed as "+sStatus);
						Assert.assertTrue("Reject Button is not displayed as "+sStatus,bStatus);
					}
					break;
				case "Complete RA Review":
					if(sStatus.equalsIgnoreCase("Disabled")){
						bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.sCompleteRAReviewBtnDisabled);
					}else if(sStatus.equalsIgnoreCase("Enabled")){
						bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.CompleteRAReview_Btn);
					}					
					if(bStatus){
						logger.info("Complete RA Review Button is displayed as "+sStatus);
						Assert.assertTrue("Reject Button is displayed as "+ sStatus,bStatus);
					}else{
						logger.info("Complete RA Review Button is not displayed as "+sStatus);
						Assert.assertTrue("Reject Button is not displayed as "+sStatus,bStatus);
					}
					break;
				case "View Paragraph Info":
					bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.sViewParagraphInfoBtn);
					if(bStatus){
						logger.info("View Paragraph Info Button is displayed as "+sStatus);
						Assert.assertTrue("View Paragraph Info Button is displayed as "+ sStatus,bStatus);
					}else{
						logger.info("View Paragraph Info Button is not displayed as "+sStatus);
						Assert.assertTrue("View Paragraph Info Button is not displayed as "+sStatus,bStatus);
					}
					break;
				default:
					Assert.assertTrue("Provided in valid button in the switch case '"+sButtonName+"'",false);
				}		
	}

	@Step
	public void captureStatusFromDatabase(String sLCD_Article) {
	
		String sReviewStatusSQLQuery = "";
		String sReviewStatusDBVal = "";
		
		if(sLCD_Article.equalsIgnoreCase("LCD"))
		{	
		    sReviewStatusSQLQuery = "SELECT TSL.DESCRIPTION FROM LCD.LCD_REVIEW_TASK LRT, LCD.TASK_STATUS_LKP TSL WHERE LRT.TASK_STATUS_KEY = TSL.TASK_STATUS_KEY AND LCD_ID ="+ Serenity.sessionVariableCalled("ID").toString();
		}
		else if(sLCD_Article.equalsIgnoreCase("Article"))
		{			
			sReviewStatusSQLQuery = "SELECT TSL.DESCRIPTION FROM LCD.ART_REVIEW_TASK LRT, LCD.TASK_STATUS_LKP TSL WHERE LRT.TASK_STATUS_KEY = TSL.TASK_STATUS_KEY AND ART_ID ="+ Serenity.sessionVariableCalled("ID").toString();			
		}
		
		try {
			System.out.println(Serenity.sessionVariableCalled("ID").toString());		
			sReviewStatusDBVal = DBUtils.executeSQLQuery(sReviewStatusSQLQuery);
			System.out.println("DB QueryReusult-->  :" + sReviewStatusDBVal);
			System.out.println("DB Query executed successfully");
			Serenity.setSessionVariable("sReviewStatusDBVal").to(sReviewStatusDBVal);			
		} catch (Exception e) {
			System.out.println("DB Query is not executed");
		}
	}

	@Step
	public void ValidateReviewStatusWithDBAndUI() {
		boolean bStatus = false;
		String sReviewDBStatus = Serenity.sessionVariableCalled("sReviewStatusDBVal");
		String sReviewUIStatus = oSeleniumUtils.get_Text_From_WebElement(oRAReviewWorkQueuePage.ReviewStatus_Txt);
		logger.info("Review Status of DB Value is "+sReviewDBStatus);
		logger.info("Review Status of UI Value is "+sReviewUIStatus);
		
		bStatus = sReviewDBStatus.equalsIgnoreCase(sReviewUIStatus);
		if(bStatus){
			logger.info("UI Review Status and DB Review Status of id ("+Serenity.sessionVariableCalled("ID").toString()+") is same.");
			Assert.assertTrue("UI Review Status and DB Review Status of LCD_OR_Article id is same.",bStatus);
		}else{
			logger.info("UI Review Status and DB Review Status of id ("+Serenity.sessionVariableCalled("ID").toString()+") is not same.");
			Assert.assertTrue("UI Review Status and DB Review Status of LCD_OR_Article id is not same.",bStatus);
		}
		
	}

	@Step
	public void clickOnViewParagraphInfoButton() {
			oSeleniumUtils.Click_given_Locator(oRAReviewWorkQueuePage.sViewParagraphInfoBtn);
	}

	@Step
	public void validateParagraphInformationSection() {
		boolean bStatus = false;
		
		bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.sViewParagraphInfoSection);
		if(bStatus){
			logger.info("Paragraph Information Section is displayed");
			Assert.assertTrue("Paragraph Information Section is displayed",bStatus);
		}else{
			logger.info("Paragraph Information Section is not displayed");
			Assert.assertTrue("Paragraph Information Section is not displayed",bStatus);
		}
			
	}

	@Step
	public void validateParagraphInfoCloseIcon() {
		boolean bStatus = false;
		
		bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAReviewWorkQueuePage.sViewParagraphInfoCloseIcon);
		if(bStatus){
			logger.info("Paragraph Information Close Icon is displayed");
			Assert.assertTrue("Paragraph Information Close Icon is displayed",bStatus);
		}else{
			logger.info("Paragraph Information Close Icon is not displayed");
			Assert.assertTrue("Paragraph Information Close Icon is not displayed",bStatus);
		}
	}

	@Step
	public void closeParagraphInfo() {
		boolean bStatus = false;
		
		oSeleniumUtils.Click_given_Locator(oRAReviewWorkQueuePage.sViewParagraphInfoCloseIcon);		
		bStatus=getDriver().findElement(By.xpath(oRAReviewWorkQueuePage.sViewParagraphInfoCloseIcon)).isDisplayed();	
		
		if(!bStatus){
			logger.info("Paragraph Info section is hidden");
			Assert.assertTrue("Paragraph Info section is hidden",!bStatus);
		}else{
			logger.info("Paragraph Info section is not hidden");
			Assert.assertTrue("Paragraph Info section is not hidden",bStatus);
		}		
	}
		
	@Step
	public void clickRAReviewWorkQueue() {
		oSeleniumUtils.Click_given_WebElement(oRAReviewWorkQueuePage.RA_Review_WorkQueue);
	}

	@Step
	public void validateDecisionChangeAlertMessage() {
		 boolean bStatus;
		 String sExpectedMessage="";
		 
		 sExpectedMessage = "Note - Selected records already have decisions on them. Ensure that correct records have been selected to change the decisions. There is a risk of losing decisions on incorrectly chosen records. Are you sure you want to proceed with this changing the decisions?";
		
		bStatus = oSeleniumUtils.is_WebElement_Displayed(oRAPage.RAPage_sAlertPopup);
		
		if(bStatus)
		{
			logger.info("Alert Popup is displayed.");
			String sActualAlertMsg = oSeleniumUtils.get_TextFrom_Locator(oHomePage.sAlertPopupMsg);
			System.out.println("Actual AlertMsg:: "+sActualAlertMsg);
			
		       if(sActualAlertMsg.equalsIgnoreCase(sExpectedMessage))
		       {
		    		logger.info("Actual Alert Msg:: '"+sActualAlertMsg+"' is equal with Expected Alert Msg::  '"+sExpectedMessage+"'");
					Assert.assertTrue("Actual and expected alert messages are equal.",true);				
				}
		       else
		       {   
		    	   logger.info("Actual Alert Msg '"+sActualAlertMsg+"' is not equal with Expected Alert Msg::  '"+sExpectedMessage+"'");
				   Assert.assertTrue("Actual "+sActualAlertMsg+" and expected "+sExpectedMessage+" alert messages are not equal.",false);
				   
				}			
			
		}//end of if comparing bstatus
		
	}

	@Step 
	public void raClicksAlertPopupButton(String sButton) {
		
		boolean bStatus=false;	
		
		String sButtonName="";
		
		   if(sButton.equalsIgnoreCase("yes"))
		   {
			   sButtonName= oHomePage.sAlertPopupOKYes;
		   }
		   else{			  
			   sButtonName= oHomePage.sAlertPopupOKNo;			   
		       }		
		
		bStatus = oSeleniumUtils.is_WebElement_Displayed(sButtonName);
		
		if(bStatus)
		{
			logger.info(sButtonName+" Button is displayed in the Alert Popup.");
			oSeleniumUtils.Click_given_Locator(sButtonName);
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
		}else{
			logger.info(sButtonName+" Button is not displayed in the Alert Popup.");
			Assert.assertTrue(sButtonName+" button is not displayed in the Alert Popup.",false);
		}
		
	}

	@Step 
	public void SelectAllCodeCombinations(String sTabName)
	{
		if (sTabName.equalsIgnoreCase("SupportTab") || sTabName.equalsIgnoreCase("DoesNotSupportTab") )
		{
			
			Serenity.setSessionVariable("TabName").to(sTabName);
			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			oSeleniumUtils.is_WebElement_Displayed(oRAPage.ROWHEADER_CHECKBOX);			
			oSeleniumUtils.Click_given_Locator(oRAPage.ROWHEADER_CHECKBOX);		   
	   } 

	}

	@Step 
	public void validateExcludedCodesReviewdecision(String sRejectRemarks, String sCPT_HCPCCode, String sNewICDCode,String sTabName) 
	{

		//Click on the provided tab name	 	
    	if(sTabName.equalsIgnoreCase("Support")||(sTabName.equalsIgnoreCase("Does")))
    	{
    		Serenity.setSessionVariable("TabName").to(sTabName);
    		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue",sTabName));
    		 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);      
    		 }
		    	
    	   //Store all CPT/HCPC codes in a array
    	  String[] sCodeVals  =  sCPT_HCPCCode.split(",");
    	  
    	  
    	  //Loop through all HCPC codes
    	   for (int k=0;k<sCodeVals.length;k++)
    	   {    
    		    //Enter CPT /HCPC code and NewICd code			    	
			    	oSeleniumUtils.enter_given_text_StringLocator(oRAPage.CptCodeTextBox,sCodeVals[k]);
			    	
			    	if(!(sNewICDCode.isEmpty()))
			    	{			    		
			    	   oSeleniumUtils.enter_given_text_StringLocator(oRAPage.ICDCodeTextBoxNew,sNewICDCode);
			    	}  
			    			
					//click on the ApplyFilters button
			    	oSeleniumUtils.Click_given_WebElement(oRAPage.ApplyFilter_Btn);
			    	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
					
					//Capture Review decisions & Remarks    	
			    	String sUIReviewDecision =   oSeleniumUtils.get_Text_From_WebElement(oRAPage.ReviewDecision);
			    	String sUIRemarks =  oSeleniumUtils.get_TextFrom_Locator(oRAPage.RAPage_Remarks);
					
					//Validating Reject decision is populated			    	
			    	 if(sUIReviewDecision.equalsIgnoreCase("Reject"))
			    	 {
			    		 logger.info("Review Decision  updated as Reject  updated for CPT/HCPC code ::"+sCodeVals[k]);
						 Assert.assertTrue("Review Decision  updated as Reject for CPT/HCPC code ::"+sCodeVals[k],true);	
			    	 }			    	 
			    	 else
			    	 {
			    		 logger.error("Review Decision not updated as Reject  updated for CPT/HCPC code ::"+sCodeVals[k]);
						 Assert.assertTrue("Review Decision not updated as Reject for CPT/HCPC code ::"+sCodeVals[k],false); 		    		 
			    	 }
			    	 
			    	
			    	//Validating Reject Reason is populated			 
			    	 if(sUIRemarks.equalsIgnoreCase(sRejectRemarks))
			    	 {
			    		 logger.info(" Reject Remarks updated as expected for CPT/HCPC code ::"+sCodeVals[k]);
						 Assert.assertTrue(" Reject Remarks updated as expected for CPT/HCPC code "+sCodeVals[k],true);	
			    	 }			    	 
			    	 else
			    	 {
			    		 logger.error(" Reject Remarks not  updated as expected for CPT/HCPC code ::"+sCodeVals[k]);
						 Assert.assertTrue(" Reject Remarks not updated as expected for CPT/HCPC code "+sCodeVals[k]+"UI value:: "+sUIRemarks,false);
			    	 }
			    	 
			    	 
			    		if (oRAReviewWorkQueuePage.ClearAllFilters_Btn.isCurrentlyEnabled())
						{						
							oRAReviewWorkQueuePage.ClearAllFilters_Btn.click();								
							oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
						}
						else
						{
							 logger.error("ClearAllFilters button is in disabled state,so cannot perform click");
							Assert.assertTrue("ClearAllFilters button is in disabled state,so cannot perform click",false);								
						}	
			    	 
    	   }
		
	}

	@Step
	public void validateValidCodesReviewDecision(String sValidCPTCode, String sNewICDCode, String sTabName) 
	{
	  
		//Enter CPT /HCPC code and NewICd code			    	
    	oSeleniumUtils.enter_given_text_StringLocator(oRAPage.CptCodeTextBox,sValidCPTCode);
    	oSeleniumUtils.enter_given_text_StringLocator(oRAPage.ICDCodeTextBoxNew,sNewICDCode);
    			
		//click on the ApplyFilters button
    	oSeleniumUtils.Click_given_WebElement(oRAPage.ApplyFilter_Btn);
    	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
		
		//Capture Review decisions & Remarks    	
    	String sUIReviewDecision =   oSeleniumUtils.get_Text_From_WebElement(oRAPage.ReviewDecision);
    	String sUIRemarks =  oSeleniumUtils.get_TextFrom_Locator(oRAPage.RAPage_Remarks);
		
		//Validating Reject decision is not populated			    	
    	 if(sUIReviewDecision.isEmpty())
    	 {
    		 logger.info("Review Decision  not  updated as Reject for valid CPT/HCPC code ::"+sValidCPTCode);
			 Assert.assertTrue("Review Decision  not  updated as Reject for valid CPT/HCPC code ::"+sValidCPTCode,true);	
    	 }			    	 
    	 else
    	 {
    		 logger.error("Review Decision  updated as Reject   for valid CPT/HCPC code ::"+sValidCPTCode);
			 Assert.assertTrue("Review Decision  updated as Reject for valid CPT/HCPC code ::"+sValidCPTCode,false); 		    		 
    	 }
    	 
    	
    	//Validating Reject Reason is not populated			 
    	 if(sUIRemarks.isEmpty())
    	 {
    		 logger.info(" Reject Remarks are blank as expected for CPT/HCPC code ::"+sValidCPTCode);
			 Assert.assertTrue(" Reject Remarks are blank as expected for CPT/HCPC code "+sValidCPTCode,true);	
    	 }			    	 
    	 else
    	 {
    		 logger.error(" Reject Remarks not  blank as expected for CPT/HCPC code ::"+sValidCPTCode);
			 Assert.assertTrue(" Reject Remarks not blank as expected for CPT/HCPC code "+sValidCPTCode+"UI value:: "+sUIRemarks,false);
    	 }
    	 
    	 
    		if (oRAReviewWorkQueuePage.ClearAllFilters_Btn.isCurrentlyEnabled())
			{						
				oRAReviewWorkQueuePage.ClearAllFilters_Btn.click();								
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			}
			else
			{
				 logger.error("ClearAllFilters button is in disabled state,so cannot perform click");
				Assert.assertTrue("ClearAllFilters button is in disabled state,so cannot perform click",false);								
			}	 	 
		
		
	}
}

	
	
	
		
	
	
	
	
	



