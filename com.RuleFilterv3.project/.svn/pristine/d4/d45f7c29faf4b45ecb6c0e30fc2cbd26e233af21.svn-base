package project.features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.feature.steps.definitions.AbilitytoCreateRecordforAndReviseDatebandingLogicPerJurisdictionStepDef;

public class AbilitytoCreateRecordforAndReviseDatebandingLogicPerJurisdictionSteps
{	
	
@Steps
 AbilitytoCreateRecordforAndReviseDatebandingLogicPerJurisdictionStepDef oDatebandingJursStepDef;
	
@Given("^\"([^\"]*)\" decision should be copied to all Jurisidictions$")
public void decision_should_be_copied_to_all_Jurisidictions(String arg1) throws Throwable
	{		
		oDatebandingJursStepDef.validateDecisionForJurisidictions(arg1);	   
	}

@Given("^RA selects a reason for Rejection  as \"([^\"]*)\"$")
public void ra_selects_a_reason_for_Rejection_as(String sReason) throws Throwable
	{  
		oDatebandingJursStepDef.selectRejectReason(sReason);	 		
	}
	
 @Given("^Capture decisions taken from DeltaTable for  \"([^\"]*)\"$")
 public void capture_decisions_taken_from_DeltaTable_for(String sLCD_Article) throws Throwable
 {
	oDatebandingJursStepDef.captureDecisionsFromDeltat(sLCD_Article);	 
 }

 @Then("^All the decisions should be copied to the Target for  \"([^\"]*)\"$")
 public void all_the_decisions_should_be_copied_to_the_Target_for(String sLCD_Article) throws Throwable 
 {	 
	 oDatebandingJursStepDef.decisionsValidationTarget(sLCD_Article);      
 }

 @Given("^RA captues the Decisions count$")
 public void ra_captues_the_Decisions_count() throws Throwable
 {  
	 oDatebandingJursStepDef.captureDecisionsCount(); 	 
 }
 
@Given("^Manual codecombination should be DateBanded to the user selected DOSTO \"([^\"]*)\" in \"([^\"]*)\" and for the \"([^\"]*)\" and \"([^\"]*)\"  for \"([^\"]*)\"  and  for Version \"([^\"]*)\"  for all Jurisidictions$")
public void manual_codecombination_should_be_DateBanded_to_the_user_selected_DOSTO_in_and_for_the_and_for_and_for_Version_for_all_Jurisidictions(String sDates, String sTargetTable, String sLCD_Article, String sCategoryType, String sNewCodes, String sLCD_ArtVersion) throws Throwable {
	oDatebandingJursStepDef.raValidateDosToinTargetTableforNewCodesforAllJuries(sDates,sTargetTable,sLCD_Article,sCategoryType,sNewCodes,sLCD_ArtVersion); 
}

@Given("^DeletedCodeCombinations should not be moved to TargetTable for  the \"([^\"]*)\"  and \"([^\"]*)\"  for \"([^\"]*)\"  and  for Version \"([^\"]*)\"$")
public void deletedcodecombinations_should_not_be_moved_to_TargetTable_for_the_and_for_and_for_Version(String sLCD_Article, String sCategoryType, String sNewCodes, String sLCD_ArtVersion) throws Throwable {
	oDatebandingJursStepDef.raValidatesAssctdCodesDeletionforAllJuries(sLCD_Article,sCategoryType,sNewCodes,sLCD_ArtVersion);
}

@Given("^CodeCombinations should  be created in TargetTable for  the \"([^\"]*)\"  and \"([^\"]*)\"  for \"([^\"]*)\"  and  for Version \"([^\"]*)\" for \"([^\"]*)\"$")
public void codecombinations_should_be_created_in_TargetTable_for_the_and_for_and_for_Version_for(String sLCD_Article, String sCategoryType, String sNewCodes, String sLCD_ArtVersion, String sCodeComboType) throws Throwable 
{
	oDatebandingJursStepDef.raValidatesCodeCombsinTargetTable(sLCD_Article,sCategoryType,sNewCodes,sLCD_ArtVersion,sCodeComboType);	
}

@Given("^CodeCombinations for  the \"([^\"]*)\"  and for \"([^\"]*)\" and for \"([^\"]*)\"  for LCDArticleVersion \"([^\"]*)\" should be displayed in the TargetData Screen$")
public void codecombinations_for_the_and_for_and_for_for_LCDArticleVersion_should_be_displayed_in_the_TargetData_Screen(String sLCD_Article, String sNewCodes, String sCategory,String sLCD_ArtVersion) throws Throwable {
  oDatebandingJursStepDef.raValidatesCodeCombsinTargetDataUI(sLCD_Article,sNewCodes,sCategory,sLCD_ArtVersion);	
	
}

@Then("^User should be able to see all the adjudication records on the screen for  the \"([^\"]*)\"$")
public void user_should_be_able_to_see_all_the_adjudication_records_on_the_screen_for_the(String sLCD_Article) throws Throwable 
{
	 oDatebandingJursStepDef.raValidatesRecordsCountinUI(sLCD_Article);	
}

@Given("^Only one Record Shoud be displayed for different Juries in the \"([^\"]*)\" Screen and \"([^\"]*)\" column should be blank$")
public void only_one_Record_Shoud_be_displayed_for_different_Juries_in_the_Screen_and_column_should_be_blank(String sScreenName, String sColName) throws Throwable 
{	
	 oDatebandingJursStepDef.validateSingleRecordforJuries(sScreenName,sColName);	   
}

@Given("^RA captures ID from DB and filters for \"([^\"]*)\"$")
public void ra_captures_ID_from_DB_and_filters_for(String sLCD_Article) throws Throwable {	
	oDatebandingJursStepDef.captureIDfromDB(sLCD_Article);  
}

@Given("^RA claims the ID  from group Tasks$")
public void ra_claims_the_ID_from_group_Tasks() throws Throwable { 
	oDatebandingJursStepDef.claimsIDfromGrouptasks(); 	
}

@Given("^RA filters the ID$")
public void ra_filters_the_ID() throws Throwable
{
	oDatebandingJursStepDef.raFilterstheID(); 	
   
}

@Given("^DOSFrom should be set according to min DosFrom logic in the target for \"([^\"]*)\" and for \"([^\"]*)\" and  for LCDArticleVersion \"([^\"]*)\"  for the scenario \"([^\"]*)\"$")
public void dosfrom_should_be_set_according_to_min_DosFrom_logic_in_the_target_for_and_for_and_for_LCDArticleVersion_for_the_scenario(String sNewICDCode, String sLCD_Article, String sVersion, String sScenarioName) throws Throwable
{
	oDatebandingJursStepDef.validateMinDosFromLogic(sNewICDCode,sLCD_Article,sVersion,sScenarioName);	
}

@Given("^Only one Record Shoud be displayed for Review for different Juries in the \"([^\"]*)\" Screen for the \"([^\"]*)\"$")
public void only_one_Record_Shoud_be_displayed_for_Review_for_different_Juries_in_the_Screen_for_the(String sLCD_Article, String sScenarioName) throws Throwable 
{
	oDatebandingJursStepDef.validateRAReviewScreen(sLCD_Article,sScenarioName);   
}

@Given("^Records should be updated for \"([^\"]*)\" in DeltaTable for LCDArticle Version \"([^\"]*)\"  and according to MultipleJuries  for the \"([^\"]*)\"$")
public void records_should_be_updated_for_in_DeltaTable_for_LCDArticle_Version_and_according_to_MultipleJuries_for_the(String sLCD_Article, String sLCDArticleVersion, String sScenario) throws Throwable 
{
	oDatebandingJursStepDef.validateDeltaforMultipleJuries(sLCD_Article,sLCDArticleVersion,sScenario);   	
}

@Given("^DOSTo should be Datebanded in the target  for \"([^\"]*)\" and  for LCDArticleVersion \"([^\"]*)\"  and for \"([^\"]*)\"$")
public void dosto_should_be_Datebanded_in_the_target_for_and_for_LCDArticleVersion_and_for(String sLCD_Article, String sLCDArticleVersion, String sScenario) throws Throwable 
{	
	oDatebandingJursStepDef.validateDosToDtBandforAlljuries(sLCD_Article,sLCDArticleVersion,sScenario);    
}

@Given("^Validate DOSTo value of \"([^\"]*)\"  is same as \"([^\"]*)\"  DosFrom value for  \"([^\"]*)\"$")
public void validate_DOSTo_value_of_is_same_as_DosFrom_value_for(String sNewCode, String sBaseICDCode, String sLCD_Article) throws Throwable
{	
	oDatebandingJursStepDef.validateDosToforNewCode(sNewCode,sBaseICDCode,sLCD_Article);  
}

@Given("^Records should be updated for \"([^\"]*)\" in TargetTable for LCDArticle Version \"([^\"]*)\"  and according to MultipleJuries  for the \"([^\"]*)\"$")
public void records_should_be_updated_for_in_TargetTable_for_LCDArticle_Version_and_according_to_MultipleJuries_for_the(String sLCD_Article, String sLCDArticleVersion, String sScenario) throws Throwable 
{
	oDatebandingJursStepDef.validateTargetforMultipleJuries(sLCD_Article,sLCDArticleVersion,sScenario);   		
}

@Given("^RA updates decisions for some records in the TargetTable Screen for \"([^\"]*)\"$")
public void ra_updates_decisions_for_some_records_in_the_TargetTable_Screen_for(String sLCDArticle) throws Throwable
{
	oDatebandingJursStepDef.updateDecisionsinTargetScreen(sLCDArticle);	
}


public void ra_filters_by_ID_for(String sLCDArticle) throws Throwable
{
	oDatebandingJursStepDef.filterIDinAdminScreen(sLCDArticle);	 
}

@Given("^RA filters by ID for \"([^\"]*)\" with status \"([^\"]*)\"$")
public void ra_filters_by_ID_for_with_status(String sLCDArticle, String sStatus) throws Throwable {
	oDatebandingJursStepDef.filterIDinAdminScreen(sLCDArticle, sStatus);	
}

@When("^The above updated decisions should be displayed in the screen for \"([^\"]*)\"$")
public void the_above_updated_decisions_should_be_displayed_in_the_screen_for(String sLCDArticle) throws Throwable
{
	oDatebandingJursStepDef.validateUpdatedDecisionsinAdhocReviewScreen(sLCDArticle);	
   
}

@Given("^The above updated decisions should be displayed in the screen for \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
public void the_above_updated_decisions_should_be_displayed_in_the_screen_for_and_and(String sLCDArticle, String sCategory, String sLCDArtVersion) throws Throwable {
	oDatebandingJursStepDef.validateUpdatedDecisionsinAdhocReviewScreen(sLCDArticle, sCategory, sLCDArtVersion);
}





}
