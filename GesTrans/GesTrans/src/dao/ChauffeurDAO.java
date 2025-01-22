/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Chauffeur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author halid
 */
public class ChauffeurDAO extends DAO<Chauffeur>{
 SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Chauffeur recherche(int id) {
        Chauffeur chauffeur = new Chauffeur();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from chauffeur where idchauf="+id);
            if(result.next()){
                chauffeur.setIdchauf(result.getInt("idchauf"));
                chauffeur.setNom(result.getString("nom"));
                chauffeur.setAdresse(result.getString("adresse"));
                chauffeur.setCni(result.getString("cni"));
                chauffeur.setSalaire(result.getInt("salaire"));
                chauffeur.setCar(result.getString("car"));
                chauffeur.setDate_enreg(result.getDate("date_enreg"));
                chauffeur.setStatut(result.getString("statut"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChauffeurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return chauffeur;
    }

    @Override
    public void inserer(Chauffeur obj) {
       
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("insert into chauffeur(nom,adresse,cni,salaire,car,date_enreg,statut) values(?,?,?,?,?,?,?)");
            prepare.setString(1,obj.getNom());
            prepare.setString (2,obj.getAdresse());
            prepare.setString(3,obj.getCni());
            prepare.setInt(4,obj.getSalaire());
             prepare.setString(5,obj.getCar());
            prepare.setString(6,amj.format(obj.getDate_enreg()));
             prepare.setString(7,obj.getStatut());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChauffeurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Chauffeur obj, int id) {
       
       try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("Update chauffeur set nom=?,Adresse=?, cni=?,salaire=?,car=?,date_enreg=?,statut=? where idchauf="+id  );
             prepare.setString(1,obj.getNom());
            prepare.setString (2,obj.getAdresse());
            prepare.setString(3,obj.getCni());
            prepare.setInt(4,obj.getSalaire());
             prepare.setString(5,obj.getCar());
            prepare.setString(6,amj.format(obj.getDate_enreg()));
             prepare.setString(7,obj.getStatut());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChauffeurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) {
         try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("delete from chauffeur where idchauf="+id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChauffeurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Chauffeur> liste() {
         Chauffeur chauffeur = new Chauffeur();
         List<Chauffeur>lt=new ArrayList<>();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select *from chauffeur");
            while(result.next()){
               chauffeur.setIdchauf(result.getInt("idchauf"));
                chauffeur.setNom(result.getString("nom"));
                chauffeur.setAdresse(result.getString("adresse"));
                chauffeur.setCni(result.getString("cni"));
                chauffeur.setSalaire(result.getInt("salaire"));
                chauffeur.setCar(result.getString("car"));
                chauffeur.setDate_enreg(result.getDate("date_enreg"));
                chauffeur.setStatut(result.getString("statut"));
                lt.add(chauffeur);
                chauffeur = new Chauffeur();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChauffeurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return lt;
    }
    
}
