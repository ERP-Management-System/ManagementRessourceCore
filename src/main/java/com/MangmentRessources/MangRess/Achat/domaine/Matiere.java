/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.domaine;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Taxe;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Size;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "matiere", schema = "achat")
//@Audited
//@AuditTable("matiere_AUD")
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
    @Column(name = "designation_ar", length = 200, columnDefinition = "nvarchar(200)")
    private String designationAr;

    @Size(max = 200)
    @Column(name = "designation_lt", length = 200, columnDefinition = "nvarchar(200)")
    private String designationLt;

    @JoinColumn(name = "code_statu_matiere", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private StatuMatiere statuMatiere;

    @Column(name = "code_statu_matiere", updatable = false, insertable = false, columnDefinition = "Int default 2")
    @NotNull
    private Integer codeStatuMatiere;

    @Column(name = "user_Create", nullable = false, length = 255, columnDefinition = "nvarchar(200)")
    private String userCreate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_Create", columnDefinition = ("datetime default getdate()"))
    private Date dateCreate;

    @JoinColumn(name = "code_type_matiere", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private TypeMatiere codeTypeMatiere;

    @Column(name = "code_type_matiere", updatable = false, insertable = false)
    private Integer typeMatiere;

    @Column(name = "qte_min_stock", nullable = false)
    private Integer qteMinStock;

    @Column(name = "qte_max_stock", nullable = false)
    private Integer qteMaxStock;

    @Column(name = "prix_achat", nullable = false, columnDefinition = "decimal(18,3)")
    private BigDecimal prixAchat;

    @JoinColumn(name = "code_taxe", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Taxe taxe;

    @Column(name = "code_taxe", updatable = false, insertable = false )
    private Integer codeTaxe;

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

    public Integer getQteMinStock() {
        return qteMinStock;
    }

    public void setQteMinStock(Integer qteMinStock) {
        this.qteMinStock = qteMinStock;
    }

    public Integer getQteMaxStock() {
        return qteMaxStock;
    }

    public void setQteMaxStock(Integer qteMaxStock) {
        this.qteMaxStock = qteMaxStock;
    }

    public StatuMatiere getStatuMatiere() {
        return statuMatiere;
    }

    public void setStatuMatiere(StatuMatiere statuMatiere) {
        this.statuMatiere = statuMatiere;
    }

    public Integer getCodeStatuMatiere() {
        return codeStatuMatiere;
    }

    public void setCodeStatuMatiere(Integer codeStatuMatiere) {
        this.codeStatuMatiere = codeStatuMatiere;
    }

    public BigDecimal getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(BigDecimal prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }

    public Integer getCodeTaxe() {
        return codeTaxe;
    }

    public void setCodeTaxe(Integer codeTaxe) {
        this.codeTaxe = codeTaxe;
    }
    
    

}
