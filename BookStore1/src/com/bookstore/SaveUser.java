package com.bookstore;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SaveUser
 */
@WebServlet("/SaveUser")
public class SaveUser extends HttpServlet {
	
	private Connection con;
	private PreparedStatement ps;
	
	
	public void init(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","root");
		String sql="insert into user(username,password,mobile,email,address) values(?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void destroy(){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//reads-request
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		//process
		try{
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, mobile);
			ps.setString(4, email);
			ps.setString(5, address);
			int n=ps.executeUpdate();
			out.println("Registration Completed");
			out.print("<html><body><a href='login.jsp'>Login</a></body></html>");
			
		}catch(Exception e){
			out.println(e);
		}
		//provides-response
		
	}

}