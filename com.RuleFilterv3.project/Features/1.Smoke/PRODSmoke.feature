@Smoke @PRODCPTICDLINKSmoke
Feature: Smoke Feature

  @PRODCPTICDLINKSmoke
  Scenario Outline: CPTICDLink Application Smoke  
  Given User logs to "<Environment>" as CPTICDRA into JBPM Application
  When  RA clicks on CPT ICD Link in My Tasks
  Then  RA should able to view the Group/Individual Task screen
  When  RA clicks on "Group" Task Tab    
  Then  Logout of the Application     

    Examples: 
      | User ID      |Environment  |
      | mkollipara   |PROD         |      
      