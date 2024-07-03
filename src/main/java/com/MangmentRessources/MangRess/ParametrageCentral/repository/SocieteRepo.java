/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.repository;

import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface SocieteRepo extends JpaRepository<Societe, Integer> {

    Societe findFirstBy();

//    public Societe findOne(Integer id);

//    public void delete(Integer id);

}
