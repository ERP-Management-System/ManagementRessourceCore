/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.repository;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsReceptionTemp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface DetailsReceptionTempRepo extends JpaRepository<DetailsReceptionTemp, Integer> {

    List<DetailsReceptionTemp> findByCodeOrdreAchatAndCodematiere(Integer codeOrdreAchat, Integer codematiere);

    @Modifying
    @Query("delete from DetailsReceptionTemp det where det.codeOrdreAchat=?1  and det.codematiere=?2 ")
    public void deleteByCodeOrdreAchatAndCodematiere(Integer codeOrdreAchat, Integer codematiere);

    @Modifying
    @Query("delete from DetailsReceptionTemp det where det.codeOrdreAchat=?1 ")
    public void deleteByCodeOrdreAchat(Integer codeOrdreAchat);

    public void save(List<DetailsReceptionTemp> lits);
}
