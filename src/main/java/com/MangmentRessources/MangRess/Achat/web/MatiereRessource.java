/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

 
import com.MangmentRessources.MangRess.Achat.domaine.Matiere;
import com.MangmentRessources.MangRess.Achat.dto.MatiereDTO;
import com.MangmentRessources.MangRess.Achat.service.MatiereService;
import com.MangmentRessources.MangRess.dto.AoDTO;
import jakarta.validation.Valid;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/parametrage_achat/")
public class MatiereRessource {

    private final MatiereService matiereservice;

    public MatiereRessource(MatiereService matiereservice) {
        this.matiereservice = matiereservice;
    }

    @GetMapping("matiere/{code}")
    public ResponseEntity<MatiereDTO> getMatiereByCode(@PathVariable Integer code) {
        MatiereDTO dTO = matiereservice.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("matieres/{code}")
    public ResponseEntity<AoDTO> getMatiereByCodeAO(@PathVariable Integer code) {
        AoDTO dTO = matiereservice.findOneAO(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("getPDF/{format}")
    public String getPdf(@PathVariable String format) throws FileNotFoundException, JRException {
//        MatiereDTO ddeTransfertDTO = matiereservice.findOne(code);
        return matiereservice.exportJasper(format);
    }

    @GetMapping("matiere/all")
    public ResponseEntity<List<MatiereDTO>> getAllMatiere() {
//        List<DdeAchat> ddeAchatList = ddeAchatService.findAllDdeAchat();
        return ResponseEntity.ok().body(matiereservice.findAllMatiere());
    }

    @PostMapping("matiere")
    public ResponseEntity<MatiereDTO> postMatiere(@Valid @RequestBody MatiereDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {

        MatiereDTO result = matiereservice.save(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("matiere/update")
    public ResponseEntity<Matiere> updateMatiere(@RequestBody @Valid MatiereDTO dTO) throws URISyntaxException {

        Matiere result = matiereservice.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("matiere/delete/{code}")
    public ResponseEntity<Matiere> deleteMatiere(@PathVariable("code") Integer code) {
        matiereservice.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
