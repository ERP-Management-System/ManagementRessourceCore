/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.Taille;
import com.MangmentRessources.MangRess.dto.TailleDTO;
import com.MangmentRessources.MangRess.factory.TailleFactory;
import com.MangmentRessources.MangRess.repository.TailleRepo;
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
public class TailleService {
    
    
    private final TailleRepo tailleRepo;

    public TailleService(TailleRepo tailleRepo) {
        this.tailleRepo = tailleRepo;
    }

   

    @Transactional(readOnly = true)
    public List<TailleDTO> findAllTaille() {
        return TailleFactory.listTailleToTailleDTOs(tailleRepo.findAll());

    }

    @Transactional(readOnly = true)
    public TailleDTO findOne(Integer code) {
        Taille domaine = tailleRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.TailleNotFound");
        return TailleFactory.tailleToTailleDTO(domaine);
    }

//
    public TailleDTO save(TailleDTO dTO) {
        Taille domaine = TailleFactory.tailleDTOToTaille(dTO, new Taille());
        domaine = tailleRepo.save(domaine);
        return TailleFactory.tailleToTailleDTO(domaine);
    }

    public Taille update(TailleDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.TailleNotFound");
        Taille domaine = tailleRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.TailleNotFound");
        dTO.setCode(domaine.getCode());
        TailleFactory.tailleDTOToTaille(dTO, domaine);
        return tailleRepo.save(domaine);
    }

    public void delete(Integer code) {
        Preconditions.checkArgument(tailleRepo.existsById(code), "error.TailleNotFound");
        tailleRepo.deleteTailleByCode(code);
    }

}
