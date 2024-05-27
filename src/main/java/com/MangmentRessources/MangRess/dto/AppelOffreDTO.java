/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.dto;

import com.MangmentRessources.MangRess.domaine.EtatReception;
import jakarta.persistence.Column;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class AppelOffreDTO {

    private Integer code;

    private String codeSaisie;

    private String designationAr;

    private String designationLt;
    
    private boolean actif;

    private boolean visible;

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

    public AppelOffreDTO() {
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

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Collection<DetailsAppelOffreDTO> getDetailsAppelOffreDTOs() {
        return detailsAppelOffreDTOs;
    }

    public void setDetailsAppelOffreDTOs(Collection<DetailsAppelOffreDTO> detailsAppelOffreDTOs) {
        this.detailsAppelOffreDTOs = detailsAppelOffreDTOs;
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

}
