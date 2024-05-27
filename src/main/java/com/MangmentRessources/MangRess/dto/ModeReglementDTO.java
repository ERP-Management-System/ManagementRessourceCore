/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.dto;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class ModeReglementDTO {
    
     private Integer code;

    private String codeSaisie;

    private String designationAr;

    private String designationLt;

    private boolean actif;

    private boolean visible;

    private String userCreate;

    private Date dateCreate;


    private TypeCaisseDTO typeCaisse;

    private Integer codeTypeCaisse;


    private BanqueDTO banque;

    private Integer codeBanque;

    public ModeReglementDTO() {
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

    public TypeCaisseDTO getTypeCaisse() {
        return typeCaisse;
    }

    public void setTypeCaisse(TypeCaisseDTO typeCaisse) {
        this.typeCaisse = typeCaisse;
    }

    public Integer getCodeTypeCaisse() {
        return codeTypeCaisse;
    }

    public void setCodeTypeCaisse(Integer codeTypeCaisse) {
        this.codeTypeCaisse = codeTypeCaisse;
    }

    public BanqueDTO getBanque() {
        return banque;
    }

    public void setBanque(BanqueDTO banque) {
        this.banque = banque;
    }

    public Integer getCodeBanque() {
        return codeBanque;
    }

    public void setCodeBanque(Integer codeBanque) {
        this.codeBanque = codeBanque;
    }
    
    
}
