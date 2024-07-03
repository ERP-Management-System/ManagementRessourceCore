/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.factory;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Societe;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.SocieteDTO;
import java.util.ArrayList;
import java.util.Collection;
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
public class SocieteFactory {
     static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }
    
    public static SocieteDTO societeToSocieteDTO(Societe societe ,Boolean withoutLogo) {
        SocieteDTO societeDTO = new SocieteDTO();
        societeDTO.setCode(societe.getCode());
        if (!Boolean.TRUE.equals(withoutLogo)) {
            societeDTO.setLogo(societe.getLogo()); 
        } 
            societeDTO.setNomSociete(societe.getNomSociete()); 
         
        
        return societeDTO;
    }

    public static Societe societeDTOToSociete(SocieteDTO societeDTO) {
        Societe societe = new Societe();
        societe.setCode(societeDTO.getCode());
        societe.setLogo(societeDTO.getLogo()); 
            societe.setNomSociete(societeDTO.getNomSociete());
        
        return societe;
    }

    public static Collection<SocieteDTO> societeToSocieteDTOs(Collection<Societe> societes) {
        List<SocieteDTO> societesDTO = new ArrayList<>();
        societes.forEach(x -> {
            societesDTO.add(societeToSocieteDTO(x,false));
        });
        return societesDTO;
    }
}
