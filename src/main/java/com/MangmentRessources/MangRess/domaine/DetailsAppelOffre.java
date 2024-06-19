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

    @Column(name = "code_matiere" , insertable=false, updatable=false)
    private Integer codematiere;
 
    @JoinColumn(name = "code_matiere", referencedColumnName = "Code",nullable = false, insertable=false, updatable=false )
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Matiere matiere;
    
    


    
    
    
    @JoinColumn(name = "code_coloris", referencedColumnName = "code", nullable = false, updatable = false, insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Coloris coloris;
    @Column(name = "code_coloris", insertable = false, updatable = false)
    private Integer codeColoris;
    
    
    @JoinColumn(name = "code_unite", referencedColumnName = "code", nullable = false, updatable = false, insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Unite unite;
    @Column(name = "code_unite", insertable = false, updatable = false)
    private Integer codeUnite;
    
    
    



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

    public Integer getCodematiere() {
        return codematiere;
    }

    public void setCodematiere(Integer codematiere) {
        this.codematiere = codematiere;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public Coloris getColoris() {
        return coloris;
    }

    public void setColoris(Coloris coloris) {
        this.coloris = coloris;
    }

    public Integer getCodeColoris() {
        return codeColoris;
    }

    public void setCodeColoris(Integer codeColoris) {
        this.codeColoris = codeColoris;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public Integer getCodeUnite() {
        return codeUnite;
    }

    public void setCodeUnite(Integer codeUnite) {
        this.codeUnite = codeUnite;
    }

}
