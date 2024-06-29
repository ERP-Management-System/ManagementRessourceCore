/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;

import com.MangmentRessources.MangRess.Achat.domaine.Depot;
import com.MangmentRessources.MangRess.Achat.dto.DepotDTO;
import java.time.LocalDate;
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
public class DepotFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static Depot createDepotByCode(int code) {
        Depot domaine = new Depot();
        domaine.setCode(code);
        return domaine;
    }

    public static Depot depotDTOToDepot(DepotDTO Dto, Depot domaine) {
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
            domaine.setPrincipal(Dto.isPrincipal());

            domaine.setDateCreate(new Date());
            domaine.setUserCreate(Dto.getUserCreate());
            domaine.setCodeCategorieDepot(Dto.getCodeCategorieDepot());
            if (domaine.getCodeCategorieDepot() != null) {
                domaine.setCategorieDepot(CategorieDepotFactory.createCategorieDepotByCode(Dto.getCodeCategorieDepot()));

            }

            domaine.setCodeDepartement(Dto.getCodeDepartement());
            if (domaine.getCodeDepartement() != null) {
                domaine.setDepartmenet(DepartementFactory.createDepartementByCode(Dto.getCodeDepartement()));

            }

            return domaine;
        } else {
            return null;
        }
    }

    public static DepotDTO depotToDepotDTO(Depot domaine) {

        if (domaine != null) {
            DepotDTO dTO = new DepotDTO();
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
            dTO.setPrincipal(domaine.isPrincipal());

            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setCategorieDepotDTO(CategorieDepotFactory.categorieDepotToCategorieDepotDTO(domaine.getCategorieDepot()));
            dTO.setCodeCategorieDepot(domaine.getCodeCategorieDepot());

            dTO.setDepartmenetDTO(DepartementFactory.departementToDepartementDTO(domaine.getDepartmenet()));
            dTO.setCodeDepartement(domaine.getCodeDepartement());

            return dTO;
        } else {
            return null;
        }
    }

    public static List<DepotDTO> listDepotToDepotDTOs(List<Depot> ds) {
        List<DepotDTO> list = new ArrayList<>();
        for (Depot depot : ds) {
            list.add(depotToDepotDTO(depot));
        }
        return list;
    }

    public static Collection<DepotDTO> listDepotToDepotDTOsCollection(Collection<Depot> filiales) {
        List<DepotDTO> dTOs = new ArrayList<>();
        filiales.forEach(x -> {
            dTOs.add(depotToDepotDTO(x));
        });
        return dTOs;

    }
}
