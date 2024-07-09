/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchat;
import com.MangmentRessources.MangRess.Achat.dto.DetailsOrdreAchatDTO;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class DetailsOrdreAchatFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static DetailsOrdreAchatDTO detailsOrdreAchatTodetailsOrdreAchatDTOCollection(DetailsOrdreAchat domaine) {

        if (domaine != null) {
            DetailsOrdreAchatDTO dTO = new DetailsOrdreAchatDTO();
            dTO.setCodeOrdreAchat(domaine.getDetailsOrdreAchatPK().getCodeOrdreAchat());
            dTO.setDatecreate(domaine.getDateCreate());
            dTO.setUsercreate(domaine.getUsercreate());
            dTO.setCodematiere(MatiereFactory.matiereToMatiereDTO(domaine.getMatiere()));
            dTO.setCodeColoris(ColorisFactory.colorisToColorisDTO(domaine.getColoris()));
            dTO.setCodeUnite(UniteFactory.uniteToUniteDTO(domaine.getUnite()));
//            dTO.setValeurTaxe(domaine.getMatiere().getTaxe().getValeurTaxe());

            dTO.setQteDemander(domaine.getQteDemander());
            return dTO;
        } else {
            return null;
        }

    }

    public static DetailsOrdreAchatDTO UpdatedetailsOrdreAchatTodetailsOrdreAchatDTO(DetailsOrdreAchat domaine) {

        if (domaine != null) {
            DetailsOrdreAchatDTO dTO = new DetailsOrdreAchatDTO();
            dTO.setCodeOrdreAchat(domaine.getDetailsOrdreAchatPK().getCodeOrdreAchat());
            dTO.setDatecreate(domaine.getDateCreate());
            dTO.setUsercreate(domaine.getUsercreate());
            System.out.println("soufien returnxxxx");
            dTO.setCodeSaisieOrdreAchat(domaine.getOrdreAchat().getCodeSaisie());
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

            dTO.setPrixAchat(domaine.getPrixUnitaireAchat());
            dTO.setMntTotalHT(domaine.getMntTotalHT());
            dTO.setMntTotalTTC(domaine.getMntTotalTTC());
            dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());

            dTO.setValeurTaxe(domaine.getMatiere().getTaxe().getValeurTaxe());

            dTO.setQteDemander(domaine.getQteDemander());
            return dTO;
        } else {
            return null;
        }

    }

    public static Collection<DetailsOrdreAchatDTO> UpdatedetailsOrdreAchatTodetailsOrdreAchatDTOCollection(Collection<DetailsOrdreAchat> detailsOrdreAchats) {
        Collection<DetailsOrdreAchatDTO> dTOs = new ArrayList<>();
        for (DetailsOrdreAchat rslt : detailsOrdreAchats) {
            dTOs.add(UpdatedetailsOrdreAchatTodetailsOrdreAchatDTO(rslt));
        }
        return dTOs;
    }
}
