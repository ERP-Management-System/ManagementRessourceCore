/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.AppelOffre;
import com.MangmentRessources.MangRess.domaine.DetailsAppelOffre;
import com.MangmentRessources.MangRess.domaine.DetailsAppelOffrePK;
import com.MangmentRessources.MangRess.dto.AppelOffreDTO;
import com.MangmentRessources.MangRess.dto.CopieAODTO;
import com.MangmentRessources.MangRess.dto.DetailsAppelOffreDTO;
import com.MangmentRessources.MangRess.web.Util.Preconditions;
//import com.google.common.base.Preconditions;
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
public class AppelOffreFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static AppelOffre createAppelOffreByCode(int code) {
        AppelOffre domaine = new AppelOffre();
        domaine.setCode(code);
        return domaine;
    }

    public static AppelOffre appelOffreDTOToAppelOffre(AppelOffreDTO Dto, AppelOffre domaine) {
        if (Dto != null) {
            domaine.setCode(Dto.getCode());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {
                domaine.setDesignationAr(Dto.getDesignationAr());
                domaine.setDesignationLt(Dto.getDesignationLt());
            } else {
                domaine.setDesignationLt(Dto.getDesignationLt());
                domaine.setDesignationAr(Dto.getDesignationAr());
            }
            domaine.setCodeSaisie(Dto.getCodeSaisie());
            domaine.setActif(Dto.isActif());
            domaine.setVisible(Dto.isVisible());

            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());
            domaine.setObservation(Dto.getObservation());
            domaine.setCodeModeReglement(Dto.getCodeModeReglement());
            domaine.setCodeFournisseur(Dto.getCodeFournisseur());

            domaine.setCodeEtatReception(Dto.getCodeEtatReception());

            return domaine;
        } else {
            return null;
        }
    }

    public static AppelOffreDTO appelOffreToAppelOffreDTO(AppelOffre domaine) {

        if (domaine != null) {
            AppelOffreDTO dTO = new AppelOffreDTO();
            dTO.setCode(domaine.getCode());
            //            System.out.println("jihennn  " + LocaleContextHolder.getLocale().getLanguage());
            //            System.out.println("jihennn  " + new Locale(LANGUAGE_SEC).getLanguage());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {

                dTO.setDesignationAr(domaine.getDesignationAr());
                dTO.setDesignationLt(domaine.getDesignationLt());
            } else {
                dTO.setDesignationLt(domaine.getDesignationLt());
                dTO.setDesignationAr(domaine.getDesignationAr());
            }
            dTO.setCodeSaisie(domaine.getCodeSaisie());
            dTO.setActif(domaine.isActif());
            dTO.setVisible(domaine.isVisible());
            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());

            dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
            dTO.setCodeFournisseur(domaine.getCodeFournisseur());

            dTO.setModeReglementDTO(ModeReglementFactory.modeReglementToModeReglementDTO(domaine.getModeReglement()));
            dTO.setCodeModeReglement(domaine.getCodeModeReglement());

            dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
            dTO.setCodeEtatReception(domaine.getCodeEtatReception());

            if (domaine.getDetailsAppelOffresCollections() != null) {
                Collection<DetailsAppelOffreDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
                domaine.getDetailsAppelOffresCollections().forEach(x -> {
                    DetailsAppelOffreDTO detailsDTO = new DetailsAppelOffreDTO();
                    detailsDTO = DetailsAppelOffreFactory.detailsAppelOffreTodetailsAppelOffreDTOCollection(x);
                    detailsDdeTransfertDTOSCollection.add(detailsDTO);
                });
                if (dTO.getDetailsAppelOffreDTOs() != null) {
                    dTO.getDetailsAppelOffreDTOs().clear();
                    dTO.getDetailsAppelOffreDTOs().addAll(detailsDdeTransfertDTOSCollection);
                } else {
                    dTO.setDetailsAppelOffreDTOs(detailsDdeTransfertDTOSCollection);
                }
            }

            return dTO;
        } else {
            return null;
        }
    }
    
    
//    public static CopieAODTO appelOffreToAppelOffreDTOToCopy(AppelOffre domaine) {
//
//        if (domaine != null) {
//            CopieAODTO dTO = new CopieAODTO();
//            dTO.setCodeAppelOffre(domaine.getCode());
//          
//            dTO.setNbreCopie(domaine.getCodeSaisie());
//            dTO.setActif(domaine.isActif());
//            dTO.setVisible(domaine.isVisible());
//            dTO.setDateCreate(domaine.getDateCreate());
//            dTO.setUserCreate(domaine.getUserCreate());
//            
//
//            return dTO;
//        } else {
//            return null;
//        }
//    }

    public static List<AppelOffreDTO> listAppelOffreToAppelOffreDTOs(List<AppelOffre> domaines) {
        List<AppelOffreDTO> list = new ArrayList<>();
        for (AppelOffre appelOffre : domaines) {
            list.add(appelOffreToAppelOffreDTO(appelOffre));
        }
        return list;
    }

    ///// new Factory with details
    public static AppelOffre appelOffreDTOToAppelOffreWithDetails(AppelOffre domaine, AppelOffreDTO dTO) {
        domaine.setCode(dTO.getCode());

        domaine.setCodeSaisie(dTO.getCodeSaisie());
        domaine.setDesignationAr(dTO.getDesignationAr());
        domaine.setDesignationLt(dTO.getDesignationLt());

        domaine.setActif(dTO.isActif());
        domaine.setVisible(dTO.isVisible());

        domaine.setDateCreate(new Date());
        domaine.setUserCreate(dTO.getUserCreate());
        domaine.setObservation(dTO.getObservation());

        domaine.setCodeFournisseur(dTO.getCodeFournisseur());
        if (domaine.getCodeFournisseur() != null) {
            domaine.setFournisseur(FournisseurFactory.createFournisseurByCode(dTO.getCodeFournisseur()));

        }

        domaine.setCodeModeReglement(dTO.getCodeModeReglement());
        if (domaine.getCodeModeReglement() != null) {
            domaine.setModeReglement(ModeReglementFactory.createModeReglementByCode(dTO.getCodeModeReglement()));

        }

        domaine.setCodeEtatReception(dTO.getCodeEtatReception());
        if (domaine.getCodeEtatReception() != null) {
            domaine.setEtatReception(EtatReceptionFactory.createEtatReceptionByCode(dTO.getCodeEtatReception()));

        }

        Collection<DetailsAppelOffre> detailsModelePanierCollections = new ArrayList<>();

        dTO.getDetailsAppelOffreDTOs().forEach(x -> {

            DetailsAppelOffre detailsmodelepanier = new DetailsAppelOffre();
            DetailsAppelOffrePK detailsmodelepanierPK = new DetailsAppelOffrePK();
  
            Preconditions.checkBusinessLogique(x.getCodematiere() != null, "error.MatiereRequired");
            detailsmodelepanierPK.setCodeMatiere(x.getCodematiere().getCode());

            Preconditions.checkBusinessLogique(x.getCodeUnite().getCode() != null, "error.UniteRequired");
            detailsmodelepanierPK.setCodeUnite(x.getCodeUnite().getCode());
            Preconditions.checkBusinessLogique(x.getCodeColoris().getCode() != null, "error.ColorisRequired");
            detailsmodelepanierPK.setCodeColoris(x.getCodeColoris().getCode());
            detailsmodelepanier.setDetailsAppelOffrePK(detailsmodelepanierPK);
            Preconditions.checkBusinessLogique(x.getQteDemander() != null, "error.QuantiteRequired");
            detailsmodelepanier.setQteDemander(x.getQteDemander());
            detailsmodelepanier.setDateCreate(domaine.getDateCreate());
            detailsmodelepanier.setUsercreate(domaine.getUserCreate());
            detailsmodelepanier.setAppelOffre(domaine);
            detailsModelePanierCollections.add(detailsmodelepanier);
        });

        if (domaine.getDetailsAppelOffresCollections() != null) {
            domaine.getDetailsAppelOffresCollections().clear();
            domaine.getDetailsAppelOffresCollections().addAll(detailsModelePanierCollections);
        } else {
            domaine.setDetailsAppelOffresCollections(detailsModelePanierCollections);
        }
//        System.out.println("soufien send valider");
        return domaine;
    }

    public static AppelOffreDTO appelOffreWithDetailsToappelOffreDTOWithDetails(AppelOffre domaine) {
//        System.out.println("soufien return");
        if (domaine == null) {
            return null;
        }
        AppelOffreDTO dTO = new AppelOffreDTO();
        dTO.setCode(domaine.getCode());
        dTO.setCodeSaisie(domaine.getCodeSaisie());
        dTO.setActif(domaine.isActif());
        dTO.setVisible(domaine.isVisible());
        dTO.setDateCreate(domaine.getDateCreate());
        dTO.setUserCreate(domaine.getUserCreate());
        dTO.setObservation(domaine.getObservation());
        dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
        dTO.setCodeFournisseur(domaine.getCodeFournisseur());

        dTO.setModeReglementDTO(ModeReglementFactory.modeReglementToModeReglementDTO(domaine.getModeReglement()));
        dTO.setCodeModeReglement(domaine.getCodeModeReglement());

        dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
        dTO.setCodeEtatReception(domaine.getCodeEtatReception());

        if (domaine.getDetailsAppelOffresCollections() != null) {
            Collection<DetailsAppelOffreDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
            domaine.getDetailsAppelOffresCollections().forEach(x -> {
                DetailsAppelOffreDTO detailsDTO = new DetailsAppelOffreDTO();
                detailsDTO = DetailsAppelOffreFactory.detailsAppelOffreTodetailsAppelOffreDTOCollection(x);
                detailsDdeTransfertDTOSCollection.add(detailsDTO);
            });
            if (dTO.getDetailsAppelOffreDTOs() != null) {
                dTO.getDetailsAppelOffreDTOs().clear();
                dTO.getDetailsAppelOffreDTOs().addAll(detailsDdeTransfertDTOSCollection);
            } else {
                dTO.setDetailsAppelOffreDTOs(detailsDdeTransfertDTOSCollection);
            }
        }
        return dTO;
    }

    public static AppelOffreDTO DetailsappelOffreToDetailsAppelOffreDTO(AppelOffre domaine) {

        if (domaine != null) {
            AppelOffreDTO dTO = new AppelOffreDTO();
            dTO.setCode(domaine.getCode());
            //            System.out.println("jihennn  " + LocaleContextHolder.getLocale().getLanguage());
            //            System.out.println("jihennn  " + new Locale(LANGUAGE_SEC).getLanguage());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {

                dTO.setDesignationAr(domaine.getDesignationAr());
                dTO.setDesignationLt(domaine.getDesignationLt());
            } else {
                dTO.setDesignationLt(domaine.getDesignationLt());
                dTO.setDesignationAr(domaine.getDesignationAr());
            }
            dTO.setCodeSaisie(domaine.getCodeSaisie());
            dTO.setActif(domaine.isActif());
            dTO.setVisible(domaine.isVisible());
            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());

            dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
            dTO.setCodeFournisseur(domaine.getCodeFournisseur());

            dTO.setModeReglementDTO(ModeReglementFactory.modeReglementToModeReglementDTO(domaine.getModeReglement()));
            dTO.setCodeModeReglement(domaine.getCodeModeReglement());

            dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
            dTO.setCodeEtatReception(domaine.getCodeEtatReception());

            return dTO;
        } else {
            return null;
        }
    }

    public static AppelOffreDTO UpdateappelOffreWithDetailsToappelOffreDTOWithDetails(AppelOffre domaine) {
//        System.out.println("soufien return");
        if (domaine == null) {
            return null;
        }
        AppelOffreDTO dTO = new AppelOffreDTO();
        dTO.setCode(domaine.getCode());
        dTO.setCodeSaisie(domaine.getCodeSaisie());
        dTO.setActif(domaine.isActif());
        dTO.setVisible(domaine.isVisible());
        dTO.setDateCreate(domaine.getDateCreate());
        dTO.setUserCreate(domaine.getUserCreate());
        dTO.setObservation(domaine.getObservation());
        dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
        dTO.setCodeFournisseur(domaine.getCodeFournisseur());

        dTO.setModeReglementDTO(ModeReglementFactory.modeReglementToModeReglementDTO(domaine.getModeReglement()));
        dTO.setCodeModeReglement(domaine.getCodeModeReglement());

        dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
        dTO.setCodeEtatReception(domaine.getCodeEtatReception());

        if (domaine.getDetailsAppelOffresCollections() != null) {
            Collection<DetailsAppelOffreDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
            domaine.getDetailsAppelOffresCollections().forEach(x -> {
                DetailsAppelOffreDTO detailsDTO = new DetailsAppelOffreDTO();
                detailsDTO = DetailsAppelOffreFactory.detailsAppelOffreTodetailsAppelOffreDTOCollection(x);
                detailsDdeTransfertDTOSCollection.add(detailsDTO);
            });
            if (dTO.getDetailsAppelOffreDTOs() != null) {
                dTO.getDetailsAppelOffreDTOs().clear();
                dTO.getDetailsAppelOffreDTOs().addAll(detailsDdeTransfertDTOSCollection);
            } else {
                dTO.setDetailsAppelOffreDTOs(detailsDdeTransfertDTOSCollection);
            }
        }
        return dTO;
    }
}
