package com.example.tp_ws2.Controller;

import com.example.tp_ws2.Modele.Avion;
import com.example.tp_ws2.Modele.Token;
import com.example.tp_ws2.Repository.AvionRepository;
import com.example.tp_ws2.Repository.TokenRepository;
import com.example.tp_ws2.Service.ResponseData;
import com.example.tp_ws2.Service.Util;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/avions")
public class AvionController {
    TokenRepository repoToken;
    AvionRepository repoAvion;

    public AvionController(TokenRepository repoToken,AvionRepository repoAvion){
        this.repoToken=repoToken;
        this.repoAvion=repoAvion;
    }

    @GetMapping
    public Object getAll(@RequestHeader("Authorization") String bearerToken){
        Util util=new Util();
        try{
            Token token =new Token();
            token=token.check_Expiration(bearerToken,this.repoToken);
            if(token==null)
                return new Util().generate_Error("Session expire");

            Avion[] list=new Avion().getLastMonth_Assurance(this.repoAvion.getAvions_AssuranceValide());
            return new ResponseData(list);
        }catch(Throwable e){
            System.out.println(e.getMessage());
            return util.generate_Error("Erreur d'authentification");
        }

    }

    @PostMapping("/{id}/picture")
    public Object sendPicture(@PathVariable int id,@RequestBody String img){
        Util util=new Util();
        try{
            this.repoAvion.addpicture(id,img);
            return util.generate_Success("Avion modifié");
        }catch(Throwable e){
            System.out.println(e.getMessage());
            return util.generate_Error("Erreur d'authentification");
        }
    }
}
