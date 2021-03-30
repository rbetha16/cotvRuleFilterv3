@Dec19
Feature: LCD to MDM Movement

  @LCDtoMDMCheck1 
  Scenario Outline: LCD to MDM -RAReviewWorkQueuePage-SupportTab-> Accept & Reject decisions,DoesNotSupportTab->All Reject Decisions- TC9821 -TO ADD IN THE REG SHEET
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
    When User selects "<CodeComboCount>" codecombinations in the "<Support_OR_Doesnot_Support>"  for "Accept" decision in "RAReviewPage" page
    When RA clicks on "Accept"
    Then the codecombination should be set as "Accept" in ReviewDecision column
    When RA clicks on "ReviewDecisionDropdown"
    When RA clicks on "BlankReviewDecision"
    When RA clicks on "ApplyFilters"
    When User selects "<CodeComboCount>" codecombinations in the "<Support_OR_Doesnot_Support>"  for "Reject" decision in "RAReviewPage" page
    When RA clicks on "Reject"
    And RA selects a reason for Rejection  as "Non-configurable-Frequency"
    And RA clicks on "ClearAllFilters"
    When RA clicks on "ReviewDecisionDropdown"
    When RA clicks on "BlankReviewDecision"
    When RA clicks on "ApplyFilters"
    When User selects all the Codecombs in the "<Support_OR_Doesnot_Support>" for "Accept" decision
    When RA clicks on "Accept"
    And RA clicks on "ClearAllFilters"
    And RA captues the Decisions count
    When RA clicks on "Does" Task Tab
    When User selects all the Codecombs in the "DoesNotSupportTab" for "Reject" decision
    When RA clicks on "Reject"
    And RA selects a reason for Rejection  as "Non-configurable-Frequency"
    And Capture decisions taken from DeltaTable for  "<LCD_OR_ARTICLE>"
    When RA clicks on "CompleteRAReview"
    Then All the decisions should be copied to the Target for  "<LCD_OR_ARTICLE>"
    And The "Accept"  decisions should be moved to MDM for "<LCD_OR_ARTICLE>"
    And The "Reject"  decisions should not be moved to MDM for  "<LCD_OR_ARTICLE>"
    Then Logout of the Application

    #Examples: 
    | User ID      | LCD_OR_ARTICLE | Support_OR_Doesnot_Support | TabName | CodeComboCount |
    |iht_ittest05 | LCD                      | SupportTab                                | Support    |              2               |
  | iht_ittest05 | Article                  | SupportTab                                | Support    |               2               |
  
 
 
  @LCDtoMDMCheck2
  Scenario Outline: LCD to MDM -RAReviewWorkQueuePage-SupportTab->All Reject Decisions,DoesNotSupportTab->Accept & Reject decisions- TC9821 -TO ADD IN THE REG SHEET
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
    When User selects "<CodeComboCount>" codecombinations in the "<Support_OR_Doesnot_Support>"  for "Accept" decision in "RAReviewPage" page
    When RA clicks on "Accept"
    Then the codecombination should be set as "Accept" in ReviewDecision column
    When RA clicks on "ReviewDecisionDropdown"
    When RA clicks on "BlankReviewDecision"
    When RA clicks on "ApplyFilters"
    When User selects "<CodeComboCount>" codecombinations in the "<Support_OR_Doesnot_Support>"  for "Reject" decision in "RAReviewPage" page
    When RA clicks on "Reject"
    And RA selects a reason for Rejection  as "Non-configurable-Frequency"
    And RA clicks on "ClearAllFilters"
    When RA clicks on "ReviewDecisionDropdown"
    When RA clicks on "BlankReviewDecision"
    When RA clicks on "ApplyFilters"
    When User selects all the Codecombs in the "<Support_OR_Doesnot_Support>" for "Accept" decision
    When RA clicks on "Accept"
    And RA clicks on "ClearAllFilters"
    And RA captues the Decisions count	
    When RA clicks on "Support" Task Tab
    When User selects all the Codecombs in the "SupportTab" for "Reject" decision
    When RA clicks on "Reject"
    And RA selects a reason for Rejection  as "Non-configurable-Frequency"
    When RA clicks on "CompleteRAReview"  
    And The "Accept"  decisions should be moved to MDM for "<LCD_OR_ARTICLE>"
    And The "Reject"  decisions should not be moved to MDM for  "<LCD_OR_ARTICLE>"
    Then Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | Support_OR_Doesnot_Support | TabName | CodeComboCount |  
      | iht_ittest05 | LCD                      | DoesNotSupportTab                  | Does        |               2               |
     # | iht_ittest05 | Article                  | DoesNotSupportTab                  | Does        |               2               |
 
 
  @LCDtoMDMChngChk
  Scenario Outline:  LCD to MDM - RequestLCDArticleReviewPage-SupportTab - AcceptReject decisions  - TESLA-20436 (TC17950) 
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
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And click on "Request LCD/Article for Review" and enter "<LCD_OR_ARTICLE>" claimed
    When User selects "<CodeComboCount>" codecombinations in the "<Support_OR_Doesnot_Support>"  for "Reject" decision in "RequestLCDArticleReview" page
    When RA clicks on "Reject"
    And RA selects a reason for Rejection  as "Non-configurable-Frequency"  in "RequestLCDArticleReview" page 
    And The "Reject"  decisions should not be moved to MDM for  "<LCD_OR_ARTICLE>"
    When User selects "<CodeComboCount>" codecombinations in the "<Support_OR_Doesnot_Support>"  for "Accept" decision in "RequestLCDArticleReview" page
    When RA clicks on "Accept"
    And  RA enters the ReasonforUpdating decision for the "Accept" decision 
    And The "Accept"  decisions should be moved to MDM for "<LCD_OR_ARTICLE>"    
    Then Logout of the Application
    
      Examples: 
      | User ID      | LCD_OR_ARTICLE | Support_OR_Doesnot_Support | TabName | CodeComboCount |  
      | iht_ittest05 | LCD                      | SupportTab                                | Support    |               2               |
     # | iht_ittest05 | Article                   | SupportTab                               | Support    |               2               |
 
    
    @LCDtoMDMChngChk
  Scenario Outline:  LCD to MDM - RequestLCDArticleReviewPage-DoesNotSupportTab - AcceptReject decisions - TESLA-20436 (TC17950) 
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
    Then RA takes decisions on CodeCombinations and Completes RA Review  
    And click on "Request LCD/Article for Review" and enter "<LCD_OR_ARTICLE>" claimed
    When RA clicks on "Does" Task Tab   
    And  RA filters "ICDCode" column in with Value "C90"  for  "<Support_OR_Doesnot_Support>" tab in the "RequestLCDArticleReview" page
    When RA clicks on "ApplyFilters" 
    When User selects "<CodeComboCount>" codecombinations in the "<Support_OR_Doesnot_Support>"  for "Accept" decision in "RequestLCDArticleReview" page
    When RA clicks on "Accept"
    And  RA enters the ReasonforUpdating decision for the "Accept" decision 
    And The "Accept"  decisions should be moved to MDM for "<LCD_OR_ARTICLE>"   
    When User selects "<CodeComboCount>" codecombinations in the "<Support_OR_Doesnot_Support>"  for "Reject" decision in "RequestLCDArticleReview" page
    When RA clicks on "Reject"
    And RA selects a reason for Rejection  as "Non-configurable-Frequency"  in "RequestLCDArticleReview" page  
    And The "Reject"  decisions should not be moved to MDM for  "<LCD_OR_ARTICLE>"
    Then Logout of the Application
    
      Examples: 
      | User ID        | LCD_OR_ARTICLE | Support_OR_Doesnot_Support | TabName | CodeComboCount |  
      | iht_ittest05 | LCD                        | DoesNotSupportTab                    | Does        |               2               |
      #| iht_ittest05 | Article                   | DoesNotSupportTab                    | Does        |               2               |
 
 
   
    @LCDtoMDMChngChktd
  Scenario Outline: To be added to Regr Sheet, LCD to MDM - RequestLCDArticleReviewPage-Add Associated Codes  & TC17939 (TESLA-20425) -Display Add/Edit Manually created code combo 
                               #TESLA-20436(TC17950)-Ability to delete manual associated code combination for LCD/Article in target
                               #TESLA-20437(TC17951) -  Ability to delete manual associated code combination for LCD in Target_MDM movement      
                               #TESLA-20441 (TC17956) -  Ability to validate manual associated details for LCD/Article                 
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
    Then RA takes decisions on CodeCombinations and Completes RA Review  
    And click on "Request LCD/Article for Review" and enter "<LCD_OR_ARTICLE>" claimed
    
   ### Scenario 1  - Check DateBanding in MDM   
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Add Combination" Task Tab
    When RA Enters the "<Base ICD Code>","<ICD Group>","<Category>","<New ICD Code>","<New ICD Code1>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
     And RA captures the HCPCCodes for "<Category_Type>" and "<LCD_OR_ARTICLE>"  for "TargetRecords"
    And Close the Alert Popup        
     When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Delete Combination" Task Tab
    When RA enters date as "<Date>" in delete combination tab
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "The selected combination(s) are successfully date banded."
    And Close the Alert Popup
    Then The Deleted combinations should be datebanded to "<Date>"  for  "<New ICD Code>"   in MDM  for  "<Support_OR_Doesnot_Support>" and for "<LCD_OR_ARTICLE>"   
    And  Manually added codes should be successfully deleted from Manualtable "<MANUAL_CODE_COMB_TABLE>" for "<Category_Type>" and for the "<LCD_OR_ARTICLE>"  for "ICDCode1"    
    
    ## Scenario 2 - - Check AssociateCodes movement to MDM based on Review Decisions    
   When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Add Combination" Task Tab				    
    When RA Enters the "<Base ICD Code>","<ICD Group>","<Category>","<New ICD Code>","<New ICD Code1>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And Close the Alert Popup
   And RA captures the HCPCCodes for "<Category_Type>" and "<LCD_OR_ARTICLE>"  for "TargetRecords"          
    And Manual Associated code should be added to the base code for  "<LCD_OR_ARTICLE>"   
    And All the decisions should be copied to the AssociatedCode in the Target for "<New ICD Code>"  and for  "<LCD_OR_ARTICLE>"
    And Validate mapping between base and manually created codes in "<MANUAL_CODE_COMB_TABLE>" for "<Category_Type>" and "<LCD_OR_ARTICLE>" 
    And  RA filters "ICDCode" column in with Value "<New ICD Code>"  for  "<Support_OR_Doesnot_Support>" tab in the "RequestLCDArticleReview" page 
    When RA clicks on "ApplyFilters" 
    And  RA captures Review  decisions  for  "<Support_OR_Doesnot_Support>" tab in the "RequestLCDArticleReview" page     
    And The "Accept"  decisions should be moved to MDM for "<LCD_OR_ARTICLE>"   
     And The "Reject"  decisions should not be moved to MDM for  "<LCD_OR_ARTICLE>"
    Then Logout of the Application
    
      Examples: 
      | User ID        | LCD_OR_ARTICLE | Support_OR_Doesnot_Support | TabName |   NewICDCodesCount | Category |Date          |Category_Type|Base ICD Code|ICD Group|Category   |New ICD Code|New ICD Code1|MANUAL_CODE_COMB_TABLE|
      | iht_ittest05 | LCD                        | SupportTab                               | Support     |                 1                  |Support    |12/10/2018|   Support         |     C69.31        |   1          |  Support  | Y37.001A       |                          |LCD_MANUAL_CODE_COMB |
   # | iht_ittest05 | Article                    | SupportTab                               | Support     |               1                    | Support    | 12/10/2018|   Support        |    C69.31        |    1         |   Support  |  Y37.001A     |                          | ART_MANUAL_CODE_COMB|
    
 
 
  
  @LCDtoMDMCheck3
  Scenario Outline:  LCD to MDM - Overlapping DOS From & DOS TO
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
  Then RA takes decisions on CodeCombinations and Completes RA Review 
  Then DOSFrom and DOSTO should be displayed in MDM according to min Dosfrom logic for "<Support_OR_Doesnot_Support>" for "<LCD_OR_ARTICLE>"   
  And Logout of the Application  
  And RA Closes the Application
  
  
    Examples: 
      | User ID        | LCD_OR_ARTICLE | Support_OR_Doesnot_Support | TabName | CodeComboCount |  NewICDCodesCount | Category45              |FilterVal     |Date          |Category_Type|Base ICD Code|ICD Group|Category|New ICD Code|New ICD Code1|NewICDCode2|
      | iht_ittest05 | LCD                        | SupportTab                               | Support     |               2             |    1                              |Support-ValidCodes  | Y37.001A   |12/10/2018|   Support         |     C69.31        |   1              |  Support  | Y37.001A       |                         |                       |   
   # | iht_ittest05 | Article                    | SupportTab                               | Support     |               2              |  1                                |                                |                    | 12/10/2018|   Support        |                        |                   |              |                         |                         |                       |  
    
   
    
    
    
  @RegressionDI
  Scenario Outline: TESLA -20430 - Validate Show Data Integrity Record on the Target Screen (ACID: TC17944)
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    And Screen will be opened in a new tab with title CPTICD Links- Admin
    And User clicks on the "TargetData" tab
    Then Filter the "ID"  column with "<LCD_OR_ARTICLE ID>"
     When RA clicks on "ShowDataIntegrityRecord"
    Then  A popup "Data Integrity Records" should be displayed   
    Then Logout of the Application

    Examples: 
      | User ID        |LCD_OR_ARTICLE ID|
      | iht_ittest05 |      LCD          |
    	| iht_ittest05 |      Article      |
 
 
   
   @LCDtoMDMChngChkReg12
  Scenario Outline:  TC17953 - Delete Combination- Alert Message Check - Test name wrong in JIRA 
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
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And click on "Request LCD/Article for Review" and enter "<LCD_OR_ARTICLE>" claimed   
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Add Combination" Task Tab
    When RA Enters the "<Base ICD Code>","<ICD Group>","<Category>","<New ICD Code>","<New ICD Code1>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And RA captures the HCPCCodes for "<Category_Type>" and "<LCD_OR_ARTICLE>"  for "TargetRecords"
    And Close the Alert Popup        
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
     When RA clicks on "Delete Combination" Task Tab
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "'DOS To' is mandatory to manually date band the 'Associated ICD code' combinations. Please select appropriate date(s) for selected associated ICD code(s) to successfully date band the combinations."
    And Logout of the Application
 
       Examples: 
      | User ID        | LCD_OR_ARTICLE | Support_OR_Doesnot_Support | TabName |   Category_Type|Base ICD Code|ICD Group|Category|New ICD Code|New ICD Code1|
      | iht_ittest05 | LCD                        | SupportTab                               | Support     |    Support          |     C69.31       |   1             |  Support  | Y37.001A     |                         |    
   # | iht_ittest05 | Article                    | SupportTab                               | Support     |    Support          |     C69.31       |   1             |   Support |Y37.001A      |                         |     
 
 @RegressionFeb28th
 Scenario Outline: TESLA-20437(TC17952)-Ability to delete manual associated code combination for LCD in target_mdm movement             
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
    And click on "Request LCD/Article for Review" and enter "<LCD_OR_ARTICLE>" claimed  
  # Scenario 1  - Check DateBanding in MDM   
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Add Combination" Task Tab
    When RA Enters the "<Base ICD Code>","<ICD Group>","<Category>","<New ICD Code>","<New ICD Code1>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
     And RA captures the HCPCCodes for "<Category_Type>" and "<LCD_OR_ARTICLE>"  for "TargetRecords"
    And Close the Alert Popup        
     When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Delete Combination" Task Tab
    When RA enters date as "<Date>" in delete combination tab
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "The selected combination(s) are successfully date banded."
    And Close the Alert Popup
    Then The Deleted combinations should be datebanded to "<Date>"  for  "<New ICD Code>"   in the table "<TableName>" for  "<Support_OR_Doesnot_Support>" and for "<LCD_OR_ARTICLE>" with version "1"  
    And  Manually added codes should be successfully deleted from Manualtable "<MANUAL_CODE_COMB_TABLE>" for "<Category_Type>" and for the "<LCD_OR_ARTICLE>"  for "ICDCode1"   
    
      Examples: 
      | User ID        | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange| Support_OR_Doesnot_Support | TabName |NewICDCodesCount | Category |Date      |Category_Type|Base ICD Code|ICD Group|Category   |New ICD Code|New ICD Code1|MANUAL_CODE_COMB_TABLE|TableName |
      | iht_ittest05   | LCD            | Week1  |              | 801				      | SupportTab                 | Support |    1            |Support   |12/10/2018|   Support   |     C69.31  |   1     |  Support  | Y37.001A   |             |LCD_MANUAL_CODE_COMB  |Target-5,A,K;MDM|
      | iht_ittest05   | Article        | Week1  |              | 900				      |SupportTab                  | Support |    1            | Support  |12/10/2018|   Support   |     C69.31  |   1     |  Support  |  Y37.001A  |             |ART_MANUAL_CODE_COMB  |Target-5,D,K;MDM|
     
    @Regression
    Scenario Outline: TESLA -20430 - Ability to view all data integrity records on pop up screen_no data integrity(ACID: TC17926)
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    And Screen will be opened in a new tab with title CPTICD Links- Admin
    And User clicks on the "TargetData" tab
    Then Filter the "ID"  column with "<LCD_OR_ARTICLE ID>"
    When RA clicks on "ShowDataIntegrityRecord"
    Then  A popup "Data Integrity Records" should be displayed 
    And Validate Sorting as "Sort Ascending,Sort Descending" for column "<ColumnHeaders>" in DataIntegrity grid 
    Then Logout of the Application

    Examples: 
      | User ID        |LCD_OR_ARTICLE ID|ColumnHeaders |
      | iht_ittest05   |      LCD        |LCD/Article ID,CPT Code,CPT Group,ICD Code,ICD Group,Jurisdiction,Category,DOS From,Integrity DOS From,DOS To|
      | iht_ittest05   |      Article    |LCD/Article ID,CPT Code,CPT Group,ICD Code,ICD Group,Jurisdiction,Category,DOS From,Integrity DOS From,DOS To|
    