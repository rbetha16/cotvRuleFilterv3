package project.feature.steps.definitions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import org.junit.Assert;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import project.pageobjects.AdminPage;
import project.pageobjects.HomePage;
import project.pageobjects.LoginPage;
import project.pageobjects.RAReviewWorkQueuePage;
import project.utilities.DBQueries;
import project.utilities.DBUtils;
import project.utilities.SeleniumUtils;


public class UpdateDatebandingLogicforCPTICDCombinationStepDef
{
	private static final long serialVersionUID = 5898280540796957114L;
	
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UpdateDatebandingLogicforCPTICDCombinationStepDef.class);

	LoginPage ologinPage;
	HomePage oHomePage;
	SeleniumUtils oSeleniumUtils;
	DBQueries oDBQueries;
	RAReviewWorkQueuePage  oRAPage;
	AdminPage oAdminPage;

	@Step
	public void validateRetiredDate(String sLCD_Article,String sVersion) throws ParseException
	{	
		
	   	 HashMap<String,List<String>>  JuryMap= new HashMap<String,List<String>>();   	
	     String sTargetTableName = "";
	   	 String sMasterTableName = "";
	   	 String sLCDArticleIDColName = "";
	   	 String sQuery="";	
	   	String sVersionColName="";
	    List<String> LinkKeys=null;	
		 String sExpectedDOSToDate ="";
		 String sRetiredDate="";
		 String sDOSFromDBValue="";
		 java.util.Date dDOSFromDtDB=null;
		 String sCPTICDLinksKeyColName="";
		 String sDOSToDBValue="";
		 String sQuery1="";
		 SimpleDateFormat sdf =null;
		 java.util.Date sRetiredDateDB =null;
		 String sEffectiveDateColName="";
		 
		 
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
	   		   sCPTICDLinksKeyColName=  "LCD_CPT_ICD_LINKS_KEY";	   		   
	   	   }
	   	  else if (sLCD_Article.equals("Article"))
	   	  { 
	   		  sTargetTableName = "ARTICLE_CPT_ICD_LINKS";   	   		
	   		  sLCDArticleIDColName  =  "ARTICLE_ID";   	   		 
	   		  sVersionColName =  "ARTICLE_VERSION";	   		
	   		  sMasterTableName =   "ARTICLE_MASTER";	   		   		
	   		  sEffectiveDateColName  = "ARTICLE_EFF_DATE";
	   		  sVersionColName =  "ARTICLE_VERSION";
	   		 sCPTICDLinksKeyColName = "ARTICLE_CPT_ICD_LINKS_KEY";
	   	  }	 	 
		 
		 int iVersionNo= Integer.parseInt(sVersion);	 
	   	
	   	//Retrieve the CPTICDLinksKey values stored in the session variable for which DOSTO is open dated	   		   	
	     LinkKeys = Serenity.sessionVariableCalled("LCD_Article_LinkKeys");
	    
	   	//Retrieve Retired Date from LCD Master table for the LCD/Article based on version
	     sQuery = "Select To_CHAR(DATE_RETIRED,'dd/mm/yyyy') from LCD."+sMasterTableName+" where "+ sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID")+ "  and "+sVersionColName+"="+iVersionNo;
	     sRetiredDate= DBUtils.executeSQLQuery(sQuery);	  
	   	
	     //Initialize the DateFormat
	     sdf = new SimpleDateFormat( "dd/MM/yyyy" );
	     
	     if(!sRetiredDate.isEmpty())   
	     {
	    	 sRetiredDateDB = sdf.parse(sRetiredDate);
	     }		 
	 
	
	     if(!sRetiredDate.isEmpty())   //If the Retired date is NOT blank  then DOSTo of the Version 2 records date should be Retired_Date 
	     {    	 	    	   
	    	     logger.info("Retired Date in MasterTable is available.So proceeding with comparisions with Retired Date::"+ sRetiredDate);    
	    	 
	    	         for (int k=0;k<LinkKeys.size();k++) //Retrieve DOSFrom date for each Links Key and compare it with RetiredDate
	    	         {			    	        	 
	    	     		    logger.info("***Processing the "+k+" st/nd/th record for the key::"+LinkKeys.get(k));
	    	     		    
				    	     sQuery1 = "Select TO_Char(DOS_FROM,'dd/mm/yyyy') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName +"="
								 	+ Serenity.sessionVariableCalled("ID") +  " and "+sVersionColName+"="+iVersionNo+"  and "+sCPTICDLinksKeyColName+" = "+LinkKeys.get(k);
				
							 	 sDOSFromDBValue = DBUtils.executeSQLQuery(sQuery1);					 				 		
							     dDOSFromDtDB = sdf.parse(sDOSFromDBValue );	    	 
						    	 
						    	     if( dDOSFromDtDB.compareTo(sRetiredDateDB)<0)
						    	     {
						    	    	  sExpectedDOSToDate = sRetiredDate;	 
						    	    	  logger.info("DOS From date is  less than Retired Date for  CPTICDLinksKey ::"+LinkKeys.get(k)+" so checking if DOS_To=Retired Date in TargetTable");
						    	     }
						    	     else if( dDOSFromDtDB.compareTo(sRetiredDateDB)>0)
						    	     {
						    	    	  sExpectedDOSToDate = sDOSFromDBValue;
						    	    	  logger.info("DOS From date is greater than Retired Date for  CPTICDLinksKey ::"+LinkKeys.get(k)+" so checking if DOS_TO=DOS_FROM in TargetTable");
						    	      } 
						    	     
						    	    //Retrieve DOSTo date for each Links Key and and check whether it is set as expected date as above
						    	     sQuery1 = "Select TO_Char(DOS_TO,'dd/mm/yyyy') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName +"="
											 	+ Serenity.sessionVariableCalled("ID") +  " and "+sVersionColName+"="+iVersionNo+"  and "+sCPTICDLinksKeyColName+" = "+LinkKeys.get(k);
							
										 	 sDOSToDBValue = DBUtils.executeSQLQuery(sQuery1);					 				 		
										  	 									    	 
						    	          if(sDOSToDBValue.compareTo(sExpectedDOSToDate)==0)
						    	          {
						    	        	     logger.info("DOSTo date value is Datebanded to Expected Date :: "+sExpectedDOSToDate + " for CPTICDLinksKey ::"+LinkKeys.get(k)+" and for ID ::" +Serenity.sessionVariableCalled("ID"));
					 					    	 Assert.assertTrue("DOSTo date value is Datebanded to Expected Date ::"+sExpectedDOSToDate+ " for CPTICDLinksKey ::"+LinkKeys.get(k)+" and for ID ::" +Serenity.sessionVariableCalled("ID"),true);	  			 				       
		 				 		            }   
					 				 		else
					 				 		{
					 				 			 logger.info("DOSTo date value is Not Datebanded to Expected Date :: "+sExpectedDOSToDate + " for CPTICDLinksKey ::"+LinkKeys.get(k)+" and for ID ::" +Serenity.sessionVariableCalled("ID"));
					 					    	 Assert.assertTrue("DOSTo date value is Not Datebanded to Expected Date ::"+sExpectedDOSToDate+ " for CPTICDLinksKey ::"+LinkKeys.get(k)+" and for ID ::" +Serenity.sessionVariableCalled("ID"),false);	
					 				 		}						    	     
	    	                  }	//end of For for CPTICDLINKSKEY loop
	    	         
	     } //end of If control
	   
	     else if (sRetiredDate.isEmpty())    //if Retired date is empty
	     {	   	    		    	 		 
	    	 
				    	sQuery = "Select To_CHAR(Last_Updated,'dd/mm/yyyy') from LCD."+sMasterTableName+" where " + sLCDArticleIDColName+"="+Serenity.sessionVariableCalled("ID") + "  and "+sVersionColName+"="+iVersionNo;									 
						String sLastUpdatedDBValue = DBUtils.executeSQLQuery(sQuery);					 				 		
					 	java.util.Date dLastUpdatedDB = sdf.parse(sLastUpdatedDBValue);
					 	
						logger.info("Retired Date in MasterTable is  blank.so proceeding with comparisions with LAST_UPDATED Date::"+sLastUpdatedDBValue);   				 	
					 	

		    	         for (int k=0;k<LinkKeys.size();k++)//Retrieve DOSFrom date for each Links Key and compare it with LAST_UPDATED dates
		    	         {				    	        	 
		    	        		logger.info("***Processing the "+k+" st/nd/th record for the key::"+LinkKeys.get(k));    
		    	        	 
					    	     sQuery1 = "Select TO_Char(DOS_FROM,'dd/mm/yyyy') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName +"="
									 	+ Serenity.sessionVariableCalled("ID") +  " and "+sVersionColName+"="+iVersionNo+"  and "+sCPTICDLinksKeyColName+" = "+LinkKeys.get(k);
					
								 	 sDOSFromDBValue = DBUtils.executeSQLQuery(sQuery1);					 				 		
								     dDOSFromDtDB = sdf.parse(sDOSFromDBValue );	    	 
							    	 
							    	     if( dDOSFromDtDB.compareTo(dLastUpdatedDB)<0)
							    	     {
							    	    	  sExpectedDOSToDate = sLastUpdatedDBValue;	 
							    	    	  logger.info("DOS From date is  less than LastUpdated Date for  CPTICDLinksKey ::"+LinkKeys.get(k)+" so checking if DOS_TO=LastUpdated Date in TargetTable");
							    	     }
							    	     else if( dDOSFromDtDB.compareTo(dLastUpdatedDB)>0)
							    	     {
							    	    	  sExpectedDOSToDate = sDOSFromDBValue;
							    	    	  logger.info("DOS From date is greater than LastUpdated Date for  CPTICDLinksKey ::"+LinkKeys.get(k)+" so checking if DOS_TO=DOS_FROM in TargetTable");
							    	      } 							    	     
							    	     
								    	   //Retrieve DOSTo date for each Links Key and and check whether it is set as expected date as above
								    	     sQuery1 = "Select TO_Char(DOS_TO,'dd/mm/yyyy') from LCD."+sTargetTableName+" where "+ sLCDArticleIDColName +"="
													 	+ Serenity.sessionVariableCalled("ID") +  " and "+sVersionColName+"="+iVersionNo+"  and "+sCPTICDLinksKeyColName+" = "+LinkKeys.get(k);
									
												 	 sDOSToDBValue = DBUtils.executeSQLQuery(sQuery1);					 				 		
												  	 									    	 
								    	          if(sDOSToDBValue.compareTo(sExpectedDOSToDate)==0)
								    	          {
								    	        	     logger.info("DOSTo date value is Datebanded to Expected Date :: "+sExpectedDOSToDate + " for CPTICDLinksKey ::"+LinkKeys.get(k)+" and for ID ::" +Serenity.sessionVariableCalled("ID"));
							 					    	 Assert.assertTrue("DOSTo date value is Datebanded to Expected Date ::"+sExpectedDOSToDate+ " for CPTICDLinksKey ::"+LinkKeys.get(k)+" and for ID ::" +Serenity.sessionVariableCalled("ID"),true);	  			 				       
				 				 		            }   
							 				 		else
							 				 		{
							 				 			 logger.info("DOSTo date value is Not Datebanded to Expected Date :: "+sExpectedDOSToDate + " for CPTICDLinksKey ::"+LinkKeys.get(k)+" and for ID ::" +Serenity.sessionVariableCalled("ID"));
							 					    	 Assert.assertTrue("DOSTo date value is Not Datebanded to Expected Date ::"+sExpectedDOSToDate+ " for CPTICDLinksKey ::"+LinkKeys.get(k)+" and for ID ::" +Serenity.sessionVariableCalled("ID"),false);	
							 				 		}		    	     
		              
		    	                    }          
			 
	                }	 
   
		  	 }//end of Method	
	
	public void captureOpendatedRecord(String sLCD_Article, String sVersion) throws Exception 
	{	
		 String sTableName="";
		  String sQuery="";
		  List<String> LinkKeys=null;		  		
		  String sCPTICDLinksKeyColName="";
		  String sLCDArticleIDColName="";
		  String sVersionColName="";
		  
		int iVersion= Integer.parseInt(sVersion);
				
		if (sLCD_Article.equalsIgnoreCase("LCD")) 
		{
			sTableName = "LCD_CPT_ICD_LINKS";
 			sLCDArticleIDColName = "LCD_ID";			
			sVersionColName = "LCD_VERSION";
			sCPTICDLinksKeyColName=  "LCD_CPT_ICD_LINKS_KEY";	   
			
		} else if (sLCD_Article.equalsIgnoreCase("Article"))
		{
			sTableName = "ARTICLE_CPT_ICD_LINKS";
			sLCDArticleIDColName = "ARTICLE_ID";			
			sVersionColName = "ARTICLE_VERSION";
			sCPTICDLinksKeyColName = "ARTICLE_CPT_ICD_LINKS_KEY";
		}
		  		
			//Query to retrieve all CPT_ICD_LINKS_KEY codes associated with the new Manually added ICD Code
			sQuery = "Select "+sCPTICDLinksKeyColName+" from LCD." + sTableName + " where "+sLCDArticleIDColName+"="+ Serenity.sessionVariableCalled("ID") + " and TO_CHAR(DOS_TO,'dd-mm-yyyy')='31-12-9999'  and "+sVersionColName+" ="+iVersion;

			//Storing the HCPC Codes in the ArrayList
			LinkKeys = DBUtils.executeSQLQueryMultipleRows(sQuery);			
            Serenity.setSessionVariable("LCD_Article_LinkKeys").to(LinkKeys); 	
		
	}		
		
}
