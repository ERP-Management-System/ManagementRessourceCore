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
public class DetailsAppelOffreDTOs {
    
    private Integer codeAppelOffre;

    private String codeMatiere;
    private MatiereDTO matiereDTO;

    private String codeColoris;
    private ColorisDTO colorisDTO;

    private String codeUnite;
    private UniteDTO uniteDTO;
    
    private Integer qteDemander;
    private String userCreate;

    private Date dateCreate;

    public Integer getCodeAppelOffre() {
        return codeAppelOffre;
    }

    public void setCodeAppelOffre(Integer codeAppelOffre) {
        this.codeAppelOffre = codeAppelOffre;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public MatiereDTO getMatiereDTO() {
        return matiereDTO;
    }

    public void setMatiereDTO(MatiereDTO matiereDTO) {
        this.matiereDTO = matiereDTO;
    }

    public String getCodeColoris() {
        return codeColoris;
    }

    public void setCodeColoris(String codeColoris) {
        this.codeColoris = codeColoris;
    }

    public ColorisDTO getColorisDTO() {
        return colorisDTO;
    }

    public void setColorisDTO(ColorisDTO colorisDTO) {
        this.colorisDTO = colorisDTO;
    }

    public String getCodeUnite() {
        return codeUnite;
    }

    public void setCodeUnite(String codeUnite) {
        this.codeUnite = codeUnite;
    }

    public UniteDTO getUniteDTO() {
        return uniteDTO;
    }

    public void setUniteDTO(UniteDTO uniteDTO) {
        this.uniteDTO = uniteDTO;
    }

    public Integer getQteDemander() {
        return qteDemander;
    }

    public void setQteDemander(Integer qteDemander) {
        this.qteDemander = qteDemander;
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
