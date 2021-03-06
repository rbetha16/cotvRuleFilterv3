package project.utilities;

import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.bson.Document;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//import org.json.simple.*;

public class GenericUtils {

	public static String getDate_given_Format() {
		// String element = DA_PROJ_OR.LAST_SEARCH_TIME;
		String sExpectedTime = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		String[] words = sExpectedTime.split("\\s");
		System.out.println("System Date-->:- " + words[0]);

		String sExpectedDate = words[0];

		return sExpectedDate;
	}

	public static int generate_Random_Number_for_Given_Range(int range) {
		Random rand = new Random();
		int value = rand.nextInt(range);
		return value;
	}

	public static String decode(String value) {
		byte[] decodedValue = null;
		try {
			decodedValue = Base64.getDecoder().decode(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new String(decodedValue, StandardCharsets.UTF_8);
	}

	public static void sendEmail() {
		try {
			Email email = new SimpleEmail();
			email.setHostName("ihtmail.ihealthtechnologies.com");
			email.setSmtpPort(25);
			email.setAuthenticator(new DefaultAuthenticator("nkatari", ""));
			email.setSSLOnConnect(false);
			email.setFrom("neelima.katari@cotiviti.com");
			email.setSubject("ExecutionMAil");
			email.setMsg("Script Execution");
			email.addTo("neelima.katari@cotiviti.com");
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	/*
	 * The idea is that 1 + nextInt(2) shall always give 1 or 2. You then
	 * multiply it by 10000 to satisfy your requirement and then add a number
	 * between [0..9999].
	 */
	public static int GetRandomNumber() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	public boolean enterValue(java.util.List<WebElement> columnList, int columnNo, String sCode, WebDriver driver) {
		PageObject p = null;

		try {
			columnList.get(columnNo).click();
			columnList.get(columnNo).clear();
			Thread.sleep(1000);
			System.out.println("size:=" + columnList.size());
			System.out.println("IS DISPLAYED:=" + columnList.get(columnNo).isDisplayed());
			p.evaluateJavascript("arguments[0].value=arguments[1];", columnList.get(columnNo), sCode);

			// JavascriptExecutor js=(JavascriptExecutor) driver;
			// js.executeScript("arguments[0].value=arguments[1];",
			// columnList.get(columnNo),sCode);

			Robot robot = new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
		} catch (Exception e) {
			System.out.println("Element not present");
			System.err.println(e);
			driver.close();
			return false;
		}

		return true;
	}

	public static void Verify(String sDescription, boolean blnStatus) {

		if (blnStatus) {
			Assert.assertTrue("Validation Successful for " + sDescription, blnStatus);
		} else {
			Assert.assertTrue("Validation not Successful for " + sDescription, blnStatus);
		}

	}

	@SuppressWarnings({ "unchecked" })
	public static JSONObject SetDataAsJsonFile(String sTagName, String sFeaturename, String sTcName, String sTcStatus,
			String sDate, String sReasonCode, String sReason, String sReleaseName, String sDescription,
			String sScrshotPath) throws Exception {

		// First Employee

		JSONObject ExecutionDetails = new JSONObject();

		ExecutionDetails.put("tagName", sTagName);
		ExecutionDetails.put("featureName", sFeaturename);
		ExecutionDetails.put("tcName", sTcName);
		ExecutionDetails.put("tcStatus", sTcStatus);
		ExecutionDetails.put("executionTime", sDate);
		ExecutionDetails.put("reasonCode", sReasonCode);
		ExecutionDetails.put("failureReason", sReason);
		ExecutionDetails.put("releaseName", sReleaseName);
		ExecutionDetails.put("step Description", sDescription);
		ExecutionDetails.put("failure Screenshot", sScrshotPath);

		ProjectVariables.execResultList.add(ExecutionDetails);

		// Write JSON file
		FileWriter file = new FileWriter(ProjectVariables.sDirectory + "\\Execution.json", true);
		try {
			file.write(ExecutionDetails.toString());
			file.write("\n");
		} catch (Exception e) {
			System.out.println("Failed due to:" + e);
		} finally {
			file.flush();
			file.close();
		}

		return ExecutionDetails;

	}

	public void clearFileContent(String file) {
		try {
			java.io.PrintWriter writer = new java.io.PrintWriter(file);
			writer.print("");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getCurrentTimeStamp() {
		// Date object
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return StringUtils.replace(ts.toString(), ":", "-");
	}

	public static void writeProperty(String propertyName, String propertyValue) {

		// create object for properties
		Properties prop = new Properties();
		OutputStream output = null;

		try {
			String sDirectory = System.getProperty("user.dir");
			File writeFile = new File(sDirectory + "\\src\\test\\resources\\Defects.properties");
			output = new FileOutputStream(writeFile);

			// set the properties value
			prop.setProperty(propertyName, propertyValue);

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String encodeImage(String fileName) {
		String imageString = null;
		try {
			File f = new File(fileName);
			FileInputStream fis = new FileInputStream(f);
			byte byteArray[] = new byte[(int)f.length()];
			fis.read(byteArray);
			imageString = Base64.getEncoder().encodeToString(byteArray);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return imageString;
	}
	
	public static void decodeImage(String encodedStr, String fileName) {		
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			byte byteArray[] = Base64.getDecoder().decode(encodedStr);
			fos.write(byteArray);
			
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
 
        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
 
            //BASE64Encoder encoder = new BASE64Encoder();
            imageString = Base64.getEncoder().encodeToString(imageBytes);
            //imageString = encoder.encode(imageBytes);
 
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
	
	public static BufferedImage decodeToImage(String imageString) {
		 
        BufferedImage image = null;
        byte[] imageByte;
        try {
            //BASE64Decoder decoder = new BASE64Decoder();
            //imageByte = decoder.decodeBuffer(imageString);
        	imageByte = Base64.getDecoder().decode(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
	
	// For Sending a mail with attachments and HTML Report
    public static void SendEmail(String DBname, String collectionname, String Mailreciepients) {

          // logMessage("Preparing the HTML Report for sending the mail...");
           
           
           // For Sending the Mail-----------
           try {

                 // Get system properties
                 Properties properties = System.getProperties();

                 // Setup mail server
                 properties.setProperty("mail.smtp.host", "ihtmail.ihealthtechnologies.com");
                 Session session = Session.getInstance(properties, null);
                 Message msg = new MimeMessage(session);
                 msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
                 msg.addHeader("format", "flowed");
                 msg.addHeader("Content-Transfer-Encoding", "8bit");
                 msg.setFrom(new InternetAddress("donotreply@cotiviti.com", ProjectVariables.Mailheader));
                 msg.setSubject(ProjectVariables.MailSubject);
                 Multipart multipart = new MimeMultipart();

                 // Creating the attachment part
                 
                 String DownloadPath="P:\\ReportIcons\\testResults";
                 
                 //String DownloadPath=StringUtils.replace(ProjectVariables.DownloadedPath, "username", System.getProperty("user.name"));
                 
                 System.out.println(DownloadPath);
                 
                 // Create the HTML Part
                 BodyPart htmlBodyPart = new MimeBodyPart();
                 
                 
                 //Retrieving the Data from MONGO
                 long All=MongoDBUtils.Method_For_Automation_Dashboard_To_Retrive_the_count("All",DBname,collectionname);
                 long passed=MongoDBUtils.Method_For_Automation_Dashboard_To_Retrive_the_count("passed",DBname,collectionname);
                 long failed=MongoDBUtils.Method_For_Automation_Dashboard_To_Retrive_the_count("failed",DBname,collectionname);
                 
           
                 String first_Part_of_html=GenericUtils.Intialiaze_the_First_part_of_html(All,passed,failed);
                 String HTML=MongoDBUtils.Method_For_Automation_Dashboard(DBname,collectionname,first_Part_of_html);
           
                 // BuildMyString.com generated code. Please enjoy your string responsibly.

               
               String Final=HTML.concat( "</table>\r\n" +
                       "</th>\r\n" +
                       "</tr>\r\n" +
            		  
            		   "</table>\r\n" +
                               "</body>\r\n" +
                               "</html>\r\n");
                 
                 StringBuilder sb = new StringBuilder(Final);
                 
//                 System.out.println(sb);
                 
                  
              /*   htmlBodyPart.setContent("Please click the below link to view the exact report ", "text/html; charset=utf-8");
                 //htmlBodyPart.setContent(sb.toString(), "text/html");
                 //trinath
*/                 htmlBodyPart.setContent(sb.toString(), "text/html");
                 htmlBodyPart.setDisposition(BodyPart.INLINE);
                 multipart.addBodyPart(htmlBodyPart);
                 msg.setContent(multipart);
                 msg.setSentDate(new Date());
                 String UserName = null;
                 UserName = Mailreciepients;
                 msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(UserName, false));
                 msg.setContent(multipart);

                 // To Send the mail
                 Transport.send(msg);

                 System.out.println("Mail sent successfully");

           } catch (Exception e) {

                 e.printStackTrace();

           }

    }
    
    public static String Intialiaze_the_First_part_of_html(long all, long passed, long failed){
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  
  Date date = new Date();
  
  System.out.println(formatter.format(date));
  
  

long PassedSrciptPercentage;
  
long FailedScriptPercentage;

long NoRunPercentage;


System.out.println("Failed Count ==>"+failed);
System.out.println("Passed Count ==>"+passed);

  FailedScriptPercentage = (100 * failed / all);
   PassedSrciptPercentage = (100 * passed / all);
   
   NoRunPercentage=(all-(failed+passed))*100/all;


long TotalPercentage=(100 * (failed+passed)/all);

System.out.println("Total Percentage ======>"+TotalPercentage);

String str="<h2 align=center><img src= https://chart.googleapis.com/chart?cht=p3&amp;chtt=AutomationResults&amp;chl=Pass-"+PassedSrciptPercentage+"%|Fail-"+FailedScriptPercentage+"%|NoRun-"+NoRunPercentage+"%&amp;chs=500x250&amp;chd=t:"+PassedSrciptPercentage+","+FailedScriptPercentage+","+NoRunPercentage+"&amp;chco=91cc3a|ff4f4f|FF8D00&amp;height=700;width=900  /></h2></tr>\r\n";


String sb="	<!DOCTYPE html>\r\n" +
"<html>\r\n" +
"<head>\r\n" +
"<title>Execution Summary Report</title>\r\n" +
"<style>\r\n" +
".orangetext {\r\n" +
"        color: white;\r\n" +
"table, th, td {\r\n" +
"     padding: 5px !important;\r\n" +
"    border: 10px solid black;\r\n" +
"       border-collapse: collapse;\r\n" +
"}\r\n" +
"th, td {\r\n" +
"	padding: 5px !important;\r\n" +
"}\r\n" +
"h3.trin {\r\n" +
"    \r\n" +
"    text-align: centre;    \r\n" +
"}\r\n" +
"h3.fo {\r\n" +
"  font-size: 30px;\r\n" +
"  \r\n" +
"  width: 80px;\r\n" +
"}\r\n" +
".info th,.info td{\r\n" +
"  border: 1px solid black;\r\n" +
"}\r\n" +
".info td{\r\n" +
"}\r\n" +
".info th{\r\n" +
"text-align: center;\r\n" +
"    padding: -17px;\r\n" +
" }\r\n" +
"</style>\r\n" +
"<style>\r\n" +
".dsfa{\r\n" +
"    background: rgb(0, 37, 74);\r\n" +
"	\r\n" +
"	\r\n" +
"}\r\n" +
"</style>\r\n" +
"<style type='text/css'>a{text-decoration:none};\r\n" +
"</style>\r\n" +
"<style>\r\n" +
"body{margin:0;padding:0;font-family:verdana;font-size:12px}.rowheader{background-color:rgb(0, 37, 74); !important}\r\n" +
"</style>\r\n" +
"</head>\r\n" +
"<body>\r\n" +
"<table class=\"info\">\r\n" +
"<TABLE border='0' cellSpacing='0' cellPadding='12' width='100%'><TR class='rowheader'><TD align='left'></TD><TD align='center'><H4 align='center '><font color='white' face='arial' align='center' size='6'>\r\n" +
"<b>Test Execution Summary Report</b>\r\n" +
"</font></H4></TD><td></td></TR></TABLE>\r\n" +
"<table width=90% align=center>\r\n" +
"<tr>\r\n" +
"<td>\r\n" +
"<table class=\"dsfa\" cellspacing=\"0\" border=2px rgb(0, 37, 74); align=\"center\" Width=100% >\r\n" +
"<tr><th align=left width=50%><font  face=Verdana size=2 color=\"white\">RUN DETAILS</font></th>\r\n" +
"<th align = right width=50%><font  face=Verdana size=2></font></th></tr>\r\n" +
"<tr><th align=left><font  face=Verdana size=2 color=\"white\" > Run Date: </font></th>\r\n" +
"<th align=\"center\"><font  face=Verdana size=2 color=\"white\">"+formatter.format(date)+"</font></th></tr>\r\n" +
"<tr><th align=left><font  face=Verdana size=2 color=\"white\"> Total Number of test cases:</font></th>\r\n" +
"<th align=\"center\"><font  face=Verdana size=2 color=\"white\">"+all+"</font></th></tr>\r\n" +
"<tr><th align=left><font  face=Verdana size=2 color=\"white\">No of Pass test cases:</font></th><th align=\"center\"><font  face=Verdana size=2 color=\"white\">"+passed+"</font></th></tr>\r\n" +
"<tr><th align=left><font  face=Verdana size=2 color=\"white\"> No of Failed test cases:</font></th><th align=\"center\"><font  face=Verdana size=2 color=\"white\">"+failed+"</font></th></tr>\r\n" +
"<tr><th align=left><font  face=Verdana size=2 color=\"white\">Project:</font></th><th align=\"center\"><font  face=Verdana size=2 color=\"white\">CPT-ICD</font></th></tr>\r\n" +
"</table>\r\n" +
"</td>\r\n" +
"<td>\r\n" +str+
"</table>\r\n" +
"<div class=\"w3-\">\r\n" +
"  <table class=\"w3-table\" border=\"10\" bordercolor=\"background: rgb(0, 37, 74)\" align=\"center\" Width=\"100%\" cellspacing=\"0\" >\r\n" +
"	<tr>\r\n" +
"	<th>\r\n" +
"    <table class=\"w3-table\" border=\"1\" align=\"center\" Width=\"100%\" cellspacing=\"0\" >\r\n" +
"   \r\n" +
"      <th style=\"background-color:rgb(0, 37, 74);\" class=\"orangetext\">FEATURE NAME</th>\r\n" +
"      <th style=\"background-color:rgb(0, 37, 74);\" class=\"orangetext\">SCRIPT NAME</th>\r\n" +
"      <th style=\"background-color:rgb(0, 37, 74);\" class=\"orangetext\">STATUS</th>\r\n" +
"      <th style=\"background-color:rgb(0, 37, 74);\" class=\"orangetext\">REASON CODE</th>\r\n" +
"         <th style=\"background-color:rgb(0, 37, 74);\" class=\"orangetext\">REASON FOR FAILURE</th>\r\n" +
"		 \r\n" +
"      <th style=\"background-color:rgb(0, 37, 74);\"class=\"orangetext\">DEFECT ID</th>\r\n" +

"    </tr>\r\n" +
"	\r\n";

        
  
  
        return sb;
        
        
 }

////////////////////////////////////////////////


    public static void Delete_the_files_in_the_given_path(String path) {
        
        File file = new File(path);
        File[] files = file.listFiles();
        
        
        for (File f:files) 
        {
        	
        	if (f.isFile() && f.exists()) 
            { 
        		f.delete();
            	
            }
        	else
        	{
            	Assert.assertTrue("cant delete a file due to open or error in the given path =====>"+path,false);
        	}
        	}
        
        System.out.println("successfully deleted the files in the given path ====>"+path);
        }
 


	 @SuppressWarnings({ "unchecked" })
    public static  JSONObject SetDataAsJsonFile(String sTagName,String sFeaturename , String sTcName, String sTcStatus,String sDate,String sReasonCode,String sReason,String sReleaseName, String sDescription) throws Exception {
           //First Employee            
           
           JSONObject ExecutionDetails=new JSONObject() ;
           
           ExecutionDetails.put("tagName", sTagName);
           ExecutionDetails.put("featureName", sFeaturename);
           ExecutionDetails.put("tcName", sTcName);
           ExecutionDetails.put("tcStatus", sTcStatus);
           ExecutionDetails.put("executionTime",sDate);
           ExecutionDetails.put("reasonCode", sReasonCode);
           ExecutionDetails.put("failureReason", sReason);
           ExecutionDetails.put("releaseName", sReleaseName);
           ExecutionDetails.put("step Description", sDescription); 

            

           ProjectVariables.execResultList.add(ExecutionDetails);
           
           //Write JSON file
           FileWriter file = new FileWriter(ProjectVariables.sDirectory+"\\Execution.json",true);
           try {               
               file.write(ExecutionDetails.toString());
               file.write("\n");                     
     }catch(Exception e){
          System.out.println("Failed due to:"+e);              
     }finally{
           file.flush();
                 file.close();
     }
    
           return ExecutionDetails;
     }


}
