/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.TypeCircuitAchat;
import com.MangmentRessources.MangRess.Achat.dto.TypeCircuitAchatDTO;
import com.MangmentRessources.MangRess.Achat.factory.TypeCircuitAchatFactory;
import com.MangmentRessources.MangRess.Achat.repository.TypeCircuitAchatRepo;
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
public class TypeCircuitAchatService {

    private final TypeCircuitAchatRepo typeCircuitAchatRepo;

    public TypeCircuitAchatService(TypeCircuitAchatRepo typeCircuitAchatRepo) {
        this.typeCircuitAchatRepo = typeCircuitAchatRepo;
    }

    @Transactional(readOnly = true)
    public List<TypeCircuitAchatDTO> findAllTypeCircuitAchat() {
        return TypeCircuitAchatFactory.listTypeCircuitAchatToTypeCircuitAchatDTOs(typeCircuitAchatRepo.findAll());

    }

    @Transactional(readOnly = true)
    public TypeCircuitAchatDTO findOne(Integer code) {
        TypeCircuitAchat matiere = typeCircuitAchatRepo.getReferenceById(code);
        Preconditions.checkArgument(matiere.getCode() != null, "error.TypeCircuitAchatNotFound");
        return TypeCircuitAchatFactory.typeCircuitAchatToTypeCircuitAchatDTO(matiere);
    }

//
    public TypeCircuitAchatDTO save(TypeCircuitAchatDTO dTO) {
        TypeCircuitAchat matiere = TypeCircuitAchatFactory.typeCircuitAchatDTOToTypeCircuitAchat(dTO, new TypeCircuitAchat());
        matiere = typeCircuitAchatRepo.save(matiere);
        return TypeCircuitAchatFactory.typeCircuitAchatToTypeCircuitAchatDTO(matiere);
    }

    public TypeCircuitAchat update(TypeCircuitAchatDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.TypeCircuitAchatNotFound");
        TypeCircuitAchat matiere = typeCircuitAchatRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.TypeCircuitAchatNotFound");
        dTO.setCode(matiere.getCode());
        TypeCircuitAchatFactory.typeCircuitAchatDTOToTypeCircuitAchat(dTO, matiere);
        return typeCircuitAchatRepo.save(matiere);
    }

    public void deleteTypeCircuitAchat(Integer code) {
        Preconditions.checkArgument(typeCircuitAchatRepo.existsById(code), "error.TypeCircuitAchatNotFound");
        typeCircuitAchatRepo.deleteById(code);
    }

}
