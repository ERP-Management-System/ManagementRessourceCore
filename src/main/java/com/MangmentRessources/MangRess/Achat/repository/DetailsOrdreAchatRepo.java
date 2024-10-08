/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.repository;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchatPK;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface DetailsOrdreAchatRepo extends JpaRepository<DetailsOrdreAchat, DetailsOrdreAchatPK> {
//      Collection<DetailsOrdreAchat> findByDetailsOrdreAchatPK_codeOrdreAchat(Integer codeOrdreAchat);   

    Collection<DetailsOrdreAchat> findByDetailsOrdreAchatPK_codeOrdreAchatAndTotalementLivred (Integer codeOrdreAchat,Boolean totalementLivred);
    
    Collection<DetailsOrdreAchat> findByDetailsOrdreAchatPK_codeOrdreAchat(Integer codeOrdreAchat);  

     


    DetailsOrdreAchat findByDetailsOrdreAchatPK_codeOrdreAchatAndCodematiere(Integer codeOrdreAchat, Integer codematiere);

    Boolean existsByDetailsOrdreAchatPK_codeOrdreAchat(int codeOrdreAchat);

    public Collection<DetailsOrdreAchat> save(Collection<DetailsOrdreAchat> detailsOrdreAchats);
}
