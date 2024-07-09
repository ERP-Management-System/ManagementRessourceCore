/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.Coloris;
import com.MangmentRessources.MangRess.Achat.domaine.EtatDemande;
import com.MangmentRessources.MangRess.Achat.dto.ColorisDTO;
import com.MangmentRessources.MangRess.Achat.dto.EtatDemandeDTO;
import com.MangmentRessources.MangRess.Achat.factory.ColorisFactory;
import com.MangmentRessources.MangRess.Achat.factory.EtatDemandeFactory;
import com.MangmentRessources.MangRess.Achat.repository.ColorisRepo;
import com.MangmentRessources.MangRess.Achat.repository.EtatDemandeAchatRepo;
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
public class EtatDemandeAchatService {
    
    
    
     private final EtatDemandeAchatRepo etatDemandeAchatRepo;

    public EtatDemandeAchatService(EtatDemandeAchatRepo etatDemandeAchatRepo) {
        this.etatDemandeAchatRepo = etatDemandeAchatRepo;
    }
    
    @Transactional(readOnly = true)
    public List<EtatDemandeDTO> findAllEtatDemande() {
        return EtatDemandeFactory.listEtatDemandeAchatToEtatDemandeAchatDTOs(etatDemandeAchatRepo.findAll());

    }

    @Transactional(readOnly = true)
    public EtatDemandeDTO findOne(Integer code) {
        EtatDemande domaine = etatDemandeAchatRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.EtatDemandeAchatNotFound");
        return EtatDemandeFactory.etatDemandeAchatToEtatDemandeAchatDTO(domaine);
    }

 
}
