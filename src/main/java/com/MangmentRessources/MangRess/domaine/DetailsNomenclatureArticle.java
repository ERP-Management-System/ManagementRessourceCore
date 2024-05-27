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
@Table(name = "details_nomenclature_article", schema = "achat")
public class DetailsNomenclatureArticle {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected DetailsNomenclaturePK detailsNomenclaturePK;

    @MapsId("codenomenclaturearticle")
    @JoinColumn(name = "code_nomenclature_article", referencedColumnName = "code")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private NomenclatureArticle nomenclatureArticle;

    @Column(name = "code_article", insertable = false, updatable = false)
    private Integer codearticle;

//    @Column(name = "designation_ar_article" ,columnDefinition = "nvarchar(max)", nullable = false)
//    private String designationararticle;
//
//    @Column(name = "designation_en_article" ,columnDefinition = "nvarchar(max)", nullable = false)
//    private String designationenarticle;
    @Column(name = "qte_besoin", nullable = false)
    private Integer qtebesoin;

    @Column(name = "user_create",nullable = false, columnDefinition = "nvarchar(200)")
    private String usercreate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_Create", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;


    
    

    public DetailsNomenclatureArticle() {
    }

    public DetailsNomenclaturePK getDetailsNomenclaturePK() {
        return detailsNomenclaturePK;
    }

    public void setDetailsNomenclaturePK(DetailsNomenclaturePK detailsNomenclaturePK) {
        this.detailsNomenclaturePK = detailsNomenclaturePK;
    }

    public NomenclatureArticle getNomenclatureArticle() {
        return nomenclatureArticle;
    }

    public void setNomenclatureArticle(NomenclatureArticle nomenclatureArticle) {
        this.nomenclatureArticle = nomenclatureArticle;
    }

    public Integer getCodearticle() {
        return codearticle;
    }

    public void setCodearticle(Integer codearticle) {
        this.codearticle = codearticle;
    }

//    public String getDesignationararticle() {
//        return designationararticle;
//    }
//
//    public void setDesignationararticle(String designationararticle) {
//        this.designationararticle = designationararticle;
//    }
//
//    public String getDesignationenarticle() {
//        return designationenarticle;
//    }
//
//    public void setDesignationenarticle(String designationenarticle) {
//        this.designationenarticle = designationenarticle;
//    }
    public Integer getQtebesoin() {
        return qtebesoin;
    }

    public void setQtebesoin(Integer qtebesoin) {
        this.qtebesoin = qtebesoin;
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
