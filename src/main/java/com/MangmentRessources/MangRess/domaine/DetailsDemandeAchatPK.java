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
 
    
    
    
    
    

}
