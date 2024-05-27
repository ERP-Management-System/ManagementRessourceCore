/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.AppelOffre; 
import com.MangmentRessources.MangRess.dto.AppelOffreDTO; 
import com.MangmentRessources.MangRess.dto.DetailsAppelOffreDTO; 
import java.util.ArrayList;
import java.util.Collection;
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
//            if (adherantDTO.getLienParentale() != null) {
//                adherant.setCodeLienParental(adherantDTO.getLienParentale().getCode());
//            } else {
//                adherant.setCodeLienParental(null);
//            } 
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

//            dTO.setArticleDTO(ArticleFactory.articleToArticleDTO(domaine.getArticle()));
//            dTO.setCodeArticle(domaine.getCodeArticle());
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

    public static List<AppelOffreDTO> listAppelOffreToAppelOffreDTOs(List<AppelOffre> domaines) {
        List<AppelOffreDTO> list = new ArrayList<>();
        for (AppelOffre appelOffre : domaines) {
            list.add(appelOffreToAppelOffreDTO(appelOffre));
        }
        return list;
    }
    
    public static AppelOffreDTO AppelOffreToAppelOffreDTOCollection(AppelOffre domaine) {

        if (domaine != null) {
            AppelOffreDTO dTO = new AppelOffreDTO();
            dTO.setCode(domaine.getCode());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());   
            dTO.setObservation(domaine.getObservation());


            dTO.setCodeEtatReception(domaine.getEtatReception().getCode());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {
                dTO.setDesignationArEtatReception(domaine.getEtatReception().getDesignationAr());
                dTO.setDesignationLTEtatReception(domaine.getEtatReception().getDesignationLt());
            } else {
                dTO.setDesignationLTEtatReception(domaine.getEtatReception().getDesignationLt());
                dTO.setDesignationArEtatReception(domaine.getEtatReception().getDesignationAr());
            }

            if (domaine.getDetailsAppelOffres()!= null) {
                Collection<DetailsAppelOffreDTO> detailsAppelOffreDTOs = new ArrayList<>();
                domaine.getDetailsAppelOffres().forEach(x -> {
                    DetailsAppelOffreDTO dTos = new DetailsAppelOffreDTO();
                    dTos = DetailsAppelOffreFactory.detailsAppelOffreTodetailsAppelOffreDTOCollection(x);
                    detailsAppelOffreDTOs.add(dTos);
                });
                if (dTO.getDetailsAppelOffreDTOs()!= null) {
                    dTO.getDetailsAppelOffreDTOs().clear();
                    dTO.getDetailsAppelOffreDTOs().addAll(detailsAppelOffreDTOs);
                } else {
                    dTO.setDetailsAppelOffreDTOs(detailsAppelOffreDTOs);
                }
            }

            return dTO;
        } else {
            return null;
        }
    }
}
