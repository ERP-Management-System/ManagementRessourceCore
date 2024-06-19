/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.dto;

import com.MangmentRessources.MangRess.Achat.domaine.TypeCircuitAchat;
import jakarta.persistence.Column;
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

    
}
