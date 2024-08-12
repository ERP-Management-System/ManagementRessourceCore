/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.factory;

import com.MangmentRessources.MangRess.Achat.factory.DepotFactory;
import com.MangmentRessources.MangRess.Achat.factory.EtatReceptionFactory;
import com.MangmentRessources.MangRess.Stock.domaine.DemandeTransfertMatiere;
import com.MangmentRessources.MangRess.Stock.domaine.DetailsDemandeTransfertMatiere;
import com.MangmentRessources.MangRess.Stock.domaine.DetailsDemandeTransfertMatierePK;
import com.MangmentRessources.MangRess.Stock.dto.DemandeTransfertMatiereDTO;
import com.MangmentRessources.MangRess.Stock.dto.DetailsDemandeTransfertMatiereDTO;
import com.MangmentRessources.MangRess.web.Util.Preconditions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class DemandeTransfertMatiereFactory {

    public static DemandeTransfertMatiere createDemandeTransfertMatiereByCode(int code) {
        DemandeTransfertMatiere domaine = new DemandeTransfertMatiere();
        domaine.setCode(code);
        return domaine;
    }
//
    public static DemandeTransfertMatiereDTO demandeTransfertMatiereToDemandeTransfertMatiereDTO(DemandeTransfertMatiere domaine) {

        if (domaine != null) {
            DemandeTransfertMatiereDTO dTO = new DemandeTransfertMatiereDTO();
            dTO.setCode(domaine.getCode());
            dTO.setCodeSaisie(domaine.getCodeSaisie());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());

            dTO.setMntTotalHT(domaine.getMntTotalHT());
            dTO.setMntTotalTTC(domaine.getMntTotalTTC());
            dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());

 
            dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
            dTO.setCodeDepot(domaine.getCodeDepot());

            dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
            dTO.setCodeEtatReception(domaine.getCodeEtatReception());

            if (domaine.getDetailsDemandeTransfertMatieresCollections() != null) {
                Collection<DetailsDemandeTransfertMatiereDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
                domaine.getDetailsDemandeTransfertMatieresCollections().forEach(x -> {
                    DetailsDemandeTransfertMatiereDTO detailsDTO = new DetailsDemandeTransfertMatiereDTO();
                    detailsDTO = DetailsDemandeTransfertMatiereFactory.detailsDemandeTransfertMatiereTodetailsDemandeTransfertMatiereDTOCollection(x);
                    detailsDdeTransfertDTOSCollection.add(detailsDTO);
                });
                if (dTO.getDetailsDemandeTransfertMatiereDTOs() != null) {
                    dTO.getDetailsDemandeTransfertMatiereDTOs().clear();
                    dTO.getDetailsDemandeTransfertMatiereDTOs().addAll(detailsDdeTransfertDTOSCollection);
                } else {
                    dTO.setDetailsDemandeTransfertMatiereDTOs(detailsDdeTransfertDTOSCollection);
                }
            }

            return dTO;
        } else {
            return null;
        }
    }
//
    public static List<DemandeTransfertMatiereDTO> listDemandeTransfertMatiereToDemandeTransfertMatiereDTOs(List<DemandeTransfertMatiere> domaines) {
        List<DemandeTransfertMatiereDTO> list = new ArrayList<>();
        for (DemandeTransfertMatiere demandeTransfertMatiere : domaines) {
            list.add(demandeTransfertMatiereToDemandeTransfertMatiereDTO(demandeTransfertMatiere));
        }
        return list;
    }
//
    ///// new Factory with details
    public static DemandeTransfertMatiere demandeTransfertMatiereDTOToDemandeTransfertMatiereWithDetails(DemandeTransfertMatiere domaine, DemandeTransfertMatiereDTO dTO) {
        domaine.setCode(dTO.getCode());

        domaine.setCodeSaisie(dTO.getCodeSaisie());

        domaine.setDateCreate(new Date());
        domaine.setUserCreate(dTO.getUserCreate());
        domaine.setObservation(dTO.getObservation());

        domaine.setMntTotalHT(dTO.getMntTotalHT()); 
        domaine.setMntTotalTTC(dTO.getMntTotalTTC());
        domaine.setMntTotalTaxe(dTO.getMntTotalTaxe());  

 
        domaine.setCodeDepot(dTO.getCodeDepot());
        if (domaine.getCodeDepot() != null) {
            domaine.setDepot(DepotFactory.createDepotByCode(dTO.getCodeDepot()));
        }

 
 
        domaine.setCodeEtatReception(dTO.getCodeEtatReception());
        if (domaine.getCodeEtatReception() != null) {
            domaine.setEtatReception(EtatReceptionFactory.createEtatReceptionByCode(dTO.getCodeEtatReception()));

        }
        Preconditions.checkBusinessLogique(dTO.getDetailsDemandeTransfertMatiereDTOs() != null, "error.DetailsDemandeTransfertMatiereRequired");
        Collection<DetailsDemandeTransfertMatiere> detailsDemandeTransfertMatieres = new ArrayList<>();
        AtomicReference<Integer> order = new AtomicReference<>(1);
        dTO.getDetailsDemandeTransfertMatiereDTOs().forEach(x -> {

            DetailsDemandeTransfertMatiere detailsDemandeTransfertMatiere = new DetailsDemandeTransfertMatiere();
            DetailsDemandeTransfertMatierePK detailsmodelepanierPK = new DetailsDemandeTransfertMatierePK();

            Preconditions.checkBusinessLogique(x.getCodeMatieres() != null, "error.MatiereRequired");
            detailsmodelepanierPK.setCodeMatiere(x.getCodeMatieres());

            Preconditions.checkBusinessLogique(x.getCodeUnites() != null, "error.UniteRequired");
            detailsmodelepanierPK.setCodeUnite(x.getCodeUnites());
            Preconditions.checkBusinessLogique(x.getCodeColoriss() != null, "error.ColorisRequired");
            detailsmodelepanierPK.setCodeColoris(x.getCodeColoriss());
            detailsDemandeTransfertMatiere.setDetailsDemandeTransfertMatierePK(detailsmodelepanierPK);

            Preconditions.checkBusinessLogique(x.getQteDemander()!= null, "error.QuantiteRequired");
            detailsDemandeTransfertMatiere.setQteDemander(x.getQteDemander());  
            
            detailsDemandeTransfertMatiere.setQteTransfert(BigDecimal.ZERO);


            detailsDemandeTransfertMatiere.setDateCreate(domaine.getDateCreate());
            detailsDemandeTransfertMatiere.setUsercreate(domaine.getUserCreate());
            detailsDemandeTransfertMatiere.setPrixUnitaire(x.getPrixUnitaire()); 

      
            System.out.println("x.getCodeDepot()" + x.getCodeDepot());
       
            detailsDemandeTransfertMatiere.setCodeDepot(x.getCodeDepot());
            if (detailsDemandeTransfertMatiere.getCodeDepot() != null) {
                detailsDemandeTransfertMatiere.setDepot(DepotFactory.createDepotByCode(x.getCodeDepot()));
            }
            
            
            detailsDemandeTransfertMatiere.setMntTotalHT(x.getMntTotalHT());
            detailsDemandeTransfertMatiere.setMntTotalTTC(x.getMntTotalTTC());
            detailsDemandeTransfertMatiere.setMntTotalTaxe(x.getMntTotalTaxe());
            //order item
            detailsDemandeTransfertMatiere.setOrdreMatiere(order.get());
            order.getAndSet(order.get() + 1);
            detailsDemandeTransfertMatiere.setDemandeTransfertMatiere(domaine);
            detailsDemandeTransfertMatieres.add(detailsDemandeTransfertMatiere);
        });

        if (domaine.getDetailsDemandeTransfertMatieresCollections()!= null) {
            domaine.getDetailsDemandeTransfertMatieresCollections().clear();
            domaine.getDetailsDemandeTransfertMatieresCollections().addAll(detailsDemandeTransfertMatieres);
        } else {
            domaine.setDetailsDemandeTransfertMatieresCollections(detailsDemandeTransfertMatieres);
        }
 
        return domaine;
    }
//
//    public static DemandeTransfertMatiereDTO demandeTransfertMatiereWithDetailsTodemandeTransfertMatiereDTOWithDetails(DemandeTransfertMatiere domaine) {
////        System.out.println("soufien return");
//        if (domaine == null) {
//            return null;
//        }
//        DemandeTransfertMatiereDTO dTO = new DemandeTransfertMatiereDTO();
//        dTO.setCode(domaine.getCode());
//        dTO.setCodeSaisie(domaine.getCodeSaisie());
//
//        dTO.setCodeFactureFournisseur(domaine.getCodeFactureFournisseur());
//        dTO.setMntFactureFournisseur(domaine.getMntFactureFournisseur());
//        dTO.setDateFactureFournisseur(domaine.getDateFactureFournisseur());
//
//        dTO.setMntTotalHT(domaine.getMntTotalHT());
//        dTO.setMntTimbre(domaine.getMntTimbre());
//        dTO.setMntRemise(domaine.getMntRemise());
//        dTO.setMntTotalTTC(domaine.getMntTotalTTC());
//        dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
//        dTO.setMntNet(domaine.getMntNet());
//
//        dTO.setDateCreate(domaine.getDateCreate());
//        dTO.setUserCreate(domaine.getUserCreate());
//        dTO.setObservation(domaine.getObservation());
//
//        dTO.setOrdreAchatDTO(OrdreAchatFactory.DetailsordreAchatToDetailsOrdreAchatDTO(domaine.getOrdreAchat()));
//        dTO.setCodeOrdreAchat(domaine.getCodeOrdreAchat());
//
//        dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
//        dTO.setCodeFournisseur(domaine.getCodeFournisseur());
//
//        dTO.setDemandeAchatDTO(DemandeAchatFactory.DetailsdemandeAchatToDetailsDemandeAchatDTO(domaine.getDemandeAchat()));
//        dTO.setCodeDemandeAchat(domaine.getCodeDemandeAchat());
//
//        dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
//        dTO.setCodeDepot(domaine.getCodeDepot());
//
//        dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
//        dTO.setCodeEtatReception(domaine.getCodeEtatReception());
//
//        if (domaine.getDetailsDemandeTransfertMatieres() != null) {
//            Collection<DetailsDemandeTransfertMatiereDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
//            domaine.getDetailsDemandeTransfertMatieres().forEach(x -> {
//                DetailsDemandeTransfertMatiereDTO detailsDTO = new DetailsDemandeTransfertMatiereDTO();
//                detailsDTO = DetailsDemandeTransfertMatiereFactory.detailsDemandeTransfertMatiereTodetailsDemandeTransfertMatiereDTOCollection(x);
//                detailsDdeTransfertDTOSCollection.add(detailsDTO);
//            });
//            if (dTO.getDetailsDemandeTransfertMatiereDTOs() != null) {
//                dTO.getDetailsDemandeTransfertMatiereDTOs().clear();
//                dTO.getDetailsDemandeTransfertMatiereDTOs().addAll(detailsDdeTransfertDTOSCollection);
//            } else {
//                dTO.setDetailsDemandeTransfertMatiereDTOs(detailsDdeTransfertDTOSCollection);
//            }
//        }
//        return dTO;
//    }
//
//    public static DemandeTransfertMatiereDTO DetailsdemandeTransfertMatiereToDetailsDemandeTransfertMatiereDTO(DemandeTransfertMatiere domaine) {
//
//        if (domaine != null) {
//            DemandeTransfertMatiereDTO dTO = new DemandeTransfertMatiereDTO();
//            dTO.setCode(domaine.getCode());
//            dTO.setCodeSaisie(domaine.getCodeSaisie());
//
//            dTO.setCodeFactureFournisseur(domaine.getCodeFactureFournisseur());
//            dTO.setMntFactureFournisseur(domaine.getMntFactureFournisseur());
//            dTO.setDateFactureFournisseur(domaine.getDateFactureFournisseur());
//
//            dTO.setMntTotalHT(domaine.getMntTotalHT());
//            dTO.setMntTimbre(domaine.getMntTimbre());
//            dTO.setMntRemise(domaine.getMntRemise());
//            dTO.setMntTotalTTC(domaine.getMntTotalTTC());
//            dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
//            dTO.setMntNet(domaine.getMntNet());
//
//            dTO.setDateCreate(domaine.getDateCreate());
//            dTO.setUserCreate(domaine.getUserCreate());
//            dTO.setObservation(domaine.getObservation());
//
//            dTO.setOrdreAchatDTO(OrdreAchatFactory.DetailsordreAchatToDetailsOrdreAchatDTO(domaine.getOrdreAchat()));
//            dTO.setCodeOrdreAchat(domaine.getCodeOrdreAchat());
//
//            dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
//            dTO.setCodeFournisseur(domaine.getCodeFournisseur());
//
//            dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
//            dTO.setCodeDepot(domaine.getCodeDepot());
//
//            dTO.setDemandeAchatDTO(DemandeAchatFactory.DetailsdemandeAchatToDetailsDemandeAchatDTO(domaine.getDemandeAchat()));
//            dTO.setCodeDemandeAchat(domaine.getCodeDemandeAchat());
//
//            dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
//            dTO.setCodeEtatReception(domaine.getCodeEtatReception());
//
//            return dTO;
//        } else {
//            return null;
//        }
//    }
//
    public static DemandeTransfertMatiereDTO UpdatedemandeTransfertMatiereWithDetailsTodemandeTransfertMatiereDTOWithDetails(DemandeTransfertMatiere domaine) {
//        System.out.println("soufien return");
        if (domaine == null) {
            return null;
        }
        DemandeTransfertMatiereDTO dTO = new DemandeTransfertMatiereDTO();
        dTO.setCode(domaine.getCode());
        dTO.setCodeSaisie(domaine.getCodeSaisie());

        dTO.setDateCreate(domaine.getDateCreate());
        dTO.setUserCreate(domaine.getUserCreate());

        dTO.setMntTotalHT(domaine.getMntTotalHT()); 
        dTO.setMntTotalTTC(domaine.getMntTotalTTC());
        dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());  
        dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
        dTO.setCodeDepot(domaine.getCodeDepot());

        dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
        dTO.setCodeEtatReception(domaine.getCodeEtatReception());

        if (domaine.getDetailsDemandeTransfertMatieresCollections()!= null) {
            Collection<DetailsDemandeTransfertMatiereDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
            domaine.getDetailsDemandeTransfertMatieresCollections().forEach(x -> {
                DetailsDemandeTransfertMatiereDTO detailsDTO = new DetailsDemandeTransfertMatiereDTO();
                detailsDTO = DetailsDemandeTransfertMatiereFactory.detailsDemandeTransfertMatiereTodetailsDemandeTransfertMatiereDTOCollection(x);
                detailsDdeTransfertDTOSCollection.add(detailsDTO);
            });
            if (dTO.getDetailsDemandeTransfertMatiereDTOs() != null) {
                dTO.getDetailsDemandeTransfertMatiereDTOs().clear();
                dTO.getDetailsDemandeTransfertMatiereDTOs().addAll(detailsDdeTransfertDTOSCollection);
            } else {
                dTO.setDetailsDemandeTransfertMatiereDTOs(detailsDdeTransfertDTOSCollection);
            }
        }
        return dTO;
    }


}
