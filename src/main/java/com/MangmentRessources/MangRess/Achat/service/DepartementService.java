/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.Departement;
import com.MangmentRessources.MangRess.Achat.dto.DepartementDTO;
import com.MangmentRessources.MangRess.Achat.factory.DepartementFactory;
import com.MangmentRessources.MangRess.Achat.repository.DepartementRepo;
import com.MangmentRessources.MangRess.web.Util.Helper;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class DepartementService {

    private final DepartementRepo departementRepo;

    public DepartementService(DepartementRepo departementRepo) {
        this.departementRepo = departementRepo;
    }

    @Transactional(readOnly = true)
    public List<DepartementDTO> findAllDepartement() {
        return DepartementFactory.listDepartementToDepartementDTOs(departementRepo.findAll());

    }

    @Transactional(readOnly = true)
    public DepartementDTO findOne(Integer code) {
        Departement domaine = departementRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.DepartementNotFound");
        return DepartementFactory.departementToDepartementDTO(domaine);
    }

    public DepartementDTO save(DepartementDTO dTO) {
        Departement domaine = DepartementFactory.departementDTOToDepartement(dTO, new Departement());
        domaine = departementRepo.save(domaine);
        return DepartementFactory.departementToDepartementDTO(domaine);
    }

    public Departement update(DepartementDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.DepartementNotFound");
        Departement domaine = departementRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.DepartementNotFound");
        dTO.setCode(domaine.getCode());
        DepartementFactory.departementDTOToDepartement(dTO, domaine);
        return departementRepo.save(domaine);
    }

    public void deleteDepartement(Integer code) {
        Preconditions.checkArgument(departementRepo.existsById(code), "error.DepartementNotFound");
        departementRepo.deleteById(code);
    }

}
