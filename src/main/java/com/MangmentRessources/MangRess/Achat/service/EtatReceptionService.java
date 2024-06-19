/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.EtatReception;
import com.MangmentRessources.MangRess.Achat.dto.EtatReceptionDTO;
import com.MangmentRessources.MangRess.Achat.factory.EtatReceptionFactory;
import com.MangmentRessources.MangRess.Achat.repository.EtatReceptionRepo;
import com.google.common.base.Preconditions;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class EtatReceptionService {
    private final EtatReceptionRepo etatReceptionRepo;

    public EtatReceptionService(EtatReceptionRepo etatReceptionRepo) {
        this.etatReceptionRepo = etatReceptionRepo;
    }
    
    @Transactional(readOnly = true)
    public List<EtatReceptionDTO> findAllEtatReception() {
        return EtatReceptionFactory.listEtatReceptionToEtatReceptionDTOs(etatReceptionRepo.findAll());

    }

    @Transactional(readOnly = true)
    public EtatReceptionDTO findOne(Integer code) {
        EtatReception domaine = etatReceptionRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.EtatReceptionNotFound");
        return EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine);
    }

//
    public EtatReceptionDTO save(EtatReceptionDTO dTO) {
        EtatReception domaine = EtatReceptionFactory.etatReceptionDTOToEtatReception(dTO, new EtatReception());
        domaine = etatReceptionRepo.save(domaine);
        return EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine);
    }

    public EtatReception update(EtatReceptionDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.EtatReceptionNotFound");
        EtatReception matiere = etatReceptionRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.EtatReceptionNotFound");
        dTO.setCode(matiere.getCode());
        EtatReceptionFactory.etatReceptionDTOToEtatReception(dTO, matiere);
        return etatReceptionRepo.save(matiere);
    }

 
    
}
