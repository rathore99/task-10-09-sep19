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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerifyUser
 */
@WebServlet("/VerifyUser")
public class VerifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		try {
			if (usertype.equals("owner")) {
				if (username.equals("admin") && password.equals("admin99")) {
					HttpSession userSession = request.getSession();
					userSession.setAttribute("userid","1" );
					response.sendRedirect("adminpage.jsp");
				} else {
					out.println("INVALID CREDENTIALS FOR ADMIN");
				}
			} else {
				out.println("usertype buyer");
				String sql = "SELECT userid,username,email from user where username='" + username + "' AND password= '" + password + "';";
				ResultSet rs = DBManager.getResultSet(sql);
				out.println(rs);
				String userId = "";
				if (rs.next()) {
					do{
						userId = rs.getString(1);
						out.println(rs.getString(1));
						out.println(rs.getString(2));
						out.println(rs.getString(3));
					}while(rs.next());
					String choice = request.getParameter("save");
					if (choice != null) {
						Cookie uNameCookie = new Cookie("username", username);
						Cookie upswrdCookie = new Cookie("password", password);
						uNameCookie.setMaxAge(60 * 60 * 24 * 7);
						upswrdCookie.setMaxAge(60 * 60 * 24 * 7);
						response.addCookie(upswrdCookie);
						response.addCookie(uNameCookie);
					}
					
					HttpSession userSession = request.getSession();
					userSession.setAttribute("userid",userId );
					response.sendRedirect("buyerpage.jsp");
					// RequestDispatcher rd =
					// request.getRequestDispatcher("buyerpage.jsp");
					// rd.forward(request, response);

				} else {
					out.println("INVALID BUYER CREDENTIALS");
				}

			}

		} catch (Exception e) {
			
			e.printStackTrace();

		}

	}

}
