/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.domaine.DetailsDemandeAchatPK;
import com.MangmentRessources.MangRess.domaine.DetailsNomenclaturePK;
import com.MangmentRessources.MangRess.dto.DetailsDemandeAchatDTO;
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
public class DetailsDemandeAchatFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static DetailsDemandeAchat detailsNomenclatureDTOTodetailNomenclatureCollection(DetailsDemandeAchatDTO dTO) {
        DetailsDemandeAchat detailsDdeAchat = new DetailsDemandeAchat();

        DetailsDemandeAchatPK detailsDemandeAchatPK = new DetailsDemandeAchatPK(); 
        detailsDdeAchat.setDetailsDemandeAchatPK(detailsDemandeAchatPK); 
        detailsDdeAchat.setQteDemander(dTO.getQteDemander());   
        detailsDdeAchat.setQteLivrer(dTO.getQteLivrer());

        detailsDdeAchat.setDateCreate(new Date());
        detailsDdeAchat.setUsercreate(dTO.getUsercreate());

        return detailsDdeAchat;
    }

    public static DetailsDemandeAchatDTO detailsDemandeAchatTodetailsDemandeAchatDTOCollection(DetailsDemandeAchat domaine) {

        if (domaine != null) {

            DetailsDemandeAchatDTO dTO = new DetailsDemandeAchatDTO();
 
            dTO.setDatecreate(domaine.getDateCreate());

            dTO.setUsercreate(domaine.getUsercreate());

            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {

                dTO.setCodeSaisieMatiere(domaine.getDetailsDemandeAchatPK().getMatiere().getCodeSaisie());
                dTO.setDesignationMatiereAr(domaine.getDetailsDemandeAchatPK().getMatiere().getDesignationAr());
                dTO.setDesignationMatiereLT(domaine.getDetailsDemandeAchatPK().getMatiere().getDesignationLt());

                dTO.setCodeSaisieColoris(domaine.getDetailsDemandeAchatPK().getColoris().getCodeSaisie());
                dTO.setDesignationColorisAr(domaine.getDetailsDemandeAchatPK().getColoris().getDesignationAr());
                dTO.setDesignationColorisLT(domaine.getDetailsDemandeAchatPK().getColoris().getDesignationLt());

                dTO.setCodeSaisieUnite(domaine.getDetailsDemandeAchatPK().getUnite().getCodeSaisie());
                dTO.setDesignationUniteAr(domaine.getDetailsDemandeAchatPK().getUnite().getDesignationAr());
                dTO.setDesignationUniteLT(domaine.getDetailsDemandeAchatPK().getUnite().getDesignationLt());

            } else {
               
                dTO.setCodeSaisieMatiere(domaine.getDetailsDemandeAchatPK().getMatiere().getCodeSaisie());
                dTO.setDesignationMatiereLT(domaine.getDetailsDemandeAchatPK().getMatiere().getDesignationLt());
                dTO.setDesignationMatiereAr(domaine.getDetailsDemandeAchatPK().getMatiere().getDesignationAr());

                dTO.setCodeSaisieColoris(domaine.getDetailsDemandeAchatPK().getColoris().getCodeSaisie());
                dTO.setDesignationColorisLT(domaine.getDetailsDemandeAchatPK().getColoris().getDesignationLt());
                dTO.setDesignationColorisAr(domaine.getDetailsDemandeAchatPK().getColoris().getDesignationAr());

                dTO.setCodeSaisieUnite(domaine.getDetailsDemandeAchatPK().getUnite().getCodeSaisie());
                dTO.setDesignationUniteLT(domaine.getDetailsDemandeAchatPK().getUnite().getDesignationLt());
                dTO.setDesignationUniteAr(domaine.getDetailsDemandeAchatPK().getUnite().getDesignationAr());

            }

            dTO.setQteDemander(domaine.getQteDemander());
            dTO.setQteLivrer(domaine.getQteLivrer());
            return dTO;
        } else {
            return null;
        }
    }
}
