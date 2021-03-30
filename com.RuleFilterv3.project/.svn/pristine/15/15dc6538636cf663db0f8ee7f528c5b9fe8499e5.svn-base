package project.features.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.feature.steps.definitions.EstablishOperationalAuditFunctionalityStepDef;

public class EstablishOperationalAuditFunctionalitySteps {

	@Steps
	EstablishOperationalAuditFunctionalityStepDef OEstOpratlAuditFunctionalityStepdef;
	
	@Then("^User should be able click on CPTICDLink-Admin under Adminstration Section$")
	public void user_should_be_able_click_on_CPTICDLink_Admin_under_Adminstration_Section() throws Throwable {		
		OEstOpratlAuditFunctionalityStepdef.ClicksOnCPTICDAdminLink();
	}
	
	@Then("^Screen will be opened in a new tab with title CPTICD Links- Admin$")
	public void screen_will_be_opened_in_a_new_tab_with_title_CPTICD_Links_Admin() throws Throwable {	   
		OEstOpratlAuditFunctionalityStepdef.validateAdminPage();		
	}
	
	@When("^User clicks on the \"([^\"]*)\" tab$")
	public void user_clicks_on_the_tab(String arg1) throws Throwable {
	    OEstOpratlAuditFunctionalityStepdef.ClicksOnTargetDataTab();	
	}
	
	@When("^User filters by \"([^\"]*)\" for Assignee dropdown$")
	public void user_filters_by_for_Assignee_dropdown(String arg1) throws Throwable {		
		OEstOpratlAuditFunctionalityStepdef.filter_TargetDataColumns(arg1);
	}
	
	@When("^User applies filter on multiple columns and Assignee filter$")
	public void user_applies_filter_on_multiple_columns_and_Assignee_filter() throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.filter_MutipleTargetColumns(); 
	}
	
	@When("^User applies filter on multiple columns and \"([^\"]*)\"$")
	public void user_applies_filter_on_multiple_columns_and(String sAssigneeName) throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.filter_MutipleTargetColumns_Assignee(sAssigneeName);
	}
	
	@When("^RA provides the completed Request Review \"([^\"]*)\" id$")
	public void ra_provides_the_completed_Request_Review_id(String sLCD_OR_ARTICLE_ID) throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.Request_Review_For_Completed(sLCD_OR_ARTICLE_ID);
	}

	@When("^RA update decision in \"([^\"]*)\" task tab$")
	public void ra_update_decision_in_task_tab(String sTaskTab) throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.Update_Decision_in_Task_Tab(sTaskTab);
	}

	@When("^User clicks on History link for one of the code combinations$")
	public void user_clicks_on_History_link_for_one_of_the_code_combinations() throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.click_On_History_Link();
	}

	@Then("^User should be able to view the entire history of that combination$")
	public void user_should_be_able_to_view_the_entire_history_of_that_combination() throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.Validate_Code_Combination_History();
	}
		
	@Then("^Expected columns Headers should be displayed in the TargetData screen$")
	public void expected_columns_Headers_should_be_displayed_in_the_TargetData_screen() throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.validateTargetDataColumnsHeaders();		
	}
	
	@Then("^User captures the DB Count and UI Count of records to validate$")
	public void user_captures_the_DB_Count_and_UI_Count_of_records_to_validate() throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.validateTargetDataRecordsCount();  		
	}
		
	@When("^User applies filter on all the columns in TargetData tab$")
	public void user_applies_filter_on_all_the_columns_in_TargetData_tab() throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.ValidateTargetDataTabFilters(); 
	}
		
	@When("^User Sort \"([^\"]*)\" in the TargetData tab$")
	public void user_Sort_in_the_TargetData_tab(String sColumnName) throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.user_Sort_TargetData_Tab(sColumnName);
	}

	@Then("^User should be able to sort \"([^\"]*)\" in the TargetData tab$")
	public void user_should_be_able_to_sort_in_the_TargetData_tab(String sColumnName) throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.user_should_be_able_to_sort_in_the_TargetData(sColumnName);
	}
	
	@Then("^filter  LCD_OR_ARTICLE id with required code combination and jury name \"([^\"]*)\"$")
	public void filter_LCD_OR_ARTICLE_id_with_required_code_combination_and_jury_name(String juryName) throws Throwable {
		OEstOpratlAuditFunctionalityStepdef.filterTargetTabRecordWithCodeCombinationandJury(juryName);
	}

}
	
	
	
	


