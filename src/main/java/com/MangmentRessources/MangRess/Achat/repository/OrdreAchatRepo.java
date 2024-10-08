/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.repository;

import com.MangmentRessources.MangRess.Achat.domaine.OrdreAchat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface OrdreAchatRepo extends JpaRepository<OrdreAchat, Integer> {

    OrdreAchat findByCodeAppelOffre(Integer codeAppelOffre);

    OrdreAchat findByCodeDemandeAchat(Integer codeDemandeAchat);

    List<OrdreAchat> findOrdreAchatByCodeEtatReception(Integer codeEtatReception); 
    List<OrdreAchat> findOrdreAchatByCodeEtatReceptionIn(List<Integer> codeEtatReception); 

    List<OrdreAchat> findAllByOrderByCodeSaisieDesc();

}
