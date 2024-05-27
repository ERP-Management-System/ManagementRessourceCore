/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.dto;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class NomenclatureArticleDTO {

    private Integer code;

    private String codeSaisie;

    private String designationAr;

    private String designationLt;

    private boolean actif;

    private boolean visible;

    private String userCreate;

    private Integer qteBesoin;

    private Date dateCreate;

    private Collection<DetailsNomenclatureArticleDTO> detailsNomenclatureArticleDTOs;

    public NomenclatureArticleDTO() {
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

    public Integer getQteBesoin() {
        return qteBesoin;
    }

    public void setQteBesoin(Integer qteBesoin) {
        this.qteBesoin = qteBesoin;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Collection<DetailsNomenclatureArticleDTO> getDetailsNomenclatureArticleDTOs() {
        return detailsNomenclatureArticleDTOs;
    }

    public void setDetailsNomenclatureArticleDTOs(Collection<DetailsNomenclatureArticleDTO> detailsNomenclatureArticleDTOs) {
        this.detailsNomenclatureArticleDTOs = detailsNomenclatureArticleDTOs;
    }

}
