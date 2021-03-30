#Author: jaganmohan.appagari
@RegressionNov18
Feature: F7316 - Establish Operational Audit Functionality.

  #########################################################################################################################


##PreRequisite : Provide the TestData value in the step  "RA provides the completed Request Review"  code
@RegressionAdhoc5
  Scenario Outline: US20933-Ability to track History for Target Table data  ,US18177(: Track updates done to Target records )- need to chk it is covered
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Individual" Task Tab
    And RA provides the completed Request Review "<LCD_OR_ARTICLE>" id
    Then RA Review Work Queue screen should be displayed
    When RA update decision in "<Support_OR_Doesnot_Support>" task tab
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    Then Screen will be opened in a new tab with title CPTICD Links- Admin
    When User clicks on the "TargetData" tab
    And User clicks on History link for one of the code combinations
    Then User should be able to view the entire history of that combination
    Then Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | Support_OR_Doesnot_Support |
    | iht_ittest05 |   LCD          | Support                    |
     #| iht_ittest05 |   LCD          | Does                       |
    #| iht_ittest05 |   Article      | Support                    |
    #| iht_ittest05 |   Article      | Does                       |



  @RegressionAdhoc1
  Scenario Outline: US18177 Adhoc Tab Validation
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA claims "<LCD_OR_ARTICLE>" code with multiple weeks tasks from GroupTasks tab for "<WeekNo>" and "<ScenarioName>" with "<TestDataIDsRange>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on claimed "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    When RA clicks on "Individual" Task Tab
    And click on "Request LCD/Article for Review" and enter "<LCD_OR_ARTICLE>" claimed
    And pick some random rule from "Support Tab" and update the Decision for the CPT Code
    And pick some random rule from "Does Not Support Tab" and update the Decision for the CPT Code
    And Logout of the Application
    And RA Closes the Application
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    And Screen will be opened in a new tab with title CPTICD Links- Admin
    And validate the updated decision of CPT Code in Adhoc Review "Support Tab" for "<LCD_OR_ARTICLE>"
    And validate the updated decision of CPT Code in Adhoc Review "Does Not Support Tab" for "<LCD_OR_ARTICLE>"

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDGroup | WeekNo | TestDataIDsRange | ScenarioName |
      | iht_ittest05 | LCD            |           1 | Week1  |             811 |              |
      #| iht_ittest05 | Article        |           1 | Week1  |             942 |              |
