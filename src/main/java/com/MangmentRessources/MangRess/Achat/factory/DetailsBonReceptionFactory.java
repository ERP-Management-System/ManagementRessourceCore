/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsBonReception;
import com.MangmentRessources.MangRess.Achat.dto.DetailsBonReceptionDTO;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class DetailsBonReceptionFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static DetailsBonReceptionDTO detailsBonReceptionTodetailsBonReceptionDTOCollection(DetailsBonReception domaine) {

        if (domaine != null) {
            DetailsBonReceptionDTO dTO = new DetailsBonReceptionDTO();
            dTO.setCodeBonReception(domaine.getDetailsBonReceptionPK().getCodeBonReception());
            dTO.setDatecreate(domaine.getDateCreate());
            dTO.setUsercreate(domaine.getUsercreate());
            dTO.setCodeMatieres(MatiereFactory.matiereToMatiereDTO(domaine.getMatiere()).getCode());
            dTO.setCodeColoris(ColorisFactory.colorisToColorisDTO(domaine.getColoris()));
            dTO.setCodeUnite(UniteFactory.uniteToUniteDTO(domaine.getUnite()));

            dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));

            dTO.setQteReceptionner(domaine.getQteReceptionner());
            return dTO;
        } else {
            return null;
        }

    }

    public static DetailsBonReceptionDTO UpdatedetailsBonReceptionTodetailsBonReceptionDTO(DetailsBonReception domaine) {

        if (domaine != null) {
            DetailsBonReceptionDTO dTO = new DetailsBonReceptionDTO();
            dTO.setCodeBonReception(domaine.getDetailsBonReceptionPK().getCodeBonReception());
            dTO.setDatecreate(domaine.getDateCreate());
            dTO.setUsercreate(domaine.getUsercreate());
            dTO.setCodeSaisieBonReception(domaine.getBonReception().getCodeSaisie());
            dTO.setCodeMatieres(domaine.getMatiere().getCode());

            dTO.setCodeSaisieMatiere(domaine.getMatiere().getCodeSaisie());
            dTO.setDesignationArMatiere(domaine.getMatiere().getDesignationAr());
            dTO.setDesignationLtMatiere(domaine.getMatiere().getDesignationLt());
            dTO.setPrixAchat(domaine.getMatiere().getPrixAchat());
            dTO.setCodeTaxe(domaine.getMatiere().getCodeTaxe());
            dTO.setQteReceptionner(domaine.getQteReceptionner());

            dTO.setCodeColoriss(domaine.getColoris().getCode());
            dTO.setCodeSaisieColoriss(domaine.getColoris().getCodeSaisie());
            dTO.setDesignationArColoriss(domaine.getColoris().getDesignationAr());
            dTO.setDesignationLtColoriss(domaine.getColoris().getDesignationLt());

            dTO.setCodeUnites(domaine.getUnite().getCode());
            dTO.setCodeSaisieUnites(domaine.getUnite().getCodeSaisie());
            dTO.setDesignationArUnites(domaine.getUnite().getDesignationAr());
            dTO.setDesignationLtUnites(domaine.getUnite().getDesignationLt());

            return dTO;
        } else {
            return null;
        }

    }

    public static Collection<DetailsBonReceptionDTO> UpdatedetailsBonReceptionTodetailsBonReceptionDTOCollection(Collection<DetailsBonReception> detailsOrdreAchats) {
        Collection<DetailsBonReceptionDTO> detailsBonReceptionDTOs = new ArrayList<>();
        for (DetailsBonReception detailsBonReception : detailsOrdreAchats) {
            detailsBonReceptionDTOs.add(UpdatedetailsBonReceptionTodetailsBonReceptionDTO(detailsBonReception));
        }
        return detailsBonReceptionDTOs;
    }
}
