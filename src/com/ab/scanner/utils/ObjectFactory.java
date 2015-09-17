/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ab.scanner.utils;

import com.ab.scanner.DAO.DBaccess;
import com.ab.scanner.ui.HomeUI;
import com.ab.scanner.ui.ProductDetailUI;

/**
 *
 * @author KochiKaMama
 */
public class ObjectFactory {
    
    private HomeUI homeInstance;
    
    private static ObjectFactory uIinstances;
    
    private ProductDetailUI productUI;
    
    private DBaccess dbObject;
    
    private ObjectFactory()
    {
        //avoid creation of multiple instances
    }
    
    public static ObjectFactory getUIinstance()
    {
        if(uIinstances==null)
        {
           uIinstances=new ObjectFactory();
        }
        
        return uIinstances;
    }

    public DBaccess getDbObject() {
        if(dbObject==null)
        {
            dbObject=new DBaccess();
        }
        return dbObject;
    }

  
    

    public HomeUI getHomeInstance() {
        if(homeInstance==null)
        {
            homeInstance=new HomeUI();
        }
            return homeInstance;
    }

    public ProductDetailUI getProductUI() {
        if(productUI==null)
        {
            productUI=new ProductDetailUI();
        }
        return productUI;
    }

}
