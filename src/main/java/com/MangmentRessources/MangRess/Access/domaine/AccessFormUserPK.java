/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MangmentRessources.MangRess.Access.domaine;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class AccessFormUserPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Module")
    private Boolean module;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_name")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Control")
    private String control;

    public AccessFormUserPK() {
    }

    public Boolean getModule() {
        return module;
    }

    public void setModule(Boolean module) {
        this.module = module;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }
 

}
