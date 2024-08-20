/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsReceptionTemp;
import com.MangmentRessources.MangRess.Achat.dto.DetailsReceptionTempDTO;
import com.MangmentRessources.MangRess.Achat.factory.DetailsReceptionTempFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import com.MangmentRessources.MangRess.Achat.repository.DetailsReceptionTempRepo;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class DetailsReceptionTempService {

    private final DetailsReceptionTempRepo detailsReceptionRepo;

    public DetailsReceptionTempService(DetailsReceptionTempRepo detailsReceptionRepo) {
        this.detailsReceptionRepo = detailsReceptionRepo;
    }

    @Transactional(readOnly = true)
    public List<DetailsReceptionTempDTO> findOneByCodeOrdreAchatAndCodeMatiere(Integer codeOrdreAchat, Integer codematiere) {
        
//        Preconditions.checkArgument(!detailsReceptionRepo.findByCodeOrdreAchatAndCodematiere(codeOrdreAchat, codematiere).isEmpty() , "Any.Details.Reception.With.This.OrdreAchat&This.Matiere" );   
        
        return DetailsReceptionTempFactory.listDetailsReceptionTempToDetailsReceptionTempDTOs(detailsReceptionRepo.findByCodeOrdreAchatAndCodematiere(codeOrdreAchat, codematiere));
    }

    public DetailsReceptionTempDTO saveDetailsReceptionTemp(DetailsReceptionTempDTO Dto) {
        DetailsReceptionTemp domaine = DetailsReceptionTempFactory.bonReceptionDTOToDetailsReceptionTemp(new DetailsReceptionTemp(), Dto);
        domaine.setCode(null);
        detailsReceptionRepo.flush();
        domaine = detailsReceptionRepo.save(domaine);
        DetailsReceptionTempDTO resultDTO = DetailsReceptionTempFactory.bonReceptionToDetailsReceptionTempDTO(domaine);

        return resultDTO;
    }

    public Boolean saveList(List<DetailsReceptionTempDTO> litDTOs) throws JsonProcessingException {
//        log.debug("Request to save Lit");
        List<DetailsReceptionTemp> lits = new ArrayList<>();
        detailsReceptionRepo.save(lits);
        String token = RequestContextHolder.currentRequestAttributes().getSessionId();
//        Collection<EtatLitDTO> etats = receptionServiceClient.saveEtatsLit(etatLitDTOs, token);
//        Preconditions.checkArgument(etats != null, "reception.failed");
        return Boolean.TRUE;
    }

    public Boolean saveLists(List<DetailsReceptionTemp> detailsPriceListOperation) { 
        detailsReceptionRepo.save(detailsPriceListOperation);
        detailsReceptionRepo.flush();
        return true;
    }

    public Boolean deleteByCodeOrdreAchatAndCodeMatiere(Integer codeOrdreAchat, Integer codematiere) {
        detailsReceptionRepo.deleteByCodeOrdreAchatAndCodematiere(codeOrdreAchat, codematiere);
        return true;
    }
    
     public Boolean deleteByCodeOrdreAchat(Integer codeOrdreAchat) {
        detailsReceptionRepo.deleteByCodeOrdreAchat(codeOrdreAchat);
        return true;
    }
}
