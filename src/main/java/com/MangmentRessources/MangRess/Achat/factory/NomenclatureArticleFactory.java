/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsNomenclatureArticle;
import com.MangmentRessources.MangRess.Achat.domaine.NomenclatureArticle;
import com.MangmentRessources.MangRess.Achat.dto.DetailsNomenclatureArticleDTO;
import com.MangmentRessources.MangRess.Achat.dto.NomenclatureArticleDTO;
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
public class NomenclatureArticleFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static NomenclatureArticle createNomenclatureArticleByCode(int code) {
        NomenclatureArticle domaine = new NomenclatureArticle();
        domaine.setCode(code);
        return domaine;
    }

    public static NomenclatureArticle nomenclatureArticleDTOToNomenclatureArticleCollection(NomenclatureArticleDTO Dto, NomenclatureArticle domaine) {
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

            Collection<DetailsNomenclatureArticle> detailsNomenclatureArticles = new ArrayList<>();
            if (Dto.getDetailsNomenclatureArticleDTOs()!= null) {
                Dto.getDetailsNomenclatureArticleDTOs().forEach(x -> {
                    DetailsNomenclatureArticle detailsNomenclatureArticle = new DetailsNomenclatureArticle();
                    detailsNomenclatureArticle = DetailsNomenclatureArticleFactory.detailsNomenclatureDTOTodetailNomenclatureCollection(x);
                    detailsNomenclatureArticle.setNomenclatureArticle(domaine);
                    detailsNomenclatureArticles.add(detailsNomenclatureArticle);
                });
            }
            if (domaine.getDetailsNomenclatureArticles()!= null) {
                domaine.getDetailsNomenclatureArticles().clear();
                domaine.getDetailsNomenclatureArticles().addAll(detailsNomenclatureArticles);
            } else {
                domaine.setDetailsNomenclatureArticles(detailsNomenclatureArticles);
            }

            return domaine;
        } else {
            return null;
        }
    }

    public static NomenclatureArticleDTO nomenclatureArticleToNomenclatureArticleDTO(NomenclatureArticle domaine) {

        if (domaine != null) {
            NomenclatureArticleDTO dTO = new NomenclatureArticleDTO();
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
//            dTO.setQteBesoin(domaine.getQteBesoin());
//
//            dTO.setArticleDTO(ArticleFactory.articleToArticleDTO(domaine.getArticle()));
//            dTO.setCodeArticle(domaine.getCodeArticle());
//
//            dTO.setColroisDTO(ColorisFactory.colorisToColorisDTO(domaine.getColrois()));
//            dTO.setCodeColoris(domaine.getCodeColoris());
//
//            dTO.setMatiereDTO(MatiereFactory.matiereToMatiereDTO(domaine.getMatiere()));
//            dTO.setCodeMatiere(domaine.getCodeMatiere());

            return dTO;
        } else {
            return null;
        }
    }

    public static List<NomenclatureArticleDTO> listNomenclatureArticleToNomenclatureArticleDTOs(List<NomenclatureArticle> domaines) {
        List<NomenclatureArticleDTO> list = new ArrayList<>();
        for (NomenclatureArticle nomenclatureArticle : domaines) {
            list.add(nomenclatureArticleToNomenclatureArticleDTO(nomenclatureArticle));
        }
        return list;
    }
    
    public static NomenclatureArticleDTO nomenclatureArticleToNomenclatureArticleDTOCollection(NomenclatureArticle domaine) {

        if (domaine != null) {
            NomenclatureArticleDTO dTO = new NomenclatureArticleDTO();
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
 
            
        if (domaine.getDetailsNomenclatureArticles()!= null) {
            Collection<DetailsNomenclatureArticleDTO> detailsNomenclatureArticleDTOs = new ArrayList<>();
            domaine.getDetailsNomenclatureArticles().forEach(x -> {
                DetailsNomenclatureArticleDTO detailsNomenclatureArticleDTO = new DetailsNomenclatureArticleDTO();
                detailsNomenclatureArticleDTO = DetailsNomenclatureArticleFactory.detailsNomenclatureTodetailsNomenclatureDTOCollection(x);
                detailsNomenclatureArticleDTOs.add(detailsNomenclatureArticleDTO);
            });
            if (dTO.getDetailsNomenclatureArticleDTOs()!= null) {
                dTO.getDetailsNomenclatureArticleDTOs().clear();
                dTO.getDetailsNomenclatureArticleDTOs().addAll(detailsNomenclatureArticleDTOs);
            } else {
                dTO.setDetailsNomenclatureArticleDTOs(detailsNomenclatureArticleDTOs);
            }
        }
            
            return dTO;
        } else {
            return null;
        }
    }

}
