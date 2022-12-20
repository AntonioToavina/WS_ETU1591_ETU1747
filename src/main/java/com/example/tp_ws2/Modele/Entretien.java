package com.example.tp_ws2.Modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "entretien")
public class Entretien {
    @Id
    @GeneratedValue
    private Integer identretien;

    int idavion;

    int idtype;

    Date dateentretien;

    public int getIdavion() {
        return idavion;
    }

    public void setIdavion(int idavion) {
        this.idavion = idavion;
    }

    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    public Date getDateentretien() {
        return dateentretien;
    }

    public void setDateentretien(Date dateentretien) {
        this.dateentretien = dateentretien;
    }

    public void setIdentretien(Integer identretien) {
        this.identretien = identretien;
    }

    public Integer getIdentretien() {
        return identretien;
    }
}
