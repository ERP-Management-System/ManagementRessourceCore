/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.factory;

import com.MangmentRessources.MangRess.Achat.domaine.Depot;
import com.MangmentRessources.MangRess.Achat.dto.DepotDTO;
import static com.MangmentRessources.MangRess.Achat.factory.DepotFactory.depotToDepotDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Taxe;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TaxeDTO;
import static com.MangmentRessources.MangRess.ParametrageCentral.factory.ModeReglementFactory.LANGUAGE_SEC;
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
public class TaxeFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static Taxe createTaxeByCode(int code) {
        Taxe domaine = new Taxe();
        domaine.setCode(code);
        return domaine;
    }

    public static Taxe taxeDTOToTaxe(TaxeDTO Dto, Taxe domaine) {
        if (Dto != null) {
            domaine.setCode(Dto.getCode());
            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {
                domaine.setDesignationAr(Dto.getDesignationAr());
                domaine.setDesignationLt(Dto.getDesignationLt());
            } else {
                domaine.setDesignationLt(Dto.getDesignationLt());
                domaine.setDesignationAr(Dto.getDesignationAr());
            }
            domaine.setCodeTypeTaxe(Dto.getCodeTypeTaxe());
            if (Dto.getCodeTypeTaxe() != null) {
                domaine.setTypeTaxe(TypeTaxeFactory.createTypeTaxeByCode(Dto.getCodeTypeTaxe()));
            }
            domaine.setDateCreate(new Date());
            domaine.setUserCreate(Dto.getUserCreate());  
            domaine.setValeurTaxe(Dto.getValeurTaxe());  
            domaine.setCodeSaisie(Dto.getCodeSaisie());


            return domaine;
        } else {
            return null;
        }
    }

    public static TaxeDTO taxeToTaxeDTO(Taxe domaine) {

        if (domaine != null) {
            TaxeDTO dTO = new TaxeDTO();
            dTO.setCode(domaine.getCode());
             
            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());

            dTO.setTypeTaxeDTO(TypeTaxeFactory.typeTaxeToTypeTaxeDTO(domaine.getTypeTaxe()));
            dTO.setCodeTypeTaxe(domaine.getCodeTypeTaxe());  
            dTO.setValeurTaxe(domaine.getValeurTaxe());        
            dTO.setDesignationAr(domaine.getDesignationAr());
            dTO.setDesignationLt(domaine.getDesignationLt());     
            dTO.setCodeSaisie(domaine.getCodeSaisie());




            return dTO;
        } else {
            return null;
        }
    }

    public static List<TaxeDTO> listTaxeToTaxeDTOs(List<Taxe> taxes) {
        List<TaxeDTO> list = new ArrayList<>();
        for (Taxe taxe : taxes) {
            list.add(taxeToTaxeDTO(taxe));
        }
        return list;
    }
    
     public static Collection<TaxeDTO> listTaxeToTaxeDTOsCollection(Collection<Taxe> collection) {
        List<TaxeDTO> dTOs = new ArrayList<>();
        collection.forEach(x -> {
            dTOs.add(taxeToTaxeDTO(x));
        });
        return dTOs;

    }
}
