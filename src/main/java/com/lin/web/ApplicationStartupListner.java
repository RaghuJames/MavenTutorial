package com.lin.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationStartupListner implements ServletContextListener {

	public void contextInitialized(ServletContextEvent context) {
		Connection connection = null;
		Statement statement = null;
		ServletContext sc = context.getServletContext();
		String fileName = sc.getRealPath(Constants.jdbcPath);
		if(fileName!=null){
			Util.loadProperties(fileName);
			String jdbcDriver = Util.getPropertyString("jdbc.driverClassName");
			String url = Util.getPropertyString("jdbc.url");
			String user= Util.getPropertyString("jdbc.username");
			String pass= Util.getPropertyString("jdbc.password");
			try {
				System.out.println("--url"+url);
				System.out.println("--user-- ** "+user);
				Class.forName(jdbcDriver);
				connection = DriverManager.getConnection(url,user,pass);
				statement = connection.createStatement();
				System.out.println("---------CONNECTION SUCCESSFUL------>>>>>>>>> ");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(connection!=null){
					try {
						connection.close();
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
			}
			
			
		}
		
	}


public void contextDestroyed(ServletContextEvent context) {
	
	
	
}
}