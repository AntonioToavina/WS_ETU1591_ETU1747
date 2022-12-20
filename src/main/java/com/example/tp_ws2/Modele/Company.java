package com.example.tp_ws2.Modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue
    private Integer idcompany;

    String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIdcompany(Integer idcompany) {
        this.idcompany = idcompany;
    }

    public Integer getIdcompany() {
        return idcompany;
    }
}
