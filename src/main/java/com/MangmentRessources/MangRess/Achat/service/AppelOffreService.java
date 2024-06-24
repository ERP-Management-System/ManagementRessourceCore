/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.AppelOffre;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsAppelOffre; 
import com.MangmentRessources.MangRess.Achat.dto.AppelOffreDTO; 
import com.MangmentRessources.MangRess.Achat.dto.DetailsAppelOffreDTO; 
import com.MangmentRessources.MangRess.Achat.factory.AppelOffreFactory;
import com.MangmentRessources.MangRess.Achat.factory.DetailsAppelOffreFactory; 
import com.MangmentRessources.MangRess.Achat.repository.AppelOffreRepo;
import com.MangmentRessources.MangRess.Achat.repository.DetailsAppelOffreRepo;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class AppelOffreService {

     private final Logger log = LoggerFactory.getLogger(AppelOffreService.class);
    
     
     
    private final AppelOffreRepo appelOffreRepo;

    private final DetailsAppelOffreRepo detailsAppelOffreRepo;

    public AppelOffreService(AppelOffreRepo appelOffreRepo, DetailsAppelOffreRepo detailsAppelOffreRepo) {
        this.appelOffreRepo = appelOffreRepo;
        this.detailsAppelOffreRepo = detailsAppelOffreRepo;
    }

    @Transactional(readOnly = true)
    public List<AppelOffreDTO> findAllAppelOffre() {
        return AppelOffreFactory.listAppelOffreToAppelOffreDTOs(appelOffreRepo.findAll());

    }
    
    

    @Transactional(readOnly = true)
    public AppelOffreDTO findOne(Integer code) {
        AppelOffre domaine = appelOffreRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.AppelOffreNotFound");
        return AppelOffreFactory.appelOffreToAppelOffreDTO(domaine);
    }
    
    
//        @Transactional(readOnly = true)
//    public CopieAODTO findOneToCopy(Integer code) {
//        AppelOffre domaine = appelOffreRepo.getReferenceById(code);
//        Preconditions.checkArgument(domaine.getCode() != null, "error.AppelOffreNotFound");
//        return AppelOffreFactory.appelOffreToAppelOffreDTO(domaine);
//    }

    @Transactional(readOnly = true)
    public AppelOffreDTO findOneDetails(Integer code) {
        AppelOffre domaine = appelOffreRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.AppelOffreNotFound");
        return AppelOffreFactory.appelOffreToAppelOffreDTO(domaine);
    }

//
//    public AppelOffreDTO save(AppelOffreDTO dTO) {
//        AppelOffre domaine = AppelOffreFactory.appelOffreDTOToAppelOffre(dTO, new AppelOffre());
//        domaine = appelOffreRepo.save(domaine);
//        return AppelOffreFactory.appelOffreToAppelOffreDTO(domaine);
//    }
    public AppelOffre update(AppelOffreDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.AppelOffreNotFound");
        AppelOffre domaine = appelOffreRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.AppelOffreNotFound");
        dTO.setCode(domaine.getCode());
        AppelOffreFactory.appelOffreDTOToAppelOffreWithDetails(domaine, dTO);
        return appelOffreRepo.save(domaine);
    }

    public AppelOffreDTO updateNewWithFlush(AppelOffreDTO modelepanierDTO) { 
        AppelOffre inBase = appelOffreRepo.getReferenceById(modelepanierDTO.getCode());
        Preconditions.checkArgument(inBase != null, "error.ModelePanierInexistant");

//        if ((inBase.getActif() != modelepanierDTO.getActif()) && (modelepanierDTO.getActif() == false)) {
//            boolean testopr = operationService.existsBycodeModeleCodeAndActif(modelepanierDTO.getCode());
//            Preconditions.checkArgument(testopr == false, "error.controleActif");
//
//            boolean testprest = prestationService.existsBycodeModeleCodeAndActif(modelepanierDTO.getCode());
//            Preconditions.checkArgument(testprest == false, "error.controleActif");
//        }
        inBase.getDetailsAppelOffresCollections().clear();
        appelOffreRepo.flush();
        inBase = AppelOffreFactory.appelOffreDTOToAppelOffreWithDetails(inBase, modelepanierDTO);
        inBase = appelOffreRepo.save(inBase);
        AppelOffreDTO resultDTO = AppelOffreFactory.UpdateappelOffreWithDetailsToappelOffreDTOWithDetails(inBase);
        return resultDTO;
    }

    public void deleteAppelOffre(Integer code) {
        Preconditions.checkArgument(appelOffreRepo.existsById(code), "error.AppelOffreNotFound");
        appelOffreRepo.deleteById(code);
    }

    public AppelOffreDTO saveAO(AppelOffreDTO Dto) { 
        
         log.debug("Request to update Convention : {}",Dto);
        AppelOffre domaine = AppelOffreFactory.appelOffreDTOToAppelOffreWithDetails(new AppelOffre(), Dto);

        domaine.setCode(null);
        domaine.setUserCreate(domaine.getUserCreate());
        domaine.setDateCreate(new Date());
        domaine.setCodeSaisie(Dto.getCodeSaisie()); 
        
        domaine = appelOffreRepo.save(domaine);
        AppelOffreDTO resultDTO = AppelOffreFactory.appelOffreWithDetailsToappelOffreDTOWithDetails(domaine);
        return resultDTO;
    }


    @Transactional(readOnly = true)
    public Collection<DetailsAppelOffreDTO> findOneWithDetilas(Integer code) {
//        log.debug("Request to get Affectation: {}", code);
        Collection<DetailsAppelOffre> detailsOrdreAchats = detailsAppelOffreRepo.findByDetailsAppelOffrePK_codeAppelOffre(code);
        return DetailsAppelOffreFactory.UpdatedetailsAppelOffreTodetailsAppelOffreDTOCollection(detailsOrdreAchats);
    }

}
