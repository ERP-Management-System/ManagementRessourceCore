/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.domaine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "copie_appel_offre", schema = "achat")
public class CopieAO {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Code", nullable = false)
    private Integer code;
    
    @JoinColumn(name = "code_appel_offre", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private AppelOffre appelOffre;

    @Column(name = "code_appel_offre", updatable = false, insertable = false)
    private Integer codeAppelOffre;
    
    
    @Size(max = 200)
    @Column(name = "nbre_copie_AO", length = 200, nullable = false, columnDefinition = "int")
    private String nbreCopie;
    
    

    public CopieAO() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public AppelOffre getAppelOffre() {
        return appelOffre;
    }

    public void setAppelOffre(AppelOffre appelOffre) {
        this.appelOffre = appelOffre;
    }

    public Integer getCodeAppelOffre() {
        return codeAppelOffre;
    }

    public void setCodeAppelOffre(Integer codeAppelOffre) {
        this.codeAppelOffre = codeAppelOffre;
    }

    public String getNbreCopie() {
        return nbreCopie;
    }

    public void setNbreCopie(String nbreCopie) {
        this.nbreCopie = nbreCopie;
    }
    
    
    
    

}
