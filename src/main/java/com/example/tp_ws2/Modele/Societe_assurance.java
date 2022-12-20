package com.example.tp_ws2.Modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "societe_assurance")
public class Societe_assurance {
    @Id
    @GeneratedValue
    private Integer idsociete;

    String nomsociete;

    public String getNomsociete() {
        return nomsociete;
    }

    public void setNomsociete(String nomsociete) {
        this.nomsociete = nomsociete;
    }

    public void setIdsociete(Integer idsociete) {
        this.idsociete = idsociete;
    }

    public Integer getIdsociete() {
        return idsociete;
    }
}
