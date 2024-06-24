/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.web;

import com.MangmentRessources.MangRess.Achat.dto.DepotDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Taxe;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TaxeDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.service.TaxeService;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/api/parametrage/")
public class TaxeRessource {
    
     private final TaxeService taxeService;

    public TaxeRessource(TaxeService taxeService) {
        this.taxeService = taxeService;
    }

    @GetMapping("taxe/{code}")
    public ResponseEntity<TaxeDTO> getTaxeByCode(@PathVariable Integer code) {
        TaxeDTO dTO = taxeService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("taxe/all")
    public ResponseEntity<List<TaxeDTO>> getAllTaxe() { 
        return ResponseEntity.ok().body(taxeService.findAllTaxe());
    }
    
        @GetMapping("taxe/type_taxe")
    public ResponseEntity<Collection<TaxeDTO>> getDepotPrincipal(@RequestParam Collection<Integer> type_taxe) {
        Collection<TaxeDTO> dTOs = taxeService.findByTypeTaxe(type_taxe);
        return ResponseEntity.ok().body(dTOs);
    }


    @PostMapping("taxe")
    public ResponseEntity<TaxeDTO> postTaxe(@Valid @RequestBody TaxeDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        TaxeDTO result = taxeService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage/" + result.getCode())).body(result);
    }

    @PutMapping("taxe/update")
    public ResponseEntity<Taxe> updateTaxe(@RequestBody @Valid TaxeDTO dTO) throws URISyntaxException {
        Taxe result = taxeService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("taxe/delete/{code}")
    public ResponseEntity<Taxe> deleteTaxe(@PathVariable("code") Integer code) {
        taxeService.deleteTaxe(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
