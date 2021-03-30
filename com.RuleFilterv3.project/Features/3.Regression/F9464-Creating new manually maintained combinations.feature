#Author: shailaja.nuthi@cotiviti.com, Udayakiran lanka
@RegressionNov21
Feature: F9464 - Creating new manually maintained combinations

  #########################################################################################################################

    @RegressionJan9th
  Scenario Outline: US41993 Alert the user while switching radio button by entering details(TC13673)
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount>","<Category1>" for "<LCD_OR_ARTICLE>"
    And RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
    Then the Alert should be displayed with the "<Alert Message>"
    When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount>","<Category2>" for "<LCD_OR_ARTICLE>"
    And RA Validates selection as "Manually Maintain" and click on "Associate Code" in add combination tab
    Then the Alert should be displayed with the "<Alert Message>"
    And Logout of the Application 

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount | Category1                      | Category2                     | Alert Message                                                                                     |
   | iht_ittest05 | LCD            |                1 | Validate_RadioButton_Assosiate | Validate_RadioButton_Manually | You have unsaved data on the screen. Click on 'Yes' to continue, 'No' to stay on the same screen. |
   | iht_ittest05 | Article        |                1 | Validate_RadioButton_Assosiate | Validate_RadioButton_Manually | You have unsaved data on the screen. Click on 'Yes' to continue, 'No' to stay on the same screen. |



    @RegressionJan9th
  Scenario Outline: US41993 Alert the user while switching radio button without entering details(TC13673)
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
    When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
    Then Alert Popup should not be displayed
    When RA Validates selection as "Manually Maintain" and click on "Associate Code" in add combination tab
    Then Alert Popup should not be displayed
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE |
     | iht_ittest05 | LCD            |
    | iht_ittest05 | Article        |

  @RegressionJan9th
  Scenario Outline: US39182(TC13807),US41992(TC13871)-Ability to consider default dates for DOS to and DOS from for manually maintained combination,Ability to validate the ICD code for manually maintained codes 
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
  Then RA takes decisions on CodeCombinations and Completes RA Review 
  And  DOSFrom should be set to open ended default dates in the target for "<NewICDCode>" and for "<LCD_OR_ARTICLE>"
  And  DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<NewICDCode>" and for "<LCD_OR_ARTICLE>"
  And  Logout of the Application
  
   Examples: 
      | User ID      | LCD_OR_ARTICLE |Alert Message1  																                    |	NewICDGroup 	|NewICDCode|Category|DOSToOpenDate  |
    | iht_ittest05 | LCD                        | Code combination(s) are created successfully. |    1                        | Y37.001A |                       |12/31/9999      |
   | iht_ittest05 | Article                    | Code combination(s) are created successfully.  |    1                        | Y37.001A |                         |12/31/9999     | 
   
   
   
   
  @RegressionJan9th
  Scenario Outline: US41992(TC13782)-Ability to validate the ICD code for manually maintained codes 
  Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
  When RA clicks on CPT ICD Link in My Tasks
  And  RA clicks on "Individual" Task Tab
  And  RA clicks the "<LCD_OR_ARTICLE>" id
  Then RA Review Work Queue screen should be displayed 
  Then Review status should be dispalyed as "Started"
  When RA clicks on the "Add/Edit manual code combination" button
  Then RA should be able to see the "manually" and "associate" radio buttons
  When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
  And  Category should be selected as "Support" and should be non-editable 
  When RA Enters the "<NewICDGroup>","<Category>" and "<NewICDCode>"
  And  RA Clicks on "Save" button
  Then the Alert should be displayed with the "<Alert Message>"  
  And  Logout of the Application
   
  Examples: 
      | User ID      | LCD_OR_ARTICLE |	NewICDGroup 	|NewICDCode|Category|Alert Message  		  															  								|
     | iht_ittest05 | LCD                       |                        | Y37.001A |        |Please enter data in all mandatory field(s) to save.								  |
     | iht_ittest05 | LCD                       |     1                 |          |        |Please enter data in all mandatory field(s) to save.								  |	
     | iht_ittest05 | LCD                     |     1                  |  abcd    |        |Manual ICD code(s) is invalid. Please enter valid code(s) to continue.|	      
      | iht_ittest05 | Article                  |                       | Y37.001A |        |Please enter data in all mandatory field(s) to save.								  |
      | iht_ittest05 | Article                |     1                 |          |        |Please enter data in all mandatory field(s) to save.								  |	
  | iht_ittest05 | Article               |     1                  |  abcd    |        |Manual ICD code(s) is invalid. Please enter valid code(s) to continue.|
    	                                                       																											 																											   
    
    

    
  @RegressionJan9th
  Scenario Outline: US41910,US42018 - Ability to create manually maintained code combinations for LCD (TC13780) & Article (TC13940,TC13942)  - Delta Table Validations
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
    When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
    And  Category should be selected as "Support" and should be non-editable 
    When RA Enters the "<NewICDGroup>","<Category>" and "<NewICDCode>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And Close the Alert Popup
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
     # Second Scenario
    When RA clicks on the "Add/Edit manual code combination" button 
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Add Combination" Task Tab
    Then RA should be able to see the "manually" and "associate" radio buttons
    When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
    And  Category should be selected as "Support" and should be non-editable    
    When RA clicks "<Count>" times on the Add new ICD code button
    When RA Enters the "<NewICDGroup>","<Category>" and "<NewICDCode>"
    And  RA enters the "<NewICDCode2>" for "<Count>" times
    And  RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) already exists in the system for few of the ICD codes. New manual code combination(s) are successfully created for the new ICD code(s)."
    And  Logout of the Application
   
     Examples: 
      | User ID      | LCD_OR_ARTICLE |Alert Message1  																														                                        |	NewICDGroup 	|NewICDCode|NewICDCode2|Category|Count|
     | iht_ittest05 | LCD                      | Code combination(s) for the Manual ICD code(s) already exists in the system.|    1                  | Y37.001A     | Y37.001D  |                    |  1  |
    | iht_ittest05 | Article                  | Code combination(s) for the Manual ICD code(s) already exists in the system.|    1                   | Y37.001A    | Y37.001D  |                    |  1  |    
   
            
            
            
  @RegressionJan9th
  Scenario Outline: US41883-TC13943- Ability to view all manually maintained combinations in the review screen 
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
	When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount>","Support-ValidCodes" for "<LCD_OR_ARTICLE>"
	And    RA Clicks on "Save" button
	Then   the Alert should be displayed with the "<Alert Message1>" 	
	When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
	And  Category should be selected as "Support" and should be non-editable
	When RA Enters the "<NewICDGroup>","<Category>" and "<NewICDCode>" 
	And    RA Clicks on "Save" button
	Then   the Alert should be displayed with the "<Alert Message1>"  
  And   AddCombination Popup window  should not be closed automatically
 	When RA clicks on "Delete Combination" Task Tab
	Then RA should validate List of all manually added "Manually Added Code,Base ICD Code,ICD group,Category" ICD codes with Base ICD Codes
	Then The system should display the list of all the manually maintained code combination to the user with Basecode and DOSTo as "NA"
	#And Validate mapping between base and manually created codes in "<ManualCodeCombTable>"  and  for  "<LCD_OR_ARTICLE>"  --Old Gherkin,  Test below one and delete it	 And  Validate mapping between base and manually created codes in "<ManualCodeCombTable>"  and  for  "<LCD_OR_ARTICLE>"  for "Both" codes
  And  Logout of the Application
   
  
     Examples: 
      | User ID      | LCD_OR_ARTICLE    |Alert Message1  																                  |	NewICDGroup 	|NewICDCode|Category|NewICDCodesCount  |
     | iht_ittest05 | LCD                        | Code combination(s) are created successfully. |    1                  | Y37.001D |                   |1                                |
   | iht_ittest05 | Article                    | Code combination(s) are created successfully. |    1                  | Y37.001D |                   |1                                | 
                  
   
   
   
    @RegressionJan9th
  Scenario Outline: US39183 ,US42030: Ability to delete manually maintained combination in LCD(TC13851,TC13855) - Delete from Delta
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
  Then RA should be able to see the "manually" and "associate" radio buttons
  When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
  And  Category should be selected as "Support" and should be non-editable
  When RA Enters the "<NewICDGroup>","<Category>" and "<NewICDCode>"
  And  RA Clicks on "Save" button
  Then the Alert should be displayed with the "<Alert Message1>"
  When RA clicks on "Delete Combination" Task Tab
  Then RA Selects "All" records for deletion
  Then Records as per the selection should be selected for deletion for "AllRecords"
  Then RA Selects "Single" record for deletion
  Then Records as per the selection should be selected for deletion for "SingleRecord"
  When RA clicks on the "Delete Combination" button
  Then the Alert should be displayed with the "<Alert Message2>"
  And Logout of the Application
   
   Examples:   
      | User ID        | LCD_OR_ARTICLE |Alert Message1  																                 |	NewICDGroup 	|NewICDCode|Category|Alert Message2                                                               |  	
    | iht_ittest05 | LCD                       | Code combination(s) are created successfully. |    1                  | Y37.001A |                   |The selected combination(s) are successfully deleted. |
  | iht_ittest05 | Article                   | Code combination(s) are created successfully. |    1                  | Y37.001A |                    | The selected combination(s) are successfully deleted.|
   
   
   	
                  
    
    #*************************  Multiple Weeks Scenarios ( 2 Weeks ) **************************
    
    
    
    
##Take both Support & doesnot Support Update Script TestData
@RegressionNov21
   Scenario Outline: US39183  -  Ability to delete manually maintained combination in LCD  -TC13854
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
       And  RA Clicks on "Save" button
     Then the Alert should be displayed with the "Code combination(s) are created successfully."
    When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
    And  Category should be selected as "Support" and should be non-editable 
    When RA Enters the "<ICD Group>","<MMCategory>" and "<NewICDCode2>"
    And  RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And  Close the Alert Popup
   Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
         ####Second Week
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
     When RA clicks on "Delete Combination" Task Tab
     When RA enters date as "<Dates>" in delete combination tab for RowNumber "1"
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "The selected combination(s) are successfully date banded."
     And Logout of the Application
    
        Examples: 
      | User ID        | LCD_OR_ARTICLE|WeekNo|ScenarioName|TestDataIDsRange|Base ICD Code|ICD Group|Category|New ICD Code|New ICD Code1|NewICDCode2|CategoryType				|DOSToOpenDate|NewICDCodesCount1|Dates                           |MMCategory|
      | iht_ittest05 |   LCD                    |    Week2 |                            |     80100-80140              | C69.31               |1             |  Support |Y37.001A         |                 |  Y37.001D     |  Support-ValidCodes   |   12/31/9999     | 1                               | 12/10/2018             |                            |       
    | iht_ittest05 |   Article                |    Week2 |                            |      94100-94140          | C69.31             |1               |  Support  |Y37.001A      |                     |  Y37.001D     | 															    |12/31/9999    |  1                                      |  12/10/2018               |                              |                             
    
       
         
     #Flow:  Week1-  Add New Manual Code  and Save ,Week2 - Add Manual Code Y37.001A ,AlertMsg1 displays, Add Manual Codes Y37.001A,Y37.001D  then AlertMsg2 displays     
     
     ###  WORKING
     #USED SUPPORT AND DOESNOTSUPPORT UPDATED SCRIPT TESTDATA  
   @RegressionNov21
  Scenario Outline: US41910 US42018- Ability to create manually maintained code combinations for LCD (TC13778,TC13941)-- Target Table Validations
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
    Then the Alert should be displayed with the "Code combination(s) are created successfully."    
    And Close the Alert Popup
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
    #SecondWeek
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
    When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
    And  Category should be selected as "Support" and should be non-editable 
    When RA Enters the "<NewICDGroup>","<Category>" and "<NewICDCode>"   
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message1>"
    And  Close the Alert Popup
    #Second Scenario    
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be able to see the "manually" and "associate" radio buttons
    When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
    And  Category should be selected as "Support" and should be non-editable 
    When RA clicks "<Count>" times on the Add new ICD code button
    When RA Enters the "<NewICDGroup>","<Category>" and "<NewICDCode>"  
    And  RA enters the "<NewICDCode2>" for "<Count>" times
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) already exists in the system for few of the ICD codes. New manual code combination(s) are successfully created for the new ICD code(s)."
    And  Logout of the Application
    
     Examples: 
      | User ID        | LCD_OR_ARTICLE |Alert Message1  																														                            	           |	NewICDGroup 	|NewICDCode|NewICDCode2|Category|Count|WeekNo|ScenarioName|TestDataIDsRange|
      | iht_ittest05 | LCD                     | Code combination(s) for the Manual ICD code(s) already exists in the system.|    1                       | Y37.001A           | Y37.001D              |                |  1     | week2  |                       |      80100-80140                |
     | iht_ittest05 | Article                 | Code combination(s) for the Manual ICD code(s) already exists in the system.|    1                      | Y37.001A     | Y37.001D       |                |  1     |  week2 |                       |      94100-94140                         | 
   
        
    
    
     ###  WORKING    
    #Flow:  Week1-  Add New Manual Code  and Save   ,Week2 - Delete the Manual Code added in First Week Expected:  DOSFrom need to change to the Date according to Min(DOS_FROM) logic,TargetTable-ManualIndicator will change from 0 to -1 for Version 2
         
     #USED SUPPORT AND DOESNOTSUPPORT UPDATED SCRIPT TESTDATA  
    @RegressionNov21
    Scenario Outline: US41910  US42018  - Ability to create manually maintained code combinations for LCD (TC13779,TC13941), US42030 - Delete from Target
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
    Then the Alert should be displayed with the "Code combination(s) are created successfully."    
    And  Close the Alert Popup
    And  RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>" for Manual maintained Codecombinations
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And  Manual indicator value should be set to "-1" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "1"
    And  Logout of the Application
    And  RA Closes the Application
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And  RA clicks on "Group" Task Tab
    #SecondWeek
    And  RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And  Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Add Combination" Task Tab    
    When RA clicks on "Delete Combination" Task Tab   
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button   
    Then the Alert should be displayed with the "The selected combination(s) are successfully date banded."    
    When RA clicks on "Add Combination" Task Tab
    Then RA should be able to see the "manually" and "associate" radio buttons
    When RA Validates selection as "Associate Code" and click on "Manually Maintain" in add combination tab
    And  Category should be selected as "Support" and should be non-editable 
    When RA Enters the "<NewICDGroup>","<Category>" and "<NewICDCode>"
    And  RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."  
    And  DOSFrom should be set to open ended default dates in the target for "<NewICDCode>" and for "<LCD_OR_ARTICLE>"   
    And  Close the Alert Popup     
    And  Manual indicator value should be set to "-1" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "2"
    And  Logout of the Application
            
     Examples:                                                                                                                                                                                                                 
    | User ID         | LCD_OR_ARTICLE |Alert Message1  															                    |	NewICDGroup   |NewICDCode|Category|Count  |WeekNo|ScenarioName|TestDataIDsRange|                                 
    | iht_ittest05  | LCD                        |Code combination(s) are created successfully. |    1                    | Y37.001A           |              |      1     |  Week2  |                      |   80100-80140                |
   | iht_ittest05   | Article                   |Code combination(s) are created successfully. |    1                    | Y37.001A     |              |      1     |  Week2  |                     |    94100-94140                           |     
                                                                                                                                                                                                                               
 
    
     ### WORKING
     
   # Add Manual New ICD Code preferably as Y37.001A in the First week
   # Move it to Target
   # Manual indicator value should be set to -1
   #Bring the manual CodeY37.001A  from CMS in 2nd week
   # Start Review
   # On Start Review,Manual indicator value should be set to 0      
  
  @RegressionNov21
  Scenario Outline: US41910 US42018- Ability to create manually maintained code combinations for LCD (TC13777) Article (TC13939)- New Mnaul Code insertion 2nd week from CMS
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
    And  Manual indicator value should be set to "-1" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "1"
    And  Logout of the Application
    And  RA Closes the Application 
    #Second Week   
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And  RA clicks on "Group" Task Tab
    And  RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And  Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
     And  Manual indicator value should be set to "0" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "2" 
    Then Manually added codes should be successfully deleted from Manualtable "<ManualCodeCombTable>" for "Support" and for the "<LCD_OR_ARTICLE>"  for "<NewICDCode3>"   
    And  Logout of the Application
    
     Examples: 
      | User ID      | LCD_OR_ARTICLE |Alert Message1  															                     |	NewICDGroup  |NewICDCode|Category|Count|ManualCodeCombTable           |WeekNo|ScenarioName|TestDataIDsRange|
      | iht_ittest05 | LCD                      |Code combination(s) are created successfully. |    1                      | Y37.001A            |               |  1     | LCD_MANUAL_CODE_COMB   | Week2 |                          |      80141-80150                        | 
    | iht_ittest05 | Article                 |Code combination(s) are created successfully. |    1                       | Y37.001A            |               |  1     |  ART_MANUAL_CODE_COMB   | Week2 |                          |    94141-94150                         |
   
       
   ## WORKING
 #Flow:  Week1-  Add New Manual Code and Save   ,Week2 - New HCPC code added which comes from CMS        Expected: For the ManualCode added in the Week1 ,combination should be added with the new HCPC code 
  @RegressionNov22
  Scenario Outline: US44054 - Ability to add and delete manually maintained combinations when new HCPC codes are added by CMS in the 2nd Week (TC14097,TC14100)
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
    Then System should "Add" combination with the new "<HCPCCode>" to the ManuallyMaintainCode combination for "<LCD_OR_ARTICLE>"   and  for LCDArticleVersion "2"
    And   Manual indicator value should be set to "-1" in the "DeltaTable"  for  "<LCD_OR_ARTICLE>"  for LCDArticleVersion "2" and for "<HCPCCode>" 
    And Validate mapping between base and manually created codes in "ManualCodeCombTable"  and  for  "<LCD_OR_ARTICLE>"  for "ManuallyMaintain" codes
    And Logout of the Application


   Examples: 
         | User ID        | LCD_OR_ARTICLE |WeekNo|		ScenarioName|	TestDataIDsRange|		Alert Message1  															       |	NewICDGroup     |NewICDCode|Category|Count|  HCPCCode|
       # | iht_ittest05 | LCD                        |	Week2 	|												 |			80151-80165			  |Code combination(s) are created successfully. |    1                       | Y37.001A           |               |  1     |    0291T      |
       | iht_ittest05 | Article                    |	Week2  	|													 |			94161-94170   								    |Code combination(s) are created successfully. |    1                       | Y37.001A     |                |  1     |    0291T      |
          
      
      
     ### WORKING     
    #Flow:  Week1-  Add New Manual Code and Save   ,Week2 -  Week1 HCPC code comes from CMS as deleted  in week2 Expected: For the ManualCode added in the Week1 ,combination should be deleted for deleted HCPC code                   
  @RegressionNov22
  Scenario Outline: US44054 - Ability to add and delete manually maintained combinations when new HCPC codes deleted by CMS (TC14098,TC14101),US46611.US46493 (Feature: F11040)
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
    #Second week  
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
    Then System should "Delete" combination with the new "G9143" to the ManuallyMaintainCode combination for "<LCD_OR_ARTICLE>"   and  for LCDArticleVersion "1"
    Then System should "Delete" combination with the new "G9143" to the ManuallyMaintainCode combination for "<LCD_OR_ARTICLE>"   and  for LCDArticleVersion "2"    
    And  DOSTo should be Datebanded in the target for "<NewICDCode>"  for "<LCD_OR_ARTICLE>" and for "<DeletedHCPCCode>" and  for LCDArticleVersion "2"   
    And Logout of the Application

   Examples: 
         | User ID        | LCD_OR_ARTICLE |Alert Message1  															                       |	NewICDGroup  |NewICDCode|Category|Count|ManualCodeCombTable             |HCPCCode|DeletedHCPCCode|WeekNo|ScenarioName|TestDataIDsRange|
    #   | iht_ittest05 | LCD                        |Code combination(s) are created successfully.    |    1                   | Y37.001A         |                 |  1      | LCD_MANUAL_CODE_COMB    | 0291T      |   G9143                 | Week2|                |     80166-80180               | 
         | iht_ittest05 | Article                    |Code combination(s) are created successfully.    |    1                  | Y37.001A      |               |  1     | ART_MANUAL_CODE_COMB      | 0291T      |   G9143                 | Week2|                          |    94261-94275                | 
                                                             

 
 
## WORKING ##
 
 #Another Approach :  In the FirstWeek, Add New Manual ICD Code A75.0
 #Week2:                     Bring the Manual Code from CMS (A75.0) by using SQL scripts 
 
 #Flow:  Week1-  Add New Manual Code and Save   ,Week2 - Y37.001A comes from  CMS     (To check:: insert first week data and complete RA Review and then insert second week data with new Manual code)
  @RegressionNov23CMS
  Scenario Outline: US42537 - TC14050-TC14051 - Ability to handle the scenario when the user create manual combination and  delta review is pending for the same combination
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
     And RA Clicks on "Save" button    
    Then the Alert should be displayed with the "<Alert Message1>"
    And Close the Alert Popup
    And  RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>" for Manual maintained Codecombinations
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
  #  Second week Task 
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab 
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    # And  Manual indicator value should be set to "-1" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "1"    #*** Commented as manual code Y37.001A  is not in Target for Version 1 
    And  Manual indicator value should be set to "0" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "2"     
    And  DOSFrom should be set to ReviewEffective date in the target for "<NewICDCode>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "2"   
    And  DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<NewICDCode>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "2"
    Then Manually added codes should be successfully deleted from Manualtable "<ManualCodeCombTable>" for "Support" and for the "<LCD_OR_ARTICLE>"  for "NewICDCode1"   for "ManuallyMaintain" Codecombinations
    And Logout of the Application
       Examples: 
      | User ID      | LCD_OR_ARTICLE |Alert Message1  															                    |	NewICDGroup        |NewICDCode|Category|Count |DOSToOpenDate       |ManualCodeCombTable                |WeekNo|ScenarioName|TestDataIDsRange|
    | iht_ittest05 | Article                   |Code combination(s) are created successfully. |    1                           | Y37.001A            |                   |  1       |12/31/9999         | ART_MANUAL_CODE_COMB  | Week2 |                         |   94310-94320                            |  
     # | iht_ittest05 | LCD                       |Code combination(s) are created successfully. |    1                       |  Y37.001A             |                   |  1       |12/31/9999         | LCD_MANUAL_CODE_COMB  | Week2|                          |     80141-80150                 |
 
 
      ###  WORKING
    #Flow:  Week1-  Add New Manual Code and ICDGroup(2) and Save   ,Week2 - New Manual Code and ICDGroup (2) comes from  CMS 
   @RegressionNov23
  Scenario Outline: US41990, US42094 - Ability to handle the manual combinations when CMS file sends same data for LCD,Article - TC14512- 2 Weeks
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
    Then the Alert should be displayed with the "Code combination(s) are created successfully."    
    And Close the Alert Popup
    And  RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>" for Manual maintained Codecombinations
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
  	And  Manual indicator value should be set to "0" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "2" 
   Then Manually added codes should be successfully deleted from Manualtable "<ManualCodeCombTable>" for "Support" and for the "<LCD_OR_ARTICLE>"  for "<NewICDCode1>"   for "ManuallyMaintain" Codecombinations    
   And ReviewTask should not be created in Support DeltaTable  for  "<LCD_OR_ARTICLE>"  for the CodeCombination  "<NewICDCode>" and   "<NewICDGroup>"   
    And  Logout of the Application 
    
     Examples: 
      | User ID        | LCD_OR_ARTICLE |  	NewICDGroup 	|NewICDCode|Category|Count  |ManualCodeCombTable            |WeekNo|ScenarioName|TestDataIDsRange|
    #| iht_ittest05 | LCD                       |     2                     | Y37.001A      |              |  1        |  LCD_MANUAL_CODE_COMB | Week2  |                       |     80201- 80210                 | 
      | iht_ittest05 | Article                   |     2                    | Y37.001A      |              |  1        |   ART_MANUAL_CODE_COMB| Week2  |                       |         94321-94325               | 
   
    
 
 
   
    #*************************  Multiple Weeks Scenarios (3 Weeks) **************************
 
     
    #Flow:  Week1-  Add New Manual Code and ICDGroup(2) and Save   ,Week2- delete the Manual code combination from UI    Week3 - New Manual Code and ICDGroup (2) comes from  CMS 
   @RegressionNov21New
  Scenario Outline: US41990 , US42094- Ability to handle the manual combinations when CMS file sends same data for LCD, Article- TC1451- 3 Weeks
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
    Then the Alert should be displayed with the "Code combination(s) are created successfully."    
    And Close the Alert Popup
    And  RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>" for Manual maintained Codecombinations
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
   #SecondWeek
   Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And  RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And  Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Add Combination" Task Tab    
    When RA clicks on "Delete Combination" Task Tab   
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button   
    Then the Alert should be displayed with the "The selected combination(s) are successfully date banded."    
    And Close the Alert Popup
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application    
  #Third Week    
  Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
  When RA clicks on CPT ICD Link in My Tasks
  And RA clicks on "Group" Task Tab
  And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
  When RA clicks on "Individual" Task Tab
  When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
  Then RA Review Work Queue screen should be displayed
  And Review status should be dispalyed as "Not Started"
   When RA clicks on "Start Review"
  And  Manual indicator value should be set to "0" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "3" 
  Then Manually added codes should be successfully deleted from Manualtable "<ManualCodeCombTable>" for "Support" and for the "<LCD_OR_ARTICLE>"  for "NewICDCode1"   for "ManuallyMaintain" Codecombinations    
   And ReviewTask should not be created in Support DeltaTable  for  "<LCD_OR_ARTICLE>"  for the CodeCombination  "<NewICDCode>" and   "<NewICDGroup>"   
   And  DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<NewICDCode>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "3"
   And  Logout of the Application 
    
     Examples: 
      | User ID        | LCD_OR_ARTICLE | 	NewICDGroup 	|NewICDCode|Category|ManualCodeCombTable            |WeekNo   |TestDataIDsRange|DOSToOpenDate|ScenarioName|
    | iht_ittest05 | LCD                       |     2                    | Y37.001A     |                | LCD_MANUAL_CODE_COMB | Week3     |     4512                         |   12/31/9999     |                        | 
  # | iht_ittest05 | Article                   |     2                    | Y37.001A     |                | ART_MANUAL_CODE_COMB |  Week3    |   9312                   |   12/31/9999     |                        |
   
    
    
    
   
  @RegressionNov21New
  Scenario Outline: US42537 - TC14052-TC14053 - Ability to handle the scenario when the user create manual combination and  delta review is pending for the same combination
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
     And RA Clicks on "Save" button    
    Then the Alert should be displayed with the "<Alert Message1>"
    And Close the Alert Popup
    And  RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>" for Manual maintained Codecombinations
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
  #  Second week Task 
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
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "The selected combination(s) are successfully date banded."    
    And Close the Alert Popup
     Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
    #Third week Task 
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And   RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"    
    And  Manual indicator value should be set to "-1" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "1"
    And  Manual indicator value should be set to "0" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "3"     
    And  DOSFrom should be set to ReviewEffective date in the target for "<NewICDCode>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "3"   
    And  DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<NewICDCode>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "3"
    Then Manually added codes should be successfully deleted from Manualtable "<ManualCodeCombTable>" for "Support" and for the "<LCD_OR_ARTICLE>"  for "NewICDCode1"   for "ManuallyMaintain" Codecombinations
    And  Logout of the Application
    
       Examples: 
      | User ID      | LCD_OR_ARTICLE |Alert Message1  															                    |	NewICDGroup        |NewICDCode|Category|Count |DOSToOpenDate       |ManualCodeCombTable          |WeekNo|ScenarioName|TestDataIDsRange|
#    | iht_ittest05 | Article                   |Code combination(s) are created successfully. |    1                         |  Y37.001A    |                   |  1       |12/31/9999         | ART_MANUAL_CODE_COMB  |  Week3|                         |                             | 
      | iht_ittest05 | LCD                       |Code combination(s) are created successfully. |    1                         |  Y37.001A    |                   |  1       |12/31/9999         | LCD_MANUAL_CODE_COMB  |  Week3|                          | 4513                 |
 
  
           
    ###  WORKING     
  #Flow:  Week1-  Add New Manual Code and Save   ,Week2 - G9143 Comes from CMS as deleted  Week3: G9143 is subsequently added Expected: For the ManualCode added in the Week1 ,combination should be added with the new HCPC code       
  @RegressionNov21New
  Scenario Outline: US44054,US39183 - Ability to add and delete manually maintained combinations when new HCPC codes are added or deleted by CMS (TC14099,TC14102,TC13857).US42030-Delete combination from Delta and Target 
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
     And RA Clicks on "Save" button    
    Then the Alert should be displayed with the "<Alert Message1>"     
    And Close the Alert Popup
    And  RA captures the HCPCCodes for "<Category>" and "<LCD_OR_ARTICLE>" for Manual maintained Codecombinations
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
#Second week Task Scenario
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
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button  
    Then the Alert should be displayed with the "Manual code combination(s) created in the current review are deleted and code combination(s) existing in the target data are date banded successfully."
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
    And  DOSTo should be set to "<OpenDate>"  in the target for "<NewICDCode>"  and  "<NewHCPCCode>"  and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "3"
     And  Manual indicator value should be set to "0" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "3"  and for "<NewHCPCCode>"
    And  Logout of the Application
    
       Examples: 
      | User ID        | LCD_OR_ARTICLE |Alert Message1  															                    |	NewICDGroup  |NewICDCode|Category|Count |OpenDate    |ManualCodeCombTable          | NewHCPCCode|WeekNo|ScenarioName|TestDataIDsRange|
   | iht_ittest05 | Article                   |Code combination(s) are created successfully. |    1                    | Y37.001A           |        |  1       |12/31/9999 | ART_MANUAL_CODE_COMB  |   G9143            | Week3 |                          |                             |
    | iht_ittest05 | LCD                      |Code combination(s) are created successfully.   |    1                    | Y37.001A           |        |  1       |12/31/9999  | LCD_MANUAL_CODE_COMB  |   G9143             |  Week3|                          |         4520                   |
      