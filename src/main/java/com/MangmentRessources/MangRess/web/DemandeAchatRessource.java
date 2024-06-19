/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;
 
import com.MangmentRessources.MangRess.domaine.DemandeAchat; 
import com.MangmentRessources.MangRess.dto.DemandeAchatDTO; 
import com.MangmentRessources.MangRess.dto.DetailsDemandeAchatDTO;  
import com.MangmentRessources.MangRess.service.DemandeAchatService;
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
public class DemandeAchatRessource {

    private final DemandeAchatService demandeAchatService; 

    public DemandeAchatRessource(DemandeAchatService demandeAchatService) {
        this.demandeAchatService = demandeAchatService;
    }

  
 
 
    @GetMapping("demande_achat/all")
    public ResponseEntity<List<DemandeAchatDTO>> getAllArticle() { 
        return ResponseEntity.ok().body(demandeAchatService.findAllDemandeAchat());
    }

    @PutMapping("demande_achat/update")
    public ResponseEntity<DemandeAchatDTO> updateModelePanier(@Valid @RequestBody DemandeAchatDTO dTO, BindingResult bindingResult) throws MethodArgumentNotValidException {
        DemandeAchatDTO result = demandeAchatService.updateNewWithFlush(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("demande_achat/delete/{code}")
    public ResponseEntity<DemandeAchat> deleteAppelOffre(@PathVariable("code") Integer code) {
        demandeAchatService.deleteDemandeAchat(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("demande_achat")
    public ResponseEntity<DemandeAchatDTO> postDetailsAppelOffreNew(@Valid @RequestBody DemandeAchatDTO dTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        DemandeAchatDTO result = demandeAchatService.saveDdeAchat(dTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @GetMapping("details_demande_achat/{code}")
    public ResponseEntity<Collection<DetailsDemandeAchatDTO>> getAppelOffre(@PathVariable Integer code) {
        Collection<DetailsDemandeAchatDTO> dto = demandeAchatService.findOneWithDetilas(code);
        return ResponseEntity.ok().body(dto);

    }
    
    
    @GetMapping("details_demande_achat/edition/{code}")
    public ResponseEntity<byte[]> getReport (@PathVariable Integer code) throws Exception {

        String fileNameJrxml = "src/main/resources/Reports/DetailsAppelOffre.jrxml"; 
        
         Collection<DetailsDemandeAchatDTO> dto = demandeAchatService.findOneWithDetilas(code);    
             
          DemandeAchatDTO rslt = demandeAchatService.findOne(code);

        JasperDesign jasperDesign = JRXmlLoader.load(fileNameJrxml);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map<String, Object> params = new HashMap<>();
        params.put("ItemDataSource", new JRBeanCollectionDataSource(dto));
        params.put("UserCreate", "SoufienCreateCore");     
        params.put("codeSaisieAppelOffre", rslt.getCodeSaisie());     
        params.put("Observation", rslt.getObservation());


         

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
