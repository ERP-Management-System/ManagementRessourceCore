/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MangmentRessources.MangRess.Access.service;
 
import com.MangmentRessources.MangRess.Access.domaine.AccessControl;
import com.MangmentRessources.MangRess.Access.dto.AccessControlDTO;
import com.MangmentRessources.MangRess.Access.factory.AccessControlFactory;
import com.MangmentRessources.MangRess.Access.repository.AccessControlRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Service
@Transactional
public class AccessControlService {

 
   private final AccessControlRepository accesscontrolRepository;

    public AccessControlService(AccessControlRepository accesscontrolRepository) {
        this.accesscontrolRepository = accesscontrolRepository;
    }

 

    
    
    @Transactional(readOnly = true)
    public List<AccessControlDTO> findAll() {
        List<AccessControl> result = accesscontrolRepository.findAll();
        return AccessControlFactory.accesscontrolsToAccessControlDTOs(result);
    }

    public List<AccessControl> findone(String user, String passwd) {
        List<AccessControl> accesscont = accesscontrolRepository.findByUserNameAndPassWord(user, passwd);
        return accesscont;
    }
    
    
    public List<AccessControl> getAllStagiaire() {
        List<AccessControl> accesscont = accesscontrolRepository.findByGrpLike("%stag%");
        return accesscont;
    }
    
        public boolean updateLastDateLogin(String name) {
//        AccessControl accessControl = accesscontrolRepository.findByUserName(name);
//        boolean firstTimeLogin = accessControl.getDerniereDateCnx() == null;
//        accessControl.setDerniereDateCnx(new Date());
        return true;
    }


}
