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
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "nomenclature_article", schema = "achat")
//@Audited
//@AuditTable("nomenclature_article_AUD")
public class NomenclatureArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Integer code;

    @Size(max = 200)
    @NotNull
    @Column(name = "code_saisie", length = 200)
    private String codeSaisie;

    @Size(max = 200)
    @NotNull
    @Column(name = "designation_ar", length = 200, columnDefinition = "nvarchar")
    private String designationAr;

    @Size(max = 200)
    @Column(name = "designation_lt", length = 200, columnDefinition = "nvarchar")
    private String designationLt;

    @Column(name = "actif", nullable = false)
    @NotNull
    private boolean actif;

    @Column(name = "visible", nullable = false)
    @NotNull
    private boolean visible;

    @Column(name = "user_Create", nullable = false, length = 255, columnDefinition = "nvarchar")
    private String userCreate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomenclatureArticle", fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<DetailsNomenclatureArticle> detailsNomenclatureArticles;

//    @Column(name = "qte_besoin", nullable = false, length = 255)
//    private Integer qteBesoin;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_Create")
    private Date dateCreate;

//    @JoinColumn(name = "code_article", referencedColumnName = "Code", nullable = false)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Article article;
//
//    @Column(name = "code_article", updatable = false, insertable = false)
//    private Integer codeArticle;
//
//    @JoinColumn(name = "code_matiere", referencedColumnName = "Code", nullable = false)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Matiere matiere;
//
//    @Column(name = "code_matiere", updatable = false, insertable = false)
//    private Integer codeMatiere;
//
//    @JoinColumn(name = "code_coloris", referencedColumnName = "Code", nullable = false)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Coloris colrois;
//
//    @Column(name = "code_coloris", updatable = false, insertable = false)
//    private Integer codeColoris;
    public NomenclatureArticle() {
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

//    public Article getArticle() {
//        return article;
//    }
//
//    public void setArticle(Article article) {
//        this.article = article;
//    }
//
//    public Integer getCodeArticle() {
//        return codeArticle;
//    }
//
//    public void setCodeArticle(Integer codeArticle) {
//        this.codeArticle = codeArticle;
//    }
//
//    public Matiere getMatiere() {
//        return matiere;
//    }
//
//    public void setMatiere(Matiere matiere) {
//        this.matiere = matiere;
//    }
//
//    public Integer getCodeMatiere() {
//        return codeMatiere;
//    }
//
//    public void setCodeMatiere(Integer codeMatiere) {
//        this.codeMatiere = codeMatiere;
//    }
//
//    public Integer getQteBesoin() {
//        return qteBesoin;
//    }
//
//    public void setQteBesoin(Integer qteBesoin) {
//        this.qteBesoin = qteBesoin;
//    }
//
// 
//    public Coloris getColrois() {
//        return colrois;
//    }
//
//    public void setColrois(Coloris colrois) {
//        this.colrois = colrois;
//    }
//
//    public Integer getCodeColoris() {
//        return codeColoris;
//    }
//
//    public void setCodeColoris(Integer codeColoris) {
//        this.codeColoris = codeColoris;
//    }

    public Collection<DetailsNomenclatureArticle> getDetailsNomenclatureArticles() {
        return detailsNomenclatureArticles;
    }

    public void setDetailsNomenclatureArticles(Collection<DetailsNomenclatureArticle> detailsNomenclatureArticles) {
        this.detailsNomenclatureArticles = detailsNomenclatureArticles;
    }
    
    
    
}
