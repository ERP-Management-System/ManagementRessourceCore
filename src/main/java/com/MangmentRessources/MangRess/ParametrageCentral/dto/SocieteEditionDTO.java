/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.dto;

import jakarta.validation.constraints.NotNull;
import java.sql.Blob;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
public class SocieteEditionDTO {

    @NotNull
    private Integer code;

    private Blob logo;

    @NotNull
    @Size(
            min = 1,
            max = 100
    )
    private String nomSociete;

    public SocieteEditionDTO(Integer code, Blob logo, String nomSociete) {
        this.code = code;
        this.logo = logo;
        this.nomSociete = nomSociete;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Blob getLogo() {
        return logo;
    }

    public void setLogo(Blob logo) {
        this.logo = logo;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }
    
    

}
