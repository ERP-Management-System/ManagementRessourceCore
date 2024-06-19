/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.EtatReception;
import com.MangmentRessources.MangRess.Achat.dto.EtatReceptionDTO;
import com.MangmentRessources.MangRess.Achat.service.EtatReceptionService;
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
public class EtatReceptionRessource {
    
    private final EtatReceptionService etatReceptionService;

    public EtatReceptionRessource(EtatReceptionService etatReceptionService) {
        this.etatReceptionService = etatReceptionService;
    }
    
    
     @GetMapping("etatReception/{code}")
    public ResponseEntity<EtatReceptionDTO> getEtatReceptionByCode(@PathVariable Integer code) {
        EtatReceptionDTO dTO = etatReceptionService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }


    @GetMapping("etatReception/all")
    public ResponseEntity<List<EtatReceptionDTO>> getAllEtatReception() { 
        return ResponseEntity.ok().body(etatReceptionService.findAllEtatReception());
    }

    @PostMapping("etatReception")
    public ResponseEntity<EtatReceptionDTO> postEtatReception(@Valid @RequestBody EtatReceptionDTO ddeTransfertDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        EtatReceptionDTO result = etatReceptionService.save(ddeTransfertDTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("etatReception/update")
    public ResponseEntity<EtatReception> updateEtatReception(@RequestBody @Valid EtatReceptionDTO dTO) throws URISyntaxException {
        EtatReception result = etatReceptionService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

 
    
}
