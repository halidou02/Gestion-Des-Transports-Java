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
public class Chauffeur {
     private int idchauf;
    private String nom;
    private String adresse;
    private String cni;
    private int salaire;
    private String car;
    private Date date_enreg;
    private String statut;

   

    public Chauffeur() {
    }

    public Chauffeur(int idchauf, String nom, String adresse, String cni, int salaire, String car, Date date_enreg, String statut) {
        this.idchauf = idchauf;
        this.nom = nom;
        this.adresse = adresse;
        this.cni = cni;
        this.salaire = salaire;
        this.car = car;
        this.date_enreg = date_enreg;
        this.statut = statut;
    }

    public Chauffeur(String nom, String adresse, String cni, int salaire, String car, Date date_enreg, String statut) {
        this.nom = nom;
        this.adresse = adresse;
        this.cni = cni;
        this.salaire = salaire;
        this.car = car;
        this.date_enreg = date_enreg;
        this.statut = statut;
    }

    public int getIdchauf() {
        return idchauf;
    }

    public void setIdchauf(int idchauf) {
        this.idchauf = idchauf;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Date getDate_enreg() {
        return date_enreg;
    }

    public void setDate_enreg(Date date_enreg) {
        this.date_enreg = date_enreg;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

   
    
    
}
