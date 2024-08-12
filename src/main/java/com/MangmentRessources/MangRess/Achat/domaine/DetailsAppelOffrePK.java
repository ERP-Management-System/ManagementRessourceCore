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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 *
 *
 * @author Administrator
 */
@Embeddable
public class DetailsAppelOffrePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Code_Appel_Offre", nullable = false)
    private int codeAppelOffre;

    @Basic(optional = false)
    @NotNull
    @Column(name = "code_matiere")
    private int codeMatiere;

    @Basic(optional = false)
    @NotNull
    @Column(name = "code_coloris", nullable = false)
    private int codeColoris;

    @Basic(optional = false)
    @NotNull
    @Column(name = "code_unite", nullable = false)
    private int codeUnite;



    public DetailsAppelOffrePK() {
    }

    public int getCodeAppelOffre() {
        return codeAppelOffre;
    }

    public void setCodeAppelOffre(int codeAppelOffre) {
        this.codeAppelOffre = codeAppelOffre;
    }

    public Integer getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(Integer codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public int getCodeColoris() {
        return codeColoris;
    }

    public void setCodeColoris(int codeColoris) {
        this.codeColoris = codeColoris;
    }

    public int getCodeUnite() {
        return codeUnite;
    }

    public void setCodeUnite(int codeUnite) {
        this.codeUnite = codeUnite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codeAppelOffre;
        hash = 97 * hash + this.codeMatiere;
        hash = 97 * hash + this.codeColoris;
        hash = 97 * hash + this.codeUnite;
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
        final DetailsAppelOffrePK other = (DetailsAppelOffrePK) obj;
        if (this.codeAppelOffre != other.codeAppelOffre) {
            return false;
        }
        if (this.codeMatiere != other.codeMatiere) {
            return false;
        }
        if (this.codeColoris != other.codeColoris) {
            return false;
        }
        return this.codeUnite == other.codeUnite;
    }


}
