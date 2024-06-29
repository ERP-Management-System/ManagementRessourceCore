/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.repository;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsAppelOffre;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsAppelOffrePK;
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
public interface DetailsAppelOffreRepo extends JpaRepository<DetailsAppelOffre, DetailsAppelOffrePK> {

    Collection<DetailsAppelOffre> findByDetailsAppelOffrePK_codeAppelOffre(Integer codeAppelOffre);

    @Modifying
    @Query("delete from DetailsAppelOffre det where det.detailsAppelOffrePK.codeAppelOffre=?1 ")
    public void deleteByCodeAppelOffre(Integer codeAppelOffre);

}
