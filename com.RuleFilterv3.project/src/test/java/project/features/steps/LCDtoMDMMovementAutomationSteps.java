package project.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.feature.steps.definitions.LCDtoMDMMovementAutomationStepDef;

public class LCDtoMDMMovementAutomationSteps 
{

@Steps
LCDtoMDMMovementAutomationStepDef  oLCDtoMDM;


@Given("^The \"([^\"]*)\"  decisions should be moved to MDM for \"([^\"]*)\"$")
public void the_decisions_should_be_moved_to_MDM_for(String arg1, String arg2) throws Throwable 
{
	oLCDtoMDM.RAChecksAcceptDecisionsMovedtoMDM(arg1,arg2);	
}

@Given("^The \"([^\"]*)\"  decisions should not be moved to MDM for  \"([^\"]*)\"$")
public void the_decisions_should_not_be_moved_to_MDM_for(String arg1, String arg2) throws Throwable 
{
	oLCDtoMDM.RAChecksRejectDecisionsNotMovedtoMDM(arg1,arg2);	
}

@When("^User selects all the Codecombs in the \"([^\"]*)\" for \"([^\"]*)\" decision$")
public void user_selects_all_the_Codecombs_in_the_for_decision(String arg1, String arg2) throws Throwable 
{
	oLCDtoMDM.RASelectsAllCombs(arg1,arg2);		
}

@When("^User selects \"([^\"]*)\" codecombinations in the \"([^\"]*)\"  for \"([^\"]*)\" decision in \"([^\"]*)\" page$")
public void user_selects_codecombinations_in_the_for_decision_in_page(String arg1, String arg2, String arg3, String arg4) throws Throwable
{
	oLCDtoMDM.RASelectsSpecifiedCodeCombinations(arg1,arg2,arg3,arg4);			
}

@When("^RA selects a reason for Rejection  as \"([^\"]*)\"  in \"([^\"]*)\" page$")
public void ra_selects_a_reason_for_Rejection_as_in_page(String arg1, String arg2) throws Throwable 
{
	oLCDtoMDM.RATakesRejectdecision(arg1,arg2);		
}

@Given("^RA enters the ReasonforUpdating decision for the \"([^\"]*)\" decision$")
public void ra_enters_the_ReasonforUpdating_decision_for_the_decision(String sDecision) throws Throwable 
{
	oLCDtoMDM.RAentersUpdateDecisionReason(sDecision);    
}

@Then("^The Deleted combinations should be datebanded to \"([^\"]*)\"  for  \"([^\"]*)\"   in MDM  for  \"([^\"]*)\" and for \"([^\"]*)\"$")
public void the_Deleted_combinations_should_be_datebanded_to_for_in_MDM_for_and_for(String sDate, String sNewICDCode, String sTabName,String sLCDArticle) throws Throwable
{   
	oLCDtoMDM.validateDatebandinginMDM(sDate,sNewICDCode,sTabName,sLCDArticle);	
}

@Then("^RA filters \"([^\"]*)\" column in with Value \"([^\"]*)\"  for  \"([^\"]*)\" tab in the \"([^\"]*)\" page$")
public void ra_filters_column_in_with_Value_for_tab_in_the_page(String sColName, String sFilterVal,String sTabName, String sPageName) throws Throwable 
{
	oLCDtoMDM.RAFiltersColumSpecific(sColName,sFilterVal,sTabName,sPageName);   
}

@Then("^RA captures Review  decisions  for  \"([^\"]*)\" tab in the \"([^\"]*)\" page$")
public void ra_captures_Review_decisions_for_tab_in_the_page(String sTabName, String sPageName) throws Throwable 
{
	oLCDtoMDM.captureReviewDecisions(sTabName,sPageName);	
}

@Given("^RA captures the HCPCCodes for \"([^\"]*)\" and \"([^\"]*)\"  for \"([^\"]*)\"$")
public void ra_captures_the_HCPCCodes_for_and_for(String sCategory, String sLCDArticle, String sRecordsType) throws Throwable
{
  
	oLCDtoMDM.captureHCPCCodes(sCategory,sLCDArticle,sRecordsType);	
}

	@Then("^Filter the \"([^\"]*)\"  column with \"([^\"]*)\"$")
	public void filter_the_column_with(String sColName, String sValue) throws Throwable
	{
		oLCDtoMDM.filterColumn(sColName,sValue);
	}
		
	@Then("^A popup \"([^\"]*)\" should be displayed$")
	public void a_popup_should_be_displayed(String sPopupTitle) throws Throwable
	{
		oLCDtoMDM.validatePopup(sPopupTitle);
	}
	
	@Given("^Manual Associated code should be added to the base code for  \"([^\"]*)\"$")
	public void manual_Associated_code_should_be_added_to_the_base_code_for(String sLCD_Article) throws Throwable
	{
		oLCDtoMDM.validateManualCodetoBaseCode(sLCD_Article);
	}

	@Given("^All the decisions should be copied to the AssociatedCode in the Target for \"([^\"]*)\"  and for  \"([^\"]*)\"$")
	public void all_the_decisions_should_be_copied_to_the_AssociatedCode_in_the_Target_for_and_for(String sNewICDCode, String sLCD_Article) throws Throwable 
	{
		  oLCDtoMDM.validateDecisionsCopiedtoTarget(sNewICDCode,sLCD_Article);
	}
	
	@Then("^The Deleted combinations should be datebanded to \"([^\"]*)\"  for  \"([^\"]*)\"   in the table \"([^\"]*)\" for  \"([^\"]*)\" and for \"([^\"]*)\" with version \"([^\"]*)\"$")
	public void the_Deleted_combinations_should_be_datebanded_to_for_in_the_table_for_and_for_with_version(String sDate, String sNewICDCode, String sTableName, String sTabName, String sLCD_Article, String iLCDArticleVersion) throws Throwable {
		oLCDtoMDM.validateDatebandinginSpecificTable(sDate, sNewICDCode, sTableName, sTabName, sLCD_Article, iLCDArticleVersion);
	}
	
	
	
	

}
