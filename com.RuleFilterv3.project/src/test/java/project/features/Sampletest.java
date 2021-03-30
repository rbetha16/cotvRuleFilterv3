package project.features;

import java.awt.image.BufferedImage;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
import javax.net.ssl.SSLContext;

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
import project.pageobjects.CustomSSLSocketFactory;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import sun.security.jca.GetInstance;
import sun.security.jca.ProviderList;
import sun.security.jca.Providers;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;


public class Sampletest   {
	

	static MongoClient mongoClient;
	static MongoDatabase db;
	static MongoCollection<Document> mColl;
	static FindIterable<Document> results;
	static MongoCursor<Document> cursor;
	static long recordsCount;
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException{
		
//		enableTLSv12ForMssqlJdbc() ;
		
		CustomSSLSocketFactory();
		
//    	 URL obj = new URL("https://jira2.cotiviti.com/secure/Dashboard.jspa");

    	 URL obj = new URL("https://jira2.cotiviti.com/secure/Dashboard.jspa");
    	 HttpURLConnection con = (HttpsURLConnection) obj.openConnection();
			((HttpsURLConnection) con).setHostnameVerifier(new SSLSkipSNIHostnameVerifier());
			
			
			con.setRequestMethod("POST");
			
			//Prepairing credentials
         String cred = "Raveendra.Betha:Berlincity&77";
         byte[] encoded = Base64.getEncoder().encode(cred.getBytes());
         String credentials = new String(encoded);

         //Setting the Authorization Header as 'Basic' with the given credentials
         con.setRequestProperty("Authorization", "Basic " + credentials);
			
			
		//	con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("User-Agent", HttpHeaders.USER_AGENT);
			
			int responseCode = con.getResponseCode();
		
//		String prriority=null;
//   	 	String releaseName=null;
//   	 	String executionTime=null;
//   	 	String testscriptName=null;
//   	 	String Description=null;
//   	 	String TagName=null;
//   	 	String FailureScreenshot;
//   	 	String sDescription ="";
//   	 	
//   	 	mongoClient = new MongoClient(new ServerAddress(ProjectVariables.Zero_Touch_MONGO_SERVER_URL, ProjectVariables.Zero_Touch_MONGO_SERVER_PORT));
//		db = mongoClient.getDatabase("CPT_ICD_Links");
//		mColl = db.getCollection("CPTICDLinks_Test_Lab");
//		cursor = mColl.find().iterator();
//		results = mColl.find();
//		recordsCount = mColl.count();
//		
//
//	
//		MongoCursor<String> l1 = mColl.distinct("sourceName",
//	            String.class).iterator();
//		List<String> l3 = new ArrayList<String>();
//
//	    try{
//	        while(l1.hasNext()){
//	            l3.add(l1.next());
//	            System.out.println(l3.toString());
//	        }
//	    }finally{
//	        l1.close();
//	    }
		
		
		
		 
		
		  
//		  Map<String,String> gfg = new HashMap<String,String>(); 
//	             
//	        // using for-each loop for iteration over Map.entrySet() 
//	        for (Map.Entry<String,String> entry : gfg.entrySet()) 

		
		 
	}
	
	
	
	
	
	private static void CustomSSLSocketFactory() {
		// TODO Auto-generated method stub
		
	}





	
	public static void enableTLSv12ForMssqlJdbc() throws NoSuchAlgorithmException, KeyManagementException, IOException
	{
		
	
		
		SSLContext context = SSLContext.getInstance("TLSv1.2");
		context.init(null,null,null);
		SSLContext.setDefault(context); 
		SSLSocketFactory factory = (SSLSocketFactory)context.getSocketFactory();
		SSLSocket socket = (SSLSocket)factory.createSocket();
//		 ArrayList<String> protocols = socket.getEnabledProtocols();
		 ArrayList<String> secureProtocols = new ArrayList<>();
		 
		 for (String p : socket.getEnabledProtocols()) {
			   if (!p.contains("TLSv1.2")) {
				   secureProtocols.add(p);
			   }
		 }
			  socket.setEnabledProtocols(secureProtocols.toArray(
			      new String[secureProtocols.size()]));
			 
	}
	

}