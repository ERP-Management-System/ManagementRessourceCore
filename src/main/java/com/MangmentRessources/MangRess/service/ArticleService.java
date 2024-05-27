/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.Article;
import com.MangmentRessources.MangRess.dto.ArticleDTO;
import com.MangmentRessources.MangRess.factory.ArticleFactory;
import com.MangmentRessources.MangRess.repository.ArticleRepo;
import com.google.common.base.Preconditions;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class ArticleService {

    private final ArticleRepo articleRepo;

    public ArticleService(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    @Transactional(readOnly = true)
    public List<ArticleDTO> findAllArticle() {
        return ArticleFactory.listArticleToArticleDTOs(articleRepo.findAll());

    }

    @Transactional(readOnly = true)
    public List<ArticleDTO> findByCodeTypeArticle(Integer code) {
//        log.debug("Request to get Affectation: {}", code);
        List<Article> articles = articleRepo.findByCodeTypeArticle(code);
        return ArticleFactory.listArticleToArticleDTOs(articles);
    }
    
    
        @Transactional(readOnly = true)
    public List<ArticleDTO> findByCodeCategorieArticle(Integer code) {
//        log.debug("Request to get Affectation: {}", code);
        List<Article> articles = articleRepo.findByCodeCategorieArticle(code);
        return ArticleFactory.listArticleToArticleDTOs(articles);
    }

    @Transactional(readOnly = true)
    public ArticleDTO findOne(Integer code) {
        Article domaine = articleRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.ArticleNotFound");
        return ArticleFactory.articleToArticleDTO(domaine);
    }

//
    public ArticleDTO save(ArticleDTO dTO) {
        Article domaine = ArticleFactory.articleDTOToArticle(dTO, new Article());
        domaine = articleRepo.save(domaine);
        return ArticleFactory.articleToArticleDTO(domaine);
    }

    public Article update(ArticleDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.ArticleNotFound");
        Article domaine = articleRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.ArticleNotFound");
        dTO.setCode(domaine.getCode());
        ArticleFactory.articleDTOToArticle(dTO, domaine);
        return articleRepo.save(domaine);
    }

    public void delete(Integer code) {
        Preconditions.checkArgument(articleRepo.existsById(code), "error.ArticleNotFound");
        articleRepo.deleteById(code);
    }
}
