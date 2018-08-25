package com.capgemini.ams.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.capgemini.ams.exception.AMSException;
import com.capgemini.ams.dao.IQueryMapper;


public class DBUtil {
	private static Connection connection = null;

	public static Connection establishConnection() throws SQLException {
		
			connection = DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521:orcl","trg210","training210");
			return connection;
		
	}
}