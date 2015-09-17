/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ab.scanner.DAO;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author KochiKaMama
 */
public class DBaccess {

    DBaccess dbObject;
    public DBaccess() {
    }
    
    
    
    
    public boolean createDBschema ()throws Exception
    {
        boolean result=false;
        Statement stmt=null;
        try {
            Connection con=DBUtils.getConnection();
            stmt=con.createStatement();
            result=stmt.execute(DBCOnstants.CREATE_DB_SCHEMA);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally{
           stmt.close();
           
        }
        
        return true;
    }
    
    
}
