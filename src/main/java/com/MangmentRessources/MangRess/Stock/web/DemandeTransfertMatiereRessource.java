/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Stock.web;
 
import com.MangmentRessources.MangRess.ParametrageCentral.service.ParamService;
import com.MangmentRessources.MangRess.ParametrageCentral.service.SocieteService;
import com.MangmentRessources.MangRess.Stock.domaine.DemandeTransfertMatiere;
import com.MangmentRessources.MangRess.Stock.dto.DemandeTransfertMatiereDTO;
import com.MangmentRessources.MangRess.Stock.dto.DetailsDemandeTransfertMatiereDTO;
import com.MangmentRessources.MangRess.Stock.service.DemandeTransfertMatiereService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/stock/")
public class DemandeTransfertMatiereRessource {

    private final DemandeTransfertMatiereService demandeTransfertMatiereService;
    private final SocieteService societeService;
    private final ParamService paramService;

    public DemandeTransfertMatiereRessource(DemandeTransfertMatiereService demandeTransfertMatiereService, SocieteService societeService, ParamService paramService) {
        this.demandeTransfertMatiereService = demandeTransfertMatiereService;
        this.societeService = societeService;
        this.paramService = paramService;
    }

    
    
    @GetMapping("demande_transfert_matiere/{code}")
    public ResponseEntity<DemandeTransfertMatiereDTO> getDemandeTransfertMatiereByCode(@PathVariable Integer code) {
        DemandeTransfertMatiereDTO dTO = demandeTransfertMatiereService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("demande_transfert_matiere/all")
    public ResponseEntity<List<DemandeTransfertMatiereDTO>> getAllDemandeTransfertMatiere() {
        return ResponseEntity.ok().body(demandeTransfertMatiereService.findAllDemandeTransfertMatiere());
    }

 

    @PutMapping("demande_transfert_matiere/update")
    public ResponseEntity<DemandeTransfertMatiereDTO> updateDemandeTransfert(@Valid @RequestBody DemandeTransfertMatiereDTO dTO, BindingResult bindingResult) throws MethodArgumentNotValidException {
        DemandeTransfertMatiereDTO result = demandeTransfertMatiereService.updateNewWithFlush(dTO);
        return ResponseEntity.ok().body(result);
    }

// 
    @DeleteMapping("demande_transfert_matiere/delete/{code}")
    public ResponseEntity<DemandeTransfertMatiere> deleteDemandeTransfertMatiere(@PathVariable("code") Integer code) {
        demandeTransfertMatiereService.deleteDemandeTransfertMatiere(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("demande_transfert_matiere")
    public ResponseEntity<DemandeTransfertMatiereDTO> postDetailsDemandeTransfertMatiereNew(@Valid @RequestBody DemandeTransfertMatiereDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        DemandeTransfertMatiereDTO result = demandeTransfertMatiereService.saveDTR(dTO);
        return ResponseEntity.created(new URI("/api/stock/" + result.getCode())).body(result);
    }

    @GetMapping("details_demande_transfert_matiere/{code}")
    public ResponseEntity<Collection<DetailsDemandeTransfertMatiereDTO>> getDemandeTransfertMatiere(@PathVariable Integer code) {
        Collection<DetailsDemandeTransfertMatiereDTO> dto = demandeTransfertMatiereService.findOneWithDetilas(code);
        return ResponseEntity.ok().body(dto);

    }

}
