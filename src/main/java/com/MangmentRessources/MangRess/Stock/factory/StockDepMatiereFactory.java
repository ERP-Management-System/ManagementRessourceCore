/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.factory;

import com.MangmentRessources.MangRess.Achat.factory.ColorisFactory;
import com.MangmentRessources.MangRess.Achat.factory.DepotFactory;
import com.MangmentRessources.MangRess.Achat.factory.MatiereFactory;
import com.MangmentRessources.MangRess.Achat.factory.UniteFactory;
import com.MangmentRessources.MangRess.Stock.domaine.StockDepMatiere;
import com.MangmentRessources.MangRess.Stock.dto.StockDepMatiereDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class StockDepMatiereFactory {

    public static StockDepMatiere createStockDepMatiereByCode(int code) {
        StockDepMatiere domaine = new StockDepMatiere();
        domaine.setCode(code);
        return domaine;
    }

    public static StockDepMatiereDTO StockDepMatiereToStockDepMatiereDTO(StockDepMatiere domaine) {

        if (domaine != null) {
            StockDepMatiereDTO dTO = new StockDepMatiereDTO();
            dTO.setCode(domaine.getCode());
            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUsercreate(domaine.getUsercreate());
            dTO.setLaize(domaine.getLaize());
            dTO.setNumPiece(domaine.getNumPiece());
            dTO.setNumBonReception(domaine.getNumBonReception());
            dTO.setPrixUnitaire(domaine.getPrixUnitaire());
            dTO.setQteDispo(domaine.getQteDispo());

            dTO.setMatiereDTO(MatiereFactory.matiereToMatiereDTO(domaine.getMatiere()));
            dTO.setCodematiere(domaine.getCodematiere());

            dTO.setColorisDTO(ColorisFactory.colorisToColorisDTO(domaine.getColoris()));
            dTO.setCodeColoris(domaine.getCodeColoris());

            dTO.setUniteDTO(UniteFactory.uniteToUniteDTO(domaine.getUnite()));
            dTO.setCodeUnite(domaine.getCodeUnite());

            dTO.setDepotDTO(DepotFactory.depotToDepotDTO(domaine.getDepot()));
            dTO.setCodeDepot(domaine.getCodeDepot());

            return dTO;
        } else {
            return null;
        }
    }
//

    public static List<StockDepMatiereDTO> listStockDepMatiereToStockDepMatiereDTOs(List<StockDepMatiere> domaines) {
        List<StockDepMatiereDTO> list = new ArrayList<>();
        for (StockDepMatiere stockDepMatiere : domaines) {
            list.add(StockDepMatiereToStockDepMatiereDTO(stockDepMatiere));
        }
        return list;
    }

    public static StockDepMatiere StockDepMatiereDTOToStockDepMatiereWithDetails(StockDepMatiere domaine, StockDepMatiereDTO dTO) {
        domaine.setCode(dTO.getCode());

        domaine.setDateCreate(new Date());
        domaine.setUsercreate(dTO.getUsercreate());
        domaine.setLaize(dTO.getLaize());
        domaine.setNumPiece(dTO.getNumPiece());
        domaine.setNumBonReception(dTO.getNumBonReception());
        domaine.setQteDispo(dTO.getQteDispo());

        domaine.setCodeDepot(dTO.getCodeDepot());
        if (domaine.getCodeDepot() != null) {
            domaine.setDepot(DepotFactory.createDepotByCode(dTO.getCodeDepot()));
        }

        domaine.setCodematiere(dTO.getCodematiere());
        if (domaine.getCodematiere() != null) {
            domaine.setMatiere(MatiereFactory.createMatiereByCode(dTO.getCodematiere()));

        }

        domaine.setCodeColoris(dTO.getCodeColoris());
        if (domaine.getCodeColoris() != null) {
            domaine.setColoris(ColorisFactory.createColorisByCode(dTO.getCodeColoris()));

        }

        domaine.setCodeUnite(dTO.getCodeUnite());
        if (domaine.getCodeUnite() != null) {
            domaine.setUnite(UniteFactory.createUniteByCode(dTO.getCodeUnite()));

        }

        return domaine;
    }
    
        public static Collection<StockDepMatiereDTO> detailsStockDepMatiereTodetailsStockDepMatiereDTOCollection(Collection<StockDepMatiere> stockDepMatieres) {
        Collection<StockDepMatiereDTO> collection = new ArrayList<>();
        for (StockDepMatiere ddtm : stockDepMatieres) {
            collection.add(StockDepMatiereToStockDepMatiereDTO(ddtm));
        }
        return collection;
    }


}
