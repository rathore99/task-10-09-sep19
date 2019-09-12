package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchBooks
 */
@WebServlet("/SearchBooks")
public class SearchBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement ps;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchBooks() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "root");
			String sql = "select bname,author,price from book where subject=?";
			ps = con.prepareStatement(sql);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String subject = request.getParameter("booksubject");
		try {
			ps.setString(1, subject);
			ResultSet rs = ps.executeQuery();
			out.println("<html><body>");
			out.println("<h2>List of Books</h2>");
			while(rs.next()){
				out.println("<p>"+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+"</p>");
			}
			out.println("</body></html>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
