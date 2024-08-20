/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.domaine;

import com.MangmentRessources.MangRess.Achat.domaine.Coloris;
import com.MangmentRessources.MangRess.Achat.domaine.Depot;
import com.MangmentRessources.MangRess.Achat.domaine.Matiere;
import com.MangmentRessources.MangRess.Achat.domaine.OrdreAchat;
import com.MangmentRessources.MangRess.Achat.domaine.Unite;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "stock_dep_matiere", schema = "stock")
public class StockDepMatiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Code", nullable = false)
    private Integer code;

    @Column(name = "code_matiere", insertable = false, updatable = false)
    private Integer codematiere;
    @JoinColumn(name = "code_matiere", referencedColumnName = "Code", nullable = false, updatable = false, insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Matiere matiere;

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

    @Column(name = "prix_unitaire", nullable = false, columnDefinition = "decimal(18,3)")
    private BigDecimal prixUnitaire;

    @Column(name = "qte", nullable = false, columnDefinition = "decimal(18,3)")
    private BigDecimal qteDispo;

    @Column(name = "user_create", nullable = false, columnDefinition = "nvarchar(200)")
    private String usercreate;

    @Basic(optional = false)
    @Column(name = "date_create", nullable = false, columnDefinition = ("datetime default(getdate())"))
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "num_bon_recept", nullable = false, columnDefinition = "nvarchar(200)")
    private String numBonReception;

    @Column(name = "num_piece", nullable = false, columnDefinition = "nvarchar(200)")
    private String numPiece;

    @Column(name = "laize", nullable = false, columnDefinition = "nvarchar(200)")
    private String laize;

    @JoinColumn(name = "code_ordre_achat", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private OrdreAchat ordreAchat;
    @Column(name = "code_ordre_achat", insertable = false, updatable = false)
    private Integer codeOrdreAchat;

    public StockDepMatiere() {
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

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public BigDecimal getQteDispo() {
        return qteDispo;
    }

    public void setQteDispo(BigDecimal qteDispo) {
        this.qteDispo = qteDispo;
    }

    public String getUsercreate() {
        return usercreate;
    }

    public void setUsercreate(String usercreate) {
        this.usercreate = usercreate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getNumBonReception() {
        return numBonReception;
    }

    public void setNumBonReception(String numBonReception) {
        this.numBonReception = numBonReception;
    }

    public String getNumPiece() {
        return numPiece;
    }

    public void setNumPiece(String numPiece) {
        this.numPiece = numPiece;
    }

    public String getLaize() {
        return laize;
    }

    public void setLaize(String laize) {
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

    
}
