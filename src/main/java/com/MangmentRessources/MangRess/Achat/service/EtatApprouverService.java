/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.EtatApprouver;
import com.MangmentRessources.MangRess.Achat.dto.EtatApprouverDTO;
import com.MangmentRessources.MangRess.Achat.factory.EtatApprouverFactory;
import com.MangmentRessources.MangRess.web.Util.Helper;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.MangmentRessources.MangRess.Achat.repository.EtatApprouverRepo;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class EtatApprouverService {
    private final EtatApprouverRepo etatApprouverOrdreAchatRepo;

    public EtatApprouverService(EtatApprouverRepo etatApprouverOrdreAchatRepo) {
        this.etatApprouverOrdreAchatRepo = etatApprouverOrdreAchatRepo;
    }

    @Transactional(readOnly = true)
    public List<EtatApprouverDTO> findAllEtatApprouverOrdreAchat() {
        return EtatApprouverFactory.listEtatApprouverToEtatApprouverDTOs(etatApprouverOrdreAchatRepo.findAll());

    }

    @Transactional(readOnly = true)
    public EtatApprouverDTO findOne(Integer code) {
        EtatApprouver domaine = etatApprouverOrdreAchatRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.EtatApprouverOrdreAchatNotFound");
        return EtatApprouverFactory.etatApprouverToEtatApprouverDTO(domaine);
    }

 
 

  
}
