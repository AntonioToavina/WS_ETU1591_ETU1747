package com.example.tp_ws2.Service;

import com.example.tp_ws2.Modele.Token;
import com.example.tp_ws2.Modele.Utilisateur;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Util {
    public Object generate_Error(String value){
        Message message=new Message(value);
        Error error=new Error(message);
        return error;
    }

    public Object generate_Success(String value){
        Message message=new Message(value);
        message.setCode(200);
        Success success=new Success(message);
        return success;
    }

    public  String criptage(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Change this to UTF-16 if needed
        md.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        String hex = String.format("%064x", new BigInteger(1, digest));
        return hex;
    }

    public Token generateToken(Utilisateur admin) throws NoSuchAlgorithmException {
        Token token=new Token();
        token.setToken(criptage(admin.getLogin().concat(admin.getMdp())));
        token.setIduser(admin.getIduser());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.setMinutes(timestamp.getMinutes()+40);
        token.setDateexp(timestamp);

        return token;
    }
}