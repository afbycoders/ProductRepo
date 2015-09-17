/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ab.scanner.launch;

import com.ab.scanner.ui.HomeUI;
import com.ab.scanner.utils.ObjectFactory;

/**
 *
 * @author KochiKaMama
 */
public class LaunchApplication {

    //public static HomeUI homeInstance;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ObjectFactory.getUIinstance().getHomeInstance().setVisible(true);
    }
    
}
