/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.CategorieDepot;
import com.MangmentRessources.MangRess.Achat.dto.CategorieDepotDTO;
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
public class CategorieDepotFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static CategorieDepot createCategorieDepotByCode(int code) {
        CategorieDepot domaine = new CategorieDepot();
        domaine.setCode(code);
        return domaine;
    }

    public static CategorieDepot categorieDepotDTOToCategorieDepot(CategorieDepotDTO Dto, CategorieDepot domaine) {
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

    public static CategorieDepotDTO categorieDepotToCategorieDepotDTO(CategorieDepot domaine) {

        if (domaine != null) {
            CategorieDepotDTO dTO = new CategorieDepotDTO();
            dTO.setCode(domaine.getCode());
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

            return dTO;
        } else {
            return null;
        }
    }

    public static List<CategorieDepotDTO> listCategorieDepotToCategorieDepotDTOs(List<CategorieDepot> categorieDepots) {
        List<CategorieDepotDTO> list = new ArrayList<>();
        for (CategorieDepot categorieDepot : categorieDepots) {
            list.add(categorieDepotToCategorieDepotDTO(categorieDepot));
        }
        return list;
    }

}
