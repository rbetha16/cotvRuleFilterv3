package project.feature.steps.definitions;

import java.util.ArrayList;
import org.junit.Assert;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import project.pageobjects.AdminPage;
import project.pageobjects.HomePage;
import project.pageobjects.LoginPage;
import project.pageobjects.RAReviewWorkQueuePage;

import project.utilities.DBUtils;

import project.utilities.SeleniumUtils;

public class CreatingNewManuallyMaintainedCombinationsStepDef extends ScenarioSteps {

	private static final long serialVersionUID = 5898280540796957114L;
	org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(CreatingNewManuallyMaintainedCombinationsStepDef.class);

	LoginPage ologinPage;
	HomePage oHomePage;
	SeleniumUtils oSeleniumUtils;
	RAReviewWorkQueuePage oRAPage;
	AdminPage oAdminPage;

	@Step
	public void raEntersManualCombinationData(String sICDGroup, String sCategory, String sNewICDCode) {

		// RA enters new ICD Group
		if (!(sICDGroup.isEmpty())) {
			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sICDGroupTxt, sICDGroup);
			logger.info("RA entered Base ICD Group as '" + sICDGroup);
			Serenity.setSessionVariable("NewICDGroup").to(sICDGroup);
		} else {
			logger.info("ICD Group value is empty");
		}

		// RA selects Category
		if (!(sCategory.isEmpty())) {
			oSeleniumUtils.Click_given_Locator(oRAPage.sCategoryDropDown);
			oSeleniumUtils.select_Given_Value_From_DropDown(oRAPage.sCategoryDropDown, sCategory);
			logger.info("RA selected Category as '" + sCategory);
		} else {
			logger.info("Category value is empty");
		}

		// RA enters new ICD Code
		if (!(sNewICDCode.isEmpty())) {
			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.sICDCodeTxt, sNewICDCode);
			logger.info("RA entered New ICD Code as '" + sNewICDCode);
			Serenity.setSessionVariable("NewICDCode").to(sNewICDCode);
			Serenity.setSessionVariable("NewICDCode3").to(sNewICDCode);
			Serenity.setSessionVariable("NewICDCode1").to(sNewICDCode);
			Serenity.setSessionVariable("NewICDCodeUI").to(sNewICDCode);
		} else {
			oSeleniumUtils.clear_Text(oRAPage.sICDCodeTxt);
			logger.info("New ICD Code value is empty");
		}

	}

	@Step
	public void validateCategoryDropdown(String sCategory) {

		
		if(!sCategory.isEmpty())//Checking if category value is not empty
		{	
			//Checking whether only support Category is selected from drop down by default
			if (oSeleniumUtils.is_WebElement_Displayed(oRAPage.sCategoryDropDownmanuallyMntn))
			{
				String sCategoryValue = oSeleniumUtils.get_TextFrom_Locator(oRAPage.sCategoryDropDownmanuallyMntn);
	
				if (sCategoryValue.equalsIgnoreCase("Support")) {
					logger.info("Category dropdown value selected as Support");
					Assert.assertTrue("Category dropdown value selected as Support", true);
				} else {
					logger.info("Category dropdown value Not selected as Support");
					Assert.assertTrue("Category dropdown value Not selected as Support", false);
				}
			} else {
				logger.info("Category dropdown value is not displayed");
				Assert.assertTrue("Category dropdown value is not displayed", false);
			}
		}
		else
		{
		   logger.info("Categoryvalue is empty");
		   Assert.assertTrue("Categoryvalue is empty", false);
		}
		
		//Checking whether Category drop down is disabled restricting user not able to select any other value apart from Support category
		String sDisbaled = oSeleniumUtils.get_AttributeValueFrom_Locator(oRAPage.sCategoryDropDownmanuallyMntn,"disabled");

		if (sDisbaled.equalsIgnoreCase("true")) {
			logger.info("Category drop down is in disabled mode");
			Assert.assertTrue("Category drop down is in disabled mode", true);
		} else {
			logger.info("Category drop down is not in disabled mode");
			Assert.assertTrue("Category drop down is not in disabled mode", false);
		}

	}

	@Step
	public void ValidateDOSDatesinTarget(String sDOSFromOpenDate, String sDOSToOpenDate, String sNewICDCode,
			String sLCD_Article) throws Exception {
		String sHCPCCodesQuery = "";
		ArrayList<String> HCPCCodes = null;

		switch (sLCD_Article) {
		case "LCD":

			sHCPCCodesQuery = "Select DISTINCT HCPC_code from LCD.LCD_CPT_ICD_LINKS where LCD_ID="
					+ Serenity.sessionVariableCalled("ID");
			HCPCCodes = DBUtils.executeSQLQueryMultipleRows(sHCPCCodesQuery);

			// To retrieve the DOS_FROM and DOS_TO values stored in the DB
			for (int j = 0; j <= HCPCCodes.size() - 1; j++) {
				String sQuery1 = "Select TO_Char(DOS_FROM,'MM/DD/YYYY') from LCD.LCD_CPT_ICD_LINKS where LCD_ID="
						+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + HCPCCodes.get(j) + "'"
						+ " and ICD_CODE='" + sNewICDCode + "'";
				String sDOSFromValue = DBUtils.executeSQLQuery(sQuery1);
				if (sDOSFromValue.compareTo(sDOSFromOpenDate) == 0) {
					logger.info("DOSFrom defaulted to open date:" + sDOSFromOpenDate
							+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j));
					Assert.assertTrue(
							"DOSFrom defaulted to open date:" + sDOSFromOpenDate
									+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j),
							true);
				}

				else {
					logger.info("DOSFrom not defaulted to open date:" + sDOSFromOpenDate
							+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j));
					Assert.assertTrue(
							"DOSFrom not defaulted to open date:" + sDOSFromOpenDate
									+ " when the combinations moved in target for the HCPCCode:" + HCPCCodes.get(j),
							false);
				}

				String sQuery2 = "Select TO_Char(DOS_TO,'MM/DD/YYYY') from LCD.LCD_CPT_ICD_LINKS where LCD_ID="
						+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + HCPCCodes.get(j) + "'"
						+ " and ICD_CODE='" + sNewICDCode + "'";
				String sDOSTOValue = DBUtils.executeSQLQuery(sQuery2);

				if (sDOSTOValue.compareTo(sDOSToOpenDate) == 0) {
					logger.info("DOSTo defaulted to open date:" + sDOSToOpenDate
							+ " when the combinations moved in target for the HCPC code:" + HCPCCodes.get(j));
					Assert.assertTrue(
							"DOSTo defaulted to open date:" + sDOSToOpenDate
									+ " when the combinations moved in target for the HCPC code:" + HCPCCodes.get(j),
							true);
				}

				else {
					Assert.assertTrue(
							"DOSTo not defaulted to open date:" + sDOSToOpenDate
									+ " when the combinations moved in target for the HCPC code:" + HCPCCodes.get(j),
							false);
					logger.info("DOSTo not defaulted to open date:" + sDOSToOpenDate
							+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j));
				}

			}

			break;

		case "Article":

			sHCPCCodesQuery = "Select DISTINCT HCPC_code from LCD.ARTICLE_CPT_ICD_LINKS where ARTICLE_ID="
					+ Serenity.sessionVariableCalled("ID");
			HCPCCodes = DBUtils.executeSQLQueryMultipleRows(sHCPCCodesQuery);

			// To retrieve the DOS_FROM and DOS_TO values stored in the DB
			for (int j = 0; j <= HCPCCodes.size() - 1; j++) {
				String sQuery1 = "Select TO_CHAR(DOS_FROM,'MM/DD/YYYY') from LCD.ARTICLE_CPT_ICD_LINKS where ARTICLE_ID="
						+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + HCPCCodes.get(j) + "'"
						+ " and ICD_CODE='" + sNewICDCode + "'";
				String sDOSFromValue = DBUtils.executeSQLQuery(sQuery1);
				if (sDOSFromValue.compareTo(sDOSFromOpenDate) == 0) {
					logger.info("DOSFrom defaulted to open date:" + sDOSFromOpenDate
							+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j));
					Assert.assertTrue(
							"DOSFrom defaulted to open date:" + sDOSFromOpenDate
									+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j),
							true);
				}

				else {
					logger.info("DOSFrom not defaulted to open date:" + sDOSFromOpenDate
							+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j));
					Assert.assertTrue(
							"DOSFrom not defaulted to open date:" + sDOSFromOpenDate
									+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j),
							false);
				}

				String sQuery2 = "Select TO_Char(DOS_TO,'MM/DD/YYYY') from LCD.ARTICLE_CPT_ICD_LINKS where ARTICLE_ID="
						+ Serenity.sessionVariableCalled("ID") + " and HCPC_CODE='" + HCPCCodes.get(j) + "'"
						+ " and ICD_CODE='" + sNewICDCode + "'";
				String sDOSTOValue = DBUtils.executeSQLQuery(sQuery2);

				if (sDOSTOValue.compareTo(sDOSToOpenDate) == 0) {
					logger.info("DOSTo defaulted to open date:" + sDOSToOpenDate
							+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j));
					Assert.assertTrue(
							"DOSTo defaulted to open date:" + sDOSToOpenDate
									+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j),
							true);
				}

				else {
					logger.info("DOSTo not defaulted to open date:" + sDOSToOpenDate
							+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j));
					Assert.assertTrue(
							"DOSTo not defaulted to open date:" + sDOSToOpenDate
									+ " when the combinations moved in target or the HCPC code:" + HCPCCodes.get(j),
							false);
				}

			} // end of for

			break;

		default:
			logger.info("No input is provided for the Switch Case");
			Assert.assertTrue("Provided invalid case value", false);
		}

	}

	@Step
	public void raEntersNewICDCodes(String sICDCode, String count) {
		int iLoopCount=0;

		//Checking if the Count passed is empty  
		if (!count.isEmpty())
		{	
		  iLoopCount = Integer.parseInt(count); //Extracting integer from the String
		} 
		else 
		{
		  logger.info("Count-No of times to add ICD Code value is empty");		  
		 }

		//Checking if the ICD code passed is empty  
		if (!sICDCode.isEmpty()) 
		{
			for (int j = 1; j <= iLoopCount; j++)  //entering value in the ICD Code filed
			{
			  oSeleniumUtils.enter_given_text_StringLocator("(" + oRAPage.sICDCodeTxt + ")[" + (j + 1) + "]",						sICDCode);
			  logger.info("RA entered ICD Code as '" + sICDCode);
			}
		} 
		else 
		{
		  logger.info("New ICD Code is empty");		 
		}

	}
	
	@Step
	public void raValidatesManuallyAddedICDCode(String sHCPCCode, String sICDCode){
		
		// RA enters new HCPCCode 
		if (!(sHCPCCode.isEmpty()) && (oSeleniumUtils.is_WebElement_Displayed(oRAPage.CptCodeTextBox))) {
			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.CptCodeTextBox, sHCPCCode);
			logger.info("RA entered HCPC code as '" + sHCPCCode);
			Serenity.setSessionVariable("HCPCCode").to(sHCPCCode);
		} else {
			logger.info("HCPC Code value is empty or CPT code text box is not displayed");
			Assert.assertTrue("CPT code text box is not displayed", false);
		}
		
		// RA enters new ICDCode 
		if (!(sICDCode.isEmpty()) && (oSeleniumUtils.is_WebElement_Displayed(oRAPage.ICDCodeTextBoxNew))){
			oSeleniumUtils.enter_given_text_StringLocator(oRAPage.ICDCodeTextBoxNew, sICDCode);
			logger.info("RA entered ICD code as '" + sICDCode);
			Serenity.setSessionVariable("ICDCode").to(sICDCode);
		} else {
			logger.info("ICD Code value is empty or ICD code text box is not displayed");
			Assert.assertTrue("ICD code text box is not displayed", false);
		}
		
		if(oRAPage.ApplyFilter_Btn.isVisible()){	
		oSeleniumUtils.Click_given_WebElement(oRAPage.ApplyFilter_Btn);
		logger.info("Apply filter button is clicked successfully");
		}
		else
		{
			logger.info("Apply filter button is not displayed");
			Assert.assertTrue("apply filter button is not displayed", false);
		}
		
		
		if(oSeleniumUtils.is_WebElement_Displayed(oRAPage.RAPageCombinationType_Text)){	
			String sCombinationTypeValue = oSeleniumUtils.get_TextFrom_Locator(oRAPage.RAPageCombinationType_Text);
			if (sCombinationTypeValue.trim().equalsIgnoreCase("Manual")) {
				logger.info("Combination type as Manual is verified successfully");
				Assert.assertTrue("Combination type updated as Manual", true);
			} else {
				logger.info("Combination type is not captured as Manual");
				Assert.assertTrue("Combination type is not updated as Manual", false);
			}
		}
		else
		{
			logger.info("Combination type text box is not displayed");
			Assert.assertTrue("Combination type is not displayed", false);
		}
		
		if(oRAPage.ClearAllFilters_Btn.isVisible()){	
			oSeleniumUtils.Click_given_WebElement(oRAPage.ClearAllFilters_Btn);
			logger.info("Clear All filters button is clicked successfully");
		}
		else
		{
			logger.info("Clear All filters button is not displayed");
		}
		
	}

}// End Of Class
