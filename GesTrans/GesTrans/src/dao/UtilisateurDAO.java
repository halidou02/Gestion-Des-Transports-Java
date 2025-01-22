/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import classe.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Halidou
 */
public class UtilisateurDAO extends DAO<Utilisateur>{

    @Override
    public Utilisateur recherche(int id) {
       Utilisateur utilisateur = new Utilisateur();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from utilisateur where idu="+id);
            if(result.next()){
                utilisateur.setIdu(result.getInt("idu"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setLogin(result.getString("login"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setProfil(result.getString("Profil"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return utilisateur;
    }

    @Override
    public void inserer(Utilisateur obj) {
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("insert into utilisateur(nom,login,password,profil) values(?,?,?,?)");
            prepare.setString (1,obj.getNom());
            prepare.setString(2,obj.getLogin());
            prepare.setString(3,obj.getPassword());
            prepare.setString(4,obj.getProfil());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }



    @Override
    public void modifier(Utilisateur obj, int id) {
       try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("Update utilisateur set Nom=?,login =?,password=?, profil=? where idu="+id  );
             prepare.setString (1,obj.getNom());
            prepare.setString(2,obj.getLogin());
            prepare.setString(3,obj.getPassword());
            prepare.setString(4,obj.getProfil());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("delete from utilisateur where idu="+id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Utilisateur> liste() {
          Utilisateur utilisateur = new Utilisateur();
         List<Utilisateur>lu=new ArrayList<>();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select *from utilisateur");
            while(result.next()){
                 utilisateur.setIdu(result.getInt("idu"));
                utilisateur.setNom(result.getString("nom"));
                utilisateur.setLogin(result.getString("login"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setProfil(result.getString("Profil"));
                lu.add(utilisateur);
                utilisateur = new Utilisateur();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return lu;
    }
        public boolean connexion(String login, String password) {
       boolean v = false;
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from utilisateur where login='"+login+"' and password='"+password+"'");
            if(result.next()){
               v=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return v;
    }
            public String getProfil(String login, String password) {
        String v = null;
        try {

            ResultSet result = this.connect.createStatement().executeQuery("select * from utilisateur where login='" + login + "' and password='" + password + "'");
            if (result.next()) {
                v = result.getString("profil");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }
    }

  
    
    
