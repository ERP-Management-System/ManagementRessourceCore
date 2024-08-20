/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.dto;

import com.MangmentRessources.MangRess.Achat.domaine.Coloris;
import com.MangmentRessources.MangRess.Achat.domaine.Depot;
import com.MangmentRessources.MangRess.Achat.domaine.Matiere;
import com.MangmentRessources.MangRess.Achat.domaine.OrdreAchat;
import com.MangmentRessources.MangRess.Achat.domaine.Unite;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 *
 * @author Administrator
 */
public class DetailsReceptionTempDTO {

    private Integer code;

    private Integer codematiere;

    private MatiereDTO matiereDTO;
    private String numPiece;

    private BigDecimal laize;

    private BigDecimal qteReceptionner;

    private OrdreAchatDTO ordreAchatDTO;

    private Integer codeOrdreAchat;

    private ColorisDTO colorisDTO;
    private Integer codeColoris;

    private UniteDTO uniteDTO;
    private Integer codeUnite;

    private DepotDTO depotDTO;
    private Integer codeDepot;

    private BigDecimal prixUnitaireAchat;

    public DetailsReceptionTempDTO() {
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

    public String getNumPiece() {
        return numPiece;
    }

    public void setNumPiece(String numPiece) {
        this.numPiece = numPiece;
    }

    public BigDecimal getLaize() {
        return laize;
    }

    public void setLaize(BigDecimal laize) {
        this.laize = laize;
    }

    public Integer getCodeOrdreAchat() {
        return codeOrdreAchat;
    }

    public void setCodeOrdreAchat(Integer codeOrdreAchat) {
        this.codeOrdreAchat = codeOrdreAchat;
    }

    public MatiereDTO getMatiereDTO() {
        return matiereDTO;
    }

    public void setMatiereDTO(MatiereDTO matiereDTO) {
        this.matiereDTO = matiereDTO;
    }

    public OrdreAchatDTO getOrdreAchatDTO() {
        return ordreAchatDTO;
    }

    public void setOrdreAchatDTO(OrdreAchatDTO ordreAchatDTO) {
        this.ordreAchatDTO = ordreAchatDTO;
    }

    public BigDecimal getQteReceptionner() {
        return qteReceptionner;
    }

    public void setQteReceptionner(BigDecimal qteReceptionner) {
        this.qteReceptionner = qteReceptionner;
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

    public BigDecimal getPrixUnitaireAchat() {
        return prixUnitaireAchat;
    }

    public void setPrixUnitaireAchat(BigDecimal prixUnitaireAchat) {
        this.prixUnitaireAchat = prixUnitaireAchat;
    }
    
    

}
