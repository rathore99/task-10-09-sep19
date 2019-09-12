package com.bookstore;

import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class DBManager
 */
@WebServlet("/DBManager")
public class DBManager extends HttpServlet {

	private static Connection con;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String CONSTRING = "jdbc:mysql://localhost:3306/bookstore";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	/**
	     * create Database object
	     */
	    public DBManager() {
	    }

	/**
	 * to load the database base driver
	 * 
	 * @return a database connection
	 * @throws SQLException
	 *             throws an exception if an error occurs
	 */
	public static Connection loadDriver() throws SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		con = DriverManager.getConnection(CONSTRING, USER, PASSWORD);
		return con;
	}

	/**
	 * to get a result set of a query
	 * 
	 * @param query
	 *            custom query
	 * @return a result set of custom query
	 * @throws SQLException
	 *             throws an exception if an error occurs
	 */
	public static ResultSet getResultSet(String query) throws SQLException {
		Connection con = loadDriver();
		ResultSet rs;
		PreparedStatement st = con.prepareStatement(query);
		rs = st.executeQuery();
		//con.close();
		return rs;
	}

	/**
	 * to run an update query such as update, delete
	 * 
	 * @param query
	 *            custom query
	 * @throws SQLException
	 *             throws an exception if an error occurs
	 */
	public static void runQuery(String query) throws SQLException {
		Connection con = loadDriver();
		//ResultSet rs;
		PreparedStatement st = con.prepareStatement(query);
		st.executeUpdate();
		con.close();
	}
}
