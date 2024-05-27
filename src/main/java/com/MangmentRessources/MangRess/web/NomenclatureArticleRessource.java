/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.NomenclatureArticle;
import com.MangmentRessources.MangRess.dto.NomenclatureArticleDTO;
import com.MangmentRessources.MangRess.service.NomenclatureArticleService; 
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/api/parametrage_achat/")
public class NomenclatureArticleRessource {
    
    private final NomenclatureArticleService nomenclatureArticleService;

    public NomenclatureArticleRessource(NomenclatureArticleService nomenclatureArticleService) {
        this.nomenclatureArticleService = nomenclatureArticleService;
    }

 

    @GetMapping("nomenclature_article/{code}")
    public ResponseEntity<NomenclatureArticleDTO> getNomenclatureArticleByCode(@PathVariable Integer code) {
        NomenclatureArticleDTO dTO = nomenclatureArticleService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

 
    @GetMapping("nomenclature_article/all")
    public ResponseEntity<List<NomenclatureArticleDTO>> getAllNomenclatureArticle() {
        return ResponseEntity.ok().body(nomenclatureArticleService.findAllNomenclatureArticle());
    }

    @PostMapping("nomenclature_article")
    public ResponseEntity<NomenclatureArticleDTO> postNomenclatureArticle(@Valid @RequestBody NomenclatureArticleDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        NomenclatureArticleDTO result = nomenclatureArticleService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

//    @PutMapping("nomenclature_article/update")
//    public ResponseEntity<NomenclatureArticle> updateNomenclatureArticle(@RequestBody @Valid NomenclatureArticleDTO dTO) throws URISyntaxException {
//
//        NomenclatureArticle result = nomenclatureArticleService.update(dTO);
//        return ResponseEntity.ok().body(result);
//    }

    @DeleteMapping("nomenclature_article/delete/{code}")
    public ResponseEntity<NomenclatureArticle> deleteNomenclatureArticle(@PathVariable("code") Integer code) {
        nomenclatureArticleService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
