package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uname, pass, action;
		response.setContentType("text/html");
		uname = request.getParameter("username");
		pass = request.getParameter("password");
		action =  request.getParameter("value");
		PrintWriter out = response.getWriter();
		if(action!=null&& action.equalsIgnoreCase("gotoRegister"))
		{
			out.println("You will be forwarded to Register Page");
		}else {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/registeredusers", "root", "maher");
			String query = "SELECT * from userdata where username= ? AND password= ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			out.println("You are logged in");
		}else
		{
			out.println("Invalid Username and Password");
		}
		
		
		} catch (Exception e) {
         e.printStackTrace();
		}
		}

	}

}
