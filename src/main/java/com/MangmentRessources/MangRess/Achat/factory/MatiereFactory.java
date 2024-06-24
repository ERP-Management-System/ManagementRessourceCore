/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.factory;
 
import com.MangmentRessources.MangRess.Achat.domaine.Matiere; 
import com.MangmentRessources.MangRess.Achat.dto.MatiereDTO;  
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

            domaine.setDateCreate(Dto.getDateCreate());
            domaine.setUserCreate(Dto.getUserCreate());
            domaine.setQteMinStock(Dto.getQteMinStock());
            domaine.setQteMaxStock(Dto.getQteMaxStock());  
            domaine.setPrixAchat(Dto.getPrixAchat());        
            domaine.setCodeTaxe(Dto.getCodeTaxe());


            domaine.setCodeStatuMatiere(Dto.getCodeStatuMatiere());
            if (domaine.getCodeStatuMatiere() != null) {
                domaine.setStatuMatiere(StatuMatiereFactory.createStatuArticleByCode(Dto.getCodeStatuMatiere()));

            }

            domaine.setTypeMatiere(Dto.getTypeMatiere());
            if (domaine.getTypeMatiere() != null) {
                domaine.setCodeTypeMatiere(TypeMatiereFactory.createTypeMatiereByCode(Dto.getTypeMatiere()));

            }

            return domaine;
        } else {
            return null;
        }
    }

    public static MatiereDTO matiereToMatiereDTO(Matiere domaine) {

        if (domaine != null) {
            MatiereDTO dTO = new MatiereDTO();
            dTO.setCode(domaine.getCode());

            dTO.setCodeMatieres(domaine.getCode());

            if (LocaleContextHolder.getLocale().getLanguage().equals(new Locale(LANGUAGE_SEC).getLanguage())) {

                dTO.setDesignationAr(domaine.getDesignationAr());
                dTO.setDesignationLt(domaine.getDesignationLt());
                dTO.setDesignationArMatiere(domaine.getDesignationAr());
                dTO.setDesignationLtMatiere(domaine.getDesignationLt());
            } else {
                dTO.setDesignationLt(domaine.getDesignationLt());
                dTO.setDesignationAr(domaine.getDesignationAr());
                dTO.setDesignationLtMatiere(domaine.getDesignationLt());
                dTO.setDesignationArMatiere(domaine.getDesignationAr());
            }
            dTO.setCodeSaisie(domaine.getCodeSaisie());
            dTO.setCodeSaisieMatiere(domaine.getCodeSaisie());     
            dTO.setCodeTaxe(domaine.getCodeTaxe());


            dTO.setDateCreate(domaine.getDateCreate());
            dTO.setUserCreate(domaine.getUserCreate());
            dTO.setQteMinStock(domaine.getQteMinStock());
            dTO.setQteMaxStock(domaine.getQteMaxStock()); 
            dTO.setPrixAchat(domaine.getPrixAchat());


            dTO.setCodeTypeMatiereDTO(TypeMatiereFactory.typeMatiereToTypeMatiereDTO(domaine.getCodeTypeMatiere()));
            dTO.setTypeMatiere(domaine.getTypeMatiere());

            dTO.setStatuMatiereDTO(StatuMatiereFactory.statuArticleToStatuArticleDTO(domaine.getStatuMatiere()));
            dTO.setCodeStatuMatiere(domaine.getCodeStatuMatiere());

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

    public static Collection<MatiereDTO> MatiereToMatiereDTOsCollection(Collection<Matiere> c) {
        List<MatiereDTO> dTOs = new ArrayList<>();
        c.forEach(x -> {
            dTOs.add(matiereToMatiereDTO(x));
        });
        return dTOs;

    }
}
