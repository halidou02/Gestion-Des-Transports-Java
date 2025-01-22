/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Car;
import classe.Voyage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author halid
 */
public class CarDAO extends DAO<Car>{
 SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Car recherche(int id) {
        Car car = new Car();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from car where idcar="+id);
            if(result.next()){
                car.setIdcar(result.getInt("idcar"));
                car.setMarque(result.getString("marque"));
                 car.setMatricule(result.getString("matricule"));
                car.setNb_place(result.getInt("nb_place"));
                car.setStatut(result.getString("statut"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return car;
    }

    @Override
    public void inserer(Car obj) {
       
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("insert into car(marque,matricule,nb_place,statut) values(?,?,?,?)");
            prepare.setString(1,obj.getMarque());
            prepare.setString (2,obj.getMatricule());
            prepare.setInt (3,obj.getNb_place());
          prepare.setString (4,obj.getStatut());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param obj
     * @param id
     */
    @Override
    public void modifier(Car obj, int id) {
       
       try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("Update car set marque=? , matricule=? , nb_place=? , statut=? where idcar=" +id  );
           prepare.setString(1,obj.getMarque());
            prepare.setString (2,obj.getMatricule());
            prepare.setInt (3,obj.getNb_place());
          prepare.setString (4,obj.getStatut());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void modifierStatutCar( String statut, int id) {
    

       try {
          
         //  PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("Update  car set  statut='Indisponible' where idcar=" +id  );
          String Query = "Update  car set  statut="+statut+" where idcar="+id;
           Statement add= connect.createStatement();
          
           add.executeUpdate(Query);
          
           
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
           
            
    @Override
    public void supprimer(int id) {
         try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("delete from car where idcar="+id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Car> liste() {
         Car car = new Car();
         List<Car>lt=new ArrayList<>();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select *from car");
            while(result.next()){
              car.setIdcar(result.getInt("idcar"));
                car.setMarque(result.getString("marque"));
                car.setMatricule(result.getString("matricule"));
                car.setNb_place(result.getInt("nb_place"));
                car.setStatut(result.getString("statut"));
               
                lt.add(car);
                car = new Car();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return lt;
    }
    
}
