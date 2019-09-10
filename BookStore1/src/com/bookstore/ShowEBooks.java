package com.bookstore;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowEBooks
 */
@WebServlet("/ShowEBooks")
public class ShowEBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			 PrintWriter out  = response.getWriter();
			File file = new File("D:/Data/");
		 File  [] files = file.listFiles();
		 if(file.isDirectory()){
			 String name ="";
		     for(File fname:files){
		    	 name =fname.getName();
		    	 out.println("<a href='DownloadBook?name="+name+"'>"+name+"</a><br/>");
		     }
		 }
			
		

}

}
