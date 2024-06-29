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
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DemandeAchatDTO {

    private Integer code;

    private String codeSaisie;

    private EtatDemandeAchatDTO etatDemandeAchatDTO;

    private Integer codeEtatDemande;

//    private AppelOffreDTO appelOffreDTO;
//    private Integer codeAppelOffre;
    private String designationArEtat;
    private String designationLTEtat;

    private String userCreate;

    private Date dateCreate;

    private Collection<DetailsDemandeAchatDTO> detailsDemandeAchatDTOs;

    private TypeCircuitAchatDTO typeCircuitAchatDTO;

    private Integer codeTypeCircuitAchat;

    private String designationArTypeCircuitAchat;

    private String designationLTTypeCircuitAchat;

    private String observation;

//    private BigDecimal  mntTotalTTC;
//
//    private BigDecimal mntTotalHT;
//
//    private BigDecimal mntTotalTaxe;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateLivraison;

    private DepartementDTO departementDTO;
    private Integer codeDepartement;
    
    
    private DepotDTO depotDTO;
    private Integer codeDepot;
    
    
            private EtatApprouverDTO etatApprouverDTO;
 
    private Integer codeEtatApprouver;
    

    public DemandeAchatDTO() {
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

    public String getDesignationArEtat() {
        return designationArEtat;
    }

    public void setDesignationArEtat(String designationArEtat) {
        this.designationArEtat = designationArEtat;
    }

    public String getDesignationLTEtat() {
        return designationLTEtat;
    }

    public void setDesignationLTEtat(String designationLTEtat) {
        this.designationLTEtat = designationLTEtat;
    }

    public EtatDemandeAchatDTO getEtatDemandeAchatDTO() {
        return etatDemandeAchatDTO;
    }

    public void setEtatDemandeAchatDTO(EtatDemandeAchatDTO etatDemandeAchatDTO) {
        this.etatDemandeAchatDTO = etatDemandeAchatDTO;
    }

    public Integer getCodeEtatDemande() {
        return codeEtatDemande;
    }

    public void setCodeEtatDemande(Integer codeEtatDemande) {
        this.codeEtatDemande = codeEtatDemande;
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

    public Collection<DetailsDemandeAchatDTO> getDetailsDemandeAchatDTOs() {
        return detailsDemandeAchatDTOs;
    }

    public void setDetailsDemandeAchatDTOs(Collection<DetailsDemandeAchatDTO> detailsDemandeAchatDTOs) {
        this.detailsDemandeAchatDTOs = detailsDemandeAchatDTOs;
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

    public String getDesignationArTypeCircuitAchat() {
        return designationArTypeCircuitAchat;
    }

    public void setDesignationArTypeCircuitAchat(String designationArTypeCircuitAchat) {
        this.designationArTypeCircuitAchat = designationArTypeCircuitAchat;
    }

    public String getDesignationLTTypeCircuitAchat() {
        return designationLTTypeCircuitAchat;
    }

    public void setDesignationLTTypeCircuitAchat(String designationLTTypeCircuitAchat) {
        this.designationLTTypeCircuitAchat = designationLTTypeCircuitAchat;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
//
//    public AppelOffreDTO getAppelOffreDTO() {
//        return appelOffreDTO;
//    }
//
//    public void setAppelOffreDTO(AppelOffreDTO appelOffreDTO) {
//        this.appelOffreDTO = appelOffreDTO;
//    }
//
//    public Integer getCodeAppelOffre() {
//        return codeAppelOffre;
//    }
//
//    public void setCodeAppelOffre(Integer codeAppelOffre) {
//        this.codeAppelOffre = codeAppelOffre;
//    }
//
//    public BigDecimal getMntTotalTTC() {
//        return mntTotalTTC;
//    }
//
//    public void setMntTotalTTC(BigDecimal mntTotalTTC) {
//        this.mntTotalTTC = mntTotalTTC;
//    }
//
//    public BigDecimal getMntTotalHT() {
//        return mntTotalHT;
//    }
//
//    public void setMntTotalHT(BigDecimal mntTotalHT) {
//        this.mntTotalHT = mntTotalHT;
//    }
//
//    public BigDecimal getMntTotalTaxe() {
//        return mntTotalTaxe;
//    }
//
//    public void setMntTotalTaxe(BigDecimal mntTotalTaxe) {
//        this.mntTotalTaxe = mntTotalTaxe;
//    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public DepartementDTO getDepartementDTO() {
        return departementDTO;
    }

    public void setDepartementDTO(DepartementDTO departementDTO) {
        this.departementDTO = departementDTO;
    }

    public Integer getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(Integer codeDepartement) {
        this.codeDepartement = codeDepartement;
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

    public EtatApprouverDTO getEtatApprouverDTO() {
        return etatApprouverDTO;
    }

    public void setEtatApprouverDTO(EtatApprouverDTO etatApprouverDTO) {
        this.etatApprouverDTO = etatApprouverDTO;
    }

    public Integer getCodeEtatApprouver() {
        return codeEtatApprouver;
    }

    public void setCodeEtatApprouver(Integer codeEtatApprouver) {
        this.codeEtatApprouver = codeEtatApprouver;
    }

 

}
