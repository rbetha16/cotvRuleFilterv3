package project.features.steps;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import project.pageobjects.AdminPage;
import project.pageobjects.HomePage;
import project.pageobjects.LoginPage;
import project.pageobjects.RAReviewWorkQueuePage;
import project.utilities.DBQueries;
import project.utilities.DBUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;
import project.feature.steps.definitions.UpdateDatebandingLogicforCPTICDCombinationStepDef;


public class UpdateDatebandingLogicforCPTICDCombinationSteps
{

	@Steps
	UpdateDatebandingLogicforCPTICDCombinationStepDef  oUpdateDatebandingStepDef;
			
	
	@Given("^RA captures OpenDated DOSTo records from Target for \"([^\"]*)\"  for version \"([^\"]*)\"$")
	public void ra_captures_OpenDated_DOSTo_records_from_Target_for_for_version(String sLCD_Article, String sVersion) throws Throwable 
	{
		oUpdateDatebandingStepDef.captureOpendatedRecord(sLCD_Article,sVersion);	   
	}

	@Then("^DOSTo value of the all OpenDated records should be updated according to ReiredDate Dateband Logic for \"([^\"]*)\"   for version \"([^\"]*)\"$")
	public void dosto_value_of_the_all_OpenDated_records_should_be_updated_according_to_ReiredDate_Dateband_Logic_for_for_version(String sLCD_Article, String sVersion) throws Throwable 
	{		
		oUpdateDatebandingStepDef.validateRetiredDate(sLCD_Article,sVersion);	   
	}
	
	
}	





