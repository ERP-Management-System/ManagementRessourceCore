/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.AppelOffre;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsAppelOffre;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsAppelOffrePK;
import com.MangmentRessources.MangRess.Achat.dto.AppelOffreDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsAppelOffreDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.factory.ModeReglementFactory;
import com.MangmentRessources.MangRess.web.Util.Preconditions;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
//import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
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

//    public static AppelOffre appelOffreDTOToAppelOffre(AppelOffreDTO Dto, AppelOffre domaine) {
//        if (Dto != null) {
//            domaine.setCode(Dto.getCode());
//            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {
//                domaine.setDesignationAr(Dto.getDesignationAr());
//                domaine.setDesignationLt(Dto.getDesignationLt());
//            } else {
//                domaine.setDesignationLt(Dto.getDesignationLt());
//                domaine.setDesignationAr(Dto.getDesignationAr());
//            }
//            domaine.setCodeSaisie(Dto.getCodeSaisie());
//            domaine.setActif(Dto.isActif());
//            domaine.setVisible(Dto.isVisible());
//
//            domaine.setCodeEtatApprouverOrdreAchat(Dto.getCodeEtatApprouverOrdreAchat());
//
//            domaine.setDateCreate(Dto.getDateCreate());
//
//            domaine.setDateLivraison(Dto.getDateLivraison());
//
//            domaine.setUserCreate(Dto.getUserCreate());
//            domaine.setObservation(Dto.getObservation());
//            domaine.setCodeModeReglement(Dto.getCodeModeReglement());
//            domaine.setCodeFournisseur(Dto.getCodeFournisseur());
//
//            domaine.setCodeEtatReception(Dto.getCodeEtatReception());
//
//            return domaine;
//        } else {
//            return null;
//        }
//    }
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

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());
            dTO.setDateLivraison(domaine.getDateLivraison());
            dTO.setAdressLivraison(domaine.getAdressLivraison());

            dTO.setEtatApprouverOrdreAchatDTO(EtatApprouverFactory.etatApprouverToEtatApprouverDTO(domaine.getEtatApprouverOrdreAchat()));
            dTO.setCodeEtatApprouverOrdreAchat(domaine.getCodeEtatApprouverOrdreAchat());

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

        domaine.setDateLivraison(dTO.getDateLivraison());
        domaine.setAdressLivraison(dTO.getAdressLivraison());

        domaine.setDateCreate(new Date());
        domaine.setUserCreate(dTO.getUserCreate());
        domaine.setObservation(dTO.getObservation());

        domaine.setCodeEtatApprouverOrdreAchat(dTO.getCodeEtatApprouverOrdreAchat());
        if (domaine.getCodeEtatApprouverOrdreAchat() != null) {
            domaine.setEtatApprouverOrdreAchat(EtatApprouverFactory.createEtatApprouverByCode(dTO.getCodeEtatApprouverOrdreAchat()));
        }

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
        AtomicReference<Integer> order = new AtomicReference<>(1);
        dTO.getDetailsAppelOffreDTOs().forEach(x -> {

            DetailsAppelOffre detailsAppelOffre = new DetailsAppelOffre();
            DetailsAppelOffrePK detailsmodelepanierPK = new DetailsAppelOffrePK();

            Preconditions.checkBusinessLogique(x.getCodematiere() != null, "error.MatiereRequired");
            detailsmodelepanierPK.setCodeMatiere(x.getCodematiere().getCode());

            Preconditions.checkBusinessLogique(x.getCodeUnite().getCode() != null, "error.UniteRequired");
            detailsmodelepanierPK.setCodeUnite(x.getCodeUnite().getCode());
            Preconditions.checkBusinessLogique(x.getCodeColoris().getCode() != null, "error.ColorisRequired");
            detailsmodelepanierPK.setCodeColoris(x.getCodeColoris().getCode());

            detailsAppelOffre.setDetailsAppelOffrePK(detailsmodelepanierPK);
            Preconditions.checkBusinessLogique(x.getQteDemander() != null, "error.QuantiteRequired");
            detailsAppelOffre.setQteDemander(x.getQteDemander());
            detailsAppelOffre.setDateCreate(domaine.getDateCreate());
            detailsAppelOffre.setUsercreate(domaine.getUserCreate());

            //order item
            detailsAppelOffre.setOrdreMatiere(order.get());
            order.getAndSet(order.get() + 1); 
            detailsAppelOffre.setAppelOffre(domaine);
            detailsModelePanierCollections.add(detailsAppelOffre);
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

        dTO.setDateLivraison(domaine.getDateLivraison());
        dTO.setAdressLivraison(domaine.getAdressLivraison());

        dTO.setDateCreate(domaine.getDateCreate());
        dTO.setUserCreate(domaine.getUserCreate());
        dTO.setObservation(domaine.getObservation());
        dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
        dTO.setCodeFournisseur(domaine.getCodeFournisseur());

        dTO.setModeReglementDTO(ModeReglementFactory.modeReglementToModeReglementDTO(domaine.getModeReglement()));
        dTO.setCodeModeReglement(domaine.getCodeModeReglement());

        dTO.setEtatApprouverOrdreAchatDTO(EtatApprouverFactory.etatApprouverToEtatApprouverDTO(domaine.getEtatApprouverOrdreAchat()));
        dTO.setCodeEtatApprouverOrdreAchat(domaine.getCodeEtatApprouverOrdreAchat());

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
            dTO.setAdressLivraison(domaine.getAdressLivraison());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());

            dTO.setEtatApprouverOrdreAchatDTO(EtatApprouverFactory.etatApprouverToEtatApprouverDTO(domaine.getEtatApprouverOrdreAchat()));
            dTO.setCodeEtatApprouverOrdreAchat(domaine.getCodeEtatApprouverOrdreAchat());

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

        dTO.setDateCreate(domaine.getDateCreate());
        dTO.setUserCreate(domaine.getUserCreate());
        dTO.setAdressLivraison(domaine.getAdressLivraison());

        dTO.setObservation(domaine.getObservation());
        dTO.setFournisseurDTO(FournisseurFactory.fournisseurToFournisseurDTO(domaine.getFournisseur()));
        dTO.setCodeFournisseur(domaine.getCodeFournisseur());

        dTO.setModeReglementDTO(ModeReglementFactory.modeReglementToModeReglementDTO(domaine.getModeReglement()));
        dTO.setCodeModeReglement(domaine.getCodeModeReglement());

        dTO.setEtatApprouverOrdreAchatDTO(EtatApprouverFactory.etatApprouverToEtatApprouverDTO(domaine.getEtatApprouverOrdreAchat()));
        dTO.setCodeEtatApprouverOrdreAchat(domaine.getCodeEtatApprouverOrdreAchat());

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
