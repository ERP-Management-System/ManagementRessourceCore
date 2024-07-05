/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.web;

import com.MangmentRessources.MangRess.Access.dto.AccessUserDTO;
import com.MangmentRessources.MangRess.Access.service.AccessUserService;
import com.MangmentRessources.MangRess.Achat.domaine.DemandeAchat;
import com.MangmentRessources.MangRess.Achat.dto.DemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsDemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.service.DemandeAchatService;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.SocieteDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.dto.paramDTO;
import com.MangmentRessources.MangRess.ParametrageCentral.service.ParamService;
import com.MangmentRessources.MangRess.ParametrageCentral.service.SocieteService;
import com.google.common.base.Preconditions;
import jakarta.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import static java.lang.StrictMath.log;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.rowset.serial.SerialBlob;
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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
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
public class DemandeAchatRessource {

    private final DemandeAchatService demandeAchatService;
    private final ParamService paramService;
    private final SocieteService societeService;

    private final AccessUserService accessUserService;

    public DemandeAchatRessource(DemandeAchatService demandeAchatService, ParamService paramService, SocieteService societeService, AccessUserService accessUserService) {
        this.demandeAchatService = demandeAchatService;
        this.paramService = paramService;
        this.societeService = societeService;
        this.accessUserService = accessUserService;
    }

    @GetMapping("demande_achat/all")
    public ResponseEntity<List<DemandeAchatDTO>> getAllArticle() {
        return ResponseEntity.ok().body(demandeAchatService.findAllDemandeAchat());
    }

    @GetMapping("demande_achat/EtatApprouver/{codeEtatApprouver}")
    public ResponseEntity<List<DemandeAchatDTO>> getAppelOffreByCodeEtatApprouve(@PathVariable Integer codeEtatApprouver) {
        List<DemandeAchatDTO> dto = demandeAchatService.findOneByEtatApprouver(codeEtatApprouver);
        return ResponseEntity.ok().body(dto);

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
    public ResponseEntity<byte[]> getReport(@PathVariable Integer code) throws Exception {

        String fileNameJrxml = "src/main/resources/Reports/DetailsDemandeAchat.jrxml";

        Collection<DetailsDemandeAchatDTO> dto = demandeAchatService.findOneWithDetilas(code);
        paramDTO dTOs = paramService.findParamByCodeParamS("NomSociete");
        DemandeAchatDTO rslt = demandeAchatService.findOne(code);
        System.out.println("getCodeUserDemander)" + rslt.getCodeUserDemander());
        AccessUserDTO getsignature = accessUserService.findOne(rslt.getCodeUserDemander());
//        Preconditions.checkArgument(getsignature.getSignature() != null, "Signature Not Found");

        com.MangmentRessources.MangRess.web.Util.Preconditions.checkBusinessLogique(getsignature.getSignature() != null, "Signature Not Found ");
//        Resource ressource = new ByteArrayResource(getsignature.getSignature());

//        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(ressource);
        SocieteDTO clinique = societeService.findOne(1);
        JasperDesign jasperDesign = JRXmlLoader.load(fileNameJrxml);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map<String, Object> params = new HashMap<>();
        params.put("ItemDataSource", new JRBeanCollectionDataSource(dto));
        params.put("UserCreate", "SoufienCreateCore");
        params.put("codeSaisie", rslt.getCodeSaisie());
        params.put("Observation", rslt.getObservation());
        params.put("societe", dTOs.getValeur());
        params.put("dateLivraison", rslt.getDateLivraison());
        params.put("EtatValidation", rslt.getEtatApprouverDTO().getDesignation());
        params.put("Departement", rslt.getDepartementDTO().getDesignationAr());
        params.put("Demandeur", rslt.getUserDemander());
        params.put("signature", getsignature.getSignature());

        params.put("logo", clinique.getLogo());
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
