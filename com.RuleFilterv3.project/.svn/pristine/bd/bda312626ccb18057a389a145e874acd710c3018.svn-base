package project.features;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.runtime.junit.ExecutionUnitRunner;
import cucumber.runtime.junit.JUnitReporter;
import cucumber.runtime.model.CucumberScenario;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Step;
import net.thucydides.core.annotations.ManagedPages;

import net.thucydides.core.pages.Pages;
import project.utilities.ExcelUtils;
import project.utilities.GenericUtils;
import project.utilities.MongoDBUtils;
import project.utilities.MongoDBUtils;
import project.utilities.ProjectVariables;
import org.junit.*;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.MultipleFailureException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import cucumber.*;


public class CucumberHooks {
	
	@ManagedPages
	private Pages pages;
	    
	
    //static   JSONObject[]  JSONObjScenarioResult = new  JSONObject[] ;
    
    static ArrayList<String>   JSONObjScenarioResult = new ArrayList<String>();
    
    static int counter = 0;
    

    
   	@After 
     public void cleanUp(Scenario sScenario) throws Exception{            
        	
        	String sStatus = sScenario.getStatus();
        	String sTCName = sScenario.getName();     
        	
        	sTCName =sTCName.replaceAll("^\"|\"$", "");        	
        	sTCName= sTCName.replaceAll("\"", "");
        	String ScreenShotPath =null;
       
          	 String  sFeatureName = sScenario.getId();       		
			 if(sFeatureName.contains("-"))
			 {	 
				 sFeatureName = sFeatureName.split(";")[0].replace("-", " ");		 
			 }
				 
         	int indx =  sFeatureName.indexOf(".feature");         	
         	sFeatureName = sFeatureName.substring(0, indx).trim();    //To remove .feature from feature name
         

         	//For init capitalization
         	 String result = "";
             char firstChar = sFeatureName.charAt(0);
             result = result + Character.toUpperCase(firstChar);
             for (int i = 1; i < sFeatureName.length(); i++) {
                 char currentChar = sFeatureName.charAt(i);
                 char previousChar = sFeatureName.charAt(i - 1);
                 if (previousChar == ' ') {
                     result = result + Character.toUpperCase(currentChar);
                 } else {
                     result = result + currentChar;
                 }
             }             
             sFeatureName = result;
       		
         	
        	String sReason = null;
            String sReasonCode=null;
            String sErrormessage=null;
            String sTagName = "";
            String sTempTagName = "";
            Collection<String>  sTagNames =  sScenario.getSourceTagNames();     //if scenario failed,it is taking feature level tag name             
    
            Iterator it = sTagNames.iterator();               
            List<String>  tagnames = (List)sTagNames;     
                     
            for(int j=0;j<tagnames.size();j++)
            {
            	sTempTagName = tagnames.get(j);
            	if (!(sTempTagName.contains("Regression")))
           			{
            		   sTagName = tagnames.get(j);
           			}
            }
            
            
        	sTagName =  sTagName.replace("@", "").trim();     
       
        	if(sStatus.equalsIgnoreCase("failed")){
        		
        		Field sfield = sScenario.getClass().getDeclaredField("stepResults");
                sfield.setAccessible(true);
                ArrayList<Result> sResults = null;
                
                sResults = (ArrayList<Result>) sfield.get(sScenario);
               
                for (Result sResult: sResults)
                {                     
		                     String stepstatus = sResult.getStatus();
		                     if (stepstatus.equalsIgnoreCase("failed")){
		                    	 try{
		                    		 sErrormessage = sResult.getErrorMessage().toString();
		                             System.out.println(sResult.getErrorMessage().toString());
		                             sReason=sErrormessage.split("\\n")[0];
		                             if(sReason.contains("SerenityManagedException")){
		                             	sReason = sErrormessage.split("\\n")[0].split(":")[1];
		                             }
		                             System.out.println(sReason); 
		                             if(sErrormessage.contains("AssertionError")||sErrormessage.contains("Element not available")||sErrormessage.contains("Element not found")||sErrormessage.contains("Validation not Successful")||sErrormessage.contains("no such element")){
		                              	sReasonCode="Application Issue";
		                             }else if(sErrormessage.contains("IndexOutOfBoundsException")||sErrormessage.contains("stale element reference")||sErrormessage.contains("NullPointerException")
		                             		||sErrormessage.contains("Could not instantiate class")||sErrormessage.contains("ArithmeticException")||sErrormessage.contains("IOException")||sErrormessage.contains("No such file or directory")||sErrormessage.contains("ClassNotFoundException")||sErrormessage.contains("SQLException")){
		                             	sReasonCode="Script Issue";
		                             }else if(sErrormessage.contains("chrome not reachable")){
		                             	sReasonCode="Network Issue";
		                             }else{
		                             	sReasonCode="Others";
		                             }
		                             break;
		                    	 }catch(Exception e)
		                    	 {
		                    		 e.printStackTrace();
		                    	 }
                           
                              }//End If
                     
                    }//End for
                       		
        	}//End If
        	
        	
        //**** Code to Capture Cucumber Step descriptions in case of Failures	to update in MongoDB
        	 String sDesc = null;
             ArrayList<Result> sResults = null;
             ArrayList<Step> sSteps = null;
             int size=0;        	

        	if(sStatus.equalsIgnoreCase("failed")){
        		
        		Field sfield = sScenario.getClass().getDeclaredField("stepResults");
                sfield.setAccessible(true);
               
                List<String> Steps=new ArrayList<String>();
                sResults = (ArrayList<Result>) sfield.get(sScenario);
                
	           	Field f = sScenario.getClass().getDeclaredField("reporter");
	             f.setAccessible(true);
	             JUnitReporter reporter =(JUnitReporter) f.get(sScenario);
	          
	             Field executionRunnerField = reporter.getClass().getDeclaredField("executionUnitRunner");
	             executionRunnerField.setAccessible(true);
	             ExecutionUnitRunner executionUnitRunner =(ExecutionUnitRunner) executionRunnerField.get(reporter);
	             
	             Field CucumberScenarioField = executionUnitRunner.getClass().getDeclaredField("cucumberScenario");
	             CucumberScenarioField.setAccessible(true);
	             CucumberScenario CucumberRunner = (CucumberScenario) CucumberScenarioField.get(executionUnitRunner);
	             
	             sSteps = (ArrayList<Step>)CucumberRunner.getSteps();
        	  
            for (Result sResult: sResults){
                 
                 String stepstatus = sResult.getStatus();
                 if (stepstatus.equalsIgnoreCase("failed")){
                	
                    	Steps.add("Expected:"+sSteps.get(size).getName());
                    	sErrormessage = sResult.getErrorMessage().toString();
                        System.out.println(sResult.getErrorMessage().toString());
                        sReason=sErrormessage.split("\\n")[0];
                        if(sReason.contains("SerenityManagedException")){
                        	sReason = sErrormessage.split("\\n")[0].split(":")[1];
                        }
                        System.out.println(sReason); 
                        if(sErrormessage.contains("AssertionError")||sErrormessage.contains("Element not available")||sErrormessage.contains("Element not found")||sErrormessage.contains("Validation not Successful")||sErrormessage.contains("no such element")||sErrormessage.contains("no such window")){
                         	sReasonCode="Application Issue";
                        }else if(sErrormessage.contains("IndexOutOfBoundsException")||sErrormessage.contains("stale element reference")||sErrormessage.contains("NullPointerException")||sErrormessage.contains(" Timed out after")
                        		||sErrormessage.contains("Could not instantiate class")||sErrormessage.contains("ArithmeticException")||sErrormessage.contains("IOException")||sErrormessage.contains("No such file or directory")||
                        		sErrormessage.contains("ClassNotFoundException")||sErrormessage.contains("SQLException")||sErrormessage.contains("ORA")){
                        	sReasonCode="Script Issue";
                        }else if(sErrormessage.contains("chrome not reachable")){
                        	sReasonCode="Network Issue";
                        }else{
                        	sReasonCode="Others";
                        }                         
                        Steps.add("Actual:"+sReason);
                        sDesc= StringUtils.join(Steps, "\n");
                    	break;
                    }else{
                    	Steps.add(sSteps.get(size).getName());                    
                	   	System.out.println(sSteps.get(size).getName());
                	   	size = size+1;
                    }
                        	                            	 
            }  
      	}   	
     //**** End of Code to Capture Cucumber Step descriptions in case of Failures	  	
        	
      
    //**** Code for capturing screenshots    	 
       	 if (sScenario.isFailed() && sReasonCode.equals("Application Issue")) {      		 
   			 File scrFile = ((TakesScreenshot) pages.getDriver()).getScreenshotAs(OutputType.FILE);
   		
   			 try {       				   
   				 File destDir = new File(ProjectVariables.sDirectory+"\\src\\test\\resources\\Failures"); // path only     				
   				 FileUtils.copyFileToDirectory(scrFile, destDir);
   				 File oldFile=new File(ProjectVariables.sDirectory+"\\src\\test\\resources\\Failures\\"+scrFile.getName());   				 
   				 ScreenShotPath = oldFile.getAbsolutePath().replace(oldFile.getName(), "") + sTCName+".png";
   				 File newFile = new File(ScreenShotPath);
   				  try {
   				    FileUtils.moveFile(oldFile, newFile);   			
   				  } catch (IOException e) {
   				    e.printStackTrace();
   				  }
   			 } catch (IOException e) {
   				 e.printStackTrace();
   			 }       			
  	         }
         
         //** End of  Code for capturing screenshots	
       	 
        	pages.getDriver().quit();
       	    
        	String sDirectory = System.getProperty("user.dir");
        	String sDriverPath = sDirectory+"\\src\\test\\resources\\Data";
    		String sExcelPath = sDirectory+"\\src\\test\\resources\\Data\\Mail.xlsm";
    		
    		  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    		  Date sDate = new Date();  
    		  String sExecutionTime =   formatter.format(sDate).toString();    		
    		  String sReleaseName =  ProjectVariables.sReleaseName;
   
        	  
    	    int iScenarioCount = ExcelUtils.SetCellDataXlsm(sFeatureName,sTCName,sStatus,sReasonCode,sReason,sExcelPath);    	 
    	    
    	    GenericUtils.SetDataAsJsonFile(sTagName, sFeatureName, sTCName, sStatus, sExecutionTime, sReasonCode, sReason,sReleaseName,sDesc,ScreenShotPath);
        
        	if (iScenarioCount % 20 == 0)
        		Runtime.getRuntime().exec(new String[] { "wscript.exe", sDriverPath+"\\Trigger.vbs",sExcelPath}); 
     
        }//End of Method
       
    }//End of class