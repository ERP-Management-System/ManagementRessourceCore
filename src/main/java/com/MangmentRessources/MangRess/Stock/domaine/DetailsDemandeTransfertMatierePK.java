/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.domaine;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import javax.persistence.Embeddable;

 

 

/**
 *
 * @author Administrator
 */
@Embeddable
public class DetailsDemandeTransfertMatierePK {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code_Demande_Transfert", nullable = false)
    private int codeDemandeTransfertMatiere;



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

    public DetailsDemandeTransfertMatierePK() {
    }

    public int getCodeDemandeTransfertMatiere() {
        return codeDemandeTransfertMatiere;
    }

    public void setCodeDemandeTransfertMatiere(int codeDemandeTransfertMatiere) {
        this.codeDemandeTransfertMatiere = codeDemandeTransfertMatiere;
    }

    public int getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(int codeMatiere) {
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
        int hash = 3;
        hash = 97 * hash + this.codeDemandeTransfertMatiere;
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
        final DetailsDemandeTransfertMatierePK other = (DetailsDemandeTransfertMatierePK) obj;
        if (this.codeDemandeTransfertMatiere != other.codeDemandeTransfertMatiere) {
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
