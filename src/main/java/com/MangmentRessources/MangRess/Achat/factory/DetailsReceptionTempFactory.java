/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;
 
import com.MangmentRessources.MangRess.Achat.domaine.DetailsReceptionTemp;
import com.MangmentRessources.MangRess.Achat.dto.DetailsReceptionTempDTO; 
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

 


            dTO.setMatiereDTO(MatiereFactory.matiereToMatiereDTO(domaine.getMatiere()));
            dTO.setCodematiere(domaine.getCodematiere());

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

 
        domaine.setCodeOrdreAchat(dTO.getCodeOrdreAchat());
        if (domaine.getCodeOrdreAchat() != null) {
            domaine.setOrdreAchat(OrdreAchatFactory.createOrdreAchatByCode(dTO.getCodeOrdreAchat()));
        } 
        domaine.setCodematiere(dTO.getCodematiere());
        if (domaine.getCodematiere() != null) {
            domaine.setMatiere(MatiereFactory.createMatiereByCode(dTO.getCodematiere()));
        } 
        return domaine;
    }
}
