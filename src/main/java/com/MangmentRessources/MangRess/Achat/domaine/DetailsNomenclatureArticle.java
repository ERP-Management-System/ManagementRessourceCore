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
import java.util.Date;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "details_nomenclature_article", schema = "achat")
//@Audited
//@AuditTable("details_nomenclature_article_AUD")
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

}
