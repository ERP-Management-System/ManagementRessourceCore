/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.GrilleTaille;
import com.MangmentRessources.MangRess.Achat.domaine.Matiere;
import com.MangmentRessources.MangRess.Achat.dto.GrilleTailleDTO;
import com.MangmentRessources.MangRess.Achat.service.GrilleTailleService;
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
public class GrilleTailleRessource {
    
    private final GrilleTailleService grilleTailleService;

    public GrilleTailleRessource(GrilleTailleService grilleTailleService) {
        this.grilleTailleService = grilleTailleService;
    }
    
    
    
    @GetMapping("grille_taille/{code}")
    public ResponseEntity<GrilleTailleDTO> getGrilleTailleByCode(@PathVariable Integer code) {
        GrilleTailleDTO dTO = grilleTailleService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }
 
    @GetMapping("grille_taille/all")
    public ResponseEntity<List<GrilleTailleDTO>> getAllGrilleTaille() { 
        return ResponseEntity.ok().body(grilleTailleService.findAllGrilleTaille());
    }

    @PostMapping("grille_taille")
    public ResponseEntity<GrilleTailleDTO> postGrilleTaille(@Valid @RequestBody GrilleTailleDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {

        GrilleTailleDTO result = grilleTailleService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("grille_taille/update")
    public ResponseEntity<GrilleTaille> updateGrilleTaille(@RequestBody @Valid GrilleTailleDTO ddeTransfertDTO) throws URISyntaxException {

        GrilleTaille result = grilleTailleService.update(ddeTransfertDTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("grille_taille/delete/{code}")
    public ResponseEntity<GrilleTaille> deleteGrilleTaille(@PathVariable("code") Integer code) {
        grilleTailleService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
