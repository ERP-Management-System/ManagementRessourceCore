/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.web;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.TypeCaisse;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.TypeCaisseDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.service.TypeCaisseService;
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
public class TypeCaisseRessource {
     
    private final TypeCaisseService type_caisseService;

    public TypeCaisseRessource(TypeCaisseService type_caisseService) {
        this.type_caisseService = type_caisseService;
    }
    
    
     @GetMapping("type_caisse/{code}")
    public ResponseEntity<TypeCaisseDTO> getTypeCaisseByCode(@PathVariable Integer code) {
        TypeCaisseDTO ddeTransfertDTO = type_caisseService.findOne(code);
        return ResponseEntity.ok().body(ddeTransfertDTO);
    }


    @GetMapping("type_caisse/all")
    public ResponseEntity<List<TypeCaisseDTO>> getAllTypeCaisse() {
        return ResponseEntity.ok().body(type_caisseService.findAllTypeCaisse());
    }

    @PostMapping("type_caisse")
    public ResponseEntity<TypeCaisseDTO> postTypeCaisse(@Valid @RequestBody TypeCaisseDTO ddeTransfertDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        TypeCaisseDTO result = type_caisseService.save(ddeTransfertDTO);
        return ResponseEntity.created(new URI("/api/parametrage/" + result.getCode())).body(result);
    }

    @PutMapping("type_caisse/update")
    public ResponseEntity<TypeCaisse> updateTypeCaisse(@RequestBody @Valid TypeCaisseDTO dTO) throws URISyntaxException {
        TypeCaisse result = type_caisseService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("type_caisse/delete/{code}")
    public ResponseEntity<TypeCaisse> deleteTypeCaisse(@PathVariable("code") Integer code) {
        type_caisseService.deleteTypeCaisse(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
