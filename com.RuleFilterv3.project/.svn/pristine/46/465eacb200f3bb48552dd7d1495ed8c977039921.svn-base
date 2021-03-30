#Author: Udayakiran Lanka

@RegressionNov21
Feature: F11404 - Update date banding logic for CPT ICD Combination

### WORKING
@RegressionNov22
   Scenario Outline: US47396 US47397  Ability to update DOS to equals to Retired date when LCD/Article is retired  - Manually Maintained codes--  Retired date is BLANK
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
    When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
    And  Category should be selected as "Support" and should be non-editable 
    When RA Enters the "<ICD Group>","<MMCategory>" and "<NewICDCode2>"
    And  RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And  Close the Alert Popup
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And RA captures OpenDated DOSTo records from Target for "<LCD_OR_ARTICLE>"  for version "1"
    And Logout of the Application
    And RA Closes the Application
   # Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"	
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then DOSTo value of the all OpenDated records should be updated according to ReiredDate Dateband Logic for "<LCD_OR_ARTICLE>"   for version "2"   
    Then Logout of the Application

    Examples: 
      | User ID        | LCD_OR_ARTICLE|WeekNo|ScenarioName|TestDataIDsRange|Base ICD Code|ICD Group|Category|New ICD Code|New ICD Code1|NewICDCode2|MMCategory|
      | iht_ittest05 |   LCD                    |    Week2 |                      |    80191-80195     | C69.31              |1               |  Support |Y37.001A            |                         |  Y37.001D            |                      |   	
     | iht_ittest05 |   Article                |    Week2 |                      |     94287-94294      |C69.31               |1               |  Support |Y37.001A             |                         | Y37.001D       |                      |
          
          
          
          
     ### WORKING   
@RegressionNov22
   Scenario Outline: US47396 US47397  Ability to update DOS to equals to Retired date when LCD/Article is retired  - Manually Maintained codes--  Retired date is  NOT BLANK
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
    When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
    And  Category should be selected as "Support" and should be non-editable 
    When RA Enters the "<ICD Group>","<MMCategory>" and "<NewICDCode2>"
    And  RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And  Close the Alert Popup
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And RA captures OpenDated DOSTo records from Target for "<LCD_OR_ARTICLE>"  for version "1"
    And Logout of the Application
    And RA Closes the Application
   # Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"	
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then DOSTo value of the all OpenDated records should be updated according to ReiredDate Dateband Logic for "<LCD_OR_ARTICLE>"   for version "2"   
    Then Logout of the Application

    Examples: 
      | User ID        | LCD_OR_ARTICLE|WeekNo|ScenarioName|TestDataIDsRange|Base ICD Code|ICD Group|Category|New ICD Code|New ICD Code1|NewICDCode2|MMCategory|
      | iht_ittest05 |   LCD                    |    Week2 |                      |    80196-80200               | C69.31              |1               |  Support |Y37.001A            |                         |  Y37.001D            |                      |   	
    | iht_ittest05 |   Article                |    Week2 |                      |       94295-94300              | C69.31              |1               |  Support |Y37.001A             |                         | Y37.001D       |                      |
          
          
       
   ### WORKING
          
 ##Week2- Delete HCPC Code     
@RegressionNov22
    Scenario Outline: US43115 - Update the date band logic to- DOS To = Revision effective date minus 1 day
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
    When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
    And  Category should be selected as "Support" and should be non-editable 
    When RA Enters the "<NewICDGroup>","<Category>" and "<NewICDCode>"    
    And  RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message1>"
    And  Close the Alert Popup
     And  RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>" for Manual maintained Codecombinations
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And  Logout of the Application
    And  RA Closes the Application    
    #Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And  RA clicks on "Group" Task Tab
    And  RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then   RA Review Work Queue screen should be displayed
    And  Review status should be dispalyed as "Not Started"
    When  RA clicks on "Start Review"    
    Then Review status should be dispalyed as "Started"
    And  DOSTo should be Datebanded in the target for "<NewICDCode>"  for "<LCD_OR_ARTICLE>" and for "<DeletedHCPCCode>" and  for LCDArticleVersion "2" 
    And Logout of the Application

   Examples: 
         | User ID        | LCD_OR_ARTICLE |Alert Message1  															                    |	NewICDGroup  |NewICDCode|Category|Count|ManualCodeCombTable           |HCPCCode|DeletedHCPCCode|WeekNo|ScenarioName|TestDataIDsRange|
      # | iht_ittest05 | LCD                        |Code combination(s) are created successfully. |    1                   | Y37.001A     |               |  1 | LCD_MANUAL_CODE_COMB  | 0291T      |   G9143                 | Week2|                          |       80166-80180                       | 
       | iht_ittest05 | Article                    |Code combination(s) are created successfully. |    1                   | Y37.001A     |               |  1 | ART_MANUAL_CODE_COMB  | 0291T      |   G9143                 | Week2|                          |    94261-94275               | 
         