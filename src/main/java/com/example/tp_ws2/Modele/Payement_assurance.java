package com.example.tp_ws2.Modele;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "payement_assurance")
public class Payement_assurance {
    @Id
    @GeneratedValue
    private Integer idpayement;

    @OneToOne
    @JoinColumn(name = "idsociete",referencedColumnName = "idsociete",insertable = false,updatable = false)
    Societe_assurance societe;

    int idavion;

    Date datedebut;

    Date datefin;

    @ManyToOne(targetEntity = Avion.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="idavion",referencedColumnName = "idavion",insertable = false,updatable = false)
    @JsonBackReference
    Avion avion;

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    double payer;

    double restant;

    public double getRestant() {
        return restant;
    }

    public void setRestant(double restant) {
        this.restant = restant;
    }

    public Societe_assurance getSociete() {
        return societe;
    }

    public void setSociete(Societe_assurance societe) {
        this.societe = societe;
    }

    public int getIdavion() {
        return idavion;
    }

    public void setIdavion(int idavion) {
        this.idavion = idavion;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public double getPayer() {
        return payer;
    }

    public void setPayer(double payer) {
        this.payer = payer;
    }

    public void setIdpayement(Integer idpayement) {
        this.idpayement = idpayement;
    }

    public Integer getIdpayement() {
        return idpayement;
    }
}
