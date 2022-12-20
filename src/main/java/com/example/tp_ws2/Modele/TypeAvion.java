package com.example.tp_ws2.Modele;

import javax.persistence.*;

@Entity
@Table(name = "typeavion")
public class TypeAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idtype;

    String nomtype;

    public String getNomtype() {
        return nomtype;
    }

    public void setNomtype(String nomtype) {
        this.nomtype = nomtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public Integer getIdtype() {
        return idtype;
    }
}
