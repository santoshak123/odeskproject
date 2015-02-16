package com.odeskproj;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ThirdPage
 */
public class ThirdPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ThirdPage() {
    	super();
     }
    																	                    
	/** 																								
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Map fdata=new HashMap(); 
	  HttpSession session=request.getSession(false);
	  fdata=(HashMap)session.getAttribute("fdata");    
	  request.setAttribute("fdata", fdata);            
	  RequestDispatcher rd=request.getRequestDispatcher("/ThirdPage.jsp");		
	  rd.forward(request, response); 
	  
	}                                                     													

}
