package project.features;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
//import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
//import net.thucydides.core.annotations.Managed;
import project.utilities.ExcelUtils;
import project.utilities.ExecuteImport;
import project.utilities.GenericUtils;
import project.utilities.HttppMethods;
import project.utilities.ProjectVariables;

//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions( plugin = {"pretty","html:target/cucumber-html-report","json:target/jsonReport/cucumber.json","junit:target/XMLReport/cucumber.xml"},
features="Features",tags = {"@US20932AbilitytoFilterTargetTabledata"},monochrome=true)


public class TestRunner2 {	 
	 
	@BeforeClass	
	public static void initReport() throws Exception{                    
        ProjectVariables.execResultList = new ArrayList<JSONObject>();
        
        //deleting all the files in the src/test/resources/Failures folder
        File failureDir = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Failures");
        File[] files = failureDir.listFiles();
        
        if (files != null) {
        	for (File f:files) {
        		if (f.isFile()) {
        			f.delete();
        		}
        	}
        }
        
        File imageFile = new File(System.getProperty("user.dir") + "\\image.png");
        imageFile.delete();
        
}

	
	
    public static void killExcel() throws Exception{           
//           Runtime.getRuntime().exec("taskkill /F /IM EXCEL.EXE");
//           String sDirectory = System.getProperty("user.dir");
//           String sDriverPath = sDirectory+"\\src\\test\\resources\\Data";
//           String sExcelPath = sDirectory+"\\src\\test\\resources\\Data\\Mail.xlsm";
//           ExcelUtils.SetPath(7, 2, sDriverPath, sExcelPath);   
    }
	
	
	
	 @AfterClass    
	 public static void Create_Jira_Defect () throws IOException{
  	 
		 HttppMethods.postDefect("CPT_ICD_Links","CPTICDLinks_Test_Lab");	 
		  
    }
	
	 
	
}

	
