/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.service;

import com.MangmentRessources.MangRess.domaine.NomenclatureArticle;
import com.MangmentRessources.MangRess.dto.NomenclatureArticleDTO;
import com.MangmentRessources.MangRess.factory.NomenclatureArticleFactory;
import com.MangmentRessources.MangRess.repository.NomenclatureRepo; 
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
public class NomenclatureArticleService {

    private final NomenclatureRepo nomenclatureRepo;

    public NomenclatureArticleService(NomenclatureRepo nomenclatureRepo) {
        this.nomenclatureRepo = nomenclatureRepo;
    }

    @Transactional(readOnly = true)
    public List<NomenclatureArticleDTO> findAllNomenclatureArticle() {
        return NomenclatureArticleFactory.listNomenclatureArticleToNomenclatureArticleDTOs(nomenclatureRepo.findAll());

    }

    @Transactional(readOnly = true)
    public NomenclatureArticleDTO findOne(Integer code) {
        NomenclatureArticle domaine = nomenclatureRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.NomenclatureArticleNotFound");
        return NomenclatureArticleFactory.nomenclatureArticleToNomenclatureArticleDTOCollection(domaine);
    }

//
    public NomenclatureArticleDTO save(NomenclatureArticleDTO dTO) {
        NomenclatureArticle domaine = NomenclatureArticleFactory.nomenclatureArticleDTOToNomenclatureArticleCollection(dTO, new NomenclatureArticle());
        domaine = nomenclatureRepo.save(domaine);
        return NomenclatureArticleFactory.nomenclatureArticleToNomenclatureArticleDTOCollection(domaine);
    }

    
            /// Update List


    public NomenclatureArticle update(NomenclatureArticleDTO dTO) { 
        Preconditions.checkArgument((dTO.getCode() != null), "error.NomenclatureArticleNotFound");
        NomenclatureArticle domaine = nomenclatureRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.NomenclatureArticleNotFound");
        dTO.setCode(domaine.getCode());
        NomenclatureArticleFactory.nomenclatureArticleDTOToNomenclatureArticleCollection(dTO, domaine);
        return nomenclatureRepo.save(domaine);
    }
    
    
    public void delete(Integer code) {
        Preconditions.checkArgument(nomenclatureRepo.existsById(code), "error.NomenclatureArticleNotFound");

        
        /// Control Order Achat + Dde Achat  + Demande Devis 
//        Preconditions.checkArgument(nomenclatureRepo.existsById(code), "error.NomenclatureArticleNotFound");

        nomenclatureRepo.deleteById(code);
    }

}
