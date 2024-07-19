package com.MangmentRessources.MangRess.Access.service;

 
import com.MangmentRessources.MangRess.Access.domaine.AccessMenuUser;
import com.MangmentRessources.MangRess.Access.dto.AccessMenuUserDTO;
import com.MangmentRessources.MangRess.Access.factory.AccessMenuUserFactory;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.MangmentRessources.MangRess.Access.repository.AccessMenuUserRepository;

/**
 * Service Implementation for managing VAccessMenuUser.
 */
@Service
@Transactional
public class AccessMenuUserService {

    private final Logger log = LoggerFactory.getLogger(AccessMenuUserService.class);

    private final AccessMenuUserRepository vaccessmenuuserRepository;

    public AccessMenuUserService(AccessMenuUserRepository vaccessmenuuserRepository) {
        this.vaccessmenuuserRepository = vaccessmenuuserRepository;
    }

    /**
     * Save a vaccessmenuuserDTO.
     *
     * @param vaccessmenuuserDTO
     * @return the persisted entity
     */
    public AccessMenuUserDTO save(AccessMenuUserDTO vaccessmenuuserDTO) {
        log.debug("Request to save VAccessMenuUser: {}", vaccessmenuuserDTO);
        AccessMenuUser vaccessmenuuser = AccessMenuUserFactory.vaccessmenuuserDTOToVAccessMenuUser(vaccessmenuuserDTO);
        vaccessmenuuser = vaccessmenuuserRepository.save(vaccessmenuuser);
        AccessMenuUserDTO resultDTO = AccessMenuUserFactory.vaccessmenuuserToVAccessMenuUserDTO(vaccessmenuuser);
        return resultDTO;
    }

    /**
     * Get one vaccessmenuuserDTO by id.
     *
     * @param id the id of the entity
     * @return the entity DTO
     */
    @Transactional(
            readOnly = true
    )
    public Collection<AccessMenuUserDTO> findByUserAndMenu(String user, String control) {
        Collection<AccessMenuUser> result = vaccessmenuuserRepository.findByAccessMenuUserPK_userAndAccessMenuUserPK_menu(user, control);
        return AccessMenuUserFactory.vaccessmenuuserToVAccessMenuUserDTOs(result);
    }

    
        @Transactional(
            readOnly = true
    )
    public Collection<AccessMenuUserDTO> findByUserAndMenuPere(String user, String menuPere) {
        Collection<AccessMenuUser> result = vaccessmenuuserRepository.findByAccessMenuUserPK_userAndMenuPere(user, menuPere);
        return AccessMenuUserFactory.vaccessmenuuserToVAccessMenuUserDTOs(result);
    }

    @Transactional(
            readOnly = true
    )
    public Collection<AccessMenuUserDTO> findByUser(String user) {
        Collection<AccessMenuUser> result = vaccessmenuuserRepository.findByAccessMenuUserPK_User(user);
        return AccessMenuUserFactory.vaccessmenuuserToVAccessMenuUserDTOs(result);
    }
}
