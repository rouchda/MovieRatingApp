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

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uname, pass;

		response.setContentType("text/html");
		uname = request.getParameter("username");
		pass = request.getParameter("password");
		PrintWriter out = response.getWriter();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/registeredusers", "root", "maher");
			String query = "SELECT * from userdata where username= ? AND password= ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				out.println("User Already Registered");
			} else {
				String query2 = "INSERT INTO userdata(username,password) VALUES(?,?)";
				PreparedStatement ps2 = con.prepareStatement(query2);
				ps2.setString(1, uname);
				ps2.setString(2, pass);
				int i = ps2.executeUpdate();
				out.println("User Registered" + i);

			}

		} catch (Exception e) {
			e.printStackTrace();
			out.println("Data has not been inserted");
		}

	}

}
