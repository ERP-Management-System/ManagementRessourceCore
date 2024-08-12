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
public class DetailsDemandeAchatPK {

    @Basic(optional = false)
    @NotNull
    @Column(name = "code_demande_achat", nullable = false)
    private int codeDemandeAchat;

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

 

    public DetailsDemandeAchatPK() {
    }

    public int getCodeDemandeAchat() {
        return codeDemandeAchat;
    }

    public void setCodeDemandeAchat(int codeDemandeAchat) {
        this.codeDemandeAchat = codeDemandeAchat;
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
        hash = 43 * hash + this.codeDemandeAchat;
        hash = 43 * hash + this.codeMatiere;
        hash = 43 * hash + this.codeColoris;
        hash = 43 * hash + this.codeUnite;
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
        final DetailsDemandeAchatPK other = (DetailsDemandeAchatPK) obj;
        if (this.codeDemandeAchat != other.codeDemandeAchat) {
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
