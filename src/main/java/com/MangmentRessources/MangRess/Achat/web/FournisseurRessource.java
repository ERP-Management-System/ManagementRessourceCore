/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.Fournisseur;
import com.MangmentRessources.MangRess.Achat.dto.FournisseurDTO;
import com.MangmentRessources.MangRess.Achat.service.FournisseurService;
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
public class FournisseurRessource {
    
    private final FournisseurService fournisseurService;

    public FournisseurRessource(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping("fournisseur/{code}")
    public ResponseEntity<FournisseurDTO> getFournisseurByCode(@PathVariable Integer code) {
        FournisseurDTO dTO = fournisseurService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("fournisseur/all")
    public ResponseEntity<List<FournisseurDTO>> getAllFournisseur() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(fournisseurService.findAllFournisseur());
    }

    @PostMapping("fournisseur")
    public ResponseEntity<FournisseurDTO> postFournisseur(@Valid @RequestBody FournisseurDTO ddeTransfertDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        FournisseurDTO result = fournisseurService.save(ddeTransfertDTO);
        return ResponseEntity.created(new URI("/api/parametrage/" + result.getCode())).body(result);
    }

    @PutMapping("fournisseur/update")
    public ResponseEntity<Fournisseur> updateFournisseur(@RequestBody @Valid FournisseurDTO dTO) throws URISyntaxException {
        Fournisseur result = fournisseurService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("fournisseur/delete/{code}")
    public ResponseEntity<Fournisseur> deleteFournisseur(@PathVariable("code") Integer code) {
        fournisseurService.deleteFournisseur(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
