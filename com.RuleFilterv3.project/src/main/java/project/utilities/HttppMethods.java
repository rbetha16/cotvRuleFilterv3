package project.utilities;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.bson.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
//import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import net.serenitybdd.core.Serenity;
import project.pageobjects.SSLSkipSNIHostnameVerifier;
import project.utilities.GenericUtils;
import project.utilities.MongoDBUtils;
import project.utilities.ProjectVariables;
import sun.misc.BASE64Decoder;

public class HttppMethods  {
	

	static MongoClient mongoClient;
	static MongoDatabase db;
	static MongoCollection<Document> mColl;
	static FindIterable<Document> results;
	static MongoCursor<Document> cursor;
	static long recordsCount;
	
	public static void postDefect(String DBName,String Collectionname ) throws IOException {
		String prriority=null;
   	 	String releaseName=null;
   	 	String executionTime=null;
   	 	String testscriptName=null;
   	 	String Description=null;
   	 	String TagName=null;
   	 	String FailureScreenshot="";
   	 	String sDescription ="";
   	 	mongoClient = new MongoClient(new ServerAddress(ProjectVariables.Zero_Touch_MONGO_SERVER_URL, ProjectVariables.Zero_Touch_MONGO_SERVER_PORT));
		db = mongoClient.getDatabase(DBName);
		mColl = db.getCollection(Collectionname);
		cursor = mColl.find().iterator();
		results = mColl.find();
		recordsCount = mColl.count();
		
		System.out.println("ZeroTouch_records_Count:"+recordsCount);

		List<Document> documents = (List<Document>) mColl.find().into(new ArrayList<Document>());

		

           for(Document document : documents){
        	   
              String Status= (String)document.get("testcaseStatus");
             // String sReasonCode=(String)document.get("reasonCode");
              System.out.println(Status);
              String sReasonCode=(String) document.get("reasonCode");
              String sDefectNo=(String) document.get("DefectNo");
            // if(Status.equalsIgnoreCase("failed")&&){
		            if((Status.equalsIgnoreCase("failed"))&&(sReasonCode.equalsIgnoreCase("Application Issue")))
		            {
		            		
		            	 	Description= (String)document.get("step Description");
		            	 	Serenity.setSessionVariable("stepDescription").to(Description.replaceAll("\\s+",""));
			             	System.out.println("Rule Version: " + Serenity.sessionVariableCalled("stepDescription").toString());
			             	
		            		//{&(sReasonCode.equalsIgnoreCase("Application Issue")&&sDefectNo.isEmpty())){
			             	if(!(sDescription.replaceAll("\\s+","").equalsIgnoreCase(Serenity.sessionVariableCalled("stepDescription")))){
//			            	if (Serenity.sessionVariableCalled("stepDescription")!= sDescription){
			            		
			            		 prriority = (String) document.get("priority");
				             	 releaseName = (String) document.get("releaseName");
				             	 executionTime = (String) document.get("executionTime");
				             	 
				             	 testscriptName=(String)document.get("testscriptName");
				             	
				             	 sDescription = Description;
				             	
				             	 TagName=(String)document.getString("tagName");
				//             	 FailureScreenshot=(String)document.getString("FailureScreenshot");
				             	 System.out.println(testscriptName);
				             	 System.out.println(Description);
				             	 URL obj = new URL(ProjectVariables.POST_URL);
				
								HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
								((HttpsURLConnection) con).setHostnameVerifier(new SSLSkipSNIHostnameVerifier()); 	
								//get jsonObject input
								String input=Post_Input(testscriptName,Description).toString();
								
								String encodedData = URLEncoder.encode(input, "UTF-8");
						
								System.out.println("encodedata " + encodedData);
						
								// Prepairing credentials
								String cred = "raveendra.betha:Berlin!23";
								byte[] encoded = Base64.getEncoder().encode(cred.getBytes());
								String credentials = new String(encoded);
						
								// Setting the Authorization Header as 'Basic' with the given
								// credentials
								con.setRequestProperty("Authorization", "Basic " + credentials);
						
								// con.setRequestProperty("User-Agent", USER_AGENT);
								con.setRequestProperty("User-Agent", HttpHeaders.USER_AGENT);
								con.setRequestProperty("Content-Type", "application/json");
								con.setRequestMethod("POST");
								con.setDoOutput(true);
								OutputStream os = con.getOutputStream();
								os.write(input.getBytes());
								os.flush();
								os.close();
								int responseCode = con.getResponseCode();
								System.out.println(responseCode);
				
									try {
										InputStream inputStream = con.getInputStream();
										System.out.println(inputStream);
									} catch (IOException e) {
										System.out.println(e.getMessage());
										System.out.println(e.getStackTrace());
										System.out.println("String: " + e.toString());
										System.out.println(e.toString().toString());
									}
							
									catch (Exception e) {
							
										e.printStackTrace();
										e.getMessage();
										e.getStackTrace();
							
									}
				
									if (responseCode == HttpURLConnection.HTTP_CREATED) { // success
										BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
										String inputLine;
										StringBuffer response = new StringBuffer();
							
										while ((inputLine = in.readLine()) != null) {
											response.append(inputLine);
										}
										in.close();
							
										// print result
										System.out.println(response.toString());
										String result_response=response.toString();
										String[] subresult=result_response.split(",");
										System.out.println(subresult[1]);
										String[] actualResult=subresult[1].split(":");
										GenericUtils.writeProperty(testscriptName.replace(" ", ""),actualResult[1].replace("\"",""));
										//decoding the String to image 
										// create a buffered image
//										BufferedImage image = null;
//										byte[] imageByte;
//							
//										BASE64Decoder decoder = new BASE64Decoder();
//										imageByte = decoder.decodeBuffer(FailureScreenshot);
//										ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
//										image = ImageIO.read(bis);
//										bis.close();
//							
//										// write the image to a file
//										File outputfile = new File("image.png");
//										ImageIO.write(image, "png", outputfile);
//										//insert image to created defect
//										addAttachmentToIssue(actualResult[1].replace("\"",""),outputfile);
//										update jira defect back to mongo db
										MongoDBUtils.updateJIRADefectID(DBName,TagName,testscriptName,actualResult[1].replace("\"",""));
									} else {
										System.out.println("POST request not worked");
									}
			            	
			            		
			            	}
		            	
		            	  
		             	
		          }
	 }
	}

	
	//=============================================================ATTACHMENT METHOD=================================================
		private static void addAttachmentToIssue(String issueKey, File fullfilename) throws IOException{
			 // String pathname= "H:\\Downloads\\ParserData.xls";
	       // String pathname= "C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg";
	       // File fileUpload = new File(fullfilename);
	        HttpClient httpClient = (HttpClient) HttpClientBuilder.create().build();
	        HttpPost postRequest = new HttpPost("https://agile.cotiviti.com/rest/api/2/issue/"+issueKey+"/attachments");
	        String cred = "raveendra.betha:Berlin!23";
            byte[] encoded = Base64.getEncoder().encode(cred.getBytes());
            String credentials = new String(encoded);

            //Setting the Authorization Header as 'Basic' with the given credentials
            postRequest.setHeader("Authorization", "Basic " + credentials);
	        postRequest.setHeader("X-Atlassian-Token","nocheck");
	        //send file input to post request by using multipart
	        MultipartEntityBuilder entity=MultipartEntityBuilder.create();
	        entity.addPart("file", new FileBody(fullfilename));
	        postRequest.setEntity( entity.build());
	        HttpResponse response = httpClient.execute(postRequest);
	        int StatusCode=response.getStatusLine().getStatusCode();
	        System.out.println(StatusCode);
	        if(StatusCode==200){
	        	System.out.println("SUCESS");
	        }else{
	        	System.out.println("FAILED");
	        }

	}
	//================================================Convert String input to JsonObject input==================================================>
	private static JsonObject Post_Input(String testScriptName,String FailureDescription){
		System.out.println(FailureDescription);
		JsonBuilderFactory factory =Json.createBuilderFactory(null);
		JsonObject jsonObj = factory.createObjectBuilder()
	            .add("fields", factory.createObjectBuilder()
	                    .add("summary", testScriptName)
	                    .add("issuetype",factory.createObjectBuilder().add("id","10007"))
	                    .add("project", factory.createObjectBuilder().add("id","10008"))
	                    .add("priority",factory.createObjectBuilder().add("name","3 - Normal"))
	            		.add("assignee", factory.createObjectBuilder().add("name","raveendra.betha"))
	            		.add("reporter", factory.createObjectBuilder().add("name","raveendra.betha"))
	            		.add("customfield_10705",factory.createObjectBuilder().add("value","Regression"))
	            		.add("description", FailureDescription)
	            		.add("fixVersions", factory.createArrayBuilder()
	            				.add(factory.createObjectBuilder()
	            						.add("name", "2019 June Software Release")))).build();
	    System.out.println(jsonObj);
		return jsonObj;
	}
		
//
}
