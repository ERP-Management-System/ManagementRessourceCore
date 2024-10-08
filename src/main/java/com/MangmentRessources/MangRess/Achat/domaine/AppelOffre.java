/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.ModeReglement;
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
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "appel_offre", schema = "achat")

public class AppelOffre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Code", nullable = false)
    private Integer code;

    @Size(max = 200)
    @Column(name = "code_saisie", length = 200, nullable = false)
    private String codeSaisie;

    @Size(max = 200)
    @Column(name = "designation_ar", length = 200, nullable = false, columnDefinition = "nvarchar(200)")
    private String designationAr;

    @Size(max = 200)
    @Column(name = "designation_lt", length = 200, nullable = false, columnDefinition = "nvarchar(200)")
    private String designationLt;

    @Column(name = "user_Create", nullable = false, length = 255, columnDefinition = "nvarchar(200)")
    private String userCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_Create", nullable = false)
    private Date dateCreate;

    @Basic(optional = false)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "date_livraison", nullable = false)
    private LocalDate dateLivraison;

    @JoinColumn(name = "code_mode_reglement", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private ModeReglement modeReglement;

    @Column(name = "code_mode_reglement", updatable = false, insertable = false)
    private Integer codeModeReglement;

    @JoinColumn(name = "code_fournisseur", referencedColumnName = "Code", nullable = true)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Fournisseur fournisseur;

    @Column(name = "code_fournisseur", updatable = false, insertable = false)
    private Integer codeFournisseur;

    @JoinColumn(name = "code_etat_reception", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private EtatReception etatReception;

    @Column(name = "code_etat_reception", updatable = false, insertable = false)
    private Integer codeEtatReception;

    @Column(name = "observation", nullable = false, columnDefinition = "nvarchar(max)")
    private String observation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appelOffre", orphanRemoval = true)
    private Collection<DetailsAppelOffre> detailsAppelOffresCollections;

//    @JoinColumn(name = "etat_approuver", referencedColumnName = "code", nullable = false)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JsonBackReference
//    private EtatApprouver etatApprouverOrdreAchat;
//
//    @Column(name = "etat_approuver", updatable = false, insertable = false)
//    private Integer codeEtatApprouverOrdreAchat;
    @Column(name = "adress_livraison", nullable = false, columnDefinition = "nvarchar(200) ")
    private String adressLivraison;

    @JoinColumn(name = "code_demande_achat", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private DemandeAchat demandeAchat;

    @Column(name = "code_demande_achat", updatable = false, insertable = false)
    private Integer codeDemandeAchat;

    @Column(name = "ordre_achat", nullable = false, columnDefinition = ("bit default 0"))
    private Boolean hasOrdreAchat;

    public AppelOffre() {
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

    public ModeReglement getModeReglement() {
        return modeReglement;
    }

    public void setModeReglement(ModeReglement modeReglement) {
        this.modeReglement = modeReglement;
    }

    public Integer getCodeModeReglement() {
        return codeModeReglement;
    }

    public void setCodeModeReglement(Integer codeModeReglement) {
        this.codeModeReglement = codeModeReglement;
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
//
//    public Article getArticle() {
//        return article;
//    }
//
//    public void setArticle(Article article) {
//        this.article = article;
//    }
//
//    public Integer getCodeArticle() {
//        return codeArticle;
//    }
//
//    public void setCodeArticle(Integer codeArticle) {
//        this.codeArticle = codeArticle;
//    }

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

    public Collection<DetailsAppelOffre> getDetailsAppelOffresCollections() {
        return detailsAppelOffresCollections;
    }

    public void setDetailsAppelOffresCollections(Collection<DetailsAppelOffre> detailsAppelOffresCollections) {
        this.detailsAppelOffresCollections = detailsAppelOffresCollections;
    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

//    public EtatApprouver getEtatApprouverOrdreAchat() {
//        return etatApprouverOrdreAchat;
//    }
//
//    public void setEtatApprouverOrdreAchat(EtatApprouver etatApprouverOrdreAchat) {
//        this.etatApprouverOrdreAchat = etatApprouverOrdreAchat;
//    }
//
//    public Integer getCodeEtatApprouverOrdreAchat() {
//        return codeEtatApprouverOrdreAchat;
//    }
//
//    public void setCodeEtatApprouverOrdreAchat(Integer codeEtatApprouverOrdreAchat) {
//        this.codeEtatApprouverOrdreAchat = codeEtatApprouverOrdreAchat;
//    }
    public String getAdressLivraison() {
        return adressLivraison;
    }

    public void setAdressLivraison(String adressLivraison) {
        this.adressLivraison = adressLivraison;
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

    public Boolean getHasOrdreAchat() {
        return hasOrdreAchat;
    }

    public void setHasOrdreAchat(Boolean hasOrdreAchat) {
        this.hasOrdreAchat = hasOrdreAchat;
    }

}
