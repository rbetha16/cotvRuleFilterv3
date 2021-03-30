#Author: Udayakiran
@RegressionDec27
Feature: F3775 Create Proposal with Paragraph Information

  @RegressionJan7
  Scenario Outline: US14643,US14181- CPT ICD Link page with tabbed view,- Ability to claim Review task
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    Then RA should able to view the Group/Individual Task screen
    When RA clicks on "Group" Task Tab
    And RA claims "<LCD_OR_ARTICLE>" code from group Tasks
    When RA clicks on "Individual" Task Tab
    When RA clicks on claimed "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"

    Examples: 
      | User ID      | LCD_OR_ARTICLE |
     | iht_ittest05 | Article                 |
      | iht_ittest05 | LCD                    |
  
   
  
  @RegressionJan7
  Scenario Outline: US14858 , US14202 - Ability to Start Review - Functional validation, UI Negative Validation
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA claims "<LCD_OR_Article>" code from group Tasks
    When RA clicks on "Individual" Task Tab
    When RA clicks on claimed "<LCD_OR_Article>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    Then "Start Review" Button should be "Enabled"
    And "Accept" Button should be "Disabled"
    And "Reject" Button should be "Disabled"
    And "Complete RA Review" Button should be "Disabled" 
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    And "Start Review" Button should be "Disabled"
    And "Accept" Button should be "Disabled"
    And "Reject" Button should be "Disabled"
    And "Complete RA Review" Button should be "Disabled"
    And Capture status by executing Query connecting to Database
    And Status on RA Review Work Queue Screen should match with the Status caputured from Database    
    And "View Paragraph Info" Button should be "Enabled"
    When clicks on View Paragraph button 
    Then Paragraph Information for the ICD Code should be displayed
    And  Close Icon should be displayed for the Paragraph information
    Then Click Close Icon  		
    When User clicks on RA Review Work Queue
    Then User Should be able to Navigate to Individual Task  Screen   
    Then Logout of the Application
    
    
    Examples: 
      | User ID      | LCD_OR_Article |
      | iht_ittest05 | LCD            |
  

