/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.DemandeAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DemandeAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsDemandeAchatPK;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.Achat.dto.DemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsDemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsDemandeAchatDTO;
import static com.MangmentRessources.MangRess.Achat.factory.DemandeAchatFactory.LANGUAGE_SEC;
import static com.MangmentRessources.MangRess.Achat.factory.DetailsDemandeAchatFactory.LANGUAGE_SEC;
import com.MangmentRessources.MangRess.web.Util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class DemandeAchatFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static DemandeAchat createDemandeAchatByCode(int code) {
        DemandeAchat domaine = new DemandeAchat();
        domaine.setCode(code);
        return domaine;
    }

    public static DemandeAchat demandeAchatDTOToDemandeAchat(DemandeAchatDTO Dto, DemandeAchat domaine) {
        if (Dto != null) {
            domaine.setCode(Dto.getCode());

            domaine.setCodeSaisie(Dto.getCodeSaisie());

            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());
            domaine.setObservation(Dto.getObservation());

            domaine.setCodeEtatDemande(Dto.getCodeEtatDemande());

            return domaine;
        } else {
            return null;
        }
    }

    public static DemandeAchatDTO demandeAchatToDemandeAchatDTO(DemandeAchat domaine) {

        if (domaine != null) {
            DemandeAchatDTO dTO = new DemandeAchatDTO();
            dTO.setCode(domaine.getCode());

            dTO.setCodeSaisie(domaine.getCodeSaisie());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());
            dTO.setDateLivraison(domaine.getDateLivraison());

//            dTO.setMntTotalHT(domaine.getMntTotalHT());
//            dTO.setMntTotalTTC(domaine.getMntTotalTTC());
//            dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
            dTO.setTypeCircuitAchatDTO(TypeCircuitAchatFactory.typeCircuitAchatToTypeCircuitAchatDTO(domaine.getTypeCircuitAchat()));
            dTO.setCodeTypeCircuitAchat(domaine.getCodeTypeCircuitAchat());

            dTO.setDepartementDTO(DepartementFactory.departementToDepartementDTO(domaine.getDepartement()));
            dTO.setCodeDepartement(domaine.getCodeDepartement());

            dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
            dTO.setCodeDepot(domaine.getCodeDepot());

            dTO.setEtatApprouverDTO(EtatApprouverFactory.etatApprouverToEtatApprouverDTO(domaine.getEtatApprouver()));
            dTO.setCodeEtatApprouver(domaine.getCodeEtatApprouver());

//             dTO.setAppelOffreDTO(AppelOffreFactory.DetailsappelOffreToDetailsAppelOffreDTO(domaine.getAppelOffre()));
//            dTO.setCodeAppelOffre(domaine.getCodeAppelOffre());
//            
//            
            dTO.setEtatDemandeAchatDTO(EtatDemandeAchatFactory.etatDemandeAchatToEtatDemandeAchatDTO(domaine.getEtatDemande()));
            dTO.setCodeEtatDemande(domaine.getCodeEtatDemande());

            if (domaine.getDetailsDemandeAchats() != null) {
                Collection<DetailsDemandeAchatDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
                domaine.getDetailsDemandeAchats().forEach(x -> {
                    DetailsDemandeAchatDTO detailsDTO = new DetailsDemandeAchatDTO();
                    detailsDTO = DetailsDemandeAchatFactory.detailsDemandeAchatTodetailsDemandeAchatDTOCollection(x);
                    detailsDdeTransfertDTOSCollection.add(detailsDTO);
                });
                if (dTO.getDetailsDemandeAchatDTOs() != null) {
                    dTO.getDetailsDemandeAchatDTOs().clear();
                    dTO.getDetailsDemandeAchatDTOs().addAll(detailsDdeTransfertDTOSCollection);
                } else {
                    dTO.setDetailsDemandeAchatDTOs(detailsDdeTransfertDTOSCollection);
                }
            }

            return dTO;
        } else {
            return null;
        }
    }

    public static List<DemandeAchatDTO> listDemandeAchatToDemandeAchatDTOs(List<DemandeAchat> domaines) {
        List<DemandeAchatDTO> list = new ArrayList<>();
        for (DemandeAchat demandeAchat : domaines) {
            list.add(demandeAchatToDemandeAchatDTO(demandeAchat));
        }
        return list;
    }

    ///// new Factory with details
    public static DemandeAchat demandeAchatDTOToDemandeAchatWithDetails(DemandeAchat domaine, DemandeAchatDTO dTO) {
        domaine.setCode(dTO.getCode());

        domaine.setCodeSaisie(dTO.getCodeSaisie());
        domaine.setDateCreate(new Date());
        domaine.setUserCreate(dTO.getUserCreate());
        domaine.setObservation(dTO.getObservation());
//        domaine.setMntTotalHT(dTO.getMntTotalHT());
//        domaine.setMntTotalTTC(dTO.getMntTotalTTC());
//        domaine.setMntTotalTaxe(dTO.getMntTotalTaxe());

        domaine.setCodeEtatDemande(2);
        if (domaine.getCodeEtatDemande() != null) {
            domaine.setEtatDemande(EtatDemandeAchatFactory.createEtatDemandeAchatByCode(2));
        }

        domaine.setCodeDepartement(dTO.getCodeDepartement());
        if (domaine.getCodeDepartement() != null) {
            domaine.setDepartement(DepartementFactory.createDepartementByCode(dTO.getCodeDepartement()));
        }

        domaine.setCodeEtatApprouver(dTO.getCodeEtatApprouver());
        if (domaine.getCodeEtatApprouver() != null) {
            domaine.setEtatApprouver(EtatApprouverFactory.createEtatApprouverByCode(dTO.getCodeEtatApprouver()));
        }

        domaine.setCodeDepot(dTO.getCodeDepot());
        if (domaine.getCodeDepot() != null) {
            domaine.setDepot(DepotFactory.createDepotByCode(dTO.getCodeDepot()));
        }

//        domaine.setCodeAppelOffre(dTO.getCodeAppelOffre());
//        if (domaine.getCodeAppelOffre() != null) {
//            domaine.setAppelOffre(AppelOffreFactory.createAppelOffreByCode(dTO.getCodeAppelOffre()));
//        }
        domaine.setCodeTypeCircuitAchat(dTO.getCodeTypeCircuitAchat());
        if (domaine.getCodeTypeCircuitAchat() != null) {
            domaine.setTypeCircuitAchat(TypeCircuitAchatFactory.createTypeCircuitAchatByCode(dTO.getCodeTypeCircuitAchat()));
        }
        Collection<DetailsDemandeAchat> detailsCollections = new ArrayList<>();
        dTO.getDetailsDemandeAchatDTOs().forEach(x -> {
            DetailsDemandeAchat detailsDemandeAchat = new DetailsDemandeAchat();
            DetailsDemandeAchatPK detailsmodelepanierPK = new DetailsDemandeAchatPK();
            Preconditions.checkBusinessLogique(x.getCodematiere() != null, "error.MatiereRequired");
            detailsmodelepanierPK.setCodeMatiere(x.getCodematiere().getCode());
            Preconditions.checkBusinessLogique(x.getCodeUnite().getCode() != null, "error.UniteRequired");
            detailsmodelepanierPK.setCodeUnite(x.getCodeUnite().getCode());
            Preconditions.checkBusinessLogique(x.getCodeColoris().getCode() != null, "error.ColorisRequired");
            detailsmodelepanierPK.setCodeColoris(x.getCodeColoris().getCode());
            detailsDemandeAchat.setDetailsDemandeAchatPK(detailsmodelepanierPK);
            Preconditions.checkBusinessLogique(x.getQteDemander() != null, "error.QuantiteRequired");
            detailsDemandeAchat.setQteDemander(x.getQteDemander());
            detailsDemandeAchat.setDateCreate(domaine.getDateCreate());
            detailsDemandeAchat.setUsercreate(domaine.getUserCreate());
            detailsDemandeAchat.setDemandeAchat(domaine);
            detailsCollections.add(detailsDemandeAchat);
        });

        if (domaine.getDetailsDemandeAchats() != null) {
            domaine.getDetailsDemandeAchats().clear();
            domaine.getDetailsDemandeAchats().addAll(detailsCollections);
        } else {
            domaine.setDetailsDemandeAchats(detailsCollections);
        }
//        System.out.println("soufien send valider");
        return domaine;
    }
//
//    public static DemandeAchatDTO demandeAchatWithDetailsTodemandeAchatDTOWithDetails(DemandeAchat domaine) {
////        System.out.println("soufien return");
//        if (domaine == null) {
//            return null;
//        }
//        DemandeAchatDTO dTO = new DemandeAchatDTO();
//        dTO.setCode(domaine.getCode());
//        dTO.setCodeSaisie(domaine.getCodeSaisie());
//        dTO.setActif(domaine.isActif());
//        dTO.setVisible(domaine.isVisible());
//        dTO.setDateCreate(domaine.getDateCreate());
//        dTO.setUserCreate(domaine.getUserCreate());
//        dTO.setObservation(domaine.getObservation());
//        dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
//        dTO.setCodeFournisseur(domaine.getCodeFournisseur());
//
//        dTO.setModeReglementDTO(ModeReglementFactory.modeReglementToModeReglementDTO(domaine.getModeReglement()));
//        dTO.setCodeModeReglement(domaine.getCodeModeReglement());
//
//        dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
//        dTO.setCodeEtatReception(domaine.getCodeEtatReception());
//
//        if (domaine.getDetailsDemandeAchatsCollections() != null) {
//            Collection<DetailsDemandeAchatDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
//            domaine.getDetailsDemandeAchatsCollections().forEach(x -> {
//                DetailsDemandeAchatDTO detailsDTO = new DetailsDemandeAchatDTO();
//                detailsDTO = DetailsDemandeAchatFactory.detailsDemandeAchatTodetailsDemandeAchatDTOCollection(x);
//                detailsDdeTransfertDTOSCollection.add(detailsDTO);
//            });
//            if (dTO.getDetailsDemandeAchatDTOs() != null) {
//                dTO.getDetailsDemandeAchatDTOs().clear();
//                dTO.getDetailsDemandeAchatDTOs().addAll(detailsDdeTransfertDTOSCollection);
//            } else {
//                dTO.setDetailsDemandeAchatDTOs(detailsDdeTransfertDTOSCollection);
//            }
//        }
//        return dTO;
//    }

    public static DemandeAchatDTO DetailsdemandeAchatToDetailsDemandeAchatDTO(DemandeAchat domaine) {

        if (domaine != null) {
            DemandeAchatDTO dTO = new DemandeAchatDTO();
            dTO.setCode(domaine.getCode());

            dTO.setCodeSaisie(domaine.getCodeSaisie());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());

//            dTO.setMntTotalHT(domaine.getMntTotalHT());
//            dTO.setMntTotalTTC(domaine.getMntTotalTTC());
//            dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
//
//            dTO.setAppelOffreDTO(AppelOffreFactory.DetailsappelOffreToDetailsAppelOffreDTO(domaine.getAppelOffre()));
//            dTO.setCodeAppelOffre(domaine.getCodeAppelOffre());
            dTO.setEtatDemandeAchatDTO(EtatDemandeAchatFactory.etatDemandeAchatToEtatDemandeAchatDTO(domaine.getEtatDemande()));
            dTO.setCodeEtatDemande(domaine.getCodeEtatDemande());

            dTO.setEtatApprouverDTO(EtatApprouverFactory.etatApprouverToEtatApprouverDTO(domaine.getEtatApprouver()));
            dTO.setCodeEtatApprouver(domaine.getCodeEtatApprouver());

            dTO.setDepartementDTO(DepartementFactory.departementToDepartementDTO(domaine.getDepartement()));
            dTO.setCodeDepartement(domaine.getCodeDepartement());

            dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
            dTO.setCodeDepot(domaine.getCodeDepot());

            return dTO;
        } else {
            return null;
        }
    }

    public static DemandeAchatDTO UpdatedemandeAchatWithDetailsTodemandeAchatDTOWithDetails(DemandeAchat domaine) {
//        System.out.println("soufien return");
        if (domaine == null) {
            return null;
        }
        DemandeAchatDTO dTO = new DemandeAchatDTO();
        dTO.setCode(domaine.getCode());
        dTO.setCodeSaisie(domaine.getCodeSaisie());

        dTO.setDateCreate(domaine.getDateCreate());
        dTO.setUserCreate(domaine.getUserCreate());
        dTO.setObservation(domaine.getObservation());
        dTO.setObservation(domaine.getObservation());

//        dTO.setMntTotalHT(domaine.getMntTotalHT());
//        dTO.setMntTotalTTC(domaine.getMntTotalTTC());
//        dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
//
//        dTO.setAppelOffreDTO(AppelOffreFactory.DetailsappelOffreToDetailsAppelOffreDTO(domaine.getAppelOffre()));
//        dTO.setCodeAppelOffre(domaine.getCodeAppelOffre());
        dTO.setEtatDemandeAchatDTO(EtatDemandeAchatFactory.etatDemandeAchatToEtatDemandeAchatDTO(domaine.getEtatDemande()));
        dTO.setCodeEtatDemande(domaine.getCodeEtatDemande());

        dTO.setEtatApprouverDTO(EtatApprouverFactory.etatApprouverToEtatApprouverDTO(domaine.getEtatApprouver()));
        dTO.setCodeEtatApprouver(domaine.getCodeEtatApprouver());

        dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
        dTO.setCodeDepot(domaine.getCodeDepot());

        dTO.setDepartementDTO(DepartementFactory.departementToDepartementDTO(domaine.getDepartement()));
        dTO.setCodeDepartement(domaine.getCodeDepartement());

        if (domaine.getDetailsDemandeAchats() != null) {
            Collection<DetailsDemandeAchatDTO> detailsDTOSCollection = new ArrayList<>();
            domaine.getDetailsDemandeAchats().forEach(x -> {
                DetailsDemandeAchatDTO detailsDTO = new DetailsDemandeAchatDTO();
                detailsDTO = DetailsDemandeAchatFactory.detailsDemandeAchatTodetailsDemandeAchatDTOCollection(x);
                detailsDTOSCollection.add(detailsDTO);
            });
            if (dTO.getDetailsDemandeAchatDTOs() != null) {
                dTO.getDetailsDemandeAchatDTOs().clear();
                dTO.getDetailsDemandeAchatDTOs().addAll(detailsDTOSCollection);
            } else {
                dTO.setDetailsDemandeAchatDTOs(detailsDTOSCollection);
            }
        }
        return dTO;
    }
}
