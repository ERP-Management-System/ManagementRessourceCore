/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.dto;

import com.MangmentRessources.MangRess.Achat.domaine.CategorieDepot;
import com.MangmentRessources.MangRess.Achat.domaine.Departement;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
public class DepotDTO {
    private Integer code;
 
    private String codeSaisie;
 
    private String designationAr;
 
    private String designationLt;
 
    private boolean principal;
 
    private boolean actif;
 
    private boolean visible;
 
    private String userCreate; 
    private Date dateCreate;

  
    private CategorieDepotDTO categorieDepotDTO;
 
    private Integer codeCategorieDepot;
    
    
        private DepartementDTO departmenetDTO;
 
    private Integer codeDepartement;

    public DepotDTO() {
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

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
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

    public CategorieDepotDTO getCategorieDepotDTO() {
        return categorieDepotDTO;
    }

    public void setCategorieDepotDTO(CategorieDepotDTO categorieDepotDTO) {
        this.categorieDepotDTO = categorieDepotDTO;
    }

    public Integer getCodeCategorieDepot() {
        return codeCategorieDepot;
    }

    public void setCodeCategorieDepot(Integer codeCategorieDepot) {
        this.codeCategorieDepot = codeCategorieDepot;
    }

    public DepartementDTO getDepartmenetDTO() {
        return departmenetDTO;
    }

    public void setDepartmenetDTO(DepartementDTO departmenetDTO) {
        this.departmenetDTO = departmenetDTO;
    }

    public Integer getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(Integer codeDepartement) {
        this.codeDepartement = codeDepartement;
    }
    
    
    
}


