/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.factory;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.TypeTaxe;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TypeTaxeDTO;
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
public class TypeTaxeFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static TypeTaxe createTypeTaxeByCode(int code) {
        TypeTaxe domaine = new TypeTaxe();
        domaine.setCode(code);
        return domaine;
    }

    public static TypeTaxe typeTaxeDTOToTypeTaxe(TypeTaxeDTO Dto, TypeTaxe domaine) {
        if (Dto != null) {
            domaine.setCode(Dto.getCode());
            domaine.setDesignation(Dto.getDesignation());

            return domaine;
        } else {
            return null;
        }
    }

    public static TypeTaxeDTO typeTaxeToTypeTaxeDTO(TypeTaxe domaine) {

        if (domaine != null) {
            TypeTaxeDTO dTO = new TypeTaxeDTO();
            dTO.setCode(domaine.getCode());
            dTO.setDesignation(domaine.getDesignation());
            return dTO;
        } else {
            return null;
        }
    }

    public static List<TypeTaxeDTO> listTypeTaxeToTypeTaxeDTOs(List<TypeTaxe> typeTaxes) {
        List<TypeTaxeDTO> list = new ArrayList<>();
        for (TypeTaxe typeTaxe : typeTaxes) {
            list.add(typeTaxeToTypeTaxeDTO(typeTaxe));
        }
        return list;
    }
}
