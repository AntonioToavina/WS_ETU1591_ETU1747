package com.example.tp_ws2.Repository;

import com.example.tp_ws2.Modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository  extends JpaRepository<Utilisateur, Integer> {
    @Query(value = "SELECT * from utilisateur a where a.login= ?1 and a.mdp= ?2",nativeQuery = true)
    Utilisateur userLogin (String login, String mdp);
}
