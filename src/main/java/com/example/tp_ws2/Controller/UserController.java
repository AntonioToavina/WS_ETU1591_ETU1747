package com.example.tp_ws2.Controller;

import com.example.tp_ws2.Modele.Token;
import com.example.tp_ws2.Modele.Utilisateur;
import com.example.tp_ws2.Repository.TokenRepository;
import com.example.tp_ws2.Repository.UserRepository;
import com.example.tp_ws2.Service.ResponseData;
import com.example.tp_ws2.Service.Util;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    UserRepository userrepo;
    TokenRepository repoToken;

    public UserController(UserRepository userrepo,TokenRepository repotoken){
        this.userrepo=userrepo;
        this.repoToken=repotoken;
    }

    @PostMapping("/login")
    public Object login(@RequestBody Utilisateur user){
        Util util=new Util();
        try{
            user=this.userrepo.userLogin(user.getLogin(),user.getMdp());
            System.out.println(user.toString());
            if(user==null)
                return util.generate_Error("Erreur d'authentification");
            Token token=util.generateToken(user);
            this.repoToken.save(token);

            token.setUser(user);
            return new ResponseData(token);

        }catch(Throwable e){
            System.out.println(e.getMessage());
            return util.generate_Error("Erreur d'authentification");
        }
    }
}
