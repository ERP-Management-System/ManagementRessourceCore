/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.DemandeAchat;
import com.MangmentRessources.MangRess.dto.DemandeAchatDTO;
import com.MangmentRessources.MangRess.service.DemandeAchatService;
import com.MangmentRessources.MangRess.service.DemandeAchatService;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/parametrage_achat/")
public class DemandeAchatRessource {

    private final DemandeAchatService demandeAchatService;

    public DemandeAchatRessource(DemandeAchatService demandeAchatService) {
        this.demandeAchatService = demandeAchatService;
    }

    @GetMapping("demande_achat/{code}")
    public ResponseEntity<DemandeAchatDTO> getDemandeAchatByCode(@PathVariable Integer code) {
        DemandeAchatDTO dTO = demandeAchatService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("details_demande_achat/code_demande_achat")
    public ResponseEntity<DemandeAchatDTO> getDetailsDemandeAchatByCode(@RequestParam Integer code_demande_achat) {
        DemandeAchatDTO dTO = demandeAchatService.findOneWithDetilas(code_demande_achat);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("demande_achat/all")
    public ResponseEntity<List<DemandeAchatDTO>> getAllDemandeAchat() {
        return ResponseEntity.ok().body(demandeAchatService.findAllDemandeAchat());
    }

    @PostMapping("demande_achat")
    public ResponseEntity<DemandeAchatDTO> postDemandeAchat(@Valid @RequestBody DemandeAchatDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        DemandeAchatDTO result = demandeAchatService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

//    @PutMapping("demande_achat/update")
//    public ResponseEntity<DemandeAchat> updateDemandeAchat(@RequestBody @Valid DemandeAchatDTO dTO) throws URISyntaxException {
//
//        DemandeAchat result = nomenclatureArticleService.update(dTO);
//        return ResponseEntity.ok().body(result);
//    }
    @DeleteMapping("demande_achat/delete/{code}")
    public ResponseEntity<DemandeAchat> deleteDemandeAchat(@PathVariable("code") Integer code) {
        demandeAchatService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
