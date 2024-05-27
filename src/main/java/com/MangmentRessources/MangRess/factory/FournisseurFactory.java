/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.Fournisseur;
import com.MangmentRessources.MangRess.dto.FournisseurDTO;
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
public class FournisseurFactory {
    
    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static Fournisseur createFournisseurByCode(int code) {
        Fournisseur domaine = new Fournisseur();
        domaine.setCode(code);
        return domaine;
    }

    public static Fournisseur fournisseurDTOToFournisseur(FournisseurDTO Dto, Fournisseur domaine) {
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
            domaine.setCodeRegion(Dto.getCodeRegion());

            return domaine;
        } else {
            return null;
        }
    }

    public static FournisseurDTO fournisseurToFournisseurDTO(Fournisseur domaine) {

        if (domaine != null) {
            FournisseurDTO dTO = new FournisseurDTO();
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

            dTO.setRegionDTO(RegionFactory.regionToRegionDTO(domaine.getRegion()));
            dTO.setCodeRegion(domaine.getCodeRegion());

            return dTO;
        } else {
            return null;
        }
    }

    public static List<FournisseurDTO> listFournisseurToFournisseurDTOs(List<Fournisseur> domaines) {
        List<FournisseurDTO> list = new ArrayList<>();
        for (Fournisseur fournisseur : domaines) {
            list.add(fournisseurToFournisseurDTO(fournisseur));
        }
        return list;
    }
}
