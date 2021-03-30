package project.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.feature.steps.definitions.ManuallyCreatingNewCombinations_AssociateICDCodes_DecStepDef;


public class ManuallyCreatingNewCombinations_AssociateICDCodes_Dec

{
		
	@Steps
	ManuallyCreatingNewCombinations_AssociateICDCodes_DecStepDef oManuallyCreatingNewCombinationsDecStepDef;
			
	@Then("^System should display the \"([^\"]*)\" text in CombinationType column against the combination in \"([^\"]*)\" for \"([^\"]*)\" and  for \"([^\"]*)\" Codecombination with \"([^\"]*)\"$")
	public void system_should_display_the_text_in_CombinationType_column_against_the_combination_in_for_and_for_Codecombination_with(String sText, String sTabName, String sLCD_Article, String sCodeComboType, String sNewHCPCCode) throws Throwable {
		oManuallyCreatingNewCombinationsDecStepDef.validateManualTextforCombination(sText,sTabName,sLCD_Article,sCodeComboType,sNewHCPCCode);
	}
		
	@Given("^DOSFrom should be set to ReviewEffective date in the target for \"([^\"]*)\" and for \"([^\"]*)\" and  for LCDArticleVersion \"([^\"]*)\"$")
	public void dosfrom_should_be_set_to_ReviewEffective_date_in_the_target_for_and_for_and_for_LCDArticleVersion(String sNewIcdCode, String sLCDArticle, String sVersionNo) throws Throwable {
		oManuallyCreatingNewCombinationsDecStepDef.validateRevEffectiveDateDOSFrom(sNewIcdCode,sLCDArticle,sVersionNo);
	}
	
	@Given("^DOSTo should be set to \"([^\"]*)\" default date in the target for \"([^\"]*)\" and for \"([^\"]*)\" and  for LCDArticleVersion \"([^\"]*)\"$")
	public void dosto_should_be_set_to_default_date_in_the_target_for_and_for_and_for_LCDArticleVersion(String sDOsToDate, String sNewIcdCode, String sLCDArticle, String sVersionNo) throws Throwable {
		oManuallyCreatingNewCombinationsDecStepDef.validateDOSToOpendate(sDOsToDate,sNewIcdCode,sLCDArticle,sVersionNo);
	}
	
	@Then("^Manually added codes should be successfully deleted from Manualtable \"([^\"]*)\" for \"([^\"]*)\" and for the \"([^\"]*)\"  for \"([^\"]*)\"   for \"([^\"]*)\" Codecombinations$")
	public void manually_added_codes_should_be_successfully_deleted_from_Manualtable_for_and_for_the_for_for_Codecombinations(String sManualTableName, String sCategory, String sLCDArticle, String sNewICDCode, String sCodeCombType) throws Throwable {
	   oManuallyCreatingNewCombinationsDecStepDef.validateDeletionFromManualTable(sManualTableName,sCategory,sLCDArticle,sNewICDCode,sCodeCombType);
		
	}
		
	@Given("^RA enters  the Seven digit \"([^\"]*)\" in to BaseICD Code field$")
	public void ra_enters_the_Seven_digit_in_to_BaseICD_Code_field(String sICDCode) throws Throwable
	{
		oManuallyCreatingNewCombinationsDecStepDef.enterBaseICDCode(sICDCode);	    
	}	
	
	@Given("^RA  presses a Tab$")
	public void ra_presses_a_Tab() throws Throwable 
	{
		oManuallyCreatingNewCombinationsDecStepDef.raPressesTab();
	}
	
	@Then("^System should auto populate the first Six digits of the Base ICD code into ICD code field$")
	public void system_should_auto_populate_the_first_Six_digits_of_the_Base_ICD_code_into_ICD_code_field() throws Throwable 
	{
		oManuallyCreatingNewCombinationsDecStepDef.validateNewICDCodeAutopopulate();				
	}
	
	@Then("^System should auto populate the first Six digits of the BaseICDcode into all ICD code fields$")
	public void system_should_auto_populate_the_first_Six_digits_of_the_BaseICDcode_into_all_ICD_code_fields() throws Throwable 
	{	  
		oManuallyCreatingNewCombinationsDecStepDef.validateMultipleICDCodesFields();				
	}
	
	@When("^RA  clears the data in the BaseICDCode field$")
	public void ra_clears_the_data_in_the_BaseICDCode_field() throws Throwable
	{	   
		oManuallyCreatingNewCombinationsDecStepDef.raClearsTheData();		
	}
	
	@Then("^ICDCode fields should have the same data as of BaseICDCode$")
	public void icdcode_fields_should_have_the_same_data_as_of_BaseICDCode() throws Throwable 
	{
		oManuallyCreatingNewCombinationsDecStepDef.raValidatesICDCodeField();			   
	}
		
	@Given("^ReviewTask should not be created in Support DeltaTable  for  \"([^\"]*)\"  for the CodeCombination  \"([^\"]*)\" and   \"([^\"]*)\"$")
	public void reviewtask_should_not_be_created_in_Support_DeltaTable_for_for_the_CodeCombination_and(String sLCD_Article, String sNewICDCode, String sICDGroup) throws Throwable {
		oManuallyCreatingNewCombinationsDecStepDef.validateDeltaTableCombinations(sLCD_Article,sNewICDCode,sICDGroup);	
	}
	

}
