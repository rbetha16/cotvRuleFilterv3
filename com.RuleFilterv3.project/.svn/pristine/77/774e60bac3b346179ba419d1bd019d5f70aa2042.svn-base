#Author: Udayakiran Lanka
@RegressionNov21
Feature: F10125 - Manually creating new combinations based on associated ICD codes(after Dec)



  @RegressionJan7US41024
  Scenario Outline: US41024 - Add manual Indicator on the review page (TC13672)- For Associated Code Combinations
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount>","<Category>" for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message>"
    And Close the Alert Popup   
    Then System should display the "Manual" text in CombinationType column against the combination in "<TabName>" for "<LCD_OR_ARTICLE>" and  for "Associated" Codecombination with "<NewHCPCCode>"
    And Logout of the Application

    Examples: 
      | User ID         | LCD_OR_ARTICLE | NewICDCodesCount | Category                                 | TabName | Alert Message                                                    |NewHCPCCode|
   #| iht_ittest05 | LCD                         |      1                           | Support-ValidCodes               | Support     | Code combination(s) are created successfully. |                        |
 #| iht_ittest05  | LCD                          | 			1					                 | DoesNotSupport-ValidCodes   |  Does       |Code combination(s) are created successfully.  |                        |
  #| iht_ittest05 | Article                       | 			1					                 | Support-ValidCodes                 |  Support   |Code combination(s) are created successfully.  |                        |
  | iht_ittest05 | Article                       | 			1					                 | DoesNotSupport-ValidCodes   |  Does       |Code combination(s) are created successfully.   |                        |
 
  
   @RegressionJan7
  Scenario Outline: US41024 - Add manual Indicator on the review page (TC13672) - For Manual Code Combinations 
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
  When RA clicks on the "Add/Edit manual code combination" button
  Then RA should be able to see the "manually" and "associate" radio buttons
  When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
  And  Category should be selected as "Support" and should be non-editable
  When RA Enters the "<NewICDGroup>","<Category>" and "<NewICDCode>"
  And  RA Clicks on "Save" button
  Then the Alert should be displayed with the "<Alert Message1>" 
  And  Close the Alert Popup
   And  RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>" for Manual maintained Codecombinations  
  Then System should display the "Manual" text in CombinationType column against the combination in "<TabName>" for "<LCD_OR_ARTICLE>" and  for "ManuallyManintained" Codecombination with "<NewHCPCCode>"  
  And  Logout of the Application
  
   Examples: 
      | User ID      | LCD_OR_ARTICLE |Alert Message1  																                    |	NewICDGroup 	     |NewICDCode|Category    | TabName |Category_Type|NewHCPCCode|
      | iht_ittest05 | LCD                        | Code combination(s) are created successfully. |    1                        | Y37.001A |                      | Support     |     Support    |                          |
     | iht_ittest05 | LCD                        | Code combination(s) are created successfully. |    1                       | Y37.001A |                     | Does         |        Does     |                           |
     | iht_ittest05 | Article                    | Code combination(s) are created successfully.  |    1                     | Y37.001A |                      |  Support    |  Support       |                           |
     | iht_ittest05 | Article                    | Code combination(s) are created successfully.|    1                     | Y37.001A |                     |  Does        |  Support       |                            |  
   
   
     
 #############    Multiple Weeks Scenarios    ##############
 
 # Use HCPC code Delete 2nd week data
 
  @RegressionNov21
  Scenario Outline: US41024- Add manual Indicator on the review page-TC13773 - For Subsequent codes
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
     When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
     And  Category should be selected as "Support" and should be non-editable
    When RA Enters the "<NewICDGroup>","<Category>" and "<NewICDCode>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message1>"
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
    Then System should display the "Manual" text in CombinationType column against the combination in "<TabName>" for "<LCD_OR_ARTICLE>" and  for "ManuallyManintained" Codecombination with "<NewHCPCCode>"
    And Logout of the Application
    
        Examples:                                                                                                                                                                                                                                               
      | User ID         | LCD_OR_ARTICLE | NewICDCodesCount      |   Alert Message1                                                  |NewHCPCCode|	 NewICDCode|Category    | TabName |Category_Type|	NewICDGroup 	|WeekNo   |TestDataIDsRange|ScenarioName|    
      | iht_ittest05 | LCD                         |      1                                | Code combination(s) are created successfully. |    0291T           | Y37.001A |                          | Support     |     Support    |    1                    |  Week2      |     80166-80180                          |                       |
      | iht_ittest05  | LCD                          | 			1		        	  						   |Code combination(s) are created successfully.|    0291T            | Y37.001A |                          | Does         |        Does     |  1                      |   Week2      |     80166-80180                        |                       |
   #| iht_ittest05 | Article                       | 			1		          							   |Code combination(s) are created successfully.   |    0291T           | Y37.001A |                         |  Support    |  Support    | 1                         |Week2          |     94100-94140                           |                       |        
# | iht_ittest05 | Article                       | 			1			 												  |Code combination(s) are created successfully.    |    0291T            | Y37.001A |                         |  Does        |  Support  |1                           |   Week2       |            94100-94140                    |                       |
                                                                                                                                                                                                                                                              
    
# Second week Manual code from CMS script data
 @RegressionNov21
  Scenario Outline: US42009 -  - Ability to handle the scenario when the user create manual combination and  delta review is pending for the same combinations (TC13656)
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
     When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount>","<Category>" for "<LCD_OR_ARTICLE>"
     And RA Clicks on "Save" button    	
    Then the Alert should be displayed with the "<Alert Message1>"
    And Close the Alert Popup
    And RA captures the HCPCCodes for "<CategoryType>" and "<LCD_OR_ARTICLE>"
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application 
#Second week Task Scenario
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And   RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    And  Manual indicator value should be set to "0" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "2"  for AssociatedCodes   
    And  DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<NewICDCode>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "2"
    Then Manually added codes should be successfully deleted from Manualtable "<ManualCodeCombTable>" for "Support" and for the "<LCD_OR_ARTICLE>"  for "NewICDCode1"   for "AssociateCode" Codecombinations
    And  Logout of the Application
    
       Examples: 
      | User ID         | LCD_OR_ARTICLE |Alert Message1  															                   |NewICDCodesCount|Category                   |ManualCodeCombTable            |CategoryType |  DOSToOpenDate|NewICDCode| WeekNo   |TestDataIDsRange|ScenarioName|
    | iht_ittest05   | LCD                       |Code combination(s) are created successfully. |  1                            |  Support-ValidCodes| LCD_MANUAL_CODE_COMB  |		Support 		  	|   12/31/9999     |Y37.001A       |   Week2    |   80141-80150                   |                       | 
   # | iht_ittest05  | Article                   |Code combination(s) are created successfully. |  1                            |  Support-ValidCodes| ART_MANUAL_CODE_COMB  |		Support				|    12/31/9999      |Y37.001A      | Week2     |       9513                      |                       |                    
                                                                                                                                                                                                                            
                                                                                                                                                                                                         
                                                                                                                                                                                                         
 @RegressionNov21Test
  Scenario Outline: US43315 -  Auto populate the first Six digits to new ICD codes (TC13988,TC13989,TC14151)
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
    And   RA enters  the Seven digit "<BaseICDCode>" in to BaseICD Code field 
    And   RA  presses a Tab
    Then System should auto populate the first Six digits of the Base ICD code into ICD code field
     When RA  clears the data in the BaseICDCode field
    Then  ICDCode fields should have the same data as of BaseICDCode
     And   RA enters  the Seven digit "<BaseICDCode>" in to BaseICD Code field 
    When RA clicks "<Count>" times on the Add new ICD code button
    Then  System should auto populate the first Six digits of the BaseICDcode into all ICD code fields   
    And   Logout of the Application           
     
      Examples: 
      | User ID         | LCD_OR_ARTICLE |	BaseICDCode|Count      |
      | iht_ittest05  | LCD                        |  S00.001X       |     100    |
      | iht_ittest05  | LCD                        |  S00.001         |     2        |
      | iht_ittest05  | Article                    |  S00.001X       |     100    |
     | iht_ittest05  | Article                    |  S00.001         |     2        |
     
     
     
     
     
   ######  ************     THIRD WEEK SCENARIOS  ********  ########### 
 
 @RegressionNov21New
  Scenario Outline: US42009 -  - Ability to handle the scenario when the user create manual combination and  delta review is pending for the same combinations (TC13674)
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
     When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount>","<Category>" for "<LCD_OR_ARTICLE>"
     And RA Clicks on "Save" button    
    Then the Alert should be displayed with the "<Alert Message1>"
    And Close the Alert Popup
     And RA captures the HCPCCodes for "<CategoryType>" and "<LCD_OR_ARTICLE>"
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
  # Second week Task Scenario
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
    Then RA Selects the data grid Checkbox
    When RA clicks on the "Delete Combination" button  
    Then the Alert should be displayed with the "The selected combination(s) are successfully date banded."    
    And Close the Alert Popup
     Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
    #Third week Task Scenario
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And   RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"    
    And  Manual indicator value should be set to "0" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "3"  for AssociatedCodes   
    And  DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<NewICDCode>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "3"
    Then Manually added codes should be successfully deleted from Manualtable "<ManualCodeCombTable>" for "Support" and for the "<LCD_OR_ARTICLE>"  for "NewICDCode1"   for "AssociateCode" Codecombinations
    And  Logout of the Application
    
    
    Examples: 
      | User ID         | LCD_OR_ARTICLE |Alert Message1  															                    |NewICDCodesCount|Category                   |ManualCodeCombTable            |CategoryType |  DOSToOpenDate|NewICDCode|Dates            |WeekNo   |TestDataIDsRange|ScenarioName|
      | iht_ittest05   | LCD                       |Code combination(s) are created successfully. |  1                            |  Support-ValidCodes| LCD_MANUAL_CODE_COMB  |		Support 		  	|   12/31/9999       |Y37.001A      |  12/10/2018  |   Week3  |         4517	                     |                      | 
  # | iht_ittest05  | Article                     |Code combination(s) are created successfully. |  1                            |  Support-ValidCodes| ART_MANUAL_CODE_COMB  |		Support				|    12/31/9999      |Y37.001A      | 12/10/2018    |  Week3   |      90331                         |                       |   

  
 
 