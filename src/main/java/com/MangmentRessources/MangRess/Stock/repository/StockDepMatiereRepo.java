/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.repository;

import com.MangmentRessources.MangRess.Stock.domaine.StockDepMatiere;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface StockDepMatiereRepo extends JpaRepository<StockDepMatiere, Integer> {

    Collection<StockDepMatiere> findByCodeDepot(Integer codeDepot);
}
