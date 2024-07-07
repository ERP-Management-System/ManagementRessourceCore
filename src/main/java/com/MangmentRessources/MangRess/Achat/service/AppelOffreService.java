/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.AppelOffre;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsAppelOffre;
import com.MangmentRessources.MangRess.Achat.domaine.OrdreAchat;
import com.MangmentRessources.MangRess.Achat.dto.AppelOffreDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsAppelOffreDTO;
import com.MangmentRessources.MangRess.Achat.factory.AppelOffreFactory;
import com.MangmentRessources.MangRess.Achat.factory.DetailsAppelOffreFactory;
import com.MangmentRessources.MangRess.Achat.repository.AppelOffreRepo;
import com.MangmentRessources.MangRess.Achat.repository.DetailsAppelOffreRepo;
import com.MangmentRessources.MangRess.Achat.repository.OrdreAchatRepo;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Compteur;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.param;
import com.MangmentRessources.MangRess.ParametrageCentral.service.CompteurService;
import com.MangmentRessources.MangRess.ParametrageCentral.service.ParamService;
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
    private final CompteurService compteurService;
    private final DetailsAppelOffreService detailsAppelOffreService;
    private final DetailsAppelOffreRepo detailsAppelOffreRepo;
    private final OrdreAchatRepo ordreAchatRepo;

    public AppelOffreService(AppelOffreRepo appelOffreRepo, CompteurService compteurService, DetailsAppelOffreService detailsAppelOffreService, DetailsAppelOffreRepo detailsAppelOffreRepo, OrdreAchatRepo ordreAchatRepo) {
        this.appelOffreRepo = appelOffreRepo;
        this.compteurService = compteurService;
        this.detailsAppelOffreService = detailsAppelOffreService;
        this.detailsAppelOffreRepo = detailsAppelOffreRepo;
        this.ordreAchatRepo = ordreAchatRepo;
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

    @Transactional(readOnly = true)
    public AppelOffreDTO findOneDetails(Integer code) {
        AppelOffre domaine = appelOffreRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.AppelOffreNotFound");
        return AppelOffreFactory.appelOffreToAppelOffreDTO(domaine);
    }

//    @Transactional(readOnly = true)
//    public List<AppelOffreDTO> findOneByEtatApprouver(Integer CodeEtatApprouverOrdreAchat) {
//        return AppelOffreFactory.listAppelOffreToAppelOffreDTOs(appelOffreRepo.findAppelOffreByCodeEtatApprouverOrdreAchat(CodeEtatApprouverOrdreAchat));
//    }

    public AppelOffreDTO updateNewWithFlush(AppelOffreDTO modelepanierDTO) {
        AppelOffre inBase = appelOffreRepo.getReferenceById(modelepanierDTO.getCode());
        Preconditions.checkArgument(inBase != null, "error.ModelePanierInexistant");
        inBase.getDetailsAppelOffresCollections().clear();
        appelOffreRepo.flush();
        inBase = AppelOffreFactory.appelOffreDTOToAppelOffreWithDetails(inBase, modelepanierDTO);
        inBase = appelOffreRepo.save(inBase);
        AppelOffreDTO resultDTO = AppelOffreFactory.UpdateappelOffreWithDetailsToappelOffreDTOWithDetails(inBase);
        return resultDTO;
    }

    public void deleteAppelOffre(Integer code) {
        Preconditions.checkArgument(appelOffreRepo.existsById(code), "error.AppelOffreNotFound");
//        AppelOffre inBase = appelOffreRepo.getReferenceById(code);
//                Preconditions.checkArgument(inBase.getCodeEtatApprouverOrdreAchat().equals("3"), "error.AppelOffreRefuser"); 
        OrdreAchat ordreAchat = ordreAchatRepo.findByCodeAppelOffre(code);
        Preconditions.checkArgument(ordreAchat == null, "error.AppelOffreInOrdreAchat"); 
        detailsAppelOffreService.deleteByCodeAppelOffre(code); 
        appelOffreRepo.deleteById(code);
    }

    public AppelOffreDTO saveAO(AppelOffreDTO Dto) {

        log.debug("Request to update Convention : {}", Dto);
        AppelOffre domaine = AppelOffreFactory.appelOffreDTOToAppelOffreWithDetails(new AppelOffre(), Dto);
        Compteur CompteurCodeSaisie = compteurService.findOne("codeSaisieAO");
        String codeSaisieAO = CompteurCodeSaisie.getPrefixe() + CompteurCodeSaisie.getSuffixe();
        domaine.setCode(null);
        domaine.setUserCreate(domaine.getUserCreate());
        domaine.setDateCreate(new Date());
        domaine.setCodeSaisie(codeSaisieAO);
        compteurService.incrementeSuffixe(CompteurCodeSaisie);
        domaine = appelOffreRepo.save(domaine);
        AppelOffreDTO resultDTO = AppelOffreFactory.appelOffreWithDetailsToappelOffreDTOWithDetails(domaine);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public Collection<DetailsAppelOffreDTO> findOneWithDetilas(Integer code) {
        Collection<DetailsAppelOffre> detailsOrdreAchats = detailsAppelOffreRepo.findByDetailsAppelOffrePK_codeAppelOffre(code);
        return DetailsAppelOffreFactory.UpdatedetailsAppelOffreTodetailsAppelOffreDTOCollection(detailsOrdreAchats);
    }

}
