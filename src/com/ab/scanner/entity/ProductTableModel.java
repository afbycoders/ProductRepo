/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ab.scanner.entity;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author KochiKaMama
 */
public class ProductTableModel extends AbstractTableModel{

    private List<ProductTable> listProduct;
    
    private final String[] columnNames = new String[] {
            "Product Id", "Tk No", "Total Quantity ", "Left ", "Color"
    };
    private final Class[] columnClass = new Class[] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
    };
    
    public List<ProductTable> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductTable> listProduct) {
        this.listProduct = listProduct;
    
    }
    
    @Override
    public int getRowCount() {
       return listProduct.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object ret=null;
        switch(columnIndex)
        {
            case 0:
                return listProduct.get(rowIndex).getProductId();
                
            case 1:
                return listProduct.get(rowIndex).getTkNo();
               
            case 2:
                return listProduct.get(rowIndex).getTotalQuality();
                
            case 3:
                return listProduct.get(rowIndex).getRemainingQuality();
                
            case 4:
                return listProduct.get(rowIndex).getColor();
                
            default:
                return listProduct.get(rowIndex).getProductId();
        }
        
    }
    
     @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
    
}
