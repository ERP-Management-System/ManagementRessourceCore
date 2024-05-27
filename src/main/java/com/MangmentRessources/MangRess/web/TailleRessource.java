/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.Taille;
import com.MangmentRessources.MangRess.dto.TailleDTO;
import com.MangmentRessources.MangRess.service.TailleService;
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
public class TailleRessource {
    
    
     private final TailleService tailleService;

    public TailleRessource(TailleService tailleService) {
        this.tailleService = tailleService;
    }

 

    @GetMapping("taille/{code}")
    public ResponseEntity<TailleDTO> getTailleByCode(@PathVariable Integer code) {
        TailleDTO dTO = tailleService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }
 
    @GetMapping("taille/all")
    public ResponseEntity<List<TailleDTO>> getAllTaille() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(tailleService.findAllTaille());
    }

    @PostMapping("taille")
    public ResponseEntity<TailleDTO> postTaille(@Valid @RequestBody TailleDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {

        TailleDTO result = tailleService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("taille/update")
    public ResponseEntity<Taille> updateTaille(@RequestBody @Valid TailleDTO ddeTransfertDTO) throws URISyntaxException {

        Taille result = tailleService.update(ddeTransfertDTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("taille/delete/{code}")
    public ResponseEntity<Taille> deleteTaille(@PathVariable("code") Integer code) {
        tailleService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
