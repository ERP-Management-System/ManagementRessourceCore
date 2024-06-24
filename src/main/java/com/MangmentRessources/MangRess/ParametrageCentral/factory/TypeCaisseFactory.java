/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.factory;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.TypeCaisse;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TypeCaisseDTO;
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
public class TypeCaisseFactory {
    
    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static TypeCaisse createTypeCaisseByCode(int code) {
        TypeCaisse domaine = new TypeCaisse();
        domaine.setCode(code);
        return domaine;
    }

    public static TypeCaisse typeCaisseDTOToTypeCaisse(TypeCaisseDTO Dto, TypeCaisse domaine) {
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
            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());
            return domaine;
        } else {
            return null;
        }
    }

    public static TypeCaisseDTO typeCaisseToTypeCaisseDTO(TypeCaisse domaine) {

        if (domaine != null) {
            TypeCaisseDTO dTO = new TypeCaisseDTO();
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

    public static List<TypeCaisseDTO> listTypeCaisseToTypeCaisseDTOs(List<TypeCaisse> typeCaisses) {
        List<TypeCaisseDTO> list = new ArrayList<>();
        for (TypeCaisse typeCaisse : typeCaisses) {
            list.add(typeCaisseToTypeCaisseDTO(typeCaisse));
        }
        return list;
    }
}
