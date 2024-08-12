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
//@AllArgsConstructor
public class DetailsOrdreAchatDTO {

    private Integer codeOrdreAchat;

    private OrdreAchatDTO ordreAchatDTO;

    private String codeSaisieOrdreAchat;
    @NotNull
    private MatiereDTO matiereDTO;

    @NotNull
    private ColorisDTO codeColoris;

    @NotNull
    private UniteDTO codeUnite;

    private DepotDTO codeDepot;

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
    
    private Boolean requiredNumPiece;


    private Integer codeUnites;
    private String codeSaisieUnites;
    private String designationArUnites;
    private String designationLtUnites;

    private Integer codeColoriss;
    private String codeSaisieColoriss;
    private String designationArColoriss;
    private String designationLtColoriss;

    private BigDecimal prixAchat;

    private BigDecimal mntTotalTTC;

    private BigDecimal mntTotalHT;

    private BigDecimal mntTotalTaxe;
    private BigDecimal valeurTaxe;
    private Boolean totalementLivred;

    public DetailsOrdreAchatDTO() {
    }

    public DetailsOrdreAchatDTO(Integer codeOrdreAchat, Integer codeMatieres, String codeSaisieMatiere,
            String designationArMatiere, String designationLtMatiere, Integer codeUnites,
            String codeSaisieUnites, String designationArUnites, String designationLtUnites,
            Integer codeColoriss, String codeSaisieColoriss, String designationArColoriss,
            String designationLtColoriss, BigDecimal qteDemander, BigDecimal qteLivrer, BigDecimal prixAchat, BigDecimal valeurTaxe, Boolean requiredNumPiece) {
        this.codeOrdreAchat = codeOrdreAchat;
        this.qteDemander = qteDemander;
        this.qteLivrer = qteLivrer;
        this.codeMatieres = codeMatieres;
        this.codeSaisieMatiere = codeSaisieMatiere;
        this.designationArMatiere = designationArMatiere;
        this.designationLtMatiere = designationLtMatiere;
        this.codeUnites = codeUnites;
        this.codeSaisieUnites = codeSaisieUnites;
        this.designationArUnites = designationArUnites;
        this.designationLtUnites = designationLtUnites;
        this.codeColoriss = codeColoriss;
        this.codeSaisieColoriss = codeSaisieColoriss;
        this.designationArColoriss = designationArColoriss;
        this.designationLtColoriss = designationLtColoriss;
        this.prixAchat = prixAchat;
        this.valeurTaxe = valeurTaxe;
        this.requiredNumPiece = requiredNumPiece;

    }

    public Boolean getRequiredNumPiece() {
        return requiredNumPiece;
    }

    public void setRequiredNumPiece(Boolean requiredNumPiece) {
        this.requiredNumPiece = requiredNumPiece;
    }

    
    public Integer getCodeOrdreAchat() {
        return codeOrdreAchat;
    }

    
    public void setCodeOrdreAchat(Integer codeOrdreAchat) {
        this.codeOrdreAchat = codeOrdreAchat;
    }

    public String getCodeSaisieOrdreAchat() {
        return codeSaisieOrdreAchat;
    }

    public void setCodeSaisieOrdreAchat(String codeSaisieOrdreAchat) {
        this.codeSaisieOrdreAchat = codeSaisieOrdreAchat;
    }

    public MatiereDTO getMatiereDTO() {
        return matiereDTO;
    }

    public void setMatiereDTO(MatiereDTO matiereDTO) {
        this.matiereDTO = matiereDTO;
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

    public DepotDTO getCodeDepot() {
        return codeDepot;
    }

    public void setCodeDepot(DepotDTO codeDepot) {
        this.codeDepot = codeDepot;
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

    public BigDecimal getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(BigDecimal prixAchat) {
        this.prixAchat = prixAchat;
    }

    public BigDecimal getMntTotalTTC() {
        return mntTotalTTC;
    }

    public void setMntTotalTTC(BigDecimal mntTotalTTC) {
        this.mntTotalTTC = mntTotalTTC;
    }

    public BigDecimal getMntTotalHT() {
        return mntTotalHT;
    }

    public void setMntTotalHT(BigDecimal mntTotalHT) {
        this.mntTotalHT = mntTotalHT;
    }

    public BigDecimal getMntTotalTaxe() {
        return mntTotalTaxe;
    }

    public void setMntTotalTaxe(BigDecimal mntTotalTaxe) {
        this.mntTotalTaxe = mntTotalTaxe;
    }

    public BigDecimal getValeurTaxe() {
        return valeurTaxe;
    }

    public void setValeurTaxe(BigDecimal valeurTaxe) {
        this.valeurTaxe = valeurTaxe;
    }

    public OrdreAchatDTO getOrdreAchatDTO() {
        return ordreAchatDTO;
    }

    public void setOrdreAchatDTO(OrdreAchatDTO ordreAchatDTO) {
        this.ordreAchatDTO = ordreAchatDTO;
    }

    public Boolean getTotalementLivred() {
        return totalementLivred;
    }

    public void setTotalementLivred(Boolean totalementLivred) {
        this.totalementLivred = totalementLivred;
    }

    
    
}
