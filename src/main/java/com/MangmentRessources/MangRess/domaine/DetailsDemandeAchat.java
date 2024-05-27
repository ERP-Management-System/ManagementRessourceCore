/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.domaine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "details_demande_achat", schema = "achat")
public class DetailsDemandeAchat {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected DetailsDemandeAchatPK detailsDemandeAchatPK;

    @MapsId("codeDemandeAchat")
    @JoinColumn(name = "code_demande_achat", referencedColumnName = "code")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private DemandeAchat demandeAchat;

    @NotNull
    @Column(name = "qte_demander", nullable = false)
    private Integer qteDemander;

    @NotNull
    @Column(name = "qte_livrer", nullable = false)
    private Integer qteLivrer;

    @Column(name = "user_create", nullable = false, columnDefinition = "nvarchar(200)")
    private String usercreate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_Create", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    public DetailsDemandeAchat() {
    }

    public DetailsDemandeAchatPK getDetailsDemandeAchatPK() {
        return detailsDemandeAchatPK;
    }

    public void setDetailsDemandeAchatPK(DetailsDemandeAchatPK detailsDemandeAchatPK) {
        this.detailsDemandeAchatPK = detailsDemandeAchatPK;
    }

    public DemandeAchat getDemandeAchat() {
        return demandeAchat;
    }

    public void setDemandeAchat(DemandeAchat demandeAchat) {
        this.demandeAchat = demandeAchat;
    }

    public Integer getQteDemander() {
        return qteDemander;
    }

    public void setQteDemander(Integer qteDemander) {
        this.qteDemander = qteDemander;
    }

    public Integer getQteLivrer() {
        return qteLivrer;
    }

    public void setQteLivrer(Integer qteLivrer) {
        this.qteLivrer = qteLivrer;
    }

    public String getUsercreate() {
        return usercreate;
    }

    public void setUsercreate(String usercreate) {
        this.usercreate = usercreate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

}
