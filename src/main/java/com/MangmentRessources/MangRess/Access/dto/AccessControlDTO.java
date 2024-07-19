/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MangmentRessources.MangRess.Access.dto;

/**
 *
 * @author ASUS
 */
public class AccessControlDTO {
    private String userName;
    private String description;
    private String passWord;
    private String grp;
    private String codeInterv;

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

    public String getCodeInterv() {
        return codeInterv;
    }

    public void setCodeInterv(String codeInterv) {
        this.codeInterv = codeInterv;
    }
}
