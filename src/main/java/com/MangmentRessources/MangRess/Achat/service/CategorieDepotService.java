/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.CategorieDepot;
import com.MangmentRessources.MangRess.Achat.dto.CategorieDepotDTO;
import com.MangmentRessources.MangRess.Achat.factory.CategorieDepotFactory;
import com.MangmentRessources.MangRess.Achat.repository.CategorieDepotRepo; 
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
public class CategorieDepotService {
     private final CategorieDepotRepo categorieDepotRepo;

    public CategorieDepotService(CategorieDepotRepo categorieDepotRepo) {
        this.categorieDepotRepo = categorieDepotRepo;
    }

    @Transactional(readOnly = true)
    public List<CategorieDepotDTO> findAllCategorieDepot() {
        return CategorieDepotFactory.listCategorieDepotToCategorieDepotDTOs(categorieDepotRepo.findAll());

    }

    @Transactional(readOnly = true)
    public CategorieDepotDTO findOne(Integer code) {
        CategorieDepot domaine = categorieDepotRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.CategorieDepotNotFound");
        return CategorieDepotFactory.categorieDepotToCategorieDepotDTO(domaine);
    }

//
    public CategorieDepotDTO save(CategorieDepotDTO dTO) {
        CategorieDepot domaine = CategorieDepotFactory.categorieDepotDTOToCategorieDepot(dTO, new CategorieDepot());
        domaine = categorieDepotRepo.save(domaine);
        return CategorieDepotFactory.categorieDepotToCategorieDepotDTO(domaine);
    }

    public CategorieDepot update(CategorieDepotDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.CategorieDepotNotFound");
        CategorieDepot domaine = categorieDepotRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.CategorieDepotNotFound");
        dTO.setCode(domaine.getCode());
        CategorieDepotFactory.categorieDepotDTOToCategorieDepot(dTO, domaine);
        return categorieDepotRepo.save(domaine);
    }

    public void deleteCategorieDepot(Integer code) {
        Preconditions.checkArgument(categorieDepotRepo.existsById(code), "error.CategorieDepotNotFound");
        categorieDepotRepo.deleteById(code);
    }
    
}
