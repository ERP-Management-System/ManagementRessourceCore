package com.MangmentRessources.MangRess.Access.repository;

import com.MangmentRessources.MangRess.Access.domaine.AccessFormUser;
import com.MangmentRessources.MangRess.Access.domaine.AccessFormUserPK;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the VAccessFormUser entity.
 */
@Repository
public interface AccessFormUserRepository extends JpaRepository<AccessFormUser, AccessFormUserPK> {

    Collection<AccessFormUser> findByAccessFormUserPK_userAndAccessFormUserPK_Control(String user, String control);
    Collection<AccessFormUser> findByAccessFormUserPK_user(String user);

}
