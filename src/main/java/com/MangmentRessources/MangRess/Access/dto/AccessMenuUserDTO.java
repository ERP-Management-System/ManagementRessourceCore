package com.MangmentRessources.MangRess.Access.dto;

import com.MangmentRessources.MangRess.Access.domaine.AccessMenuUserPK;

public class AccessMenuUserDTO {

    private AccessMenuUserPK accessMenuUserPK;

    private Boolean visible;

    private String des;

    private String menuPere;

    public AccessMenuUserDTO() {
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getMenuPere() {
        return menuPere;
    }

    public void setMenuPere(String menuPere) {
        this.menuPere = menuPere;
    }
    
}
