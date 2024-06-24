/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.service;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.ModeReglement;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.TypeCaisse;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TypeCaisseDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.factory.TypeCaisseFactory;
import com.MangmentRessources.MangRess.ParametrageCentral.repository.ModeReglementRepo;
import com.MangmentRessources.MangRess.ParametrageCentral.repository.TypeCaisseRepo;
import com.MangmentRessources.MangRess.ParametrageCentral.repository.TypeCaisseRepo;
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
public class TypeCaisseService {

    private final TypeCaisseRepo typeCaisseRepo;
    private final ModeReglementRepo modeReglementRepo;

    public TypeCaisseService(TypeCaisseRepo typeCaisseRepo, ModeReglementRepo modeReglementRepo) {
        this.typeCaisseRepo = typeCaisseRepo;
        this.modeReglementRepo = modeReglementRepo;
    }
    
    

 
    @Transactional(readOnly = true)
    public List<TypeCaisseDTO> findAllTypeCaisse() {
        return TypeCaisseFactory.listTypeCaisseToTypeCaisseDTOs(typeCaisseRepo.findAll());

    }

    @Transactional(readOnly = true)
    public TypeCaisseDTO findOne(Integer code) {
        TypeCaisse matiere = typeCaisseRepo.getReferenceById(code);
        Preconditions.checkArgument(matiere.getCode() != null, "error.TypeCaisseNotFound");
        return TypeCaisseFactory.typeCaisseToTypeCaisseDTO(matiere);
    }

//
    public TypeCaisseDTO save(TypeCaisseDTO dTO) {
        TypeCaisse matiere = TypeCaisseFactory.typeCaisseDTOToTypeCaisse(dTO, new TypeCaisse());
        matiere = typeCaisseRepo.save(matiere);
        return TypeCaisseFactory.typeCaisseToTypeCaisseDTO(matiere);
    }

    public TypeCaisse update(TypeCaisseDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.TypeCaisseNotFound");
        TypeCaisse domaine = typeCaisseRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.TypeCaisseNotFound");
        dTO.setCode(domaine.getCode());
        TypeCaisseFactory.typeCaisseDTOToTypeCaisse(dTO, domaine);
        return typeCaisseRepo.save(domaine);
    }

    public void deleteTypeCaisse(Integer code) {
        Preconditions.checkArgument(typeCaisseRepo.existsById(code), "error.TypeCaisseNotFound");

        
//         control is used in mode_reglement
        List<ModeReglement> domaine = modeReglementRepo.findByCodeTypeCaisse(code);
        Preconditions.checkArgument(true, "error.TypeCaisseUsedInCaisse");

        typeCaisseRepo.deleteById(code);
    }
}
