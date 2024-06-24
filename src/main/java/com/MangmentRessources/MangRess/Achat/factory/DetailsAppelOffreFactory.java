/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsAppelOffre; 
import com.MangmentRessources.MangRess.Achat.dto.DetailsAppelOffreDTO;
import java.util.ArrayList;
import java.util.Collection;  
import org.springframework.beans.factory.annotation.Value;
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

    public static DetailsAppelOffreDTO detailsAppelOffreTodetailsAppelOffreDTOCollection(DetailsAppelOffre domaine) {

        if (domaine != null) {
            DetailsAppelOffreDTO dTO = new DetailsAppelOffreDTO();
            dTO.setCodeAppelOffre(domaine.getDetailsAppelOffrePK().getCodeAppelOffre());
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

    public static DetailsAppelOffreDTO UpdatedetailsAppelOffreTodetailsAppelOffreDTO(DetailsAppelOffre domaine) {

        if (domaine != null) {
            DetailsAppelOffreDTO dTO = new DetailsAppelOffreDTO();
            dTO.setCodeAppelOffre(domaine.getDetailsAppelOffrePK().getCodeAppelOffre());
            dTO.setDatecreate(domaine.getDateCreate());
            dTO.setUsercreate(domaine.getUsercreate()); 

            System.out.println("soufien return");
            dTO.setCodeSaisieAppelOffre(domaine.getAppelOffre().getCodeSaisie());
            dTO.setCodeMatieres(domaine.getMatiere().getCode());

            dTO.setCodeSaisieMatiere(domaine.getMatiere().getCodeSaisie());
            dTO.setDesignationArMatiere(domaine.getMatiere().getDesignationAr());
            dTO.setDesignationLtMatiere(domaine.getMatiere().getDesignationLt());      
            dTO.setPrixAchat(domaine.getMatiere().getPrixAchat());       
            dTO.setCodeTaxe(domaine.getMatiere().getCodeTaxe());



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

    public static Collection<DetailsAppelOffreDTO> UpdatedetailsAppelOffreTodetailsAppelOffreDTOCollection(Collection<DetailsAppelOffre> detailsOrdreAchats) {
        Collection<DetailsAppelOffreDTO> affectationFilialleDTOS = new ArrayList<>();
        for (DetailsAppelOffre affectationFilialle : detailsOrdreAchats) {
            affectationFilialleDTOS.add(UpdatedetailsAppelOffreTodetailsAppelOffreDTO(affectationFilialle));
        }
        return affectationFilialleDTOS;
    }
/////// Appel Offre With Details From Base
}
