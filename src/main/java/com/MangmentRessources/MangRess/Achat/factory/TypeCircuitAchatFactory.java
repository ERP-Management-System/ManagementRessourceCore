/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.TypeCircuitAchat;
import com.MangmentRessources.MangRess.Achat.domaine.TypeCircuitAchat;
import com.MangmentRessources.MangRess.Achat.dto.TypeCircuitAchatDTO;
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
public class TypeCircuitAchatFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static TypeCircuitAchat createTypeCircuitAchatByCode(int code) {
        TypeCircuitAchat domaine = new TypeCircuitAchat();
        domaine.setCode(code);
        return domaine;
    }

    public static TypeCircuitAchat typeCircuitAchatDTOToTypeCircuitAchat(TypeCircuitAchatDTO Dto, TypeCircuitAchat domaine) {
        if (Dto != null) {
            domaine.setCode(Dto.getCode());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {
                domaine.setDesignationAr(Dto.getDesignationAr());
                domaine.setDesignationLt(Dto.getDesignationLt());
            } else {
                domaine.setDesignationLt(Dto.getDesignationLt());
                domaine.setDesignationAr(Dto.getDesignationAr());
            }
            domaine.setCodeSaisie(Dto.getCodeSaisie());
            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());
            return domaine;
        } else {
            return null;
        }
    }

    public static TypeCircuitAchatDTO typeCircuitAchatToTypeCircuitAchatDTO(TypeCircuitAchat domaine) {

        if (domaine != null) {
            TypeCircuitAchatDTO dTO = new TypeCircuitAchatDTO();
            dTO.setCode(domaine.getCode());

            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {

                dTO.setDesignationAr(domaine.getDesignationAr());
                dTO.setDesignationLt(domaine.getDesignationLt());
            } else {
                dTO.setDesignationLt(domaine.getDesignationLt());
                dTO.setDesignationAr(domaine.getDesignationAr());
            }
            dTO.setCodeSaisie(domaine.getCodeSaisie());
            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());

            return dTO;
        } else {
            return null;
        }
    }

    public static List<TypeCircuitAchatDTO> listTypeCircuitAchatToTypeCircuitAchatDTOs(List<TypeCircuitAchat> typeCircuitAchats) {
        List<TypeCircuitAchatDTO> list = new ArrayList<>();
        for (TypeCircuitAchat typeCircuitAchat : typeCircuitAchats) {
            list.add(typeCircuitAchatToTypeCircuitAchatDTO(typeCircuitAchat));
        }
        return list;
    }
}
