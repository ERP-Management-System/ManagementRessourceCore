/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.DemandeAchat;
import com.MangmentRessources.MangRess.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.dto.DemandeAchatDTO;
import com.MangmentRessources.MangRess.dto.DetailsDemandeAchatDTO;
import static com.MangmentRessources.MangRess.factory.DetailsDemandeAchatFactory.LANGUAGE_SEC;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class DemandeAchatFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static DemandeAchat createDemandeAchatByCode(int code) {
        DemandeAchat domaine = new DemandeAchat();
        domaine.setCode(code);
        return domaine;
    }

    public static DemandeAchat nomenclatureArticleDTOToDemandeAchatCollection(DemandeAchatDTO Dto, DemandeAchat domaine) {
        if (Dto != null) {
            domaine.setCode(Dto.getCode());

            domaine.setCodeSaisieDemande(Dto.getCodeSaisieDemande());

            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());
            domaine.setObservation(Dto.getObservation());

            if (Dto.getCodeTypeCircuitAchat() != null) {
                domaine.setTypeCircuitAchat(TypeCircuitAchatFactory.createTypeCircuitAchatByCode(Dto.getCodeTypeCircuitAchat()));
            }
            if (Dto.getCodeEtatDemande() != null) {
                domaine.setEtatDemande(EtatDemandeAchatFactory.createEtatDemandeAchatByCode(Dto.getCodeEtatDemande()));
            }
            Collection<DetailsDemandeAchat> detailsDemandeAchats = new ArrayList<>();
            if (Dto.getDetailsDemandeAchatDTOs() != null) {
                Dto.getDetailsDemandeAchatDTOs().forEach(x -> {
                    DetailsDemandeAchat detailsDemandeAchat = new DetailsDemandeAchat();
                    detailsDemandeAchat = DetailsDemandeAchatFactory.detailsNomenclatureDTOTodetailNomenclatureCollection(x);
                    detailsDemandeAchat.setDemandeAchat(domaine);
                    detailsDemandeAchats.add(detailsDemandeAchat);
                });
            }
            if (domaine.getDetailsDemandeAchats() != null) {
                domaine.getDetailsDemandeAchats().clear();
                domaine.getDetailsDemandeAchats().addAll(detailsDemandeAchats);
            } else {
                domaine.setDetailsDemandeAchats(detailsDemandeAchats);
            }

            return domaine;
        } else {
            return null;
        }
    }

    public static DemandeAchatDTO demandeAchatToDemandeAchatDTO(DemandeAchat domaine) {

        if (domaine != null) {
            DemandeAchatDTO dTO = new DemandeAchatDTO();
            dTO.setCode(domaine.getCode());
            //            System.out.println("jihennn  " + LocaleContextHolder.getLocale().getLanguage());
            //            System.out.println("jihennn  " + new Locale(LANGUAGE_SEC).getLanguage());

            dTO.setCodeSaisieDemande(domaine.getCodeSaisieDemande());
            dTO.setCodeTypeCircuitAchat(domaine.getTypeCircuitAchat().getCode());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());

            dTO.setObservation(domaine.getObservation());

            dTO.setCodeEtatDemande(domaine.getEtatDemande().getCode());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {
                dTO.setDesignationArEtatDemande(domaine.getEtatDemande().getDesignationAr());
                dTO.setDesignationLTEtatDemande(domaine.getEtatDemande().getDesignationLt());
                dTO.setDesignationArTypeCircuitAchat(domaine.getTypeCircuitAchat().getDesignationAr());
                dTO.setDesignationLTTypeCircuitAchat(domaine.getTypeCircuitAchat().getDesignationLt());
            } else {
                dTO.setDesignationLTEtatDemande(domaine.getEtatDemande().getDesignationLt());
                dTO.setDesignationArEtatDemande(domaine.getEtatDemande().getDesignationAr());
                dTO.setDesignationLTTypeCircuitAchat(domaine.getTypeCircuitAchat().getDesignationLt());
                dTO.setDesignationArTypeCircuitAchat(domaine.getTypeCircuitAchat().getDesignationAr());
            }

            return dTO;
        } else {
            return null;
        }
    }

    public static List<DemandeAchatDTO> listDemandeAchatToDemandeAchatDTOs(List<DemandeAchat> domaines) {
        List<DemandeAchatDTO> list = new ArrayList<>();
        for (DemandeAchat nomenclatureArticle : domaines) {
            list.add(demandeAchatToDemandeAchatDTO(nomenclatureArticle));
        }
        return list;
    }

    public static DemandeAchatDTO demandeAchatToDemandeAchatDTOCollection(DemandeAchat domaine) {

        if (domaine != null) {
            DemandeAchatDTO dTO = new DemandeAchatDTO();
            dTO.setCode(domaine.getCode());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());   
            dTO.setObservation(domaine.getObservation());


            dTO.setCodeEtatDemande(domaine.getEtatDemande().getCode());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {
                dTO.setDesignationArEtatDemande(domaine.getEtatDemande().getDesignationAr());
                dTO.setDesignationLTEtatDemande(domaine.getEtatDemande().getDesignationLt());
            } else {
                dTO.setDesignationLTEtatDemande(domaine.getEtatDemande().getDesignationLt());
                dTO.setDesignationArEtatDemande(domaine.getEtatDemande().getDesignationAr());
            }

            if (domaine.getDetailsDemandeAchats() != null) {
                Collection<DetailsDemandeAchatDTO> detailsDemandeAchatDTOs = new ArrayList<>();
                domaine.getDetailsDemandeAchats().forEach(x -> {
                    DetailsDemandeAchatDTO detailsDemandeAchatDTO = new DetailsDemandeAchatDTO();
                    detailsDemandeAchatDTO = DetailsDemandeAchatFactory.detailsDemandeAchatTodetailsDemandeAchatDTOCollection(x);
                    detailsDemandeAchatDTOs.add(detailsDemandeAchatDTO);
                });
                if (dTO.getDetailsDemandeAchatDTOs() != null) {
                    dTO.getDetailsDemandeAchatDTOs().clear();
                    dTO.getDetailsDemandeAchatDTOs().addAll(detailsDemandeAchatDTOs);
                } else {
                    dTO.setDetailsDemandeAchatDTOs(detailsDemandeAchatDTOs);
                }
            }

            return dTO;
        } else {
            return null;
        }
    }

}
