/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.dto;

import com.MangmentRessources.MangRess.Achat.domaine.StatuMatiere;
import com.MangmentRessources.MangRess.Achat.domaine.TypeMatiere;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Taxe;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TaxeDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class MatiereDTO {

    private Integer code;

    private String codeSaisie;

    private String designationAr;

    private String designationLt;

    private StatuMatiereDTO statuMatiereDTO;

    private Integer codeStatuMatiere;

    private String userCreate;

    private Date dateCreate;

    private TypeMatiereDTO codeTypeMatiereDTO;

    private Integer typeMatiere;

    private String desigColoris;

    private Integer codeMatieres;
    private String codeSaisieMatiere;
    private String designationArMatiere;
    private String designationLtMatiere;

    private Integer qteMinStock;

    private Integer qteMaxStock;

    private BigDecimal prixAchat;

    private TaxeDTO taxeDTO;

    private Integer codeTaxe;   
    
    private BigDecimal valeurTaxe;


    public MatiereDTO() {
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

    public TypeMatiereDTO getCodeTypeMatiereDTO() {
        return codeTypeMatiereDTO;
    }

    public void setCodeTypeMatiereDTO(TypeMatiereDTO codeTypeMatiereDTO) {
        this.codeTypeMatiereDTO = codeTypeMatiereDTO;
    }

    public Integer getTypeMatiere() {
        return typeMatiere;
    }

    public void setTypeMatiere(Integer typeMatiere) {
        this.typeMatiere = typeMatiere;
    }

    public String getDesigColoris() {
        return desigColoris;
    }

    public void setDesigColoris(String desigColoris) {
        this.desigColoris = desigColoris;
    }

    public void setCodeMatieres(Integer codeMatieres) {
        this.codeMatieres = codeMatieres;
    }

    public void setCodeSaisieMatiere(String codeSaisieMatiere) {
        this.codeSaisieMatiere = codeSaisieMatiere;
    }

    public void setDesignationArMatiere(String designationArMatiere) {
        this.designationArMatiere = designationArMatiere;
    }

    public void setDesignationLtMatiere(String designationLtMatiere) {
        this.designationLtMatiere = designationLtMatiere;
    }

    public Integer getCodeMatieres() {
        return codeMatieres;
    }

    public String getCodeSaisieMatiere() {
        return codeSaisieMatiere;
    }

    public String getDesignationArMatiere() {
        return designationArMatiere;
    }

    public String getDesignationLtMatiere() {
        return designationLtMatiere;
    }

    public Integer getQteMinStock() {
        return qteMinStock;
    }

    public void setQteMinStock(Integer qteMinStock) {
        this.qteMinStock = qteMinStock;
    }

    public Integer getQteMaxStock() {
        return qteMaxStock;
    }

    public void setQteMaxStock(Integer qteMaxStock) {
        this.qteMaxStock = qteMaxStock;
    }

    public StatuMatiereDTO getStatuMatiereDTO() {
        return statuMatiereDTO;
    }

    public void setStatuMatiereDTO(StatuMatiereDTO statuMatiereDTO) {
        this.statuMatiereDTO = statuMatiereDTO;
    }

    public Integer getCodeStatuMatiere() {
        return codeStatuMatiere;
    }

    public void setCodeStatuMatiere(Integer codeStatuMatiere) {
        this.codeStatuMatiere = codeStatuMatiere;
    }

    public BigDecimal getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(BigDecimal prixAchat) {
        this.prixAchat = prixAchat;
    }

    public TaxeDTO getTaxeDTO() {
        return taxeDTO;
    }

    public void setTaxeDTO(TaxeDTO taxeDTO) {
        this.taxeDTO = taxeDTO;
    }

    public Integer getCodeTaxe() {
        return codeTaxe;
    }

    public void setCodeTaxe(Integer codeTaxe) {
        this.codeTaxe = codeTaxe;
    }

    public BigDecimal getValeurTaxe() {
        return valeurTaxe;
    }

    public void setValeurTaxe(BigDecimal valeurTaxe) {
        this.valeurTaxe = valeurTaxe;
    }
 
 
}
