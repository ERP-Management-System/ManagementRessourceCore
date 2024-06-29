/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.repository.DetailsAppelOffreRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
 
@Service
@Transactional
public class DetailsAppelOffreService {
private final DetailsAppelOffreRepo detailsAppelOffreRepo;

    public DetailsAppelOffreService(DetailsAppelOffreRepo detailsAppelOffreRepo) {
        this.detailsAppelOffreRepo = detailsAppelOffreRepo;
    }

  

    
    public Boolean deleteByCodeAppelOffre(Integer codeAppelOffre) {
        detailsAppelOffreRepo.deleteByCodeAppelOffre(codeAppelOffre);
        return true;
    }

}
