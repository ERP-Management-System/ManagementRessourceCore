/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

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
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "details_ordre_achat", schema = "achat")
public class DetailsOrdreAchat {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailsOrdreAchatPK detailsOrdreAchatPK;

    @MapsId("codeOrdreAchat")
    @JoinColumn(name = "code_ordre_achat", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false)
    private OrdreAchat ordreAchat;

    @Column(name = "code_matiere", insertable = false, updatable = false)
    private Integer codematiere;

    @JoinColumn(name = "code_matiere", referencedColumnName = "Code", nullable = false, insertable = false, updatable = false)
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
    @Column(name = "qte_ordre", nullable = false)
    private BigDecimal qteOrdre;

    @Column(name = "qte_livrer")
    private BigDecimal qteLivrer;

    @Column(name = "user_create", nullable = false, columnDefinition = "nvarchar(200)")
    private String usercreate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_Create", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @JoinColumn(name = "code_depot", referencedColumnName = "code", nullable = false, updatable = false, insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Depot depot;
    @Column(name = "code_depot", insertable = false, updatable = false)
    private Integer codeDepot;

    public DetailsOrdreAchat() {
    }

    public DetailsOrdreAchatPK getDetailsOrdreAchatPK() {
        return detailsOrdreAchatPK;
    }

    public void setDetailsOrdreAchatPK(DetailsOrdreAchatPK detailsOrdreAchatPK) {
        this.detailsOrdreAchatPK = detailsOrdreAchatPK;
    }

    public OrdreAchat getOrdreAchat() {
        return ordreAchat;
    }

    public void setOrdreAchat(OrdreAchat ordreAchat) {
        this.ordreAchat = ordreAchat;
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

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
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

    public BigDecimal getQteOrdre() {
        return qteOrdre;
    }

    public void setQteOrdre(BigDecimal qteOrdre) {
        this.qteOrdre = qteOrdre;
    }

    public BigDecimal getQteLivrer() {
        return qteLivrer;
    }

    public void setQteLivrer(BigDecimal qteLivrer) {
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

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Integer getCodeDepot() {
        return codeDepot;
    }

    public void setCodeDepot(Integer codeDepot) {
        this.codeDepot = codeDepot;
    }

    
    
}
