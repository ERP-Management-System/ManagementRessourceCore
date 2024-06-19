/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

import com.MangmentRessources.MangRess.Achat.domaine.GrilleTaille;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */

@Entity
@Table(name = "taille", schema = "achat")
public class Taille {
    
    
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

    @Column(name = "Actif", nullable = false)
    @NotNull
    private boolean actif;

    @Column(name = "Visible", nullable = false)
    @NotNull
    private boolean visible;

    @Column(name = "User_Create", nullable = false, length = 255, columnDefinition = "nvarchar")
    private String userCreate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Date_Create")
    private Date dateCreate;

    @JoinColumn(name = "code_type_matiere", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private GrilleTaille grilleTaille;

    @Column(name = "code_grille_taille", updatable = false, insertable = false)
    private Integer codeGrilleTaille;

    public Taille() {
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

    public GrilleTaille getGrilleTaille() {
        return grilleTaille;
    }

    public void setGrilleTaille(GrilleTaille grilleTaille) {
        this.grilleTaille = grilleTaille;
    }

    public Integer getCodeGrilleTaille() {
        return codeGrilleTaille;
    }

    public void setCodeGrilleTaille(Integer codeGrilleTaille) {
        this.codeGrilleTaille = codeGrilleTaille;
    }
    
    
    
    
    
}
