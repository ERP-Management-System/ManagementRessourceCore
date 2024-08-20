/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.service;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Compteur;
import com.MangmentRessources.MangRess.Stock.domaine.StockDepMatiere;
import com.MangmentRessources.MangRess.Stock.domaine.StockDepMatiere;
import com.MangmentRessources.MangRess.Stock.dto.StockDepMatiereDTO;
import com.MangmentRessources.MangRess.Stock.dto.StockDepMatiereDTO;
import com.MangmentRessources.MangRess.Stock.dto.StockDepMatiereDTO;
import com.MangmentRessources.MangRess.Stock.factory.StockDepMatiereFactory;
import com.MangmentRessources.MangRess.Stock.factory.StockDepMatiereFactory;
import com.MangmentRessources.MangRess.Stock.factory.StockDepMatiereFactory;
import com.MangmentRessources.MangRess.Stock.repository.StockDepMatiereRepo;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class StockDepMatiereService {

    private final StockDepMatiereRepo stockDepMatiereRepo;

    public StockDepMatiereService(StockDepMatiereRepo stockDepMatiereRepo) {
        this.stockDepMatiereRepo = stockDepMatiereRepo;
    }

    @Transactional(readOnly = true)
    public List<StockDepMatiereDTO> findAllStockDepMatiere() {
        return StockDepMatiereFactory.listStockDepMatiereToStockDepMatiereDTOs(stockDepMatiereRepo.findAll());
    }

    @Transactional(readOnly = true)
    public Collection<StockDepMatiereDTO> findByCodeDepot(Integer codeDepot) {
        Collection<StockDepMatiere> collection = stockDepMatiereRepo.findByCodeDepot(codeDepot); 
        return StockDepMatiereFactory.detailsStockDepMatiereTodetailsStockDepMatiereDTOCollection(collection);
    }

    public StockDepMatiereDTO saveStockDepMatiere(StockDepMatiereDTO Dto) {
        StockDepMatiere domaine = StockDepMatiereFactory.StockDepMatiereDTOToStockDepMatiereWithDetails(new StockDepMatiere(), Dto);
        domaine.setCode(null);
        domaine.setUsercreate(domaine.getUsercreate());
        domaine.setDateCreate(new Date());
        domaine = stockDepMatiereRepo.save(domaine);
        StockDepMatiereDTO resultDTO = StockDepMatiereFactory.StockDepMatiereToStockDepMatiereDTO(domaine);
        return resultDTO;
    }

}
