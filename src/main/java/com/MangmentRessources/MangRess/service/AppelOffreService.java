/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.AppelOffre;
import com.MangmentRessources.MangRess.domaine.FamilleArticle;
import com.MangmentRessources.MangRess.dto.AppelOffreDTO;
import com.MangmentRessources.MangRess.dto.DetailsAppelOffreDTO;
import com.MangmentRessources.MangRess.dto.FamilleArticleDTO;
import com.MangmentRessources.MangRess.factory.AppelOffreFactory;
import com.MangmentRessources.MangRess.factory.FamilleArticleFactory;
import com.MangmentRessources.MangRess.repository.AppelOffreRepo;
import com.google.common.base.Preconditions;
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
public class AppelOffreService {

    private final AppelOffreRepo appelOffreRepo;

    public AppelOffreService(AppelOffreRepo appelOffreRepo) {
        this.appelOffreRepo = appelOffreRepo;
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

//
    public AppelOffreDTO save(AppelOffreDTO dTO) {
        AppelOffre domaine = AppelOffreFactory.appelOffreDTOToAppelOffre(dTO, new AppelOffre());
        domaine = appelOffreRepo.save(domaine);
        return AppelOffreFactory.appelOffreToAppelOffreDTO(domaine);
    }

    public AppelOffre update(AppelOffreDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.AppelOffreNotFound");
        AppelOffre domaine = appelOffreRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.AppelOffreNotFound");
        dTO.setCode(domaine.getCode());
        AppelOffreFactory.appelOffreDTOToAppelOffre(dTO, domaine);
        return appelOffreRepo.save(domaine);
    }

    public void deleteAppelOffre(Integer code) {
        Preconditions.checkArgument(appelOffreRepo.existsById(code), "error.AppelOffreNotFound");
        appelOffreRepo.deleteById(code);
    }

//    @Transactional(readOnly = true)
//    public AppelOffreDTO findOneWithDetilas(Integer code) {
//        AppelOffre domaine = appelOffreRepo.getReferenceById(code);
//        Preconditions.checkArgument(domaine.getCode() != null, "error.AppelOffreNotFound");
//        return AppelOffreFactory.AppelOffreToAppelOffreDTOCollection(domaine);
//    }
//    public AppelOffreDTO saveWithDetails(AppelOffreDTO dTO) {
////        log.debug("Request to save dde DdeTransfer: {}", dTO);
//        AppelOffre appelOffre = AppelOffreFactory.ordreAchatDTOToordreAchatCollection(dTO, new AppelOffre());
//        appelOffre = appelOffreRepo.save(appelOffre);
//        return AppelOffreFactory.AppelOffreToAppelOffreDTOCollection(appelOffre);
//    }
//
//    public AppelOffreDTO saveNew(AppelOffreDTO ddeAchatDTO) {
////        log.debug("Request to save dde DdeTransfer: {}", ddeAchatDTO);
//        AppelOffre ddeAchat = AppelOffreFactory.ddeAchatDTOToddeAchatCollection(ddeAchatDTO, new AppelOffre());
//        ddeAchat = appelOffreRepo.save(ddeAchat);
//        return AppelOffreFactory.ddeAchatToddeAchatDTOwithDetails(ddeAchat);
//    }
    public AppelOffreDTO saveAO(AppelOffreDTO Dto) { 

        
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
    public AppelOffreDTO findOneWithDetilas(Integer code) {
        AppelOffre domaine = appelOffreRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.AppelOffreNotFound");
        return AppelOffreFactory.appelOffreWithDetailsToappelOffreDTOWithDetails(domaine);
    }

}
