/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ab.scanner.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author KochiKaMama
 */
public class DBUtils {
    
    static Connection connection;
    
    
    
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
    
}
