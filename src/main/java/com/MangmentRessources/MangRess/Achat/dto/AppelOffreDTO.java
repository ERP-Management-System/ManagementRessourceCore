/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.dto;

import com.MangmentRessources.MangRess.ParametrageCentral.dto.ModeReglementDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDate;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class AppelOffreDTO {

    private Integer code;

    private Integer codeAppel;

    private String codeSaisie;

    private String designationAr;

    private String designationLt;

    private String userCreate;

    private Date dateCreate;

    private ModeReglementDTO modeReglementDTO;

    private Integer codeModeReglement;

    private FournisseurDTO fournisseurDTO;

    private Integer codeFournisseur;

    private Collection<DetailsAppelOffreDTO> detailsAppelOffreDTOs;

    private EtatReceptionDTO etatReceptionDTO;

    private String designationArEtatReception;

    private String designationLTEtatReception;

    private Integer codeEtatReception;

    private String observation;

    private String adressLivraison;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateLivraison;

//        private EtatApprouverDTO etatApprouverOrdreAchatDTO;
// 
//    private Integer codeEtatApprouverOrdreAchat;
    private DemandeAchatDTO demandeAchatDTO;

    private Integer codeDemandeAchat;
    
        private Boolean hasOrdreAchat;
        

    public AppelOffreDTO() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCodeAppel() {
        return codeAppel;
    }

    public void setCodeAppel(Integer codeAppel) {
        this.codeAppel = codeAppel;
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

    public ModeReglementDTO getModeReglementDTO() {
        return modeReglementDTO;
    }

    public void setModeReglementDTO(ModeReglementDTO modeReglementDTO) {
        this.modeReglementDTO = modeReglementDTO;
    }

    public Integer getCodeModeReglement() {
        return codeModeReglement;
    }

    public void setCodeModeReglement(Integer codeModeReglement) {
        this.codeModeReglement = codeModeReglement;
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

    public Collection<DetailsAppelOffreDTO> getDetailsAppelOffreDTOs() {
        return detailsAppelOffreDTOs;
    }

    public void setDetailsAppelOffreDTOs(Collection<DetailsAppelOffreDTO> detailsAppelOffreDTOs) {
        this.detailsAppelOffreDTOs = detailsAppelOffreDTOs;
    }

    public EtatReceptionDTO getEtatReceptionDTO() {
        return etatReceptionDTO;
    }

    public void setEtatReceptionDTO(EtatReceptionDTO etatReceptionDTO) {
        this.etatReceptionDTO = etatReceptionDTO;
    }

    public String getDesignationArEtatReception() {
        return designationArEtatReception;
    }

    public void setDesignationArEtatReception(String designationArEtatReception) {
        this.designationArEtatReception = designationArEtatReception;
    }

    public String getDesignationLTEtatReception() {
        return designationLTEtatReception;
    }

    public void setDesignationLTEtatReception(String designationLTEtatReception) {
        this.designationLTEtatReception = designationLTEtatReception;
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

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

//    public EtatApprouverDTO getEtatApprouverOrdreAchatDTO() {
//        return etatApprouverOrdreAchatDTO;
//    }
//
//    public void setEtatApprouverOrdreAchatDTO(EtatApprouverDTO etatApprouverOrdreAchatDTO) {
//        this.etatApprouverOrdreAchatDTO = etatApprouverOrdreAchatDTO;
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

    public Boolean getHasOrdreAchat() {
        return hasOrdreAchat;
    }

    public void setHasOrdreAchat(Boolean hasOrdreAchat) {
        this.hasOrdreAchat = hasOrdreAchat;
    }

    
    
}
