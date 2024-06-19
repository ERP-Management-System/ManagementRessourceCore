/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.Coloris;
import com.MangmentRessources.MangRess.dto.ColorisDTO;
import com.MangmentRessources.MangRess.service.ColorisService;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RestController;
 
/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/parametrage_achat/")
public class ColorisRessource {

    private final ColorisService colorisService;
    private final Logger log = LoggerFactory.getLogger(ColorisService.class);

    public ColorisRessource(ColorisService colorisService) {
        this.colorisService = colorisService;
    }

    @GetMapping("coloris/{code}")
    public ResponseEntity<ColorisDTO> getColorisByCode(@PathVariable Integer code) {
//        try {
        log.debug("Request to get Country: {}", code);
        ColorisDTO dTO = colorisService.findOne(code); 
        return ResponseEntity.ok().body(dTO);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }

    }
 

    @GetMapping("coloris/all")
    public ResponseEntity<List<ColorisDTO>> getAllColoris() {
        return ResponseEntity.ok().body(colorisService.findAllColoris());
    }

    @PostMapping("coloris")
    public ResponseEntity<ColorisDTO> postColoris(@Valid @RequestBody ColorisDTO ddeTransfertDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        ColorisDTO result = colorisService.save(ddeTransfertDTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("coloris/update")
    public ResponseEntity<Coloris> updateColoris(@RequestBody @Valid ColorisDTO dTO) throws URISyntaxException {
        Coloris result = colorisService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("coloris/delete/{code}")
    public ResponseEntity<Coloris> deleteColoris(@PathVariable("code") Integer code) {
        colorisService.deleteColoris(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
