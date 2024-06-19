/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.Coloris;
import com.MangmentRessources.MangRess.Achat.dto.ColorisDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import java.util.Locale;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class ColorisFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static Coloris createColorisByCode(int code) {
        Coloris domaine = new Coloris();
        domaine.setCode(code);
        return domaine;
    }

    public static Coloris colorisDTOToColoris(ColorisDTO Dto, Coloris domaine) {
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
            return domaine;
        } else {
            return null;
        }
    }

    public static ColorisDTO colorisToColorisDTO(Coloris domaine) {

        if (domaine != null) {
            ColorisDTO dTO = new ColorisDTO();
            dTO.setCode(domaine.getCode());       
            dTO.setCodeColoriss(domaine.getCode());

 
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {

                dTO.setDesignationAr(domaine.getDesignationAr());
                dTO.setDesignationLt(domaine.getDesignationLt());
                 dTO.setDesignationArColoriss(domaine.getDesignationAr());
                dTO.setDesignationLtColoriss(domaine.getDesignationLt());
            } else {
                dTO.setDesignationLt(domaine.getDesignationLt());
                dTO.setDesignationAr(domaine.getDesignationAr());
                 dTO.setDesignationLtColoriss(domaine.getDesignationLt());
                dTO.setDesignationArColoriss(domaine.getDesignationAr());
            }
            dTO.setCodeSaisie(domaine.getCodeSaisie());
            dTO.setActif(domaine.isActif());
            dTO.setVisible(domaine.isVisible());
            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());       
            dTO.setDesigColor(domaine.getDesignationAr());


            return dTO;
        } else {
            return null;
        }
    }

    public static List<ColorisDTO> listColorisToColorisDTOs(List<Coloris> coloriss) {
        List<ColorisDTO> list = new ArrayList<>();
        for (Coloris coloris : coloriss) {
            list.add(colorisToColorisDTO(coloris));
        }
        return list;
    }

}
