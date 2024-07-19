package com.MangmentRessources.MangRess.Access.service;

import com.MangmentRessources.MangRess.Access.domaine.AccessFormUser;
import com.MangmentRessources.MangRess.Access.domaine.AccessFormUserPK;
import com.MangmentRessources.MangRess.Access.dto.AccessFormUserDTO;
import com.MangmentRessources.MangRess.Access.factory.AccessFormUserFactory;
 
import com.google.common.base.Preconditions;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.MangmentRessources.MangRess.Access.repository.AccessFormUserRepository;

/**
 * Service Implementation for managing VAccessFormUser.
 */
@Service
@Transactional
public class AccessFormUserService {

    private final Logger log = LoggerFactory.getLogger(AccessFormUserService.class);

    private final AccessFormUserRepository vaccessformuserRepository;

    public AccessFormUserService(AccessFormUserRepository vaccessformuserRepository) {
        this.vaccessformuserRepository = vaccessformuserRepository;
    }

    /**
     * Save a vaccessformuserDTO.
     *
     * @param vaccessformuserDTO
     * @return the persisted entity
     */
    public AccessFormUserDTO save(AccessFormUserDTO vaccessformuserDTO) {
        log.debug("Request to save VAccessFormUser: {}", vaccessformuserDTO);
        AccessFormUser vaccessformuser = AccessFormUserFactory.vaccessformuserDTOToVAccessFormUser(vaccessformuserDTO);
        vaccessformuser = vaccessformuserRepository.save(vaccessformuser);
        AccessFormUserDTO resultDTO = AccessFormUserFactory.vaccessformuserToVAccessFormUserDTO(vaccessformuser);
        return resultDTO;
    }

    /**
     * Update a vaccessformuserDTO.
     *
     * @param vaccessformuserDTO
     * @return the updated entity
     */
    public AccessFormUserDTO update(AccessFormUserDTO accessFormUserDTO) {
        log.debug("Request to update VAccessFormUser: {}", accessFormUserDTO);
        AccessFormUser inBase = vaccessformuserRepository.getReferenceById(accessFormUserDTO.getAccessFormUserPK());
        Preconditions.checkArgument(inBase != null, "vaccessformuser.NotFound");
        AccessFormUser accessFormUser = AccessFormUserFactory.vaccessformuserDTOToVAccessFormUser(accessFormUserDTO);
        accessFormUser = vaccessformuserRepository.save(accessFormUser);
        AccessFormUserDTO resultDTO = AccessFormUserFactory.vaccessformuserToVAccessFormUserDTO(accessFormUser);
        return resultDTO;
    }

    /**
     * Get one vaccessformuserDTO by id.
     *
     * @param id the id of the entity
     * @return the entity DTO
     */
    @Transactional(
            readOnly = true
    )
    public AccessFormUserDTO findOne(AccessFormUserPK id) {
        log.debug("Request to get VAccessFormUser: {}", id);
        AccessFormUser accessFormUser = vaccessformuserRepository.getReferenceById(id);
        AccessFormUserDTO dto = AccessFormUserFactory.vaccessformuserToVAccessFormUserDTO(accessFormUser);
        return dto;
    }
 
    @Transactional(
            readOnly = true
    )
    public AccessFormUser findVAccessFormUser(AccessFormUserPK id) {
        log.debug("Request to get VAccessFormUser: {}", id);
        AccessFormUser vaccessformuser = vaccessformuserRepository.getReferenceById(id);
        return vaccessformuser;
    }

 
    @Transactional(
            readOnly = true
    )
    public Collection<AccessFormUserDTO> findAll() {
        log.debug("Request to get All VAccessFormUsers");
        Collection<AccessFormUser> result = vaccessformuserRepository.findAll();
        return AccessFormUserFactory.vaccessformuserToVAccessFormUserDTOs(result);
    }
 
    public void delete(AccessFormUserPK id) {
        log.debug("Request to delete VAccessFormUser: {}", id);
        vaccessformuserRepository.deleteById(id);
    }

    @Transactional(
            readOnly = true
    )
    public Collection<AccessFormUserDTO> findByUserAndControl(String user, String control) {
        Collection<AccessFormUser> result = vaccessformuserRepository.findByAccessFormUserPK_userAndAccessFormUserPK_Control(user, control);
        return AccessFormUserFactory.vaccessformuserToVAccessFormUserDTOs(result);
    }

    @Transactional(
            readOnly = true
    )
    public Collection<AccessFormUserDTO> findByUser(String user) {
        Collection<AccessFormUser> result = vaccessformuserRepository.findByAccessFormUserPK_user(user);
        return AccessFormUserFactory.vaccessformuserToVAccessFormUserDTOs(result);
    }
}
