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
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Compteur;
import com.MangmentRessources.MangRess.ParametrageCentral.service.CompteurService;
import com.google.common.base.Preconditions;
import jakarta.persistence.EntityManager;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private final CompteurService compteurService;
    private final DetailsOrdreAchatRepo detailsOrdreAchatRepo;
    private final AppelOffreService appelOffreService;
//    @Autowired
//    private MessageSource messageSource;
//    

    static String LANGUAGE_SEC;
    @Autowired
    EntityManager entityManager;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public OrdreAchatService(OrdreAchatRepo ordreAchatRepo, CompteurService compteurService, DetailsOrdreAchatRepo detailsOrdreAchatRepo, AppelOffreService appelOffreService) {
        this.ordreAchatRepo = ordreAchatRepo;
        this.compteurService = compteurService;
        this.detailsOrdreAchatRepo = detailsOrdreAchatRepo;
        this.appelOffreService = appelOffreService;
    }

//    private final static String  Product_notfound= "error.OrdreAchatRecpetionnerTotalemenet";  
//    private final static String  productUSer= "error.OrdreAchatRecpetionnerTotalemenet";
//    private String getMessage(String code, Object... args) {
//        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
//    }
    @Transactional(readOnly = true)
    public List<OrdreAchatDTO> findAllOrdreAchat() {
        return OrdreAchatFactory.listOrdreAchatToOrdreAchatDTOs(ordreAchatRepo.findAllByOrderByCodeSaisieDesc());

    }

    @Transactional(readOnly = true)
    public List<OrdreAchatDTO> findOneByEtatReception(Integer codeEtatReception) {
        return OrdreAchatFactory.listOrdreAchatToOrdreAchatDTOs(ordreAchatRepo.findOrdreAchatByCodeEtatReception(codeEtatReception));
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
        
        dTO.setDetailsOrdreAchatDTOs(DetailsOrdreAchatFactory.UpdatedetailsOrdreAchatTodetailsOrdreAchatDTOCollection(domaine.getDetailsOrdreAchats()));
        
          System.out.println("nourhene getCodematiere  " + dTO.getDetailsOrdreAchatDTOs().iterator().next().getCodeMatieres());
        OrdreAchatFactory.ordreAchatDTOToOrdreAchatWithDetails(domaine, dTO);
        return ordreAchatRepo.save(domaine);
    }
    
 
    public OrdreAchat updateEtatRecpetion(OrdreAchatDTO dTO) {
        OrdreAchat domaine = ordreAchatRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.OrdreAchatNotFound");
        dTO.setCode(domaine.getCode());
        OrdreAchatFactory.ordreAchatDTOToOrdreAchat(dTO,domaine );
        System.out.println("Update etat reception ");
        return ordreAchatRepo.save(domaine);
    }
    
    
        public Boolean updateEtatRecpetions(OrdreAchat ordreAchat) {
        if (ordreAchat != null) {
            ordreAchat.setCodeEtatReception(ordreAchat.getCodeEtatReception());
            ordreAchatRepo.save(ordreAchat);
            return true;
        } else {
            return false;
        }
    }
    
    public OrdreAchatDTO updateNewWithFlush(OrdreAchatDTO dTO) {
        OrdreAchat inBase = ordreAchatRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(inBase != null, "error.OrdreAchatInexistant");

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

//        OrdreAchat inBase = ordreAchatRepo.findOrdreAchatByCodeEtatReception(2);
//        System.out.println("inBase.getCodeEtatReception()" + inBase.getCodeEtatReception());
//        if (inBase.getCodeEtatReception() != null) {
//            Integer codeEtatRecept = inBase.getCodeEtatReception();
//            Preconditions.checkArgument(codeEtatRecept.equals("5"), "error.OrdreAchatRecpetionnerTotalemenet");
//        }else if
//
//         (inBase.getCodeEtatReception() != null) {
//            Integer codeEtatRecept = inBase.getCodeEtatReception();
//            Preconditions.checkArgument(codeEtatRecept., "error.OrdreAchatRecpetionnerPartielement");
//        }else
//        {
//        }
//        List<OrdreAchat> inBase = ordreAchatRepo.findOrdreAchatByCodeEtatReception(9);

        ordreAchatRepo.deleteById(code);

    }

    public OrdreAchatDTO saveOrdreAchat(OrdreAchatDTO Dto) {

        OrdreAchat domaine = OrdreAchatFactory.ordreAchatDTOToOrdreAchatWithDetails(new OrdreAchat(), Dto);

        domaine.setCode(null);
        domaine.setUserCreate(domaine.getUserCreate());
        domaine.setDateCreate(new Date());
        Compteur CompteurCodeSaisie = compteurService.findOne("codeSaisieOA");
        String codeSaisieDA = CompteurCodeSaisie.getPrefixe() + CompteurCodeSaisie.getSuffixe();
        domaine.setCode(null);
        domaine.setUserCreate(domaine.getUserCreate());
        domaine.setDateCreate(new Date());
        domaine.setCodeSaisie(codeSaisieDA);
        compteurService.incrementeSuffixe(CompteurCodeSaisie);
        domaine = ordreAchatRepo.save(domaine);
        OrdreAchatDTO resultDTO = OrdreAchatFactory.UpdateordreAchatWithDetailsToordreAchatDTOWithDetails(domaine);

//        AppelOffreDTO appelOffreDTO = appelOffreService.findOne(domaine.getCodeAppelOffre());
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public Collection<DetailsOrdreAchatDTO> findOneWithDetilas(Integer code) {

        Collection<DetailsOrdreAchat> collection = detailsOrdreAchatRepo.findByDetailsOrdreAchatPK_codeOrdreAchat(code);
        return DetailsOrdreAchatFactory.UpdatedetailsOrdreAchatTodetailsOrdreAchatDTOCollection(collection);
    }

}
