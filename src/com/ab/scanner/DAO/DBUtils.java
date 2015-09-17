/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ab.scanner.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author KochiKaMama
 */
public class DBUtils {
    
    static Connection connection;
    static PreparedStatement pstmt;
    
    
    public static Connection getConnection()
    {
        try{
        if(connection==null)
        {
            Class.forName(DBCOnstants.DRIVER);
            connection=DriverManager.getConnection(DBCOnstants.DB_URL,DBCOnstants.USER,DBCOnstants.PWD);
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return connection;
    }
    
    public static Connection getConnectionDatabase()
    {
        try{
        if(connection==null)
        {
            Class.forName(DBCOnstants.DRIVER);
            connection=DriverManager.getConnection(DBCOnstants.DB_URL+DBCOnstants.DB_NAME,DBCOnstants.USER,DBCOnstants.PWD);
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return connection;
    }
    
    public static PreparedStatement getPreparedStatmentQuery(String query) throws Exception
    {
        if(pstmt==null)
        {
            pstmt=getConnectionDatabase().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        }
        return pstmt;
    }
    
   
    
   
    
}
