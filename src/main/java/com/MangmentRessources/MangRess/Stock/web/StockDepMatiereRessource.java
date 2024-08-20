/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.web;

import com.MangmentRessources.MangRess.ParametrageCentral.service.ParamService;
import com.MangmentRessources.MangRess.ParametrageCentral.service.SocieteService;
import com.MangmentRessources.MangRess.Stock.dto.StockDepMatiereDTO;
import com.MangmentRessources.MangRess.Stock.service.StockDepMatiereService;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/stock/")
public class StockDepMatiereRessource {
     private final StockDepMatiereService demandeTransfertMatiereService;

    public StockDepMatiereRessource(StockDepMatiereService demandeTransfertMatiereService) {
        this.demandeTransfertMatiereService = demandeTransfertMatiereService;
    }
 

 

    
    
    @GetMapping("stock_depot_matiere/findByCodeDepot")
    public ResponseEntity<Collection<StockDepMatiereDTO>> getStockDepMatiereByCode(@RequestParam Integer CodeDepot) {
        Collection<StockDepMatiereDTO> dTO = demandeTransfertMatiereService.findByCodeDepot(CodeDepot);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("stock_depot_matiere/all")
    public ResponseEntity<List<StockDepMatiereDTO>> getAllStockDepMatiere() {
        return ResponseEntity.ok().body(demandeTransfertMatiereService.findAllStockDepMatiere());
    }
 
    @PostMapping("stock_depot_matiere")
    public ResponseEntity<StockDepMatiereDTO> postDetailsStockDepMatiereNew(@Valid @RequestBody StockDepMatiereDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        StockDepMatiereDTO result = demandeTransfertMatiereService.saveStockDepMatiere(dTO);
        return ResponseEntity.created(new URI("/api/stock/" + result.getCode())).body(result);
    }

  
}
