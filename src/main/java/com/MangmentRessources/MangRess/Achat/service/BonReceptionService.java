/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsBonReception;
import com.MangmentRessources.MangRess.Achat.domaine.BonReception;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchatPK;
import com.MangmentRessources.MangRess.Achat.dto.DetailsBonReceptionDTO;
import com.MangmentRessources.MangRess.Achat.dto.BonReceptionDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsOrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.OrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.factory.DetailsBonReceptionFactory;
import com.MangmentRessources.MangRess.Achat.factory.BonReceptionFactory;
import com.MangmentRessources.MangRess.Achat.repository.DetailsBonReceptionRepo;
import com.MangmentRessources.MangRess.Achat.repository.BonReceptionRepo;
import com.MangmentRessources.MangRess.Achat.repository.DetailsOrdreAchatRepo;
import com.MangmentRessources.MangRess.Achat.repository.OrdreAchatRepo;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Compteur;
import com.MangmentRessources.MangRess.ParametrageCentral.service.CompteurService;
import com.google.common.base.Preconditions;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
public class BonReceptionService {

    private final BonReceptionRepo bonReceptionRepo;
    private final CompteurService compteurService;
    private final DetailsBonReceptionRepo detailsBonReceptionRepo;
    private final OrdreAchatService achatService;
    private final DetailsOrdreAchatService detailsOrdreAchatService;
    private final DetailsOrdreAchatRepo detailsOrdreAchatRepo;
    private final DetailsReceptionTempService detailsReceptionTempService;

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

    public BonReceptionService(BonReceptionRepo bonReceptionRepo, CompteurService compteurService, DetailsBonReceptionRepo detailsBonReceptionRepo, OrdreAchatService achatService, DetailsOrdreAchatService detailsOrdreAchatService, DetailsOrdreAchatRepo detailsOrdreAchatRepo, DetailsReceptionTempService detailsReceptionTempService) {
        this.bonReceptionRepo = bonReceptionRepo;
        this.compteurService = compteurService;
        this.detailsBonReceptionRepo = detailsBonReceptionRepo;
        this.achatService = achatService;
        this.detailsOrdreAchatService = detailsOrdreAchatService;
        this.detailsOrdreAchatRepo = detailsOrdreAchatRepo;
        this.detailsReceptionTempService = detailsReceptionTempService;
    }

    @Transactional(readOnly = true)
    public List<BonReceptionDTO> findAllBonReception() {
        return BonReceptionFactory.listBonReceptionToBonReceptionDTOs(bonReceptionRepo.findAllByOrderByCodeSaisieDesc());

    }

    @Transactional(readOnly = true)
    public List<BonReceptionDTO> findOneByEtatReception(Integer codeEtatReception) {
        return BonReceptionFactory.listBonReceptionToBonReceptionDTOs(bonReceptionRepo.findBonReceptionByCodeEtatReception(codeEtatReception));
    }

    @Transactional(readOnly = true)
    public BonReceptionDTO findOne(Integer code) {
        BonReception domaine = bonReceptionRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine == null, "error.BonReceptionNotFound");
        return BonReceptionFactory.bonReceptionToBonReceptionDTO(domaine);
    }

//    @Transactional(readOnly = true)
//    public BonReceptionDTO findOneDetails(Integer code) {
//        BonReception domaine = bonReceptionRepo.getReferenceById(code);
//        Preconditions.checkArgument(domaine.getCode() != null, "error.BonReceptionNotFound");
//        return BonReceptionFactory.DetailsbonReceptionToDetailsBonReceptionDTO(domaine);
//    }
//
    public BonReception update(BonReceptionDTO dTO) {
        BonReception domaine = bonReceptionRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(domaine == null, "error.BonReceptionNotFound");
        dTO.setCode(domaine.getCode());
        BonReceptionFactory.bonReceptionDTOToBonReceptionWithDetails(domaine, dTO);
        return bonReceptionRepo.save(domaine);
    }

    public BonReceptionDTO updateNewWithFlush(BonReceptionDTO dTO) {
        BonReception inBase = bonReceptionRepo.getReferenceById(dTO.getCode());
//        Preconditions.checkArgument(inBase == null, "error.BonReceptionInexistant");

//        inBase.getDetailsBonReceptions().clear();
//        bonReceptionRepo.flush();
        inBase = BonReceptionFactory.bonReceptionDTOToBonReceptionWithDetails(inBase, dTO);
        inBase = bonReceptionRepo.save(inBase);
        BonReceptionDTO resultDTO = BonReceptionFactory.UpdatebonReceptionWithDetailsTobonReceptionDTOWithDetails(inBase);
        return resultDTO;
    }

    public void deleteBonReception(Integer code) {
        Preconditions.checkArgument(bonReceptionRepo.existsById(code), "error.BonReceptionNotFound");

//        BonReception inBase = bonReceptionRepo.findBonReceptionByCodeEtatReception(2);
//        System.out.println("inBase.getCodeEtatReception()" + inBase.getCodeEtatReception());
//        if (inBase.getCodeEtatReception() != null) {
//            Integer codeEtatRecept = inBase.getCodeEtatReception();
//            Preconditions.checkArgument(codeEtatRecept.equals("5"), "error.BonReceptionRecpetionnerTotalemenet");
//        }else if
//
//         (inBase.getCodeEtatReception() != null) {
//            Integer codeEtatRecept = inBase.getCodeEtatReception();
//            Preconditions.checkArgument(codeEtatRecept., "error.BonReceptionRecpetionnerPartielement");
//        }else
//        {
//        }
//        List<BonReception> inBase = bonReceptionRepo.findBonReceptionByCodeEtatReception(9);
        bonReceptionRepo.deleteById(code);

    }

    public BonReceptionDTO saveBonReception(BonReceptionDTO Dto) {
        com.MangmentRessources.MangRess.web.Util.Preconditions.checkBusinessLogique(Dto.getCodeDepot() != null, "error.DepotRequired");
        Collection<DetailsBonReceptionDTO> detailsBonReceptions = new ArrayList<>();
        detailsBonReceptions = Dto.getDetailsBonReceptionDTOs();
        Collection<DetailsOrdreAchatDTO> detailsOrdreAchatDTOs = detailsOrdreAchatService.findOne(Dto.getCodeOrdreAchat());
        OrdreAchatDTO ordreAchatDTO = null;
        List<DetailsOrdreAchatDTO> listDetailsOrdreAchatDTOs = new ArrayList<>();
        for (DetailsBonReceptionDTO detail : detailsBonReceptions) {
            BigDecimal qteDemander;
            Optional<DetailsOrdreAchatDTO> details = detailsOrdreAchatDTOs.stream().filter(x -> (x.getCodeMatieres().equals(detail.getCodeMatieres()))).findFirst();

            if (details.isPresent()) {
                qteDemander = details.get().getQteDemander();

                BigDecimal qteOldReviced = details.get().getQteLivrer();
                BigDecimal qteLivree = detail.getQteReceptionner();
                BigDecimal sumQteLivred = qteOldReviced.add(qteLivree);

                if (qteDemander.compareTo(sumQteLivred) > 0) {

                    ordreAchatDTO = detailsOrdreAchatDTOs.iterator().next().getOrdreAchatDTO();
                    ordreAchatDTO.setCodeEtatReception(5);

                    break;
                } else if (qteDemander.compareTo(sumQteLivred) <= 0) {
                    ordreAchatDTO = detailsOrdreAchatDTOs.iterator().next().getOrdreAchatDTO();
                    ordreAchatDTO.setCodeEtatReception(7);
                }
            }

            com.MangmentRessources.MangRess.web.Util.Preconditions.checkBusinessLogique(detail.getQteReceptionner() != null, "error.QuantiteRecptionnerRequired");
        }

        for (DetailsBonReceptionDTO detail : detailsBonReceptions) {

            Optional<DetailsOrdreAchatDTO> details = detailsOrdreAchatDTOs.stream().filter(x -> (x.getCodeMatieres().equals(detail.getCodeMatieres())) && (x.getCodeOrdreAchat().equals(detail.getCodeOrdreAchat()))).findFirst();
            DetailsOrdreAchatDTO newDetails = new DetailsOrdreAchatDTO();

            BigDecimal qteOldReviced = details.get().getQteLivrer();
            BigDecimal qteLivree = detail.getQteReceptionner();
            BigDecimal sumQteLivredx = qteOldReviced.add(qteLivree);

            if (details.isPresent()) {
                newDetails = details.get();

                if (details.get().getQteDemander().compareTo(sumQteLivredx) >= 0) {
                    newDetails.setTotalementLivred(Boolean.FALSE);

                } else {
                    newDetails.setTotalementLivred(Boolean.TRUE);
                }

                listDetailsOrdreAchatDTOs.add(newDetails);

            }
            System.out.println("sumQteLivredx"+sumQteLivredx);
            newDetails.setQteLivrer(qteLivree);
        }

        BonReception domaine = BonReceptionFactory.bonReceptionDTOToBonReceptionWithDetails(new BonReception(), Dto);

        domaine.setCode(null);
        domaine.setUserCreate(domaine.getUserCreate());
        domaine.setDateCreate(new Date());
        Compteur CompteurCodeSaisie = compteurService.findOne("codeSaisieBR");
        String codeSaisieDA = CompteurCodeSaisie.getPrefixe() + CompteurCodeSaisie.getSuffixe();
        domaine.setCode(null);
        domaine.setUserCreate(domaine.getUserCreate());
        domaine.setCodeFactureFournisseur(domaine.getCodeFactureFournisseur());
        domaine.setDateFactureFournisseur(domaine.getDateFactureFournisseur());
        domaine.setMntFactureFournisseur(domaine.getMntFactureFournisseur());

        domaine.setDateCreate(new Date());
        domaine.setCodeSaisie(codeSaisieDA);
        compteurService.incrementeSuffixe(CompteurCodeSaisie);

        domaine = bonReceptionRepo.save(domaine);
        achatService.updateEtatRecpetion(ordreAchatDTO);
        detailsOrdreAchatService.update(listDetailsOrdreAchatDTOs);
        detailsReceptionTempService.deleteByCodeOrdreAchat(Dto.getCodeOrdreAchat());
        BonReceptionDTO resultDTO = BonReceptionFactory.UpdatebonReceptionWithDetailsTobonReceptionDTOWithDetails(domaine);

        return resultDTO;
    }

    @Transactional(readOnly = true)
    public Collection<DetailsBonReceptionDTO> findOneWithDetilas(Integer code) {

        Collection<DetailsBonReception> collection = detailsBonReceptionRepo.findByDetailsBonReceptionPK_codeBonReception(code);
        return DetailsBonReceptionFactory.UpdatedetailsBonReceptionTodetailsBonReceptionDTOCollection(collection);
    }
}
