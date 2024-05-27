/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.domaine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import javax.xml.validation.Schema;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "matiere", schema = "achat")
public class Matiere {

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

    @Column(name = "actif", nullable = false)
    @NotNull
    private boolean actif;

    @Column(name = "visible", nullable = false)
    @NotNull
    private boolean visible;

    @Column(name = "user_Create", nullable = false, length = 255, columnDefinition = "nvarchar")
    private String userCreate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_Create")
    private Date dateCreate;

    @JoinColumn(name = "code_type_matiere", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private TypeMatiere codeTypeMatiere;

    @Column(name = "code_type_matiere", updatable = false, insertable = false)
    private Integer typeMatiere;
    
    

    public Matiere() {
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

    public TypeMatiere getCodeTypeMatiere() {
        return codeTypeMatiere;
    }

    public void setCodeTypeMatiere(TypeMatiere codeTypeMatiere) {
        this.codeTypeMatiere = codeTypeMatiere;
    }

    public Integer getTypeMatiere() {
        return typeMatiere;
    }

    public void setTypeMatiere(Integer typeMatiere) {
        this.typeMatiere = typeMatiere;
    }

 
}
