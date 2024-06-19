/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.repository;

import com.MangmentRessources.MangRess.domaine.DetailsAppelOffre;
import com.MangmentRessources.MangRess.domaine.DetailsAppelOffrePK;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface DetailsAppelOffreRepo extends JpaRepository<DetailsAppelOffre, DetailsAppelOffrePK> {

    Collection<DetailsAppelOffre> findByDetailsAppelOffrePK_codeAppelOffre(Integer codeAppelOffre);
}
