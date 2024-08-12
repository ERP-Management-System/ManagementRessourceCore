/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.BonReception;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsBonReception;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsBonReceptionPK;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchat;
import com.MangmentRessources.MangRess.Achat.dto.BonReceptionDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsBonReceptionDTO;
import com.MangmentRessources.MangRess.web.Util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class BonReceptionFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static BonReception createBonReceptionByCode(int code) {
        BonReception domaine = new BonReception();
        domaine.setCode(code);
        return domaine;
    }

    public static BonReceptionDTO bonReceptionToBonReceptionDTO(BonReception domaine) {

        if (domaine != null) {
            BonReceptionDTO dTO = new BonReceptionDTO();
            dTO.setCode(domaine.getCode());
            dTO.setCodeSaisie(domaine.getCodeSaisie());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());
            dTO.setCodeFactureFournisseur(domaine.getCodeFactureFournisseur());
            dTO.setMntFactureFournisseur(domaine.getMntFactureFournisseur());
            dTO.setDateFactureFournisseur(domaine.getDateFactureFournisseur());

            dTO.setMntTotalHT(domaine.getMntTotalHT());
            dTO.setMntTimbre(domaine.getMntTimbre());
            dTO.setMntRemise(domaine.getMntRemise());
            dTO.setMntTotalTTC(domaine.getMntTotalTTC());
            dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
            dTO.setMntNet(domaine.getMntNet());

            dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
            dTO.setCodeFournisseur(domaine.getCodeFournisseur());

            dTO.setDemandeAchatDTO(DemandeAchatFactory.DetailsdemandeAchatToDetailsDemandeAchatDTO(domaine.getDemandeAchat()));
            dTO.setCodeDemandeAchat(domaine.getCodeDemandeAchat());

            dTO.setAppelOffreDTO(AppelOffreFactory.DetailsappelOffreToDetailsAppelOffreDTO(domaine.getAppelOffre()));
            dTO.setCodeAppelOffre(domaine.getCodeAppelOffre());

            dTO.setOrdreAchatDTO(OrdreAchatFactory.DetailsordreAchatToDetailsOrdreAchatDTO(domaine.getOrdreAchat()));
            dTO.setCodeOrdreAchat(domaine.getCodeOrdreAchat());

            dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
            dTO.setCodeDepot(domaine.getCodeDepot());

            dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
            dTO.setCodeEtatReception(domaine.getCodeEtatReception());

            if (domaine.getDetailsBonReceptions() != null) {
                Collection<DetailsBonReceptionDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
                domaine.getDetailsBonReceptions().forEach(x -> {
                    DetailsBonReceptionDTO detailsDTO = new DetailsBonReceptionDTO();
                    detailsDTO = DetailsBonReceptionFactory.detailsBonReceptionTodetailsBonReceptionDTOCollection(x);
                    detailsDdeTransfertDTOSCollection.add(detailsDTO);
                });
                if (dTO.getDetailsBonReceptionDTOs() != null) {
                    dTO.getDetailsBonReceptionDTOs().clear();
                    dTO.getDetailsBonReceptionDTOs().addAll(detailsDdeTransfertDTOSCollection);
                } else {
                    dTO.setDetailsBonReceptionDTOs(detailsDdeTransfertDTOSCollection);
                }
            }

            return dTO;
        } else {
            return null;
        }
    }

    public static List<BonReceptionDTO> listBonReceptionToBonReceptionDTOs(List<BonReception> domaines) {
        List<BonReceptionDTO> list = new ArrayList<>();
        for (BonReception bonReception : domaines) {
            list.add(bonReceptionToBonReceptionDTO(bonReception));
        }
        return list;
    }

    ///// new Factory with details
    public static BonReception bonReceptionDTOToBonReceptionWithDetails(BonReception domaine, BonReceptionDTO dTO) {
        domaine.setCode(dTO.getCode());

        domaine.setCodeSaisie(dTO.getCodeSaisie());

        domaine.setDateCreate(new Date());
        domaine.setUserCreate(dTO.getUserCreate());
        domaine.setObservation(dTO.getObservation());

        domaine.setMntTotalHT(dTO.getMntTotalHT());
        domaine.setMntTimbre(dTO.getMntTimbre());
        domaine.setMntRemise(dTO.getMntRemise());
        domaine.setMntTotalTTC(dTO.getMntTotalTTC());
        domaine.setMntTotalTaxe(dTO.getMntTotalTaxe());

        domaine.setMntNet(dTO.getMntNet());

        domaine.setCodeFactureFournisseur(dTO.getCodeFactureFournisseur());
        domaine.setMntFactureFournisseur(dTO.getMntFactureFournisseur());
        domaine.setDateFactureFournisseur(dTO.getDateFactureFournisseur());

        domaine.setCodeDemandeAchat(dTO.getCodeDemandeAchat());
        if (domaine.getCodeDemandeAchat() != null) {
            domaine.setDemandeAchat(DemandeAchatFactory.createDemandeAchatByCode(dTO.getCodeDemandeAchat()));
        }

        domaine.setCodeAppelOffre(dTO.getCodeAppelOffre());
        if (domaine.getCodeAppelOffre() != null) {
            domaine.setAppelOffre(AppelOffreFactory.createAppelOffreByCode(dTO.getCodeAppelOffre()));
        }

        domaine.setCodeDepot(dTO.getCodeDepot());
        if (domaine.getCodeDepot() != null) {
            domaine.setDepot(DepotFactory.createDepotByCode(dTO.getCodeDepot()));
        }

        domaine.setCodeFournisseur(dTO.getCodeFournisseur());
        if (domaine.getCodeFournisseur() != null) {
            domaine.setFournisseur(FournisseurFactory.createFournisseurByCode(dTO.getCodeFournisseur()));
        }

        domaine.setCodeOrdreAchat(dTO.getCodeOrdreAchat());
        if (domaine.getCodeOrdreAchat() != null) {
            domaine.setOrdreAchat(OrdreAchatFactory.createOrdreAchatByCode(dTO.getCodeOrdreAchat()));
        }

        domaine.setCodeEtatReception(dTO.getCodeEtatReception());
        if (domaine.getCodeEtatReception() != null) {
            domaine.setEtatReception(EtatReceptionFactory.createEtatReceptionByCode(dTO.getCodeEtatReception()));

        }
        Preconditions.checkBusinessLogique(dTO.getDetailsBonReceptionDTOs() != null, "error.DetailsBonReceptionRequired");
        Collection<DetailsBonReception> detailsBonReceptions = new ArrayList<>();
        AtomicReference<Integer> order = new AtomicReference<>(1);
        dTO.getDetailsBonReceptionDTOs().forEach(x -> {

            DetailsBonReception detailsBonReception = new DetailsBonReception();
            DetailsBonReceptionPK detailsmodelepanierPK = new DetailsBonReceptionPK();
    
            Preconditions.checkBusinessLogique(x.getCodeMatieres() != null, "error.MatiereRequired");
            detailsmodelepanierPK.setCodeMatiere(x.getCodeMatieres());

            Preconditions.checkBusinessLogique(x.getCodeUnites() != null, "error.UniteRequired");
            detailsmodelepanierPK.setCodeUnite(x.getCodeUnites());
            Preconditions.checkBusinessLogique(x.getCodeColoriss() != null, "error.ColorisRequired");
            detailsmodelepanierPK.setCodeColoris(x.getCodeColoriss());
            detailsBonReception.setDetailsBonReceptionPK(detailsmodelepanierPK);

            Preconditions.checkBusinessLogique(x.getQteReceptionner() != null, "error.QuantiteRequired");
            detailsBonReception.setQteReceptionner(x.getQteReceptionner());

            detailsBonReception.setDateCreate(domaine.getDateCreate());
            detailsBonReception.setUsercreate(domaine.getUserCreate());
            detailsBonReception.setPrixUnitaireAchat(x.getPrixAchat());
            detailsBonReception.setValeurTaxe(x.getValeurTaxe());

            detailsBonReception.setCodeOrdreAchat(dTO.getCodeOrdreAchat());
            if (detailsBonReception.getCodeOrdreAchat() != null) {
                detailsBonReception.setOrdreAchat(OrdreAchatFactory.createOrdreAchatByCode(dTO.getCodeOrdreAchat()));
            }

            detailsBonReception.setCodeDepot(x.getCodeDepot());
            if (detailsBonReception.getCodeDepot() != null) {
                detailsBonReception.setDepot(DepotFactory.createDepotByCode(x.getCodeDepot()));
            }
            detailsBonReception.setCodeFournisseur(x.getCodeFournisseur());
            if (detailsBonReception.getCodeFournisseur() != null) {
                detailsBonReception.setFournisseur(FournisseurFactory.createFournisseurByCode(x.getCodeFournisseur()));
            }

            detailsBonReception.setMntTotalHT(x.getMntTotalHT());
            detailsBonReception.setMntTotalTTC(x.getMntTotalTTC());
            detailsBonReception.setMntTotalTaxe(x.getMntTotalTaxe());
            //order item
            detailsBonReception.setOrdreMatiere(order.get());
            order.getAndSet(order.get() + 1);
            detailsBonReception.setBonReception(domaine);
            detailsBonReceptions.add(detailsBonReception);
        });

        if (domaine.getDetailsBonReceptions() != null) {
            domaine.getDetailsBonReceptions().clear();
            domaine.getDetailsBonReceptions().addAll(detailsBonReceptions);
        } else {
            domaine.setDetailsBonReceptions(detailsBonReceptions);
        }
        
  
        
        
        //// details order achat
        
        
        
        
//        System.out.println("soufien send valider");
        return domaine;
    }

    public static BonReceptionDTO bonReceptionWithDetailsTobonReceptionDTOWithDetails(BonReception domaine) {
//        System.out.println("soufien return");
        if (domaine == null) {
            return null;
        }
        BonReceptionDTO dTO = new BonReceptionDTO();
        dTO.setCode(domaine.getCode());
        dTO.setCodeSaisie(domaine.getCodeSaisie());

        dTO.setCodeFactureFournisseur(domaine.getCodeFactureFournisseur());
        dTO.setMntFactureFournisseur(domaine.getMntFactureFournisseur());
        dTO.setDateFactureFournisseur(domaine.getDateFactureFournisseur());

        dTO.setMntTotalHT(domaine.getMntTotalHT());
        dTO.setMntTimbre(domaine.getMntTimbre());
        dTO.setMntRemise(domaine.getMntRemise());
        dTO.setMntTotalTTC(domaine.getMntTotalTTC());
        dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
        dTO.setMntNet(domaine.getMntNet());

        dTO.setDateCreate(domaine.getDateCreate());
        dTO.setUserCreate(domaine.getUserCreate());
        dTO.setObservation(domaine.getObservation());

        dTO.setOrdreAchatDTO(OrdreAchatFactory.DetailsordreAchatToDetailsOrdreAchatDTO(domaine.getOrdreAchat()));
        dTO.setCodeOrdreAchat(domaine.getCodeOrdreAchat());

        dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
        dTO.setCodeFournisseur(domaine.getCodeFournisseur());

        dTO.setDemandeAchatDTO(DemandeAchatFactory.DetailsdemandeAchatToDetailsDemandeAchatDTO(domaine.getDemandeAchat()));
        dTO.setCodeDemandeAchat(domaine.getCodeDemandeAchat());

        dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
        dTO.setCodeDepot(domaine.getCodeDepot());

        dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
        dTO.setCodeEtatReception(domaine.getCodeEtatReception());

        if (domaine.getDetailsBonReceptions() != null) {
            Collection<DetailsBonReceptionDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
            domaine.getDetailsBonReceptions().forEach(x -> {
                DetailsBonReceptionDTO detailsDTO = new DetailsBonReceptionDTO();
                detailsDTO = DetailsBonReceptionFactory.detailsBonReceptionTodetailsBonReceptionDTOCollection(x);
                detailsDdeTransfertDTOSCollection.add(detailsDTO);
            });
            if (dTO.getDetailsBonReceptionDTOs() != null) {
                dTO.getDetailsBonReceptionDTOs().clear();
                dTO.getDetailsBonReceptionDTOs().addAll(detailsDdeTransfertDTOSCollection);
            } else {
                dTO.setDetailsBonReceptionDTOs(detailsDdeTransfertDTOSCollection);
            }
        }
        return dTO;
    }

    public static BonReceptionDTO DetailsbonReceptionToDetailsBonReceptionDTO(BonReception domaine) {

        if (domaine != null) {
            BonReceptionDTO dTO = new BonReceptionDTO();
            dTO.setCode(domaine.getCode());
            dTO.setCodeSaisie(domaine.getCodeSaisie());

            dTO.setCodeFactureFournisseur(domaine.getCodeFactureFournisseur());
            dTO.setMntFactureFournisseur(domaine.getMntFactureFournisseur());
            dTO.setDateFactureFournisseur(domaine.getDateFactureFournisseur());

            dTO.setMntTotalHT(domaine.getMntTotalHT());
            dTO.setMntTimbre(domaine.getMntTimbre());
            dTO.setMntRemise(domaine.getMntRemise());
            dTO.setMntTotalTTC(domaine.getMntTotalTTC());
            dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
            dTO.setMntNet(domaine.getMntNet());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());

            dTO.setOrdreAchatDTO(OrdreAchatFactory.DetailsordreAchatToDetailsOrdreAchatDTO(domaine.getOrdreAchat()));
            dTO.setCodeOrdreAchat(domaine.getCodeOrdreAchat());

            dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
            dTO.setCodeFournisseur(domaine.getCodeFournisseur());

            dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
            dTO.setCodeDepot(domaine.getCodeDepot());

            dTO.setDemandeAchatDTO(DemandeAchatFactory.DetailsdemandeAchatToDetailsDemandeAchatDTO(domaine.getDemandeAchat()));
            dTO.setCodeDemandeAchat(domaine.getCodeDemandeAchat());

            dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
            dTO.setCodeEtatReception(domaine.getCodeEtatReception());

            return dTO;
        } else {
            return null;
        }
    }

    public static BonReceptionDTO UpdatebonReceptionWithDetailsTobonReceptionDTOWithDetails(BonReception domaine) {
//        System.out.println("soufien return");
        if (domaine == null) {
            return null;
        }
        BonReceptionDTO dTO = new BonReceptionDTO();
        dTO.setCode(domaine.getCode());
        dTO.setCodeSaisie(domaine.getCodeSaisie());

        dTO.setDateCreate(domaine.getDateCreate());
        dTO.setUserCreate(domaine.getUserCreate());

        dTO.setMntTotalHT(domaine.getMntTotalHT());
        dTO.setMntTimbre(domaine.getMntTimbre());
        dTO.setMntRemise(domaine.getMntRemise());
        dTO.setMntTotalTTC(domaine.getMntTotalTTC());
        dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
        dTO.setMntNet(domaine.getMntNet());

        dTO.setCodeFactureFournisseur(domaine.getCodeFactureFournisseur());
        dTO.setMntFactureFournisseur(domaine.getMntFactureFournisseur());
        dTO.setDateFactureFournisseur(domaine.getDateFactureFournisseur());

        dTO.setOrdreAchatDTO(OrdreAchatFactory.DetailsordreAchatToDetailsOrdreAchatDTO(domaine.getOrdreAchat()));
        dTO.setCodeOrdreAchat(domaine.getCodeOrdreAchat());

        dTO.setObservation(domaine.getObservation());
        dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
        dTO.setCodeFournisseur(domaine.getCodeFournisseur());

        dTO.setDemandeAchatDTO(DemandeAchatFactory.DetailsdemandeAchatToDetailsDemandeAchatDTO(domaine.getDemandeAchat()));
        dTO.setCodeDemandeAchat(domaine.getCodeDemandeAchat());

        dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
        dTO.setCodeDepot(domaine.getCodeDepot());

        dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
        dTO.setCodeEtatReception(domaine.getCodeEtatReception());

        if (domaine.getDetailsBonReceptions() != null) {
            Collection<DetailsBonReceptionDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
            domaine.getDetailsBonReceptions().forEach(x -> {
                DetailsBonReceptionDTO detailsDTO = new DetailsBonReceptionDTO();
                detailsDTO = DetailsBonReceptionFactory.detailsBonReceptionTodetailsBonReceptionDTOCollection(x);
                detailsDdeTransfertDTOSCollection.add(detailsDTO);
            });
            if (dTO.getDetailsBonReceptionDTOs() != null) {
                dTO.getDetailsBonReceptionDTOs().clear();
                dTO.getDetailsBonReceptionDTOs().addAll(detailsDdeTransfertDTOSCollection);
            } else {
                dTO.setDetailsBonReceptionDTOs(detailsDdeTransfertDTOSCollection);
            }
        }
        return dTO;
    }

}
