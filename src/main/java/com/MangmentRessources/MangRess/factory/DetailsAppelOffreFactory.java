/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;
 
import com.MangmentRessources.MangRess.domaine.DetailsAppelOffre;
import com.MangmentRessources.MangRess.domaine.DetailsAppelOffrePK; 
import com.MangmentRessources.MangRess.dto.DetailsAppelOffreDTO;  
 
import java.util.Date;
import java.util.Locale;
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

//    public static DetailsAppelOffre detailsAppelOffreDTOTodetailAppelOffreCollection(DetailsAppelOffreDTO dTO) {
//        DetailsAppelOffre detailsDdeAchat = new DetailsAppelOffre();
//
//        DetailsAppelOffrePK detailsAppelOffrePK = new DetailsAppelOffrePK();
//        detailsDdeAchat.setDetailsAppelOffrePK(detailsAppelOffrePK);
//        detailsDdeAchat.setQteDemander(dTO.getQteDemander());
//
//        detailsDdeAchat.setDateCreate(new Date());
//        detailsDdeAchat.setUsercreate(dTO.getUsercreate());
//
//        return detailsDdeAchat;
//    }
    public static DetailsAppelOffre detailordreAchatDTOTodetailordreAchatCollection(DetailsAppelOffreDTO Dto) {
        DetailsAppelOffre domain = new DetailsAppelOffre();
        DetailsAppelOffrePK detailsOrdreAchatPK = new DetailsAppelOffrePK();
//        detailsDdeTransfert.setCodeddeTransfert(detailsDdeTransfertDTO.getCodeddeTransfert());

//        detailsOrdreAchatPK.setCodematiere(Dto.getCodeMatiere());
        domain.setDetailsAppelOffrePK(detailsOrdreAchatPK);

        domain.setQteDemander(Dto.getQteDemander());

//        System.out.println("soufien  " + Dto.getCodeMatiere());
//        domain.setCodedemandeur(Dto.getCodedemandeur());
//        domain.setCodefournisseur(Dto.getCodefournisseur());
        domain.setDateCreate(new Date());
        domain.setUsercreate(Dto.getUsercreate());

        return domain;
    }
//
//    public static DetailsAppelOffre detailddetransfertDTOTodetailddetransfertCollection(DetailsAppelOffreDTO detailsAppelOffreDTO, AppelOffre appelOffre) {
//        DetailsAppelOffre detailsAppelOffre = new DetailsAppelOffre();
//
//        DetailsAppelOffrePK detailsDdeTransfertPK = new DetailsAppelOffrePK();
////        detailsDdeTransfert.set(detailsDdeTransfertDTO.getCodeddeTransfert());
////        detailsDdeTransfertPK.setCodematiere(detailsAppelOffreDTO.getCodeMatiere());
////        detailsDdeTransfertPK.setCodeappeloffre(appelOffre.getCode());
//
//        detailsAppelOffre.setDetailsAppelOffrePK(detailsDdeTransfertPK);
//
//        detailsAppelOffre.setQteDemander(detailsAppelOffreDTO.getQteDemander());
//        detailsAppelOffre.setDateCreate(new Date());
//        detailsAppelOffre.setUsercreate(detailsAppelOffreDTO.getUsercreate());
//
//        return detailsAppelOffre;
//    }

    public static DetailsAppelOffreDTO detailsAppelOffreTodetailsAppelOffreDTOCollection(DetailsAppelOffre domaine) {

        if (domaine != null) {
            DetailsAppelOffreDTO dTO = new DetailsAppelOffreDTO();
            dTO.setCodeAppelOffre(domaine.getDetailsAppelOffrePK().getCodeAppelOffre());
            dTO.setDatecreate(domaine.getDateCreate());
            dTO.setUsercreate(domaine.getUsercreate());
            System.out.println("after save "+ MatiereFactory.matiereToMatiereDTO(domaine.getMatiere()));
            dTO.setCodematiere(MatiereFactory.matiereToMatiereDTO(domaine.getMatiere())); 
            
            
            
            dTO.setQteDemander(domaine.getQteDemander());
            return dTO;
        } else {
            return null;
        }

    }

/////// Appel Offre With Details From Base
}
