package project.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.feature.steps.definitions.CreateProposalStepDef;

public class CreateProposalSteps {
	
@Steps
CreateProposalStepDef oCreateProposalStepDef;

@Given("^User logs with \"([^\"]*)\" as CPT ICD RA into JBPM Application$")
public void user_logs_with_as_CPT_ICD_RA_into_JBPM_Application(String sUserName) throws Throwable {
	oCreateProposalStepDef.loginCPTICDLink(sUserName);
}

@When("^RA clicks on CPT ICD Link in My Tasks$")
public void ra_clicks_on_CPT_ICD_Link_in_My_Tasks() throws Throwable {
	oCreateProposalStepDef.clickOnCPTICDLink();
}

@Then("^RA should able to view the Group/Individual Task screen$")
public void ra_should_able_to_view_the_Group_Individual_Task_screen() throws Throwable {
	oCreateProposalStepDef.validateGroupIndividualTabs();
}

@When("^RA clicks on \"([^\"]*)\" Task Tab$")
public void ra_clicks_on_Task_Tab(String arg1) throws Throwable {
	oCreateProposalStepDef.ra_clicks_on_Task_Tab(arg1);
}
	
@Then("^RA User should be able to filter by \"([^\"]*)\" in GroupTask screen for the \"([^\"]*)\"$")
public void ra_User_should_be_able_to_filter_by_in_GroupTask_screen_for_the(String sTaskTblColName, String sLCD_OR_Article) throws Throwable {
	oCreateProposalStepDef.RA_User_Able_to_Filter_In_GroupTask_Screen(sTaskTblColName,sLCD_OR_Article);
}

@Then("^RA User should be able to filter \"([^\"]*)\" using Special Character in GroupTask screen$")
public void ra_User_should_be_able_to_filter_using_Special_Character_in_GroupTask_screen(String arg1)throws Throwable {

}	

@Then("^Logout of the Application$")
public void logout_of_the_Application() throws Throwable {
		oCreateProposalStepDef.userLogsout();
	}
	
@Then("^They should able to click on CPT ICD Link-Admin link under Adminstration tab$")
public void they_should_able_to_click_on_CPT_ICD_Link_Admin_link_under_Adminstration_tab() throws Throwable {
	   oCreateProposalStepDef.clickOnAdminTab();
}

@Then("^\"([^\"]*)\" button should be \"([^\"]*)\"$")
public void button_should_be(String arg1, String arg2) throws Throwable {
	oCreateProposalStepDef.validateAcceptRejectButtons(arg1,arg2);
}

@When("^User selects some codecombinations in the \"([^\"]*)\"$")
public void user_selects_some_codecombinations_in_the(String arg1) throws Throwable {
	oCreateProposalStepDef.selectCodeCombinationinTab(arg1); 
}

@Then("^the codecombination should be set as \"([^\"]*)\" in ReviewDecision column$")
public void the_codecombination_should_be_set_as_in_ReviewDecision_column(String arg1) throws Throwable {
	oCreateProposalStepDef.validateReviewDecision(arg1);
}

@When("^User captures the CodeCombination count in \"([^\"]*)\"$")
public void user_captures_the_CodeCombination_count_in(String arg1) throws Throwable {
	oCreateProposalStepDef.retrieveItemsCount();    
}

@Then("^\"([^\"]*)\" button should be disabled$")
public void button_should_be_disabled(String arg1) throws Throwable {
	oCreateProposalStepDef.validateButtons(arg1);	
}

@When("^User selects codecombinations in the \"([^\"]*)\" and does not select any in DoesNotSupportTab$")
public void user_selects_codecombinations_in_the_and_does_not_select_any_in_DoesNotSupportTab(String arg1) throws Throwable {
	 oCreateProposalStepDef.selectCodeCombinationinTab(arg1); 
}

@When("^User selects codecombinations in the \"([^\"]*)\" and does not select any in SupportTab$")
public void user_selects_codecombinations_in_the_and_does_not_select_any_in_SupportTab(String arg1) throws Throwable {
   oCreateProposalStepDef.selectCodeCombinationinTab(arg1); 
	
}

@When("^User selects any codecombinations in \"([^\"]*)\" tabs$")
public void user_selects_any_codecombinations_in_tabs(String arg1) throws Throwable {
	oCreateProposalStepDef.selectCodeCombinationinTab(arg1);
}

@When("^User selects any code combinations in \"([^\"]*)\" tabs$")
public void user_selects_any_code_combinations_in_tabs(String arg1) throws Throwable {
	oCreateProposalStepDef.selectCodeCombinationinTab(arg1);
}

@When("^User deselects any codecombinations in \"([^\"]*)\" tabs$")
public void user_deselects_any_codecombinations_in_tabs(String arg1) throws Throwable {
	oCreateProposalStepDef.deSelectCodeCombinationinTab(arg1);
}

@When("^User doesnot select any codecombinations in \"([^\"]*)\" tabs$")
public void user_doesnot_select_any_codecombinations_in_tabs(String arg1) throws Throwable {
	oCreateProposalStepDef.deSelectCodeCombinationinTab(arg1);
}

@When("^User deselects any codecombinations in the \"([^\"]*)\"$")
public void user_deselects_any_codecombinations_in_the(String arg1) throws Throwable {
	oCreateProposalStepDef.deSelectCodeCombinationinTab(arg1);	
}

@Then("^The count should match with the DB count for \"([^\"]*)\"$")
public void the_count_should_match_with_the_DB_count_for(String arg1) throws Throwable {
	oCreateProposalStepDef.compareUIandDBitemsCount(arg1);	
}

@Given("^User logs to \"([^\"]*)\" as CPTICDRA into JBPM Application$")
public void user_logs_to_as_CPTICDRA_into_JBPM_Application(String arg1) throws Throwable {
	oCreateProposalStepDef.loginCPTICDLinkSmokeTest(arg1);
}

@Then("^Apply Filter on CPTHCPCSGroup in the \"([^\"]*)\"$")
public void apply_Filter_on_CPTHCPCSGroup_in_the(String arg1) throws Throwable {
	oCreateProposalStepDef.applyFilterOnCPTHCPCSCodeGroup(arg1);
}


@Then("^The count should match with the DB count for \"([^\"]*)\" for \"([^\"]*)\"$")
public void the_count_should_match_with_the_DB_count_for_for(String sTabName, String sLCD_Article) throws Throwable {
	oCreateProposalStepDef.compareUIandDBitemCount(sTabName,sLCD_Article);
}


}
