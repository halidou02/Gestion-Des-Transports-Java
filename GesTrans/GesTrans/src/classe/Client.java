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
public class Client {
    private int idclt;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private String genre;
    private String cni;
    private Date dateenrg;

    public Client(int idclt, String nom, String prenom, String telephone, String adresse, String genre, String cni, Date dateenrg) {
        this.idclt = idclt;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.genre = genre;
        this.cni = cni;
        this.dateenrg = dateenrg;
    }

    public Client() {
    }

    public Client(String nom, String prenom, String telephone, String adresse, String genre, String cni, Date dateenrg) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.genre = genre;
        this.cni = cni;
        this.dateenrg = dateenrg;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public Date getDateenrg() {
        return dateenrg;
    }

    public void setDateenrg(Date dateenrg) {
        this.dateenrg = dateenrg;
    }
    
}
