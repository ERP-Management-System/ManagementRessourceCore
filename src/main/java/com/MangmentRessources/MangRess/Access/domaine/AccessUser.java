/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Access.domaine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "access_user", schema = "access")
public class AccessUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Integer code;

    @Column(name = "username", length = 200, nullable = false)
    private String userName;

    @Size(max = 200)
    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @Column(name = "actif", nullable = false)
    private Boolean actif;
 

    @Size(max = 200)
    @Column(name = "nom_complet_user", length = 200, nullable = false, columnDefinition = "nvarchar(200) default ''")
    private String nomCompletUser;

    @Lob
    @Column(name = "signature")
    private byte[] signature;

    public AccessUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

 
    public String getNomCompletUser() {
        return nomCompletUser;
    }

    public void setNomCompletUser(String nomCompletUser) {
        this.nomCompletUser = nomCompletUser;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
