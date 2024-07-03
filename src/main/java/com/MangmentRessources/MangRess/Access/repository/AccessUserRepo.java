/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MangmentRessources.MangRess.Access.repository;

import com.MangmentRessources.MangRess.Access.domaine.AccessUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface AccessUserRepo extends JpaRepository<AccessUser, Integer> {

    AccessUser findFirstBy();
//    AccessUser findAccessUserByUserName(String UserName);

    Optional<AccessUser> findAccessUserByUserName(String UserName);
}
