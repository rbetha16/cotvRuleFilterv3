@Regression
Feature: F6333-Establish Operational Audit Functionality - June Release.feature

  @US24466DynamicFilterforAssigneeonTargetviewAdminshouldhaveRoleofAdminOps
  Scenario Outline: US24466 - Dynamic filter for Assignee on Target view & Admin should have role of AdminOps
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    #	And User should be able click on CPTICDLink-Admin under Adminstration Section
    #And Screen will be opened in a new tab with title CPTICD Links- Admin
    #And User clicks on the "TargetData" tab
    #When User filters by "<Assignees>" for Assignee dropdown
    #When User applies filter on multiple columns and "<AssigneeName>"
    Then Logout of the Application

    Examples: 
      | User ID      | Assignees            | AssigneeName |
      | iht_ittest05 | OneUser:iht_ittest01 | dhasten      |

  @US20931DisplayTargettableData
  Scenario Outline: US20931 - Display Target table Data
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    And Screen will be opened in a new tab with title CPTICD Links- Admin
    #And User clicks on the "TargetData" tab
    Then Expected columns Headers should be displayed in the TargetData screen
    And User captures the DB Count and UI Count of records to validate
    Then Logout of the Application

    Examples: 
      | User ID      |
      | iht_ittest05 |

  @US20932AbilitytoFilterTargetTabledata
  Scenario Outline: US20932-Ability to Filter Target Table data
    When User logs with "<User ID>" as CPT ICD RA into JBPM Application
    And User should be able click on CPTICDLink-Admin under Adminstration Section
    And Screen will be opened in a new tab with title CPTICD Links- Admin
    And User clicks on the "TargetData" tab
    When User applies filter on all the columns in TargetData tab
    Then Logout of the Application

    Examples: 
      | User ID       |
      | iht_ittest05 |

  @US20932AbilitytoSortTargetTabledata
  Scenario Outline: US20932-Ability to Sort Target table data for <Column>
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
    When User should be able click on CPTICDLink-Admin under Adminstration Section
    Then Screen will be opened in a new tab with title CPTICD Links- Admin
    When User clicks on the "TargetData" tab
    And User Sort "<Column>" in the TargetData tab
    Then User should be able to sort "<Column>" in the TargetData tab
    And Logout of the Application

    Examples: 
      | User ID       | Column    |
      #| iht_ittest05F | LCD/Article ID               |
      #| iht_ittest05 | CPT Code |
      #| iht_ittest05 | CPT Group                    |
      #| iht_ittest05 | ICD Code                     |
      #| iht_ittest05 | ICD Group |
      #| iht_ittest05 | Category                     |
      | iht_ittest05F | DOS From                     |
      #| iht_ittest05F | DOS To                       |
      #| iht_ittest05 | Decision                     |
      #| iht_ittest05 | Assignee                     |
      #| iht_ittest05 | Combination Type             |
      #| iht_ittest05 | Jurisdiction                 |
      #| iht_ittest05 | Remarks                      |
      #| iht_ittest05 | Reason For Updating Decision |
