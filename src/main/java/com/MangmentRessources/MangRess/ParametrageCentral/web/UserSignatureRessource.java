/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.web;

import com.MangmentRessources.MangRess.ParametrageCentral.dto.SocieteDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.service.SocieteService;
import com.MangmentRessources.MangRess.web.Util.RestPreconditions;
import jakarta.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/api")
public class UserSignatureRessource {
    
    
    private static final String ENTITY_NAME = "societe";

  private final SocieteService societeService;

  private final Logger log = LoggerFactory.getLogger(SocieteService.class);

    public UserSignatureRessource(SocieteService societeService) {
        this.societeService = societeService;
    }

 

 
  @PostMapping("/societes")
  public ResponseEntity<SocieteDTO> createSociete(@Valid @RequestBody SocieteDTO societeDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException, IOException {
    log.debug("REST request to save Societe : {}", societeDTO);
    if (bindingResult.hasErrors()) {
      throw new MethodArgumentNotValidException(null, bindingResult);
    }

    SocieteDTO result = societeService.save(societeDTO);
    return ResponseEntity.created( new URI("/api/societes/"+ result.getCode())).body(result);
  }

 
  @PutMapping("/societes")
  public ResponseEntity<SocieteDTO> updateSociete(@Valid @RequestBody SocieteDTO societeDTO, BindingResult bindingResult) throws MethodArgumentNotValidException, IOException {
    log.debug("Request to update Societe: {}",societeDTO);
    if (bindingResult.hasErrors()) {
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    if ( societeDTO.getCode() == null) {
      bindingResult.addError( new FieldError("SocieteDTO","code","PUT method does not accepte "+ENTITY_NAME+" with code"));
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    SocieteDTO result =societeService.update(societeDTO);
    return ResponseEntity.ok().body(result);
  }

 
  @GetMapping("/societes/{id}")
  public ResponseEntity<SocieteDTO> getSociete(@PathVariable Integer id , @RequestParam(required=false , defaultValue = "false") Boolean withoutLogo ){
    log.debug("Request to get Societe: {} withoutLogo :{}",id,withoutLogo);
    SocieteDTO dto = societeService.findOne(id,withoutLogo);
    RestPreconditions.checkFound(dto, "societe.NotFound");
    return ResponseEntity.ok().body(dto);
  }

 
  @GetMapping("/societes")
  public Collection<SocieteDTO> getAllSocietes( @RequestParam(required=false , defaultValue = "false") Boolean withoutLogo ) {
    log.debug("Request to get all  Societes : {}");
    return societeService.findAll(withoutLogo);
  }

 
  @DeleteMapping("/societes/{id}")
  public ResponseEntity<Void> deleteSociete(@PathVariable Integer id) {
    log.debug("Request to delete Societe: {}",id);
    societeService.delete(id);
    return ResponseEntity.ok().build();
  }
  
  
  
 
  @GetMapping("/societes/{id}/logo")
  public ResponseEntity<Resource> getLogoSociete(@PathVariable Integer id) {
    log.debug("Request to get all  Societes : {}");
        SocieteDTO dto = societeService.findOne(id);

            Resource ressource = new ByteArrayResource(dto.getLogo());

    return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(ressource);
  }
}
