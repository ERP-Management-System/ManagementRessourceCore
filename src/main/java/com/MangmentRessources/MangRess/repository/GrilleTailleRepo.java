/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.repository;

import com.MangmentRessources.MangRess.domaine.GrilleTaille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface GrilleTailleRepo extends JpaRepository<GrilleTaille, Integer> {
    
    void deleteGrilleTailleByCode(Integer code);
}
