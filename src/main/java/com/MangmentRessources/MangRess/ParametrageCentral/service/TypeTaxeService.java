/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.service;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Taxe;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.TypeTaxe;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TaxeDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TypeTaxeDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.factory.TaxeFactory;
import com.MangmentRessources.MangRess.ParametrageCentral.factory.TypeTaxeFactory;
import com.MangmentRessources.MangRess.ParametrageCentral.repository.TaxeRepo;
import com.MangmentRessources.MangRess.ParametrageCentral.repository.TypeTaxeRepo;
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
public class TypeTaxeService {
     private final TypeTaxeRepo typeTaxeRepo; 

    public TypeTaxeService(TypeTaxeRepo typeTaxeRepo) {
        this.typeTaxeRepo = typeTaxeRepo;
    }

   
    

   

    @Transactional(readOnly = true)
    public List<TypeTaxeDTO> findAllTypeTaxe() {
        return TypeTaxeFactory.listTypeTaxeToTypeTaxeDTOs(typeTaxeRepo.findAll());

    }

    @Transactional(readOnly = true)
    public TypeTaxeDTO findOne(Integer code) {
        TypeTaxe domaine = typeTaxeRepo.getReferenceById(code);
        Preconditions.checkBusinessLogique(domaine.getCode() != null, "error.TypeTaxeNotFound");
        return TypeTaxeFactory.typeTaxeToTypeTaxeDTO(domaine);
    }

//
    
}
