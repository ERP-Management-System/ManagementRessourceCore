/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "details_bon_reception", schema = "achat")
public class DetailsBonReception {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected DetailsBonReceptionPK detailsBonReceptionPK;

    private Integer code;

    @MapsId("codeBonReception")
    @JoinColumn(name = "code_bon_reception", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false)
    private BonReception bonReception;

    @Column(name = "code_matiere", insertable = false, updatable = false)
    private Integer codematiere;

    @JoinColumn(name = "code_matiere", referencedColumnName = "Code", nullable = false, insertable = false, updatable = false)
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

    @Column(name = "qte_receptionner")
    private BigDecimal qteReceptionner;

    @Column(name = "laize")
    private BigDecimal laize;

    @Column(name = "user_create", nullable = false, columnDefinition = "nvarchar(200)")
    private String usercreate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_Create", nullable = false, columnDefinition = "datetime default(getdate())")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @JoinColumn(name = "code_depot", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Depot depot;
    @Column(name = "code_depot", insertable = false, updatable = false)
    private Integer codeDepot;

    @Column(name = "prix_unitaire_achat", columnDefinition = ("decimal(18,6) "), nullable = false)
    private BigDecimal prixUnitaireAchat;

    @Column(name = "montant_total_ttc", columnDefinition = ("decimal(18,6)"), nullable = false)
    private BigDecimal mntTotalTTC;

    @Column(name = "montant_total_ht", columnDefinition = ("decimal(18,6)"), nullable = false)
    private BigDecimal mntTotalHT;

    @Column(name = "montant_total_taxe", columnDefinition = ("decimal(18,6)"), nullable = false)
    private BigDecimal mntTotalTaxe;

    @Column(name = "valeur_taxe", columnDefinition = ("decimal(18,2)"), nullable = false)
    private BigDecimal valeurTaxe;

    @JoinColumn(name = "code_fournisseur", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Fournisseur fournisseur;

    @Column(name = "code_fournisseur", updatable = false, insertable = false)
    private Integer codeFournisseur;

    @NotNull
    @Column(name = "ordre_martiere", nullable = false, columnDefinition = "int default 1")
    private Integer ordreMatiere;

    @JoinColumn(name = "code_ordre_achat", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private OrdreAchat ordreAchat;

    @Column(name = "code_ordre_achat", updatable = false, insertable = false)
    private Integer codeOrdreAchat;

    public DetailsBonReception() {
    }

    public DetailsBonReceptionPK getDetailsBonReceptionPK() {
        return detailsBonReceptionPK;
    }

    public void setDetailsBonReceptionPK(DetailsBonReceptionPK detailsBonReceptionPK) {
        this.detailsBonReceptionPK = detailsBonReceptionPK;
    }

    public BonReception getBonReception() {
        return bonReception;
    }

    public void setBonReception(BonReception bonReception) {
        this.bonReception = bonReception;
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

    public BigDecimal getQteReceptionner() {
        return qteReceptionner;
    }

    public void setQteReceptionner(BigDecimal qteReceptionner) {
        this.qteReceptionner = qteReceptionner;
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

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Integer getCodeFournisseur() {
        return codeFournisseur;
    }

    public void setCodeFournisseur(Integer codeFournisseur) {
        this.codeFournisseur = codeFournisseur;
    }

    public Integer getOrdreMatiere() {
        return ordreMatiere;
    }

    public void setOrdreMatiere(Integer ordreMatiere) {
        this.ordreMatiere = ordreMatiere;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BigDecimal getLaize() {
        return laize;
    }

    public void setLaize(BigDecimal laize) {
        this.laize = laize;
    }

    
    
}
