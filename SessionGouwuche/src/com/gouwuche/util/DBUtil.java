package com.gouwuche.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String DRIVER_URL="jdbc:mysql://localhost:3306/test";
	private static String DRIVER_USER="root";
	private static String DRIVER_PWD="123456";
	
	protected Connection conn;
	protected PreparedStatement pst;
	protected ResultSet rs;
	//配置驱动
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//链接数据库
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn= DriverManager.getConnection(DRIVER_URL, DRIVER_USER, DRIVER_PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//查询
	public ResultSet connSelect(String sql,Object...params){
		conn=getConnection();
		try {
			pst=conn.prepareStatement(sql);
			if(params.length>0 && params!=null){
				setValues(pst,params);
			}
			rs=pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	private void setValues(PreparedStatement pst2, Object[] params) throws SQLException {
		for(int i=0;i<params.length;i++){
			pst.setObject(i+1, params[i]);
		}
		
	}
	//增删改
	public int connUpdate(String sql,Object...params){
		int result =0;
		conn=getConnection();
		try {
			pst=conn.prepareStatement(sql);
			if(params.length>0 && params !=null){
				setValues(pst, params);
			}
			result=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(conn, pst, rs);
		}
		return result ;
	}
	//关闭数据库
	public void closeAll(Connection conn,PreparedStatement pst,ResultSet rs){
		try {
			if(rs !=null){
				rs.close();
			}
			if(pst !=null){
				pst.close();
			}
			if(conn !=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		new DBUtil();
//		System.out.println(DRIVER);
//	}
	
}
