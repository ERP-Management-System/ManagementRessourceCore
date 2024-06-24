/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.dto.MatiereDTO;
import com.MangmentRessources.MangRess.Achat.dto.StatuMatiereDTO;
import com.MangmentRessources.MangRess.Achat.factory.MatiereFactory;
import com.MangmentRessources.MangRess.Achat.factory.StatuMatiereFactory;
import com.MangmentRessources.MangRess.Achat.repository.MatiereRepo;
import com.MangmentRessources.MangRess.Achat.repository.StatuMatiereRepo;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class StatuMatiereService {
    
    
    private final StatuMatiereRepo statuMatiereRepo;

    public StatuMatiereService(StatuMatiereRepo statuMatiereRepo) {
        this.statuMatiereRepo = statuMatiereRepo;
    }
 

    @Transactional(readOnly = true)
    public List<StatuMatiereDTO> findAllStatuMatiere() {
        return StatuMatiereFactory.listStatuArticleToStatuArticleDTOs(statuMatiereRepo.findAll());

    }
    
}
