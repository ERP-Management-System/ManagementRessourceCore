/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.Depot;
import com.MangmentRessources.MangRess.Achat.dto.DepotDTO;
import com.MangmentRessources.MangRess.Achat.factory.DepotFactory;
import com.MangmentRessources.MangRess.Achat.repository.DepotRepo;
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
public class DepotService {

    private final DepotRepo depotRepo;

    public DepotService(DepotRepo depotRepo) {
        this.depotRepo = depotRepo;
    }

    @Transactional(readOnly = true)
    public List<DepotDTO> findAllDepot() {
        return DepotFactory.listDepotToDepotDTOs(depotRepo.findAll());

    }

    @Transactional(readOnly = true)
    public DepotDTO findOne(Integer code) {
        Depot domaine = depotRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.DepotNotFound");
        return DepotFactory.depotToDepotDTO(domaine);
    }

//      @Transactional(readOnly = true)
//    public DepotDTO findDepotPrincipal(Integer code) {
//        Depot domaine = depotRepo.getReferenceById(code);
//        Preconditions.checkArgument(domaine.getCode() != null, "error.DepotNotFound");
//        return DepotFactory.depotToDepotDTO(domaine);
//    }
    @Transactional(readOnly = true)
    public Collection<DepotDTO> findDepotPrincipal(Collection<Boolean> principal) {
        Collection<Depot> result = depotRepo.findDepotByPrincipalIn(Helper.removeNullValueFromCollection(principal));
        return DepotFactory.listDepotToDepotDTOsCollection(result);
    }

//
    public DepotDTO save(DepotDTO dTO) {
        Depot domaine = DepotFactory.depotDTOToDepot(dTO, new Depot());
        domaine = depotRepo.save(domaine);
        return DepotFactory.depotToDepotDTO(domaine);
    }

    public Depot update(DepotDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.DepotNotFound");
        Depot domaine = depotRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.DepotNotFound");
        dTO.setCode(domaine.getCode());
        DepotFactory.depotDTOToDepot(dTO, domaine);
        return depotRepo.save(domaine);
    }

    public void deleteDepot(Integer code) {
        Preconditions.checkArgument(depotRepo.existsById(code), "error.DepotNotFound");
        depotRepo.deleteById(code);
    }

}
