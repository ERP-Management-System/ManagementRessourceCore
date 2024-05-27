/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.domaine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "Coloris", schema = "achat")
public class Coloris {

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
    private boolean actif;

    @Column(name = "visible", nullable = false)
    private boolean visible;

    @Column(name = "user_Create", nullable = false, length = 255, columnDefinition = "nvarchar")
    private String userCreate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_Create")
    private Date dateCreate;

    public Coloris() {
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

}
