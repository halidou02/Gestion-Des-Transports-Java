/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Badking
 */
public abstract class DAO<T> {
    public Connection connect= Connectdb.getInstance();
    //Recherche
    public abstract T recherche(int id);
    //inserer
    public abstract void inserer(T obj);
    //modifier
    public abstract void modifier(T obj,int id);
    //supprimer
    public abstract void supprimer(int id);
    //liste
    public abstract List<T>liste();
    
    
}
