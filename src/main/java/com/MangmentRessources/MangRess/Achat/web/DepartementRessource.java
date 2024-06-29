/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.Departement;
import com.MangmentRessources.MangRess.Achat.dto.DepartementDTO;
import com.MangmentRessources.MangRess.Achat.service.DepartementService;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/parametrage_achat/")
public class DepartementRessource {
    
    private final DepartementService departementService;

    public DepartementRessource(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping("departement/{code}")
    public ResponseEntity<DepartementDTO> getDepartementByCode(@PathVariable Integer code) {
        DepartementDTO dTO = departementService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("departement/all")
    public ResponseEntity<List<DepartementDTO>> getAllDepartement() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(departementService.findAllDepartement());
    }

 
    @PostMapping("departement")
    public ResponseEntity<DepartementDTO> postDepartement(@Valid @RequestBody DepartementDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        DepartementDTO result = departementService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage/" + result.getCode())).body(result);
    }

    @PutMapping("departement/update")
    public ResponseEntity<Departement> updateDepartement(@RequestBody @Valid DepartementDTO dTO) throws URISyntaxException {
        Departement result = departementService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("departement/delete/{code}")
    public ResponseEntity<Departement> deleteDepartement(@PathVariable("code") Integer code) {
        departementService.deleteDepartement(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
