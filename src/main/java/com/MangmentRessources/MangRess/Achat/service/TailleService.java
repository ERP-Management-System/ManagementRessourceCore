/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.Taille;
import com.MangmentRessources.MangRess.Achat.dto.TailleDTO;
import com.MangmentRessources.MangRess.Achat.factory.TailleFactory;
import com.MangmentRessources.MangRess.Achat.repository.TailleRepo;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
    public TailleDTO findOne(Integer id) { 
        Taille domaine = tailleRepo.getReferenceById(id);
        Preconditions.checkArgument(domaine.getCode() != null, "error.TailleNotFound");
        return TailleFactory.tailleToTailleDTO(domaine);
        
        
        
    }
//    public Optional<Taille> findOne(Integer id) {
//    return tailleRepo.findById(id);
//}
//    
 
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
