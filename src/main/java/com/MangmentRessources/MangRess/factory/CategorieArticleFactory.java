/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.CategorieArticle;
import com.MangmentRessources.MangRess.dto.CategorieArticleDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 *
 * @author Administrator
 */
public class CategorieArticleFactory {
    
    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static CategorieArticle createCategorieArticleByCode(int code) {
        CategorieArticle domaine = new CategorieArticle();
        domaine.setCode(code);
        return domaine;
    }

    public static CategorieArticle matiereDTOToCategorieArticle(CategorieArticleDTO Dto, CategorieArticle domaine) {
        if (Dto != null) {
            domaine.setCode(Dto.getCode());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {
                domaine.setDesignationAr(Dto.getDesignationAr());
                domaine.setDesignationLt(Dto.getDesignationLt());
            } else {
                domaine.setDesignationLt(Dto.getDesignationLt());
                domaine.setDesignationAr(Dto.getDesignationAr());
            }
//            domaine.setCodeSaisie(Dto.getCodeSaisie());
            domaine.setActif(Dto.isActif());
            domaine.setVisible(Dto.isVisible());
            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());      
            domaine.setCodeFamilleArticle(Dto.getCodeFamilleArticle());

            return domaine;
        } else {
            return null;
        }
    }

    public static CategorieArticleDTO matiereToCategorieArticleDTO(CategorieArticle domaine) {

        if (domaine != null) {
            CategorieArticleDTO dTO = new CategorieArticleDTO();
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

            dTO.setFamilleArticleDTO(FamilleArticleFactory.familleArticleToFamilleArticleDTO(domaine.getFamilleArticle()));
            dTO.setCodeFamilleArticle(domaine.getCodeFamilleArticle());

            return dTO;
        } else {
            return null;
        }
    }

    public static List<CategorieArticleDTO> listCategorieArticleToCategorieArticleDTOs(List<CategorieArticle> domaines) {
        List<CategorieArticleDTO> list = new ArrayList<>();
        for (CategorieArticle matiere : domaines) {
            list.add(matiereToCategorieArticleDTO(matiere));
        }
        return list;
    }
}
