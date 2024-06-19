/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.Article;
import com.MangmentRessources.MangRess.Achat.domaine.CategorieArticle;
import com.MangmentRessources.MangRess.Achat.dto.ArticleDTO;
import com.MangmentRessources.MangRess.Achat.dto.CategorieArticleDTO;
import com.MangmentRessources.MangRess.Achat.factory.ArticleFactory;
import com.MangmentRessources.MangRess.Achat.factory.CategorieArticleFactory;
import com.MangmentRessources.MangRess.Achat.repository.CategorieArticleRepo;
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
public class CategorieArticleService {
    private final CategorieArticleRepo categorieArticleRepo;

    public CategorieArticleService(CategorieArticleRepo categorieArticleRepo) {
        this.categorieArticleRepo = categorieArticleRepo;
    }



    @Transactional(readOnly = true)
    public List<CategorieArticleDTO> findAllCategorieArticle() {
        return CategorieArticleFactory.listCategorieArticleToCategorieArticleDTOs(categorieArticleRepo.findAll());

    }

    @Transactional(readOnly = true)
    public CategorieArticleDTO findOne(Integer code) {
        CategorieArticle domaine = categorieArticleRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.CategorieArticleNotFound");
        return CategorieArticleFactory.matiereToCategorieArticleDTO(domaine);
    }

//
    public CategorieArticleDTO save(CategorieArticleDTO dTO) {
        CategorieArticle domaine = CategorieArticleFactory.matiereDTOToCategorieArticle(dTO, new CategorieArticle());
        domaine = categorieArticleRepo.save(domaine);
        return CategorieArticleFactory.matiereToCategorieArticleDTO(domaine);
    }

    public CategorieArticle update(CategorieArticleDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.CategorieArticleNotFound");
        CategorieArticle domaine = categorieArticleRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.CategorieArticleNotFound");
        dTO.setCode(domaine.getCode());
        CategorieArticleFactory.matiereDTOToCategorieArticle(dTO, domaine);
        return categorieArticleRepo.save(domaine);
    }

    public void delete(Integer code) {
        Preconditions.checkArgument(categorieArticleRepo.existsById(code), "error.CategorieArticleNotFound");
        categorieArticleRepo.deleteById(code);
    }
    
      @Transactional(readOnly = true)
    public List<CategorieArticleDTO> findByCodeFamilleArticle(Integer code) {
//        log.debug("Request to get Affectation: {}", code);
        List<CategorieArticle> list = categorieArticleRepo.findByCodeFamilleArticle(code);
        return CategorieArticleFactory.listCategorieArticleToCategorieArticleDTOs(list);
    }

}
