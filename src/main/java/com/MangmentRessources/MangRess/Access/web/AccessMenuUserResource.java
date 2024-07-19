package com.MangmentRessources.MangRess.Access.web;
 
import com.MangmentRessources.MangRess.Access.dto.AccessMenuUserDTO;
import com.MangmentRessources.MangRess.Access.service.AccessMenuUserService;
import java.lang.String;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing VAccessMenuUser.
 */
@RestController
@RequestMapping("/api/access/")
public class AccessMenuUserResource {

    private static final String ENTITY_NAME = "vaccessmenuuser";

    private final AccessMenuUserService vaccessmenuuserService;

    private final Logger log = LoggerFactory.getLogger(AccessMenuUserService.class);

    public AccessMenuUserResource(AccessMenuUserService vaccessmenuuserService) {
        this.vaccessmenuuserService = vaccessmenuuserService;
    }

    @GetMapping("/vaccessmenuusers/findByUserAndMenu")
    public Collection<AccessMenuUserDTO> findByUserAndMenu(String user, String control) {
        log.debug("Request to get all  VAccessFormUsers : {}");
        return vaccessmenuuserService.findByUserAndMenu(user, control);
    }
    
        @GetMapping("/vaccessmenuusers/findByUserAndMenuPere")
    public Collection<AccessMenuUserDTO> findByUserAndMenuPere(String user, String menuPere) {
        log.debug("Request to get all  VAccessFormUsers : {}");
        return vaccessmenuuserService.findByUserAndMenu(user, menuPere);
    }

    @GetMapping("/vaccessmenuusers/findByUser")
    public Collection<AccessMenuUserDTO> findByUser(String user) {
        log.debug("Request to get all  VAccessFormUsers : {}");
        return vaccessmenuuserService.findByUser(user);
    }
}
