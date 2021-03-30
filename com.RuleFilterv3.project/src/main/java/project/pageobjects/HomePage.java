package project.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import project.utilities.ProjectVariables;
import project.utilities.SeleniumUtils;


public class HomePage extends PageObject {
			
	@FindBy(xpath = "//h1[contains(text(), 'CPT ICD Link')]")
	public WebElementFacade CPTICDLinkHomePage;
	
	@FindBy(xpath = "//a[text()='CPT ICD Link']")
	public WebElementFacade CPTICDLink;	
		
	@FindBy(xpath = "//a[text()='CPT ICD Link - Admin']")
	public WebElementFacade CPTICDLinkAdmin;	
	
	@FindBy(id ="dropdownlistArrowlcdOrArticle")
	public WebElementFacade LCDArticleDropdown;
	
	@FindBy(id ="dropdownlistContentrequestReview")
	public WebElementFacade RequestReview_Cmb;
	
	@FindBy(xpath = "//input[@ng-model='rowEntity.lcdId']")
	public WebElementFacade RequestReview_LCD_ID;
	
	public String Submit_Btn = "//div[@class='modal-footer']/button";
	
	@FindBy(xpath = "//div[@id='dropdownlistArrowngxDropDownList7']")
	public WebElementFacade TaskAssignedWeekDropDown;
	
	@FindBy(xpath = "//div[@id='dropdownlistArrowngxDropDownList0']")
	public WebElementFacade StatusDropDown;
		
	@FindBy(xpath = "//li[text()='Review Status :']/following-sibling::li/b)]")
	public WebElementFacade Review_Status;	
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn-primary Request LCD/Article for Review pull-right']")
	public WebElementFacade Request_LCD_Article_For_Review_Btn;
	
	public String LCD_VALUE =  "//div[@id='listitem0innerListBoxrequestReview']";
	 
	public String ARTICLE_VALUE =  "//div[@id='listitem1innerListBoxrequestReview']";
	 	 
	@FindBy(xpath = "(//input[@ng-model='colFilter.term'])[1]")
	public WebElementFacade ID_Txt;
	
	@FindBy(xpath = "(//i[@aria-label='Remove Filter'])[1]")
	public WebElementFacade Remove_Filter;
	
	@FindBy(xpath = "//div[@row-render-index='rowRenderIndex']/div/div/div/div")
	public WebElementFacade ID_Checkbox;	
	
	@FindBy(xpath = "//a[@ng-click='claimTask()']")
	public WebElementFacade ClaimTask_Btn;	
	
	@FindBy(xpath = "//div[text()='Loading Rules ...' or text()='Loading...' or text()='Please Wait' or text()='Retrieving interpretive update role users ...'] | //span[text()='Progress']")
	public WebElementFacade Loading;
	
	public String AnchorTags = "//a[contains(text(),'sValue')]";
	
	public String CPTICDLinkTaskTblColumnTxt = "//span[text()='sColumnName']/ancestor::div[@role='columnheader']//input";
	
	public String LCDCheckBox = "//div[@id='listitem0innerListBoxlcdOrArticle']";
	
	public String ArticleCheckBox = "//div[@id='listitem1innerListBoxlcdOrArticle']";
	
	public String AdminSection = "//span[contains(text(),'Administration')]";

	public String DivTages = "//div[text()='sValue']";
	
	public String IndividualTaskTab = "//a[contains(text(),'Individual')]";
		
	public String GroupTaskTab = "//a[contains(text(),'Group')]";
	
	public String SpanText = "//span[text()='sValue']";
	
	public String ButtonTag = "//button[contains(text(),'sValue')]";

	public String sPageLoading = "//div[@id='spinner' and @class='ng-hide']";	
	
	@FindBy(xpath = "//h1[contains(text(),'CPT ICD Link-Admin']")
	public WebElementFacade AdminPageTitle;	

	@FindBy(xpath = "//div[@class='modal-dialog modal-sm']/div")
	public WebElementFacade Alert_PopUp;
	
	public String sAlertPopupMsg = "//div[contains(@class,'modal-body')]";
	
	public String sAlertPopupOKBtn = "//div[@class='modal-footer']/button[text()='OK']";
	
	public String sAlertPopupOKYes = "//div[@class='modal-footer']/button[text()='Yes']";
	
	public String sAlertPopupOKNo = "//div[@class='modal-footer']/button[text()='No']";
	
	public String sWindowProptOKButton = "//div[@class=' x-window-plain x-window-dlg x-window x-component']//button[text()='OK']";
	
	public String sAttributeName = "aria-label";

	public String closeTabs = "//a[@class='x-tab-strip-close']";

	public String LCDRequestButton="//a[contains(@class,'Request LCD/Article for Review')]";

	public String LCDReviewArticlePopUp="//h4[text()='Request LCD/Article for Review']";

	public String LCDDropDownListArrow="//div[@id='dropdownlistArrowrequestReview']";

	public String CodeType="//div[contains(@id,'innerListBoxrequestReview')]//span[text()='sValue']";

	public String LCDArticleTextbox="//label[contains(text(),'Enter LCD/Article')]/parent::div/child::div//input";
	
	public boolean NavigateToCPTICDLink(){
		
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		
		oSeleniumUtils.Click_given_WebElement(CPTICDLink);		
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);		
    	SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);	
		
		if(Serenity.sessionVariableCalled("UserName").toString().equalsIgnoreCase("iht_ittest03")){						
			return true;
		}else{
		
		oSeleniumUtils.switchWindowUsingWindowCount(100,2);
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(AnchorTags, "sValue","Individual"));
		return CPTICDLinkHomePage.withTimeoutOf(ProjectVariables.MID_TIME_OUT,TimeUnit.SECONDS).waitUntilVisible().isDisplayed();		
		}
	}

	public boolean ClicksOnGroupTasks() {
		
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
		
		oSeleniumUtils.Click_given_Locator(StringUtils.replace(AnchorTags, "sValue","Group"));
		
		return CPTICDLinkHomePage.withTimeoutOf(ProjectVariables.MIN_TIME_OUT,TimeUnit.SECONDS).waitUntilVisible().isDisplayed();		
			
	}

	public boolean NavigateToCPTICDAdminLink()  {
		
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		
		SeleniumUtils oSeleniumUtils = this.switchToPage(SeleniumUtils.class);
			
		oSeleniumUtils.Click_given_Locator(AdminSection);

		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

		oSeleniumUtils.Click_given_WebElement(CPTICDLinkAdmin);
		
		SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
		
		oSeleniumUtils.switchWindowUsingWindowCount(100,2);
		
		WaitUntilPageLoad(sPageLoading);
		
		return true;
	}
	
	public void WaitUntilPageLoad(String sXPath)
	{
		
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);
		boolean bPageStatus = false;
		int iCount;
		int iLoopCount=0;
		
		SeleniumUtils.defaultWait(2000);	
		
		do{
			iCount = getDriver().findElements(By.xpath(sXPath)).size();
			if(iCount >= 1){
				bPageStatus = true;
			}else{
				SeleniumUtils.defaultWait(ProjectVariables.MAX_TIME_OUT);
				iLoopCount= iLoopCount + 1;
			}
		}while((!bPageStatus) && (iLoopCount<=180000));
		
		if (iLoopCount>180000)
		{		
			System.out.println("The expected Page is not yet loaded");
			getDriver().quit();
		}
		
	}

	public void closeApplication() {

		//Close the Application 
		Set<String> s1 = getDriver().getWindowHandles();
		// Now we will iterate using Iterator
		Iterator<String> I1 = s1.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();
			getDriver().switchTo().window(child_window);
			System.out.println(getDriver().switchTo().window(child_window).getTitle());
			getDriver().close();
			
		}
	
		
	}
	
	public void closeAllTabs() {

		getDriver().switchTo().defaultContent();

		List<WebElement> iCloseTabs = getDriver().findElements(By.xpath(closeTabs));

		for (int i = 1; i < iCloseTabs.size(); i++) {

			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);

			iCloseTabs.get(i).click();

		}

	}
	
	public void waitUntil_Loading_Dailog_Disappears(WebElementFacade element) {

		do {
			SeleniumUtils.defaultWait(ProjectVariables.MIN_TIME_OUT);
		} while (element.isVisible());
		SeleniumUtils.defaultWait(ProjectVariables.MID_TIME_OUT);

	}

	
}
