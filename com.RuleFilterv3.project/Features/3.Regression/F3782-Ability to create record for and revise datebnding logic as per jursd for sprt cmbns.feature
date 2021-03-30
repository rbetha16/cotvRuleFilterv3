#Author: Udayakiran Lanka
@RegressionNov21
Feature: F3782 Ability to create record for and revise date banding logic as per jurisdiction for support combinations

  ###  WORKING
  @RegressionJan7
  Scenario Outline: US46533 - Copy of decisions and comments of Delta Records to all jurisdiction records- LCD/Article-TC15359,TC15367
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA claims "<LCD_OR_ARTICLE>" code from group Tasks
    When RA clicks on "Individual" Task Tab
    When RA clicks on claimed "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    When RA clicks on "<TabName>" Task Tab
    When User selects some codecombinations in the "<Support_OR_Doesnot_Support>"
    When RA clicks on "Accept"
    Then the codecombination should be set as "Accept" in ReviewDecision column
    And "Accept" decision should be copied to all Jurisidictions
    When RA clicks on "ReviewDecisionDropdown"
    When RA clicks on "BlankReviewDecision"
    When RA clicks on "ApplyFilters"
    When User selects some codecombinations in the "<Support_OR_Doesnot_Support>"
    When RA clicks on "Reject"
    And RA selects a reason for Rejection  as "Non-configurable-Frequency"
    Then the codecombination should be set as "Reject" in ReviewDecision column
    And RA clicks on "ClearAllFilters"
    And "Reject" decision should be copied to all Jurisidictions
    When RA clicks on "ReviewDecisionDropdown"
    When RA clicks on "BlankReviewDecision"
    When RA clicks on "ApplyFilters"
    When User selects all Codecombinations in the "<Support_OR_Doesnot_Support>"
    When RA clicks on "Accept"
    And RA clicks on "ClearAllFilters"
    And RA captues the Decisions count
    When RA clicks on "Does" Task Tab
    When User selects all Codecombinations in the "DoesNotSupportTab"
    When RA clicks on "Reject"
    And RA selects a reason for Rejection  as "Non-configurable-Frequency"
    And Capture decisions taken from DeltaTable for  "<LCD_OR_ARTICLE>"
    When RA clicks on "CompleteRAReview"
    Then All the decisions should be copied to the Target for  "<LCD_OR_ARTICLE>"
    Then Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | Support_OR_Doesnot_Support | TabName |
      | iht_ittest05 | LCD            | SupportTab                 | Support |
      | iht_ittest05 | Article        | SupportTab                 | Support |

  ##WORKING
  #Take both Support & DoesnotSupport Updated data
  @RegressionNov21 @RegressionFeb7th
  Scenario Outline: US49545- Handling Associated codes- Manual delete- LCD (TC15482)
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount1>","Support-ValidCodes" for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message1>"
    And Validate mapping between base and manually created codes in "<ManualCodeCombTable>" for "<Category_Type>" and "<LCD_OR_ARTICLE>"
    And RA captures the HCPCCodes for "<Category_Type>" and "<LCD_OR_ARTICLE>"
    And Close the Alert Popup
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
    #Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Add Combination" Task Tab
    Then RA should be able to see the "manually" and "associate" radio buttons
    When RA clicks on "Delete Combination" Task Tab
    When RA enters date as "<Dates>" in delete combination tab
    Then RA Selects the data grid Checkbox
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "The selected combination(s) are successfully date banded."
    And Manual codecombination should be DateBanded to the user selected DOSTO "<Dates>" in "<TargetTable>" and for the "<LCD_OR_ARTICLE>" and "<Category_Type>"  for "ICDCode1"  and  for Version "1"  for all Jurisidictions
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount1 | NewICDCodesCount2 | Category_Type | Category           | Category2                | Dates      | Alert Message1                                | ManualCodeCombTable  | SupportTables          | WeekNo | ScenarioName | TestDataIDsRange |
      | iht_ittest05 | LCD            |                 1 |                 2 | Support       | Support-ValidCodes | Subsequent_SupportSingle | 12/10/2018 | Code combination(s) are created successfully. | LCD_MANUAL_CODE_COMB | LCD_CPT_ICD_SPRT_DELTA | Week2  |              | 81111-81199      |

  ### WORKING     - To take care of the Script values,if we update the value to 20.27 for Support tab
  #														 and add the same value(20.27) as Manual code in Week1,then in W2 it will be datebanded and wont be available in Delete Combination tab in W2
  #														 So can add 20.26  as Manual code if 20.27 is used in Update Script
  @RegressionJan7
  Scenario Outline: US49545- Handling Associated codes- Manual delete- LCD (TC15483)
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA claims "<LCD_OR_ARTICLE>" code from group Tasks
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount1>","<Category>" for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message1>"
    And RA captures the HCPCCodes for "<Category_Type>" and "<LCD_OR_ARTICLE>"
    When RA clicks on "Delete Combination" Task Tab
    When RA enters date as "<Dates>" in delete combination tab
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "The selected combination(s) are successfully deleted."
    And DeletedCodeCombinations should not be moved to TargetTable for  the "<LCD_OR_ARTICLE>"  and "<Category_Type>"  for "ICDCode1"  and  for Version "1"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount1 | Category_Type | Category           | Dates      | Alert Message1                                | ManualCodeCombTable  | SupportTables          |
      | iht_ittest05 | LCD            |                 1 | Support       | Support-ValidCodes | 12/10/2018 | Code combination(s) are created successfully. | LCD_MANUAL_CODE_COMB | LCD_CPT_ICD_SPRT_DELTA |

  ###  WORKING
  @RegressionNov22
  Scenario Outline: US46613 US46350  - Ability to update DOS to equals to Retired date when LCD/Article is retired - Associated Codes
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
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | MMCategory |
      #    | iht_ittest05 |   LCD                    |    Week2 |                      |    80191-80195                 |  C69.31         |1                |  Support |Y37.001A      |                       |  Y37.001D        |                      |
      | iht_ittest05 | Article        | Week2  |              | 94287-94294      | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    |            |

  ### WORKING
  @RegressionJan7
  Scenario Outline: US45295,US46798 - Ability to populate multiple records for the same combination in Target data tab,Ability to view multiple jurisdiction records in target data tab
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount1>","<CategoryType>" for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And Close the Alert Popup
    And RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>"
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And RA captures OpenDated DOSTo records from Target for "<LCD_OR_ARTICLE>"  for version "1"
    And Logout of the Application
    And RA Closes the Application
    #Login  to access the TargetData screen
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    And Screen will be opened in a new tab with title CPTICD Links- Admin
    And User clicks on the "TargetData" tab
    Then User should be able to see all the adjudication records on the screen for  the "<LCD_OR_ARTICLE>"
    And CodeCombinations for  the "<LCD_OR_ARTICLE>"  and for "ICDCode1" and for "<Category>"  for LCDArticleVersion "1" should be displayed in the TargetData Screen
    Then Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType       | DOSToOpenDate | NewICDCodesCount1 |
      | iht_ittest05 | LCD            | Week1  |              |              802 | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 |
      | iht_ittest05 | Article        | Week1  |              |              942 | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 |

  ### WORKING
  @RegressionNov21
  Scenario Outline: US49544 , - Ability to handle associate code - ICD Code Subsequent add (Bring Mnaul code in W2 from CMS)- Start review- LCD (Scenario 1 & 2)
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
    And RA captures OpenDated DOSTo records from Target for "<LCD_OR_ARTICLE>"  for version "1"
    And Logout of the Application
    And RA Closes the Application
    ###Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    And Records should be updated for "<LCD_OR_ARTICLE>" in TargetTable for LCDArticle Version "2"  and according to MultipleJuries  for the "<DBValidationScenario>"
    And DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<New ICD Code>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "2"
    And Manual indicator value should be set to "0" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "2"
    And Logout of the Application
    And RA Closes the Application
    # Login again in to access the TargetData screen
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    And Screen will be opened in a new tab with title CPTICD Links- Admin
    And User clicks on the "TargetData" tab
    Then User should be able to see all the adjudication records on the screen for  the "<LCD_OR_ARTICLE>"
    And CodeCombinations for  the "<LCD_OR_ARTICLE>"  and for "ICDCode1" and for "<Category>"  for LCDArticleVersion "2" should be displayed in the TargetData Screen
    Then Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType       | DOSToOpenDate | NewICDCodesCount1 | DBValidationScenario        |
      #   | iht_ittest05 |   LCD                    |    Week2 |                      |    80141-80150                | C69.31          |1               |  Support  |Y37.001A    |                               | Y37.001D     |   Support-ValidCodes   |   12/31/9999     | 1                               |AddNewICDCodeW2CMS-Y37.001A |
      | iht_ittest05 | Article        | Week2  |              | 94141-94150      | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 | AddNewICDCodeW2CMS-Y37.001A |

  ###  WORKING
  @RegressionJan7
  Scenario Outline: US49463 - Ability to display single records in Admin tab/Individual tab/Group task
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA captures ID from DB and filters for "<LCD_OR_ARTICLE>"
    And Only one Record Shoud be displayed for different Juries in the "GroupTasks" Screen and "Jurisdiction" column should be blank
    And RA claims the ID  from group Tasks
    When RA clicks on "Individual" Task Tab
    And Only one Record Shoud be displayed for different Juries in the "IndividualTasks" Screen and "Jurisdiction" column should be blank
    When RA clicks on claimed "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    Then Logout of the Application
    And RA Closes the Application
    #Navigate to Admin Screen
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    And Screen will be opened in a new tab with title CPTICD Links- Admin
    And Only one Record Shoud be displayed for different Juries in the "Admin" Screen and "Jurisdiction" column should be blank
    Then Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | Support_OR_Doesnot_Support | TabName |
      | iht_ittest05 | LCD            | SupportTab                 | Support |
      | iht_ittest05 | Article        | SupportTab                 | Support |

  ###  WORKING
  @RegressionNov21
  Scenario Outline: US46529,US46500 - New combination for Jurisdiction logic change for Adjudication records-LCD-Bring the Manaul Code from CMS second Week- Scenario 1
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
    And RA captures OpenDated DOSTo records from Target for "<LCD_OR_ARTICLE>"  for version "1"
    And DOSFrom should be set according to min DosFrom logic in the target for "<New ICD Code>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "1"  for the scenario "<ValidationScenario>"
    And DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<New ICD Code>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "1"
    Then Logout of the Application
    And RA Closes the Application
    ##Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    And DOSFrom should be set according to min DosFrom logic in the target for "<New ICD Code>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "2"  for the scenario "<ValidationScenario>"
    And DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<New ICD Code>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "2"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType       | DOSToOpenDate | NewICDCodesCount1 | ValidationScenario |
      # | iht_ittest05 |   LCD                    |    Week2 |                     |    80141-80150       | C69.31          |1                 |  Support |Y37.001A     |                         |   Y37.001D     |   Support-ValidCodes  |   12/31/9999     | 1                               |  NewICDCode2ndWeek|
      | iht_ittest05 | Article        | Week2  |              | 94141-94150      | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 | NewICDCode2ndWeek  |

  @RegressionNov22New
  Scenario Outline: US46529,US46500 - New combination for Jurisdiction logic change for Adjudication records-LCD-Bring the New Jury from CMS second Week- Scenario 1
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
    Then Logout of the Application
    And RA Closes the Application
    ##Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    And Records should be updated for "<LCD_OR_ARTICLE>" in TargetTable for LCDArticle Version "2"  and according to MultipleJuries  for the "<DBValidationScenario>"
    And DOSFrom should be set according to min DosFrom logic in the target for "<New ICD Code>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "2"  for the scenario "<ValidationScenario>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType       | DOSToOpenDate | NewICDCodesCount1 | DBValidationScenario        | ValidationScenario |
      | iht_ittest05 | LCD            | Week2  |              |             4790 | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 | AddNewJuryW2CMS-Y37.001A -5 | NewJury2ndWeek     |

  # | iht_ittest05 |   Article                |    Week2 |                     |     91104                |C69.31             |1              |  Support |Y37.001A        |                         | Y37.001D      | Support-ValidCodes		|   12/31/9999     |  1                               | AddNewJuryW2CMS-Y37.001A -5 |NewJury2ndWeek   |
  ## Duplicate of above and cane be removed
  @RegressionNov21New
  Scenario Outline: US46529,US46500 - New combination for Jurisdiction logic change for Adjudication records-LCD-Bring the Manaul Code from CMS second Week- Scenario 1
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
    And RA captures OpenDated DOSTo records from Target for "<LCD_OR_ARTICLE>"  for version "1"
    And DOSFrom should be set according to min DosFrom logic in the target for "<New ICD Code>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "1"  for the scenario "<ValidationScenario>"
    And DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<New ICD Code>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "1"
    Then Logout of the Application
    And RA Closes the Application
    ##Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    And DOSFrom should be set according to min DosFrom logic in the target for "<New ICD Code>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "2"  for the scenario "<ValidationScenario>"
    And DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<New ICD Code>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "2"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType       | DOSToOpenDate | NewICDCodesCount1 | ValidationScenario |
      | iht_ittest05 | LCD            | Week2  |              |            45203 | C69.31        |         1 | Support  | Y37.001A     | Y37.001D      |             | Support-ValidCodes | 12/31/9999    |                 1 | NewJury2ndWeek     |

  # | iht_ittest05 |   Article                   |    Week2 |                        |     91104              | C69.31           |1                  |  Support|Y37.001A       |   Y37.001D      |  												|    Support-ValidCodes|  12/31/9999        |  1                              |  NewJury2ndWeek|
  ###  WORKING
  @RegressionJan7
  Scenario Outline: US45068, US45290 - Add New -Ability to present 1 record in delta for a combination with Jurisdiction logic- LCD
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA claims "<LCD_OR_ARTICLE>" code from group Tasks
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
    And Validate DOSTo value of "<New ICD Code>"  is same as "<Base ICD Code>"  DosFrom value for  "<LCD_OR_ARTICLE>"
    And Only one Record Shoud be displayed for Review for different Juries in the "RAReviewWorkQueue" Screen for the "<UIValidationScenario>"
    And Records should be updated for "<LCD_OR_ARTICLE>" in DeltaTable for LCDArticle Version "1"  and according to MultipleJuries  for the "<DBValidationScenario>"
    Then Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType       | DOSToOpenDate | NewICDCodesCount1 | UIValidationScenario   | DBValidationScenario   |
      | iht_ittest05 | LCD            | Week1  |              |              802 | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 | AddNewICDCode-Y37.001A | AddNewICDCode-Y37.001A |
      | iht_ittest05 | Article        | Week2  |              |              942 | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 | AddNewICDCode-Y37.001A | AddNewICDCode-Y37.001A |

  ### Scenario1- Working
  @RegressionNov22DeleteHCPC
  Scenario Outline: US45068- Delete HCPC code ,US46492,US45292, US45290 - Ability to present 1 record in delta for a combination with Jurisdiction logic- LCD
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
    ## And Validate DOSTo value of "<New ICD Code>"  is same as "<Base ICD Code>"  DosFrom value for  "<LCD_OR_ARTICLE>"
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And CodeCombinations should  be created in TargetTable for  the "<LCD_OR_ARTICLE>"  and "<Category>"  for "ICDCode1"  and  for Version "1" for "AssociatedCodes"
    And Logout of the Application
    And RA Closes the Application
    ##Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    And Only one Record Shoud be displayed for Review for different Juries in the "RAReviewWorkQueue" Screen for the "<UIValidationScenario>"
    And Records should be updated for "<LCD_OR_ARTICLE>" in DeltaTable for LCDArticle Version "2"  and according to MultipleJuries  for the "<DBValidationScenario>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | DOSToOpenDate | NewICDCodesCount1 | UIValidationScenario   | DBValidationScenario                  |
      # | iht_ittest05 |   LCD                    |    Week2 |                      |    80166-80180                 | C69.31          |1               |  Support |Y37.001A        |                         |   12/31/9999     | 1                  |DeleteHCPCCodeW2-0291T |DeleteHCPCCodeW2-Y37.001A-G9143-0291T |
      # | iht_ittest05 |   LCD                    |    Week2 |                      |    431                               | C69.31           |1               |  Support |Y37.001A      |                         |   12/31/9999     | 1                       |AddJuryW2                             |AddJuryW2     |
      | iht_ittest05 | Article        | Week2  |              | 94261-94275      | C69.31        |         1 | Support  | Y37.001A     |               | 12/31/9999    |                 1 | DeleteHCPCCodeW2-0291T | DeleteHCPCCodeW2-Y37.001A-G9143-0291T |

  ###Working
  @RegressionNov22
  Scenario Outline: US45068,US46492,US45292 - ICDCodeDeleted in Week2 -Ability to present 1 record in delta for a combination with Jurisdiction logic- LCD
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
    And Logout of the Application
    And RA Closes the Application
    ##Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    And Only one Record Shoud be displayed for Review for different Juries in the "RAReviewWorkQueue" Screen for the "<UIValidationScenario>"
    And Records should be updated for "<LCD_OR_ARTICLE>" in DeltaTable for LCDArticle Version "2"  and according to MultipleJuries  for the "<DBValidationScenario>"
    And DOSTo should be Datebanded in the target  for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "2"  and for "<DOSToDtBndScenario>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType       | DOSToOpenDate | NewICDCodesCount1 | UIValidationScenario  | DBValidationScenario  | DOSToDtBndScenario    |
      # | iht_ittest05 |   LCD                    |    Week2 |                      |    80181-80190                  | C69.31         |1                  |  Support |Y37.001A      |                         |    Y37.001D    |   Support-ValidCodes   |   12/31/9999     | 1                              |DeleteICDCodeW2-C18.2  |DeleteICDCodeW2-C18.2   |  DeleteICDCodeW2-C18.1|
      | iht_ittest05 | Article        | Week2  |              | 94276-94286      | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 | DeleteICDCodeW2-C18.2 | DeleteICDCodeW2-C18.2 | DeleteICDCodeW2-C18.1 |

  ###  WORKING
  @RegressionNov22
  Scenario Outline: US45068 - LCD/Article Retired -Ability to present 1 record in delta for a combination with Jurisdiction logic- LCD
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount1>","Support-ValidCodes" for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And Close the Alert Popup
    And RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>"
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
    ##Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    And Only one Record Shoud be displayed for Review for different Juries in the "RAReviewWorkQueue" Screen for the "<UIValidationScenario>"
    And Records should be updated for "<LCD_OR_ARTICLE>" in DeltaTable for LCDArticle Version "2"  and according to MultipleJuries  for the "<DBValidationScenario>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType      | DOSToOpenDate | NewICDCodesCount1 | UIValidationScenario | DBValidationScenario |
      # | iht_ittest05 |   LCD                    |    Week2 |                      |    80191-80195     | C69.31           |1               |  Support |Y37.001A      |                     |  Y37.001D    |   Support-ValidCodes   |   12/31/9999     | 1                                |RetiredW2-C69.31          |RetiredW2-C69.31     |
      | iht_ittest05 | Article        | Week2  |              | 94287-94294      | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCode | 12/31/9999    |                 1 | RetiredW2-C69.31     | RetiredW2-C69.31     |

  @RegressionNov22
  Scenario Outline: US46796 - Impact on Adhoc review screen
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
    ## Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    And RA clicks on "RequestCodeCombinationReview"
    And RA updates decisions for some records in the TargetTable Screen for "<LCD_OR_ARTICLE>"
    Then Logout of the Application
    And RA Closes the Application
    ##Navigate to Admin Screen
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    And Screen will be opened in a new tab with title CPTICD Links- Admin
   And RA filters by ID for "<LCD_OR_ARTICLE>" with status "<Status>"
    When RA clicks on "AdhocReviewTab"
    And The above updated decisions should be displayed in the screen for "<LCD_OR_ARTICLE>"
    Then Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType       | DOSToOpenDate | NewICDCodesCount1 | UIValidationScenario | DBValidationScenario | Dates      |Status|
     #| iht_ittest05 |   LCD          |  Week2 |              |     80100-80140  | C69.31        |1          |  Support |Y37.001A      |               |  Y37.001D   | Support-ValidCodes |   12/31/9999  | 1                 |SubAddW3-Y37.001A     |SubAddW3-Y37.001A     |12/10/2018  |2|
      | iht_ittest05 | Article        | Week2  |              | 94100-94140      | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 | SubAddW3-Y37.001A    | SubAddW3-Y37.001A    | 12/10/2018 |2|

  #############  Multiple Weeks Scenarios (3 Weeks )  ####################
  @RegressionNov21New
  Scenario Outline: US45068 - SubsequentAdd -  Ability to present 1 record in delta for a combination with Jurisdiction logic- LCD
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
    And Logout of the Application
    And RA Closes the Application
    ##Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    When RA clicks on the "Add/Edit manual code combination" button
    When RA clicks on "Delete Combination" Task Tab
    When RA enters date as "<Dates>" in delete combination tab
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "The selected combination(s) are successfully date banded."
    And Close the Alert Popup
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
    ##Third Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    And Only one Record Shoud be displayed for Review for different Juries in the "RAReviewWorkQueue" Screen for the "<UIValidationScenario>"
    And Records should be updated for "<LCD_OR_ARTICLE>" in DeltaTable for LCDArticle Version "3"  and according to MultipleJuries  for the "<DBValidationScenario>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType       | DOSToOpenDate | NewICDCodesCount1 | UIValidationScenario | DBValidationScenario | Dates      |
      | iht_ittest05 | LCD            | Week3  |              |            43989 | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 | SubAddW3-Y37.001A    | SubAddW3-Y37.001A    | 12/10/2018 |

  # | iht_ittest05 |   Article                |    Week3 |                      |     91104                | C69.31           |1               |  Support |Y37.001A      |                        |  Y37.001D     | 																			|   12/31/9999    |  1                                |                                  |                                  | 12/10/2018 |
  @RegressionNov21New
  Scenario Outline: US45068 - SubsequentAdd -  Ability to present 1 record in delta for a combination with Jurisdiction logic- LCD - HCPC Code Subsequent Add
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
    And Logout of the Application
    And RA Closes the Application
    ##Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
    ##Third Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    And Only one Record Shoud be displayed for Review for different Juries in the "RAReviewWorkQueue" Screen for the "<UIValidationScenario>"
    And Records should be updated for "<LCD_OR_ARTICLE>" in DeltaTable for LCDArticle Version "3"  and according to MultipleJuries  for the "<DBValidationScenario>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType       | DOSToOpenDate | NewICDCodesCount1 | UIValidationScenario   | DBValidationScenario            | Dates      |
      | iht_ittest05 | LCD            | Week3  |              |              452 | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 | SubAddHCPCCodeW3-0291T | SubAddHCPCCodeW3-Y37.001A-0291T | 12/10/2018 |

  # | iht_ittest05 |   Article                |    Week3 |                      |     91104                | C69.31           |1               |  Support |Y37.001A      |                        |  Y37.001D     | 																			|   12/31/9999    |  1                                |                                  |                                  | 12/10/2018 |
  @RegressionNov21New
  Scenario Outline: US49544 - Ability to handle associate code - Subsequent add- Start review- LCD (Scenario 3)
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
    And RA captures OpenDated DOSTo records from Target for "<LCD_OR_ARTICLE>"  for version "1"
    And Logout of the Application
    And RA Closes the Application
    ### Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    When RA clicks on the "Add/Edit manual code combination" button
    When RA clicks on "Delete Combination" Task Tab
    When RA enters date as "<Dates>" in delete combination tab
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "The selected combination(s) are successfully date banded."
    And Close the Alert Popup
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
    ###Third Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    And Records should be updated for "<LCD_OR_ARTICLE>" in TargetTable for LCDArticle Version "3"  and according to MultipleJuries  for the "<DBValidationScenario>"
    And DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<New ICD Code>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "3"
    And Manual indicator value should be set to "0" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "3"
    And Logout of the Application
    And RA Closes the Application
    # Login again in to access the TargetData screen
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    And Screen will be opened in a new tab with title CPTICD Links- Admin
    And User clicks on the "TargetData" tab
    Then User should be able to see all the adjudication records on the screen for  the "<LCD_OR_ARTICLE>"
    And CodeCombinations for  the "<LCD_OR_ARTICLE>"  and for "ICDCode1" and for "<Category>"  for LCDArticleVersion "3" should be displayed in the TargetData Screen
    Then Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | NewICDCode2 | CategoryType       | DOSToOpenDate | NewICDCodesCount1 | DBValidationScenario        | Dates      |
      | iht_ittest05 | LCD            | Week3  |              |             4513 | C69.31        |         1 | Support  | Y37.001A     |               | Y37.001D    | Support-ValidCodes | 12/31/9999    |                 1 | AddNewICDCodeW3CMS-Y37.001A | 12/10/2018 |

  # | iht_ittest05 |   Article                |    Week3 |                      |     91104                | C69.31           |1               |  Support |Y37.001A      |                         |  Y37.001D     | 																			|   12/31/9999    |  1                               |AddNewICDCodeW3CMS-Y37.001A|12/10/2018|
  
  
  
  @RegressionFeb19th
  Scenario Outline: TC16578 - Ability to add manually maintained combinations for each jurisdiction in delta when new HCPC code is added by CMS to the LCD/Article
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
    Then Logout of the Application
    And RA Closes the Application
    #Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    When RA clicks on "<TabName>" Task Tab
    Then verify newly added "<New HCPC code>" is added with "<New ICD Code>" in UI
    And Records should be updated for "<LCD_OR_ARTICLE>" in DeltaTable for LCDArticle Version "2"  and according to MultipleJuries  for the "<DBValidationScenario>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | New HCPC code | TabName |DBValidationScenario               | 
      #| iht_ittest05 | LCD            | Week2  |              |      82100-82200 | C69.31        |         1 | Support  | Y37.001A     |               | 0001T         | Support |AllNewHCPCCode-Y37.001A-0001T-5,A,K|                    
      | iht_ittest05 | Article         | Week2  |              |      91431-91440 | C69.31        |         1 | Support  | Y37.001A     |               | 0001T         | Support |AllNewHCPCCode-Y37.001A-0001T-5,D,K|       
      
      @RegressionMar4th
  Scenario Outline: TC16581 - Ability to handle manual combinations when HCPC is added with New Jurisdiction for LCD/Article with Different dates
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
    When RA selects "manually", ICD group as "1" and add new ICD code "<New ICD Code>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And Close the Alert Popup
    And RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>"
    Then RA takes decisions on CodeCombinations and Completes RA Review
    Then Logout of the Application
    And RA Closes the Application
    #Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    When RA clicks on "<TabName>" Task Tab
    Then verify newly added "<New HCPC code>" is added with "<New ICD Code>" in UI
    And Records should be updated for "<LCD_OR_ARTICLE>" in DeltaTable for LCDArticle Version "2"  and according to MultipleJuries  for the "<DBValidationScenario>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category   | New ICD Code | New ICD Code1|New HCPC code | TabName |DBValidationScenario | 
      | iht_ittest05 | LCD            | Week2  |              |      81114-81114 | C18.1         |  1        | Support    | A01.1     |              |   0291T      | Support |AllNewHCPCCodeAndNewJury-A01.1-0291T-K-12/31/9999 |                    
     # | iht_ittest05 | Article        | Week2  |              |      92007-92007 | C18.1         |  1        | Support    | A01.1     |              |   0291T      | Support |AllNewHCPCCodeAndNewJury-A01.1-0291T-K-12/31/9999 |       
      
     
     
    Scenario Outline: Ability to auto trigger the LCD/Article to MDM movement of the combinations for support and does not support
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
    Then Logout of the Application
    And RA Closes the Application
    #Second Week
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    #When RA clicks on "<TabName>" Task Tab
    #Then verify newly added "<New HCPC code>" is added with "<New ICD Code>" in UI
    #And Records should be updated for "<LCD_OR_ARTICLE>" in DeltaTable for LCDArticle Version "2"  and according to MultipleJuries  for the "<DBValidationScenario>"
    #And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | New HCPC code | TabName |DBValidationScenario               | 
      #| iht_ittest05 | LCD            | Week2  |              |      82100-82200 | C69.31        |         1 | Support  | Y37.001A     |               | 0001T         | Support |AllNewHCPCCode-Y37.001A-0001T-5,A,K|                    
      | iht_ittest05 | Article         | Week2  |              |      91431-91440 | C69.31        |         1 | Support  | Y37.001A     |               | 0001T         | Support |AllNewHCPCCode-Y37.001A-0001T-5,D,K|                               