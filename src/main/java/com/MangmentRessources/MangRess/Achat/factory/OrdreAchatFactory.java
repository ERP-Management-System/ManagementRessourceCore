/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.OrdreAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchatPK;
import com.MangmentRessources.MangRess.Achat.dto.OrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsOrdreAchatDTO;
import com.MangmentRessources.MangRess.web.Util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class OrdreAchatFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static OrdreAchat createOrdreAchatByCode(int code) {
        OrdreAchat domaine = new OrdreAchat();
        domaine.setCode(code);
        return domaine;
    }

    public static OrdreAchat ordreAchatDTOToOrdreAchat(OrdreAchatDTO Dto, OrdreAchat domaine) {
        if (Dto != null) {
            domaine.setCode(Dto.getCode());

            domaine.setCodeSaisie(Dto.getCodeSaisie());

            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());
            domaine.setObservation(Dto.getObservation());

            domaine.setCodeEtatDemande(Dto.getCodeEtatDemande());

            return domaine;
        } else {
            return null;
        }
    }

    public static OrdreAchatDTO ordreAchatToOrdreAchatDTO(OrdreAchat domaine) {

        if (domaine != null) {
            OrdreAchatDTO dTO = new OrdreAchatDTO();
            dTO.setCode(domaine.getCode());

            dTO.setCodeSaisie(domaine.getCodeSaisie());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());

            dTO.setTypeCircuitAchatDTO(TypeCircuitAchatFactory.typeCircuitAchatToTypeCircuitAchatDTO(domaine.getTypeCircuitAchat()));
            dTO.setCodeTypeCircuitAchat(domaine.getCodeTypeCircuitAchat());

            dTO.setEtatDemandeAchatDTO(EtatDemandeAchatFactory.etatDemandeAchatToEtatDemandeAchatDTO(domaine.getEtatDemande()));
            dTO.setCodeEtatDemande(domaine.getCodeEtatDemande());

            dTO.setAppelOffreDTO(AppelOffreFactory.DetailsappelOffreToDetailsAppelOffreDTO(domaine.getAppelOffre()));
            dTO.setCodeAppelOffre(domaine.getCodeAppelOffre());

            dTO.setDemandeAchatDTO(DemandeAchatFactory.DetailsdemandeAchatToDetailsDemandeAchatDTO(domaine.getDemandeAchat()));
            dTO.setCodeDemandeAchat(domaine.getCodeDemandeAchat());

            if (domaine.getDetailsOrdreAchats() != null) {
                Collection<DetailsOrdreAchatDTO> detailsDdeTransfertDTOSCollection = new ArrayList<>();
                domaine.getDetailsOrdreAchats().forEach(x -> {
                    DetailsOrdreAchatDTO detailsDTO = new DetailsOrdreAchatDTO();
                    detailsDTO = DetailsOrdreAchatFactory.detailsOrdreAchatTodetailsOrdreAchatDTOCollection(x);
                    detailsDdeTransfertDTOSCollection.add(detailsDTO);
                });
                if (dTO.getDetailsOrdreAchatDTOs() != null) {
                    dTO.getDetailsOrdreAchatDTOs().clear();
                    dTO.getDetailsOrdreAchatDTOs().addAll(detailsDdeTransfertDTOSCollection);
                } else {
                    dTO.setDetailsOrdreAchatDTOs(detailsDdeTransfertDTOSCollection);
                }
            }

            return dTO;
        } else {
            return null;
        }
    }

    public static List<OrdreAchatDTO> listOrdreAchatToOrdreAchatDTOs(List<OrdreAchat> domaines) {
        List<OrdreAchatDTO> list = new ArrayList<>();
        for (OrdreAchat ordreAchat : domaines) {
            list.add(ordreAchatToOrdreAchatDTO(ordreAchat));
        }
        return list;
    }

    public static OrdreAchat ordreAchatDTOToOrdreAchatWithDetails(OrdreAchat domaine, OrdreAchatDTO dTO) {
        domaine.setCode(dTO.getCode());

        domaine.setCodeSaisie(dTO.getCodeSaisie());

        domaine.setDateCreate(new Date());
        domaine.setUserCreate(dTO.getUserCreate());
        domaine.setObservation(dTO.getObservation());

        domaine.setCodeEtatDemande(dTO.getCodeDemandeAchat());
        if (domaine.getCodeEtatDemande() != null) {
            domaine.setEtatDemande(EtatDemandeAchatFactory.createEtatDemandeAchatByCode(dTO.getCodeDemandeAchat()));

        }

        domaine.setCodeTypeCircuitAchat(dTO.getCodeTypeCircuitAchat());
        if (domaine.getCodeTypeCircuitAchat() != null) {
            domaine.setTypeCircuitAchat(TypeCircuitAchatFactory.createTypeCircuitAchatByCode(dTO.getCodeTypeCircuitAchat()));

        }

        domaine.setCodeDemandeAchat(dTO.getCodeDemandeAchat());
        if (domaine.getCodeDemandeAchat() != null) {
            domaine.setDemandeAchat(DemandeAchatFactory.createDemandeAchatByCode(dTO.getCodeDemandeAchat()));

        }

        domaine.setCodeAppelOffre(dTO.getCodeAppelOffre());
        if (domaine.getCodeAppelOffre() != null) {
            domaine.setAppelOffre(AppelOffreFactory.createAppelOffreByCode(dTO.getCodeAppelOffre()));

        }

        Collection<DetailsOrdreAchat> detailsCollections = new ArrayList<>();

        dTO.getDetailsOrdreAchatDTOs().forEach(x -> {

            DetailsOrdreAchat detailsmodelepanier = new DetailsOrdreAchat();
            DetailsOrdreAchatPK detailsmodelepanierPK = new DetailsOrdreAchatPK();

            Preconditions.checkBusinessLogique(x.getCodematiere() != null, "error.MatiereRequired");
            detailsmodelepanierPK.setCodeMatiere(x.getCodematiere().getCode());

            Preconditions.checkBusinessLogique(x.getCodeUnite().getCode() != null, "error.UniteRequired");
            detailsmodelepanierPK.setCodeUnite(x.getCodeUnite().getCode());
            Preconditions.checkBusinessLogique(x.getCodeColoris().getCode() != null, "error.ColorisRequired");
            detailsmodelepanierPK.setCodeColoris(x.getCodeColoris().getCode());
            detailsmodelepanier.setDetailsOrdreAchatPK(detailsmodelepanierPK);
            Preconditions.checkBusinessLogique(x.getQteOrdre() != null, "error.QuantiteRequired");
            detailsmodelepanier.setQteOrdre(x.getQteOrdre());
            detailsmodelepanier.setDateCreate(domaine.getDateCreate());
            detailsmodelepanier.setUsercreate(domaine.getUserCreate());
            detailsmodelepanier.setOrdreAchat(domaine);
            detailsCollections.add(detailsmodelepanier);
        });

        if (domaine.getDetailsOrdreAchats() != null) {
            domaine.getDetailsOrdreAchats().clear();
            domaine.getDetailsOrdreAchats().addAll(detailsCollections);
        } else {
            domaine.setDetailsOrdreAchats(detailsCollections);
        }
        return domaine;
    }

    public static OrdreAchatDTO DetailsordreAchatToDetailsOrdreAchatDTO(OrdreAchat domaine) {

        if (domaine != null) {
            OrdreAchatDTO dTO = new OrdreAchatDTO();
            dTO.setCode(domaine.getCode());

            dTO.setCodeSaisie(domaine.getCodeSaisie());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());

            dTO.setEtatDemandeAchatDTO(EtatDemandeAchatFactory.etatDemandeAchatToEtatDemandeAchatDTO(domaine.getEtatDemande()));
            dTO.setCodeEtatDemande(domaine.getCodeEtatDemande());

            return dTO;
        } else {
            return null;
        }
    }

    public static OrdreAchatDTO UpdateordreAchatWithDetailsToordreAchatDTOWithDetails(OrdreAchat domaine) {
//        System.out.println("soufien return");
        if (domaine == null) {
            return null;
        }
        OrdreAchatDTO dTO = new OrdreAchatDTO();
        dTO.setCode(domaine.getCode());
        dTO.setCodeSaisie(domaine.getCodeSaisie());

        dTO.setDateCreate(domaine.getDateCreate());
        dTO.setUserCreate(domaine.getUserCreate());
        dTO.setObservation(domaine.getObservation());

        dTO.setEtatDemandeAchatDTO(EtatDemandeAchatFactory.etatDemandeAchatToEtatDemandeAchatDTO(domaine.getEtatDemande()));
        dTO.setCodeEtatDemande(domaine.getCodeEtatDemande());

        if (domaine.getDetailsOrdreAchats() != null) {
            Collection<DetailsOrdreAchatDTO> detailsDTOSCollection = new ArrayList<>();
            domaine.getDetailsOrdreAchats().forEach(x -> {
                DetailsOrdreAchatDTO detailsDTO = new DetailsOrdreAchatDTO();
                detailsDTO = DetailsOrdreAchatFactory.detailsOrdreAchatTodetailsOrdreAchatDTOCollection(x);
                detailsDTOSCollection.add(detailsDTO);
            });
            if (dTO.getDetailsOrdreAchatDTOs() != null) {
                dTO.getDetailsOrdreAchatDTOs().clear();
                dTO.getDetailsOrdreAchatDTOs().addAll(detailsDTOSCollection);
            } else {
                dTO.setDetailsOrdreAchatDTOs(detailsDTOSCollection);
            }
        }
        return dTO;
    }
}
