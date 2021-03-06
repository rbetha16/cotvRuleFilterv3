package project.utilities;

import java.io.FileWriter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ProjectVariables {	

	public static String USER_NAME = "iht_ittest05F";
	public static String PASSWORD = "SWhlYWx0aDEyMw==";
	
	public static String DB_DRIVER_NAME = "oracle.jdbc.OracleDriver";

	//VPMTST1 Connection details
    public static String DB_CONNECTION_URL = "jdbc:Oracle:thin:@vpmtst1.ihtech.com:1521/VPMTST1.iht.com";	
	public static String DB_USERNAME = "LCD";
	public static String DB_PASSWORD = "bGNk";
	
	//VPMAXN DB details
	//public static String DB_CONNECTION_URL =   "jdbc:oracle:thin:@usadelphix03.ihtech.com:1521/VPMMAXN.iht.com";
	//public static String DB_USERNAME = "app_mdm";
	// public static String DB_PASSWORD = "YXBwX21kbQ==";		

	
	//Old JBPM URL
	//public static String  QA_URL = "https://qajbpm.ihealthtechnologies.com/jbpm/#LogInPlace:login";
	
	//New JBPM URL
	public static String  QA_URL = "https://qapolicy.ihtech.com/jbpm/#LogInPlace:login";
	
	
	// Old Production URL
	//public static String  PROD_URL = "https://jbpm.ihealthtechnologies.com/jbpm/#LogInPlace:login";
	
	//New Production URL
	public static String  PROD_URL = "https://prodpolicy.ihtech.com/jbpm/#LogInPlace:login";

	public static String PROD_USER_NAME = "spodugu";	
	public static String PROD_PASSWORD  = "RmVicnVhcnlmZWJAMTQ=";

		
	public static String sRA_Completed_ARTICLE_ID = "SELECT Article_id FROM LCD.Article_CPT_ICD_LINKS WHERE Article_id IN (SELECT Article_id FROM LCD.Article_CPT_ICD_LINKS WHERE support_10 = -1 AND Article_id LIKE '91%' INTERSECT SELECT Article_id FROM LCD.Article_CPT_ICD_LINKS WHERE support_10 = 0 AND Article_id LIKE '91%') AND ROWNUM = 1";
	
	// @ - BROWSER SYNC TIME VARIABLES	
	public static int MAX_TIME_OUT = 10000;

	public static int MID_TIME_OUT = 700;

	public static int MIN_TIME_OUT = 300;
	
	public static int MIN_SLEEP=4000;

	public static int HIGHLIGHT_COUNT = 10;
	
	public static String SelectReasonValue = "Non-configurable-Other";
	
	public static String sRA_Completed_LCD_ID = "Select LCD_id from LCD.LCD_CPT_ICD_LINKS  where lcd_id in (select LCD_ID from LCD.LCD_CPT_ICD_LINKS where supports_10=-1 and lcd_id like '81%' intersect select LCD_ID from LCD.LCD_CPT_ICD_LINKS where supports_10=0 and lcd_id like '81%') and rownum=1";

	public static String Matching_Count = "1 - 1 of 1 items";
	
	public static String sClaimedError_Msg = "Previous Task(s) for this ID is still not completed. This Task cannot be claimed till the review is completed for all the previous weeks review tasks for this LCD/Article ID";
	
	public static String SwitchindRadioErrorMessage="You have unsaved data on the screen. Click on 'Yes' to continue, 'No' to stay on the same screen.";
	
	public static String sReassignedError_Msg = "Previous Task(s) for this ID is still not completed. This Task cannot be reassigned till the review is completed for all the previous week(s) review tasks for this LCD/Article ID";
	
	public static String ReasonCommentText="Auto Test";
	
	public static String  sDirectory = System.getProperty("user.dir");
	
	public static List<JSONObject> execResultList;
	
	public static String sReleaseName = "Apr2019";
	

	public static final String USER_AGENT = "Chrome/70.0";

	public static final String GET_URL = "https://agile.cotiviti.com/rest/api/latest/issue/IV-81726?description";

	public static final String POST_URL = "https://agile.cotiviti.com/rest/api/2/issue";
	
	public static final String GET_Status_URL = "https://agile.cotiviti.com/rest/api/2/issue";

	public static String Zero_Touch_MONGO_SERVER_URL = "10.32.16.168";

	public static int Zero_Touch_MONGO_SERVER_PORT = 27017;


	public static FileWriter file;
	public static String sTargetDataTab_LCD_ID;
	public static String sTargetDataTab_Article_ID;



	public static String Mailheader = "CPT-ICD Execution";

	public static String DownloadedPath = "C:/Users/username/Downloads";

	public static String MailSubject = "CPT-ICD Execution";
 



	}
	

