/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Achat.domaine.DetailsOrdreAchat;
import com.MangmentRessources.MangRess.Achat.domaine.OrdreAchat;
import com.MangmentRessources.MangRess.Achat.dto.OrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsOrdreAchatDTO;
import com.MangmentRessources.MangRess.Achat.repository.OrdreAchatRepo;
import com.MangmentRessources.MangRess.Achat.service.OrdreAchatService;
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
public class OrdreAchatRessource {

    private final OrdreAchatService ordreAchatService;
    private final ParamService paramService;
    private final SocieteService societeService;

    private final OrdreAchatRepo ordreAchatRepo;

    public OrdreAchatRessource(OrdreAchatService ordreAchatService, ParamService paramService, SocieteService societeService, OrdreAchatRepo ordreAchatRepo) {
        this.ordreAchatService = ordreAchatService;
        this.paramService = paramService;
        this.societeService = societeService;
        this.ordreAchatRepo = ordreAchatRepo;
    }

    @GetMapping("ordre_achat/all")
    public ResponseEntity<List<OrdreAchatDTO>> getAllOrdreAchat() {
        return ResponseEntity.ok().body(ordreAchatService.findAllOrdreAchat());
    }

    @GetMapping("ordre_achat/etat_reception/{codeEtatReception}")
    public ResponseEntity<List<OrdreAchatDTO>> getOrdreAchatByEtatReception(@PathVariable Integer codeEtatReception) {
        List<OrdreAchatDTO> dto = ordreAchatService.findOneByEtatReception(codeEtatReception);
        return ResponseEntity.ok().body(dto);

    }

    @GetMapping("ordre_achat/etat_reception_in/{codeEtatReception}")
    public ResponseEntity<List<OrdreAchatDTO>> getOrdreAchatByEtatReceptionIn(@PathVariable List<Integer> codeEtatReception) {
        List<OrdreAchatDTO> dto = ordreAchatService.findOneByEtatReceptionIn(codeEtatReception);
        return ResponseEntity.ok().body(dto);

    }
//
//    @GetMapping("ordre_achat/etat_reception_in_nonReciedFull/{codeEtatReception}")
//    public ResponseEntity<List<OrdreAchatDTO>> getOrdreAchatByEtatReceptionInAndNotFullRecived(@PathVariable List<Integer> codeEtatReception) {
//        List<OrdreAchatDTO> dto = ordreAchatService.findOneByEtatReceptionAndNotFullRecived(codeEtatReception);
//        return ResponseEntity.ok().body(dto);
//
//    }

    @PutMapping("ordre_achat/update")
    public ResponseEntity<OrdreAchatDTO> updateOrdreAchat(@Valid @RequestBody OrdreAchatDTO dTO, BindingResult bindingResult) throws MethodArgumentNotValidException {
        OrdreAchatDTO result = ordreAchatService.updateNewWithFlush(dTO);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("ordre_achat/update_etat_reception")
    public ResponseEntity<OrdreAchat> updateOrdreAchatEtatReception(@Valid @RequestBody OrdreAchatDTO dTO, BindingResult bindingResult) throws MethodArgumentNotValidException {
        OrdreAchat result = ordreAchatService.updateEtatRecpetion(dTO);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("ordre_achat/delete/{code}")
    public ResponseEntity<OrdreAchat> deleteOrdreAchat(@PathVariable("code") Integer code) {
        ordreAchatService.deleteOrdreAchat(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("ordre_achat")
    public ResponseEntity<OrdreAchatDTO> postDetailsOrdreAchatNew(@Valid @RequestBody OrdreAchatDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        OrdreAchatDTO result = ordreAchatService.saveOrdreAchat(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @GetMapping("details_ordre_achat/{code}")
    public ResponseEntity<Collection<DetailsOrdreAchatDTO>> getDetailsOrdreAchat(@PathVariable Integer code) {
        Collection<DetailsOrdreAchatDTO> dto = ordreAchatService.findOneWithDetilas(code);
        return ResponseEntity.ok().body(dto);

    }

    @GetMapping("details_ordre_achat_not_full_recived/{code}")
    public ResponseEntity<Collection<DetailsOrdreAchatDTO>> getDetailsOrdreAchatNonLivredTotalment(@PathVariable Integer code, Boolean totalementLivred) {
        Collection<DetailsOrdreAchatDTO> dto = ordreAchatService.findOneWithDetilasTotalmentLivredFalse(code, false);
        return ResponseEntity.ok().body(dto);

    }
//    
//    @GetMapping("details_ordre_achat/all_non_complete_receptionner")
//    public List<DetailsOrdreAchatDTO> getAllDetailsOrdersNonReceptionnerComplete() {
//        return ordreAchatService.getDetailsOrdreAchatNonCompleteReceptionner();
//    }
//
//    
// 
//    
//    
//    @GetMapping("details_ordre_achat/all_non_complete_receptionner/{codeOrdreAchat}")
//    public Collection<DetailsOrdreAchatDTO> getAllDetailsOrdersNonReceptionnerComplete(@PathVariable Integer codeOrdreAchat) {
//        return ordreAchatService.getDetailsOrdreAchatNonCompleteReceptionnerByCode(codeOrdreAchat);
//    }
//
//    @GetMapping("ordre_achat/all_non_complete_receptionner")
//    public List<OrdreAchatDTO> getOrdersAchatNonReceptionnerComplete() {
//        return ordreAchatService.getOrdreAchatNonCompleteReceptionner();
//    }

    @GetMapping("ordre_achat/{code}")
    public ResponseEntity< OrdreAchatDTO> getOrdreAchat(@PathVariable Integer code) {
        OrdreAchatDTO dto = ordreAchatService.findOne(code);
        return ResponseEntity.ok().body(dto);

    }

    @GetMapping("details_ordre_achat/edition/{code}")
    public ResponseEntity<byte[]> getReport(@PathVariable Integer code) throws Exception {

        String fileNameJrxml = "src/main/resources/Reports/DetailsOrdreAchat.jrxml";

        Collection<DetailsOrdreAchatDTO> dto = ordreAchatService.findOneWithDetilas(code);
        paramDTO dTOs = paramService.findParamByCodeParamS("NomSociete");
        OrdreAchatDTO rslt = ordreAchatService.findOne(code);
        SocieteDTO societeDTO = societeService.findOne(1);
        JasperDesign jasperDesign = JRXmlLoader.load(fileNameJrxml);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map<String, Object> params = new HashMap<>();
        params.put("ItemDataSource", new JRBeanCollectionDataSource(dto));
        params.put("UserCreate", "SoufienCreateCore");
        params.put("codeSaisie", rslt.getCodeSaisie());
        params.put("Observation", rslt.getObservation());
        params.put("societe", dTOs.getValeur());
        params.put("dateLivraison", rslt.getDateLivraison());
        System.out.println("rslt.getDateLivraison()" + rslt.getDateLivraison());
        params.put("codeAppelOffre", rslt.getAppelOffreDTO().getCodeSaisie());
        params.put("codeDemandeAchat", rslt.getDemandeAchatDTO().getCodeSaisie());

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
