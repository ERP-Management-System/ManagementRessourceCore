/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Access.web;

import com.MangmentRessources.MangRess.Access.dto.AccessUserDTO;
import com.MangmentRessources.MangRess.Access.repository.AccessUserRepo;
import com.MangmentRessources.MangRess.Access.service.AccessUserService;
import com.MangmentRessources.MangRess.web.Util.RestPreconditions;
import jakarta.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/access/")
public class AccessUSerRessource {

    private final AccessUserService accessUserService;
    
    private final AccessUserRepo accessUserRepo;
    
    private static final String ENTITY_NAME = "access";

    public AccessUSerRessource(AccessUserService accessUserService, AccessUserRepo accessUserRepo) {
        this.accessUserService = accessUserService;
        this.accessUserRepo = accessUserRepo;
    }

    
//    @GetMapping("accessUser/{UserName}")
//    public ResponseEntity<AccessUserDTO> getAccessUserByCode(@PathVariable String UserName) {
//        AccessUserDTO dTO = accessUserService.findOne(UserName);
//        return ResponseEntity.ok().body(dTO);
//    }
    @GetMapping("accessUser/all")
    public ResponseEntity<List<AccessUserDTO>> getAllAccessUserWithOutPasswrod() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(accessUserService.findAllAcessUserWithOutPassword());
    }
    
        @GetMapping("accessUser/allWithPass")
    public ResponseEntity<List<AccessUserDTO>> getAllAccessUser() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(accessUserService.findAllAcessUser());
    }

//    @PostMapping("accessUser")
//    public ResponseEntity<AccessUserDTO> postAccessUser(@Valid @RequestBody AccessUserDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
//        AccessUserDTO result = accessUserService.save(dTO);
//        return ResponseEntity.created(new URI("/api/parametrage/" + result.getUserName())).body(result);
//    }
//    @PutMapping("accessUser/update")
//    public ResponseEntity<AccessUser> updateAccessUser(@RequestBody @Valid AccessUserDTO dTO) throws URISyntaxException {
//        AccessUser result = accessUserService.update(dTO);
//        return ResponseEntity.ok().body(result);
//    }
//    @DeleteMapping("accessUser/delete/{UserName}")
//    public ResponseEntity<AccessUser> deleteAccessUser(@PathVariable("UserName") String UserName) {
//        accessUserService.deleteUSerName(UserName);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PostMapping("accessUser")
    public ResponseEntity<AccessUserDTO> createSociete(@Valid @RequestBody AccessUserDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException, IOException {
//    log.debug("REST request to save Societe : {}", societeDTO);
//        if (bindingResult.hasErrors()) {
//            throw new MethodArgumentNotValidException(null, bindingResult);
//        }
        AccessUserDTO result = accessUserService.saves(dTO);
        return ResponseEntity.created(new URI("/api/access/accessUser/" + result.getCode())).body(result);
    }

    @PutMapping("accessUser/update")
    public ResponseEntity<AccessUserDTO> updateSociete(@Valid @RequestBody AccessUserDTO dTO, BindingResult bindingResult) throws MethodArgumentNotValidException, IOException {

        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        if (dTO.getUserName() == null) {
            bindingResult.addError(new FieldError("AccessUserDTO", "User", "PUT method does not accepte " + ENTITY_NAME + " with code"));
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        AccessUserDTO result = accessUserService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

//    @GetMapping("accessUser/UserName/{UserName}")
//    public ResponseEntity<AccessUserDTO> getSociete(@PathVariable String UserName, @RequestParam(required = false, defaultValue = "false") Boolean withoutLogo) {
//        AccessUserDTO dto = accessUserService.findOneWithOutLogo(UserName, withoutLogo);
//        RestPreconditions.checkFound(dto, "societe.NotFound");
//        return ResponseEntity.ok().body(dto);
//    }

//    @DeleteMapping("accessUser/delete/{UserName}")
//    public ResponseEntity<Void> deleteUser(@PathVariable String UserName) {
//        accessUserService.deleteUSerName(UserName);
//        return ResponseEntity.ok().build();
//    }

    @GetMapping("/accessUser/{UserName}/sginature")
    public ResponseEntity<Resource> getSignature(@PathVariable Integer code) {
        AccessUserDTO dto = accessUserService.findOne(code);

        Resource ressource = new ByteArrayResource(dto.getSignature());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(ressource);
    }
    
 
    
}
