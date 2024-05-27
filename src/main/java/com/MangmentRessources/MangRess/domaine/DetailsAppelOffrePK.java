/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.domaine;

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
public class DetailsAppelOffrePK {
    
     
    @Basic(optional = false)
    @NotNull
    @Column(name = "code_appel_offre")
    private Integer codeAppelOffre;
    
    @Column(name = "code_matiere", updatable = false, insertable = false)
    private Integer codeMatiere;

    @JoinColumn(name = "code_matiere", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Matiere matiere;

    @Column(name = "code_coloris", updatable = false, insertable = false)
    private Integer codeColoris;

    @JoinColumn(name = "code_coloris", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Coloris coloris;
    
    
    @Column(name = "code_unite", updatable = false, insertable = false)
    private Integer codeUnite;

    @JoinColumn(name = "code_unite", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Unite unite;

    public DetailsAppelOffrePK() {
    }

    public Integer getCodeAppelOffre() {
        return codeAppelOffre;
    }

    public void setCodeAppelOffre(Integer codeAppelOffre) {
        this.codeAppelOffre = codeAppelOffre;
    }

    public Integer getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(Integer codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

 
   

    public Integer getCodeColoris() {
        return codeColoris;
    }

    public void setCodeColoris(Integer codeColoris) {
        this.codeColoris = codeColoris;
    }

    public Coloris getColoris() {
        return coloris;
    }

    public void setColoris(Coloris coloris) {
        this.coloris = coloris;
    }

    public Integer getCodeUnite() {
        return codeUnite;
    }

    public void setCodeUnite(Integer codeUnite) {
        this.codeUnite = codeUnite;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }
    
    
    
    
}
