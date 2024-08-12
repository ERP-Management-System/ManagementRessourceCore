/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MangmentRessources.MangRess.Access.domaine;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date; 
import jakarta.persistence.Table;
@Entity
@Table(name = "[Access_Control]" , schema = "access") 
public class AccessControl  { 
    @Id
    @Basic(optional = false)
    @Column(name = "User_name")
    private String userName;
    @Column(name = "Description")
    private String description;
    @Column(name = "PassWord")
    private String passWord;
    @Column(name = "Grp")
    private String grp;
    @Column(name = "Dernier_Date_Cnx")
    @Temporal(TemporalType.DATE)
    private Date derniereDateCnx;
    @Column(name = "Actif")
    private Boolean actif;



    public AccessControl() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    /**
     * @return the derniereDateCnx
     */
    public Date getDerniereDateCnx() {
        return derniereDateCnx;
    }

    /**
     * @param derniereDateCnx the derniereDateCnx to set
     */
    public void setDerniereDateCnx(Date derniereDateCnx) {
        this.derniereDateCnx = derniereDateCnx;
    }

    /**
     * @return the actif
     */
    public Boolean getActif() {
        return actif;
    }

    /**
     * @param actif the actif to set
     */
    public void setActif(Boolean actif) {
        this.actif = actif;
    }

  
}