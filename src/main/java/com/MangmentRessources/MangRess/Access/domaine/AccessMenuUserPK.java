/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MangmentRessources.MangRess.Access.domaine;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable; 



 
public class AccessMenuUserPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "Module")
    private Boolean module;
    @Column(name = "user_name")
    private String user;
     @Column(name = "Menu")
    private String menu;


    public AccessMenuUserPK() {
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

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }





}
