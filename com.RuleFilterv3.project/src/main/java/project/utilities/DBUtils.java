package project.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public  class DBUtils {	
	 
	public static String executeSQLQuery(String sqlQuery) {
		
		String queryResultValue = "";
		try {
			
			
			String sPassword = GenericUtils.decode(ProjectVariables.DB_PASSWORD);

			Class.forName(ProjectVariables.DB_DRIVER_NAME);
			Connection con = DriverManager.getConnection(ProjectVariables.DB_CONNECTION_URL,
					ProjectVariables.DB_USERNAME, sPassword);
			
			 try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}

			if (con != null) {
				System.out.println("Connected to the Database...");
			} else {
				System.out.println("Database connection failed ");
			}

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
				
			while (rs.next()) {

				if (rs.getString(1) != null) {
					queryResultValue = rs.getString(1).toString();
				}
				else {
					System.out.println("No value obtained from this specific query");
					return "";
				}
			}
			 
			  
			System.out.println("DB Result: " + queryResultValue);

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		catch (NullPointerException err) {
			System.out.println("No Records obtained for this specific query");
			err.printStackTrace();
		}

		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return queryResultValue;
	}

	public static ArrayList<String> executeSQLQueryMultipleRows(String sqlQuery) throws Exception
	{
				
		ArrayList<String> resultList = new ArrayList<String>();
	
	try {					
			String sPassword = GenericUtils.decode(ProjectVariables.DB_PASSWORD);        		
        	Class.forName(ProjectVariables.DB_DRIVER_NAME);
        	Connection conn = DriverManager.getConnection(ProjectVariables.DB_CONNECTION_URL,ProjectVariables.DB_USERNAME,sPassword);
        	
        	  if(conn!=null) {
                  System.out.println("Connected to the Database...");
              }else {
                  System.out.println("Database connection failed ");
              }
        	        	  
        	  String result;        	  
        	  Statement st = conn.createStatement();	        		
        	  ResultSet rs =st.executeQuery(sqlQuery);  
        	  
        	  int i = 0;
        	  while (rs.next() && i != 500) {
        	          result = rs.getString(1).toString();
        	          resultList.add(result);
        	          i = i + 1;
        	      }        	
        	           
        	  if (conn != null) {
      	    	conn.close();} 
   
            
        }catch (SQLException e) {
            e.printStackTrace();}
        
        catch (NullPointerException err) {
            System.out.println("No Records obtained for this specific query");
            err.printStackTrace();              }        
		
	     catch (ClassNotFoundException e1) {     		  		
				e1.printStackTrace();	}
	  
	  return resultList;
        
	}   

	public static ArrayList<String> db_GetAllColumnvalues(String sqlQuery, String sColumn) throws Exception {
	       
	       ArrayList<String> resultList = new ArrayList<String>();
	        Connection con=null;
	        
	       try {

	    	    Class.forName(ProjectVariables.DB_DRIVER_NAME);
	    	    String sPassword = GenericUtils.decode(ProjectVariables.DB_PASSWORD);				
				con = DriverManager.getConnection(ProjectVariables.DB_CONNECTION_URL,ProjectVariables.DB_USERNAME,sPassword);

	              if (con != null) {
	                     System.out.println("Connected to the Database...");
	              } else {
	                     System.out.println("Database connection failed ");
	              }

	              String result;

	              Statement st = con.createStatement();
	              ResultSet rs = st.executeQuery(sqlQuery);
	              ResultSetMetaData rsmd = rs.getMetaData();

	              int iColCount = rsmd.getColumnCount();
	              System.out.println("Column"+iColCount);
	              
	              while (rs.next()) {
	            	  	if(rs.getString(sColumn)!= null){
	                     result = rs.getString(sColumn).toString();
	                     System.out.println("Column data "+result);
	                     resultList.add(result); 
	            	  	}else{
	            	  		System.out.println("no data present ");
	            	  		resultList.add("");
	            	  	}
	              }

	              con.close();

	       } catch (SQLException e) {
	              e.printStackTrace();
	       }

	       catch (NullPointerException err) {
	              System.out.println("No Records obtained for this specific query");
	              
	       }

	       catch (ClassNotFoundException e1) {
	              e1.printStackTrace();
	       }

	       return resultList;

     }
	
	
	}	
		

        

