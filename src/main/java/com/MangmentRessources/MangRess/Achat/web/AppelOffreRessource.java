/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.AppelOffre;
import com.MangmentRessources.MangRess.Achat.dto.AppelOffreDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsAppelOffreDTO;
import com.MangmentRessources.MangRess.Achat.repository.DetailsAppelOffreRepo;
import com.MangmentRessources.MangRess.Achat.service.AppelOffreService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/parametrage_achat/")
public class AppelOffreRessource {

    private final AppelOffreService appelOffreService;

    private final DetailsAppelOffreRepo detailsAppelOffreRepo;

    private final SocieteService societeService;
    private final ParamService paramService;

    public AppelOffreRessource(AppelOffreService appelOffreService, DetailsAppelOffreRepo detailsAppelOffreRepo, SocieteService societeService, ParamService paramService) {
        this.appelOffreService = appelOffreService;
        this.detailsAppelOffreRepo = detailsAppelOffreRepo;
        this.societeService = societeService;
        this.paramService = paramService;
    }
 
    @GetMapping("appel_offre/{code}")
    public ResponseEntity<AppelOffreDTO> getAppelOffreByCode(@PathVariable Integer code) {
        AppelOffreDTO dTO = appelOffreService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("appel_offre/all")
    public ResponseEntity<List<AppelOffreDTO>> getAllAppelOffre() {
        return ResponseEntity.ok().body(appelOffreService.findAllAppelOffre());
    }

//    @GetMapping("appel_offre/EtatApprouverOrdreAchat/{codeEtatApprouverOrdreAchat}")
//    public ResponseEntity<List<AppelOffreDTO>> getAppelOffreByCodeEtatApprouve(@PathVariable Integer codeEtatApprouverOrdreAchat) {
//        List<AppelOffreDTO> dto = appelOffreService.findOneByEtatApprouver(codeEtatApprouverOrdreAchat);
//        return ResponseEntity.ok().body(dto);
//
//    }

    @PutMapping("appel_offre/update")
    public ResponseEntity<AppelOffreDTO> updateModelePanier(@Valid @RequestBody AppelOffreDTO dTO, BindingResult bindingResult) throws MethodArgumentNotValidException {
        AppelOffreDTO result = appelOffreService.updateNewWithFlush(dTO);
        return ResponseEntity.ok().body(result);
    }

// 
    @DeleteMapping("appel_offre/delete/{code}")
    public ResponseEntity<AppelOffre> deleteAppelOffre(@PathVariable("code") Integer code) {
        appelOffreService.deleteAppelOffre(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("appel_offre")
    public ResponseEntity<AppelOffreDTO> postDetailsAppelOffreNew(@Valid @RequestBody AppelOffreDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        AppelOffreDTO result = appelOffreService.saveAO(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @GetMapping("details_appel_offre/{code}")
    public ResponseEntity<Collection<DetailsAppelOffreDTO>> getAppelOffre(@PathVariable Integer code) {
        Collection<DetailsAppelOffreDTO> dto = appelOffreService.findOneWithDetilas(code);
        return ResponseEntity.ok().body(dto);

    }

    @GetMapping("details_appel_offre/edition/{code}")
    public ResponseEntity<byte[]> getReport(@PathVariable Integer code) throws Exception {

        String fileNameJrxml = "src/main/resources/Reports/DetailsAppelOffre.jrxml";
//        Collection<DetailsAppelOffre> products = detailsAppelOffreRepo.findAll();

        Collection<DetailsAppelOffreDTO> dto = appelOffreService.findOneWithDetilas(code);

        paramDTO dTOs = paramService.findParamByCodeParamS("NomSociete");
        AppelOffreDTO rslt = appelOffreService.findOne(code);
        SocieteDTO societeDTO = societeService.findOne(1);
        JasperDesign jasperDesign = JRXmlLoader.load(fileNameJrxml);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map<String, Object> params = new HashMap<>();
        params.put("ItemDataSource", new JRBeanCollectionDataSource(dto));
        params.put("UserCreate", "SoufienCreateCore");
        params.put("codeSaisieAppelOffre", rslt.getCodeSaisie());
        params.put("Observation", rslt.getObservation());
        params.put("societe", dTOs.getValeur());
        params.put("dateLivraison", rslt.getDateLivraison());
        params.put("modeReglement", rslt.getModeReglementDTO().getDesignationLt());
        params.put("AdressLivraison", rslt.getAdressLivraison()); 
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
