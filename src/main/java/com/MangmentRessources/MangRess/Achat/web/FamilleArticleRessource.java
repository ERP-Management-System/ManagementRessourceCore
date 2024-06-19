/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.FamilleArticle;
import com.MangmentRessources.MangRess.Achat.dto.FamilleArticleDTO;
import com.MangmentRessources.MangRess.Achat.service.FamilleArticleService; 
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
public class FamilleArticleRessource {
    
     private final FamilleArticleService familleArticleService;

    public FamilleArticleRessource(FamilleArticleService familleArticleService) {
        this.familleArticleService = familleArticleService;
    }

 
    @GetMapping("famille_article/{code}")
    public ResponseEntity<FamilleArticleDTO> getFamilleArticleByCode(@PathVariable Integer code) {
        FamilleArticleDTO dTO = familleArticleService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }
 

    @GetMapping("famille_article/all")
    public ResponseEntity<List<FamilleArticleDTO>> getAllFamilleArticle() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(familleArticleService.findAllFamilleArticle());
    }

    @PostMapping("famille_article")
    public ResponseEntity<FamilleArticleDTO> postFamilleArticle(@Valid @RequestBody FamilleArticleDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {

        FamilleArticleDTO result = familleArticleService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("famille_article/update")
    public ResponseEntity<FamilleArticle> updateFamilleArticle(@RequestBody @Valid FamilleArticleDTO dTO) throws URISyntaxException {

        FamilleArticle result = familleArticleService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("famille_article/delete/{code}")
    public ResponseEntity<FamilleArticle> deleteFamilleArticle(@PathVariable("code") Integer code) {
        familleArticleService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
