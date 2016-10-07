package com.cg.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/DSApp2")
public class SimpleDSServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//	super.doGet(req, resp);
		PrintWriter out = response.getWriter();
		
		try {
			DataSource ds = ServiceLocator.getDataSource();
			Connection dbConnection = ds.getConnection();
			
			System.out.println("Connection successful ?"+(dbConnection!=null));
			
			if(ds!=null){
				ServletContext application = getServletConfig().getServletContext();
				application.setAttribute("connector", ds);
			}
		}catch(NamingException | SQLException e){
			e.printStackTrace();
		}			
		
	}
}
