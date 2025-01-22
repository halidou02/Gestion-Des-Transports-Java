/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classe.Ticket;
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
public class TicketDAO extends DAO<Ticket>{
 SimpleDateFormat amj = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Ticket recherche(int id) {
        Ticket ticket = new Ticket();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from ticket where idtkt="+id);
            if(result.next()){
                ticket.setIdtkt(result.getInt("idtkt"));
                ticket.setIdvoy(result.getInt("idvoy"));
                 ticket.setSource(result.getString("source"));
                ticket.setDestination(result.getString("destination"));
                ticket.setIdclt(result.getInt("idclt"));
                ticket.setNom(result.getString("nom"));
                ticket.setCni(result.getString("cni"));
                ticket.setDate(result.getDate("date"));
                ticket.setPrix(result.getInt("prix"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return ticket;
    }

    @Override
    public void inserer(Ticket obj) {
       
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("insert into ticket(idvoy,source,destination,idclt,nom,cni,date,prix) values(?,?,?,?,?,?,?,?)");
            prepare.setInt (1,obj.getIdvoy());
            prepare.setString(2,obj.getSource());
            prepare.setString(3,obj.getDestination());
            prepare.setInt(4,obj.getIdclt());
            prepare.setString(5,obj.getNom());
            prepare.setString(6,obj.getCni());
            prepare.setString(7,amj.format(obj.getDate()));
            prepare.setInt(8,obj.getPrix());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Ticket obj, int id) {
       
       try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("update ticket set idvoy=?,source=? , destination=?,idclt=?,nom=?, cni=?, date=? where idtkt="+id  );
            prepare.setInt (1,obj.getIdvoy());
            prepare.setString(2,obj.getSource());
            prepare.setString(3,obj.getDestination());
            prepare.setInt(4,obj.getIdclt());
            prepare.setString(5,obj.getNom());
            prepare.setString(6,obj.getCni());
            prepare.setString(7,amj.format(obj.getDate()));
            prepare.setInt(8,obj.getPrix());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) {
         try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("delete from ticket where idtkt="+id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Ticket> liste() {
         Ticket ticket = new Ticket();
         List<Ticket>lt=new ArrayList<>();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select *from ticket");
            while(result.next()){
                ticket.setIdtkt(result.getInt("idtkt"));
                ticket.setIdvoy(result.getInt("idvoy"));
                ticket.setSource(result.getString("source"));
                ticket.setDestination(result.getString("destination"));
                ticket.setIdclt(result.getInt("idclt"));
                ticket.setNom(result.getString("nom"));
                ticket.setCni(result.getString("cni"));
                ticket.setDate(result.getDate("date"));
                ticket.setPrix(result.getInt("prix"));
                lt.add(ticket);
                ticket = new Ticket();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return lt;
    }
    
}
