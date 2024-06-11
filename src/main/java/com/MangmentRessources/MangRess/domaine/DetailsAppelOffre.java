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
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "details_appel_offre", schema = "achat")
public class DetailsAppelOffre {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailsAppelOffrePK detailsAppelOffrePK;

    @MapsId("codeAppelOffre")
    @JoinColumn(name = "Code_Appel_Offre", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false)
    private AppelOffre appelOffre;

    @Column(name = "code_matiere", insertable = false, updatable = false)
    private Integer codematiere;

//    @JoinColumn(name = "code_matiere", referencedColumnName = "Code", nullable = false)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Matiere matiere;

    @NotNull
    @Column(name = "qte_demander", nullable = false)
    private BigDecimal qteDemander;

    @Column(name = "user_create", nullable = false, columnDefinition = "nvarchar(200)")
    private String usercreate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_Create", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    public DetailsAppelOffre() {
    }

    public DetailsAppelOffrePK getDetailsAppelOffrePK() {
        return detailsAppelOffrePK;
    }

    public void setDetailsAppelOffrePK(DetailsAppelOffrePK detailsAppelOffrePK) {
        this.detailsAppelOffrePK = detailsAppelOffrePK;
    }

    public AppelOffre getAppelOffre() {
        return appelOffre;
    }

    public void setAppelOffre(AppelOffre appelOffre) {
        this.appelOffre = appelOffre;
    }

    public Integer getCodematiere() {
        return codematiere;
    }

    public void setCodematiere(Integer codematiere) {
        this.codematiere = codematiere;
    }

    public BigDecimal getQteDemander() {
        return qteDemander;
    }

    public void setQteDemander(BigDecimal qteDemander) {
        this.qteDemander = qteDemander;
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
