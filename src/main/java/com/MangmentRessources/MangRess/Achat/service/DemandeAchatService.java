/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MangmentRessources.MangRess.Achat.service;

import com.MangmentRessources.MangRess.Achat.domaine.DemandeAchat;
import com.MangmentRessources.MangRess.Achat.domaine.DetailsDemandeAchat;
import com.MangmentRessources.MangRess.Achat.dto.DemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.dto.DetailsDemandeAchatDTO;
import com.MangmentRessources.MangRess.Achat.factory.DemandeAchatFactory;
import com.MangmentRessources.MangRess.Achat.factory.DetailsDemandeAchatFactory;
import com.MangmentRessources.MangRess.Achat.repository.DemandeAchatRepo;
import com.MangmentRessources.MangRess.Achat.repository.DetailsDemandeAchatRepo;
import com.MangmentRessources.MangRess.ParametrageCentral.domaine.Compteur;
import com.MangmentRessources.MangRess.ParametrageCentral.service.CompteurService;
import com.google.common.base.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.text.html.HTML;
import static net.sf.jasperreports.data.excel.ExcelFormatEnum.XLSX;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXmlExporterOutput;
import org.jfree.data.io.CSV;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import static org.thymeleaf.standard.inline.StandardInlineMode.XML;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class DemandeAchatService {

    private final DemandeAchatRepo demandeAchatRepo;

    private final DetailsDemandeAchatRepo detailsDemandeAchatRepo;
    private final CompteurService compteurService;

    public DemandeAchatService(DemandeAchatRepo demandeAchatRepo, DetailsDemandeAchatRepo detailsDemandeAchatRepo, CompteurService compteurService) {
        this.demandeAchatRepo = demandeAchatRepo;
        this.detailsDemandeAchatRepo = detailsDemandeAchatRepo;
        this.compteurService = compteurService;
    }

    @Transactional(readOnly = true)
    public List<DemandeAchatDTO> findAllDemandeAchat() {
        return DemandeAchatFactory.listDemandeAchatToDemandeAchatDTOs(demandeAchatRepo.findAll());

    }

    @Transactional(readOnly = true)
    public DemandeAchatDTO findOne(Integer code) {
        DemandeAchat domaine = demandeAchatRepo.getReferenceById(code);
        Preconditions.checkArgument(domaine.getCode() != null, "error.DemandeAchatNotFound");
        return DemandeAchatFactory.demandeAchatToDemandeAchatDTO(domaine);
    }

    @Transactional(readOnly = true)
    public List<DemandeAchatDTO> findOneByEtatApprouver(Integer CodeEtatApprouver) {
        return DemandeAchatFactory.listDemandeAchatToDemandeAchatDTOs(demandeAchatRepo.findDemandeAchatByCodeEtatApprouver(CodeEtatApprouver));
    }

    public DemandeAchat update(DemandeAchatDTO dTO) {
        DemandeAchat domaine = demandeAchatRepo.getReferenceById(dTO.getCode());
        Preconditions.checkArgument(true, "error.DemandeAchatNotFound");
        dTO.setCode(domaine.getCode());
        DemandeAchatFactory.demandeAchatDTOToDemandeAchatWithDetails(domaine, dTO);
        return demandeAchatRepo.save(domaine);
    }

//    public DemandeAchatDTO updateNewWithFlush(DemandeAchatDTO dTO) {
//        DemandeAchat inBase = demandeAchatRepo.getReferenceById(dTO.getCode());
//        Preconditions.checkArgument(inBase != null, "error.ModelePanierInexistant");
//
////        if ((inBase.getActif() != modelepanierDTO.getActif()) && (modelepanierDTO.getActif() == false)) {
////            boolean testopr = operationService.existsBycodeModeleCodeAndActif(modelepanierDTO.getCode());
////            Preconditions.checkArgument(testopr == false, "error.controleActif");
////
////            boolean testprest = prestationService.existsBycodeModeleCodeAndActif(modelepanierDTO.getCode());
////            Preconditions.checkArgument(testprest == false, "error.controleActif");
////        }
//        inBase.getDetailsDemandeAchats().clear();
//        demandeAchatRepo.flush();
//        inBase = DemandeAchatFactory.demandeAchatDTOToDemandeAchatWithDetails(inBase, dTO);
//        inBase = demandeAchatRepo.save(inBase);
//        DemandeAchatDTO resultDTO = DemandeAchatFactory.UpdatedemandeAchatWithDetailsTodemandeAchatDTOWithDetails(inBase);
//        return resultDTO;
//    }
    public DemandeAchatDTO updateNewWithFlush(DemandeAchatDTO modelepanierDTO) {
        DemandeAchat inBase = demandeAchatRepo.getReferenceById(modelepanierDTO.getCode());
        Preconditions.checkArgument(inBase != null, "error.ModelePanierInexistant");
        inBase.getDetailsDemandeAchats().clear();
        demandeAchatRepo.flush();
        inBase = DemandeAchatFactory.demandeAchatDTOToDemandeAchatWithDetails(inBase, modelepanierDTO);
        inBase = demandeAchatRepo.save(inBase);
        DemandeAchatDTO resultDTO = DemandeAchatFactory.UpdatedemandeAchatWithDetailsTodemandeAchatDTOWithDetails(inBase);
        return resultDTO;
    }

    public void deleteDemandeAchat(Integer code) {
        Preconditions.checkArgument(demandeAchatRepo.existsById(code), "error.DemandeAchatNotFound");
        demandeAchatRepo.deleteById(code);
    }

    public DemandeAchatDTO saveDdeAchat(DemandeAchatDTO Dto) {

        DemandeAchat domaine = DemandeAchatFactory.demandeAchatDTOToDemandeAchatWithDetails(new DemandeAchat(), Dto);

        domaine.setCode(null);
        domaine.setUserCreate(domaine.getUserCreate());
        domaine.setDateCreate(new Date());
//        domaine.setCodeSaisie(Dto.getCodeSaisie()); 

        Compteur CompteurCodeSaisie = compteurService.findOne("codeSaisieDA");
        String codeSaisieDA = CompteurCodeSaisie.getPrefixe() + CompteurCodeSaisie.getSuffixe();
        domaine.setCodeSaisie(codeSaisieDA);
        compteurService.incrementeSuffixe(CompteurCodeSaisie);
        domaine = demandeAchatRepo.save(domaine);
        DemandeAchatDTO resultDTO = DemandeAchatFactory.UpdatedemandeAchatWithDetailsTodemandeAchatDTOWithDetails(domaine);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public Collection<DetailsDemandeAchatDTO> findOneWithDetilas(Integer code) {

        Collection<DetailsDemandeAchat> collection = detailsDemandeAchatRepo.findByDetailsDemandeAchatPK_codeDemandeAchat(code);
        return DetailsDemandeAchatFactory.UpdatedetailsDemandeAchatTodetailsDemandeAchatDTOCollection(collection);
    }
//
//    public byte[] employeeJasperReportInBytes(String fileType) throws Exception {
//        String template = "reports/emp24.jrxml";
//        List<DetailsDemandeAchat> employees = detailsDemandeAchatRepo.findAll();
//        List<DetailsDemandeAchatDTO> dataSource = DetailsDemandeAchatFactory.UpdatedetailsDemandeAchatTodetailsDemandeAchatDTOList(employees);
////1. Create Required Parameters
//        Map<String, Object> parameters = new HashMap<>();
//        FileInputStream leafBannerStream = new FileInputStream(ResourceUtils.getFile("classpath:reports/logo.jpg").getAbsolutePath());
//        parameters.put("comanyName", "BLACK STAR TECHNOLOGIES");
//        parameters.put("address", "Address: Raheja Mind Space Entrance Gate, HITEC City, Hyderabad -500081");
//        parameters.put("header", "Employees Salary Report");
//        parameters.put("logo", leafBannerStream);
//        parameters.put("createdBy", "Satya Kaveti");
//        //2.Create DataSource
//        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(dataSource);
//        //3.Compile .jrmxl template, stored in JasperReport object
//        String path = ResourceUtils.getFile("classpath:" + template).getAbsolutePath();
//        JasperReport jasperReport = JasperCompileManager.compileReport(path);
//        //4.Fill Report - by passing complied .jrxml object, paramters, datasource
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanCollectionDataSource);
//        //5.Export Report - by using JasperExportManager
//        ReportTypeEnum reportType = ReportTypeEnum.getReportTypeByCode(fileType);
//        return jasperReportsUtil.exportJasperReportBytes(jasperPrint, reportType);
//    }
//
////jasperReportsUtil
//
//    /**
//     *
//     * @param jasperPrint
//     * @param reportType
//     * @return
//     * @throws JRException
//     */
//    public byte[] exportJasperReportBytes(JasperPrint jasperPrint, ReportTypeEnum reportType) throws JRException {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        switch (reportType) {
//            case CSV:
//                // Export to CSV
//                JRCsvExporter csvExporter = new JRCsvExporter();
//                csvExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//                csvExporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
//                csvExporter.exportReport();
//                break;
//            case XLSX:
//                // Export to XLSX
//                JRXlsxExporter xlsxExporter = new JRXlsxExporter();
//                xlsxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//                xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
//                xlsxExporter.exportReport();
//                break;
//            case HTML:
//                // Export to HTML
//                HtmlExporter htmlExporter = new HtmlExporter();
//                htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//                htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(outputStream));
//                htmlExporter.exportReport();
//                break;
//            case XML:
//                // Export to XML
//                JRXmlExporter xmlExporter = new JRXmlExporter();
//                xmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//                xmlExporter.setExporterOutput(new SimpleXmlExporterOutput(outputStream));
//                xmlExporter.exportReport();
//                break;
//            case DOC:
//                // Export to DOCX (RTF format)
//                JRRtfExporter docxExporter = new JRRtfExporter();
//                docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//                docxExporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
//                docxExporter.exportReport();
//                break;
//            default:
//                // Export to PDF by default
//                JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
//                break;
//        }
//        return outputStream.toByteArray();
//    }

}
