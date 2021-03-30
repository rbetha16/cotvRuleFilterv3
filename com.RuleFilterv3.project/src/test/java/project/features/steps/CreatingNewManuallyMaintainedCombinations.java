package project.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.feature.steps.definitions.CreatingNewManuallyMaintainedCombinationsStepDef;


public class CreatingNewManuallyMaintainedCombinations {
	
	@Steps
	CreatingNewManuallyMaintainedCombinationsStepDef oCreatingNewManuallyMaintainedCombsStepDef;
	
	@When("^RA Enters the \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void ra_Enters_the_and(String sICDGroup, String sCategory, String sNewICDCode) throws Throwable {
		oCreatingNewManuallyMaintainedCombsStepDef.raEntersManualCombinationData(sICDGroup,sCategory,sNewICDCode);		
	}

	@Given("^Category should be selected as \"([^\"]*)\" and should be non-editable$")
	public void category_should_be_selected_as_and_should_be_non_editable(String sCategory) throws Throwable {
		oCreatingNewManuallyMaintainedCombsStepDef.validateCategoryDropdown(sCategory);
		
	}	
	
	@Then("^DOSFromDate and DOSToDates should be defaulted to the open \"([^\"]*)\" and \"([^\"]*)\" in the Target  for \"([^\"]*)\" for \"([^\"]*)\"$")
	public void dosfromdate_and_DOSToDates_should_be_defaulted_to_the_open_and_in_the_Target_for_for(String sDOSFromOpenDate, String sDOSToOpenDate, String sNewICDCode, String sLCD_Article) throws Throwable {
		oCreatingNewManuallyMaintainedCombsStepDef.ValidateDOSDatesinTarget(sDOSFromOpenDate,sDOSToOpenDate,sNewICDCode,sLCD_Article); 
	}	

	@Given("^RA enters the \"([^\"]*)\" for \"([^\"]*)\" times$")
	public void ra_enters_the_for_times(String sICDCode, String Count) throws Throwable
	{
	  oCreatingNewManuallyMaintainedCombsStepDef.raEntersNewICDCodes(sICDCode,Count);
		
	}	
	
	@Then("^verify newly added \"([^\"]*)\" is added with \"([^\"]*)\" in UI$")
	public void verify_newly_added_New_ICD_code_is_added_with_in_UI(String sHCPCCode, String sICDCode) throws Throwable {
		oCreatingNewManuallyMaintainedCombsStepDef.raValidatesManuallyAddedICDCode(sHCPCCode, sICDCode);
	}

	

		
	}

	
	
 
	
	
	


