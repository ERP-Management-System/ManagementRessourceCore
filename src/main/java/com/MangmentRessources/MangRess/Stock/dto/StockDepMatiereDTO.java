/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.dto;

import com.MangmentRessources.MangRess.Achat.dto.ColorisDTO;
import com.MangmentRessources.MangRess.Achat.dto.DepotDTO;
import com.MangmentRessources.MangRess.Achat.dto.MatiereDTO;
import com.MangmentRessources.MangRess.Achat.dto.UniteDTO;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class StockDepMatiereDTO {

    private Integer code;

    private Integer codematiere;
    private MatiereDTO matiereDTO;

    private ColorisDTO colorisDTO;
    private Integer codeColoris;

    private UniteDTO uniteDTO;
    private Integer codeUnite;

    private DepotDTO depotDTO;
    private Integer codeDepot;

    private BigDecimal prixUnitaire;

    private BigDecimal qteDispo;

    private String usercreate;

    private Date dateCreate;

    private String numBonReception;

    private String numPiece;

    private String laize;

    public StockDepMatiereDTO() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCodematiere() {
        return codematiere;
    }

    public void setCodematiere(Integer codematiere) {
        this.codematiere = codematiere;
    }

    public MatiereDTO getMatiereDTO() {
        return matiereDTO;
    }

    public void setMatiereDTO(MatiereDTO matiereDTO) {
        this.matiereDTO = matiereDTO;
    }

    public ColorisDTO getColorisDTO() {
        return colorisDTO;
    }

    public void setColorisDTO(ColorisDTO colorisDTO) {
        this.colorisDTO = colorisDTO;
    }

    public Integer getCodeColoris() {
        return codeColoris;
    }

    public void setCodeColoris(Integer codeColoris) {
        this.codeColoris = codeColoris;
    }

    public UniteDTO getUniteDTO() {
        return uniteDTO;
    }

    public void setUniteDTO(UniteDTO uniteDTO) {
        this.uniteDTO = uniteDTO;
    }

    public Integer getCodeUnite() {
        return codeUnite;
    }

    public void setCodeUnite(Integer codeUnite) {
        this.codeUnite = codeUnite;
    }

    public DepotDTO getDepotDTO() {
        return depotDTO;
    }

    public void setDepotDTO(DepotDTO depotDTO) {
        this.depotDTO = depotDTO;
    }

    public Integer getCodeDepot() {
        return codeDepot;
    }

    public void setCodeDepot(Integer codeDepot) {
        this.codeDepot = codeDepot;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public BigDecimal getQteDispo() {
        return qteDispo;
    }

    public void setQteDispo(BigDecimal qteDispo) {
        this.qteDispo = qteDispo;
    }

    public String getUsercreate() {
        return usercreate;
    }

    public void setUsercreate(String usercreate) {
        this.usercreate = usercreate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getNumBonReception() {
        return numBonReception;
    }

    public void setNumBonReception(String numBonReception) {
        this.numBonReception = numBonReception;
    }

    public String getNumPiece() {
        return numPiece;
    }

    public void setNumPiece(String numPiece) {
        this.numPiece = numPiece;
    }

    public String getLaize() {
        return laize;
    }

    public void setLaize(String laize) {
        this.laize = laize;
    }

    
}
