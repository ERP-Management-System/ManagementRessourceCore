/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.Matiere;
import com.MangmentRessources.MangRess.domaine.TypeArticle;
import com.MangmentRessources.MangRess.dto.TypeArticleDTO;
import com.MangmentRessources.MangRess.service.TypeArticleService;
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
public class TypeArticleRessource {
    
     private final TypeArticleService typeArticleService;

    public TypeArticleRessource(TypeArticleService typeArticleService) {
        this.typeArticleService = typeArticleService;
    }

    

    @GetMapping("type_article/{code}")
    public ResponseEntity<TypeArticleDTO> getTypeArticleByCode(@PathVariable Integer code) {
        TypeArticleDTO dTO = typeArticleService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

 

    @GetMapping("type_article/all")
    public ResponseEntity<List<TypeArticleDTO>> getAllTypeArticle() { 
        return ResponseEntity.ok().body(typeArticleService.findAllTypeArticle());
    }

    @PostMapping("type_article")
    public ResponseEntity<TypeArticleDTO> postTypeArticle(@Valid @RequestBody TypeArticleDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {

        TypeArticleDTO result = typeArticleService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("type_article/update")
    public ResponseEntity<TypeArticle> updateTypeArticle(@RequestBody @Valid TypeArticleDTO dTO) throws URISyntaxException {

        TypeArticle result = typeArticleService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("type_article/delete/{code}")
    public ResponseEntity<TypeArticle> deleteTypeArticle(@PathVariable("code") Integer code) {
        typeArticleService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
