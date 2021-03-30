#Author: jaganmohan.appagari
@RegressionDec27
Feature: F3777 Establish Proposal Review Workflow.

@RegressionJan7
   Scenario Outline: US22321 Filter and Sort Remarks Column
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
    When RA clicks on "<Support_OR_Doesnot_Support>" Task Tab
    When RA enters the remarks as "Functional Test,Automation test" for the rejected codes
    Then RA should be able to view the filter codes based on "Remarks"
    And RA should be able to view the filter codes based on "Display Blanks"
    And Remarks column should be sorted
    Then Logout of the Application

    Examples: 
      | User ID        | Support_OR_Doesnot_Support |LCD_OR_ARTICLE|
      | iht_ittest05 | Support                                      |  LCD         | 
      | iht_ittest05 | Does                                          |  LCD         |
   
     

#Author: Udayakiran

 @RegressionJan7
  Scenario Outline: US10488 - Ability to review Proposal Information and Set a Code combination Appropriate
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
    When RA clicks on "<Support_OR_Doesnot_Support>" Task Tab
    Then "Accept" button should be "disabled"    
    And  Apply Filter on CPTHCPCSGroup in the "SupportTab"
    When User selects codecombinations in the "SupportTab" and does not select any in DoesNotSupportTab   
    Then "Accept" button should be "enabled"
    When User deselects any codecombinations in the "SupportTab"
    And  Apply Filter on CPTHCPCSGroup in the "DoesNotSupportTab"
    And  User selects codecombinations in the "DoesNotSupportTab" and does not select any in SupportTab
    Then "Accept" button should be "enabled"
    And  Apply Filter on CPTHCPCSGroup in the "SupportTab"
    And  Apply Filter on CPTHCPCSGroup in the "DoesNotSupportTab"
    When User selects any code combinations in "Support and DoesNotSupport" tabs
    Then "Reject" button should be "enabled"
    When User doesnot select any codecombinations in "Support and DoesNotSupport" tabs
    Then "Accept" button should be "disabled"
    And  Apply Filter on CPTHCPCSGroup in the "SupportTab"
    When User selects some codecombinations in the "<SupportORDoesnotSupport>"
    When RA clicks on "Accept"
    Then the codecombination should be set as "Accept" in ReviewDecision column    
    When User captures the CodeCombination count in "SupportandDoesNotSupport"    
    Then The count should match with the DB count for "SupportTab" for "<LCD_OR_ARTICLE>"  
    Then The count should match with the DB count for "DoesNotSupportTab" for "<LCD_OR_ARTICLE>"  
    Then Logout of the Application
    
      Examples: 
      | User ID        | LCD_OR_ARTICLE|Support_OR_Doesnot_Support |     
      | iht_ittest05 | LCD                      |         Support                               |
     | iht_ittest05    | Article                  |         Support                               |
     
     
     
  @AutoReject
  Scenario Outline: US22436,US22442-System Reject Add-on Codes  , Unlisted Codes
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
    Then the ReviewDecision should be auto populated as Reject with Remarks as "<RejectRemarks>"  for  excluded "<CPT/HCPCcode>" with "<New ICD Code>"   for "<Support_OR_DontSupport>" tabs
    ###NegativeScenario
    But the ReviewDecision should not be populated as Reject and Remarks should be blank for "<Valid CPT/HCPCcode>" with "<New ICD Code>"   for "<Support_OR_DontSupport>" tabs 
  # And  The Reasons System-Excluded Add-on Codes and System-Excluded Unlisted code should not be displayed in the Reason dropdown
  #  And  RA should be able to edit the System decision
    Then Logout of the Application   
       
       Examples:    
        | User ID        | LCD_OR_ARTICLE|WeekNo   |ScenarioName|TestDataIDsRange|Category                 |New ICD Code|RejectRemarks                           |CPT/HCPCcode                                                                     |  Support_OR_DontSupport|Valid CPT/HCPCcode|
      #  | iht_ittest05 |   LCD                    |    Week1 |                        |     8132                 |  Support   				       |                     | System-Excluded Add-on Codes  |  0071U,0072U,0073U,0074U,0075U,0076U,C8937,C9753   |   Support                            |    G9143                 |
      #| iht_ittest05 |   LCD                    |    Week1 |                       |      8132                 |  Does Not Support |Y37.001A       |System-Excluded Add-on Codes   |  0071U,0072U,0073U,0074U,0075U,0076U,C8937,C9753 |      Does                              |       G9143                         | 
      #| iht_ittest05 |   Article                |    Week1 |                       |     8132                  |  Support                 |Y37.001A        |System-Excluded Add-on Codes   |   0071U,0072U,0073U,0074U,0075U,0076U,C8937,C9753 |      Support                         |      G9143                         |
      #| iht_ittest05 |   Article                |    Week1 |                       |     8132                   |  Does Not Support |Y37.001A        |System-Excluded Add-on Codes   |   0071U,0072U,0073U,0074U,0075U,0076U,C8937,C9753 |      Does                             |      G9143                          |   
       
        | iht_ittest05 |   LCD                    |    Week1 |                        |     8133                 |  Support   				       |                     | System-Excluded Unlisted Codes  |   01999,38129,41599,50549,67399,77299,81599,90999    |   Support                            |    G9143                 |
       
             
         
         
         
              
                 
         
         
              
         
         
         
   
 @ManuallyMaintainedCodes
  Scenario Outline:  TESLA-6102 - Auto Reject decisions for ManuallyMaintainedCodes (AC ID: TC17274) 
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
    Then the ReviewDecision should be auto populated as Reject with Remarks as "<RejectRemarks>"  for  excluded "<CPT/HCPCcode>" with "<NewICDCode2>"   for "Support" tabs     
    Then Logout of the Application            

          Examples:    
        | User ID        | LCD_OR_ARTICLE|WeekNo   |ScenarioName|TestDataIDsRange|Base ICD Code|ICD Group|Category|New ICD Code|NewICDCode2|	DOSToOpenDate|NewICDCodesCount1|RejectRemarks                            |CPT/HCPCcode           																										      |  Support_OR_DontSupport|New ICD Code1|MMCategory|Valid CPT/HCPCcode|
        | iht_ittest05 |   LCD                    |    Week1 |                        |     8132                    | C69.31             |1             |  Support |Y37.001A    | Y37.001D        | 12/31/9999          | 1                              |System-Excluded Add-on Codes  | 0071U,0072U,0073U,0074U,0075U,0076U,C8937,C9753 	|   Support                           |                         |                      |  G9143                     |   
#      | iht_ittest05 |   Article                |    Week1 |                        |     813                    | C69.31             |1             |  Support |Y37.001A    | Y37.001D        | 12/31/9999          | 1                              |System-Excluded Add-on Codes  | 0071U,0072U,0073U,0074U,0075U,0076U,C8937,C9753 	|   Support                           |                         |                      |  G9143                     |
    
    #    | iht_ittest05 |   LCD                    |    Week1 |                        |     8133                  | C69.31             |1             |  Support  |Y37.001A    | Y37.001D        | 12/31/9999        | 1                            |System-Excluded Unlisted Codes  |   01999,38129,41599,50549,67399,77299,81599,90999  |   Support                           |                           |                    |    G9143                   |
#      | iht_ittest05 |   Article                |    Week1 |                        |     8133                  | C69.31             |1             |  Support  |Y37.001A    | Y37.001D        | 12/31/9999        | 1                            |System-Excluded Unlisted Codes  |   01999,38129,41599,50549,67399,77299,81599,90999  |   Support                           |                           |                    |    G9143                   |
       
       

      
 @ManuallyAssociatedCodes
  Scenario Outline: TESLA-6100 - Auto Reject decisions for ManuallyAssociatedCodes   (AC ID: TC17261)
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
   Then the ReviewDecision should be auto populated as Reject with Remarks as "<RejectRemarks>"  for  excluded "<CPT/HCPCcode>" with "<New ICD Code>"   for "<Support_OR_DontSupport>" tabs
    ###NigativeScenario
    And the ReviewDecision should not be populated as Reject and Remarks should be blank for "<Valid CPT/HCPCcode>" with "<New ICD Code>"   for "<Support_OR_DontSupport>" tabs 
    Then Logout of the Application   
            
    
        #@Support     
          #Examples:    
        #| User ID        | LCD_OR_ARTICLE|WeekNo   |ScenarioName|TestDataIDsRange|Base ICD Code|ICD Group|Category                |New ICD Code|NewICDCode2|	DOSToOpenDate|NewICDCodesCount1|RejectRemarks                              |CPT/HCPCcode                                                                     |  Support_OR_DontSupport|New ICD Code1|MMCategory|Valid CPT/HCPCcode|
      #| iht_ittest05 |   LCD                    |    Week1 |                        |     8132                 | C69.31             |1             |  Support   				       |Y37.001A       | Y37.001D        | 12/31/9999          | 1                             |System-Excluded Add-on Codes  |  0071U,0072U,0073U,0074U,0075U,0076U,C8937,C9753   |   Support                          |                           |                    |    G9143                   |
      #| iht_ittest05 |   LCD                    |    Week1 |                       |      94100-94140     | C69.31             |1             |  Does Not Support |Y37.001A       | Y37.001D        | 	12/31/9999         |  1                           |System-Excluded Add-on Codes   |  0071U,0072U,0073U,0074U,0075U,0076U,C8937,C9753 |      Does   |                           |                   |                         |    G9143                   |
      #| iht_ittest05 |   Article                |    Week1 |                       |      94100-94140     | C69.31             |1             |  Support                 |Y37.001A        | Y37.001D        | 	12/31/9999         |  1                           |System-Excluded Add-on Codes   |   0071U,0072U,0073U,0074U,0075U,0076U,C8937,C9753 |      Support|                           |                    |                      |    G9143                    | 
      #| iht_ittest05 |   Article                |    Week1 |                       |      94100-94140     | C69.31             |1             |  Does Not Support |Y37.001A        | Y37.001D        | 	12/31/9999         |  1                           |System-Excluded Add-on Codes   |   0071U,0072U,0073U,0074U,0075U,0076U,C8937,C9753 |      Does    |                           |                    |                      |    G9143                    |
      
    
      #@DoesNotSupport
         Examples:    
          | User ID        | LCD_OR_ARTICLE|WeekNo   |ScenarioName|TestDataIDsRange|Base ICD Code|ICD Group|Category                 |New ICD Code|NewICDCode2|	DOSToOpenDate|NewICDCodesCount1|RejectRemarks                            |CPT/HCPCcode                                                                       |  Support_OR_DontSupport|New ICD Code1|MMCategory|Valid CPT/HCPCcode|
     #  | iht_ittest05 |   LCD                    |    Week1 |                        |     8132                    | C90.10            |1             |  Does Not Support |Y37.001A          | Y37.001D        | 12/31/9999       | 1                               |System-Excluded Add-on Codes  | 0071U,0072U,0073U,0074U,0075U,0076U,C8937,C9753   |Does                                  |                           |                    | G9143                |   
        | iht_ittest05 |   LCD                     |    Week1 |                       |      8133                    | C69.31          |1             |  Support                  |Y37.001A          | Y37.001D        | 	12/31/9999     |  1                             | System-Excluded Unlisted Codes   |  01999,38129,41599,50549,67399,77299,81599,90999                   |Support                             |                           |                      |G9143                  |
     
         
     
