/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DetailsAppelOffreDTO {

    private Integer codeAppelOffre;

    private Integer codeMatiere;
    private String designationMatiereAr;
    private String designationMatiereLT;
    private String codeSaisieMatiere;

    private Integer codeColoris;
    private String designationColorisAr;
    private String designationColorisLT;
    private String codeSaisieColoris;

    private Integer codeUnite;
    private String designationUniteAr;
    private String designationUniteLT;
    private String codeSaisieUnite;

    private BigDecimal qteDemander;

    private String usercreate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreate;

    public DetailsAppelOffreDTO() {
    }

    public Integer getCodeAppelOffre() {
        return codeAppelOffre;
    }

    public void setCodeAppelOffre(Integer codeAppelOffre) {
        this.codeAppelOffre = codeAppelOffre;
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

    public String getCodeSaisieMatiere() {
        return codeSaisieMatiere;
    }

    public void setCodeSaisieMatiere(String codeSaisieMatiere) {
        this.codeSaisieMatiere = codeSaisieMatiere;
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

    public String getCodeSaisieColoris() {
        return codeSaisieColoris;
    }

    public void setCodeSaisieColoris(String codeSaisieColoris) {
        this.codeSaisieColoris = codeSaisieColoris;
    }

    public String getDesignationUniteAr() {
        return designationUniteAr;
    }

    public void setDesignationUniteAr(String designationUniteAr) {
        this.designationUniteAr = designationUniteAr;
    }

    public String getDesignationUniteLT() {
        return designationUniteLT;
    }

    public void setDesignationUniteLT(String designationUniteLT) {
        this.designationUniteLT = designationUniteLT;
    }

    public String getCodeSaisieUnite() {
        return codeSaisieUnite;
    }

    public void setCodeSaisieUnite(String codeSaisieUnite) {
        this.codeSaisieUnite = codeSaisieUnite;
    }

    public BigDecimal getQteDemander() {
        return qteDemander;
    }

    public void setQteDemander(BigDecimal qteDemander) {
        this.qteDemander = qteDemander;
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

    public Integer getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(Integer codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public Integer getCodeColoris() {
        return codeColoris;
    }

    public void setCodeColoris(Integer codeColoris) {
        this.codeColoris = codeColoris;
    }

    public Integer getCodeUnite() {
        return codeUnite;
    }

    public void setCodeUnite(Integer codeUnite) {
        this.codeUnite = codeUnite;
    }

    
}
