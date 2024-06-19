/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.Article;
import com.MangmentRessources.MangRess.Achat.dto.ArticleDTO;
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
public class ArticleFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static Article createArticleByCode(int code) {
        Article domaine = new Article();
        domaine.setCode(code);
        return domaine;
    }

    public static Article articleDTOToArticle(ArticleDTO Dto, Article domaine) {
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
//            if (adherantDTO.getLienParentale() != null) {
//                adherant.setCodeLienParental(adherantDTO.getLienParentale().getCode());
//            } else {
//                adherant.setCodeLienParental(null);
//            } 
            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());
            domaine.setCodeTypeArticle(Dto.getCodeTypeArticle());
            domaine.setCodeCategorieArticle(Dto.getCodeCategorieArticle());

            return domaine;
        } else {
            return null;
        }
    }

    public static ArticleDTO articleToArticleDTO(Article domaine) {

        if (domaine != null) {
            ArticleDTO dTO = new ArticleDTO();
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

            dTO.setCategorieArticleDTO(CategorieArticleFactory.matiereToCategorieArticleDTO(domaine.getCategorieArticle()));
            dTO.setCodeCategorieArticle(domaine.getCodeCategorieArticle());

            dTO.setTypeArticleDTO(TypeArticleFactory.typeArticleToTypeArticleDTO(domaine.getTypeArticle()));
            dTO.setCodeTypeArticle(domaine.getCodeTypeArticle());

            return dTO;
        } else {
            return null;
        }
    }

    public static List<ArticleDTO> listArticleToArticleDTOs(List<Article> domaines) {
        List<ArticleDTO> list = new ArrayList<>();
        for (Article article : domaines) {
            list.add(articleToArticleDTO(article));
        }
        return list;
    }
}
