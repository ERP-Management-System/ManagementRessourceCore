/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.Taille;
import com.MangmentRessources.MangRess.dto.TailleDTO;
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
public class TailleFactory {
    
    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static Taille createTailleByCode(int code) {
        Taille domaine = new Taille();
        domaine.setCode(code);
        return domaine;
    }

    public static Taille tailleDTOToTaille(TailleDTO Dto, Taille domaine) {
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
            return domaine;
        } else {
            return null;
        }
    }

    public static TailleDTO tailleToTailleDTO(Taille domaine) {

        if (domaine != null) {
            TailleDTO dTO = new TailleDTO();
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

            dTO.setGrilleTailleDTO(GrilleTailleFactory.grilleTailleTogrilleTailleDTO(domaine.getGrilleTaille()));
            dTO.setCodeGrilleTaille(domaine.getCodeGrilleTaille());

            return dTO;
        } else {
            return null;
        }
    }

    public static List<TailleDTO> listTailleToTailleDTOs(List<Taille> domaines) {
        List<TailleDTO> list = new ArrayList<>();
        for (Taille taille : domaines) {
            list.add(tailleToTailleDTO(taille));
        }
        return list;
    }
    
}
