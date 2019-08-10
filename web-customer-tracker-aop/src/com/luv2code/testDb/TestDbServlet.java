package com.luv2code.testDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
 class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="root";
		String pass="root";
		String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		try{
			PrintWriter out =response.getWriter();
			out.println("Connecting to:"+url);
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,pass);
			out.println("SUCCESS!!!!");
			con.close();
		}
		catch(Exception exc){
			exc.printStackTrace();
			throw new ServletException(exc);
			
		}
	}

}
