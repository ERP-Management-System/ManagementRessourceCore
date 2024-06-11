/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.ModeReglement;
import com.MangmentRessources.MangRess.dto.ModeReglementDTO;
import java.util.ArrayList;
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
public class ModeReglementFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static ModeReglement createModeReglementByCode(int code) {
        ModeReglement domaine = new ModeReglement();
        domaine.setCode(code);
        return domaine;
    }

    public static ModeReglement modeReglementDTOToModeReglement(ModeReglementDTO Dto, ModeReglement domaine) {
        if (Dto != null) {
            domaine.setCode(Dto.getCode());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {
                domaine.setDesignationAr(Dto.getDesignationAr());
                domaine.setDesignationLt(Dto.getDesignationLt());
            } else {
                domaine.setDesignationLt(Dto.getDesignationLt());
                domaine.setDesignationAr(Dto.getDesignationAr());
            }
//            domaine.setCodeSaisie(Dto.getCodeSaisie());
            domaine.setActif(Dto.isActif());
            domaine.setVisible(Dto.isVisible());
            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());

            domaine.setCodeBanque(Dto.getCodeBanque());
            if (Dto.getCodeBanque()!= null) {
                domaine.setBanque(BanqueFactory.createBanqueByCode(Dto.getCodeBanque()));
            }
 
            domaine.setCodeTypeCaisse(Dto.getCodeTypeCaisse());
            if (Dto.getCodeTypeCaisse()!= null) {
                domaine.setTypeCaisse(TypeCaisseFactory.createTypeCaisseByCode(Dto.getCodeTypeCaisse()));
            }
 
            return domaine;
        } else {
            return null;
        }
    }

    public static ModeReglementDTO modeReglementToModeReglementDTO(ModeReglement domaine) {

        if (domaine != null) {
            ModeReglementDTO dTO = new ModeReglementDTO();
            dTO.setCode(domaine.getCode());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {

                dTO.setDesignationAr(domaine.getDesignationAr());
                dTO.setDesignationLt(domaine.getDesignationLt());
            } else {
                dTO.setDesignationLt(domaine.getDesignationLt());
                dTO.setDesignationAr(domaine.getDesignationAr());
            }
            dTO.setCodeSaisie(domaine.getCodeSaisie());
            dTO.setActif(domaine.isActif());
            dTO.setVisible(domaine.isVisible());
            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());

            dTO.setTypeCaisse(TypeCaisseFactory.typeCaisseToTypeCaisseDTO(domaine.getTypeCaisse()));
            dTO.setCodeTypeCaisse(domaine.getCodeTypeCaisse());

            dTO.setBanque(BanqueFactory.banqueToBanqueDTO(domaine.getBanque()));
            dTO.setCodeBanque(domaine.getCodeBanque());

            return dTO;
        } else {
            return null;
        }
    }

    public static List<ModeReglementDTO> listModeReglementToModeReglementDTOs(List<ModeReglement> modeReglements) {
        List<ModeReglementDTO> list = new ArrayList<>();
        for (ModeReglement modeReglement : modeReglements) {
            list.add(modeReglementToModeReglementDTO(modeReglement));
        }
        return list;
    }

}
