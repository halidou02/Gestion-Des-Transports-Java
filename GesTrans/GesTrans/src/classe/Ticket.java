/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.util.Date;

/**
 *
 * @author Baba
 */
public class Ticket {
     private int idtkt;
    private int idvoy;
    private String source;
    private String destination;
    private int idclt;
    private String nom;
    private String cni;
    private Date date;
    private int prix;
  

    public Ticket() {
    }

    public Ticket(int idtkt, int idvoy, String source, String destination, int idclt, String nom, String cni, Date date, int prix) {
        this.idtkt = idtkt;
        this.idvoy = idvoy;
        this.source = source;
        this.destination = destination;
        this.idclt = idclt;
        this.nom = nom;
        this.cni = cni;
        this.date = date;
        this.prix = prix;
    }

    public Ticket(int idvoy, String source, String destination, int idclt, String nom, String cni, Date date, int prix) {
        this.idvoy = idvoy;
        this.source = source;
        this.destination = destination;
        this.idclt = idclt;
        this.nom = nom;
        this.cni = cni;
        this.date = date;
        this.prix = prix;
    }

    public int getIdtkt() {
        return idtkt;
    }

    public void setIdtkt(int idtkt) {
        this.idtkt = idtkt;
    }

    public int getIdvoy() {
        return idvoy;
    }

    public void setIdvoy(int idvoy) {
        this.idvoy = idvoy;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getIdclt() {
        return idclt;
    }

    public void setIdclt(int idclt) {
        this.idclt = idclt;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    

   
   
    
}
