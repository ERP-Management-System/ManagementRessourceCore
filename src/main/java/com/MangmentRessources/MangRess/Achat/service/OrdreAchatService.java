/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.OrdreAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchat;
import com.MangmentRessources.MangRess.Achat.dto.OrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsOrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.factory.OrdreAchatFactory;
import com.MangmentRessources.MangRess.Achat.factory.DetailsOrdreAchatFactory;
import com.MangmentRessources.MangRess.Achat.repository.OrdreAchatRepo;
import com.MangmentRessources.MangRess.Achat.repository.DetailsOrdreAchatRepo;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class OrdreAchatService {
     private final OrdreAchatRepo ordreAchatRepo;
    
    private final DetailsOrdreAchatRepo detailsOrdreAchatRepo;

    public OrdreAchatService(OrdreAchatRepo ordreAchatRepo, DetailsOrdreAchatRepo detailsOrdreAchatRepo) {
        this.ordreAchatRepo = ordreAchatRepo;
        this.detailsOrdreAchatRepo = detailsOrdreAchatRepo;
    }
    
    

  
 
    @Transactional(readOnly = true)
    public List<OrdreAchatDTO> findAllOrdreAchat() {
        return OrdreAchatFactory.listOrdreAchatToOrdreAchatDTOs(ordreAchatRepo.findAll());

    }
    
    

    @Transactional(readOnly = true)
    public OrdreAchatDTO findOne(Integer code) {
        OrdreAchat domaine = ordreAchatRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.OrdreAchatNotFound");
        return OrdreAchatFactory.ordreAchatToOrdreAchatDTO(domaine);
    }
    
 
//    @Transactional(readOnly = true)
//    public OrdreAchatDTO findOneDetails(Integer code) {
//        OrdreAchat domaine = ordreAchatRepo.getReferenceById(code);
//        Preconditions.checkArgument(domaine.getCode() != null, "error.OrdreAchatNotFound");
//        return OrdreAchatFactory.DetailsordreAchatToDetailsOrdreAchatDTO(domaine);
//    }

//
 
    public OrdreAchat update(OrdreAchatDTO dTO) { 
        OrdreAchat domaine = ordreAchatRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.OrdreAchatNotFound");
        dTO.setCode(domaine.getCode());
        OrdreAchatFactory.ordreAchatDTOToOrdreAchatWithDetails(domaine, dTO);
        return ordreAchatRepo.save(domaine);
    }

    public OrdreAchatDTO updateNewWithFlush(OrdreAchatDTO dTO) { 
        OrdreAchat inBase = ordreAchatRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(inBase != null, "error.ModelePanierInexistant");

//        if ((inBase.getActif() != modelepanierDTO.getActif()) && (modelepanierDTO.getActif() == false)) {
//            boolean testopr = operationService.existsBycodeModeleCodeAndActif(modelepanierDTO.getCode());
//            Preconditions.checkArgument(testopr == false, "error.controleActif");
//
//            boolean testprest = prestationService.existsBycodeModeleCodeAndActif(modelepanierDTO.getCode());
//            Preconditions.checkArgument(testprest == false, "error.controleActif");
//        }
        inBase.getDetailsOrdreAchats().clear();
        ordreAchatRepo.flush();
        inBase = OrdreAchatFactory.ordreAchatDTOToOrdreAchatWithDetails(inBase, dTO);
        inBase = ordreAchatRepo.save(inBase);
        OrdreAchatDTO resultDTO = OrdreAchatFactory.UpdateordreAchatWithDetailsToordreAchatDTOWithDetails(inBase);
        return resultDTO;
    }

    public void deleteOrdreAchat(Integer code) {
        Preconditions.checkArgument(ordreAchatRepo.existsById(code), "error.OrdreAchatNotFound");
        ordreAchatRepo.deleteById(code);
    }

    public OrdreAchatDTO saveDdeAchat(OrdreAchatDTO Dto) { 
         
        OrdreAchat domaine = OrdreAchatFactory.ordreAchatDTOToOrdreAchatWithDetails(new OrdreAchat(), Dto);

        domaine.setCode(null);
        domaine.setUserCreate(domaine.getUserCreate());
        domaine.setDateCreate(new Date());
        domaine.setCodeSaisie(Dto.getCodeSaisie()); 
        
        domaine = ordreAchatRepo.save(domaine);
        OrdreAchatDTO resultDTO = OrdreAchatFactory.UpdateordreAchatWithDetailsToordreAchatDTOWithDetails(domaine);
        return resultDTO;
    }


    @Transactional(readOnly = true)
    public Collection<DetailsOrdreAchatDTO> findOneWithDetilas(Integer code) {
 
        Collection<DetailsOrdreAchat> collection = detailsOrdreAchatRepo.findByDetailsOrdreAchatPK_codeOrdreAchat(code);
        return DetailsOrdreAchatFactory.UpdatedetailsOrdreAchatTodetailsOrdreAchatDTOCollection(collection);
    }
    
}
