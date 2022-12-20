package com.example.tp_ws2.Modele;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Table(name = "avion")
public class Avion {
    @Id
    @GeneratedValue
    private Integer idavion;

    double capacite;

    double hauteur;

    double vmax;

    double carburant;

    @OneToOne
    @JoinColumn(name = "idmodele", referencedColumnName = "idmodele",insertable = false,updatable = false)
    Modele modele;

    String matricule;

    String img;

    @OneToMany(mappedBy ="avion" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @Column(nullable = true)
    List<Kilometrage> kilometrages;

    @OneToMany(mappedBy = "avion",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Payement_assurance> assurance;

    public List<Payement_assurance> getAssurance() {
        return assurance;
    }

    public void setAssurance(List<Payement_assurance> assurance) {
        this.assurance = assurance;
    }

    public List<Kilometrage> getKilometrages() {
        return kilometrages;
    }

    public void setKilometrages(List<Kilometrage> kilometrages) {
        this.kilometrages = kilometrages;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public double getCapacite() {
        return capacite;
    }

    public void setCapacite(double capacite) {
        this.capacite = capacite;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getVmax() {
        return vmax;
    }

    public void setVmax(double vmax) {
        this.vmax = vmax;
    }

    public double getCarburant() {
        return carburant;
    }

    public void setCarburant(double carburant) {
        this.carburant = carburant;
    }


    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setIdavion(Integer idavion) {
        this.idavion = idavion;
    }

    public Integer getIdavion() {
        return idavion;
    }

    public Avion[] getLastMonth_Assurance(Avion[] avion){
        for(int i=0;i<avion.length;i++){
            for(Payement_assurance assurance: avion[i].getAssurance()){
                assurance.setRestant(ChronoUnit.MONTHS.between(new Date(System.currentTimeMillis()).toLocalDate(),assurance.getDatefin().toLocalDate()));
            }
        }

        return avion;
    }
}
