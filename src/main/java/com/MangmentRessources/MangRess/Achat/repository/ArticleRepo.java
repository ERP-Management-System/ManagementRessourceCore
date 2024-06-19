/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.repository;

import com.MangmentRessources.MangRess.Achat.domaine.Article;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface ArticleRepo extends JpaRepository<Article, Integer> {

    List<Article> findArticleByActifIn(Collection<Boolean> actif);
    List<Article> findByCodeTypeArticle(Integer codeTypeArticle); 
    List<Article> findByCodeCategorieArticle(Integer codeCategorieArticle);


}
