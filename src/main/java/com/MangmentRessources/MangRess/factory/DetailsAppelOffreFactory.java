/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.AppelOffre;
import com.MangmentRessources.MangRess.domaine.Article;
import com.MangmentRessources.MangRess.domaine.DetailsAppelOffre;
import com.MangmentRessources.MangRess.domaine.DetailsAppelOffrePK;
import com.MangmentRessources.MangRess.dto.ArticleDTO;
import com.MangmentRessources.MangRess.dto.DetailsAppelOffreDTO;
import com.MangmentRessources.MangRess.dto.DetailsAppelOffreDTOs;
import static com.MangmentRessources.MangRess.factory.ArticleFactory.LANGUAGE_SEC;
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

    public static DetailsAppelOffre detailddetransfertDTOTodetailddetransfertCollection(DetailsAppelOffreDTO detailsAppelOffreDTO, AppelOffre appelOffre) {
        DetailsAppelOffre detailsAppelOffre = new DetailsAppelOffre();

        DetailsAppelOffrePK detailsDdeTransfertPK = new DetailsAppelOffrePK();
//        detailsDdeTransfert.set(detailsDdeTransfertDTO.getCodeddeTransfert());
//        detailsDdeTransfertPK.setCodematiere(detailsAppelOffreDTO.getCodeMatiere());
//        detailsDdeTransfertPK.setCodeappeloffre(appelOffre.getCode());

        detailsAppelOffre.setDetailsAppelOffrePK(detailsDdeTransfertPK);

        detailsAppelOffre.setQteDemander(detailsAppelOffreDTO.getQteDemander());
        detailsAppelOffre.setDateCreate(new Date());
        detailsAppelOffre.setUsercreate(detailsAppelOffreDTO.getUsercreate());

        return detailsAppelOffre;
    }

    public static DetailsAppelOffreDTO detailsAppelOffreTodetailsAppelOffreDTOCollection(DetailsAppelOffre domaine) {

        if (domaine != null) {

            DetailsAppelOffreDTO dTO = new DetailsAppelOffreDTO();

            dTO.setCodeAppelOffre(domaine.getDetailsAppelOffrePK().getCodeAppelOffre());
            dTO.setDatecreate(domaine.getDateCreate());

            dTO.setUsercreate(domaine.getUsercreate());

            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {

//                dTO.setCodeMatiere(domaine.getDetailsAppelOffrePK().getCodeMatiere());
//                System.out.println("soufien v1 " + domaine.getMatiere());
 
//                dTO.setCodeMatiere(domaine.getDetailsAppelOffrePK().getCodeMatiere());
//                dTO.setMatiereDTO(MatiereFactory.matiereToMatiereDTO(domaine.getMatiere()));
                dTO.setCodeMatiere(domaine.getDetailsAppelOffrePK().getCodeMatiere());
                
                
//            dTO.setMatiereDTO(MatiereFactory.matiereToMatiereDTO(domaine.getDetailsAppelOffrePK().getMatiere()));

            } else {
                dTO.setCodeMatiere(domaine.getDetailsAppelOffrePK().getCodeMatiere());
//
//                System.out.println("soufien v2" + domaine.getMatiere().getDesignationAr());
//                dTO.setDesignationArMatiere(domaine.getMatiere().getDesignationAr());
//                dTO.setDesignationArMatiere(domaine.getDetailsAppelOffrePK().getMatiere().getDesignationAr());
//                dTO.setDesignationMatiereLT(domaine.getDetailsAppelOffrePK().getMatiere().getDesignationLt());
//                dTO.setDesignationMatiereAr(domaine.getDetailsAppelOffrePK().getMatiere().getDesignationAr());
//
//                dTO.setCodeSaisieColoris(domaine.getDetailsAppelOffrePK().getColoris().getCodeSaisie());
//                dTO.setDesignationColorisLT(domaine.getDetailsAppelOffrePK().getColoris().getDesignationLt());
//                dTO.setDesignationColorisAr(domaine.getDetailsAppelOffrePK().getColoris().getDesignationAr());
//
//                dTO.setCodeSaisieUnite(domaine.getDetailsAppelOffrePK().getUnite().getCodeSaisie());
//                dTO.setDesignationUniteLT(domaine.getDetailsAppelOffrePK().getUnite().getDesignationLt());
//                dTO.setDesignationUniteAr(domaine.getDetailsAppelOffrePK().getUnite().getDesignationAr());
            }

            dTO.setQteDemander(domaine.getQteDemander());
            return dTO;
        } else {
            return null;
        }

    }
    
    
    /////// Appel Offre With Details From Base
    
  

}
