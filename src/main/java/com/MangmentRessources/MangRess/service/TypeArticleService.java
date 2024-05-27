/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.TypeArticle;
import com.MangmentRessources.MangRess.dto.TypeArticleDTO;
import com.MangmentRessources.MangRess.factory.TypeArticleFactory;
import com.MangmentRessources.MangRess.repository.TypeArticleRepo;
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
public class TypeArticleService {
    
     private final TypeArticleRepo typeArticleRepo;

    public TypeArticleService(TypeArticleRepo typeArticleRepo) {
        this.typeArticleRepo = typeArticleRepo;
    }
 
    @Transactional(readOnly = true)
    public List<TypeArticleDTO> findAllTypeArticle() {
        return TypeArticleFactory.listTypeArticleToTypeArticleDTOs(typeArticleRepo.findAll());

    }

    @Transactional(readOnly = true)
    public TypeArticleDTO findOne(Integer code) {
        TypeArticle domaine = typeArticleRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.TypeArticleNotFound");
        return TypeArticleFactory.typeArticleToTypeArticleDTO(domaine);
    }

//
    public TypeArticleDTO save(TypeArticleDTO dTO) {
        TypeArticle domaine = TypeArticleFactory.typeArticleDTOToTypeArticle(dTO, new TypeArticle());
        domaine = typeArticleRepo.save(domaine);
        return TypeArticleFactory.typeArticleToTypeArticleDTO(domaine);
    }

    public TypeArticle update(TypeArticleDTO dTO) {
        Preconditions.checkArgument((dTO.getCode() != null), "error.TypeArticleNotFound");
        TypeArticle domaine = typeArticleRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.TypeArticleNotFound");
        dTO.setCode(domaine.getCode());
        TypeArticleFactory.typeArticleDTOToTypeArticle(dTO, domaine);
        return typeArticleRepo.save(domaine);
    }

    public void delete(Integer code) {
        Preconditions.checkArgument(typeArticleRepo.existsById(code), "error.TypeArticleNotFound");
        typeArticleRepo.deleteTypeArticleByCode(code);
    }
}
