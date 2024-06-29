/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DetailsAppelOffreDTO {
 
    
    private int codeAppelOffre;
    private String codeSaisieAppelOffre;
    @NotNull
    private MatiereDTO codematiere;

    @NotNull
    private ColorisDTO codeColoris;

    @NotNull
    private UniteDTO codeUnite;

    private BigDecimal qteDemander;

    private String usercreate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreate;

    private Integer codeMatieres;
    private String codeSaisieMatiere;
    private String designationArMatiere;
    private String designationLtMatiere;   
    private BigDecimal prixAchat;
    private Integer codeTaxe;


    private Integer codeUnites;
    private String codeSaisieUnites;
    private String designationArUnites;
    private String designationLtUnites;

    private Integer codeColoriss;
    private String codeSaisieColoriss;
    private String designationArColoriss;
    private String designationLtColoriss;
    

    private Integer ordreMatiere;
    
    private Integer codeModeReglement;
    
    @Basic(optional = false)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "date_livraison", nullable = false)
    private LocalDate dateLivraison;
     
    public DetailsAppelOffreDTO() {
    }

    @Override
    public String toString() {
        return "com.MangmentRessources.MangRess.domaine.DetailsAppelOffre[ detailsAppelOffrePK=" + " ]";
    }

    public int getCodeAppelOffre() {
        return codeAppelOffre;
    }

    public void setCodeAppelOffre(int codeAppelOffre) {
        this.codeAppelOffre = codeAppelOffre;
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

    public String getCodeSaisieAppelOffre() {
        return codeSaisieAppelOffre;
    }

    public void setCodeSaisieAppelOffre(String codeSaisieAppelOffre) {
        this.codeSaisieAppelOffre = codeSaisieAppelOffre;
    }

    public BigDecimal getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(BigDecimal prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Integer getCodeTaxe() {
        return codeTaxe;
    }

    public void setCodeTaxe(Integer codeTaxe) {
        this.codeTaxe = codeTaxe;
    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

 
    public Integer getOrdreMatiere() {
        return ordreMatiere;
    }

    public void setOrdreMatiere(Integer ordreMatiere) {
        this.ordreMatiere = ordreMatiere;
    }

    public Integer getCodeModeReglement() {
        return codeModeReglement;
    }

    public void setCodeModeReglement(Integer codeModeReglement) {
        this.codeModeReglement = codeModeReglement;
    }

   

 

 

 
}
