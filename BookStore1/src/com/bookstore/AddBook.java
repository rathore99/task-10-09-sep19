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
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private Connection con;
	private PreparedStatement ps;

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "root");
			String sql = "insert into book values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	
		PrintWriter out = response.getWriter();
		// reads-request
		String bookCode = request.getParameter("bookcode");
		String bookName = request.getParameter("bookname");
		String subject = request.getParameter("subject");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String fileName = request.getParameter("image");
		out.println(bookCode+" "+bookName+" "+subject+" "+author+" "+ price+"  "+fileName);
		try {
			ps.setString(1, bookCode);
			ps.setString(2, bookName);
			ps.setString(3, subject);
			ps.setString(4, price);
			ps.setString(5, author);
			ps.setString(6,fileName);
			int n = ps.executeUpdate();
			out.println("New book added successfully");

		} catch (Exception e) {
			out.println(e);
		}
		// provides-response

	}

}
