/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchat;
import com.MangmentRessources.MangRess.Achat.domaine.OrdreAchat;
import com.MangmentRessources.MangRess.Achat.dto.DetailsOrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.OrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.factory.DetailsOrdreAchatFactory;
import com.MangmentRessources.MangRess.Achat.factory.OrdreAchatFactory;
import com.MangmentRessources.MangRess.Achat.repository.DetailsOrdreAchatRepo;
import com.google.common.base.Preconditions;
import java.util.Collection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class DetailsOrdreAchatService {
    private final DetailsOrdreAchatRepo detailsOrdreAchatRepo;

    public DetailsOrdreAchatService(DetailsOrdreAchatRepo detailsOrdreAchatRepo) {
        this.detailsOrdreAchatRepo = detailsOrdreAchatRepo;
    }
    
       @Transactional(readOnly = true)
    public Collection<DetailsOrdreAchatDTO> findOne(Integer code) {
           Collection<DetailsOrdreAchat> domaine = detailsOrdreAchatRepo.findByDetailsOrdreAchatPK_codeOrdreAchat(code); 
          
        return DetailsOrdreAchatFactory.UpdatedetailsOrdreAchatTodetailsOrdreAchatDTOCollection(domaine);
    }
    
}
