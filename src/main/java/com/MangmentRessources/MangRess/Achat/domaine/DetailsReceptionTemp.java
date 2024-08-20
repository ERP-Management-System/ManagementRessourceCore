/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "details_reception_temp", schema = "achat")
public class DetailsReceptionTemp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Code", nullable = false)
    private Integer code;

    @Column(name = "code_matiere", insertable = false, updatable = false)
    private Integer codematiere;

    @JoinColumn(name = "code_matiere", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Matiere matiere;

    @Column(name = "num_piece", columnDefinition = "varchar(200)")
    private String numPiece;

    @Column(name = "laize")
    private BigDecimal laize;

    @JoinColumn(name = "code_ordre_achat", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private OrdreAchat ordreAchat;

    @Column(name = "code_ordre_achat", updatable = false, insertable = false)
    private Integer codeOrdreAchat;

    @Column(name = "qte_receptionner")
    private BigDecimal qteReceptionner;
    
    
     @JoinColumn(name = "code_coloris", referencedColumnName = "code", nullable = false, updatable = false, insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Coloris coloris;
    @Column(name = "code_coloris", insertable = false, updatable = false)
    private Integer codeColoris;

    @JoinColumn(name = "code_unite", referencedColumnName = "code", nullable = false, updatable = false, insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Unite unite;
    @Column(name = "code_unite", insertable = false, updatable = false)
    private Integer codeUnite;

        @JoinColumn(name = "code_depot", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Depot depot;
    @Column(name = "code_depot", insertable = false, updatable = false)
    private Integer codeDepot;

    @Column(name = "prix_unitaire_achat", columnDefinition = ("decimal(18,3)"), nullable = false)
    private BigDecimal prixUnitaireAchat;
    

    public DetailsReceptionTemp() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCodematiere() {
        return codematiere;
    }

    public void setCodematiere(Integer codematiere) {
        this.codematiere = codematiere;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public String getNumPiece() {
        return numPiece;
    }

    public void setNumPiece(String numPiece) {
        this.numPiece = numPiece;
    }

    public BigDecimal getLaize() {
        return laize;
    }

    public void setLaize(BigDecimal laize) {
        this.laize = laize;
    }

    public OrdreAchat getOrdreAchat() {
        return ordreAchat;
    }

    public void setOrdreAchat(OrdreAchat ordreAchat) {
        this.ordreAchat = ordreAchat;
    }

    public Integer getCodeOrdreAchat() {
        return codeOrdreAchat;
    }

    public void setCodeOrdreAchat(Integer codeOrdreAchat) {
        this.codeOrdreAchat = codeOrdreAchat;
    }

    public BigDecimal getQteReceptionner() {
        return qteReceptionner;
    }

    public void setQteReceptionner(BigDecimal qteReceptionner) {
        this.qteReceptionner = qteReceptionner;
    }

    public Coloris getColoris() {
        return coloris;
    }

    public void setColoris(Coloris coloris) {
        this.coloris = coloris;
    }

    public Integer getCodeColoris() {
        return codeColoris;
    }

    public void setCodeColoris(Integer codeColoris) {
        this.codeColoris = codeColoris;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public Integer getCodeUnite() {
        return codeUnite;
    }

    public void setCodeUnite(Integer codeUnite) {
        this.codeUnite = codeUnite;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Integer getCodeDepot() {
        return codeDepot;
    }

    public void setCodeDepot(Integer codeDepot) {
        this.codeDepot = codeDepot;
    }

    public BigDecimal getPrixUnitaireAchat() {
        return prixUnitaireAchat;
    }

    public void setPrixUnitaireAchat(BigDecimal prixUnitaireAchat) {
        this.prixUnitaireAchat = prixUnitaireAchat;
    }
    
    

}
