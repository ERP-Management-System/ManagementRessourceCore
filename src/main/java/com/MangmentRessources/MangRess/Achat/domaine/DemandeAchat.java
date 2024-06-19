/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "demande_achat", schema = "achat")
public class DemandeAchat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private Integer code;

    @Size(max = 200)
    @Column(name = "code_saisie_demande", length = 200, nullable = false)
    private String codeSaisie;

    @JoinColumn(name = "code_etat_demande", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private EtatDemandeAchat etatDemande;

    @Column(name = "code_etat_demande", updatable = false, insertable = false)
    private Integer codeEtatDemande;

    @JoinColumn(name = "code_type_circuit_achat", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private TypeCircuitAchat typeCircuitAchat;

    @Column(name = "code_type_circuit_achat", updatable = false, insertable = false)
    private Integer codeTypeCircuitAchat;

    @Column(name = "user_Create", nullable = false, length = 255, columnDefinition = "nvarchar")
    private String userCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_Create", nullable = false)
    private Date dateCreate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "demandeAchat", fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<DetailsDemandeAchat> detailsDemandeAchats;

 
    @Column(name = "observation", nullable = false, columnDefinition = "nvarchar(max)")
    private String observation;

    public DemandeAchat() {
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

 
    public EtatDemandeAchat getEtatDemande() {
        return etatDemande;
    }

    public void setEtatDemande(EtatDemandeAchat etatDemande) {
        this.etatDemande = etatDemande;
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

    public Collection<DetailsDemandeAchat> getDetailsDemandeAchats() {
        return detailsDemandeAchats;
    }

    public void setDetailsDemandeAchats(Collection<DetailsDemandeAchat> detailsDemandeAchats) {
        this.detailsDemandeAchats = detailsDemandeAchats;
    }

    public TypeCircuitAchat getTypeCircuitAchat() {
        return typeCircuitAchat;
    }

    public void setTypeCircuitAchat(TypeCircuitAchat typeCircuitAchat) {
        this.typeCircuitAchat = typeCircuitAchat;
    }

    public Integer getCodeTypeCircuitAchat() {
        return codeTypeCircuitAchat;
    }

    public void setCodeTypeCircuitAchat(Integer codeTypeCircuitAchat) {
        this.codeTypeCircuitAchat = codeTypeCircuitAchat;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    
    
}
