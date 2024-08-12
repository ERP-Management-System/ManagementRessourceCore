/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.service;

import com.MangmentRessources.MangRess.Achat.repository.DetailsAppelOffreRepo;
import com.MangmentRessources.MangRess.Stock.repository.DetailsDemandeTransfertMatiereRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class DetailsDemandeTransfertMatiereService {
    private final DetailsDemandeTransfertMatiereRepo demandeTransfertMatiereRepo;

    public DetailsDemandeTransfertMatiereService(DetailsDemandeTransfertMatiereRepo demandeTransfertMatiereRepo) {
        this.demandeTransfertMatiereRepo = demandeTransfertMatiereRepo;
    }
    
    
 
  

    
    public Boolean deleteByCodeDemandeTransfertMatiere(Integer CodeDemandeTransfertMatiere) {
        demandeTransfertMatiereRepo.deleteByCodeDemandeTransfertMatiere(CodeDemandeTransfertMatiere);
        return true;
    }
}
