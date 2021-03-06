$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("3.Regression/F6333-Establish Operational Audit Functionality - June Release.feature");
formatter.feature({
  "line": 2,
  "name": "F6333-Establish Operational Audit Functionality - June Release.feature",
  "description": "",
  "id": "f6333-establish-operational-audit-functionality---june-release.feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Regression"
    }
  ]
});
formatter.scenarioOutline({
  "line": 33,
  "name": "US20932-Ability to Filter Target Table data",
  "description": "",
  "id": "f6333-establish-operational-audit-functionality---june-release.feature;us20932-ability-to-filter-target-table-data",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 32,
      "name": "@US20932AbilitytoFilterTargetTabledata"
    }
  ]
});
formatter.step({
  "line": 34,
  "name": "User logs with \"\u003cUser ID\u003e\" as CPT ICD RA into JBPM Application",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "User should be able click on CPTICDLink-Admin under Adminstration Section",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "Screen will be opened in a new tab with title CPTICD Links- Admin",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "User clicks on the \"TargetData\" tab",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "User applies filter on all the columns in TargetData tab",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "Logout of the Application",
  "keyword": "Then "
});
formatter.examples({
  "line": 41,
  "name": "",
  "description": "",
  "id": "f6333-establish-operational-audit-functionality---june-release.feature;us20932-ability-to-filter-target-table-data;",
  "rows": [
    {
      "cells": [
        "User ID"
      ],
      "line": 42,
      "id": "f6333-establish-operational-audit-functionality---june-release.feature;us20932-ability-to-filter-target-table-data;;1"
    },
    {
      "cells": [
        "iht_ittest05"
      ],
      "line": 43,
      "id": "f6333-establish-operational-audit-functionality---june-release.feature;us20932-ability-to-filter-target-table-data;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 43,
  "name": "US20932-Ability to Filter Target Table data",
  "description": "",
  "id": "f6333-establish-operational-audit-functionality---june-release.feature;us20932-ability-to-filter-target-table-data;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 32,
      "name": "@US20932AbilitytoFilterTargetTabledata"
    },
    {
      "line": 1,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 34,
  "name": "User logs with \"iht_ittest05\" as CPT ICD RA into JBPM Application",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "User should be able click on CPTICDLink-Admin under Adminstration Section",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "Screen will be opened in a new tab with title CPTICD Links- Admin",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "User clicks on the \"TargetData\" tab",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "User applies filter on all the columns in TargetData tab",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "Logout of the Application",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "iht_ittest05",
      "offset": 16
    }
  ],
  "location": "CreateProposalSteps.user_logs_with_as_CPT_ICD_RA_into_JBPM_Application(String)"
});
formatter.result({
  "duration": 13636616300,
  "status": "passed"
});
formatter.match({
  "location": "EstablishOperationalAuditFunctionalitySteps.user_should_be_able_click_on_CPTICDLink_Admin_under_Adminstration_Section()"
});
formatter.result({
  "duration": 8165595200,
  "error_message": "net.serenitybdd.core.exceptions.SerenityManagedException: Timed out after 4 seconds. Element not available\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027dev-xd034\u0027, ip: \u002710.130.12.36\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_25\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat net.thucydides.core.annotations.locators.SmartAjaxElementLocator.ajaxFindElement(SmartAjaxElementLocator.java:147)\r\n\tat net.thucydides.core.annotations.locators.SmartAjaxElementLocator.findElement(SmartAjaxElementLocator.java:102)\r\n\tat net.thucydides.core.annotations.locators.AbstractSingleItemHandler.invoke(AbstractSingleItemHandler.java:39)\r\n\tat com.sun.proxy.$Proxy26.getWrappedElement(Unknown Source)\r\n\tat org.openqa.selenium.remote.internal.WebElementToJsonConverter.apply(WebElementToJsonConverter.java:49)\r\n\tat com.google.common.collect.Iterators$8.transform(Iterators.java:799)\r\n\tat com.google.common.collect.TransformedIterator.next(TransformedIterator.java:48)\r\n\tat com.google.common.collect.Iterators.addAll(Iterators.java:362)\r\n\tat com.google.common.collect.Lists.newArrayList(Lists.java:160)\r\n\tat com.google.common.collect.Lists.newArrayList(Lists.java:144)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.executeScript(RemoteWebDriver.java:572)\r\n\tat net.thucydides.core.webdriver.WebDriverFacade.executeScript(WebDriverFacade.java:386)\r\n\tat project.utilities.SeleniumUtils.highlightElement(SeleniumUtils.java:181)\r\n\tat project.utilities.SeleniumUtils.Click_given_WebElement(SeleniumUtils.java:192)\r\n\tat project.pageobjects.HomePage.NavigateToCPTICDAdminLink(HomePage.java:164)\r\n\tat project.feature.steps.definitions.EstablishOperationalAuditFunctionalityStepDef.ClicksOnCPTICDAdminLink(EstablishOperationalAuditFunctionalityStepDef.java:42)\r\n\tat project.feature.steps.definitions.EstablishOperationalAuditFunctionalityStepDef$$EnhancerByCGLIB$$ca76943a.CGLIB$ClicksOnCPTICDAdminLink$0(\u003cgenerated\u003e)\r\n\tat project.feature.steps.definitions.EstablishOperationalAuditFunctionalityStepDef$$EnhancerByCGLIB$$ca76943a$$FastClassByCGLIB$$5438c11e.invoke(\u003cgenerated\u003e)\r\n\tat net.sf.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:228)\r\n\tat net.thucydides.core.steps.StepInterceptor.invokeMethod(StepInterceptor.java:372)\r\n\tat net.thucydides.core.steps.StepInterceptor.executeTestStepMethod(StepInterceptor.java:357)\r\n\tat net.thucydides.core.steps.StepInterceptor.runTestStep(StepInterceptor.java:332)\r\n\tat net.thucydides.core.steps.StepInterceptor.testStepResult(StepInterceptor.java:134)\r\n\tat net.thucydides.core.steps.StepInterceptor.intercept(StepInterceptor.java:61)\r\n\tat project.feature.steps.definitions.EstablishOperationalAuditFunctionalityStepDef$$EnhancerByCGLIB$$ca76943a.ClicksOnCPTICDAdminLink(\u003cgenerated\u003e)\r\n\tat project.features.steps.EstablishOperationalAuditFunctionalitySteps.user_should_be_able_click_on_CPTICDLink_Admin_under_Adminstration_Section(EstablishOperationalAuditFunctionalitySteps.java:15)\r\n\tat ???.And User should be able click on CPTICDLink-Admin under Adminstration Section(3.Regression/F6333-Establish Operational Audit Functionality - June Release.feature:35)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "EstablishOperationalAuditFunctionalitySteps.screen_will_be_opened_in_a_new_tab_with_title_CPTICD_Links_Admin()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "TargetData",
      "offset": 20
    }
  ],
  "location": "EstablishOperationalAuditFunctionalitySteps.user_clicks_on_the_tab(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "EstablishOperationalAuditFunctionalitySteps.user_applies_filter_on_all_the_columns_in_TargetData_tab()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CreateProposalSteps.logout_of_the_Application()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 2038204500,
  "status": "passed"
});
});