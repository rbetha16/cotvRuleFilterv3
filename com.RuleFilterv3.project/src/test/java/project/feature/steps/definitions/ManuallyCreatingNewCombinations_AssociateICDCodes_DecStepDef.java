
package project.feature.steps.definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.google.common.base.CharMatcher;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.pageobjects.AdminPage;
import project.pageobjects.HomePage;
import project.pageobjects.LoginPage;
import project.pageobjects.RAReviewWorkQueuePage;
import project.utilities.DBUtils;
import project.utilities.SeleniumUtils;

public class ManuallyCreatingNewCombinations_AssociateICDCodes_DecStepDef extends ScenarioSteps 
{

	private static final long serialVersionUID = 5898280540796957114L;
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ManuallyCreatingNewCombinations_AssociateICDCodes_DecStepDef.class);
	
	LoginPage ologinPage;
	HomePage oHomePage;
	SeleniumUtils oSeleniumUtils;
	RAReviewWorkQueuePage  oRAPage;
	AdminPage oAdminPage;
	
	 @Step
	public void validateManualTextforCombination(String sText, String sTabName, String sLCD_Article,String sCodeComboType,String sNewHCPCCode) throws Exception {

		
		String sTableName="";
		String sQuery="";
		String sICDCode="";
		String sNewICDCode="";
		List<String>  HCPCSCodes = new ArrayList<String>() ;
		
	
			
			if (sTabName.equalsIgnoreCase("Support"))
			{
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue", "Support"));
				sTableName = "CPT_ICD_SPRT_DELTA";

			} else {
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue", "Does"));
				oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				sTableName = "CPT_ICD_DONTSPRT_DELTA";
			}
	
		
			switch (sCodeComboType) {

			case "Associated":

				sNewICDCode = Serenity.sessionVariableCalled("NewICDCode");

				if (sTabName.equalsIgnoreCase("Support")) {
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

				break;

			case "ManuallyManintained":
				sNewICDCode = Serenity.sessionVariableCalled("NewICDCode");
				HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");
				break;

			default:   logger.error("No input provided for Switch case");

			}
			
			//If the new HCPC Code is added in the 2nd week for the scenario (US41024 : TC13773),then new manually added ICDCode to be validated with the new HCPCCode 
			if(!sNewHCPCCode.isEmpty())
			{			
				if (HCPCSCodes!=null)
			{
			   HCPCSCodes.clear();                              //Clear the ArrayList
			}else{
				
				HCPCSCodes = new ArrayList<String>();
			   HCPCSCodes.add(0, sNewHCPCCode);	//Add new HCPC Code to the ArrayList					
			}			
			
			
		//Validate whether for each HCPC Code and New manual Code combination is available in Delta Review screen UI	 
			if (!HCPCSCodes.isEmpty()) {

				for (int i = 0; i < HCPCSCodes.size(); i++) {

					//Enter HCPCS Code
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.RAPage_Input_TextArea, "arg", "CPT/HCPCS Code"),HCPCSCodes.get(i));

					//Enter ICD COde
					oSeleniumUtils.enter_given_text_StringLocator(StringUtils.replace(oRAPage.RAPage_Input_TextArea, "arg", "ICD Code"),sNewICDCode);
					
					//Click on Apply Filter
					oSeleniumUtils.Click_given_WebElement(oRAPage.ApplyFilter_Btn);

					//Synchronization
					oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
					
					String SCombinationText = oSeleniumUtils.get_TextFrom_Locator(oRAPage.RAPageCombinationType_Text);

					// Check whether pageItems count is 0
					if (SCombinationText.equalsIgnoreCase("Manual"))
					{

						logger.info("Manual text is displayed");
						Assert.assertTrue("Manual text is displayed",true);
					} else {
						logger.info("Manual text is not displayed");
						Assert.assertTrue("Manual text is not displayed",false);
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
		} // End of Method	

	@Step
	public void validateRevEffectiveDateDOSFrom(String sNewICDCode, String sLCD_Article, String sVersionNo) throws Exception
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
	   	int iVersionNo=  Integer.parseInt(sVersionNo);
	   	
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
	   	   }
	   	  else if (sLCD_Article.equals("Article"))
	   	  { 
	   		  sTargetTableName = "ARTICLE_CPT_ICD_LINKS";   
	   		  sMasterTableName =   "ARTICLE_MASTER";
	   		  sLCDArticleIDColName  =  "ARTICLE_ID";	   		
	   		  sEffectiveDateColName  = "ARTICLE_EFF_DATE";
	   		  sVersionColName =  "ARTICLE_VERSION";
	   	  }
	   		   	  
	   	if(HCPCCodes.size()!=0) 
	   	{
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
	   	
	   		//If any of the above Review Effective date is different from each other then REV_EFFECTIVE_DATE from the Master table should be reflected as DOS_FROM date in Target Table	  		 
	   		sQuery = "Select (Trim(SUBSTR(To_CHAR("+sEffectiveDateColName+",'yyyy-mm-dd'),0,10))) from LCD."+sMasterTableName+" where "+ sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID")+ "  and "+sVersionColName+"="+iVersionNo;
		  	        		  	   		  		   		  		  
	   		String sRevEffDate= DBUtils.executeSQLQuery(sQuery);
	   		
	   	      //Retrieve all keys from the Map
   	           Set<String> keys=JuryMap.keySet();	   
	   		  		   
	   		  		 if(!sRevEffDate.isEmpty()) //if Review effective date is not null
	   		  		    {		  		   		  	        
		   		   		   	for(String key : keys)  //Navigate through all keys and retrieve the values 
		   		   		  	  {	  		   		   		  	  
		   		   		  	     List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
			   		   		  	  if(Jurs.size()!=0)    
			   		   		  	   {					   		   		  		     
			   			    		  	 for (j=0;j<Jurs.size();j++)  //Retrieve all the Jurisdictions for each HCPC Code and store them in DOSFromDate String Array
			   			    		  	 {	   			   	  			     
					    		  		    
					    		    					 sQuery = "Select To_Char(DOS_FROM,'yyyy-mm-dd') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName+"="
					    		    							+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + key + "'"
					    		    							+ " and ICD_CODE='" + sNewICDCode + "'"+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"="+iVersionNo;
					    		    					
					    		    					String sDOSFromValue = DBUtils.executeSQLQuery(sQuery);
					    		    					
					    		    					if (sRevEffDate.compareTo(sDOSFromValue) == 0) 
					    		    					{
					    		    						logger.info("DOSFrom set as RevEffectiveDate:" + sDOSFromValue + " when the combinations moved in target for the HCPCCode:" + key);
					    		    						Assert.assertTrue("DOSFrom set as RevEffectiveDate" + sDOSFromValue+ " when the combinations moved in target for the HCPCCode:" + key,true);
					    		    					}
					    		
					    		    					else {    						
					    		    						  logger.info("DOSFrom not set as RevEffectiveDatee:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + key);
					    		    						  Assert.assertTrue("DOSFrom not set as RevEffectiveDate:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + key, false);
					    		    					    }
					    		
					    	    		  		
	   			    		  	   } //End of For loop for Jurs Codes   	
			   		   		  	  }
			   		   		  	  else{		   		   		  		  			   		   		  
					   		   	          logger.info("Jurs codes list size is 0");
					   				      Assert.assertTrue("Jurs codes list size is 0",false);			   		   		  		  
			   		   		  	         }
			   		   		 }//end of For for Keys 		  	 
	   		  		    }  
	   		  		 
	   		  		    else //If the REV_EFFECTIVE_DATE is Null then LAST_UPDATED from LCD/Article MASTER table should be reflected as DOS_FROM date in Target Table.
	   		  		    {
	   		  		    	 sQuery = "Select (Trim(SUBSTR(To_CHAR(Last_Updated,'yyyy-mm-dd'),0,10))) from LCD."+sMasterTableName+" where " + sLCDArticleIDColName+"="+Serenity.sessionVariableCalled("ID") + "  and "+sVersionColName+"="+iVersionNo;
	   		  		  	     String  sLastUpdateDate = DBUtils.executeSQLQuery(sQuery);	   		  		    	
	   		  		    	
			   		  		  	       if(!sLastUpdateDate.isEmpty())
			   		  		  	          {
			   		  		  	    	   
							   		  		  	 	for(String key : keys)  //Navigate through all keys and retrieve the values 
								   		   		  	  {	  		   		   		  	  
								   		   		  	      List<String>  Jurs= JuryMap.get(key);	 //Retrieve the String Array stored in the List			   		   		  	 
									   		   		  	 if(Jurs.size()!=0)    
											   		   		  	   {					   		   		  		     
											   			    		  	 for (j=0;j<Jurs.size();j++)  //Retrieve all the Jurisdictions for each HCPC Code and store them in DOSFromDate String Array
											   			    		  	 {	  
														   		  		    
														   		  		    	  sQuery = "Select TO_Char(DOS_FROM,'yyyy-mm-dd') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName+"="
																    							+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" +key + "'"
																    							+ " and ICD_CODE='" + sNewICDCode + "'"+" and mcare_juris='"+ Jurs.get(j)+"'"+ " and "+sVersionColName+"="+iVersionNo;  
														   		  		    		
														   		  		    		 String sDOSFromDate2 = DBUtils.executeSQLQuery(sQuery);
														   		    					
														   		    					if (sLastUpdateDate.compareTo(sDOSFromDate2) == 0) 
														   		    					{
														   		    						logger.info("DOSFrom set as Last_Updated date:" + sDOSFromDate + " when the combinations moved in target for the HCPCCode:" + key);
														   		    						Assert.assertTrue("DOSFrom set as Last_Updated  date:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + key,true);
														   		    					}
														   		
														   		    					else {    						
														   		    						  logger.info("DOSFrom not set as Last_Updated  open date:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + key);
														   		    						  Assert.assertTrue("DOSFrom not set as Last_Updated date:" + sDOSFromDate+ " when the combinations moved in target for the HCPCCode:" + key,false);
														   		    					    }														   		
														   	    		  	
											   			    		  	 }//end of Juris For loop
											   		   		  	     }//end of jury empty if 	 
											   			    		  	 else
											   			    		  	 {
											   			    		        logger.info("Jurs codes list size is 0");
												   				            Assert.assertTrue("Jurs codes list size is 0",false);			   		   		  		  
										   		   		  	         }
								   		   		  	  }//end of Juris keys for loop    		  	 
			   		  		  	          }
			   		  		  	       
			   		  		  	        else{		   		  		  	    	       
			   		  		  	    	   	  logger.info("Last Updated Date is null in the Master Table");
			   		  		  	    	   	  Assert.assertTrue("Last Updated Date is null in the Master Table",false);		   		  		  	    	   		   		  		  	    	   
			   		  		  	           }
	   		  		    	
	   		  		      }//end of Method
	   		  		 
	   		  	   }  	
		
	@Step	
	public void validateDOSToOpendate(String sDosToDate, String sNewICDCode, String sLCD_Article, String sVersionNo) throws Exception
	{			

	   	 List<String> HCPCCodes = null;  
	   	 List<String> Jurisdictions = null;   	
	   	
	   	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
	     String sTargetTableName = "";
	   
	   	 String sLCDArticleIDColName = "";
	   	 String sQuery="";
	   	 int j=0;
	   
	   	String sVersionColName="";
	   	int iVersionNo=  Integer.parseInt(sVersionNo);	
		
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
	   	
		
	   //Retrieve the HCPC codes from the session variable    	
   	    HCPCCodes = Serenity.sessionVariableCalled("HCPCCodes"); 	
   	  
   	    //Retrieve all Jurisdictions from the DB for each HCPC Code
   	   if(HCPCCodes.size()!=0) 
	   	{
		   	//Retrieve the Jurisdiction names for each hcpc code & store it in List    	 
		   	 for(j=0;j<HCPCCodes.size();j++)
		   	 {	 
		   		sQuery = "Select distinct mcare_juris from LCD."+sTargetTableName+" where hcpc_code ='" +HCPCCodes.get(j)+"'"+" and mcare_juris is not null and " +sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID");
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
												
												String sDOSTOValue = DBUtils.executeSQLQuery(sQuery2);
								
												if (sDOSTOValue.compareTo(sDosToDate) == 0) {
													logger.info("DOSTo defaulted to open date:" + sDosToDate
															+ " when the combinations moved in target for the HCPC code:" + key);
													Assert.assertTrue("DOSTo defaulted to open date:" + sDosToDate+ " when the combinations moved in target for the HCPC code:" + key,true);
												}
								
												else {
													Assert.assertTrue("DOSTo not defaulted to open date:" + sDosToDate+ " when the combinations moved in target for the HCPC code:" + key,false);
													logger.info("DOSTo not defaulted to open date:" + sDosToDate+ " when the combinations moved in target or the HCPC code:" + key);
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
													
													String sDOSTOValue = DBUtils.executeSQLQuery(sQuery2);
									
													if (sDOSTOValue.compareTo(sDosToDate) == 0) {
														logger.info("DOSTo defaulted to open date:" + sDosToDate
																+ " when the combinations moved in target or the HCPC code:" + key);
														Assert.assertTrue(
																"DOSTo defaulted to open date:" + sDosToDate
																		+ " when the combinations moved in target or the HCPC code:" + key,true);
													}
									
													else {
														logger.info("DOSTo not defaulted to open date:" + sDosToDate
																+ " when the combinations moved in target or the HCPC code:" + key);
														Assert.assertTrue(
																"DOSTo not defaulted to open date:" + sDosToDate
																		+ " when the combinations moved in target or the HCPC code:" + key,false);
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
		
	}//end of Method

	@Step
	public void validateDeletionFromManualTable(String sManualTableName, String sCategoryType, String sLCD_Article,String sNewCodes, String sCodeCombType)
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
	      
		  switch(sCodeCombType.toUpperCase())
		  {
		    
		  case "ASSOCIATECODE":
											
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
																sManualTableQuery = "Select count(*) from (select * from LCD." + sManualTableName + " where LCD_ID="
																		+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
																		+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'" + " and BASE_ICD10_CODE=" + "'" + sICDCode
																		+ "'" + "and SUPPORTS_10=" + iSupportVal + ")";
																
															} else if (sLCD_Article.equalsIgnoreCase("Article")) {
																sManualTableQuery = "Select count(*) from (select * from LCD." + sManualTableName + " where ART_ID="
																		+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
																		+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) + "'" + " and BASE_ICD10_CODE=" + "'" + sICDCode
																		+ "'" + "and SUPPORTS_10=" + iSupportVal + ")";
															}
															
															iRowCountCheck = Integer.parseInt(DBUtils.executeSQLQuery(sManualTableQuery));
												
															// Validation of the row count Check
															if (iRowCountCheck == 0) {
																logger.info("New ICDCode deleted from DB Manual Code Combination  Table::" + sManualTableName
																		+ "  as no rows returned from DB Query");
																Assert.assertTrue("New ICDCode deleted from DB Manual Code Combination Table::" + sManualTableName
																		+ "  as no rows returned from DB Que", true);
												
															} else if (iRowCountCheck == 1) {
																logger.error("New ICDCode not deleted from DB Manual Code Combination Table::" + sManualTableName
																		+ "  as no rows returned from DB Query");
																Assert.assertTrue("New ICDCode not deleted from DB Manual Code Combination Table::" + sManualTableName
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
						       break;	
						       
		  case  "MANUALLYMAINTAIN":
			  
						//Executing For loop to retrieve the New manual code stored in  the session variables
						for(int iStartIndex=iCodeNo;iStartIndex<=iLoopCounter;iStartIndex++)	
						{									
											if (sLCD_Article.equalsIgnoreCase("LCD"))
											{
												
												//Check the query to add base icd code null in where condition
												sManualTableQuery = "Select count(*) from LCD." + sManualTableName + " where LCD_ID="
														+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
														+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) +"'"+  " and SUPPORTS_10=" + iSupportVal+ " and BASE_ICD10_CODE is null ";
												
											} else if (sLCD_Article.equalsIgnoreCase("Article")) {
												sManualTableQuery = "Select count(*) from  LCD." + sManualTableName + " where ART_ID="
														+ Serenity.sessionVariableCalled("ID") + " and ICD10_CODE=" + "'"
														+ Serenity.sessionVariableCalled("NewICDCode"+iStartIndex) +"'"+" and SUPPORTS_10=" + iSupportVal +" and BASE_ICD10_CODE is null ";
											}
											
											iRowCountCheck = Integer.parseInt(DBUtils.executeSQLQuery(sManualTableQuery));
								
											// Validation of the row count Check
											if (iRowCountCheck == 0) {
												logger.info("New ICDCode deleted from DB Manual Code Combination  Table::" + sManualTableName
														+ "  as no rows returned from DB Query");
												Assert.assertTrue("New ICDCode deleted from DB Manual Code Combination Table::" + sManualTableName
														+ "  as no rows returned from DB Que", true);
								
											} else if (iRowCountCheck == 1) {
												logger.error("New ICDCode not deleted from DB Manual Code Combination Table::" + sManualTableName
														+ "  as no rows returned from DB Query");
												Assert.assertTrue("New ICDCode not deleted from DB Manual Code Combination Table::" + sManualTableName
														+ "  as no rows returned from DB Query", false);
											}	
				      	}//end of for loop				  
			  
			  break;
			  
			default:         System.out.println("no input provided for Switch case");
			                         logger.error("No input provided for Switch case");
			                         break;
						
				
	        }
		
       }

	@Step
	public void enterBaseICDCode(String sICDCode)
	{		
		    if (!sICDCode.isEmpty())
		    {		    	
		       oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sBaseICDCodeTxt, sICDCode);	
		       Serenity.setSessionVariable("BaseICDCode").to(sICDCode);		       
		       logger.info("Base ICD code is entered as :"+sICDCode);
		       Assert.assertTrue("Base ICD code is entered", true);	
		    }
		    else
		    {		    
		       logger.error("Base ICD code argument is empty ,cannot proceed further");
		       Assert.assertTrue("Base ICD code argument is empty,cannot proceed further", false);		    	
		    }			
	}

	@Step 
	public void raPressesTab() 
	{
		
		//Reach to the end of the Text Field
		getDriver().findElement(By.xpath(oRAPage.sBaseICDCodeTxt)).sendKeys(Keys.END);
		
		//Press tab on the Base ICD Code field 
		getDriver().findElement(By.xpath(oRAPage.sBaseICDCodeTxt)).sendKeys(Keys.TAB);				
		 logger.info("Tab pressed in the Base ICD Code field");
	}

	@Step
	public void validateNewICDCodeAutopopulate() 
	{
		
		String sBaseICDCode="";
		String sBaseICDCodeNew="";
		String sNewICDCodeVal= "";
		String sNewICDCode= "";
		boolean  iSevenDigits = false; 
		
		//Retrieve the BaseICd code stored in Session variable
		sBaseICDCode = Serenity.sessionVariableCalled("BaseICDCode");
				
		if(!(sBaseICDCode.length()<=7  &&  sBaseICDCode.contains(".")))
			{		
							String[]  sCodes = sBaseICDCode.split("\\.");						    
						    for(String sCode : sCodes)
						    {
						    	sBaseICDCodeNew = sBaseICDCodeNew.concat(sCode);	    	
						    }
			 			   }
		else
		{			
			 sBaseICDCodeNew  = sBaseICDCode;			
		}
		
		 //Find the length of the String
		  int len = sBaseICDCode.length();
		 
		  //if the length of the string is 8 (including dot) ,remove the last character		  
		   if (len==8)
		   {
			   sBaseICDCodeNew =  sBaseICDCodeNew.substring(0, 6);	
			   iSevenDigits = true;
		   }		   

		   //Capture value from New ICD Code Field		   
		   sNewICDCodeVal =  oSeleniumUtils.get_TextFrom_Locator(oRAPage.sICDCodeTxt);
		  
		  //if it contains decimal...remove the Decimal		
		   if(!(sBaseICDCode.length()<=7  &&  sBaseICDCode.contains(".")))
			{		
				   if (sNewICDCodeVal.contains("."))
					  {
						   String[]  sCodes = sNewICDCodeVal.split("\\.");			
						    
						    for(String sCode : sCodes)
						    {
						    	sNewICDCode = sNewICDCode.concat(sCode);	    	
						    }
					  }
		 	   }
		   else
		   {
			   sNewICDCode = sNewICDCodeVal;
		   }
		   
		   //Compare it with the BaseICD code with equality		   
		   if(sBaseICDCodeNew.equalsIgnoreCase(sNewICDCode))
		    {
			   if(iSevenDigits==true)		   
			   {
				   logger.info("First 6 digits of the Base ICD Code are populated into the ICD Code field");
				   Assert.assertTrue("First 6 digits of the Base ICD Code are populated into the ICD Code field", true);
			   }	   
			   else   
			   {
				   logger.info("The Base ICD Codewith 6 digits is populated into the ICD Code field");
				   Assert.assertTrue("The Base ICD Codewith 6 digits is populated into the ICD Code field", true);
			   }	
			   
			}
		   else
		   {
			   if(iSevenDigits==true)		   
			   {
				   logger.error("First 6 digits of the Base ICD Code are not populated into the ICD Code field");
				   Assert.assertTrue("First 6 digits of the Base ICD Code are not populated into the ICD Code field", false);
			   }  
			   else   
			   {
				   logger.info("The Base ICD Codewith 6 digits is not populated into the ICD Code field");
				   Assert.assertTrue("The Base ICD Codewith 6 digits is not populated into the ICD Code field", false);
			   }	
		   }	
		
	}
	
	@Step
	public void raClearsTheData()
	{	
		   oSeleniumUtils.clear_Text(oRAPage.sBaseICDCodeTxt);	
		   logger.info("Text cleared in the Base ICD Code field");
		    //Press tab on the Base ICD Code field 
			getDriver().findElement(By.xpath(oRAPage.sBaseICDCodeTxt)).sendKeys(Keys.TAB);		
	}

	@Step
	public void raValidatesICDCodeField()
	{
		
		String sICDCodeText = (oSeleniumUtils.get_TextFrom_Locator(oRAPage.sBaseICDCodeTxt)).trim();
		
		if (sICDCodeText.isEmpty())
		{
			   logger.info("ICD Code field value is cleared as base ICD Code value cleared");
		       Assert.assertTrue("ICD Code field value is cleared as Base ICD Code value cleared", true);				
		}
		else
		{
			 logger.info("ICD Code field value is Not  cleared as base ICD Code value cleared");
		      Assert.assertTrue("ICD Code field value is Not cleared as Base ICD Code value cleared", false);		
		}
		
	}

	@Step
	public void validateMultipleICDCodesFields()
	{
		
		String sBaseICDCode="";
		String sBaseICDCodeNew="";
		String sNewICDCodeVal= "";
		String sNewICDCode= "";
		boolean  iSevenDigits = false; 
		int iICDCodeFieldCount=0;
		
		//Retrieve the BaseICd code stored in Session variable
		sBaseICDCode = Serenity.sessionVariableCalled("BaseICDCode");
		
		if(!(sBaseICDCode.length()<=7  &&  sBaseICDCode.contains(".")))
		{						
			   String[]  sCodes = sBaseICDCode.split("\\.");			
			    
			    for(String sCode : sCodes)
			    {
			    	sBaseICDCodeNew = sBaseICDCodeNew.concat(sCode);	    	
			    }		 			
	   }
	else
	{			
		 sBaseICDCodeNew  = sBaseICDCode;			
	}
		  
		  //Find the length of the String
		  int len = sBaseICDCode.length();
		 
		  //if the length of the string is 7 (including dot) ,remove the last character		  
		   if (len==8)
		   {
			   sBaseICDCodeNew =  sBaseICDCodeNew.substring(0, 6);	
			   iSevenDigits = true;
		   }		  		  
		
		for(int j=1;j<=iICDCodeFieldCount;j++)
		{			
			  	     sNewICDCode="";
				
				   //Capture value from New ICD Code Field		   
				   sNewICDCodeVal =  oSeleniumUtils.get_TextFrom_Locator("("+oRAPage.sAddedICDCodeTxtFields+")"+"["+j+"]");
				   
				   //if it contains decimal...remove the Decimal		
				   if(!(sBaseICDCode.length()<=7  &&  sBaseICDCode.contains(".")))
					{		   
							   if (sNewICDCodeVal.contains("."))
								  {
									   String[]  sCodes = sNewICDCodeVal.split("\\.");			
									    
									    for(String sCode : sCodes)
									    {
									    	sNewICDCode = sNewICDCode.concat(sCode);	    	
									    }
						 		  }
					}
				   else
				   {
					   sNewICDCode=sNewICDCodeVal;					   
				   }
				   
				   //Compare it with the BaseICD code with equality		   
				   if(sBaseICDCodeNew.equalsIgnoreCase(sNewICDCode))
				    {
					   if(iSevenDigits==true)		   
					   {
						   logger.info("First 6 digits of the Base ICD Code are populated into the ICD Code field");
						   Assert.assertTrue("First 6 digits of the Base ICD Code are populated into the ICD Code field", true);
					   }	   
					   else   
					   {
						   logger.info("The Base ICD Codewith 6 digits is populated into the ICD Code field");
						   Assert.assertTrue("The Base ICD Codewith 6 digits is populated into the ICD Code field", true);
					   }	
					   
					}
				   else
				   {
					   if(iSevenDigits==true)		   
					   {
						   logger.error("First 6 digits of the Base ICD Code are not populated into the ICD Code field");
						   Assert.assertTrue("First 6 digits of the Base ICD Code are not populated into the ICD Code field", false);
					   }  
					   else   
					   {
						   logger.info("The Base ICD Codewith 6 digits is not populated into the ICD Code field");
						   Assert.assertTrue("The Base ICD Codewith 6 digits is not populated into the ICD Code field", false);
					   }	
				   }				
		}
		  		
	}
	
	@Step
	public void validateDeltaTableCombinations(String sLCD_Article,String sNewICDCode,String sICDGroup)
	{
				  
		  String sQuery="";
		  int iICDGroup= Integer.parseInt(sICDGroup);	   		
	   	 String 	   sDeltaTableName = "";	   
	   	 String sLCDArticleIDColName = "";	   		   	 
	    int  iDBCount =  -40;   	 
	       
	 	    	  
	    	  //Assign table names based on whether it is LCD or Article 
	       	  if(sLCD_Article.equals("LCD"))
	       	  {   	
	       		   sLCDArticleIDColName  =  "LCD_ID";		       		   
	       		   sDeltaTableName = "LCD_CPT_ICD_SPRT_DELTA";	  	       		   
	       	   }
	       	  else if (sLCD_Article.equals("Article"))
	       	  { 	       		 
	       		  sLCDArticleIDColName  =  "ART_ID";	       		  
	       	     sDeltaTableName = "ART_CPT_ICD_SPRT_DELTA";	  	       	  
	       	  }     		       	  
  			
				sQuery = "Select count(*)  from LCD."+sDeltaTableName + " where "+ sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID") + 
							" and ICD10_Code='" + sNewICDCode + "'"+" and ICD10_Group="+iICDGroup;										
					
					   logger.info(sQuery);				
					
					 //Retrieve the Manual indicator value from the Query
			    	 iDBCount = Integer.parseInt(DBUtils.executeSQLQuery(sQuery));  
			    	 logger.info("DB Count retrieved from query is: "+iDBCount);	        	            
	 
		            //Checking if Review Task not created
			    	 if (iDBCount== 0)
			    	 {        
			    	   logger.info("Review Task is not created for "+ sNewICDCode+" and for ICD Group " +iICDGroup+" in the Delta Table");
			    	   Assert.assertTrue("Review Task is not created for "+ sNewICDCode+" and for ICD Group " +iICDGroup+" in the Delta Table" ,true);	    	  
			    	 }		  
			    	 else 
			    	 {
			    		   logger.info("Review Task is  created for "+ sNewICDCode+" and for ICD Group " +iICDGroup+" in the Delta Table which is not expected");
				    	   Assert.assertTrue("Review Task is  created for "+ sNewICDCode+" and for ICD Group " +iICDGroup+" in the Delta Table which is not expected" ,false); 
				     }	
   		  	
	}
	
}	