package project.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.feature.steps.definitions.EstablishProposalReviewWorkflowStepDef;

public class EstablishProposalReviewWorkflow {

	@Steps
	EstablishProposalReviewWorkflowStepDef oEstablishProposalReviewWorkflowStepDef;
	
	@When("^RA claims a LCD code from group Tasks$")
	public void ra_claims_a_LCD_code_from_group_Tasks() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.ra_Claims_LCD_Code_From_Group_Tasks();
	}

	@Then("^Claimed LCD code should be displayed with status as \"([^\"]*)\"$")
	public void claimed_LCD_code_should_be_displayed_with_status_as(String sReviewStatus) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.claimed_Code_Should_Be_Dispalyed_As(sReviewStatus);
	}

	@Then("^RA Review Work Queue screen should be displayed$")
	public void ra_Review_Work_Queue_screen_should_be_displayed() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.ra_Review_Work_Queue_Screen();
	}

	@Then("^Review status should be dispalyed as \"([^\"]*)\"$")
	public void review_status_as(String sReviewStatus) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.review_Status_As(sReviewStatus);
	}
	
	@When("^RA clicks on \"([^\"]*)\"$")
	public void ra_clicks_on(String arg1) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.ra_Clicks_on(arg1);
	}
	
	@When("^RA enters the remarks as \"([^\"]*)\" for the rejected codes$")
	public void ra_enters_the_remarks_as_for_the_rejected_codes(String sRemarks) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.ra_Enters_Remarks_For_Rejected_Code(sRemarks);
	}
	
	@Then("^RA should be able to view the filter codes based on \"([^\"]*)\"$")
	public void ra_should_be_able_to_view_the_filter_codes_based_on(String arg1) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.ra_Able_To_Filter_Codes_Based_on(arg1);
	}	
	
	@Then("^Remarks column should be sorted$")
	public void remarks_column_should_be_sorted() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.ra_Able_Sorted_Remarks_Column();
	}
		
	@When("^AdminRA clicks on one of the review taskID$")
	public void adminra_clicks_on_one_of_the_review_taskID() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.clickOnTaskID();
	}
	
	@Then("^AdminRA selects the \"([^\"]*)\" radio button$")
	public void adminra_selects_the_radio_button(String arg1) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.selectRadioButton(arg1);
	}

	@When("^AdminRA mouseovers on the CPTICD Description to display the Tooltip description$")
	public void adminra_mouseovers_on_the_CPTICD_Description_to_display_the_Tooltip_description() throws Throwable {
	    oEstablishProposalReviewWorkflowStepDef.validateTooltipDescription();
	}	

	@When("^\"([^\"]*)\" of different length exists in the Grid to check tooltip Mouseover for \"([^\"]*)\"$")
	public void of_different_length_exists_in_the_Grid_to_check_tooltip_Mouseover_for(String arg1, String arg2) throws Throwable 
	{
		oEstablishProposalReviewWorkflowStepDef.validateTooltipDescriptionMaxLength(arg1,arg2);	   
	}
	
	@When("^User selects few records with Review Decision \"([^\"]*)\"$")
	public void user_selects_few_records_with_Review_Decision(String arg1) throws Throwable {
	    
	}
	
	@Then("^An alert message should be displayed$")
	public void an_alert_message_should_be_displayed() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.validateDecisionChangeAlertMessage();
	  }
	
	@Then("^RA should able to view Review tasks in Group Task screen$")
	public void ra_should_able_to_view_Review_tasks_in_Group_Task_screen() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.ra_able_To_View_Review_Tasks_GroupTask_Screen();
	}

	@Then("^RA should not able to view Review tasks$")
	public void ra_should_not_able_to_view_Review_tasks() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.ra_Should_Not_Able_to_View_Review_Tasks();
	}
	
	@When("^User clicks on \"([^\"]*)\" button on the Alert popup$")
	public void user_clicks_on_button_on_the_Alert_popup(String sButton) throws Throwable {
		
		oEstablishProposalReviewWorkflowStepDef.raClicksAlertPopupButton(sButton);	
		
	}
	
	@Then("^Claimed LCD code should be displayed in queue for RA$")
	public void claimed_LCD_code_should_be_displayed_in_queue_for_RA() throws Throwable {
	    oEstablishProposalReviewWorkflowStepDef.claimed_LCD_Code_Should_be_in_Queue_For_RA();
	}

	@Then("^Alert message should be closed and all the checkmarks for the selected records should be retained$")
	public void alert_message_should_be_closed_and_all_the_checkmarks_for_the_selected_records_should_be_retained() throws Throwable {
	   System.out.println("hi"); 
	}
	
	@Then("^The Decision for the selected records should not be changed$")
	public void the_Decision_for_the_selected_records_should_not_be_changed() throws Throwable {
	    
	}
	
	@Then("^The Review Decision for all the selected records should be changed to Reject and the corresponding Remarks should be cleared$")
	public void the_Review_Decision_for_all_the_selected_records_should_be_changed_to_Reject_and_the_corresponding_Remarks_should_be_cleared() throws Throwable {
	    
	}
	
	@Then("^User should be able to apply the Remarks from the dropdown list for the selected records$")
	public void user_should_be_able_to_apply_the_Remarks_from_the_dropdown_list_for_the_selected_records() throws Throwable {
	  
	}
	
	@When("^User selects few records with Review Decision in combination of Accept Reject and Blank$")
	public void user_selects_few_records_with_Review_Decision_in_combination_of_Accept_Reject_and_Blank() throws Throwable {
	   
	}
	
	@Then("^User should be able to enter the Remarks for these records$")
	public void user_should_be_able_to_enter_the_Remarks_for_these_records() throws Throwable {
	   
	}
	
	@Then("^The Review Decision for selected records should be changed to Accept$")
	public void the_Review_Decision_for_selected_records_should_be_changed_to_Accept() throws Throwable {
	  
	}

	@When("^User selects Codecombinations in the \"([^\"]*)\"$")
	public void user_selects_Codecombinations_in_the(String arg1) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.selectCodeCombinationinTab(arg1); 
	 }
	
	@When("^RA applies filter on Review decision \"([^\"]*)\" value$")
	public void ra_applies_filter_on_Review_decision_value(String arg1) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.selectReviewDecision(arg1);
	}

	@Then("^RA should not be able to view other RA Claimed tasks$")
	public void ra_should_not_be_able_to_view_other_RA_Claimed_tasks() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.ra_Should_Not_be_Able_to_view_Other_RA_Claimed_Tasks();
	}

	@When("^\"([^\"]*)\" User tries to Claim Subsequent Weeks Task from Group Tasks Screen$")
	public void user_tries_to_Claim_Subsequent_Weeks_Task_from_Group_Tasks_Screen(String arg1) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.user_Claim_Subsequent_Week_Task_From_Group_Tasks(arg1);
	}

	@Then("^an \"([^\"]*)\" should be displayed$")
	public void an_should_be_displayed(String arg1) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.alert_Popup_Should_be_Displayed_with_Message(arg1);
	}
	
	@Given("^Multiple Weeks Task exist for the same \"([^\"]*)\" and First week Task Status is not Started$")
	public void multiple_Weeks_Task_exist_for_the_same_and_First_week_Task_Status_is_not_Started(String arg1) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.multiple_Weeks_Task_exist_for_Not_Started_In_GroupTasks(arg1);
	}

	@When("^\"([^\"]*)\" User tries to Reassign the Subsequent Weeks Task from Admin Code Combination Screen$")
	public void user_tries_to_Reassign_the_Subsequent_Weeks_Task_from_Admin_Code_Combination_Screen(String arg1) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.user_Reassign_Subsequent_Week_Task();
	}
	
	@When("^First Week Task Status is \"([^\"]*)\"$")
	public void first_Week_Task_Status_is(String arg1) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.first_Week_Task_Status_is(arg1);
	}

	@Then("^Task should be successfully \"([^\"]*)\"$")
	public void task_should_be_successfully(String sTaskStatus) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.task_should_be_successfully(sTaskStatus);		
	}	
	
	@When("^clicks on View Paragraph button$")
	public void clicks_on_View_Paragraph_button() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.clickOnViewParagraphInfoButton();
	}
	
	@Then("^Paragraph Information for the ICD Code should be displayed$")
	public void paragraph_Information_for_the_ICD_Code_should_be_displayed() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.validateParagraphInformationSection();
	}
	
	@Then("^Close Icon should be displayed for the Paragraph information$")
	public void close_Icon_should_be_displayed_for_the_Paragraph_information() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.validateParagraphInfoCloseIcon();
	}
	
	@Then("^Click Close Icon$")
	public void click_Close_Icon() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.closeParagraphInfo();
	}
	
	@When("^User clicks on RA Review Work Queue$")
	public void user_clicks_on_RA_Review_Work_Queue() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.clickRAReviewWorkQueue();
	}
	
	@Then("^User Should be able to Navigate to Individual Task  Screen$")
	public void user_Should_be_able_to_Navigate_to_Individual_Task_Screen() throws Throwable {

	}
	
	@Then("^\"([^\"]*)\" Button should be \"([^\"]*)\"$")
	public void button_should_be(String sButtonName, String sStatus) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.validateGivenButtonStatus(sButtonName,sStatus);
	}

	/*@Then("^Capture status by executing Query connecting to Database$")
	public void capture_status_by_executing_Query_connecting_to_Database() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.captureStatusFromDatabase();
	}*/
	
	@Given("^Capture status by executing Query connecting to Database for \"([^\"]*)\"$")
	public void capture_status_by_executing_Query_connecting_to_Database_for(String sLCD_Article) throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.captureStatusFromDatabase(sLCD_Article);
	}

	@Then("^Status on RA Review Work Queue Screen should match with the Status caputured from Database$")
	public void status_on_RA_Review_Work_Queue_Screen_should_match_with_the_Status_caputured_from_Database() throws Throwable {
		oEstablishProposalReviewWorkflowStepDef.ValidateReviewStatusWithDBAndUI();
	}
	
  @When("^User selects all Codecombinations in the \"([^\"]*)\"$")
   public void user_selects_all_Codecombinations_in_the(String sTabName) throws Throwable {
    
	oEstablishProposalReviewWorkflowStepDef.SelectAllCodeCombinations(sTabName);
	
}
  
  @Then("^the ReviewDecision should be auto populated as Reject with Remarks as \"([^\"]*)\"  for  excluded \"([^\"]*)\" with \"([^\"]*)\"   for \"([^\"]*)\" tabs$")
  public void the_ReviewDecision_should_be_auto_populated_as_Reject_with_Remarks_as_for_excluded_with_for_tabs(String sRejectRemarks, String sCPT_HCPCCode, String sNewICDCode, String sTabName) throws Throwable
  {
	  oEstablishProposalReviewWorkflowStepDef.validateExcludedCodesReviewdecision(sRejectRemarks,sCPT_HCPCCode,sNewICDCode,sTabName);	  
  }
  
  @Given("^the ReviewDecision should not be populated as Reject and Remarks should be blank for \"([^\"]*)\" with \"([^\"]*)\"   for \"([^\"]*)\" tabs$")
  public void the_ReviewDecision_should_not_be_populated_as_Reject_and_Remarks_should_be_blank_for_with_for_tabs(String sValidCPTCode, String sNewICDCode, String sTabName) throws Throwable 
  {
	  oEstablishProposalReviewWorkflowStepDef.validateValidCodesReviewDecision(sValidCPTCode,sNewICDCode,sTabName);
  }
	
	
}
