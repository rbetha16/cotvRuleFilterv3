package project.feature.steps.definitions;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.pageobjects.AdminPage;
import project.pageobjects.HomePage;
import project.pageobjects.LoginPage;
import project.pageobjects.RAReviewWorkQueuePage;
import project.utilities.DBQueries;
import project.utilities.DBUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;

public class CreateProposalStepDef extends ScenarioSteps {

	private static final long serialVersionUID = 5898280540796957114L;

	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateProposalStepDef.class);

	LoginPage ologinPage;
	HomePage oHomePage;
	SeleniumUtils oSeleniumUtils;
	DBQueries oDBQueries;
	RAReviewWorkQueuePage  oRAPage;
	AdminPage oAdminPage;
		
	@Step
	public void loginCPTICDLink(String sUserName) {
		ologinPage.open();
		logger.info("JBPM Home page opened successfully");
		Assert.assertTrue("JBPM Home page should be dispalyed.", ologinPage.loginToCPTICDLink(sUserName));
	}
	
	@Step
	public void clickOnCPTICDLink() {
		Assert.assertTrue("CPTICDLink Home page should be dispalyed.",oHomePage.NavigateToCPTICDLink());		
	}

	@Step
	public void validateGroupIndividualTabs() {	    
	   	    
	    oSeleniumUtils.switchToPage(SeleniumUtils.class);   
	  
		Assert.assertTrue("Individual Task Page should be displayed.",oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oHomePage.AnchorTags, "sValue", "Individual")));
		
		Assert.assertTrue("Group Task Page should be displayed.",oSeleniumUtils.is_WebElement_Displayed(StringUtils.replace(oHomePage.AnchorTags, "sValue", "Group")));
		 
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue", "Group"));
		
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);  
		
	}

    @Step
    public void claimIDFromtheGroupTasks(String LCD_Article) throws InterruptedException {
		
    	String ID="";
    	
		if (LCD_Article.equalsIgnoreCase("LCD"))	
		{
			ID= DBUtils.executeSQLQuery(DBQueries.LCD_ID_Query);
		}
		else if  (LCD_Article.equalsIgnoreCase("Article"))
		{	  
			ID=DBUtils.executeSQLQuery(DBQueries.ArticleQuery);
			System.out.println(ID);
		}	
		
		//Click on ClaimTaskButton
		oSeleniumUtils.Click_given_WebElement(oHomePage.ClaimTask_Btn);	
    }

    @Step
	public void userLogsout() {
		ologinPage.signoutCPTICDLink();
	}
    
    @Step
	public void ra_clicks_on_Task_Tab(String sTabName) 
    {    	
    	if(sTabName.equalsIgnoreCase("Support")||(sTabName.equalsIgnoreCase("Does"))){
    		Serenity.setSessionVariable("TabName").to(sTabName);
    		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue",sTabName));
    		 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);       
    		 }
    	        	  
    	 // getDriver().findElement(By.xpath(StringUtils.replace(oHomePage.AnchorTags, "sValue",sTabName))).click();  	   
    	  
    	       if(sTabName.equalsIgnoreCase("Individual"))
    	    	{
    	    	   getDriver().findElement(By.xpath(oHomePage.IndividualTaskTab)).click();    	
    	       		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
    	    	}
    	       else  if(sTabName.equalsIgnoreCase("Group"))
    	       {
    	    	   getDriver().findElement(By.xpath(oHomePage.GroupTaskTab)).click();    	
   	       		   oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);    	    	   
    	       }
    	       else{
    	     	     oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue",sTabName));    
    	     	     oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);  
    	            }
    	       	logger.info("Clicked on the Tab:"+sTabName);
	    }
    
    @Step
	public void RA_User_Able_to_Filter_In_GroupTask_Screen(String sTaskTblColName,String sLCD_OR_Article) {
    	
    	String sFilterValue = "";
    	oSeleniumUtils.switchToPage(SeleniumUtils.class);
		
    	if(sTaskTblColName.contains("and")){
    		List<String> sTaskTblColNameList = Arrays.asList(sTaskTblColName.split("and"));
    		
    		for (int i = 0; i < sTaskTblColNameList.size(); i++) {
				
    			switch(sTaskTblColNameList.get(i)){
    			
    				case "ID": 
    					 getTaskTableFilterValue_FromDB(sLCD_OR_Article,"ID");    					
    					 break;    					  
    				case "Title":
    					 getTaskTableFilterValue_FromDB(sLCD_OR_Article,"Title");
    					 break;    					  
    				case "Code Combination Count":    					 
    					 sFilterValue = getTaskTableFilterValue_FromDB(sLCD_OR_Article,"CodeCombinationCount");
    					 System.out.println(sFilterValue);
    					 break;  					     					
    				case "Task Assigned Week":
    					break;
    				case "LCD/Article":    					   					
    					oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.CPTICDLinkTaskTblColumnTxt,"sValue","LCD/Article"));
    					oSeleniumUtils.Click_given_Locator(oHomePage.LCDCheckBox);    					
    					oSeleniumUtils.is_WebElement_Displayed("LCD");  
    					
    					oSeleniumUtils.Click_given_Locator(oHomePage.LCDCheckBox); 
    					oSeleniumUtils.Click_given_Locator(oHomePage.ArticleCheckBox);
    					oSeleniumUtils.is_WebElement_Displayed("Article");     					
    				    break;   
    				    
    				   default:  logger.info("No input is provided for the Switch Case"); 
    			}
			}
    		
    	}//end of If
    	else
    	{	    		
	    		switch(sTaskTblColName)
	    		{
				
				case "ID": 
					 getTaskTableFilterValue_FromDB(sLCD_OR_Article,"ID");    					
					 break;    					  
				case "Title":
					 getTaskTableFilterValue_FromDB(sLCD_OR_Article,"Title");
					 break;    					  
				case "Code Combination Count":    					 
					 sFilterValue = getTaskTableFilterValue_FromDB(sLCD_OR_Article,"CodeCombinationCount");
					 System.out.println(sFilterValue);
					 break;  					     					
				case "Task Assigned Week":
					break;
				case "LCD/Article":    					   					
					oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.CPTICDLinkTaskTblColumnTxt,"sValue","LCD/Article"));
					oSeleniumUtils.Click_given_Locator(oHomePage.LCDCheckBox);    					
					oSeleniumUtils.is_WebElement_Displayed("LCD");  
					
					oSeleniumUtils.Click_given_Locator(oHomePage.LCDCheckBox); 
					oSeleniumUtils.Click_given_Locator(oHomePage.ArticleCheckBox);
					oSeleniumUtils.is_WebElement_Displayed("Article");     					
				    break;   
				    
				   default:  logger.info("No input is provided for the Switch Case"); 
			    }
	    		
    	   }
		
	}
        
    @Step
	private String getTaskTableFilterValue_FromDB(String sLCD_OR_Article, String sTaskTblColName) {
		
    	 String sColName="";    	
    	 String sQuery="";
    	 
    	
    	switch(sLCD_OR_Article){    	
			case "LCD":
				 sColName = "LCD_"+sTaskTblColName;
				 sQuery = "Select * from (Select sColName from (Select sColName from LCD.LCD_REVIEW_TASK where  sColName like '85%' and\r\n" + 
						"task_status_key=1 and user_id is null and sColName NOT in(Select sColName from LCD.LCD_REVIEW_TASK GROUP BY\r\n" + 
						"sColName HAVING COUNT(sColName) > 1 ))) where rownum=1";
				sQuery = sQuery.replace("sColName", sColName);				
				break;			
			case "Article":
				 sColName = "Article_"+sTaskTblColName;
				 sQuery = "Select * from (Select sColName from (Select sColName from LCD.ART_REVIEW_TASK where  sColName like '95%' and\r\n" + 
							"task_status_key=1 and user_id is null and sColName NOT in(Select sColName from LCD.ART_REVIEW_TASK GROUP BY\r\n" + 
							"sColName HAVING COUNT(sColName) > 1 ))) where rownum=1";	
				 break;	
				 
			 default:  logger.info("No input is provided for the Switch Case"); 	 
		}  
    	
		return null;
	}

    @Step
	public void clickOnAdminTab() {
		
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText,"sValue","Administration"));	
		oHomePage.CPTICDLinkAdmin.click();
					
		}
         
    @Step
	public void validateAcceptRejectButtons(String arg1,String arg2) {
		
		 boolean result;	
		 String sButton= arg1;
		 
		result = oRAPage.validateAcceptRejectButtons(arg1,arg2);
		Assert.assertTrue(sButton+"Button Status",result);
	}
    
    @Step
	public void validateButtons(String arg1) {
		
		  String sButton= arg1;
		 
		  if(sButton.equalsIgnoreCase("Accept"))
		  {		
			Assert.assertTrue("Accept Button Status",!oRAPage.Accept_Btn.isEnabled());
		  }
		  else if (sButton.equalsIgnoreCase("Reject"))
		  {
			  Assert.assertTrue("Reject Button Status",oRAPage.Reject_Btn.isEnabled());		  
		  }
	  }
    
    @Step
	public void selectCodeCombinationinTab(String arg1) {
		 	  	  
		  oRAPage.selectCodeCombinations(arg1);
		
	}
	
    @Step
	public void deSelectCodeCombinationinTab(String arg1) {
		oRAPage.deSelectCodeCombinations(arg1);
		
	}
	
    @Step
	public void retrieveItemsCount() {
		
		try {
			 int count=oRAPage.retrievePageItemsCount("","SupportTab");
			 Serenity.setSessionVariable("SupportTabItemsCount").to(count);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
		try {
			 int count2= oRAPage.retrievePageItemsCount("","DoesNotSupportTab");
			 Serenity.setSessionVariable("DoesNotSupportTabItemsCount").to(count2);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
	}
	
    @Step
	public void compareUIandDBitemsCount(String arg1) {
		
		boolean bcompareCount;		
		bcompareCount = oRAPage.compareUIandDBitemsCount(arg1);
		Assert.assertTrue("UI and DB count match",bcompareCount);		
	}
	
    @Step
	public void loginCPTICDLinkSmokeTest(String arg1) {				
		Assert.assertTrue("JBPM Home page should be dispalyed.", ologinPage.loginToCPTICDLinkSmokeTest(arg1));
	}
	
    @Step
    public void validateReviewDecision(String arg1) {
		oRAPage.validateReviewDecision(arg1);
		
	}
    
    @Step
	public void applyFilterOnCPTHCPCSCodeGroup(String arg1) {
		oRAPage.applyFilterOnCPTGroup(arg1);
	}	  
    
    @Step
	public void ra_Clicks_the_id(String sLCD_OR_Article) {
		
		oSeleniumUtils.Click_given_WebElement(oHomePage.LCDArticleDropdown);
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.SpanText,"sValue",sLCD_OR_Article));
		oSeleniumUtils.Click_given_WebElement(oHomePage.LCDArticleDropdown);		
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);		
	}

	public void compareUIandDBitemCount(String sTabName, String sLCD_Article) {
					
		int UICount = 0;
		int DBCount = 0;
		String sSupportTabCodeCombDBCountQry="";
		String sDoesNotSupportTabCodeCombDBCountQry=""; 	
		int DBItemsCount=0;
				
	switch (sLCD_Article) 
	{		
	
	case "LCD":
			if (sTabName.equalsIgnoreCase("SupportTab")) {			
				
				sSupportTabCodeCombDBCountQry =  "Select count(*) from (Select * from LCD.LCD_CPT_ICD_SPRT_DELTA where LCD_ID="+Serenity.sessionVariableCalled("LCD_ID")+")";
				int sSupportTabCodeCombDBCount =    Integer.parseInt(DBUtils.executeSQLQuery(sSupportTabCodeCombDBCountQry));
				
				//Access the Support count stored in Session variable
				UICount = Serenity.sessionVariableCalled("SupportTabItemsCount");				
									 
				//Capture Jurisdictions count for the LCDID
				String sQuery = "Select count(*) from (select distinct  mcare_juris from LCD.LCD_CPT_ICD_SPRT_DELTA where lcd_id="+Serenity.sessionVariableCalled("LCD_ID")+" and mcare_juris is not null)";
				int iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));
													 
				//Divide the DB count by  Jurisdiction count  as in DB  for each Jurisdiction the HCPC code values are replicated,but in UI only single set of data is shown 
				DBItemsCount =  Math.abs((sSupportTabCodeCombDBCount/iJusrisidictionCount));			
				System.out.println("After division by Jurisdictions,DB Count: "+DBItemsCount); 								  
	
				//Compare the count of UI and DB	
				if (UICount == DBItemsCount)
				{
					System.out.println("Support Tab DB and UI count matched");					
					Assert.assertTrue("Support Tab DB and UI count matched", true);
				}else {  					
					Assert.assertTrue("Support Tab DB and UI count not matched", false);
					}
	
			} else if (sTabName.equalsIgnoreCase("DoesNotSupportTab")) {
				
				sDoesNotSupportTabCodeCombDBCountQry="Select count(*) from (Select * from LCD.LCD_CPT_ICD_DONTSPRT_DELTA where LCD_ID="+Serenity.sessionVariableCalled("LCD_ID")+")";
				
				//Access the DoesNotSupport count stored in Session variable
				UICount = Serenity.sessionVariableCalled("DoesNotSupportTabItemsCount");
	
				//Retrieve the count from query for Support Tab
				DBCount = Integer.parseInt(DBUtils.executeSQLQuery(sDoesNotSupportTabCodeCombDBCountQry));
	
				//Compare the count of UI and DB
				if (UICount == DBCount) {
					System.out.println("DoesNotSupport Tab DB and UI count matched");
				
					Assert.assertTrue("DoesNot Support Tab DB and UI count matched", true);
				}else {  
				     Assert.assertTrue("DoesNot Support Tab DB and UI count not matched", false);
				    }
	
			} 
			
		 break;	

	case "Article":
		
			if (sTabName.equalsIgnoreCase("SupportTab")) {			
				
				sSupportTabCodeCombDBCountQry =  "Select count(*) from (Select * from LCD.ART_CPT_ICD_SPRT_DELTA where ART_ID="+Serenity.sessionVariableCalled("Article_ID")+")";
				int sSupportTabCodeCombDBCount =    Integer.parseInt(DBUtils.executeSQLQuery(sSupportTabCodeCombDBCountQry));
				
				//Access the Support count stored in Session variable
				UICount = Serenity.sessionVariableCalled("SupportTabItemsCount");			
						 
				//Capture Jurisdictions count for the LCDID
				String sQuery = "Select count(*) from (select distinct  mcare_juris from LCD.ART_CPT_ICD_SPRT_DELTA where ART_ID="+Serenity.sessionVariableCalled("Article_ID")+" and mcare_juris is not null)";
				int iJusrisidictionCount =    Integer.parseInt(DBUtils.executeSQLQuery(sQuery));
													 
				//Divide the DB count by  Jurisdiction count  as in DB  for each Jurisdiction the HCPC code values are replicated,but in UI only single set of data is shown 
				DBItemsCount =  Math.abs((sSupportTabCodeCombDBCount/iJusrisidictionCount));			
				System.out.println("After division by Jurisdictions,DB Count: "+DBItemsCount); 
	
				//Compare the count of UI and DB	
				if (UICount == DBItemsCount)
				{
					System.out.println("Support Tab DB and UI count matched");					
					Assert.assertTrue("Support Tab DB and UI count matched", true);
				}else { 			 
						Assert.assertTrue("Support Tab DB and UI count not matched", false);
				      }
	
			} else if (sTabName.equalsIgnoreCase("DoesNotSupportTab")) {
				
				sDoesNotSupportTabCodeCombDBCountQry="Select count(*) from (Select * from LCD.ART_CPT_ICD_DONTSPRT_DELTA where ART_ID="+Serenity.sessionVariableCalled("Article_ID")+")";
				
				//Access the DoesNotSupport count stored in Session variable
				UICount = Serenity.sessionVariableCalled("DoesNotSupportTabItemsCount");
	
				//Retrieve the count from query for Support Tab
				DBCount = Integer.parseInt(DBUtils.executeSQLQuery(sDoesNotSupportTabCodeCombDBCountQry));
	
				//Compare the count of UI and DB
				if (UICount == DBCount) {
					System.out.println("DoesNotSupport Tab DB and UI count matched");
					
					Assert.assertTrue("DoesNotSupport Tab DB and UI count matched", true);
				}else { 				
				         Assert.assertTrue("DoesNotSupport Tab DB and UI count not matched", false);
				        }	
			}			
		 break;	  
			
	}		
		
		
		
	}          
	
}     
	
	
	
		
	
	
	
	
	



