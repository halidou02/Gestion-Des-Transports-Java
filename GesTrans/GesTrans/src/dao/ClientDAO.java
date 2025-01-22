/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Client;
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
public class ClientDAO extends DAO<Client>{
 SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Client recherche(int id) {
        Client client = new Client();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from client where idclt="+id);
            if(result.next()){
                client.setIdclt(result.getInt("idclt"));
                client.setNom(result.getString("nom"));
                client.setPrenom(result.getString("prenom"));
                client.setTelephone(result.getString("telephone"));
                client.setAdresse(result.getString("adresse"));
                client.setGenre(result.getString("genre"));
                client.setCni(result.getString("cni"));
                client.setDateenrg(result.getDate("dateenrg"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return client;
    }

    @Override
    public void inserer(Client obj) {
       
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("insert into client(nom,prenom,telephone,adresse,genre, cni,dateenrg) values(?,?,?,?,?,?,?)");
            prepare.setString (1,obj.getNom());
            prepare.setString(2,obj.getPrenom());
            prepare.setString(3,obj.getTelephone());
            prepare.setString(4,obj.getAdresse());
            prepare.setString(5,obj.getGenre());
            prepare.setString(6,obj.getCni());
            prepare.setString(7,amj.format(obj.getDateenrg()));
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Client obj, int id) {
       
       try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("Update client set Nom=?,prenom=?,telephone=?, adresse=?, genre=?, cni=?, dateenrg=? where idclt="+id  );
            prepare.setString (1,obj.getNom());
            prepare.setString(2,obj.getPrenom());
            prepare.setString(3,obj.getTelephone());
            prepare.setString(4,obj.getAdresse());
            prepare.setString(5,obj.getGenre());
            prepare.setString(6,obj.getCni());
            prepare.setString(7,amj.format(obj.getDateenrg()));
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) {
         try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("delete from client where idclt="+id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Client> liste() {
         Client client = new Client();
         List<Client>lc=new ArrayList<>();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select *from client");
            while(result.next()){
                  client.setIdclt(result.getInt("idclt"));
                client.setNom(result.getString("nom"));
                client.setPrenom(result.getString("prenom"));
                client.setTelephone(result.getString("telephone"));
                client.setAdresse(result.getString("adresse"));
                client.setGenre(result.getString("genre"));
                client.setCni(result.getString("cni"));
                client.setDateenrg(result.getDate("dateenrg"));
                lc.add(client);
                client = new Client();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return lc;
    }
    
}
