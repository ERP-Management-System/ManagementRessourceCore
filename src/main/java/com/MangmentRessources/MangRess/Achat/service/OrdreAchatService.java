/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsBonReception;
import com.MangmentRessources.MangRess.Achat.domaine.OrdreAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchat;
import com.MangmentRessources.MangRess.Achat.dto.DetailsBonReceptionDTO;
import com.MangmentRessources.MangRess.Achat.dto.OrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsOrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.factory.OrdreAchatFactory;
import com.MangmentRessources.MangRess.Achat.factory.DetailsOrdreAchatFactory;
import com.MangmentRessources.MangRess.Achat.repository.DetailsBonReceptionRepo;
import com.MangmentRessources.MangRess.Achat.repository.OrdreAchatRepo;
import com.MangmentRessources.MangRess.Achat.repository.DetailsOrdreAchatRepo;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Compteur;
import com.MangmentRessources.MangRess.ParametrageCentral.service.CompteurService;
import com.google.common.base.Preconditions;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
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
public class OrdreAchatService {

    private final OrdreAchatRepo ordreAchatRepo;
    private final CompteurService compteurService;
    private final DetailsOrdreAchatRepo detailsOrdreAchatRepo;
    private final AppelOffreService appelOffreService;
    private final DetailsBonReceptionRepo detailsBonReceptionRepo;

    static String LANGUAGE_SEC;
    @Autowired
    EntityManager entityManager;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public OrdreAchatService(OrdreAchatRepo ordreAchatRepo, CompteurService compteurService, DetailsOrdreAchatRepo detailsOrdreAchatRepo, AppelOffreService appelOffreService, DetailsBonReceptionRepo detailsBonReceptionRepo) {
        this.ordreAchatRepo = ordreAchatRepo;
        this.compteurService = compteurService;
        this.detailsOrdreAchatRepo = detailsOrdreAchatRepo;
        this.appelOffreService = appelOffreService;
        this.detailsBonReceptionRepo = detailsBonReceptionRepo;
    }

    @Transactional(readOnly = true)
    public List<OrdreAchatDTO> findAllOrdreAchat() {
        return OrdreAchatFactory.listOrdreAchatToOrdreAchatDTOs(ordreAchatRepo.findAllByOrderByCodeSaisieDesc());

    }

    @Transactional(readOnly = true)
    public List<OrdreAchatDTO> findOneByEtatReception(Integer codeEtatReception) {
        return OrdreAchatFactory.listOrdreAchatToOrdreAchatDTOs(ordreAchatRepo.findOrdreAchatByCodeEtatReception(codeEtatReception));
    }

    @Transactional(readOnly = true)
    public List<OrdreAchatDTO> findOneByEtatReceptionAndNotFullRecived(List<Integer> codeEtatReception) {
        return OrdreAchatFactory.listOrdreAchatToOrdreAchatDTOs(ordreAchatRepo.findOrdreAchatByCodeEtatReceptionIn(codeEtatReception).stream().filter(order
                -> order.getDetailsOrdreAchats().iterator().next().getQteDemander().compareTo(order.getDetailsOrdreAchats().iterator().next().getQteLivrer()) < 0).collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public List<OrdreAchatDTO> findOneByEtatReceptionIn(List<Integer> codeEtatReception) {
        return OrdreAchatFactory.listOrdreAchatToOrdreAchatDTOs(ordreAchatRepo.findOrdreAchatByCodeEtatReceptionIn(codeEtatReception));
    }

    @Transactional(readOnly = true)
    public OrdreAchatDTO findOne(Integer code) {
        OrdreAchat domaine = ordreAchatRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.OrdreAchatNotFound");
        return OrdreAchatFactory.ordreAchatToOrdreAchatDTO(domaine);
    }

//    public OrdreAchat update(OrdreAchatDTO dTO) {
//        OrdreAchat domaine = ordreAchatRepo.getReferenceById(dTO.getCode());
//        Preconditions.checkArgument(true, "error.OrdreAchatNotFound");
//        dTO.setCode(domaine.getCode());
//
//        dTO.setDetailsOrdreAchatDTOs(DetailsOrdreAchatFactory.UpdatedetailsOrdreAchatTodetailsOrdreAchatDTO(domaine.getDetailsOrdreAchats()));
// 
//        OrdreAchatFactory.ordreAchatDTOToOrdreAchatWithDetails(domaine, dTO);
//        return ordreAchatRepo.save(domaine);
//    }
    public OrdreAchat updateEtatRecpetion(OrdreAchatDTO dTO) {
        OrdreAchat domaine = ordreAchatRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.OrdreAchatNotFound");
        dTO.setCode(domaine.getCode());
        OrdreAchatFactory.ordreAchatDTOToOrdreAchat(dTO, domaine);
        return ordreAchatRepo.save(domaine);
    }

    public OrdreAchatDTO updateNewWithFlush(OrdreAchatDTO ordreAchatDTO) {
        OrdreAchat inBase = ordreAchatRepo.getReferenceById(ordreAchatDTO.getCode());
        Preconditions.checkArgument(inBase != null, "error.ordreAchatDTOInexistant");
        inBase.getDetailsOrdreAchats().clear();
        ordreAchatRepo.flush();
      
        inBase = OrdreAchatFactory.ordreAchatDTOToOrdreAchatWithDetails(inBase, ordreAchatDTO);
              System.out.println("xxx"  +inBase.getDetailsOrdreAchats().iterator().next().getCodematiere() );
        inBase = ordreAchatRepo.save(inBase);
        OrdreAchatDTO resultDTO = OrdreAchatFactory.UpdateordreAchatWithDetailsToordreAchatDTOWithDetails(inBase);
        return resultDTO;
    }

    public void deleteOrdreAchat(Integer code) {
        Preconditions.checkArgument(ordreAchatRepo.existsById(code), "error.OrdreAchatNotFound");

        ordreAchatRepo.deleteById(code);

    }

    public OrdreAchatDTO saveOrdreAchat(OrdreAchatDTO Dto) {
//        DetailsOrdreAchatPK det = null;
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
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public Collection<DetailsOrdreAchatDTO> findOneWithDetilas(Integer code) {
        Collection<DetailsOrdreAchat> detailsOrdreAchats = detailsOrdreAchatRepo.findByDetailsOrdreAchatPK_codeOrdreAchat(code);
        return DetailsOrdreAchatFactory.UpdatedetailsOrdreAchatTodetailsOrdreAchatDTOCollection(detailsOrdreAchats);
    }

    @Transactional(readOnly = true)
    public Collection<DetailsOrdreAchatDTO> findOneWithDetilasTotalmentLivredFalse(Integer code, Boolean totalementLivred) {
        Collection<DetailsOrdreAchat> detailsOrdreAchats = detailsOrdreAchatRepo.findByDetailsOrdreAchatPK_codeOrdreAchatAndTotalementLivred(code, totalementLivred);
        return DetailsOrdreAchatFactory.UpdatedetailsOrdreAchatTodetailsOrdreAchatDTOCollection(detailsOrdreAchats);
    }

//
//    // get details OrdreAchat non receptionner compelet
//    public List<DetailsOrdreAchatDTO> getDetailsOrdreAchatNonCompleteReceptionner() {
//        List<DetailsOrdreAchat> orders = detailsOrdreAchatRepo.findAll();
//        List<DetailsOrdreAchatDTO> discrepancyOrders = new ArrayList<>();
//        for (DetailsOrdreAchat order : orders) {
//            BigDecimal quantityReceived = getQuantityReceivedForOrder(order.getDetailsOrdreAchatPK().getCodeOrdreAchat());
//
//            // Check if there's a discrepancy
//            if (order.getQteDemander().compareTo(quantityReceived) != 0) {
//                DetailsOrdreAchatDTO orderDto = new DetailsOrdreAchatDTO(order.getDetailsOrdreAchatPK().getCodeOrdreAchat(), order.getCodematiere(), order.getMatiere().getCodeSaisie(), order.getMatiere().getDesignationAr(), order.getMatiere().getDesignationLt(), order.getUnite().getCode(), order.getUnite().getCodeSaisie(), order.getUnite().getDesignationAr(), order.getUnite().getDesignationLt(), order.getColoris().getCode(), order.getColoris().getCodeSaisie(), order.getColoris().getDesignationAr(), order.getColoris().getDesignationLt(), order.getQteDemander(), quantityReceived, order.getMatiere().getPrixAchat(), order.getMatiere().getTaxe().getValeurTaxe());
//                discrepancyOrders.add(orderDto);
//            }
//        }
//        return discrepancyOrders;
//    }
//
//    private BigDecimal getQuantityReceivedForOrder(Integer orderId) {
//        // Retrieve all receipts for the order
//        List<DetailsBonReception> receipts = detailsBonReceptionRepo.findByCodeOrdreAchat(orderId);
//
//        // Calculate the total quantity received
//        BigDecimal quantityReceived = BigDecimal.ZERO;
//        for (DetailsBonReception receipt : receipts) {
//
//            Optional<DetailsBonReception> details = receipts.stream().filter(x -> (x.getCodematiere().equals(receipt.getCodematiere()))).findFirst();
//            if (details.isPresent()) {
//                quantityReceived = receipt.getQteReceptionner();
//            }
//        }
//
//        return quantityReceived;
//    }
//
//    //// get Grouped OrdreAchat non receptionner compelet
//    public List<OrdreAchatDTO> getOrdreAchatNonCompleteReceptionner() {
//        List<OrdreAchat> orders = ordreAchatRepo.findAll();
//        List<OrdreAchatDTO> discrepancyOrders = new ArrayList<>();
//        for (OrdreAchat order : orders) {
//            // Calculate the quantity received for the order based on receipts
//            BigDecimal quantityReceived = getQuantityReceivedForOrderGrouped(order.getCode());
//
//            // Check if there's a discrepancy
//            if (order.getDetailsOrdreAchats().iterator().next().getQteDemander().compareTo(quantityReceived) != 0) {
//                OrdreAchatDTO orderDto = new OrdreAchatDTO(order.getCode(), order.getCodeSaisie());
//                discrepancyOrders.add(orderDto);
//            }
//        }
//        return discrepancyOrders;
//    }
//
//    private BigDecimal getQuantityReceivedForOrderGrouped(Integer orderId) {
//        // Retrieve all receipts for the order
//        List<DetailsBonReception> receipts = detailsBonReceptionRepo.findByCodeOrdreAchat(orderId);
//
//        // Calculate the total quantity received
//        BigDecimal quantityReceived = BigDecimal.ZERO;
//        for (DetailsBonReception receipt : receipts) {
//            quantityReceived = quantityReceived.add(receipt.getQteReceptionner());
//        }
//
//        return quantityReceived;
//    }
//
//    public Collection<DetailsOrdreAchatDTO> getDetailsOrdreAchatNonCompleteReceptionnerByCode(Integer codeOrdreAchat) {
//        Collection<DetailsOrdreAchat> orders = detailsOrdreAchatRepo.findByDetailsOrdreAchatPK_codeOrdreAchat(codeOrdreAchat);
//        Collection<DetailsOrdreAchatDTO> discrepancyOrders = new ArrayList<>();
//        for (DetailsOrdreAchat order : orders) {
//            // Calculate the quantity received for the order based on receipts
//            BigDecimal quantityReceived = getQuantityReceivedForOrderByCode(order.getDetailsOrdreAchatPK().getCodeOrdreAchat());
//
//            // Check if there's a discrepancy
//            if (order.getQteDemander().compareTo(quantityReceived) > 0) {
//                DetailsOrdreAchatDTO orderDto = new DetailsOrdreAchatDTO(order.getDetailsOrdreAchatPK().getCodeOrdreAchat(), order.getCodematiere(), order.getMatiere().getCodeSaisie(), order.getMatiere().getDesignationAr(), order.getMatiere().getDesignationLt(), order.getUnite().getCode(), order.getUnite().getCodeSaisie(), order.getUnite().getDesignationAr(), order.getUnite().getDesignationLt(), order.getColoris().getCode(), order.getColoris().getCodeSaisie(), order.getColoris().getDesignationAr(), order.getColoris().getDesignationLt(), order.getQteDemander(), quantityReceived, order.getMatiere().getPrixAchat(), order.getMatiere().getTaxe().getValeurTaxe());
//                discrepancyOrders.add(orderDto);
//            }
//        }
//        return discrepancyOrders;
//    }
//
//    private BigDecimal getQuantityReceivedForOrderByCode(Integer orderId) {
//        // Retrieve all receipts for the order
//        List<DetailsBonReception> receipts = detailsBonReceptionRepo.findByCodeOrdreAchat(orderId);
//
////         Calculate the total quantity received
//        BigDecimal quantityReceived = BigDecimal.ZERO;
////        for (DetailsBonReception receipt : receipts) {
////            quantityReceived = quantityReceived.add(receipt.getQteReceptionner());
////        }
//
//        for (DetailsBonReception detail : receipts) {
//            BigDecimal qteDemander;
//            Optional<DetailsBonReception> details = receipts.stream().filter(x -> (x.getCodematiere().equals(detail.getCodematiere()))).findFirst();
//            if (details.isPresent()) {
////                qteDemander = details.get().getQteDemander();
////
////                if (qteDemander.compareTo(detail.getQteReceptionner()) > 0) {
////
////                    ordreAchatDTO = detailsOrdreAchatDTOs.iterator().next().getOrdreAchatDTO();
////                    ordreAchatDTO.setCodeEtatReception(5);
////
////                    break;
////                } else if (qteDemander.compareTo(detail.getQteReceptionner()) <= 0) {
////                    ordreAchatDTO = detailsOrdreAchatDTOs.iterator().next().getOrdreAchatDTO();
////                    ordreAchatDTO.setCodeEtatReception(7);
//////                   detailsOrdreAchatDTO.iterator().next().setQteLivrer(detail.getQteReceptionner()); 
////                }
//
//                quantityReceived = detail.getQteReceptionner();
//            }
//
//            com.MangmentRessources.MangRess.web.Util.Preconditions.checkBusinessLogique(detail.getQteReceptionner() != null, "error.QuantiteRecptionnerRequired");
//        }
//
//        return quantityReceived;
//    }
}
