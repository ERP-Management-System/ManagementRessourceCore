/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DetailsDemandeAchatDTO {

    private int codeDemandeAchat;
    private String codeSaisieDemandeAchat;
    @NotNull
    private MatiereDTO codematiere;

    @NotNull
    private ColorisDTO codeColoris;

    @NotNull
    private UniteDTO codeUnite;

    private BigDecimal qteDemander;

    private BigDecimal qteLivrer;

    private String usercreate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreate;

    private Integer codeMatieres;
    private String codeSaisieMatiere;
    private String designationArMatiere;
    private String designationLtMatiere;
//    private BigDecimal prixAchat;
    private Integer codeTaxe;

    private Integer codeUnites;
    private String codeSaisieUnites;
    private String designationArUnites;
    private String designationLtUnites;

    private Integer codeColoriss;
    private String codeSaisieColoriss;
    private String designationArColoriss;
    private String designationLtColoriss;

//    private Integer codeAppelOffre;
//    private Integer codeModeReglement;

    public DetailsDemandeAchatDTO() {
    }

    public int getCodeDemandeAchat() {
        return codeDemandeAchat;
    }

    public void setCodeDemandeAchat(int codeDemandeAchat) {
        this.codeDemandeAchat = codeDemandeAchat;
    }

    public String getCodeSaisieDemandeAchat() {
        return codeSaisieDemandeAchat;
    }

    public void setCodeSaisieDemandeAchat(String codeSaisieDemandeAchat) {
        this.codeSaisieDemandeAchat = codeSaisieDemandeAchat;
    }

    public MatiereDTO getCodematiere() {
        return codematiere;
    }

    public void setCodematiere(MatiereDTO codematiere) {
        this.codematiere = codematiere;
    }

    public ColorisDTO getCodeColoris() {
        return codeColoris;
    }

    public void setCodeColoris(ColorisDTO codeColoris) {
        this.codeColoris = codeColoris;
    }

    public UniteDTO getCodeUnite() {
        return codeUnite;
    }

    public void setCodeUnite(UniteDTO codeUnite) {
        this.codeUnite = codeUnite;
    }

    public BigDecimal getQteDemander() {
        return qteDemander;
    }

    public void setQteDemander(BigDecimal qteDemander) {
        this.qteDemander = qteDemander;
    }

    public BigDecimal getQteLivrer() {
        return qteLivrer;
    }

    public void setQteLivrer(BigDecimal qteLivrer) {
        this.qteLivrer = qteLivrer;
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

    public Integer getCodeMatieres() {
        return codeMatieres;
    }

    public void setCodeMatieres(Integer codeMatieres) {
        this.codeMatieres = codeMatieres;
    }

    public String getCodeSaisieMatiere() {
        return codeSaisieMatiere;
    }

    public void setCodeSaisieMatiere(String codeSaisieMatiere) {
        this.codeSaisieMatiere = codeSaisieMatiere;
    }

    public String getDesignationArMatiere() {
        return designationArMatiere;
    }

    public void setDesignationArMatiere(String designationArMatiere) {
        this.designationArMatiere = designationArMatiere;
    }

    public String getDesignationLtMatiere() {
        return designationLtMatiere;
    }

    public void setDesignationLtMatiere(String designationLtMatiere) {
        this.designationLtMatiere = designationLtMatiere;
    }

    public Integer getCodeUnites() {
        return codeUnites;
    }

    public void setCodeUnites(Integer codeUnites) {
        this.codeUnites = codeUnites;
    }

    public String getCodeSaisieUnites() {
        return codeSaisieUnites;
    }

    public void setCodeSaisieUnites(String codeSaisieUnites) {
        this.codeSaisieUnites = codeSaisieUnites;
    }

    public String getDesignationArUnites() {
        return designationArUnites;
    }

    public void setDesignationArUnites(String designationArUnites) {
        this.designationArUnites = designationArUnites;
    }

    public String getDesignationLtUnites() {
        return designationLtUnites;
    }

    public void setDesignationLtUnites(String designationLtUnites) {
        this.designationLtUnites = designationLtUnites;
    }

    public Integer getCodeColoriss() {
        return codeColoriss;
    }

    public void setCodeColoriss(Integer codeColoriss) {
        this.codeColoriss = codeColoriss;
    }

    public String getCodeSaisieColoriss() {
        return codeSaisieColoriss;
    }

    public void setCodeSaisieColoriss(String codeSaisieColoriss) {
        this.codeSaisieColoriss = codeSaisieColoriss;
    }

    public String getDesignationArColoriss() {
        return designationArColoriss;
    }

    public void setDesignationArColoriss(String designationArColoriss) {
        this.designationArColoriss = designationArColoriss;
    }

    public String getDesignationLtColoriss() {
        return designationLtColoriss;
    }

    public void setDesignationLtColoriss(String designationLtColoriss) {
        this.designationLtColoriss = designationLtColoriss;
    }

//    public BigDecimal getPrixAchat() {
//        return prixAchat;
//    }
//
//    public void setPrixAchat(BigDecimal prixAchat) {
//        this.prixAchat = prixAchat;
//    }

    public Integer getCodeTaxe() {
        return codeTaxe;
    }

    public void setCodeTaxe(Integer codeTaxe) {
        this.codeTaxe = codeTaxe;
    }
//
//    public Integer getCodeAppelOffre() {
//        return codeAppelOffre;
//    }
//
//    public void setCodeAppelOffre(Integer codeAppelOffre) {
//        this.codeAppelOffre = codeAppelOffre;
//    }
//
//    public Integer getCodeModeReglement() {
//        return codeModeReglement;
//    }
//
//    public void setCodeModeReglement(Integer codeModeReglement) {
//        this.codeModeReglement = codeModeReglement;
//    }

}
