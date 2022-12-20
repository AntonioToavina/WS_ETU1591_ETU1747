package com.example.tp_ws2.Modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeentretien")
public class TypeEntretien {
    @Id
    @GeneratedValue
    private Integer idtype;

    String typeentretien;

    public String getTypeentretien() {
        return typeentretien;
    }

    public void setTypeentretien(String typeentretien) {
        this.typeentretien = typeentretien;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public Integer getIdtype() {
        return idtype;
    }
}
