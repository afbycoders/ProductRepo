/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ab.scanner.entity;

/**
 *
 * @author KochiKaMama
 */
public class ProductTable {
    
    String tkNo;
    String productId;
    String totalQuality;
    String remainingQuality;
    String color;

    public String getTkNo() {
        return tkNo;
    }

    public void setTkNo(String tkNo) {
        this.tkNo = tkNo;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTotalQuality() {
        return totalQuality;
    }

    public void setTotalQuality(String totalQuality) {
        this.totalQuality = totalQuality;
    }

    public String getRemainingQuality() {
        return remainingQuality;
    }

    public void setRemainingQuality(String remainingQuality) {
        this.remainingQuality = remainingQuality;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
