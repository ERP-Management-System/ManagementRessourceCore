/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.StatuMatiere;
import com.MangmentRessources.MangRess.Achat.dto.StatuMatiereDTO; 
import java.util.ArrayList;
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
public class StatuMatiereFactory {
 
    
    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static StatuMatiere createStatuArticleByCode(int code) {
        StatuMatiere domaine = new StatuMatiere();
        domaine.setCode(code);
        return domaine;
    }

    public static StatuMatiere statuArticleDTOToStatuArticle(StatuMatiereDTO Dto, StatuMatiere domaine) {
        if (Dto != null) {
            domaine.setCode(Dto.getCode());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {
                domaine.setDesignationAr(Dto.getDesignationAr());
                domaine.setDesignationLt(Dto.getDesignationLt());
            } else {
                domaine.setDesignationLt(Dto.getDesignationLt());
                domaine.setDesignationAr(Dto.getDesignationAr());
            }
 
            return domaine;
        } else {
            return null;
        }
    }

    public static StatuMatiereDTO statuArticleToStatuArticleDTO(StatuMatiere domaine) {

        if (domaine != null) {
            StatuMatiereDTO dTO = new StatuMatiereDTO();
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
 

            return dTO;
        } else {
            return null;
        }
    }

    public static List<StatuMatiereDTO> listStatuArticleToStatuArticleDTOs(List<StatuMatiere> domaines) {
        List<StatuMatiereDTO> list = new ArrayList<>();
        for (StatuMatiere statuArticle : domaines) {
            list.add(statuArticleToStatuArticleDTO(statuArticle));
        }
        return list;
    }
}
