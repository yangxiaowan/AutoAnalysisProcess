package com.yangwan;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.StringUtils;

public class DataUtils{  
    private static final String databasePath = "jdbc:mysql://172.19.100.2:3306/djadmin";  
    private static final String driverPath = "com.mysql.jdbc.Driver";  
    private String userName = "root";  
    private String password = "qmc2016";  
    private Connection connection = null;  
    public DataUtils(){  
        try {  
            Class.forName(driverPath);  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
        System.out.println("加载数据库驱动成功");  
    }  
    public boolean getConnectionToSQL(){  
        try {  
        	connection = DriverManager.getConnection(databasePath,userName,password);  
             return true;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return false;  
    }
    
    public void saveData(List<String> list){
    	Statement stmt = null;
    	try {
    		stmt = connection.createStatement();
    		String sql = "select path from permission where description='"+list.get(0)+"'";
    		ResultSet resultSet = stmt.executeQuery(sql);
    		if(resultSet.next()){
    			if(!StringUtils.isNullOrEmpty(resultSet.getString("path"))&& !resultSet.getString("path").equals(list.get(2))){
    				System.out.println("修改"+list.get(0));
    				sql = "update permission set path='"+list.get(2)+"'"+" where description='"+list.get(0)+"'";
    				stmt.executeUpdate(sql);
    				System.out.println("修改成功"+list.get(0));
    			}
    		}else{
    			System.out.println("新增"+list.get(0));
    			sql = "INSERT INTO `permission`(`description`,`module`,`path`) values ('"+list.get(0)+"','"+list.get(1)+"','"+list.get(2)+"')";
    			stmt.executeUpdate(sql);
    			System.out.println("新增成功"+list.get(0));
    		}
		} catch (Exception e) {
		}finally{
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
    }
    
    public void closeSql(){
    	if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
    
}  
