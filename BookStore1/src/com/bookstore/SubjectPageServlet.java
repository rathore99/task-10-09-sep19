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
 * Servlet implementation class SubjectPageServlet
 */
@WebServlet("/SubjectPageServlet")
public class SubjectPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			String subName = "All";
			if(request.getCookies() != null){
				
				for(Cookie cookie: request.getCookies()){
					if(cookie.getName().equals("subject")){
						subName = cookie.getValue();
						subName = subName.replace("+", " ");
					}
				}
			}
			String sql = "SELECT distinct subject from book";
			
			ResultSet rs = DBManager.getResultSet(sql);
			out.println("<html>");
			out.println("<html><body>");
			out.println("<marquee><h4>Attractive Offers On "+subName+" Books </h4></marquee>");
			out.println("<h3>Select The Desired Subject</h3>");
			out.println("<hr>");
			while (rs.next()) {
				String sub = rs.getString(1);
				String newSub =sub.replace(' ', '+');
				out.println("<a href=BookListServlet?subject=" +newSub+ ">");
				out.println(sub);
				out.println("</a><br>");
			}
			out.println("<hr>");
			out.println("<a href=buyerpage.jsp>Buyer-Page</a>");
			out.println("</body></html>");

		} catch (Exception e) {
			out.println(e);
		}
	}

}
