/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MangmentRessources.MangRess.Access.repository;
 
import com.MangmentRessources.MangRess.Access.domaine.AccessControl;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author ASUS
 */
public interface AccessControlRepository extends JpaRepository <AccessControl,String>{
 Optional<AccessControl>  findByUserName (String username);
List<AccessControl> findByUserNameAndPassWord(String user,String passwd); 
List<AccessControl> findByGrpLike(String grp);

  //  AccessControl findByUserName(String userName);
    Optional<AccessControl> findOneWithModulesAndMenusAndFormsByUserName(String username);

}
