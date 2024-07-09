/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.dto;

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
public class OrdreAchatDTO {

    private Integer code;

    private String codeSaisie;

    private EtatReceptionDTO etatReceptionDTO;

    private Integer codeEtatReception; 

    private String userCreate;

    private Date dateCreate;

    private Collection<DetailsOrdreAchatDTO> detailsOrdreAchatDTOs;

    private TypeCircuitAchatDTO typeCircuitAchatDTO;

    private Integer codeTypeCircuitAchat;

    private DemandeAchatDTO demandeAchatDTO;

    private Integer codeDemandeAchat;

    private AppelOffreDTO appelOffreDTO;

    private Integer codeAppelOffre; 

    private String observation;

    private BigDecimal mntTotalTTC;

    private BigDecimal mntTotalHT;

    private BigDecimal mntTotalTaxe;

    private BigDecimal mntRemise;
    
        private BigDecimal mntNet;
        

    private BigDecimal mntTimbre;
    @Basic(optional = false)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateLivraison;
    private String lieu;

    private String instruction;

    public OrdreAchatDTO() {
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

    public Collection<DetailsOrdreAchatDTO> getDetailsOrdreAchatDTOs() {
        return detailsOrdreAchatDTOs;
    }

    public void setDetailsOrdreAchatDTOs(Collection<DetailsOrdreAchatDTO> detailsOrdreAchatDTOs) {
        this.detailsOrdreAchatDTOs = detailsOrdreAchatDTOs;
    }

    public TypeCircuitAchatDTO getTypeCircuitAchatDTO() {
        return typeCircuitAchatDTO;
    }

    public void setTypeCircuitAchatDTO(TypeCircuitAchatDTO typeCircuitAchatDTO) {
        this.typeCircuitAchatDTO = typeCircuitAchatDTO;
    }

    public Integer getCodeTypeCircuitAchat() {
        return codeTypeCircuitAchat;
    }

    public void setCodeTypeCircuitAchat(Integer codeTypeCircuitAchat) {
        this.codeTypeCircuitAchat = codeTypeCircuitAchat;
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

 

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
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

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public BigDecimal getMntNet() {
        return mntNet;
    }

    public void setMntNet(BigDecimal mntNet) {
        this.mntNet = mntNet;
    }

}
