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
            domaine.setCodeEtatReception(Dto.getCodeEtatReception());
            if (domaine.getCodeEtatReception() != null) {
                domaine.setEtatReception(EtatReceptionFactory.createEtatReceptionByCode(Dto.getCodeEtatReception()));

            }

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
            dTO.setDateLivraison(domaine.getDateLivraison());

            dTO.setMntTotalHT(domaine.getMntTotalHT());
            dTO.setMntTimbre(domaine.getMntTimbre());
            dTO.setMntRemise(domaine.getMntRemise());
            dTO.setMntTotalTTC(domaine.getMntTotalTTC());
            dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
            dTO.setMntNet(domaine.getMntNet());

            dTO.setLieu(domaine.getLieu());
            dTO.setInstruction(domaine.getInstruction());

            dTO.setTypeCircuitAchatDTO(TypeCircuitAchatFactory.typeCircuitAchatToTypeCircuitAchatDTO(domaine.getTypeCircuitAchat()));
            dTO.setCodeTypeCircuitAchat(domaine.getCodeTypeCircuitAchat());

            dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
            dTO.setCodeEtatReception(domaine.getCodeEtatReception());

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

    public static OrdreAchatDTO ordreAchatToOrdreAchatDTOLazy(OrdreAchat domaine) {

        if (domaine != null) {
            OrdreAchatDTO dTO = new OrdreAchatDTO();
            dTO.setCode(domaine.getCode());

            dTO.setCodeSaisie(domaine.getCodeSaisie());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setObservation(domaine.getObservation());
            dTO.setDateLivraison(domaine.getDateLivraison());

            dTO.setMntTotalHT(domaine.getMntTotalHT());
            dTO.setMntTimbre(domaine.getMntTimbre());
            dTO.setMntRemise(domaine.getMntRemise());
            dTO.setMntTotalTTC(domaine.getMntTotalTTC());
            dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
            dTO.setMntNet(domaine.getMntNet());

            dTO.setLieu(domaine.getLieu());
            dTO.setInstruction(domaine.getInstruction());

            dTO.setTypeCircuitAchatDTO(TypeCircuitAchatFactory.typeCircuitAchatToTypeCircuitAchatDTO(domaine.getTypeCircuitAchat()));
            dTO.setCodeTypeCircuitAchat(domaine.getCodeTypeCircuitAchat());

            dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
            dTO.setCodeEtatReception(domaine.getCodeEtatReception());

            dTO.setAppelOffreDTO(AppelOffreFactory.DetailsappelOffreToDetailsAppelOffreDTO(domaine.getAppelOffre()));
            dTO.setCodeAppelOffre(domaine.getCodeAppelOffre());

            dTO.setDemandeAchatDTO(DemandeAchatFactory.DetailsdemandeAchatToDetailsDemandeAchatDTO(domaine.getDemandeAchat()));
            dTO.setCodeDemandeAchat(domaine.getCodeDemandeAchat());

            return dTO;
        } else {
            return null;
        }
    }

    public static List<OrdreAchatDTO> listOrdreAchatToOrdreAchatDTOs(List<OrdreAchat> domaines) {
        List<OrdreAchatDTO> list = new ArrayList<>();
        for (OrdreAchat ordreAchat : domaines) {
            list.add(ordreAchatToOrdreAchatDTOLazy(ordreAchat));
        }
        return list;
    }

    public static OrdreAchat ordreAchatDTOToOrdreAchatWithDetails(OrdreAchat domaine, OrdreAchatDTO dTO) {
        domaine.setCode(dTO.getCode());
        domaine.setDateCreate(new Date());
        domaine.setUserCreate(dTO.getUserCreate());
        domaine.setObservation(dTO.getObservation());

        domaine.setMntTotalHT(dTO.getMntTotalHT());
        domaine.setMntTimbre(dTO.getMntTimbre());
        domaine.setMntRemise(dTO.getMntRemise());
        domaine.setMntTotalTTC(dTO.getMntTotalTTC());
        domaine.setMntTotalTaxe(dTO.getMntTotalTaxe());

        domaine.setMntNet(dTO.getMntNet());

        domaine.setLieu(dTO.getLieu());
        domaine.setInstruction(dTO.getInstruction());
        domaine.setDateLivraison(dTO.getDateLivraison());

        domaine.setCodeTypeCircuitAchat(dTO.getCodeTypeCircuitAchat());
        if (domaine.getCodeTypeCircuitAchat() != null) {
            domaine.setTypeCircuitAchat(TypeCircuitAchatFactory.createTypeCircuitAchatByCode(dTO.getCodeTypeCircuitAchat()));

        }

        Preconditions.checkBusinessLogique(dTO.getCodeEtatReception() != null, "error.CodeEtatReceptionRequired");
        domaine.setCodeEtatReception(dTO.getCodeEtatReception());
        if (domaine.getCodeEtatReception() != null) {
            domaine.setEtatReception(EtatReceptionFactory.createEtatReceptionByCode(dTO.getCodeEtatReception()));

        }
        Preconditions.checkBusinessLogique(dTO.getCodeDemandeAchat() != null, "error.DemandeAchatRequired");
        domaine.setCodeDemandeAchat(dTO.getCodeDemandeAchat());
        if (domaine.getCodeDemandeAchat() != null) {
            domaine.setDemandeAchat(DemandeAchatFactory.createDemandeAchatByCode(dTO.getCodeDemandeAchat()));

        }
        Preconditions.checkBusinessLogique(dTO.getCodeAppelOffre() != null, "error.AppelOffreRequired");
        domaine.setCodeAppelOffre(dTO.getCodeAppelOffre());
        if (domaine.getCodeAppelOffre() != null) {
            domaine.setAppelOffre(AppelOffreFactory.createAppelOffreByCode(dTO.getCodeAppelOffre()));

        }

        Collection<DetailsOrdreAchat> detailsCollections = new ArrayList<>();

        dTO.getDetailsOrdreAchatDTOs().forEach(x -> {

            DetailsOrdreAchat detailsOrdreAchat = new DetailsOrdreAchat();
            DetailsOrdreAchatPK detailsOrdreAchatPK = new DetailsOrdreAchatPK();

            Preconditions.checkBusinessLogique(x.getMatiereDTO().getCode()!= null, "error.MatiereRequired");
            detailsOrdreAchatPK.setCodeMatiere(x.getMatiereDTO().getCode());
            Preconditions.checkBusinessLogique(x.getCodeUnites() != null, "error.UniteRequired");
            detailsOrdreAchatPK.setCodeUnite(x.getCodeUnites());
            Preconditions.checkBusinessLogique(x.getCodeColoriss() != null, "error.ColorisRequired");
            detailsOrdreAchatPK.setCodeColoris(x.getCodeColoriss());
            
//            detailsOrdreAchat.setValeurTaxe(x.getCodematiere().getValeurTaxe());
            detailsOrdreAchat.setDetailsOrdreAchatPK(detailsOrdreAchatPK);
            Preconditions.checkBusinessLogique(x.getQteDemander() != null, "error.QuantiteRequired");
            detailsOrdreAchat.setQteDemander(x.getQteDemander());
            detailsOrdreAchat.setDateCreate(domaine.getDateCreate());
            detailsOrdreAchat.setUsercreate(domaine.getUserCreate());

            detailsOrdreAchat.setPrixUnitaireAchat(x.getPrixAchat());
            detailsOrdreAchat.setMntTotalHT(x.getMntTotalHT());
            detailsOrdreAchat.setMntTotalTTC(x.getMntTotalTTC());
            detailsOrdreAchat.setMntTotalTaxe(x.getMntTotalTaxe());

            detailsOrdreAchat.setOrdreAchat(domaine);
            detailsCollections.add(detailsOrdreAchat);
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

            dTO.setDateLivraison(domaine.getDateLivraison());

            dTO.setMntTotalHT(domaine.getMntTotalHT());
            dTO.setMntTimbre(domaine.getMntTimbre());
            dTO.setMntRemise(domaine.getMntRemise());
            dTO.setMntTotalTTC(domaine.getMntTotalTTC());
            dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());
            dTO.setMntNet(domaine.getMntNet());

            dTO.setLieu(domaine.getLieu());
            dTO.setInstruction(domaine.getInstruction());

            dTO.setTypeCircuitAchatDTO(TypeCircuitAchatFactory.typeCircuitAchatToTypeCircuitAchatDTO(domaine.getTypeCircuitAchat()));
            dTO.setCodeTypeCircuitAchat(domaine.getCodeTypeCircuitAchat());

            dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
            dTO.setCodeEtatReception(domaine.getCodeEtatReception());

            dTO.setAppelOffreDTO(AppelOffreFactory.DetailsappelOffreToDetailsAppelOffreDTO(domaine.getAppelOffre()));
            dTO.setCodeAppelOffre(domaine.getCodeAppelOffre());

            dTO.setDemandeAchatDTO(DemandeAchatFactory.DetailsdemandeAchatToDetailsDemandeAchatDTO(domaine.getDemandeAchat()));
            dTO.setCodeDemandeAchat(domaine.getCodeDemandeAchat());

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

        dTO.setMntTotalHT(domaine.getMntTotalHT());
        dTO.setMntTimbre(domaine.getMntTimbre());
        dTO.setMntRemise(domaine.getMntRemise());
        dTO.setMntTotalTTC(domaine.getMntTotalTTC());
        dTO.setMntTotalTaxe(domaine.getMntTotalTaxe());

        dTO.setMntNet(domaine.getMntNet());

        dTO.setLieu(domaine.getLieu());
        dTO.setInstruction(domaine.getInstruction());

        dTO.setTypeCircuitAchatDTO(TypeCircuitAchatFactory.typeCircuitAchatToTypeCircuitAchatDTO(domaine.getTypeCircuitAchat()));
        dTO.setCodeTypeCircuitAchat(domaine.getCodeTypeCircuitAchat());

        dTO.setEtatReceptionDTO(EtatReceptionFactory.etatReceptionToEtatReceptionDTO(domaine.getEtatReception()));
        dTO.setCodeEtatReception(domaine.getCodeEtatReception());

        dTO.setAppelOffreDTO(AppelOffreFactory.DetailsappelOffreToDetailsAppelOffreDTO(domaine.getAppelOffre()));
        dTO.setCodeAppelOffre(domaine.getCodeAppelOffre());

        dTO.setDemandeAchatDTO(DemandeAchatFactory.DetailsdemandeAchatToDetailsDemandeAchatDTO(domaine.getDemandeAchat()));
        dTO.setCodeDemandeAchat(domaine.getCodeDemandeAchat());

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
    
        public static Collection< OrdreAchatDTO> DetailsordreAchatToDetailsOrdreAchatDTOCollection(Collection< OrdreAchat> detailsOrdreAchats) {
        Collection< OrdreAchatDTO> dTOs = new ArrayList<>();
        for ( OrdreAchat rslt : detailsOrdreAchats) {
            dTOs.add(DetailsordreAchatToDetailsOrdreAchatDTO(rslt));
        }
        return dTOs;
    }
}
