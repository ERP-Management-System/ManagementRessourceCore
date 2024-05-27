/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.EtatDemandeAchat;
import com.MangmentRessources.MangRess.dto.EtatDemandeAchatDTO;
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
public class EtatDemandeAchatFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static EtatDemandeAchat createEtatDemandeAchatByCode(int code) {
        EtatDemandeAchat domaine = new EtatDemandeAchat();
        domaine.setCode(code);
        return domaine;
    }

    public static EtatDemandeAchat etatDemandeAchatDTOToEtatDemandeAchat(EtatDemandeAchatDTO Dto, EtatDemandeAchat domaine) {
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
            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());
            return domaine;
        } else {
            return null;
        }
    }

    public static EtatDemandeAchatDTO etatDemandeAchatToEtatDemandeAchatDTO(EtatDemandeAchat domaine) {

        if (domaine != null) {
            EtatDemandeAchatDTO dTO = new EtatDemandeAchatDTO();
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

            return dTO;
        } else {
            return null;
        }
    }

    public static List<EtatDemandeAchatDTO> listEtatDemandeAchatToEtatDemandeAchatDTOs(List<EtatDemandeAchat> etatDemandeAchats) {
        List<EtatDemandeAchatDTO> list = new ArrayList<>();
        for (EtatDemandeAchat etatDemandeAchat : etatDemandeAchats) {
            list.add(etatDemandeAchatToEtatDemandeAchatDTO(etatDemandeAchat));
        }
        return list;
    }

}
