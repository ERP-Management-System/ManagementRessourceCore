package com.MangmentRessources.MangRess.Access.dto;
 
import com.MangmentRessources.MangRess.Access.domaine.AccessFormUserPK;


public class AccessFormUserDTO {
  private AccessFormUserPK accessFormUserPK;

  private Boolean visible;

  private String form;

    public AccessFormUserDTO() {
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

