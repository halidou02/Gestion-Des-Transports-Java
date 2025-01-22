/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;



/**
 *
 * @author Baba
 */
public class Car {
     private int idcar;
    private String marque;
   private String matricule;
    private int nb_place;
    
    private String statut;

    public Car() {
    }

    public Car(String statut) {
        this.statut = statut;
    }

    public Car(int idcar, String marque, String matricule, int nb_place, String statut) {
        this.idcar = idcar;
        this.marque = marque;
        this.matricule = matricule;
        this.nb_place = nb_place;
        this.statut = statut;
    }

    public Car(String marque, String matricule, int nb_place, String statut) {
        this.marque = marque;
        this.matricule = matricule;
        this.nb_place = nb_place;
        this.statut = statut;
    }

    public int getIdcar() {
        return idcar;
    }

    public void setIdcar(int idcar) {
        this.idcar = idcar;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

   
  
    
}
