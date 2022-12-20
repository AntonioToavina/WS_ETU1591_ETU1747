package com.example.tp_ws2.Modele;

import com.example.tp_ws2.Repository.TokenRepository;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "token_user")
public class Token {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "pk_token_user_idtoken_seq")
    @SequenceGenerator(name="pk_token_user_idtoken_seq" ,sequenceName = "token_user_idtoken_seq",allocationSize = 1)
    private Integer idtoken;

    @OneToOne
    @JoinColumn(name = "iduser",referencedColumnName = "iduser",insertable = false,updatable = false)
    Utilisateur user;

    @Column
    int iduser;

    String token;

    Timestamp dateexp;

    public Timestamp getDateexp() {
        return dateexp;
    }

    public void setDateexp(Timestamp dateexp) {
        this.dateexp = dateexp;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setIdtoken(Integer idtoken) {
        this.idtoken = idtoken;
    }

    public Integer getIdtoken() {
        return idtoken;
    }

    public Token check_Expiration(String script, TokenRepository repo){
        script=script.substring(7);
      Token token =repo.findTokenByToken(script);
        if(token==null)
            return null;

        return token;
    }
}
