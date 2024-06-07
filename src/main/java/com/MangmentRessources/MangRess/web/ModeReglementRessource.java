/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.web;

import com.MangmentRessources.MangRess.domaine.ModeReglement;
import com.MangmentRessources.MangRess.dto.ModeReglementDTO;
import com.MangmentRessources.MangRess.repository.ModeReglementRepo;
import com.MangmentRessources.MangRess.service.ModeReglementService;
import com.MangmentRessources.MangRess.web.Util.Helper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.rowset.serial.SerialBlob;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api/parametrage/")
public class ModeReglementRessource {

    private final ModeReglementService modeReglementServiceService;
    private final ModeReglementRepo modeReglementRepo;

    public ModeReglementRessource(ModeReglementService modeReglementServiceService, ModeReglementRepo modeReglementRepo) {
        this.modeReglementServiceService = modeReglementServiceService;
        this.modeReglementRepo = modeReglementRepo;
    }

    @GetMapping("mode_reglement/{code}")
    public ResponseEntity<ModeReglementDTO> getModeReglementByCode(@PathVariable Integer code) {
        ModeReglementDTO dTO = modeReglementServiceService.findOne(code);
        return ResponseEntity.ok().body(dTO);
    }

    @GetMapping("mode_reglement/all")
    public ResponseEntity<List<ModeReglementDTO>> getAllModeReglement() {
        return ResponseEntity.ok().body(modeReglementServiceService.findAllModeReglement());
    }

    @PostMapping("mode_reglement")
    public ResponseEntity<ModeReglementDTO> postModeReglement(@Valid @RequestBody ModeReglementDTO ddeTransfertDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        ModeReglementDTO result = modeReglementServiceService.save(ddeTransfertDTO);
        return ResponseEntity.created(new URI("/api/parametrage-achat/" + result.getCode())).body(result);
    }

    @PutMapping("mode_reglement/update")
    public ResponseEntity<ModeReglement> updateModeReglement(@RequestBody @Valid ModeReglementDTO dTO) throws URISyntaxException {
        ModeReglement result = modeReglementServiceService.update(dTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("mode_reglement/delete/{code}")
    public ResponseEntity<ModeReglement> deleteModeReglement(@PathVariable("code") Integer code) {
        modeReglementServiceService.deleteModeReglement(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("mode_reglement/edition")
    public ResponseEntity<ModeReglement> GetRapport() {

        String fileNameJrxml = "c:/ModeReglement.jrxml";
        String fileNamePdf = "c:/HelloPDFv2s.pdf";

        Collection<ModeReglement> products = modeReglementRepo.findAll(); // Example using a repository

        try {
            System.out.println("Loading the .JRMXML file ....");
            JasperDesign jasperDesign = JRXmlLoader.load(fileNameJrxml);
            System.out.println("Compiling the .JRMXML file to .JASPER file....");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Map<String, Object> params = new HashMap<>();
            params.put("ItemDataSource", new JRBeanCollectionDataSource(products));
            System.out.println("filling parameters to .JASPER file....");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

            System.out.println("exporting the JASPER file to PDF file....");
            JasperExportManager.exportReportToPdfFile(jasperPrint, fileNamePdf);
            System.out.println("Successfully completed the export");

        } catch (Exception e) {
            System.out.print("Exception:" + e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
//
//    @GetMapping("mode_reglement/editionss")
//    public void getDocument(HttpServletResponse response) throws IOException, JRException {
//        String fileNameJrxml = "c:/ModeReglement.jrxml";
////        String sourceFileName = ResourceUtils.getFile(fileNameJrxml).getAbsolutePath();
//
//        JasperDesign jasperDesign = JRXmlLoader.load(fileNameJrxml);
//        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//        ModeReglement sampleBean = new ModeReglement();
//
//        Collection<ModeReglement> products = modeReglementRepo.findAll();
//        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(products);
//        Map parameters = new HashMap();
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
//        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
//        response.setContentType("application/pdf");
//
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_PDF);
////        return ResponseEntity.ok().headers(headers).body(Helper.read(byteArrayInputStream));
//        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
//        System.out.println("Successfully completed the export");
//    }

    @GetMapping("mode_reglement/exp")
    public ResponseEntity<byte[]> getReport() throws Exception {

        String fileNameJrxml = "src/main/resources/Reports/ModeReglement.jrxml";
        Collection<ModeReglement> products = modeReglementRepo.findAll();
        JasperDesign jasperDesign = JRXmlLoader.load(fileNameJrxml);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map<String, Object> params = new HashMap<>();
        params.put("ItemDataSource", new JRBeanCollectionDataSource(products));
        params.put("UserCreate", "SoufienCreateCore");

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
