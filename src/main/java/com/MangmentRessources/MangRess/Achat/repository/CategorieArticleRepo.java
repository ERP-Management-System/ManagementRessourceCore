/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.repository;

import com.MangmentRessources.MangRess.Achat.domaine.CategorieArticle;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface CategorieArticleRepo extends JpaRepository<CategorieArticle, Integer> {

    List<CategorieArticle> findCategorieArticleByActifIn(Collection<Boolean> actif);

    List<CategorieArticle> findByCodeFamilleArticle(Integer codeFamilleArticle);

}
