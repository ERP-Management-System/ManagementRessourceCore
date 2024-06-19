/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.Fournisseur;
import com.MangmentRessources.MangRess.Achat.dto.FournisseurDTO;
import com.MangmentRessources.MangRess.Achat.factory.FournisseurFactory;
import com.MangmentRessources.MangRess.Achat.repository.FournisseurRepo;
import com.google.common.base.Preconditions;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Transactional
@Service
public class FournisseurService {
     private final FournisseurRepo fournisseurRepo;   

    public FournisseurService(FournisseurRepo fournisseurRepo) {
        this.fournisseurRepo = fournisseurRepo;
    }

 
 
    @Transactional(readOnly = true)
    public List<FournisseurDTO> findAllFournisseur() {
        return FournisseurFactory.listFournisseurToFournisseurDTOs(fournisseurRepo.findAll());

    }

    @Transactional(readOnly = true)
    public FournisseurDTO findOne(Integer code) {
        Fournisseur domaine = fournisseurRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.FournisseurNotFound");
        return FournisseurFactory.fournisseurToFournisseurDTO(domaine);
    }

//
    public FournisseurDTO save(FournisseurDTO dTO) {
        Fournisseur domaine = FournisseurFactory.fournisseurDTOToFournisseur(dTO, new Fournisseur());
        domaine = fournisseurRepo.save(domaine);
        return FournisseurFactory.fournisseurToFournisseurDTO(domaine);
    }

    public Fournisseur update(FournisseurDTO dTO) {
//        Preconditions.checkArgument((dTO.getCode() != null), "error.FournisseurNotFound");
        Fournisseur domaine = fournisseurRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.FournisseurNotFound");
        dTO.setCode(domaine.getCode());
        FournisseurFactory.fournisseurDTOToFournisseur(dTO, domaine);
        return fournisseurRepo.save(domaine);
    }

    public void deleteFournisseur(Integer code) {
        Preconditions.checkArgument(fournisseurRepo.existsById(code), "error.FournisseurNotFound");

//        control is used
//        List<Fournisseur> domaine = fournisseurRepo.findByCodeFournisseur(code);
//        Preconditions.checkArgument(true, "error.FournisseurUsed");
        
        
        fournisseurRepo.deleteById(code);
    }
}
