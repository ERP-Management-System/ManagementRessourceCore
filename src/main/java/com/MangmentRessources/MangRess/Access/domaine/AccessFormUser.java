/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MangmentRessources.MangRess.Access.domaine;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable; 

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "ACCESS_FORM_USER" , schema = "access")
public class AccessFormUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessFormUserPK accessFormUserPK;

    @Column(name = "Visible")
    private Boolean visible;
    @Column(name = "Form")
    private String form;
   


    public AccessFormUser() {
    }

    public AccessFormUserPK getAccessFormUserPK() {
        return accessFormUserPK;
    }

    public void setAccessFormUserPK(AccessFormUserPK accessFormUserPK) {
        this.accessFormUserPK = accessFormUserPK;
    }

 

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }



}
