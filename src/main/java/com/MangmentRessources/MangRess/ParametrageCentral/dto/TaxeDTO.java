/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.dto;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.TypeTaxe;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class TaxeDTO {

    private Integer code;

    private String codeSaisie;

    private String designationAr;

    private String designationLt;

    private TypeTaxeDTO typeTaxeDTO;

    private Integer codeTypeTaxe;

    private String userCreate;

    private Date dateCreate;

    private Integer valeurTaxe;

    public TaxeDTO() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeSaisie() {
        return codeSaisie;
    }

    public void setCodeSaisie(String codeSaisie) {
        this.codeSaisie = codeSaisie;
    }

    public String getDesignationAr() {
        return designationAr;
    }

    public void setDesignationAr(String designationAr) {
        this.designationAr = designationAr;
    }

    public String getDesignationLt() {
        return designationLt;
    }

    public void setDesignationLt(String designationLt) {
        this.designationLt = designationLt;
    }

    public TypeTaxeDTO getTypeTaxeDTO() {
        return typeTaxeDTO;
    }

    public void setTypeTaxeDTO(TypeTaxeDTO typeTaxeDTO) {
        this.typeTaxeDTO = typeTaxeDTO;
    }

    public Integer getCodeTypeTaxe() {
        return codeTypeTaxe;
    }

    public void setCodeTypeTaxe(Integer codeTypeTaxe) {
        this.codeTypeTaxe = codeTypeTaxe;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getValeurTaxe() {
        return valeurTaxe;
    }

    public void setValeurTaxe(Integer valeurTaxe) {
        this.valeurTaxe = valeurTaxe;
    }

}
