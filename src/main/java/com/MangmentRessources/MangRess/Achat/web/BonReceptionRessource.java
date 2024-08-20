/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.BonReception;
import com.MangmentRessources.MangRess.Achat.dto.BonReceptionDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsBonReceptionDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsReceptionTempDTO;
import com.MangmentRessources.MangRess.Achat.repository.DetailsBonReceptionRepo;
import com.MangmentRessources.MangRess.Achat.service.BonReceptionService;
import com.MangmentRessources.MangRess.Achat.service.DetailsReceptionTempService;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.SocieteDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.paramDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.service.ParamService;
import com.MangmentRessources.MangRess.ParametrageCentral.service.SocieteService;
import jakarta.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
public class BonReceptionRessource {
    
    private final BonReceptionService bonReceptionService;
    
    private final DetailsBonReceptionRepo detailsBonReceptionRepo;
    
    private final SocieteService societeService;
    private final ParamService paramService;
    
    private final DetailsReceptionTempService detailsReceptionTempService;
    
    public BonReceptionRessource(BonReceptionService bonReceptionService, DetailsBonReceptionRepo detailsBonReceptionRepo, SocieteService societeService, ParamService paramService, DetailsReceptionTempService detailsReceptionTempService) {
        this.bonReceptionService = bonReceptionService;
        this.detailsBonReceptionRepo = detailsBonReceptionRepo;
        this.societeService = societeService;
        this.paramService = paramService;
        this.detailsReceptionTempService = detailsReceptionTempService;
    }
    
    @GetMapping("bon_reception/{code}")
    public ResponseEntity<BonReceptionDTO> getBonReceptionByCode(@PathVariable Integer code) {
        BonReceptionDTO dTO = bonReceptionService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }
    
    @GetMapping("bon_reception/all")
    public ResponseEntity<List<BonReceptionDTO>> getAllBonReception() {
        return ResponseEntity.ok().body(bonReceptionService.findAllBonReception());
    }

//    @GetMapping("bon_reception/EtatApprouverOrdreAchat/{codeEtatApprouverOrdreAchat}")
//    public ResponseEntity<List<BonReceptionDTO>> getBonReceptionByCodeEtatApprouve(@PathVariable Integer codeEtatApprouverOrdreAchat) {
//        List<BonReceptionDTO> dto = bonReceptionService.findOneByEtatApprouver(codeEtatApprouverOrdreAchat);
//        return ResponseEntity.ok().body(dto);
//
//    }
    @PutMapping("bon_reception/update")
    public ResponseEntity<BonReceptionDTO> updateBonReception(@Valid @RequestBody BonReceptionDTO dTO, BindingResult bindingResult) throws MethodArgumentNotValidException {
        BonReceptionDTO result = bonReceptionService.updateNewWithFlush(dTO);
        return ResponseEntity.ok().body(result);
    }

// 
    @DeleteMapping("bon_reception/delete/{code}")
    public ResponseEntity<BonReception> deleteBonReception(@PathVariable("code") Integer code) {
        bonReceptionService.deleteBonReception(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("bon_reception")
    public ResponseEntity<BonReceptionDTO> postDetailsBonReceptionNew(@Valid @RequestBody BonReceptionDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        BonReceptionDTO result = bonReceptionService.saveBonReception(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }
    
    @GetMapping("details_reception_temp/By")
        public ResponseEntity<List<DetailsReceptionTempDTO>> getDetailsReceptionTemp(@RequestParam(required = true) Integer codeOrdreAchat, @RequestParam Integer codematiere) {
        return ResponseEntity.ok().body(detailsReceptionTempService.findOneByCodeOrdreAchatAndCodeMatiere(codeOrdreAchat, codematiere));
    }
    
    @PostMapping("details_reception_temp")
    public ResponseEntity<DetailsReceptionTempDTO> postDetailsBonReceptionTemp(@Valid @RequestBody DetailsReceptionTempDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        DetailsReceptionTempDTO result = detailsReceptionTempService.saveDetailsReceptionTemp(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }
    
    @DeleteMapping("details_reception_temp/deleteByCodeOrdreAchatAndCodeMatiere")
    public ResponseEntity<BonReception> deleteDetailsReceptionTempByCodeOrdreAchatAndCodeMatiere(@RequestParam(required = true) Integer codeOrdreAchat, @RequestParam Integer codematiere) {
        detailsReceptionTempService.deleteByCodeOrdreAchatAndCodeMatiere(codeOrdreAchat, codematiere);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
        @DeleteMapping("details_reception_temp/deleteByCodeOrdreAchat")
    public ResponseEntity<BonReception> deleteDetailsReceptionTempByCodeOrdreAchat(@RequestParam(required = true) Integer codeOrdreAchat) {
        detailsReceptionTempService.deleteByCodeOrdreAchat(codeOrdreAchat);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    @GetMapping("details_bon_reception/{code}")
    public ResponseEntity<Collection<DetailsBonReceptionDTO>> getBonReception(@PathVariable Integer code) {
        Collection<DetailsBonReceptionDTO> dto = bonReceptionService.findOneWithDetilas(code);
        return ResponseEntity.ok().body(dto);
        
    }
    
    @GetMapping("details_bon_reception/edition/{code}")
    public ResponseEntity<byte[]> getReport(@PathVariable Integer code) throws Exception {
        
        String fileNameJrxml = "src/main/resources/Reports/DetailsBonReception.jrxml";
//        Collection<DetailsBonReception> products = detailsBonReceptionRepo.findAll();

        Collection<DetailsBonReceptionDTO> dto = bonReceptionService.findOneWithDetilas(code);
        
        paramDTO dTOs = paramService.findParamByCodeParamS("NomSociete");
        BonReceptionDTO rslt = bonReceptionService.findOne(code);
        SocieteDTO societeDTO = societeService.findOne(1);
        JasperDesign jasperDesign = JRXmlLoader.load(fileNameJrxml);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map<String, Object> params = new HashMap<>();
        params.put("ItemDataSource", new JRBeanCollectionDataSource(dto));
        params.put("UserCreate", "SoufienCreateCore");
        params.put("codeSaisieBonReception", rslt.getCodeSaisie());
        params.put("Observation", rslt.getObservation());
        params.put("societe", dTOs.getValeur());
        params.put("logo", societeDTO.getLogo());
        System.out.println("filling parameters to .JASPER file....");
        JasperPrint print = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

        //initiate exporter
        JRPdfExporter exporter = new JRPdfExporter();
        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfOutputStream));
        
        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);
        
        exporter.exportReport();
        var res = pdfOutputStream.toByteArray();
        
        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename= filename.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(res);
    }
}
