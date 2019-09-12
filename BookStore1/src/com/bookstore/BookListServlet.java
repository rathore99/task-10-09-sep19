package com.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String subject=request.getParameter("subject");
		PrintWriter out=response.getWriter();
		try{
		String sub = request.getParameter("subject");
		sub = sub.replace(" ", "+");
		//System.out.println(sub);
		Cookie usrChoiceSub = new Cookie("subject",sub);
		usrChoiceSub.setMaxAge(60*60*24);
		response.addCookie(usrChoiceSub);
		String sql="SELECT bcode,bname from book where subject like '%"+subject+"%';";
		ResultSet rs = DBManager.getResultSet(sql);
		out.println("<html>");
		out.println("<html><body>");
		out.println("<h3>Select The Desired bookname</h3>");
		out.println("<hr>");
		while(rs.next()){
			String code=rs.getString(1);
			String bookname=rs.getString(2);
			
			out.println("<a href=BookDetailsServlet?code="+code+">");
			out.println(bookname);
			out.println("</a><br>");
		}
		out.println("<hr>");
		out.println("<a href=SubjectPageServlet>Subject-Page</a>");
		out.println("<a href=buyerpage.jsp>Buyer-Page</a>");
		out.println("</body></html>");
		
		
		
		
		}catch(Exception e){
			
			out.println("error occured");
			out.println(e);
		}
	}
}