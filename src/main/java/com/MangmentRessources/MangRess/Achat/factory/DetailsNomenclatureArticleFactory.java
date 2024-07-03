/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsNomenclatureArticle;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsNomenclaturePK;
import com.MangmentRessources.MangRess.Achat.dto.DetailsNomenclatureArticleDTO;
import static com.MangmentRessources.MangRess.Achat.factory.NomenclatureArticleFactory.LANGUAGE_SEC;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import com.MangmentRessources.MangRess.Achat.repository.MatiereRepo;

/**
 *
 * @author Administrator
 */
@Component
public class DetailsNomenclatureArticleFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static DetailsNomenclatureArticle detailsNomenclatureDTOTodetailNomenclatureCollection(DetailsNomenclatureArticleDTO dTO) {
        DetailsNomenclatureArticle detailsDdeAchat = new DetailsNomenclatureArticle();

        DetailsNomenclaturePK detailsNomenclaturePK = new DetailsNomenclaturePK();
//        detailsDdeTransfert.setCodeddeTransfert(detailsDdeTransfertDTO.getCodeddeTransfert());
        detailsDdeAchat.setDetailsNomenclaturePK(detailsNomenclaturePK);
//        detailsNomenclaturePK.setCodearticle(dTO.getCodearticle());
        detailsDdeAchat.setQtebesoin(dTO.getQtebesoin());
        detailsDdeAchat.setDateCreate(new Date());
        detailsDdeAchat.setUsercreate(dTO.getUsercreate());

        return detailsDdeAchat;
    }

    public static DetailsNomenclatureArticleDTO detailsNomenclatureTodetailsNomenclatureDTOCollection(DetailsNomenclatureArticle domaine) {

        if (domaine != null) {

            DetailsNomenclatureArticleDTO dTO = new DetailsNomenclatureArticleDTO();

            dTO.setCodeMatiere(domaine.getDetailsNomenclaturePK().getCodeMatiere());
            dTO.setCodeNomenclatureArticle(domaine.getDetailsNomenclaturePK().getCodeNomenclatureArticle());

            dTO.setDatecreate(domaine.getDateCreate());

            dTO.setUsercreate(domaine.getUsercreate());

            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {

//                dTO.setCodeSaisieMatiere(domaine.getDetailsNomenclaturePK().getMatiere().getCodeSaisie());
//                dTO.setDesignationMatiereAr(domaine.getDetailsNomenclaturePK().getMatiere().getDesignationAr());
//                dTO.setDesignationMatiereLT(domaine.getDetailsNomenclaturePK().getMatiere().getDesignationLt());  
//                
//                
//                dTO.setCodeSaisieColoris(domaine.getDetailsNomenclaturePK().getColoris().getCodeSaisie());
//                dTO.setDesignationColorisAr(domaine.getDetailsNomenclaturePK().getColoris().getDesignationAr());
//                dTO.setDesignationColorisLT(domaine.getDetailsNomenclaturePK().getColoris().getDesignationLt());
//
//            } else {
//                dTO.setDesignationMatiereLT(domaine.getDetailsNomenclaturePK().getMatiere().getDesignationLt());
//                dTO.setDesignationMatiereAr(domaine.getDetailsNomenclaturePK().getMatiere().getDesignationAr());
//
//                dTO.setDesignationColorisLT(domaine.getDetailsNomenclaturePK().getColoris().getDesignationLt());
//                dTO.setDesignationColorisAr(domaine.getDetailsNomenclaturePK().getColoris().getDesignationAr());
            }

            dTO.setQtebesoin(domaine.getQtebesoin());
            dTO.setCodeArticle(domaine.getCodearticle());
            return dTO;
        } else {
            return null;
        }
    }
}
