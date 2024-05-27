/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.DetailsAppelOffre;
import com.MangmentRessources.MangRess.domaine.DetailsAppelOffrePK;
import com.MangmentRessources.MangRess.dto.DetailsAppelOffreDTO;

import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class DetailsAppelOffreFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static DetailsAppelOffre detailsAppelOffreDTOTodetailAppelOffreCollection(DetailsAppelOffreDTO dTO) {
        DetailsAppelOffre detailsDdeAchat = new DetailsAppelOffre();

        DetailsAppelOffrePK detailsAppelOffrePK = new DetailsAppelOffrePK();
        detailsDdeAchat.setDetailsAppelOffrePK(detailsAppelOffrePK);
        detailsDdeAchat.setQteDemander(dTO.getQteDemander());

        detailsDdeAchat.setDateCreate(new Date());
        detailsDdeAchat.setUsercreate(dTO.getUsercreate());

        return detailsDdeAchat;
    }

    public static DetailsAppelOffreDTO detailsAppelOffreTodetailsAppelOffreDTOCollection(DetailsAppelOffre domaine) {

        if (domaine != null) {

            DetailsAppelOffreDTO dTO = new DetailsAppelOffreDTO();

            
            dTO.setCodeAppelOffre(domaine.getDetailsAppelOffrePK().getCodeAppelOffre());
            dTO.setDatecreate(domaine.getDateCreate());

            dTO.setUsercreate(domaine.getUsercreate());

            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {

                dTO.setCodeMatiere(domaine.getDetailsAppelOffrePK().getMatiere().getCode());
                dTO.setCodeSaisieMatiere(domaine.getDetailsAppelOffrePK().getMatiere().getCodeSaisie());
                dTO.setDesignationMatiereAr(domaine.getDetailsAppelOffrePK().getMatiere().getDesignationAr());
                dTO.setDesignationMatiereLT(domaine.getDetailsAppelOffrePK().getMatiere().getDesignationLt());

                dTO.setCodeColoris(domaine.getDetailsAppelOffrePK().getColoris().getCode());  
                dTO.setCodeSaisieColoris(domaine.getDetailsAppelOffrePK().getColoris().getCodeSaisie());
                dTO.setDesignationColorisAr(domaine.getDetailsAppelOffrePK().getColoris().getDesignationAr());
                dTO.setDesignationColorisLT(domaine.getDetailsAppelOffrePK().getColoris().getDesignationLt());

                dTO.setCodeUnite(domaine.getDetailsAppelOffrePK().getUnite().getCode());    
                dTO.setCodeSaisieUnite(domaine.getDetailsAppelOffrePK().getUnite().getCodeSaisie());
                dTO.setDesignationUniteAr(domaine.getDetailsAppelOffrePK().getUnite().getDesignationAr());
                dTO.setDesignationUniteLT(domaine.getDetailsAppelOffrePK().getUnite().getDesignationLt());

            } else {

                dTO.setCodeSaisieMatiere(domaine.getDetailsAppelOffrePK().getMatiere().getCodeSaisie());
                dTO.setDesignationMatiereLT(domaine.getDetailsAppelOffrePK().getMatiere().getDesignationLt());
                dTO.setDesignationMatiereAr(domaine.getDetailsAppelOffrePK().getMatiere().getDesignationAr());

                dTO.setCodeSaisieColoris(domaine.getDetailsAppelOffrePK().getColoris().getCodeSaisie());
                dTO.setDesignationColorisLT(domaine.getDetailsAppelOffrePK().getColoris().getDesignationLt());
                dTO.setDesignationColorisAr(domaine.getDetailsAppelOffrePK().getColoris().getDesignationAr());

                dTO.setCodeSaisieUnite(domaine.getDetailsAppelOffrePK().getUnite().getCodeSaisie());
                dTO.setDesignationUniteLT(domaine.getDetailsAppelOffrePK().getUnite().getDesignationLt());
                dTO.setDesignationUniteAr(domaine.getDetailsAppelOffrePK().getUnite().getDesignationAr());

            }

            dTO.setQteDemander(domaine.getQteDemander());
            return dTO;
        } else {
            return null;
        }
    }

}
