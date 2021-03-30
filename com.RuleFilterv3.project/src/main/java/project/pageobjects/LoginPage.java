package project.pageobjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import project.utilities.GenericUtils;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;


public class LoginPage extends PageObject {
	
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoginPage.class);
	
	@FindBy(xpath = "//label[text()='User Name :']/../following-sibling::td//input")
	public WebElementFacade UserName_Txt;
	
	@FindBy(xpath = "//label[text()='Password :']/../following-sibling::td//input")
	public WebElementFacade Password_Txt;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	public WebElementFacade Login_Btn;
	
	@FindBy(xpath = "//a[text()='Task Management']")
	public WebElementFacade JBPMHomePage;
	
	@FindBy(xpath = "//button[text()='Sign Out']")
	public WebElementFacade Logout;
	
	@WhenPageOpens
	public void LoginPageValidation()
	{		
		UserName_Txt.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible();	
	}
				
	public boolean loginToCPTICDLink(String sUserName) {
		/*'********************************************************************************************************************
		'
		' @ Function Name   		:  LOGIN
		' @ Parameters      		:  NA
		' @ Return Type				:  Boolean
		' @ Project Variables       :  loAppUsername, loAppPassword
		' @ Description     		:  This Function will provide UserName and password and clicks Sign-In button and validate the Home
		'                      			page of JBPM Home Application is displayed
		' @ Exception Handling 		: This function will exit when object under test is not visible on the Application uder test and 
		'                        		and returns 'FAIL" flag
		' @ Created By      		:  
		' @ Created Date    		:  
		' @ Modified By     		: 
		' @ Modified Date   		:  
		'*********************************************************************************************************************/
		getDriver().manage().window().maximize();
		
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		Serenity.setSessionVariable("UserName").to(sUserName);		
		enterLoginCredentials(sUserName,GenericUtils.decode(ProjectVariables.PASSWORD));
		logger.info("Password entered successfully");		
		oSeleniumUtils.Click_given_WebElement(Login_Btn);
		logger.info("Login Button clicked successfully.");
		return JBPMHomePage.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().isDisplayed();
		
	}
		
	public boolean signoutCPTICDLink() {
		
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);			
		SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);		
		oSeleniumUtils.switchWindowUsingWindowCount(100,1);			
		oSeleniumUtils.Click_given_WebElement(Logout);		
		SeleniumUtils.defaultWait(ProjectVariables.MIN_SLEEP);
		return Login_Btn.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().isDisplayed();				
	    }

	public boolean loginToCPTICDLinkSmokeTest(String arg1) {
		
	String sEnvironment;		    
	sEnvironment = arg1;
	
	Serenity.setSessionVariable("Environment").to(sEnvironment);	
	open();	
	getDriver().manage().window().maximize();
	SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
	switch(sEnvironment){
		
		case "QA":	
			Serenity.setSessionVariable("UserName").to(ProjectVariables.USER_NAME);
			getDriver().navigate().to(ProjectVariables.QA_URL);			
			enterLoginCredentials(ProjectVariables.USER_NAME,GenericUtils.decode(ProjectVariables.PASSWORD));					
			break;
			
		case "PROD":
			Serenity.setSessionVariable("UserName").to(ProjectVariables.PROD_USER_NAME);
			getDriver().navigate().to(ProjectVariables.PROD_URL);			
			enterLoginCredentials(ProjectVariables.PROD_USER_NAME,GenericUtils.decode(ProjectVariables.PROD_PASSWORD));			
			break;			
	}
	
	oSeleniumUtils.Click_given_WebElement(Login_Btn);	
	return JBPMHomePage.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().isDisplayed();
}	
		
	public void enterLoginCredentials(String sUsername,String sPassword) 
	{				
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		
	    //Enter User name
		oSeleniumUtils.highlightElement(UserName_Txt);
		UserName_Txt.clear();
		UserName_Txt.sendKeys(sUsername);
		logger.info("User Name entered successfully :"+sUsername);
		
		//Enter Password
		oSeleniumUtils.highlightElement(Password_Txt);        
		Password_Txt.clear();
		Password_Txt.sendKeys(sPassword);	
	
		
	 }	
	

		
	}

