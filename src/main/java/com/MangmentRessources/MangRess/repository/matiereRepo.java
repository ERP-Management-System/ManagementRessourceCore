/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.repository;

import com.MangmentRessources.MangRess.domaine.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface matiereRepo extends JpaRepository<Matiere, Integer> {

    void deleteMatiereByCode(Integer code);
}
