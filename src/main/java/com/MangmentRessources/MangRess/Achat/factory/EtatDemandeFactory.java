/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.EtatDemande;
import com.MangmentRessources.MangRess.Achat.dto.EtatDemandeDTO;
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
public class EtatDemandeFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static EtatDemande createEtatDemandeAchatByCode(int code) {
        EtatDemande domaine = new EtatDemande();
        domaine.setCode(code);
        return domaine;
    }

    public static EtatDemande etatDemandeAchatDTOToEtatDemandeAchat(EtatDemandeDTO Dto, EtatDemande domaine) {
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

    public static EtatDemandeDTO etatDemandeAchatToEtatDemandeAchatDTO(EtatDemande domaine) {

        if (domaine != null) {
            EtatDemandeDTO dTO = new EtatDemandeDTO();
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

    public static List<EtatDemandeDTO> listEtatDemandeAchatToEtatDemandeAchatDTOs(List<EtatDemande> etatDemandeAchats) {
        List<EtatDemandeDTO> list = new ArrayList<>();
        for (EtatDemande etatDemandeAchat : etatDemandeAchats) {
            list.add(etatDemandeAchatToEtatDemandeAchatDTO(etatDemandeAchat));
        }
        return list;
    }

}
