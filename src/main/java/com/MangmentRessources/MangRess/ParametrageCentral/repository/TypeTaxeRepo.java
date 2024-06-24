/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.repository;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.TypeTaxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface TypeTaxeRepo extends JpaRepository<TypeTaxe, Integer>{
    
}
