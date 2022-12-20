package com.example.tp_ws2.Modele;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "kilometrage")
public class Kilometrage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idkilometrage;
    int idavion;

    Date datemodif;

    double debutkm;

    double finkm;

    @ManyToOne(targetEntity = Avion.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idavion",referencedColumnName = "idavion",insertable = false,updatable = false)
    @JsonBackReference
    Avion avion;

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public int getIdavion() {
        return idavion;
    }

    public void setIdavion(int idavion) {
        this.idavion = idavion;
    }

    public Date getDatemodif() {
        return datemodif;
    }

    public void setDatemodif(Date datemodif) {
        this.datemodif = datemodif;
    }

    public double getDebutkm() {
        return debutkm;
    }

    public void setDebutkm(double debutkm) {
        this.debutkm = debutkm;
    }

    public double getFinkm() {
        return finkm;
    }

    public void setFinkm(double finkm) {
        this.finkm = finkm;
    }

    public void setIdkilometrage(Integer idkilometrage) {
        this.idkilometrage = idkilometrage;
    }

    public Integer getIdkilometrage() {
        return idkilometrage;
    }
}
