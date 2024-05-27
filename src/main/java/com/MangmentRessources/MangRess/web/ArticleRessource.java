/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.Article;
import com.MangmentRessources.MangRess.dto.ArticleDTO;
import com.MangmentRessources.MangRess.service.ArticleService;
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
public class ArticleRessource {

    private final ArticleService articleService;

    public ArticleRessource(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("article/{code}")
    public ResponseEntity<ArticleDTO> getArticleByCode(@PathVariable Integer code) {
        ArticleDTO dTO = articleService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("article/all")
    public ResponseEntity<List<ArticleDTO>> getAllArticle() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(articleService.findAllArticle());
    }

    @PostMapping("article")
    public ResponseEntity<ArticleDTO> postArticle(@Valid @RequestBody ArticleDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {

        ArticleDTO result = articleService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("article/update")
    public ResponseEntity<Article> updateArticle(@RequestBody @Valid ArticleDTO dTO) throws URISyntaxException {

        Article result = articleService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("article/delete/{code}")
    public ResponseEntity<Article> deleteArticle(@PathVariable("code") Integer code) {
        articleService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("article/codeTypeArticle")
    public ResponseEntity<Collection<ArticleDTO>> findByCodeTypeArticle(@RequestParam(name = "codeTypeArticle") Integer codeTypeArticle) {
        return ResponseEntity.ok().body(articleService.findByCodeTypeArticle(codeTypeArticle));
    }

    @GetMapping("article/codeCategorieArticle")
    public ResponseEntity<Collection<ArticleDTO>> findByCodeCategorieArticle(@RequestParam(name = "codeCategorieArticle") Integer codeCategorieArticle) {
        return ResponseEntity.ok().body(articleService.findByCodeCategorieArticle(codeCategorieArticle));
    }
}
