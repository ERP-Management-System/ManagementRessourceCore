/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.Unite;
import com.MangmentRessources.MangRess.dto.UniteDTO;
import com.MangmentRessources.MangRess.factory.UniteFactory;
import com.MangmentRessources.MangRess.repository.UniteRepo;
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
public class UniteService {

    private final UniteRepo uniteRepo;

    public UniteService(UniteRepo uniteRepo) {
        this.uniteRepo = uniteRepo;
    }

    @Transactional(readOnly = true)
    public List<UniteDTO> findAllUnite() {
        return UniteFactory.listUniteToUniteDTOs(uniteRepo.findAll());

    }

    @Transactional(readOnly = true)
    public UniteDTO findOne(Integer code) {
        Unite matiere = uniteRepo.getReferenceById(code);
        Preconditions.checkArgument(matiere.getCode() != null, "error.UniteNotFound");
        return UniteFactory.uniteToUniteDTO(matiere);
    }
    
        @Transactional(readOnly = true)
    public UniteDTO findOneToAO(Integer code) {
        Unite matiere = uniteRepo.getReferenceById(code);
        Preconditions.checkArgument(matiere.getCode() != null, "error.UniteNotFound");
        return UniteFactory.uniteToUniteDTO(matiere);
    }

//
    public UniteDTO save(UniteDTO dTO) {
        Unite matiere = UniteFactory.uniteDTOToUnite(dTO, new Unite());
        matiere = uniteRepo.save(matiere);
        return UniteFactory.uniteToUniteDTO(matiere);
    }

    public Unite update(UniteDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.UniteNotFound");
        Unite matiere = uniteRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.UniteNotFound");
        dTO.setCode(matiere.getCode());
        UniteFactory.uniteDTOToUnite(dTO, matiere);
        return uniteRepo.save(matiere);
    }

    public void deleteUnite(Integer code) {
        Preconditions.checkArgument(uniteRepo.existsById(code), "error.UniteNotFound");
        uniteRepo.deleteUniteByCode(code);
    }
}
