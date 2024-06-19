/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.Coloris;
import com.MangmentRessources.MangRess.Achat.domaine.Matiere;
import com.MangmentRessources.MangRess.Achat.dto.ColorisDTO;
import com.MangmentRessources.MangRess.Achat.dto.EtatDemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.service.ColorisService;
import com.MangmentRessources.MangRess.Achat.service.EtatDemandeAchatService;
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
@RequestMapping("/api/parametrage_achat/")
public class EtatDemandeAchatRessource {

    private final EtatDemandeAchatService etatDemandeAchatService;

    public EtatDemandeAchatRessource(EtatDemandeAchatService etatDemandeAchatService) {
        this.etatDemandeAchatService = etatDemandeAchatService;
    }
 
    @GetMapping("eta_demande/{code}")
    public ResponseEntity<EtatDemandeAchatDTO> getMatiereByCode(@PathVariable Integer code) {
        EtatDemandeAchatDTO dTO = etatDemandeAchatService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("eta_demande/all")
    public ResponseEntity<List<EtatDemandeAchatDTO>> getAllMatiere() { 
        return ResponseEntity.ok().body(etatDemandeAchatService.findAllEtatDemande());
    }


}
