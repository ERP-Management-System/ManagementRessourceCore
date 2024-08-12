/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.dto;

import com.MangmentRessources.MangRess.Achat.domaine.Depot;
import com.MangmentRessources.MangRess.Achat.domaine.EtatReception;
import com.MangmentRessources.MangRess.Achat.dto.DepotDTO;
import com.MangmentRessources.MangRess.Achat.dto.EtatReceptionDTO;
import com.MangmentRessources.MangRess.Stock.domaine.DetailsDemandeTransfertMatiere;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class DemandeTransfertMatiereDTO {

    private Integer code;

    private String codeSaisie;

    private String userCreate;

    private Date dateCreate;

    private EtatReceptionDTO etatReceptionDTO;

    private String designationArEtatReception;

    private String designationLTEtatReception;

    private Integer codeEtatReception;

    private String observation;

    private Collection<DetailsDemandeTransfertMatiereDTO> detailsDemandeTransfertMatiereDTOs;

    private DepotDTO depotDTO;

    private Integer codeDepot;

    private BigDecimal mntTotalTTC;

    private BigDecimal mntTotalHT;

    private BigDecimal mntTotalTaxe;

    private BigDecimal qteTransfert;
    private BigDecimal qteDemander;

    public DemandeTransfertMatiereDTO() {
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

    public Collection<DetailsDemandeTransfertMatiereDTO> getDetailsDemandeTransfertMatiereDTOs() {
        return detailsDemandeTransfertMatiereDTOs;
    }

    public void setDetailsDemandeTransfertMatiereDTOs(Collection<DetailsDemandeTransfertMatiereDTO> detailsDemandeTransfertMatiereDTOs) {
        this.detailsDemandeTransfertMatiereDTOs = detailsDemandeTransfertMatiereDTOs;
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

    public BigDecimal getQteTransfert() {
        return qteTransfert;
    }

    public void setQteTransfert(BigDecimal qteTransfert) {
        this.qteTransfert = qteTransfert;
    }

    public BigDecimal getQteDemander() {
        return qteDemander;
    }

    public void setQteDemander(BigDecimal qteDemander) {
        this.qteDemander = qteDemander;
    }
    
    

}
