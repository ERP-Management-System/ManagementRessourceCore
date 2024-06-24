/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.web;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Taxe;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TaxeDTO; 
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TypeTaxeDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.service.TypeTaxeService;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/parametrage/")
public class TypeTaxeRessource {
     private final TypeTaxeService typeTaxeService;

    public TypeTaxeRessource(TypeTaxeService typeTaxeService) {
        this.typeTaxeService = typeTaxeService;
    }

    

    @GetMapping("type_taxe/{code}")
    public ResponseEntity<TypeTaxeDTO> getTaxeByCode(@PathVariable Integer code) {
        TypeTaxeDTO dTO = typeTaxeService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("type_taxe/all")
    public ResponseEntity<List<TypeTaxeDTO>> getAllTaxe() {
        return ResponseEntity.ok().body(typeTaxeService.findAllTypeTaxe());
    }

  
}
