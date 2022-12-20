package com.example.tp_ws2.Repository;

import com.example.tp_ws2.Modele.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AvionRepository extends JpaRepository<Avion,Integer> {

    @Query(value = "select v.*  from avion v join payement_assurance p on v.idavion=p.idavion where (p.datefin-current_date)>0 ",nativeQuery = true)
    Avion[] getAvions_AssuranceValide();

    @Transactional
    @Modifying
    @Query(value = "update avion set img=?2 where idavion=?1",nativeQuery = true)
    void addpicture(int id,String img);
}
