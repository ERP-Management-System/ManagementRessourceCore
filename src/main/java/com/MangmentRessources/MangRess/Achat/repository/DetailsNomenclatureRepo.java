/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.repository;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsNomenclatureArticle;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsNomenclaturePK;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface DetailsNomenclatureRepo extends JpaRepository<DetailsNomenclatureArticle, DetailsNomenclaturePK> {

    Collection<DetailsNomenclatureArticle> findByDetailsNomenclaturePK_codeMatiere(Integer codeMatiere);
}
