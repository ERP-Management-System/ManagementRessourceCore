
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.dto;

import com.MangmentRessources.MangRess.Achat.domaine.NomenclatureArticle;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DetailsNomenclatureArticleDTO {

//    private Integer code;
//    private NomenclatureArticle nomenclatureArticle;
    private Integer codeNomenclatureArticle;

    private Integer codeArticle;

    private Integer codeMatiere;

    private String designationMatiereAr;

    private String designationMatiereLT;
    private String codeSaisieMatiere;

    private String designationColorisAr;

    private String designationColorisLT;

    private String codeSaisieColoris;

    private Integer qtebesoin;
    private String usercreate;

//    private ArticleDTO article;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreate;

    public DetailsNomenclatureArticleDTO() {
    }

//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//
//    public NomenclatureArticle getNomenclatureArticle() {
//        return nomenclatureArticle;
//    }
//
//    public void setNomenclatureArticle(NomenclatureArticle nomenclatureArticle) {
//        this.nomenclatureArticle = nomenclatureArticle;
//    }
    public Integer getCodeNomenclatureArticle() {
        return codeNomenclatureArticle;
    }

    public void setCodeNomenclatureArticle(Integer codeNomenclatureArticle) {
        this.codeNomenclatureArticle = codeNomenclatureArticle;
    }

    public Integer getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(Integer codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public String getDesignationMatiereAr() {
        return designationMatiereAr;
    }

    public void setDesignationMatiereAr(String designationMatiereAr) {
        this.designationMatiereAr = designationMatiereAr;
    }

    public String getDesignationMatiereLT() {
        return designationMatiereLT;
    }

    public void setDesignationMatiereLT(String designationMatiereLT) {
        this.designationMatiereLT = designationMatiereLT;
    }

    public Integer getQtebesoin() {
        return qtebesoin;
    }

    public void setQtebesoin(Integer qtebesoin) {
        this.qtebesoin = qtebesoin;
    }

    public String getUsercreate() {
        return usercreate;
    }

    public void setUsercreate(String usercreate) {
        this.usercreate = usercreate;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Integer getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(Integer codeArticle) {
        this.codeArticle = codeArticle;
    }

    public String getDesignationColorisAr() {
        return designationColorisAr;
    }

    public void setDesignationColorisAr(String designationColorisAr) {
        this.designationColorisAr = designationColorisAr;
    }

    public String getDesignationColorisLT() {
        return designationColorisLT;
    }

    public void setDesignationColorisLT(String designationColorisLT) {
        this.designationColorisLT = designationColorisLT;
    }

    public String getCodeSaisieMatiere() {
        return codeSaisieMatiere;
    }

    public void setCodeSaisieMatiere(String codeSaisieMatiere) {
        this.codeSaisieMatiere = codeSaisieMatiere;
    }

    public String getCodeSaisieColoris() {
        return codeSaisieColoris;
    }

    public void setCodeSaisieColoris(String codeSaisieColoris) {
        this.codeSaisieColoris = codeSaisieColoris;
    }

    
    
}
