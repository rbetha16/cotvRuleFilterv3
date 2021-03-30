package project.features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import project.feature.steps.definitions.ManuallyCreatingNewCombinationsBaseOnAssociatedICDCodesStepDef;


public class ManuallyCreatingNewCombinationsBasedOnAssociatedICDCodesSteps {
	
	@Steps
	ManuallyCreatingNewCombinationsBaseOnAssociatedICDCodesStepDef oManuallyCreatingNewCombinationsStepDef;
	
	@When("^RA clicks the \"([^\"]*)\" id$")
	public void ra_clicks_the_id(String sLCD_OR_Article) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raClicksTheID(sLCD_OR_Article);
	}
	
	@When("^RA clicks on the \"([^\"]*)\" button$")
	public void ra_clicks_on_the_button(String arg1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raClicksOnTheButton(arg1);
	}
	
	@Then("^RA should be navigated to a screen with two tabs as  \"([^\"]*)\" and \"([^\"]*)\"$")
	public void ra_should_be_navigated_to_a_screen_with_two_tabs_as_and(String arg1, String arg2) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raShouldBeNavigatedToScreenWithTwoTabs(arg1,arg2);
	}
	
	@Then("^Add combination tab should be displayed with \"([^\"]*)\"$")
	public void add_combination_tab_should_be_displayed_with(String arg1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.addCombinationTabShouldBeDisplayedWith(arg1);
	}
	
	@Then("^Category dropdown should be displayed \"([^\"]*)\"$")
	public void category_dropdown_should_be_displayed(String sCategoryDropDownValues) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.ValidateCategoryDropDownValues(sCategoryDropDownValues);
	}
		
	@When("^RA claims \"([^\"]*)\" code from group Tasks$")
	public void ra_claims_code_from_group_Tasks(String LCD_Article) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raclaimsCodeFromGroupTasks(LCD_Article);		
	}
	
	@When("^RA clicks \"([^\"]*)\" times on the Add new ICD code button$")
	public void ra_clicks_times_on_the_Add_new_ICD_code_button(String arg1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.RAClicksOnAddNewICDCodeButton(arg1);
	}

	@Then("^RA should be able to see the \"([^\"]*)\" ICD code text fields with proper UI$")
	public void ra_should_be_able_to_see_the_ICD_code_text_fields_with_proper_UI(String arg1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.RAShouldBeAbleToSeeTheICDCodeTextFieldsWithProperUI(arg1);
	}
		
	@When("^RA clicks on claimed \"([^\"]*)\"$")
	public void ra_clicks_on_claimed(String LCD_Article) throws Throwable {
	  oManuallyCreatingNewCombinationsStepDef.raClicksOnClaimedLCDArticleID(LCD_Article);		
	}
		
	@Then("^The buton \"([^\"]*)\" should be displayed$")
	public void the_buton_should_be_displayed(String strButtonName) throws Throwable {
	 oManuallyCreatingNewCombinationsStepDef.validateAddEditCodeCombinationButton(strButtonName);	 
	}	
	
	@And("^The button \"([^\"]*)\" should be \"([^\"]*)\" based on Status \"([^\"]*)\"$")
	public void the_button_should_be_based_on_Status(String strButtonName, String strButtonStatus, String strReviewStatus) throws Throwable {
	 oManuallyCreatingNewCombinationsStepDef.validateAddEditCodeCombinationButtonStatus(strButtonName,strButtonStatus,strReviewStatus);	 
	}
	
	@When("^RA clicks on the \"([^\"]*)\" button based on Status \"([^\"]*)\"$")
	public void ra_clicks_on_the_button_based_on_Status(String strButtonName, String strReviewStatus) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raClicksOnTheButtonWithStatus(strButtonName,strReviewStatus);		
	}
	
	@When("^RA clicks on the \"([^\"]*)\" ID$")
	public void ra_clicks_on_the_ID(String sLCD_OR_Article) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raClicksOnTheFirstID(sLCD_OR_Article);
	}
	
	@Then("^RA should be able to see the \"([^\"]*)\" and \"([^\"]*)\" radio buttons$")
	public void ra_should_be_able_to_see_the_and_radio_buttons(String arg1, String arg2) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.ValidateManuallyAndAssociateCodeRadioButtons(arg1,arg2);
	}
	
	@When("^RA Clicks on \"([^\"]*)\" button$")
	public void ra_Clicks_on_button(String arg1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.RAClicksButton(arg1);
	}
	
	@When("^RA Enters the \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void ra_Enters_the(String BaseICDCode, String ICDGroup, String Category, String ICDCode,String ICDCode1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.RAEntersGivenData(BaseICDCode,ICDGroup,Category,ICDCode,ICDCode1); 
	}
		
	@Then("^the Alert should be displayed with the \"([^\"]*)\"$")	
	public void the_Alert_should_be_displayed_with_the(String arg1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.ValidateAlertMessage(arg1);
	}	
	
	@When("^RA Enters the Base ICD Code,ICD Group,New ICD Code for \"([^\"]*)\",\"([^\"]*)\" for \"([^\"]*)\"$")
	public void ra_Enters_the_Base_ICD_Code_ICD_Group_New_ICD_Code_for_for(String sNewICDCodesCount,String sCategory, String sLCD_Article) throws Throwable {
			oManuallyCreatingNewCombinationsStepDef.RAEntersBaseICDCodes(sNewICDCodesCount,sCategory,sLCD_Article);
	}  	

	@Then("^columns with \"([^\"]*)\" names should display on delete combination tab$")
	public void columns_with_names_should_display_on_delete_combination_tab(String arg1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.ColumnNamesInDeleteCombinationTab(arg1);
	}	
	 
	@Then("^Validate Sorting as \"([^\"]*)\" for column \"([^\"]*)\"$")
	public void validate_Sorting_as_for_column(String arg1, String arg2) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.ValidateSortingForColumn(arg1,arg2);
	} 

	@When("^RA Enters the CodeCombination details for \"([^\"]*)\",\"([^\"]*)\" for \"([^\"]*)\"$")
	public void ra_Enters_the_CodeCombination_details_for_for(String sNewICDCodesCount, String sCategory, String sLCD_Article) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.RAEntersCodeCombinations(sNewICDCodesCount,sCategory,sLCD_Article);
	}

	@When("^RA claims \"([^\"]*)\" code with multiple weeks tasks from GroupTasks tab$")
	public void ra_claims_code_with_multiple_weeks_tasks_from_GroupTasks_tab(String sLCDArticle) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raClaimsCodeWithMultipleWeeksTasks(sLCDArticle);	
	}
	
	@Then("^RA takes decisions on CodeCombinations and Completes RA Review$")
	public void ra_takes_decisions_on_CodeCombinations_and_Completes_RA_Review() throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raCompletesRAReview();	
	}
		
	@Given("^RA Claims Second week task from the GroupTasks tab for \"([^\"]*)\"$")
	public void ra_Claims_Second_week_task_from_the_GroupTasks_tab_for(String sLCDArticle) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raClaimsSecondWeekTask(sLCDArticle);
	}
	
	@Given("^RA claims \"([^\"]*)\" code with three weeks tasks from GroupTasks tab$")
	public void ra_claims_code_with_three_weeks_tasks_from_GroupTasks_tab(String sLCDArticle) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raClaimsCodeWithThreeWeeksTask(sLCDArticle);
	}

	
	@When("^RA Enters the Base ICD Code,ICD Group,New ICD Code on SubsequentTasks for \"([^\"]*)\",\"([^\"]*)\" for \"([^\"]*)\"$")
	public void ra_Enters_the_Base_ICD_Code_ICD_Group_New_ICD_Code_on_SubsequentTasks_for_for(String sNewICDCodesCount, String sCategory, String sLCD_Article) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.RAEntersSubsequentTaskCodeCombinations(sNewICDCodesCount,sCategory,sLCD_Article);
	}

	@When("^RA clicks on SecondWeekTask ID for \"([^\"]*)\"$")
	public void ra_clicks_on_SecondWeekTask_ID_for(String sLCDArticle) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raClicksSecondweekTaskID(sLCDArticle);	 
	}
	
	@Given("^RA captures the HCPCCodes for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void ra_captures_the_HCPCCodes_for_and(String sCategory, String sLCD_Article) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raCapturesHCPCCodes(sCategory,sLCD_Article);		   
	}	
	
	@Given("^Close the Alert Popup$")
	public void close_the_Alert_Popup() throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raClosesPopup();		
	}

	@When("^RA selects \"([^\"]*)\" as \"([^\"]*)\"$")
	public void ra_selects_as(String arg1, String arg2) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.RASelects(arg1,arg2);
	}

	@Then("^RA validate the filters applied for \"([^\"]*)\"$")
	public void ra_validate_the_filters_applied_for(String arg1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.RaValidatesFilterForColumn(arg1);
	}
	
	@Then("^RA should validate List of all manually added \"([^\"]*)\" ICD codes with Base ICD Codes$")
	public void ra_should_validate_List_of_all_manually_added_ICD_codes_with_Base_ICD_Codes(String arg1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.ValidateManuallyAddedCodesInDeleteTab(arg1);
	}
	
	@When("^RA enters date as \"([^\"]*)\" in delete combination tab$")
	public void ra_enters_date_as_in_delete_combination_tab(String arg1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.RAEntersDateInDeleteCombinationAs(arg1);
	}
	
	@When("^RA enters date as \"([^\"]*)\" in delete combination tab for RowNumber \"([^\"]*)\"$")
	public void ra_enters_date_as_in_delete_combination_tab_for_RowNumber(String sDate, String sRowNo) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.RAEntersDateInDeleteCombinationforRow(sDate, sRowNo);
		
	}

	@Given("^RA Closes the Application$")
	public void ra_Closes_the_Application() throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raClosesApplication();
	}
	
   @Then("^RA Selects the data grid Checkbox$")
    public void ra_Selects_the_data_grid_Checkbox() throws Throwable {
	oManuallyCreatingNewCombinationsStepDef.raSelectsGridCheckBox();
	}

	@Then("^Alert Popup should not be displayed$")
	public void alert_Popup_should_not_be_displayed() throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.AlertPoupShouldNotbeDisplayed();
	}
	
	@Given("^RA Validates selection as \"([^\"]*)\" and click on \"([^\"]*)\" in add combination tab$")
	public void ra_Validates_selection_as_and_click_on_in_add_combination_tab(String arg1, String arg2) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.RaValidatesRadioButtonsInAddCombTab(arg1,arg2);
	}
		
	@Then("^RA Selects \"([^\"]*)\" records for deletion$")
	public void ra_Selects_records_for_deletion(String sRecordsType) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raSelectsDeleteCombinationGridRecords(sRecordsType,"");
	}
	
	@Then("^RA Selects \"([^\"]*)\" record for deletion$")
	public void ra_Selects_record_for_deletion(String sRecordsType) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raSelectsDeleteCombinationGridRecords(sRecordsType,"");  
	}

	@Then("^Validate created new code combinations with all CPT codes under the \"([^\"]*)\"$")
	public void validate_created_new_code_combinations_with_all_CPT_codes_under_the(String arg1) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.ValidatingCreatedCodesUnderLCD(arg1);
	}

	@Given("^manually created code combinations should be set as Manual in \"([^\"]*)\" for that \"([^\"]*)\"$")
	public void manually_created_code_combinations_should_be_set_as_Manual_in_for_that(String arg1, String arg2) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.ValidatingManual10CodeInDB(arg1,arg2);
	}

	@Given("^Validate mapping between base and manually created codes in \"([^\"]*)\" for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void validate_mapping_between_base_and_manually_created_codes_in_for_and(String arg1, String arg2, String arg3) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.MappingBaseCodeWithManualCodeInDB(arg1,arg2,arg3);
	}
	
	@Then("^RA Selects single record for deletion$")
	public void ra_Selects_single_record_for_deletion() throws Throwable {
	   
	}

	@Then("^RA Selects all records for deletion$")
	public void ra_Selects_all_records_for_deletion() throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raSelectsGridCheckBox();
	}
		
	@Then("^Records as per the selection should be selected for deletion for \"([^\"]*)\"$")
	public void records_as_per_the_selection_should_be_selected_for_deletion_for(String sRecordsType) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.validateGriDRecordSelection(sRecordsType,"");		
	   
	}

	@Then("^Manually added \"([^\"]*)\" should be successfully \"([^\"]*)\" from UI$")
	public void manually_added_should_be_successfully_from_UI(String sNewCodeType, String sOperation) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.validateNewCodesinUI(sNewCodeType,sOperation);
	   
	}
	
	@Then("^manually created code combinations should be set as manual in \"([^\"]*)\" for that \"([^\"]*)\" in target$")
	public void manually_created_code_combinations_should_be_set_as_manual_in_for_that_in_target(String arg1, String arg2) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.ValidatingManual10CodeInTargetDB(arg1,arg2);
	}

	@Then("^RA Clicks on the \"([^\"]*)\"$")
	public void ra_Clicks_on_the(String sTabName) throws Throwable {
	   oManuallyCreatingNewCombinationsStepDef.raClicksOnDataTab(sTabName);		
	}
	
	@Then("^The records should be delted from the \"([^\"]*)\" Popup$")
	public void the_records_should_be_delted_from_the_Popup(String sTabName) throws Throwable {
	  	oManuallyCreatingNewCombinationsStepDef.raValidatesRecordsDeletion(sTabName,"");			
	}
		
	@Then("^Manually added codes should be successfully deleted from \"([^\"]*)\" for \"([^\"]*)\" and for the \"([^\"]*)\"$")
	public void manually_added_codes_should_be_successfully_deleted_from_for_and_for_the(String sTableName, String sCategoryType, String sLCD_Article) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raValidateRecordsDeletionFromDB(sTableName,sCategoryType,sLCD_Article);
	}

	@Then("^Manually added codes should be successfully deleted from Manualtable \"([^\"]*)\" for \"([^\"]*)\" and for the \"([^\"]*)\"$")
	public void manually_added_codes_should_be_successfully_deleted_from_Manualtable_for_and_for_the(String sTableName, String sCategoryType, String sLCD_Article)throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raValidateRecordsDeletionFromManualTableDB(sTableName,sCategoryType,sLCD_Article);
	   
	}
	
	@Given("^CodeCombinations created for the records should be deleted from UI for \"([^\"]*)\" and for \"([^\"]*)\"$")
	public void codecombinations_created_for_the_records_should_be_deleted_from_UI_for_and_for(String sCategoryType, String sLCD_Article) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raValidateRecordsDeletionFromUI(sCategoryType,sLCD_Article);		
	}	

	@When("^Manual codecombination should be DateBanded to the user selected DOSTO \"([^\"]*)\" in \"([^\"]*)\" and for the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void manual_codecombination_should_be_DateBanded_to_the_user_selected_DOSTO_in_and_for_the_and(String sDates, String sTargetTable, String sLCD_Article, String sCategoryType) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raValidateDosToinTargetTable(sDates,sTargetTable,sLCD_Article,sCategoryType);		
	}	
	
	@Then("^Manually added codes should be successfully deleted from \"([^\"]*)\" for \"([^\"]*)\" and for the \"([^\"]*)\" for \"([^\"]*)\"$")
	public void manually_added_codes_should_be_successfully_deleted_from_for_and_for_the_for(String sTableName, String sCategoryType, String sLCD_Article, String sNewCodes) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raValidateRecordsDeletionFromDBNewCodes(sTableName,sCategoryType,sLCD_Article,sNewCodes);   
	}
		
	@Then("^Manually added codes should be successfully deleted from Manualtable \"([^\"]*)\" for \"([^\"]*)\" and for the \"([^\"]*)\"  for \"([^\"]*)\"$")
	public void manually_added_codes_should_be_successfully_deleted_from_Manualtable_for_and_for_the_for(String sTableName, String sCategoryType, String sLCD_Article, String sNewCodes) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raValidateRecordsDeletionFromManualTableDBNewCodes(sTableName,sCategoryType,sLCD_Article,sNewCodes);
		
	}
	
	@Then("^Manual codecombination should be DateBanded to the user selected DOSTO \"([^\"]*)\" in \"([^\"]*)\" and for the \"([^\"]*)\" and \"([^\"]*)\"  for \"([^\"]*)\"$")
	public void manual_codecombination_should_be_DateBanded_to_the_user_selected_DOSTO_in_and_for_the_and_for(String sDates, String sTargetTable, String sLCD_Article, String sCategoryType, String sNewCodes) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raValidateDosToinTargetTableforNewCodes(sDates,sTargetTable,sLCD_Article,sCategoryType,sNewCodes);
	
	}	

	@Given("^RA Enters new Manual ICDCode for \"([^\"]*)\"$")
	public void ra_Enters_new_Manual_ICDCode_for(String sLCD_Article) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raEntersNewManualICDCode(sLCD_Article);
	}
		
	@When("^RA captures the HCPCCodes for \"([^\"]*)\" and \"([^\"]*)\" for Manual maintained Codecombinations$")
	public void ra_captures_the_HCPCCodes_for_and_for_Manual_maintained_Codecombinations(String sCategoryType,String sLCD_Article) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raCapturesHCPCCodesManuallyMaintain(sCategoryType,sLCD_Article);
	}	

	@Given("^DOSTo should be set to \"([^\"]*)\" default date in the target for \"([^\"]*)\" and for \"([^\"]*)\"$")
	public void dosto_should_be_set_to_default_date_in_the_target_for_and_for(String sDate, String sNewICDCode, String sLCD_Article) throws Throwable {
		    oManuallyCreatingNewCombinationsStepDef.validateDOSToDatesinTarget(sDate,sNewICDCode,sLCD_Article);	
	}
		
	@Given("^DOSFrom should be set to open ended default dates in the target for \"([^\"]*)\" and for \"([^\"]*)\"$")
	public void dosfrom_should_be_set_to_open_ended_default_dates_in_the_target_for_and_for(String sNewICDCode, String sLCD_Article) throws Throwable {
			oManuallyCreatingNewCombinationsStepDef.validateDOSFromDatesinTarget(sNewICDCode,sLCD_Article);
	}

	@Given("^Manual indicator value should be set to \"([^\"]*)\" in the TargetTable for \"([^\"]*)\" for LCDArticleVersion \"([^\"]*)\"$")
	public void manual_indicator_value_should_be_set_to_in_the_TargetTable_for_for_LCDArticleVersion(String sIndicatorVal, String sLCD_Article, String sLCDArticleVersion) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raValidatesManualIndicatorinTarget(sIndicatorVal,sLCD_Article,sLCDArticleVersion);	
	}

	@Given("^AddCombination Popup window  should not be closed automatically$")
	public void addcombination_Popup_window_should_not_be_closed_automatically() throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.raValidatesPopupWindow();
		  
	}

	@Then("^The system should display the list of all the manually maintained code combination to the user with Basecode and DOSTo as \"([^\"]*)\"$")
	public void the_system_should_display_the_list_of_all_the_manually_maintained_code_combination_to_the_user_with_Basecode_and_DOSTo_as(String sExpectedValue) throws Throwable {
	  	 oManuallyCreatingNewCombinationsStepDef.validateBaseCodeandDOSToforManuallyMaintained(sExpectedValue);
	}
	
	@When("^Validate mapping between base and manually created codes in \"([^\"]*)\"  and  for  \"([^\"]*)\"$")
	public void validate_mapping_between_base_and_manually_created_codes_in_and_for(String sTableName, String SLCD_Article) throws Throwable {
		oManuallyCreatingNewCombinationsStepDef.validateNewCodesinDB(sTableName,sTableName);
	}
	
@Given("^RA Selects the Next Week TaskID$")
    public void ra_Selects_the_Next_Week_TaskID() throws Throwable {
	oManuallyCreatingNewCombinationsStepDef.selectNextWeekTask();
}

@Then("^System should \"([^\"]*)\" combination with the new \"([^\"]*)\" to the ManuallyMaintainCode combination for \"([^\"]*)\"   and  for LCDArticleVersion \"([^\"]*)\"$")
  public void system_should_combination_with_the_new_to_the_Codecombination_for_and_for_LCDArticleVersion(String sValidation, String sHCPCCode, String sLCDArticle, String sVersion) throws Throwable {
	    oManuallyCreatingNewCombinationsStepDef.validateNewCodeCombInManualTable(sValidation,sHCPCCode,sLCDArticle,sVersion);
}

  @Then("^Manual indicator value should be set to \"([^\"]*)\" in the \"([^\"]*)\"  for  \"([^\"]*)\"  for LCDArticleVersion \"([^\"]*)\" and for \"([^\"]*)\"$")
  public void manual_indicator_value_should_be_set_to_in_the_for_for_LCDArticleVersion_and_for(String sIndicator, String sTableName, String sLCDArticle, String sVersion, String sCode) throws Throwable {
       	oManuallyCreatingNewCombinationsStepDef.validateManualIndicatorInDeltaTable(sIndicator,sTableName,sLCDArticle,sVersion,sCode);
}	
    
  @Given("^Validate mapping between base and manually created codes in \"([^\"]*)\"  and  for  \"([^\"]*)\"  for \"([^\"]*)\" codes$")
  public void validate_mapping_between_base_and_manually_created_codes_in_and_for_for_codes(String sTableName, String sLCD_Article, String sCodeComboType) throws Throwable {
	  	oManuallyCreatingNewCombinationsStepDef.validateNewCodesintheDB(sTableName,sLCD_Article,sCodeComboType);
  }
  
  @Given("^DOSTo should be Datebanded in the target for \"([^\"]*)\"  for \"([^\"]*)\" and for \"([^\"]*)\" and  for LCDArticleVersion \"([^\"]*)\"$")
  public void dosto_should_be_Datebanded_in_the_target_for_for_and_for_and_for_LCDArticleVersion(String sNewICDCode, String sLCD_Article, String sHCPCCode, String sLCDArticleVersion) throws Throwable {
	   oManuallyCreatingNewCombinationsStepDef.validateDOSToDateBanding(sNewICDCode,sLCD_Article,sHCPCCode,sLCDArticleVersion);
  }
   
  @Given("^DOSTo should be set to \"([^\"]*)\"  in the target for \"([^\"]*)\"  and  \"([^\"]*)\"  and for \"([^\"]*)\" and  for LCDArticleVersion \"([^\"]*)\"$")
  public void dosto_should_be_set_to_in_the_target_for_and_and_for_and_for_LCDArticleVersion(String sOpenDate,String sNewICDCode, String sHCPCCode, String sLCD_Article, String sLCDArticleVersion) throws Throwable {
	  oManuallyCreatingNewCombinationsStepDef.validateDOSToOpenDate(sOpenDate,sNewICDCode,sHCPCCode,sLCD_Article,sLCDArticleVersion);
}
  
@When("^Manual indicator value should be set to \"([^\"]*)\" in the TargetTable for \"([^\"]*)\" for LCDArticleVersion \"([^\"]*)\"  and for \"([^\"]*)\"$")
  public void manual_indicator_value_should_be_set_to_in_the_TargetTable_for_for_LCDArticleVersion_and_for(String sIndicatorVal, String sLCD_Article, String sLCDArticleVersion, String sHCPCCode) throws Throwable {
	oManuallyCreatingNewCombinationsStepDef.raValidatesManualIndicatorinTargetwithCode(sIndicatorVal,sLCD_Article,sLCDArticleVersion,sHCPCCode);	
}

@Given("^Manual indicator value should be set to \"([^\"]*)\" in the TargetTable for \"([^\"]*)\" for LCDArticleVersion \"([^\"]*)\"  for AssociatedCodes$")
   public void manual_indicator_value_should_be_set_to_in_the_TargetTable_for_for_LCDArticleVersion_for_AssociatedCodes(String sIndicatorVal, String sLCD_Article, String sLCDArticleVersion) throws Throwable {
	oManuallyCreatingNewCombinationsStepDef.raValidatesManualIndicatorinTargetForAssociatedCodes(sIndicatorVal,sLCD_Article,sLCDArticleVersion);
}

@Given("^RA claims \"([^\"]*)\" code with multiple weeks tasks from GroupTasks tab for \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$")
   public void ra_claims_code_with_multiple_weeks_tasks_from_GroupTasks_tab_for_and_with(String sLCD_Article, String sWeekNo, String sScenarioName, String sTestDataRange) throws Throwable {
	oManuallyCreatingNewCombinationsStepDef.raClaimsGrpTasksDataByScenario(sLCD_Article,sWeekNo,sScenarioName,sTestDataRange);
}

@Given("^click on \"([^\"]*)\" and enter \"([^\"]*)\" claimed$")
  public void click_on_and_enter_claimed(String arg1, String arg2) throws Throwable {
	
	oManuallyCreatingNewCombinationsStepDef.click_on_and_enter_claimedRule(arg1, arg2);
    
}

@Given("^pick some random rule from \"([^\"]*)\" and update the Decision for the CPT Code$")
   public void pick_some_random_rule_from_and_update_the_Decision_for_the_CPT_Code(String arg1) throws Throwable {
   
	oManuallyCreatingNewCombinationsStepDef.pick_some_random_rule_from_and_update_the_Decision_for_the_CPT_Code(arg1);
    
}

@Given("^validate the updated decision of CPT Code in Adhoc Review \"([^\"]*)\" for \"([^\"]*)\"$")
   public void validate_the_updated_decision_of_CPT_Code_in_Adhoc_Review_for(String arg1, String arg2) throws Throwable {
	oManuallyCreatingNewCombinationsStepDef.validate_the_updated_decision_of_CPT_Code_in_Adhoc_Review_for(arg1,arg2);
    
}


@Then("^RA rejects accepted decision by searching \"([^\"]*)\" from \"([^\"]*)\" and verifies the updated decision$")
public void ra_rejects_accepted_decision_by_searching_from_and_verifies_the_updated_decision(String arg1, String arg2) throws Throwable {
	oManuallyCreatingNewCombinationsStepDef.raUpdateAcceptDecisionAsReject(arg1, arg2);
}

@Then("^verify updated decision for  \"([^\"]*)\" in TargetTable for all juries with  \"([^\"]*)\" in DB \"([^\"]*)\"$")
public void verify_updated_decision_for_in_TargetTable_for_all_juries_with_in_DB(String arg1, String arg2, String arg3) throws Throwable {
	oManuallyCreatingNewCombinationsStepDef.raValidatesUpdatedDecisioninTargetTable(arg1, arg2, arg3);
}

@Then("^verify label saying \"([^\"]*)\" on the top of the pop up screen$")
public void verify_label_saying_on_the_top_of_the_pop_up_screen(String arg1) throws Throwable {
	oManuallyCreatingNewCombinationsStepDef.raValidatesAddCombinationPopupHeader(arg1);
}

@Given("^Validate Sorting as \"([^\"]*)\" for column \"([^\"]*)\" in DataIntegrity grid$")
public void validate_Sorting_as_for_column_in_DataIntegrity_grid(String arg1, String arg2) throws Throwable {
	oManuallyCreatingNewCombinationsStepDef.ValidateSortingForColumnsInDataIntegrityGrid(arg1, arg2);
}

@When("^RA selects \"([^\"]*)\", ICD group as \"([^\"]*)\" and add new ICD code \"([^\"]*)\"$")
public void ra_selects_ICD_group_as_and_add_new_ICD_code(String arg1, String arg2, String arg3) throws Throwable {
	oManuallyCreatingNewCombinationsStepDef.raSelectsManualOptionAndAddICDCode(arg1, arg2, arg3);
}

}
	
	


