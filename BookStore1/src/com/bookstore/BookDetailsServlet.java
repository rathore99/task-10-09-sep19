package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookDetailsServlet
 */
@WebServlet("/BookDetailsServlet")
public class BookDetailsServlet extends HttpServlet {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");
		PrintWriter out = response.getWriter();
		int cnt = 0;
		String bookCode = request.getParameter("code"); 
		try {
			
			if (request.getCookies() != null) {

				for (Cookie cookie : request.getCookies()) {
					if (cookie.getName().equals(bookCode)) {
						cnt = Integer.parseInt(cookie.getValue())+1;
						
						
						
					}
				}
			}
			
				String s = new Integer(cnt).toString();
				Cookie cntr = new Cookie(code,s );
				cntr.setMaxAge(60*60*24*30);
				response.addCookie(cntr);
			
			String sql = "SELECT * from book where bcode=" + code + ";";
			ResultSet rs = DBManager.getResultSet(sql);
			out.println("<html>");
			out.println("<html><body>");
			out.println("<h3>Book-Details</h3>");
			out.println("<hr>");
			while (rs.next()) {
				String bcode = rs.getString(1);
				String title = rs.getString(2);
				String subject = rs.getString(3);
				String price = rs.getString(4);
				String author = rs.getString(5);
				if(cnt>3){
					Integer bPrice = Integer.parseInt(price);
					bPrice = bPrice+ 500;
					price = bPrice.toString();
				}
				out.println("<table border=2>");
				out.println("<tr>");
				out.println("<td>BCode</td>");
				out.println("<td>" + bcode + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Title</td>");
				out.println("<td>" + title + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Author</td>");
				out.println("<td>" + author + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Subject</td>");
				out.println("<td>" + subject + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Price</td>");
				out.println("<td>" + price + "</td>");
				out.println("</tr>");
				out.println("</table>");
			}
			out.println("<hr>");
			out.println("<a href=CartManager?code=" + code + ">Add-To-Cart</a><br>");
			out.println("<a href=SubjectPageServlet>Subject-Page</a><br>");
			out.println("<a href=buyerpage.jsp>Buyer-Page</a><br>");
			out.println("</body></html>");

		} catch (Exception e) {
			out.println(e);
		}
	}
}