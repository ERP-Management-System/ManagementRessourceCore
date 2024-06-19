/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.domaine.DetailsDemandeAchatPK;
import com.MangmentRessources.MangRess.domaine.DetailsNomenclaturePK;
import com.MangmentRessources.MangRess.dto.DetailsDemandeAchatDTO;
import com.MangmentRessources.MangRess.dto.DetailsDemandeAchatDTO;
import java.util.ArrayList;
import java.util.Collection;
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

    
    public static DetailsDemandeAchatDTO detailsDemandeAchatTodetailsDemandeAchatDTOCollection(DetailsDemandeAchat domaine) {

        if (domaine != null) {
            DetailsDemandeAchatDTO dTO = new DetailsDemandeAchatDTO();
            dTO.setCodeDemandeAchat(domaine.getDetailsDemandeAchatPK().getCodeDemandeAchat());
            dTO.setDatecreate(domaine.getDateCreate());
            dTO.setUsercreate(domaine.getUsercreate());
            dTO.setCodematiere(MatiereFactory.matiereToMatiereDTO(domaine.getMatiere()));
            dTO.setCodeColoris(ColorisFactory.colorisToColorisDTO(domaine.getColoris()));
            dTO.setCodeUnite(UniteFactory.uniteToUniteDTO(domaine.getUnite()));

            dTO.setQteDemander(domaine.getQteDemander());
            return dTO;
        } else {
            return null;
        }

    }

    public static DetailsDemandeAchatDTO UpdatedetailsDemandeAchatTodetailsDemandeAchatDTO(DetailsDemandeAchat domaine) {

        if (domaine != null) {
            DetailsDemandeAchatDTO dTO = new DetailsDemandeAchatDTO();
            dTO.setCodeDemandeAchat(domaine.getDetailsDemandeAchatPK().getCodeDemandeAchat());
            dTO.setDatecreate(domaine.getDateCreate());
            dTO.setUsercreate(domaine.getUsercreate());
            System.out.println("soufien returnxxxx");
            dTO.setCodeSaisieDemandeAchat(domaine.getDemandeAchat().getCodeSaisie());
            dTO.setCodeMatieres(domaine.getMatiere().getCode());

            dTO.setCodeSaisieMatiere(domaine.getMatiere().getCodeSaisie());
            dTO.setDesignationArMatiere(domaine.getMatiere().getDesignationAr());
            dTO.setDesignationLtMatiere(domaine.getMatiere().getDesignationLt());

            dTO.setCodeColoriss(domaine.getColoris().getCode());
            dTO.setCodeSaisieColoriss(domaine.getColoris().getCodeSaisie());
            dTO.setDesignationArColoriss(domaine.getColoris().getDesignationAr());
            dTO.setDesignationLtColoriss(domaine.getColoris().getDesignationLt());

            dTO.setCodeUnites(domaine.getUnite().getCode());
            dTO.setCodeSaisieUnites(domaine.getUnite().getCodeSaisie());
            dTO.setDesignationArUnites(domaine.getUnite().getDesignationAr());
            dTO.setDesignationLtUnites(domaine.getUnite().getDesignationLt());

            dTO.setQteDemander(domaine.getQteDemander());
            return dTO;
        } else {
            return null;
        }

    }

    public static Collection<DetailsDemandeAchatDTO> UpdatedetailsDemandeAchatTodetailsDemandeAchatDTOCollection(Collection<DetailsDemandeAchat> detailsDemandeAchats) {
        Collection<DetailsDemandeAchatDTO> dTOs = new ArrayList<>();
        for (DetailsDemandeAchat rslt : detailsDemandeAchats) {
            dTOs.add(UpdatedetailsDemandeAchatTodetailsDemandeAchatDTO(rslt));
        }
        return dTOs;
    }
}
