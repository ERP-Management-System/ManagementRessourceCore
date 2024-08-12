/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.domaine;

import com.MangmentRessources.MangRess.Achat.domaine.Depot;
import com.MangmentRessources.MangRess.Achat.domaine.EtatReception;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "demande_transfert_matiere", schema = "stock")
public class DemandeTransfertMatiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Code", nullable = false)
    private Integer code;

    @Size(max = 200)
    @Column(name = "code_saisie", length = 200, nullable = false)
    private String codeSaisie;

    @Column(name = "user_Create", nullable = false, length = 255, columnDefinition = "nvarchar(200)")
    private String userCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_Create", nullable = false, columnDefinition = ("datetime default(getdate())"))
    private Date dateCreate;

    @JoinColumn(name = "code_etat_reception", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private EtatReception etatReception;

    @Column(name = "code_etat_reception", updatable = false, insertable = false)
    private Integer codeEtatReception;

    @Column(name = "observation", nullable = false, columnDefinition = "nvarchar(max)")
    private String observation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "demandeTransfertMatiere")
    private Collection<DetailsDemandeTransfertMatiere> detailsDemandeTransfertMatieresCollections;

    @JoinColumn(name = "code_depot", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Depot depot;

    @Column(name = "code_depot", insertable = false, updatable = false)
    private Integer codeDepot;

    @Column(name = "montant_total_ttc", columnDefinition = ("decimal(18,6) "))
    private BigDecimal mntTotalTTC;

    @Column(name = "montant_total_ht", columnDefinition = ("decimal(18,6)"))
    private BigDecimal mntTotalHT;

    @Column(name = "montant_total_taxe", columnDefinition = ("decimal(18,6) "))
    private BigDecimal mntTotalTaxe;

    public DemandeTransfertMatiere() {
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

    public EtatReception getEtatReception() {
        return etatReception;
    }

    public void setEtatReception(EtatReception etatReception) {
        this.etatReception = etatReception;
    }

    public Integer getCodeEtatReception() {
        return codeEtatReception;
    }

    public void setCodeEtatReception(Integer codeEtatReception) {
        this.codeEtatReception = codeEtatReception;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Collection<DetailsDemandeTransfertMatiere> getDetailsDemandeTransfertMatieresCollections() {
        return detailsDemandeTransfertMatieresCollections;
    }

    public void setDetailsDemandeTransfertMatieresCollections(Collection<DetailsDemandeTransfertMatiere> detailsDemandeTransfertMatieresCollections) {
        this.detailsDemandeTransfertMatieresCollections = detailsDemandeTransfertMatieresCollections;
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
