package com.k.util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;


public  class BaseDao {
	
	private static String driver;
	private static String url; 
	private static String user; 
	private static String password; 
   Connection conn = null;
	
	static{
		init();
	}
	
		public static void init(){
			
			Properties params=new Properties();
			String configFile = "database.properties";
			InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(configFile);
			
			try {
				params.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			driver=params.getProperty("driver");
			url=params.getProperty("url");
			user=params.getProperty("user");
			password=params.getProperty("password");
		}   

	public Connection getConnection() {
		if(conn==null){

			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		
		System.out.println("连接数据库成功");
		return conn;
	}

	public void closeAll(Connection conn, Statement stmt, 
					ResultSet rs ) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
  
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int exceuteUpdate(String preparedSql, Object[] param) {
		PreparedStatement pstmt = null;
		int num = 0;
		conn =  getConnection(); 
		try {
			pstmt = conn.prepareStatement(preparedSql);
			
			if (param != null) {
				
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]); 
					
				}
			}
			num = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(conn, pstmt, null);
		}
		return num;
	}
	

		
	
 public <T>List<T> query(String preparedSql, Object[] params, Class<T> clazz){
		
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 //创建List集合，存放数据库查询出来的数据
		 List<T> list = new ArrayList<T>();
		 //要封装的对象
		 T t = null;
		 try {
			
			 
			//获取连接
			 conn =  getConnection(); 
				
			 //创建执行命令的stmt对象
			 pstmt = conn.prepareStatement(preparedSql);
			 //通过参数元数据，得到占位参数的个数
			 int paramsCount = pstmt.getParameterMetaData().getParameterCount();
			 //设置占位符参数的值
			 
			 if(params!=null && params.length>0){
				 //循环给参数赋值
				 for(int i=0; i<paramsCount; i++){
					 pstmt.setObject(i+1, params[i]);
				 }
			 }
			 //执行查询
			 rs = pstmt.executeQuery();
			 //获取结果集元数据
			 
			ResultSetMetaData rsMeta =  rs.getMetaData();
			 //获取列的个数
			 int columnCount = rsMeta.getColumnCount();
			 //System.out.println(columnCount);
			 //遍历结果集，迭代每一行
			 while(rs.next()){
				 //创建要封装的T对象
				 t = clazz.newInstance();
				 //遍历每一行的每一列
				 for(int i=0; i<columnCount; i++){
					 //获取每一列的名称
					 String columnName = rsMeta.getColumnName(i+1);
					 //获取该行对应列名称的值
					 Object objectValue = rs.getObject(columnName);
					 //利用BeanUtils将属性拷贝到对象中
					BeanUtils.copyProperty(t, columnName, objectValue);//注意日期类型的数据保存，需要注册日期类型注册前
				 
				 }
				 
				 
				 //将封装完毕的t对象存入list集合中
				 list.add(t);
			 }
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		 return list;
	 }
}
	

