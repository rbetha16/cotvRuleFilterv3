package project.utilities;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.regex.ParseException;
import org.apache.xmlbeans.impl.util.Base64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.jboss.netty.handler.codec.base64.Base64Decoder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import com.mongodb.util.JSON;

import gherkin.JSONParser;
import net.sourceforge.htmlunit.corejs.javascript.json.JsonParser;
import sun.misc.BASE64Decoder;

public class MongoDBUtils {

	 private static MongoDBUtils instance = null;
	 private MongoDBUtils() {
	// Exists only to defeat instantiation.
	 }

	/*
	  @return WebControlUtils instance
	*/
	public static MongoDBUtils getInstance() {
		if (instance == null) {
			instance = new MongoDBUtils();
		}
		return instance;
	}

	List<TestExecutionResult> resultsList = new ArrayList<TestExecutionResult>();

	static MongoClient mongoClient;
	static MongoDatabase mongoDB;
	static MongoCollection<Document> mongoCollection;
	static MongoCollection<Document> mongoLabCollection;
	static String projectName;
	static String tagName;
	static String featureName;
	static String testscriptName;
	static String priority;
	//static MongoClient mongoClient;
	static MongoDatabase db;
	static MongoCollection<Document> mColl;
	static FindIterable<Document> results;
	//static MongoCursor<Document> cursor;
	static long recordsCount; 

	static MongoCursor<Document> cursor;

	public static void connectWithCredentials() {

		MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
		// build the connection options
		builder.maxConnectionIdleTime(60000);// set the max wait time in (ms)
		MongoClientOptions opts = builder.build();

		MongoCredential credential = MongoCredential.createCredential("cpTestUser", "Client_Profile",
				"testAuto@123".toCharArray());
		mongoClient = new MongoClient(new ServerAddress("10.32.16.168", 27107), Arrays.asList(credential), opts);
	}

	public static boolean connectToMongo() {
		mongoClient = new MongoClient("10.32.16.168", 27017);
		return (mongoClient != null);
	}

	public MongoDatabase getDatabase(String dbName) {
		mongoDB = mongoClient.getDatabase(dbName);
		return mongoDB;
	}

	@SuppressWarnings("rawtypes")
	public MongoCollection getCollection(String collectionName) {
		mongoCollection = mongoDB.getCollection(collectionName);
		return mongoCollection;
	}

	// create Master Test Plan for project
	/*public boolean createMasterTestPlan(String filePath, String projectName) {
		boolean flag = false;

		try {
			switch (projectName) {
			case "Client_Profile":
				if (importMasterTestPlanWithPOJO(filePath, projectName))
					flag = true;
				break;
			case "CPT_ICD_Links":
				if (importMasterTestPlanWithPOJO(filePath, projectName))
					flag = true;
				break;
			default:
				System.out.println("Incorrect Project Name");
			}
		} catch (IOException e) {
			System.out.println("Failed to read the master test list for project: " + projectName);
		}

		return flag;
	}*/

	public boolean createTestLab(String projectName, String relStr, String priority) {
		return insertTestLabDocuments(projectName, relStr, priority);
	}

	/*public boolean importMasterTestPlanWithPOJO(String filePath, String projectName) throws IOException {
		boolean flag = false;

		String csvFile = System.getProperty("user.dir") + "\\" + filePath;

		Pattern pattern = Pattern.compile(",");

		switch (projectName) {
		case "Client_Profile":
			try (BufferedReader in = new BufferedReader(new FileReader(csvFile));) {

				List<MasterProjectTest_TestLab> results = in.lines().skip(1).map(line -> {
					String[] x = pattern.split(line);

					return new MasterProjectTest_TestLab((x[0]), x[1], x[2], x[3]);
				}).collect(Collectors.toList());

				ObjectMapper mapper = new ObjectMapper();
				mapper.enable(SerializationFeature.INDENT_OUTPUT);
				mapper.writeValue(System.out, results);

				if (connectToMongo()) {
					if (addMasterProjectTestPlanPOJOSToDB(results))
						flag = true;
				}
			} catch (FileNotFoundException e) {
				System.out.println("Could not find the file to be imported - " + e.toString());
			} catch (IOException e) {
				System.out.println("Error while reading the file - " + e.toString());
				e.printStackTrace();
			}
			break;
		case "CPT_ICD_Links":
			try (BufferedReader in = new BufferedReader(new FileReader(csvFile));) {

				List<MasterTest_TestLab> results = in.lines().skip(1).map(line -> {
					String[] x = pattern.split(line);

					return new MasterTest_TestLab((x[0]), x[1], x[2], x[3], x[4], x[5]);
				}).collect(Collectors.toList());

				ObjectMapper mapper = new ObjectMapper();
				mapper.enable(SerializationFeature.INDENT_OUTPUT);
				mapper.writeValue(System.out, results);

				if (connectToMongo()) {
					if (addMasterTestPlanPOJOSToDB(results, projectName))
						flag = true;
				}
			} catch (FileNotFoundException e) {
				System.out.println("Could not find the file to be imported - " + e.toString());
			} catch (IOException e) {
				System.out.println("Error while reading the file - " + e.toString());
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Incorrect project Name");
		}

		return flag;
	}*/

	/*public boolean importTestResultsWithPOJO(String filePath, String projectName) throws IOException {
		boolean flag = false;

		String csvFile = System.getProperty("user.dir") + "\\" + filePath;

		Pattern pattern = Pattern.compile(",");

		try (BufferedReader in = new BufferedReader(new FileReader(csvFile));) {

			List<MasterTest_TestLab> results = in.lines().skip(1).map(line -> {
				String[] x = pattern.split(line);

				return new MasterTest_TestLab((x[0]), x[1], x[2], x[3], x[4], x[5]);
			}).collect(Collectors.toList());

			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			mapper.writeValue(System.out, results);

			if (connectToMongo()) {
				addPOJOSToDB(results, projectName);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file to be imported - " + e.toString());
		} catch (IOException e) {
			System.out.println("Error while reading the file - " + e.toString());
			e.printStackTrace();
		}

		return flag;
	}*/

	@SuppressWarnings("unchecked")
	public boolean importTestResultsWithJson(String filePath) {
		boolean flag = true;

		String jsonFile = System.getProperty("user.dir") + "\\" + filePath;

		org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();

		try {
			FileReader reader = new FileReader(jsonFile);

			Object obj = jsonParser.parse(reader);

			JSONArray testExecutionResultArray = (JSONArray) obj;
			 System.out.println(testExecutionResultArray);

			testExecutionResultArray.forEach(result -> getTestResultObject((JSONObject) result));
				
			
		ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
			
			mapper.writeValue(System.out, resultsList);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	private boolean insertTestLabDocuments(String projectName, String releaseStr, String priority) {
		boolean flag = false;

		connectToMongo();

		switch (projectName) {

		case "Client_Profile":
			mongoDB = mongoClient.getDatabase(projectName);

			mongoCollection = mongoDB.getCollection("CP_Master_Test_Plan");

			mongoLabCollection = mongoDB.getCollection("CP_Test_Lab");
			break;
		case "CPT_ICD_Links":
			mongoDB = mongoClient.getDatabase(projectName);

			mongoCollection = mongoDB.getCollection("CPTICDLinks_Master_Test_Plan");

			mongoLabCollection = mongoDB.getCollection("CPTICDLinks_Test_Lab");
			break;
		default:
			System.out.println("Incorrect project name");
		}

		String featureNo = null;
		String featureName = null;
		String userstoryNo = null;
		String testscriptName = null;
		String testType = null;
		String mPriority = null;

		// create tagName field
		FindIterable<Document> outputDisp = mongoCollection.find();

		for (Document outptDoc : outputDisp) {
			// each document retrieved is to be added to the testlab collection
			featureNo = outptDoc.getString("featureNo");
			featureName = outptDoc.getString("featureName");
			userstoryNo = outptDoc.getString("userstoryNo");
			testscriptName = outptDoc.getString("testscriptName");
			testType = outptDoc.getString("testType");
			mPriority = outptDoc.getString("priority");

			String tagName = null;
			if (mPriority.equals(priority)) {
				tagName = featureNo + "_" + featureName + "_" + userstoryNo + "_" + testscriptName + "_" + testType
						+ "_" + priority + "_" + releaseStr;

				outptDoc.append("tagName", tagName);

				mongoLabCollection.insertOne(outptDoc);
			}

		}
		flag = true;

		return flag;
	}

	@SuppressWarnings("unchecked")
	private TestExecutionResult getTestResultObject(JSONObject result) 
	{
		//TestExecutionResult testR = new TestExecutionResult("","","","","","","","","","");
		TestExecutionResult testR = new TestExecutionResult();
		
		Set<String> keys = result.keySet();
		Iterator<String> iter = keys.iterator();

		while (iter.hasNext()) 
		{
			String key = iter.next();

				String featureName = (String) result.get("featureName");
				//System.out.println(featureName);
				testR.setFeatureName(featureName);

				String tcName = (String) result.get("tcName");
				//System.out.println(tcName);
				testR.setTcName(tcName);

				String tagName = (String) result.get("tagName");
				//System.out.println(tagName);
				testR.setTagName(tagName);

				String tcStatus = (String) result.get("tcStatus");
				//System.out.println(tcStatus);
				testR.setTcStatus(tcStatus);
				
				String executionTime = (String) result.get("executionTime");
				//System.out.println(executionTime);
				testR.setExecutionTime(executionTime);

				String reasonCode = (String) result.get("reasonCode");
				//System.out.println(reasonCode);
				testR.setReasonCode(reasonCode);

				String failureReason = (String) result.get("failureReason");
				//System.out.println(failureReason);
				testR.setFailureReason(failureReason);
				
				String releaseName = (String) result.get("releaseName");
				//System.out.println(releaseName);
				testR.setReleaseName(releaseName);	
				
				String description = (String) result.get("step Description");
				//System.out.println(description);
				testR.setDescription(description);	
				
				String failureScreenshot = (String) result.get("failure Screenshot");
				//System.out.println(failureScreenshot);
				testR.setFailureScreenshot(failureScreenshot);			
		}
		resultsList.add(testR);

		return testR;
	}

	public List<List<String>> getTestResultsForApplication(String applicationName) {
		List<List<String>> queryResults = new ArrayList<List<String>>();
		switch (applicationName) {
		case "CLient Profile":
			System.out.println("We will retrieve MongoDB records for application CPW here");
			if (connectToMongo()) {
				mongoDB = mongoClient.getDatabase("ClientProfile");
				mongoCollection = mongoDB.getCollection("CPTestResults");

				@SuppressWarnings("unchecked")
				FindIterable<Document> dbOutput = mongoCollection.find();

				for (Document outDoc : dbOutput) {
					System.out.println(outDoc.toString());
					System.out.println(outDoc.toJson());
				}
			}
			break;
		default:
			System.out.println("Incorrect application name to retrieve test results");
		}

		return queryResults;
	}

	/*@SuppressWarnings("unchecked")
	private boolean addPOJOSToDB(List<MasterTest_TestLab> results, String projectName) throws JsonProcessingException {
		boolean flag = false;
		String objJSON = null;

		if (projectName.equals("CPT_ICD_Links")) {
			mongoDB = mongoClient.getDatabase("CPT_ICD_Links");

			mongoCollection = mongoDB.getCollection("CPTICDLinks_Master_Test_Plan");
		}

		for (MasterTest_TestLab res : results) {

			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			objJSON = ow.writeValueAsString(res);
			Document inDoc = Document.parse(objJSON);

			mongoCollection.insertOne(inDoc);
			flag = true;
		}
		return flag;
	}*/

	/*@SuppressWarnings("unchecked")
	public boolean addMasterProjectTestPlanPOJOSToDB(List<MasterProjectTest_TestLab> results)
			throws JsonProcessingException {
		boolean flag = false;
		String objJSON = null;

		mongoDB = mongoClient.getDatabase("ClientProfile");

		mongoCollection = mongoDB.getCollection("CP_Master_Test_Plan");

		for (MasterProjectTest_TestLab res : results) {

			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			objJSON = ow.writeValueAsString(res);
			Document inDoc = Document.parse(objJSON);

			mongoCollection.insertOne(inDoc);
			flag = true;
		}
		return flag;
	}*/

	/*@SuppressWarnings("unchecked")
	public boolean addMasterTestPlanPOJOSToDB(List<MasterTest_TestLab> results, String projectName)
			throws JsonProcessingException {
		boolean flag = false;
		String objJSON = null;

		switch (projectName) {
		case "Client_Profile":
			mongoDB = mongoClient.getDatabase("Client_Profile");

			mongoCollection = mongoDB.getCollection("CP_Master_Test_Plan");
			break;
		case "CPT_ICD_Links":
			mongoDB = mongoClient.getDatabase("CPT_ICD_Links");

			mongoCollection = mongoDB.getCollection("CPTICDLinks_Master_Test_Plan");
			break;
		default:
			System.out.println("Incorrect Project Name");
		}

		for (MasterTest_TestLab res : results) {

			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			objJSON = ow.writeValueAsString(res);
			Document inDoc = Document.parse(objJSON);

			mongoCollection.insertOne(inDoc);
			flag = true;
		}
		return flag;
	}  */
	public boolean updateTestResults(String projectName) {
		boolean flag = false;
		
		connectToMongo();
		
		switch (projectName) {
		case "Client_Profile":
			mongoDB = mongoClient.getDatabase("Client_Profile");
			
			mongoLabCollection = mongoDB.getCollection("CP_Test_Lab");
			break;
		case "CPT_ICD_Links":
			mongoDB = mongoClient.getDatabase("CPT_ICD_Links");
			
			mongoLabCollection = mongoDB.getCollection("CPTICDLinks_Test_Lab");
			break;
		default:
			System.out.println("Incorrect Project Name");
		}
		
		//testExecutionResultArray.forEach(action);
		for (TestExecutionResult res : resultsList) {
				
			//get a document for each test result object
			Bson testcaseMatch = Filters.and(/*Filters.eq("testscriptName", res.getTcName()), */ 
					Filters.eq("tagName", res.getTagName()));
					//Filters.eq("releaseName", res.getReleaseName()));	
			
			FindIterable<Document> returnedDoc = mongoLabCollection.find(testcaseMatch);
			
			Iterator iter = returnedDoc.iterator();
			
			if (iter.hasNext()) {
				Document retDoc = (Document) iter.next();
				
				String rel = retDoc.getString("release");
				String featureNo = retDoc.getString("featureNo");
				String userSt = retDoc.getString("userstoryNo");
				String ttype = retDoc.getString("testType");
				String pr= retDoc.getString("priority");
				
				Document passedDoc = new Document();
				Document failedDoc = new Document();
				
				passedDoc.put("release", rel);
				failedDoc.put("release", rel);
				
				passedDoc.put("featureNo", featureNo);
				failedDoc.put("featureNo", featureNo);
				
				passedDoc.put("userstoryNo", userSt);
				failedDoc.put("userstoryNo", userSt);
				
				passedDoc.put("testType", ttype);
				failedDoc.put("testType", ttype);
				
				passedDoc.put("priority", pr);
				failedDoc.put("priority", pr);
				
				passedDoc.put("tagName", res.getTagName());
				failedDoc.put("tagName", res.getTagName());
				
				passedDoc.put("featureName", res.getFeatureName());
				failedDoc.put("featureName", res.getFeatureName());
				
				passedDoc.put("testscriptName", res.getTcName());
				failedDoc.put("testscriptName", res.getTcName());			
				
				//check for the test case execution result
				String status = res.getTcStatus();
				if (status.equals("passed")) {
					//else just add the test case status field	
					passedDoc.put("testcaseStatus", status);
					passedDoc.put("executionTime", res.getExecutionTime());
					
					UpdateResult actionResult = mongoLabCollection.replaceOne(testcaseMatch, passedDoc);
					
					if (actionResult.wasAcknowledged()) {
						flag = true;
					}
					
				} else if (status.equals("failed")) {
					//in case the execution result is failed then add the two more fields
					failedDoc.put("testcaseStatus", status);
					failedDoc.put("executionTime", res.getExecutionTime());
					failedDoc.put("reasonCode", res.getReasonCode());
					failedDoc.put("failureReason", res.getFailureReason());
					String steps = res.getDescription();
					//steps = steps.replace(" ", "");
					//steps = steps.replace("\n", "");
					failedDoc.put("step Description", steps);
					
					String newFileName = res.getFailureScreenshot();
					String fileName = newFileName.replace(" ", "");
					String encodedScreenshot = GenericUtils.encodeImage(newFileName);
					failedDoc.put("FailureScreenshot", encodedScreenshot);				
					
					System.out.println(failedDoc.toString());
					
					UpdateResult actionResult = mongoLabCollection.replaceOne(testcaseMatch, failedDoc);
					
					if (actionResult.wasAcknowledged()) {
						flag = true;
					}
				}
			}
			
										
		}
	
		return flag;
	}
	
	public static boolean updateJIRADefectID(String arg_projectName, String arg_tagName, String arg_testscriptName,
            String arg_defectId) {
     boolean flag = false;

     connectToMongo();

     switch (arg_projectName) {
     case "Client_Profile":
            mongoDB = mongoClient.getDatabase("Client_Profile");

            mongoLabCollection = mongoDB.getCollection("CP_Test_Lab");
            break;
     case "CPT_ICD_Links":
            mongoDB = mongoClient.getDatabase("CPT_ICD_Links");

            mongoLabCollection = mongoDB.getCollection("CPTICDLinks_Test_Lab");
            break;
     default:
            System.out.println("Incorrect Project Name");
     }

  // get a document for each test result object
     Bson testcaseMatch = Filters.and(
                               //Filters.eq("testscriptName", res.getTcName()),
                  Filters.eq("tagName", arg_tagName));

     Document updtDoc = new Document();

     updtDoc.put("DefectNo", arg_defectId);    
     FindIterable doc = mongoLabCollection.find(testcaseMatch);  
     Iterator cur = doc.iterator();
     
     if (cur.hasNext()) {
                 Document docFound = (Document) cur.next();
                 //docFound.replace("DefectNo", arg_defectId);
                 Document actionResult = (Document) docFound.append("DefectNo", arg_defectId);         
                 UpdateResult res = mongoLabCollection.replaceOne(testcaseMatch, docFound);
                 if (res.isModifiedCountAvailable()) {
                                 System.out.println("Defect Id updated in MongoDB");
             flag = true;
       }
     }

     return flag;
}

	
	public static long Method_For_Automation_Dashboard_To_Retrive_the_count(String criteria, String dBname, String collectionname) {
        
        
        ArrayList<String> Failure_count=new ArrayList<>();
        ArrayList<String> Passed_count=new ArrayList<>();
        
        //Connecting to Zero touch Database
        connectWithCredentials_For_Zero_touch(dBname,collectionname);
 
        for (Document doc : results) {
               
        
               String TestscriptName = doc.getString("testscriptName");
               String TestscriptStatus=doc.getString("testcaseStatus");
               String FailureReason=doc.getString("failureReason");
               //String ReasonCode=doc.getString("reasonCode");
               
               System.out.println(doc);
               System.out.println(TestscriptStatus);
               
               
               if(TestscriptStatus.equalsIgnoreCase("failed"))
               {
                     Failure_count.add(TestscriptStatus);
               }
               else if(TestscriptStatus.equalsIgnoreCase("passed"))
               {
                     Passed_count.add(TestscriptStatus);
               }
        
               
        }
        //GenericUtils.logMessage(ProjectVariables.HTML);
        
        
        if(criteria.equalsIgnoreCase("failed"))
        {
               return Failure_count.size();
                            
        }
        else if(criteria.equalsIgnoreCase("passed"))
               {
               return Passed_count.size();             
               }
        else if(criteria.equalsIgnoreCase("All"))
        {
        return recordsCount;             
        }
        return 0;
        
 }
	public static void connectWithCredentials_For_Zero_touch(String DBName,String Collectionname) {
        
        
        //MongoCredential credential = MongoCredential.createCredential(ProjectVariables.MONGODB_USER,
               //     ProjectVariables.MONGODB, ProjectVariables.MONGODB_PWD.toCharArray());
        mongoClient = new MongoClient(new ServerAddress(ProjectVariables.Zero_Touch_MONGO_SERVER_URL, ProjectVariables.Zero_Touch_MONGO_SERVER_PORT));
        db = mongoClient.getDatabase(DBName);
        mColl = db.getCollection(Collectionname);
        cursor = mColl.find().iterator();
        results = mColl.find();
        recordsCount = mColl.count();
        
       // GenericUtils.logMessage("ZeroTouch_records_Count:"+recordsCount);
 }

	public static String Method_For_Automation_Dashboard(String Dbname,String collectionname, String first_Part_of_html) throws IOException {
        //GenericUtils.logMessage("Filtered Data As input for Mongo DB:"+Dbname+",CollectionName:"+collectionname);
        
        //Connecting to Zero touch Database
        connectWithCredentials_For_Zero_touch(Dbname,collectionname);
        String FailureScreenshot=null;
        String FailurescreenshotTag=null;
        File Screenshot = null;
        for (Document doc : results) {
               
               String FeatureName = doc.getString("featureName");
               String TestscriptName = doc.getString("testscriptName");
               String TestscriptStatus=doc.getString("testcaseStatus");
               String FailureReason=doc.getString("failureReason");
               String ReasonCode=doc.getString("reasonCode");
               String DefectNumber=doc.getString("DefectNo");
               FailureScreenshot=(String)doc.getString("FailureScreenshot"); 
               
               System.out.println(FailureScreenshot);
               
                         
               String statuscolour=null;
               String colour=null;
               if(TestscriptStatus.equalsIgnoreCase("failed"))
               {
                     
            	   statuscolour="&#10008;";
            	   
            	   colour="red;font-size:20px;";
                     
               }
               else if(TestscriptStatus.equalsIgnoreCase("passed"))
               {
                     
                     statuscolour="&#10004";
                     
                     colour="rgb(60, 179, 113);font-size:20px;";
                     
               }
               else
               {
                    
            	   statuscolour="&#216";
            	   
            	   colour="rgb(255, 141, 0);font-size:20px;";
            	   
               }
               
               
               if(ReasonCode==null)
               {
            	   ReasonCode=""; 
               }
                if(FailureReason==null)
               {
            	  
            	   FailureReason="";
               }
               
                if(DefectNumber==null)
                {
                	DefectNumber="";
                }
                
                String rows=    "     <tr>\r\n" +
                        "       \r\n" +
                        "     <td align=\"center\" style=\"color:black;\">"+FeatureName+"</td>\r\n" +
                        "     <td align=\"center\" style=\"color:black;\">"+TestscriptName+"</td>\r\n" +
                        "     <td align=\"center\" style=\"color:"+colour+"\">"+statuscolour+"</td>\r\n" +
                        "     <td align=\"center\" style=\"color:black;\">"+ReasonCode+"</td>\r\n" +
                        "     <td align=\"center\" style=\"color:black;\">"+FailureReason+"</td>\r\n" +
                        "	 <td align=\"center\" style=\"color:black;\">"+DefectNumber+"</td>\r\n" +
                       
                        "  </tr>\r\n";
                
                  
               first_Part_of_html=first_Part_of_html.concat(rows);
               
        }
        //GenericUtils.logMessage(first_Part_of_html);
        
        return first_Part_of_html;
        
 }

private static File method_to_get_screenshot_from_Db(String failureScreenshot) throws IOException {
    
	String FailureScreenshot = null;
	
	String DownloadPath="P:\\ReportIcons\\testResults";
	
    //String DownloadPath=StringUtils.replace(ProjectVariables.DownloadedPath, "username", System.getProperty("user.name"));
    
    System.out.println(DownloadPath);
    
	BufferedImage image = null;
	byte[] imageByte;

	BASE64Decoder decoder = new BASE64Decoder();
	imageByte = decoder.decodeBuffer(failureScreenshot);
	ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
	image = ImageIO.read(bis);
	bis.close();
    
    // write the image to a file
    GenericUtils.Delete_the_files_in_the_given_path(DownloadPath);
    
    File outputfile = new File(DownloadPath+"//image.png");
    
    //File outputfile = new File("image.png");
    
    //GenericUtils.decodeImage(failureScreenshot, outputfile.getName());
    ImageIO.write(image, "png", outputfile); 
    
    return outputfile;
    
}


	
}
