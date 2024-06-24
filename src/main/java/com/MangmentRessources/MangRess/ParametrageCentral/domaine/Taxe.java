/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.domaine;

import com.MangmentRessources.MangRess.Achat.domaine.StatuMatiere;
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
@Table(name = "taxe", schema = "param")
public class Taxe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code" , columnDefinition = ("decimal(18,3)"))
    private Integer code;

    @Size(max = 200)
    @NotNull
    @Column(name = "code_saisie", length = 200)
    private String codeSaisie;

    @Size(max = 200)
    @NotNull
    @Column(name = "designation_ar", length = 200, columnDefinition = "nvarchar(200)")
    private String designationAr;

    @Size(max = 200)
    @Column(name = "designation_lt", length = 200, columnDefinition = "nvarchar(200)")
    private String designationLt;

    @JoinColumn(name = "code_type_taxe", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private TypeTaxe typeTaxe;

    @Column(name = "code_type_taxe", updatable = false, insertable = false, columnDefinition = "Int default 0")
    @NotNull
    private Integer codeTypeTaxe;

    @Column(name = "user_Create", nullable = false, length = 255, columnDefinition = "nvarchar")
    private String userCreate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_Create", columnDefinition = ("datetime default getdate()"))
    private Date dateCreate;

    @NotNull
    @Column(name = "valeur_taxe", columnDefinition = "decimal(18,3)")
    private Integer valeurTaxe;

    public Taxe() {
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

    public TypeTaxe getTypeTaxe() {
        return typeTaxe;
    }

    public void setTypeTaxe(TypeTaxe typeTaxe) {
        this.typeTaxe = typeTaxe;
    }

    public Integer getCodeTypeTaxe() {
        return codeTypeTaxe;
    }

    public void setCodeTypeTaxe(Integer codeTypeTaxe) {
        this.codeTypeTaxe = codeTypeTaxe;
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

    public Integer getValeurTaxe() {
        return valeurTaxe;
    }

    public void setValeurTaxe(Integer valeurTaxe) {
        this.valeurTaxe = valeurTaxe;
    }

}
