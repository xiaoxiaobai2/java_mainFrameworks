package com.zhanghao.utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0
 *
 */
public class C3P0Util {


	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	

	

	public static DataSource getDataSource(){
		return ds;
	}
	
	

	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}

	public static void main(String[] args) {
		System.out.println(getDataSource());
	}
}
