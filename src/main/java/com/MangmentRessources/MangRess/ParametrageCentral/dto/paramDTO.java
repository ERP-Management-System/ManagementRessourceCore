/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.dto;

import jakarta.persistence.Column;

/**
 *
 * @author Administrator
 */
public class paramDTO {

    private Integer code;   
    private String codeParam;


    private String description;

    private String valeur;

    public paramDTO() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeParam() {
        return codeParam;
    }

    public void setCodeParam(String codeParam) {
        this.codeParam = codeParam;
    }

 

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
    
    
    

}
