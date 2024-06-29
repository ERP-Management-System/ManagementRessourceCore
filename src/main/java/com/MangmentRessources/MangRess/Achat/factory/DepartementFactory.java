/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.Departement;
import com.MangmentRessources.MangRess.Achat.dto.DepartementDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
public class DepartementFactory {
    
    
      static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static Departement createDepartementByCode(int code) {
        Departement domaine = new Departement();
        domaine.setCode(code);
        return domaine;
    }

    public static Departement departementDTOToDepartement(DepartementDTO Dto, Departement domaine) {
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

            domaine.setDateCreate(new Date());
            domaine.setUserCreate(Dto.getUserCreate());
     

            return domaine;
        } else {
            return null;
        }
    }

    public static DepartementDTO departementToDepartementDTO(Departement domaine) {

        if (domaine != null) {
            DepartementDTO dTO = new DepartementDTO();
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
 

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
 

            return dTO;
        } else {
            return null;
        }
    }

    public static List<DepartementDTO> listDepartementToDepartementDTOs(List<Departement> ds) {
        List<DepartementDTO> list = new ArrayList<>();
        for (Departement departement : ds) {
            list.add(departementToDepartementDTO(departement));
        }
        return list;
    }

    public static Collection<DepartementDTO> listDepartementToDepartementDTOsCollection(Collection<Departement> filiales) {
        List<DepartementDTO> dTOs = new ArrayList<>();
        filiales.forEach(x -> {
            dTOs.add(departementToDepartementDTO(x));
        });
        return dTOs;

    }
}
