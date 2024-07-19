/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MangmentRessources.MangRess.Access.web;
 
import com.MangmentRessources.MangRess.Access.domaine.AccessControl;
import com.MangmentRessources.MangRess.Access.dto.AccessControlDTO;
import com.MangmentRessources.MangRess.Access.service.AccessControlService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS //
 */
@RestController
@RequestMapping("/api")
public class AccessControlRessource {

    private static final String ENTITY_NAME = "accessControl";
    @Autowired
    AccessControlService accesscontrolservice;

    @GetMapping("/accessControls")
    public List<AccessControlDTO> findallaccess() {
        return accesscontrolservice.findAll();
    }

    @GetMapping("/authen")
    public ResponseEntity<List<AccessControl>> authentification(@RequestParam("user") String login, @RequestParam("pass") String password) {
        List<AccessControl> dd = accesscontrolservice.findone(login, password);
        return ResponseEntity.ok().body(dd);

    }

    @GetMapping("/accessControls/stagiaire")
    public ResponseEntity<List<AccessControl>> getAllStagiaire() {
        List<AccessControl> dd = accesscontrolservice.getAllStagiaire();
        return ResponseEntity.ok().body(dd);

    }

}
