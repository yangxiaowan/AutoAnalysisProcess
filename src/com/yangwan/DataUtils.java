package com.yangwan;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
