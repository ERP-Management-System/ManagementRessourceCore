/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.TypeCircuitAchat;
import com.MangmentRessources.MangRess.Achat.dto.TypeCircuitAchatDTO;
import com.MangmentRessources.MangRess.Achat.service.TypeCircuitAchatService;
import com.MangmentRessources.MangRess.Achat.service.TypeCircuitAchatService;
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
public class TypeCircuitAchatRessource {
     private final TypeCircuitAchatService typeCircuitAchatService;

    public TypeCircuitAchatRessource(TypeCircuitAchatService typeCircuitAchatService) {
        this.typeCircuitAchatService = typeCircuitAchatService;
    }
 
 
    
     @GetMapping("type_circuit_achat/{code}")
    public ResponseEntity<TypeCircuitAchatDTO> getTypeCircuitAchatByCode(@PathVariable Integer code) {
        TypeCircuitAchatDTO ddeTransfertDTO = typeCircuitAchatService.findOne(code);
        return ResponseEntity.ok().body(ddeTransfertDTO);
    }


    @GetMapping("type_circuit_achat/all")
    public ResponseEntity<List<TypeCircuitAchatDTO>> getAllTypeCircuitAchat() { 
        return ResponseEntity.ok().body(typeCircuitAchatService.findAllTypeCircuitAchat());
    }

    @PostMapping("type_circuit_achat")
    public ResponseEntity<TypeCircuitAchatDTO> postTypeCircuitAchat(@Valid @RequestBody TypeCircuitAchatDTO ddeTransfertDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        TypeCircuitAchatDTO result = typeCircuitAchatService.save(ddeTransfertDTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("type_circuit_achat/update")
    public ResponseEntity<TypeCircuitAchat> updateTypeCircuitAchat(@RequestBody @Valid TypeCircuitAchatDTO dTO) throws URISyntaxException {
        TypeCircuitAchat result = typeCircuitAchatService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("type_circuit_achat/delete/{code}")
    public ResponseEntity<TypeCircuitAchat> deleteTypeCircuitAchat(@PathVariable("code") Integer code) {
        typeCircuitAchatService.deleteTypeCircuitAchat(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
