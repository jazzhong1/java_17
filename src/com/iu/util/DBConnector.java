package com.iu.util;

import java.sql.*;

public  class DBConnector {
	
	public static Connection getConnect(){
		
		String	user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";	
		Connection con =null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		return con;
		
	}
	
	//st,con,
	public static void disConnect(PreparedStatement st, Connection con){
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection con){
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}
}
