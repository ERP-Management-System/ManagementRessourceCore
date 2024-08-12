/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.factory;

import com.MangmentRessources.MangRess.Achat.factory.ColorisFactory;
import com.MangmentRessources.MangRess.Achat.factory.DepotFactory;
import com.MangmentRessources.MangRess.Achat.factory.MatiereFactory;
import com.MangmentRessources.MangRess.Achat.factory.UniteFactory;
import com.MangmentRessources.MangRess.Stock.domaine.DetailsDemandeTransfertMatiere;
import com.MangmentRessources.MangRess.Stock.dto.DetailsDemandeTransfertMatiereDTO;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class DetailsDemandeTransfertMatiereFactory {

    public static DetailsDemandeTransfertMatiereDTO detailsDemandeTransfertMatiereTodetailsDemandeTransfertMatiereDTOCollection(DetailsDemandeTransfertMatiere domaine) {

        if (domaine != null) {
            DetailsDemandeTransfertMatiereDTO dTO = new DetailsDemandeTransfertMatiereDTO();
            dTO.setCodeDemandeTransfertMatiere(domaine.getDetailsDemandeTransfertMatierePK().getCodeDemandeTransfertMatiere());
            dTO.setDatecreate(domaine.getDateCreate());
            dTO.setUsercreate(domaine.getUsercreate());
            dTO.setMatiereDTO(MatiereFactory.matiereToMatiereDTO(domaine.getMatiere()));
            dTO.setColorisDTO(ColorisFactory.colorisToColorisDTO(domaine.getColoris()));
            dTO.setUniteDTO(UniteFactory.uniteToUniteDTO(domaine.getUnite()));
            dTO.setQteDemander(domaine.getQteDemander());
            dTO.setQteTransfert(domaine.getQteTransfert()); 
            dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));

            return dTO;
        } else {
            return null;
        }

    }

    public static Collection<DetailsDemandeTransfertMatiereDTO> detailsDemandeTransfertTodetailsDemandeTransfertDTOCollection(Collection<DetailsDemandeTransfertMatiere> detailsOrdreAchats) {
        Collection<DetailsDemandeTransfertMatiereDTO> collection = new ArrayList<>();
        for (DetailsDemandeTransfertMatiere ddtm : detailsOrdreAchats) {
            collection.add(detailsDemandeTransfertMatiereTodetailsDemandeTransfertMatiereDTOCollection(ddtm));
        }
        return collection;
    }

}
