/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.dto;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsBonReception;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Basic;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class BonReceptionDTO {

    private Integer code;
    private String codeSaisie;

    private EtatReceptionDTO etatReceptionDTO;

    private Integer codeEtatReception;

    private OrdreAchatDTO ordreAchatDTO;

    private Integer codeOrdreAchat;

    private DemandeAchatDTO demandeAchatDTO;

    private Integer codeDemandeAchat;

    private AppelOffreDTO appelOffreDTO;

    private Integer codeAppelOffre;

    private String userCreate;

    private Date dateCreate;

    private BigDecimal mntTotalTTC;

    private BigDecimal mntTotalHT;

    private BigDecimal mntTotalTaxe;

    private BigDecimal mntRemise;

    private BigDecimal mntTimbre;

    private BigDecimal mntNet;

    private DepotDTO depotDTO;

    private Integer codeDepot;

    private FournisseurDTO fournisseurDTO;

    private Integer codeFournisseur;

    private String observation;

    private Collection<DetailsBonReceptionDTO> detailsBonReceptionDTOs;

    
    
    private Collection<DetailsOrdreAchatDTO> detailsOrdreAchatDTOs;
    
    
    @Basic(optional = false)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateFactureFournisseur;

    private BigDecimal mntFactureFournisseur;
    private String codeFactureFournisseur;

    public BonReceptionDTO() {
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

    public EtatReceptionDTO getEtatReceptionDTO() {
        return etatReceptionDTO;
    }

    public void setEtatReceptionDTO(EtatReceptionDTO etatReceptionDTO) {
        this.etatReceptionDTO = etatReceptionDTO;
    }

    public Integer getCodeEtatReception() {
        return codeEtatReception;
    }

    public void setCodeEtatReception(Integer codeEtatReception) {
        this.codeEtatReception = codeEtatReception;
    }

    public DemandeAchatDTO getDemandeAchatDTO() {
        return demandeAchatDTO;
    }

    public void setDemandeAchatDTO(DemandeAchatDTO demandeAchatDTO) {
        this.demandeAchatDTO = demandeAchatDTO;
    }

    public Integer getCodeDemandeAchat() {
        return codeDemandeAchat;
    }

    public void setCodeDemandeAchat(Integer codeDemandeAchat) {
        this.codeDemandeAchat = codeDemandeAchat;
    }

    public AppelOffreDTO getAppelOffreDTO() {
        return appelOffreDTO;
    }

    public void setAppelOffreDTO(AppelOffreDTO appelOffreDTO) {
        this.appelOffreDTO = appelOffreDTO;
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

    public DepotDTO getDepotDTO() {
        return depotDTO;
    }

    public void setDepotDTO(DepotDTO depotDTO) {
        this.depotDTO = depotDTO;
    }

    public Integer getCodeDepot() {
        return codeDepot;
    }

    public void setCodeDepot(Integer codeDepot) {
        this.codeDepot = codeDepot;
    }

    public FournisseurDTO getFournisseurDTO() {
        return fournisseurDTO;
    }

    public void setFournisseurDTO(FournisseurDTO fournisseurDTO) {
        this.fournisseurDTO = fournisseurDTO;
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

    public Collection<DetailsBonReceptionDTO> getDetailsBonReceptionDTOs() {
        return detailsBonReceptionDTOs;
    }

    
  
    public void setDetailsBonReceptionDTOs(Collection<DetailsBonReceptionDTO> detailsBonReceptionDTOs) {
        this.detailsBonReceptionDTOs = detailsBonReceptionDTOs;
    }

    public LocalDate getDateFactureFournisseur() {
        return dateFactureFournisseur;
    }

    public void setDateFactureFournisseur(LocalDate dateFactureFournisseur) {
        this.dateFactureFournisseur = dateFactureFournisseur;
    }

    public BigDecimal getMntFactureFournisseur() {
        return mntFactureFournisseur;
    }

    public void setMntFactureFournisseur(BigDecimal mntFactureFournisseur) {
        this.mntFactureFournisseur = mntFactureFournisseur;
    }

 
    public String getCodeFactureFournisseur() {
        return codeFactureFournisseur;
    }

    public void setCodeFactureFournisseur(String codeFactureFournisseur) {
        this.codeFactureFournisseur = codeFactureFournisseur;
    }

    public OrdreAchatDTO getOrdreAchatDTO() {
        return ordreAchatDTO;
    }

    public void setOrdreAchatDTO(OrdreAchatDTO ordreAchatDTO) {
        this.ordreAchatDTO = ordreAchatDTO;
    }

    public Integer getCodeOrdreAchat() {
        return codeOrdreAchat;
    }

    public void setCodeOrdreAchat(Integer codeOrdreAchat) {
        this.codeOrdreAchat = codeOrdreAchat;
    }

    public Collection<DetailsOrdreAchatDTO> getDetailsOrdreAchatDTOs() {
        return detailsOrdreAchatDTOs;
    }

    public void setDetailsOrdreAchatDTOs(Collection<DetailsOrdreAchatDTO> detailsOrdreAchatDTOs) {
        this.detailsOrdreAchatDTOs = detailsOrdreAchatDTOs;
    }

    
    
}
