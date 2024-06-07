/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.factory;

import com.MangmentRessources.MangRess.domaine.Matiere;
import com.MangmentRessources.MangRess.dto.AoDTO;
import com.MangmentRessources.MangRess.dto.MatiereDTO;
import com.MangmentRessources.MangRess.dto.TypeMatiereDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import java.util.Locale;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class MatiereFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static Matiere createMatiereByCode(int code) {
        Matiere domaine = new Matiere();
        domaine.setCode(code);
        return domaine;
    }

    public static Matiere matiereDTOToMatiere(MatiereDTO Dto, Matiere domaine) {
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

    public static MatiereDTO matiereToMatiereDTO(Matiere domaine) {

        if (domaine != null) {
            MatiereDTO dTO = new MatiereDTO();
            dTO.setCode(domaine.getCode());
            //            System.out.println("jihennn  " + LocaleContextHolder.getLocale().getLanguage());
            //            System.out.println("jihennn  " + new Locale(LANGUAGE_SEC).getLanguage());
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

            dTO.setDesigColoris("");
            dTO.setCodeTypeMatiereDTO(TypeMatiereFactory.typeMatiereToTypeMatiereDTO(domaine.getCodeTypeMatiere()));
            dTO.setTypeMatiere(domaine.getTypeMatiere());

            return dTO;
        } else {
            return null;
        }
    }

    public static AoDTO matiereToMatiereDTOAO(Matiere domaine) {

        if (domaine != null) {
            AoDTO dTO = new AoDTO();
            dTO.setCode(domaine.getCode());    
            dTO.setDesignation(domaine.getDesignationAr());
            dTO.setColoris("");
            dTO.setQuantite("");
            dTO.setUnite("");

            return dTO;
        } else {
            return null;
        }
    }

    public static List<MatiereDTO> listMatiereToMatiereDTOs(List<Matiere> domaines) {
        List<MatiereDTO> list = new ArrayList<>();
        for (Matiere matiere : domaines) {
            list.add(matiereToMatiereDTO(matiere));
        }
        return list;
    }
}
