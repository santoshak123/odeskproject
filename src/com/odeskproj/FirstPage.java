package com.odeskproj;
														
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class FirstPage extends HttpServlet {
	
   protected static String DB_URL=null;
   protected static String DB_DRIVER=null;
   protected static String DB_USERNAME=null;												
   protected static String DB_PASSWORD=null;
   protected static String DB_TABLE=null;
   protected static String DB_TABLE_FIRST_COLUMN=null;
   protected static String DB_TABLE_SECOND_COLUMN=null;
   Connection con=null;
   Statement st=null;
   ResultSet rs=null;
   Map<Integer,String> cityNames=new HashMap<Integer,String>();
   String queryStatement="";                                                                              
   ServletConfig config; 
   																		   	  						
   public void init() throws ServletException{	 																
 
	   FirstPage.DB_URL=getServletConfig().getInitParameter("DB_URL");
	   FirstPage.DB_DRIVER=getServletConfig().getInitParameter("DB_DRIVER");
	   FirstPage.DB_USERNAME=getServletConfig().getInitParameter("DB_USERNAME");                           
	   FirstPage.DB_PASSWORD=getServletConfig().getInitParameter("DB_PASSWORD");                         
	   FirstPage.DB_TABLE=getServletConfig().getInitParameter("DB_TABLE");		
	   FirstPage.DB_TABLE_FIRST_COLUMN=getServletConfig().getInitParameter("DB_TABLE_FIRST_COLUMN");		
	   FirstPage.DB_TABLE_SECOND_COLUMN=getServletConfig().getInitParameter("DB_TABLE_SECOND_COLUMN");	   	  	 
	   																										   
   }	
    /**
     * Default constructor. 
     */
    public FirstPage() {
    	super(); 
     }
    
   /**
    * Fetches data from db and bind to city drop down list 
    */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
    	 try{
  		      	   
      	   Class.forName(FirstPage.DB_DRIVER);
    	   con=DriverManager.getConnection(FirstPage.DB_URL,FirstPage.DB_USERNAME,FirstPage.DB_PASSWORD); 
  		   st=con.createStatement();
  		   queryStatement="select "+FirstPage.DB_TABLE_FIRST_COLUMN+","+FirstPage.DB_TABLE_SECOND_COLUMN+"  from "+FirstPage.DB_TABLE;
  		   rs=st.executeQuery(queryStatement);													
  		   while(rs.next()){											 		
  			   cityNames.put(rs.getInt(1), rs.getString(2));
  		   }
  		   																				
  	   }
  	   
  	   catch(Exception e1){
  		 e1.printStackTrace();           
  		 try{
  		 rs.close();
  		 st.close();
  		 con.close();
  		 }
  		 catch(Exception e2){															
  		 e2.printStackTrace();													
  		 }
  		   	                 
  	   }
    	 
       	 request.setAttribute("cityNames", cityNames);
    	 RequestDispatcher rd=request.getRequestDispatcher("/FirstPage.jsp");	 
      	 rd.forward(request, response); 
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Map<String, String> fdata=new HashMap<String, String>();
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		String sex=request.getParameter("sex");
		String city=request.getParameter("city"); 
		String zipcode=request.getParameter("zip");
		String country=request.getParameter("country");
		
		fdata.put("fname", firstName);
		fdata.put("lname", lastName);
		fdata.put("sex", sex);
		fdata.put("city", city);
		fdata.put("zip", zipcode);
		fdata.put("country", country);																
																									
		request.setAttribute("fdata", fdata); 													
									
		RequestDispatcher rd=request.getRequestDispatcher("/page2");		
		rd.forward(request, response);                                                          			
																				
	}																													

}