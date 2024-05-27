/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

//import com.MangmentRessources.MangRess.domaine.Client;
import com.MangmentRessources.MangRess.domaine.Region;
import com.MangmentRessources.MangRess.dto.ClientDTO;
import com.MangmentRessources.MangRess.dto.RegionDTO;
import com.MangmentRessources.MangRess.factory.RegionFactory;
import com.MangmentRessources.MangRess.repository.ClientRepo;
import com.MangmentRessources.MangRess.repository.RegionRepo;

import com.MangmentRessources.MangRess.web.Util.Preconditions;
  
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Transactional
@Service
public class RegionService {

    private final RegionRepo regionRepo;
    private final ClientRepo clientRepo;
    private final ClientService clientService;

    public RegionService(RegionRepo regionRepo, ClientRepo clientRepo, ClientService clientService) {
        this.regionRepo = regionRepo;
        this.clientRepo = clientRepo;
        this.clientService = clientService;
    }
    
    

   

    @Transactional(readOnly = true)
    public List<RegionDTO> findAllRegion() {
        return RegionFactory.listRegionToRegionDTOs(regionRepo.findAll());

    }

    @Transactional(readOnly = true)
    public RegionDTO findOne(Integer code) {
        Region domaine = regionRepo.getReferenceById(code);
        Preconditions.checkBusinessLogique(domaine.getCode() != null, "error.RegionNotFound");
        return RegionFactory.regionToRegionDTO(domaine);
    }

//
    public RegionDTO save(RegionDTO dTO) {
        Region domaine = RegionFactory.regionDTOToRegion(dTO, new Region());
        domaine = regionRepo.save(domaine);
        return RegionFactory.regionToRegionDTO(domaine);
    }

    public Region update(RegionDTO dTO) {
        Preconditions.checkBusinessLogique((dTO.getCode() != null), "error.RegionNotFound");
        Region domaine = regionRepo.getReferenceById(dTO.getCode());
        Preconditions.checkBusinessLogique(true, "error.RegionNotFound");
        dTO.setCode(domaine.getCode());
        RegionFactory.regionDTOToRegion(dTO, domaine);
        return regionRepo.save(domaine);
    }

    public void deleteRegion(Integer code) {
        Preconditions.checkBusinessLogique(regionRepo.existsById(code), "error.RegionNotFound");

        List<ClientDTO> chambre = clientService.findByCodeRegion(code);
        Preconditions.checkBusinessLogique(chambre.isEmpty(), "error.RegionMouvmente");


        regionRepo.deleteById(code);
    }
}
