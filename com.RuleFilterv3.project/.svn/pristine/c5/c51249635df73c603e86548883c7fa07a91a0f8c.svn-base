 #Author: Udayakiran Lanka
 
@RegressionDec28
Feature: F6407-Establish Proposal Review Workflow - June
      
 @RegressionJan7admin
 Scenario Outline: US27547 - Admin-Tool Tip for CPT ICD Description on Admin CodeCombinationScreen(TC9016)
 Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
 And   User should be able click on CPTICDLink-Admin under Adminstration Section
 And   Screen will be opened in a new tab with title CPTICD Links- Admin
 When  AdminRA clicks on one of the review taskID 
 And   AdminRA selects the "LongView" radio button
 When  AdminRA mouseovers on the CPTICD Description to display the Tooltip description
 When  "CPTDescription" of different length exists in the Grid to check tooltip Mouseover for "<TabName>"
 When  "ICDDescription" of different length exists in the Grid to check tooltip Mouseover for "<TabName>"         
 Then  Logout of the Application
    
     Examples: 
      | User ID      |TabName       |
      | iht_ittest05 |Support       |
    # | iht_ittest05 |DoesNotSupport|   
      
      
      
 @RegressionJan7
 Scenario Outline: US25289-Alert User on changing the decision    
 Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
 When RA clicks on CPT ICD Link in My Tasks
 And  RA clicks on "Group" Task Tab
 And  RA claims "<LCD_OR_ARTICLE>" code from group Tasks
 When RA clicks on "Individual" Task Tab
 When RA clicks on claimed "<LCD_OR_ARTICLE>"
 Then RA Review Work Queue screen should be displayed
 And  Review status should be dispalyed as "Not Started"
 When RA clicks on "Start Review"
 Then Review status should be dispalyed as "Started" 
 When RA clicks on "<TabName2>" Task Tab
 And  Apply Filter on CPTHCPCSGroup in the "<TabName>"
 When User selects Codecombinations in the "<TabName>"  
 When RA clicks on "Accept"
 And  RA clicks on "ClearAllFilters"
 And  RA applies filter on Review decision "Blank" value
 And  Apply Filter on CPTHCPCSGroup in the "<TabName>"
 And  RA clicks on "ApplyFilters"
 When User selects Codecombinations in the "<TabName>"  
 When RA clicks on "Reject"
 And  RA clicks on "ClearAllFilters"
 And  RA applies filter on Review decision "Accept" value
 And  RA clicks on "ApplyFilters"
 When User selects few records with Review Decision "Accept" 
 When User selects Codecombinations in the "<TabName>" 
 And  RA clicks on "Reject" 
 Then An alert message should be displayed
 When User clicks on "No" button on the Alert popup
 Then Alert message should be closed and all the checkmarks for the selected records should be retained
 And  The Decision for the selected records should not be changed
 And  RA clicks on "Reject" 
 When User clicks on "Yes" button on the Alert popup
 Then The Review Decision for all the selected records should be changed to Reject and the corresponding Remarks should be cleared
 And  User should be able to apply the Remarks from the dropdown list for the selected records 
  When RA clicks on "ClearAllFilters"
   When RA clicks on "ReviewDecisionDropdown"
  When RA clicks on "BlankReviewDecision"
  When RA clicks on "ApplyFilters" 
    When User selects Codecombinations in the "<TabName>" 
 When RA clicks on "Accept"
    When RA clicks on "ClearAllFilters"
   When RA clicks on "ReviewDecisionDropdown"
  When RA clicks on "BlankReviewDecision"
  When RA clicks on "AcceptReviewDecision"
  When RA clicks on "RejectReviewDecision"  
   When RA clicks on "ApplyFilters" 
   When User selects all Codecombinations in the "<TabName>"  
 When RA clicks on "Reject"
 When User clicks on "Yes" button on the Alert popup
 Then The Review Decision for all the selected records should be changed to Reject and the corresponding Remarks should be cleared 
  Then Logout of the Application
       
   Examples: 
  |LCD_OR_ARTICLE  | User ID      |TabName          |TabName2 |
 |LCD             | iht_ittest05 |SupportTab								|  Support   |   
  |LCD             | iht_ittest05 |DoesNotSupportTab|  Does   |   
 |Article 			   | iht_ittest05 |SupportTab               | Support |
  |Article         | iht_ittest05 |DoesNotSupportTab|  Does   |   
    
                    
                    
                    
               
                    
                    
                    
                    
                    
                    
         
         
         
 
     
       
       
        
 