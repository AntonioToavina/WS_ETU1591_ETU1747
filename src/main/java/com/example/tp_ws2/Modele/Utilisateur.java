package com.example.tp_ws2.Modele;

import javax.persistence.*;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "pk_utilisateur_iduser_seq")
    @SequenceGenerator(name="pk_utilisateur_iduser_seq" ,sequenceName = "utilisateur_iduser_seq",allocationSize = 1)
    private Integer iduser;

    String login;

    String mdp;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIduser() {
        return iduser;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "iduser=" + iduser +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
