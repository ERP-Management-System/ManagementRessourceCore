/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsReceptionTemp;
import com.MangmentRessources.MangRess.Achat.dto.DetailsReceptionTempDTO;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class DetailsReceptionTempFactory {

    public static DetailsReceptionTemp createDetailsReceptionTempByCode(int code) {
        DetailsReceptionTemp domaine = new DetailsReceptionTemp();
        domaine.setCode(code);
        return domaine;
    }

    public static DetailsReceptionTempDTO bonReceptionToDetailsReceptionTempDTO(DetailsReceptionTemp domaine) {

        if (domaine != null) {
            DetailsReceptionTempDTO dTO = new DetailsReceptionTempDTO();
            dTO.setCode(domaine.getCode());
            dTO.setLaize(domaine.getLaize());
            dTO.setNumPiece(domaine.getNumPiece());
            dTO.setQteReceptionner(domaine.getQteReceptionner());
            dTO.setPrixUnitaireAchat(domaine.getPrixUnitaireAchat());

            dTO.setMatiereDTO(MatiereFactory.matiereToMatiereDTO(domaine.getMatiere()));
            dTO.setCodematiere(domaine.getCodematiere());

            dTO.setColorisDTO(ColorisFactory.colorisToColorisDTO(domaine.getColoris()));
            dTO.setCodeColoris(domaine.getCodeColoris());

            dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
            dTO.setCodeDepot(domaine.getCodeDepot());

            dTO.setUniteDTO(UniteFactory.uniteToUniteDTO(domaine.getUnite()));
            dTO.setCodeUnite(domaine.getCodeUnite());

            dTO.setOrdreAchatDTO(OrdreAchatFactory.ordreAchatToOrdreAchatDTO(domaine.getOrdreAchat()));
            dTO.setCodeOrdreAchat(domaine.getCodeOrdreAchat());

            return dTO;
        } else {
            return null;
        }
    }

    public static List<DetailsReceptionTempDTO> listDetailsReceptionTempToDetailsReceptionTempDTOs(List<DetailsReceptionTemp> domaines) {
        List<DetailsReceptionTempDTO> list = new ArrayList<>();
        for (DetailsReceptionTemp bonReception : domaines) {
            list.add(bonReceptionToDetailsReceptionTempDTO(bonReception));
        }
        return list;
    }

    public static DetailsReceptionTemp bonReceptionDTOToDetailsReceptionTemp(DetailsReceptionTemp domaine, DetailsReceptionTempDTO dTO) {
        domaine.setCode(dTO.getCode());
        domaine.setLaize(dTO.getLaize());
        domaine.setNumPiece(dTO.getNumPiece());
        domaine.setQteReceptionner(dTO.getQteReceptionner());

        Preconditions.checkArgument(dTO.getPrixUnitaireAchat() != null, "PrixCanNotMakeNull");
        domaine.setPrixUnitaireAchat(dTO.getPrixUnitaireAchat());

        domaine.setCodeOrdreAchat(dTO.getCodeOrdreAchat());
        if (domaine.getCodeOrdreAchat() != null) {
            domaine.setOrdreAchat(OrdreAchatFactory.createOrdreAchatByCode(dTO.getCodeOrdreAchat()));
        }

        domaine.setCodeColoris(dTO.getCodeColoris());
        if (domaine.getCodeColoris() != null) {
            domaine.setColoris(ColorisFactory.createColorisByCode(dTO.getCodeColoris()));
        }

        domaine.setCodeUnite(dTO.getCodeUnite());
        if (domaine.getCodeUnite() != null) {
            domaine.setUnite(UniteFactory.createUniteByCode(dTO.getCodeUnite()));
        }

        domaine.setCodeDepot(dTO.getCodeDepot());
        if (domaine.getCodeDepot() != null) {
            domaine.setDepot(DepotFactory.createDepotByCode(dTO.getCodeDepot()));
        }

        domaine.setCodematiere(dTO.getCodematiere());
        if (domaine.getCodematiere() != null) {
            domaine.setMatiere(MatiereFactory.createMatiereByCode(dTO.getCodematiere()));
        }
        return domaine;
    }
}
