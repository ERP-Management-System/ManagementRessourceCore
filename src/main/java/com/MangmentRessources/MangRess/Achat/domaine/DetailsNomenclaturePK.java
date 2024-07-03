/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
@Embeddable
public class DetailsNomenclaturePK {

    @Basic(optional = false)
    @NotNull
    @Column(name = "code_nomenclature_article")
    private Integer codeNomenclatureArticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "code_article")
    private Integer codearticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "code_matiere")
    private int codeMatiere;

    @Basic(optional = false)
    @NotNull
    @Column(name = "code_coloris", nullable = false)
    private int codeColoris;

//    @JoinColumn(name = "code_matiere", referencedColumnName = "Code", nullable = false)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Matiere matiere;

//    @JoinColumn(name = "code_coloris", referencedColumnName = "code", nullable = false, updatable = false, insertable = false)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Coloris coloris;
 

    public DetailsNomenclaturePK() {
    }

    public Integer getCodeNomenclatureArticle() {
        return codeNomenclatureArticle;
    }

    public void setCodeNomenclatureArticle(Integer codeNomenclatureArticle) {
        this.codeNomenclatureArticle = codeNomenclatureArticle;
    }

    public Integer getCodearticle() {
        return codearticle;
    }

    public void setCodearticle(Integer codearticle) {
        this.codearticle = codearticle;
    }

    public Integer getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(Integer codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public Integer getCodeColoris() {
        return codeColoris;
    }

    public void setCodeColoris(Integer codeColoris) {
        this.codeColoris = codeColoris;
    }
 

    
    
}
