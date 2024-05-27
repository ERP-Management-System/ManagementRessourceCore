/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.ModeReglement;
import com.MangmentRessources.MangRess.dto.ModeReglementDTO;
import com.MangmentRessources.MangRess.service.ModeReglementService;
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
public class ModeReglementRessource {
    
    private final ModeReglementService modeReglementServiceService;

    public ModeReglementRessource(ModeReglementService modeReglementServiceService) {
        this.modeReglementServiceService = modeReglementServiceService;
    }
    
    
     @GetMapping("mode_reglement/{code}")
    public ResponseEntity<ModeReglementDTO> getModeReglementByCode(@PathVariable Integer code) {
        ModeReglementDTO dTO = modeReglementServiceService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }


    @GetMapping("mode_reglement/all")
    public ResponseEntity<List<ModeReglementDTO>> getAllModeReglement() { 
        return ResponseEntity.ok().body(modeReglementServiceService.findAllModeReglement());
    }

    @PostMapping("mode_reglement")
    public ResponseEntity<ModeReglementDTO> postModeReglement(@Valid @RequestBody ModeReglementDTO ddeTransfertDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        ModeReglementDTO result = modeReglementServiceService.save(ddeTransfertDTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("mode_reglement/update")
    public ResponseEntity<ModeReglement> updateModeReglement(@RequestBody @Valid ModeReglementDTO dTO) throws URISyntaxException {
        ModeReglement result = modeReglementServiceService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("mode_reglement/delete/{code}")
    public ResponseEntity<ModeReglement> deleteModeReglement(@PathVariable("code") Integer code) {
        modeReglementServiceService.deleteModeReglement(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
