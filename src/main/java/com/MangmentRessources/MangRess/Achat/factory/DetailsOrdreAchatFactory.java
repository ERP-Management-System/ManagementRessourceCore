/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.CategorieArticle;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchatPK;
import com.MangmentRessources.MangRess.Achat.domaine.OrdreAchat;
import com.MangmentRessources.MangRess.Achat.dto.CategorieArticleDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsOrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.OrdreAchatDTO;
import static com.MangmentRessources.MangRess.Achat.factory.CategorieArticleFactory.LANGUAGE_SEC;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class DetailsOrdreAchatFactory {

    static String LANGUAGE_SEC;
 
    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static DetailsOrdreAchatDTO detailsOrdreAchatTodetailsOrdreAchatDTOCollection(DetailsOrdreAchat domaine) {

        if (domaine != null) {
            DetailsOrdreAchatDTO dto = new DetailsOrdreAchatDTO();
            dto.setCodeOrdreAchat(domaine.getDetailsOrdreAchatPK().getCodeOrdreAchat());
            dto.setDatecreate(domaine.getDateCreate());
            dto.setUsercreate(domaine.getUsercreate());
            dto.setMatiereDTO(MatiereFactory.matiereToMatiereDTO(domaine.getMatiere()));
            dto.setCodeColoris(ColorisFactory.colorisToColorisDTO(domaine.getColoris()));
            dto.setCodeUnite(UniteFactory.uniteToUniteDTO(domaine.getUnite()));
//            dto.setValeurTaxe(domaine.getMatiere().getTaxe().getValeurTaxe());

            dto.setQteDemander(domaine.getQteDemander());    
            dto.setQteLivrer(domaine.getQteLivrer());     
            dto.setTotalementLivred(domaine.getTotalementLivred());


            return dto;
        } else {
            return null;
        }

    }

    public static DetailsOrdreAchatDTO UpdatedetailsOrdreAchatTodetailsOrdreAchatDTO(DetailsOrdreAchat domaine) {

        if (domaine != null) {

            DetailsOrdreAchatDTO dto = new DetailsOrdreAchatDTO();
            dto.setCodeOrdreAchat(domaine.getDetailsOrdreAchatPK().getCodeOrdreAchat());
            dto.setDatecreate(domaine.getDateCreate());
            dto.setUsercreate(domaine.getUsercreate());

//            dto.setCode(domaine.getCode());
//         
            dto.setCodeSaisieOrdreAchat(domaine.getOrdreAchat().getCodeSaisie());
            dto.setCodeMatieres(domaine.getMatiere().getCode());

            dto.setCodeSaisieMatiere(domaine.getMatiere().getCodeSaisie());
            dto.setDesignationArMatiere(domaine.getMatiere().getDesignationAr());
            dto.setDesignationLtMatiere(domaine.getMatiere().getDesignationLt());    
            dto.setRequiredNumPiece(domaine.getMatiere().getRequiredNumPiece());


            dto.setCodeColoriss(domaine.getColoris().getCode());
            dto.setCodeSaisieColoriss(domaine.getColoris().getCodeSaisie());
            dto.setDesignationArColoriss(domaine.getColoris().getDesignationAr());
            dto.setDesignationLtColoriss(domaine.getColoris().getDesignationLt());

            dto.setCodeUnites(domaine.getUnite().getCode());
            dto.setCodeSaisieUnites(domaine.getUnite().getCodeSaisie());
            dto.setDesignationArUnites(domaine.getUnite().getDesignationAr());
            dto.setDesignationLtUnites(domaine.getUnite().getDesignationLt());

            dto.setPrixAchat(domaine.getPrixUnitaireAchat());
            dto.setMntTotalHT(domaine.getMntTotalHT());
            dto.setMntTotalTTC(domaine.getMntTotalTTC());
            dto.setMntTotalTaxe(domaine.getMntTotalTaxe());

            dto.setValeurTaxe(domaine.getMatiere().getTaxe().getValeurTaxe());

            dto.setQteDemander(domaine.getQteDemander());  
            dto.setQteLivrer(domaine.getQteLivrer());     
            dto.setTotalementLivred(domaine.getTotalementLivred()); 


             


            dto.setOrdreAchatDTO(OrdreAchatFactory.DetailsordreAchatToDetailsOrdreAchatDTO(domaine.getOrdreAchat()));

            return dto;
        } else {
            return null;
        }

    }

    public static Collection<DetailsOrdreAchatDTO> UpdatedetailsOrdreAchatTodetailsOrdreAchatDTOCollection(Collection<DetailsOrdreAchat> detailsOrdreAchats) {
        Collection<DetailsOrdreAchatDTO> dtos = new ArrayList<>();
        for (DetailsOrdreAchat rslt : detailsOrdreAchats) {
            dtos.add(UpdatedetailsOrdreAchatTodetailsOrdreAchatDTO(rslt));
        }
        return dtos;
    }
//    
    public static DetailsOrdreAchat DetailsordreAchatDTOToDetailsOrdreAchat( DetailsOrdreAchat domaine) {
        DetailsOrdreAchatDTO dTO = new DetailsOrdreAchatDTO();
        if (dTO != null) { 
            DetailsOrdreAchatPK det = new DetailsOrdreAchatPK();
            det.setCodeOrdreAchat(dTO.getCodeOrdreAchat());
            
            domaine.setQteLivrer(dTO.getQteLivrer()); 
            return domaine;
        } else {
            return null;
        }
    }
    
        public static Collection<DetailsOrdreAchat> NewUpdateQTEdetailsOrdreAchatTodetailsOrdreAchatDTOCollection(Collection<DetailsOrdreAchat> detailsOrdreAchats) {
        Collection<DetailsOrdreAchat> dtos = new ArrayList<>();
        for (DetailsOrdreAchat rslt : detailsOrdreAchats) {
            dtos.add(DetailsordreAchatDTOToDetailsOrdreAchat(rslt));
        }
        return dtos;
    }
 
        
        public static DetailsOrdreAchat DetailsOrdreAchatDTOToDetailsOrdreAchatQteLivre(DetailsOrdreAchatDTO Dto, DetailsOrdreAchat domaine) {
        if (Dto != null) {
            domaine.getDetailsOrdreAchatPK().setCodeOrdreAchat(Dto.getCodeOrdreAchat());
 
//            domaine.setCodeSaisie(Dto.getCodeSaisie());
            domaine.setQteLivrer(Dto.getQteLivrer()); 

            return domaine;
        } else {
            return null;
        }
    }

  }
