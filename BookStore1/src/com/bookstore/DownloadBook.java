package com.bookstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/**
 * Servlet implementation class DownloadBook
 */
@WebServlet("/DownloadBook")
public class DownloadBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String fname = request.getParameter("name");
		 File f = new File("D:/Data/"+fname);
		 FileInputStream fis = new FileInputStream(f);
		 byte [] b = new byte[fis.available()];
		 fis.read(b);
		 int dotInd = fname.lastIndexOf('.');
		 String extension = fname.substring(dotInd);
		 if(extension==".pdf")
		 {
			response.setContentType("application/pdf");
		 }
		 else if(extension==".xlsx"){
			 response.setContentType("application/excel");
			 
		 }
		 ServletOutputStream sout =  response.getOutputStream();
		 sout.write(b);
		 sout.close();
		 fis.close();
	}
}
