/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.dto;

import com.MangmentRessources.MangRess.domaine.Matiere;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DetailsAppelOffreDTO {


        
//    private MatiereDTO matiereDTO;  
    private String DesignationLTMatiere;
    
    
    @NotNull
    private Integer codeMatiere;




    private int codeAppelOffre;

    private BigDecimal qteDemander;

    private String usercreate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreate;

    public DetailsAppelOffreDTO() {
    }

    @Override
    public String toString() {
        return "com.MangmentRessources.MangRess.domaine.DetailsAppelOffre[ detailsAppelOffrePK=" + " ]";
    }

    public int getCodeAppelOffre() {
        return codeAppelOffre;
    }

    public void setCodeAppelOffre(int codeAppelOffre) {
        this.codeAppelOffre = codeAppelOffre;
    }

    public BigDecimal getQteDemander() {
        return qteDemander;
    }

    public void setQteDemander(BigDecimal qteDemander) {
        this.qteDemander = qteDemander;
    }

    public String getUsercreate() {
        return usercreate;
    }

    public void setUsercreate(String usercreate) {
        this.usercreate = usercreate;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }


    public Integer getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(Integer codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public String getDesignationLTMatiere() {
        return DesignationLTMatiere;
    }

    public void setDesignationLTMatiere(String DesignationLTMatiere) {
        this.DesignationLTMatiere = DesignationLTMatiere;
    }

 


  

}
