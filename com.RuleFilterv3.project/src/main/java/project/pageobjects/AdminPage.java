

package project.pageobjects;


import java.awt.Robot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.seleniumhq.jetty9.util.StringUtil;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import project.utilities.DBQueries;
import project.utilities.DBUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;


public class AdminPage extends PageObject
{	
	
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AdminPage.class);
	
	DBUtils  oDBUtils;
	HomePage oHomePage;
	DBQueries oDBQueries;
	
	String sColVal="";
	
	int ColIndex=0;
	
	@FindBy(xpath = "//a[text()='Target Data']")
	public WebElementFacade TargetDataTab;
	
	@FindBy(xpath = "//a[@id='Reassign']")
	public WebElementFacade ReassignBtn;
	
	@FindBy(xpath="//a[text()='Admin']")
	public WebElementFacade AdminTab;
	
	@FindBy(xpath="//h1[text()='CPT ICD Link-Admin']")
	public WebElementFacade AdminPageTitle;
		
	@FindBy(xpath = "//div[@id='dropdownlistArrowngxDropDownList6']")
	public WebElementFacade AssigneeDropDown;	
			
	@FindBy(xpath = "//div[@id='ngxScrollBtnDownverticalScrollBarinnerListBoxngxDropDownList6']")
	public WebElementFacade AssigneeDropDownScrollDownButton;	

	@FindBy(xpath = "//div[@id='filterinnerListBoxngxDropDownList6']/input")
	public WebElementFacade AssigneeDrpDownSearchBox;
	
	@FindBy(xpath = "//div[@id='filterinnerListBoxngxDropDownList4']/input")
	public WebElementFacade CPTGroupDrpDownSearchBox;
		
	@FindBy(xpath="//button[@id='applyFilter']")
	public WebElementFacade ApplyFilter_Btn;
	
	@FindBy(xpath="//button[@id='clearFilter']")
	public WebElementFacade ClearAllFilters_Btn;
	
	@FindBy(xpath="//div[@class='ui-grid-pager-count']")
	public WebElementFacade pageItemsCount;
		
	@FindBy(xpath = "//div[@id='dropdownlistArrowngxDropDownList4']")
	public WebElementFacade CPTGroupDropDown;	
	
	@FindBy(xpath =  "//div[@id='listBoxContentinnerListBoxngxDropDownList4']/div/div[1]")
	public WebElementFacade CPTGroupDropDownVal;
	
	@FindBy(xpath = "//div[@id='dropdownlistArrowcategory-drop-down']")
	public WebElementFacade CategoryDropDown;
	
	@FindBy(xpath = "//div[@id='filterinnerListBoxcategory-drop-down']/input")
	public WebElementFacade CategorySearchBox;
	
	@FindBy(xpath = "//div[@id='dropdownlistArrowngxDropDownList5']")
	public WebElementFacade ICDGroupDropDown;
	
	@FindBy(xpath =  "//div[@id='listBoxContentinnerListBoxngxDropDownList5']/div/div[1]")
	public WebElementFacade ICDGroupDropDownVal;	
	
	@FindBy(xpath = "//div[@id='filterinnerListBoxngxDropDownList5']/input")
	public WebElementFacade ICDGroupSearchBox;
			
	@FindBy(xpath = "//div[@id='dropdownlistContentappropriate_10-drop-down']")
	public WebElementFacade DecisionDropDown;
	
	@FindBy(xpath = "//div[@id='filterinnerListBoxappropriate_10-drop-down']/input")
	public WebElementFacade DecisionSearchBox;
	
	@FindBy(xpath = "(//div[@class='ui-grid-cell-contents ng-scope'])[1]/a")
	public WebElementFacade FirstReviewTaskID;	
	
	@FindBy(xpath = "//input[@value='Long View']")
	public WebElementFacade LongViewRadioButton;	
	
	@FindBy(xpath = "//input[@value='Short View']")
	public WebElementFacade ShortViewRadioButton;

	@FindBy(xpath = "(//div[@class='ui-grid-header-cell-row'])[2]//span[.='ID']/../following-sibling::div//input")	
	public WebElementFacade AdminIDColFilter;
	
	@FindBy(xpath = "(//div[@class='ui-grid-header-cell-row'])[2]//span[.='ICD Code']/../following-sibling::div//input")	
	public WebElementFacade AdminICDCodeColFilter;
	
	@FindBy(xpath = "(//div[@class='ui-grid-header-cell-row'])[2]//span[.='CPT/HCPCS Code']/../following-sibling::div//input")	
	public WebElementFacade AdminCPTHCPCColFilter;
		
	public String TargetDataColInputField = "(//div[@class='ui-grid-header-cell-row'])[2]//span[.='sColVal']/../following-sibling::div//input";	
			
	public String TargetDataCol =   "//div[@role='gridcell']["+"ColIndex"+"]";
	
	public String EditBoxes = "//input[@type='text'][@aria-label='Filter for column']";
			
	public String AssigneeDropDownValues = "//div[@id='listBoxContentinnerListBoxngxDropDownList6']//span[text()='sValue']/../div/div";
		
	public String AssigneeColumn = "//span[text()='Assignee']";
	
	public String AssigneeColumnDropDownIcon ="//div[@id='dropdownlistArrowngxDropDownList6']//div[@class='ngx-icon-arrow-down ngx-icon']";

	public String ColumnDropDownIcon ="//div[@id='sColName']//div[@class='ngx-icon-arrow-down ngx-icon']";
	
	public String AssigneeNameTag = "//span[contains(text(),'sValue')]";
	
	public String FilterTag = "//span[text()='sValue']";
	
	public String TargetDataColNames= "//span[text()='sValue']";
	
	public String CPTDescription =  "(//textarea[@id='cptDescTxt'])"; 
	
	public String CPTDescrTooltip =  "(//textarea[@id='cptDescTxt']/..//span)"; 
	
	public String ICDDescription =  "(//textarea[@id='icdDescTxt'])"; 
	
	public String ICDDescrTooltip =  "(//textarea[@id='icdDescTxt']/..//span)"; 
	
	public String ICDGroupVal = "//div[@id='listBoxContentinnerListBoxngxDropDownList5']//span[text()='sValue']";

	@FindBy(xpath = "//div[@id='listBoxContentinnerListBoxngxDropDownList1']//div[2]//div[1]")	
	public WebElementFacade StatusStarted;
	
	public String Status ="//div[@id='listitemsValueinnerListBoxngxDropDownList1']/div[1]/div";
	// public String Status="//span[text()='sValue']//parent::div/div[@class='chkbox']";
	
	@FindBy(xpath = "//div[@id='dropdownlistArrowngxDropDownList1']")	
	public WebElementFacade AdminStatusDropDown;
	
	public String SelectRA_Cmb = "//span[text()='Please select RA']/ancestor::div[@class='ngx-dropdownlist-content']/following-sibling::div";
	
	public String sRAUser = "(//span[text()='iht_ittest05'])[1]";

	public String sCheckbox_Two = "(//div[@row-render-index='rowRenderIndex']/div/div/div/div)[2]";
	
	public String sCheckbox_One = "(//div[@row-render-index='rowRenderIndex']/div/div/div/div)[1]";	
	
	public String AssigneeDropDownIcon ="//div[@id='dropdownlistArrowngxDropDownList6']";


	//=======================================================================================================================
	
	public String sTargetDataColHeaderTxt = "(//div[@class='ui-grid-header-cell-row'])[2]//span[.='sHeaderName']/../following-sibling::div//input";
	
	public String sTargetDataColHeaderCmb = "(//div[@class='ui-grid-header-cell-row'])[2]//span[.='sHeaderName']/../following-sibling::div//span";
	
	public String sTargetDataHistoryCol = "(//div[@class='ui-grid-header-cell-row'])[2]//span[.='History']";
	
	public String sHistoryLink = "//a[.='History']";
	
	public String sTargetDataLCD_ID_HeaderValue = "//li[contains(text(),'LCD/Article Id')]/following-sibling::li[1]/b";
	
	public String sTargetDataHeaderValue = "//li[.='sHeaderName']/following-sibling::li[1]/b";
	
	public String sDecisionCol = "//div[@role='gridcell'][3]";
	
	public String sJurisidictionCol = "//div[@role='gridcell'][12]";
	
	public String sRemarksCol = "//div[@role='gridcell'][4]";
	
	public String sDecisionReasonCol = "//div[@role='gridcell'][5]";
	
	public String sDosToCol = "//div[@role='gridcell'][8]";
	
	public String sDecision = "//div[@role='gridcell'][9]";
	
	public String sRemarks = "//div[@role='gridcell'][13]";
	
	public String sTargetDataColSortIcon = "(//div[@class='ui-grid-header-cell-row'])[2]//span[.='sHeaderName']/following-sibling::span";
	
	public String sColHeader = "(//div[@class='ui-grid-header-cell-row'])[2]//span[.='sHeaderName']";

	public String SelectRuleInAdmin="(//div[@class='ui-grid-cell-contents'])[2]/child::div";

	public String AdhocCategoryTextBox="(//input[@ng-model='colFilter.term'])[7]";

	public String ReviewDecisionTextbox="(//input[@ng-model='colFilter.term'])[8]";

	public String ReasonCommentSection="(//input[@ng-model='colFilter.term'])[10]";
	
	public String LCD_ArticleIDTextBox="(//input[@ng-model='colFilter.term'])[1]";
	
	public String sDataIntrgtButton =  "//button[@id='dataIntegrityRecrd']";
	
	public String sPopupText   =  "//h4[contains(text(),'Data Integrity Records')]";
	
	public String  sPopupDoalog =   "//div[@class = 'modal-content']";
	
	public String sDataIntegrityGridColumnHdr = "//h4[text()='Data Integrity Records']//parent::div//following-sibling::div//div[@role='rowgroup']//div[number]/div[@role='columnheader']/div/span[text()='columnname']";
	
	public String sDataIntegritySortingType ="//h4[text()='Data Integrity Records']//parent::div//following-sibling::div//div[@role='rowgroup']//div[number]/div[@role='columnheader']/div//span[contains(@aria-label,'arg')]";
	
	public String sDataIntegrityGridColTextBox = "//h4[text()='Data Integrity Records']//parent::div//following-sibling::div//div[@role='rowgroup']//span[text()='sValue']//parent::div//following-sibling::div//input";
			
//=======================================================================================================================
			
	public boolean clicksOnTargetDataTab() {			
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);		
		SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);	
		oSeleniumUtils.Click_given_WebElement(TargetDataTab);		
		 //Wait till the Data loads in the page
	    oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
	    logger.info("TargetData Tab screen opened");
	    return TargetDataTab.withTimeoutOf(ProjectVariables.MIN_TIME_OUT,TimeUnit.SECONDS).waitUntilVisible().isDisplayed();
	}
		
	public boolean validateAssigneeFilterDropDown(String sValuesToSelect) throws Exception
	{   						
		String AssigneeName="";
		String[]  AssigneeNames=null;		
		int allItemsDBCount;
		int allItemsUICount;
		int allUsersDBCount;
		int allUsersUICount;
		int multipleUsersDBCount;
		int multipleUsersUICount;
		int singleUsersDBCount;		
		boolean filterResult=false;
		int singleUsersUICount;			
		
				SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		  	   		 								
				if (sValuesToSelect.equalsIgnoreCase("None"))			
				{			
					//allItemsDBCount = Integer.parseInt(DBUtils.executeSQLQuery(DBQueries.sAllItemsCount_Admin_TargetTab_Query_LCD_Article));						
					allItemsDBCount =  Integer.parseInt(DBUtils.executeSQLQuery("Select count(*) from (SELECT * FROM LCD.LCD_CPT_ICD_LINKS UNION  SELECT * FROM LCD.ARTICLE_CPT_ICD_LINKS)"));
					allItemsUICount = retrievePageItemsCount("","AdminTargetData");
										
					 if(allItemsDBCount==allItemsUICount)
					 {
						System.out.println("Admin default selection items count matched between DB and UI "+"DBCount: "+allItemsDBCount+"UI Count: "+allItemsUICount);
						filterResult = true;																	
					  }						 
					 else
					  {						 
						 System.out.println("Admin default selection items count Not matched between DB and UI "+"DBCount: "+allItemsDBCount+"UI Count: "+allItemsUICount); 
						 filterResult = false; 						 
					  }
					
				   }				
				
				else if (sValuesToSelect.equalsIgnoreCase("All"))					
				{					
					SeleniumUtils.scrollingToGivenElement(getDriver(), AssigneeColumnDropDownIcon);						
					oSeleniumUtils.Click_given_WebElement(AssigneeDropDown);				 					 
									
					//Get all Assignee values from the DB and store it in the list
					//ArrayList<String> assigneeList=DBUtils.executeSQLQueryMultipleRows(DBQueries.sAdminTargetTabAssigneeNames);
					
					ArrayList<String> assigneeList = DBUtils.executeSQLQueryMultipleRows("SELECT distinct DECISION_USER AS ASSIGNEE FROM LCD.LCD_CPT_ICD_LINKS "+
																		" Union SELECT distinct DECISION_USER AS ASSIGNEE FROM LCD.ARTICLE_CPT_ICD_LINKS");
							
					//Iterate through the list of Assignees
					for (int k=0;k<assigneeList.size();k++)
					{
						System.out.println("Assignee Name :"+assigneeList.get(k));	
						AssigneeName = assigneeList.get(k).trim();
						AssigneeDrpDownSearchBox.sendKeys(assigneeList.get(k));	
						SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
						
						try{
							oSeleniumUtils.Click_given_Locator(StringUtils.replace(AssigneeNameTag, "sValue", AssigneeName));
						   }
						catch(Exception e){
							getDriver().quit();
							throw new Exception("Given Assignee Name not present in the application dropdown");
						}
						
						    AssigneeDrpDownSearchBox.clear();
					}	
					
					  //Click Apply Filter Button
					   ApplyFilter_Btn.click();		
					   
					   //Wait till the Data loads in the page
					    oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
										
					   //Retrieve page items Count	
					   allUsersUICount = retrievePageItemsCount("","AdminTargetData");
						 
					   SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);		
						
					  //Retrieve DB Count					
					   //allUsersDBCount = Integer.parseInt(DBUtils.executeSQLQuery(DBQueries.sAllItemsCount_Admin_All_Assignee_Query));
					   
					   //Added Query here as if the above query is in the DBQueries file the Query is returning count as 0
					   allUsersDBCount = Integer.parseInt(DBUtils.executeSQLQuery("Select count(*) from (SELECT * FROM LCD.LCD_CPT_ICD_LINKS UNION "+
						 " SELECT * FROM LCD.ARTICLE_CPT_ICD_LINKS "+
						 "	Where DECISION_USER in(SELECT distinct DECISION_USER AS ASSIGNEE FROM LCD.LCD_CPT_ICD_LINKS "+
					      " UNION  SELECT distinct DECISION_USER AS ASSIGNEE FROM LCD.ARTICLE_CPT_ICD_LINKS ))"));
					 
					 //Compare UI Count and DBcount by executing Query	
					    if(allUsersDBCount==allUsersUICount)
						 {
					    	filterResult= true;
							System.out.println("Admin All Assginee users selection items count :"+" matched between DB and UI"); 							 
						  }						
					    else{					    	
					    	 System.out.println("Admin All Assginee items count matched between DB and UI ");
					    	 filterResult= false;
					       }
					  
					  //Clear Filters
					  ClearAllFilters_Btn.click();
					  
					  //Wait till the Data loads in the page
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
					  
			     	}
						
				else if (sValuesToSelect.contains("-"))
				{		
				  
					 SeleniumUtils.scrollingToGivenElement(getDriver(), AssigneeColumnDropDownIcon);	
					 oSeleniumUtils.Click_given_WebElement(AssigneeDropDown);				
					
				     //Split the Values by hyphen(-)					
				     AssigneeNames= sValuesToSelect.split("-");	
					
					for (String AssgnName:AssigneeNames)
					{
						AssigneeDrpDownSearchBox.sendKeys(AssgnName);
						SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
						oSeleniumUtils.Click_given_Locator(StringUtils.replace(AssigneeNameTag, "sValue", AssgnName));						
						AssigneeDrpDownSearchBox.clear();						
					}		
										
     				//Store the Assignees in session variables to replace them in the SQL query
					Serenity.setSessionVariable("AdminAssigneeUser1").to(AssigneeNames[0]);					
					Serenity.setSessionVariable("AdminAssigneeUser2").to(AssigneeNames[1]);
					Serenity.setSessionVariable("AdminAssigneeUser3").to(AssigneeNames[2]);
											
					
					   //Click Apply Filter Button					
					    ApplyFilter_Btn.click();
					  
					   //Wait till the Data loads in the page
					    oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
					  							
					  //Execute Query to retrieve value
					 // multipleUsersDBCount = Integer.parseInt(DBUtils.executeSQLQuery(DBQueries.sAdminTargetTabAssigneeFilterDBCount));
					  
					    //Added Query here as if the above query is in the DBQueries file the Query is returning count as 0
					  multipleUsersDBCount =  Integer.parseInt(DBUtils.executeSQLQuery( "Select count(*) from (SELECT * FROM LCD.LCD_CPT_ICD_LINKS where DECISION_USER in("+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser1")+"'"+","+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser2")+"'"+","+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser3")+"'"+") UNION "
								+" SELECT * FROM LCD.ARTICLE_CPT_ICD_LINKS where DECISION_USER in("+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser1")+"'"+","+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser2")+"'"+","+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser3")+"'"+"))"));
					  
					  //Retrieve page items Count	
					  multipleUsersUICount = retrievePageItemsCount("","AdminTargetData");							 					 
					 if(multipleUsersDBCount==multipleUsersUICount)
					 {
						 filterResult=true; 
						 System.out.println("Admin Multiple Assginee users selection items count :"+" matched between DB and UI"); 
					  }		
					 else{
						 
						 System.out.println("Admin Multiple Assginee users count Not matched between DB and UI ");
						 filterResult=false;
					 }
					 
					//Clear Filters
					ClearAllFilters_Btn.click();
					 
					//Wait till the Data loads in the page
				     oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
					 
			 	}
				
				else if (sValuesToSelect.contains("OneUser"))					
				{
					
				 //Scroll drop down element in to view	
				  SeleniumUtils.scrollingToGivenElement(getDriver(), AssigneeColumnDropDownIcon);
				  
				  //Click on the Assignee drop down	
				   oSeleniumUtils.Click_given_WebElement(AssigneeDropDown);
					
				   //Split the Values by hyphen(-)					
				   AssigneeNames= sValuesToSelect.split(":");
				   AssigneeName = AssigneeNames[1];  //Take second value after colon for Assignee Name
				   
				   AssigneeDrpDownSearchBox.sendKeys(AssigneeName);						
					oSeleniumUtils.Click_given_Locator(StringUtils.replace(AssigneeNameTag, "sValue", AssigneeName));						
					AssigneeDrpDownSearchBox.clear();
					
					 //Click Apply Filter Button					
					  ApplyFilter_Btn.click();		
					  
					  //Wait till the Data loads in the page
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);								 
					
					 
					//Store the Assignees in session variables to replace them in the SQL query
					 Serenity.setSessionVariable("AdminAssigneeOneUser").to(AssigneeName);				 
					 
					 SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
					 					
					//Execute Query to retrieve value
					 //singleUsersDBCount = Integer.parseInt(DBUtils.executeSQLQuery(DBQueries.sAdminTargetTabAssigneeFilterSingleUser));		
					 singleUsersDBCount =Integer.parseInt(DBUtils.executeSQLQuery("Select count(*) from (SELECT * FROM LCD.LCD_CPT_ICD_LINKS where DECISION_USER ="+"'"+ Serenity.sessionVariableCalled("AdminAssigneeOneUser")+"'"+" UNION "+ 
								" SELECT * FROM LCD.ARTICLE_CPT_ICD_LINKS where DECISION_USER ="+"'"+Serenity.sessionVariableCalled("AdminAssigneeOneUser")+"'"+")"));
					 

					 //Retrieve page items count
					 singleUsersUICount = retrievePageItemsCount("","AdminTargetData");
					 
					 
					 if(singleUsersDBCount==singleUsersUICount)
					 {						 
						 filterResult=true;
						 System.out.println("Admin One Assignee users selection items count :"+" matched between DB and UI"); 
					  }		
					 else
					 {
						 System.out.println("Admin One Assignee User items count matched between DB and UI ");
						 filterResult=false;
					 }
					 					 
					 //Clear Filters
					 ClearAllFilters_Btn.click();
				     //Wait till the Data loads in the page
				     oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);		
				     
				 }			
				
				return filterResult;
				
				
		 	}//End of Method
		
	public void Check_The_Given_ColumnValue(String sColumnValue) {
		   
		int icount = 0; 
		
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
	    
	    do {
	         icount = getDriver().findElements(By.xpath(StringUtils.replace(AssigneeNameTag,"sValue",sColumnValue))).size();                
	         AssigneeDropDownScrollDownButton.click();
	         
	        } while (icount == 0);
	    
	       AssigneeDropDownScrollDownButton.click();
	       AssigneeDropDownScrollDownButton.click();
	       
	      oSeleniumUtils.Click_given_Locator(StringUtils.replace(AssigneeNameTag, "sValue", sColumnValue));	         
	
	}		
	
	public int retrievePageItemsCount(String ColName,String TaborScreenName) throws Exception {
		  
	  int ItemsCount=0;
	  String ItemsCountText="";
	  String[] ItemCountArr1;
	  String[] ItemCountArr2;	  
		  
	 switch(TaborScreenName){		  			
		  case "AdminTargetData":
		  case "GroupTask":
		  case "AdminScreen":
		  case "AdhocReviewTab":
			      ItemsCountText = pageItemsCount.getText();  
		  case "IndividualTask":
			 ItemsCountText = pageItemsCount.getText();     
		     break;		  
		  case "AdminWorkQueuePage":		  
			  ItemsCountText = pageItemsCount.getText();     
			   break;
			   
		  default:  logger.info("No input is provided for the Switch Case");          			
		  			Assert.assertTrue("Provided invalid case value",false);		
			}	
	
	     //Retrieving the ItemsCount from the String	   
		  if (ItemsCountText.isEmpty()){	 	    	
		  	 return 0;		  		    		    	  
		    } else{			    	  
		  	 ItemCountArr1 = ItemsCountText.split("of");
		  	 ItemCountArr2 = ItemCountArr1[1].split("items");
		  	 ItemsCount=  Integer.parseInt(ItemCountArr2[0].trim());
		     }		    
		  //Print the values
		  System.out.println(ColName+"  Items Count :->"+ItemsCount+ " for "+TaborScreenName);		      
		   
		  //Returning items count to the calling Method  
		   return ItemsCount;
	  }
	
	public String getTableColumnLocators(String sColumnName)
	{
		
		HashMap<String, String> oHashMap = new HashMap<String, String>();
				
		oHashMap.put("LCD_ArticleList", "//div[@role='gridcell'][1]");
		oHashMap.put("CPTCodeList", "//div[@role='gridcell'][2]");
		oHashMap.put("CPTGroupList", "//div[@role='gridcell'][3]");
		oHashMap.put("ICDCodeList", "//div[@role='gridcell'][4]");
		oHashMap.put("ICDGroupList", "//div[@role='gridcell'][5]");
		oHashMap.put("CategoryList", "//div[@role='gridcell'][6]");
		oHashMap.put("DOSFromList", "//div[@role='gridcell'][7]");
		oHashMap.put("DOSToList", "//div[@role='gridcell'][8]");
		oHashMap.put("DecisionList", "//div[@role='gridcell'][9]");
		
		return oHashMap.get(sColumnName);
		
	}
	
	public boolean fn_Validate_Multiple_Filters_TargeData() throws Exception
	{		
	    
	    List<WebElement> sList = null;
	    List<WebElement> LCD_Articles=null;	   
	    List<WebElement> CPTCodeGroups=null;	
	    List<WebElement> ICDCodes=null;
	    List<WebElement> ICDGroups=null;
	    List<WebElement> Categories=null;
	    List<WebElement> DOSFromVals=null;
	    List<WebElement> DOSToVals=null;
	    List<WebElement> Decisions=null;
	    List<WebElement> CPTCodes=null;
	  
	    
	    String ID="";    
	    String CPTCode="";
	    String CPTCodeGroup="";
	    String ICDCode="";	  
	    String DOSFrom="";
	    String DOSTo="";
	    String Category="";	   
	    int sAllItemsCount_Admin_TargetTab_UI;	   
	    String Decision="";	 	
	    int CMSID=0;	    
	    String sICDCodeGroup;
	    boolean compare;	    
	    int multipleFiltersDBCount=0;
	    int CategoryVal=0;
	    int DecisionVal=0;
	   
	    
	    SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
	    
	    //Capture LCD/ArticleValue
	    LCD_Articles = getDriver().findElements(By.xpath(getTableColumnLocators("LCD_ArticleList")));	    
	    
	    //Capture CPTCodeList values
	    CPTCodes = getDriver().findElements(By.xpath(getTableColumnLocators("CPTCodeList")));
	    
	    //Capture CPTGroupList values
	    CPTCodeGroups = getDriver().findElements(By.xpath(getTableColumnLocators("CPTGroupList")));
	    
	    //Capture ICDCodeList values
	    ICDCodes = getDriver().findElements(By.xpath(getTableColumnLocators("ICDCodeList")));	    
	    
	    //Capture ICDGroupList values
        ICDGroups = getDriver().findElements(By.xpath(getTableColumnLocators("ICDGroupList")));        
        
        //Capture CategoryList values
        Categories = getDriver().findElements(By.xpath(getTableColumnLocators("CategoryList")));
        
        //Capture DOSFromList values
        DOSFromVals = getDriver().findElements(By.xpath(getTableColumnLocators("DOSFromList")));        
        
        //Capture DOSToList values
        DOSToVals = getDriver().findElements(By.xpath(getTableColumnLocators("DOSToList")));
        
        //Capture DecisionList values
        Decisions = getDriver().findElements(By.xpath(getTableColumnLocators("DecisionList")));
        	    
	 	           	               
	           //Capture First Value from UI and enter into the Edit Boxes          
	           ID = LCD_Articles.get(12).getText();	            
	           CPTCodeGroup= CPTCodeGroups.get(12).getText();
	           CPTCode = CPTCodes.get(12).getText();
	           ICDCode= ICDCodes.get(12).getText();
	           sICDCodeGroup= ICDGroups.get(12).getText();
	           Category= Categories.get(12).getText();
	           DOSFrom = DOSFromVals.get(12).getText();
	           DOSTo = DOSToVals.get(12).getText();  
	           Decision = Decisions.get(12).getText();
	           
	           //ICD Code taking partial value
	           ICDCode = ICDCode.substring(0,4);
	          
	         	            
	            //Retrieve web edit objects  and enter values in the edit boxes     
	            sList = getDriver().findElements(By.xpath(EditBoxes));	            
	            enterValue(sList,0,ID);	                       
	            enterValue(sList,1,CPTCode);            
	            enterValue(sList,2,ICDCode);            
	            enterValue(sList,3,DOSFrom);            
	            enterValue(sList,4,DOSTo); 
	            CMSID = Integer.parseInt(LCD_Articles.get(1).getText()); 
	            
	            //Select category value from the drop down based on the value captured from UI
		        if (Category.equalsIgnoreCase("Support")) { CategoryVal=-1; }
		        else if (Category.equalsIgnoreCase("Does Not Support")) { CategoryVal=0; }
		      
	            
		        if (Decision.equalsIgnoreCase("Accept"))  { DecisionVal=-1; }
		        else if (Decision.equalsIgnoreCase("Reject")) { DecisionVal=0; }
		        
		        
	           //Store the ID in session variables to replace them in the SQL query
				 Serenity.setSessionVariable("CMSID").to(CMSID);
				 Serenity.setSessionVariable("CPTCode").to(CPTCode);
				 Serenity.setSessionVariable("ICDCode").to(ICDCode);
				 Serenity.setSessionVariable("DOSFrom").to(DOSFrom);
				 Serenity.setSessionVariable("DOSTo").to(DOSTo);
				 Serenity.setSessionVariable("ICDCodeGroup").to(sICDCodeGroup);
				 Serenity.setSessionVariable("CPTCodeGroup").to(CPTCodeGroup);
				 Serenity.setSessionVariable("Category").to(CategoryVal);
				 Serenity.setSessionVariable("DecisionVal").to(DecisionVal);
				 
				 
				 //Drop downs
				 //Category
				 CategoryDropDown.click();
				 CategorySearchBox.sendKeys(Category);						
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(FilterTag, "sValue", Category));						
				 CategorySearchBox.clear();	
				 
				 //ICDGroup
				 ICDGroupDropDown.click();
				 ICDGroupDropDownVal.click();	
					
				 
				 //Decision
				 DecisionDropDown.click();
				 DecisionSearchBox.sendKeys(Decision);						
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(FilterTag, "sValue", Decision));						
				 DecisionSearchBox.clear();					 		 
				 
			        
				 //Click on CPTGroup drop down		     
	              CPTGroupDropDown.click();	
	              CPTGroupDropDownVal.click();	
	              
				//Store the CPTCodeGroup in session variables to replace them in the SQL query
				 Serenity.setSessionVariable("CPTCodeGroup").to(CPTCodeGroup);
	           		              		 	              
	              	            
	             //Apply Filter           	  
	             ApplyFilter_Btn.click();				   
	             oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
				     
				 //Capture RuleCount from UI
				 sAllItemsCount_Admin_TargetTab_UI = retrievePageItemsCount("","AdminTargetData");
				 
				 				 				    				    
				  //Execute Query to retrieve value
				  multipleFiltersDBCount = Integer.parseInt(DBUtils.executeSQLQuery(DBQueries.sAdminMultipleFiltersCountQuery));    
				  		  			   				  						  
					
					//Compare the DB count and UI Count 
					if(sAllItemsCount_Admin_TargetTab_UI==multipleFiltersDBCount)
					{					
					  System.out.println("DB and UI count matched after filter applied"); 
			         }else{
			        	 System.out.println("DB and UI count Not matched after filter applied"); 			        		        	 
			          }									
								
					
										
				if(sAllItemsCount_Admin_TargetTab_UI==multipleFiltersDBCount)
				{									   
				    compare = CompareDB_UIColumnValues(DBQueries.sAdminMultipleFiltersQuery, "LCD_ID",getTableColumnLocators("LCD_ArticleList"));			    
				    if(compare)
			         {
			          System.out.println("DB and UI comparison matched for CMSID"); 
			         }
			       else{
			             getDriver().quit();
			             throw new Exception("DB and UI comparison matched for CMSID");			        	 
			          }
					    
				     
			     	}  			    	
	             
			return true;		
	   }	
	 	 	 
	public boolean enterValue(java.util.List<WebElement>  columnList, int columnNo,String sCode)
	    {
		 	    	 
	    	 try{
	    		columnList.get(columnNo).click();
		         
		         System.out.println("size:="+columnList.size());		              
		         System.out.println("IS DISPLAYED:="+columnList.get(columnNo).isDisplayed());
		         JavascriptExecutor js=(JavascriptExecutor) getDriver();
		         js.executeScript("arguments[0].value=arguments[1];", columnList.get(columnNo),sCode);	              
		
		         Robot robot = new Robot();  
		         robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
	    	 }
	    	   catch (Exception e) {
	           System.out.println("Element not present");
	           System.err.println(e);
	           getDriver().close();
	           return false; 
	           }
	    	 
	    	 return true;
	    	
	    }	
		 
	public  boolean CompareDB_UIColumnValues(String sqlQuery, String sColumn,String ColumnXpath) throws Exception {
									
			List<WebElement> colValuesList = null;			
			boolean comparisionSuccessfull=true;
			int k=0;
			int m=0;
	          
	          //Finding all UI elements and adding in the list             
	          colValuesList = getDriver().findElements(By.xpath(ColumnXpath));
	          
	          //Capture all DB column values
	          List<String> sDBColValList = DBUtils.db_GetAllColumnvalues(sqlQuery,sColumn);
					
		      int idFound=0;
				
				  //Compare DB column values with the UI values
				  for(k=0;k<sDBColValList.size();k++)				
				  {
					 idFound=1;
					 for  (m=k;m<colValuesList.size();m++)		
					  {
						 if((colValuesList.get(m).getText().trim().isEmpty()) && (sDBColValList.get(k).trim().isEmpty())){
							 System.out.println("After comparision :" + "Column value for " + sColumn +" matched for DB and UI");
							  idFound=1;
							  break; 
						 }
						 if ((colValuesList.get(m).getText()).equalsIgnoreCase(sDBColValList.get(k)))
						  {
							  System.out.println("After comparision :" + "Column value for " + sColumn +" matched for DB and UI");
							  idFound=1;
							  break;
						  }//end of if
					  }//end of inner For
				   
					   if(idFound==0)
					   {
						 System.out.println("After comparision :" + "DB value not available in UI"+"DB Value: "+sDBColValList.get(k));
						 comparisionSuccessfull =false;	
						 break;
					   }
		          
				  }//End of For	
				  
			  return comparisionSuccessfull;
			
		}

	public boolean clicksFirstReviewTaskID() {
			
		boolean breviewTask=true;
			
		
	   //Filter the Review Status "Started" in the column		
		AdminStatusDropDown.click();		
	    oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		StatusStarted.click();
		AdminStatusDropDown.click();
		oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);
		
    try{
    	   	
		//Capture the ID
		String TaskID = FirstReviewTaskID.getText();				
		FirstReviewTaskID.click();	
		
		//Wait till the Data loads in the page
	    oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	    
	    System.out.println("Task Id is: "+TaskID);	 
	    
      }catch(Exception e)
	   {
    	  breviewTask =false;
		}	
    
    return breviewTask;
    }

	public boolean selectRadioButton(String arg1) {
		
		 boolean bSelectRadioBtn=true;
		
	    try{			
	    	SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);							
			oSeleniumUtils.Click_given_WebElement(LongViewRadioButton);
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);	
	      }catch(Exception e)
		   {
	    	  bSelectRadioBtn=false;
			}
	    
	     return bSelectRadioBtn;
	}

	public boolean validateToolTipDescription(int loopMaxCntr,String sCPTICDDescriptionTooltip,String DBValidation) {
		
		String  sCPTDescr="";
		String  sCPTToolTip="";
		String sTooltipText="";
		String sICDDescr="";
		String sICDDescrToolTip="";
		String sCPTDescriptionUI="";
		String sValidateDB="";
		int loopMaxCounter=0;
		boolean validateToolTipDescription=true;
		String sCheckDescription="";
		sValidateDB= DBValidation;
		String sICDDescriptionUI="";
		//CPT Code Description	
		String sCPTDDescrQry="";

		//ICD Code Description	
		String sICDDescrDBQry="";
		
		sCheckDescription=sCPTICDDescriptionTooltip;				
		loopMaxCounter=loopMaxCntr;	
			
		
		if  (sCheckDescription.equalsIgnoreCase("CPT")){
			  sCPTDDescrQry = "SELECT  LONG_DESC FROM MDM.CPT_MASTER CM where CPT_CODE IN ("+"'"+Serenity.sessionVariableCalled("CPTCodeOne").toString()+"'"+")";
				}
		
		else if  (sCheckDescription.equalsIgnoreCase("ICD")){			
			sICDDescrDBQry = "Select ICD_DESC FROM MDM.DIAG_MASTER CM where ICD_CODE IN ("+"'"+Serenity.sessionVariableCalled("ICDCodeOne").toString()+"'"+")";
		}
		
		
		if  ((sCheckDescription.equalsIgnoreCase("CPT")) || (sCheckDescription.contains("Both")))
		{						
			  for (int k = 1; k <= loopMaxCounter; k++) 
					{
						 try {
								sCPTDescr = CPTDescription+"[" + k + "]";
								SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
								WebElement elemnt = getDriver().findElement(By.xpath(sCPTDescr));
								Actions action = new Actions(getDriver());
								action.moveToElement(elemnt).build().perform();								
								sCPTToolTip = CPTDescrTooltip+"[" + k + "]";				
								
								try{
									sTooltipText = getDriver().findElement(By.xpath(sCPTToolTip)).getText();
									System.out.println("CPT tooltip text: " + sTooltipText);
									
									sCPTDescriptionUI = getDriver().findElement(By.xpath((sCPTDescr))).getText();
									System.out.println("CPT Description:"+sCPTDescriptionUI);
									
									//Compare tool tip text and text box text
									if (sTooltipText.equalsIgnoreCase(sCPTDescriptionUI)) {
										System.out.println("Tooltip Text and actual description matched for CPT");
									}
									
									if(sValidateDB.equalsIgnoreCase("yes"))
									{
										String CPTDescrDB = DBUtils.executeSQLQuery(sCPTDDescrQry);
										if(sCPTDescriptionUI.equalsIgnoreCase(CPTDescrDB))
										{											
											System.out.println("Tooltip Text and DB description matched for CPT");
										 }										
										
									}									
									
								}catch (Exception e) {
									System.out.println("Tooltip Text not available for "+k+"th item");
									validateToolTipDescription=false;				}
				
							 } catch (Exception e) {}
				
					}//End of For loop
					
		}		
					
		
		
		if  ((sCheckDescription.equalsIgnoreCase("ICD")) || (sCheckDescription.contains("Both")))
		{
			for (int m = 1; m <= loopMaxCounter; m++) 
				{
						try {
							sICDDescr = ICDDescription+"[" + m + "]";
							SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
							WebElement elemnt =  getDriver().findElement(By.xpath(sICDDescr));
							Actions action = new Actions( getDriver());
							action.moveToElement(elemnt).build().perform();							
							sICDDescrToolTip = ICDDescrTooltip+"[" + m + "]";
							
							try{
								sTooltipText =  getDriver().findElement(By.xpath(sICDDescrToolTip)).getText();
								System.out.println("ICD tooltip text: " + sTooltipText);
								SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
								
								sICDDescriptionUI =  getDriver().findElement(By.xpath((sICDDescr))).getText();
								System.out.println("ICD Description:"+sICDDescriptionUI);
								// Compare tool tip text and text box text
								if (sTooltipText.equalsIgnoreCase(sICDDescriptionUI)) {
									System.out.println("Tooltip Text and actual description matched for ICD");
								}						
								

								if(sValidateDB.equalsIgnoreCase("yes"))
								{
									String ICDDescrDB = DBUtils.executeSQLQuery(sICDDescrDBQry);
									if(sICDDescriptionUI.equalsIgnoreCase(ICDDescrDB))
									{
										
										System.out.println("Tooltip Text and DB description matched for ICD");
									}
								}
								
								
							}catch (Exception e) {
								System.out.println("Tooltip Text not available for "+m+"th item");
								validateToolTipDescription=false;
								}
			
						} catch (Exception e)	{	}
		
		          	}	
		  }	
		
		return validateToolTipDescription;
	}

	public boolean validateToolTipDescriptionForSupportDontSupport() {
	
		int pageItemsCount=0;
		int loopMaxCounter=0;	
		
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);		
		
		
		//Support Tab	
	   try{			
			//Retrieve Page Items count to run the below loop	
			pageItemsCount= retrievePageItemsCount("SuportTab","AdminWorkQueuePage");
			
		   }catch(Exception e)
      		{			
			  System.out.println("Page items count Not retrieved");
		    }
		
		 if(pageItemsCount==0)
		 {
			  System.out.println("There is no data in the Support Tab so cannot validate the CPTICD Description Tooltip"); 
		 }
		 else if (pageItemsCount>=10)
		 {
			 loopMaxCounter=10;			 
		 }
		 
		 else if (pageItemsCount<=5)
		 {
			 loopMaxCounter=5;			 
		 }
			
		 
		 if(pageItemsCount!=0)
		 {
		 //Call method to validate Tool tip description
		 validateToolTipDescription(loopMaxCounter,"Both","No");  
		 }
		 
		 loopMaxCounter=0;	
       
		//Click on DoesNotSupportTab		 
		 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Does"));
		 
		//Retrieve Page Items count to run the below loop	
		 try{			 
		   pageItemsCount= retrievePageItemsCount("DoesNotSuportTab","AdminWorkQueuePage");			
		   }catch(Exception e) { 			
			  System.out.println("Page items count Not retrieved");
		    }
		
		 if(pageItemsCount==0)
		 {
			  System.out.println("There is no data in the DoesNotSupport Tab so cannot validate the CPTICD Description Tooltip"); 
			  
		 }
		 else if (pageItemsCount>=10)
		 {
			loopMaxCounter=10;			 
		 }
		 
		 else if (pageItemsCount<=5)
		 {
			loopMaxCounter=5;			 
		 } 	
		 
		 if(pageItemsCount!=0)
		 {		 
		  //Call method to validate Tool tip description
		   validateToolTipDescription(loopMaxCounter,"Both","No"); 		   
		 }
		
		return true; 
	}

	public boolean validateToolTipMaxLength(String arg1,String arg2) {
		
	String ICDCode="";
	String sCPTICDdescription="";
	String CPTCode="";
	String sTabName="";
	String LCDID_ICD="";
	String LCDID_HCPC="";	
	boolean bvalidateToolTip=false;
	
	sCPTICDdescription=arg1;
	sTabName=arg2;
	
	SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
	
	//Support Table
	 String sICDDescrSupportLCDID_ICD; 
     String sICDDescrSupportICDCode;
	 String sCPTDescrSupportLCDID_HCPC;
	 String sCPTDescrSupportHCPCCode;
	
	 //DoesNot Support Table
	  String sICDDescrDontSupportLCDID_ICD;
	  String sICDDescrDontSupportICDCode;
	  String sCPTDescrDontSupportLCDID_HCPC;
	  String sCPTDescrDontSupportHCPC;
		
	switch(sTabName)
	{
	
	  case "Support":		  		  
		
		sICDDescrSupportLCDID_ICD =  "SELECT DISTINCT SD.LCD_ID FROM LCD.LCD_CPT_ICD_SPRT_DELTA SD WHERE  SD.LCD_ID NOT in(Select LCD_ID from LCD.LCD_REVIEW_TASK GROUP BY LCD_ID HAVING COUNT(lcd_id) > 1 ) and  SD.ICD10_CODE IN (SELECT DISTINCT ICD_CODE FROM MDM.DIAG_MASTER DM WHERE LENGTH(DM.ICD_DESC) > 50)and rownum=1";		
		sICDDescrSupportICDCode =    "SELECT  DISTINCT  SD.ICD10_CODE FROM LCD.LCD_CPT_ICD_SPRT_DELTA SD WHERE  SD.LCD_ID NOT in(Select LCD_ID from LCD.LCD_REVIEW_TASK GROUP BY LCD_ID HAVING COUNT(lcd_id) > 1 ) and SD.ICD10_CODE IN (SELECT DISTINCT ICD_CODE FROM MDM.DIAG_MASTER DM WHERE LENGTH(DM.ICD_DESC) > 50) and rownum=1";		
		sCPTDescrSupportLCDID_HCPC =  "SELECT DISTINCT SD.LCD_ID FROM LCD.LCD_CPT_ICD_SPRT_DELTA SD WHERE  SD.LCD_ID NOT in(Select LCD_ID from LCD.LCD_REVIEW_TASK GROUP BY LCD_ID HAVING COUNT(lcd_id) > 1 ) and SD.HCPC_CODE IN (SELECT DISTINCT CPT_CODE FROM MDM.CPT_MASTER CM WHERE LENGTH(CM.LONG_DESC) > 50) and rownum=1";		
		sCPTDescrSupportHCPCCode =   "SELECT  DISTINCT  SD.HCPC_CODE FROM LCD.LCD_CPT_ICD_SPRT_DELTA SD WHERE  SD.LCD_ID NOT in(Select LCD_ID from LCD.LCD_REVIEW_TASK GROUP BY LCD_ID HAVING COUNT(lcd_id) > 1 ) and SD.HCPC_CODE IN (SELECT DISTINCT CPT_CODE FROM MDM.CPT_MASTER CM WHERE LENGTH(CM.LONG_DESC) > 50) and rownum=1";
				  
		  	
		  //ICD Code
		  if(sCPTICDdescription.equalsIgnoreCase("ICDDescription")){		  
			//Capture ID from the DB which has ID value	
			LCDID_ICD = DBUtils.executeSQLQuery(sICDDescrSupportLCDID_ICD);				
			ICDCode =  DBUtils.executeSQLQuery(sICDDescrSupportICDCode);
			Serenity.setSessionVariable("ICDCodeOne").to(ICDCode);
			
		  }	
			
		  //CPT Code
		  if(sCPTICDdescription.equalsIgnoreCase("CPTDescription")){			
			//Capture ID from the DB	
			LCDID_HCPC = DBUtils.executeSQLQuery(sCPTDescrSupportLCDID_HCPC);				
			CPTCode=  DBUtils.executeSQLQuery(sCPTDescrSupportHCPCCode);
			Serenity.setSessionVariable("CPTCodeOne").to(CPTCode);
			
		  }  
			
		  break;		  
		  
	  case "DoesNotSupport":	
	
		sICDDescrDontSupportLCDID_ICD =  "SELECT DISTINCT SD.LCD_ID FROM LCD.LCD_CPT_ICD_DONTSPRT_DELTA SD WHERE  SD.LCD_ID NOT in(Select LCD_ID from LCD.LCD_REVIEW_TASK GROUP BY LCD_ID HAVING COUNT(lcd_id) > 1 ) and  SD.ICD10_CODE IN (SELECT DISTINCT ICD_CODE FROM MDM.DIAG_MASTER DM WHERE LENGTH(DM.ICD_DESC) > 50)and rownum=1";
		sICDDescrDontSupportICDCode = "SELECT  DISTINCT  SD.ICD10_CODE FROM LCD.LCD_CPT_ICD_DONTSPRT_DELTA SD WHERE  SD.LCD_ID NOT in(Select LCD_ID from LCD.LCD_REVIEW_TASK GROUP BY LCD_ID HAVING COUNT(lcd_id) > 1 ) and SD.ICD10_CODE IN (SELECT DISTINCT ICD_CODE FROM MDM.DIAG_MASTER DM WHERE LENGTH(DM.ICD_DESC) > 50) and rownum=1";
		sCPTDescrDontSupportLCDID_HCPC=  "SELECT DISTINCT SD.LCD_ID FROM LCD.LCD_CPT_ICD_DONTSPRT_DELTA SD WHERE  SD.LCD_ID NOT in(Select LCD_ID from LCD.LCD_REVIEW_TASK GROUP BY LCD_ID HAVING COUNT(lcd_id) > 1 ) and SD.HCPC_CODE IN (SELECT DISTINCT CPT_CODE FROM MDM.CPT_MASTER CM WHERE LENGTH(CM.LONG_DESC) > 50) and rownum=1";
		sCPTDescrDontSupportHCPC =  "SELECT  DISTINCT  SD.HCPC_CODE FROM LCD.LCD_CPT_ICD_DONTSPRT_DELTA SD WHERE  SD.LCD_ID NOT in(Select LCD_ID from LCD.LCD_REVIEW_TASK GROUP BY LCD_ID HAVING COUNT(lcd_id) > 1 ) and SD.HCPC_CODE IN (SELECT DISTINCT CPT_CODE FROM MDM.CPT_MASTER CM WHERE LENGTH(CM.LONG_DESC) > 50) and rownum=1";
	  
		   
		    //ICD Code	
		  if(sCPTICDdescription.equalsIgnoreCase("ICDDescription")){
			  
			//Capture ID from the DB which has ID value	
		    LCDID_ICD = DBUtils.executeSQLQuery(sICDDescrDontSupportLCDID_ICD);				
			ICDCode =  DBUtils.executeSQLQuery(sICDDescrDontSupportICDCode);			
			Serenity.setSessionVariable("ICDCodeOne").to(ICDCode);
			
		   }
		  			
			//CPT Code
		  if(sCPTICDdescription.equalsIgnoreCase("CPTDescription")){
			  
			//Capture ID from the DB	
			LCDID_HCPC = DBUtils.executeSQLQuery(sCPTDescrDontSupportLCDID_HCPC);				
			CPTCode =  DBUtils.executeSQLQuery(sCPTDescrDontSupportHCPC);
			Serenity.setSessionVariable("CPTCodeOne").to(CPTCode);
			
		  }
		  
	        break;
	        

default:  logger.info("No input is provided for the Switch Case");
		  Assert.assertTrue("Provided invalid case value",false);
		
		}	
			if(sCPTICDdescription.equalsIgnoreCase("ICDDescription"))
			{						
			   //Click on Admin WorkQueue link				
			
				if (ApplyFilter_Btn.isVisible()) {
				
					oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Admin"));
				
				 
				//Wait till the Data loads in the page
				 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
				 
				}
					
				  if (LCDID_ICD.equalsIgnoreCase("")|| LCDID_ICD.equalsIgnoreCase(null))
				  {		  
					System.out.println("There no LCD/Article ID with ICD description greater than 200 or no data in the Support Tab ");
					bvalidateToolTip=true;
				  }else{
					  
					  //Enter the Filter value in the column	
						AdminIDColFilter.typeAndEnter(LCDID_ICD);
						
						SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
						
						//Click on the captured LCDID
						 FirstReviewTaskID.click();
						 
						//Wait till the Data loads in the page
						 oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
						 
						 

						 if(sTabName.equalsIgnoreCase("DoesNotSupport")){
							 
							 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Does")); 
						 }
						 
						
						//Click on "LongView Radio Button
						oSeleniumUtils.Click_given_WebElement(LongViewRadioButton);
						SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);	
						
						 AdminICDCodeColFilter.typeAndEnter(ICDCode);
						 
						 //Click on Apply Filter
						 ApplyFilter_Btn.click();
						
						//Wait till the Data loads in the page
					     oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
					     
					     //validate ToolTip description
					     validateToolTipDescription(1,"ICD","Yes");
					     bvalidateToolTip=true;
				    }     

			}  
			
			else if(sCPTICDdescription.equalsIgnoreCase("CPTDescription"))
			{
				
				
				if (ApplyFilter_Btn.isVisible()){	
					
					
				//Click on Admin WorkQueue link		
				oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Admin"));
				 
				//Wait till the Data loads in the page
			     oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);		
				
				}
						
				 if (LCDID_HCPC.equalsIgnoreCase("")|| LCDID_HCPC.equalsIgnoreCase(null))
				  {		  
					  System.out.println("There no LCD/Article ID with CPT description greater than 200 or no data in the DoesNotSupport Tab ");	
					  bvalidateToolTip=true;
				  }	  
				  	
				 else{
					 
					 
					 //Enter the Filter value in the column	
					AdminIDColFilter.typeAndEnter(LCDID_HCPC);
					
					SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
					
					//Click on the captured LCDID
					 FirstReviewTaskID.click();
					 
					//Wait till the Data loads in the page
				     oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);							
					
					 if(sTabName.equalsIgnoreCase("DoesNotSupport")){						 
						 oSeleniumUtils.Click_given_Locator(StringUtils.replace(oHomePage.AnchorTags, "sValue","Does")); 
					 }					 
					
					 //Wait till the Data loads in the page
					  oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
					 
					//Click on "LongView Radio Button
					 oSeleniumUtils.Click_given_WebElement(LongViewRadioButton);
					 SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);	
							 
					 AdminCPTHCPCColFilter.typeAndEnter(CPTCode);
					 
					 //Click on Apply Filter
					 ApplyFilter_Btn.click();
					
					//Wait till the Data loads in the page
				     oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);	
				     
				     //validate ToolTip description
				     validateToolTipDescription(1,"CPT","Yes");	
				     bvalidateToolTip=true;
				 }  
			
	 }	
		
	
			 return bvalidateToolTip;
	}

	public boolean validateColumnHeaders() {
		
		 boolean bColValidation=false;
		 int iArrayLength=0;
		 		 
		 String sColNames[]={"LCD/Article ID","CPT Code","CPT Group","ICD Code","ICD Group","Category","DOS From","DOS To","Decision","Assignee","Jurisdiction","Remarks","Reason For Updating Decision","Commit Date","History"};		 
		 iArrayLength = sColNames.length;
		 		
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		
				
		for (int loopCounter=0;loopCounter<iArrayLength;loopCounter++)
		{		
						
			 if(loopCounter<=8)	
				{				
					if (oSeleniumUtils.is_WebElement_Displayed(StringUtil.replace(TargetDataColNames, "sValue", sColNames[loopCounter])))
					{			
						oSeleniumUtils.highlightElement(StringUtil.replace(TargetDataColNames, "sValue", sColNames[loopCounter]));
						bColValidation=true;
						 System.out.println("TargetDataTabColName:"+sColNames[loopCounter]+" is  displayed");
						
					 }else{ 			 
						    bColValidation =false;		     	 
						    System.out.println("TargetDataTabColName:"+sColNames[loopCounter]+" is not displayed");
						 }				
				}	
			if(loopCounter>=9)	
			{		
				
				WebElement element = getDriver().findElement(By.xpath(StringUtil.replace(TargetDataColNames, "sValue", sColNames[loopCounter])));
				  ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);	
				  
				  if (oSeleniumUtils.is_WebElement_Displayed(StringUtil.replace(TargetDataColNames, "sValue", sColNames[loopCounter])))
					{			
						oSeleniumUtils.highlightElement(StringUtil.replace(TargetDataColNames, "sValue", sColNames[loopCounter]));
						bColValidation=true;
						System.out.println("TargetDataTabColName:"+sColNames[loopCounter]+" is displayed");
						
					 }else{ 			 
						    bColValidation =false;		     	 
						    System.out.println("TargetDataTabColName:"+sColNames[loopCounter]+" is not displayed");
					  }				  
			   }
			
		 }		
				
		  return bColValidation;
		
	}

	public boolean fn_Validate_Multiple_Filters_TargeData_Assignee(String sAssigneeName) throws Exception {

		List<WebElement> sList = null;
	    List<WebElement> LCD_Articles=null;	   
	    List<WebElement> CPTCodeGroups=null;	
	    List<WebElement> ICDCodes=null;
	    List<WebElement> ICDGroups=null;
	    List<WebElement> Categories=null;
	    List<WebElement> DOSFromVals=null;
	    List<WebElement> DOSToVals=null;
	    List<WebElement> Decisions=null;
	    List<WebElement> CPTCodes=null;
	  
	    
	    String ID="";    
	    String CPTCode="";
	    String CPTCodeGroup="";
	    String ICDCode="";	  
	    String DOSFrom="";
	    String DOSTo="";
	    String Category="";	   
	    int sAllItemsCount_Admin_TargetTab_UI;	   
	    String Decision="";	 	
	    int CMSID=0;	    
	    String sICDCodeGroup;
	    boolean compare;	    
	    int multipleFiltersDBCount=0;
	    int CategoryVal=0;
	    int DecisionVal=0;
	   
	    
	    SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
	    
	    //Capture LCD/ArticleValue
	    LCD_Articles = getDriver().findElements(By.xpath(getTableColumnLocators("LCD_ArticleList")));	    
	    
	    //Capture CPTCodeList values
	    CPTCodes = getDriver().findElements(By.xpath(getTableColumnLocators("CPTCodeList")));
	    
	    //Capture CPTGroupList values
	    CPTCodeGroups = getDriver().findElements(By.xpath(getTableColumnLocators("CPTGroupList")));
	    
	    //Capture ICDCodeList values
	    ICDCodes = getDriver().findElements(By.xpath(getTableColumnLocators("ICDCodeList")));	    
	    
	    //Capture ICDGroupList values
        ICDGroups = getDriver().findElements(By.xpath(getTableColumnLocators("ICDGroupList")));        
        
        //Capture CategoryList values
        Categories = getDriver().findElements(By.xpath(getTableColumnLocators("CategoryList")));
        
        //Capture DOSFromList values
        DOSFromVals = getDriver().findElements(By.xpath(getTableColumnLocators("DOSFromList")));        
        
        //Capture DOSToList values
        DOSToVals = getDriver().findElements(By.xpath(getTableColumnLocators("DOSToList")));
        
        //Capture DecisionList values
        Decisions = getDriver().findElements(By.xpath(getTableColumnLocators("DecisionList")));
        	    
	 	           	               
	           //Capture First Value from UI and enter into the Edit Boxes          
	           ID = LCD_Articles.get(12).getText();	            
	           CPTCodeGroup= CPTCodeGroups.get(12).getText();
	           CPTCode = CPTCodes.get(12).getText();
	           ICDCode= ICDCodes.get(12).getText();
	           sICDCodeGroup= ICDGroups.get(12).getText();
	           Category= Categories.get(12).getText();
	           DOSFrom = DOSFromVals.get(12).getText();
	           DOSTo = DOSToVals.get(12).getText();  
	           Decision = Decisions.get(12).getText();
	           
	           //ICD Code taking partial value
	           ICDCode = ICDCode.substring(0,4);
	          
	         	            
	            //Retrieve web edit objects  and enter values in the edit boxes     
	            sList = getDriver().findElements(By.xpath(EditBoxes));	            
	            enterValue(sList,0,ID);	                       
	            enterValue(sList,1,CPTCode);            
	            enterValue(sList,2,ICDCode);            
	            enterValue(sList,3,DOSFrom);            
	            enterValue(sList,4,DOSTo); 
	            CMSID = Integer.parseInt(LCD_Articles.get(1).getText()); 
	            
	            //Select category value from the drop down based on the value captured from UI
		        if (Category.equalsIgnoreCase("Support")) { CategoryVal=-1; }
		        else if (Category.equalsIgnoreCase("Does Not Support")) { CategoryVal=0; }
		      
	            
		        if (Decision.equalsIgnoreCase("Accept"))  { DecisionVal=-1; }
		        else if (Decision.equalsIgnoreCase("Reject")) { DecisionVal=0; }
		        
		        
	           //Store the ID in session variables to replace them in the SQL query
				 Serenity.setSessionVariable("CMSID").to(CMSID);
				 Serenity.setSessionVariable("CPTCode").to(CPTCode);
				 Serenity.setSessionVariable("ICDCode").to(ICDCode);
				 Serenity.setSessionVariable("DOSFrom").to(DOSFrom);
				 Serenity.setSessionVariable("DOSTo").to(DOSTo);
				 Serenity.setSessionVariable("ICDCodeGroup").to(sICDCodeGroup);
				 Serenity.setSessionVariable("CPTCodeGroup").to(CPTCodeGroup);
				 Serenity.setSessionVariable("Category").to(CategoryVal);
				 Serenity.setSessionVariable("DecisionVal").to(DecisionVal);
				 
				 
				 //Drop downs
				 //Category
				 CategoryDropDown.click();
				 CategorySearchBox.sendKeys(Category);						
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(FilterTag, "sValue", Category));						
				 CategorySearchBox.clear();	
				 
				 //ICDGroup
				 ICDGroupDropDown.click();
				 ICDGroupDropDownVal.click();	
					
				 
				 //Decision
				 DecisionDropDown.click();
				 DecisionSearchBox.sendKeys(Decision);						
				 oSeleniumUtils.Click_given_Locator(StringUtils.replace(FilterTag, "sValue", Decision));						
				 DecisionSearchBox.clear();					 		 
				 
			        
				 //Click on CPTGroup drop down		     
	              CPTGroupDropDown.click();	
	              CPTGroupDropDownVal.click();	
	              
				//Store the CPTCodeGroup in session variables to replace them in the SQL query
				 Serenity.setSessionVariable("CPTCodeGroup").to(CPTCodeGroup);	 
				 

				 JavascriptExecutor jse = (JavascriptExecutor) getDriver();	 			
				 WebElement element = getDriver().findElement(By.xpath(AssigneeDropDownIcon));
				 jse.executeScript("arguments[0].scrollIntoView();", element);	
				 SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
				 
				   //Assignee value from drop down Selection
								 
				   //Click on the Assignee in the drop down	
				   oSeleniumUtils.Click_given_WebElement(AssigneeDropDown);
				   SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);				
				 
				   AssigneeDrpDownSearchBox.sendKeys(sAssigneeName);						
				   oSeleniumUtils.Click_given_Locator(StringUtils.replace(AssigneeNameTag, "sValue", sAssigneeName));						
				   AssigneeDrpDownSearchBox.clear();
					
				   //Click Apply Filter Button					
				    ApplyFilter_Btn.click();		
					
					//Wait till the Data loads in the page
					oHomePage.WaitUntilPageLoad(oHomePage.sPageLoading);								 
										 
					//Store the Assignees in session variables to replace them in the SQL query
					Serenity.setSessionVariable("AdminAssigneeOneUser").to(sAssigneeName);						 
					SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP); 		           		              		 	              		              	            
		           
				     //Capture RuleCount from UI
				     sAllItemsCount_Admin_TargetTab_UI = retrievePageItemsCount("","AdminTargetData");				 
				 				 				    				    
				     //Execute Query to retrieve value
				     multipleFiltersDBCount = Integer.parseInt(DBUtils.executeSQLQuery(DBQueries.sAdminMultipleFiltersAssigneeCountQuery));    
				  		  			   				  						  
					
					//Compare the DB count and UI Count 
					if(sAllItemsCount_Admin_TargetTab_UI==multipleFiltersDBCount)
					{					
					  System.out.println("DB and UI count matched after filter applied"); 
			         }else{
			        	 System.out.println("DB and UI count Not matched after filter applied"); 			        		        	 
			          }									
								
					
										
				if(sAllItemsCount_Admin_TargetTab_UI==multipleFiltersDBCount)
				{									   
				    compare = CompareDB_UIColumnValues(DBQueries.sAdminMultipleFiltersQuery, "LCD_ID",getTableColumnLocators("LCD_ArticleList"));			    
				    if(compare)
			         {
			          System.out.println("DB and UI comparison matched for CMSID"); 
			         }
			       else{
			             getDriver().quit();
			             throw new Exception("DB and UI comparison matched for CMSID");			        	 
			          }
					    
				     
			     	}  			    	
	             
			return true;	
		
		
		
		
	}
	

	
}   
  
	
	
	
	
	
	


