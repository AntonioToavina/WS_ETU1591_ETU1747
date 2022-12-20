package com.example.tp_ws2.Repository;

import com.example.tp_ws2.Modele.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = "SELECT * FROM token_user t where t.token= ?1 and t.dateexp>now()",nativeQuery = true)
    Token findTokenByToken(String token);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM token_user t where t.iuser = ?1",nativeQuery = true)
    void deleteTokenByAdmin_IdUser(int iduser);
}