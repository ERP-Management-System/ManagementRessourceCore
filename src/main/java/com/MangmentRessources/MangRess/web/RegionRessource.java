/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.Region;
import com.MangmentRessources.MangRess.dto.RegionDTO;
import com.MangmentRessources.MangRess.service.RegionService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/parametrage/")
public class RegionRessource {

    private final RegionService regionService;

    public RegionRessource(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("region/{code}")
    public ResponseEntity<RegionDTO> getRegionByCode(@PathVariable Integer code) {
        RegionDTO dTO = regionService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("region/all")
    public ResponseEntity<List<RegionDTO>> getAllRegion() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(regionService.findAllRegion());
    }

    @PostMapping("region")
    public ResponseEntity<RegionDTO> postRegion(@Valid @RequestBody RegionDTO ddeTransfertDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        RegionDTO result = regionService.save(ddeTransfertDTO);
        return ResponseEntity.created(new URI("/api/parametrage/" + result.getCode())).body(result);
    }

    @PutMapping("region/update")
    public ResponseEntity<Region> updateRegion(@RequestBody @Valid RegionDTO dTO) throws URISyntaxException {
        Region result = regionService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("region/delete/{code}")
    public ResponseEntity<Region> deleteRegion(@PathVariable("code") Integer code) {
        regionService.deleteRegion(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
