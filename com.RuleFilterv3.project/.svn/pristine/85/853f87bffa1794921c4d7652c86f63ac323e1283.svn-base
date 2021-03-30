package project.feature.steps.definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.google.common.base.CharMatcher;

import jline.internal.Log;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.features.steps.ManuallyCreatingNewCombinationsBasedOnAssociatedICDCodesSteps;
import project.pageobjects.AdminPage;
import project.pageobjects.HomePage;
import project.pageobjects.LoginPage;
import project.pageobjects.RAReviewWorkQueuePage;
import project.pageobjects.TargetTableRecordsReviewPage;
import project.utilities.DBQueries;
import project.utilities.DBUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;
import project.utilities.GenericUtils;

import java.awt.Robot;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AbilitytoCreateRecordforAndReviseDatebandingLogicPerJurisdictionStepDef  extends ScenarioSteps 
{
	
	private static final long serialVersionUID = 5898280540796957114L;

	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AbilitytoCreateRecordforAndReviseDatebandingLogicPerJurisdictionStepDef.class);

	LoginPage ologinPage;
	HomePage oHomePage;
	SeleniumUtils oSeleniumUtils;
	DBQueries oDBQueries;
	RAReviewWorkQueuePage  oRAPage;
	AdminPage oAdminPage;
	TargetTableRecordsReviewPage  oTargetScreenPage;
	GenericUtils oGeneric;
	ManuallyCreatingNewCombinationsBaseOnAssociatedICDCodesStepDef  oManualCodeComb = new ManuallyCreatingNewCombinationsBaseOnAssociatedICDCodesStepDef()  ;
	
	
	@Step
	public void validateDecisionForJurisidictions(String sDecision) throws Exception 
	{
		
		List<String> Jurisidictions = new ArrayList<String>();

		int iTotalDecisionsCount = 0;
		int iAppropriateVal = -2;

		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		
		if (oRAPage.ReviewDecisionDropDown.isCurrentlyEnabled()) {
			// Click on ReviewDecision Drop down
			oRAPage.ReviewDecisionDropDown.click();
		} else {
			logger.error("ReviewDecision Drop down is no enabled");
			Assert.assertTrue("ReviewDecision Drop down is not enabled ", false);
		}

		// Filter By decision
		switch (sDecision) {
		case "Accept":
			iAppropriateVal = -1;
			oSeleniumUtils.Click_given_Locator(
					StringUtils.replace(oRAPage.ReviewDecisionDrpdownValues, "ReviewDecisionVal", "Accept"));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			break;
		case "Reject":
			iAppropriateVal = 0;
			oSeleniumUtils.Click_given_Locator(
					StringUtils.replace(oRAPage.ReviewDecisionDrpdownValues, "ReviewDecisionVal", "Reject"));
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			break;
		}

		// Apply Filter
		oRAPage.ApplyFilter_Btn.click();
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

		// Capture the UI count
		int iDecisionsCountUI = oRAPage.retrievePageItemsCount("", "SupportTab");

		// Capture Jurisdictions count
		String sQuery = "Select count(*) from (select distinct  mcare_juris from LCD.LCD_CPT_ICD_SPRT_DELTA where lcd_id="
				+ Serenity.sessionVariableCalled("LCD_ID") + " and mcare_juris is not null)";
		int iJusrisidictionCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));
		logger.info("No of Jursidictions for the ID is/are::" + iJusrisidictionCount);

		iTotalDecisionsCount = iJusrisidictionCount * iDecisionsCountUI;

		// Capture the decisions count from DB
		sQuery = "Select count(*) from (SELECT DECODE(APPROPRIATE_10, -1, 'Accept', 0, 'Reject') AS REVIEW_DECISION  FROM LCD.LCD_CPT_ICD_SPRT_DELTA  WHERE LCD_ID ="
				+ Serenity.sessionVariableCalled("LCD_ID") + " AND APPROPRIATE_10 = " + iAppropriateVal + ")";
		int iDecisionsCountDB = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));

		// Compare the decisions count
		if (iTotalDecisionsCount == iDecisionsCountDB) {
			Assert.assertTrue("Total decisions taken count matched as per the jurisidictions", true);
		} else {
			logger.error("Total decisions taken count :: " + iTotalDecisionsCount
					+ " not  matched as per the jurisidictions count:: " + iDecisionsCountDB);
			Assert.assertTrue("Total decisions taken count matched as per the jurisidictions", false);
		}

		// Capture Jurisdictions names
		sQuery = "select distinct  mcare_juris from LCD.LCD_CPT_ICD_SPRT_DELTA where lcd_id="
				+ Serenity.sessionVariableCalled("LCD_ID") + " and mcare_juris is not null";
		Jurisidictions = DBUtils.executeSQLQueryMultipleRows(sQuery);

		// Retrieve decision for each Jurisidiction
		for (int j = 0; j < Jurisidictions.size(); j++) {
			sQuery = "SELECT DECODE(APPROPRIATE_10, -1, 'Accept', 0, 'Reject') AS REVIEW_DECISION  FROM LCD.LCD_CPT_ICD_SPRT_DELTA  WHERE LCD_ID ="
					+ Serenity.sessionVariableCalled("LCD_ID") + " AND APPROPRIATE_10 =  " + iAppropriateVal
					+ " and MCARE_JURIS='" + Jurisidictions.get(j) + "'";
			String sDecisionDB = DBUtils.executeSQLQuery(sQuery);

			if (sDecisionDB.equalsIgnoreCase(sDecision)) {
				logger.info("Decision: " + sDecision + "  copied to Jurisidiction: " + Jurisidictions.get(j));
				Assert.assertTrue("Decision" + sDecision + "  copied to Jurisidiction: " + Jurisidictions.get(j), true);
			} else {
				logger.error("Decision: " + sDecision + "  not copied to Jurisidiction: " + Jurisidictions.get(j));
				Assert.assertTrue("Decision: " + sDecision + "  not copied to Jurisidiction: " + Jurisidictions.get(j),
						false);
			}
		} // end of for

		// Check if comments are copied or not to all jurisdictions
		if (sDecision.equalsIgnoreCase("Reject")) {
			String sSelectedRemark = Serenity.sessionVariableCalled("RejectReason");

			// Retrieve decision for each Jurisidiction
			for (int j = 0; j < Jurisidictions.size(); j++) {
				sQuery = "SELECT REMARKS  FROM LCD.LCD_CPT_ICD_SPRT_DELTA  WHERE LCD_ID ="
						+ Serenity.sessionVariableCalled("LCD_ID") + " AND APPROPRIATE_10 =  " + iAppropriateVal
						+ " and MCARE_JURIS='" + Jurisidictions.get(j) + "'";
				String sRemarksDB = DBUtils.executeSQLQuery(sQuery);

				if (sRemarksDB.equalsIgnoreCase(sSelectedRemark)) {
					logger.info("Remarks: " + sSelectedRemark + "  copied to Jurisidiction: " + Jurisidictions.get(j));
					Assert.assertTrue(
							"Remarks: " + sSelectedRemark + "  copied to Jurisidiction: " + Jurisidictions.get(j),
							true);
				} else {
					logger.error(
							"Remarks: " + sSelectedRemark + "  not copied to Jurisidiction: " + Jurisidictions.get(j));
					Assert.assertTrue(
							"Remarks: " + sSelectedRemark + "  not copied to Jurisidiction: " + Jurisidictions.get(j),
							false);
				}
			} // end of for
		} // end of if

		// Clear Filters
		oRAPage.ClearAllFilters_Btn.click();
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

	}//end of method	

	@Step
	public void selectRejectReason(String sReason)
	{
		
		 SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);	
		
	 //Check whether "Select Reason" drop down  is displayed        
      oSeleniumUtils.is_WebElement_Displayed(oRAPage.SelectReasonCmb);

	 //Click on Drop down arrow icon
	 oSeleniumUtils.Click_given_WebElement(oRAPage.SelectReasonArrowIcon);
	 SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
	    
	 //Select reason from Drop down
     oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText, "sValue", "Non-configurable-Frequency"));

      //Click on Apply button
      oSeleniumUtils.Click_given_Locator(oRAPage.Apply);
     oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);  
     
     Serenity.setSessionVariable("RejectReason").to("Non-configurable-Frequency");	
		
	}

	@Step
	public void captureDecisionsFromDeltat(String sLCD_Article)
	{
		  String sAcceptQuery ="";
		  String sRejectQuery="";
		  String sJursQuery="";
		
		   if (sLCD_Article.equalsIgnoreCase("LCD"))
		   {			   
			    sAcceptQuery =  "Select count(*) from LCD.LCD_CPT_ICD_SPRT_DELTA  where lcd_id="+Serenity.sessionVariableCalled("ID")+" and appropriate_10=-1 ";	
			    sRejectQuery =  "Select count(*) from LCD.LCD_CPT_ICD_SPRT_DELTA  where lcd_id="+Serenity.sessionVariableCalled("ID")+" and appropriate_10=0";
			    sJursQuery = "Select count(*) from (select distinct  mcare_juris from LCD.LCD_CPT_ICD_SPRT_DELTA where lcd_id="+Serenity.sessionVariableCalled("ID")+" and mcare_juris is not null)";
		   }
		   else if  (sLCD_Article.equalsIgnoreCase("Article"))
		   {
			   sAcceptQuery =  "Select count(*) from LCD.ART_CPT_ICD_SPRT_DELTA  where art_id="+Serenity.sessionVariableCalled("ID")+" and appropriate_10=-1";	
			   sRejectQuery =  "Select count(*) from LCD.ART_CPT_ICD_SPRT_DELTA  where art_id="+Serenity.sessionVariableCalled("ID")+" and appropriate_10=0";
			   sJursQuery = "Select count(*) from (select distinct  mcare_juris from LCD.ART_CPT_ICD_SPRT_DELTA where art_id="+Serenity.sessionVariableCalled("ID")+" and mcare_juris is not null)";
		   }	   
		   
		   int sAcceptDecisionsCntDB =   Integer.parseInt(DBUtils.executeSQLQuery(sAcceptQuery)); 				   
		   int sRejectDecisionsCntDB =   Integer.parseInt(DBUtils.executeSQLQuery(sRejectQuery)); 
		   	   
			 //Decisions count in UI RAPage
			 int  iAccptdecsCntUI = Integer.parseInt(Serenity.sessionVariableCalled("AcceptCountUI"));
			 int  iRjctdecsCntUI =  Integer.parseInt(Serenity.sessionVariableCalled("RejectCountUI"));	 
		   
		  //Get jurisdictions count
		   int  iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sJursQuery));	
		   
		   	   
	       //Validating Accept decisions
		   if(sAcceptDecisionsCntDB == (iAccptdecsCntUI*iJusrisidictionCount ))
		   {
			    logger.info("Accept Decisions Count in Delta::"+sAcceptDecisionsCntDB+" Jusrisidictions Count:: "+iJusrisidictionCount+" Accept Decisions Count in UI::" +iAccptdecsCntUI);		
				Assert.assertTrue("Accept decisions copied to target.Accept Decisions Count in Delta::"+sAcceptDecisionsCntDB+" Jusrisidictions Count:: "+iJusrisidictionCount+" Accept Decisions Count in Target::" +iAccptdecsCntUI,true);			
		   }
		   else
		   {
			    logger.error("Accept Decisions Count in Delta::"+sAcceptDecisionsCntDB+" Jusrisidictions Count:: "+iJusrisidictionCount+" Accept Decisions Count in Target::" +iAccptdecsCntUI);		
				Assert.assertTrue("Accept decisions Not  copied to target.Accept Decisions Count in Delta::"+sAcceptDecisionsCntDB+" Jusrisidictions Count:: "+iJusrisidictionCount+" Accept Decisions Count in Target::" +iAccptdecsCntUI,false);				   
		   }			   

	      //Validating Reject decisions
		   if(sRejectDecisionsCntDB == (iRjctdecsCntUI*iJusrisidictionCount ))
		   {
			    logger.info("Reject Decisions Count in Delta::"+sRejectDecisionsCntDB+" Jusrisidictions Count:: "+iJusrisidictionCount+" Reject Decisions Count in UI::" +iRjctdecsCntUI);		
				Assert.assertTrue("Reject decisions copied to target.Reject Decisions Count in Delta::"+sRejectDecisionsCntDB+" Jusrisidictions Count:: "+iJusrisidictionCount+" Reject Decisions Count in Target::" +iRjctdecsCntUI,true);			
		   }
		   else
		   {
			    logger.error("Reject Decisions Count in Delta::"+sRejectDecisionsCntDB+" Jusrisidictions Count:: "+iJusrisidictionCount+" Reject Decisions Count in UI::" +iRjctdecsCntUI);		
				Assert.assertTrue("Reject decisions Not  copied to target.Reject Decisions Count in Delta::"+sRejectDecisionsCntDB+" Jusrisidictions Count:: "+iJusrisidictionCount+" Reject Decisions Count in UI::" +iRjctdecsCntUI,false);				   
		   }		
		   	   
		   	//Store the values in Session variables to compare with TargetTable decisions count	 
		    Serenity.setSessionVariable("AcceptDecisionCount").to(String.valueOf(sAcceptDecisionsCntDB));		   
		    Serenity.setSessionVariable("RejectDecisionsCount").to(String.valueOf(sRejectDecisionsCntDB)); 	
		    
	}

	@Step
	public void decisionsValidationTarget(String sLCD_Article) 
	{
		  String sAcceptQuery  = "";
		  String sRejectQuery = "";
		  String sJursQuery = "";

		if (sLCD_Article.equalsIgnoreCase("LCD")) {
			sAcceptQuery = "Select count(*) from LCD.LCD_CPT_ICD_LINKS  where lcd_id="
					+ Serenity.sessionVariableCalled("ID") + " and appropriate_10=-1 and supports_10 = -1";
			sRejectQuery = "Select count(*) from LCD.LCD_CPT_ICD_LINKS  where lcd_id="
					+ Serenity.sessionVariableCalled("ID") + " and appropriate_10=0 and supports_10 = -1";
			sJursQuery = "Select count(*) from (select distinct  mcare_juris from LCD.LCD_CPT_ICD_LINKS where lcd_id="
					+ Serenity.sessionVariableCalled("ID") + " and mcare_juris is not null)";
		} else if (sLCD_Article.equalsIgnoreCase("Article")) {
			sAcceptQuery = "Select count(*) from LCD.ARTICLE_CPT_ICD_LINKS  where article_id="
					+ Serenity.sessionVariableCalled("ID") + " and appropriate_10=-1  and support_10=-1";
			sRejectQuery = "Select count(*) from LCD.ARTICLE_CPT_ICD_LINKS  where article_id="
					+ Serenity.sessionVariableCalled("ID") + " and appropriate_10=0  and support_10=-1";
			sJursQuery = "Select count(*) from (select distinct  mcare_juris from LCD.ARTICLE_CPT_ICD_LINKS where article_id="
					+ Serenity.sessionVariableCalled("ID") + " and mcare_juris is not null)";
		}

		// Decisions count in Target
		int iAcceptDecisionsCntTarget = Integer.parseInt(DBUtils.executeSQLQuery(sAcceptQuery));
		int iRejectDecisionsCntTarget = Integer.parseInt(DBUtils.executeSQLQuery(sRejectQuery));

		// Target Table
		int iJusrisidictionCount = Integer.parseInt(DBUtils.executeSQLQuery(sJursQuery));

		// Decisions count in Delta
		int iAccptdecsCntDelta = Integer.parseInt(Serenity.sessionVariableCalled("AcceptDecisionCount"));
		int iRjctdecsCntDelta = Integer.parseInt(Serenity.sessionVariableCalled("RejectDecisionsCount"));

		// Validating Accept decisions
		if (iAcceptDecisionsCntTarget == iAccptdecsCntDelta) {
			logger.info("Accept Decisions Count in Delta::" + iAccptdecsCntDelta + " Jusrisidictions Count:: "
					+ iJusrisidictionCount + " Accept Decisions Count in Target::" + iAcceptDecisionsCntTarget);
			Assert.assertTrue("Accept decisions copied to target.Accept Decisions Count in Delta::" + iAccptdecsCntDelta
					+ " Jusrisidictions Count:: " + iJusrisidictionCount + " Accept Decisions Count in Target::"
					+ iAcceptDecisionsCntTarget, true);
		} else {
			logger.error("Accept Decisions Count in Delta::" + iAccptdecsCntDelta + " Jusrisidictions Count:: "
					+ iJusrisidictionCount + " Accept Decisions Count in Target::" + iAcceptDecisionsCntTarget);
			Assert.assertTrue("Accept decisions Not  copied to target.Accept Decisions Count in Delta::"
					+ iAccptdecsCntDelta + " Jusrisidictions Count:: " + iJusrisidictionCount
					+ " Accept Decisions Count in Target::" + iAcceptDecisionsCntTarget, false);
		}

		// Validating Reject decisions
		if (iRejectDecisionsCntTarget == iRjctdecsCntDelta) {
			logger.info("Reject Decisions Count in Delta::" + iRjctdecsCntDelta + " Jusrisidictions Count:: "
					+ iJusrisidictionCount + " Reject Decisions Count in Target::" + iRejectDecisionsCntTarget);
			Assert.assertTrue("Reject decisions copied to target.Reject Decisions Count in Delta::" + iRjctdecsCntDelta
					+ " Jusrisidictions Count:: " + iJusrisidictionCount + " Reject Decisions Count in Target::"
					+ iRejectDecisionsCntTarget, true);
		} else {
			logger.error("Reject Decisions Count in Delta::" + iRjctdecsCntDelta + " Jusrisidictions Count:: "
					+ iJusrisidictionCount + " Reject Decisions Count in Target::" + iRejectDecisionsCntTarget);
			Assert.assertTrue("Reject decisions Not  copied to target.Reject Decisions Count in Delta::"
					+ iRjctdecsCntDelta + " Jusrisidictions Count:: " + iJusrisidictionCount
					+ " Reject Decisions Count in Target::" + iRejectDecisionsCntTarget, false);
		}
		
	}

	@Step
	public void captureDecisionsCount() throws Exception
	{
		
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT); 
		oRAPage.ReviewDecisionDropDown.click();
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAPage.ReviewDecisionDrpdownValues, "ReviewDecisionVal", "Accept"));
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		if (oRAPage.ApplyFilter_Btn.isCurrentlyEnabled()) {
			oRAPage.ApplyFilter_Btn.click();
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

		} else {
			logger.error("ApplyFilters button is in disabled state,so cannot perform click");
			Assert.assertTrue("ApplyFilters button is in disabled state,so cannot perform click", false);
		}

		// Capture the Accept Decisions  count		
		String sAcceptCount = String.valueOf(oRAPage.retrievePageItemsCount("","SupportTab"));	
		Serenity.setSessionVariable("AcceptCountUI").to(sAcceptCount);

		if (oRAPage.ClearAllFilters_Btn.isCurrentlyEnabled()) {
			oRAPage.ClearAllFilters_Btn.click();
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		} else {
			logger.error("ClearAllFilters button is in disabled state,so cannot perform click");
			Assert.assertTrue("ClearAllFilters button is in disabled state,so cannot perform click", false);
		}

		oRAPage.ReviewDecisionDropDown.click();
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAPage.ReviewDecisionDrpdownValues, "ReviewDecisionVal", "Reject"));
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

		if (oRAPage.ApplyFilter_Btn.isCurrentlyEnabled()) {
			oRAPage.ApplyFilter_Btn.click();
			oSeleniumUtils.Click_given_WebElement(oRAPage.ApplyFilter_Btn);
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		} else {
			logger.error("ApplyFilters button is in disabled state,so cannot perform click");
			Assert.assertTrue("ApplyFilters button is in disabled state,so cannot perform click", false);
		}

		// Capture the Reject Decisions  count
		String sRejectCount = String.valueOf(oRAPage.retrievePageItemsCount("","SupportTab"));	
		Serenity.setSessionVariable("RejectCountUI").to(sRejectCount);

		if (oRAPage.ClearAllFilters_Btn.isCurrentlyEnabled()) {
			oRAPage.ClearAllFilters_Btn.click();
			oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		} else {
			logger.error("ClearAllFilters button is in disabled state,so cannot perform click");
			Assert.assertTrue("ClearAllFilters button is in disabled state,so cannot perform click", false);
		}		
		
	}

	@Step
	public void raValidateDosToinTargetTableforNewCodesforAllJuries(String sDates, String sTargetTable, String sLCD_Article,String sCategoryType, String sNewCodes,String sLCD_ArtVersion) throws Exception 
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
     String sTargetTableName="";
     String sLCDArticleIDColName="";    
   	 List<String> Jurisdictions = null;   	   	
   	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>(); 
   	 String sQuery="";
   	 
   	 int iLCD_ArtVer = Integer.parseInt(sLCD_ArtVersion);
   
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
	
	 if(sLCD_Article.equals("LCD"))
  	  {   		  
  		   sTargetTableName = "LCD_CPT_ICD_LINKS";   		 
  		   sLCDArticleIDColName  =  "LCD_ID"; 	  	
  	   }
  	  else if (sLCD_Article.equals("Article"))
  	  { 
  		  sTargetTableName = "ARTICLE_CPT_ICD_LINKS";    		
  		  sLCDArticleIDColName  =  "ARTICLE_ID";  		  
  	  }
	
		//Retrieve HCPCCodes stored in Session variables	
		HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");			
	 
	    //Retrieve all Jurisdictions from the DB for each HCPC Code
	   if(HCPCSCodes.size()!=0) 
   	{
	   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
	   	 for(int j=0;j<HCPCSCodes.size();j++)
	   	 {	 
	   		sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCSCodes.get(j)+"'"+" and mcare_juris is not null and " +sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID");
	   	    Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
	   	    JuryMap.put(HCPCSCodes.get(j), Jurisdictions);
	   	 }    	    	 
   	}
   	else
   	{
   		logger.info("HCPC codes list size is 0");
		Assert.assertTrue("HCPC codes list size is 0",false);	   		
   	}  	  		
		//Retrieve all keys from the Map
	    Set<String> keys=JuryMap.keySet();	   
	   
	  switch (sLCD_Article)				      
      {			  
	      case "LCD":
		
	    	  	for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
	    	  		{ 

	    			// To retrieve the DOS_FROM and DOS_TO values stored in the DB			
	    		 	 for(String key : keys)  //Navigate through all keys and retrieve the values 
	    	   		  	  {	  		   		   		  	  
	    	   		  	     List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
	    		   		  	
	    	   		  	     if(Jurs.size()!=0)    
	    		   		  	   {					   		   		  		     
	    				    	  for (int j=0;j<Jurs.size();j++)  //Retrieve all the Jurisdictions for each HCPC Code and store them in DOSFromDate String Array
	    				    	  { 										
												sQuery1 = "Select TO_Char(DOS_TO,'MM/DD/YYYY') from LCD.LCD_CPT_ICD_LINKS where LCD_ID="
														+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
														+ " and ICD_CODE='" + Serenity.sessionVariableCalled("NewICDCode" + iStartIndex)
														+ "'" + " and mcare_juris='" + Jurs.get(j) + "'"
														+ " and  Manual_10=-1 and LCD_VERSION="+iLCD_ArtVer+" and SUPPORTS_10=" + iSupportVal;
												
												   String sNewICDCode = Serenity.sessionVariableCalled("NewICDCode" + iStartIndex);					
												   sDOSToValue = DBUtils.executeSQLQuery(sQuery1);
												
												if (sDOSToValue.compareTo(sDatesNew[0]) == 0) 
												{
													Assert.assertTrue("Dates entered while deleting the CodeCombination ::" + sDatesNew[0]
															+ " and DB DOS_TO dates: " + sDOSToValue + " for HCPC Code: " + key
															+ " are  equal.Codes are DateBanded in TargetTable for LCD:"
															+ Serenity.sessionVariableCalled("ID")+" and for Jury::"+ Jurs.get(j)+" for NewICDCode::"+sNewICDCode, true);
													
													logger.info("Entered Dates while deleting the CodeCombination ::" + sDatesNew[0]
															+ " and DB DOS_TO dates: " +  sDOSToValue + " for HCPC Code: " + key
															+ " are equal.Codes are DateBanded in TargetTable for LCD:"
															+ Serenity.sessionVariableCalled("ID")+" and for Jury::"+ Jurs.get(j)+" for NewICDCode::"+sNewICDCode);
												}
					
												else {
													logger.error("Entered Dates while deleting the CodeCombination ::" + sDatesNew[0]
															+ " and DB DOS_TO dates: " + sDOSToValue + " for HCPC Code:" + HCPCSCodes.get(j)
															+ "are Not equal.Codes are Not DateBanded in TargetTable for LCD:"
															+ Serenity.sessionVariableCalled("ID")+" and for Jury::"+ Jurs.get(j)+" for NewICDCode::"+sNewICDCode);
												
													Assert.assertTrue("Entered Dates while deleting the CodeCombination ::" + sDatesNew[0]
															+ " and DB DOS_TO dates: " + sDOSToValue + " for HCPC Code:" + HCPCSCodes.get(j)
															+ "are Not equal.Codes are Not DateBanded in TargetTable for LCD:"
															+ Serenity.sessionVariableCalled("ID")+" and for Jury::"+ Jurs.get(j)+" for NewICDCode::"+sNewICDCode, false);
												      }	    	  
	    				    		  	  }	//end of Jury for
	    		   		  	   }	//end of Keys for
	    	   		  	  }	//end of ICDCode for	    	  	
				   } //end of case
		    	  
	       break;
	      
	      case "Article":			

		    	//Executing For loop to retrieve the New manual code stored in  the session variables 
		    	 for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
					{	
			    		// To retrieve the DOS_FROM and DOS_TO values stored in the DB			
		    		 	 for(String key : keys)  //Navigate through all keys and retrieve the values 
		    	   		  	  {	  		   		   		  	  
	    	   		  	         List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
	    		   		  	
		    	   		  	     if(Jurs.size()!=0)    
		    		   		  	   {					   		   		  		     
		    				    	  for (int j=0;j<Jurs.size();j++)  //Retrieve all the Jurisdictions for each HCPC Code and store them in DOSFromDate String Array
		    				    	  { 	
		    				    		  						    	  
											String sQuery2 = "Select TO_Char(DOS_TO,'mm/dd/yyyy') from LCD.ARTICLE_CPT_ICD_LINKS where ARTICLE_ID="
													+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
													+ " and ICD_CODE='" + Serenity.sessionVariableCalled("NewICDCode" + iStartIndex)
													+ "'" + " and mcare_juris='" + key + "'"
													+ " and  Manual_10=-1 and ARTICLE_VERSION="+iLCD_ArtVer+" and SUPPORT_10=" + iSupportVal;
											
											        String sNewICDCode = Serenity.sessionVariableCalled("NewICDCode" + iStartIndex);						
					    							sDOSToValue = DBUtils.executeSQLQuery(sQuery1);	
					    							
													if (sDOSToValue.compareTo(sDatesNew[0]) == 0) 
													{
														Assert.assertTrue("Entered Dates while deleting the CodeCombination ::" + sDatesNew[0]
																+ " and DB DOS_TO dates: " + sDOSToValue + " for HCPC Code:" + key
																+ "are  equal.Codes are DateBanded in TargetTable for Article:"
																+ Serenity.sessionVariableCalled("ID")+" and for Jury::"+ Jurs.get(j)+" for NewICDCode::"+sNewICDCode, true);
														
														logger.info("Entered Dates while deleting the CodeCombination ::" + sDatesNew[0]
																+ " and DB DOS_TO dates: " + sDOSToValue + " for HCPC Code:" + key
																+ "are equal.Codes are DateBanded in TargetTable for Article:"
																+ Serenity.sessionVariableCalled("ID")+" and for Jury::"+ Jurs.get(j)+" for NewICDCode::"+sNewICDCode);
													    }
						
													else {
														logger.error("Entered Dates while deleting the CodeCombination ::" + sDatesNew[0]
																+ " and DB DOS_TO dates: " + sDOSToValue + " for HCPC Code:" + HCPCSCodes.get(j)
																+ "are Not equal.Codes are Not DateBanded in TargetTable for Article:"
																+ Serenity.sessionVariableCalled("ID")+" and for Jury::"+ Jurs.get(j)+" for NewICDCode::"+sNewICDCode);
														
														Assert.assertTrue("Entered Dates while deleting the CodeCombination ::" + sDatesNew[0]
																+ " and DB DOS_TO dates: " + sDOSToValue + " for HCPC Code:" + HCPCSCodes.get(j)
																+ "are Not equal.Codes are Not DateBanded in TargetTable for Article:"
																+ Serenity.sessionVariableCalled("ID")+" and for Jury::"+ Jurs.get(j)+" for NewICDCode::"+sNewICDCode, false);
													         }
		    				    	      }//end of Jury for
	    		   		  	   }//end of Keys for	    	   		  	     
			    	  }	//end of ICDCode for	 
				   } //end of case	  
	    	  
	       break;   
	       
	      default:  logger.info("No input is provided for the Switch Case");
          		    Assert.assertTrue("Provided invalid case value",false);				
      }			
	
		
		
	}

	@Step
	public void raValidatesAssctdCodesDeletionforAllJuries(String sLCD_Article, String sCategoryType, String sNewCodes,String sLCD_ArtVersion) throws Exception 
	{			
	      int iSupportVal=-2;
		  String sQuery1="";    	   	  	   	  
		  List<String> HCPCSCodes=null;		 
	      int iCodeNo=0;
	      int iLoopCounter=0;	  
	     String[] sManualCodes=null;  
	     sManualCodes=sNewCodes.split(",");	    
	     String sLCDArticleIDColName="";    
	   	 List<String> Jurisdictions = null;   	   	
	   	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>(); 
	   	 String sQuery="";
	   	 int iDBRowCount = -100;
	   	 String sDeltaTableName="";
	   	 int iLCD_ArtVer = Integer.parseInt(sLCD_ArtVersion);
	   	String sLCDArticleIDDltaColName ="";
	   
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
		
		 if(sLCD_Article.equals("LCD"))
	  	  {   			  		  	 
	  		   sLCDArticleIDColName  =  "LCD_ID"; 	 
	  		   sDeltaTableName = "LCD_CPT_ICD_SPRT_DELTA";
	  		   sLCDArticleIDDltaColName =  "LCD_ID"; 	  		   
	  	   }
	  	  else if (sLCD_Article.equals("Article"))
	  	  { 			
	  		  sLCDArticleIDColName  =  "ARTICLE_ID";  
	  		  sDeltaTableName = "ART_CPT_ICD_SPRT_DELTA";
	  		 sLCDArticleIDDltaColName =  "ART_ID"; 
	  	  }
		
			//Retrieve HCPCCodes stored in Session variables	
			HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");			
		 
		    //Retrieve all Jurisdictions from the DB for each HCPC Code
		   if(HCPCSCodes.size()!=0) 
	   	{
		   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
		   	 for(int j=0;j<HCPCSCodes.size();j++)
		   	 {	 
		   		sQuery = "Select distinct mcare_juris from LCD."+sDeltaTableName+" where hcpc_code ='" +HCPCSCodes.get(j)+"'"+" and mcare_juris is not null and " +sLCDArticleIDDltaColName+"="+ Serenity.sessionVariableCalled("ID");
		   	    Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
		   	    JuryMap.put(HCPCSCodes.get(j), Jurisdictions);
		   	 }    	    	 
	   	}
	   	else
	   	{
	   		logger.info("HCPC codes list size is 0");
			Assert.assertTrue("HCPC codes list size is 0",false);	   		
	   	}  	  		
			//Retrieve all keys from the Map
		    Set<String> keys=JuryMap.keySet();	   
		   
		  switch (sLCD_Article)				      
	      {			  
		      case "LCD":
			
		    	  	for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
		    	  		{		    				
		    		 	 for(String key : keys)  //Navigate through all keys and retrieve the values 
		    	   		  	  {	  		   		   		  	  
		    	   		  	     List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
		    		   		  	
		    	   		  	     if(Jurs.size()!=0)    
		    		   		  	   {					   		   		  		     
		    				    	  for (int j=0;j<Jurs.size();j++)  //Retrieve the count for each hcpc code  and new manual code combination in Target
		    				    	  { 										
													sQuery1 = "Select count(*) from LCD.LCD_CPT_ICD_LINKS where LCD_ID="
															+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
															+ " and ICD_CODE='" + Serenity.sessionVariableCalled("NewICDCode" + iStartIndex)
															+ "'" + " and mcare_juris='" + Jurs.get(j) + "'"
															+ " and  Manual_10=-1 and LCD_VERSION="+iLCD_ArtVer+" and SUPPORTS_10=" + iSupportVal;
													
													   String sNewICDCode = Serenity.sessionVariableCalled("NewICDCode" + iStartIndex);					
													   iDBRowCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery1));
													
													if (iDBRowCount == 0) 
													{
														Assert.assertTrue("The CodeCombination  for HCPC Code: " + key
																+ " not moved to Target as expected for  LCD::"
																+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode, true);
														
														logger.info("The CodeCombination  for HCPC Code: " + key 
																+ " not moved to Target as expected for  LCD::" + 
																 Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode);
													}
						
													else {
														logger.error("The CodeCombination  for HCPC Code: " + key
																+ " moved to Target  after deletion for  LCD::"
																+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode);
													
														Assert.assertTrue("The CodeCombination  for HCPC Code: " + key
																+ " moved to Target after deletion   for  LCD::"
																+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode+sNewICDCode, false);
													      }	    	  
		    				    		  	  }	//end of Jury for
		    		   		  	   }	//end of Keys for
		    	   		  	  }	//end of ICDCode for	    	  	
					   } //end of case
			    	  
		       break;
		      
		      case "Article":			

			    	//Executing For loop to retrieve the New manual code stored in  the session variables 
			    	 for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
						{	
				    					
			    		 	 for(String key : keys)  //Navigate through all keys and retrieve the values 
			    	   		  	  {	  		   		   		  	  
		    	   		  	         List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
		    		   		  	
			    	   		  	     if(Jurs.size()!=0)    
			    		   		  	   {					   		   		  		     
			    				    	  for (int j=0;j<Jurs.size();j++)   //Retrieve the count for each hcpc code  and new manual code combination in Target
			    				    	  { 	
						    	  
												String sQuery2 = "Select count(*)  from LCD.ARTICLE_CPT_ICD_LINKS where ARTICLE_ID="
														+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
														+ " and ICD_CODE='" + Serenity.sessionVariableCalled("NewICDCode" + iStartIndex)
														+ "'" + " and mcare_juris='" + key + "'"
														+ " and  Manual_10=-1 and ARTICLE_VERSION="+iLCD_ArtVer+" and SUPPORT_10=" + iSupportVal;
												
												        String sNewICDCode = Serenity.sessionVariableCalled("NewICDCode" + iStartIndex);						
												        iDBRowCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery2));
						    							
												        if (iDBRowCount == 0) 
														{
												        	Assert.assertTrue("The CodeCombination  for HCPC Code: " + key
																	+ " not moved to Target as expected for  Article::"
																	+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode, true);
															
															logger.info("The CodeCombination  for HCPC Code: " + key 
																	+ " not moved to Target as expected for  Article::" + 
																	 Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode);
														}
							
														else {
															logger.error("The CodeCombination  for HCPC Code: " + key
																	+ " moved to Target  after deletion for  Article::"
																	+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode);
														
															Assert.assertTrue("The CodeCombination  for HCPC Code: " + key
																	+ " moved to Target after deletion   for  Article::"
																	+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode, false);
														      }	    	  
			    				    	      }//end of Jury for
		    		   		  	   }//end of Keys for	    	   		  	     
				    	  }	//end of ICDCode for	 
					   } //end of case	  
		    	  
		       break;   
		       
		      default:  logger.info("No input is provided for the Switch Case");
	          		    Assert.assertTrue("Provided invalid case value",false);				
	      }			
		
	}

	@Step
	public void raValidatesCodeCombsinTargetTable(String sLCD_Article, String sCategoryType, String sNewCodes,String sLCD_ArtVersion, String sCodeComboType) throws Exception 
	{		
	      int iSupportVal=-2;
		  String sQuery1="";    	   	  	   	  
		  List<String> HCPCSCodes=null;		 
	      int iCodeNo=0;
	      int iLoopCounter=0;	  
	     String[] sManualCodes=null;  
	     sManualCodes=sNewCodes.split(",");	    
	     String sLCDArticleIDColName="";    
	   	 List<String> Jurisdictions = null;   	   	
	   	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>(); 
	   	 String sQuery="";
	   	 int iDBRowCount = -100;
	   	 String sTargetTableName="";
	   	 int iLCD_ArtVer = Integer.parseInt(sLCD_ArtVersion);
	   	String sLCDArticleIDDltaColName ="";
	   	String sLCDArtIDColName="";
	   
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
		
		 if(sLCD_Article.equals("LCD"))
	  	  {   			  		  	 
	  		   sLCDArtIDColName  =  "LCD_ID"; 	 
	  		   sTargetTableName = "LCD_CPT_ICD_LINKS";
	  		   sLCDArticleIDDltaColName =  "LCD_ID"; 	  		   
	  	   }
	  	  else if (sLCD_Article.equals("Article"))
	  	  { 			
	  		 sLCDArtIDColName  =  "ARTICLE_ID";  
	  		 sTargetTableName = "ARTICLE_CPT_ICD_LINKS";
	  		 sLCDArticleIDDltaColName =  "ARTICLE_ID"; 
	  	  }
		
			//Retrieve HCPCCodes stored in Session variables	
			HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");			
		 
		    //Retrieve all Jurisdictions from the DB for each HCPC Code
		   if(HCPCSCodes.size()!=0) 
	    	{
		   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
		   	 for(int j=0;j<HCPCSCodes.size();j++)
		   	 {	 
		   		sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCSCodes.get(j)+"'"+" and mcare_juris is not null and " +sLCDArtIDColName+"="+ Serenity.sessionVariableCalled("ID");
		   	    Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
		   	    JuryMap.put(HCPCSCodes.get(j), Jurisdictions);
		   	 }    	    	 
	   	}
	   	else
	   	{
	   		logger.info("HCPC codes list size is 0");
			Assert.assertTrue("HCPC codes list size is 0",false);	   		
	   	}  	  		
			//Retrieve all keys from the Map
		    Set<String> keys=JuryMap.keySet();	   
		   
		  switch (sLCD_Article)				      
	      {			  
		      case "LCD":
			
		    	  	for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
		    	  		{		    				
		    		 	 for(String key : keys)  //Navigate through all keys and retrieve the values 
		    	   		  	  {	  		   		   		  	  
		    	   		  	     List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
		    		   		  	
		    	   		  	     if(Jurs.size()!=0)    
		    		   		  	   {					   		   		  		     
		    				    	  for (int j=0;j<Jurs.size();j++)  //Retrieve the count for each hcpc code  and new manual code combination in Target
		    				    	  { 										
													sQuery1 = "Select count(*) from LCD.LCD_CPT_ICD_LINKS where LCD_ID="
															+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
															+ " and ICD_CODE='" + Serenity.sessionVariableCalled("NewICDCode" + iStartIndex)
															+ "'" + " and mcare_juris='" + Jurs.get(j) + "'"
															+ " and  Manual_10=-1 and LCD_VERSION="+iLCD_ArtVer+" and SUPPORTS_10=" + iSupportVal;
													
													   String sNewICDCode = Serenity.sessionVariableCalled("NewICDCode" + iStartIndex);					
													   iDBRowCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery1));
													
													if (iDBRowCount == 1) 
													{
														Assert.assertTrue("The CodeCombination  for HCPC Code: " + key
																+ " created in Target as expected for  LCD::"
																+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and for NewICDCode::"+sNewICDCode, true);
														
														logger.info("The CodeCombination  for HCPC Code: " + key 
																+ "  created in Target as expected as expected for  LCD::" + 
																 Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode);
													}
						
													else {
														logger.error("The CodeCombination  for HCPC Code: " + key
																+ " not created in Target as expected  for  LCD::"
																+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode);
													
														Assert.assertTrue("The CodeCombination  for HCPC Code: " + key
																+ " not created in Target as expected for LCD::"
																+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode+sNewICDCode, false);
													      }	    	  
		    				    		  	  }	//end of Jury for
		    		   		  	   }	//end of Keys for
		    	   		  	  }	//end of ICDCode for	    	  	
					   } //end of case
			    	  
		       break;
		      
		      case "Article":			

			    	//Executing For loop to retrieve the New manual code stored in  the session variables 
			    	 for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
						{	
				    					
			    		 	 for(String key : keys)  //Navigate through all keys and retrieve the values 
			    	   		  	  {	  		   		   		  	  
		    	   		  	         List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
		    		   		  	
			    	   		  	     if(Jurs.size()!=0)    
			    		   		  	   {					   		   		  		     
			    				    	  for (int j=0;j<Jurs.size();j++)   //Retrieve the count for each hcpc code  and new manual code combination in Target
			    				    	  { 	
						    	  
												String sQuery2 = "Select count(*)  from LCD.ARTICLE_CPT_ICD_LINKS where ARTICLE_ID="
														+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
														+ " and ICD_CODE='" + Serenity.sessionVariableCalled("NewICDCode" + iStartIndex)
														+ "'" + " and mcare_juris='" + Jurs.get(j) + "'"
														+ " and  Manual_10=-1 and ARTICLE_VERSION="+iLCD_ArtVer+" and SUPPORT_10=" + iSupportVal;
												
												        String sNewICDCode = Serenity.sessionVariableCalled("NewICDCode" + iStartIndex);						
												        iDBRowCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery2));
						    							
												        if (iDBRowCount == 1) 
														{
												        	Assert.assertTrue("The CodeCombination  for HCPC Code: " + key
																	+ "  created in Target as expected  for  Article::"
																	+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode, true);
															
															logger.info("The CodeCombination  for HCPC Code: " + key 
																	+ "  created in Target as expected  for  Article::" + 
																	 Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode);
														}
							
														else {
															logger.error("The CodeCombination  for HCPC Code: " + key
																	+ "  not created in Target for  Article::"
																	+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode);
														
															Assert.assertTrue("The CodeCombination  for HCPC Code: " + key
																	+ " not created in Target  for  Article::"
																	+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode, false);
														      }	    	  
			    				    	      }//end of Jury for
		    		   		  	   }//end of Keys for	    	   		  	     
				    	  }	//end of ICDCode for	 
					   } //end of case	  
		    	  
		       break;   
		       
		      default:  logger.info("No input is provided for the Switch Case");
	          		    Assert.assertTrue("Provided invalid case value",false);				
	      }			
				
	}

	@Step
	public void raValidatesCodeCombsinTargetDataUI(String sLCD_Article, String sNewCodes,String sCategoryType,String sLCD_ArticleVersion) throws Exception 
	{		
	      int iSupportVal=-2;
		  String sQuery1="";    	   	  	   	  
		  List<String> HCPCSCodes=null;		 
	      int iCodeNo=0;
	      int iLoopCounter=0;	  
	     String[] sManualCodes=null;  
	     sManualCodes=sNewCodes.split(",");	    
	     String sLCDArticleIDColName="";    
	   	 List<String> Jurisdictions = null;   	   	
	   	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>(); 
	   	 String sQuery="";
	   	 int iDBRowCount = -100;
	   	 String sTargetTableName="";	
	   	String sLCDArticleIDDltaColName ="";
		List<WebElement> colValuesList = null;			
		boolean comparisionSuccessfull=true;
		int k=0;
		int m=0;
          
	   	
	   	int iLCD_ArtVer =  Integer.parseInt(sLCD_ArticleVersion);
	   
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
		
		 if(sLCD_Article.equals("LCD"))
	  	  {   			  		  	 
	  		   sLCDArticleIDColName  =  "LCD_ID"; 	 
	  		 sTargetTableName = "LCD_CPT_ICD_LINKS";
	  		   sLCDArticleIDDltaColName =  "LCD_ID"; 	  		   
	  	   }
	  	  else if (sLCD_Article.equals("Article"))
	  	  { 			
	  		  sLCDArticleIDColName  =  "ARTICLE_ID";  
	  		 sTargetTableName = "Article_CPT_ICD_LINKS";
	  		 sLCDArticleIDDltaColName =  "ART_ID"; 
	  	  }
		
			//Retrieve HCPCCodes stored in Session variables	
			HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");			
		 
		    //Retrieve all Jurisdictions from the DB for each HCPC Code
		   if(HCPCSCodes.size()!=0) 
	   	{
		   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
		   	 for(int j=0;j<HCPCSCodes.size();j++)
		   	 {	 
		   		sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCSCodes.get(j)+"'"+" and mcare_juris is not null and " +sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID");
		   	    Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
		   	    JuryMap.put(HCPCSCodes.get(j), Jurisdictions);
		   	 }    	    	 
	   	}
	   	else
	   	{
	   		logger.info("HCPC codes list size is 0");
			Assert.assertTrue("HCPC codes list size is 0",false);	   		
	   	}  	  		
			//Retrieve all keys from the Map
		    Set<String> keys=JuryMap.keySet();	   
		   
		  switch (sLCD_Article)				      
	      {			  
		      case "LCD":
			
		    	  	for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
		    	  		{		    				
		    		 	 for(String key : keys)  //Navigate through all keys and retrieve the values 
		    	   		  	  {	  		   		   		  	  
		    	   		  	     List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List		   		   		  	 
		    		   		  	
		    	   		  	    // if(Jurs.size()!=0)    
		    		   		  	 //  {					   		   		  		     
		    				    	//  for (int j=0;j<Jurs.size();j++)  //Retrieve the count for each hcpc code  and new manual code combination in Target
		    				    	//  { 				    				    		  
		    				    		  
		    				    		  String sNewICDCode =  Serenity.sessionVariableCalled("NewICDCode" + iStartIndex);
		    				    		  
		    				    		  //Enter LCD/Article  ID
		    				    		  oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "LCD/Article ID"), Serenity.sessionVariableCalled("ID"));
		    				    		   logger.info("Entered LCD/Article ID in the TargetScreen:: "+Serenity.sessionVariableCalled("ID"));
		    				    		  
		    				    						    				    		  
		    				    		 //Enter CPT/HCPC Code 
		    				    		 oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "CPT Code"),key);
		    				    		 logger.info("Entered CPT Code TargetScreen:: "+key);
		    				    		 
		    				    		  //Enter ICD Code
		    				    	     oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "ICD Code"),sNewICDCode);
		    				    	     logger.info("Entered ICD Code TargetScreen:: "+sNewICDCode);
		    				    		  
		    				    		   //Apply filter
		    				    	       oAdminPage.ApplyFilter_Btn.click();
		    						       oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);		
		    						       logger.info("clicked on Apply Filter Button");
		    						  
		    						       //Retrieve Jurisdiction  values from DB for comparison with UI
											String sJuriesQuery1 = "Select mcare_juris  from LCD.LCD_CPT_ICD_LINKS   where lcd_id=	"+ Serenity.sessionVariableCalled("ID")+"   and icd_code='"+ Serenity.sessionVariableCalled("NewICDCode" + iStartIndex)+"'"+" and hcpc_code ="+" '" + key + "'"+" and supports_10="+ iSupportVal+" and LCD_VERSION="+iLCD_ArtVer;					
										    //Compare Query results with UI													   
											Assert.assertTrue("Decision column values compared with the DB Values ",oAdminPage.CompareDB_UIColumnValues(sJuriesQuery1, "MCARE_JURIS",oAdminPage.sJurisidictionCol));
											logger.info("Decision column values compared with the DB Values and values are equal"); 
											
											//Retrieve DOS To values from DB for comparison with UI
											String sDOSQuery1 = "Select TO_Char(DOS_TO,'MM/DD/YYYY')  from LCD.LCD_CPT_ICD_LINKS   where lcd_id=	"+ Serenity.sessionVariableCalled("ID")+"   and icd_code='"+ Serenity.sessionVariableCalled("NewICDCode" + iStartIndex)+"'"+" and hcpc_code ="+" '" + key + "'"+" and supports_10="+ iSupportVal+" and LCD_VERSION="+iLCD_ArtVer;
																																	
										  //Finding all UI elements and adding in the list             
									     colValuesList = getDriver().findElements(By.xpath(oAdminPage.sDosToCol));
									          
									     //Capture all DB column values
									     List<String> sDBColValList =    DBUtils.executeSQLQueryMultipleRows(sDOSQuery1);									     
											
									           int idFound=0;
											
											  //Compare DB column values with the UI values
											  for(k=0;k<sDBColValList.size();k++)				
											  {
												 idFound=1;
												 for  (m=k;m<colValuesList.size();m++)		
												  {													 
													      String sUIDate =  (colValuesList.get(m).getText()).trim();
													      String sDBDate =  (sDBColValList.get(k)).trim();
													 
													 if((sUIDate.isEmpty()) && (sDBDate.isEmpty())){
														 System.out.println("After comparision :" + "Column value  matched for DB and UI");
														 logger.info("After comparision :" + "Column value  matched for DB and UI");
														  idFound=1;
														  break; 
													 }
													 if (sUIDate.compareTo(sDBDate)==0)
													  {
														  System.out.println("After comparision :" + "Column value matched for DB and UI");
														  logger.info("After comparision :" + "Column value  matched for DB and UI");
														  idFound=1;
														  break;
													  }//end of if
												  }//end of inner For
											   
												   if(idFound==0)
												   {
													 System.out.println("After comparision :" + "DB value not available in UI"+"DB Value: "+sDBColValList.get(k));
													 logger.info("After comparision :" + "DB value not available in UI"+"DB Value:"+sDBColValList.get(k));
													 comparisionSuccessfull =false;	
													 break;
												   }
									          
											  }//End of For												
																								   
											//Clear the Filters 
											oAdminPage.ClearAllFilters_Btn.click();
					    					oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
					    					 logger.info("ClearAll Filters button clicked");
													
		    				    		  	 // }	//end of Jury for
		    		   		  	 //  }	//end of Keys for
		    	   		  	  }	//end of ICDCode for	
		    		 	break;
					   } //end of case		       
	      }
	}

   @Step	
   public void raValidatesRecordsCountinUI(String sLCD_Article) throws Exception 
	{
		
		String sQuery = "";
		String sID =  Serenity.sessionVariableCalled("ID");
		
		//Enter LCD or Article
		 oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "LCD/Article ID"), sID);
		
		//Click Apply Filter
		 oAdminPage.ApplyFilter_Btn.click();
	     oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		
		//Capture the UI Count	    
	     int UIItemsCount = oAdminPage.retrievePageItemsCount("All Items","AdminTargetData");
				
		//Compare with the DB Count				
		switch (sLCD_Article)
		{		
		case "LCD":			     
			         sQuery  =  "Select count (*) from LCD.LCD_CPT_ICD_LINKS  where LCD_ID ="+sID;			
			 break;
			 
		case "Article":
			       sQuery  =  "Select count (*) from LCD.ARTICLE_CPT_ICD_LINKS  where ARTICLE_ID ="+sID;			
			   break;				
		}
		
		 int iDBItemsCount  = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));		 
	     if (UIItemsCount ==  iDBItemsCount)
	     {
	    	logger.info("All adjudication records  displayed on the Target Data Screen");
			Assert.assertTrue("All adjudication records  displayed on the Target Data Screen ", true);
	     }
	     else
	     {
	    	logger.error("All adjudication records not displayed on the Target Data Screen->DBRecords Count ::"+iDBItemsCount+ " UI Records Count::+"+UIItemsCount);
			Assert.assertTrue("All adjudication records  displayed on the Target Data Screen->DBRecords Count ::"+iDBItemsCount+" UI Records Count::+"+UIItemsCount,false);	    	 
	     }
	     
	 	//Clear the Filters 
		oAdminPage.ClearAllFilters_Btn.click();
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	
		
	}
	
@Step
	public void validateSingleRecordforJuries(String sScreenName, String sColName) throws Exception 
{
	
	//Retrieve the ID	
	String sID =  Serenity.sessionVariableCalled("ID");	
	int iDecisionsCountUI =0;
	String sJuryData ="";
	
	int iVal = 0;
	String sJuryColData   =   "(//div[@role='gridcell'])["+iVal+"]"; 

    switch (sScreenName)
    { 	
    
       case "GroupTasks":
    	   
    	          iVal  = 4;
    	          sJuryColData   =   "(//div[@role='gridcell'])["+iVal+"]"; 
				
			   	//Enter LCD/Article in the ID Field
    	        oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,sID);
    	        oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				
				//Capture UI Count
    	        iDecisionsCountUI = oRAPage.retrievePageItemsCount("AllItems", "GroupTasks");
    	    				
				//Compare UI and DB count
    	        if (iDecisionsCountUI  ==  1)
    	        {
    	        	logger.info("Only one Record is displayed in GroupTasks screen as expected");
    				Assert.assertTrue("Only one Record is displayed in GroupTasks screen as expected", (iDecisionsCountUI  ==  1));	    	        	
    	        }
    	        else
    	        {
    	        	logger.error("Multiple Records displayed in GroupTasks screen");
    				Assert.assertTrue("Multiple Records displayed in GroupTasks screen", (iDecisionsCountUI  ==  1));	    	        	    	        	
    	        }
				
				//Check Jury Col value is blank    	       
    	         sJuryData = oSeleniumUtils.get_TextFrom_Locator(sJuryColData);    	       
    	         if(sJuryData.isEmpty())
    	         {
    	        	 logger.info("Jursidiction  column data is empty in GroupTasks screen ");
     				Assert.assertTrue("Jursidiction  column data is empty in GroupTasks screen", sJuryData.isEmpty());	    	
    	        }
    	         else
    	         {
    	        	 logger.error("Jursidiction column data is Not  empty in GroupTasks screen");
     				Assert.assertTrue("Jursidiction column data is Not  empty in GroupTasks screen", sJuryData.isEmpty());	    	
    	         }
    	            	   
    	   break;
		    	
		case "IndividualTasks":
			
		    iVal  = 5;
			 sJuryColData   =   "(//div[@role='gridcell'])["+iVal+"]"; 
			
			 oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,sID);
			 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			 
			iDecisionsCountUI = oRAPage.retrievePageItemsCount("AllItems", "IndividualTasks");
			
			//Compare UI and DB count
	        if (iDecisionsCountUI  ==  1)
	        {
	        	logger.info("Only one Record is displayed in IndividiualTasks screen as expected");
				Assert.assertTrue("Only one Record is displayed in IndividiualTasks screen as expected", true);	    	        	
	        }
	        else
	        {
	        	logger.error("Multiple Records displayed in IndividiualTasks screen");
				Assert.assertTrue("Multiple Records displayed in IndividiualTasks screen", false);	    	        	    	        	
	        }
	        
	        sJuryData = oSeleniumUtils.get_TextFrom_Locator(sJuryColData);  
	        if(sJuryData.isEmpty())
	         {
	        	 logger.info("Jursidiction  column data is empty in IndividiualTasks screen ");
				Assert.assertTrue("Jursidiction  column data is empty in IndividiualTasks screen", true);	    	
	        }
	         else
	         {
	        	 logger.error("Jursidiction column data is Not  empty in IndividiualTasks screen");
				Assert.assertTrue("Jursidiction column data is Not  empty in IndividiualTasks screen", false);	    	
	         }	            	   
					    	
		break;	
				
		case "Admin":
			
			 iVal  = 6;
			 sJuryColData   =   "(//div[@role='gridcell'])["+iVal+"]"; 	
			
			 oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oAdminPage.TargetDataColInputField, "sColVal", "ID"), sID);
			 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			 
			    iDecisionsCountUI = oAdminPage.retrievePageItemsCount("AllItems", "AdminScreen");
			    if (iDecisionsCountUI  ==  1)
		        {
		        	logger.info("Only one Record is displayed in AdminScreen  as expected");
					Assert.assertTrue("Only one Record is displayed in AdminScreen as expected", true);	    	        	
		        }
		        else
		        {
		        	logger.error("Multiple Records displayed in AdminScreen ");
					Assert.assertTrue("Multiple Records displayed in AdminScreen", false);	    	        	    	        	
		        }
			    
			    sJuryData = oSeleniumUtils.get_TextFrom_Locator(sJuryColData);  
			    if(sJuryData.isEmpty())
   	         {
   	        	 logger.info("Jursidiction  column data is empty in GroupTasks screen ");
    				Assert.assertTrue("Jursidiction  column data is empty in GroupTasks screen", true);	    	
   	        }
   	         else
   	         {
   	        	 logger.error("Jursidiction column data is Not  empty in Admin screen");
    				Assert.assertTrue("Jursidiction column data is Not  empty in Admin screen", false);	    	
   	         }
		 	
		break;	
		
		case "RAReviewWorkQueue":
			
			
			
			
		break;	
		 	  
    }	
		
}

@Step
	public void captureIDfromDB(String sLCD_Article)
{

	String sID ="";
	
		if(sLCD_Article.equalsIgnoreCase("LCD"))
		{			
			sID= DBUtils.executeSQLQuery(DBQueries.LCD_ID_Query);			     
			Serenity.setSessionVariable("LCD_ID").to(sID);	
			Serenity.setSessionVariable("ID").to(sID);	
			System.out.println("LCD id value is ...."+Serenity.sessionVariableCalled("ID").toString());		
		}
		else{  //Code for Article 		
			sID = DBUtils.executeSQLQuery(DBQueries.ArticleQuery);	
			Serenity.setSessionVariable("Article_ID").to(sID);
			Serenity.setSessionVariable("ID").to(sID);				
		}
	
}

@Step
	public void claimsIDfromGrouptasks() 
{
		oSeleniumUtils.is_WebElement_Displayed(oHomePage.ID_Checkbox);			
	oSeleniumUtils.Click_given_WebElement(oHomePage.ID_Checkbox);
	logger.info("Clicked on the ID CheckBox");
	SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
	oSeleniumUtils.Click_given_WebElement(oHomePage.ClaimTask_Btn);
	logger.info("Clicked on the ClaimTask Button for the ID");
	SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
	
}

@Step
	public void raFilterstheID()
{
	
	 String sID =  Serenity.sessionVariableCalled("ID");
     oSeleniumUtils.enter_given_text_webelement(oHomePage.ID_Txt,sID);
     logger.info("ID entered in the TextBox :"+sID);
     oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
}

@Step
   public void validateMinDosFromLogic(String sNewICDCode, String sLCD_Article, String sVersionNo, String sScenarioName) throws Exception
{
  	 List<String> HCPCCodes = new ArrayList <String>();  
  	 List<String> Jurisdictions = null;   	
  	 String sDOSFromDate = "";
  	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
    String sTargetTableName = "";
  	 String sMasterTableName = "";
  	 String sLCDArticleIDColName = "";
  	 String sQuery="";
  	 int j=0;	   	
  	String sEffectiveDateColName="";
  	String sVersionColName="";
  	int iVersionNo=  Integer.parseInt(sVersionNo);
  	 List<String> DosFromValues =  new ArrayList<String>() ;
     String sDOSFromValue = ""; 
     java.util.Date dDBDOSFromDate = null;
     boolean blDOSFromValuesequal=false;
     String [] sScnarioNames ;
     String sNewJuryName =  "";
     String sDeltaTableName = "";
     Set<String> keys  = new HashSet();
     
      iVersionNo  = Integer.parseInt(sVersionNo);
           
     //Retrieve the HCPC codes from the session variable    	
  	 HCPCCodes = Serenity.sessionVariableCalled("HCPCCodes"); 	 	
  	 
  	  //Assign table names based on whether it is LCD or Article 
  	  if(sLCD_Article.equals("LCD"))
  	  {   		  
  		   sTargetTableName = "LCD_CPT_ICD_LINKS"; 
  		   sMasterTableName =   "LCD_MASTER";
  		   sLCDArticleIDColName  =  "LCD_ID";	   		 
  		   sEffectiveDateColName = "REV_EFF_DATE";
  		   sVersionColName =  "LCD_VERSION";
  		   sDeltaTableName = "LCD_CPT_ICD_SPRT_DELTA";
  	   }
  	  else if (sLCD_Article.equals("Article"))
  	  { 
  		  sTargetTableName = "ARTICLE_CPT_ICD_LINKS";   
  		  sMasterTableName =   "ARTICLE_MASTER";
  		  sLCDArticleIDColName  =  "ARTICLE_ID";	   		
  		  sEffectiveDateColName  = "ARTICLE_EFF_DATE";
  		  sVersionColName =  "ARTICLE_VERSION";
  		 sDeltaTableName = "ART_CPT_ICD_SPRT_DELTA";
  	  }  	  
  	 
  	  SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
	
  	switch (sScenarioName)
  	{
  	
  	case "NewICDCode2ndWeek":		
  		
  	 	if(HCPCCodes.size()!=0) 
  	  	{
  	  		 DosFromValues.clear();
  	  		
  		   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
  		   	 for(j=0;j<HCPCCodes.size();j++)
  		   	 {	 
  		   		sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCCodes.get(j)+"'"+" and mcare_juris is not null and "+sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID");
  		   	    Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
  		   	    JuryMap.put(HCPCCodes.get(j), Jurisdictions);
  		   	 }    	    	 
  	  	}
  	  	else
  	  	{
  	  		logger.info("HCPC codes list size is 0");
  			Assert.assertTrue("HCPC codes list size is 0",false);	   		
  	  	}
  	 	
  	  //Retrieve all keys from the Map  --Keys are HCPC codes
  	     keys=JuryMap.keySet(); 
  	    
  		break;
  		
	case "NewJury2ndWeek":		
		
				sScnarioNames  = sScenarioName.split("-");
				sNewJuryName   =    sScnarioNames[1];
				
				if(HCPCCodes.size()!=0) 
		  	  	{
		  	  		 DosFromValues.clear();
		  	  		
		  		   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
		  		   	 for(j=0;j<HCPCCodes.size();j++)
		  		   	 {	 
		  		   		sQuery = "Select distinct mcare_juris from LCD."+sDeltaTableName+" where hcpc_code ='" +HCPCCodes.get(j)+"'"+" and mcare_juris is not null and "+sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID")+" and "+ sVersionColName +"= 2";
		  		   	    Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
		  		   	    JuryMap.put(HCPCCodes.get(j), Jurisdictions);
		  		   	 }    	    	 
		  	  	}
		  	  	else
		  	  	{
		  	  		logger.info("HCPC codes list size is 0");
		  			Assert.assertTrue("HCPC codes list size is 0",false);	   		
		  	  	}
				
		  	  //Retrieve all keys from the Map  --Keys are HCPC codes
		  	   keys=JuryMap.keySet(); 
		  	   
		  	   break;
		  	    	 
  	}  	
  	
  	//Retrieve min(dos_from) for each HCPC code for all juries  	
	for(String key : keys)  //Navigate through all keys and retrieve the values 
	  {   
	     	
		    List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List
				  	
					if(Jurs.size()!=0)    
					 {			  	 
			    		  	 for (j=0;j<Jurs.size();j++)  //Retrieve all the Jurisdictions for each HCPC Code and store them in DOSFromDate String Array
			    		  	 {		  		    
			    					 sQuery = "Select To_Char(DOS_FROM,'dd-mm-yyyy') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName+"="
			    							+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
			    							+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"="+iVersionNo;
			    					
				    					 sDOSFromValue = DBUtils.executeSQLQuery(sQuery);				    					 					 		
				    					 DosFromValues.add(sDOSFromValue);
			    		  	 }//end of each Jury for
			    		  	 
			      //Compare Dos from values for a jury			    		  	         
			       outerloop: for (int k=0;k<DosFromValues.size();k++)
			    		  	           {    				    		  	        	   
				    		  	        	   //Compare Dos From values for a jury    		  	     
					    		  	           for (int m=0;m<DosFromValues.size();m++)
					    		  	           {  
					    		  	        	       if (DosFromValues.get(k).compareTo(DosFromValues.get(m))==0)
					    		  	        	       {    		  	        	    	        
					    		  	        	    	   blDOSFromValuesequal = true;   
					    		  	        	       }
					    		  	        	       else
					    		  	        	         {
					    		  	        	    	        blDOSFromValuesequal = false;
					    		  	        	    	        break outerloop;				    		  	        	    	        
					    		  	        	            }
					    		  	               }
			    		  	               }			    		  	           
			    		  	           
			    		  	         if (blDOSFromValuesequal)    //if it is true
					    		  	   {					    		  	        	 
			    		  	        	      String sExpectedDOSFromVal  =  DosFromValues.get(0);
			    		  	        	      
								    		  	 for (j=0;j<Jurs.size();j++) 
								    		  	 {			
				    		    					 sQuery = "Select To_Char(DOS_FROM,'dd-mm-yyyy') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName+"="
				    		    							+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
				    		    							+ " and ICD_CODE='" + sNewICDCode + "'"+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"="+iVersionNo;								    					
									    					 
				    		    					        sDOSFromValue = DBUtils.executeSQLQuery(sQuery);			    		  	        	   
									    					 
									    					 if(sDOSFromValue.compareToIgnoreCase(sExpectedDOSFromVal)==0)
									    					 {									    						 
									    						 logger.info("DOS from updated as mind dos from" );	
									    						 logger.info("DOSFrom not set as RevEffectiveDatee:" + sDOSFromDate
																			+ " when the combinations moved in target for the HCPCCode:" + key);
																	Assert.assertTrue(
																			"DOSFrom not set as RevEffectiveDate:" + sDOSFromDate
																					+ " when the combinations moved in target for the HCPCCode:" + key,
																			true);
									    					 }		
									    					 
									    					 else
									    					 {
									    					
									    						 logger.error("DOSFrom not set as RevEffectiveDatee:" + sDOSFromDate
																			+ " when the combinations moved in target for the HCPCCode:" + key);
																	Assert.assertTrue(
																			"DOSFrom not set as RevEffectiveDate:" + sDOSFromDate
																					+ " when the combinations moved in target for the HCPCCode:" + key,
																			false);
																	
									    					 }
									    					 
					    		  	                }//end of for
					    		  	     }//end of if
			    		  	         
			    		  	      // DosFromValues = null;
			    		  	    DosFromValues.clear();
					 }//end of jury if
												
								    if (!blDOSFromValuesequal)    //if it is false  & DOS From values of each Jury are different
								    {											
														// If any of the above Review Effective date is different from each  other then REV_EFFECTIVE_DATE from the Master table should be  reflected as DOS_FROM date in Target Table
														sQuery = "Select (Trim(SUBSTR(To_CHAR(" + sEffectiveDateColName + ",'yyyy-mm-dd'),0,10))) from LCD."
																+ sMasterTableName + " where " + sLCDArticleIDColName + "=" + Serenity.sessionVariableCalled("ID")
																+ "  and " + sVersionColName + "=" + iVersionNo;
											
														String sRevEffDate = DBUtils.executeSQLQuery(sQuery);
											
														if (!sRevEffDate.isEmpty()) // if Review effective date is not null
														{
																 Jurs = JuryMap.get(key); // Retrieve the String  	Array stored in  the List
																if (Jurs.size() != 0) {
																	
																	for (j = 0; j < Jurs.size(); j++)
																	{
											
																		sQuery = "Select To_Char(DOS_FROM,'yyyy-mm-dd') from LCD." + sTargetTableName + " where "
																				+ sLCDArticleIDColName + "=" + Serenity.sessionVariableCalled("ID")
																				+ " and HCPC_CODE='" + key + "'" + " and ICD_CODE='" + sNewICDCode + "'"
																				+ " and mcare_juris='" + Jurs.get(j) + "'" + " and " + sVersionColName + "="
																				+ iVersionNo;
											
																		sDOSFromValue = DBUtils.executeSQLQuery(sQuery);
											
																		if (sRevEffDate.compareTo(sDOSFromValue) == 0) {
																			logger.info("DOSFrom set as RevEffectiveDate:" + sDOSFromValue
																					+ " when the combinations moved in target for the HCPCCode:" + key);
																			Assert.assertTrue(
																					"DOSFrom set as RevEffectiveDate" + sDOSFromValue
																							+ " when the combinations moved in target for the HCPCCode:" + key,
																					true);
																		}
											
																		else {
																			logger.info("DOSFrom not set as RevEffectiveDatee:" + sDOSFromDate
																					+ " when the combinations moved in target for the HCPCCode:" + key);
																			Assert.assertTrue(
																					"DOSFrom not set as RevEffectiveDate:" + sDOSFromDate
																							+ " when the combinations moved in target for the HCPCCode:" + key,
																					false);
																		}
											
																	} // End of For loop for Jurs Codes
																} else {
																	logger.info("Jurs codes list size is 0");
																	Assert.assertTrue("Jurs codes list size is 0", false);
																}
														
														}
											
														else                        // If the REV_EFFECTIVE_DATE is Null then LAST_UPDATED from   LCD/Article MASTER table should be reflected as DOS_FROM date in Target Table.
														{
															sQuery = "Select (Trim(SUBSTR(To_CHAR(Last_Updated,'yyyy-mm-dd'),0,10))) from LCD." + sMasterTableName
																	+ " where " + sLCDArticleIDColName + "=" + Serenity.sessionVariableCalled("ID") + "  and "
																	+ sVersionColName + "=" + iVersionNo;
															String sLastUpdateDate = DBUtils.executeSQLQuery(sQuery);
											
															if (!sLastUpdateDate.isEmpty()) {
											
																	Jurs = JuryMap.get(key); // Retrieve the  String Array stored in the List
																	if (Jurs.size() != 0) {
																		
																		for (j = 0; j < Jurs.size(); j++) // Retrieve all  the  Jurisdictions  for each HCPC  Code and  store them in  DOSFromDate  String Array
																		{
											
																			sQuery = "Select TO_Char(DOS_FROM,'yyyy-mm-dd') from LCD." + sTargetTableName
																					+ " where " + sLCDArticleIDColName + "=" + Serenity.sessionVariableCalled("ID")
																					+ " and HCPC_CODE='" + key + "'" + " and ICD_CODE='" + sNewICDCode + "'"
																					+ " and mcare_juris='" + Jurs.get(j) + "'" + " and " + sVersionColName + "="
																					+ iVersionNo;
											
																			String sDOSFromDate2 = DBUtils.executeSQLQuery(sQuery);
											
																			if (sLastUpdateDate.compareTo(sDOSFromDate2) == 0) {
																				logger.info("DOSFrom set as Last_Updated date:" + sDOSFromDate
																						+ " when the combinations moved in target for the HCPCCode:" + key);
																				Assert.assertTrue(
																						"DOSFrom set as Last_Updated  date:" + sDOSFromDate
																								+ " when the combinations moved in target for the HCPCCode:" + key,
																						true);
																			}
											
																			else {
																				logger.info("DOSFrom not set as Last_Updated  open date:" + sDOSFromDate
																						+ " when the combinations moved in target for the HCPCCode:" + key);
																				Assert.assertTrue(
																						"DOSFrom not set as Last_Updated date:" + sDOSFromDate
																								+ " when the combinations moved in target for the HCPCCode:" + key,
																						false);
																			}
											
																		} // end of Juris For loop
																	} // end of jury empty if
																	else {
																		logger.info("Jurs codes list size is 0");
																		Assert.assertTrue("Jurs codes list size is 0", false);
																	}															
															}
											
															else {
																logger.info("Last Updated Date is null in the Master Table");
																Assert.assertTrue("Last Updated Date is null in the Master Table", false);
															}
														}
											
													} // end of if
								    
	          }//end of keys for 	

	
    }//end of Method

@Step
   public void validateRAReviewScreen(String sLCD_Article, String sScenario)
	{
	
	 List<String> HCPCSCodes=new ArrayList<String>();	
	 String sNewICDCode = "";
	 int  iPageItemsCount  = 0;
	String[] sScenarioName;
	String sCode = "";
	 
	//Retrieve HCPCCodes stored in Session variables	
	HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");	
	sNewICDCode =  Serenity.sessionVariableCalled("NewICDCode1");

	  
    //Split the ScenarioName and get the TestData from it provided through Gherkin  
   	sScenarioName  = sScenario.split("-");
   	sScenario   =    sScenarioName[0];
   	sCode =  sScenarioName[1];
	
		switch (sScenario) 
		{

				case "DeleteHCPCCodeW2":		
				
					HCPCSCodes.removeAll(HCPCSCodes);
					HCPCSCodes.add(sCode);  //Validate for newly added code  0291T for version 2			
		
					break;
					
				case "DeleteICDCodeW2":
					
					   sNewICDCode = sCode; 
					
				   break; 	
		
				case "AddNewICDCode":
					   sNewICDCode = sCode; 
		
					break;  
				case "SubAddW3":			
					 
					    sNewICDCode  =sCode;
			
					  break;
					  
				case "RetiredW2":	 		
					sNewICDCode = sCode; 
		
				 break;
				 
				case "SubAddHCPCCodeW3":					
					sCode =  sScenarioName[1];
					int index = HCPCSCodes.indexOf(sCode);
					HCPCSCodes.remove(index);
				break;	

		}
		  
		//Validate whether for each HCPC Code and New manual Code combination is available in Delta Review screen UI	 
			if (!HCPCSCodes.isEmpty()) {

		  				for (int i = 0; i < HCPCSCodes.size(); i++) 
		  				{		
		  					//Enter HCPCS Code
		  					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.RAPage_Input_TextArea, "arg", "CPT/HCPCS Code"),HCPCSCodes.get(i));		
		  					//Enter ICD COde
		  					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.RAPage_Input_TextArea, "arg", "ICD Code"),sNewICDCode);				  					
		  					//Click on Apply Filter
		  					oSeleniumUtils.Click_given_WebElement(oRAPage.ApplyFilter_Btn);		
		  					//Synchronization
		  					oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);					  					
		  						
		  				    //Retrieve Page Items count			 
		  					 try {
		  						iPageItemsCount=oRAPage.retrievePageItemsCount("All Items","SupportTab");
		  					} catch (Exception e) {				  						
		  						e.printStackTrace();
		  					}
		  					 
		  					 //Check whether pageItems count is 1
		  					 if(iPageItemsCount == 1) 
		  					 {
		  						 logger.info("Only one Record is displayed in RA Review workQueue screen  as expected  for HCPC Code :"+ HCPCSCodes.get(i)+ " and new ICD Code :"+sNewICDCode+" ");
		  					    Assert.assertTrue("Only one Record is displayed in RA Review workQueue screen  as expected  for HCPC Code :"+ HCPCSCodes.get(i)+ " and new ICD Code :"+sNewICDCode ,true);	 
		  					 }else{
		  					   logger.error("Multiple records displayed in RA Review workQueue screen for HCPC Code :"+ HCPCSCodes.get(i)+ " and new ICD Code :"+sNewICDCode);
		  					   Assert.assertTrue("Multiple records displayed in RA Review workQueue screen for HCPC Code :"+ HCPCSCodes.get(i)+ " and new ICD Code :"+sNewICDCode ,false);
		  					 }
		  					 
		  					//Click on ClearAll Filters
		  					oSeleniumUtils.Click_given_WebElement(oRAPage.ClearAllFilters_Btn);		
		  					//Synchronization
		  					oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

		  				} // End of For loop
			} 
			
			else {				
				logger.info("No elements were retrieved from query");
				Assert.assertTrue("No elements were retrieved from query", false);
				
			} // End of if		  			
	  
		
	}

  @Step
	public void validateDeltaforMultipleJuries(String sLCD_Article, String sLCDArticleVersion,String sScenario) throws Throwable 
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
    List<String> HCPCSCodes=null;	
	int DBRecordsCount  = 0;
	String[] sScenarioName;
	String sCode = "";
	String sNewHCPCCode = "";
	String sMasterTableName = "";
	String sQuery_DOS="";
	String sColumnName = "";
	String sQuery_ReviewEffectiveDate = "";
	String ReviewEffectiveDate = "";
	String sLCDArticleIDColNameRevEffDate = "";
	String sVersionColNameRevEffDate = "";
	
   	

	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
	  
	  sICDCode  = Serenity.sessionVariableCalled("NewICDCode1");
	  System.out.println(Serenity.sessionVariableCalled("NewICDCode1").toString());
	  sICDGroup = Integer.parseInt(Serenity.sessionVariableCalled("NewICDGroup"));
	  System.out.println(Serenity.sessionVariableCalled("NewICDGroup").toString());
	  HCPCSCodes	  = Serenity.sessionVariableCalled("HCPCCodes");
	  System.out.println(Serenity.sessionVariableCalled("HCPCCodes").toString());
	  String sID  = "";
	  String sDeletedCode = "";
	  
	  //Convert LCD/Article version to Integer	
      iLCDArticleVersion = Integer.parseInt(sLCDArticleVersion);
    	    	  
	  //Assign table names based on whether it is LCD or Article 
   	  if(sLCD_Article.equals("LCD"))
   	  {   	
   		   sLCDArticleIDColName  =  "LCD_ID";	       		     		   
   		   sVersionColName =  "LCD_VERSION";
   		   sDeltaTableName = "LCD_CPT_ICD_SPRT_DELTA";	  
   	  }
   	 else if (sLCD_Article.equals("Article"))
  	  { 	       		 
  		  sLCDArticleIDColName  =  "ART_ID";	       		  		  
  		  sVersionColName =  "ART_VERSION";
  	     sDeltaTableName = "ART_CPT_ICD_SPRT_DELTA";	  
  	  }     
   	  
  	sID =  Serenity.sessionVariableCalled("ID");  	  
   	  
    //Split the ScenarioName and get the TestData from it provided through Gherkin  
   	sScenarioName  = sScenario.split("-");
   	sScenario   =    sScenarioName[0];  	
   	  
   	  switch (sScenario)
   	  {
   	     	  
   	     case "AddNewICDCode":			
   	             sCode =  sScenarioName[1];
		         sICDCode = sCode; 	
	       		break;
	       		
   	      case "DeleteHCPCCodeW2":
   	    	       sCode =  sScenarioName[1];                //New ICD Code
   	    	       sDeletedCode  = sScenarioName[2];    //Deleted HCPC Code
   	    	       sNewHCPCCode  = sScenarioName[3] ;   //New HCPC Code
   	    	  		HCPCSCodes.removeAll(HCPCSCodes);
   	    	  		HCPCSCodes.add(sNewHCPCCode);   	    	  	
   	    	  		
					//DOS To should get Date banded according to the RevEffective date	 for deleted HCPC code for corresponding combinations			
					oManualCodeComb.validateDOSToDateBanding(sCode, sLCD_Article , sDeletedCode,sLCDArticleVersion);		
					
   	    	  break;   	    	  
   	    	  
		   case "DeleteICDCodeW2":
			   sCode =  sScenarioName[1];  //Deleted ICD code
			   sICDCode = sCode; 	
			  	   	    	  
   	    	  break;						   
			   
		   case "RetiredW2":
			   sCode =  sScenarioName[1];
			   sICDCode = sCode; 		   	    	  
    	  break;   			   	    	  
    	  
		   case "SubAddW3":
			   sCode =  sScenarioName[1];
			   sICDCode = sCode; 		   	    	  
    	  break;   	
    	  
		   case "SubAddHCPCCodeW3":	    	
	    	      sCode  = sScenarioName[1];
	    	      sDeletedCode  = sScenarioName[2];
	    	      
					//DOS To should get Date banded according to the RevEffective date	 for deleted HCPC code for corresponding combinations			
					oManualCodeComb.validateDOSToDateBanding(sCode, sLCD_Article , sDeletedCode,sLCDArticleVersion);									   
			   
			break;	
			
		   case "AllNewHCPCCode":			
 	             sCode =  sScenarioName[1];
		         sICDCode = sCode; 	
		         sNewHCPCCode  = sScenarioName[2] ;   //New HCPC Code
		         HCPCSCodes.removeAll(HCPCSCodes);
	    	  	 HCPCSCodes.add(sNewHCPCCode);
		         String sJuries =  sScenarioName[3] ;
		         String juryList[] = sJuries.split(",");
		      
		      if(sLCD_Article.equals("LCD"))
		   	  {   	
		   		   sLCDArticleIDColNameRevEffDate  =  "LCD_ID";	       		     		   
		   		   sVersionColNameRevEffDate =  "LCD_VERSION";
		   		   sMasterTableName = "LCD.LCD_MASTER";	  
		   		   sColumnName = "rev_eff_date";
		   	  }
		   	  else if (sLCD_Article.equals("Article"))
		  	  { 	       		 
		  		  sLCDArticleIDColNameRevEffDate  =  "ARTICLE_ID";	       		  		  
		  		  sVersionColNameRevEffDate =  "ARTICLE_VERSION";
		  	      sMasterTableName = "LCD.ARTICLE_MASTER";
		  	      sColumnName = "article_eff_date";
		  	  } 
		  	sQuery_ReviewEffectiveDate = "Select  (Trim(SUBSTR(To_CHAR("+sColumnName+",'MM/DD/YYYY'),0,10)))  from " + sMasterTableName + " where " + sLCDArticleIDColNameRevEffDate + " ="
								+ Serenity.sessionVariableCalled("ID") + " and "
								+ sVersionColNameRevEffDate + "=" + iLCDArticleVersion;
		  	String reviewEffectiveDate_res = DBUtils.executeSQLQuery(sQuery_ReviewEffectiveDate);
		  	ReviewEffectiveDate = reviewEffectiveDate_res;
			
		  	if(sLCD_Article.equals("Article") && ReviewEffectiveDate.isEmpty())
		  	{
		  		logger.info("Artice or LCD review effective date is empty so fetching last updated date column value from master table");
		  		sColumnName = "last_updated";
		  		sQuery_ReviewEffectiveDate = "Select (Trim(SUBSTR(To_CHAR("+sColumnName+",'MM/DD/YYYY'),0,10)))  from " + sMasterTableName + " where " + sLCDArticleIDColNameRevEffDate + " ="
						+ Serenity.sessionVariableCalled("ID") + " and "
						+ sVersionColNameRevEffDate + "=" + iLCDArticleVersion;
		  		String reviewEffectiveDate_res1 = DBUtils.executeSQLQuery(sQuery_ReviewEffectiveDate);
		  		ReviewEffectiveDate = reviewEffectiveDate_res1;		
		  	}
		  	logger.info("Review effective date from master table is " +ReviewEffectiveDate);
		  	 SimpleDateFormat sdf = new SimpleDateFormat( "MM/dd/yyyy" );
			 java.util.Date dDBExpectedDate = sdf.parse(ReviewEffectiveDate);	
			logger.info("Review effective date in modified format from DB is "+dDBExpectedDate);
		  
			if (!(juryList.length==0)) {
		        for (int k = 0; k < juryList.length; k++)
					{
						// Retrieve the count from DB with combination of new HCPC code, ICD code and jury name
						sQuery = "Select count(*) from LCD." + sDeltaTableName + " where hcpc_code ='" + sNewHCPCCode
								+ "'" + " and mcare_juris ='" + juryList[k]+ "'" + "  and " + sLCDArticleIDColName + " ="
								+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'  and "
								+ sVersionColName + "=" + iLCDArticleVersion;
						DBRecordsCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));							
		
						// Checking if Manual Indicator value updated as expected
						if (DBRecordsCount == 1) {
							logger.info("New HCPC code "+sNewHCPCCode+" is added with manually added ICD code "+sICDCode+" and jury name "+juryList[k]+" in DB");
							Assert.assertTrue("New HCPC code "+sNewHCPCCode+" is added with manually added ICD code "+sICDCode+" and jury name "+juryList[k]+" in DB", true);
						} else {
							logger.info("New HCPC code "+sNewHCPCCode+" is not added with manually added ICD code "+sICDCode+" and jury name "+juryList[k]+" in DB");
							Assert.assertTrue("New HCPC code "+sNewHCPCCode+" is not added with manually added ICD code "+sICDCode+" and jury name "+juryList[k]+" in DB", false);
						}
						
						//validating dosfrom field value for each jury
						sQuery_DOS = "Select (Trim(SUBSTR(To_CHAR(dos_from,'MM/DD/YYYY'),0,10))) from LCD." + sDeltaTableName + " where hcpc_code ='" + sNewHCPCCode
								+ "'" + " and mcare_juris ='" + juryList[k]+ "'" + "  and " + sLCDArticleIDColName + " ="
								+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'  and "
								+ sVersionColName + "=" + iLCDArticleVersion;
						String DOS_res = DBUtils.executeSQLQuery(sQuery_DOS);
						logger.info("Date of Service from column value of master table from DB is "+DOS_res);
						java.util.Date dDBExpectedDate_DOS = sdf.parse(DOS_res);
						logger.info("Date of Service from column value "+DOS_res+" from delta table for the combination of New HCPC code "+sNewHCPCCode+" and ICD code "+sICDCode+" and jury name "+juryList[k]+" in DB");
						 
						 if(dDBExpectedDate_DOS.equals(dDBExpectedDate)){
							 logger.info("Date of service from delta table is "+dDBExpectedDate_DOS+" and review effective date from master table is "+dDBExpectedDate);
							 Assert.assertTrue("Date of Service is same with review effective date validated successfully in DB", true);
						 }
						 else
						 {
							 logger.info("Date of service from delta table is "+dDBExpectedDate_DOS+" and review effective date from master table is "+dDBExpectedDate);
							 Assert.assertTrue("Date of Service is Not same with review effective date in DB", false);
						 }
						 
					}
			} else {
				logger.info("Jury list is empty");
				Assert.assertTrue("Jury list is empty", false);	  
	    	}	
		        
       	   break;
       	   
       	   
		   case "AllNewHCPCCodeAndNewJury":			
	             sCode =  sScenarioName[1];
		         sICDCode = sCode; 	
		         sNewHCPCCode  = sScenarioName[2] ;   //New HCPC Code
		         HCPCSCodes.removeAll(HCPCSCodes);
	    	  	 HCPCSCodes.add(sNewHCPCCode);
		         String sJuries1  =  sScenarioName[3] ;
		       String juryList1[] = sJuries1.split(",");
		       String sDOS_To = sScenarioName[4] ;
		      
		      if(sLCD_Article.equals("LCD"))
		   	  {   	
		   		   sLCDArticleIDColNameRevEffDate  =  "LCD_ID";	       		     		   
		   		   sVersionColNameRevEffDate =  "LCD_VERSION";
		   		   sMasterTableName = "LCD.LCD_MASTER";	  
		   		   sColumnName = "rev_eff_date";
		   	  }
		   	  else if (sLCD_Article.equals("Article"))
		  	  { 	       		 
		  		  sLCDArticleIDColNameRevEffDate  =  "ARTICLE_ID";	       		  		  
		  		  sVersionColNameRevEffDate =  "ARTICLE_VERSION";
		  	      sMasterTableName = "LCD.ARTICLE_MASTER";
		  	      sColumnName = "article_eff_date";
		  	  } 
		  	sQuery_ReviewEffectiveDate = "Select  (Trim(SUBSTR(To_CHAR("+sColumnName+",'MM/DD/YYYY'),0,10)))  from " + sMasterTableName + " where " + sLCDArticleIDColNameRevEffDate + " ="
								+ Serenity.sessionVariableCalled("ID") + " and "
								+ sVersionColNameRevEffDate + "=" + iLCDArticleVersion;
		  	String reviewEffectiveDate_result = DBUtils.executeSQLQuery(sQuery_ReviewEffectiveDate);
		  	ReviewEffectiveDate = reviewEffectiveDate_result;
			
		  	if(sLCD_Article.equals("Article") && ReviewEffectiveDate.isEmpty())
		  	{
		  		logger.info("Artice or LCD review effective date is empty so fetching last updated date column value from master table");
		  		sColumnName = "last_updated";
		  		sQuery_ReviewEffectiveDate = "Select (Trim(SUBSTR(To_CHAR("+sColumnName+",'MM/DD/YYYY'),0,10)))  from " + sMasterTableName + " where " + sLCDArticleIDColNameRevEffDate + " ="
						+ Serenity.sessionVariableCalled("ID") + " and "
						+ sVersionColNameRevEffDate + "=" + iLCDArticleVersion;
		  		String reviewEffectiveDate_res1 = DBUtils.executeSQLQuery(sQuery_ReviewEffectiveDate);
		  		ReviewEffectiveDate = reviewEffectiveDate_res1;		
		  	}
		  	logger.info("Review effective date from master table is " +ReviewEffectiveDate);
		  	 SimpleDateFormat asdf = new SimpleDateFormat( "MM/dd/yyyy" );
			 java.util.Date dDBExpectedDate_result = asdf.parse(ReviewEffectiveDate);	
			logger.info("Review effective date in modified format from DB is "+dDBExpectedDate_result);
		  
			if (!(juryList1.length==0)) {
		        for (int k = 0; k < juryList1.length; k++)
					{
						// Retrieve the count from DB with combination of new HCPC code, ICD code and jury name
						sQuery = "Select count(*) from LCD." + sDeltaTableName + " where hcpc_code ='" + sNewHCPCCode
								+ "'" + " and mcare_juris ='" + juryList1[k]+ "'" + "  and " + sLCDArticleIDColName + " ="
								+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'  and "
								+ sVersionColName + "=" + iLCDArticleVersion + " and MANUAL_10=-1";
						DBRecordsCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));							
		
						if (DBRecordsCount == 1) {
							logger.info("New HCPC code "+sNewHCPCCode+" is added with manually added ICD code "+sICDCode+" and jury name "+juryList1[k]+" in DB");
							Assert.assertTrue("New HCPC code "+sNewHCPCCode+" is added with manually added ICD code "+sICDCode+" and jury name "+juryList1[k]+" in DB", true);
						} else {
							logger.info("New HCPC code "+sNewHCPCCode+" is not added with manually added ICD code "+sICDCode+" and jury name "+juryList1[k]+" in DB");
							Assert.assertTrue("New HCPC code "+sNewHCPCCode+" is not added with manually added ICD code "+sICDCode+" and jury name "+juryList1[k]+" in DB", false);
						}
						
						//validating dosfrom field value for each jury
						sQuery_DOS = "Select (Trim(SUBSTR(To_CHAR(dos_from,'MM/DD/YYYY'),0,10))) from LCD." + sDeltaTableName + " where hcpc_code ='" + sNewHCPCCode
								+ "'" + " and mcare_juris ='" + juryList1[k]+ "'" + "  and " + sLCDArticleIDColName + " ="
								+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'  and "
								+ sVersionColName + "=" + iLCDArticleVersion;
						String DOS_res = DBUtils.executeSQLQuery(sQuery_DOS);
						logger.info("Date of Service from column value of master table from DB is "+DOS_res);
						java.util.Date dDBExpectedDate_DOS = asdf.parse(DOS_res);
						logger.info("Date of Service from column value "+dDBExpectedDate_DOS+" from delta table for the combination of New HCPC code "+sNewHCPCCode+" and ICD code "+sICDCode+" and jury name "+juryList1[k]+" in DB");
						 
						 if(dDBExpectedDate_DOS.equals(dDBExpectedDate_result)){
							 logger.info("Date of service from delta table is "+dDBExpectedDate_DOS+" and review effective date from master table is "+dDBExpectedDate_result);
							 Assert.assertTrue("Date of Service is same with review effective date validated successfully in DB", true);
						 }
						 else
						 {
							 logger.info("Date of service from delta table is "+dDBExpectedDate_DOS+" and review effective date from master table is "+dDBExpectedDate_result);
							 Assert.assertTrue("Date of Service is Not same with review effective date in DB", false);
						 }
						 
						//validating dosTo field value for each jury
							String sQuery_DOSTo = "Select (Trim(SUBSTR(To_CHAR(dos_to,'MM/DD/YYYY'),0,10))) from LCD." + sDeltaTableName + " where hcpc_code ='" + sNewHCPCCode
									+ "'" + " and mcare_juris ='" + juryList1[k]+ "'" + "  and " + sLCDArticleIDColName + " ="
									+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'  and "
									+ sVersionColName + "=" + iLCDArticleVersion;
							String DOSTo_res = DBUtils.executeSQLQuery(sQuery_DOSTo);
							logger.info("Date of Service To column value of master table from DB is "+DOSTo_res);
							//java.util.Date dDBExpectedDate_DOSTo = asdf.parse(DOSTo_res);
							logger.info("Date of Service To column value "+DOSTo_res+" from delta table for the combination of New HCPC code "+sNewHCPCCode+" and ICD code "+sICDCode+" and jury name "+juryList1[k]+" in DB");
							 						
						//Fri Dec 31 00:00:00 IST 9999
							 if(DOSTo_res.equals(sDOS_To)){
								 logger.info("Date of service To from delta table is "+DOSTo_res);
								 Assert.assertTrue("Date of Service To is validated successfully in DB", true);
							 }
							 else
							 {
								 logger.info("Date of service To from delta table is "+DOSTo_res);
								 Assert.assertTrue("Date of Service To is Not validated; in DB", false);
							 }
						 
					}
			} else {
				logger.info("Jury list is empty");
				Assert.assertTrue("Jury list is empty", false);	  
	    	}	
		        
     	   break;
   	   		   	    	  
   	  }  
   	  
   	  		if(!sScenario.equalsIgnoreCase("AllNewHCPCCodeAndNewJury")){
										
				 	// Retrieve DB Count for each HCPC code and new ICD Code
					if (!HCPCSCodes.isEmpty()) {
						for (int k = 0; k < HCPCSCodes.size(); k++)
						{
							// Retrieve the Jurisdiction names for each hcpc code &  store it in List
							sQuery = "Select count(*) from LCD." + sDeltaTableName + " where hcpc_code ='" + HCPCSCodes.get(k)
									+ "'" + " and mcare_juris is not null and " + sLCDArticleIDColName + " ="
									+ Serenity.sessionVariableCalled("ID") + " and ICD10_Code='" + sICDCode + "'  and "
									+ sVersionColName + "=" + iLCDArticleVersion;
							DBRecordsCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));							
			
							// Checking if Manual Indicator value updated as expected
							if (DBRecordsCount == 3) {
								logger.info("Expected no of records displayed in DB");
								Assert.assertTrue("Expected no of records displayed in DB", true);
							} else {
								logger.info("Expected no of records Not displayed in DB");
								Assert.assertTrue("Expected no of  records  Not displayed in DB", false);
							}
						}
					} else {
						logger.info("New code is empty");
						Assert.assertTrue("New code is empty", false);	  
			    	}	
	}
					
}

	 @Step
	public void validateDosToDtBandforAlljuries(String sLCD_Article, String sLCDArticleVersion, String sScenario) throws Exception 
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
	    List<String> HCPCSCodes=null;	
	    String[] sScenarioName = null;
	     String  sCode  = "";
	     String sICDCode = "";
	   	
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
	   	  
	   	   HCPCSCodes	  =   Serenity.sessionVariableCalled("HCPCCodes");
	   	  	   	  
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
	
		 	  
			    //Split the ScenarioName and get the TestData from it provided through Gherkin  
			   	sScenarioName  = sScenario.split("-");
			   	sScenario   =    sScenarioName[0];
			   	sCode =  sScenarioName[1];     //Deleted ICD code in W2
			
			switch (sScenario)   				
			{	
			
			case "DeleteICDCodeW2":			
		   
			  //HCPC codes			 
			  for(int l=0;l<HCPCSCodes.size();l++)
			  {			 
		   	    sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCSCodes.get(l)+"'"+" and mcare_juris is not null and " +sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID");
		   	    Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
		   	    JuryMap.put(HCPCSCodes.get(l), Jurisdictions);
			  }  
			  
			  sICDCode = sCode ;  
			  break;		  
			}
			
		    	//Retrieve all keys from the Map
		        Set<String> keys=JuryMap.keySet();     
			
			// To retrieve the DOS_FROM and DOS_TO values stored in the DB			
		 	 for(String key : keys)  //Navigate through all keys and retrieve the values 
	   		  	  {	  		   		   		  	  
	   		  	     List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
		   		  	  if(Jurs.size()!=0)    
		   		  	   {					   		   		  		     
				    		  	 for (j=0;j<Jurs.size();j++)  //Retrieve all the Dos_From values for each HCPC Code and compare with expected Dos_To date
				    		  	 {	  				

					 				 String sQuery1 = "Select TO_Char(DOS_FROM,'MM/DD/YYYY') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName +"="
					 						 	+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
					 						 	+ " and ICD_CODE='" + sICDCode + "'"+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"="+iVersionNo;
						
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
												+ " and ICD_CODE='" + sICDCode + "'"+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"="+iVersionNo;
										
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
	 
 @Step
   public void validateDosToforNewCode(String sNewCode, String sBaseICDCode, String sLCD_Article) throws Exception 
	{
	 List<String> HCPCCodes = null;  
  	 List<String> Jurisdictions = null;   	
  	 String sDOSFromDate = "";
  	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
    String sTargetTableName = "";
  	 String sMasterTableName = "";
  	 String sLCDArticleIDColName = "";
  	 String sQuery="";
  	 int j=0;	   	
  	String sEffectiveDateColName="";
  	String sVersionColName="";
  	 List<String> DosFromValues =  new ArrayList<String>() ;
     String sDOSFromValue = ""; 
     java.util.Date dDBDOSFromDate = null;
     boolean blDOSFromValuesequal=false;
     String sDOSToValue_BaseCode = "";
     String sDOSToValue_NewCode = "";
     String sDeltaTableName = "";
       	
     //Retrieve the HCPC codes from the session variable    	
  	 HCPCCodes = Serenity.sessionVariableCalled("HCPCCodes"); 	 	     	
  	 
  	  //Assign table names based on whether it is LCD or Article 
	  
//Assign table names based on whether it is LCD or Article 
if(sLCD_Article.equals("LCD"))
{   	
	   sLCDArticleIDColName  =  "LCD_ID";	       		     		   
	   sVersionColName =  "LCD_VERSION";
	   sDeltaTableName = "LCD_CPT_ICD_SPRT_DELTA";	  
}
else if (sLCD_Article.equals("Article"))
{ 	       		 
	  sLCDArticleIDColName  =  "ART_ID";	       		  		  
	  sVersionColName =  "ART_VERSION";
  sDeltaTableName = "ART_CPT_ICD_SPRT_DELTA";	  
}    	  	
	   	  
	if(HCPCCodes.size()!=0) 
	{
	   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
	   	 for(j=0;j<HCPCCodes.size();j++)
	   	 {	 
	   		sQuery = "Select distinct mcare_juris from LCD."+sDeltaTableName+" where hcpc_code ='" +HCPCCodes.get(j)+"'"+" and mcare_juris is not null and "+sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID");
	   	    Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
	   	    JuryMap.put(HCPCCodes.get(j), Jurisdictions);
	   	 }    	    	 
	}
	else
	{
		logger.info("HCPC codes list size is 0");
		Assert.assertTrue("HCPC codes list size is 0",false);	   		
	}
	   	 
	//Retrieve all keys from the Map  --Keys are HCPC codes
     Set<String> keys=JuryMap.keySet();
     

   	//Retrieve dos_to for each HCPC code for all juries  	
 	for(String key : keys)  //Navigate through all keys and retrieve the values 
 	  {
 		    List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List
 				  	
 					if(Jurs.size()!=0)    
 					 {			  	 
 			    		  	 for (j=0;j<Jurs.size();j++)  //Retrieve all the Jurisdictions for each HCPC Code and store them in DOSFromDate String Array
 			    		  	 {		
 			    		  		 
 			    					 sQuery = "Select To_Char(DOS_To,'dd-mm-yyyy') from LCD."+sDeltaTableName+" where "+ sLCDArticleIDColName+"="
 			    							+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
 			    							+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"=1"+ " and ICD10_CODE='" + sBaseICDCode +"'";
 			    					
 				    					      sDOSToValue_BaseCode = DBUtils.executeSQLQuery(sQuery);
 				    					   
 				    					   
 				    					  sQuery = "Select To_Char(DOS_To,'dd-mm-yyyy') from LCD."+sDeltaTableName+" where "+ sLCDArticleIDColName+"="
 		 			    							+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
 		 			    							+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"=+1"+ " and ICD10_CODE='" + sNewCode +"'";
 		 			    					
 		 				    					   sDOSToValue_NewCode = DBUtils.executeSQLQuery(sQuery); 		 				    					   
 		 				    					   
 		 				    					      if (sDOSToValue_BaseCode.compareTo(sDOSToValue_NewCode)==0)
 		 				    					      {
 		 				    					    	  logger.info("DOSTo value is set as :" + sDOSToValue_NewCode + " for the combinations in Delta same as base ICD Code for HCPCCode:" + key+" and Jury :"+Jurs.get(j) );
														  Assert.assertTrue("DOSTo value is set as :" + sDOSToValue_NewCode +" for the combinations in Delta same as base ICD Code for HCPCCode: "+ key+" and Jury :"+Jurs.get(j),true);
 		 				    					      }	  
 		 				    					    
 		 				    					      else
		 				    					      {
		 				    					    	  logger.info("DOSTo value is Not set as :" + sDOSToValue_NewCode + " for the combinations in Delta same as base ICD Code for HCPCCode:" + key+" and Jury :"+Jurs.get(j) );
														  Assert.assertTrue("DOSTo value is Not set as :" + sDOSToValue_NewCode +" for the combinations in Delta same as base ICD Code for HCPCCode: "+ key+" and Jury :"+Jurs.get(j),false);
		 				    					      }	   		 
 		 				    					    	  
 		 				    		} 				    					   
 				    					   
 				    					   
 			    		  	 }
 	  }		 
		 
		
	}

  @Step
   public void validateTargetforMultipleJuries(String sLCD_Article, String sLCDArticleVersion, String sScenario) throws Exception
{

	  int iSupportVal=-2;
	  String sQuery1="";    	   	  	   	  
	  List<String> HCPCSCodes=null;		   
        
   
   	 List<String> Jurisdictions = null;   	   	
   	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>(); 
   	 String sQuery="";
   	 int iDBRowCount = -100;
   	 String sTargetTableName="";
   	 int iLCD_ArtVer = Integer.parseInt(sLCDArticleVersion);
   	String sLCDArtIDColName="";
   	String[] sScenarioName = null;
   	String sCode = "";
   	int ManualIndicatorVal = -2;
   	String sSupportColName = "";

    String sNewICDCode = Serenity.sessionVariableCalled("NewICDCode1");

	 if(sLCD_Article.equals("LCD"))
  	  {   			  		  	 
  		   sLCDArtIDColName  =  "LCD_ID"; 	 
  		   sTargetTableName = "LCD_CPT_ICD_LINKS";  		
  		   sSupportColName =  "SUPPORTS_10";
  	   }
  	  else if (sLCD_Article.equals("Article"))
  	  { 			
  		 sLCDArtIDColName  =  "ARTICLE_ID";  
  		 sTargetTableName = "ARTICLE_CPT_ICD_LINKS";  		 
  		 sSupportColName =  "SUPPORT_10";
  	  }
	
		//Retrieve HCPCCodes stored in Session variables	
		HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");			
	 
	    //Retrieve all Jurisdictions from the DB for each HCPC Code
	   if(HCPCSCodes.size()!=0) 
    	{
	   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
	   	 for(int j=0;j<HCPCSCodes.size();j++)
	   	 {	 
	   		sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCSCodes.get(j)+"'"+" and mcare_juris is not null and " +sLCDArtIDColName+"="+ Serenity.sessionVariableCalled("ID");
	   	    Jurisdictions = DBUtils.executeSQLQueryMultipleRows(sQuery);    	     	   
	   	    JuryMap.put(HCPCSCodes.get(j), Jurisdictions);
	   	 }    	    	 
   	}
   	else
   	{
   		logger.info("HCPC codes list size is 0");
		Assert.assertTrue("HCPC codes list size is 0",false);	   		
   	}  	  		
		//Retrieve all keys from the Map containing Juries
	    Set<String> keys=JuryMap.keySet();	    
	    
	    //Split the ScenarioName and get the TestData from it provided through Gherkin  
	   	sScenarioName  = sScenario.split("-");
	   	sScenario   =    sScenarioName[0];	  
	   
	  switch (sScenario)				      
      {			  
	      case "AddNewICDCodeW2CMS":
	    	  
	      case "AddNewICDCodeW3CMS":
	    	  
	    	  sCode =  sScenarioName[1];
	    	  ManualIndicatorVal  = 0 ;
	    	  iSupportVal = -1;	
			    				
	    		 	 for(String key : keys)  //Navigate through all keys and retrieve the values for Juries
	    	   		  	  {	  		   		   		  	  
	    	   		  	     List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List	 for each Jury	   		   		  	 
	    		   		  	
	    	   		  	     if(Jurs.size()!=0)    
	    		   		  	   {					   		   		  		     
	    				    	  for (int j=0;j<Jurs.size();j++)  //Retrieve the count for each hcpc code  and new manual code combination in Target
	    				    	  { 										
												sQuery1 = "Select count(*) from LCD."+sTargetTableName+" where "+sLCDArtIDColName+"="
														+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
														+ " and ICD_CODE='" + sNewICDCode
														+ "'" + " and mcare_juris='" + Jurs.get(j) + "'"
														+ " and  Manual_10="+ManualIndicatorVal+" and LCD_VERSION="+iLCD_ArtVer+" and "+sSupportColName+" =" + iSupportVal;										
												  					

												iDBRowCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery1));
												
												if (iDBRowCount == 1) 
												{
													Assert.assertTrue("The CodeCombination  for HCPC Code: " + key
															+ " created in Target as expected for  LCD/Article::"
															+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and for NewICDCode::"+sNewICDCode, true);
													
													logger.info("The CodeCombination  for HCPC Code: " + key 
															+ "  created in Target as expected as expected for  LCD/Article::" + 
															 Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode);
												}
					
												else {
													logger.error("The CodeCombination  for HCPC Code: " + key
															+ " not created in Target as expected  for  LCD/Article::"
															+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode);
												
													Assert.assertTrue("The CodeCombination  for HCPC Code: " + key
															+ " not created in Target as expected for LCD/Article::"
															+ Serenity.sessionVariableCalled("ID")+" with Jury::"+ Jurs.get(j)+" and NewICDCode::"+sNewICDCode, false);
												      }	    	  
	    				    		  	  }	//end of Jury for
	    		   		  	   }	//end of Keys for	    	   		  		    	  	
				   } //end of case
		    	  
	       break;
	       
  case "AddNewJuryW2CMS":
	    	  
	    	  String sNewCode =  sScenarioName[1];
	    	  String sNewJury =    sScenarioName[2];
	    	  ManualIndicatorVal  = -1 ;  //Manual Code
	    	  iSupportVal = -1;		//Support Tab
	    	  
	    	  //Check whether W1 manual code added to new Jury (k/A/5) which came from CMS in W2	    	
	    	  for(int k=0;k<HCPCSCodes.size();k++)  //Navigate through all the HCPC Codes  	  
	      	  {	  		   		   		  	  
	   		  	     sQuery1 = "Select count(*) from LCD."+sTargetTableName+" where "+sLCDArtIDColName+"="
												+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + HCPCSCodes.get(k) + "'"
												+ " and ICD_CODE='" + sNewCode
												+ "'" + " and mcare_juris='" +sNewJury+ "'"
												+ " and  Manual_10="+ManualIndicatorVal+" and LCD_VERSION="+iLCD_ArtVer+" and "+sSupportColName+" =" + iSupportVal;	
	   		  	     
										iDBRowCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery1));										
										if (iDBRowCount == 1) 
										{
											Assert.assertTrue("The CodeCombination  for HCPC Code: " +  HCPCSCodes.get(k)
													+ " created in Target as expected for  LCD/Article::"
													+ Serenity.sessionVariableCalled("ID")+" with new Jury from CMS::"+sNewJury+" and for NewICDCode::"+sNewICDCode, true);
											
											logger.info("The CodeCombination  for HCPC Code: " + HCPCSCodes.get(k) 
													+ "  created in Target as expected as expected for  LCD/Article::" + 
													 Serenity.sessionVariableCalled("ID")+"with new Jury from CMS::"+sNewJury+" and NewICDCode::"+sNewICDCode);
										}
			
										else {
											logger.error("The CodeCombination  for HCPC Code: " + HCPCSCodes.get(k)
													+ " not created in Target as expected  for  LCD/Article::"
													+ Serenity.sessionVariableCalled("ID")+" with new Jury from CMS::"+ sNewJury+" and NewICDCode::"+sNewICDCode);
										
											Assert.assertTrue("The CodeCombination  for HCPC Code: " + HCPCSCodes.get(k)
													+ " not created in Target as expected for LCD/Article::"
													+ Serenity.sessionVariableCalled("ID")+" with new Jury from CMS::"+sNewJury+" and NewICDCode::"+sNewICDCode, false);
										      }	    	  
				    		  	 
		   		  	   }	//end of Keys for	    	   		  		    	  	
		          
	    	  break;

	    
	      default:  logger.info("No input is provided for the Switch Case");
          		    Assert.assertTrue("Provided invalid case value",false);				
      }			
			
}

  @Step
   public void updateDecisionsinTargetScreen(String sLCD_Article) 
  {
	
	  //Navigate to Support Tab
	  
	  
	 //Select a Record	  
	 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oTargetScreenPage.sCheckBox, "iRowCount", "1"));
	 
	//Capture HCPC code and ICDCode & decision and store in session variable	 
	String HCPCCode_Support = oSeleniumUtils.get_TextFrom_Locator(oTargetScreenPage.HCPCSCode_CellValue);
	String ICDCode_Support =  oSeleniumUtils.get_TextFrom_Locator(oTargetScreenPage.ICDCode_CellValue);
		
	 Serenity.setSessionVariable("HCPCCode_Support").to(HCPCCode_Support);
	Serenity.setSessionVariable("ICDCode_Support").to(ICDCode_Support);
	 		
	 
	//Take Reject  decision and update the decision
	oSeleniumUtils.Click_given_Locator(oTargetScreenPage.RejectButton);
	      
     //Check whether "Select Reason" drop down  is displayed        
      oSeleniumUtils.is_WebElement_Displayed(oTargetScreenPage.SelectReason_DrpDwn);

	   //Click on Drop down arrow icon	     
	    oSeleniumUtils.Click_given_Locator(oTargetScreenPage.SelectReasonArrowIcon);	   
	    SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
     
	   //Select reason from Drop down
        oSeleniumUtils.Click_given_Locator(StringUtils.replace(oTargetScreenPage.SpanText, "sValue", "Non-configurable-Frequency"));
        
        //Enter comments
        oSeleniumUtils.enter_given_text_StringLocator(oTargetScreenPage.UpdateDecisionReason, "Test123");
        
	   //Click on Apply button
	   oSeleniumUtils.Click_given_Locator(oTargetScreenPage.Apply);
	   oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	    	  
	  		 
	 //Click on Update Decision Button	 
	 oSeleniumUtils.Click_given_Locator(oTargetScreenPage.UpdateDecisionButton);
	 
		String sDecisionUpdtMessage = oSeleniumUtils.get_TextFrom_Locator(oTargetScreenPage.DecisionConfirmation_Message);
		
		if(sDecisionUpdtMessage.contains("Decision updated for the records"))
		{
			 oSeleniumUtils.Click_given_Locator(oTargetScreenPage.DecisionConfirmation_OkBtn);				
		}
		else
		{		
			logger.info("After decision updated::popup message is displayed as ::"+sDecisionUpdtMessage);
			logger.error("Reject Decision Not updated in the DB");
		    Assert.assertTrue("Reject Decision Not updated in the DB", false);			
		}
	
	//Capture Review Decision Value
	 String ReviewDec_Support  =  oSeleniumUtils.get_TextFrom_Locator(oTargetScreenPage.ReviewDecision_CellValue);
	 Serenity.setSessionVariable("ReviewDecision_Support").to(ReviewDec_Support);		  
	  
	//Navigate to DoesNotSupport Tab		
	 oSeleniumUtils.Click_given_Locator(oTargetScreenPage.DoesNotSupportTab);
	 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
	  
	  //Take Accept  decision and update the decision
	  oSeleniumUtils.Click_given_Locator(StringUtils.replace(oTargetScreenPage.sCheckBox, "iRowCount", "1"));
	  oSeleniumUtils.Click_given_Locator(oTargetScreenPage.AcceptButton);	 
      
      //Enter comments
      oSeleniumUtils.enter_given_text_StringLocator(oTargetScreenPage.UpdateDecisionReason, "Test123");
      
	   //Click on Apply button
	   oSeleniumUtils.Click_given_Locator(oTargetScreenPage.Apply);
	   oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	    	  
	  		 
	 //Click on Update Decision Button	 
	 oSeleniumUtils.Click_given_Locator(oTargetScreenPage.UpdateDecisionButton);
	 try{
	 sDecisionUpdtMessage = oSeleniumUtils.get_TextFrom_Locator(oTargetScreenPage.DecisionConfirmation_Message);
	 }
	 catch(Exception e)
	 {
	 }	 
	 
	if(sDecisionUpdtMessage.equalsIgnoreCase("Decision updated for the records"))
	{
		 oSeleniumUtils.Click_given_Locator(oTargetScreenPage.DecisionConfirmation_OkBtn);				
	}
	else
	{		
		logger.info("After decision updated::popup message is displayed as ::"+sDecisionUpdtMessage);
		logger.error("Accept Decision Not updated in the DB");
	    Assert.assertTrue("Accept Decision Not updated in the DB", false);			
	}
  	 
	//Capture HCPC code and ICDCode & decision and store in session variable	 
	String HCPCCode_DntSupport = oSeleniumUtils.get_TextFrom_Locator(oTargetScreenPage.HCPCSCode_CellValue);
	String ICDCode_DntSupport  =  oSeleniumUtils.get_TextFrom_Locator(oTargetScreenPage.ICDCode_CellValue);
	String ReviewDec_DntSupport   =  oSeleniumUtils.get_TextFrom_Locator(oTargetScreenPage.ReviewDecision_CellValue);
	
	Serenity.setSessionVariable("HCPCCode_DntSupport ").to(HCPCCode_DntSupport);
	Serenity.setSessionVariable("ICDCode_DntSupport" ).to(ICDCode_DntSupport);
	Serenity.setSessionVariable("ReviewDec_DntSupport ").to(ReviewDec_DntSupport);	  
	  
  }

@Step  
   public void filterIDinAdminScreen(String sLCDArticle) 
{		
	
	String sID = Serenity.sessionVariableCalled("ID"); 
	
	//String sID ="45116";
	oSeleniumUtils.enter_given_text_StringLocator(oTargetScreenPage.InputColumn, sID);
	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	
	//Click on the ID with status Started
	oAdminPage.AdminStatusDropDown.click();		
    oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
    oAdminPage.StatusStarted.click();
    oAdminPage.AdminStatusDropDown.click();
    
    //Click on the LCD/Article ID
	String TaskID = oAdminPage.FirstReviewTaskID.getText();				
	oAdminPage.FirstReviewTaskID.click();		
	//Wait till the Data loads in the page
    oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	    
    
}

@Step  
public void filterIDinAdminScreen(String sLCDArticle, String sStatus) 
{		
	
	String sID = Serenity.sessionVariableCalled("ID"); 
	oSeleniumUtils.enter_given_text_StringLocator(oTargetScreenPage.InputColumn, sID);
	oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
	
	//Click on the ID with status Started
	oAdminPage.AdminStatusDropDown.click();		
 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
 System.out.println(StringUtils.replace(oAdminPage.Status, "sValue", "2"));
 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oAdminPage.Status, "sValue", sStatus));
 SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
 oAdminPage.AdminStatusDropDown.click();
 
 //Click on the LCD/Article ID
	String TaskID = oAdminPage.FirstReviewTaskID.getText();				
	oAdminPage.FirstReviewTaskID.click();		
	//Wait till the Data loads in the page
 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	    
 
}

@Step
   public void validateUpdatedDecisionsinAdhocReviewScreen(String sLCDArticle) throws Exception
{
	
	
	int iAppropriateVal = -2;
	int iSupportVal = -2;
	 int iDBCount  = 0;  
	
	
	java.util.List<WebElement>  columnList =null;
	
	String ID = Serenity.sessionVariableCalled("ID");
	
      
	//Click on  Adhoc Review Tab
	
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
		
	//Enter the values from the session Variable  for Support Category		
	 String HCPCCode_Support = Serenity.sessionVariableCalled("HCPCCode_Support");
	 String ICDCode_Support =    Serenity.sessionVariableCalled("ICDCode_Support");
	 String ReviewDecision_Support =  Serenity.sessionVariableCalled("ReviewDecision_Support");
    	 String sCategory  = "Support";
	 	
	 columnList = getDriver().findElements(By.xpath(oTargetScreenPage.InputBox));
	  JavascriptExecutor js=(JavascriptExecutor)  getDriver();
      Robot robot = new Robot();
	 
	 try{		 	    
	      
	        //Enter HCPCCode value
		 js.executeScript("arguments[0].scrollIntoView(true);",columnList.get(0));	 
 	      	 columnList.get(0).click();
 		     columnList.get(0).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(0),HCPCCode_Support);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
	         
	         //Enter ICDCode  value
 	      	 columnList.get(3).click();
 		     columnList.get(3).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(3),ICDCode_Support);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);	         
	         
	         //Enter Category  value
 	      	 columnList.get(6).click();
 		     columnList.get(6).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(6),sCategory);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
	         
	         //Enter ReviewDecision  value
	         js.executeScript("arguments[0].scrollIntoView(true);",columnList.get(7));	  
 	      	 columnList.get(7).click();
 		     columnList.get(7).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(7),ReviewDecision_Support);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);       	         
	         
 	 }
 	   catch (Exception e) {
        System.out.println("Element not present");
        System.err.println(e);     
        }
	
	
	
	//Capture the UI count and verify it is 1
	int itemsCount = oAdminPage.retrievePageItemsCount("AllItems","AdhocReviewTab");	
	 if(itemsCount == 1)
	 {		 
			logger.info("items Count is 1");		
		    Assert.assertTrue("items Count is 1", true);				 
	 }
	 else
	 {
		    logger.error("items Count is not 1");		
		    Assert.assertTrue("items Count is 1", false);		 
	 
	 } 
	 
	 if(ReviewDecision_Support.equalsIgnoreCase("Accept"))
	 {
		 iAppropriateVal = -1;
	 }else  if(ReviewDecision_Support.equalsIgnoreCase("Reject"))
	 {
		 iAppropriateVal = 0;		 
	 }
	 
	 if(sCategory.equalsIgnoreCase("Support"))
	 {
		 iSupportVal = -1;
	 }else  if(sCategory.equalsIgnoreCase("Does Not Support"))
	 {
		 iSupportVal = 0;		 
	 }
	 
		
	//Get DB  count and verify  the count is 3 
	 String sQuery = "";
	 
	 int iJusrisidictionCount = 0;  
	String sJuryQuery ="";
		 
	 if(sLCDArticle.equalsIgnoreCase("LCD"))
      {		
		 sQuery  = "Select count(*) from  LCD.LCD_CPT_ICD_LINKS  where lcd_id ="+ID+" and lcd_version=2 and icd_code ="+"'"+ICDCode_Support+"'"+"  and hcpc_code = "+"'"+HCPCCode_Support+"'"+"  and appropriate_10="+iAppropriateVal+" and supports_10="+iSupportVal;
		 iDBCount  =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));
		 sJuryQuery = "Select count(*) from (select distinct  mcare_juris from LCD.LCD_CPT_ICD_LINKS where lcd_id="+ID+" and mcare_juris is not null)";
		 iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
       }
	 else if  (sLCDArticle.equalsIgnoreCase("Article"))
	   {
		 sQuery  = "Select count(*) from  LCD.Article_CPT_ICD_LINKS  where Article_id ="+ID+" and Article_version=2 and icd_code ="+"'"+ICDCode_Support+"'"+"  and hcpc_code = "+"'"+HCPCCode_Support+"'"+"  and appropriate_10="+iAppropriateVal+" and support_10="+iSupportVal;
		 iDBCount  =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
		 sJuryQuery = "Select count(*) from (select distinct  mcare_juris from LCD.Article_CPT_ICD_LINKS where Article_id="+ID+" and mcare_juris is not null)";
		 iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
    	}	 
	 
	 if (iDBCount == iJusrisidictionCount )
	 {
		    logger.info("items Count is 3");		
		    Assert.assertTrue("items Count is 3", true);						 		 
	 }
	 else{
		         logger.error("items Count is not 3");		
		        Assert.assertTrue("items Count is 3", false);		 
	 }
	 

				
	 
	//Enter the values from the session Variable  for DoesNotSupport Category	
	 String HCPCCode_DntSupport = Serenity.sessionVariableCalled("HCPCCode_DntSupport");
	 String ICDCode_DntSupport =    Serenity.sessionVariableCalled("ICDCode_DntSupport");
	 String ReviewDec_DntSupport =  Serenity.sessionVariableCalled("ReviewDec_DntSupport");	
	 sCategory = "Does Not Support";

	
	 if(ReviewDec_DntSupport.equalsIgnoreCase("Accept"))
	 {
		 iAppropriateVal = -1;
	 }else  if(ReviewDec_DntSupport.equalsIgnoreCase("Reject"))
	 {
		 iAppropriateVal = 0;		 
	 }
	
	 if(sCategory.equalsIgnoreCase("Support"))
	 {
		 iSupportVal = -1;
	 }else  if(sCategory.equalsIgnoreCase("Does Not Support"))
	 {
		 iSupportVal = 0;		 
	 }
	
	 
	 try{		 	    
	      
	        //Enter HCPCCode value
	      	 columnList.get(0).click();
		     columnList.get(0).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(0),HCPCCode_DntSupport);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
	         
	         //Enter ICDCode  value
	      	 columnList.get(3).click();
		     columnList.get(3).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(3),ICDCode_DntSupport);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);	         
	         
	         //Enter Category  value
	      	 columnList.get(6).click();
		     columnList.get(6).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(6),sCategory);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
	         
	         //Enter ReviewDecision  value
	         js.executeScript("arguments[0].scrollIntoView(true);",columnList.get(7));	         
	      	 columnList.get(7).click();
		     columnList.get(7).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(7),ReviewDec_DntSupport);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);       	         
	         
	 }
	   catch (Exception e) {
     System.out.println("Element not present");
     System.err.println(e);     
     }
	
	 
	
	//Capture the UI count and verify it is one
	 itemsCount = oAdminPage.retrievePageItemsCount("AllItems","AdhocReviewTab");	
	 if(itemsCount == 1)
	 {		 
			logger.info("items Count is 1");		
		    Assert.assertTrue("items Count is 1", true);				 
	 }
	 else
	 {
		    logger.info("items Count is not 1");		
		    Assert.assertTrue("items Count is 1", false);		 
	 }		

	//Get DB  count and verify  the count is 3 
	 
	 if(sLCDArticle.equalsIgnoreCase("LCD"))
     {		
		 sQuery  = "Select count(*) from  LCD.LCD_CPT_ICD_LINKS  where lcd_id ="+ID+" and lcd_version=2 and icd_code ="+"'"+ICDCode_DntSupport+"'"+"  and hcpc_code = "+"'"+HCPCCode_DntSupport+"'"+"  and appropriate_10="+iAppropriateVal+" and supports_10="+iSupportVal;
		 iDBCount  =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));
		 sJuryQuery = "Select count(*) from (select distinct  mcare_juris from LCD.LCD_CPT_ICD_LINKS where lcd_id="+ID+" and mcare_juris is not null)";
		 iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
      }
	 else if  (sLCDArticle.equalsIgnoreCase("Article"))
	   {
		 sQuery  = "Select count(*) from  LCD.Article_CPT_ICD_LINKS  where Article_id ="+ID+" and Article_version=2 and icd_code ="+"'"+ICDCode_DntSupport+"'"+"  and hcpc_code = "+"'"+HCPCCode_DntSupport+"'"+"  and appropriate_10="+iAppropriateVal+" and support_10="+iSupportVal;
		 iDBCount  =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
		 sJuryQuery = "Select count(*) from (select distinct  mcare_juris from LCD.Article_CPT_ICD_LINKS where Article_id="+ID+" and mcare_juris is not null)";
		 iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
   	}	 
	 
	 if (iDBCount == iJusrisidictionCount )
	 {
		    logger.info("items Count is 3");		
		    Assert.assertTrue("items Count is 3", true);						 		 
	 }
	 else{
		         logger.error("items Count is not 3");		
		        Assert.assertTrue("items Count is 3", false);		 
	 }
	
	

}//end of class

@Step
public void validateUpdatedDecisionsinAdhocReviewScreen(String sLCDArticle, String sCategory, String sLCDArtVersion) throws Exception
{
	
	
	int iAppropriateVal = -2;
	int iSupportVal = -2;
	 int iDBCount  = 0;  
	
	
	java.util.List<WebElement>  columnList =null;
	
	String ID = Serenity.sessionVariableCalled("ID");
	
   
	//Click on  Adhoc Review Tab
	
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
	
	  JavascriptExecutor js=(JavascriptExecutor)  getDriver();
	  Robot robot = new Robot();
	  String sQuery = "";
		 int iJusrisidictionCount = 0;  
		String sJuryQuery ="";
		int itemsCount = 0;
		
	if (sCategory.equalsIgnoreCase("Support")){
		
	//Enter the values from the session Variable  for Support Category		
	 String HCPCCode_Support = Serenity.sessionVariableCalled("HCPCCode_Support");
    	 System.out.println(Serenity.sessionVariableCalled("HCPCCode_Support").toString());
	 String ICDCode_Support =    Serenity.sessionVariableCalled("ICDCode_Support");
	 System.out.println(Serenity.sessionVariableCalled("ICDCode_Support").toString());
	 String ReviewDecision_Support =  Serenity.sessionVariableCalled("ReviewDecision_Support");
	 System.out.println(Serenity.sessionVariableCalled("ReviewDecision_Support").toString());
 	
	 	
	 columnList = getDriver().findElements(By.xpath(oTargetScreenPage.InputBox));
	
   
	 
	 try{		 	    
	      
	        //Enter HCPCCode value
    		 js.executeScript("arguments[0].scrollIntoView(true);",columnList.get(0));	 
	      	 columnList.get(0).click();
		     columnList.get(0).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(0),HCPCCode_Support);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
	         
	         //Enter ICDCode  value
	      	 columnList.get(3).click();
		     columnList.get(3).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(3),ICDCode_Support);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);	         
	         
	         //Enter Category  value
	      	 columnList.get(6).click();
		     columnList.get(6).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(6),sCategory);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
	         
	         //Enter ReviewDecision  value
	         js.executeScript("arguments[0].scrollIntoView(true);",columnList.get(7));	  
	      	 columnList.get(7).click();
		     columnList.get(7).clear();
	         Thread.sleep(1000);	         	  
	         js.executeScript("arguments[0].value=arguments[1];", columnList.get(7),ReviewDecision_Support);	           
	         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);       	         
	         
	 }
	   catch (Exception e) {
     System.out.println("Element not present");
     System.err.println(e);     
     }
	
	
	
	//Capture the UI count and verify it is 1
	 itemsCount = oAdminPage.retrievePageItemsCount("AllItems","AdhocReviewTab");	
	 if(itemsCount == 1)
	 {		 
			logger.info("items Count is 1");		
		    Assert.assertTrue("items Count is 1", true);				 
	 }
	 else
	 {
		    logger.error("items Count is not 1");		
		    Assert.assertTrue("items Count is 1", false);		 
	 
	 } 
	 
	 if(ReviewDecision_Support.equalsIgnoreCase("Accept"))
	 {
		 iAppropriateVal = -1;
	 }else  if(ReviewDecision_Support.equalsIgnoreCase("Reject"))
	 {
		 iAppropriateVal = 0;		 
	 }
	 
	 if(sCategory.equalsIgnoreCase("Support"))
	 {
		 iSupportVal = -1;
	 }else  if(sCategory.equalsIgnoreCase("Does Not Support"))
	 {
		 iSupportVal = 0;		 
	 }
	 
		
	//Get DB  count and verify  the count is 3 
	
	
		 
	 if(sLCDArticle.equalsIgnoreCase("LCD"))
   {		
		 sQuery  = "Select count(*) from  LCD.LCD_CPT_ICD_LINKS  where lcd_id ="+ID+" and lcd_version="+"'"+sLCDArtVersion+"'"+" and icd_code ="+"'"+ICDCode_Support+"'"+"  and hcpc_code = "+"'"+HCPCCode_Support+"'"+"  and appropriate_10="+iAppropriateVal+" and supports_10="+iSupportVal;
		 iDBCount  =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));
		 sJuryQuery = "Select count(*) from (select distinct  mcare_juris from LCD.LCD_CPT_ICD_LINKS where lcd_id="+ID+" and mcare_juris is not null)";
		 iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
    }
	 else if  (sLCDArticle.equalsIgnoreCase("Article"))
	   {
		 sQuery  = "Select count(*) from  LCD.Article_CPT_ICD_LINKS  where Article_id ="+ID+" and Article_version="+"'"+sLCDArtVersion+"'"+" and icd_code ="+"'"+ICDCode_Support+"'"+"  and hcpc_code = "+"'"+HCPCCode_Support+"'"+"  and appropriate_10="+iAppropriateVal+" and support_10="+iSupportVal;
		 iDBCount  =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
		 sJuryQuery = "Select count(*) from (select distinct  mcare_juris from LCD.Article_CPT_ICD_LINKS where Article_id="+ID+" and mcare_juris is not null)";
		 iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
 	}	 
	 
	 if (iDBCount == iJusrisidictionCount )
	 {
		    logger.info("items Count is 3");		
		    Assert.assertTrue("items Count is 3", true);						 		 
	 }
	 else{
		         logger.error("items Count is not 3");		
		        Assert.assertTrue("items Count is 3", false);		 
	 }
	}
	else{
		 
		//Enter the values from the session Variable  for DoesNotSupport Category	
		 String HCPCCode_DntSupport = Serenity.sessionVariableCalled("HCPCCode_DntSupport");
		 String ICDCode_DntSupport =    Serenity.sessionVariableCalled("ICDCode_DntSupport");
		 String ReviewDec_DntSupport =  Serenity.sessionVariableCalled("ReviewDec_DntSupport");	
		 sCategory = "Does Not Support";

		
		 if(ReviewDec_DntSupport.equalsIgnoreCase("Accept"))
		 {
			 iAppropriateVal = -1;
		 }else  if(ReviewDec_DntSupport.equalsIgnoreCase("Reject"))
		 {
			 iAppropriateVal = 0;		 
		 }
		
		 if(sCategory.equalsIgnoreCase("Support"))
		 {
			 iSupportVal = -1;
		 }else  if(sCategory.equalsIgnoreCase("Does Not Support"))
		 {
			 iSupportVal = 0;		 
		 }
		
		 
		 try{		 	    
		      
		        //Enter HCPCCode value
		      	 columnList.get(0).click();
			     columnList.get(0).clear();
		         Thread.sleep(1000);	         	  
		         js.executeScript("arguments[0].value=arguments[1];", columnList.get(0),HCPCCode_DntSupport);	           
		         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
		         
		         //Enter ICDCode  value
		      	 columnList.get(3).click();
			     columnList.get(3).clear();
		         Thread.sleep(1000);	         	  
		         js.executeScript("arguments[0].value=arguments[1];", columnList.get(3),ICDCode_DntSupport);	           
		         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);	         
		         
		         //Enter Category  value
		      	 columnList.get(6).click();
			     columnList.get(6).clear();
		         Thread.sleep(1000);	         	  
		         js.executeScript("arguments[0].value=arguments[1];", columnList.get(6),sCategory);	           
		         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
		         
		         //Enter ReviewDecision  value
		         js.executeScript("arguments[0].scrollIntoView(true);",columnList.get(7));	         
		      	 columnList.get(7).click();
			     columnList.get(7).clear();
		         Thread.sleep(1000);	         	  
		         js.executeScript("arguments[0].value=arguments[1];", columnList.get(7),ReviewDec_DntSupport);	           
		         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);       	         
		         
		 }
		   catch (Exception e) {
	     System.out.println("Element not present");
	     System.err.println(e);     
	     }
		
		 
		
		//Capture the UI count and verify it is one
		 itemsCount = oAdminPage.retrievePageItemsCount("AllItems","AdhocReviewTab");	
		 if(itemsCount == 1)
		 {		 
				logger.info("items Count is 1");		
			    Assert.assertTrue("items Count is 1", true);				 
		 }
		 else
		 {
			    logger.info("items Count is not 1");		
			    Assert.assertTrue("items Count is 1", false);		 
		 }		

		//Get DB  count and verify  the count is 3 
		 
		 if(sLCDArticle.equalsIgnoreCase("LCD"))
	     {		
			 sQuery  = "Select count(*) from  LCD.LCD_CPT_ICD_LINKS  where lcd_id ="+ID+" and lcd_version="+"'"+sLCDArtVersion+"'"+" and icd_code ="+"'"+ICDCode_DntSupport+"'"+"  and hcpc_code = "+"'"+HCPCCode_DntSupport+"'"+"  and appropriate_10="+iAppropriateVal+" and supports_10="+iSupportVal;
			 iDBCount  =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));
			 sJuryQuery = "Select count(*) from (select distinct  mcare_juris from LCD.LCD_CPT_ICD_LINKS where lcd_id="+ID+" and mcare_juris is not null)";
			 iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
	      }
		 else if  (sLCDArticle.equalsIgnoreCase("Article"))
		   {
			 sQuery  = "Select count(*) from  LCD.Article_CPT_ICD_LINKS  where Article_id ="+ID+" and Article_version="+"'"+sLCDArtVersion+"'"+" and icd_code ="+"'"+ICDCode_DntSupport+"'"+"  and hcpc_code = "+"'"+HCPCCode_DntSupport+"'"+"  and appropriate_10="+iAppropriateVal+" and support_10="+iSupportVal;
			 iDBCount  =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
			 sJuryQuery = "Select count(*) from (select distinct  mcare_juris from LCD.Article_CPT_ICD_LINKS where Article_id="+ID+" and mcare_juris is not null)";
			 iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));	
	   	}	 
		 
		 if (iDBCount == iJusrisidictionCount )
		 {
			    logger.info("items Count is 3");		
			    Assert.assertTrue("items Count is 3", true);						 		 
		 }
		 else{
			         logger.error("items Count is not 3");		
			        Assert.assertTrue("items Count is 3", false);		 
		 }
		
		
	}
		
	}
}
	

