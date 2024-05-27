/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.FamilleArticle;
import com.MangmentRessources.MangRess.dto.FamilleArticleDTO;
import com.MangmentRessources.MangRess.factory.FamilleArticleFactory;
import com.MangmentRessources.MangRess.repository.FamilleArticleRepo; 
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
public class FamilleArticleService {
    
    private final FamilleArticleRepo familleArticleRepo;

    public FamilleArticleService(FamilleArticleRepo familleArticleRepo) {
        this.familleArticleRepo = familleArticleRepo;
    }

    

    @Transactional(readOnly = true)
    public List<FamilleArticleDTO> findAllFamilleArticle() {
        return FamilleArticleFactory.listFamilleArticleToFamilleArticleDTOs(familleArticleRepo.findAll());

    }

    @Transactional(readOnly = true)
    public FamilleArticleDTO findOne(Integer code) {
        FamilleArticle domaine = familleArticleRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.FamilleArticleNotFound");
        return FamilleArticleFactory.familleArticleToFamilleArticleDTO(domaine);
    }

//
    public FamilleArticleDTO save(FamilleArticleDTO dTO) {
        FamilleArticle domaine = FamilleArticleFactory.familleArticleDTOToFamilleArticle(dTO, new FamilleArticle());
        domaine = familleArticleRepo.save(domaine);
        return FamilleArticleFactory.familleArticleToFamilleArticleDTO(domaine);
    }

    public FamilleArticle update(FamilleArticleDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.FamilleArticleNotFound");
        FamilleArticle domaine = familleArticleRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.FamilleArticleNotFound");
        dTO.setCode(domaine.getCode());
        FamilleArticleFactory.familleArticleDTOToFamilleArticle(dTO, domaine);
        return familleArticleRepo.save(domaine);
    }

    public void delete(Integer code) {
        Preconditions.checkArgument(familleArticleRepo.existsById(code), "error.FamilleArticleNotFound");
        familleArticleRepo.deleteById(code);
    }
}
