/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.parametrageCentral.factory;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.param;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.paramDTO; 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List; 
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class paramFactory {

    static String LANGUAGE_SEC;

    @Value("${lang.secondary}")
    public void setLanguage(String db) {
        LANGUAGE_SEC = db;
    }

    public static param createparamByCode(Integer code) {
        param domaine = new param();
        domaine.setCode(code);
        return domaine;
    }

    public static param paramDTOToparam(paramDTO Dto, param domaine) {
        if (Dto != null) { 
            domaine.setValeur(Dto.getValeur());    
            domaine.setVisible(Dto.getVisible());   
            return domaine;
        } else {
            return null;
        }
    }

    public static paramDTO paramToparamDTO(param domaine) {

        if (domaine != null) {
            paramDTO dTO = new paramDTO();
            dTO.setVisible(domaine.getVisible());
            dTO.setValeur(domaine.getValeur());

            return dTO;
        } else {
            return null;
        }
    }

    public static Collection<paramDTO> CollectionparamToparamDTOs(Collection<param> params) {
        Collection<paramDTO> collection = new ArrayList<>();
        for (param param : params) {
            collection.add(paramToparamDTO(param));
        }
        return collection;
    }
}
