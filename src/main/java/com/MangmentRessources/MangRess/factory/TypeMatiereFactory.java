/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.TypeMatiere;
import com.MangmentRessources.MangRess.dto.TypeMatiereDTO;
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
public class TypeMatiereFactory {
    
    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static TypeMatiere createTypeMatiereByCode(int code) {
        TypeMatiere domaine = new TypeMatiere();
        domaine.setCode(code);
        return domaine;
    }

    public static TypeMatiere typeMatiereDTOToTypeMatiere(TypeMatiereDTO Dto, TypeMatiere domaine) {
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
            domaine.setActif(Dto.isActif());
            domaine.setVisible(Dto.isVisible());
//            if (adherantDTO.getLienParentale() != null) {
//                adherant.setCodeLienParental(adherantDTO.getLienParentale().getCode());
//            } else {
//                adherant.setCodeLienParental(null);
//            } 
            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());
            return domaine;
        } else {
            return null;
        }
    }

    public static TypeMatiereDTO typeMatiereToTypeMatiereDTO(TypeMatiere domaine) {

        if (domaine != null) {
            TypeMatiereDTO dTO = new TypeMatiereDTO();
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

            return dTO;
        } else {
            return null;
        }
    }

    public static List<TypeMatiereDTO> listTypeMatiereToTypeMatiereDTOs(List<TypeMatiere> typeMatieres) {
        List<TypeMatiereDTO> list = new ArrayList<>();
        for (TypeMatiere typeMatiere : typeMatieres) {
            list.add(typeMatiereToTypeMatiereDTO(typeMatiere));
        }
        return list;
    }
    
}
