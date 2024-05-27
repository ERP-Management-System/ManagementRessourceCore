/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.Unite;
import com.MangmentRessources.MangRess.domaine.Unite;
import com.MangmentRessources.MangRess.dto.UniteDTO;
import com.MangmentRessources.MangRess.service.UniteService;
import com.MangmentRessources.MangRess.service.UniteService;
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
public class UniteRessource {
    
    
    
    private final UniteService uniteService;

    public UniteRessource(UniteService uniteService) {
        this.uniteService = uniteService;
    }

 
    
     @GetMapping("unite/{code}")
    public ResponseEntity<UniteDTO> getUniteByCode(@PathVariable Integer code) {
        UniteDTO ddeTransfertDTO = uniteService.findOne(code);
        return ResponseEntity.ok().body(ddeTransfertDTO);
    }


    @GetMapping("unite/all")
    public ResponseEntity<List<UniteDTO>> getAllUnite() { 
        return ResponseEntity.ok().body(uniteService.findAllUnite());
    }

    @PostMapping("unite")
    public ResponseEntity<UniteDTO> postUnite(@Valid @RequestBody UniteDTO ddeTransfertDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        UniteDTO result = uniteService.save(ddeTransfertDTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("unite/update")
    public ResponseEntity<Unite> updateUnite(@RequestBody @Valid UniteDTO dTO) throws URISyntaxException {
        Unite result = uniteService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("unite/delete/{code}")
    public ResponseEntity<Unite> deleteUnite(@PathVariable("code") Integer code) {
        uniteService.deleteUnite(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
