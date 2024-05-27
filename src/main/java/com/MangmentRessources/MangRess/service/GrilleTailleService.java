/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.GrilleTaille;
import com.MangmentRessources.MangRess.dto.GrilleTailleDTO;
import com.MangmentRessources.MangRess.factory.GrilleTailleFactory;
import com.MangmentRessources.MangRess.repository.GrilleTailleRepo;
import com.google.common.base.Preconditions;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class GrilleTailleService {
    
    private final GrilleTailleRepo grilleTailleRepo;

    public GrilleTailleService(GrilleTailleRepo grilleTailleRepo) {
        this.grilleTailleRepo = grilleTailleRepo;
    }
    
     @Transactional(readOnly = true)
    public List<GrilleTailleDTO> findAllGrilleTaille() {
        return GrilleTailleFactory.listGrilleTailleToGrilleTailleDTOs(grilleTailleRepo.findAll());

    }

    @Transactional(readOnly = true)
    public GrilleTailleDTO findOne(Integer code) {
        GrilleTaille matiere = grilleTailleRepo.getReferenceById(code);
        Preconditions.checkArgument(matiere.getCode() != null, "error.MatiereNotFound");
        return GrilleTailleFactory.grilleTailleTogrilleTailleDTO(matiere);
    }

//
    public GrilleTailleDTO save(GrilleTailleDTO dTO) {
        GrilleTaille matiere = GrilleTailleFactory.grilleTailleDTOTogrilleTaille(dTO, new GrilleTaille());
        matiere = grilleTailleRepo.save(matiere);
        return GrilleTailleFactory.grilleTailleTogrilleTailleDTO(matiere);
    }

    public GrilleTaille update(GrilleTailleDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.GrilleTailleNotFound");
        GrilleTaille grilleTaille = grilleTailleRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.GrilleTailleNotFound");
        dTO.setCode(grilleTaille.getCode());
        GrilleTailleFactory.grilleTailleDTOTogrilleTaille(dTO, grilleTaille);
        return grilleTailleRepo.save(grilleTaille);
    }

    public void delete(Integer code) {
        Preconditions.checkArgument(grilleTailleRepo.existsById(code), "error.GrilleTailleNotFound");
        grilleTailleRepo.deleteGrilleTailleByCode(code);
    }

    
}
