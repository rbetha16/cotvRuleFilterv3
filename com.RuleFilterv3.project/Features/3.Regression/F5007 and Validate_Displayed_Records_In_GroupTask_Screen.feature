#Author: jaganmohan.appagari
@RegressionDec28
Feature: Validate Displayed Records in Group task screen.

  # TC6711 and TC6712 (There is no User Story mapping for this Test case in Agile Central).
  #########################################################################################################################
  

  ####*** PreRequisite:-  For iht_ittest03  User remove the role CPT-ICD-RA in the "Assignment Configuration" screen  
  @RegressionJan7
  Scenario Outline: TC7681(US14280,Feature-F5007)-Display records in Group Task screen,TC6711 Validate Displayed Records in Group Task Screen
    Given User logs with "<CPT-ICD RA>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Individual" Task Tab
     And RA clicks on "Group" Task Tab
    Then RA should able to view Review tasks in Group Task screen
    And Logout of the Application
    Given User logs with "<With_Out_CPT-ICD RA>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    Then RA should not able to view Review tasks

    Examples: 
      | CPT-ICD RA   | With_Out_CPT-ICD RA |
      | iht_ittest05 | iht_ittest03        |


 @RegressionJan7
  Scenario Outline: TC6712 Ability to generate a proposal for RA Review of Code combinations
    Given User logs with "<CPT-ICD RA>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA claims a LCD code from group Tasks
    When RA clicks on "Individual" Task Tab
    Then Claimed LCD code should be displayed with status as "Not Started"
    And Claimed LCD code should be displayed in queue for RA
    And Logout of the Application
    Given User logs with "<Other_CPT-ICD RA>" as CPT ICD RA into JBPM Application
    When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Individual" Task Tab
    Then RA should not be able to view other RA Claimed tasks
    And Logout of the Application

    Examples: 
      | CPT-ICD RA   | Other_CPT-ICD RA |
      | iht_ittest05 | iht_ittest02     |
