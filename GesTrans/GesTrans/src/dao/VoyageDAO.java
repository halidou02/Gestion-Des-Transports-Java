/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import classe.Voyage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Badking
 */
public class VoyageDAO extends DAO<Voyage>{
SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Voyage recherche(int id) {
         Voyage voyage = new Voyage();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from voyage where idvoy="+id);
            if(result.next()){
                voyage.setIdvoy(result.getInt("idvoy"));
                voyage.setSource(result.getString("source"));
                voyage.setDestination(result.getString("destination"));
                voyage.setDepart(result.getDate("depart"));
                voyage.setArrive(result.getDate("arrive"));
                
                voyage.setIdcar(result.getInt("idcar"));
                voyage.setIdchauf(result.getInt("idchauf"));
               // voyage.setStatut(result.getString("statut"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoyageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return voyage;
    }

    @Override
    public void inserer(Voyage obj) {
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("insert into voyage(source,destination,idcar,idchauf,depart,arrive) values(?,?,?,?,?,?) ");
            prepare.setString (1,obj.getSource());
            prepare.setString(2,obj.getDestination());
            prepare.setInt(3,obj.getIdcar());
           
            prepare.setInt(4,obj.getIdchauf());
            prepare.setString(5,amj.format(obj.getDepart()));
            prepare.setString(6,amj.format(obj.getArrive()));
            
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VoyageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Voyage obj, int id) {
         try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("Update voyage set  source=?,destination =?,idcar=?,idchauf=?,depart=?,arrive=? where idvoy="+id  );
            prepare.setString (1,obj.getSource());
            prepare.setString(2,obj.getDestination());
            prepare.setInt(3,obj.getIdcar());
           
            prepare.setInt(4,obj.getIdchauf());
            prepare.setString(5,amj.format(obj.getDepart()));
            prepare.setString(6,amj.format(obj.getArrive()));
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VoyageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int id) {
         try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("delete from voyage where idvoy="+id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VoyageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Voyage> liste() {
         Voyage voyage = new Voyage();
         List<Voyage>lv=new ArrayList<>();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select *from voyage");
            while(result.next()){
                voyage.setIdvoy(result.getInt("idvoy"));
                voyage.setSource(result.getString("source"));
                voyage.setDestination(result.getString("destination"));
                voyage.setIdcar(result.getInt("idcar"));
                
                voyage.setIdchauf(result.getInt("idchauf"));
                voyage.setDepart(result.getDate("depart"));
               voyage.setArrive(result.getDate("arrive"));
                
                
                lv.add(voyage);
                voyage = new Voyage();
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoyageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return lv;
       
    }

    
    
    
    
    
}
