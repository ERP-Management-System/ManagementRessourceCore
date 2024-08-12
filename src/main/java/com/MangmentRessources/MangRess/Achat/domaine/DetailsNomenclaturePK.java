/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codeNomenclatureArticle);
        hash = 67 * hash + Objects.hashCode(this.codearticle);
        hash = 67 * hash + this.codeMatiere;
        hash = 67 * hash + this.codeColoris;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetailsNomenclaturePK other = (DetailsNomenclaturePK) obj;
        if (this.codeMatiere != other.codeMatiere) {
            return false;
        }
        if (this.codeColoris != other.codeColoris) {
            return false;
        }
        if (!Objects.equals(this.codeNomenclatureArticle, other.codeNomenclatureArticle)) {
            return false;
        }
        return Objects.equals(this.codearticle, other.codearticle);
    }
 

    
    
}
