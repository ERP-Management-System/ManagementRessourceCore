package com.MangmentRessources.MangRess.Access.web;

 
import com.MangmentRessources.MangRess.Access.domaine.AccessFormUserPK;
import com.MangmentRessources.MangRess.Access.dto.AccessFormUserDTO;
import com.MangmentRessources.MangRess.Access.service.AccessFormUserService;
import com.MangmentRessources.MangRess.web.Util.RestPreconditions;
 
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing VAccessFormUser.
 */
@RestController
@RequestMapping("/api")
public class AccessFormUserResource {

    private static final String ENTITY_NAME = "vaccessformuser";

    private final AccessFormUserService vaccessformuserService;

    private final Logger log = LoggerFactory.getLogger(AccessFormUserService.class);

    public AccessFormUserResource(AccessFormUserService vaccessformuserService) {
        this.vaccessformuserService = vaccessformuserService;
    }

 
    @PostMapping("/vaccessformusers")
    public ResponseEntity<AccessFormUserDTO> createVAccessFormUser(@Valid @RequestBody AccessFormUserDTO vaccessformuserDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        log.debug("REST request to save VAccessFormUser : {}", vaccessformuserDTO);
        if (vaccessformuserDTO.getAccessFormUserPK()!= null) {
            bindingResult.addError(new FieldError("VAccessFormUserDTO", "vAccessFormUserPK", "POST method does not accepte " + ENTITY_NAME + " with code"));
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        AccessFormUserDTO result = vaccessformuserService.save(vaccessformuserDTO);
        return ResponseEntity.created(new URI("/api/vaccessformusers/" + result.getAccessFormUserPK())).body(result);
    }
 
    @PutMapping("/vaccessformusers/{id}")
    public ResponseEntity<AccessFormUserDTO> updateVAccessFormUser(@PathVariable AccessFormUserPK id, @Valid @RequestBody AccessFormUserDTO vaccessformuserDTO) throws MethodArgumentNotValidException {
        log.debug("Request to update VAccessFormUser: {}", id);
        vaccessformuserDTO.setAccessFormUserPK(id);
        AccessFormUserDTO result = vaccessformuserService.update(vaccessformuserDTO);
        return ResponseEntity.ok().body(result);
    }
 
    @GetMapping("/vaccessformusers/{id}")
    public ResponseEntity<AccessFormUserDTO> getVAccessFormUser(@PathVariable AccessFormUserPK id) {
        log.debug("Request to get VAccessFormUser: {}", id);
        AccessFormUserDTO dto = vaccessformuserService.findOne(id);
        RestPreconditions.checkFound(dto, "vaccessformuser.NotFound");
        return ResponseEntity.ok().body(dto);
    }
 
    @GetMapping("/vaccessformusers")
    public Collection<AccessFormUserDTO> getAllVAccessFormUsers() {
        log.debug("Request to get all  VAccessFormUsers : {}");
        return vaccessformuserService.findAll();
    }
 
    @DeleteMapping("/vaccessformusers/{id}")
    public ResponseEntity<Void> deleteVAccessFormUser(@PathVariable AccessFormUserPK id) {
        log.debug("Request to delete VAccessFormUser: {}", id);
        vaccessformuserService.delete(id);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/vaccessformusers/findByUserAndControl")
//    public Collection<VAccessFormUserDTO> findByUserAndControl(String user, String control) {
//        log.debug("Request to get all  VAccessFormUsers : {}");
//        return vaccessformuserService.findByUserAndControl(user, control);
//    }
//
//    @GetMapping("/vaccessformusers/findByUser")
//    public Collection<VAccessFormUserDTO> findByUser(String user) {
//        log.debug("Request to get all  VAccessFormUsers : {}");
//        return vaccessformuserService.findByUser(user);
//    }
}
