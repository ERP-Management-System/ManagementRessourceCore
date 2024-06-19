/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.TypeMatiere;
import com.MangmentRessources.MangRess.Achat.dto.TypeMatiereDTO;
import com.MangmentRessources.MangRess.Achat.service.TypeMatiereService;
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
public class TypeMatiereRessource {
    
    private final TypeMatiereService typeMatiereService;

    public TypeMatiereRessource(TypeMatiereService typeMatiereService) {
        this.typeMatiereService = typeMatiereService;
    }

 
    
    
    @GetMapping("type_matiere/{code}")
    public ResponseEntity<TypeMatiereDTO> getMatiereByCode(@PathVariable Integer code) {
        TypeMatiereDTO dTO = typeMatiereService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

 
    @GetMapping("type_matiere/all")
    public ResponseEntity<List<TypeMatiereDTO>> getAllMatiere() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(typeMatiereService.findAllTypeMatiere());
    }

    @PostMapping("type_matiere")
    public ResponseEntity<TypeMatiereDTO> postTypeMatiere(@Valid @RequestBody TypeMatiereDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {

        TypeMatiereDTO result = typeMatiereService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("type_matiere/update")
    public ResponseEntity<TypeMatiere> updateMatiere(@RequestBody @Valid TypeMatiereDTO dTO) throws URISyntaxException {

        TypeMatiere result = typeMatiereService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("type_matiere/delete/{code}")
    public ResponseEntity<TypeMatiere> deleteTypeMatiere(@PathVariable("code") Integer code) {
        typeMatiereService.deleteTypeMatiere(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
