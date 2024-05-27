/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.ModeReglement;
import com.MangmentRessources.MangRess.domaine.ModeReglement;
import com.MangmentRessources.MangRess.dto.ModeReglementDTO;
import com.MangmentRessources.MangRess.factory.ModeReglementFactory;
import com.MangmentRessources.MangRess.repository.ModeReglementRepo;
import com.MangmentRessources.MangRess.repository.ModeReglementRepo;
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
public class ModeReglementService {
    
    private final ModeReglementRepo modeReglementRepo;

    public ModeReglementService(ModeReglementRepo modeReglementRepo) {
        this.modeReglementRepo = modeReglementRepo;
    }

 
    

 
    @Transactional(readOnly = true)
    public List<ModeReglementDTO> findAllModeReglement() {
        return ModeReglementFactory.listModeReglementToModeReglementDTOs(modeReglementRepo.findAll());

    }

    @Transactional(readOnly = true)
    public ModeReglementDTO findOne(Integer code) {
        ModeReglement matiere = modeReglementRepo.getReferenceById(code);
        Preconditions.checkArgument(matiere.getCode() != null, "error.ModeReglementNotFound");
        return ModeReglementFactory.modeReglementToModeReglementDTO(matiere);
    }

//
    public ModeReglementDTO save(ModeReglementDTO dTO) {
        ModeReglement matiere = ModeReglementFactory.modeReglementDTOToModeReglement(dTO, new ModeReglement());
        matiere = modeReglementRepo.save(matiere);
        return ModeReglementFactory.modeReglementToModeReglementDTO(matiere);
    }

    public ModeReglement update(ModeReglementDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.ModeReglementNotFound");
        ModeReglement domaine = modeReglementRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.ModeReglementNotFound");
        dTO.setCode(domaine.getCode());
        ModeReglementFactory.modeReglementDTOToModeReglement(dTO, domaine);
        return modeReglementRepo.save(domaine);
    }

    public void deleteModeReglement(Integer code) {
        Preconditions.checkArgument(modeReglementRepo.existsById(code), "error.ModeReglementNotFound");

        
////         control is used in mode_reglement
//        List<ModeReglement> domaine = modeReglementRepo.findByCodeModeReglement(code);
//        Preconditions.checkArgument(true, "error.ModeReglementUsedInCaisse");

        modeReglementRepo.deleteById(code);
    }
    
}
