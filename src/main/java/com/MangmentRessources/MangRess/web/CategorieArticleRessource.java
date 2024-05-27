/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.CategorieArticle;
import com.MangmentRessources.MangRess.dto.ArticleDTO;
import com.MangmentRessources.MangRess.dto.CategorieArticleDTO;
import com.MangmentRessources.MangRess.service.CategorieArticleService;
import jakarta.validation.Valid;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
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
public class CategorieArticleRessource {

    private final CategorieArticleService categorieArticleService;

    public CategorieArticleRessource(CategorieArticleService categorieArticleService) {
        this.categorieArticleService = categorieArticleService;
    }

    @GetMapping("categorie_article/{code}")
    public ResponseEntity<CategorieArticleDTO> getCategorieArticleByCode(@PathVariable Integer code) {
        CategorieArticleDTO dTO = categorieArticleService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("categorie_article/all")
    public ResponseEntity<List<CategorieArticleDTO>> getAllCategorieArticle() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(categorieArticleService.findAllCategorieArticle());
    }

    @GetMapping("categorie_article/codeFamilleArticle")
    public ResponseEntity<Collection<CategorieArticleDTO>> findByCodeFamilleArticle(@RequestParam(name = "codeFamilleArticle") Integer codeFamilleArticle) {
        return ResponseEntity.ok().body(categorieArticleService.findByCodeFamilleArticle(codeFamilleArticle));
    }

    @PostMapping("categorie_article")
    public ResponseEntity<CategorieArticleDTO> postCategorieArticle(@Valid @RequestBody CategorieArticleDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {

        CategorieArticleDTO result = categorieArticleService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("categorie_article/update")
    public ResponseEntity<CategorieArticle> updateCategorieArticle(@RequestBody @Valid CategorieArticleDTO dTO) throws URISyntaxException {

        CategorieArticle result = categorieArticleService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("categorie_article/delete/{code}")
    public ResponseEntity<CategorieArticle> deleteCategorieArticle(@PathVariable("code") Integer code) {
        categorieArticleService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
