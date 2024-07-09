/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.service;

import com.MangmentRessources.MangRess.Achat.domaine.Depot;
import com.MangmentRessources.MangRess.Achat.dto.ClientDTO;
import com.MangmentRessources.MangRess.Achat.dto.DepotDTO;
import com.MangmentRessources.MangRess.Achat.factory.DepotFactory;
import com.MangmentRessources.MangRess.Achat.repository.ClientRepo;
import com.MangmentRessources.MangRess.Achat.service.ClientService;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Taxe;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TaxeDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.factory.TaxeFactory;
import com.MangmentRessources.MangRess.ParametrageCentral.repository.TaxeRepo;
import com.MangmentRessources.MangRess.web.Util.Helper;
import com.MangmentRessources.MangRess.web.Util.Preconditions;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Transactional
@Service
public class TaxeService {

    private final TaxeRepo taxeRepo;

    public TaxeService(TaxeRepo taxeRepo) {
        this.taxeRepo = taxeRepo;
    }

    @Transactional(readOnly = true)
    public List<TaxeDTO> findAllTaxe() {
        return TaxeFactory.listTaxeToTaxeDTOs(taxeRepo.findAll());

    }

    @Transactional(readOnly = true)
    public TaxeDTO findOne(Integer code) {
        Taxe domaine = taxeRepo.getReferenceById(code);
        Preconditions.checkBusinessLogique(domaine.getCode() != null, "error.TaxeNotFound");
        return TaxeFactory.taxeToTaxeDTO(domaine);
    }

    @Transactional(readOnly = true)
    public Collection<TaxeDTO> findByTypeTaxe(Collection<Integer> codeTypeTaxe) {

        Collection<Taxe> result = taxeRepo.findTaxeByCodeTypeTaxeIn(Helper.removeNullValueFromCollection(codeTypeTaxe));

        return TaxeFactory.listTaxeToTaxeDTOsCollection(result);
    }

//
    public TaxeDTO save(TaxeDTO dTO) {
        Taxe domaine = TaxeFactory.taxeDTOToTaxe(dTO, new Taxe());
        domaine = taxeRepo.save(domaine);
        return TaxeFactory.taxeToTaxeDTO(domaine);
    }

    public Taxe update(TaxeDTO dTO) {
        Preconditions.checkBusinessLogique((dTO.getCode() != null), "error.TaxeNotFound");
        Taxe domaine = taxeRepo.getReferenceById(dTO.getCode());
        Preconditions.checkBusinessLogique(true, "error.TaxeNotFound");
        dTO.setCode(domaine.getCode());
        TaxeFactory.taxeDTOToTaxe(dTO, domaine);
        return taxeRepo.save(domaine);
    }

    public void deleteTaxe(Integer code) {
//        Preconditions.checkBusinessLogique(taxeRepo.getReferenceById(code), "error.TaxeNotFound");
        Taxe domaine = taxeRepo.getReferenceById(code);
        Preconditions.checkBusinessLogique(true, "error.TaxeNotFound");
        taxeRepo.deleteById(code);
    }

}
