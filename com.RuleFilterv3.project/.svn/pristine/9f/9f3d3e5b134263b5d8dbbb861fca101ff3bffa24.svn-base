package project.feature.steps.definitions;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.Serenity;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.pageobjects.AdminPage;
import project.pageobjects.HomePage;
import project.pageobjects.LoginPage;
import project.pageobjects.RAReviewWorkQueuePage;
import project.pageobjects.TargetTableRecordsReviewPage;
import project.utilities.DBQueries;
import project.utilities.DBUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;


public class LCDtoMDMMovementAutomationStepDef  extends ScenarioSteps{

	private static final long serialVersionUID = 5898280540796957114L;

	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CreateProposalStepDef.class);

	LoginPage ologinPage;
	HomePage oHomePage;
	SeleniumUtils oSeleniumUtils;
	DBQueries oDBQueries;
	RAReviewWorkQueuePage  oRAPage;
	AdminPage oAdminPage;
	TargetTableRecordsReviewPage oRequestLCDArticleReviewpage;
	
	
	static  boolean  bAcceptDataExistsinList = false;  
	static  boolean  bRejectDataExistsinList = false;
	static  boolean  bDNSAcceptDataExistsinList = false;  
	static  boolean  bDNSRejectDataExistsinList = false;
	
	  static {
		         Serenity.setSessionVariable("AcceptDataExistsinList").to(bAcceptDataExistsinList); 
		         Serenity.setSessionVariable("RejectDataExistsinList").to(bRejectDataExistsinList);
		         Serenity.setSessionVariable("DNSAcceptDataExistsinList").to(bDNSAcceptDataExistsinList); 
		         Serenity.setSessionVariable("DNSRejectDataExistsinList").to(bDNSRejectDataExistsinList);
		         }
		 
	@Step
	public void RASelectsSpecifiedCodeCombinations(String sCodeComboCount, String sTabName,String sDecision,String  sPageName)	
	{		
		
		 List<String>  SupportAcceptList =  new  ArrayList<String>();
		 List<String>  SupportRejectList =  new  ArrayList<String>();
		 List<String>  DNSAcceptList =  new  ArrayList<String>();
		 List<String>  DNSRejectList =  new  ArrayList<String>();		
		 
		//Capture the CPTCode,ICDCode  and store it in Session Variable for checking data in MDM table										
         String sCPTLocator = "";			
         String sICDLocator = "";	
         String sCPTXpath  = "";
         String sICDXpath = "";
         String sHCPCCode = "";
         String sICDCode = "";
         
          sCPTXpath =  "("+ oRAPage.RAPage_CPTHCPCCode+")";
          
          if(sPageName.equalsIgnoreCase("RAReviewPage"))
          {        	  
             sICDXpath =  "("+ oRAPage.RAPage_ICDCode+")";
          }
          else if (sPageName.equalsIgnoreCase("RequestLCDArticleReview"))
          {        	  
        	  sICDXpath =  "("+ oRequestLCDArticleReviewpage.TargetScreen_ICDCode+")"; 
          }
		 
	     int iCodeComboCount=  Integer.parseInt(sCodeComboCount);		   
	       
	      int  iListIndex = 0;
			
			if (sTabName.equalsIgnoreCase("SupportTab")){
						sTabName = "Support";
						Serenity.setSessionVariable("TabName").to(sTabName);
						oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue", sTabName));
						oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
						// Select specified code combinations
						for (int i = 0; i < iCodeComboCount; i++) 
						{							
						   //Select the check box
						    oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAPage.sCheckBox, "iRowCount", String.valueOf(i + 1)));
						}						
			               
							 for (int k = 1; k <= iCodeComboCount; k++) 
								{									
								 sCPTLocator  =  sCPTXpath+"["+k+"]";
								 sICDLocator  =  sICDXpath+"["+k+"]";
								  
								  sHCPCCode = oSeleniumUtils.get_TextFrom_Locator(sCPTLocator);
								  sICDCode =  oSeleniumUtils.get_TextFrom_Locator(sICDLocator);								 
								
								  if(sDecision.equalsIgnoreCase("Accept"))
								  { 	
									        if ((boolean) Serenity.sessionVariableCalled("AcceptDataExistsinList")){                      // Check if the Accept data already there in ArrayList
											      SupportAcceptList = Serenity.sessionVariableCalled("SupportAcceptCodeComob");
											     }
										      SupportAcceptList.add(iListIndex,sHCPCCode+"-"+sICDCode);
										      bAcceptDataExistsinList  = true;
										      Serenity.setSessionVariable("AcceptDataExistsinList").to(bAcceptDataExistsinList);
										      Serenity.setSessionVariable("SupportAcceptCodeComob").to(SupportAcceptList);
								  }
								  else if (sDecision.equalsIgnoreCase("Reject"))
								  {  
									   if ((boolean) Serenity.sessionVariableCalled("RejectDataExistsinList")){                    // Check if the Reject data already there in ArrayList        
									      SupportRejectList = Serenity.sessionVariableCalled("SupportRejectCodeComob");
									   } 
									   SupportRejectList.add(iListIndex,sHCPCCode+"-"+sICDCode);
									   bRejectDataExistsinList  = true;
									   Serenity.setSessionVariable("RejectDataExistsinList").to(bRejectDataExistsinList);
									   Serenity.setSessionVariable("SupportRejectCodeComob").to(SupportRejectList);
								  }	  
							 	       iListIndex = iListIndex+1;							 	 
						       }
							 
						
			}//End of Support Tab If			
							
						
					 else if (sTabName.equalsIgnoreCase("DoesNotSupportTab")) {
						 
						 iListIndex = 0;
						sTabName = "Does";
						Serenity.setSessionVariable("TabName").to(sTabName);
						oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue", sTabName));
						oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
						// Select some code combinations
						for (int i = 0; i < iCodeComboCount; i++)
						{							
							oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAPage.sCheckBox, "iRowCount", String.valueOf(i + 1)));			  // Select the check box				
						}					
			               
							 for (int k = 1; k <= iCodeComboCount; k++)          //Traverse loop for no of code combinations selected
								{									 
								 sCPTLocator  =  sCPTXpath+"["+k+"]";
								 sICDLocator  =  sICDXpath+"["+k+"]";
								  
								  sHCPCCode = oSeleniumUtils.get_TextFrom_Locator(sCPTLocator);
								  sICDCode =  oSeleniumUtils.get_TextFrom_Locator(sICDLocator);								 
								
								  if(sDecision.equalsIgnoreCase("Accept"))
								  { 	
									        if ((boolean) Serenity.sessionVariableCalled("DNSAcceptDataExistsinList")){
									        	DNSAcceptList = Serenity.sessionVariableCalled("DNSAcceptCodeCombo");
											     }
									            DNSAcceptList.add(iListIndex,sHCPCCode+"-"+sICDCode);
										      bDNSAcceptDataExistsinList  = true;
										      Serenity.setSessionVariable("DNSAcceptDataExistsinList").to(bDNSAcceptDataExistsinList);
										      Serenity.setSessionVariable("DNSAcceptCodeCombo").to(DNSAcceptList);
								  }
								  else if (sDecision.equalsIgnoreCase("Reject"))
								  {  
									   if ((boolean) Serenity.sessionVariableCalled("DNSRejectDataExistsinList")){
										   DNSRejectList = Serenity.sessionVariableCalled("DNSRejectCodeCombo");
									   } 
									   DNSRejectList.add(iListIndex,sHCPCCode+"-"+sICDCode);
									   bDNSRejectDataExistsinList  = true;
									   Serenity.setSessionVariable("DNSRejectDataExistsinList").to(bDNSRejectDataExistsinList);
									   Serenity.setSessionVariable("DNSRejectCodeCombo").to(DNSRejectList);
								  }	  
							 	       iListIndex = iListIndex+1;			 //increment ArrayList iterator increment				 	 
						       }
						
						
						
					} else if (sTabName.contains("Support and DoesNotSupport")) {
			
						oSeleniumUtils
								.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue", "Support"));
						oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
						// Select some code combinations
						for (int i = 0; i < iCodeComboCount; i++) {							
							oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAPage.sCheckBox, "iRowCount", String.valueOf(i + 1)));   // Select the check box
						}
			
						// Click on "DoesNotSupport" tab and select some code combinations
						oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue", "Does"));
						oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
						// Select some code combinations
						for (int i = 0; i < iCodeComboCount; i++) {							
							oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAPage.sCheckBox, "iRowCount", String.valueOf(i + 1)));   // Select the check box
						}	
						
						
					} else if (sTabName.contains("OR")) {
						
						oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue", "Support"));
						oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
			
						// Select some code combinations
						for (int i = 0; i < 1; i++) {						
							oSeleniumUtils.Click_given_Locator(StringUtils.replace(oRAPage.sCheckBox, "iRowCount", String.valueOf(i + 1)));  	// Select the check box
						}
					}		
		
	}

	@Step
	public void RAChecksAcceptDecisionsMovedtoMDM(String sDecision, String sLCD_Article) 
	{
	      
		   String sCodeComb = "";
		   String[] sCodeCombData;
		   String sHCPCCode  = "";
		   String sICDCode  = "";		
		   int iLCDArtFlag  = -2;
	
		  List<String>  SupportAcceptData =  new  ArrayList<String>();
		  List<String>  DNSAcceptData =  new  ArrayList<String>();		
		   
		  if (sLCD_Article.equalsIgnoreCase("LCD"))
		  {
			    iLCDArtFlag   = -1;
		  }
		  else if (sLCD_Article.equalsIgnoreCase("Article"))
		  {
			  iLCDArtFlag   = 0;
		  }
		  
		   if ((boolean) Serenity.sessionVariableCalled("AcceptDataExistsinList")) 	
		   { 
				SupportAcceptData =  Serenity.sessionVariableCalled("SupportAcceptCodeComob");   //For Support Data
					  
				    if (!(SupportAcceptData.isEmpty()))
				    {	
					    int iListSize =  SupportAcceptData.size();
					    
							     for (int m=0;m<iListSize;m++)
									    {		    	
										    	sCodeComb =  SupportAcceptData.get(m);
										    	sCodeCombData =   sCodeComb.split("-");
										    	
										    	sHCPCCode =  sCodeCombData[0];
										    	sICDCode    =  sCodeCombData[1];
										    	
												String sSQLQuery =  "Select count(*) from  (Select *  from MDM.CPT_ICD_LINKS where CPT_CODE = "+"'"+sHCPCCode+"'"+"  and  ICD_CODE = "+"'"+sICDCode+"'" +"  and INVALID_COMBO_10 = 0 and LCD_ART_KEY IN (Select LCD_ART_KEY from MDM.LCD_ART_LKP where LCD_ART_ID = " +  Serenity.sessionVariableCalled("ID") +"   and LCD_NOT_ART_10 = "+iLCDArtFlag+"))";
												String sRowCount =  DBUtils.executeSQLQuery(sSQLQuery);												
												
												if (Integer.parseInt(sRowCount) == 1)    //Check if DB returned one Row
												{
													 Assert.assertTrue("Accept decisions in SupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " moved to MDM",true);
													 logger.info("Accept decisions in SupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " moved to MDM");	
												}
												else
												{
													 Assert.assertTrue("Accept decisions in SupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " not moved to MDM",false);
													 logger.error("Accept decisions in SupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " not moved to MDM");	
												}												
												
									     }//end of For
					       }  //end of if
		   }
		   
		
		   if ((boolean) Serenity.sessionVariableCalled("DNSAcceptDataExistsinList"))	
		   { 
					   
					DNSAcceptData =  Serenity.sessionVariableCalled("DNSAcceptCodeCombo");
					        		
				    if (!(DNSAcceptData.isEmpty()))
				    {	
				    	
				    	 int iDNSListSize  =  DNSAcceptData.size();
				    	 
						     for (int m=0;m<iDNSListSize;m++)
								    {		    	
									    	sCodeComb =  DNSAcceptData.get(m);
									    	sCodeCombData =   sCodeComb.split("-");
									    	
									    	sHCPCCode =  sCodeCombData[0];
									    	sICDCode    =  sCodeCombData[1];
									    	
											String sSQLQuery =  "Select count(*) from  (Select *  from MDM.CPT_ICD_LINKS where CPT_CODE = "+"'"+sHCPCCode+"'"+"  and  ICD_CODE = "+"'"+sICDCode+"'" +" and INVALID_COMBO_10 = -1 and LCD_ART_KEY IN (Select LCD_ART_KEY from MDM.LCD_ART_LKP where LCD_ART_ID = " +  Serenity.sessionVariableCalled("ID") +"   and LCD_NOT_ART_10 = "+iLCDArtFlag+"))";
											String sRowCount =  DBUtils.executeSQLQuery(sSQLQuery);										
											
											if (Integer.parseInt(sRowCount) == 1)    //Check if DB returned one Row
											{
												 Assert.assertTrue("Accept decisions in DoesNotSupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " moved to MDM",true);
												 logger.info("Accept decisions in DoesNotSupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " moved to MDM");	
											}
											else
											{
												 Assert.assertTrue("Accept decisions in DoesNotSupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " not moved to MDM",false);
												 logger.error("Accept decisions in DoesNotSupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " not moved to MDM");	
											}												
											
								     }//end of For
				         }//end of if   
		   }					
	}

	@Step
	public void RASelectsAllCombs(String sTabName,String sDecision) 
	{		
		
		  int 	iPageItemsCount = 0;
		  List<String>  SupportAcceptList =  new  ArrayList<String>();
		  List<String>  SupportRejectList =  new  ArrayList<String>();
		  List<String>  DNSAcceptList =  new  ArrayList<String>();
	       List<String>  DNSRejectList =  new  ArrayList<String>();	       
			  
		  //Capture the CPTCode,ICDCode  and store it in Session Variable for checking data in MDM table										
           String sCPTLocator = "";			
           String sICDLocator = "";	
	
		 
	    //Retrieve Page Items count			 
		 try {
		   	iPageItemsCount = oRAPage.retrievePageItemsCount("PageCount",sTabName);
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		 
		    //Select All rows
		    Serenity.setSessionVariable("TabName").to(sTabName);
			SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
			oSeleniumUtils.is_WebElement_Displayed(oRAPage.ROWHEADER_CHECKBOX);			
			oSeleniumUtils.Click_given_Locator(oRAPage.ROWHEADER_CHECKBOX);		 
		
			if (sTabName.equalsIgnoreCase("SupportTab") )
			{							
				 for (int k = 1; k <= iPageItemsCount; k++) 
					{									 
							 sCPTLocator  =  "("+ oRAPage.RAPage_CPTHCPCCode+")"+"["+k+"]";
							 sICDLocator  =  "("+ oRAPage.RAPage_ICDCode+")"+"["+k+"]";
							  
							 String sHCPCCode = oSeleniumUtils.get_TextFrom_Locator(sCPTLocator);
							 String sICDCode =  oSeleniumUtils.get_TextFrom_Locator(sICDLocator);	
							 							 
							  if(sDecision.equalsIgnoreCase("Accept"))
							  { 									  
									   if ((boolean) Serenity.sessionVariableCalled("AcceptDataExistsinList"))
									   {
											  SupportAcceptList = Serenity.sessionVariableCalled("SupportAcceptCodeComob");
									   }	  
									    SupportAcceptList.add(sHCPCCode+"-"+sICDCode);
									    Serenity.setSessionVariable("SupportAcceptCodeComob").to(SupportAcceptList);
									    bAcceptDataExistsinList = true;  
									    Serenity.setSessionVariable("AcceptDataExistsinList").to(bAcceptDataExistsinList);  
							  }
							  else if (sDecision.equalsIgnoreCase("Reject"))
							  {  
								   if ((boolean) Serenity.sessionVariableCalled("RejectDataExistsinList"))
								   {
										  SupportRejectList = Serenity.sessionVariableCalled("SupportRejectCodeComob");
								   }		  
										  SupportRejectList.add(sHCPCCode+"-"+sICDCode);
										  Serenity.setSessionVariable("SupportRejectCodeComob").to(SupportRejectList);
										  bRejectDataExistsinList = true;  
										  Serenity.setSessionVariable("RejectDataExistsinList").to(bRejectDataExistsinList);  
							  }	 						           			 						 	 
			       }
			 } 
				 else	if (sTabName.equalsIgnoreCase("DoesNotSupportTab") )
				 {
					 
				   	 for (int k = 1; k <= iPageItemsCount; k++) 
						{									 
								 sCPTLocator  =  "("+ oRAPage.RAPage_CPTHCPCCode+")"+"["+k+"]";
								 sICDLocator  =  "("+ oRAPage.RAPage_ICDCode+")"+"["+k+"]";
								  
								 String sHCPCCode = oSeleniumUtils.get_TextFrom_Locator(sCPTLocator);
								 String sICDCode =  oSeleniumUtils.get_TextFrom_Locator(sICDLocator);	
								 							 
								  if(sDecision.equalsIgnoreCase("Accept"))
									  { 									  
										   if ((boolean) Serenity.sessionVariableCalled("DNSAcceptDataExistsinList")) 
										   {
											   DNSAcceptList = Serenity.sessionVariableCalled("DNSAcceptCodeCombo");
									         }
										      DNSAcceptList.add(sHCPCCode+"-"+sICDCode);										      
										      bDNSAcceptDataExistsinList = true;  
											  Serenity.setSessionVariable("DNSAcceptCodeCombo").to(DNSAcceptList);
											  Serenity.setSessionVariable("DNSAcceptDataExistsinList").to(bDNSAcceptDataExistsinList);
								  }
								  else if (sDecision.equalsIgnoreCase("Reject"))
									  {  									  
										   if ((boolean) Serenity.sessionVariableCalled("DNSRejectDataExistsinList")) 
										   {
											   DNSRejectList = Serenity.sessionVariableCalled("DNSRejectCodeCombo");
										   }   
										     DNSRejectList.add(sHCPCCode+"-"+sICDCode);
										     bDNSRejectDataExistsinList = true;  
											Serenity.setSessionVariable("DNSRejectCodeCombo").to(DNSRejectList);
											Serenity.setSessionVariable("bDNSRejectDataExistsinList").to(bDNSRejectDataExistsinList);
								  }	 						           			 						 	 
				            }	
					 
				 }				
		
	}

	@Step
	public void RAChecksRejectDecisionsNotMovedtoMDM(String sDecision, String sLCD_Article)
	{
		 
		   String sCodeComb = "";
		   String[] sCodeCombData;
		   String sHCPCCode  = "";
		   String sICDCode  = "";		 
		   int  iLCDArtFlag = -2;		   

			  List<String>  SupportRejectData =  new  ArrayList<String>();
			  List<String>  DNSRejectData =  new  ArrayList<String>();			   
	   
		  if (sLCD_Article.equalsIgnoreCase("LCD"))
		  {
			    iLCDArtFlag   = -1;
		  }
		  else if (sLCD_Article.equalsIgnoreCase("Article"))
		  {
			  iLCDArtFlag   = 0;
		  }
	   	   
		  
		   if ((boolean) Serenity.sessionVariableCalled("RejectDataExistsinList")) 	
		   {   
					   SupportRejectData =  Serenity.sessionVariableCalled("SupportRejectCodeComob");   //For Support Data	   
				  
				    if (!(SupportRejectData.isEmpty()))
				    {	
					    int iListSize =  SupportRejectData.size();
					    
							     for (int m=0;m<iListSize;m++)
									    {		    	
										    	sCodeComb =  SupportRejectData.get(m);
										    	sCodeCombData =   sCodeComb.split("-");
										    	
										    	sHCPCCode =  sCodeCombData[0];
										    	sICDCode    =  sCodeCombData[1];
										    	
												String sSQLQuery =  "Select count(*) from  (Select *  from MDM.CPT_ICD_LINKS where CPT_CODE = "+"'"+sHCPCCode+"'"+"  and  ICD_CODE = "+"'"+sICDCode+"'" +"  and INVALID_COMBO_10 = 0 and LCD_ART_KEY IN (Select LCD_ART_KEY from MDM.LCD_ART_LKP where LCD_ART_ID = " +  Serenity.sessionVariableCalled("ID") +"   and LCD_NOT_ART_10 = "+iLCDArtFlag+"))";
												String sRowCount =  DBUtils.executeSQLQuery(sSQLQuery);
												
												if (Integer.parseInt(sRowCount) == 0)
												{
													 Assert.assertTrue("Reject  decisions in SupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " not moved to MDM as expected",true);
													 logger.info("Reject decisions in SupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " not moved to MDM as expected");	
												}
												else
												{
													 Assert.assertTrue("Reject decisions in SupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " moved to MDM which is not expected",false);
													 logger.error("Reject decisions in SupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + "  moved to MDM which is not expected");	
												}				
												
									     }//end of For
					       }  //end of if
		   }	   
		   
		   
		   if ((boolean) Serenity.sessionVariableCalled("DNSRejectDataExistsinList")) 	
		   {   
				  DNSRejectData =  Serenity.sessionVariableCalled("DNSRejectCodeCombo");   //For DoesNotSupport Data
						        		
					    if (!(DNSRejectData.isEmpty()))
					    {	
					    	
					    	 int iDNSListSize  =  DNSRejectData.size();
					    	 
							     for (int m=0;m<iDNSListSize;m++)
									    {		    	
										    	sCodeComb =  DNSRejectData.get(m);
										    	sCodeCombData =   sCodeComb.split("-");
										    	
										    	sHCPCCode =  sCodeCombData[0];
										    	sICDCode    =  sCodeCombData[1];
										    	
												String sSQLQuery =  "Select count(*) from  (Select *  from MDM.CPT_ICD_LINKS where CPT_CODE = "+"'"+sHCPCCode+"'"+"  and  ICD_CODE = "+"'"+sICDCode+"'" +" and INVALID_COMBO_10 = -1 and LCD_ART_KEY IN (Select LCD_ART_KEY from MDM.LCD_ART_LKP where LCD_ART_ID = " +  Serenity.sessionVariableCalled("ID") +"   and LCD_NOT_ART_10 = "+iLCDArtFlag+"))";
												String sRowCount =  DBUtils.executeSQLQuery(sSQLQuery);
												
												if (Integer.parseInt(sRowCount) == 0)     //Check if DB has no row for above condition i:e;count = 0
												{
													 Assert.assertTrue("Reject  decisions in DoesNotSupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " not moved to MDM as expected",true);
													 logger.info("Reject decisions in DoesNotSupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " not moved to MDM as expected");	
												}
												else
												{
													 Assert.assertTrue("Reject decisions in DoesNotSupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + " moved to MDM which is not expected",false);
													 logger.error("Reject decisions in DoesNotSupportData for  HCPCCode::"+sHCPCCode+" & ICDCode::"+sICDCode + "  moved to MDM which is not expected");	
												}	
												
									     }//end of For
					         }//end of if   
		   }				
		
	}

	@Step
	public void RATakesRejectdecision(String sRejectReason, String sPageName)
	{
		 
		oSeleniumUtils.Click_given_Locator(oRAPage.DecisionArrow);

		oSeleniumUtils.Click_given_Locator(oRAPage.DecisionValue);

		oSeleniumUtils.enter_given_text_StringLocator(oRAPage.Reason, ProjectVariables.ReasonCommentText);
		
		oSeleniumUtils.Click_given_Locator(oRAPage.ApplyBtn);

		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
		
		oSeleniumUtils.Click_given_WebElement(oRAPage.Update_Decision_Btn);
		
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);

		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.ButtonTag, "sValue", "OK"));

		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
		
	}

	@Step
	public void RAentersUpdateDecisionReason(String sDecision) 
	{	
		
		oSeleniumUtils.enter_given_text_StringLocator(oRAPage.Reason, ProjectVariables.ReasonCommentText);		
		oSeleniumUtils.Click_given_Locator(oRAPage.ApplyBtn);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		
		//Click on Update decision button
         oSeleniumUtils.Click_given_WebElement(oRAPage.Update_Decision_Btn);		
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.ButtonTag, "sValue", "OK"));
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		
	}
	
	@Step
	public void validateDatebandinginMDM(String sDate, String sNewICDCode,String sTabName, String sLCD_Article) 
	{
		
		 int iLCDArtFlag =  -2;
		 String sQuery1 = "";
		 List<String> HCPCSCodes=null;
   	     String sDOSToValue="";    	  
   	     String[] sDatesNew;   
   	     int iInvalidValidCombo =  -2;
   	    
		
		//Retrieve HCPCCodes stored in Session variables	
		  HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");
		
		  if (sLCD_Article.equalsIgnoreCase("LCD"))
		  {
			    iLCDArtFlag   = -1;
		  }
		  else if (sLCD_Article.equalsIgnoreCase("Article"))
		  {
			  iLCDArtFlag   = 0;
		  }
		  

		  if (sTabName.equalsIgnoreCase("SupportTab"))
		  {
			    iInvalidValidCombo   = 0;
		  }
		  else if (sTabName.equalsIgnoreCase("DoesNotSupportTab"))
		  {
			  iInvalidValidCombo   = -1;
		  }
	   	   		
				
				  switch (sLCD_Article)				      
			      {			      
				      case "LCD":		    	  
				    	  
				    	  for (int j=0;j<=HCPCSCodes.size()-1;j++)
				    	  {		    	  
					    	  sQuery1="Select  TO_CHAR(DOS_To,'mm/dd/yyyy') from MDM.CPT_ICD_LINKS where  CPT_CODE='"+HCPCSCodes.get(j)+"'"+ " and ICD_Code='"+sNewICDCode+"'"+ " and INVALID_COMBO_10 = "+iInvalidValidCombo+" and LCD_ART_KEY IN (Select LCD_ART_KEY from MDM.LCD_ART_LKP where LCD_ART_ID = " +  Serenity.sessionVariableCalled("ID") +"   and LCD_NOT_ART_10 = "+iLCDArtFlag+")";
					    	  sDOSToValue = DBUtils.executeSQLQuery(sQuery1);			    	  
					    	  if (sDOSToValue.compareTo(sDate)==0)
					    	
					    	  {			    		  
					    		  Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in MDM",true);
					    		  logger.info("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in MDM");
					    	  }	
					    	  
					    	  else{			    		  
					    		    logger.error("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in MDM");
					    		    Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in MDM",false);			    		  
					    	       }			    	  
				    	    }	  
				    	  
				       break;
				      
				      case "Article":	
				    	  
				    	  for (int j=0;j<=HCPCSCodes.size()-1;j++)
				    	  {		    	  
				    		  sQuery1="Select  TO_CHAR(DOS_To,'mm/dd/yyyy') from MDM.CPT_ICD_LINKS where LCD_ID="+Serenity.sessionVariableCalled("ID")+ " and CPT_CODE='"+HCPCSCodes.get(j)+"'"+ " and ICD_Code='"+sNewICDCode+"'"+ " and INVALID_COMBO_10 = "+iInvalidValidCombo+" and LCD_ART_KEY IN (Select LCD_ART_KEY from MDM.LCD_ART_LKP where LCD_ART_ID = " +  Serenity.sessionVariableCalled("ID") +"   and LCD_NOT_ART_10 = "+iLCDArtFlag+")";
					    	  sDOSToValue = DBUtils.executeSQLQuery(sQuery1);	
					    	  
						    	  if (sDOSToValue.compareTo(sDate)==0)							    	
						    	  {			    		  
						    		  Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in MDM",true);
						    		  logger.info("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in MDM");
						    	  }	
						    	  
						     else{			    		  
						    		   logger.error("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in MDM");
						    		    Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in MDM",false);			    		  
						    	     }						    	   	  	    	  
				    	  }	  			    	
				    	  
				       break;   
				       
				      default:  logger.info("No input is provided for the Switch Case");
			          		         Assert.assertTrue("Provided invalid case value",false);				
			      }		
			    	
		
	}
	
	@Step
	public void captureHCPCCodes(String sCategory, String sLCD_Article, String sRecordsType) throws Exception 
	{
		  String sTableName="";
		  String sICDCode="";
		  String sQuery="";
		  List<String> HCPCSCodes=null;		
		  int iSupportVal = -2;
	
		  
if(sRecordsType.equalsIgnoreCase("TargetRecords"))
{	
		if (sCategory.equalsIgnoreCase("Support")) 
		   {
				if (sCategory.equalsIgnoreCase("Support"))
				{
					iSupportVal = -1;
					sICDCode = Serenity.sessionVariableCalled("ICD Code");
				
				} else if  (sCategory.equalsIgnoreCase("Does"))
				{
					iSupportVal = 0;	  
					sICDCode = Serenity.sessionVariableCalled("ICD Code Doesn't");
				}
		   }
}	
			// Query to retrieve all HCPC codes associated with the new Manually added ICD Code
			if (sLCD_Article.equalsIgnoreCase("LCD")) 
			{
				sQuery = "Select distinct HCPC_CODE from LCD.LCD_CPT_ICD_LINKS" + " where LCD_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD_Code='" + sICDCode + "'" +" and Supports_10 = "+iSupportVal;
				logger.info(sQuery);			

			}
			else if (sLCD_Article.equalsIgnoreCase("Article"))
			{
			
				sQuery = "Select distinct HCPC_CODE from LCD.ARTICLE_CPT_ICD_LINKS" + " where ARTICLE_ID="
						+ Serenity.sessionVariableCalled("ID") + " and ICD_Code='" + sICDCode + "'" +" and Support_10 = "+iSupportVal;
				logger.info(sQuery);						
			}

			// Storing the HCPC Codes in the ArrayList
			HCPCSCodes = DBUtils.executeSQLQueryMultipleRows(sQuery);			
            Serenity.setSessionVariable("HCPCCodes").to(HCPCSCodes);  
            System.out.println(Serenity.sessionVariableCalled("HCPCCodes").toString());
		
	}

	@Step
	public void captureReviewDecisions(String sTabName, String sPageName)
	{
		
		 List<String>  SupportAcceptList =  new  ArrayList<String>();
		 List<String>  SupportRejectList =  new  ArrayList<String>();
		 List<String>  DNSAcceptList =  new  ArrayList<String>();
		 List<String>  DNSRejectList =  new  ArrayList<String>();		
		 
		//Capture the CPTCode,ICDCode  and store it in Session Variable for checking data in MDM table										
         String sCPTLocator = "";			
         String sICDLocator = "";	
         String sCPTXpath  = "";
         String sICDXpath = "";
         String sHCPCCode = "";
         String sICDCode = "";
		 
         
		 sCPTXpath =  "("+ oRAPage.RAPage_CPTHCPCCode+")";   //Building the xpath to retrieve based on Indexes   
         
         if(sPageName.equalsIgnoreCase("RAReviewPage"))
         {        	  
            sICDXpath =  "("+ oRAPage.RAPage_ICDCode+")";
         }
         else if (sPageName.equalsIgnoreCase("RequestLCDArticleReview"))
         {        	  
       	  sICDXpath =  "("+ oRequestLCDArticleReviewpage.TargetScreen_ICDCode+")"; 
         }		      
	       
	      int  iListIndex = 0;
	      int j = 0;
		
		 List<WebElement>  ReviewDecisionsList =  new  ArrayList<WebElement>();
		 String sReviewDec = "";
		 ReviewDecisionsList =  getDriver().findElements(By.xpath(oRequestLCDArticleReviewpage.TargetScreen_ReviewDecision));  //Retrieving all the ReviewDecision value webelements and store it in the List
		 
		 for (int k=0;k<ReviewDecisionsList.size();k++)
		 {
			   j= k+1;    //Index Variable for CPT & HCPC code xpaths ,they start with index 1   
			   
			 sReviewDec  =  (ReviewDecisionsList.get(k)).getText();
			 sCPTLocator  =  sCPTXpath+"["+j+"]";
			 sICDLocator  =  sICDXpath+"["+j+"]";
			  
			  sHCPCCode = oSeleniumUtils.get_TextFrom_Locator(sCPTLocator);
			  sICDCode =  oSeleniumUtils.get_TextFrom_Locator(sICDLocator);							 
			
			  
			  if( sReviewDec.equalsIgnoreCase("Accept") )
			  {				  
				  if ((boolean) Serenity.sessionVariableCalled("AcceptDataExistsinList"))
				  {
				      SupportAcceptList = Serenity.sessionVariableCalled("SupportAcceptCodeComob");
				     }
			      SupportAcceptList.add(iListIndex,sHCPCCode+"-"+sICDCode);
			      bAcceptDataExistsinList  = true;
			      Serenity.setSessionVariable("AcceptDataExistsinList").to(bAcceptDataExistsinList);
			      Serenity.setSessionVariable("SupportAcceptCodeComob").to(SupportAcceptList);
			  }  
			  
			  else if (sReviewDec.equalsIgnoreCase("Reject"))
			  {  
				   if ((boolean) Serenity.sessionVariableCalled("DNSRejectDataExistsinList"))
				   {
					   DNSRejectList = Serenity.sessionVariableCalled("DNSRejectCodeCombo");
				   } 
				   DNSRejectList.add(iListIndex,sHCPCCode+"-"+sICDCode);
				   bDNSRejectDataExistsinList  = true;
				   Serenity.setSessionVariable("DNSRejectDataExistsinList").to(bDNSRejectDataExistsinList);
				   Serenity.setSessionVariable("DNSRejectCodeCombo").to(DNSRejectList);
			  }	  			 
			 
		 }		
		
	}

	@Step
	public void RAFiltersColumSpecific(String sColName, String sFilterVal, String sTabName, String sPageName)
	{		
		
		if (sPageName.equalsIgnoreCase("RAReviewPage"))
		{
			 oSeleniumUtils.enter_given_text_StringLocator(oRAPage.ICDCodeTextBoxNew, sFilterVal);
		}
		else if( sPageName.equalsIgnoreCase("RequestLCDArticleReview")) 
		{
		   oSeleniumUtils.enter_given_text_StringLocator(oRequestLCDArticleReviewpage.ICDCode_Textbox, sFilterVal);
		}  
		
	}

	@Step
	public void filterColumn(String sColName, String sValue) 
	{
		String sID = "";
		if (sValue.equalsIgnoreCase("LCD")){
			sID = DBUtils.executeSQLQuery(ProjectVariables.sTargetDataTab_LCD_ID);
		}else
		{
			sID = DBUtils.executeSQLQuery(ProjectVariables.sTargetDataTab_Article_ID);
		}
		
		System.out.println(sID);		
		if(sColName.equalsIgnoreCase("ID"))
		{
			  oSeleniumUtils.enter_given_text_StringLocator(oAdminPage.LCD_ArticleIDTextBox,sID);
		}
		
		//Click on Apply Filters Button
		oSeleniumUtils.Click_given_WebElement(oAdminPage.ApplyFilter_Btn);
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
		oSeleniumUtils.Click_given_Locator(oAdminPage.sCheckbox_One);		
		
	}	
	
	@Step
	public void validatePopup(String sPopupTitle)
	{		
		
		if (oSeleniumUtils.is_WebElement_Displayed(oAdminPage.sPopupDoalog))
		{
			 Assert.assertTrue("Data Integrity Records popup displayed",true);
			 logger.info("Data Integrity Records popup displayed");		
		}
		else
		{
			 logger.error("Data Integrity Records popup Not displayed");	
			 Assert.assertTrue("Data Integrity Records popup Not displayed",false);			
		}
				
		oSeleniumUtils.highlightElement(oAdminPage.sPopupDoalog);
		String sTitle = oSeleniumUtils.get_TextFrom_Locator(oAdminPage.sPopupText);		
		
		 if (sTitle.equalsIgnoreCase(sPopupTitle ))
		 {
			 Assert.assertTrue("Data Integrity Records popup title displayed",true);
			 logger.info("Data Integrity Records popup titledisplayed");		
		 }
		 else
			{
				 logger.error("Data Integrity Records popup title Not displayed");	
				 Assert.assertTrue("Data Integrity Records popup title Not displayed",false);			
			}
		 
		
	}

	@Step
	public void validateManualCodetoBaseCode(String sLCD_Article) 
	{
	    //Capture Session Variable from Session Variable		
		ArrayList<String> HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");
		
		if(!HCPCSCodes.isEmpty())
		{
				for(int i=0;i<HCPCSCodes.size();i++)
				{
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
		}
		else{
			logger.info("HCPCCodes Session Variables has no data");
			Assert.assertTrue("HCPCCodes Session Variables has no data",false);			
		}
	}	
		
   @Step
	public void validateDecisionsCopiedtoTarget(String sNewICDCode, String sLCD_Article)
	{
	   
	   String sQueryBaseCodeDec = "";
	   String sQueryNewCodeDec = "";
	   
	   //Take HCPCCodes from the Session Variable
	   
	    //Capture Session Variable from Session Variable		
		ArrayList<String> HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");
	   
	
	for (int m=0;m<HCPCSCodes.size();m++)
	{	
					if( sLCD_Article.equalsIgnoreCase("LCD"))
					{		
						//Capture existing Decision for the HCPC Code ,Base code combination from DB for each HCPC code		
						sQueryBaseCodeDec =  " Select Appropriate_10 from LCD.LCD_CPT_ICD_LINKS  where  LCD_ID = " + Serenity.sessionVariableCalled("ID")+"  and ICD_CODE =  "+"'"+ Serenity.sessionVariableCalled("ICD Code")+"'"+" and HCPC_CODE = "+"'"+HCPCSCodes.get(m)+"'"+" and mcare_juris ='5'";		
						sQueryNewCodeDec = "Select appropriate_10 from LCD.LCD_CPT_ICD_LINKS  where  LCD_ID = " + Serenity.sessionVariableCalled("ID")+"   and ICD_CODE = "+"'"+Serenity.sessionVariableCalled("NewICDCode1")+"'"+" and HCPC_CODE ="+"'"+HCPCSCodes.get(m)+"'"+" and mcare_juris ='5'";
					}	
				else if(sLCD_Article.equalsIgnoreCase("Article"))
				  {
				      //Capture new decision for HCPC code and New ICD code comb from DB
					    sQueryBaseCodeDec =   " Select Appropriate_10 from LCD.ARTICLE_CPT_ICD_LINKS  where  ARTICLE_ID =  "+  Serenity.sessionVariableCalled("ID")+"   and ICD_CODE = "+ Serenity.sessionVariableCalled("ICD Code")+"  and HCPC_CODE ="+HCPCSCodes.get(m)+" and mcare_juris ='5' ";
					    sQueryNewCodeDec =    "Select appropriate_10 from LCD.ARTICLE_CPT_ICD_LINKS  where  ARTICLE_ID =  "+ Serenity.sessionVariableCalled("ID") +"   and ICD_CODE = "+Serenity.sessionVariableCalled("NewICDCode1")  +" and HCPC_CODE ="+HCPCSCodes.get(m)+" and mcare_juris ='5'";
				 }	
					
					//Retrieve Review Decisions for BaseICDCode and  NewICD Code 
					int  iReviewDecBaseCode  = Integer.parseInt(DBUtils.executeSQLQuery(sQueryBaseCodeDec));
					int  iReviewDecNewCode  = Integer.parseInt(DBUtils.executeSQLQuery(sQueryNewCodeDec));
				   
					
				   //Compare both  decisions if they are equal   		
					if ( iReviewDecBaseCode == iReviewDecNewCode )
					{
						logger.info("Review Decision copied from Base ICDCode::"+  Serenity.sessionVariableCalled("ICD Code") +" to new ManualAssociated Code:: "+Serenity.sessionVariableCalled("NewICDCode1")+" for HCPCCode ::"+HCPCSCodes.get(m));
						Assert.assertTrue("Review Decision copied from Base ICDCode::"+  Serenity.sessionVariableCalled("ICD Code") +" to new ManualAssociated Code:: "+Serenity.sessionVariableCalled("NewICDCode1")+" for HCPCCode ::"+HCPCSCodes.get(m),true);			
				    }
					else
					{
						logger.error("Review Decision Not copied from Base ICDCode::"+  Serenity.sessionVariableCalled("ICD Code") +" to new ManualAssociated Code:: "+Serenity.sessionVariableCalled("NewICDCode1")+" for HCPCCode ::"+HCPCSCodes.get(m));
						Assert.assertTrue("Review Decision Not copied from Base ICDCode::"+  Serenity.sessionVariableCalled("ICD Code") +" to new ManualAssociated Code:: "+Serenity.sessionVariableCalled("NewICDCode1")+" for HCPCCode ::"+HCPCSCodes.get(m),false);	
					}					
		
	}
	
		
	}
   
	@Step
	public void validateDatebandinginSpecificTable(String sDate, String sNewICDCode,String sTableName, String sTabName, String sLCD_Article, String sLCDArticleVersion) 
	{
		
		 int iLCDArtFlag =  -2;
		 String sQuery1 = "";
		 List<String> HCPCSCodes=null;
  	     String sDOSToValue="";    	    
  	     int iInvalidValidCombo =  -2;
  	     String[] sTable = sTableName.split(";");
  	     int isupports_10 = -2;
  	     String[] sJuries;
  	     int iLCDArticleVersion = -2;
		 iLCDArticleVersion = Integer.parseInt(sLCDArticleVersion);
  	   
		
		//Retrieve HCPCCodes stored in Session variables	
		  HCPCSCodes = Serenity.sessionVariableCalled("HCPCCodes");
		
		  if (sLCD_Article.equalsIgnoreCase("LCD"))
		  {
			    iLCDArtFlag   = -1;
		  }
		  else if (sLCD_Article.equalsIgnoreCase("Article"))
		  {
			  iLCDArtFlag   = 0;
		  }
		  

		  if (sTabName.equalsIgnoreCase("SupportTab"))
		  {
			    iInvalidValidCombo   = 0;
			    isupports_10 = -1;
		  }
		  else if (sTabName.equalsIgnoreCase("DoesNotSupportTab"))
		  {
			  iInvalidValidCombo   = -1;
			  isupports_10 = 0;
		  }
	   	   		
				
				  switch (sLCD_Article)				      
			      {			      
				      case "LCD":	
				    	  for(int i=0;i<=sTable.length-1;i++)
				    	  {
				    		  if(sTable[i].equalsIgnoreCase("MDM"))
				    		  {
				    			 
						    	  for (int j=0;j<=HCPCSCodes.size()-1;j++)
						    	  {		    	  
							    	  sQuery1="Select  TO_CHAR(DOS_To,'mm/dd/yyyy') from MDM.CPT_ICD_LINKS where  CPT_CODE='"+HCPCSCodes.get(j)+"'"+ " and ICD_Code='"+sNewICDCode+"'"+ " and INVALID_COMBO_10 = "+iInvalidValidCombo+" and LCD_ART_KEY IN (Select LCD_ART_KEY from MDM.LCD_ART_LKP where LCD_ART_ID = " +  Serenity.sessionVariableCalled("ID") +"   and LCD_NOT_ART_10 = "+iLCDArtFlag+")";
							    	  sDOSToValue = DBUtils.executeSQLQuery(sQuery1);			    	  
							    	  if (sDOSToValue.compareTo(sDate)==0)
							    	
							    	  {			    		  
							    		  Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in MDM",true);
							    		  logger.info("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in MDM");
							    	  }								    	  
							    	  else{			    		  
							    		    logger.error("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in MDM");
							    		    Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in MDM",false);			    		  
						    	       }			    	  
						    	    }
				    		  }
				    		  else{
				    			  String  sJurilist =  sTable[0] ;			    			 
			    				  sJuries  = sJurilist.split("-");		    				  
			    				  String juryList[] = sJuries[1].split(",");
			    				
				    			  for (int j=0;j<=HCPCSCodes.size()-1;j++)
						    	  {		  
			 		  				    if (!(juryList.length==0)) {
					  					    for (int k = 0; k < juryList.length; k++)
					  					    {
										    	  sQuery1="Select  TO_CHAR(DOS_To,'mm/dd/yyyy') from LCD_CPT_ICD_LINKS where  HCPC_CODE='"+HCPCSCodes.get(j)+"'"+ " and ICD_Code='"+sNewICDCode+"'"+ " and SUPPORTS_10 = "+isupports_10+" and LCD_ID = "+  Serenity.sessionVariableCalled("ID")+ "  and mcare_juris='" + juryList[k]+ "'"+"  and LCD_VERSION =" + iLCDArticleVersion;
										    	  sDOSToValue = DBUtils.executeSQLQuery(sQuery1);			    	  
										    	  if (sDOSToValue.compareTo(sDate)==0)								    	
										    	  {			    		  
										    		  Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in Target table for LCD "+  Serenity.sessionVariableCalled("ID")+ " for jury name "+juryList[k]+" with LCD Version "+iLCDArticleVersion,true);
										    		  logger.info("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in Target table for LCD "+  Serenity.sessionVariableCalled("ID")+ " for jury name "+juryList[k]+" with LCD Version "+iLCDArticleVersion);
										    	  }											    	  
										    	  else{			    		  
										    		    logger.error("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in Target table for LCD "+  Serenity.sessionVariableCalled("ID")+ " for jury name "+juryList[k]+" with LCD Version "+iLCDArticleVersion);
										    		    Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in Target table for LCD "+  Serenity.sessionVariableCalled("ID")+ " for jury name "+juryList[k]+" with LCD Version "+iLCDArticleVersion,false);			    		  
									    	      }
					  					    }
				  					    }
				  					    else{
				  					    	logger.info("Jury list is empty");
				  							Assert.assertTrue("Jury list is empty", false);	 
				  					    }
						    	    }
				    			  
				    		  }
				    	  }
				       break;
				      
				      case "Article":	
				    	  for(int i=0;i<=sTable.length-1;i++)
				    	  {
				    		  if(sTable[i].equalsIgnoreCase("MDM"))
				    		  {		    			 
						    	  for (int j=0;j<=HCPCSCodes.size()-1;j++)
						    	  {		    	  
						    		  sQuery1="Select  TO_CHAR(DOS_To,'mm/dd/yyyy') from MDM.CPT_ICD_LINKS where CPT_CODE='"+HCPCSCodes.get(j)+"'"+ " and ICD_Code='"+sNewICDCode+"'"+ " and INVALID_COMBO_10 = "+iInvalidValidCombo+" and LCD_ART_KEY IN (Select LCD_ART_KEY from MDM.LCD_ART_LKP where LCD_ART_ID = " +  Serenity.sessionVariableCalled("ID") +"   and LCD_NOT_ART_10 = "+iLCDArtFlag+")";
							    	  sDOSToValue = DBUtils.executeSQLQuery(sQuery1);							    	  
								    	  if (sDOSToValue.compareTo(sDate)==0)							    	
								    	  {			    		  
								    		  Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in MDM",true);
								    		  logger.info("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in MDM");
								    	  }						    	  
								    	  else{			    		  
								    		   logger.error("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in MDM");
								    		    Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in MDM",false);			    		  
							    	      }						    	   	  	    	  
						    	  }	
				    		  }
				    		  else{
				    			  String  sJurilist =  sTable[0] ;			    			 
			    				  sJuries  = sJurilist.split("-");		    				  
			    				  String juryList[] = sJuries[1].split(",");
			    				
				    			  for (int j=0;j<=HCPCSCodes.size()-1;j++)
						    	  {		  
			 		  				    if (!(juryList.length==0)) {
					  					    for (int k = 0; k < juryList.length; k++)
					  					    {
										    	  sQuery1="Select  TO_CHAR(DOS_To,'mm/dd/yyyy') from ARTICLE_CPT_ICD_LINKS where  HCPC_CODE='"+HCPCSCodes.get(j)+"'"+ " and ICD_Code='"+sNewICDCode+"'"+ " and SUPPORT_10 = "+isupports_10+" and ARTICLE_ID = "+  Serenity.sessionVariableCalled("ID")+ "  and mcare_juris='" + juryList[k]+ "'"+"  and ARTICLE_VERSION =" + iLCDArticleVersion;
										    	  sDOSToValue = DBUtils.executeSQLQuery(sQuery1);			    	  
										    	  if (sDOSToValue.compareTo(sDate)==0)								    	
										    	  {			    		  
										    		  Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in Target table for ARTICLE "+  Serenity.sessionVariableCalled("ID")+ " for jury name "+juryList[k]+" with ARTICLE Version "+iLCDArticleVersion,true);
										    		  logger.info("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" got  Date banded in Target table for ARTICLE "+  Serenity.sessionVariableCalled("ID")+ " for jury name "+juryList[k]+" with ARTICLE Version "+iLCDArticleVersion);
										    	  }						    	  
										    	  else{			    		  
										    		    logger.error("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in Target table for ARTICLE "+  Serenity.sessionVariableCalled("ID")+ " for jury name "+juryList[k]+" with ARTICLE Version "+iLCDArticleVersion);
										    		    Assert.assertTrue("Deleted CodeCombinations ::"+HCPCSCodes.get(j)+" and "+ sNewICDCode +" did not get Date banded in Target table for ARTICLE "+  Serenity.sessionVariableCalled("ID")+ " for jury name "+juryList[k]+" with ARTICLE Version "+iLCDArticleVersion,false);			    		  
									    	      }
					  					    }
				  					    }
				  					    else{
				  					    	logger.info("Jury list is empty");
				  							Assert.assertTrue("Jury list is empty", false);	 
				  					    }
						    	    }
				    			  
				    		  }
				    	  }
				    	  
				       break;   
				       
				      default:  logger.info("No input is provided for the Switch Case");
			          		         Assert.assertTrue("Provided invalid case value",false);				
			      }		
			    	
		
	}

}
