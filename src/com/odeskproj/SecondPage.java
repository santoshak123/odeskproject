package com.odeskproj;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class SecondPage
 */
public class SecondPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SecondPage() {
    	super();
     } 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map fdata=new HashMap();
		fdata=(Map)request.getAttribute("fdata");
		HttpSession session=request.getSession();
		session.setAttribute("fdata", fdata);
		RequestDispatcher rd=request.getRequestDispatcher("/SecondPage.jsp");						 
		rd.forward(request, response);                                                                  
 	}

}
