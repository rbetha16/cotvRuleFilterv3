package project.utilities;

import net.serenitybdd.core.Serenity;

public class DBQueries {	

//SQL Query to retrieve LCD ID from the DB  	
public static String LCD_ID_Query = "Select * from (Select LCD_ID from (Select lcd_id from LCD.LCD_REVIEW_TASK where  LCD_ID like '801%' and task_status_key=1 and user_id is null and \r\n" + 

"LCD_ID NOT in(Select LCD_ID from LCD.LCD_REVIEW_TASK GROUP BY LCD_ID HAVING COUNT(lcd_id) > 1 ))) where rownum=1";

//SQL Query to retrieve Article ID from the DB
public static String ArticleQuery = "Select * from (Select Art_ID from (Select Art_ID from LCD.ART_REVIEW_TASK where  Art_ID like '90%' and task_status_key=1 and user_id is null\r\n" + 
									" and art_ID NOT in(Select ART_ID from LCD.ART_REVIEW_TASK GROUP BY ART_ID HAVING COUNT(ART_id) > 1 ))) where rownum=1";	



public static String MultipleWeek_LCDID_Query = " Select * from (SELECT LCD_ID \r\n" + 
												" FROM LCD.LCD_REVIEW_TASK\r\n" + 
												" WHERE user_id IS NULL AND TASK_STATUS_KEY = 1 and LCD_ID like '4%'\r\n" + 
												" GROUP BY LCD_ID, TASK_STATUS_KEY\r\n" + 
												" HAVING COUNT (*) >=2) where rownum=1";


public static String MultipleWeek_Article_Query =  " SELECT * FROM (  SELECT Art_ID, TASK_STATUS_KEY, COUNT (*)\r\n" +
												  " FROM LCD.ART_REVIEW_TASK \r\n" +
												  " WHERE user_id IS NULL AND TASK_STATUS_KEY = 1 AND Art_ID LIKE '95%'\r\n" +
												   " GROUP BY Art_ID, TASK_STATUS_KEY \r\n" +
													" HAVING COUNT (*) >= 2)  WHERE ROWNUM = 1";



public static String ThreeWeek_LCDID_Query = " Select * from (SELECT LCD_ID \r\n" + 
		" FROM LCD.LCD_REVIEW_TASK\r\n" + 
		" WHERE user_id IS NULL AND TASK_STATUS_KEY = 1 and LCD_ID like '404%'\r\n" + 
		" GROUP BY LCD_ID, TASK_STATUS_KEY\r\n" + 
		" HAVING COUNT (*) >=3) where rownum=1";


public static String ThreeWeek_Article_Query =  " SELECT * FROM (  SELECT Art_ID, TASK_STATUS_KEY, COUNT (*)\r\n" +
		  " FROM LCD.ART_REVIEW_TASK \r\n" +
		  " WHERE user_id IS NULL AND TASK_STATUS_KEY = 1 AND Art_ID LIKE '961%'\r\n" +
		   " GROUP BY Art_ID, TASK_STATUS_KEY \r\n" +
			" HAVING COUNT (*) >= 3)  WHERE ROWNUM = 1";

public static String sAllItemsCount_Admin_TargetTab_Query_LCD_Article= "Select count(*) from (SELECT * FROM LCD.LCD_CPT_ICD_LINKS UNION  SELECT * FROM LCD.ARTICLE_CPT_ICD_LINKS)";

public static String sAllItemsCount_Admin_All_Assignee_Query="Select count(*) from (SELECT * FROM LCD.LCD_CPT_ICD_LINKS UNION "+
															 " SELECT * FROM LCD.ARTICLE_CPT_ICD_LINKS "+
															 "	Where DECISION_USER in(SELECT distinct DECISION_USER AS ASSIGNEE FROM LCD.LCD_CPT_ICD_LINKS "+
														      " UNION  SELECT distinct DECISION_USER AS ASSIGNEE FROM LCD.ARTICLE_CPT_ICD_LINKS ))";

public static String sAllItemsCount_Admin_All_Assignee_Count_Query= "Select count(*) from (SELECT distinct DECISION_USER AS ASSIGNEE FROM LCD.LCD_CPT_ICD_LINKS "+
																" Union SELECT distinct DECISION_USER AS ASSIGNEE FROM LCD.ARTICLE_CPT_ICD_LINKS)";

public static String sAdminTargetTabAssigneeNames = "SELECT distinct DECISION_USER AS ASSIGNEE FROM LCD.LCD_CPT_ICD_LINKS "+
												" Union SELECT distinct DECISION_USER AS ASSIGNEE FROM LCD.ARTICLE_CPT_ICD_LINKS";

public String SupportRemarksCountQuery = "select count(*) from (Select Remarks from LCD.LCD_CPT_ICD_SPRT_DELTA"
		+ " where LCD_ID="+Serenity.sessionVariableCalled("LCD_ID").toString()+" and Remarks='"+Serenity.sessionVariableCalled("Remarks")+"')";

public String SupportBlankRemarksCountQuery = "select count(*) from (Select Remarks from LCD.LCD_CPT_ICD_SPRT_DELTA"
		+ " where LCD_ID="+Serenity.sessionVariableCalled("LCD_ID").toString()+" and Remarks is null) ";

public static String sAdminTargetTabAssigneeFilterDBCount = "Select count(*) from (SELECT * FROM LCD.LCD_CPT_ICD_LINKS where DECISION_USER in("+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser1")+"'"+","+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser2")+"'"+","+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser3")+"'"+") UNION "
															+" SELECT * FROM LCD.ARTICLE_CPT_ICD_LINKS where DECISION_USER in("+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser1")+"'"+","+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser2")+"'"+","+"'"+Serenity.sessionVariableCalled("AdminAssigneeUser3")+"'"+"))";

public String DoesNotSupportRemarksCountQuery = "select count(*) from (Select Remarks from LCD.LCD_CPT_ICD_DONTSPRT_DELTA"
		+ " where LCD_ID="+Serenity.sessionVariableCalled("LCD_ID").toString()+" and Remarks='"+Serenity.sessionVariableCalled("Remarks")+"')";

public String DoesNotSupportBlankRemarksCountQuery = "select count(*) from (Select Remarks from LCD.LCD_CPT_ICD_DONTSPRT_DELTA"
		+ " where LCD_ID="+Serenity.sessionVariableCalled("LCD_ID").toString()+" and Remarks is null) ";

public static String sAdminTargetTabAssigneeFilterSingleUser = "Select count(*) from (SELECT * FROM LCD.LCD_CPT_ICD_LINKS where DECISION_USER ="+"'"+ Serenity.sessionVariableCalled("AdminAssigneeOneUser")+"'"+" UNION "+ 
																" SELECT * FROM LCD.ARTICLE_CPT_ICD_LINKS where DECISION_USER ="+"'"+Serenity.sessionVariableCalled("AdminAssigneeOneUser")+"'"+")";

public static String  sAdminMultipleQueryCount = "Select count(*) from (Select * FROM LCD.LCD_CPT_ICD_LINKS  where LCD_ID =32553 and HCPC_CODE_GROUP=1)";

public static String  sAdminMultipleFiltersCountQuery = "Select count(*) from (Select * FROM LCD.LCD_CPT_ICD_LINKS  where LCD_ID = "+Serenity.sessionVariableCalled("CMSID")+" and HCPC_CODE="+"'"+Serenity.sessionVariableCalled("CPTCode")+"'"+" "
+ "and HCPC_CODE_GROUP="+Serenity.sessionVariableCalled("CPTCodeGroup")+" and ICD_CODE like "+ "'"+Serenity.sessionVariableCalled("ICDCode")+"%"+"'"+" and ICD_GROUP="+Serenity.sessionVariableCalled("ICDCodeGroup")+" "
+ "and To_Char(DOS_FROM,'MM/DD/YYYY') ="+"'"+Serenity.sessionVariableCalled("DOSFrom")+"'"+" and To_Char(DOS_TO,'MM/DD/YYYY')="+"'"+Serenity.sessionVariableCalled("DOSTo")+"'"+" "
		+ "and SUPPORTS_10="+Serenity.sessionVariableCalled("Category")+" and appropriate_10="+Serenity.sessionVariableCalled("DecisionVal")+")";	


public static String  sAdminMultipleFiltersAssigneeCountQuery = "Select count(*) from (Select * FROM LCD.LCD_CPT_ICD_LINKS  where LCD_ID = "+Serenity.sessionVariableCalled("CMSID")+" and HCPC_CODE="+"'"+Serenity.sessionVariableCalled("CPTCode")+"'"+" "
+ "and HCPC_CODE_GROUP="+Serenity.sessionVariableCalled("CPTCodeGroup")+" and ICD_CODE like "+ "'"+Serenity.sessionVariableCalled("ICDCode")+"%"+"'"+" and ICD_GROUP="+Serenity.sessionVariableCalled("ICDCodeGroup")+" "
+ "and To_Char(DOS_FROM,'MM/DD/YYYY') ="+"'"+Serenity.sessionVariableCalled("DOSFrom")+"'"+" and To_Char(DOS_TO,'MM/DD/YYYY')="+"'"+Serenity.sessionVariableCalled("DOSTo")+"'"+" "
		+ "and SUPPORTS_10="+Serenity.sessionVariableCalled("Category")+" and appropriate_10="+Serenity.sessionVariableCalled("DecisionVal")+" and DECISION_USER = "+"'"+Serenity.sessionVariableCalled("AdminAssigneeOneUser")+"'"+")";	




public static String  sAdminMultipleFiltersQuery = "Select * FROM LCD.LCD_CPT_ICD_LINKS  where LCD_ID = "+Serenity.sessionVariableCalled("CMSID")+" and HCPC_CODE="+"'"+Serenity.sessionVariableCalled("CPTCode")+"'"+" "
+ "and HCPC_CODE_GROUP="+Serenity.sessionVariableCalled("CPTCodeGroup")+" and ICD_CODE like "+ "'"+Serenity.sessionVariableCalled("ICDCode")+"%"+"'"+" and ICD_GROUP="+Serenity.sessionVariableCalled("ICDCodeGroup")+" "
+ "and To_Char(DOS_FROM,'MM/DD/YYYY') ="+"'"+Serenity.sessionVariableCalled("DOSFrom")+"'"+" and To_Char(DOS_TO,'MM/DD/YYYY')="+"'"+Serenity.sessionVariableCalled("DOSTo")+"'"+" "
		+ "and SUPPORTS_10="+Serenity.sessionVariableCalled("Category")+" and appropriate_10="+Serenity.sessionVariableCalled("DecisionVal");	


public static String sSupportTabCodeCombDBCount =  "Select count(*) from (Select * from LCD.LCD_CPT_ICD_SPRT_DELTA where LCD_ID="+Serenity.sessionVariableCalled("LCD_ID")+")";

public static String sDoesNotSupportTabCodeCombDBCount =  "Select count(*) from (Select * from LCD.LCD_CPT_ICD_DONTSPRT_DELTA where LCD_ID="+Serenity.sessionVariableCalled("LCD_ID")+")";

//============================================================================================================================

public static String sGroupTasksItmesQuery = "Select count(*) from (select * from LCD.LCD_REVIEW_TASK where user_id  is null "
		+ "union Select * from LCD.ART_REVIEW_TASK where user_id  is null)";


public static String  sAdminTarget_LCDQuery = "Select lcd_id from LCD.LCD_CPT_ICD_LINKS where rownum=1";

public static String  sAdminTarget_ArticleQuery = "Select article_id from LCD.ARTICLE_CPT_ICD_LINKS where rownum=1";

public static String  sAdminTarget_HCPCCPTCodeQuery = "Select HCPC_CODE from LCD.LCD_CPT_ICD_LINKS where rownum=1";

public static String  sAdminTarget_HCPCCPTGrpQuery = "Select HCPC_CODE_GROUP from LCD.LCD_CPT_ICD_LINKS where rownum=1";

public static String  sAdminTarget_ICDCodeQuery = "Select ICD_CODE from LCD.LCD_CPT_ICD_LINKS where rownum=1";

public  String  sAdminTarget_LCD_Count_Qry= "Select count(*) from (Select * from LCD.LCD_CPT_ICD_LINKS where lcd_id="+Serenity.sessionVariableCalled("Test_LCD_ID")+")";








}
