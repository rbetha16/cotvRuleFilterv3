#Author: jaganmohan.appagari
@RegressionNov18
Feature: F7315 -Establish Proposal Review Workflow - August.

  #########################################################################################################################

##  Prerequisite: Provide the value for the LCD/Article Query in the code before execution

@RegressionReassgn
  Scenario Outline: US23990-Ability to not let RA initiate Review for an LCD/Article without completing previous task
    Given User logs with "<CPT-ICD-RA>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    
    And RA clicks on "Group" Task Tab
    Given Multiple Weeks Task exist for the same "<LCD_OR_ARTICLE>" and First week Task Status is not Started
    And "<CPT-ICD-RA>" User tries to Claim Subsequent Weeks Task from Group Tasks Screen
    Then an "<Error_Msg_Claimed>" should be displayed
    
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    When RA clicks on "Admin" Task Tab
    And "<Admin>" User tries to Reassign the Subsequent Weeks Task from Admin Code Combination Screen
    Then an "<Error_Msg_Reassigned>" should be displayed
    
    When First Week Task Status is "Started"
    And "<CPT-ICD-RA>" User tries to Claim Subsequent Weeks Task from Group Tasks Screen
    Then an "<Error_Msg_Claimed>" should be displayed
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    When RA clicks on "Admin" Task Tab
    And "<Admin>" User tries to Reassign the Subsequent Weeks Task from Admin Code Combination Screen
    Then an "<Error_Msg_Reassigned>" should be displayed
    
    When First Week Task Status is "Completed"
    And "<CPT-ICD-RA>" User tries to Claim Subsequent Weeks Task from Group Tasks Screen
    Then Task should be successfully "Claimed"
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    When RA clicks on "Admin" Task Tab
    And "<Admin>" User tries to Reassign the Subsequent Weeks Task from Admin Code Combination Screen
    Then Task should be successfully "Reassigned"
    And Logout of the Application

    Examples: 
      | CPT-ICD-RA   | Admin        | LCD_OR_ARTICLE | Error_Msg_Claimed | Error_Msg_Reassigned |
      | iht_ittest05 | iht_ittest05 | LCD                        | Claimed                    | Reassigned           |
