/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.web;

import com.MangmentRessources.MangRess.Achat.dto.AppelOffreDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Compteur;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.CompteurDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.service.CompteurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/parametrage/")
public class CompteurRessource {
    private final CompteurService compteurService;

    public CompteurRessource(CompteurService compteurService) {
        this.compteurService = compteurService;
    }
    
        @GetMapping("compteur/{code}")
    public ResponseEntity<Compteur> getCompteurByCode(@PathVariable String code) {
        Compteur dTO = compteurService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    
}
