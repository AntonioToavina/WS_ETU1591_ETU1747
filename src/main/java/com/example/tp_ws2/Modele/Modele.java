package com.example.tp_ws2.Modele;

import javax.persistence.*;

@Entity
@Table(name = "Modele")
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idmodele")
    private Integer idModele;

    @ManyToOne
    @JoinColumn(name = "idcompany")
    Company company;

    @ManyToOne
    @JoinColumn(name = "idtype")
    TypeAvion type;

    String nommodele;

    public TypeAvion getType() {
        return type;
    }

    public void setType(TypeAvion type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getNommodele() {
        return nommodele;
    }

    public void setNommodele(String nommodele) {
        this.nommodele = nommodele;
    }

    public void setIdModele(Integer idModele) {
        this.idModele = idModele;
    }

    public Integer getIdModele() {
        return idModele;
    }
}
