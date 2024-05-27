/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.repository;

import com.MangmentRessources.MangRess.domaine.NomenclatureArticle;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface NomenclatureRepo extends JpaRepository<NomenclatureArticle, Integer> {

//    List<NomenclatureArticle> findByCodeArticle(Integer codeArticle);
//
//    List<NomenclatureArticle> findByCodeMatiere(Integer codeMatiere);
//
//    List<NomenclatureArticle> findByCodeColoris(Integer codeColoris);

}
