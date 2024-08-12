/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author Administrator
 */
 @Embeddable
public class DetailsOrdreAchatPK implements Serializable {

 

    @Basic(optional = false)
    @NotNull
    @Column(name = "code_ordre_achat", nullable = false)
    private Integer codeOrdreAchat;

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
 
    
    
    public DetailsOrdreAchatPK() {
    }
 
    
    

    public Integer getCodeOrdreAchat() {
        return codeOrdreAchat;
    }

    public void setCodeOrdreAchat(Integer codeOrdreAchat) {
        this.codeOrdreAchat = codeOrdreAchat;
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
        int hash = 5;
        hash = 89 * hash + this.codeOrdreAchat;
        hash = 89 * hash + this.codeMatiere;
        hash = 89 * hash + this.codeColoris;
        hash = 89 * hash + this.codeUnite;
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
        final DetailsOrdreAchatPK other = (DetailsOrdreAchatPK) obj;
        if (this.codeOrdreAchat != other.codeOrdreAchat) {
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
