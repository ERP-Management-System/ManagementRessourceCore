/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.CategorieDepot;
import com.MangmentRessources.MangRess.Achat.dto.CategorieDepotDTO;
import com.MangmentRessources.MangRess.Achat.service.CategorieDepotService;
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
@RequestMapping("/api/parametrage_achat/")
public class CategorieDepotRessource {
     private final CategorieDepotService categorieDepotService;

    public CategorieDepotRessource(CategorieDepotService categorieDepotService) {
        this.categorieDepotService = categorieDepotService;
    }

    @GetMapping("categorie_depot/{code}")
    public ResponseEntity<CategorieDepotDTO> getCategorieDepotByCode(@PathVariable Integer code) {
        CategorieDepotDTO dTO = categorieDepotService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("categorie_depot/all")
    public ResponseEntity<List<CategorieDepotDTO>> getAllCategorieDepot() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(categorieDepotService.findAllCategorieDepot());
    }

    @PostMapping("categorie_depot")
    public ResponseEntity<CategorieDepotDTO> postCategorieDepot(@Valid @RequestBody CategorieDepotDTO ddeTransfertDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        CategorieDepotDTO result = categorieDepotService.save(ddeTransfertDTO);
        return ResponseEntity.created(new URI("/api/parametrage/" + result.getCode())).body(result);
    }

    @PutMapping("categorie_depot/update")
    public ResponseEntity<CategorieDepot> updateCategorieDepot(@RequestBody @Valid CategorieDepotDTO dTO) throws URISyntaxException {
        CategorieDepot result = categorieDepotService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("categorie_depot/delete/{code}")
    public ResponseEntity<CategorieDepot> deleteCategorieDepot(@PathVariable("code") Integer code) {
        categorieDepotService.deleteCategorieDepot(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
