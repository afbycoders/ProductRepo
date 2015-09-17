/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ab.scanner.DAO;

import com.ab.scanner.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            stmt.execute(DBCOnstants.USE_DB);
            stmt.execute(DBCOnstants.CREATE_TABLE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally{
           stmt.close();
           
        }
        
        return true;
    }
    
    public boolean insertProduct(Product p) throws Exception
    {
        boolean result=false;
        PreparedStatement stmt=null;
        try {
                Connection con=DBUtils.getConnection();
                stmt=con.prepareStatement(DBCOnstants.INSERT_TABLE);
                stmt.setString(1, p.getTkNo());
                stmt.setString(2, p.getDescription());
                stmt.setString(3, p.getOrignalSize());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            stmt.close();
        }
        return result;
        
    }
    
    
}
