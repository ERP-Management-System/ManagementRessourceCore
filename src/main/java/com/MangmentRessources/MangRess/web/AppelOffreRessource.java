/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.AppelOffre;
import com.MangmentRessources.MangRess.dto.AppelOffreDTO;
import com.MangmentRessources.MangRess.dto.DemandeAchatDTO;
import com.MangmentRessources.MangRess.dto.DetailsAppelOffreDTO;
import com.MangmentRessources.MangRess.service.AppelOffreService;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/api/parametrage_achat/")
public class AppelOffreRessource {
    
     private final AppelOffreService appelOffreService;

    public AppelOffreRessource(AppelOffreService appelOffreService) {
        this.appelOffreService = appelOffreService;
    }

    @GetMapping("appel_offre/{code}")
    public ResponseEntity<AppelOffreDTO> getAppelOffreByCode(@PathVariable Integer code) {
        AppelOffreDTO dTO = appelOffreService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("appel_offre/all")
    public ResponseEntity<List<AppelOffreDTO>> getAllAppelOffre() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(appelOffreService.findAllAppelOffre());
    }

    @PostMapping("appel_offre")
    public ResponseEntity<AppelOffreDTO> postAppelOffre(@Valid @RequestBody AppelOffreDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {

        AppelOffreDTO result = appelOffreService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("appel_offre/update")
    public ResponseEntity<AppelOffre> updateAppelOffre(@RequestBody @Valid AppelOffreDTO dTO) throws URISyntaxException {
        AppelOffre result = appelOffreService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("appel_offre/delete/{code}")
    public ResponseEntity<AppelOffre> deleteAppelOffre(@PathVariable("code") Integer code) {
        appelOffreService.deleteAppelOffre(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }


   @PostMapping("details_appel_offre_new")
    public ResponseEntity<AppelOffreDTO> postDetailsAppelOffreNew(@Valid @RequestBody AppelOffreDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        AppelOffreDTO result = appelOffreService.saveAO(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

 
        @GetMapping("details_appel_offre/{code}")
    public ResponseEntity<AppelOffreDTO> getDetailsAppelOffreByCode(@PathVariable Integer code) {
        AppelOffreDTO dTO = appelOffreService.findOneWithDetilas(code);
        return ResponseEntity.ok().body(dTO);
    }

}
