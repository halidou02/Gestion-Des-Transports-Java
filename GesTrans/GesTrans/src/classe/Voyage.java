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
public class Voyage {
     private int idvoy;
    private String source;
    private String destination;
    private int idcar;
   
    private int idchauf;
    private Date depart;
    private Date arrive;


  

  

    public Voyage() {
    }

    public Voyage(int idvoy, String source, String destination, int idcar, int idchauf, Date depart, Date arrive) {
        this.idvoy = idvoy;
        this.source = source;
        this.destination = destination;
        this.idcar = idcar;
        this.idchauf = idchauf;
        this.depart = depart;
        this.arrive = arrive;
    }

    public Voyage(String source, String destination, int idcar, int idchauf, Date depart, Date arrive) {
        this.source = source;
        this.destination = destination;
        this.idcar = idcar;
        this.idchauf = idchauf;
        this.depart = depart;
        this.arrive = arrive;
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

    public int getIdcar() {
        return idcar;
    }

    public void setIdcar(int idcar) {
        this.idcar = idcar;
    }

    public int getIdchauf() {
        return idchauf;
    }

    public void setIdchauf(int idchauf) {
        this.idchauf = idchauf;
    }

    public Date getDepart() {
        return depart;
    }

    public void setDepart(Date depart) {
        this.depart = depart;
    }

    public Date getArrive() {
        return arrive;
    }

    public void setArrive(Date arrive) {
        this.arrive = arrive;
    }

    

    


  

   
    
}
