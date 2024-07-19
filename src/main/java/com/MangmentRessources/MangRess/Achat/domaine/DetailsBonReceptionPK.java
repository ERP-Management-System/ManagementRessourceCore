/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
public class DetailsBonReceptionPK {

    @Basic(optional = false)
    @NotNull
    @Column(name = "code_bon_reception", nullable = false)
    private int codeBonReception;

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

    public DetailsBonReceptionPK() {
    }

    public int getCodeBonReception() {
        return codeBonReception;
    }

    public void setCodeBonReception(int codeBonReception) {
        this.codeBonReception = codeBonReception;
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
