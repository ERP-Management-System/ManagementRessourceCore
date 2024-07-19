package com.MangmentRessources.MangRess.Access.repository;

import com.MangmentRessources.MangRess.Access.domaine.AccessMenuUser;
import com.MangmentRessources.MangRess.Access.domaine.AccessMenuUserPK; 
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the VAccessMenuUser entity.
 */
@Repository
public interface AccessMenuUserRepository extends JpaRepository<AccessMenuUser, AccessMenuUserPK> {

    Collection<AccessMenuUser> findByAccessMenuUserPK_userAndAccessMenuUserPK_menu(String user, String menu);  
    
    Collection<AccessMenuUser> findByAccessMenuUserPK_userAndMenuPere(String user, String menuPere);
 
    Collection<AccessMenuUser> findByAccessMenuUserPK_User(String user);

}
