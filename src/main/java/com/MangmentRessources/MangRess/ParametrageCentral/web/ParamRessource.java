/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.ParametrageCentral.web;

import com.MangmentRessources.MangRess.Achat.dto.DepotDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.paramDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.service.ParamService;
import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/parametrage/")
public class ParamRessource {
    private final ParamService paramService;

    public ParamRessource(ParamService paramService) {
        this.paramService = paramService;
    }
    
        @GetMapping("param/codeParam")
    public ResponseEntity<Collection<paramDTO>> getParamByCodeParam(@RequestParam Collection<String> codeParam) {
        Collection<paramDTO> dTOs = paramService.findParamByCodeParam(codeParam);
        return ResponseEntity.ok().body(dTOs);
    }

}
