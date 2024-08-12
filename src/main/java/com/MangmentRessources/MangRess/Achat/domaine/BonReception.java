/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "bon_reception", schema = "achat")
public class BonReception {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Integer code;

    @Size(max = 200)
    @Column(name = "code_saisie", length = 200, nullable = false)
    private String codeSaisie;

    @JoinColumn(name = "code_etat_reception", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private EtatReception etatReception;

    @Column(name = "code_etat_reception", updatable = false, insertable = false)
    private Integer codeEtatReception;

    @JoinColumn(name = "code_demande_achat", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private DemandeAchat demandeAchat;

    @Column(name = "code_demande_achat", updatable = false, insertable = false)
    private Integer codeDemandeAchat;

    @JoinColumn(name = "code_ordre_achat", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private OrdreAchat ordreAchat;

    @Column(name = "code_ordre_achat", updatable = false, insertable = false)
    private Integer codeOrdreAchat;

    @JoinColumn(name = "code_appel_offre", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private AppelOffre appelOffre;

    @Column(name = "code_appel_offre", updatable = false, insertable = false)
    private Integer codeAppelOffre;

    @Column(name = "user_Create", nullable = false, length = 255, columnDefinition = "nvarchar(200)")
    private String userCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_Create", nullable = false, columnDefinition = "datetime default(getdate())")
    private Date dateCreate;

    @Column(name = "montant_total_ttc", columnDefinition = ("decimal(18,6) "))
    private BigDecimal mntTotalTTC;

    @Column(name = "montant_total_ht", columnDefinition = ("decimal(18,6)"))
    private BigDecimal mntTotalHT;

    @Column(name = "montant_total_taxe", columnDefinition = ("decimal(18,6) "))
    private BigDecimal mntTotalTaxe;

    @Column(name = "total_remise_pourcent", columnDefinition = ("decimal(18,6) "))
    private BigDecimal mntRemise;

    @Column(name = "montant_timbre", columnDefinition = ("decimal(18,6)"))
    private BigDecimal mntTimbre;

    @Column(name = "montant_net", columnDefinition = ("decimal(18,6) "))
    private BigDecimal mntNet;

    @Column(name = "montant_facture_fournisseur", columnDefinition = ("decimal(18,6)"))
    private BigDecimal MntFactureFournisseur;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_facture_fournisseur" , columnDefinition = ("date default getdate()"))
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateFactureFournisseur;

    @Size(max = 200)
    @Column(name = "code_facture_fournisseur", length = 200 , columnDefinition = ("nvarchar(200)"))
    private String codeFactureFournisseur;

    @JoinColumn(name = "code_depot", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Depot depot;

    @Column(name = "code_depot", updatable = false, insertable = false)
    private Integer codeDepot;

    @JoinColumn(name = "code_fournisseur", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Fournisseur fournisseur;

    @Column(name = "code_fournisseur", updatable = false, insertable = false)
    private Integer codeFournisseur;

    @Column(name = "observation", nullable = false, columnDefinition = "nvarchar(max)")
    private String observation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonReception", fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<DetailsBonReception> detailsBonReceptions;

    public BonReception() {
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

    public DemandeAchat getDemandeAchat() {
        return demandeAchat;
    }

    public void setDemandeAchat(DemandeAchat demandeAchat) {
        this.demandeAchat = demandeAchat;
    }

    public Integer getCodeDemandeAchat() {
        return codeDemandeAchat;
    }

    public void setCodeDemandeAchat(Integer codeDemandeAchat) {
        this.codeDemandeAchat = codeDemandeAchat;
    }

    public AppelOffre getAppelOffre() {
        return appelOffre;
    }

    public void setAppelOffre(AppelOffre appelOffre) {
        this.appelOffre = appelOffre;
    }

    public Integer getCodeAppelOffre() {
        return codeAppelOffre;
    }

    public void setCodeAppelOffre(Integer codeAppelOffre) {
        this.codeAppelOffre = codeAppelOffre;
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

    public BigDecimal getMntRemise() {
        return mntRemise;
    }

    public void setMntRemise(BigDecimal mntRemise) {
        this.mntRemise = mntRemise;
    }

    public BigDecimal getMntTimbre() {
        return mntTimbre;
    }

    public void setMntTimbre(BigDecimal mntTimbre) {
        this.mntTimbre = mntTimbre;
    }

    public BigDecimal getMntNet() {
        return mntNet;
    }

    public void setMntNet(BigDecimal mntNet) {
        this.mntNet = mntNet;
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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Collection<DetailsBonReception> getDetailsBonReceptions() {
        return detailsBonReceptions;
    }

    public void setDetailsBonReceptions(Collection<DetailsBonReception> detailsBonReceptions) {
        this.detailsBonReceptions = detailsBonReceptions;
    }

    public BigDecimal getMntFactureFournisseur() {
        return MntFactureFournisseur;
    }

    public void setMntFactureFournisseur(BigDecimal MntFactureFournisseur) {
        this.MntFactureFournisseur = MntFactureFournisseur;
    }

    public LocalDate getDateFactureFournisseur() {
        return dateFactureFournisseur;
    }

    public void setDateFactureFournisseur(LocalDate dateFactureFournisseur) {
        this.dateFactureFournisseur = dateFactureFournisseur;
    }

    public String getCodeFactureFournisseur() {
        return codeFactureFournisseur;
    }

    public void setCodeFactureFournisseur(String codeFactureFournisseur) {
        this.codeFactureFournisseur = codeFactureFournisseur;
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
