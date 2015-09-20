/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ab.scanner.DAO;

import com.ab.scanner.entity.Product;
import com.ab.scanner.entity.ProductTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        Connection con=null;
        try {
            con=DBUtils.getConnection();
            stmt=con.createStatement();
            result=stmt.execute(DBCOnstants.CREATE_DB_SCHEMA);
            stmt.execute(DBCOnstants.USE_DB);
            stmt.execute(DBCOnstants.CREATE_TABLE);
            stmt.execute(DBCOnstants.CREATE_TRANSACTION_DB);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally{
           stmt.close();
           con.close();
           
        }
        
        return true;
    }
    
    public int insertProduct(Product p) throws Exception
    {
        boolean result=false;
        PreparedStatement stmt=null;
        try {
               
                //stmt=DBUtils.getPreparedStatmentQuery(DBCOnstants.INSERT_RECORD_QUERY);
                stmt=DBUtils.getConnectionDatabase().prepareStatement(DBCOnstants.INSERT_RECORD_QUERY,Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, p.getTkNo());
                stmt.setString(2, p.getDescription());
                stmt.setString(3, p.getOrignalSize());
                stmt.setString(4, p.getLefetSize());
                stmt.setString(5, p.getColor());
                stmt.setString(6, p.getSupplier());
                stmt.setString(7, p.getIssueNo());
                
                String issuedate=p.getIssueDate();
                Date issuedateUtil=new SimpleDateFormat("dd-mm-yyyy").parse(issuedate);
                java.sql.Date sqlDate=new java.sql.Date(issuedateUtil.getTime());
                stmt.setDate(8, sqlDate);
                
                java.sql.Date sqlDateCurrent=new java.sql.Date(System.currentTimeMillis());
                stmt.setDate(9, sqlDateCurrent);
                
                stmt.setString(10, "0");
                stmt.executeUpdate();
                ResultSet rs=stmt.getGeneratedKeys();
                while(rs.next())
                {
                    return rs.getInt(1);
                }
                
                
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            stmt.close();
        }
        return 0;
        
    }
    
    
    
    public List<ProductTable> getProductList()
    {
        Statement stmt=null;
        List<ProductTable> list=new ArrayList<>();
        try {
            stmt=DBUtils.getConnectionDatabase().createStatement();
            ResultSet rs=stmt.executeQuery(DBCOnstants.FETCH_PRODUCT_LIST);
            while(rs.next())
            {
                ProductTable pt=new ProductTable();
                pt.setColor(rs.getString("color"));
                pt.setProductId(rs.getString("pId"));
                pt.setRemainingQuality(rs.getString("leftSize"));
                pt.setTkNo(rs.getString("tkNo"));
                pt.setTotalQuality(rs.getString("orignalSize"));
                
                list.add(pt);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;  
    }
    
    public Product getProduct(Integer pId)
    {
        Product p=null;
        try {
            PreparedStatement pst=DBUtils.getPreparedStatmentQuery(DBCOnstants.GET_A_PRODUCT);
            pst.setInt(1, pId);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                p=new Product();
                p.setBarcode(rs.getString("barcode"));
                p.setColor(rs.getString("color"));
                p.setDdatCreated(rs.getString("dateCreated"));
                p.setDescription(rs.getString("description"));
                p.setIssueDate(rs.getString("issueDate"));
                p.setIssueNo(rs.getString("issueNo"));
                p.setLefetSize(rs.getString("leftSize"));
                p.setOrignalSize(rs.getString("orignalSize"));
                p.setSupplier(rs.getString("supplier"));
                p.setTkNo(rs.getString("tkNo"));
                p.setpId(rs.getInt("pId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
    public boolean updateRecord(Product p) throws Exception
    {
        boolean result=false;
        PreparedStatement stmt=null;
        try {
                //stmt=DBUtils.getConnectionDatabase().prepareStatement(DBCOnstants.UPDATE_A_RECORD);
                stmt=DBUtils.getConnectionDatabase().prepareStatement(DBCOnstants.UPDATE_A_RECORD);
                stmt.setString(1, p.getTkNo());
                stmt.setString(2, p.getDescription());
                stmt.setString(3, p.getOrignalSize());
                stmt.setString(4, p.getLefetSize());
                stmt.setString(5, p.getColor());
                stmt.setString(6, p.getSupplier());
                stmt.setString(7, p.getIssueNo());
                stmt.setString(8, p.getIssueDate());
                stmt.setString(9, p.getDdatCreated());
                stmt.setString(10, p.getBarcode());
                stmt.setInt(11, p.getpId());
                
                int i=stmt.executeUpdate();
                System.out.println(i+" is updated");
                result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            stmt.close();
        }
        return result;
    }
    
    
    public boolean updateBarcode(Integer pid,String barcode)
    {
        boolean bool=false;
        PreparedStatement stmt=null;
        try {
            stmt=DBUtils.getConnectionDatabase().prepareStatement(DBCOnstants.UPDATE_BARCODE);
            stmt.setString(1, barcode);
            stmt.setInt(2, pid);
            stmt.executeUpdate();
            bool=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }
}
