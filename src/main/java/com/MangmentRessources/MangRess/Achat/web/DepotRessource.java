/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.Depot;
import com.MangmentRessources.MangRess.Achat.dto.DepotDTO;
import com.MangmentRessources.MangRess.Achat.service.DepotService;
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
public class DepotRessource {

    private final DepotService depotService;

    public DepotRessource(DepotService depotService) {
        this.depotService = depotService;
    }

    @GetMapping("depot/{code}")
    public ResponseEntity<DepotDTO> getDepotByCode(@PathVariable Integer code) {
        DepotDTO dTO = depotService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("depot/all")
    public ResponseEntity<List<DepotDTO>> getAllDepot() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(depotService.findAllDepot());
    }

    @GetMapping("depot/principal")
    public ResponseEntity<Collection<DepotDTO>> getDepotPrincipal(@RequestParam Collection<Boolean> principal) {
        Collection<DepotDTO> dTOs = depotService.findDepotPrincipal(principal);
        return ResponseEntity.ok().body(dTOs);
    }

    @PostMapping("depot")
    public ResponseEntity<DepotDTO> postDepot(@Valid @RequestBody DepotDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        DepotDTO result = depotService.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage/" + result.getCode())).body(result);
    }

    @PutMapping("depot/update")
    public ResponseEntity<Depot> updateDepot(@RequestBody @Valid DepotDTO dTO) throws URISyntaxException {
        Depot result = depotService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("depot/delete/{code}")
    public ResponseEntity<Depot> deleteDepot(@PathVariable("code") Integer code) {
        depotService.deleteDepot(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
