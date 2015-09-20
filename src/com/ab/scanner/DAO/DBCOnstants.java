/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ab.scanner.DAO;

/**
 *
 * @author KochiKaMama
 */
public interface DBCOnstants {

    //---- connection urls and Credentials-------
    String DB_URL = "jdbc:mysql://localhost/";
    String USER = "root";
    String PWD = "root";
    String DRIVER = "com.mysql.jdbc.Driver";

    String DB_NAME = "Scanner";

    // -- Querys----
    String CREATE_DB_SCHEMA = "create database " + DB_NAME;
    
    String USE_DB = "use " + DB_NAME;
    
    String CREATE_TABLE = "create table products("
            + "pId mediumint NOT NULL AUTO_INCREMENT,"
            + "tkNo varchar(20),"
            + "description varchar(500),"
            + "orignalSize varchar(10),"
            + "leftSize varchar(10),"
            + "color varchar(10),"
            + "supplier varchar(10),"
            + "issueNo varchar(10),"
            + "issueDate date,"
            + "dateCreated TIMESTAMP not null DEFAULT NOW(),"
            + "barcode varchar(100),"
            + "primary key (pId)"
            + ")";
    
    String CREATE_TRANSACTION_DB = "create table transaction( tId mediumint NOT NULL AUTO_INCREMENT,"
            + "pid mediumint ,"
            + "dateCreated TIMESTAMP not null DEFAULT NOW() ,"
            + "type varchar(10),"
            + "primary key (tId ))";
    
    String INSERT_RECORD_QUERY = "insert into products(tkNo,"
            + "description ,orignalSize , leftSize,color,supplier ,issueNo ,"
            + "issueDate ,dateCreated  ,barcode )"
            + "values(?,?,?,?,?,?,?,?,?,?)";
    
    String INSERT_TRANSACTION_QUERY="insert into transaction(pid,type) values(?,?)";
    
    String FETCH_PRODUCT_LIST="select pId ,tkNo ,orignalSize ,leftSize ,color from products order by dateCreated desc";
    
    String GET_A_PRODUCT="select * from products where pId=?";
    
    String UPDATE_A_RECORD = "update products set tkNo=?,"
            + "description=? , orignalSize=? ,leftSize=? ,color=?,supplier=? ,issueNo=? ,"
            + "issueDate=? ,dateCreated=?  ,barcode=? "
            + " where pid=?";
    
    String UPDATE_BARCODE="update products set barcode=? where pid=?";

}
