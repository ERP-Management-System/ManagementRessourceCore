/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.repository;

import com.MangmentRessources.MangRess.Stock.domaine.DetailsDemandeTransfertMatiere;
import com.MangmentRessources.MangRess.Stock.domaine.DetailsDemandeTransfertMatierePK;
import java.util.Collection;
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
public interface DetailsDemandeTransfertMatiereRepo  extends JpaRepository<DetailsDemandeTransfertMatiere, DetailsDemandeTransfertMatierePK>{
    
     Collection<DetailsDemandeTransfertMatiere> findByDetailsDemandeTransfertMatierePK_codeDemandeTransfertMatiere(Integer codeDemandeTransfertMatiere);    
    
//    List<DetailsDemandeTransfertMatiere> findByCodeOrdreAchat(Integer codeOrdreAchat);


    @Modifying
    @Query("delete from DetailsDemandeTransfertMatiere det where det.detailsDemandeTransfertMatierePK.codeDemandeTransfertMatiere=?1 ")
    public void deleteByCodeDemandeTransfertMatiere(Integer codeDemandeTransfertMatiere);
}
