/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.TypeMatiere;
import com.MangmentRessources.MangRess.dto.TypeMatiereDTO;
import com.MangmentRessources.MangRess.factory.TypeMatiereFactory;
import com.MangmentRessources.MangRess.repository.TypeMatiereRepo;
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
public class TypeMatiereService {
    
    private final TypeMatiereRepo typeMatiereRepo;

    public TypeMatiereService(TypeMatiereRepo typeMatiereRepo) {
        this.typeMatiereRepo = typeMatiereRepo;
    }

  
    
     @Transactional(readOnly = true)
    public List<TypeMatiereDTO> findAllTypeMatiere() {
        return TypeMatiereFactory.listTypeMatiereToTypeMatiereDTOs(typeMatiereRepo.findAll());

    }

    @Transactional(readOnly = true)
    public TypeMatiereDTO findOne(Integer code) {
        TypeMatiere domaine = typeMatiereRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.TypeMatiereNotFound");
        return TypeMatiereFactory.typeMatiereToTypeMatiereDTO(domaine);
    }

//
    public TypeMatiereDTO save(TypeMatiereDTO dTO) {
        TypeMatiere domaine = TypeMatiereFactory.typeMatiereDTOToTypeMatiere(dTO, new TypeMatiere());
        domaine = typeMatiereRepo.save(domaine);
        return TypeMatiereFactory.typeMatiereToTypeMatiereDTO(domaine);
    }

    public TypeMatiere update(TypeMatiereDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.TypeMatiereNotFound");
        TypeMatiere domaine = typeMatiereRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.TypeMatiereNotFound");
        dTO.setCode(domaine.getCode());
        TypeMatiereFactory.typeMatiereDTOToTypeMatiere(dTO, domaine);
        return typeMatiereRepo.save(domaine);
    }

    public void deleteTypeMatiere(Integer code) {
        Preconditions.checkArgument(typeMatiereRepo.existsById(code), "error.TypeMatiereNotFound");
        typeMatiereRepo.deleteTypeMatiereByCode(code);
    }

    
    
}
