/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.repository;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsAppelOffre;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsBonReception;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsBonReceptionPK;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface DetailsBonReceptionRepo extends JpaRepository<DetailsBonReception, DetailsBonReceptionPK> {

    Collection<DetailsBonReception> findByDetailsBonReceptionPK_codeBonReception(Integer codeBonReception);

    @Modifying
    @Query("delete from DetailsBonReception det where det.detailsBonReceptionPK.codeBonReception=?1 ")
    public void deleteByCodeBonReception(Integer codeBonReception);

}
