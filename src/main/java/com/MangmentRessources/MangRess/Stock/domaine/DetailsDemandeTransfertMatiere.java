/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.domaine;

import com.MangmentRessources.MangRess.Achat.domaine.AppelOffre;
import com.MangmentRessources.MangRess.Achat.domaine.Coloris;
import com.MangmentRessources.MangRess.Achat.domaine.Depot;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsAppelOffrePK;
import com.MangmentRessources.MangRess.Achat.domaine.Matiere;
import com.MangmentRessources.MangRess.Achat.domaine.Unite;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "details_demande_transfert_matiere", schema = "stock")
public class DetailsDemandeTransfertMatiere {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailsDemandeTransfertMatierePK detailsDemandeTransfertMatierePK;

    @MapsId("codeDemandeTransfertMatiere")
    @JoinColumn(name = "Code_Demande_Transfert", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false)
    private DemandeTransfertMatiere demandeTransfertMatiere;

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

    @Column(name = "qte_demander", nullable = false, columnDefinition = "decimal(18,3)")
    private BigDecimal qteDemander;

    @Column(name = "qte_transfert", nullable = false, columnDefinition = "decimal(18,3)")
    private BigDecimal qteTransfert;

    @Column(name = "prix_unitaire", nullable = false, columnDefinition = "decimal(18,3)")
    private BigDecimal prixUnitaire;

    @Column(name = "montant_total_ttc", columnDefinition = ("decimal(18,6) "))
    private BigDecimal mntTotalTTC;

    @Column(name = "montant_total_ht", columnDefinition = ("decimal(18,6)"))
    private BigDecimal mntTotalHT;

    @Column(name = "montant_total_taxe", columnDefinition = ("decimal(18,6) "))
    private BigDecimal mntTotalTaxe;

    @Column(name = "user_create", nullable = false, columnDefinition = "nvarchar(200)")
    private String usercreate;

    @Basic(optional = false)
    @Column(name = "date_create", nullable = false, columnDefinition = ("datetime default(getdate())"))
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "ordre_martiere", nullable = false, columnDefinition = "int default 1")
    private Integer ordreMatiere;

    public DetailsDemandeTransfertMatiere() {
    }

    public DetailsDemandeTransfertMatierePK getDetailsDemandeTransfertMatierePK() {
        return detailsDemandeTransfertMatierePK;
    }

    public void setDetailsDemandeTransfertMatierePK(DetailsDemandeTransfertMatierePK detailsDemandeTransfertMatierePK) {
        this.detailsDemandeTransfertMatierePK = detailsDemandeTransfertMatierePK;
    }

    public DemandeTransfertMatiere getDemandeTransfertMatiere() {
        return demandeTransfertMatiere;
    }

    public void setDemandeTransfertMatiere(DemandeTransfertMatiere demandeTransfertMatiere) {
        this.demandeTransfertMatiere = demandeTransfertMatiere;
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

    public BigDecimal getQteDemander() {
        return qteDemander;
    }

    public void setQteDemander(BigDecimal qteDemander) {
        this.qteDemander = qteDemander;
    }

    public BigDecimal getQteTransfert() {
        return qteTransfert;
    }

    public void setQteTransfert(BigDecimal qteTransfert) {
        this.qteTransfert = qteTransfert;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
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

    public Integer getOrdreMatiere() {
        return ordreMatiere;
    }

    public void setOrdreMatiere(Integer ordreMatiere) {
        this.ordreMatiere = ordreMatiere;
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

}
