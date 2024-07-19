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
@Table(name = "ACCESS_MENU_USER", schema = "access")
public class AccessMenuUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccessMenuUserPK accessMenuUserPK;

    @Column(name = "Visible")
    private Boolean visible;
    @Column(name = "Designation_menu")
    private String desigMenu;

    @Column(name = "menu_pere" , columnDefinition = ("varchar(50)"))
    private String menuPere;

    public AccessMenuUser() {
    }

    public AccessMenuUserPK getAccessMenuUserPK() {
        return accessMenuUserPK;
    }

    public void setAccessMenuUserPK(AccessMenuUserPK accessMenuUserPK) {
        this.accessMenuUserPK = accessMenuUserPK;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getDesigMenu() {
        return desigMenu;
    }

    public void setDesigMenu(String desigMenu) {
        this.desigMenu = desigMenu;
    }

    public String getMenuPere() {
        return menuPere;
    }

    public void setMenuPere(String menuPere) {
        this.menuPere = menuPere;
    }

}
