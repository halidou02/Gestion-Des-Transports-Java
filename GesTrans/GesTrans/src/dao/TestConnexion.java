/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;

/**
 *
 * @author Badking
 */
public class TestConnexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection connect= Connectdb.getInstance();
        if (connect!=null){
            System.out.println("Connexion effective");
        }
        else{
            System.out.println("Pas de connexion");
        }
    }
    
}
