/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.Achat.dto.DetailsDemandeAchatDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
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
            dTO.setDateLivraison(domaine.getDemandeAchat().getDateLivraison());
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
            dTO.setCodeSaisieDemandeAchat(domaine.getDemandeAchat().getCodeSaisie());
            dTO.setCodeMatieres(domaine.getMatiere().getCode());

            dTO.setDateLivraison(domaine.getDemandeAchat().getDateLivraison());

//            dTO.setCodeAppelOffre(domaine.getDemandeAchat().getCodeAppelOffre());      
//            dTO.setCodeModeReglement(domaine.getDemandeAchat().getAppelOffre().getCodeModeReglement());      
            dTO.setCodeSaisieMatiere(domaine.getMatiere().getCodeSaisie());
            dTO.setDesignationArMatiere(domaine.getMatiere().getDesignationAr());
            dTO.setDesignationLtMatiere(domaine.getMatiere().getDesignationLt());
            dTO.setPrixAchat(domaine.getMatiere().getPrixAchat());
            System.out.println("domaine.getMatiere().getTaxe()"+domaine.getMatiere().getTaxe());
            dTO.setValeurTaxe(domaine.getMatiere().getTaxe().getValeurTaxe());      
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

    public static List<DetailsDemandeAchatDTO> UpdatedetailsDemandeAchatTodetailsDemandeAchatDTOList(List<DetailsDemandeAchat> detailsDemandeAchats) {
        List<DetailsDemandeAchatDTO> dTOs = new ArrayList<>();
        for (DetailsDemandeAchat rslt : detailsDemandeAchats) {
            dTOs.add(UpdatedetailsDemandeAchatTodetailsDemandeAchatDTO(rslt));
        }
        return dTOs;
    }
}
