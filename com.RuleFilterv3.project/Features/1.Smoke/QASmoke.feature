@Smoke @QACPTICDLINKSmoke
Feature: Smoke Feature


  @QACPTICDLINKSmoke
  Scenario Outline: CPTICDLink Application Sample2  
  Given User logs to "<Environment>" as CPTICDRA into JBPM Application
  When  RA clicks on CPT ICD Link in My Tasks
  Then  RA should able to view the Group/Individual Task screen
  When  RA clicks on "Group" Task Tab  
  When  RA clicks on "Group" Task Tab  
  When  RA clicks on "Group" Task Tab    
  Then  Logout of the Application     

    Examples: 
      | User ID      |Environment|
      | iht_ittest05 |QA         |
       
      