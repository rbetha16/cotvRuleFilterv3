@RegressionFeb28th
Feature: F11383- Ability to create record for and revise date banding logic as per jurisdiction for support combinations-After Apr

  Scenario Outline: US45296 - Ability to pull only 1 record for the combination if user 'request for code combinations': LCD and Article (TC16536)
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
    Then RA rejects accepted decision by searching "<LCD_OR_ARTICLE>" from "<Category>" and verifies the updated decision
    Then verify updated decision for  "<LCD_OR_ARTICLE>" in TargetTable for all juries with  "<LCDArtVersion>" in DB "<DBValidationScenario>"
    And Logout of the Application
    And RA Closes the Application
    ##Navigate to Admin Screen
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    And Screen will be opened in a new tab with title CPTICD Links- Admin
    And RA filters by ID for "<LCD_OR_ARTICLE>" with status "<Status>"
    When RA clicks on "AdhocReviewTab"
    And The above updated decisions should be displayed in the screen for "<LCD_OR_ARTICLE>" and "<Category>" and "<LCDArtVersion>"
    Then Logout of the Application
    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Category|LCDArtVersion| DBValidationScenario  |Status|
      | iht_ittest05 | LCD            | Week1  |              | 600				       | Support | 1					 |UpdateDecision-5,A,K   |2     |
      | iht_ittest05 | Article        | Week1  |              |              910 | Support |1						 |UpdateDecision-5,D,K   |2     |

      @RegressionFeb28th
    Scenario Outline: TC17957 label saying "Add associated codes manually" on the top of the pop up screen 
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
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Add Combination" Task Tab
    Then RA should be able to see the "manually" and "associate" radio buttons
    When RA Enters the "<Base ICD Code>","<ICD Group>","<Category>","<New ICD Code>","<New ICD Code1>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And Close the Alert Popup
    And RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>"
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And click on "Request LCD/Article for Review" and enter "<LCD_OR_ARTICLE>" claimed
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    Then verify label saying "Add Associated Codes Manually" on the top of the pop up screen
    Then Logout of the Application
     Examples: 
       | User ID      | LCD_OR_ARTICLE | NewICDGroup | WeekNo | TestDataIDsRange |Base ICD Code | ICD Group | Category | New ICD Code|New ICD Code1 |
       | iht_ittest05 | LCD            |           1 | Week1  |             600 | C69.31        |         1 | Support  | Y37.001A    |              |
       | iht_ittest05 | Article        |           1 | Week1  |             800 | C69.31        |         1 | Support  | Y37.001A    |              |
       
       
         # Need to check the coverage for the combination is date banded or subsequent add
      @RegressionFeb26th 
    Scenario Outline: (TESLA-2238) Ability to populate history screen with Jurisdiction changes
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
    And RA provides the completed Request Review "<LCD_OR_ARTICLE>" id
    Then RA Review Work Queue screen should be displayed
    When RA update decision in "<Support_OR_Doesnot_Support>" task tab
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    Then Screen will be opened in a new tab with title CPTICD Links- Admin
    When User clicks on the "TargetData" tab
    Then filter  LCD_OR_ARTICLE id with required code combination and jury name "<Jury>"
    Then verify updated decision for  "<LCD_OR_ARTICLE>" in TargetTable for all juries with  "<LCDArtVersion>" in DB "<DBValidationScenario>"
    Then Logout of the Application
    
     Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Category|LCDArtVersion| DBValidationScenario  | Support_OR_Doesnot_Support | Jury   |
      | iht_ittest05 | LCD            | Week1  |              | 600				       | Support | 1					 |UpdateDecision-5,A,K   |Support											|5,A,K   |
      | iht_ittest05 | Article        | Week1  |              |              900 | Support |1						 |UpdateDecision-5,D,K   |Support											|5,D,K   |
    
   
    