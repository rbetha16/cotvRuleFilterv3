#Author: jaganmohan.appagari, Udayakiran Lanka, Shailaja Nuthi
@RegressionJan10
Feature: F9447 - Manually creating new combinations based on associated ICD codes

  #########################################################################################################################
  @RegressionJan9th
  Scenario Outline: US37053-Ability to initiate creation of new code combination- IndividualTasks Tab (TC13062 & TC13071)
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA claims "<LCD_OR_ARTICLE>" code from group Tasks
    When RA clicks on "Individual" Task Tab
    When RA clicks on claimed "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    Then The buton "Add/Edit Manually Created Combination" should be displayed
    And The button "Add/Edit Manually Created Combination" should be "<Enabled_OR_Disabled>" based on Status "<Started_OR_NotStarted>"
    And Logout of the Application

    Examples: 
      | User ID      | Started_OR_NotStarted | LCD_OR_ARTICLE | Enabled_OR_Disabled |
      | iht_ittest05 | NotStarted            | LCD            | Disabled            |
     | iht_ittest05 | NotStarted            | Article        | Disabled            |

  @RegressionJan9th
  Scenario Outline: US37053-Ability to initiate creation of new code combination  (TC13061 & TC13070)
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA claims "<LCD_OR_ARTICLE>" code from group Tasks
    When RA clicks on "Individual" Task Tab
    When RA clicks on claimed "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    Then The buton "Add/Edit Manually Created Combination" should be displayed
    And The button "Add/Edit Manually Created Combination" should be "<Enabled_OR_Disabled>" based on Status "<Started_OR_NotStarted>"
    When RA clicks on the "Add/Edit Manually Created Combination" button based on Status "<Started_OR_NotStarted>"
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    And Logout of the Application

    Examples: 
      | User ID      | Started_OR_NotStarted | LCD_OR_ARTICLE | Enabled_OR_Disabled |
      | iht_ittest05 | Started               | LCD            | Enabled             |
      | iht_ittest05 | Started               | Article        | Enabled             |

   @RegressionJan9th
  Scenario Outline: US37053-Ability to initiate creation of new code combination- GroupTasks Tab (TC13061 & TC13070)
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA claims "<LCD_OR_ARTICLE>" code from group Tasks
    When RA clicks on "Individual" Task Tab
    When RA clicks on claimed "<LCD_OR_ARTICLE>"
    And Review status should be dispalyed as "Not Started"
    Then The buton "Add/Edit Manually Created Combination" should be displayed
    And The button "Add/Edit Manually Created Combination" should be "<Enabled_OR_Disabled>" based on Status "<Started_OR_NotStarted>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | Enabled_OR_Disabled | Started_OR_NotStarted |
      | iht_ittest05 | LCD            | Disabled            | NotStarted            |
     | iht_ittest05 | Article        | Disabled            | NotStarted            |
      | iht_ittest05 | LCD            | Disabled            | Started               |
     | iht_ittest05 | Article        | Disabled            | Started               |

    @RegressionJan9th
  Scenario Outline: US37054-Ability to enter the Base code and New codes (TC13063 & TC13072)
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
    And Add combination tab should be displayed with "<Field_And_Field_Type>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | Field_And_Field_Type                                                                                          |
      | iht_ittest05 | LCD            | Base ICD Code-TextField;ICD Group-TextField;Category-DropDown;Base ICD Code-TextField;Add New ICD Code-button |
     | iht_ittest05 | Article        | Base ICD Code-TextField;ICD Group-TextField;Category-DropDown;Base ICD Code-TextField;Add New ICD Code-button |

  @RegressionJan9th
  Scenario Outline: US37054-Ability to enter the Base code and new codes_dropdown values (TC13064 & TC13073)
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
    When RA clicks on the "Add/Edit Manually Created Combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    And Category dropdown should be displayed "<Category_DropDown_values>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | Category_DropDown_values      |
      | iht_ittest05 | LCD            | Support,Does Not Support,Both |
      | iht_ittest05 | Article        | Support,Does Not Support,Both |

  @RegressionJan9th
  Scenario Outline: US37054-Ability to enter the Base code and new codes_Add new ICD code (TC13069 & TC13074)
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
    When RA clicks "<Count>" times on the Add new ICD code button
    Then RA should be able to see the "<Count>" ICD code text fields with proper UI
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | Count |
      | iht_ittest05 | LCD            |    10 |
      | iht_ittest05 | Article        |    10 |

   @RegressionJan9th
  Scenario Outline: US37055- Validation of the base ICD code and ICD group- mandatory filed  check (TC13082)
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
    Then the Alert should be displayed with the "<Alert Message>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | Base ICD Code | ICD Group | Category | New ICD Code | New ICD Code1 | Alert Message                                        |
      | iht_ittest05 | LCD            |               |         1 | Both     | S00.10XD     |               | Please enter data in all mandatory field(s) to save. |
      | iht_ittest05 | LCD            | S00.10XA      |           | Both     | S00.10XD     |               | Please enter data in all mandatory field(s) to save. |
      | iht_ittest05 | LCD            | S00.10XA      |         1 |          | S00.10XD     |               | Please enter data in all mandatory field(s) to save. |
      | iht_ittest05 | LCD            | S00.10XA      |         1 | Both     |              |               | Please enter data in all mandatory field(s) to save. |
     | iht_ittest05 | Article        |               |         1 | Both     | S00.10XD     |               | Please enter data in all mandatory field(s) to save. |
      | iht_ittest05 | Article        | S00.10XA      |           | Both     | S00.10XD     |               | Please enter data in all mandatory field(s) to save. |

  @RegressionJan9th
  Scenario Outline: US37055- Validation of the base ICD code and ICD group- when user enters the wrong base icd code and group (TC13082)
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
    When RA clicks "<Count>" times on the Add new ICD code button
    When RA Enters the "<Base ICD Code>","<ICD Group>","<Category>","<New ICD Code>","<New ICD Code1>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | Count | Base ICD Code | ICD Group | Category         | New ICD Code | New ICD Code1                                | Alert Message                                                                                               |
      | iht_ittest05 | LCD            |       | abcd          |         1 | Both             | S00.10XD     |                                              | Base ICD code abcd is invalid. Please enter valid code to continue.                                         |
      | iht_ittest05 | LCD            |       | S00.10XA      |         1 | Both             | S00.10XA     |                                              | Base ICD code and Manual ICD codes cannot be same.                                                          |
      | iht_ittest05 | LCD            |     1 | abcd          |         1 | Support          | abcdd        | abcdd                                        | Base ICD code and Manual ICD code(s) are invalid. Please enter valid codes to continue.                     |
      | iht_ittest05 | LCD            |       | D68.2         |         1 | Support          | D68.2x       |                                              | Manual ICD code(s) D68.2x are invalid. Please enter valid codes to continue.                                |
      | iht_ittest05 | LCD            |       | C18.1         |         1 | Support          | C18.1Y       |                                              | Manual ICD code(s) C18.1Y are invalid. Please enter valid codes to continue.                                |
      | iht_ittest05 | LCD            |       | C18.1         |         1 | Does Not Support | C18.1Y       |                                              | Manual ICD code(s) C18.1Y are invalid. Please enter valid codes to continue.                                |
      | iht_ittest05 | LCD            |     5 | S00.10XA      |           | Support          | S00.10XD     | S00.10XE,S00.10XF,S00.10XG,S00.10XH,S00.10XI | Please enter data in all mandatory field(s) to save.                                                        |
      | iht_ittest05 | LCD            |     3 | abcd          |         1 | Support          | Y37.001A     | abcdd,abcde,abcdf                            | Base ICD code and Manual ICD code(s) abcdf, abcdd, abcde are invalid. Please enter valid codes to continue. |
      | iht_ittest05 | Article        |       | C18.1         |         1 | Support          | C18.1Y       |                                              | Manual ICD code(s) C18.1Y are invalid. Please enter valid codes to continue.                                |
      | iht_ittest05 | Article        |       | C18.1         |         1 | Does Not Support | C18.1Y       |                                              | Manual ICD code(s) C18.1Y are invalid. Please enter valid codes to continue.                                |
      | iht_ittest05 | Article        |       | abcd          |         1 | Both             | S00.10XD     |                                              | Base ICD code abcd is invalid. Please enter valid code to continue.                                         |

  @RegressionJan9th
  Scenario Outline: US37055,US37058- Validation of the base ICD code and ICD group- Support and DoesNotSupport Categories(TC13079-US37058)
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
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount | Category                                  | Alert Message                                                                                                                 |
      | iht_ittest05 | LCD            |                1 | Does Not Support                          | Base ICD code is not mapped with the LCD for 'Does Not Support' category. Please enter valid data to continue.                |
      | iht_ittest05 | LCD            |                1 | Support                                   | Base ICD code is not mapped with the LCD for 'Support' category. Please enter valid data to continue.                         |
      | iht_ittest05 | LCD            |                1 | Both                                      | Base ICD code is not mapped with the LCD for 'Both' the categories. Please enter valid data to continue.                      |
      | iht_ittest05 | LCD            |                1 | Support-ValidCodes-InvalidICDGroup        | Base ICD code and ICD group are not mapped with the LCD for 'Support' category. Please enter valid data to continue.          |
      | iht_ittest05 | LCD            |                1 | DoesNotSupport-ValidCodes-InvalidICDGroup | Base ICD code and ICD group are not mapped with the LCD for 'Does Not Support' category. Please enter valid data to continue. |
      | iht_ittest05 | LCD            |                1 | BothCategories-InvalidICDGroup            | Base ICD code and ICD group are not mapped with the LCD for 'Both' category. Please enter valid data to continue.             |
      | iht_ittest05 | LCD            |                1 | Support-ValidCodes                        | Code combination(s) are created successfully.                                                                                 |
      | iht_ittest05 | LCD            |                1 | DoesNotSupport-ValidCodes                 | Code combination(s) are created successfully.                                                                                 |
      | iht_ittest05 | Article        |                1 | Both                                      | Base ICD code is not mapped with the Article for 'Both' the categories. Please enter valid data to continue.                  |
      | iht_ittest05 | Article        |                1 | Support                                   | Base ICD code is not mapped with the Article for 'Support' category. Please enter valid data to continue.                     |
      | iht_ittest05 | Article        |                1 | Does Not Support                          | Base ICD code is not mapped with the Article for 'Does Not Support' category. Please enter valid data to continue.            |

  @RegressionJan9th
  Scenario Outline: US37055- Validation of the base ICD code and ICD group- Support and DoesNotSupport Categories
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
    When RA Enters the CodeCombination details for "<NewICDCodesCount>","<Category>" for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount | Category                   | Alert Message                                                                                                                                               |
      | iht_ittest05 | LCD            |                1 | Support-SingleCodes        | Code combination(s) for the Manual ICD code(s) already exists in the system.                                                                                |
      | iht_ittest05 | LCD            |                2 | Support-MultipleValidCodes | Code combination(s) already exists in the system for few of the ICD codes. New manual code combination(s) are successfully created for the new ICD code(s). |
   | iht_ittest05 | Article        |                2 | Support-MultipleValidCodes | Code combination(s) already exists in the system for few of the ICD codes. New manual code combination(s) are successfully created for the new ICD code(s). |

    @RegressionJan9th
  Scenario Outline: US37863,US39179- Ability to view all Manually created code combination- support_fields and Dont support fields
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
    When RA Enters the CodeCombination details for "<NewICDCodesCount>","<Category>" for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message>"
    When RA clicks on "Delete Combination" Task Tab
    When RA selects "Category" as "<Category_Type>"
    When RA enters date as "<Dates>" in delete combination tab
    Then columns with "<ColumnHeaders>" names should display on delete combination tab
    And Validate Sorting as "Sort Ascending,Sort Descending" for column "<ColumnHeaders>"
    Then RA should validate List of all manually added "Manually Added Code,Base ICD Code,ICD group,Category" ICD codes with Base ICD Codes
    And RA validate the filters applied for "Manually Added Code,Base ICD Code,ICD group,Category"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount | Category                                  | Alert Message                                 | ColumnHeaders                                               | Category_Type    | Dates                 |
      | iht_ittest05 | LCD            |                2 | AddMultipleValidCodes_Support_DontSupport | Code combination(s) are created successfully. | Manually Added Code,Base ICD Code,ICD group,Category,DOS To | Support          | 12/10/2012,08/11/2017 |
      | iht_ittest05 | Article        |                2 | AddMultipleValidCodes_Support_DontSupport | Code combination(s) are created successfully. | Manually Added Code,Base ICD Code,ICD group,Category,DOS To | Support          | 12/10/2012,08/11/2017 |
      | iht_ittest05 | LCD            |                2 | AddMultipleValidCodes_Support_DontSupport | Code combination(s) are created successfully. | Manually Added Code,Base ICD Code,ICD group,Category,DOS To | Does not Support | 08/11/2017,12/10/2012 |
      | iht_ittest05 | Article        |                2 | AddMultipleValidCodes_Support_DontSupport | Code combination(s) are created successfully. | Manually Added Code,Base ICD Code,ICD group,Category,DOS To | Does not Support | 08/11/2017,12/10/2012 |

  @RegressionJan9th
  Scenario Outline: US37111 : Ability to delete the Base to manually created combination mapping (TC13297)
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
    When RA Enters the CodeCombination details for "<NewICDCodesCount>","<Category>" for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message1>"
    When RA clicks on "Delete Combination" Task Tab
    Then RA Selects "All" records for deletion
    Then Records as per the selection should be selected for deletion for "AllRecords"
    Then RA Selects "Single" record for deletion
    Then Records as per the selection should be selected for deletion for "SingleRecord"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount | NewICDCodesCount2 | Category                                  | Dates      | Alert Message1                                |
      | iht_ittest05 | LCD            |                2 |                 1 | AddMultipleValidCodes_Support_DontSupport | 12/10/2018 | Code combination(s) are created successfully. |
      | iht_ittest05 | Article        |                2 |                 1 | AddMultipleValidCodes_Support_DontSupport | 12/10/2018 | Code combination(s) are created successfully. |

  @RegressionJan9th
  Scenario Outline: US37111-  Ability to delete the Base to manually created combination mapping-TC13298-Scenario3
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
    Then the Alert should be displayed with the "<Alert Message1>"
    When RA clicks on "Delete Combination" Task Tab
    When RA enters date as "<Dates>" in delete combination tab
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "<Alert Message2>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount | NewICDCodesCount2 | Category                      | TabName        | Dates      | Alert Message1                                | Alert Message2                                        |
      | iht_ittest05 | LCD            |                1 |                 1 | Support-ValidCodes            | Support        | 12/10/2018 | Code combination(s) are created successfully. | The selected combination(s) are successfully deleted. |
      | iht_ittest05 | LCD            |                1 |                 1 | DoesNotSupportOnly-ValidCodes | DoesNotSupport | 12/10/2018 | Code combination(s) are created successfully. | The selected combination(s) are successfully deleted. |
      | iht_ittest05 | Article        |                1 |                 1 | Support-ValidCodes            | Support        | 12/10/2018 | Code combination(s) are created successfully. | The selected combination(s) are successfully deleted. |
      | iht_ittest05 | Article        |                1 |                 1 | DoesNotSupportOnly-ValidCodes | DoesNotSupport | 12/10/2018 | Code combination(s) are created successfully. | The selected combination(s) are successfully deleted. |

  @RegressionJan9th
  Scenario Outline: US42030 -  Application should display when alert message when DOS TO date is not provided
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
    Then the Alert should be displayed with the "<Alert Message1>"
    When RA clicks on "Delete Combination" Task Tab
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "<Alert Message2>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount | NewICDCodesCount2 | Category           | TabName | Dates      | Alert Message1                                | Alert Message2                                                                                                                                                                                        |
      | iht_ittest05 | LCD                      |                1 |                 1 | Support-ValidCodes | Support | 12/10/2018 | Code combination(s) are created successfully. | 'DOS To' is mandatory to manually date band the 'Associated ICD code' combinations. Please select appropriate date(s) for selected associated ICD code(s) to successfully date band the combinations. |
      | iht_ittest05 | Article                  |                1 |                 1 | Support-ValidCodes | Support | 12/10/2018 | Code combination(s) are created successfully. | 'DOS To' is mandatory to manually date band the 'Associated ICD code' combinations. Please select appropriate date(s) for selected associated ICD code(s) to successfully date band the combinations. |



  #US37111 - TC13299 & TC13300
  
  @RegressionJan9th
  Scenario Outline: US37111-  Ability to delete the Base to manually created combination mapping-TC13299-TC13300
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
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And Validate mapping between base and manually created codes in "<ManualCodeCombTable>" for "<Category_Type>" and "<LCD_OR_ARTICLE>"
    And RA captures the HCPCCodes for "<Category_Type>" and "<LCD_OR_ARTICLE>"
    When RA clicks on "Delete Combination" Task Tab
    When RA enters date as "<Dates>" in delete combination tab
    Then RA Selects "All" records for deletion
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "The selected combination(s) are successfully deleted."
    And Close the Alert Popup
    Then Manually added codes should be successfully deleted from "<SupportTables>" for "<Category_Type>" and for the "<LCD_OR_ARTICLE>" for "ICDCode1"
    Then Manually added codes should be successfully deleted from Manualtable "<ManualCodeCombTable>" for "<Category_Type>" and for the "<LCD_OR_ARTICLE>"  for "ICDCode1"
    And CodeCombinations created for the records should be deleted from UI for "<Category_Type>" and for "<LCD_OR_ARTICLE>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount | Category                      | Category_Type | SupportTables                                     | ManualCodeCombTable  | Dates                 | ManualICDCodes |
      | iht_ittest05 | LCD            |                1 | Support-ValidCodes            | Support       | LCD_CPT_ICD_SPRT_DELTA                            | LCD_MANUAL_CODE_COMB | 12/10/2018            | ICDCode1       |
      | iht_ittest05 | LCD            |                1 | DoesNotSupportOnly-ValidCodes | Does          | LCD_CPT_ICD_DONTSPRT_DELTA                        | LCD_MANUAL_CODE_COMB | 12/10/2018            | ICDCode1       |
      | iht_ittest05 | LCD            |                1 | Support_Both_Categories       | Both          | LCD_CPT_ICD_SPRT_DELTA,LCD_CPT_ICD_DONTSPRT_DELTA | LCD_MANUAL_CODE_COMB | 12/10/2018,12/10/2018 | ICDCode1       |
      | iht_ittest05 | Article        |                1 | Support-ValidCodes            | Support       | ART_CPT_ICD_SPRT_DELTA                            | ART_MANUAL_CODE_COMB | 12/10/2018            | ICDCode1       |
      | iht_ittest05 | Article        |                1 | DoesNotSupportOnly-ValidCodes | Does          | ART_CPT_ICD_DONTSPRT_DELTA                        | ART_MANUAL_CODE_COMB | 12/10/2018            | ICDCode1       |
      | iht_ittest05 | Article        |                1 | Support_Both_Categories       | Both          | ART_CPT_ICD_SPRT_DELTA,ART_CPT_ICD_DONTSPRT_DELTA | ART_MANUAL_CODE_COMB | 12/10/2018,12/10/2018 | ICDCode1       |



  @RegressionJan9th
  Scenario Outline: US37056- Ability to create combinations with New ICD code with each CPT code for given LCD  (TC13075 & TC13076)
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
    And RA clicks on "<Category_Type>" Task Tab
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Add Combination" Task Tab
    Then RA should be able to see the "manually" and "associate" radio buttons
    When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount>","<Category>" for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "Code combination(s) are created successfully."
    And Close the Alert Popup
    Then Validate created new code combinations with all CPT codes under the "<LCD_OR_ARTICLE>"
    And manually created code combinations should be set as Manual in "<Tables>" for that "<LCD_OR_ARTICLE>"
    And Validate mapping between base and manually created codes in "<MANUAL_CODE_COMB_TABLE>" for "<Category_Type>" and "<LCD_OR_ARTICLE>"

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount | Category                | Category_Type | Tables                     | MANUAL_CODE_COMB_TABLE |
      | iht_ittest05 | LCD                   |      1                          | Support-ValidCodes      | Support       | LCD_CPT_ICD_SPRT_DELTA     | LCD_MANUAL_CODE_COMB   |
      | iht_ittest05 | LCD                   |                1                | DoesNotSupport          | Does          | LCD_CPT_ICD_DONTSPRT_DELTA | LCD_MANUAL_CODE_COMB   |
      | iht_ittest05 | Article               |                1                | Support-ValidCodes      | Support       | ART_CPT_ICD_SPRT_DELTA     | ART_MANUAL_CODE_COMB   |
      | iht_ittest05 | Article               |                1               | DoesNotSupport          | Does          | ART_CPT_ICD_DONTSPRT_DELTA | ART_MANUAL_CODE_COMB   |
      | iht_ittest05 | LCD                     |                1              | Support_Both_Categories | Support       | LCD_CPT_ICD_SPRT_DELTA     | LCD_MANUAL_CODE_COMB   |

  
  @RegressionJan9th
  Scenario Outline: US37056- Ability to create combinations with New ICD code with each CPT code for given LCD_Article_TARGET (TC13077 & TC13078)
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
    Then the Alert should be displayed with the "<Alert Message1>"
    And Close the Alert Popup
    Then RA takes decisions on CodeCombinations and Completes RA Review
    Then manually created code combinations should be set as manual in "<Tables>" for that "<LCD_OR_ARTICLE>" in target

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount | Category           | Alert Message1                                | Tables                |
      | iht_ittest05 | LCD            |                1 | Support-ValidCodes | Code combination(s) are created successfully. | LCD_CPT_ICD_LINKS     |
      | iht_ittest05 | Article        |                1 | Support-ValidCodes | Code combination(s) are created successfully. | ARTICLE_CPT_ICD_LINKS |
      
      
      

  ##############################----------- * Multiple Weeks Scenarios * -------------------####################################
  
  
  #Take both Support and DoesNot support Updated TestData
    @RegressionJanLater
  Scenario Outline: US37111- Ability to delete the Base to manually created combination mapping-TC13298-Scenario2
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code on SubsequentTasks for "<NewICDCodesCount1>","<Category>" for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message1>"
    When RA clicks on "Delete Combination" Task Tab
    When RA enters date as "<Dates>" in delete combination tab
    Then RA Selects the data grid Checkbox
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "<Alert Message2>"
    Then The records should be delted from the "DeleteCombination" Popup
    And Close the Alert Popup
    Then RA Clicks on the "<TabName>"
    Then Manually added "NewICDCode1" should be successfully "Deleted" from UI
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | WeekNo | ScenarioName | TestDataIDsRange | NewICDCodesCount1 | NewICDCodesCount2 | Category                                | Dates                 | Alert Message1                                | Alert Message2                                                                                                                                         | TabName |
    #| iht_ittest05 | LCD            | Week2  |              | 80100-80140      |                 1 |                 1 | DoesNotSupportOnly-SubsequentValidCodes | 12/10/2018,12/10/2018 | Code combination(s) are created successfully. | Manual code combination(s) created in the current review are deleted and code combination(s) existing in the target data are date banded successfully. | Support |
      | iht_ittest05 | Article        | Week2  |              | 94100-94140      |                 1 |                 1 | DoesNotSupportOnly-SubsequentValidCodes | 12/10/2018,12/10/2018 | Code combination(s) are created successfully. | Manual code combination(s) created in the current review are deleted and code combination(s) existing in the target data are date banded successfully. | Support |



  #Take both Support and DoesNot support Updated TestData
      @RegressionJanLater
  Scenario Outline: US37111- Ability to delete the Base to manually created combination mapping(TC13301&TC13302)
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount1>","<Category>" for "<LCD_OR_ARTICLE>"
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
    Then the Alert should be displayed with the "<Alert Message2>"
    Then Manually added codes should be successfully deleted from Manualtable "<ManualCodeCombTable>" for "<Category_Type>" and for the "<LCD_OR_ARTICLE>"
    And Manual codecombination should be DateBanded to the user selected DOSTO "<Dates>" in "<TargetTable>" and for the "<LCD_OR_ARTICLE>" and "<Category_Type>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount1 | NewICDCodesCount2 | Category_Type | Category                      | Dates      | Alert Message1                                | Alert Message2                                            | TabName | ManualCodeCombTable  | WeekNo | ScenarioName | TestDataIDsRange |
 #   | iht_ittest05 | LCD            |                 1 |                 1 | Support       | Support-ValidCodes            | 12/10/2018 | Code combination(s) are created successfully. | The selected combination(s) are successfully date banded. | Support | LCD_MANUAL_CODE_COMB | Week2  |              | 80100-80140      |
 #   | iht_ittest05 | LCD            |                 1 |                 1 | Does          | DoesNotSupportOnly-ValidCodes | 12/10/2018 | Code combination(s) are created successfully. | The selected combination(s) are successfully date banded. | Support | LCD_MANUAL_CODE_COMB | Week2  |              | 80100-80140      |
      | iht_ittest05 | Article        |                 1 |                 1 | Support       | Support-ValidCodes            | 12/10/2018 | Code combination(s) are created successfully. | The selected combination(s) are successfully date banded. | Support | ART_MANUAL_CODE_COMB | Week2  |              | 94100-94140      |
      | iht_ittest05 | Article        |                 1 |                 1 | Does          | DoesNotSupportOnly-ValidCodes | 12/10/2018 | Code combination(s) are created successfully. | The selected combination(s) are successfully date banded. | Support | ART_MANUAL_CODE_COMB | Week2  |              | 94100-94140      |




  #Take both Support and DoesNot support Updated TestData
       @RegressionJanLater
  Scenario Outline: US37111- Ability to delete the Base to manually created combination mapping(TC13303&TC13304)
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount1>","<Category>" for "<LCD_OR_ARTICLE>"
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code on SubsequentTasks for "<NewICDCodesCount1>","<Category2>" for "<LCD_OR_ARTICLE>"
    And RA Enters new Manual ICDCode for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message1>"
    When RA clicks on "Delete Combination" Task Tab
    When RA enters date as "<Dates>" in delete combination tab
    Then RA Selects the data grid Checkbox
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "<Alert Message2>"
    Then Manually added codes should be successfully deleted from "<SupportTables>" for "<Category_Type>" and for the "<LCD_OR_ARTICLE>" for "ICDCode2"
    Then Manually added codes should be successfully deleted from Manualtable "<ManualCodeCombTable>" for "<Category_Type>" and for the "<LCD_OR_ARTICLE>"  for "ICDCode1,ICDCode2"
    And Manual codecombination should be DateBanded to the user selected DOSTO "<Dates>" in "<TargetTable>" and for the "<LCD_OR_ARTICLE>" and "<Category_Type>"  for "ICDCode1"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount1 | NewICDCodesCount2 | Category_Type | Category                      | Category2                               | Dates                  | Alert Message1                                | Alert Message2                                                                                                                                         | ManualCodeCombTable  | SupportTables              | WeekNo | ScenarioName | TestDataIDsRange |
  #    | iht_ittest05 | LCD            |                 1 |                 1 | Support       | Support-ValidCodes            | Subsequent_SupportSingle                | 12/10/2018, 12/10/2018 | Code combination(s) are created successfully. | Manual code combination(s) created in the current review are deleted and code combination(s) existing in the target data are date banded successfully. | LCD_MANUAL_CODE_COMB | LCD_CPT_ICD_SPRT_DELTA     | Week2  |              | 80100-80140      |
  #    | iht_ittest05 | LCD            |                 1 |                 1 | Does          | DoesNotSupportOnly-ValidCodes | DoesNotSupportOnly-SubsequentValidCodes | 12/10/2018,12/10/2018  | Code combination(s) are created successfully. | Manual code combination(s) created in the current review are deleted and code combination(s) existing in the target data are date banded successfully. | LCD_MANUAL_CODE_COMB | LCD_CPT_ICD_DONTSPRT_DELTA | Week2  |              | 80100-80140      |
      | iht_ittest05 | Article        |                 1 |                 1 | Support       | Support-ValidCodes            | Subsequent_SupportSingle                | 12/10/2018,12/10/2018  | Code combination(s) are created successfully. | Manual code combination(s) created in the current review are deleted and code combination(s) existing in the target data are date banded successfully. | ART_MANUAL_CODE_COMB | ART_CPT_ICD_SPRT_DELTA     | Week2  |              | 94100-94140      |
      | iht_ittest05 | Article        |                 1 |                 1 | Does          | DoesNotSupportOnly-ValidCodes | DoesNotSupportOnly-SubsequentValidCodes | 12/10/2018,12/10/2018  | Code combination(s) are created successfully. | Manual code combination(s) created in the current review are deleted and code combination(s) existing in the target data are date banded successfully. | ART_MANUAL_CODE_COMB | ART_CPT_ICD_DONTSPRT_DELTA | Week2  |              | 94100-94140      |



  #Take both Support and DoesNot support Updated TestData
        @RegressionJanLater
  Scenario Outline: US37111- Validation of the base ICD code and ICD group- Subsequent Task Weeks - DeleteCombination Check,US37111-TC13298-Scenario1
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code for "<NewICDCodesCount1>","<Category>" for "<LCD_OR_ARTICLE>"
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
    When RA clicks on the "Add/Edit manual code combination" button
    Then RA should be navigated to a screen with two tabs as  "Add Combination" and "Delete Combination"
    When RA clicks on "Delete Combination" Task Tab
    When RA enters date as "<Dates>" in delete combination tab
    Then RA Selects the data grid Checkbox
    When RA clicks on the "Delete Combination" button
    Then the Alert should be displayed with the "<Alert Message2>"
    Then The records should be delted from the "DeleteCombination" Popup
    And Close the Alert Popup
    Then RA Clicks on the "<TabName>"
    Then Manually added "NewICDCode1" should be successfully "Deleted" from UI
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount1 | NewICDCodesCount2 | Category           | Dates      | Alert Message1                                | Alert Message2                                            | TabName        | WeekNo | ScenarioName | TestDataIDsRange |
 #   | iht_ittest05 | LCD            |                 1 |                 1 | Support-ValidCodes | 12/10/2018 | Code combination(s) are created successfully. | The selected combination(s) are successfully date banded. | Support        | Week2  |              | 80100-80140      |
      | iht_ittest05 | Article        |                 1 |                 1 | Support-ValidCodes | 12/10/2018 | Code combination(s) are created successfully. | The selected combination(s) are successfully date banded. | DoesNotSupport | Week2  |              | 94100-94140      |



  #Take both Support and DoesNot support Updated TestData
  @RegressionNov22
  Scenario Outline: US37055,US37058- Validation of the base ICD code and ICD group,Ability to validate if the manually created code is already maintained by CMS source file- Subsequent Task Weeks
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
    When RA Enters the Base ICD Code,ICD Group,New ICD Code on SubsequentTasks for "<NewICDCodesCount2>","<Category>" for "<LCD_OR_ARTICLE>"
    And RA Clicks on "Save" button
    Then the Alert should be displayed with the "<Alert Message2>"
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount1 | NewICDCodesCount2 | Category                 | Alert Message1                                | Alert Message2                                                               | WeekNo | ScenarioName | TestDataIDsRange |
      #| iht_ittest05 | LCD         				   |                 1 |                 1 | Subsequent_SupportSingle   | Code combination(s) are created successfully. | Code combination(s) for the Manual ICD code(s) already exists in the system.                                                                              																												 |  Week2      |              |          80100-80140                             |
      #| iht_ittest05 | LCD           			  |                 1 |                 2 | Subsequent_SupportMultiple | Code combination(s) are created successfully. | Code combination(s) already exists in the system for few of the ICD codes. New manual code combination(s) are successfully created for the new ICD code(s). |       Week2 |              |            80100-80140                        |
      | iht_ittest05 | Article        |                 1 |                 1 | Subsequent_SupportSingle | Code combination(s) are created successfully. | Code combination(s) for the Manual ICD code(s) already exists in the system. | Week2  |              | 94100-94140      |

  #  | iht_ittest05 | Article        						|                 1 |                 2 | Subsequent_SupportMultiple | Code combination(s) are created successfully. | Code combination(s) already exists in the system for few of the ICD codes. New manual code combination(s) are successfully created for the new ICD code(s). |        Week2|              |       94100-94140           									 |
  
  
  
  
  
  ######  ************     THIRD WEEK SCENARIOS  ********  ###########
  
  
  ######    Use 3rd week Manual Code Y37.001A subsequent add Script Data   ####
  @RegressionNov
  Scenario Outline: US37058 - TC13080 - Ability to validate if the manually created code is already maintained by CMS source file
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
    And RA captures the HCPCCodes for "<CategoryType>" and "<LCD_OR_ARTICLE>"
    Then RA takes decisions on CodeCombinations and Completes RA Review
    And Logout of the Application
    And RA Closes the Application
    # Second week Task
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And   Review status should be dispalyed as "Not Started"
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
    #Third week Task
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA Claims Second week task from the GroupTasks tab for "<LCD_OR_ARTICLE>"
    When RA clicks on "Individual" Task Tab
    When RA clicks on SecondWeekTask ID for "<LCD_OR_ARTICLE>"
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    And Manual indicator value should be set to "-1" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "1"
    And Manual indicator value should be set to "0" in the TargetTable for "<LCD_OR_ARTICLE>" for LCDArticleVersion "3"
    And DOSTo should be set to "<DOSToOpenDate>" default date in the target for "<NewICDCode>" and for "<LCD_OR_ARTICLE>" and  for LCDArticleVersion "3"
    Then Manually added codes should be successfully deleted from Manualtable "<ManualCodeCombTable>" for "Support" and for the "<LCD_OR_ARTICLE>"  for "NewICDCode1"   for "ManuallyMaintain" Codecombinations
    And Logout of the Application

    Examples: 
      | User ID      | LCD_OR_ARTICLE | NewICDCodesCount1 | Category           | Dates      | TabName | DOSToOpenDate | NewICDCode | ManualCodeCombTable  | WeekNo | ScenarioName | TestDataIDsRange | CategoryType |
      | iht_ittest05 | LCD            |        1 | Support-ValidCodes | 12/10/2018 | Support | 12/31/9999    | Y37.001A   | LCD_MANUAL_CODE_COMB | Week3  |              |             4514 | Support      |
     #| iht_ittest05 | Article        | 			 1	 	|	Support-ValidCodes | 12/10/2018 |  Support            |  12/31/9999     |     Y37.001A  | ART_MANUAL_CODE_COMB |  Week3  |                         |   95                     | Support        |
